package BaiCuoiKhoa;

public class Diem {
	String maSV ,maMH;
	float diem;
	
	public Diem() {
		
	}

	public Diem(String maSV, String maMH, float diem) {
		
		this.maSV = maSV;
		this.maMH = maMH;
		this.diem = diem;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maMH == null) ? 0 : maMH.hashCode());
		result = prime * result + ((maSV == null) ? 0 : maSV.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diem other = (Diem) obj;
		if (maMH == null) {
			if (other.maMH != null)
				return false;
		} else if (!maMH.equals(other.maMH))
			return false;
		if (maSV == null) {
			if (other.maSV != null)
				return false;
		} else if (!maSV.equals(other.maSV))
			return false;
		return true;
	}

	public Diem(String maSV, String maMH) {
		this.maSV = maSV;
		this.maMH = maMH;
	}

	public Diem(String maSV) {
		this.maSV = maSV;
	}
	
	
	
}
