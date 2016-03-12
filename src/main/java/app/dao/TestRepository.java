package app.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import app.entity.TestEntity;

public interface TestRepository extends Repository<TestEntity, Long> {
	List<TestEntity> findAll();
	TestEntity save(TestEntity entity);
}
