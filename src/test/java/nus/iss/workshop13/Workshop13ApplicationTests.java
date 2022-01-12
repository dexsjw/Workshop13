package nus.iss.workshop13;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import nus.iss.workshop13.model.Contact;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Workshop13ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testContact() throws Exception {
		Contact c = new Contact();
		c.setName("Kenneth");
		c.setEmail("a@a.com");
		c.setPhoneNum("1234567");
		// assert equals to the setter value
        	assertEquals(c.getEmail(), "a@a.com");
	}

}
