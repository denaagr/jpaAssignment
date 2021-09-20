package se.lexicon.dena.jpaassignment.data;

import se.lexicon.dena.jpaassignment.model.Ingredient;
import se.lexicon.dena.jpaassignment.model.RecipeCategory;

import java.util.Collection;

public interface RecipeCategoryDao {
    RecipeCategory findById(int categoryId);
    Collection<RecipeCategory> findAll();
    RecipeCategory create(RecipeCategory recipeCategory);
    RecipeCategory update(RecipeCategory recipeCategory);
    void delete(int categoryId);
}
