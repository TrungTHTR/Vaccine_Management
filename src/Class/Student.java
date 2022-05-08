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
public class Student {
    protected String idStu; 
    protected String nameStu; 

    public Student() {
    }

    public Student(String id, String name) {
        this.idStu = id;
        this.nameStu = name;
    }

    public String getId() {
        return idStu;
    }

    public void setId(String id) {
        this.idStu = id;
    }

    public String getName() {
        return nameStu;
    }

    public void setName(String name) {
        this.nameStu = name;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + idStu + ", name=" + nameStu + '}';
    }
    
}
