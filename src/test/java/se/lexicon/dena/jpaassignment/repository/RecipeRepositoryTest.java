package se.lexicon.dena.jpaassignment.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.dena.jpaassignment.model.Ingredient;
import se.lexicon.dena.jpaassignment.model.Recipe;
import se.lexicon.dena.jpaassignment.model.RecipeIngredient;

import javax.transaction.Transactional;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository testObject;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private Recipe recipe;

    List<Recipe> recipeList =Arrays.asList(
            new Recipe("milkShake",Collections.emptyList(),Collections.emptyList()),//???
            new Recipe("cake"),
            new Recipe("bread")
            );





    @BeforeEach
    void setUp() {
        // recipe = testObject.save(new Recipe("milkShake"));
        Ingredient ingredient=new Ingredient("milk");
       Ingredient milkCreatedIngredient = ingredientRepository.save(ingredient);

        Recipe cake =new Recipe("vanilCake");

        RecipeIngredient recipeIngredient=new RecipeIngredient();
        recipeIngredient.setIngredient(milkCreatedIngredient);
        RecipeIngredient createdrecipeIngredient1=recipeIngredientRepository.save(recipeIngredient);

        List<RecipeIngredient> ingredientList=new ArrayList<>();
        ingredientList.add(createdrecipeIngredient1);

        cake.setRecipeIngredients(ingredientList);
        recipe=testObject.save(cake);

    }

    @Test
    void findAllByRecipeNameLike() {

       // Arrange
        String recipeName="cak%";
        Collection<Recipe> foundRecipe= new ArrayList<>();

        //Act
        foundRecipe=testObject.findAllByRecipeNameLike(recipeName);

        //Assert
        assertTrue(foundRecipe.contains(recipeList.get(1)));


    }

    @Test
    void findRecipesByRecipeIngredients_Ingredient_ingredientName() {
        // Arrange
        String ingredientName1="milk";

        Collection<Recipe> foundRecipe;

        //Act
       foundRecipe= testObject.findAllByRecipeIngredientsIs(ingredientName1);
        //Assert
        assertEquals(1,foundRecipe.size());//????
    }

    @Test
    void findRecipeByCategories_CategoryIgnoreCase() {
        // Arrange
         String categoryName="dessert";
         Collection<Recipe> foundRecipe=new ArrayList<>();

        //Act
        foundRecipe=testObject.findRecipeByCategories_CategoryIgnoreCase(categoryName);

        //Assert
        assertTrue(foundRecipe.contains(recipeList.get(0)));

    }

    @Test
    void findRecipeByCategories_CategoryIn() {
        // Arrange
        Collection<String> categoryNames=new HashSet<>();
        categoryNames.add("bread");
        categoryNames.add("dessert");

        Collection<Recipe> foundRecipe=new ArrayList<>();

        //Act
        foundRecipe=testObject.findRecipeByCategories_CategoryIn(categoryNames);

        //Assert
        assertTrue(foundRecipe.contains(recipeList.get(0)));
    }
}