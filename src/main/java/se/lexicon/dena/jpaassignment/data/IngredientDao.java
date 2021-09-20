package se.lexicon.dena.jpaassignment.data;

import se.lexicon.dena.jpaassignment.model.Ingredient;

import java.util.Collection;

public interface IngredientDao {
    Ingredient findById(int ingredientId);
    Collection<Ingredient> findAll();
    Ingredient create(Ingredient ingredient);
    Ingredient update(Ingredient ingredient);
    void delete(int ingredientId);
}
