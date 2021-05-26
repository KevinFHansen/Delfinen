package compettition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Team {

    ArrayList<Competitor> juniorMale = new ArrayList<>();
    ArrayList<Competitor> juniorFemale = new ArrayList<>();
    ArrayList<Competitor> seniorMale = new ArrayList<>();
    ArrayList<Competitor> seniorFemale = new ArrayList<>();


    public void initializeTeams() throws FileNotFoundException {

        File[] jMDir = new File("Delfin/Ressources/Competitors/Junior/Male").listFiles();
        File[] jFDir = new File("Delfin/Ressources/Competitors/Junior/Female").listFiles();
        File[] sMDir = new File("Delfin/Ressources/Competitors/Senior/Male").listFiles();
        File[] sFDir = new File("Delfin/Ressources/Competitors/Senior/Female").listFiles();

        for(int i = 0; i < jMDir.length; i++){

            Competitor tempComp = new Competitor(null, 0, null, null);

            tempComp = tempComp.readCompFile("Male", "Junior", jMDir[i].getName());

            juniorMale.add(tempComp);
        }

        for(int i = 0; i < jFDir.length; i++){

            Competitor tempComp = new Competitor(null, 0, null, null);

            tempComp = tempComp.readCompFile("Female", "Junior", jFDir[i].getName());

            juniorFemale.add(tempComp);
        }

        for(int i = 0; i < sMDir.length; i++){

            Competitor tempComp = new Competitor(null, 0, null, null);

            tempComp = tempComp.readCompFile("Male", "Senior", sMDir[i].getName());

            seniorMale.add(tempComp);
        }

        for(int i = 0; i < sFDir.length; i++){

            Competitor tempComp = new Competitor(null, 0, null, null);

            tempComp = tempComp.readCompFile("Female", "Senior", sFDir[i].getName());

            seniorFemale.add(tempComp);
        }
    }

}
