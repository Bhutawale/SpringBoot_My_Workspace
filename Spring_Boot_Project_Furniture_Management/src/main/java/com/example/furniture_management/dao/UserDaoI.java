package com.example.furniture_management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.furniture_management.model.Feedback;
import com.example.furniture_management.model.User;

@Repository
public interface UserDaoI extends JpaRepository<User, Integer>
{
	public List<User> findByUserCity(String userCity);
	
	
	public List<User> findByUserGender(String userGender);
	
	
	public List<User> findByUserNameAndUserId
	(String userName,int userId);
	
	
	@Query(value="SELECT * FROM user_details u , login_details l WHERE l.login_id=?1 AND u.user_name=?2",nativeQuery = true)
	public List<User> findByUserNameAndLoginId
	(int loginId,String userName);
	
	
	@Query(value = "SELECT * FROM user_details ORDER BY user_name",nativeQuery = true)
	public List<User> findAllSortedByUserName();
	
	
	@Query(value="select p from Product p where p.user IN (select u.userId from User u where u.userId= ?1)")
	public List<User> findAllproductOrderedByUserName(int userId);
	
	
	
	@Query("select f from Feedback f where f.feedbackId IN (SELECT u.feedbackid FROM User u where u.userId= ?1)")
	public List<Feedback> findByFeedbackGivenByUser(int userId);
}

