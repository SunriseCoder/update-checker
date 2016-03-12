package app.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import app.entity.VkPeople;

public interface VkPeopleRepository extends Repository<VkPeople, Long> {
	List<VkPeople> findAll();
	VkPeople save(VkPeople entity);
}
