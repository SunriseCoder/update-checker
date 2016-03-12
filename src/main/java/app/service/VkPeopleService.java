package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.VkPeopleRepository;
import app.entity.VkPeople;

@Service
public class VkPeopleService {
	@Autowired
	VkPeopleRepository repository;

	public List<VkPeople> getList() {
		List<VkPeople> result = repository.findAll();
		return result;
	}

	public VkPeople save(VkPeople entity) {
		VkPeople result = repository.save(entity);
		return result;
	}
}
