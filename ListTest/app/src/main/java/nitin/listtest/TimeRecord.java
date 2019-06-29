package nitin.listtest;

/**
 * Created by nitin on 6/22/14.
 */
public class TimeRecord {

    private String time;
    private String notes;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TimeRecord(String time, String notes) {
        this.time = time;
        this.notes = notes;
    }
}
