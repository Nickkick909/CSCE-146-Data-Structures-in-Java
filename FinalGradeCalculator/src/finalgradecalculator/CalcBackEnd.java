/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgradecalculator;

import static finalgradecalculator.FinalGradeCalculator.DELIM;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nicho
 */
public class CalcBackEnd {
    private String[] grades;
    
    private int labI;
    private int hwI;
    private int e1I;
    private int e2I;
    private int le1I;
    private int le2I;
    private int fI;
    private int ecI;

    public CalcBackEnd() {
        this.grades = grades;
    }

    public String[] getGrades() {
        return grades;
    }

    public int getLabI() {
        return labI;
    }

    public int getHwI() {
        return hwI;
    }

    public int getE1I() {
        return e1I;
    }

    public int getE2I() {
        return e2I;
    }

    public int getLe1I() {
        return le1I;
    }

    public int getLe2I() {
        return le2I;
    }

    public int getfI() {
        return fI;
    }

    public int getEcI() {
        return ecI;
    }
    

    public void setGrades(String[] grades) {
        this.grades = grades;
    }
    
    
    
    
    private void init(int size){
        if(size>=0){
            grades= new String[size];
        }
    }
    public void readFile(String aFile){
        if(aFile==null)
            return;
        try{
            Scanner fileScanner = new Scanner(new File(aFile));
            int count=0;
            
            while(fileScanner.hasNextLine()){
                fileScanner.nextLine();
                count++; 
            }
            this.init(count);
            fileScanner =new Scanner(new File(aFile));
            count=0;
            while(fileScanner.hasNextLine()){
                String fileLine =fileScanner.nextLine();//read the line
                String[] splitLines=fileLine.split(DELIM);//split the line
                if(splitLines.length==1){//check
                    grades[count]=splitLines[0];
                    count++;
                }
            }
            
            fileScanner.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void findIndex(){
        for(int i=0;i<grades.length;i++){
            if(grades[i].equalsIgnoreCase("Labs"))
                labI=i;
            if(grades[i].equalsIgnoreCase("Homework"))
                hwI=i;
            if(grades[i].equalsIgnoreCase("Exam 1"))
                e1I=i;
            if(grades[i].equalsIgnoreCase("Exam 2"))
                e2I=i;
            if(grades[i].equalsIgnoreCase("Lab Exam 1"))
                le1I=i;
            if(grades[i].equalsIgnoreCase("Lab Exam 2"))
                le2I=i;
            if(grades[i].equalsIgnoreCase("Final"))
                fI=i;
            if(grades[i].equalsIgnoreCase("Extra Credit"))
                ecI=i;
        }
    }
}
