package koboldblogprovider.koboldblogprovider.mapper;

import koboldblogprovider.koboldblogprovider.dao.Classify;

import java.util.List;

public interface ClassifyMapper {
	void insertClassify(Classify classify);
	void updateClassify(String classifyName,String id,String userId);
	List<Classify>  getUsedClassify(String userId);
	List<Classify> getAllClassify(String userId);
	Classify getClassifyById(String id,String UserId);
	void deleteClassifyById(String userId,String id);
	void stopClassifyById(boolean isstopped,String id,String userId);
	List<Classify> getClassifyReleation(String id,String userId);

}
