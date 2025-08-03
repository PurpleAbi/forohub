package com.aluracursos.challenges.forohub.domain.course.topic;

import com.aluracursos.challenges.forohub.domain.course.CourseEntity;
import com.aluracursos.challenges.forohub.domain.course.Subject;
import com.aluracursos.challenges.forohub.domain.course.topic.answer.AnswerEntity;
import com.aluracursos.challenges.forohub.domain.user.profile.ProfileEntity;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String message;
    @Column(name = "date_of_creation")
    private String dateOfCreation;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<AnswerEntity> answers = new ArrayList<>();


    public TopicEntity(@Valid DataTopicCreation newTopic) {
        this.title = newTopic.title();
        this.message = newTopic.message();
        this.dateOfCreation = newTopic.dateOfCreation();
        this.author = new ProfileEntity(newTopic.authorName());
        this.course = new CourseEntity(newTopic.courseName(), newTopic.category());
        this.status = newTopic.status();
    }

    public void setAuthor(ProfileEntity profile) {
        if (profile != null) {
            this.author = profile;
        } else {
            throw new IllegalArgumentException("Author cannot be null");
        }
    }

    public void setCourse(CourseEntity course) {
        if (course != null) {
            this.course = course;
        } else {
            throw new IllegalArgumentException("Course cannot be null");
        }
    }

    public void updateFromData(DataUpdateTopic updatedTopic) {
        if (updatedTopic.title() != null) {
            this.title = updatedTopic.title();
        }
        if (updatedTopic.message() != null) {
            this.message = updatedTopic.message();
        }
        if (updatedTopic.status() != null) {
            this.status = updatedTopic.status();
        }
    }
}
