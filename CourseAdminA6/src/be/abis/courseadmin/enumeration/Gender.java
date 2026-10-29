package be.abis.courseadmin.enumeration;

public enum Gender {
    MALE("mr.", "he", "him", "his", "his", "himself"),
    FEMALE("ms.", "she", "her", "her", "hers", "herself"),
    OTHER("mx.", "they", "them", "their", "theirs", "themself");
    private String abbreviation; // Mr./Ms./Mx.
    private String subjectPronoun; // he/ she/they
    private String objectPronoun; // him/ her/them
    private String possessiveAdjective; // his/ her/their
    private String possessivePronoun; // his/ hers/theirs
    private String reflectivePronoun; // himself/ herself/themself

    Gender(String abbreviation, String subjectPronoun, String objectPronoun,
                  String possessiveAdjective, String possessivePronoun, String reflectivePronoun){
        this.abbreviation = abbreviation;
        this.subjectPronoun = subjectPronoun;
        this.objectPronoun = objectPronoun;
        this.possessiveAdjective = possessiveAdjective;
        this.possessivePronoun = possessivePronoun;
        this.reflectivePronoun = reflectivePronoun;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getSubjectPronoun() {
        return subjectPronoun;
    }

    public String getObjectPronoun() {
        return objectPronoun;
    }

    public String getPossessiveAdjective() {
        return possessiveAdjective;
    }

    public String getPossessivePronoun() {
        return possessivePronoun;
    }

    public String getReflectivePronoun() {
        return reflectivePronoun;
    }
}
