package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.PeopleRepository;
import app.entity.PeopleEntity;

@Service
public class PeopleService {
	@Autowired
	PeopleRepository repository;

	public List<PeopleEntity> getList() {
		List<PeopleEntity> result = repository.findAll();
		return result;
	}

	public PeopleEntity save(PeopleEntity entity) {
		PeopleEntity result = repository.save(entity);
		return result;
	}
}
