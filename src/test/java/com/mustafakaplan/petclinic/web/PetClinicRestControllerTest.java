package com.mustafakaplan.petclinic.web;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	public void testCreateOwner() {
		
		Owner owner = new Owner();
		owner.setFirstName("Mustafa");
		owner.setLastName("Kaplan");
		
		URI location = restTemplate.postForLocation("http://localhost:8081/rest/owner", owner);
		
		Owner owner2 = restTemplate.getForObject(location, Owner.class);
		MatcherAssert.assertThat(owner2.getFirstName(), Matchers.equalTo(owner.getFirstName()));
	}
	
	@Test
	public void testGetOwnerById() {
		
		ResponseEntity<Owner> response = restTemplate.getForEntity("http://localhost:8081/rest/owner/5", Owner.class);
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("Ad5"));
		MatcherAssert.assertThat(response.getBody().getLastName(), Matchers.equalTo("Ad5"));
	}
	
	@Test
	public void testGetOwnersByLastName() {
		
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8081/rest/owner?ln=Soyad5", List.class);
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		
		@SuppressWarnings("unchecked")
		List<Map<String, String>> body = response.getBody();
		List<String> firstNames = body.stream().map(item -> item.get("firstName")).collect(Collectors.toList());
		
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Ad5"));
	}
	
	@Test
	public void testGetOwners() {
		
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8081/rest/owners", List.class);
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		
		@SuppressWarnings("unchecked")
		List<Map<String, String>> body = response.getBody();
		List<String> firstNames = body.stream().map(item -> item.get("firstName")).collect(Collectors.toList());
		
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Ad1", "Ad2", "Ad3", "Ad4", "Ad5", "Ad6", "Ad7", "Ad8", "Ad9", "Ad10"));
	}
}
