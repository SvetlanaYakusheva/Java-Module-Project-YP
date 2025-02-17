
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> carsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String name;
        int speed;

        for (int i = 0; i < 3; i++) {
                System.out.println("— Введите название машины №" + (i + 1) + ": ");
                //метод .next() не позволяет ввести пустое значение, поэтому проверка на пустой ввод не нужна
                name = scanner.next();

                System.out.println("— Введите скорость машины №" + (i + 1) + ":");
                while (true) {
                    if (scanner.hasNextInt()) { //проверка целочисленного ввода скорости
                        //метод .next() не позволяет ввести пустое значение, поэтому проверка на пустой ввод не нужна
                        speed = scanner.nextInt();
                        //проверка корректности ввода скорости - от 0 до 250 км/ч
                        if ((speed < 0) || (speed > 250)) {
                            System.out.println("Скорость введена неверно. Введите значение от 0 до 250: ");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Неверный формат скорости машины №" + (i + 1) + ". Введите целое число:");
                        scanner.next();
                    }
                }
                carsList.add(new Car(name, speed));
        }
        scanner.close();
        System.out.println("Самая быстрая машина: " + Race.getLeader(carsList).name);

    }
}
class Race {
    static int timeOfRace = 24; //продолжительность гонки константа = 24 часа

    public static Car getLeader(ArrayList<Car> carsList) {
        Car leader = new Car(null, 0);
        for (Car car : carsList) {
            //поиск лидера в условиях данной задачи можно просто по сравнению скорости.
            // но по условиям задачи нужно это сделать по пройденной дистанции, поэтому сравниваем дистанцию
            if (leader.getDistance(timeOfRace) < car.getDistance(timeOfRace)) {
                    leader = car;
            }
        }
        return leader;
    }
}

class Car {
    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public int getDistance(int timeOfRace) {
        return speed * timeOfRace;
    }

}
