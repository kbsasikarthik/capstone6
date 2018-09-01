package co.grandcircus.Capstone6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Capstone6.entity.Task;
import co.grandcircus.Capstone6.entity.User;

public interface TaskDao extends JpaRepository<Task, Long>{
	
	List<Task> findAll();
	List<Task> findByOrderByDescription();
	List<Task> findAllByUser(User user);


}
