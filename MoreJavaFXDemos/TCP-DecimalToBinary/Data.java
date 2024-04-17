import java.io.Serializable;

public class Data implements Serializable {
	private int num;
	private String bNum;
	public Data(int num, String bNum) {
		this.num = num;
		this.bNum = bNum;
	}
	public int getNum() {
		return num;
	}        
	public void setNum(int num) {
		this.num = num;
	}
	public String getBinaryNum() {
		return bNum;
	}
	public void setBinaryNum(String bNum) {
		this.bNum = bNum;
	}       
}