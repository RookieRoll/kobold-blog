package koboldblogprovider.koboldblogprovider.mapper;

import koboldblogprovider.koboldblogprovider.dao.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

/**
 * @author RWX
 */
@Mapper
public interface UserMapper {
	List<User> getUsers();
	User findbyUsername(String username);
	void insertUser(User user);
}
