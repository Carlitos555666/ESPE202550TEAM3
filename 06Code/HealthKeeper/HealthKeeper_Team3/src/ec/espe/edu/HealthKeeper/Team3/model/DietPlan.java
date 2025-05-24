package ec.espe.edu.HealthKeeper.Team3.model;

/**
 *
 * @author Maria Quiroz
 */
public class DietPlan {
    private int calories;
    private String meals;
    private String restrictions;

    public DietPlan(int calories, String meals, String restrictions) {
        this.calories = calories;
        this.meals = meals;
        this.restrictions = restrictions;
    }

    public boolean updateDiet() {
        System.out.println("Dieta actualizada.");
        return true;
    }
}
