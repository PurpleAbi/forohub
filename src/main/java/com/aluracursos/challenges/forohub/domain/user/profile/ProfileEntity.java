package com.aluracursos.challenges.forohub.domain.user.profile;

import com.aluracursos.challenges.forohub.domain.course.topic.TopicEntity;
import com.aluracursos.challenges.forohub.domain.course.topic.answer.AnswerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "profiles")
@Entity(name = "Profile")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String username;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<TopicEntity> topics = new ArrayList<>();

    @OneToMany(mappedBy = "profileUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<AnswerEntity> answers = new ArrayList<>();

    public ProfileEntity(String username) {
        this.username = username;
    }

}
