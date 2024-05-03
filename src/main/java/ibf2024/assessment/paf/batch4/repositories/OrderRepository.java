package ibf2024.assessment.paf.batch4.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import ibf2024.assessment.paf.batch4.models.Order;

@Repository
public class OrderRepository {

	@Autowired
	private MongoTemplate template;

	// TODO: Task 5
	// db.orders.insert({
	// 	orderId: "UUID5678",
	// 	date: ,
	// 	breweryId: 2,
	// 	orders: [{},{}]
	// })
	public Order creatOrder(Order order){
		return template.insert(order);
	}
	


}
