package com.zunigatomas.loans.dto;

import lombok.Getter;
import lombok.Setter;
//import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


//esta clase va como configuración en la anotacion @EnableConfigurationProperties(value = {LoansContactInfoDto.class})
//@ConfigurationProperties(prefix = "loans")
@Getter
@Setter
public class LoansContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}
