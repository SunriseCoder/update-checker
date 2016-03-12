package app.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import app.entity.VkGroup;

public interface VkGroupsRepository extends Repository<VkGroup, Long> {
	List<VkGroup> findAll();
	VkGroup save(VkGroup entity);
}
