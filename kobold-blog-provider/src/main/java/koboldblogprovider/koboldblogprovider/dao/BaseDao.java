package koboldblogprovider.koboldblogprovider.dao;

import dto.BaseDto;
import dto.BlogsDto;
import utils.BeanMapperUtils;

public class BaseDao {
	public BaseDto convertToDto(Class dtoClazz) {
		return BeanMapperUtils.mapper(this, dtoClazz);
	}

	public static BaseDao convertToDao(BaseDto dto,Class daoClazz) {
		return BeanMapperUtils.mapper(dto,daoClazz);
	}
}
