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
}
