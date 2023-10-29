package peaksoft.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.model.Genre;
import peaksoft.service.ModelService;

import java.util.List;

@Service
@Transactional
public class GenreService implements ModelService<Genre> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Genre genre) {
        entityManager.persist(genre);

    }

    @Override
    public Genre findById(Long id) {
        Genre genre = entityManager.find(Genre.class, id);

        return genre;
    }

    @Override
    public List<Genre> findAll() {
        List<Genre> genres =
                entityManager.createQuery(
                        "from Genre").getResultList();

        return genres;
    }

    @Override
    public void update(Long id, Genre genre) {
        Genre oldGenre = findById(id);
        oldGenre.setName(genre.getName());
        oldGenre.setDescription(genre.getDescription());
        oldGenre.setCreateDate(genre.getCreateDate());
        entityManager.persist(oldGenre);

    }

    @Override
    public void deleteById(Long id) {
        Genre genre = entityManager.find(Genre.class, id);
        entityManager.remove(genre);

    }
}
