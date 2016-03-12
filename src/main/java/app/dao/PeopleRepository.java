package app.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import app.entity.PeopleEntity;

public interface PeopleRepository extends Repository<PeopleEntity, Long> {
	List<PeopleEntity> findAll();
	PeopleEntity save(PeopleEntity entity);
}
