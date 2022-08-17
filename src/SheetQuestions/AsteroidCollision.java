package SheetQuestions;

import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> storeAsteroids = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                while (!storeAsteroids.isEmpty() && storeAsteroids.peek() > 0 && storeAsteroids.peek() < Math.abs(asteroid)) {
                    storeAsteroids.pop();
                }
                if (!storeAsteroids.isEmpty() && storeAsteroids.peek() > 0) {
                    if (storeAsteroids.peek() == Math.abs(asteroid)) {
                        storeAsteroids.pop();
                    }

                } else {
                    storeAsteroids.push(asteroid);
                }

            } else {
                storeAsteroids.push(asteroid);
            }
        }
        int[] result = new int[storeAsteroids.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = storeAsteroids.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision as = new AsteroidCollision();
        int[] input = new int[]{10, 2, -5};
        System.out.println(as.asteroidCollision(input));
    }
}

