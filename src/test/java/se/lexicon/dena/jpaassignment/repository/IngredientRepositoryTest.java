package se.lexicon.dena.jpaassignment.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.dena.jpaassignment.model.Ingredient;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository testObject;

    @Autowired
    private TestEntityManager testEntityManager;

    private Ingredient ingredient;

    List<Ingredient> ingredientList= Arrays.asList(
            new Ingredient("milk"),
            new Ingredient("egg"),
            new Ingredient("flour")
    );

    @BeforeEach
    void setUp() {
        // ingredient =testObject.save(new Ingredient("milk"));

        ingredient=testObject.save(ingredientList.get(0));
        testObject.save(ingredientList.get(1));
        testObject.save(ingredientList.get(2));

    }

    @Test
    void findIngredientByIngredientName() {

        // Arrange
        String ingredientName="milk";
        Collection<Ingredient> foundIngredient=new HashSet<>();


        //Act, goal
        foundIngredient= testObject.findIngredientByIngredientName(ingredientName);

        //Assert
        assertTrue(foundIngredient.contains(ingredient));
        assertTrue(foundIngredient.size()!=0);



    }

    @Test
    void findIngredientByIngredientNameLike() {
        // Arrange
        String ingredientName="%ilk";
        Collection<Ingredient> foundIngredient=new HashSet<>();

        //Act
        foundIngredient= testObject.findIngredientByIngredientNameLike(ingredientName);

        //Assert
        assertTrue(foundIngredient.contains(ingredientList.get(0)));
        //assertEquals("milk",foundIngredient);??
    }
}