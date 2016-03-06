package app.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/database")
public class DatabasePageController {
	@RequestMapping("/")
	public String index() {
		return "database/index";
	}

	@RequestMapping("/table")
	public String table() {
		return "database/table";
	}
}
