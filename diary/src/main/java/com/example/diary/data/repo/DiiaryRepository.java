package com.example.diary.data.repo;

import com.example.diary.data.model.Diary;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.UUID;
@EnableJdbcRepositories
public interface DiiaryRepository extends JpaRepository<Diary, Long> {
}
