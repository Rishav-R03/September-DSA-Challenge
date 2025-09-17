import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

public class FoodRatingSystem {
    static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    private Map<String, Food> foodMap; // food name -> Food object
    public Map<String, PriorityQueue<Food>> cusineToMaxHeap;

    public FoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cusineToMaxHeap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);
            cusineToMaxHeap
                    .computeIfAbsent(cuisines[i], k -> new PriorityQueue<>((a, b) -> {
                        if (b.rating != a.rating) {
                            return b.rating - a.rating;// max heap by rating
                        }
                        return a.name.compareTo(b.name);
                    }))
                    .add(food);

        }
    }

    public void changeRating(String foodName, int newRating) {
        Food oldFood = foodMap.get(foodName);
        Food newFood = new Food(foodName, oldFood.cuisine, newRating);
        foodMap.put(foodName, newFood);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Food top = pq.peek();
            Food latest = foodMap.get(top.name);
            if (top.rating == latest.rating) {
                return top.name;
            } else {
                pq.poll();// stale entry, discard
            }
        }
        return "";
    }
}
