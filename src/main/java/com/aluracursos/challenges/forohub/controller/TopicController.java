package com.aluracursos.challenges.forohub.controller;

import com.aluracursos.challenges.forohub.domain.course.topic.DataTopicCreation;
import com.aluracursos.challenges.forohub.domain.course.topic.DataUpdateTopic;
import com.aluracursos.challenges.forohub.domain.course.topic.TopicDTO;
import com.aluracursos.challenges.forohub.service.ForumService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping ("/topicos")
//@SecurityRequirement(name = "bearer-key")
public class TopicController {

    private final ForumService forumService;

    public TopicController(ForumService forumService) {
        this.forumService = forumService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<TopicDTO> createTopic(@RequestBody @Valid DataTopicCreation newTopic) {
        var response = forumService.createTopic(newTopic);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDTO>> listAllTopics(@PageableDefault(size = 10, sort = {"title"})
                                                            Pageable pageable){
            var response = forumService.listAllTopics(pageable);
            return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> getTopicById(@PathVariable Integer id) {
        var topic = forumService.getTopicById(id);
        if (topic == null) {
            return ResponseEntity.notFound().build();
        } return ResponseEntity.ok(topic);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDTO> updateTopic(@PathVariable Integer id,
                                                @RequestBody @Valid DataUpdateTopic updatedTopic) {
        var updated = forumService.updateTopic(id, updatedTopic);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTopic(@PathVariable Integer id) {
        var topic = forumService.deleteTopic(id);
            if (topic == 0) {
                return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
