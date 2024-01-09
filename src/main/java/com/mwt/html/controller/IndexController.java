package com.mwt.html.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mwt.html.model.Question;
import com.mwt.html.repo.QuestionRepository;

@Controller
public class IndexController {
	@Autowired
	private QuestionRepository userRepository;

	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@PostMapping("/register")
	public String userRegistration(@ModelAttribute Question question, Model model) {
	System.out.println("im here");
		// validate 
		System.out.println(question.getName());
		System.out.println(question.getEmail());
		System.out.println(question.getAskquestion());
		model.addAttribute("Name", question.getName());
		model.addAttribute("Email", question.getEmail());
		model.addAttribute("Question", question.getAskquestion());
		Question userInserted=userRepository.save(question);
		model.addAttribute("question", userInserted.getAskquestion());
		model.addAttribute("message", "This question was asked by");
		model.addAttribute("id",userInserted.getId());
		question.setId(userInserted.getId());
		System.out.println(userInserted.getId());
		return "welcome";
	}
	
	
	@PostMapping("/edit")
	public String userEdit(@ModelAttribute Question question, Model model) {
	
	
Optional<Question> entity = userRepository.findById(question.getId());
Question ques = entity.get();
ques.setAskquestion(question.getEdit());
Question userInserted=userRepository.save(ques);
model.addAttribute("Name", ques.getName());
model.addAttribute("Email", ques.getEmail());
model.addAttribute("Question", ques.getAskquestion());
model.addAttribute("question", ques.getAskquestion());
model.addAttribute("message", "This question was edited by");
model.addAttribute("id",userInserted.getId());
question.setId(userInserted.getId());
System.out.println(userInserted.getId()+userInserted.getAskquestion());	return "welcome";
	}
	
//
//	  @PostMapping("/delete")
//	    public String delete(@ModelAttribute Question entity, @RequestParam(value = "id", required = true) int id) {
//	      System.out.print("done");
//	        userRepository.deleteById(id);
//	        return "done";
//	    }
	  
	@PostMapping("/delete")
	public String deleteEntoty(@ModelAttribute Question question, Model model) {
		System.out.print("done"+question.getId());
		  userRepository.deleteById(question.getId());
	        return "delete";
	    }
}
