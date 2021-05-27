package compettition;

import members.Member;
import members.MemberManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
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
                team.printNames(team.juniorMale, team.juniorMale.size());
                System.out.println("Choose competitor");
                int chosenComp = scInt.nextInt()-1;

                competitorToForward = team.juniorMale.get(chosenComp);

            }

            // Female
            else if(chosenGender == 2) {
                team.printNames(team.juniorFemale, team.juniorFemale.size());
                System.out.println("Choose competitor");
                int chosenComp = scInt.nextInt()-1;

                competitorToForward = team.juniorFemale.get(chosenComp);
            }
        }

        // Senior
        else if(chosenGroup == 2){

            // Male
            if(chosenGender == 1){
                team.printNames(team.seniorMale, team.seniorMale.size());
                System.out.println("Choose competitor");
                int chosenComp = scInt.nextInt()-1;

                competitorToForward = team.seniorMale.get(chosenComp);
            }

            // Female
            else if(chosenGender == 2){
                team.printNames(team.seniorFemale, team.seniorFemale.size());
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
        ArrayList<Member> memberList = memberManagement.readMemberList();

        System.out.println(memberList);

        while(!exit){

            teamManagementUI();

            int choice = scInt.nextInt();

            switch(choice){

                case 1:

                    for(int i = 0; i < memberList.size(); i++){
                        System.out.println((i+1) + ". " + memberList.get(i).getName());
                    }

                    System.out.println("Choose member:");
                    int chosenMember = scInt.nextInt()-1;

                    Competitor tempComp = competitor.createCompetitorFromMember(memberList.get(chosenMember));

                    competitor.createCompFile(tempComp);

                    break;

                case 2:
                    Competitor compToUpdateDis = chooseCompetitor();

                    disciplineSubUI();
                    int chosenDiscipline1 = scInt.nextInt()-1;

                    compToUpdateDis.disciplines.get(chosenDiscipline1).registerDiscipline();

                    competitor.createCompFile(compToUpdateDis);

                    break;

                case 3:

                    Competitor compToUpdateRes = chooseCompetitor();

                    disciplineSubUI();
                    int chosenDiscipline2 = scInt.nextInt()-1;

                    compToUpdateRes.disciplines.get(chosenDiscipline2).getResults().add(result.registerResult());

                    competitor.createCompFile(compToUpdateRes);

                    break;

                case 4: // Choose discipline, create ranking list, display list, override tostring
                    team.initializeTeams();
                    ArrayList<Competitor> rankListToPrint = new ArrayList<>();

                    ageGroupSubUI();
                    int chosenGroup = scInt.nextInt();

                    genderSubUI();
                    int chosenGender = scInt.nextInt();

                    // Junior
                    if(chosenGroup == 1){

                        // Male
                        if(chosenGender == 1){

                            Collections.sort(team.juniorMale, new Competitor.rankCrawl());
                            System.out.println("Junior Male Crawl:");
                            team.printNames(team.juniorMale, 5);

                            Collections.sort(team.juniorMale, new Competitor.rankBackCrawl());
                            System.out.println("Junior Male Backcrawl:");
                            team.printNames(team.juniorMale, 5);

                            Collections.sort(team.juniorMale, new Competitor.rankButterfly());
                            System.out.println("Junior Male Butterfly:");
                            team.printNames(team.juniorMale, 5);

                            Collections.sort(team.juniorMale, new Competitor.rankBreaststroke());
                            System.out.println("Junior Male Breaststroke:");
                            team.printNames(team.juniorMale, 5);
                        }

                        // Female
                        else if(chosenGender == 2) {

                            Collections.sort(team.juniorFemale, new Competitor.rankCrawl());
                            System.out.println("Junior Female Crawl:");
                            team.printNames(team.juniorFemale, 5);

                            Collections.sort(team.juniorFemale, new Competitor.rankBackCrawl());
                            System.out.println("Junior Female Backcrawl:");
                            team.printNames(team.juniorFemale, 5);

                            Collections.sort(team.juniorFemale, new Competitor.rankButterfly());
                            System.out.println("Junior Female Butterfly:");
                            team.printNames(team.juniorFemale, 5);

                            Collections.sort(team.juniorFemale, new Competitor.rankBreaststroke());
                            System.out.println("Junior Female Breaststroke:");
                            team.printNames(team.juniorFemale, 5);
                        }
                    }

                    // Senior
                    else if(chosenGroup == 2){

                        // Male
                        if(chosenGender == 1){

                            Collections.sort(team.seniorMale, new Competitor.rankCrawl());
                            System.out.println("Senior Male Crawl:");
                            team.printNames(team.seniorMale, 5);

                            Collections.sort(team.seniorMale, new Competitor.rankBackCrawl());
                            System.out.println("Senior Male Backcrawl:");
                            team.printNames(team.seniorMale, 5);

                            Collections.sort(team.seniorMale, new Competitor.rankButterfly());
                            System.out.println("Senior Male Butterfly:");
                            team.printNames(team.seniorMale, 5);

                            Collections.sort(team.seniorMale, new Competitor.rankBreaststroke());
                            System.out.println("Senior Male Breaststroke:");
                            team.printNames(team.seniorMale, 5);


                        }

                        // Female
                        else if(chosenGender == 2){

                            Collections.sort(team.seniorFemale, new Competitor.rankCrawl());
                            System.out.println("Senior Female Crawl:");
                            team.printNames(team.seniorFemale, 5);

                            Collections.sort(team.seniorFemale, new Competitor.rankBackCrawl());
                            System.out.println("Senior Female Backcrawl:");
                            team.printNames(team.seniorFemale, 5);

                            Collections.sort(team.seniorFemale, new Competitor.rankButterfly());
                            System.out.println("Senior Female Butterfly:");
                            team.printNames(team.seniorFemale, 5);

                            Collections.sort(team.seniorFemale, new Competitor.rankBreaststroke());
                            System.out.println("Senior Female Breaststroke:");
                            team.printNames(team.seniorFemale, 5);

                        }
                    }

                    else {
                        System.out.println("Type 1 or 2 then enter - Try again");
                    }

                    break;

                case 5:
                    exit = true;
                    break;
            }
        }
    }
}
