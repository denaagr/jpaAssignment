package se.lexicon.dena.jpaassignment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
    private List<RecipeIngredient> recipeIngredients;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructionId")
    private RecipeInstruction instruction;


    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable(name="recipe_recipe_recipeCategory",joinColumns = @JoinColumn(name="recipe_id"),inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<RecipeCategory> category;

    //Convenience Method
    public void addRecipeCategory(RecipeCategory recipeCategory){
        category.add(recipeCategory);
        recipeCategory.getRecipes().add(this);
    }
    //Convenience Method
    public void removeRecipeCategory(RecipeCategory recipeCategory){
       category.remove(recipeCategory);
       recipeCategory.getRecipes().remove(this);
    }

    public Recipe() {
    }


    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategory() {
        return category;
    }

    public void setCategory(List<RecipeCategory> category) {
        this.category = category;
    }
}
