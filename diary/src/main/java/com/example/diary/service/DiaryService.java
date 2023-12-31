package com.example.diary.service;
import com.example.diary.data.model.Diary;
import com.example.diary.dtos.request.DiaryRequest;
import com.example.diary.dtos.request.EntryRequest;
import com.example.diary.dtos.response.DiaryResponse;


import java.math.BigInteger;

public interface DiaryService{
    DiaryResponse createDiary(DiaryRequest diaryRequest);
    DiaryResponse addEntryToDiary(Long diaryId, EntryRequest entryRequest);


    Diary findById(Long id);
}
