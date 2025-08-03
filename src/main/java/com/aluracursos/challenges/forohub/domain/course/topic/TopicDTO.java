package com.aluracursos.challenges.forohub.domain.course.topic;

public record TopicDTO(
        Integer id,
        String title,
        String content,
        String courseName,
        String authorName,
        String status

) {
    public TopicDTO(TopicEntity topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(),
             topic.getCourse().getName(), topic.getAuthor().getName(), topic.getStatus());
    }
}
