package com.example.diary.controller;

import com.example.diary.dtos.request.DiaryRequest;
import com.example.diary.dtos.request.EntryRequest;
import com.example.diary.dtos.response.DiaryResponse;
import com.example.diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.UUID;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/diary")
    public ResponseEntity<DiaryResponse> createDiary(@RequestBody DiaryRequest diaryRequest) {
        DiaryResponse createdDiary = diaryService.createDiary(diaryRequest);
        return new ResponseEntity<>(createdDiary, HttpStatus.CREATED);
    }

        @PostMapping("/{diaryId}/entries")
        public ResponseEntity<DiaryResponse> addEntryToDiary(@PathVariable Long diaryId, @RequestBody EntryRequest entryRequest) {
            DiaryResponse updatedDiary = diaryService.addEntryToDiary(diaryId, entryRequest);
            return new ResponseEntity<>(updatedDiary, HttpStatus.OK);
        }
 }



