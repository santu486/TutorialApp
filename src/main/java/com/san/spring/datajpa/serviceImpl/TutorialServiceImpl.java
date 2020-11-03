package com.san.spring.datajpa.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.san.spring.datajpa.model.Tutorial;
import com.san.spring.datajpa.repository.TutorialRepository;
import com.san.spring.datajpa.service.ITutorialService;

@Service
public class TutorialServiceImpl implements ITutorialService {

	@Autowired
	TutorialRepository tutorialRepository;

	public List<Tutorial> getAllTutorials(String title) {
		List<Tutorial> tutorials = new ArrayList<Tutorial>();
		try {
			

			if (title == null)
				tutorialRepository.findAll().forEach(tutorials::add);
			else
				tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tutorials;
	}

	  public Tutorial getTutorialById( long id) {
	    Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

	    if (tutorialData.isPresent()) {
	      return tutorialData.get();
	    } else {
	      return null;
	    }
	  }

	  public Tutorial createTutorial(@RequestBody Tutorial tutorial) {
	    try {
	      Tutorial _tutorial = tutorialRepository
	          .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
	      return _tutorial;
	    } catch (Exception e) {
	      throw e ;
	    }
	  }

	  public Tutorial updateTutorial(long id,Tutorial tutorial) {
	    Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

	    if (tutorialData.isPresent()) {
	      Tutorial _tutorial = tutorialData.get();
	      _tutorial.setTitle(tutorial.getTitle());
	      _tutorial.setDescription(tutorial.getDescription());
	      _tutorial.setPublished(tutorial.isPublished());
	      tutorialRepository.save(_tutorial);
	     return _tutorial ;
	    } else {
	      return new Tutorial();
	    }
	  }

	  public void deleteTutorial( long id) {
	    try {
	      tutorialRepository.deleteById(id);
	     
	    } catch (Exception e) {
	     e.printStackTrace();
	    }
	  }

	  public void deleteAllTutorials() {
	    try {
	      tutorialRepository.deleteAll();
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	  }

	  public List<Tutorial> findByPublished() {
		   List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
		try {
	   

	     return tutorials ;
	    } catch (Exception e) {
	    	  return tutorials ;
	    }
	  }

	@Override
	public List<Tutorial> getAllTutorials() {
		// TODO Auto-generated method stub
		return null;
	}

}
