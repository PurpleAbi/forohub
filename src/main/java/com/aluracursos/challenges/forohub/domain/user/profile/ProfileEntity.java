package com.aluracursos.challenges.forohub.domain.user.profile;

import com.aluracursos.challenges.forohub.domain.course.topic.TopicEntity;
import com.aluracursos.challenges.forohub.domain.course.topic.answer.AnswerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;

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
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<TopicEntity> topics = new ArrayList<>();

    @OneToMany(mappedBy = "profileUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<AnswerEntity> answers = new ArrayList<>();

    public ProfileEntity(String name) {
        this.name = name;
    }

}
