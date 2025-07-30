package com.aluracursos.challenges.forohub.domain.course.topic;

import com.aluracursos.challenges.forohub.domain.course.topic.answer.Answer;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;

import java.util.List;

@Getter
public class Topic {
    private String id;
    private String title;
    private String message;
    private String dateOfCreation;
    private String status;
    private String authorId;
    private String courseId;
    private List<Answer> answers;


}
