package com.example.diary.controller;

import com.example.diary.data.model.Entry;
import com.example.diary.dtos.request.EntryRequest;
import com.example.diary.dtos.response.DiaryResponse;
import com.example.diary.dtos.response.EntryResponse;
import com.example.diary.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/diary/entry")
public class EntryController {
    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }
    @PostMapping("/create")
    public ResponseEntity<EntryResponse> createEntryRecord(@RequestBody EntryRequest entryRequest) {
        EntryResponse createdEntry = entryService.createEntryRecord(entryRequest);
         return new ResponseEntity<>(createdEntry, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{entryId}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long entryId) {
        boolean deleted = entryService.deleteEntryById(entryId);
        if (deleted) {
            return ResponseEntity.ok("Entry with ID " + entryId + " has been deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update/{entryId}")
    public ResponseEntity<EntryResponse> updateEntryRecord(@PathVariable Long entryId, @RequestBody EntryRequest entryRequest) throws NoSuchFieldException {
        EntryResponse createdEntry = entryService.updateEntryRecord(entryId, entryRequest);
        return new ResponseEntity<>(createdEntry, HttpStatus.OK);
    }


    @GetMapping("/get/{entryId}")
    public ResponseEntity<Entry> getEntriesById(@PathVariable Long entryId) {
        Optional<Entry> entry = entryService.getEntriesById(entryId);
        return entry.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Entry>> getAllEntryRecords() {
        List<Entry> entries = entryService.getAllEntryRecords();
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }
}


