enum Gender {
    MALE, FEMALE, OTHER
}



public class Exercise10 {
    public static void main(String[] args) {
        String firstName = "Bob";
        int age = 43;
        double grossSalary = 2700;
        boolean isSenior = false;
        String[] domains = {"Java", "Python", "C++", "Oracle"};
        Gender gender = Gender.MALE;
        String pronoun;

        switch (gender)
        {
            case MALE: pronoun = "His"; break;
            case FEMALE: pronoun = "Her"; break;
            default: pronoun = "They";
        };

        System.out.println(firstName + " is " + age + " years old. " + pronoun + " gross salary is " + grossSalary + ". Senior : " + isSenior);

        System.out.println("Number of domains:" + domains.length);
        int counter = 0;
        for (String domain : domains) {
            counter++;
            System.out.println("Domain " + counter +" : " + domain);
        }
    }
}