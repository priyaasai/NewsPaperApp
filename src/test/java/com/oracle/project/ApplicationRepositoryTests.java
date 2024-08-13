package com.oracle.project;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oracle.project.layer2.NewsPaper;
import com.oracle.project.layer3.NewsPaperRepository;

@SpringBootTest
class ApplicationRepositoryTests {

	@Autowired
	NewsPaperRepository newsPaperRepository;
	
	@Autowired
	NewsPaper newsPaper;

	@Test
	public void insertTest() {
		newsPaper.setNewsPaperId(103);
		newsPaper.setNewsPaperName("Sunday Times");
		newsPaper.setNewsPaperCost(15);
		newsPaper.setNumberOfPages(16);
		System.out.println("News Paper Object filled up...");
		newsPaperRepository.save(newsPaper);
		System.out.println("Object stored...");
	}
	
	@Test
	public void selectAllTest() {
		
		Iterable<NewsPaper> list=newsPaperRepository.findAll();
		list.forEach(System.out::print);
		System.out.println("Object stored...");
	}
	
	/*@Test
	public void updateTest() {
	
		newsPaper.setTicketId(123);
		indRailTkt.setPassengerName("Priya");
		indRailTkt.setSourceCity("Bangalore");
		indRailTkt.setDestinationCity("London");
		indRailTkt.setAge(22);
		indRailTkt.setTicketCost(80000);
		System.out.println("object filled up...");
		ticketRepository.save(indRailTkt);	//save performs both insert and update (if object already exists)
		System.out.println("Object updated...");
	}*/
	
	@Test
	public void selectAndUpdateTest() {
		
		NewsPaper actualPaper=null;
		Optional<NewsPaper> paper=null;
		paper=newsPaperRepository.findById(102);
		if(paper.isPresent())
		{
			actualPaper=paper.get();
			//actualTkt.setTicketId(123);
			//actualTkt.setPassengerName("Priya");
			//actualTkt.setSourceCity("Bangalore");
			//actualTkt.setDestinationCity("Germany");
			//actualTkt.setAge(22);
			actualPaper.setNewsPaperCost(25);
			System.out.println("object filled up...");
			newsPaperRepository.save(actualPaper);	//save performs both insert and update (if object already exists)
			System.out.println("Object retrieved and updated...");
		}
		else
		{
			throw new RuntimeException("News Paper not found");
		}
	
	}
	
	@Test
	public void deleteTest() {
	
		newsPaper.setNewsPaperId(101);
		newsPaperRepository.delete(newsPaper);	//save performs both insert and update (if object already exists)
		System.out.println("Object deleted...");
	}

}
