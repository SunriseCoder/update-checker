package app.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.entity.VkUser;
import app.service.VkUserService;

@RestController
@RequestMapping("/rest/vk-user/")
public class VkUserRestController {
	@Autowired
	VkUserService service;

	@RequestMapping("/list")
	public List<VkUser> list() throws Exception {
		List<VkUser> data = service.getList();
		return data;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Map<String, String> body) throws Exception {
		String url = body.get("url");

		if (url == null || url.isEmpty()) {
			return;
		}

		VkUser vkUser = new VkUser();
		vkUser.setUrl(url);
		vkUser.setParsed(false);

		service.save(vkUser);
	}
}
