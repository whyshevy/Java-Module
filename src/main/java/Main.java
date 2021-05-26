import java.awt.*;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        System.out.print("Введіть кількість об'єктів - ");
        int numOfPoint = inputIntTypeWithScanner();
        Point[] point = setRandom(numOfPoint);
        Set<Point> mySet = new HashSet<>();

        for (int i = 0; i < numOfPoint; i++) {
            mySet.add(point[i]);
        }

        System.out.print("Значення точок - ");
        System.out.println(mySet.toString());
        proccesing(mySet);
    }


    public static Point[] setRandom(int n) {
        Point[] point = new Point[n];
        for (int j = 0; j < n; j++) {
            int varX = (int) (Math.random() * 20);
            int varY = (int) (Math.random() * 20);
            point[j] = new Point(varX, varY);
        }
        return point;
    }

    public static void proccesing(Set<Point> points) {
        if (points.isEmpty()) return;

        Map<Point, Double> pointsAndDistances =
                points.stream().collect(Collectors.toMap(x -> x, x -> calculateDistances(points, x)));

        Map.Entry<Point, Double> minEntry = Collections.min(pointsAndDistances.entrySet(),
                Map.Entry.comparingByValue());

        System.out.println("Точка з мінімальною відстанню - " + minEntry.getKey());
    }

    public static double calculateDistances(Set<Point> points, Point point) {
        double sum = 0;
        for (var somePoint: points) {
            if (somePoint != point) sum += point.distance(somePoint);
        }
        return sum;
    }

    public static int inputIntTypeWithScanner() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Спробуйте ще раз");
            scanner.next();
        }
        return scanner.nextInt();
    }
}