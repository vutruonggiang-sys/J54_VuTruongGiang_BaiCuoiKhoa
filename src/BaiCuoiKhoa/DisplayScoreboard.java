package BaiCuoiKhoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DisplayScoreboard {
	public static void hienThiBangDiem(ArrayList<SinhVien> listSV,ArrayList<MonHoc> listMH,ArrayList<Diem> listD) {
		Scanner sc=new Scanner(System.in);
		int page=1;
		indataDiemTB(page, listSV, listMH, listD);
		System.out.println("============="+page+"=============");
		int select;
		do {
			System.out.format("%15s%15s%15s%n","1. next page","2. prev page","3. last page");
			System.out.format("%15s%15s%15s%n","4. first page","5. goto page","0. exit");
			System.out.println("chọn :");
			select=sc.nextInt();
			switch(select) {
			case 1:page++;
				indataDiemTB(page, listSV, listMH, listD);
			System.out.println("============="+page+"=============");
				break;
			case 2: page--;
				indataDiemTB(page, listSV, listMH, listD);
			System.out.println("============="+page+"=============");
				break;
			case 3: page=listSV.size()/30+1;
				indataDiemTB(page, listSV, listMH, listD);
			System.out.println("============="+page+"=============");
				break;
			case 4: page=1;
				indataDiemTB(page, listSV, listMH, listD);
			System.out.println("============="+page+"=============");
				break;
			case 5: System.out.println("mời bạn nhập trang cụ thể : ");
					page=sc.nextInt();
					indataDiemTB(page, listSV, listMH, listD);
					System.out.println("============="+page+"=============");
					break;
			case 0:break;
			default : System.out.println("chưa có lựa chọn");
			}
		}while(select!=0);
	}
	public static void indataDiemTB(int page,ArrayList<SinhVien> listSV,ArrayList<MonHoc> listMH,ArrayList<Diem> listD) {
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
		end=start+30;
		if(end>listSV.size()) end=listSV.size();
		System.out.println("tổng số trang là : "+listSV.size()/perPage);
		for(int i=start;i<end;i++) {
			System.out.println("┎────────────────────────────────────────────────────────────────┒");
			String hoVaTen=listSV.get(i).getHoDem()+" "+listSV.get(i).getTen();
			System.out.format("┃%5s%10s%1s%32s%1s%15s┃%n","mã :",listSV.get(i).getMaSV(),"┃",hoVaTen,"┃",listSV.get(i).getNgaySinh());
			System.out.println("┃────────────────────────────────────────────────────────────────┃");
			int d=0,d1=0;
			float tongDiemTB=0;
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
				System.out.format("┃%64s┃%n","sinh viên chưa có điểm trung bình");
			}
			System.out.println("┖────────────────────────────────────────────────────────────────┚");
		}
	}
}
