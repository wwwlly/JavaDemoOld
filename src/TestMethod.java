
/**
 * �������β�����ǻ������ͣ��βεĸı䲻��Ӱ��ʵ�Σ����ǻ����������Ӱ�죬
 * �ǻ������͵��βκñ�ʵ�ε����ã�ָ�룩
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
