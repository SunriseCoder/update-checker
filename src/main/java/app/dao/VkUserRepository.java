package app.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import app.entity.VkUser;

public interface VkUserRepository extends Repository<VkUser, Long> {
	List<VkUser> findAll();
	VkUser save(VkUser entity);
}
