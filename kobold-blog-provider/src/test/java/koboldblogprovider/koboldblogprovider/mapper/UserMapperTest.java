package koboldblogprovider.koboldblogprovider.mapper;

import koboldblogprovider.koboldblogprovider.KoboldBlogProviderApplication;
import koboldblogprovider.koboldblogprovider.dao.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = KoboldBlogProviderApplication.class)
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void textGetUser() {
		userMapper.getUsers().forEach(m -> System.out.println(m.getUsername()));
	}


	@Test
	public void textGetUserbyUserName() {
		System.out.println(userMapper.findbyUsername("1").getUsername());
	}

	@Test
	public void testInsertUser(){
		User user=new User();
		user.setPassword("123456");
		user.setUsername("kobold");
		user.setDescription("暂无");
		user.setId(UUID.randomUUID().toString());
		userMapper.insertUser(user);

	}
}