package com.aluracursos.challenges.forohub.service;

import com.aluracursos.challenges.forohub.domain.course.CourseEntity;
import com.aluracursos.challenges.forohub.domain.course.CourseRepository;
import com.aluracursos.challenges.forohub.domain.course.topic.*;
import com.aluracursos.challenges.forohub.domain.user.profile.ProfileEntity;
import com.aluracursos.challenges.forohub.domain.user.profile.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ForumService {

    private final TopicsRepository topicsRepository;
    private final ProfileRepository profileRepository;
    private final CourseRepository courseRepository;

    public TopicDTO createTopic(DataTopicCreation newTopic){
        var profile = profileRepository.findByName(newTopic.authorName())
            .orElseGet(() -> profileRepository.save(new ProfileEntity(newTopic.authorName())));
        var course = courseRepository.findByName(newTopic.courseName())
            .orElseGet(() -> courseRepository.save(new CourseEntity(newTopic.courseName(), newTopic.category())));
        var topic = new TopicEntity(newTopic);
        topic.setAuthor(profile);
        topic.setCourse(course);
        var savedTopic = topicsRepository.save(topic);

        return new TopicDTO(savedTopic);
    }

    public Page<TopicDTO> listAllTopics(Pageable pageable) {
        return topicsRepository.findAll(pageable).map(TopicDTO::new);
    }

    public TopicDTO getTopicById(Integer id) {
        Optional<TopicEntity> topic = topicsRepository.findById(id);
        return topic.map(TopicDTO::new).orElse(null);
    }

    public TopicDTO updateTopic(Integer id, DataUpdateTopic updatedTopic) {
        Optional<TopicEntity> existingTopic = topicsRepository.findById(id);
        if (existingTopic.isPresent()) {
            var topic = existingTopic.get();
            topic.updateFromData(updatedTopic);
            var updated = topicsRepository.save(topic);
            return new TopicDTO(updated);
        }
        return null;
    }

    public int deleteTopic(Integer id) {
        Optional<TopicEntity> topic = topicsRepository.findById(id);
        if (topic.isPresent()) {
            topicsRepository.deleteById(id);
            return 1;
        } else {
            return 0;
        }

    }
}
