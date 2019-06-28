package koboldblogweb.koboldblogweb.utils;

import koboldblogweb.koboldblogweb.annotations.AuthTypeAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class AuthManager {

	/**
	 * path:authcode
	 */
	private Map<String, String> authMap = new HashMap<>();
	@Autowired
	private WebApplicationContext applicationContext;

	@PostConstruct
	private void init() {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		final String RESOURCE_PATTERN = "/**/*.class";
		// 扫描的包名
		final String BASE_PACKAGE = "koboldblogweb.koboldblogweb.controller";
		Map<String, Class<?>> classCache = new HashMap<>();
		try {
			String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(BASE_PACKAGE)
					+ RESOURCE_PATTERN;
			Resource[] resources = resourcePatternResolver.getResources(pattern);
			MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
			for (Resource resource : resources) {
				if (resource.isReadable()) {
					MetadataReader reader = readerFactory.getMetadataReader(resource);
					//扫描到的class
					String className = reader.getClassMetadata().getClassName();
					Class<?> clazz = Class.forName(className);
					AuthTypeAnnotation clazzAnnotation = clazz.getAnnotation(AuthTypeAnnotation.class);
					if (clazzAnnotation != null) {
						String value = clazzAnnotation.value();
						authMap.put(clazz.getSimpleName(), value);
					} else {
						//判断是否有指定注解
						Method[] methods = clazz.getDeclaredMethods();
						List<Method> allowMethod = Arrays.stream(methods).filter(m -> m.getAnnotation(AuthTypeAnnotation.class) != null).collect(Collectors.toList());
						for (Method method : allowMethod) {
							AuthTypeAnnotation annotation = method.getAnnotation(AuthTypeAnnotation.class);
							String value = annotation.value();
							String key = clazz.getSimpleName() + "/" + method.getName();
							authMap.put(key, value);
						}
					}

				}
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("读取class失败v :" + e);
		}
	}

	public String getAuthCode(String key) {
		RequestMappingHandlerMapping mapping=applicationContext.getBean(RequestMappingHandlerMapping.class);
		Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
		//map.keySet().stream().filter(m->m.getPatternsCondition().getPatterns())
		//TODO 根据访问的url获取class和method
		return authMap.get(key);
	}
}
