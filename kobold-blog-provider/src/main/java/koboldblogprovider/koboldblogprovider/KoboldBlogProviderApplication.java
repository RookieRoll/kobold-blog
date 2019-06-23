package koboldblogprovider.koboldblogprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@MapperScan("koboldblogprovider.koboldblogprovider.mapper")
@EnableDiscoveryClient
@RefreshScope
public class KoboldBlogProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(KoboldBlogProviderApplication.class, args);
	}

}
