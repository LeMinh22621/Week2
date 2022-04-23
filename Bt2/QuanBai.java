//package Bt2;

import java.util.Scanner;

public class QuanBai {
    public static String[] swap = {"Co", "Ro", "Chuon", "Bich"};
    public static String[] swap2 = {"A","2","3","4","5","6","7","8","9","10","J", "Q", "K"};
    private String name = "";
    private int point;
    private int exp;
    public static Scanner sc = new Scanner(System.in);

    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
        name += swap2[exp-1];
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
        name += " " + swap[point-1];
    }
    
    public String toString()
    {
        String rs = this.name + "\t\t\t\t" + this.point + "\t\t\t\t" + this.exp;
        System.out.println(rs);
        return rs;
    }
}
