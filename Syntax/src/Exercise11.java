public class Exercise11 {
    public static void main(String[] args) {
        Instructor instructor1 = new Instructor("Bob", 43, 2700, false, Gender.MALE);

        double inscreaseRate = 0.05;

        System.out.println("Salary evolution : ");
        int startAge = 23;
        for(int i = startAge; i <= instructor1.getAge(); i+= 2) {
            System.out.println(instructor1.getFirstName() + "'s net salary at " + i + " is " + instructor1.getNetSalary());
            instructor1.inscreaseSalary(inscreaseRate);
        }
    }
}
