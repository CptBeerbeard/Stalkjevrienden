package zbookpc.stalkjevrienden;

public class User {

    private int id;
    private int picture;
    private String phone_number;
    private String password;

    public User() {

    }

    public User(int id, int picture, String phone_number, String password) {
        this.id = id;
        this.picture = picture;
        this.phone_number = phone_number;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}