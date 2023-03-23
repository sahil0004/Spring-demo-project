package com.example.subject;

import com.example.subject.bean.Subject;
import com.example.subject.controller.SubjectController;
import com.example.subject.service.SubjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class SubjectControllerTest {
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = new ObjectMapper().writer();
    Subject subject1 = new Subject(147, "Sahil Namde", "@gmail.com", "1238941", "address");
    Subject subject2 = new Subject(148, "Sahil Nam", "@gmail.com", "1238941", "address");
    Subject subject3 = new Subject(149, "Sahil Na", "@gmail.com", "1238941", "address");
    private MockMvc mockMvc;
    @Mock
    private SubjectService subjectService;
    @InjectMocks
    private SubjectController subjectController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(subjectController).build();
    }

    @Test
    public void getAllSubjectTest() throws Exception {
        List<Subject> records = new ArrayList<>(Arrays.asList(subject1, subject2, subject3));
        Mockito.when(subjectService.getAllSubjects()).thenReturn(records);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/subjects").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));

    }

}
