import autoShop.AutoShop;
import car.CarAudi;
import enums.ColorForAudi;
import enums.ModelForAudi;
import enums.VolumeOfEngineForAudi;
import enums.WheelSizeForAudi;
import factory.StorageForAudi;
import factory.StorageForBMW;
import factory.StorageForMersedes;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;

import static java.lang.Runtime.getRuntime;

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
                    System.out.println(autoShop.orderCar(reader, true));
                    break;
                case 2:
                    System.out.println(autoShop.orderCar(reader, false));
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
