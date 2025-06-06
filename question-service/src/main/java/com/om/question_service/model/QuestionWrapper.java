package com.om.question_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class QuestionWrapper {

    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
