package Class;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ACER
 */
public class Injection implements Comparable<Injection> {

    public String ID;
    public Date injDate1;
    public Date injDate2;
    public String stuID;
    public String vacID;
    public String injPlace1;
    public String injPlace2;

    public Injection() {
    }

    public Injection(String ID, Date injDate1, Date injDate2, String stuID, String vacID, String injPlace1, String injPlace2) {
        this.ID = ID;
        this.injDate1 = injDate1;
        this.injDate2 = injDate2;
        this.stuID = stuID;
        this.vacID = vacID;
        this.injPlace1 = injPlace1;
        this.injPlace2 = injPlace2;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getInjDate1() {
        return injDate1;
    }

    public void setInjDate1(Date injDate1) {
        this.injDate1 = injDate1;
    }

    public Date getInjDate2() {
        return injDate2;
    }

    public void setInjDate2(Date injDate2) {
        this.injDate2 = injDate2;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getVacID() {
        return vacID;
    }

    public void setVacID(String vacID) {
        this.vacID = vacID;
    }

    public String getInjPlace1() {
        return injPlace1;
    }

    public void setInjPlace1(String injPlace1) {
        this.injPlace1 = injPlace1;
    }

    public String getInjPlace2() {
        return injPlace2;
    }

    public void setInjPlace2(String InjPlace2) {
        this.injPlace2 = InjPlace2;
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if (injDate2 != null && injPlace2 != null) {
            return "Injection{" + "ID=" + ID + ", injDate1=" + df.format(injDate1) 
                    + ", injDate2=" + df.format(injDate2) + ", stuID=" + stuID+ ", vacID=" + vacID 
                    + ", injPlace1=" + injPlace1 + ", InjPlace2=" + injPlace2 + '}';
        } else {
            return "Injection{" + "ID=" + ID + ", injDate1=" + df.format(injDate1) + ", injDate2=" + "null" + ", stuID=" + stuID
                    + ", vacID=" + vacID + ", injPlace1=" + injPlace1 + ", InjPlace2=" + " null" + '}';
        }
    }

    @Override
    public int compareTo(Injection o) {
        if (getID() == null || o.getID() == null) {
            return 0;
        }
        return getID().compareTo(o.getID());
    }
    }
