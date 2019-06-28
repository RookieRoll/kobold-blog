package koboldblogprovider.koboldblogprovider.service;

import dto.ClassifyDto;
import koboldblogprovider.koboldblogprovider.dao.Classify;
import koboldblogprovider.koboldblogprovider.mapper.ClassifyMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.ClassifyService;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service(interfaceClass = ClassifyService.class)
public class ClassifyServiceImpl implements ClassifyService {
	@Autowired
	private ClassifyMapper classifyMapper;

	@Override
	public void insertClassify(ClassifyDto classifyDto) {
		Classify classify = (Classify) Classify.convertToDao(classifyDto, Classify.class);
		classify.setId(UUID.randomUUID().toString());
		classify.setCreateTime(new Timestamp(System.currentTimeMillis()));

		classifyMapper.insertClassify(classify);
	}

	@Override
	public void updateClassify(String classifyName, String id, String userId) {
		classifyMapper.updateClassify(classifyName, id, userId);
	}

	@Override
	public List<ClassifyDto> getUsedClassify(String userId) {
		return classifyMapper.getUsedClassify(userId).stream().map(m -> (ClassifyDto) m.convertToDto(ClassifyDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ClassifyDto> getAllClassify(String userId) {
		return classifyMapper.getAllClassify(userId).stream().map(m -> (ClassifyDto) m.convertToDto(ClassifyDto.class)).collect(Collectors.toList());
	}

	@Override
	public ClassifyDto getClassifyById(String id, String userId) {
		return (ClassifyDto) classifyMapper.getClassifyById(id, userId).convertToDto(ClassifyDto.class);
	}

	@Override
	public void deleteClassifyById(String userId, String id) {
		classifyMapper.deleteClassifyById(userId, id);
	}

	@Override
	public void stopClassifyById(boolean isstopped, String id, String userId) {
		classifyMapper.stopClassifyById(isstopped, id, userId);
	}

	@Override
	public List<ClassifyDto> getClassifyReleation(String id, String userId) {
		return classifyMapper.getClassifyReleation(id, userId).stream().map(m->(ClassifyDto)m.convertToDto(ClassifyDto.class)).collect(Collectors.toList());
	}
}
