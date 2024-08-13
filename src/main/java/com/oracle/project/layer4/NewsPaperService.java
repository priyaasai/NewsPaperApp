package com.oracle.project.layer4;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.oracle.project.layer2.NewsPaper;

/*
 
 	@Component		@Component		@Component	
  	@Repository		@Service		@Controller
  	CRUD			BUSINESS		INTERACTION	
  					LOGIC			WITH UI AND
  									SERVICE
 */

@Service
public interface NewsPaperService 
{
		List<NewsPaper> findAllNewsPapers();
		List<NewsPaper> findNewsPaperByName(String name);
		List<NewsPaper> findNewsPaperByCost(int cost);
		NewsPaper findNewsPaperById(int id);
		String findNewsPaperNameById(int id);
		int findNewsPaperNumberOfPages(int id);
		
}
