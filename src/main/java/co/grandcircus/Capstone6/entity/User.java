package co.grandcircus.Capstone6.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	@OneToMany
	(mappedBy ="user")
//	Task task;
	private List<Task> tasks;

public User() {}

public User( Long id, String email, String password) {
	
	super();
	this.id = id;
	this.email = email;
	this.password = password;
}

public User(Long id, String email, String password, List<Task> tasks) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.tasks = tasks;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

//public Task getTask() {
//	return task;
//}
//
//public void setTask(Task task) {
//	this.task = task;
//}

public List<Task> getTasks() {
	return tasks;
}

public void setTasks(List<Task> tasks) {
	this.tasks = tasks;
}

@Override
public String toString() {
	return "User [id=" + id + ", email=" + email + ", password=" + password + ", task=" + tasks+ "]";
}



}