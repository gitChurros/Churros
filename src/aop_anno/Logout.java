package aop_anno;

public class Logout implements LogInterface {

	@Override
	public String log(String id) {
		System.out.println(id + " 로그아웃");
		return null;
	}

	
}
