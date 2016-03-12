package app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.PeopleEntity;
import app.service.PeopleService;

@RestController
@RequestMapping("/rest/people/")
public class PeopleRestController {
	@Autowired
	PeopleService service;

	@RequestMapping("/list")
	public List<PeopleEntity> list() throws Exception {
		List<PeopleEntity> data = service.getList();
		return data;
	}
}
