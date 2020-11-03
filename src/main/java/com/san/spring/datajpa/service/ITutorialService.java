package com.san.spring.datajpa.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.san.spring.datajpa.model.Tutorial;

public interface ITutorialService {

	public List<Tutorial> getAllTutorials(String title) ;
	  public Tutorial getTutorialById( long id) ;

	  public Tutorial createTutorial(@RequestBody Tutorial tutorial) ;
	  public Tutorial updateTutorial(long id,Tutorial tutorial) ;

	  public void deleteTutorial( long id) ;

	  public void deleteAllTutorials();

	  public List<Tutorial> findByPublished() ;
   	public List<Tutorial> getAllTutorials();
}
