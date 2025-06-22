public class FinancialForecast {

    public static double forecastRecursive(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        return forecastRecursive(initialValue, growthRate, years - 1) * (1 + growthRate);
    }


    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05;
        int years = 5;

        System.out.println("Recursive Forecast:");
        double result = forecastRecursive(initialValue, growthRate, years);
        System.out.println("Value after " + years + " years: " + (int) result);
    }
}
