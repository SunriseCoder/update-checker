package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.VkGroupsRepository;
import app.entity.VkGroup;

@Service
public class VkGroupsService {
	@Autowired
	VkGroupsRepository repository;

	public List<VkGroup> getList() {
		List<VkGroup> result = repository.findAll();
		return result;
	}

	public VkGroup save(VkGroup entity) {
		VkGroup result = repository.save(entity);
		return result;
	}
}
