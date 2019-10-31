package io.vividcode.quarkus;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

  @Inject
  EntityManager entityManager;

  @Transactional
  public User addUser(User user) {
    if (user != null) {
      entityManager.persist(user);
    }
    return user;
  }

  public User findById(String id) {
    return users.get(id);
  }

  public User deleteUser(String userId) {
    return users.remove(userId);
  }

  public List<User> list() {
    CriteriaQuery<User> query = entityManager.getCriteriaBuilder().createQuery(User.class);
    TypedQuery<User> allQuery = entityManager.createQuery(query.select(query.from(User.class)));
    return allQuery.getResultList();
  }

  @Transactional
  public void delete(String id) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaDelete<User> deleteQuery = criteriaBuilder.createCriteriaDelete(User.class);
    Root<User> root = deleteQuery.from(User.class);
    deleteQuery.where(criteriaBuilder.equal(root.get("id"), id));
    entityManager.createQuery(deleteQuery).executeUpdate();
  }
}
