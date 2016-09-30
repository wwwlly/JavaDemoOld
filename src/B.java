
public class B extends A{

	@Override
	public void testA(int i) {
		// TODO Auto-generated method stub
		super.testA(i);
		System.out.println("B:testA()" + i);
	}
	
	public static void main(String[] args) {
		B b = new B();
		b.testA();
	}
}
