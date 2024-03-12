package com.zunigatomas.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {

    @Schema(description = "StatusCode en la respuesta")
    private String statusCode;

    @Schema(
            description = "StatusMsg en la respuesta"
    )
    private String statusMsg;
}