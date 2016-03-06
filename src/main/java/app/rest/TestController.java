package app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.TestEntity;
import app.service.TestService;

@RestController
@RequestMapping("/rest/test/")
public class TestController {
	@Autowired
	TestService testService;

	@RequestMapping("/controller")
	public TestEntity controller() {
		TestEntity result = new TestEntity((long) 15, "Entity");
		return result;
	}
	
	@RequestMapping("/database")
	public TestEntity database() {
		TestEntity entity = new TestEntity("Value");
		TestEntity result = testService.save(entity);
		return result;
	}
}
