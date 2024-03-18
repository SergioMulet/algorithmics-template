package algstudent.s11;

import java.util.Date;

public class test {

	public static void main(String arg []){
		System.out.println(System.currentTimeMillis());
		long l = Long.MAX_VALUE;
		Date d = new Date(l);
		System.out.println(d);
	}
}
