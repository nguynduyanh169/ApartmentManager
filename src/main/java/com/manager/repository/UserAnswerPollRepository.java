package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entity.UserAnswerPoll;

@Repository
public interface UserAnswerPollRepository extends JpaRepository<UserAnswerPoll, Long>{
	
	@Query("SELECT u from UserAnswerPoll u where u.poll.pollId = :pollId")
	List<UserAnswerPoll> getUserAnswerPollByPollId(@Param(value = "pollId") long pollId);

}
