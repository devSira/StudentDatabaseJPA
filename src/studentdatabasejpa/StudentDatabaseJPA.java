/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tstudentlate file, choose Tools | Tstudentlates
 * and open the tstudentlate in the editor.
 */
package studentdatabasejpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Siraphob.B
 */
public class StudentDatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       Student student1 = new Student(1, "John", 4.00);
//       Student student2 = new Student(2, "Marry", 3.99);
//       StudentTable.insertStudent(student1);
//       StudentTable.insertStudent(student2);
//       Student student;
//       student = StudentTable.findStudentById(1);
//       if (student != null) {
//           student.setName("Jack");
//           StudentTable.removeStudent(student);
//           StudentTable.updateStudent(student);
//       }
//       List<Student> studentList = StudentTable.findStudentByName("Marry"); 
//       List<Student> studentList = StudentTable.findAllStudent();
//       printAllStudent(studentList);
    }
    
    public static void printAllStudent(List<Student> studentList) {
        for(Student student : studentList) {
           System.out.print(student.getId() + " ");
           System.out.print(student.getName() + " ");
           System.out.println(student.getGpa() + " ");
       }
    }
    
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
