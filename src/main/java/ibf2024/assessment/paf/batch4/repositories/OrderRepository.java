package ibf2024.assessment.paf.batch4.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import ibf2024.assessment.paf.batch4.models.BeerOrder;
import ibf2024.assessment.paf.batch4.models.Order;

@Repository
public class OrderRepository {

	@Autowired
	private MongoTemplate template;

	// TODO: Task 5
	// db.orders.insert({
	// orderId: "UUID5678",
	// date: ,
	// breweryId: 2,
	// orders: [{},{}]
	// })
	public Order createOrder(Order order) {
		return template.insert(order);
	}

	// insert beer orders into order id
	public void insertOrder(String jsonString) {

		// read as json from string, put to beer order
		BeerOrder bo = new BeerOrder();

		// build query
		Query query = new Query();
	}

}
