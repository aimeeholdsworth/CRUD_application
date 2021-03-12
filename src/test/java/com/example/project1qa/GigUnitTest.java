package com.example.project1qa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.project1qa.domain.Gig;
import com.example.project1qa.services.GigService;
import com.example.project1qa.repo.GigRepo;

@SpringBootTest
public class GigUnitTest {
	
	@Autowired
	private GigService service;
	
	@MockBean
	private GigRepo repo;
	
	@Test
	void testCreate() {
		Gig newGig = new Gig("1975", "Bristol", "Fleece", "2021-08-12", 7);
		Gig savedGig = new Gig(1L, "1975", "Bristol", "Fleece", "2020-08-12", 7);
		
		Mockito.when(this.repo.save(newGig)).thenReturn(savedGig);
		
		assertThat(this.service.addGig(newGig)).isEqualTo(savedGig);
		Mockito.verify(this.repo, Mockito.times(1)).save(newGig); //tests how many times the method gets run
		
	}
	
	
	@Test
	void testUpdate() {
		
		//given id
		Long id = 1L;
		
		//new gig data
		Gig newGig = new Gig("1975", "Bristol", "The Fleece", "2021-08-12", 7);
		
		//optional gig 
		Optional<Gig> optionalGig = Optional.of(new Gig(id, null, null, null, null, 0));
		
		//updated gig
		Gig updatedGig = new Gig(id, newGig.getArtist(), newGig.getCity(), newGig.getVenue(),
				newGig.getGigDate(), newGig.getGigTime());
		
		//when
		Mockito.when(this.repo.findById(id)).thenReturn(optionalGig);		
		Mockito.when(this.repo.save(updatedGig)).thenReturn(updatedGig);
		
		//then
		assertThat(this.service.updateGig(id, newGig)).isEqualTo(updatedGig);
	}
	
	
	
  
@Test
void testReadAll() {
	Long id = 1L;
	List <Gig> gigs = new ArrayList<>();
	// given
	Gig testGig = new Gig(1L, "1975", "Bristol", "Fleece", "2021-08-12", 7);
	testGig.setId(id);
	gigs.add(testGig);
	
	
	
	//when
	
	Mockito.when(this.repo.findAll()).thenReturn(gigs);
	//then
	Assertions.assertThat(this.service.getAllGigs()).isEqualTo(gigs);
	
	//verify
	Mockito.verify(this.repo, Mockito.times(1)).findAll();
	
}
	
	
@Test 
void testReadByName() {
	Long id = 1L;
	String artist = "1975";
//	String location ="Bristol";
//	String venue ="Fleece";
//	LocalDate gigDate = LocalDate.of(2021, 02, 21);
//	int gigTime = 7;
	Gig expected = new Gig(id,"1975", "Bristol", "Fleece", "2021-02-12", 7);
	
	Mockito.when(this.repo.findByArtist(artist)).thenReturn(expected);
	
	Assertions.assertThat(this.service.getGigByArtist(artist)).isEqualTo(expected);
	
	Mockito.verify(this.repo, Mockito.times(1)).findByArtist(artist);
}
	
	
	
	@Test
	void testDelete() {
		//the given
		Long id = 1L;
		
		//when
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		
		//then
		
		Assertions.assertThat(this.service.removeGig(id)).isTrue();
		
		//verify
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);


}
}
