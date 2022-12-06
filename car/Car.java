package car;

import interfaces.*;
import params.Params;

import java.util.Arrays;
import java.util.Set;

import static java.lang.String.format;

public abstract class Car {
    protected final Model model;
    protected Color color;
    protected final VolumeEngine volumeOfEngine;
    protected final int year;
    protected WheelSize wheelSize;
    protected Option[] options;
    protected Params params;

    public Car(Model model, Color color, VolumeEngine volumeOfEngine, int year, WheelSize wheelSize, Option[] options, Params params) {
        this.model = model;
        this.color = color;
        this.wheelSize = wheelSize;
        this.year = year;
        this.volumeOfEngine = volumeOfEngine;
        this.options = options;
        this.params = params;
    }

    public Model getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public VolumeEngine getVolumeOfEngine() {
        return volumeOfEngine;
    }

    public int getYear() {
        return year;
    }

    public WheelSize getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(WheelSize wheelSize) {
        this.wheelSize = wheelSize;
    }

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + model +
                ", color=" + color +
                ", volumeOfEngine=" + volumeOfEngine +
                ", year=" + year +
                ", wheelSize=" + wheelSize +
                ", options=" + Arrays.toString(options) +
                ", params=" + params +
                '}';
    }
}
