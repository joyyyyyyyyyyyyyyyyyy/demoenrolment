package sg.edu.rp.c346.id22022096.demoenrolment;

public class Enrollment {
    private int year;
    private String studytype;
    private int enrolmentcount;

    public Enrollment (int year, String studytype, int enrolmentcount) {
        this.year = year;
        this.studytype = studytype;
        this.enrolmentcount = enrolmentcount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStudytype() {
        return studytype;
    }

    public void setStudytype(String studytype) {
        this.studytype = studytype;
    }

    public int getEnrolmentcount() {
        return enrolmentcount;
    }

    public void setEnrolmentcount(int enrolmentcount) {
        this.enrolmentcount = enrolmentcount;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "year=" + year +
                ", studytype='" + studytype + '\'' +
                ", enrolmentcount=" + enrolmentcount +
                '}';
    }
}
