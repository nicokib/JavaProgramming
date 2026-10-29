public class Instructor {
    private String firstName;
    private int age;
    private boolean senior;
    private double grossSalary;
    private Gender gender;

    private double netSalary;


    public Instructor(){
        this("", 18, 2000, false, Gender.OTHER);
    }

    public Instructor(String firstName, int age, double grossSalary, boolean senior, Gender gender) {
        this.firstName = firstName;
        this.age = age;
        this.senior = senior;
        this.gender = gender;
        this.setGrossSalary(grossSalary);
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
        calculateNetSalary();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getYearlyGrossSalary() {
        return grossSalary * 12;
    }

    public double getNetSalary() {
        if(netSalary == Double.MIN_NORMAL)
            calculateNetSalary();
        return netSalary;
    }

    public void calculateNetSalary() {
        double yearlyGrossSalary = getYearlyGrossSalary();
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
        netSalary = grossSalary * (1 - rate);
    }

    void inscreaseSalary(double inscreaseRate) {
        setGrossSalary(grossSalary * (1 + inscreaseRate));
    }

    void showInfo()
    {
        System.out.println(firstName + " is " + age + " years old. Gross salary is " + grossSalary + ". Senior : " + senior);
    }

}
