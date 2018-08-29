package co.grandcircus.Capstone6.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import co.grandcircus.Capstone6.entity.User;

//@Component
//public class UserDao {
	public interface UserDao extends JpaRepository<User, Long>	 {
//	private Map<Long, User> users = new HashMap<>();
//	private long nextId = 1;
//	
//	public User findById(Long id) {
//		return users.get(id);
//	}
//	
//	public User findByEmail(String email) {
//		return users.values().stream().filter(user -> email.equals(user.getEmail())).findAny().orElse(null);
//	}
//	
//	public void save(User user) {
//		if (user.getId() == null) {
//			user.setId(nextId++);
//		}
//		users.put(user.getId(), user);
//	}
//
//	public List<User> findAll() {
//		
//		return null;
//	}
		
		List<User> findAll();
		List<User> findByOrderById();
		User findByEmail(String email);
	
}


