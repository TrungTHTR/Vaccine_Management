/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Class.Student;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class StudentFile extends ArrayList<Student> {
    ArrayList<Student> listStudent = new ArrayList<>();

    public void writeStudent() {
        try {
            String fileName = "student.txt";
            FileWriter fw = new FileWriter(fileName);
            listStudent.add(new Student("SE123", "Bao Dai"));
            listStudent.add(new Student("SE234", "Hung Vuong"));
            listStudent.add(new Student("SE456", "Tran Hung Dao"));
            listStudent.add(new Student("SE789", "Quang Trung"));
            listStudent.add(new Student("SE753", "Nguyen Hue"));          
            listStudent.add(new Student("SE159", "Nguyen A"));
            listStudent.add(new Student("SE987", "Nguyen B"));
            listStudent.add(new Student("SE654", "Nguyen C"));
            listStudent.add(new Student("SE357", "Nguyen D"));
            listStudent.add(new Student("SE046", "Nguyen F"));            
            for (Student st : listStudent) {
                fw.write(st.toString());
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean isIDExist(String ID){
        return searchID(ID) != null;
    }
    
    public Student searchID(String id){
        for(Student st : listStudent){
            if(st.getId().equals(id)){
                return st;
            }
        }
        return null;
    }
    
    
    public void printList(){
        for(Student st: listStudent){
            System.out.println(st.toString());
        }
        System.out.println("Size List:"+listStudent.size());
    }
}
