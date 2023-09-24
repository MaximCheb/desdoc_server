package com.doc.concept.server.user.model.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoCodeResponseDto {
    private String code;
    private String currentProject;
}
