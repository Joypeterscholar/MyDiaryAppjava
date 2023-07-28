package com.example.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD

=======
import org.springframework.context.annotation.Import;

@Import(DiaryConfiguration.class)
>>>>>>> 9616183 (pushed)
@SpringBootApplication
public class DiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiaryApplication.class, args);
	}

}
<<<<<<< HEAD
=======

//
//import javax.swing.*;
//import java.util.Optional;
//@Component
//class Main {
//	@Autowired
//	private  DiiaryRepository diaryRepository;
//	@Autowired
//	private EntryRepository entryRepository;
//
//
//
//
////	private static DiaryService diaryService = new DiiaryServiceImpl();
////	private static EntryService entryService;
////
////	public static void Main(DiaryService diaryService, EntryService entryService) {
////		Main.diaryService = diaryService;
////		Main.entryService = entryService;
////
////	}
//
//
//	public  void main(String[] args) throws NoSuchFieldException {
//		Main main = new Main();
//
//		main.displayMainMenu(diaryRepository);
//	}
//
//	public  void displayMainMenu(DiiaryRepository diiaryRepository) throws NoSuchFieldException {
//		String mainMenu = """
//                Welcome to our diary
//                1 -> Create Diary
//                2 -> Exit
//                """;
//		String userInput = input(mainMenu);
//		switch (userInput.charAt(0)) {
//			case '1' -> createDiary(diiaryRepository);
//			case '2' -> exit();
//			default -> displayMainMenu();
//		}
//	}
//
//	private  void createDiary(DiiaryRepository diiaryRepository) throws NoSuchFieldException {
////		String title = input("Enter title");
////		DiaryRequest req = new DiaryRequest();
////		req.setTitle(input("enter title"));
//		Diary diary = new Diary();
//				diary.setTitle(input("Enter title"));
//		diiaryRepository.save(diary);
//		display("Diary created");
//		openDiaryNow();
//	}
//
//	private void exit() {
//		display("Thanks for using our application");
//		System.exit(0);
//	}
//
//
//
////	private static void unlockDiary() throws NoSuchFieldException {
////		String password = input("Enter password to unlock the diary");
//////		request.setPassword(input("enter password to unlock diary"));
////		if (Objects.equals(password, user.getPassword())) {
////			display("Diary unlocked");
////			openDiaryNow();
////		} else {
////			display("Invalid password. Please try again.");
////			unlockDiary();
////		}
////	}
//
//	private  void openDiaryNow() throws NoSuchFieldException {
//		String menuItem = """
//                1 -> Create Gist
//                2 -> View Gist by ID
//                3 -> Delete Gist by ID
//                4 -> Update Gist
//                5 -> View All Gist
//                6 -> Exit
//                """;
//		char userResponse = input(menuItem).charAt(0);
//		switch (userResponse) {
//			case '1' -> createGist(entryRepository);
//			case '2' -> viewGist(entryRepository);
//			case '3' -> deleteGist(entryRepository);
//			case '4' -> updateGist(entryRepository);
//			case '5' -> viewAllGist(entryRepository);
//			case '6' -> exit();
//			default -> openDiaryNow();
//		}
//	}
//
//	private void createGist(EntryRepository entryRepository) throws NoSuchFieldException {
//		Entry entry = new Entry();
//		EntryRequest request = new EntryRequest();
//		entry.setId(Long.valueOf("enter id"));
//		entry.setTitle(input("Enter a title"));
//		entry.setContent("Enter a body");
//		request.setEntryId(entry.getId());
//		request.setTitle(entry.getTitle());
//		request.setContent(entry.getContent());
////		entryService.createEntryRecord(request);
//		entryRepository.save(entry);
//		display("Gist created successfully");
//		openDiaryNow();
//	}
//
//	private  void viewGist(EntryRepository entryRepository) throws NoSuchFieldException {
//		int id = Integer.parseInt(input("Enter ID: "));
//		Optional<Entry> entry = entryRepository.findById((long) id);
//		if (entry.isPresent()) {
//			display(entry.toString());
//		} else {
//			display("No entry found with the specified ID.");
//		}
//		openDiaryNow();
//	}
//	private  void viewAllGist(EntryRepository entryRepository) throws NoSuchFieldException {
//		display(entryRepository.findAll().toString());
//		openDiaryNow();
//	}
//
//	private  void deleteGist(EntryRepository entryRepository) throws NoSuchFieldException {
//		Long id = Long.valueOf(input("Enter ID: "));
//		if (entryRepository.existsById(id)) {
//			display("Gist deleted successfully");
//		} else {
//			display("No entry found with the specified ID.");
//		}
//		openDiaryNow();
//	}
//
//	private void updateGist(EntryRepository entryRepository) throws NoSuchFieldException {
//		Long id = Long.valueOf(input("Enter ID: "));
//		EntryRequest entryRequest1 = new EntryRequest();
//		entryRequest1.setTitle(input("Enter a new title"));
//		entryRequest1.setContent(input("Enter new body"));
////		String newBody = input("Enter new body");
//		if (entryRepository.findById(id).isPresent()) {
//			display("Gist updated successfully");
//		} else {
//			display("No entry found with the specified ID.");
//		}
//		openDiaryNow();
//	}
//
//	private static void display(String message) {
//		JOptionPane.showMessageDialog(null, message);
//	}
//
//	private static String input(String prompt) {
//		return JOptionPane.showInputDialog(prompt);
//	}
//}
//

>>>>>>> 9616183 (pushed)
