package se.lexicon.dena.jpaassignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.dena.jpaassignment.model.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient,String> {


}
