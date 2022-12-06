import autoShop.AutoShop;
import car.CarAudi;
import car.CarBMW;
import car.CarMersedes;
import enums.enumsForAudi.*;
import enums.enumsForBMW.*;
import enums.enumsForMersedes.*;
import factory.factoryForAudi.FactoryForAudi;
import factory.factoryForAudi.StorageForAudi;
import factory.factoryForBMW.FactoryForBMW;
import factory.factoryForBMW.StorageForBMW;
import factory.factoryForMersedes.FactoryForMersedes;
import factory.factoryForMersedes.StorageForMersedes;
import service.ServiceToChangeColor;
import service.ServiceToChangeOptions;
import service.ServiceToChangeWheels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CarAudi[] carsAudi = {
                (new CarAudi(ModelForAudi.A4, ColorForAudi.PINK, VolumeOfEngineForAudi.ONE_NINE, 2018, WheelSizeForAudi.TWENTY_EIGHT, new OptionForAudi[]{OptionForAudi.GPS, OptionForAudi.MUSIC}, CountOfDoorsForAudi.FOUR )),
                (new CarAudi(ModelForAudi.A7, ColorForAudi.RED, VolumeOfEngineForAudi.ONE_ZERO, 2016, WheelSizeForAudi.TWENTY_SEVEN, new OptionForAudi[]{OptionForAudi.PANORAMA, OptionForAudi.FOGLIGHTS} , CountOfDoorsForAudi.FIVE )),
                (new CarAudi(ModelForAudi.A5, ColorForAudi.BLACK, VolumeOfEngineForAudi.SIX_ZERO, 2021, WheelSizeForAudi.TWENTY_SIX, new OptionForAudi[]{OptionForAudi.MUSIC, OptionForAudi.GPS} , CountOfDoorsForAudi.THREE )),
                (new CarAudi(ModelForAudi.A5, ColorForAudi.GREEN, VolumeOfEngineForAudi.THREE_ZERO, 2021, WheelSizeForAudi.TWENTY_SIX, new OptionForAudi[]{OptionForAudi.PARKTRONICS, OptionForAudi.GPS}, CountOfDoorsForAudi.FOUR)),
                (new CarAudi(ModelForAudi.Q6, ColorForAudi.WHITE, VolumeOfEngineForAudi.ONE_SIX, 2020, WheelSizeForAudi.TWENTY_FIVE, new OptionForAudi[]{OptionForAudi.FOGLIGHTS, OptionForAudi.PANORAMA, OptionForAudi.MUSIC} , CountOfDoorsForAudi.TWO))
        };
        StorageForAudi storageForAudi = new StorageForAudi(carsAudi);
        CarBMW[] carsBMW = {
                (new CarBMW(ModelForBMW.M4, ColorForBMW.AMARANTH, VolumeOfEngineForBMW.ONE_SEVEN, 2018, WheelSizeBMW.THIRTY_ONE, new OptionForBMW[]{OptionForBMW.TRUNK, OptionForBMW.ELECTRIC_WINDOWS}, MaxSpeedForBMW.THREE_HUNDRED)),
                (new CarBMW(ModelForBMW.I8, ColorForBMW.AUBURN, VolumeOfEngineForBMW.SIX_FIVE, 2016, WheelSizeBMW.THIRTY_FIVE, new OptionForBMW[]{OptionForBMW.AUTO_CLOSERS, OptionForBMW.TRUNK}, MaxSpeedForBMW.THREE_HUNDRED_AND_TEN)),
                (new CarBMW(ModelForBMW.E38, ColorForBMW.BROWN, VolumeOfEngineForBMW.TWO_FIVE, 2021, WheelSizeBMW.THIRTY_FOUR, new OptionForBMW[]{OptionForBMW.TRUNK}, MaxSpeedForBMW.TWO_HUNDRED_AND_FIFTY)),
                (new CarBMW(ModelForBMW.M5, ColorForBMW.CARMINE, VolumeOfEngineForBMW.TWO_FIVE, 2021, WheelSizeBMW.THIRTY_TWO, new OptionForBMW[]{OptionForBMW.ELECTRIC_WINDOWS}, MaxSpeedForBMW.TWO_HUNDRED_AND_FIFTY)),
                (new CarBMW(ModelForBMW.M3, ColorForBMW.FIRE_BRICK, VolumeOfEngineForBMW.THREE_FIVE, 2020, WheelSizeBMW.THIRTY_FIVE, new OptionForBMW[]{OptionForBMW.ELECTRIC_WINDOWS, OptionForBMW.TRUNK, OptionForBMW.AUTO_CLOSERS}, MaxSpeedForBMW.TWO_HUNDRED_AND_SEVENTY))
        };
        StorageForBMW storageForBMW = new StorageForBMW(carsBMW);
        CarMersedes[] carsMersedes = {
                (new CarMersedes(ModelForMersedes.S63, ColorForMersedes.GARMET, VolumeOfEngineForMersedes.FIVE_THREE, 2018, WheelSizeMersedes.FOURTY_ONE, new OptionForMersedes[]{OptionForMersedes.CRUISE_CONTROL, OptionForMersedes.HEATED_SEATS} , CountOfHeadLightForMersedes.FIVE )),
                (new CarMersedes(ModelForMersedes.S300, ColorForMersedes.ROSE, VolumeOfEngineForMersedes.FOUR_SEVEN, 2016, WheelSizeMersedes.FOURTY_SIX, new OptionForMersedes[]{OptionForMersedes.HEATED_WINDSHIELD, OptionForMersedes.CRUISE_CONTROL} , CountOfHeadLightForMersedes.SIX )),
                (new CarMersedes(ModelForMersedes.S400, ColorForMersedes.ORANGE_RED, VolumeOfEngineForMersedes.TEN_ZERO, 2021, WheelSizeMersedes.FOURTY_TWO, new OptionForMersedes[]{OptionForMersedes.REAR_VIEW_CAMERA, OptionForMersedes.HEATED_SEATS} , CountOfHeadLightForMersedes.TWO )),
                (new CarMersedes(ModelForMersedes.G63, ColorForMersedes.ORANGE_RED, VolumeOfEngineForMersedes.SIX_FIVE, 2021, WheelSizeMersedes.FOURTY_ONE, new OptionForMersedes[]{OptionForMersedes.HEATED_WINDSHIELD, OptionForMersedes.HEATED_SEATS}  , CountOfHeadLightForMersedes.FOUR)),
                (new CarMersedes(ModelForMersedes.GT63, ColorForMersedes.PERSIMMON, VolumeOfEngineForMersedes.FIVE_THREE, 2020,WheelSizeMersedes.FOURTY_SEVEN, new OptionForMersedes[]{OptionForMersedes.REAR_VIEW_CAMERA} , CountOfHeadLightForMersedes.THREE))
        };
        StorageForMersedes storageForMersedes = new StorageForMersedes(carsMersedes);
        ModelForAudi[] modelsForAudi = {ModelForAudi.RS7, ModelForAudi.RS6, ModelForAudi.Q6, ModelForAudi.Q7, ModelForAudi.A7, ModelForAudi.A100, ModelForAudi.A5, ModelForAudi.A2, ModelForAudi.A4, ModelForAudi.Q5, ModelForAudi.A6};
        ModelForBMW[] modelsForBMW = {ModelForBMW.E38, ModelForBMW.M3, ModelForBMW.I8, ModelForBMW.M5, ModelForBMW.M4};
        ModelForMersedes[] modelsForMersedes = {ModelForMersedes.E43, ModelForMersedes.G63, ModelForMersedes.GT63, ModelForMersedes.S400, ModelForMersedes.S300, ModelForMersedes.S63};
        ColorForAudi[] colorsForAudi = {ColorForAudi.BLACK, ColorForAudi.PINK, ColorForAudi.RED, ColorForAudi.BLUE, ColorForAudi.GREEN, ColorForAudi.WHITE, ColorForAudi.YELLOW};
        ColorForBMW[] colorsForBMW = {ColorForBMW.CARMINE, ColorForBMW.AUBURN, ColorForBMW.BROWN, ColorForBMW.AMARANTH, ColorForBMW.FIRE_BRICK, ColorForBMW.CERISE};
        ColorForMersedes[] colorsForMersedes = {ColorForMersedes.ROSE, ColorForMersedes.ORANGE_RED, ColorForMersedes.GARMET, ColorForMersedes.PERSIMMON, ColorForMersedes.MAGENTA, ColorForMersedes.RUBY};
        VolumeOfEngineForAudi[] volumesOfEngineForAudi = {VolumeOfEngineForAudi.ONE_SIX, VolumeOfEngineForAudi.ONE_NINE, VolumeOfEngineForAudi.ONE_ZERO, VolumeOfEngineForAudi.SIX_ZERO, VolumeOfEngineForAudi.EIGHT_ZERO, VolumeOfEngineForAudi.THREE_ZERO, VolumeOfEngineForAudi.TWO_ZERO};
        VolumeOfEngineForBMW[] volumesOfEngineForBMW = {VolumeOfEngineForBMW.ONE_SEVEN, VolumeOfEngineForBMW.SIX_FIVE, VolumeOfEngineForBMW.TWO_FIVE, VolumeOfEngineForBMW.THREE_FIVE};
        VolumeOfEngineForMersedes[] volumeOfEngineForMersedes = {VolumeOfEngineForMersedes.FIVE_THREE, VolumeOfEngineForMersedes.SIX_FIVE, VolumeOfEngineForMersedes.TEN_ZERO, VolumeOfEngineForMersedes.FOUR_SEVEN, VolumeOfEngineForMersedes.FOUR_THREE};
        WheelSizeForAudi[] wheelSizesForAudi = {WheelSizeForAudi.TWENTY_FIVE, WheelSizeForAudi.TWENTY_EIGHT, WheelSizeForAudi.TWENTY_SIX, WheelSizeForAudi.SEVENTY, WheelSizeForAudi.TWENTY_NINE, WheelSizeForAudi.TWENTY_FOUR, WheelSizeForAudi.TWENTY_SEVEN, WheelSizeForAudi.TWENTY_THREE};
        WheelSizeBMW[] wheelSizesBMW = {WheelSizeBMW.THIRTY_FIVE, WheelSizeBMW.THIRTY_FOUR, WheelSizeBMW.THIRTY_ONE, WheelSizeBMW.THIRTY_TWO, WheelSizeBMW.THIRTY_THREE};
        WheelSizeMersedes[] wheelSizesMersedes = {WheelSizeMersedes.FOURTY_ONE, WheelSizeMersedes.FOURTY_SIX, WheelSizeMersedes.FOURTY_SEVEN, WheelSizeMersedes.FOURTY_TWO, WheelSizeMersedes.FOURTY_FIVE};
        OptionForAudi[] optionsForAudi = {OptionForAudi.GPS, OptionForAudi.BACKWHEEL, OptionForAudi.CONDITION, OptionForAudi.MUSIC, OptionForAudi.FOGLIGHTS, OptionForAudi.PANORAMA, OptionForAudi.PARKTRONICS};
        OptionForBMW[] optionsForBMW = {OptionForBMW.AUTO_CLOSERS, OptionForBMW.ELECTRIC_WINDOWS, OptionForBMW.TRUNK};
        OptionForMersedes[] optionsForMersedes = {OptionForMersedes.CRUISE_CONTROL, OptionForMersedes.HEATED_SEATS, OptionForMersedes.HEATED_WINDSHIELD, OptionForMersedes.REAR_VIEW_CAMERA};
        CountOfDoorsForAudi[] countsOfDoorsForAudi = {CountOfDoorsForAudi.FOUR, CountOfDoorsForAudi.FIVE, CountOfDoorsForAudi.TWO, CountOfDoorsForAudi.SIX, CountOfDoorsForAudi.THREE};
        CountOfHeadLightForMersedes[] countsOfHeadLightForMersedes = {CountOfHeadLightForMersedes.FIVE, CountOfHeadLightForMersedes.FOUR, CountOfHeadLightForMersedes.TWO, CountOfHeadLightForMersedes.SIX, CountOfHeadLightForMersedes.THREE};
        MaxSpeedForBMW[] maxSpeedsForBMW = {MaxSpeedForBMW.THREE_HUNDRED, MaxSpeedForBMW.THREE_HUNDRED_AND_TEN, MaxSpeedForBMW.TWO_HUNDRED_AND_FIFTY, MaxSpeedForBMW.TWO_HUNDRED_AND_NINETY, MaxSpeedForBMW.TWO_HUNDRED_AND_SIXTY, MaxSpeedForBMW.TWO_HUNDRED_AND_SEVENTY};
        ServiceToChangeColor serviceToChangeColor = new ServiceToChangeColor();
        ServiceToChangeOptions serviceToChangeOptions = new ServiceToChangeOptions();
        ServiceToChangeWheels serviceToChangeWheels = new ServiceToChangeWheels();
        FactoryForBMW factoryForBMW = new FactoryForBMW(modelsForBMW, colorsForBMW, volumesOfEngineForBMW, wheelSizesBMW, optionsForBMW, maxSpeedsForBMW, storageForBMW, serviceToChangeColor, serviceToChangeWheels, serviceToChangeOptions);
        FactoryForAudi factoryForAudi = new FactoryForAudi(modelsForAudi, colorsForAudi, volumesOfEngineForAudi, wheelSizesForAudi, optionsForAudi, countsOfDoorsForAudi, storageForAudi, serviceToChangeColor, serviceToChangeWheels, serviceToChangeOptions);
        FactoryForMersedes factoryForMersedes = new FactoryForMersedes(modelsForMersedes, colorsForMersedes, volumeOfEngineForMersedes, wheelSizesMersedes, optionsForMersedes, countsOfHeadLightForMersedes, storageForMersedes, serviceToChangeColor, serviceToChangeWheels, serviceToChangeOptions);
        AutoShop autoShop = new AutoShop(factoryForBMW, factoryForMersedes, factoryForAudi, serviceToChangeColor, serviceToChangeWheels, serviceToChangeOptions);
        Menu menu = new Menu(autoShop);
        menu.start(reader);
        try {
            reader.close();
        } catch (IOException e) {
            Menu.catchError();
        }
    }
}