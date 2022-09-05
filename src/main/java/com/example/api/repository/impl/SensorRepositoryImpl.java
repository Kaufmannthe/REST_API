package com.example.api.repository.impl;

import com.example.api.model.Sensor;
import com.example.api.repository.SensorRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository

public class SensorRepositoryImpl implements SensorRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public SensorRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Sensor> allSensors() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Sensor ", Sensor.class).list();
    }

    @Override
    public void update(Sensor sensor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sensor);

    }

    @Override
    public void save(Sensor sensor) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sensor);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Sensor sensor = findById(id);
        session.delete(sensor);
        session.flush();
    }

    @Override
    public Sensor findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<?> query = session.createQuery("SELECT s FROM  Sensor s WHERE id=:id");
        query.setParameter("id", id);
        return (Sensor) query.getSingleResult();
    }

    @Override
    public List search(String text) {       // Hibernate Search
        EntityManager entityManager = sessionFactory.createEntityManager();

        FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Sensor.class)
                .get();

        org.apache.lucene.search.Query query = queryBuilder
                .keyword()
                .fuzzy()
                .withEditDistanceUpTo(2)
                .withPrefixLength(0)
                .onFields("sensor_id", "title", "model", "location", "description")
                .matching(text)
                .createQuery();

        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Sensor.class);
        List result = jpaQuery.getResultList();
        return result;
    }

}
