package koboldblogweb.koboldblogweb.service;

import dto.dtos.ClassifyDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import service.ClassifyService;

import java.util.List;
@Service
public class ClassifyServiceImpl implements ClassifyService {
	@Reference
	private ClassifyService classifyService;

	@Override
	public void insertClassify(ClassifyDto classify) {
		classifyService.insertClassify(classify);
	}

	@Override
	public void updateClassify(String classifyName, String id, String userId) {
		classifyService.updateClassify(classifyName, id, userId);
	}

	@Override
	@Cacheable("getUsedClassify")
	public List<ClassifyDto> getUsedClassify(String userId,int pageIndex,int pageSize) {
		return classifyService.getUsedClassify(userId,pageIndex,pageSize);
	}

	@Override
	@Cacheable("getAllClassify")
	public List<ClassifyDto> getAllClassify(String userId,int pageIndex,int pageSize) {
		return classifyService.getAllClassify(userId,pageIndex,pageSize);
	}

	@Override
	public ClassifyDto getClassifyById(String id, String userId) {
		return classifyService.getClassifyById(id, userId);
	}

	@Override
	public void deleteClassifyById(String userId, String id) {
		classifyService.deleteClassifyById(userId, id);
	}

	@Override
	public void stopClassifyById(boolean isstopped, String id, String userId) {
		classifyService.stopClassifyById(isstopped, id, userId);
	}

	@Override
	public List<ClassifyDto> getClassifyReleation(String id, String userId) {
		return classifyService.getClassifyReleation(id, userId);
	}
}
