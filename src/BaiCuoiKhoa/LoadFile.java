package BaiCuoiKhoa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class LoadFile {
	public static ArrayList<Diem> loadFileDiem(File diem_txt) {
		ArrayList<Diem> list=new ArrayList<>();
		FileReader fRead=null;
		BufferedReader bfd=null;
		try {
			fRead=new FileReader(diem_txt);
			bfd=new BufferedReader(fRead);
			String line;
			while((line=bfd.readLine())!=null) {
				if(line.startsWith("#")) continue;
				String data[]=line.split(";");
				float diem=Float.valueOf(data[2]);
				Diem d=new Diem(data[0], data[1], diem);
				list.add(d);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fRead!=null) fRead.close();
				if(bfd!=null) bfd.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public static ArrayList<SinhVien> loadFileSinhVien(File sv_txt) {
		ArrayList<SinhVien> list=new ArrayList<>();
		FileReader fRead=null;
		BufferedReader bfd=null;
		try {
			fRead =new FileReader(sv_txt);
			bfd=new BufferedReader(fRead);
			String line;
			while((line=bfd.readLine())!=null) {
				if(line.startsWith("#")) continue;
				String data[]=line.split(";");
				SinhVien sv=new SinhVien(data[0], data[1], data[2], data[3], data[4]);
				list.add(sv);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fRead!=null) fRead.close();
				if(bfd!=null) bfd.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public static ArrayList<MonHoc> loadFileMonHoc(File mh_txt) {
		ArrayList<MonHoc> list=new ArrayList<MonHoc>();
		FileReader fRead=null;
		BufferedReader bfd=null;
		try {
			fRead=new FileReader(mh_txt);
			bfd=new BufferedReader(fRead);
			String line;
			while((line=bfd.readLine())!=null) {
				if(line.startsWith("#")) continue;
				String data[]=line.split(";");
				float hsd= Float.valueOf(data[2]);
				MonHoc mh=new MonHoc(data[0],data[1],hsd);
				list.add(mh);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fRead!=null) fRead.close();
				if(bfd!=null) bfd.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
