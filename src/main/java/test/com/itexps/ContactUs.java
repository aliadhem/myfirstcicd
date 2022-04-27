/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com.itexps;

/**
 *
 * @author Owner
 */
public class ContactUs {
    private String uname;
    private String pass;
    private String uemail;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public ContactUs(String uname, String pass, String uemail) {
        this.uname = uname;
        this.pass = pass;
        this.uemail = uemail;
    }

    @Override
    public String toString() {
        return "ContactUs{" + "uname=" + uname + ", pass=" + pass + ", uemail=" + uemail + '}';
    }
    
    
}
