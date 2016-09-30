import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static int ii = 0;
	private static final int MODE_SHIFT = 30;
    private static final int MODE_MASK  = 0x3 << MODE_SHIFT;

    /**
     * Measure specification mode: The parent has not imposed any constraint
     * on the child. It can be whatever size it wants.
     */
    public static final int UNSPECIFIED = 0 << MODE_SHIFT;

    /**
     * Measure specification mode: The parent has determined an exact size
     * for the child. The child is going to be given those bounds regardless
     * of how big it wants to be.
     */
    public static final int EXACTLY     = 1 << MODE_SHIFT;

    /**
     * Measure specification mode: The child can be as large as it wants up
     * to the specified size.
     */
    public static final int AT_MOST     = 2 << MODE_SHIFT;

	public static void main(String[] args) {
		int i = 127;
		// i = new Integer(1);
		Integer ii = new Integer(127);
		Integer ii1 = new Integer(127);
		// ii = 128;
		// ii1 = 128;
		// ii = i;
		// System.out.println(i + "," + ii + "," + (i == ii));
		System.out.println(ii == ii1);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		i = Integer.MAX_VALUE + 1;
		System.out.println(i);
//		byte b = (byte)'a';
//		System.out.println(b);
		byte[] b = "a".getBytes();
		System.out.println(b[0] + "," + b.length);
		// assert false : "cuo wu";
		// System.out.println("assert");
		// +=的优先级小于+、-
//		String str = "";
//		for (i = 0; i < 3; i++) {
//			str += i + ",";
//		}
//		System.out.println(str);
//		ii = 0;
		for (for1(); for2(ii); for3(ii)) {
			System.out.println("test for");
		}
		int mask = 0x1;
		System.out.println(mask >> -6);
		CharSequence c = "A";
		int l = c.charAt(0);
		char cc = 'A';
		Integer integer = new Integer(65);
		System.out.println(integer.byteValue());
//		TestList test = new TestList();
//    	test.printList(test.getListStr());
//    	System.out.println();
//    	test.printList(test.test());
//    	System.out.println();
//    	test.printList(test.getListStr());

    	System.out.println();
    	TestBean testBean = new TestBean();
    	System.out.println(testBean.getBean());
    	System.out.println(testBean.test());
    	System.out.println(testBean.getBean());
	}

	private static void for1() {
		System.out.println("for1");
	}

	private static boolean for2(int i) {
		System.out.println("for2,i = " + i);
		return ii < 3;
	}

	private static void for3(int i) {
		ii++;
		System.out.println("for3,i = " + i);
	}

	static class Inner {
		public void test() {
			System.out.println("test");
		}
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Visi{}
}
