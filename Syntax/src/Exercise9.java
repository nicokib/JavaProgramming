public class Exercise9 {
    public static void main(String[] args) {
        String firstName = "Bob";
        int age = 43;
        double grossSalary = 2700;
        boolean isSenior = false;
        String[] domains = {"Java", "Python", "C++", "Oracle"};
        String gender = "male";
        String pronoun;

        switch (gender)
        {
            case "male": pronoun = "his"; break;
            case "female": pronoun = "her"; break;
            default: pronoun = "they";
        };

        String pronounCapitalized = pronoun.substring(0,1).toUpperCase() + pronoun.substring(1).toLowerCase();
        System.out.println(firstName + " is " + age + " years old. " + pronounCapitalized + " gross salary is " + grossSalary + ". Senior : " + isSenior);

        System.out.println("Number of domains:" + domains.length);
        int counter = 0;
        for (String domain : domains) {
            counter++;
            System.out.println("Domain " + counter +" : " + domain);
        }
    }
}