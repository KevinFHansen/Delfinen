package compettition;

import members.Member;
import members.MemberManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamManagement {

    Scanner scInt = new Scanner(System.in);
    Scanner scString = new Scanner(System.in);

    Team team = new Team();
    Competitor competitor = new Competitor(null, 0, null, null);
    MemberManagement memberManagement = new MemberManagement();
    Result2 result = new Result2(null, 0, 0.0);

    public void teamManagementUI(){

        System.out.println("Choose an option");

        System.out.println("1. Create competitor from member \n" +
                "2. Register best training time \n" +
                "3. Register competition result \n" +
                "4. View top 5 competitors \n" +
                "5. Exit team management");
    }

    public void ageGroupSubUI(){
        System.out.println("Which age group?");
        System.out.println("1. Junior \n" +
                "2. Senior");
    }

    public void genderSubUI(){
        System.out.println("Which gender?");
        System.out.println("1. Male \n" +
                "2. Female");
    }

    public void disciplineSubUI(){
        System.out.println("Which discipline?");
        System.out.println("1. Crawl \n" +
                "2. Back Crawl \n" +
                "3. Butterfly \n" +
                "4. Breaststroke");
    }

    public Competitor chooseCompetitor() throws FileNotFoundException {
        team.initializeTeams();

        Competitor competitorToForward = new Competitor(null,0,null,null);

        ageGroupSubUI();
        int chosenGroup = scInt.nextInt();

        genderSubUI();
        int chosenGender = scInt.nextInt();

        // Junior
        if(chosenGroup == 1){

            // Male
            if(chosenGender == 1){
                team.printNames(team.juniorMale);
                System.out.println("Choose competitor");
                int chosenComp = scInt.nextInt()-1;

                competitorToForward = team.juniorMale.get(chosenComp);

            }

            // Female
            else if(chosenGender == 2) {
                team.printNames(team.juniorFemale);
                System.out.println("Choose competitor");
                int chosenComp = scInt.nextInt()-1;

                competitorToForward = team.juniorFemale.get(chosenComp);
            }
        }

        // Senior
        else if(chosenGroup == 2){

            // Male
            if(chosenGender == 1){
                team.printNames(team.seniorMale);
                System.out.println("Choose competitor");
                int chosenComp = scInt.nextInt()-1;

                competitorToForward = team.seniorMale.get(chosenComp);
            }

            // Female
            else if(chosenGender == 2){
                team.printNames(team.seniorFemale);
                System.out.println("Choose competitor");
                int chosenComp = scInt.nextInt()-1;

                competitorToForward = team.seniorFemale.get(chosenComp);
            }
        }

        else {
            System.out.println("Type 1 or 2 then enter - Try again");
        }

        return competitorToForward;
    }

    public void runTeamManagement() throws IOException {
        boolean exit = false;

        while(!exit){

            teamManagementUI();

            int choice = scInt.nextInt();

            switch(choice){

                case 1:

                    ArrayList<Member> memberList = memberManagement.readMemberList();

                    System.out.println("Choose member:");

                    for(int i = 0; i < memberList.size(); i++){
                        System.out.println((i+1) + ". " + memberList.get(i).getName());
                    }

                    int chosenMember = scInt.nextInt()-1;

                    Competitor tempComp = competitor.createCompetitorFromMember(memberList.get(chosenMember));

                    competitor.createCompFile(tempComp);

                    break;

                case 2:
                    Competitor compToUpdateDis = chooseCompetitor();

                    disciplineSubUI();
                    int chosenDiscipline1 = scInt.nextInt()-1;

                    compToUpdateDis.disciplines.get(chosenDiscipline1).registerDiscipline();

                    break;

                case 3:

                    Competitor compToUpdateRes = chooseCompetitor();

                    disciplineSubUI();
                    int chosenDiscipline2 = scInt.nextInt()-1;

                    compToUpdateRes.disciplines.get(chosenDiscipline2).results.add(result.registerResult());

                    break;

                case 4:



                    break;

                case 5:
                    exit = true;
                    break;
            }
        }
    }
}
