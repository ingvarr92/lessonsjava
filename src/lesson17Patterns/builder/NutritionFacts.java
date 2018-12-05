package lesson17Patterns.builder;

public class NutritionFacts {
    private final int servings;
    private final int calories;
    private final int fat;

    private NutritionFacts(Builder builder){
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }


    public static class Builder{
        private final int servings;
        private  int calories = 0;
        private  int fat = 0;

        public Builder(int servings){
            this.servings = servings;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder setFat(int fat) {
            this.fat = fat;
            return  this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }



    public static void main(String[] args) {
        NutritionFacts prod1 = new Builder(10).setCalories(456).setFat(40).build();

        NutritionFacts prod2 = new Builder(2).setCalories(567).setFat(89).build();
    }
}
