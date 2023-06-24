package com.example.demo2.dtos.Response;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteResponse {
    private Long id;
    private String message;
}
