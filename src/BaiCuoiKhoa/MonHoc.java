package BaiCuoiKhoa;

public class MonHoc {
	String maMH,tenMH;
	float heSoDiem;
	
	public MonHoc() {
		
	}

	public MonHoc(String maMH, String tenMH, float heSoDiem) {
		
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.heSoDiem = heSoDiem;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public float getHeSoDiem() {
		return heSoDiem;
	}

	public void setHeSoDiem(float heSoDiem) {
		this.heSoDiem = heSoDiem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maMH == null) ? 0 : maMH.hashCode());
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
		MonHoc other = (MonHoc) obj;
		if (maMH == null) {
			if (other.maMH != null)
				return false;
		} else if (!maMH.equals(other.maMH))
			return false;
		return true;
	}

	public MonHoc(String maMH) {
		
		this.maMH = maMH;
	}
	
	
	
}
