package com.basic.myspringboot.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Builder
@Getter
@ToString
public class CustomerVO {
    private Long id;
    private String mode;
}

