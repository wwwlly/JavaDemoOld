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
     * temp虽然是重新new但由于Bean不是基本类型temp添加的是listStr的引用
     * 在test（）方法里很明确是改变的listStr的元素，和temp new还是不new没有关系
     * 这个方法的本意是在不改变原listStr的前提下返回一个list，这个list和listStr的唯一区别是元素id为1的name是b1；
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
