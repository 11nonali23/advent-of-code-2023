package questions;

import java.util.List;
import java.util.Map;

public class Question2 {
    private final static Map<String, Integer> bag = Map.of(
            "red", 12,
            "green", 13,
            "blue", 14
    );

    public static Integer getValidGamesCount() {
        List<List<Pair<Integer, String>>> gamesAsPairs = games.stream()
                .map(Question2::getGrabbedCubesList)
                .map(Question2::getGrabbedCubes)
                .toList();
        List<List<Pair<Integer, String>>> validGames = gamesAsPairs.stream()
                .filter(Question2::isGameValid)
                .toList();
        return validGames.stream()
                .map(validGame -> gamesAsPairs.indexOf(validGame) + 1)
                .reduce(Integer::sum)
                .orElse(Integer.MIN_VALUE);
    }

    private static List<String> getGrabbedCubesList(String game) {
        return List.of(game.split(", "));
    }

    private static List<Pair<Integer, String>> getGrabbedCubes(List<String> game) {
        return game.stream()
                .map(grabbedCube -> grabbedCube.split(" "))
                .map(grabbedCube -> new Pair<>(Integer.parseInt(grabbedCube[0]), grabbedCube[1]))
                .toList();
    }

    private static boolean isGameValid(List<Pair<Integer, String>> grabbedCubes) {
        return grabbedCubes.stream().allMatch(Question2::isAmountValid);
    }

    private static boolean isAmountValid(Pair<Integer, String> grabbedCube) {
        return grabbedCube.amount <= bag.get(grabbedCube.color);
    }

