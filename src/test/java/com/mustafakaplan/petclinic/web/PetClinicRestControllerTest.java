package com.mustafakaplan.petclinic.web;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mustafakaplan.petclinic.model.Owner;

public class PetClinicRestControllerTest {

	private RestTemplate restTemplate;
	
	@Before
	public void setUp() {
		
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testGetOwnerById() {
		
		ResponseEntity<Owner> response = restTemplate.getForEntity("http://localhost:8081/rest/owner/5", Owner.class);
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("Ad5"));
	}
}
