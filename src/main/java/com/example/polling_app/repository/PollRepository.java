package com.example.polling_app.repository;

import com.example.polling_app.model.Poll;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PollRepository extends JpaRepository<Poll,Long> {
    Optional<Poll> findById(Long pollId);
    Page<Poll> findByCreatedBy(Long userId,Pageable pageable);
    long countByCreatedBy(Long userId);
    List<Poll> findByIdIn(List<Long> pollIds);
    List<Poll> findByIdIn(List<Long> pollIds, Sort sort);

}
