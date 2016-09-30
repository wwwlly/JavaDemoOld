
/**
 * 方法中形参如果是基本类型，形参的改变不会影响实参；而非基本类型则会影响，
 * 非基本类型的形参好比实参的引用（指针）
 * @author wangkp
 *
 */
public class TestMethod {

	private int a = 1;
	private Bean bean = new Bean();
	
	private void testA(int i){
		i += 2;
	}
	
	private void testBean(Bean bean){
		bean.id = 2;
		bean.name = "www";
	}
	
	public static void main(String[] args) {
		TestMethod t = new TestMethod();
		t.testA(t.a);
		System.out.println(t.a);
		t.testBean(t.bean);
		System.out.println(t.bean);
	}
}
