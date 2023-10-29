package peaksoft.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.model.Application;
import peaksoft.service.ModelService;

import java.util.List;

@Service
@Transactional

public class ApplicationService implements ModelService<Application> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Application application) {
        entityManager.persist(application);

    }

    @Override
    public Application findById(Long id) {
        Application application = entityManager.find(Application.class, id);
        return application;
    }

    @Override
    public List<Application> findAll() {
        List<Application> applications =
                entityManager.createQuery("from Application ").getResultList();
        return applications;
    }

    @Override
    public void update(Long id, Application application) {
        Application oldApplication = findById(id);
        oldApplication.setName(application.getName());
        oldApplication.setDescription(application.getDescription());
        oldApplication.setDeveloper(application.getDeveloper());
        oldApplication.setVersion(application.getVersion());
        oldApplication.setAppStatus(application.getAppStatus());
        oldApplication.setGenreName(application.getGenreName());
        oldApplication.setCreateDate(application.getCreateDate());
        entityManager.persist(oldApplication);

    }

    @Override
    public void deleteById(Long id) {
        Application application = entityManager.find(Application.class, id);
        entityManager.remove(application);

    }

    public Application getApplicaionByUserId(Long userId) {
        Application application = findById(userId);
        return application;
    }

    public List<Application> searchApplicationByName(String name) {

        return null;
    }
}
