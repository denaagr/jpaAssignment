package se.lexicon.dena.jpaassignment.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.dena.jpaassignment.model.Ingredient;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class IngredientDaoRepository implements IngredientDao{

    private EntityManager em;
    @Autowired
    public IngredientDaoRepository(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional
    public Ingredient findById(int ingredientId) {
        return em.find(Ingredient.class,ingredientId);
    }

    @Override
    @Transactional
    public Collection<Ingredient> findAll() {
        List<Ingredient> foundAll = new ArrayList<>();
        foundAll = em.createQuery("Select a From Ingredient a", Ingredient.class).getResultList();
        return foundAll;
    }

    @Override
    @Transactional
    public Ingredient create(Ingredient ingredient) {
        em.persist(ingredient);
        return ingredient;
    }

    @Override
    @Transactional
    public Ingredient update(Ingredient ingredient) {
        return em.merge(ingredient);
    }

    @Override
    @Transactional
    public void delete(int ingredientId) {
        Ingredient toRemove = findById(ingredientId);
        if(toRemove != null){
            em.remove(toRemove);
        }else {
            throw new IllegalArgumentException("Ingredient could not be found");
        }

    }
}
