import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TestList {

    
    private List<Bean> listStr = new ArrayList<>();
    
    public TestList(){
    	for(int i = 0; i < 3;i ++){
    		Bean bean = new Bean();
    		bean.id = i;
    		bean.name = "a" + i;
    		listStr.add(bean);
    	}
    }
    
    /**
     * temp��Ȼ������new������Bean���ǻ�������temp��ӵ���listStr������
     * ��test�������������ȷ�Ǹı��listStr��Ԫ�أ���temp new���ǲ�newû�й�ϵ
     * ��������ı������ڲ��ı�ԭlistStr��ǰ���·���һ��list�����list��listStr��Ψһ������Ԫ��idΪ1��name��b1��
     * @return
     */
    public List<Bean> test(){
    	List<Bean> temp = new ArrayList<>();
    	for (Bean bean : listStr) {
			if(bean.id == 1){
				bean.name = "b1";
			}
			temp.add(bean);
		}
    	return temp;
    }
    
    public void printList(List<Bean> list){
    	for (Bean bean : list) {
			System.out.print(bean.toString() + "\n");
		}
    }

	public List<Bean> getListStr() {
		return listStr;
	}
}
