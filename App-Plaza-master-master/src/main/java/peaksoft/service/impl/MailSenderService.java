package peaksoft.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.model.MailSender;
import peaksoft.service.ModelService;

import java.util.List;

@Service
@Transactional

public class MailSenderService implements ModelService<MailSender> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(MailSender mailSender) {
        entityManager.persist(mailSender);

    }

    @Override
    public MailSender findById(Long id) {
        MailSender mailSender = entityManager.find(MailSender.class, id);

        return mailSender;
    }

    @Override
    public List<MailSender> findAll() {
        List<MailSender> mailSenders = entityManager.createQuery(
                "from MailSender").getResultList();
        return mailSenders;
    }

    @Override
    public void update(Long id, MailSender mailSender) {
        MailSender oldMailSender = findById(id);
        oldMailSender.setSender(mailSender.getSender());
        oldMailSender.setText(mailSender.getText());
        oldMailSender.setCreateDate(mailSender.getCreateDate());
        entityManager.persist(oldMailSender);
    }

    @Override
    public void deleteById(Long id) {
        MailSender mailSender = entityManager.find(MailSender.class, id);
        entityManager.remove(mailSender);

    }
}
