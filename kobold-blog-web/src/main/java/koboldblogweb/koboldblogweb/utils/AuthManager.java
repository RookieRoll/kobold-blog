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
	private void initMethod(){
		RequestMappingHandlerMapping mapping=applicationContext.getBean(RequestMappingHandlerMapping.class);
		Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
		for(RequestMappingInfo info:map.keySet()){
			String path=info.getPatternsCondition().getPatterns().iterator().next();
			HandlerMethod method=map.get(info);
			AuthTypeAnnotation annotation=method.getMethodAnnotation(AuthTypeAnnotation.class);
			if(annotation!=null){
				authMap.put(path,annotation.value());
			}
		}
	}

	public String getAuthCode(String key) {
		return authMap.get(key);
	}
}
