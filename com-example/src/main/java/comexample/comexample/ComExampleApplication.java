package comexample.comexample;


import comexample.comexample.controller.ConvertYmlToProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

//@SpringBootApplication
//@EnableDiscoveryClient
public class ComExampleApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(ComExampleApplication.class, args);
		ConvertYmlToProperties.convert();
	}

}
