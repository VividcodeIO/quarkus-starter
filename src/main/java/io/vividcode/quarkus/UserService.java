package io.vividcode.quarkus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {
  private Map<String, User> users = new HashMap<>();

  public UserService() {
    addUser(new User("test1", "test1@example.com"));
    addUser(new User("test2", "test2@example.com"));
    addUser(new User("test3", "test3@example.com"));
  }

  public void addUser(User user) {
    if (user != null) {
      users.put(user.getId(), user);
    }
  }

  public List<User> list() {
    return new ArrayList<>(users.values());
  }
}
