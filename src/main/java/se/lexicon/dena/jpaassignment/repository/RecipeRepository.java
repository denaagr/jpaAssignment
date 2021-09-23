package se.lexicon.dena.jpaassignment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.dena.jpaassignment.model.Ingredient;
import se.lexicon.dena.jpaassignment.model.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe,Integer> {

//    @Query("SELECT r from Recipe r where r.recipeName like ('%,:name,%')")
//    Collection<Recipe> findByRecipeName(String RecipeName);

    //num 1
    Collection<Recipe> findAllByRecipeNameLike( String name);

//    //num 2
//    @Query("SELECT i FROM Recipe i JOIN FETCH i.recipeIngredients as item WHERE UPPER(item.ingredient.ingredientName )=UPPER(:name)")
//    Collection<Recipe> findAllByRecipeIngredientsIs (@Param("ingredientName") String name);

    //num 2
    Collection<Recipe> findRecipesByRecipeIngredients_Ingredient_ingredientNameIn(Collection<String> name);


//    //num3
//    @Query("select r from Recipe r JOIN FETCH r.categories as item where UPPER(item.category) = UPPER(:name)")  //??
//    Collection<Recipe> findRecipeByCategory(@Param("category") String name);
    //num3
    Collection<Recipe> findRecipeByCategories_CategoryIgnoreCase(String category);


    //num4
    Collection<Recipe> findRecipeByCategories_CategoryIn(Collection<String> category);







}
