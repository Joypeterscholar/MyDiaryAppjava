package com.example.diary.service;

import com.example.diary.data.model.Entry;
import com.example.diary.dtos.request.EntryRequest;
import com.example.diary.dtos.response.EntryResponse;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EntryService {
    List<Entry> getAllEntryRecords();
    EntryResponse createEntryRecord(EntryRequest entryRequest);
    EntryResponse updateEntryRecord(Long entryId, EntryRequest entryRequest) throws NoSuchFieldException;
    Optional<Entry> getEntriesById(Long entryId);
    boolean deleteEntryById(Long entryId);
}
