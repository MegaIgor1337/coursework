package params;

import enums.enumsForAudi.CountOfDoorsForAudi;

public class AudiParams extends Params {
    private final CountOfDoorsForAudi countOfDoorsForAudi;

    public AudiParams(CountOfDoorsForAudi countOfDoorsForAudi) {
        this.countOfDoorsForAudi = countOfDoorsForAudi;
    }

    public CountOfDoorsForAudi getCountOfDoorsForAudi() {
        return countOfDoorsForAudi;
    }
}
