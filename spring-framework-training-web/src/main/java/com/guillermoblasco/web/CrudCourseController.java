package com.guillermoblasco.web;

import com.guillermoblasco.data.Course;
import com.guillermoblasco.data.CourseRepository;
import com.guillermoblasco.service.config.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.UUID;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CrudCourseController {


    private final CourseRepository courseRepository;

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @Transactional
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Course udpdate(@PathVariable("id") Course course, @RequestBody Course inputCourse) {
        course.setName(inputCourse.getName());
        courseRepository.save(course);
        return course;
    }

    @GetMapping(path = "/{id}")
    @Log
    public Course get(@PathVariable("id") UUID id) {
        Course one = courseRepository.getOne(id);
        return one;
    }

    @PostMapping(path = "")
    public Course create(@RequestBody Course course) {
        return courseRepository.save(course);
    }



}
