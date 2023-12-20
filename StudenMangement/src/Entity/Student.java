package Entity;

public class Student {
    Integer Student_id;
    Integer Roll_No;
    String Student_Name;
    String  Address; 
    Integer Mobile_Number;


    public Integer getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(Integer student_id) {
        Student_id = student_id;
    }

    public Integer getRoll_No() {
        return Roll_No;
    }

    public void setRoll_No(Integer roll_No) {
        Roll_No = roll_No;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getMobile_Number() {
        return Mobile_Number;
    }

    public void setMobile_Number(Integer mobile_Number) {
        Mobile_Number = mobile_Number;
    }
}
