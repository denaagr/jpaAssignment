package se.lexicon.dena.jpaassignment.model;

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
    private List<RecipeCategory> categories;

    //Convenience Method
    public void addRecipeCategory(RecipeCategory recipeCategory){
        categories.add(recipeCategory);
        recipeCategory.getRecipes().add(this);
    }
    //Convenience Method
    public void removeRecipeCategory(RecipeCategory recipeCategory){
       categories.remove(recipeCategory);
       recipeCategory.getRecipes().remove(this);
    }

    public Recipe() {
    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
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

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> category) {
        this.categories = category;
    }
}
