package com.example.diary;

import com.example.diary.data.model.Entry;
import com.example.diary.data.repo.EntryRepository;
import com.example.diary.dtos.request.EntryRequest;
import com.example.diary.dtos.response.EntryResponse;
import com.example.diary.service.EntryService;
import com.example.diary.service.EntryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
//@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")



public class EntryApplicationTests {
@Autowired
    private EntryService entryService;
@Autowired
    private EntryRepository entryRepository;

    @Test
    public void testGetAllEntryRecords() {
        EntryRequest entry1 = new EntryRequest();
        entry1.setTitle("Entry 1");
        entry1.setContent("Content 1");
        entryService.createEntryRecord(entry1);

        EntryRequest entry2 = new EntryRequest();
        entry2.setTitle("Entry 2");
        entry2.setContent("Content 2");
        entryService.createEntryRecord(entry2);

//        List<Entry> entryList = entryService.getAllEntryRecords();
//        System.out.println(Arrays.toString(entryList.toArray()));

        Assertions.assertEquals(2,  entryService.getAllEntryRecords().size());
    }


    @Test
    public void testCreateEntryRecord() {
        EntryRequest entryRequest = new EntryRequest();
        entryRequest.setTitle("Test Entry");
        entryRequest.setContent("Test content");

        EntryResponse entryResponse = entryService.createEntryRecord(entryRequest);
        Assertions.assertNotNull(entryResponse.getId());
        Assertions.assertEquals("Test Entry", entryResponse.getTitle());
        Assertions.assertEquals("Test content", entryResponse.getContent());
    }

    @Test
    public void testUpdateEntryRecord() throws NoSuchFieldException {
        Entry entry = new Entry();
        entry.setTitle("Existing Entry");
        entry.setContent("Existing content");
        Entry savedEntry = entryRepository.save(entry);

        EntryRequest entryRequest = new EntryRequest();
        entryRequest.setTitle("Updated Entry");
        entryRequest.setContent("Updated content");

        EntryResponse entryResponse = entryService.updateEntryRecord(savedEntry.getId(), entryRequest);
        Assertions.assertEquals(savedEntry.getId(), entryResponse.getId());
        Assertions.assertEquals("Updated Entry", entryResponse.getTitle());
        Assertions.assertEquals("Updated content", entryResponse.getContent());
        entryService.deleteEntryById(savedEntry.getId());
    }

    @Test
    public void testDeleteEntryById() {
        Entry entry = new Entry();
        entry.setTitle("Entry to delete");
        entry.setContent("Content to delete");
        Entry savedEntry = entryRepository.save(entry);

        boolean isDeleted = entryService.deleteEntryById(savedEntry.getId());

        Assertions.assertTrue(isDeleted);
    }


}

