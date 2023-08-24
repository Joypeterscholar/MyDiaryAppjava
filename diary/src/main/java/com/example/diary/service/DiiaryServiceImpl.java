package com.example.diary.service;

import com.example.diary.data.model.Diary;
import com.example.diary.data.model.Entry;
import com.example.diary.data.repo.DiiaryRepository;
import com.example.diary.dtos.request.EntryRequest;
import com.example.diary.dtos.response.DiaryResponse;
import com.example.diary.dtos.request.DiaryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.stereotype.Component;


import java.math.BigInteger;
import java.util.NoSuchElementException;

@Component
@EnableJdbcRepositories
public class DiiaryServiceImpl implements DiaryService{

        private final DiiaryRepository diiaryRepository;

        @Autowired
        public DiiaryServiceImpl(DiiaryRepository diaryRepository) {
            this.diiaryRepository = diaryRepository;
        }

        public DiaryResponse createDiary(DiaryRequest diaryRequest) {
            Diary diary = Diary.builder()
                    .title(diaryRequest.getTitle())
                    .build();

            Diary savedDiary = diiaryRepository.save(diary);

            return DiaryResponse.builder()
                    .id(savedDiary.getId())
                    .title(savedDiary.getTitle())
                    .build();
        }




    public DiaryResponse addEntryToDiary(Long diaryId, EntryRequest entryRequest) {
        Diary diary = diiaryRepository.findById(diaryId).orElseThrow(() -> new NoSuchElementException("Diary not found"));

        Entry entry = Entry.builder()
                .title(entryRequest.getTitle())
                .content(entryRequest.getContent())
                .build();

        entry.setDiary(diary);
        diary.getEntries().add(entry);

        Diary savedDiary = diiaryRepository.save(diary);

        return DiaryResponse.builder()
                .id(savedDiary.getId())
                .title(savedDiary.getTitle())
                .build();
    }

    @Override
    public Diary findById(Long id) {
        return diiaryRepository.findById(id).orElseThrow();
    }


}


