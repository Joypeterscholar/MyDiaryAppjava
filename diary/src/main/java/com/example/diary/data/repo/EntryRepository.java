package com.example.diary.data.repo;

import com.example.diary.data.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.UUID;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
