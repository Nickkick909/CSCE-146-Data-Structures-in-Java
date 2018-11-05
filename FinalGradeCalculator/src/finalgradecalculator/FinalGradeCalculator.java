package finalgradecalculator;

/**
 *Written by Nicholas Knight
 */ 
import java.util.Scanner;
import java.io.*;
public class FinalGradeCalculator {

    /**
     * @param args the command line arguments
     */
    public static final double EXAM=10.0;
    public static final double HW=30.0;
    public static final double LAB=20.0;
    public static final double EC=2.0;
    public static final String DELIM ="\n";
    public static final String FILE= "grades.txt";

    
    
    public static void main(String[] args) {
        // TODO code application logic here
        double labAv=0;
        double hwAv=0;
        //double rawTotal=0;
        double exam1=0;
        double exam2=0;
        double labE1=0;
        double labE2=0;
        double ec=0;
        double finalE=0;
        double finalGrade=0;
        String finalLetter="A";
        CalcBackEnd back= new CalcBackEnd();
        
        
        back.readFile(FILE);
        back.findIndex();
        
        //time to set the values
        exam1=Integer.parseInt(back.getGrades()[back.getE1I()+1]);
        exam2=Integer.parseInt(back.getGrades()[back.getE2I()+1]);
        labE1=Integer.parseInt(back.getGrades()[back.getLe1I()+1]);
        labE2=Integer.parseInt(back.getGrades()[back.getLe2I()+1]);
        finalE=Integer.parseInt(back.getGrades()[back.getfI()+1]);
        
        //now for the average values
        int count =0;
        for(int i= back.getLabI()+1;i<back.getHwI();i++){
            labAv+= Integer.parseInt(back.getGrades()[i]);
            count++;
        }
        labAv/=count;
        
        count =0;
        int lowest=100; //100 because the that is highest possible grade
        for(int i= back.getHwI()+1;i<back.getE1I();i++){
            hwAv+= Integer.parseInt(back.getGrades()[i]);
            count++;
            if(lowest>Integer.parseInt(back.getGrades()[i]))
                lowest=Integer.parseInt(back.getGrades()[i]);
            
        }
        hwAv-=lowest;
        hwAv/=count-1;      //-1 bc of dropped grade
        
        
        count =0;
        for(int i=back.getEcI()+1;i<back.getEcI()+5;i++){ //ecI+5 bc only 5 ec assignments
            if(Integer.parseInt(back.getGrades()[i])==100){
                count++;
            }
            ec=count*100;       //to make each ec assignment worth 2%
        }
        
        finalGrade=((LAB/100)*labAv) + ((HW/100)*hwAv) + ((EXAM/100)*labE1)
                + ((EXAM/100)*labE2) + ((EXAM/100)*exam1) + ((EXAM/100)*exam2)
                + ((EXAM/100)*finalE)+((EC/100)*(ec));
        finalGrade=Math.ceil(finalGrade);
        
        if(finalGrade>=90.0)
            finalLetter="A";
        if(finalGrade<90.0 && finalGrade>=85.0)
            finalLetter="B+";
        if(finalGrade<90.0 && finalGrade>=85.0)
            finalLetter="B+";
        if(finalGrade<85.0 && finalGrade>=80.0)
            finalLetter="B";
        if(finalGrade<80.0 && finalGrade>=75.0)
            finalLetter="C+";
        if(finalGrade<75.0 && finalGrade>=70.0)
            finalLetter="C";
        if(finalGrade<70.0 && finalGrade>=65.0)
            finalLetter="D+";
        if(finalGrade<65.0 && finalGrade>=60.0)
            finalLetter="D";
        if(finalGrade<60.0)
            finalLetter="F";
        
        
        System.out.println("Your lab average is "+ labAv);
        System.out.println("Your homework average is "+hwAv);
        System.out.println("Your first exam is "+exam1);
        System.out.println("Your second exam is "+exam2);
        System.out.println("Your first lab exam is "+labE1);
        System.out.println("Your second lab exam is "+labE2);
        System.out.println("Your extra credit total is "+ec/50+ " points");
        System.out.println("Your final is "+finalE);
        System.out.println("Your raw total is "+ finalGrade);
        System.out.println("Your final grade is "+finalLetter);
        
        /*for(int i=0;i<back.getGrades().length;i++){
            System.out.println(back.getGrades()[i]);
        }*/
    }
    
    
}
