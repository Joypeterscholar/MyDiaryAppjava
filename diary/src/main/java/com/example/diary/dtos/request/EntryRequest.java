package com.example.diary.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntryRequest {
    @Id
    private Long entryId;
    private String title;
    private String content;
<<<<<<< HEAD

=======
    private String testEntry;


    public EntryRequest(String testEntry, String content) {
        this.testEntry = testEntry;
        this.content = content;
    }
>>>>>>> 9616183 (pushed)
}

