import autoShop.AutoShop;
import car.Car;

import java.io.BufferedReader;
import java.io.IOException;

public class Menu {
    private static final String MESSAGE_IF_ERROR = "Error";
    private static final String MESSAGE_IF_DATA_WRONG = "The information entered incorrectly. Try again";
    private final AutoShop autoShop;

    public Menu(AutoShop autoShop) {
        this.autoShop =  autoShop;
    }

    public  void start(BufferedReader reader) {
        boolean trueOrFalse = true;
        while (trueOrFalse) {
            switch (menuOrderOrFix(reader)) {
                case 1:
                    Car car = autoShop.orderCar1(reader);
                    if (car == null) {
                        System.err.println(MESSAGE_IF_ERROR);
                    } else {
                        System.out.println(car);
                    }
                    break;
                case 2:
                    Car car1 = autoShop.enterCar(reader);
                    if (car1 == null) {
                        System.err.println(MESSAGE_IF_ERROR);
                    }
                    boolean trueOrFalse1 = true;
                    while (trueOrFalse1) {
                        switch (menuRepairCar(reader)) {
                            case 1:
                                car1 = autoShop.changeColor(car1, reader);
                                break;
                            case 2:
                                if (car1 != null) {
                                    car1 = autoShop.changeWheelSize(car1, reader);
                                } else {
                                    System.err.println(MESSAGE_IF_ERROR);
                                }
                                break;
                            case 3:
                                if (car1 != null) {
                                    car1 = autoShop.changeOptions(car1, reader);
                                } else {
                                    System.err.println(MESSAGE_IF_ERROR);
                                }
                                break;
                            case 4:
                                trueOrFalse1 = false;
                        }
                    }
                    break;
                case 3 :
                    trueOrFalse = false;
            }
        }
    }

    public static void catchError() {
        System.out.println(MESSAGE_IF_ERROR);
        System.exit(0);
    }

    private static int menuRepairCar(BufferedReader reader) {
        System.out.println("1. Change color");
        System.out.println("2. Change wheel size");
        System.out.println("3. Change options");
        System.out.println("4. Back");
        System.out.println("Enter from 1 to 4");
        while (true) {
            try {
                try {
                    int count = Integer.parseInt(reader.readLine());
                    if (count == 1 || count == 2 || count == 3 || count == 4) {
                        return count;
                    } else {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            } catch (IOException e) {
                catchError();
            }
        }
    }

    private static int menuOrderOrFix(BufferedReader reader) {
        System.out.println("1. Order a car");
        System.out.println("2. Give the car for repair");
        System.out.println("3. Exit");
        System.out.println("Enter from 1 to 3");
        while (true) {
            try {
                try {
                    int count = Integer.parseInt(reader.readLine());
                    if (count == 1 || count == 2 || count == 3) {
                        return count;
                    } else {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            } catch (IOException e) {
                catchError();
            }
        }
    }
}
