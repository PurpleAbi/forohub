package com.aluracursos.challenges.forohub.domain.course.topic;

import jakarta.validation.constraints.NotBlank;

public record DataUpdateTopic(
        String title,
        String message,
        String status
) {
}
