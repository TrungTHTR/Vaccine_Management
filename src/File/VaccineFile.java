/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Class.Student;
import Class.Vaccine;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class VaccineFile extends ArrayList<Vaccine> {

    public ArrayList<Vaccine> listVaccine = new ArrayList<>();

    public void writeVaccine() {
        try {
            String fileName = "Vaccine.txt";
            FileWriter fw = new FileWriter(fileName);
            listVaccine.add(new Vaccine("COVID-V001", "AstraZeneca"));
            listVaccine.add(new Vaccine("COVID-V002", "SPUTNIK V"));
            listVaccine.add(new Vaccine("COVID-V003", "Vero Cell"));
            listVaccine.add(new Vaccine("COVID-V004", "Pfizer"));
            listVaccine.add(new Vaccine("COVID-V005", "Moderna"));
            for (Vaccine vc : listVaccine) {
                fw.write(vc.toString());
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isIDExist(String ID) {
        return searchID(ID) != null;
    }

    public Vaccine searchID(String id) {
        for (Vaccine vc : listVaccine) {
            if (vc.getIdVac().equals(id)) {
                return vc;
            }
        }
        return null;
    }

    public void printList() {
        for (Vaccine vc : listVaccine) {
            System.out.println(vc.toString());
        }
        System.out.println("Size List:" + listVaccine.size());
    }

}
