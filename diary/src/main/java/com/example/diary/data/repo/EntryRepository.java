package com.example.diary.data.repo;

import com.example.diary.data.model.Entry;
<<<<<<< HEAD
=======
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
>>>>>>> 9616183 (pushed)
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.UUID;
<<<<<<< HEAD
=======
@EnableJdbcRepositories
>>>>>>> 9616183 (pushed)

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
