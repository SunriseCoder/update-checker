package app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.VkGroup;
import app.service.VkGroupsService;

@RestController
@RequestMapping("/rest/vk-groups/")
public class VkGroupsRestController {
	@Autowired
	VkGroupsService service;

	@RequestMapping("/list")
	public List<VkGroup> list() throws Exception {
		List<VkGroup> data = service.getList();
		return data;
	}
}