    private static final List<String> games = List.of(
            "1 green, 2 red, 6 blue, 4 red, 1 green, 3 blue, 7 blue, 5 green, 6 blue, 2 red, 1 green",
            "1 green, 17 red, 1 blue, 6 red, 7 green, 2 blue, 4 red, 7 green, 1 green, 6 red, 2 blue",
            "6 red, 15 blue, 15 green, 1 green, 4 red, 12 blue, 14 blue, 9 red, 1 green, 2 red, 15 blue, 12 green",
            "8 green, 10 blue, 6 red, 20 blue, 4 red, 17 blue, 2 green, 3 red, 4 blue, 2 green, 3 red, 10 red, 3 blue, 3 green, 5 green, 14 blue, 6 red",
            "3 green, 8 blue, 2 red, 11 red, 6 green, 11 blue, 8 red, 5 blue, 2 green",
            "2 blue, 12 red, 2 green, 3 green, 2 red, 3 green, 3 blue, 10 red, 7 red, 2 blue, 4 green, 1 red, 2 blue, 5 green",
            "1 red, 8 blue, 2 green, 1 red, 2 blue, 12 green, 1 blue, 3 blue, 3 green",
            "10 green, 4 red, 4 blue, 12 green, 1 blue, 1 red, 13 green, 2 blue, 12 green, 3 blue, 9 green, 7 red",
            "1 green, 1 blue, 3 red, 3 blue, 3 red, 8 green, 6 blue, 4 red, 6 green, 2 red, 7 green, 1 red, 10 green, 13 blue, 5 red, 1 blue, 1 green",
            "9 green, 3 red, 3 blue, 12 green, 2 blue, 18 green, 1 blue, 14 green, 2 blue, 9 green, 2 red",
            "14 green, 2 green, 2 red, 11 blue, 9 blue, 3 green",
            "9 green, 3 blue, 8 red, 1 green, 2 blue, 3 red, 4 blue, 8 red, 10 green, 3 blue, 7 red, 8 green, 3 blue, 5 red, 7 green, 2 blue, 5 green",
            "6 red, 1 blue, 10 green, 7 red, 1 green, 8 red, 2 green, 1 blue",
            "2 red, 4 blue, 2 green, 2 green, 5 red, 1 blue, 1 red, 6 blue",
            "7 blue, 3 red, 13 blue, 8 red, 1 green, 1 green, 5 red, 13 blue, 8 red, 5 blue, 4 red, 3 blue, 1 green, 12 blue, 8 red, 1 green",
            "5 blue, 1 green, 2 red, 2 blue, 20 green, 4 blue, 1 red, 17 green, 10 green, 5 blue, 2 red",
            "6 red, 13 blue, 8 green, 12 blue, 7 green, 9 red, 19 blue, 5 red, 2 green, 8 red, 14 blue",
            "5 red, 2 green, 1 blue, 8 blue, 17 red, 9 green, 2 blue, 1 green, 4 blue, 10 red, 5 blue, 4 red, 6 green",
            "5 red, 12 green, 8 red, 13 green, 1 blue, 1 red, 1 green, 3 blue, 5 green, 5 red",
            "11 red, 8 blue, 9 red, 2 green, 13 blue, 2 red, 1 green, 2 blue, 1 green, 9 blue, 13 red, 3 blue, 5 red, 1 green",
            "1 red, 4 green, 11 blue, 3 green, 15 blue, 6 green, 7 red, 14 blue, 15 blue, 6 green, 10 red, 6 red, 16 blue, 2 green",
            "2 blue, 15 green, 2 red, 3 blue, 6 green, 1 red, 2 blue, 5 green, 1 red, 6 green, 2 red, 2 blue, 4 green, 2 blue, 4 blue, 1 red, 15 green",
            "2 blue, 1 green, 12 red, 5 blue, 11 red, 4 green, 12 red, 4 blue, 12 red, 2 green, 5 blue",
            "4 blue, 7 red, 3 red, 3 blue, 1 red, 4 blue, 2 green, 6 red, 6 blue, 7 red, 1 green, 2 blue, 6 red, 1 blue, 1 green",
            "5 green, 9 blue, 6 green, 7 red, 2 blue, 1 red, 3 blue, 7 green, 9 blue, 3 red, 5 green, 9 blue, 2 red",
            "6 red, 4 blue, 2 blue, 4 green, 3 green, 5 red, 5 blue, 4 green, 6 red, 3 blue, 4 green, 7 red, 4 blue",
            "15 green, 1 blue, 12 red, 12 red, 1 green, 1 red, 1 blue, 5 green, 13 green, 6 red, 1 blue, 5 red, 1 blue, 1 green, 11 red, 14 green",
            "3 blue, 2 green, 10 red, 5 blue, 2 green, 4 green, 3 blue, 11 red",
            "10 blue, 2 red, 17 green, 7 blue, 2 red, 1 blue, 8 green, 1 red, 10 green, 2 red, 3 blue",
            "10 green, 8 red, 1 blue, 4 blue, 7 green, 14 red, 2 blue, 14 red, 11 green, 1 blue, 13 green, 12 red, 5 blue, 2 red, 4 green, 4 green, 5 red",
            "4 green, 11 red, 11 blue, 3 blue, 11 red, 5 blue, 7 red, 3 green, 10 blue, 5 green, 1 red",
            "4 red, 8 blue, 1 green, 14 red, 7 blue, 4 green, 13 red, 3 blue, 9 green, 3 red, 1 green, 8 blue, 8 green, 8 red, 5 blue",
            "6 red, 10 blue, 7 green, 19 blue, 1 red, 6 green, 11 red, 11 blue, 2 green, 2 blue, 12 red, 3 red, 13 blue, 7 green, 6 green, 4 red, 2 blue",
            "3 red, 3 green, 15 blue, 7 green, 15 blue, 3 red, 2 green, 8 blue, 19 green, 18 blue",
            "2 green, 1 blue, 2 green, 2 blue, 1 red, 3 blue, 1 red, 1 green, 4 blue, 1 red",
            "1 red, 11 green, 1 green, 1 blue, 8 blue, 2 green, 3 red, 1 red",
            "4 blue, 3 red, 12 blue, 13 red, 2 red, 2 green, 8 blue",
            "8 red, 2 blue, 1 green, 2 red, 8 red, 2 green, 1 blue, 16 red, 2 green, 7 red, 2 blue, 2 green",
            "6 green, 1 blue, 5 red, 14 green, 8 blue, 6 red, 8 red, 10 blue, 1 green, 14 green, 9 red, 17 blue, 5 red, 1 blue, 7 green, 1 red",
            "4 red, 8 blue, 3 green, 13 blue, 1 red, 3 blue, 7 red, 3 green, 3 green, 8 blue, 10 red, 3 green, 20 blue, 5 red",
            "1 blue, 2 green, 11 green, 2 blue, 5 blue, 15 red, 8 green, 5 blue",
            "1 green, 12 blue, 1 red, 6 blue, 1 green, 5 red, 1 red, 11 blue, 4 green, 3 red, 17 blue, 1 green, 1 red, 11 blue, 9 blue, 6 green, 3 red",
            "16 blue, 13 green, 1 red, 17 blue, 7 red, 10 green, 13 green, 5 red, 7 blue",
            "2 blue, 4 red, 15 green, 7 red, 2 green, 1 blue, 6 red, 13 green",
            "5 green, 1 blue, 8 red, 4 red, 1 blue, 5 green, 1 green, 3 red, 1 green, 2 blue, 6 red, 4 red, 3 green, 2 blue, 2 red, 2 blue, 5 green",
            "1 green, 1 red, 6 blue, 11 blue, 1 red, 1 green, 7 blue, 8 blue, 1 green, 7 blue, 2 red",
            "7 green, 9 blue, 7 red, 11 red, 13 blue, 5 green, 12 green, 12 blue, 5 red, 4 blue, 8 green, 7 red",
            "11 green, 7 red, 2 blue, 2 blue, 10 green, 3 red, 1 blue, 2 red, 1 green, 4 green, 2 red, 7 blue, 7 red, 4 green, 2 blue",
            "1 red, 2 blue, 5 green, 2 green, 4 blue, 5 blue, 2 green, 1 red, 9 blue, 1 green, 7 blue",
            "8 green, 9 blue, 2 red, 2 green, 5 blue, 14 green, 1 red, 8 blue",
            "1 green, 2 blue, 12 blue, 1 red, 2 blue",
            "3 red, 2 blue, 2 green, 4 red, 4 green, 7 blue, 2 blue, 4 red, 1 green, 3 green, 1 red, 9 green, 7 blue",
            "9 blue, 12 red, 7 green, 8 blue, 6 green, 1 green, 8 blue, 9 red, 12 red, 6 green, 9 blue, 14 red, 10 green, 7 red, 3 green, 5 blue",
            "8 green, 5 blue, 5 red, 4 green, 13 blue, 2 red, 2 blue, 5 red, 1 green, 3 red, 3 green, 10 blue",
            "17 red, 15 green, 17 blue, 6 red, 5 green, 7 blue, 17 green, 6 blue, 5 red",
            "7 blue, 6 red, 7 green, 10 green, 3 red, 9 red, 3 blue, 5 green",
            "5 blue, 11 red, 1 green, 13 red, 1 green, 2 blue, 2 blue, 4 red, 1 green, 10 red, 1 blue, 1 green, 8 red",
            "1 red, 2 green, 9 blue, 1 green, 1 blue, 1 red, 2 red, 6 blue, 2 green, 14 blue, 1 green, 1 red, 5 blue, 1 red, 2 green, 14 blue, 2 green",
            "9 green, 2 blue, 5 red, 9 red, 5 green, 10 red, 1 blue, 8 green",
            "8 blue, 6 red, 4 green, 3 red, 12 green, 9 blue, 4 blue, 5 red, 5 green, 4 red, 8 blue, 7 green, 12 blue, 6 red",
            "5 blue, 13 red, 1 green, 5 red, 5 blue, 1 red, 3 blue, 1 green, 9 red, 10 red, 3 blue, 1 green",
            "1 blue, 13 red, 4 blue, 5 red, 11 blue, 8 red, 1 green",
            "14 blue, 5 red, 9 blue, 14 green, 5 red, 3 red, 8 green, 15 blue, 4 blue, 15 green, 6 red",
            "13 red, 6 blue, 11 green, 12 red, 1 blue, 8 green, 1 red, 17 green, 13 red, 12 green, 7 blue",
            "4 red, 17 blue, 3 green, 2 green, 12 blue, 9 red, 2 green, 17 blue, 5 red, 1 red, 1 green, 4 blue, 9 red, 16 blue, 7 blue, 9 red",
            "10 blue, 10 green, 5 red, 10 green, 3 blue, 5 red, 1 red, 1 green, 10 blue, 2 green, 5 red, 20 blue, 8 blue, 11 green, 13 red, 2 green, 18 blue, 2 red",
            "6 red, 1 green, 5 red, 10 blue, 6 blue, 6 red",
            "4 green, 1 red, 5 blue, 5 red, 5 blue, 7 red, 6 green, 8 red, 1 blue",
            "2 blue, 11 red, 4 red, 6 green, 1 blue, 4 red, 1 blue, 14 green",
            "15 red, 8 blue, 5 green, 5 green, 2 red, 8 blue, 8 red, 3 green, 10 blue",
            "4 blue, 2 red, 12 green, 4 blue, 10 green",
            "3 blue, 4 green, 6 red, 6 red, 5 green, 8 blue, 10 red, 6 green, 5 blue, 1 green, 2 blue, 10 red, 5 blue, 4 green",
            "5 blue, 1 red, 1 green, 11 blue, 10 blue, 12 blue, 1 red, 1 red, 9 blue, 7 blue, 1 green, 1 red",
            "7 green, 6 blue, 7 red, 7 blue, 6 green, 15 red, 7 red, 5 blue, 1 green, 1 blue, 6 red, 8 green, 8 green, 14 red, 3 blue",
            "8 green, 3 red, 3 blue, 1 blue, 6 red, 7 green, 9 green, 3 blue, 3 blue, 9 green, 6 red, 4 blue, 1 red, 3 green, 4 green, 1 blue, 16 red",
            "4 blue, 3 green, 2 blue, 1 red, 6 green, 12 blue, 1 green, 14 blue",
            "5 green, 10 red, 11 blue, 3 red, 8 green, 6 red, 9 blue",
            "7 red, 7 green, 8 blue, 6 green, 7 red, 5 blue",
            "11 blue, 2 red, 4 green, 2 green, 3 red, 15 blue, 1 green, 15 blue, 1 red",
            "3 red, 17 green, 8 blue, 8 green, 10 blue, 4 green, 1 red, 14 blue",
            "17 green, 10 red, 10 blue, 9 green, 9 blue, 7 red, 11 red, 11 green, 4 blue, 15 blue, 5 red, 11 blue, 8 green, 15 red, 3 green, 16 red",
            "8 green, 9 blue, 1 red, 1 red, 8 green, 9 blue, 2 green, 12 blue",
            "2 green, 11 red, 20 blue, 20 blue, 1 green, 4 red, 2 green, 6 red, 20 blue, 17 blue, 10 red",
            "1 green, 9 red, 4 blue, 4 green, 1 green, 6 red, 14 blue",
            "5 red, 10 green, 9 blue, 8 blue, 3 green, 2 red, 4 blue, 14 green, 3 red, 5 red, 4 blue",
            "8 blue, 9 green, 5 red, 5 red, 10 green, 1 blue, 15 blue, 1 red, 2 green, 8 red, 8 blue, 10 green",
            "13 green, 2 red, 4 blue, 3 red, 11 green, 9 blue, 6 blue, 3 red, 12 green",
            "2 red, 7 blue, 3 green, 2 blue, 9 red, 9 red, 6 blue, 7 green, 6 green, 13 blue, 9 red, 6 green, 2 red, 15 blue, 1 red, 8 green, 7 blue",
            "11 red, 1 blue, 2 green, 6 blue, 5 green, 4 red, 15 red, 4 green, 5 blue, 11 red, 3 blue, 10 green, 6 blue, 13 green, 12 red",
            "2 red, 2 blue, 4 green, 2 red, 2 blue, 9 green, 1 red, 1 blue, 5 green, 1 red, 7 green, 2 red, 2 green, 1 blue",
            "5 blue, 3 red, 1 green, 1 red, 4 blue, 6 green, 6 blue, 6 green, 5 red",
            "16 green, 1 blue, 12 red, 18 green, 14 red, 1 blue, 16 red, 1 green, 4 blue, 16 red, 18 green",
            "9 red, 8 blue, 14 green, 1 blue, 1 green, 6 red, 4 blue, 4 red, 14 green",
            "11 green, 4 blue, 2 red, 1 red, 1 green, 1 blue, 4 red, 1 blue, 2 green",
            "5 blue, 2 red, 9 green, 5 blue, 8 green, 1 green, 15 blue, 5 red, 9 green, 5 blue, 3 green, 17 blue, 5 red",
            "2 green, 14 blue, 1 red, 3 green, 3 red, 14 blue, 2 red, 2 green, 13 blue",
            "2 green, 2 red, 2 blue, 1 green, 7 blue, 3 red",
            "2 red, 1 blue, 12 green, 2 blue, 10 green, 5 red, 11 green, 9 blue, 6 blue, 17 green, 7 blue, 9 green, 9 red, 1 red, 11 green, 9 blue",
            "2 green, 9 red, 1 blue, 3 green, 1 blue, 14 red, 5 green, 6 blue, 1 blue, 2 green, 3 red, 4 blue, 10 red, 1 green",
            "4 green, 4 blue, 15 red, 3 green, 1 red, 13 blue, 5 green, 5 blue, 10 red"
    );

    public static class Pair<K, V> {
        private final K amount;
        private final V color;

        public Pair(K amount, V color) {
            this.amount = amount;
            this.color = color;
        }

        public K getAmount() {
            return amount;
        }

        public V getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "(" + amount + ", " + color + ")";
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Pair<?, ?>)) return false;
            return ((Pair<?, ?>) other).amount.equals(amount) && ((Pair<?, ?>) other).color.equals(color);
        }
    }
}