package com.om.question_service.dao;

import com.om.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category); // we do not need to define any code in it as JPA is smart enough to


    @Query(value = "SELECT q.id FROM question q Where q.category = :category ORDER BY RANDOM() LIMIT  :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
    // match category parameter with the column present in DB as category.
}
