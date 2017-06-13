package aop_anno;

public class Login implements LogInterface {

	@Override
	public String log(String id) {
		System.out.println("로그인: " + id);
		return null;
	}
	
	
}
