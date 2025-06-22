public class Financial_method2 {

     public static double forecast2(double initialValue, double growthRate, int years, Double[] arr) {
        if (years == 0) return initialValue;

        if (arr[years] != null) return arr[years];

        arr[years] = forecast2(initialValue, growthRate, years - 1, arr) * (1 + growthRate);
        return arr[years];
    
    }
    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05;
        int years = 5;

        System.out.println("Forecast:");
        Double[] arr = new Double[years + 1];
        double optimizedResult = forecast2(initialValue, growthRate, years, arr);
        System.out.println("Value after " + years + " years: " +(int) optimizedResult);
    }
}