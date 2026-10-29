public class Exercise1 {
    public static void main(String[] args) {
        String firstName = "Bob";
        int age = 43;
        double grossSalary = 2700;
        boolean isSenior = false;
        double inscreaseRate = 0.05;

        System.out.println(firstName + " is " + age + " years old. Gross salary is " + grossSalary + ". Senior : " + isSenior);

        // 2 .Net Salary
        double netSalary = grossSalary * (1 - 0.48);
        System.out.println("Net salary is " + netSalary);
        // 3 .Depending of the annual salary
        double yearlyGrossSalary = grossSalary * 12;
        double rate = calculateRate(grossSalary);
        double taxDeduction = yearlyGrossSalary * rate;
        System.out.println("Annual Salary = " + yearlyGrossSalary);
        System.out.println("Rate = " + rate);
        System.out.println("Tax deduction = " + taxDeduction);

        // 4
        System.out.println(firstName + " is" + (isSenior ? "" : " not") +" a Senior.");
        // 5
        System.out.println("Salary evolution : ");
        int startAge = 23;
        for(int i = startAge; i <= age; i+= 2) {
            netSalary = grossSalary * (1 - rate);  //==> rate should be calculated for each loop...
            System.out.println(firstName + "'s net salary at " + i + " is " + netSalary);
            grossSalary *= (1 + inscreaseRate);
            rate = calculateRate(grossSalary);
        }
    }

    public static double calculateRate(double grossSalary) {
        double yearlyGrossSalary = grossSalary * 12;
        double rate;
        if (yearlyGrossSalary < 15200) {
            rate = 0.25;
        }
        else if (yearlyGrossSalary < 26830) {
            rate = 0.40;
        }
        else if (yearlyGrossSalary < 46440) {
            rate = 0.45;
        }
        else {
            rate = 0.50;
        }
        return rate;
    }
}
