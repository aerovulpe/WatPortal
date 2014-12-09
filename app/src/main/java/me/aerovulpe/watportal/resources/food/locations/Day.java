package me.aerovulpe.watportal.resources.food.locations;

import org.json.JSONException;
import org.json.JSONObject;

import static me.aerovulpe.watportal.Constants.CLOSING_HOUR_KEY;
import static me.aerovulpe.watportal.Constants.IS_CLOSED_KEY;
import static me.aerovulpe.watportal.Constants.OPENING_HOUR_KEY;

enum DayName{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

/**
 * Created by Aaron on 01/12/2014.
 */
public class Day {
    private final DayName dayName;
    private String closing_hour;
    private boolean is_closed;
    private String opening_hour;

    public Day(DayName dayName) {
        this.dayName = dayName;
    }

    public String getClosing_hour(){
        return this.closing_hour;
    }
    public void setClosing_hour(String closing_hour){
        this.closing_hour = closing_hour;
    }
    public boolean getIs_closed(){
        return this.is_closed;
    }
    public void setIs_closed(boolean is_closed){
        this.is_closed = is_closed;
    }
    public String getOpening_hour(){
        return this.opening_hour;
    }
    public void setOpening_hour(String opening_hour){
        this.opening_hour = opening_hour;
    }

    public DayName getDayName() {
        return dayName;
    }


    public void setFields(JSONObject jsonObject) throws JSONException{
        setOpening_hour(jsonObject.getString(OPENING_HOUR_KEY));
        setClosing_hour(jsonObject.getString(CLOSING_HOUR_KEY));
        setIs_closed(jsonObject.getBoolean(IS_CLOSED_KEY));
    }

    @Override
    public String toString() {
        return "Day{" +
                "dayName=" + dayName +
                ", closing_hour='" + closing_hour + '\'' +
                ", is_closed=" + is_closed +
                ", opening_hour='" + opening_hour + '\'' +
                '}';
    }
}
