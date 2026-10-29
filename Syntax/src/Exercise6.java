public class Exercise6 {
    public static void main(String[] args) {
        String firstName = "Bob";
        int age = 73;
        double grossSalary = 2700;
        boolean isSenior = false;
        int startAge = 23;
        int yearsRaiseIsReceived = 35;
        double inscreaseRate = 0.05;

        System.out.println(firstName + " is " + age + " years old. Gross salary is " + grossSalary + ". Senior : " + isSenior);

        double rate = calculateRate(grossSalary);

        System.out.println("Salary evolution : ");
        double netSalary;
        for(int i = startAge; i <= age; i+= 2) {
            netSalary = grossSalary * (1 - rate);
            System.out.println(firstName + "'s net salary at " + i + " is " + netSalary);
            if(i - startAge < yearsRaiseIsReceived)
            {
                grossSalary *= (1 + inscreaseRate);
                rate = calculateRate(grossSalary);
            }
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
