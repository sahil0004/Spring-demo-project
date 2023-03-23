package com.example.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.subject.bean.Subject;
import com.example.subject.service.SubjectService;
@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/subjects")
    public List<Subject> getAllSubjects()
    {
        return subjectService.getAllSubjects();
    }

    @RequestMapping(method = RequestMethod.POST, value="/subjects")
    public ResponseEntity<List<Subject>> addSubject(@RequestBody List<Subject> subject)
    {
//        subjectService.addAllSubject(subject);
        List<Subject> createdResources = subjectService.addAllSubject(subject);
        if (!createdResources.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdResources);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value="/subjects/{id}")
    public void updateSubject(@PathVariable String id, @RequestBody Subject subject)
    {
        subjectService.updateSubject(id, subject);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/subjects/{id}")
    public void DeleteSubject(@PathVariable String id)
    {
        subjectService.deleteSubject(id);
    }








}
