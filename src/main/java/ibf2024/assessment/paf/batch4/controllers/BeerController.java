package ibf2024.assessment.paf.batch4.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Style;
import ibf2024.assessment.paf.batch4.services.BeerService;

@Controller
@RequestMapping
public class BeerController {

	@Autowired
	private BeerService beerService;

	// TODO Task 2 - view 0
	@GetMapping(path = { "/", "/index", "/beer/style" })
	public String showStyles(Model model) {
		List<Style> styles = beerService.getStyles();
		model.addAttribute("styles", styles);
		return "view0";
	}

	// TODO Task 3 - view 1

	// TODO Task 4 - view 2

	// TODO Task 5 - view 2, place order

}
