package db;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MemberAdivce {
	// @Around = 어드바이스, before, after도 어드바이스 
	@Around("execution (* db.MemberDao.*(..))") // db_context.xml에 bean을 등록 해야 Around가 실행
	public Object logPrint(ProceedingJoinPoint jp) throws Throwable {
		Object obj = null;
		String file = "log.txt";
		FileOutputStream fos = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {
			fos = new FileOutputStream(file, true);
			
			obj = jp.proceed(); // jp.proceed() 기준으로 위 소스는 before, 아래 소스는 afterThrowing로 구분,
			// 리턴값은 Object이므로 Aspect로 연결된 Original Method의 리턴값을 받을 수 있다 
			
			MemberDao d = (MemberDao)jp.getTarget();
			String sql = d.getSql();
			
			String now = sdf.format(new Date());
			String cName = jp.getTarget().getClass().getName();
			String mName = jp.getSignature().getName();
			String temp = now + "\t" + cName + "\t" + mName + "\t" + sql + "\t";
			System.out.println(temp);
		
			fos.write(temp.getBytes(), 0, temp.getBytes().length);
			
			fos.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return obj;
	}

}
