package project0.doctorsprescriptor;

/**
 * Created by volser on 3/15/2018.
 */

public class user {
    private String name;
    private String phone;
    private String time;
    private String date;
    private String message;

    public user() {

    }

    public user(String name, String phone, String time, String date, String message) {
        this.name = name;
        this.phone = phone;
        this.time = time;
        this.date = date;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
