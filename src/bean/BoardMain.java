package bean;

import org.springframework.context.support.GenericXmlApplicationContext;

import di_step4.MyDB;
import di_step4.Oracle;

public class BoardMain {
	
	public static void prn(MyDB db) {
		System.out.print(db.getDB());
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("bean/board_context.xml");
		
		MyDB db = ctx.getBean("db", Oracle.class);
		prn(db);
		
	}

}
