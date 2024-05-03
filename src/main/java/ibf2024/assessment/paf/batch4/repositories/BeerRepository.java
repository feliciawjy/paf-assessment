package ibf2024.assessment.paf.batch4.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.models.Style;

@Repository
public class BeerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2
		List<Style> styles = new LinkedList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(BeerQueries.SQL_SELECT_STYLES_COUNT);
		while (rs.next()) {
			Style style = new Style();
			style.setStyleId(rs.getInt("style_id"));
			style.setName(rs.getString("name"));
			style.setBeerCount(rs.getInt("beer_count"));
			styles.add(style);
		}
		return styles;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(int styleId) {
		// TODO: Task 3
		List<Beer> beers = new LinkedList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(BeerQueries.SQL_SELECT_BEERS_BY_STYLE_ID, styleId);
		while (rs.next()) {
			Beer beer = new Beer();
			beer.setBeerId(rs.getInt("beer_id"));
			beer.setBeerName(rs.getString("beer_name"));
			beer.setBeerDescription(rs.getString("beer_description"));
			beer.setBreweryId(rs.getInt("brewery_id"));
			beer.setBreweryName(rs.getString("brewery_name"));
			beers.add(beer);
		}
		return beers;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(int breweryId) {
		// TODO: Task 4
		SqlRowSet rs = jdbcTemplate.queryForRowSet(BeerQueries.SQL_SELECT_BREWERY_DETAILS_BY_BREWERY_ID, breweryId);

		if (rs.first()) {
			Brewery brewery = new Brewery();
			List<Beer> beers = new LinkedList<>();
			brewery.setBreweryId(rs.getInt("brewery_id"));
			brewery.setName(rs.getString("brewery_name"));
			brewery.setAddress1(rs.getString("address_1"));
			brewery.setAddress2(rs.getString("address_2"));
			brewery.setCity(rs.getString("city"));
			brewery.setPhone(rs.getString("phone"));
			brewery.setWebsite(rs.getString("website"));
			brewery.setDescription(rs.getString("description"));
			while (rs.next()) {
				Beer beer = new Beer();
				beer.setBeerId(rs.getInt("beer_id"));
				beer.setBeerName(rs.getString("beer_name"));
				beer.setBeerDescription(rs.getString("beer_description"));
				beers.add(beer);
			}

			return Optional.of(brewery);

		}

		return Optional.empty();
	}
}
