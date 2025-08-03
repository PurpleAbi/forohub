package com.aluracursos.challenges.forohub.domain.course;

import com.aluracursos.challenges.forohub.domain.course.topic.TopicEntity;
import com.aluracursos.challenges.forohub.domain.course.topic.answer.AnswerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "courses")
@Entity(name = "Course")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Subject category;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<TopicEntity> topics = new ArrayList<>();

    public CourseEntity(String name, Subject category) {
        this.name = name;
        this.category = category;
    }
}
