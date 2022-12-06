package params;

import enums.enumsForBMW.MaxSpeedForBMW;

public class BMWParams extends Params {
    private final MaxSpeedForBMW maxSpeedForBMW;

    public BMWParams(MaxSpeedForBMW maxSpeedForBMW) {
        this.maxSpeedForBMW = maxSpeedForBMW;
    }

    public MaxSpeedForBMW getMaxSpeedForBMW() {
        return maxSpeedForBMW;
    }
}
