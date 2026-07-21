package com.efsun.todoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {

    @NotBlank(message = "Başlık boş bırakılamaz")
    private String title;

    private String description;

    @NotNull(message = "Completed alanı boş olamaz")
    private Boolean completed;
}