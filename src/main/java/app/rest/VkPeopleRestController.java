package app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.VkPeople;
import app.service.VkPeopleService;

@RestController
@RequestMapping("/rest/vk-people/")
public class VkPeopleRestController {
	@Autowired
	VkPeopleService service;

	@RequestMapping("/list")
	public List<VkPeople> list() throws Exception {
		List<VkPeople> data = service.getList();
		return data;
	}
}
