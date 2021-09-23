package se.lexicon.dena.jpaassignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.dena.jpaassignment.model.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {

    List<Ingredient> findIngredientByIngredientName(String ingredientName);
    List<Ingredient> findIngredientByIngredientNameLike(String ingredientName);


}
