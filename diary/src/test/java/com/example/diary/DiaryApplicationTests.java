package com.example.diary;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiaryApplicationTests {

	@Test
	void contextLoads() {
	}

=======
import com.example.diary.data.model.Diary;
import com.example.diary.dtos.request.EntryRequest;
import com.example.diary.dtos.response.EntryResponse;
import com.example.diary.service.DiaryService;
import com.example.diary.data.repo.DiiaryRepository;
import com.example.diary.dtos.request.DiaryRequest;
import com.example.diary.dtos.response.DiaryResponse;
import com.example.diary.service.DiiaryServiceImpl;
import com.example.diary.service.EntryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DiaryApplicationTests {


	@Autowired
	private DiaryService diiaryService;
	@Autowired
	private EntryService entryService;


	@Test
	public void testCreateDiary() {
		DiaryRequest diaryRequest = new DiaryRequest();
		diaryRequest.setTitle("Test Diary");

		DiaryResponse diaryResponse = diiaryService.createDiary(diaryRequest);

		assertNotNull(diaryResponse.getId());
		assertEquals("Test Diary", diaryResponse.getTitle());

		Diary savedDiary = diiaryService.findById(diaryResponse.getId());
		assertNotNull(savedDiary);
		assertEquals("Test Diary", savedDiary.getTitle());
	}
>>>>>>> 9616183 (pushed)
}
