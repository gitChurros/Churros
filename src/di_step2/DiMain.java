package di_step2;

/*	DI형태의 구조물이 만들어지지 않은 상태로
 	서로 다른 환경에서는 코드를 그 때 그 때 다시 디버깅 해야 함  */


public class DiMain {
	
	public static void prn(MyDB db) {
		System.out.print(db.getDB());
	}
	
	public static void main(String[] args) {

		// 김씨
		MyDB sql = new MySql();
		prn(sql);
	
		// 박씨
		MyDB sql2 = new Oracle();
		prn(sql2);
		
		// 홍씨
		MyDB sql3 = new MsSql();
		prn(sql3);
	}
}
