package com.example.diary.service;

import com.example.diary.data.model.Entry;
import com.example.diary.data.repo.EntryRepository;
import com.example.diary.dtos.request.EntryRequest;
import com.example.diary.dtos.response.EntryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class EntryServiceImpl implements EntryService {

    private final EntryRepository entryRepository;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<Entry> getAllEntryRecords() {
        return entryRepository.findAll();
    }

    public EntryResponse createEntryRecord(EntryRequest entryRequest) {
        try {
            Entry entry = new Entry();
            entry.setTitle(entryRequest.getTitle());
            entry.setContent(entryRequest.getContent());

            Entry savedEntry = entryRepository.save(entry);

            return new EntryResponse(savedEntry.getId(), savedEntry.getTitle(), savedEntry.getContent());
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException("Failed to create entry record. Please try again later.");
        }
    }


    public EntryResponse updateEntryRecord(Long entryId, EntryRequest entryRequest) throws NoSuchFieldException {
        Entry entry = entryRepository.findById(entryId)
                .orElseThrow(() -> new NoSuchFieldException("Entry not found"));

        entry.setTitle(entryRequest.getTitle());
        entry.setContent(entryRequest.getContent());

        Entry updatedEntry = entryRepository.save(entry);

        return new EntryResponse(updatedEntry.getId(), updatedEntry.getTitle(), updatedEntry.getContent());
    }

    public Optional<Entry> getEntriesById(Long entryId) {
        return entryRepository.findById(entryId);
    }
    public boolean deleteEntryById(Long entryId) {
        Optional<Entry> optionalEntry = entryRepository.findById(entryId);
        if (optionalEntry.isPresent()) {
            entryRepository.deleteById(entryId);
            return true;
        } else {
            return false;
        }
    }

}

