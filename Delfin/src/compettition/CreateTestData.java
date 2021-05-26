package compettition;

import members.Member;
import members.MemberManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CreateTestData {
    MemberManagement memberManagement = new MemberManagement();
    Competitor competitor = new Competitor(null, 0, null, null);



    public void createTestData() throws IOException {
        ArrayList<Member> memberList = memberManagement.readMemberList();

        for(int i = 0; i < memberList.size(); i++) {

            if(memberList.get(i).getIsMemberActive()) {
                Competitor tempComp = competitor.createCompetitorFromMember(memberList.get(i));

                competitor.createCompFile(tempComp);
            }
        }
    }
}
