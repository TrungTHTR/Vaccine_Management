package Class;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class Vaccine {
    protected String idVac;
    protected String nameVac;

    public Vaccine() {
    }

    public Vaccine(String idVac, String nameVac) {
        this.idVac = idVac;
        this.nameVac = nameVac;
    }

    public String getIdVac() {
        return idVac;
    }

    public void setIdVac(String idVac) {
        this.idVac = idVac;
    }

    public String getNameVac() {
        return nameVac;
    }

    public void setNameVac(String nameVac) {
        this.nameVac = nameVac;
    }

    @Override
    public String toString() {
        return "Vaccine{" + "idVac=" + idVac + ", nameVac=" + nameVac + '}';
    }

 
}

