package compettition;

import java.util.ArrayList;
import java.util.Scanner;

public class Result2 {
    String compName;
    int placement;
    double compTime;

    public Result2(String compName, int placement, double compTime) {
        this.compName = compName;
        this.placement = placement;
        this.compTime = compTime;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public double getCompTime() {
        return compTime;
    }

    public void setCompTime(double compTime) {
        this.compTime = compTime;
    }


    public Result2 registerResult() {
        Scanner sc = new Scanner(System.in);
        Result2 tempResult = new Result2(null, 0, 0.0);

        System.out.println("Type in competition name: ");
        tempResult.setCompName(sc.nextLine());

        System.out.println("Type in placement");
        tempResult.setPlacement(sc.nextInt());

        System.out.println("Type in time");
        tempResult.setCompTime(sc.nextDouble());

        return tempResult;
    }
}
