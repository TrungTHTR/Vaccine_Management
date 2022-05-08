/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Class.Injection;
import File.StudentFile;
import File.VaccineFile;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class InjectionList extends ArrayList<Injection> implements Injection_List {

    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    ArrayList<Injection> list = new ArrayList<>();

    int choice = 0;
    Injection inj = null;
    int index = -1;
    String id = "";
    String name = "";
    boolean check = false;

    Date injDate1;
    Date injDate2;
    String stuId = "";
    String vacId = "";
    String place1;
    String place2 = null;

    StudentFile stl;
    VaccineFile vcl;

    public InjectionList() {
    }

    public InjectionList(StudentFile stl, VaccineFile vcl) {
        this.stl = stl;
        this.vcl = vcl;
    }

    @Override
    public void show() {
        if (list.isEmpty()) {
            System.out.println("LIST IS EMPTY!!");
        } else {
            Collections.sort(list, new Comparator<Injection>() {
                @Override
                public int compare(Injection o1, Injection o2) {
                    return o2.compareTo(o1);
                }
            });
            for (Injection inj : list) {
                System.out.println(inj.toString());
            }
            storeData();
        }
    }

    @Override
    public void add() {
        do {
            System.out.println("ADD FUNCTION");
            System.out.println("1.Add");
            System.out.println("0.Exit");
            choice = Utils.getInt("Input your Choice: ", "Input Again!");
            switch (choice) {
                case 1:
                    id = Utils.getString("Input Injection ID:", "Try Again!");
                    if (isIDExist(id)) {
                        System.out.println("Duplicated!");
                        break;
                    } else {
                        stuId = Utils.getStudentID("Input Student ID: ", "Student don't exist", stl);
                        if(isStuIDExist(stuId)){
                            System.out.println("Student ID have been ADD!!!");
                            System.out.println("ADD UNSUCCESSFUL!!");
                            break;
                        }
                        vacId = Utils.getVaccineID("Input Vaccine ID: ", "Vaccine doesn't exist", vcl);
                        injDate1 = Utils.getDate();
                        place1 = Utils.getString("Input 1st Injection Place:", "Try Again");
                        injDate2 = Utils.getDate2("Date 2[dd/mm/yy]:", injDate1);
                        if (injDate2 != null) {
                            place2 = Utils.getString("Input 2st Injection Place:", "Try Again");
                        } else {
                            place2 = null;
                        }
                        list.add(new Injection(id, injDate1, injDate2, stuId, vacId, place1, place2));
                        System.out.println("Add successful");
                    }
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    @Override
    public void update() {
        if (list.isEmpty()) {
            System.out.println("LIST IS EMPTY");
        } else {
            id = Utils.getString("Input Injection ID:", "Try Again!");
            if (isIDExist(id)) {
                for (Injection ij : list) {
                    if (ij.getID().equals(id)) {
                        index = list.indexOf(ij);
                        if (index != -1) {
                            if (list.get(index).injDate2 == null) {
                                injDate2 = Utils.getDate2("Date 2[dd/mm/yy]:", list.get(index).getInjDate1());
                                list.get(index).setInjDate2(injDate2);
                                if (list.get(index).injDate2 != null) {
                                    place2 = Utils.getString("Input 2nd Injection Place:", "Try Again");
                                    list.get(index).setInjPlace2(place2);
                                    System.out.println("UPDATE SUCCESSFULL!!");
                                    System.out.println("STUDENT HAS COMPLETED 2 INJECTIONS...!");
                                } else {
                                    System.out.println("CANCEL UPDATE!");
                                }
                            } else {
                                System.out.println("STUDENT HAS COMPLETED 2 INJECTIONS");
                            }
                        }
                    }
                }
            } else {
                System.out.println("INJECTION DOESN'T EXIST!");
            }
        }
    }

    @Override
    public void delete() {
        if (list.isEmpty()) {
            System.out.println("LIST IS EMPTY");
        } else {
            System.out.println("Are you sure want to remove ?");
            System.out.println("1.yes");
            System.out.println("2.no");
            choice = Utils.getInt("Input Your Choice:", "Input Again!");
            switch (choice) {
                case 1:
                    id = Utils.getString("Input Injection ID:", "Try Again!");
                    if (isIDExist(id)) {
                        inj = search(id);
                        check = list.remove(inj);
                        Utils.printTF(check, "REMOVE SUCCESS!", "CAN' REMOVE!");
                    } else {
                        System.out.println("INJECTION DOESN'T EXIST!");
                    }
                    break;
                case 2:
                    System.out.println("CANCEL DELETE!");
                    break;
                default:
                    System.out.println("WRONG INPUT!");
            }
        }
    }

    @Override
    public void searchByStuID() {
        if (list.isEmpty()) {
            System.out.println("LIST IS EMPTY");
        } else {
            stuId = Utils.getString("Input Student ID: ", "Try Again");
            ArrayList<Injection> listFoundStuID = listFoundStuID(list, stuId);
            if (listFoundStuID.isEmpty()) {
                System.out.println("STUDENT DOES NOT EXIST!");
            } else {
                for (Injection inject : listFoundStuID) {
                    inj = inject;
                    System.out.println(inj.toString());
                }
            }
        }
    }

    @Override
    public void storeData() {
        try {
            FileWriter fw = new FileWriter("injection.txt");
            for (Injection inj : list) {
                fw.write(inj.toString());
                fw.write("\n");
            }
            System.out.println("Save successfull!");
            fw.close();
        } catch (Exception e) {
            System.out.println("Save Error!!");
        }
    }

    @Override
    public void createdata() {
        df.setLenient(false);
        try {
            list.add(new Injection("1", df.parse("13/11/2001"), null, "SE123", "COVID-V001", "FPT", null));
            list.add(new Injection("2", df.parse("14/12/2002"), df.parse("14/1/2003"), "SE789", "COVID-V003", "BV THANH PHO", "FPT"));
            list.add(new Injection("3", df.parse("15/1/2003"), null, "SE234", "COVID-V004", "FPT", null));
            list.add(new Injection("4", df.parse("23/9/2006"), df.parse("23/10/2006"), "SE753", "COVID-V005", "BV THANH PHO", "FPT"));
            list.add(new Injection("5", df.parse("29/8/2021"), df.parse("29/8/2021"), "SE456", "COVID-V006", "FPT", "FPT"));
        } catch (ParseException e) {
            System.out.println("INVALID DATE! TRY AGAIN!");
        }
    }

    private boolean isIDExist(String ID) {
        return search(ID) != null;
    }

    private Injection search(String id) {
        if (!list.isEmpty()) {
            for (Injection in : list) {
                if (in.getID().equals(id)) {
                    return in;
                }
            }
        }
        return null;
    }
    
    
    private boolean isStuIDExist(String ID) {
        return searchStuID(ID) != null;
    }

    private Injection searchStuID(String id) {
        if (!list.isEmpty()) {
            for (Injection in : list) {
                if (in.stuID.equals(id)) {
                    return in;
                }
            }
        }
        return null;
    }
    
    private ArrayList<Injection> listFoundStuID(ArrayList<Injection> lf, String keyword) {
        ArrayList<Injection> listfoundname = new ArrayList<Injection>();
        for (Injection ij : lf) {
            if (ij.getStuID().contains(keyword)) {
                listfoundname.add(ij);
            }
        }
        return listfoundname;
    }
    
    
}
