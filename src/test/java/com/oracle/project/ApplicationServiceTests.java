package com.oracle.project;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oracle.project.layer2.NewsPaper;
import com.oracle.project.layer4.NewsPaperService;

/*
 * 		List<NewsPaper> findAllNewsPapers();
		List<NewsPaper> findNewsPaperByName(String name);
		List<NewsPaper> findNewsPaperByCost(int cost);
		NewsPaper findNewsPaperById(int id);
		String findNewsPaperNameById(int id);
		--int findNewsPaperNumberOfPages(int id);
 */

@SpringBootTest
public class ApplicationServiceTests 
{
	@Autowired
	NewsPaperService newsPaperService; 
	
	@Test
	public void findAllNewsPapersTest()
	{
		List<NewsPaper> allPapers=newsPaperService.findAllNewsPapers();
		Assertions.assertTrue(allPapers!=null);
		System.out.println("List Found");
		Assertions.assertTrue(allPapers.size()>0);
		for (NewsPaper newsPaper : allPapers) 
		{
			System.out.println(newsPaper);
		}
	}
	
	@Test
	public void findNewsPaperByNameTest()
	{
		List<NewsPaper> newsPaperName=newsPaperService.findNewsPaperByName("Sunday Times");
		Assertions.assertTrue(newsPaperName!=null);
		System.out.println("Name retrieved");
		//Assertions.assertTrue(destinationCityList.size()>0);
		System.out.println(newsPaperName);
		//return newsPaperName;
	}
	
	@Test
	public void findNewsPaperByCostTest()
	{
		List<NewsPaper> paperByCostList=newsPaperService.findNewsPaperByCost(25);
		Assertions.assertTrue(paperByCostList!=null);
		System.out.println("List Found");
		Assertions.assertTrue(paperByCostList.size()>0);
		for (NewsPaper newsPaper : paperByCostList) 
		{
			System.out.println(newsPaper);
		}
	}
	
	
	@Test
	public void findNewsPaperByIdTest()
	{
		NewsPaper paper=newsPaperService.findNewsPaperById(102);
		Assertions.assertTrue(paper!=null);
		System.out.println("Paper Found");
		System.out.println(paper);
	}
	
	@Test
	public void findNewsPaperNameByIdTest()
	{
		String paperName=newsPaperService.findNewsPaperNameById(102);
		Assertions.assertTrue(paperName!=null);
		System.out.println("Paper Found");
		System.out.println(paperName);
	}
	
	@Test
	public void findNewsPaperNumberOfPagesTest()
	{
		int paperPages=newsPaperService.findNewsPaperNumberOfPages(102);
		Assertions.assertTrue(paperPages!=0);
		System.out.println("Paper Found");
		System.out.println(paperPages);
	}
	
}
