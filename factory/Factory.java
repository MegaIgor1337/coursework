package factory;

import car.Car;
import factory.storage.Storage;
import interfaces.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Factory<T, M extends Model, C extends Color, V extends VolumeEngine, W extends WheelSize, O extends Option, P> {
    private final static Calendar calendar = Calendar.getInstance();
    protected static final int YEAR  = calendar.get(Calendar.YEAR);
    protected Model[] models;
    protected Color[] colors;
    protected VolumeEngine[] volumeEngines;
    protected WheelSize[] wheelSizes;
    protected Option[] options;
    protected final Storage storage;


    public Factory(Model[] models, Color[] colors, VolumeEngine[] volumeEngines, WheelSize[] wheelSize, Option[] options, Storage storage) {
        this.models = models;
        this.colors = colors;
        this.volumeEngines = volumeEngines;
        this.wheelSizes = wheelSize;
        this.options = options;
        this.storage = storage;
    }

    public abstract T createCar(M model, C color, V volumeEngine, W wheelSize, O[] option, P params);

    @Override
    public String toString() {
        return "Factory{" +
                "models=" + Arrays.toString(models) +
                ", colors=" + Arrays.toString(colors) +
                ", volumeEngines=" + Arrays.toString(volumeEngines) +
                ", wheelSize=" + Arrays.toString(wheelSizes) +
                ", options=" + Arrays.toString(options) +
                '}';
    }

    public void printAvailableModels() {
        System.out.println("Available models: ");
        for (Model model : models) {
            System.out.print(model + " ");
        }
        System.out.println();
    }

    public void printAvailableColors() {
        System.out.println("Available colors: ");
        for (Color color : colors) {
            System.out.print(color + " ");
        }
        System.out.println();
    }

    public void printAvailableVolumes() {
        System.out.println("Available volumes: ");
        for (VolumeEngine volume: volumeEngines) {
            System.out.print(volume + " ");
        }
        System.out.println();
    }

    public void printAvailableWheelSizes() {
        System.out.println("Available sizes: ");
        for (WheelSize wheelSize: wheelSizes) {
            System.out.print(wheelSize + " ");
        }
        System.out.println();
    }

    public void printAvailableOptions() {
        System.out.println("Available options");
        for (Option option : options) {
            System.out.print(option + " ");
        }
        System.out.println();
    }
}
