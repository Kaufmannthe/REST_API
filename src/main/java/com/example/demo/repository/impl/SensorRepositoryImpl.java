package com.example.demo.repository.impl;

import com.example.demo.model.Sensor;
import com.example.demo.repository.SensorRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public void delete(Sensor sensor) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(sensor);
    }

    @Override
    public Sensor findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<?> query = session.createQuery("SELECT s FROM  Sensor s WHERE id=:id");
        query.setParameter("id", id);
        return (Sensor) query.getSingleResult();
    }
}
