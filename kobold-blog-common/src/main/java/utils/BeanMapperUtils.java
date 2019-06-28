package utils;

import org.springframework.cglib.beans.BeanCopier;

public class BeanMapperUtils {


	public static <S, T> T mapper(S s, Class clazz) {
		try {
			BeanCopier copier = BeanCopier.create(s.getClass(), clazz, false);
			Object obj = clazz.getDeclaredConstructor(null).newInstance();
			copier.copy(s, obj, null);
			return (T) obj;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static <S, T> T mapper(S s, Class clazz,Object...args) {
		try {
			BeanCopier copier = BeanCopier.create(s.getClass(), clazz, false);
			Object obj = clazz.getDeclaredConstructor(null).newInstance(args);
			copier.copy(s, obj, null);
			return (T) obj;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
