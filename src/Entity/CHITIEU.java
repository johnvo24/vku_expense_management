package Entity;

public class CHITIEU {
	String machitieu, vandechitieu, ngay, sotien, truongan, theanh, chidung, huuthang;
	
	public CHITIEU() {
	}
	
	public CHITIEU(String machitieu, String vandechitieu, String ngay, String sotien, String truongan, String theanh, String chidung, String huuthang) {
		this.machitieu = machitieu;
		this.vandechitieu = vandechitieu;
		this.ngay = ngay;
		this.sotien = sotien;
		this.truongan = truongan;
		this.theanh = theanh;
		this.chidung = chidung;
		this.huuthang = huuthang;
	}

	public String getMachitieu() {
		return machitieu;
	}

	public void setMachitieu(String machitieu) {
		this.machitieu = machitieu;
	}

	public String getVandechitieu() {
		return vandechitieu;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public void setVandechitieu(String vandechitieu) {
		this.vandechitieu = vandechitieu;
	}

	public String getSotien() {
		return sotien;
	}

	public void setSotien(String sotien) {
		this.sotien = sotien;
	}

	public String getTruongan() {
		return truongan;
	}

	public void setTruongan(String truongan) {
		this.truongan = truongan;
	}

	public String getTheanh() {
		return theanh;
	}

	public void setTheanh(String theanh) {
		this.theanh = theanh;
	}

	public String getChidung() {
		return chidung;
	}

	public void setChidung(String chidung) {
		this.chidung = chidung;
	}

	public String getHuuthang() {
		return huuthang;
	}

	public void setHuuthang(String huuthang) {
		this.huuthang = huuthang;
	}
}
