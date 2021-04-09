package com.example.polling_app.repository;

import com.example.polling_app.model.ChoiceVoteCount;
import com.example.polling_app.model.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query(value = "SELECT NEW com.example.polls.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM Vote v WHERE v.poll.id in :pollIds GROUP BY v.choice.id", nativeQuery = true)
    List<ChoiceVoteCount> countByPollIdInGroupByChoiceId(@Param("pollIds") List<Long> pollIds);
    @Query(value = "SELECT NEW com.example.polls.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM Vote v WHERE v.poll.id = :pollId GROUP BY v.choice.id", nativeQuery = true)
    List<ChoiceVoteCount> countByPollIdGroupByChoiceId(@Param("pollId") Long pollId);

    @Query(value = "SELECT v FROM Vote v where v.user.id = :userId and v.poll.id in :pollIds", nativeQuery = true)
    List<Vote> findByUserIdAndPollIdIn(@Param("userId") Long userId, @Param("pollIds") List<Long> pollIds);

    @Query(value = "SELECT v FROM Vote v where v.user.id = :userId and v.poll.id = :pollId", nativeQuery = true)
    Vote findByUserIdAndPollId(@Param("userId") Long userId, @Param("pollId") Long pollId);

    @Query(value = "SELECT COUNT(v.id) from Vote v where v.user.id = :userId", nativeQuery = true)
    long countByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT v.poll.id FROM Vote v WHERE v.user.id = :userId", nativeQuery = true)
    Page<Long> findVotedPollIdsByUserId(@Param("userId") Long userId, Pageable pageable);


}
