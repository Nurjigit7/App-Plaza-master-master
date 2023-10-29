package peaksoft.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.model.User;
import peaksoft.service.ModelService;

import java.util.List;

@Service
@Transactional

public class UserService implements ModelService<User> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList =
                entityManager.createQuery("from User ").getResultList();
        return userList;
    }

    @Override
    public void update(Long id, User user) {
        User oldUser = findById(id);
        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setCreateDate(user.getCreateDate());
        oldUser.setSubscribeToTheNewsletter(user.isSubscribeToTheNewsletter());
        oldUser.setSubscriptionStatus(user.getSubscriptionStatus());
        entityManager.persist(oldUser);
    }

    @Override
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }
}
