package BaiCuoiKhoa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static ArrayList<SinhVien> listSV=new ArrayList<>();
	static ArrayList<MonHoc> listMH=new ArrayList<>();
	static ArrayList<Diem> listD=new ArrayList<>();
	public static void main(String[] args) {
		String dataRoot="";
		for (int i = 0; i < args.length; i++) {
			dataRoot=args[i];
		}
		File sv_txt=new File(dataRoot+"/sinhvien_en.txt");
		listSV=LoadFile.loadFileSinhVien(sv_txt);
		File mh_txt=new File(dataRoot+"/monhoc_en.txt");
		listMH=LoadFile.loadFileMonHoc(mh_txt);
		File diem_txt=new File(dataRoot+"/diem.txt");
		listD=LoadFile.loadFileDiem(diem_txt);
		Scanner sc= new Scanner(System.in);
		int select;
		do {
			System.out.println("1/ cập nhập thông tin sinh viên ");
			System.out.println("2/ hiện thị bảng điểm sinh viên");
			System.out.println("3/ Tìm kiếm sinh viên");
			System.out.println("0/ thoát");
			System.out.println(" chọn : ");
			select=sc.nextInt();
			switch(select) {
			case 1: UpdateStudentInformation.menuChucNang1(listSV, listMH, listD);
				break;
			case 2: DisplayScoreboard.hienThiBangDiem(listSV, listMH, listD);
				break;
			case 3: SearchFunction.timKiem(listSV, listMH, listD);
				break;
			case 0:System.out.println("bạn đã thoát");
				break;
			default : System.out.println("không có chọn lựa");
			}
		}while(select!=0);
		loadFile(sv_txt);
		loadFile2(diem_txt);
	}
	private static void loadFile(File sv_txt) {
		FileWriter fwt=null;
		BufferedWriter bfw=null;
		try {
			fwt=new FileWriter(sv_txt);
			bfw=new BufferedWriter(fwt);
			bfw.write("#Ma - Ho dem - Ten - Ngay sinh - Gioi tinh");
			bfw.newLine();
			for(int i=0;i<listSV.size();i++) {
				bfw.write(listSV.get(i).getMaSV()+";"+listSV.get(i).getHoDem()+";"+listSV.get(i).getTen()+";"+listSV.get(i).getNgaySinh()+";"+listSV.get(i).getGioiTinh());
				bfw.newLine();
			}
			bfw.close();fwt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void loadFile2(File d_txt) {
		FileWriter fwt=null;
		BufferedWriter bfw=null;
		try {
			fwt=new FileWriter(d_txt);
			bfw=new BufferedWriter(fwt);
			bfw.write("# ma sinh vien; ma mon hoc; diem");
			bfw.newLine();
			for(int i=0;i<listD.size();i++) {
				String diem =String.format("%.2f", listD.get(i).getDiem());
				bfw.write(listD.get(i).getMaSV()+";"+listD.get(i).getMaMH()+";"+diem);
				bfw.newLine();
			}
			bfw.close();
			fwt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
