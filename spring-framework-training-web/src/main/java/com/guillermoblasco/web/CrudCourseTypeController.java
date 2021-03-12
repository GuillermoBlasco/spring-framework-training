package com.guillermoblasco.web;

import com.guillermoblasco.data.Course;
import com.guillermoblasco.data.CourseRepository;
import com.guillermoblasco.data.CourseType;
import com.guillermoblasco.data.CourseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.UUID;

@RestController
@RequestMapping("/courseType")
@RequiredArgsConstructor
public class CrudCourseTypeController {


    private final CourseTypeRepository repository;

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @Transactional
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CourseType udpdate(@PathVariable("id") CourseType course, @RequestBody CourseType inputCourse) {
        course.setName(inputCourse.getName());
        repository.save(course);
        return course;
    }

    @GetMapping(path = "/{id}")
    public CourseType get(@PathVariable("id") UUID id) {
        CourseType one = repository.getOne(id);
        return one;
    }

    @PostMapping(path = "")
    public CourseType create(@RequestBody CourseType course) {
        return repository.save(course);
    }



}
