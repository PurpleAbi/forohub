package com.aluracursos.challenges.forohub.domain.course.topic.answer;

import com.aluracursos.challenges.forohub.domain.course.topic.TopicEntity;
import com.aluracursos.challenges.forohub.domain.user.UserEntity;
import com.aluracursos.challenges.forohub.domain.user.profile.ProfileEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "answers")
@Entity(name = "Answer")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    @Column(name = "date_of_creation")
    private String dateOfCreation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profileUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private TopicEntity topic;
    private String solution;


}
