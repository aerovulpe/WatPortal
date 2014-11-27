package me.aerovulpe.watportal;

/**
 * Created by Aaron on 25/11/2014.
 */
public class Course implements WatObject {

    private String title;
    private String subject;
    private int level;
    private String number;
    private String code;
    private int credit;

    public Course(String title, String subject, int level, String number, String code, int credit) {
        this.title = title;
        this.subject = subject;
        this.level = level;
        this.number = number;
        this.code = code;
        this.credit = credit;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public int getLevel() {
        return level;
    }

    public String getNumber() {
        return number;
    }

    public String getCode() {
        return code;
    }

    public int getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", level=" + level +
                ", number='" + number + '\'' +
                ", code='" + code + '\'' +
                ", credit=" + credit +
                '}';
    }
}
