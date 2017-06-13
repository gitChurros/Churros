package di_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Qualifier2 {

	private Member user;
	
	@Autowired
	@Qualifier("guest")
	public void setUser(Member m) {
		this.user = m;
	}
	
	public Member getUser() {
		return user;
	}
}
