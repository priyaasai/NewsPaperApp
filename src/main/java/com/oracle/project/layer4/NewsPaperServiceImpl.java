package com.oracle.project.layer4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.project.layer2.NewsPaper;
import com.oracle.project.layer3.NewsPaperRepository;

/*
 * 		--List<NewsPaper> findAllNewsPapers();
		--List<NewsPaper> findNewsPaperByName(String name);
		--List<NewsPaper> findNewsPaperByCost(int cost);
		--NewsPaper findNewsPaperById(int id);
		--String findNewsPaperNameById(int id);
		--int findNewsPaperNumberOfPages(int id);
 */
@Service
public class NewsPaperServiceImpl implements NewsPaperService
{
	@Autowired
	NewsPaperRepository newsPaperRepository;
	
	
	@Override
	public List<NewsPaper> findAllNewsPapers() {

		Iterable<NewsPaper> allPapers=newsPaperRepository.findAll();
		if(allPapers!=null)
			return (List<NewsPaper>) allPapers;
		else
			throw new RuntimeException("News Papers not found");
		
	}
	
	@Override
	public List<NewsPaper> findNewsPaperByName(String name) 
	{
		boolean found=false;
		List<NewsPaper>  newsPaperList=new ArrayList<NewsPaper>();
		Iterable<NewsPaper> allNewsPapers=newsPaperRepository.findAll();
		for (NewsPaper newsPaper : allNewsPapers) 
		{
			if(newsPaper.getNewsPaperName().equalsIgnoreCase(name)) {
				newsPaperList.add(newsPaper);
				found=true;
			}
		}
		if(found)
			return newsPaperList;
		else
			throw new RuntimeException("News Paper not found");
		
	}

	@Override
	public List<NewsPaper> findNewsPaperByCost(int cost) 
	{
		boolean found=false;
		List<NewsPaper> sameCostList=new ArrayList<NewsPaper>();
		Iterable<NewsPaper> allPapers=newsPaperRepository.findAll();
		for (NewsPaper newsPaper : allPapers) 
		{
			if(newsPaper.getNewsPaperCost()>=cost) {
				sameCostList.add(newsPaper);
				found=true;
			}
		}
		if(found)
			return sameCostList;
		else
			throw new RuntimeException("No News Papers found for the mentioned cost");
		
	}

	@Override
	public NewsPaper findNewsPaperById(int id)
	{
		NewsPaper thisPaper;
		Optional<NewsPaper> paper=null;
		paper=newsPaperRepository.findById(id);
		if(paper.isPresent())
		{
			thisPaper=paper.get();
			return thisPaper;
		}

		else
			throw new RuntimeException("No News Paper found with the mentioned ID (ID): "+id);
		
	}

	@Override
	public String findNewsPaperNameById(int id)
	{
		NewsPaper thisPaper;
		Optional<NewsPaper> paper=null;
		paper=newsPaperRepository.findById(id);
		if(paper.isPresent())
		{
			thisPaper=paper.get();
			return thisPaper.getNewsPaperName();
		}

		else
			throw new RuntimeException("No News Paper found with the mentioned ID (Name): "+id);
		
	}

	@Override
	public int findNewsPaperNumberOfPages(int id)
	{
		NewsPaper thisPaper;
		Optional<NewsPaper> paper=null;
		paper=newsPaperRepository.findById(id);
		if(paper.isPresent())
		{
			thisPaper=paper.get();
			return thisPaper.getNumberOfPages();
		}
		else
			throw new RuntimeException("No News Paper found with the mentioned ID (Number of Pages): "+id);
		
	}
}
