package com.guillermoblasco.web;

import com.guillermoblasco.data.Course;
import com.guillermoblasco.data.CourseRepository;
import com.guillermoblasco.service.CrudService;
import com.guillermoblasco.service.RandomizeService;
import com.guillermoblasco.service.Student;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CrudCourseController {


    private final CourseRepository courseRepository;

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @Transactional
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Course randomize(@PathVariable("id") Course course, @RequestBody Course inputCourse) {
        course.setName(inputCourse.getName());
        courseRepository.save(course);
        return course;
    }

    @GetMapping(path = "/{id}")
    public Course randomize(@PathVariable("id") UUID id) {
        Course one = courseRepository.getOne(id);
        return one;
    }

    @PostMapping(path = "")
    public Course randomize(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @ExceptionHandler
    public ResponseEntity handleIllegalCourseNameException(IllegalCourseNameException exception) {

    }


}
