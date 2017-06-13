package aop_anno;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx= 
				new GenericXmlApplicationContext("aop_anno/Login.xml");
		
		LogInterface login = ctx.getBean("login", LogInterface.class); // LogInterface.class = 타입
		login.log("윤성훈");
		
		LogInterface logout = ctx.getBean("logout", LogInterface.class);
		logout.log("윤성훈");
		
		// LogInterface search = ctx.getBean("search", Search.class);
		// search.log("검색");
		
	}
}
