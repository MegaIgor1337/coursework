package factory;

import interfaces.*;

import java.util.Arrays;

public class Factory {
    protected static final int YEAR = 2022;
    protected Model[] models;
    protected Color[] colors;
    protected VolumeEngine[] volumeEngines;
    protected WheelSize[] wheelSizes;
    protected Option[] options;

    public Model[] getModels() {
        return models;
    }

    public Color[] getColors() {
        return colors;
    }

    public VolumeEngine[] getVolumeEngines() {
        return volumeEngines;
    }

    public WheelSize[] getWheelSize() {
        return wheelSizes;
    }

    public Option[] getOptions() {
        return options;
    }

    public Factory(Model[] models, Color[] colors, VolumeEngine[] volumeEngines, WheelSize[] wheelSize, Option[] options) {
        this.models = models;
        this.colors = colors;
        this.volumeEngines = volumeEngines;
        this.wheelSizes = wheelSize;
        this.options = options;
    }

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
