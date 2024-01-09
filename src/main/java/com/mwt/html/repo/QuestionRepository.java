package com.mwt.html.repo;
 
import org.springframework.data.repository.CrudRepository;

import com.mwt.html.model.Question;

public interface QuestionRepository extends CrudRepository<Question,Integer> {

}
