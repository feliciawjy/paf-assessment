package ibf2024.assessment.paf.batch4.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Style;
import ibf2024.assessment.paf.batch4.services.BeerService;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("/beer/style/{id}")
	public String showBeersForStyle(@PathVariable("id") int styleId,
			@RequestParam("styleName") String styleName,
			Model model) {

		// TODO: if no data, return "BeersNotFound"
		model.addAttribute("styleName", styleName);
		List<Beer> beers = beerService.getBreweriesByBeer(styleId);
		if (beers.isEmpty()) {
			return "BeersNotFound";
		} else {
			model.addAttribute("beers", beers);
			return "view1";
		}
	}

	// also take query params

	// TODO Task 4 - view 2

	// TODO Task 5 - view 2, place order

}
