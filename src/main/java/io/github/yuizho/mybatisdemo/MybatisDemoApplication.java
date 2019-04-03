package io.github.yuizho.mybatisdemo;

import io.github.yuizho.mybatisdemo.mybatis.City;
import io.github.yuizho.mybatisdemo.mybatis.CityMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MybatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}

	private final CityMapper cityMapper;

	public MybatisDemoApplication(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}

	@Bean
	CommandLineRunner sampleCommandLineRunner() {
		return args -> {
			City city = new City();
			city.setName("San Francisco");
			city.setState("CA");
			city.setCountry("US");
			cityMapper.insert(city);
			System.out.println(this.cityMapper.findById(city.getId()));
		};
	}
}
