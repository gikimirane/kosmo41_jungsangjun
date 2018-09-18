package jsp.member.model;

import java.sql.Timestamp;

//데이터의 전달을 담당하는 클래스 - DTO
public class MemberDto {
	
	private String id;            // 아이디
    private String pw;     // 비밀번호
    private String name;        // 이름
    private String birthyy;        // 생일 - 년
    private String birthmm;        // 생일 - 월
    private String birthdd;        // 생일 - 일
    private String eMail1;        // 이메일 - @ 앞부분
    private String eMail2;        // 이메일 - @ 뒷부분
    private String phone1;        // 전화
    private String phone2;        // 전화
    private String phone3;        // 전화
    private Timestamp reg;        // 가입일
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthyy() {
		return birthyy;
	}
	public void setBirthyy(String birthyy) {
		this.birthyy = birthyy;
	}
	public String getBirthmm() {
		return birthmm;
	}
	public void setBirthmm(String birthmm) {
		this.birthmm = birthmm;
	}
	public String getBirthdd() {
		return birthdd;
	}
	public void setBirthdd(String birthdd) {
		this.birthdd = birthdd;
	}
	public String geteMail1() {
		return eMail1;
	}
	public void seteMail1(String eMail1) {
		this.eMail1 = eMail1;
	}
	public String geteMail2() {
		return eMail2;
	}
	public void seteMail2(String eMail2) {
		this.eMail2 = eMail2;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
    
	
}
