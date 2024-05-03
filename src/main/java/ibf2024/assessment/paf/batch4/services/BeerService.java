package ibf2024.assessment.paf.batch4.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Style;
import ibf2024.assessment.paf.batch4.repositories.BeerRepository;

@Service
public class BeerService {

	@Autowired
	private BeerRepository beerRepo;

	public List<Style> getStyles() {
		List<Style> styles = beerRepo.getStyles();
		return styles;
	}

	// TODO: to add logic for compiling brewery name
	public List<Beer> getBreweriesByBeer(int styleId) {
		List<Beer> beers = beerRepo.getBreweriesByBeer(styleId);
		return null;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public String placeOrder(/* You can add any number parameters here */) {
		// TODO: Task 5

		return "";
	}

}
