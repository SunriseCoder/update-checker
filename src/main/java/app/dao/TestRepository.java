package app.dao;

import app.entity.TestEntity;
import org.springframework.data.repository.Repository;

public interface TestRepository extends Repository<TestEntity, Long> {
	TestEntity save(TestEntity entity);
}
