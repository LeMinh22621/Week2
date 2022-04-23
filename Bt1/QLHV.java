package Bt1;
import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class QLHV {
    private HashMap<String, HocVien> hMap;
    private SortedSet<HocVien> values;
    public static Scanner sc = new Scanner(System.in);
    public QLHV()
    {
        hMap = null;
    }
    private boolean isHasHv(String str)
    {
        return hMap.containsKey(str);
    }
    private HocVien nhapHV()
    {
        if(hMap == null)
            hMap = new HashMap<>();
        HocVien hv = new HocVien();
        try{
            System.out.print("ma    : "); String maHV = sc.nextLine(); 
            if(isHasHv(maHV) == true)
            {
                System.out.println("Da co ma hoc vien trong danh sach");
                return null;
            }
            else
            {
                if(hv.setMaHV(maHV) == false)
                    return null;
            }
                
            System.out.print("hoten : "); String hoTen = sc.nextLine(); 
            if(hv.setHoTen(hoTen) == false)
                return null;

            System.out.print("diachi: "); String diaChi = sc.nextLine(); 
            if(hv.setDiaChi(diaChi) == false)
                return null;

            System.out.print("tuoi: "); String tuoi = sc.nextLine(); 
            if(hv.setTuoi(tuoi) == false)
                return null;
        }
        catch(NoSuchElementException | IllegalStateException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return hv;
    }
    private void nhapThongTin()
    {
        String ch = "";
        do
        {
            HocVien hv = nhapHV();
            if(hv != null)
            {
                hMap.put(hv.getMaHV(), hv);
            }
            else
            {
                System.out.println("Nhap lai!!");;
            }
            System.out.println("Thoat ? nhan y");
            ch = sc.nextLine();
            if(ch.equalsIgnoreCase("y"))
                break;
        }
        while(true);
    }
    private void xuatThongTin()
    {
        if(hMap == null)
        {
            System.out.println("Danh sach rong");
            return;
        }
        // if(sortedArrayList != null)
        //     for(HocVien i : sortedArrayList)
        //         i.xuat();
        // else
            for(HocVien i : hMap.values())
                i.xuat();
    }
    private HocVien timThongTin(String str)
    {
        for(String i :hMap.keySet())
            if (i.equalsIgnoreCase(str))
                return hMap.get(i);
        return null;
    }
    private void sapXep()
    {
        System.out.println("1. ASC");
        System.out.println("2. DESC");
        out:do{
            int ch = 0;
            try{
                ch = Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException ex)
            {
                ch = 0;
            }
            switch(ch)
            {
                case 1:
                    values = new TreeSet<>();
                    values.addAll(hMap.values());
                    break out;
                case 2:
                    values = new TreeSet<>(Collections.reverseOrder());
                    values.addAll(hMap.values());
                    break out;
                default:
                    System.out.print("Nhap lai: ");
                    break;
            }
        }
        while(true);
    }
    private HocVien xoaThongTin(String maHV)
    {
        for(String i :hMap.keySet())
            if (i.equalsIgnoreCase(maHV))
                return hMap.remove(i);
        return null;
    }
    public void menu()
    {
        int ch = 0;
        do{
            System.out.println("--------------MENU--------------");
            System.out.println("|          1. nhap data        |");
            System.out.println("|          2. xuat data        |");
            System.out.println("|          3. tim thong tin    |");
            System.out.println("|          4. sap xep          |");
            System.out.println("|          5. xoa data         |");
            System.out.println("|          6. thoat            |");
            System.out.println("--------------------------------");
            
            try{
                ch = Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException ex)
            {
                ch = 0;
            }
            
            switch(ch)
            {
                case 1:
                    nhapThongTin();
                    break;
                case 2:
                    xuatThongTin();
                    break;
                case 3:
                    String str = "";
                    try {
                        str = sc.nextLine();
                    } 
                    catch (Exception e) {
                        
                    }
                    HocVien hv = timThongTin(str);
                    if(hv == null)
                        System.out.println("Khong tim thay " + str);
                    else
                        hv.xuat();
                    break;
                case 4:
                    sapXep();
                    values.forEach((value) -> value.xuat());
                    break;
                case 5:
                    String maHV = "";
                    try {
                        System.out.print("maHV can xoa : ");
                        maHV = sc.nextLine();
                    } 
                    catch (Exception e) {
                        
                    }
                    HocVien hvx = xoaThongTin(maHV);
                    if(hvx == null)
                        System.out.println("Khong tim thay hoc vien nao can xoa");
                    else
                    {
                        System.out.println("Xoa thanh cong");
                    }
                        
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    break;
            }
        }
        while(true);
    }
    public static void main(String[] args)
    {
        QLHV obj = new QLHV();
        obj.menu();
    }
}
