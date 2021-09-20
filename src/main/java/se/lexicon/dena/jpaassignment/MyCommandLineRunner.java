package se.lexicon.dena.jpaassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.dena.jpaassignment.model.Ingredient;
import se.lexicon.dena.jpaassignment.repository.IngredientRepository;

@Component   //Bean
public class MyCommandLineRunner implements CommandLineRunner {

    //Repository is a bean so we inject it here
    IngredientRepository ingredientRepository;

    @Autowired  //Constructor injection(injecting bean)
    public MyCommandLineRunner(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Ingredient ingredient=new Ingredient("flour");
        //access our ingredientRepository
        ingredient=ingredientRepository.save(ingredient);



    }


}
