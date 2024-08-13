package com.oracle.project.layer5;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.project.layer2.NewsPaper;

@RestController

public interface NewsPaperController 
{
	ResponseEntity<List<NewsPaper>> getAll();
	ResponseEntity<NewsPaper> getById(int id);
}
