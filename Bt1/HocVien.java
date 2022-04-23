package Bt1;
import java.util.regex.Pattern;

public class HocVien implements Comparable<HocVien>
{
    private String maHV;
    private String hoTen;
    private String diaChi;
    private int tuoi;
    public static String patternMaHV = "^[a-zA-Z0-9]+";
    public static String patternHoTen = "[a-zA-Z\s]+";
    public static String patternDiaChi = "[A-Za-z0-9\s,_-]*";
    public static String patternTuoi = "1[8-9]|2[0-5]";


    public boolean checkMaHV(String str)
    {
        return Pattern.matches(patternMaHV, str);
    }
    public boolean checkHoTen(String str)
    {
        return Pattern.matches(patternHoTen, str);
    }
    public boolean checkDiaChi(String str)
    {
        return Pattern.matches(patternDiaChi, str);
    }
    public boolean checkTuoi(String str)
    {
        return Pattern.matches(patternTuoi, str);
    }

    public int getTuoi() {
        return tuoi;
    }
    public String getMaHV() {
        return maHV;
    }
    public boolean setMaHV(String maHV) {
        boolean rs = false;
        if(checkMaHV(maHV))
        {
            this.maHV = maHV;
            rs = true;
        }
        return rs;
            
    }
    public String getHoTen() {
        return hoTen;
    }
    public boolean setHoTen(String hoTen) {
        boolean rs = false;
        if(checkHoTen(hoTen))
        {
            this.hoTen = hoTen;
            rs = true;
        }
        return rs;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public boolean setDiaChi(String diaChi) {
        boolean rs = false;
        if(checkDiaChi(diaChi))
        {
            this.diaChi = diaChi;
            rs = true;
        }
        return rs;
        
    }
    public boolean setTuoi(String tuoi) {
        boolean rs = false;
        if(checkTuoi(tuoi))
        {
            this.tuoi = Integer.parseInt(tuoi);
            rs = true;
        }
        return rs;
    }

    public void xuat()
    {
        System.out.println(this.maHV + "\t\t" + this.hoTen + "\t\t" + this.tuoi + "\t\t" + this.diaChi);
    }
    public boolean compareASC(HocVien hv)
    {
        return this.tuoi >= hv.getTuoi();
    }
    public boolean compareDESC(HocVien hv)
    {
        return this.tuoi < hv.getTuoi();
    }
    @Override
    public int compareTo(HocVien o) {
        return (this.tuoi - o.getTuoi()) == 0? 1:this.tuoi - o.getTuoi();
    }
}