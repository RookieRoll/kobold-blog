package service;

import dto.dtos.ClassifyDto;

import java.util.List;

public interface ClassifyService {
	void insertClassify(ClassifyDto classify);
	void updateClassify(String classifyName,String id,String userId);
	List<ClassifyDto> getUsedClassify(String userId,int pageIndex,int pageSize);
	List<ClassifyDto> getAllClassify(String userId,int pageIndex,int pageSize);
	ClassifyDto getClassifyById(String id,String userId);
	void deleteClassifyById(String userId,String id);
	void stopClassifyById(boolean isstopped,String id,String userId);
	List<ClassifyDto> getClassifyReleation(String id,String userId);
}
