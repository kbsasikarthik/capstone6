package co.grandcircus.Capstone6.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String duedate;
	private Boolean complete;
	@ManyToOne
//	@JoinColumn(name="user_id")
	private User user;
	
	public Task() {}
	
	public Task(Long id, String description, String duedate, Boolean complete) {
		super();
		this.id = id;
		this.description = description;
		this.duedate = duedate;
		this.complete = complete;	
	}
	
	public Task(Long id, String description, String duedate, Boolean complete, User user ) {
		super();
		this.id = id;
		this.description = description;
		this.duedate = duedate;
		this.complete = complete;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", duedate=" + duedate + ", complete=" + complete
				+ ", users=" + user + "]";
	}
	
	

}
