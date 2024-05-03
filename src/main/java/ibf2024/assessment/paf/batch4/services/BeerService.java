package ibf2024.assessment.paf.batch4.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.models.Order;
import ibf2024.assessment.paf.batch4.models.Style;
import ibf2024.assessment.paf.batch4.repositories.BeerRepository;
import ibf2024.assessment.paf.batch4.repositories.OrderRepository;

@Service
public class BeerService {

	@Autowired
	private BeerRepository beerRepo;

	@Autowired
	private OrderRepository orderRepo;

	public List<Style> getStyles() {
		List<Style> styles = beerRepo.getStyles();
		return styles;
	}

	// TODO: to add logic for compiling brewery name
	public List<Beer> getBreweriesByBeer(int styleId) {
		List<Beer> beers = beerRepo.getBreweriesByBeer(styleId);
		return beers;
	}

	public Optional<Brewery> getBeersFromBrewery(int breweryId) {
		return beerRepo.getBeersFromBrewery(breweryId);
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public String placeOrder(Order order) {
		// TODO: Task 5

		// strigify and return json string
		return "";
	}

}
