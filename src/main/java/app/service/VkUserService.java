package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.VkUserRepository;
import app.entity.VkUser;

@Service
public class VkUserService {
	@Autowired
	VkUserRepository repository;

	public List<VkUser> getList() {
		List<VkUser> result = repository.findAll();
		return result;
	}

	public VkUser save(VkUser entity) {
		VkUser result = repository.save(entity);
		return result;
	}
}
