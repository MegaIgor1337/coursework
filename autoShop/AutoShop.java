package autoShop;

import car.Car;
import car.CarAudi;
import car.CarBMW;
import car.CarMersedes;
import enums.enumsForAudi.*;
import enums.enumsForBMW.*;
import enums.enumsForMersedes.*;
import factory.factoryForAudi.FactoryForAudi;
import factory.factoryForBMW.FactoryForBMW;
import factory.factoryForMersedes.FactoryForMersedes;
import interfaces.*;
import params.AudiParams;
import params.BMWParams;
import params.MersedesParams;
import params.Params;
import service.ServiceToChangeColor;
import service.ServiceToChangeOptions;
import service.ServiceToChangeWheels;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
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

    public AutoShop(FactoryForBMW factoryForBMW, FactoryForMersedes factoryForMersedes, FactoryForAudi factoryForAudi,
                    ServiceToChangeColor serviceToChangeColor, ServiceToChangeWheels serviceToChangeWheels,
                    ServiceToChangeOptions serviceToChangeOptions) {
        this.factoryForBMW = factoryForBMW;
        this.factoryForMersedes = factoryForMersedes;
        this.factoryForAudi = factoryForAudi;
        this.serviceToChangeColor = serviceToChangeColor;
        this.serviceToChangeWheels = serviceToChangeWheels;
        this.serviceToChangeOptions = serviceToChangeOptions;
    }

    public Car orderCar1(BufferedReader reader) {
        String name = enterName(reader);
        Model model = enterModel(reader, name);
        Color color = enterColor(reader, name);
        VolumeEngine volumeEngine = enterVolume(reader, name);
        WheelSize wheelSize = enterWheelSize(reader, name);
        Option[] options = enterOptions(reader, name);
        Params params = enterParams(reader, name);
        if (validationOnNull(name, model, color, volumeEngine, wheelSize, options, params)) {
            return null;
        }
        if (validationOnName(name, AUDI)) {
            return factoryForAudi.createCar((ModelForAudi) model, (ColorForAudi) color, (VolumeOfEngineForAudi) volumeEngine,
                    (WheelSizeForAudi) wheelSize, (OptionForAudi[]) options, (AudiParams) params);
        } else if (validationOnName(name, BMW)) {
            return factoryForBMW.createCar((ModelForBMW) model, (ColorForBMW) color, (VolumeOfEngineForBMW) volumeEngine,
                    (WheelSizeBMW) wheelSize, (OptionForBMW[]) options, (BMWParams) params);
        } else if (validationOnName(name, MERSEDES)) {
            return factoryForMersedes.createCar((ModelForMersedes) model, (ColorForMersedes) color, (VolumeOfEngineForMersedes) volumeEngine,
                    (WheelSizeMersedes) wheelSize, (OptionForMersedes[]) options, (MersedesParams) params);
        }
        return null;
    }

    private boolean validationOnName(String name, String carName) {
        return name.equalsIgnoreCase(carName);
    }

    private Model enterModel(BufferedReader reader, String name) {
        if (validationOnName(name, AUDI)) {
            return enterModelAudi(reader);
        } else if (validationOnName(name, MERSEDES)) {
            return enterModelMersedes(reader);
        } else if (validationOnName(name, BMW)) {
            return enterModelBMW(reader);
        }
        return null;
    }

    private Color enterColor(BufferedReader reader, String name) {
        if (validationOnName(name, AUDI)) {
            return enterColorForAudi(reader);
        } else if (validationOnName(name, BMW)) {
            return enterColorForBMW(reader);
        } else if (validationOnName(name, MERSEDES)) {
            return enterColorForMersedes(reader);
        }
        return null;
    }

    private VolumeEngine enterVolume(BufferedReader reader, String name) {
        if (validationOnName(name, AUDI)) {
            return enterVolumeForAudi(reader);
        } else if (validationOnName(name, BMW)) {
            return enterVolumeForBMW(reader);
        } else if (validationOnName(name, MERSEDES)) {
            return enterVolumeForMersedes(reader);
        }
        return null;
    }

    private WheelSize enterWheelSize(BufferedReader reader, String name) {
        if (validationOnName(name, AUDI)) {
            return enterWheelSizeForAudi(reader);
        } else if (validationOnName(name, BMW)) {
            return enterWheelSizeForBMW(reader);
        } else if (validationOnName(name, MERSEDES)) {
            return enterWheelSizeForMersedes(reader);
        }
        return null;
    }

    private Option[] enterOptions(BufferedReader reader, String name) {
        if (validationOnName(name, AUDI)) {
            return enterOptionsForAudi(reader);
        } else if (validationOnName(name, BMW)) {
            return enterOptionsForBMW(reader);
        } else if (validationOnName(name, MERSEDES)) {
            return enterOptionsForMersedes(reader);
        }
        return null;
    }

    private Params enterParams(BufferedReader reader, String name) {
        if (validationOnName(name, AUDI)) {
            return new AudiParams(enterCountOfDoors(reader));
        } else if (validationOnName(name, BMW)) {
            return new BMWParams(enterMaxSpeed(reader));
        } else if (validationOnName(name, MERSEDES)) {
            return new MersedesParams(enterCountOfHeadLights(reader));
        }
        return null;
    }

    private CountOfDoorsForAudi enterCountOfDoors(BufferedReader reader) {
        while (true) {
            try {
                return CountOfDoorsForAudi.valueOf(enterCountOfDoorsForAudi(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }

    private CountOfHeadLightForMersedes enterCountOfHeadLights(BufferedReader reader) {
        while (true) {
            try {
                return CountOfHeadLightForMersedes.valueOf(enterCountOfHeadLightsForMersedes(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }

    private MaxSpeedForBMW enterMaxSpeed(BufferedReader reader) {
        while (true) {
            try {
                return MaxSpeedForBMW.valueOf(enterMaxSpeedForBMW(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }

    private OptionForAudi[] enterOptionsForAudi(BufferedReader reader) {
        Set<OptionForAudi> options = new HashSet<>();
        factoryForAudi.printAvailableOptions();
        while (true) {
            try {
                String option = enterOption(reader);
                if (option == null) {
                    break;
                }
                options.add(OptionForAudi.valueOf(option.toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
        return getArrayFromSetForAudi(options);
    }

    private OptionForAudi[] getArrayFromSetForAudi(Set<OptionForAudi> set) {
        OptionForAudi[] options = new OptionForAudi[set.size()];
        int i = 0;
        for (OptionForAudi option : set) {
            options[i++] = option;
        }
        return options;
    }

    private OptionForMersedes[] enterOptionsForMersedes(BufferedReader reader) {
        Set<OptionForMersedes> options = new HashSet<>();
        factoryForMersedes.printAvailableOptions();
        while (true) {
            try {
                String option = enterOption(reader);
                if (option == null) {
                    break;
                }
                options.add(OptionForMersedes.valueOf(option.toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
        return getArrayFromSetForMersedes(options);
    }

    private OptionForMersedes[] getArrayFromSetForMersedes(Set<OptionForMersedes> set) {
        OptionForMersedes[] options = new OptionForMersedes[set.size()];
        int i = 0;
        for (OptionForMersedes option : set) {
            options[i++] = option;
        }
        return options;
    }

    private OptionForBMW[] enterOptionsForBMW(BufferedReader reader) {
        Set<OptionForBMW> options = new HashSet<>();
        factoryForBMW.printAvailableOptions();
        while (true) {
            try {
                String option = enterOption(reader);
                if (option == null) {
                    break;
                }
                options.add(OptionForBMW.valueOf(option.toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
        return getArrayFromSetForBMW(options);
    }

    private OptionForBMW[] getArrayFromSetForBMW(Set<OptionForBMW> set) {
        OptionForBMW[] options = new OptionForBMW[set.size()];
        int i = 0;
        for (OptionForBMW option : set) {
            options[i++] = option;
        }
        return options;
    }

    private String enterOption(BufferedReader reader) {
        System.out.println("Enter option. If you want to stop, enter STOP");
        String option;
        try {
            option = reader.readLine();
            if (option.equalsIgnoreCase(STOP)) {
                return null;
            }
            return option;
        } catch (IOException e) {
            catchError();
        }
        return null;
    }

    private WheelSizeForAudi enterWheelSizeForAudi(BufferedReader reader) {
        while (true) {
            try {
                factoryForAudi.printAvailableWheelSizes();
                return WheelSizeForAudi.valueOf(enterWheelSize(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }

    private WheelSizeBMW enterWheelSizeForBMW(BufferedReader reader) {
        while (true) {
            try {
                factoryForBMW.printAvailableWheelSizes();
                return WheelSizeBMW.valueOf(enterWheelSize(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }


    private WheelSizeMersedes enterWheelSizeForMersedes(BufferedReader reader) {
        while (true) {
            try {
                factoryForMersedes.printAvailableWheelSizes();
                return WheelSizeMersedes.valueOf(enterWheelSize(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }


    private VolumeOfEngineForAudi enterVolumeForAudi(BufferedReader reader) {
        while (true) {
            try {
                factoryForAudi.printAvailableVolumes();
                return VolumeOfEngineForAudi.valueOf(enterVolumeOfEngine(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }

    private VolumeOfEngineForBMW enterVolumeForBMW(BufferedReader reader) {
        while (true) {
            try {
                factoryForBMW.printAvailableVolumes();
                return VolumeOfEngineForBMW.valueOf(enterVolumeOfEngine(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }

    private VolumeOfEngineForMersedes enterVolumeForMersedes(BufferedReader reader) {
        while (true) {
            try {
                factoryForMersedes.printAvailableVolumes();
                return VolumeOfEngineForMersedes.valueOf(enterVolumeOfEngine(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }

    private ColorForAudi enterColorForAudi(BufferedReader reader) {
        while (true) {
            try {
                factoryForAudi.printAvailableColors();
                return ColorForAudi.valueOf(enterColor(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }


    private ColorForBMW enterColorForBMW(BufferedReader reader) {
        while (true) {
            try {
                factoryForBMW.printAvailableColors();
                return ColorForBMW.valueOf(enterColor(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }

    private ColorForMersedes enterColorForMersedes(BufferedReader reader) {
        while (true) {
            try {
                factoryForMersedes.printAvailableColors();
                return ColorForMersedes.valueOf(enterColor(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }


    private ModelForAudi enterModelAudi(BufferedReader reader) {
        while (true) {
            try {
                factoryForAudi.printAvailableModels();
                return ModelForAudi.valueOf(enterModel(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }

    private ModelForMersedes enterModelMersedes(BufferedReader reader) {
        while (true) {
            try {
                factoryForMersedes.printAvailableModels();
                return ModelForMersedes.valueOf(enterModel(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }

    private ModelForBMW enterModelBMW(BufferedReader reader) {
        while (true) {
            try {
                factoryForBMW.printAvailableModels();
                return ModelForBMW.valueOf(enterModel(reader).toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_IF_DATA_WRONG);
            }
        }
    }


    private void printAvailableNames() {
        System.out.println("Available cars: " + AUDI + ", " + MERSEDES + ", " + BMW);
    }


    private void catchError() {
        System.out.println(MESSAGE_IF_ERROR);
        System.exit(-1);
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

    private String enterCountOfDoorsForAudi(BufferedReader reader) {
        factoryForAudi.printAvailableCountsOfDoors();
        System.out.println("Enter count of doors");
        String countOfDoors = null;
        try {
            countOfDoors = reader.readLine();
        } catch (IOException e) {
            catchError();
        }
        return countOfDoors;
    }

    private String enterCountOfHeadLightsForMersedes(BufferedReader reader) {
        factoryForMersedes.printAvailableCountsOfHeadLights();
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
        factoryForBMW.printAvailableMaxSpeed();
        System.out.println("Enter max speed");
        String maxSpeed = null;
        try {
            maxSpeed = reader.readLine();
        } catch (IOException e) {
            catchError();
        }
        return maxSpeed;
    }

    private int enterYearOfCarProduction(BufferedReader reader) {
        Calendar calendar = Calendar.getInstance();
        while (true) {
            try {
                try {
                    System.out.println("Enter year of production your car");
                    int year = Integer.parseInt(reader.readLine());
                    if (year > calendar.get(Calendar.YEAR)) {
                        System.out.println(MESSAGE_IF_DATA_WRONG);
                    } else {
                        return year;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(MESSAGE_IF_DATA_WRONG);
                }
            } catch (IOException e) {
                catchError();
            }
        }
    }

    private boolean validationOnNull(String name, Model model, Color color, VolumeEngine volumeEngine,
                                     WheelSize wheelSize, Option[] options, Params params) {
        if (name == null || model == null || color == null || volumeEngine == null ||
                wheelSize == null || options == null || params == null) {
            return true;
        } else {
            return false;
        }
    }


    public Car enterCar(BufferedReader reader) {
        String name = enterName(reader);
        Model model = enterModel(reader, name);
        Color color = enterColor(reader, name);
        VolumeEngine volumeEngine = enterVolume(reader, name);
        int year = enterYearOfCarProduction(reader);
        WheelSize wheelSize = enterWheelSize(reader, name);
        Option[] options = enterOptions(reader, name);
        Params params = enterParams(reader, name);
        if (validationOnNull(name, model, color, volumeEngine, wheelSize, options, params)) {
            return null;
        }
        if (validationOnName(name, AUDI)) {
            AudiParams audiParams = (AudiParams) params;
            return new CarAudi((ModelForAudi) model, (ColorForAudi) color, (VolumeOfEngineForAudi) volumeEngine,
                    year, (WheelSizeForAudi) wheelSize, (OptionForAudi[]) options, audiParams.getCountOfDoorsForAudi()
            );
        } else if (validationOnName(name, BMW)) {
            BMWParams bmwParams = (BMWParams) params;
            return new CarBMW((ModelForBMW) model, (ColorForBMW) color, (VolumeOfEngineForBMW) volumeEngine,
                    year, (WheelSizeBMW) wheelSize, (OptionForBMW[]) options, bmwParams.getMaxSpeedForBMW());
        } else if (validationOnName(name, MERSEDES)) {
            MersedesParams mersedesParams = (MersedesParams) params;
            return new CarMersedes((ModelForMersedes) model, (ColorForMersedes) color,
                    (VolumeOfEngineForMersedes) volumeEngine, year, (WheelSizeMersedes) wheelSize, (OptionForMersedes[]) options,
                    mersedesParams.getCountOfHeadLightForMersedes());
        }
        return null;
    }

    public Car changeColor(Car car, BufferedReader reader) {
        if (car == null) {
            catchError();
        }
        Color color = null;
        if (car instanceof CarAudi) {
            color = enterColorForAudi(reader);
        } else if (car instanceof CarMersedes) {
            color = enterColorForMersedes(reader);
        } else if (car instanceof CarBMW) {
            color = enterColorForBMW(reader);
        }
        if (serviceToChangeColor.changeColor(car, color)) {
            System.out.println("Your car:");
            System.out.println(car);
            return car;
        } else {
            return null;
        }
    }

    public Car changeWheelSize(Car car, BufferedReader reader) {
        if (car == null) {
            catchError();
        }
        WheelSize wheelSize = null;
        if (car instanceof CarAudi) {
            wheelSize = enterWheelSizeForAudi(reader);
        } else if (car instanceof CarMersedes) {
            wheelSize = enterWheelSizeForMersedes(reader);
        } else if (car instanceof CarBMW) {
            wheelSize = enterWheelSizeForBMW(reader);
        }
        if (serviceToChangeWheels.changeWheels(car, wheelSize)) {
            System.out.println("Your car:");
            System.out.println(car);
            return car;
        } else {
            return null;
        }
    }

    public Car changeOptions(Car car, BufferedReader reader) {
        if (car == null) {
            catchError();
        }
        Option[] options = null;
        if (car instanceof CarAudi) {
            options = enterOptionsForAudi(reader);
        } else if (car instanceof CarMersedes) {
            options = enterOptionsForMersedes(reader);
        } else if (car instanceof CarBMW) {
            options = enterOptionsForBMW(reader);
        }
        if (serviceToChangeOptions.changeOptions(car, options)) {
            System.out.println("Your car:");
            System.out.println(car);
            return car;
        } else {
            return null;
        }
    }
}