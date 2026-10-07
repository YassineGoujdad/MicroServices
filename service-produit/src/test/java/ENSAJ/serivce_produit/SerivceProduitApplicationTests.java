package ENSAJ.serivce_produit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mongodb.MongoDBContainer;

@SpringBootTest
@Testcontainers
class SerivceProduitApplicationTests {

	@Test
	void contextLoads() {
	}

	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.11");

}
