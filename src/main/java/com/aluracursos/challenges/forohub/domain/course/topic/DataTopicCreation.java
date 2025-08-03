package com.aluracursos.challenges.forohub.domain.course.topic;

import com.aluracursos.challenges.forohub.domain.course.Subject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataTopicCreation(
        @NotBlank String title,
        @NotBlank String message,
        @NotBlank String dateOfCreation,
        @NotBlank String authorName,
        @NotBlank String courseName,
        @NotNull Subject category,
        @NotBlank String status
) {

}
