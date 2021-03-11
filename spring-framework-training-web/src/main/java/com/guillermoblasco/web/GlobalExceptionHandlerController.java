package com.guillermoblasco.web;

import com.guillermoblasco.data.Course;
import com.guillermoblasco.data.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandlerController {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleIllegalCourseNameException(IllegalCourseNameException exception) {
        return
    }


}
