package com.oracle.project.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.project.layer2.NewsPaper;
import com.oracle.project.layer4.NewsPaperService;


@RestController
@RequestMapping("/NewsPapers")

public class NewsPaperControllerImpl implements NewsPaperController
{
	@Autowired
	NewsPaperService newsPaperService;
	
	@GetMapping //http://localhost:8080/NewsPapers
	public ResponseEntity<List<NewsPaper>> getAll() 
	{
		List<NewsPaper> allPapers=newsPaperService.findAllNewsPapers();
		return new ResponseEntity<>(allPapers,HttpStatus.OK);
		
	}
	
	@GetMapping("/{pid}") //http://localhost:8080/IndianRailwayTickets/124
	
	public ResponseEntity<NewsPaper> getById(@PathVariable int pid) 
	{
		NewsPaper thisPaper=newsPaperService.findNewsPaperById(pid);
		return new ResponseEntity<>(thisPaper,HttpStatus.OK);
		
	}

}
