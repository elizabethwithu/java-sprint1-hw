import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {

    private static final double STEP_TO_KM_COEFF = 0.00075;
    private static final double STEP_TO_KCAL_COEFF = 0.05;

    static double stepsToDistance(int steps) {
        return convert(steps, STEP_TO_KM_COEFF, 2);
    }

    static double stepsToEnergyCosts(int steps) {
        return convert(steps, STEP_TO_KCAL_COEFF, 0);
    }

    /**
     * Метод для конвертации шагов в другие единицы измерения.
     * @param steps количество шагов
     * @param coeff коэффициент единицы измерения
     * @param places количество знаков после запятой
     * @return шаги в нужной единице измерения
     */
    static double convert(int steps, double coeff, int places) {
        return new BigDecimal(steps * coeff)
                .setScale(places, RoundingMode.HALF_DOWN)
                .doubleValue();
    }
}
