package se.lexicon.dena.jpaassignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.dena.jpaassignment.model.RecipeInstruction;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction,String> {
}
