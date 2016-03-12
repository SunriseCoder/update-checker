package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.TestRepository;
import app.entity.TestEntity;

@Service
public class TestService {
	@Autowired
	TestRepository repository;

	public List<TestEntity> getList() {
		List<TestEntity> result = repository.findAll();
		return result;
	}

	public TestEntity save(TestEntity entity) {
		TestEntity result = repository.save(entity);
		return result;
	}
}
