package compettition;

import members.Member;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Competitor extends Member{
    private double rank;
    private String ageGroup;
    ArrayList<Discipline> disciplines = new ArrayList<>();

    public Competitor(String name, int age, String gender) {
        super(name, age, gender);

        if(age < 18){
            this.ageGroup = "Junior";
        }
        else{
            this.ageGroup = "Senior";
        }
    }

    public double calcRank(){
        // calculate rank from results
        double calcRank = 0.0;

        return calcRank;
    }

    // create competitor csv
    public void createCompFile(Competitor comp) throws IOException {

        if(comp.getAge() < 18){
            ageGroup = "Junior";
        }
        else{
            ageGroup = "Senior";
        }

        PrintWriter writer = new PrintWriter(new FileWriter("Delfin/Ressources/Team/" + ageGroup + "/" + comp.getGender() + "/" + comp.getName() + ".csv"));

        writer.print("");

        writer.println("Age;Gender;Type;Distance;BestTrainingTime;CompetitionName;Placement;Time");

        for (int i = 0; i < disciplines.size(); i++){
            for(int j = 0; j < disciplines.get(i).getResults().size(); i++){

                writer.print(comp.getAge() + ";" + comp.getGender() + ";");
                writer.print(disciplines.get(i).getType() + ";" + disciplines.get(i).getDistance() + ";" + disciplines.get(i).getBestTraining() + ";");

                writer.print(disciplines.get(i).getResults().get(j).getCompName() + ";");
                writer.print(disciplines.get(i).getResults().get(j).getPlacement() + ";");
                writer.println(disciplines.get(i).getResults().get(j).getCompTime());
            }
        }
        writer.close();
    }

    // read comp csv
    public Competitor readCompFileToArray(String gender, String ageGroup, String memberName) throws FileNotFoundException {
        File compFile = new File("Delfin/Ressources/Competitors" + ageGroup + "/" + gender + "/" + memberName + ".csv");
        Scanner scFile = new Scanner(compFile);

        ArrayList<String[]> competitorArrays = new ArrayList<>();

        scFile.nextLine();

        while (scFile.hasNext()){

            String thisLine = scFile.nextLine();
            String[] lineAsArray = thisLine.split(";");
            competitorArrays.add(lineAsArray);
        }

        Competitor competitor = new Competitor(memberName, parseInt(competitorArrays.get(0)[0]), competitorArrays.get(0)[1]);

        // Age;Gender;Type;Distance;BestTrainingTime;CompetitionName;Placement;Time

        if(competitorArrays.size() == 1){
            disciplines.get(0).setType(competitorArrays.get(0)[2].trim());
            disciplines.get(0).setDistance(Integer.parseInt(competitorArrays.get(0)[3].trim()));
            disciplines.get(0).setBestTraining(Double.parseDouble(competitorArrays.get(0)[4].trim()));


        }
        else {
            int count = 0;
            int count2 = 0;

            for (int i = 1; i < competitorArrays.size(); i++) {

                if(competitorArrays.get(i-1)[2].equals(competitorArrays.get(i)[2])) {

                    disciplines.get(i-count+count2).getResults().get(count).setCompName(competitorArrays.get(count)[5].trim());
                    disciplines.get(i-count+count2).getResults().get(count).setPlacement(Integer.parseInt(competitorArrays.get(count)[6].trim()));
                    disciplines.get(i-count+count2).getResults().get(count).setCompTime(Double.parseDouble(competitorArrays.get(count)[7].trim()));

                    count++;
                }

                if (i % count != 0) {
                    disciplines.get(i-count+count2).setType(competitorArrays.get(i-count+count2)[2].trim());
                    disciplines.get(i-count+count2).setDistance(Integer.parseInt(competitorArrays.get(i-count+count2)[3].trim()));
                    disciplines.get(i-count+count2).setBestTraining(Double.parseDouble(competitorArrays.get(i-count+count2)[4].trim()));

                    count = i;
                    count2++;

                }
            }
        }
        return competitor;
    }

    /** Age;Gender;Type;Distance;BestTrainingTime;CompetitionName;Placement;Time
     **/
}
