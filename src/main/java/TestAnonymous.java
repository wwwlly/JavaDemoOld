/**
 * Inner Class���ڲ��ࣩ���������е��ࡣ
 * Nested Class��Ƕ���ࣩ�Ǿ�̬��static���ڲ��ࡣ
 * Anonymous Inner Class �������ڲ��ࣩ�������ڲ�����û�����ֵ��ڲ��ࡣ
 * �����ڲ�����Լ̳������࣬��������extends������ʵ��ĳһ���ӿڣ���������implements��
 * �����ڲ������˼��û�����ֵ��ڲ��࣬û�����־Ͳ����й��������ͱ�����û���Ĺ����������Ե�Ȼ���Լ̳�
 * Created by wangkp on 2017/12/7.
 */
public class TestAnonymous {

    public static void main(String[] args) {
        test(new Test(){});
    }

    private static void test(Test test) {

    }

}

class Test {

}

class Test1 {

}

interface Test2 {

}
