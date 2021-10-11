package BaiCuoiKhoa;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchFunction {
	public static void timKiem(ArrayList<SinhVien> listSV,ArrayList<MonHoc> listMH,ArrayList<Diem> listD) {
		Scanner sc =new Scanner(System.in);
		int select;
		do {
			System.out.println("1/ tìm kiếm theo mã sinh viên");
			System.out.println("2/ tìm kiếm theo tên sinh viên");
			System.out.println("0/ thoát");
			System.out.println("mời bạn chọn :");
			select=sc.nextInt();
			switch(select) {
			case 1:SearchFunction.timKiemMaSV(listSV, listMH, listD);
				break;
			case 2:SearchFunction.timKiemTenSV(listSV, listMH, listD);
				break;
			case 0:break;
			default :System.out.println("không có lựa chọn");
			}
		}while(select!=0);
	}
	public static void timKiemTenSV(ArrayList<SinhVien> listSV,ArrayList<MonHoc> listMH,ArrayList<Diem> listD) {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhập tên sinh viên tìm kiếm : ");
		String tenSVTimKiem =sc.nextLine();
		try {
			if(tenSVTimKiem.trim().length()==0) {
				throw new Exception("tên sinh viên không được để trống");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			for(int i=0;i<listSV.size();i++) {
				if(tenSVTimKiem.toLowerCase().equals(listSV.get(i).getTen().toLowerCase())) {
					String hoVaTen=listSV.get(i).getHoDem()+" "+listSV.get(i).getTen();
					System.out.println("┎────────────────────────────────────────────────────────────────┒");
					System.out.format("┃%-9s%1s%-32s%1s%15s%1s%5s┃%n",listSV.get(i).getMaSV(),"┃",hoVaTen,"┃",listSV.get(i).getNgaySinh(),"┃",listSV.get(i).getGioiTinh());
					System.out.println("┃────────────────────────────────────────────────────────────────┃");
					float tongDiemTB=0;
					int d=0,d1=0;
					for(int j=0;j<listMH.size();j++) {
						Diem tg=new Diem(listSV.get(i).getMaSV(),listMH.get(j).getMaMH());
						if(listD.contains(tg)) {
							d++;
							tongDiemTB=tongDiemTB+listD.get(listD.indexOf(tg)).getDiem();
						}
					}
					if(d!=0) {
					System.out.format("┃%-50s%-14.2f┃%n","Điểm tổng kết",(float) (tongDiemTB/d));
					}else {
						System.out.format("┃%-50s%-14.2f┃%n","Điểm tổng kết",tongDiemTB);
					}
					System.out.println("┃────────────────────────────────────────────────────────────────┃");
					for(int j=0;j<listMH.size();j++) {
						Diem tg=new Diem(listSV.get(i).getMaSV(),listMH.get(j).getMaMH());
						if(listD.contains(tg)) {
							d1++;
							System.out.format("┃%-10s%-40s%-14.2f┃%n",listMH.get(j).getMaMH(),listMH.get(j).getTenMH(),listD.get(listD.indexOf(tg)).getDiem());
						}
					}
					if(d1==0) {
						System.out.format("┃%64s┃%n","sinh viên chưa có điểm");
					}
					System.out.println("┖────────────────────────────────────────────────────────────────┚");
				}
			}
	}
	public static void timKiemMaSV(ArrayList<SinhVien> listSV,ArrayList<MonHoc> listMH,ArrayList<Diem> listD) {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhập mã sinh viên tìm kiếm : ");
		String maSVTimKiem =sc.nextLine();
		try {
			if(maSVTimKiem.trim().length()==0) {
				throw new Exception("Mã sinh viên không được để trống");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("┎────────────────────────────────────────────────────────────────┒");
		if(listSV.contains(new SinhVien(maSVTimKiem))) {
			for(int i=0;i<listSV.size();i++) {
				if(maSVTimKiem.equals(listSV.get(i).getMaSV())) {
					String hoVaTen=listSV.get(i).getHoDem()+" "+listSV.get(i).getTen();
					System.out.format("┃%-42s%1s%15s%1s%5s┃%n",hoVaTen,"┃",listSV.get(i).getNgaySinh(),"┃",listSV.get(i).getGioiTinh());
					System.out.println("┃────────────────────────────────────────────────────────────────┃");
					float tongDiemTB=0;
					int d=0,d1=0;
					for(int j=0;j<listMH.size();j++) {
						Diem tg=new Diem(listSV.get(i).getMaSV(),listMH.get(j).getMaMH());
						if(listD.contains(tg)) {
							d++;
							tongDiemTB=tongDiemTB+listD.get(listD.indexOf(tg)).getDiem();
						}
					}
					if(d!=0) {
					System.out.format("┃%-50s%-14.2f┃%n","Điểm tổng kết",(float) (tongDiemTB/d));
					}else {
						System.out.format("┃%-50s%-14.2f┃%n","Điểm tổng kết",tongDiemTB);
					}
					System.out.println("┃────────────────────────────────────────────────────────────────┃");
					for(int j=0;j<listMH.size();j++) {
						Diem tg=new Diem(listSV.get(i).getMaSV(),listMH.get(j).getMaMH());
						if(listD.contains(tg)) {
							d1++;
							System.out.format("┃%-10s%-40s%-14.2f┃%n",listMH.get(j).getMaMH(),listMH.get(j).getTenMH(),listD.get(listD.indexOf(tg)).getDiem());
						}
					}
					if(d1==0) {
						System.out.format("┃%64s┃%n","sinh viên chưa có điểm");
					}
				}
			}
		}else {
			System.out.format("┃%-64s┃%n","không có mã sinh viên này");
		}
		System.out.println("┖────────────────────────────────────────────────────────────────┚");
	}
}
