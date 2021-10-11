package BaiCuoiKhoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UpdateStudentInformation {
	public static void menuChucNang1(ArrayList<SinhVien> listSV,ArrayList<MonHoc> listMH,ArrayList<Diem> listD) {
		Scanner sc1=new Scanner(System.in);
		int select;
		do {
			System.out.println("1/ thêm một sinh viên");
			System.out.println("2/ sửa thông tin sinh viên");
			System.out.println("3/ xóa sinh viên");
			System.out.println("4/ hiển thị thông tin sinh viên được sắp xếp theo tên");
			System.out.println("5/ hiện thị danh sách môn học");
			System.out.println("0/ thoát");
			System.out.println("chọn : ");
			select=sc1.nextInt();
			switch(select) {
			case 1: themSV(listSV);
				break;
			case 2: suaSV(listSV, listMH, listD);
				break;
			case 3: xoaSV(listSV, listD);
				break;
			case 4: hienThiSV(listSV, listMH, listD);
				break;
			case 5:hienThiDSMH(listMH);
				break;
			case 0: break;
			default : System.out.println("không có lựa chọn phù hợp");
			}
		}while(select!=0);
	}
	public static void themSV(ArrayList<SinhVien> listSV) {
		Scanner sc2=new Scanner(System.in);
		System.out.println("nhập mã sinh viên : ");
		String masvMoi=sc2.nextLine();
		try {
			if(masvMoi.trim().length()==0) {
				throw new Exception("mã sinh viên không được để trống ");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		SinhVien svMoi=new SinhVien(masvMoi);
		if(listSV.contains(svMoi)==true) {
			System.err.println("trùng mã sinh viên");
			return;
		}else {
			System.out.println("nhập ho đệm : ");
			svMoi.setHoDem(sc2.nextLine());
			System.out.println("nhập tên : ");
			svMoi.setTen(sc2.nextLine());
			System.out.println("nhập giới tính : ");
			svMoi.setGioiTinh(sc2.nextLine());
			System.out.println("nhập ngày sinh : ");
			svMoi.setNgaySinh(sc2.nextLine());
			if(masvMoi.trim().length()!=0)
			listSV.add(svMoi);
		}
	}
	public static void suaSV(ArrayList<SinhVien> listSV,ArrayList<MonHoc> listMH,ArrayList<Diem> listD){
		Scanner sc=new Scanner(System.in);
		System.out.println("nhập mã sinh viên bạn muốn sửa : ");
		String maSVSua=sc.nextLine();
		try {
			if(maSVSua.trim().length()==0) {
				throw new Exception("Mã sinh viên không được để trống");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		SinhVien svSua=new SinhVien(maSVSua);
		int select;
		String maMHSua;
		if(listSV.contains(svSua)) {
			do {
				System.out.println("1/ sửa thông tin sinh viên");
				System.out.println("2/ sửa điểm của sinh viên");
				System.out.println("0/ thoát");
				select=sc.nextInt();
				switch(select) {
				case 1:
					for(int i=0;i<listSV.size();i++) {
						if(maSVSua.equals(listSV.get(i).getMaSV())) {
						System.out.println(" sửa họ đệm ");
							sc.nextLine();
							listSV.get(i).setHoDem(sc.nextLine());
						System.out.println("sửa tên ");
							listSV.get(i).setTen(sc.nextLine());
						System.out.println("sửa ngày sinh ");
							listSV.get(i).setNgaySinh(sc.nextLine());
						System.out.println("sửa giới tính ");
							listSV.get(i).setGioiTinh(sc.nextLine());
							break;
						}
					}
					break;
				case 2:
					System.out.println("nhập mã môn : ");
					sc.nextLine();
					maMHSua=sc.nextLine();
					MonHoc mh=new MonHoc(maMHSua);
					if(!listMH.contains(mh)) {
						System.out.println("không có mã môn này");
					}else {
					Diem d=new Diem(maSVSua, maMHSua);
					if(listD.contains(d)) {
						for(int i=0;i<listD.size();i++) {
							if(maMHSua.equals(listD.get(i).getMaMH())&&maSVSua.equals(listD.get(i).getMaSV())) {
								System.out.println("sửa điểm : ");
								listD.get(i).setDiem(sc.nextFloat());
							}
						}
					}
					else{
						System.out.println("sinh viên chưa có điểm môn học này");
					}
					}
					break;
				case 0: break;
				default : System.out.println("không có lựa chọn này");
				}	
			}while(select!=0);
		}else {
			System.err.println("khong có mã sv này ");
			return;
		}
	}
	public static void xoaSV(ArrayList<SinhVien> listSV,ArrayList<Diem> listD) {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhập mã sv muốn xóa: ");
		String maSVXoa=sc.nextLine();
		try {
			if(maSVXoa.trim().length()==0) {
				throw new Exception("Mã sinh viên không được để trống");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		int d=0;
		for(int i=0;i<listD.size();i++) {
			if(maSVXoa.equals(listD.get(i).getMaSV())) {
				System.err.println("không được xóa vì sinh này đã có điểm");
				return;
			}else d++;
		}
		if(d!=0)
		for(int i=0;i<listSV.size();i++) {
			if(maSVXoa.equals(listSV.get(i).getMaSV())) {
				System.out.println("Bạn có muốn xóa không : 1/Yes   2/No   3/Cancel");
				int select=sc.nextInt();
				if(select==1) {
				listSV.remove(i);
				System.out.println("Bạn đã xóa thành công");
				}
				else break;
			}
		}
	}
	public static void hienThiDSMH(ArrayList<MonHoc> listMH) {
		System.out.println("┎────────────────────────────────────────────────────────────────┒");
		System.out.format("┃%15s%2s%30s%2s%15s┃%n","mã môn học","┃","tên môn học","┃","hệ số điểm");
		System.out.println("┃────────────────────────────────────────────────────────────────┃");
		for(int i=0;i<listMH.size();i++) {
			System.out.format("┃%15s%2s%30s%2s%15.1f┃%n",listMH.get(i).getMaMH(),"┃",listMH.get(i).getTenMH(),"┃",listMH.get(i).getHeSoDiem());
		}
		System.out.println("┖────────────────────────────────────────────────────────────────┚");
	}
	public static void hienThiSV(ArrayList<SinhVien> listSV,ArrayList<MonHoc> listMH,ArrayList<Diem> listD) {
		Scanner sc=new Scanner(System.in);
		int select;
		int page=1;
		indata(page, listSV, listMH, listD);
		System.out.println("=============1=============");
		do {
			System.out.format("%15s%15s%15s%n","1. next page","2. prev page","3. last page");
			System.out.format("%15s%15s%15s%n","4. first page","5. goto page","0. exit");
			System.out.println("chọn :");
			select=sc.nextInt();
			switch(select) {
			case 1:
				page++;
				indata(page, listSV, listMH, listD);
				System.out.println("============="+page+"=============");
				break;
			case 2:
				page--;
				indata(page, listSV, listMH, listD);
				System.out.println("============="+page+"=============");
				break;
			case 3:
				page=listSV.size()/30+1;
				indata(page, listSV, listMH, listD);
				System.out.println("==============Cuối==============");
				break;
			case 4:
				page=1;
				indata(page, listSV, listMH, listD);
				System.out.println("=============1=============");
				break;
			case 5:System.out.println("mời bạn nhập trang bạn muốn đến : ");
				page=sc.nextInt();
				indata(page, listSV, listMH, listD);
				System.out.println("============="+page+"=============");
				break;
			case 0: break;
			default : System.out.println("không có lựa chọn");
			}
		}while(select!=0);
	}
	private static void indata(int page,ArrayList<SinhVien> listSV,ArrayList<MonHoc> listMH,ArrayList<Diem> listD) {
		Comparator<SinhVien> c=new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getTen().toLowerCase().compareTo(o2.getTen().toLowerCase());
			}
		};
		Collections.sort(listSV, c);
		if(page<=0) {
			System.err.println("đang là trang đầu nên không quay về truoc đuoc nữa");
			return;
		}
		int perPage=30;
		int start,end;
		start=(page-1)*perPage;
		end=start+perPage;
		if(end>listSV.size()) end=listSV.size();
		System.out.println("tổng số trang là : "+listSV.size()/perPage);
		System.out.println("┎────────────────────────────────────────────────────────────────┒");
		System.out.format("┃%10s%1s%20s%1s%10s%1s%10s%1s%10s┃%n","mã sv","┃","họ đệm","┃","tên","┃","ngày sinh","┃","giới tính");
		System.out.println("┃────────────────────────────────────────────────────────────────┃");
		for(int i=start;i<end;i++) {
			System.out.format("┃%10s%1s%20s%1s%10s%1s%10s%1s%10s┃%n",listSV.get(i).getMaSV(),"┃",listSV.get(i).getHoDem(),"┃",listSV.get(i).getTen(),"┃",listSV.get(i).getNgaySinh(),"┃",listSV.get(i).getGioiTinh());
		}
		System.out.println("┖────────────────────────────────────────────────────────────────┚");
	}
}
