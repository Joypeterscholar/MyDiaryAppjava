package com.example.diary.service;
<<<<<<< HEAD
=======
import com.example.diary.data.model.Diary;
>>>>>>> 9616183 (pushed)
import com.example.diary.dtos.request.DiaryRequest;
import com.example.diary.dtos.request.EntryRequest;
import com.example.diary.dtos.response.DiaryResponse;


import java.math.BigInteger;

public interface DiaryService{
    DiaryResponse createDiary(DiaryRequest diaryRequest);
    DiaryResponse addEntryToDiary(Long diaryId, EntryRequest entryRequest);
<<<<<<< HEAD
=======

    Diary findById(Long id);
>>>>>>> 9616183 (pushed)
}
