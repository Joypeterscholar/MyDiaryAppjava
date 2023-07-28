package com.example.diary.test;
import com.example.diary.controller.DiaryController;
import com.example.diary.data.model.Diary;
import com.example.diary.dtos.request.DiaryRequest;
import com.example.diary.dtos.response.DiaryResponse;
import com.example.diary.service.DiaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

//@RunWith(SpringRunner.class)
@WebMvcTest(DiaryController.class)
@ExtendWith(MockitoExtension.class)
public class DiaryMockitoTest {
    @Autowired
    private MockMvc mock;

    @MockBean
    private DiaryController diaryController;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testCreateDiary() {
        Diary diary = new Diary();
        diary.setTitle("my diary");
        DiaryService diaryServiceMock = mock(DiaryService.class);
        DiaryRequest request = new DiaryRequest("TITLE");
        DiaryResponse response = new DiaryResponse(1L, "TITLE");
        when(diaryServiceMock.createDiary(eq(request))).thenReturn(response);
        ResponseEntity<DiaryResponse> result = diaryController.createDiary(request);
        verify(diaryServiceMock, times(1)).createDiary(eq(request));
        assertEquals(HttpStatus.CREATED, result.getStatusCode()); // Check the status code
        assertEquals(response, result.getBody());
    }


}


