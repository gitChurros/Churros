package aop_anno;

public class Search implements LogInterface {

	@Override
	public String log(String id) {
		System.out.println("검색: " + id);
		return null;
	}

	
}
