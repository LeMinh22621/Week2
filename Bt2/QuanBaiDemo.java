// package Bt2;

import java.util.ArrayList;
public class QuanBaiDemo
{
    private ArrayList<QuanBai> arrayList;
    private int n;

    public QuanBaiDemo()
    {
        arrayList = new ArrayList<>();
        n = 0;
    }
    public void displayInfo(){
        for(QuanBai i : arrayList)
        {
            i.toString();
        }
    }
    public ArrayList<QuanBai> inputInfo()
    {
        if(arrayList.size() == 0)
            arrayList = new ArrayList<>();
        System.out.println("exp: ");
        for(int i = 1; i <= 13; i++)
        {
            if(i >= 2 && i <= 10)
                continue;
            System.out.println("\t"+i +". "+ QuanBai.swap2[i-1]);
        }
        System.out.println("exp: ");
        for(int i = 1; i <= QuanBai.swap.length; i++)
        {
            System.out.println("\t"+i + ". " + QuanBai.swap[i-1]);
        }
         
        while(n++ <= 52)
        {
            QuanBai b = new QuanBai();

            System.out.print("exp = ");b.setExp(Integer.parseInt(QuanBai.sc.nextLine()));
            System.out.print("point = ");b.setPoint(Integer.parseInt(QuanBai.sc.nextLine()));
            
            
            System.out.println();
            arrayList.add(b);
            System.out.println("Thoat ? y");

            String s = QuanBai.sc.nextLine();
            if(s.compareToIgnoreCase("y") == 0)
                break;
        }
        return arrayList;
    }
    public static void main(String[] args)
    {
        QuanBaiDemo m = new QuanBaiDemo();
        m.inputInfo();
        m.displayInfo();
    }
}