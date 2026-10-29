public class Exercise8 {
    public static void main(String[] args) {
        String firstName = "Bob";
        int age = 43;
        double grossSalary = 2700;
        boolean isSenior = false;
        String[] domains = {"Java", "Python", "C++", "Oracle"};

        System.out.println(firstName + " is " + age + " years old. Gross salary is " + grossSalary + ". Senior : " + isSenior);


        System.out.println("Number of domains:" + domains.length);
        int counter = 0;
        for (String domain : domains) {
            counter++;
            System.out.println("Domain " + counter +" : " + domain);
        }
    }
}
