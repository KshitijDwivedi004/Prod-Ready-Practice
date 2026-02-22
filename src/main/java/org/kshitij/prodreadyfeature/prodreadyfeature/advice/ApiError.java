package org.kshitij.prodreadyfeature.prodreadyfeature.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Component
@AllArgsConstructor
public class ApiError {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
    private String error;
    private HttpStatus status;

    public ApiError(){
        this.dateTime=LocalDateTime.now();
    }
    public ApiError(String error,HttpStatus status){
        this();
        this.error=error;
        this.status=status;
    }
}
