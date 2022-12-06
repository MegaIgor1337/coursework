package params;

import enums.enumsForMersedes.CountOfHeadLightForMersedes;

public class MersedesParams extends Params {
    private final CountOfHeadLightForMersedes countOfHeadLightForMersedes;

    public MersedesParams(CountOfHeadLightForMersedes countOfHeadLightForMersedes) {
        this.countOfHeadLightForMersedes = countOfHeadLightForMersedes;
    }

    public CountOfHeadLightForMersedes getCountOfHeadLightForMersedes() {
        return countOfHeadLightForMersedes;
    }
}
