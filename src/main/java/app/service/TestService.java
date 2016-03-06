package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.TestRepository;
import app.entity.TestEntity;

@Service
public class TestService {
	@Autowired
	TestRepository testRepository;

	public TestEntity save(TestEntity entity) {
		TestEntity result = testRepository.save(entity);
		return result;
	}
}
