package me.aerovulpe.watportal.resources.food.locations;

import java.text.ParseException;
import java.util.Date;
import static me.aerovulpe.watportal.constants.Constants.*;

/**
 * Created by Aaron on 27/11/2014.
 */
public class Special_hours {
    private Date date;
    private String opening_hour;
    private String closing_hour;

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        try {
            this.date = DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getOpening_hour() {
        return opening_hour;
    }

    public void setOpening_hour(String opening_hour) {
        this.opening_hour = opening_hour;
    }

    public String getClosing_hour() {
        return closing_hour;
    }

    public void setClosing_hour(String closing_hour) {
        this.closing_hour = closing_hour;
    }

    @Override
    public String toString() {
        return "Special_hours{" +
                "date=" + date +
                ", opening_hour='" + opening_hour + '\'' +
                ", closing_hour='" + closing_hour + '\'' +
                '}';
    }
}
