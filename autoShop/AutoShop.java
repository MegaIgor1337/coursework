package autoShop;
import car.Car;
import car.CarAudi;
import car.CarBMW;
import car.CarMersedes;
import com.sun.security.jgss.GSSUtil;
import enums.*;
import factory.*;
import interfaces.Option;
import service.ServiceToChangeColor;
import service.ServiceToChangeOptions;
import service.ServiceToChangeWheels;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class AutoShop {

    private static final String MESSAGE_IF_ERROR = "Error";
    private static final String MESSAGE_IF_DATA_WRONG = "The information entered incorrectly. Try again";
    private static final String AUDI = "AUDI";
    private static final String MERSEDES = "MERSEDES";
    private static final String BMW = "BMW";
    private static final String STOP = "STOP";
    private final FactoryForBMW factoryForBMW;
    private final FactoryForMersedes factoryForMersedes;
    private final FactoryForAudi factoryForAudi;


    private final ServiceToChangeColor serviceToChangeColor;
    private final ServiceToChangeWheels serviceToChangeWheels;
    private final ServiceToChangeOptions serviceToChangeOptions;

    public AutoShop(FactoryForBMW factoryForBMW, FactoryForMersedes factoryForMersedes, FactoryForAudi factoryForAudi, ServiceToChangeColor serviceToChangeColor, ServiceToChangeWheels serviceToChangeWheels, ServiceToChangeOptions serviceToChangeOptions) {
        this.factoryForBMW = factoryForBMW;
        this.factoryForMersedes = factoryForMersedes;
        this.factoryForAudi = factoryForAudi;
        this.serviceToChangeColor = serviceToChangeColor;
        this.serviceToChangeWheels = serviceToChangeWheels;
        this.serviceToChangeOptions = serviceToChangeOptions;
    }

    public Car orderCar(BufferedReader reader, boolean check) {
        String name;
        while (true) {
            name = enterName(reader);
            if (name.equalsIgnoreCase(AUDI) || name.equalsIgnoreCase(MERSEDES) || name.equalsIgnoreCase(BMW)){
                break;
            } else {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
        if (name.equalsIgnoreCase(AUDI)) {
            String model = null;
            String color = null;
            String volumeOfEngine = null;
            int year;
            String wheelSize = null;
            OptionForAudi[] optionsForAudi;
            String countOfDoors = null;
            boolean trueOrFalse1 = true;
            while (trueOrFalse1) {
                factoryForAudi.printAvailableModels();
                model = enterModel(reader);
                try {
                    ModelForAudi.valueOf(model.toUpperCase());
                    trueOrFalse1 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            boolean trueOrFalse2 = true;
            while (trueOrFalse2) {
                factoryForAudi.printAvailableColors();
                color = enterColor(reader);
                try {
                    ColorForAudi.valueOf(color.toUpperCase());
                    trueOrFalse2 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            boolean trueOrFalse3 = true;
            while (trueOrFalse3) {
                factoryForAudi.printAvailableVolumes();
                volumeOfEngine = enterVolumeOfEngine(reader);
                try {
                    VolumeOfEngineForAudi.valueOf(volumeOfEngine.toUpperCase());
                    trueOrFalse3 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            boolean trueOrFalse4 = true;
            while (trueOrFalse4) {
                factoryForAudi.printAvailableWheelSizes();
                wheelSize = enterWheelSize(reader);
                try {
                    WheelSizeForAudi.valueOf(wheelSize.toUpperCase());
                    trueOrFalse4 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            factoryForAudi.printAvailableOptions();
            optionsForAudi = enterOptionsForAudi(reader);
            boolean trueOrFalse5 = true;
            while (trueOrFalse5) {
                factoryForAudi.printAvailableCountsOfDoors();
                countOfDoors = enterCountOfDoorsForAudi(reader);
                try {
                    CountOfDoorsForAudi.valueOf(countOfDoors.toUpperCase());
                    trueOrFalse5 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            if (check) {
                System.out.println("Your car:");
                return factoryForAudi.createCar(ModelForAudi.valueOf(model.toUpperCase()), ColorForAudi.valueOf(color.toUpperCase()), VolumeOfEngineForAudi.valueOf(volumeOfEngine.toUpperCase()), WheelSizeForAudi.valueOf(wheelSize.toUpperCase()), optionsForAudi, CountOfDoorsForAudi.valueOf(countOfDoors.toUpperCase()));
            } else {
                while (true) {
                    System.out.println("Enter year of production");
                    try {
                        try {
                            year = Integer.parseInt(reader.readLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(MESSAGE_IF_DATA_WRONG);
                        }
                    } catch (IOException e) {
                        catchError();
                    }
                }
                CarAudi carAudi = new CarAudi(ModelForAudi.valueOf(model.toUpperCase()), ColorForAudi.valueOf(color.toUpperCase()), VolumeOfEngineForAudi.valueOf(volumeOfEngine.toUpperCase()), year, WheelSizeForAudi.valueOf(wheelSize.toUpperCase()), optionsForAudi, CountOfDoorsForAudi.valueOf(countOfDoors.toUpperCase()));
                System.out.println("Enter new details");
                String newColor = null;
                boolean trueOrFalse6 = true;
                while (trueOrFalse6) {
                    factoryForAudi.printAvailableColors();
                    newColor = enterColor(reader);
                    try {
                        ColorForAudi.valueOf(newColor.toUpperCase());
                        trueOrFalse6 = false;
                    } catch (IllegalArgumentException e) {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                }
                serviceToChangeColor.changeColor(carAudi, ColorForAudi.valueOf(newColor.toUpperCase()));
                String newWheelSize = null;
                boolean trueOrFalse7 = true;
                while (trueOrFalse7) {
                    factoryForAudi.printAvailableWheelSizes();
                    newWheelSize = enterWheelSize(reader);
                    try {
                        WheelSizeForAudi.valueOf(newWheelSize.toUpperCase());
                        trueOrFalse7 = false;
                    } catch (IllegalArgumentException e) {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                }
                serviceToChangeWheels.changeWheels(carAudi, WheelSizeForAudi.valueOf(newWheelSize.toUpperCase()));
                factoryForAudi.printAvailableOptions();
                OptionForAudi[] newOptions = enterOptionsForAudi(reader);
                serviceToChangeOptions.changeOptions(carAudi, newOptions);
                System.out.println("Your fixed car:");
                return carAudi;
            }
        }
        if (name.equalsIgnoreCase(MERSEDES)) {
            String model = null;
            String color = null;
            String volumeOfEngine = null;
            int year;
            String wheelSize = null;
            OptionForMersedes[] optionsForMersedes;
            String countOfHeadLights = null;
            boolean trueOrFalse1 = true;
            while (trueOrFalse1) {
                factoryForMersedes.printAvailableModels();
                model = enterModel(reader);
                try {
                    ModelForMersedes.valueOf(model.toUpperCase());
                    trueOrFalse1 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            boolean trueOrFalse2 = true;
            while (trueOrFalse2) {
                factoryForMersedes.printAvailableColors();
                color = enterColor(reader);
                try {
                    ColorForMersedes.valueOf(color.toUpperCase());
                    trueOrFalse2 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            boolean trueOrFalse3 = true;
            while (trueOrFalse3) {
                factoryForMersedes.printAvailableVolumes();
                volumeOfEngine = enterVolumeOfEngine(reader);
                try {
                    VolumeOfEngineForMersedes.valueOf(volumeOfEngine.toUpperCase());
                    trueOrFalse3 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            boolean trueOrFalse4 = true;
            while (trueOrFalse4) {
                factoryForMersedes.printAvailableWheelSizes();
                wheelSize = enterWheelSize(reader);
                try {
                    WheelSizeMersedes.valueOf(wheelSize.toUpperCase());
                    trueOrFalse4 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            factoryForMersedes.printAvailableOptions();
            optionsForMersedes = enterOptionsForMersedes(reader);
            boolean trueOrFalse5 = true;
            while (trueOrFalse5) {
                factoryForMersedes.printAvailableCountsOfHeadLights();
                countOfHeadLights = enterCountOfHeadLights(reader);
                try {
                    CountOfHeadLightForMersedes.valueOf(countOfHeadLights.toUpperCase());
                    trueOrFalse5 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            if (check) {
                System.out.println("Your car:");
                return factoryForMersedes.createCar(ModelForMersedes.valueOf(model.toUpperCase()), ColorForMersedes.valueOf(color.toUpperCase()), VolumeOfEngineForMersedes.valueOf(volumeOfEngine.toUpperCase()), WheelSizeMersedes.valueOf(wheelSize.toUpperCase()), optionsForMersedes, CountOfHeadLightForMersedes.valueOf(countOfHeadLights.toUpperCase()));
            } else {
                while (true) {
                    System.out.println("Enter year of production");
                    try {
                        try {
                            year = Integer.parseInt(reader.readLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(MESSAGE_IF_DATA_WRONG);
                        }
                    } catch (IOException e) {
                        catchError();
                    }
                }
                CarMersedes carMersedes = new CarMersedes(ModelForMersedes.valueOf(model.toUpperCase()), ColorForMersedes.valueOf(color.toUpperCase()), VolumeOfEngineForMersedes.valueOf(volumeOfEngine.toUpperCase()), year, WheelSizeMersedes.valueOf(wheelSize.toUpperCase()), optionsForMersedes, CountOfHeadLightForMersedes.valueOf(countOfHeadLights.toUpperCase()));
                System.out.println("Enter new details");
                String newColor = null;
                boolean trueOrFalse6 = true;
                while (trueOrFalse6) {
                    factoryForMersedes.printAvailableColors();
                    newColor = enterColor(reader);
                    try {
                        ColorForMersedes.valueOf(newColor.toUpperCase());
                        trueOrFalse6 = false;
                    } catch (IllegalArgumentException e) {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                }
                serviceToChangeColor.changeColor(carMersedes, ColorForMersedes.valueOf(newColor.toUpperCase()));
                String newWheelSize = null;
                boolean trueOrFalse7 = true;
                while (trueOrFalse7) {
                    factoryForMersedes.printAvailableWheelSizes();
                    newWheelSize = enterWheelSize(reader);
                    try {
                        WheelSizeMersedes.valueOf(newWheelSize.toUpperCase());
                        trueOrFalse7 = false;
                    } catch (IllegalArgumentException e) {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                }
                serviceToChangeWheels.changeWheels(carMersedes, WheelSizeMersedes.valueOf(newWheelSize.toUpperCase()));
                factoryForMersedes.printAvailableOptions();
                OptionForMersedes[] newOptions = enterOptionsForMersedes(reader);
                serviceToChangeOptions.changeOptions(carMersedes, newOptions);
                System.out.println("Your fixed car:");
                return carMersedes;
            }
        }
        if (name.equalsIgnoreCase(BMW)) {
            String model = null;
            String color = null;
            String volumeOfEngine = null;
            int year;
            String wheelSize = null;
            OptionForBMW[] optionsForBMW;
            String maxSpeed = null;
            boolean trueOrFalse1 = true;
            while (trueOrFalse1) {
                factoryForBMW.printAvailableModels();
                model = enterModel(reader);
                try {
                    ModelForBMW.valueOf(model.toUpperCase());
                    trueOrFalse1 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            boolean trueOrFalse2 = true;
            while (trueOrFalse2) {
                factoryForBMW.printAvailableColors();
                color = enterColor(reader);
                try {
                    ColorForBMW.valueOf(color.toUpperCase());
                    trueOrFalse2 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            boolean trueOrFalse3 = true;
            while (trueOrFalse3) {
                factoryForBMW.printAvailableVolumes();
                volumeOfEngine = enterVolumeOfEngine(reader);
                try {
                    VolumeOfEngineForBMW.valueOf(volumeOfEngine.toUpperCase());
                    trueOrFalse3 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            boolean trueOrFalse4 = true;
            while (trueOrFalse4) {
                factoryForBMW.printAvailableWheelSizes();
                wheelSize = enterWheelSize(reader);
                try {
                    WheelSizeBMW.valueOf(wheelSize.toUpperCase());
                    trueOrFalse4 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            factoryForBMW.printAvailableOptions();
            optionsForBMW = enterOptionsForBMW(reader);
            boolean trueOrFalse5 = true;
            while (trueOrFalse5) {
                factoryForBMW.printAvailableMaxSpeed();
                maxSpeed = enterMaxSpeedForBMW(reader);
                try {
                    MaxSpeedForBMW.valueOf(maxSpeed.toUpperCase());
                    trueOrFalse5 = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            }
            if (check) {
                System.out.println("Your car: ");
                return factoryForBMW.createCar(ModelForBMW.valueOf(model.toUpperCase()), ColorForBMW.valueOf(color.toUpperCase()), VolumeOfEngineForBMW.valueOf(volumeOfEngine.toUpperCase()), WheelSizeBMW.valueOf(wheelSize.toUpperCase()), optionsForBMW, MaxSpeedForBMW.valueOf(maxSpeed.toUpperCase()));
            } else {
                while (true) {
                    System.out.println("Enter year of production");
                    try {
                        try {
                            year = Integer.parseInt(reader.readLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(MESSAGE_IF_DATA_WRONG);
                        }
                    } catch (IOException e) {
                        catchError();
                    }
                }
                CarBMW carBMW = new CarBMW(ModelForBMW.valueOf(model.toUpperCase()), ColorForBMW.valueOf(color.toUpperCase()), VolumeOfEngineForBMW.valueOf(volumeOfEngine.toUpperCase()), year, WheelSizeBMW.valueOf(wheelSize.toUpperCase()), optionsForBMW, MaxSpeedForBMW.valueOf(maxSpeed.toUpperCase()));
                System.out.println("Enter new details");
                String newColor = null;
                boolean trueOrFalse6 = true;
                while (trueOrFalse6) {
                    factoryForBMW.printAvailableColors();
                    newColor = enterColor(reader);
                    try {
                        ColorForBMW.valueOf(color.toUpperCase());
                        trueOrFalse6 = false;
                    } catch (IllegalArgumentException e) {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                }
                serviceToChangeColor.changeColor(carBMW, ColorForBMW.valueOf(newColor.toUpperCase()));
                String newWheelSize = null;
                boolean trueOrFalse7 = true;
                while (trueOrFalse7) {
                    factoryForBMW.printAvailableWheelSizes();
                    newWheelSize = enterWheelSize(reader);
                    try {
                        WheelSizeBMW.valueOf(newWheelSize.toUpperCase());
                        trueOrFalse7 = false;
                    } catch (IllegalArgumentException e) {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                }
                serviceToChangeWheels.changeWheels(carBMW, WheelSizeBMW.valueOf(newWheelSize.toUpperCase()));
                factoryForBMW.printAvailableOptions();
                OptionForBMW[] newOptions = enterOptionsForBMW(reader);
                serviceToChangeOptions.changeOptions(carBMW, newOptions);
                System.out.println("Your fixed car:");
                return carBMW;
            }
        }
        return null;
    }
    private void printAvailableNames() {
        System.out.println("Available cars: " + AUDI + ", " +  MERSEDES + ", " + BMW);
    }


    private void catchError() {
        System.out.println(MESSAGE_IF_ERROR);
        System.exit(0);
    }

    private String enterName(BufferedReader reader) {
        while (true) {
            try {
                printAvailableNames();
                System.out.println("Enter name");
                String name = reader.readLine();
                if (name.equalsIgnoreCase(AUDI) || name.equalsIgnoreCase(MERSEDES) || name.equalsIgnoreCase(BMW)) {
                    return name;
                } else {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            } catch (IOException e) {
                catchError();
            }
        }
    }

    private String enterModel(BufferedReader reader) {
        String model = null;
        try {
            System.out.println("Enter model");
            model = reader.readLine();
        } catch (IOException e) {
            catchError();
        }
        return model;
    }


    private String enterColor(BufferedReader reader) {
        String color = null;
        try {
            System.out.println("Enter color");
            color = reader.readLine();
        } catch (IOException e) {
            catchError();
        }
        return color;
    }


    private String enterVolumeOfEngine(BufferedReader reader) {
        String volume = null;
        try {
            System.out.println("Enter volume of engine");
            volume = reader.readLine();
        } catch (IOException e) {
            catchError();
        }
        return volume;
    }

    private String enterWheelSize(BufferedReader reader) {
        String wheelSize = null;
        try {
            System.out.println("Enter size of wheels");
            wheelSize = reader.readLine();
        } catch (IOException e) {
            catchError();
        }
        return wheelSize;
    }

    private OptionForAudi[] enterOptionsForAudi(BufferedReader reader) {
        OptionForAudi[] options = null;
        System.out.println("Enter options. If you want to stop entering options, enter STOP");
        while (true) {
            try {
                String option = reader.readLine();
                if (!option.equals(STOP)) {
                    try {
                        OptionForAudi.valueOf(option.toUpperCase());
                        if (options != null) {
                            if (checkOnOption(options, OptionForAudi.valueOf(option.toUpperCase()))) {
                                OptionForAudi[] tmp = new OptionForAudi[options.length + 1];
                                for (int i = 0; i < options.length; i++) {
                                    tmp[i] = options[i];
                                }
                                tmp[tmp.length - 1] = OptionForAudi.valueOf(option.toUpperCase());
                                options = tmp;
                            }
                        } else {
                            options = new OptionForAudi[1];
                            options[0] = OptionForAudi.valueOf(option.toUpperCase());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                } else {
                    break;
                }
            } catch (IOException e) {
                catchError();
            }
        }
        return options;
    }

    private OptionForMersedes[] enterOptionsForMersedes(BufferedReader reader) {
        OptionForMersedes[] options = null;
        System.out.println("Enter options. If you want to stop entering options, enter STOP");
        while (true) {
            try {
                String option = reader.readLine();
                if (!option.equals(STOP)) {
                    try {
                        OptionForMersedes.valueOf(option.toUpperCase());
                        if (options != null) {
                            if (checkOnOption(options, OptionForMersedes.valueOf(option.toUpperCase()))) {
                                OptionForMersedes[] tmp = new OptionForMersedes[options.length + 1];
                                for (int i = 0; i < options.length; i++) {
                                    tmp[i] = options[i];
                                }
                                tmp[tmp.length - 1] = OptionForMersedes.valueOf(option.toUpperCase());
                                options = tmp;
                            }
                        } else {
                            options = new OptionForMersedes[1];
                            options[0] = OptionForMersedes.valueOf(option.toUpperCase());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                } else {
                    break;
                }
            } catch (IOException e) {
                catchError();
            }
        }
        return options;
    }

    private OptionForBMW[] enterOptionsForBMW(BufferedReader reader) {
        OptionForBMW[] options = null;
        System.out.println("Enter options. If you want to stop entering options, enter STOP");
        while (true) {
            try {
                String option = reader.readLine();
                if (!option.equals(STOP)) {
                    try {
                        OptionForBMW.valueOf(option.toUpperCase());
                        if (options != null) {
                            if (checkOnOption(options, OptionForBMW.valueOf(option.toUpperCase()))) {
                                OptionForBMW[] tmp = new OptionForBMW[options.length + 1];
                                for (int i = 0; i < options.length; i++) {
                                    tmp[i] = options[i];
                                }
                                tmp[tmp.length - 1] = OptionForBMW.valueOf(option.toUpperCase());
                                options = tmp;
                            }
                        } else {
                            options = new OptionForBMW[1];
                            options[0] = OptionForBMW.valueOf(option.toUpperCase());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    }
                } else {
                    break;
                }
            } catch (IOException e) {
                catchError();
            }
        }
        return options;
    }

    private String enterCountOfDoorsForAudi(BufferedReader reader) {
        System.out.println("Enter count of doors");
        String countOfDoors = null;
        try {
            countOfDoors = reader.readLine();
        } catch (IOException e) {
            catchError();
        }
        return countOfDoors;
    }

    private String enterCountOfHeadLights(BufferedReader reader) {
        System.out.println("Enter count of headlights");
        String countOfHeadLights = null;
        try {
            countOfHeadLights = reader.readLine();
        } catch (IOException e) {
            catchError();
        }
        return countOfHeadLights;
    }

    private String enterMaxSpeedForBMW(BufferedReader reader) {
        System.out.println("Enter max speed");
        String maxSpeed = null;
        try {
            maxSpeed = reader.readLine();
        } catch (IOException e) {
            catchError();
        }
        return  maxSpeed;
    }

    private boolean checkOnOption(Option[] options, Option option) {
        for (Option option1 : options) {
            if (option1.equals(option)) {
                System.out.println("This option already exists");
                return false;
            }
        }
        return true;
    }
}