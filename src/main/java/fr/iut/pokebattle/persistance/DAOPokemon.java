package fr.iut.pokebattle.persistance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DAOPokemon {
	private EntityManager entityManager;

    public DAOPokemon(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public PokeStats insert(PokeStats obj) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(obj);
        tx.commit();
        return entityManager.find(PokeStats.class, obj.getName());
    }

    public PokeStats getById(String id) {
        return entityManager.find(PokeStats.class, id);
    }
    
    public boolean update(PokeStats obj) {
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
