package ibf2024.assessment.paf.batch4.repositories;

public class BeerQueries {

    // SELECT styles.id AS style_id, styles.style_name AS name , count(*) AS beer_count
    // FROM beers JOIN styles
    // ON beers.style_id = styles.id
    // GROUP BY styles.id
    // ORDER BY count(*) DESC, styles.style_name DESC;
    public static final String SQL_SELECT_STYLES_COUNT = """
        SELECT styles.id AS style_id, styles.style_name AS name , count(*) AS beer_count
        FROM beers JOIN styles
        ON beers.style_id = styles.id
        GROUP BY styles.id
        ORDER BY count(*) DESC, styles.style_name DESC;
                """;

    public static final String SQL_SELECT_BEERS_BY_STYLE_ID = """
        SELECT beers.id AS beer_id, beers.name AS beer_name, beers.descript AS beer_description, breweries.id AS brewery_id, breweries.name AS brewery_name
        FROM beers LEFT JOIN breweries
        ON beers.brewery_id = breweries.id
        WHERE style_id = ?
        ORDER BY beers.name ASC;
            """;
}
