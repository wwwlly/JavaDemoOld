public class TestExtends {

    private static void test(){
        C e = new E();
        if(e instanceof D){
            System.out.println("instanceof");
        }
        C f = new F();
        if(f instanceof D){
            System.out.println("instanceof");
        }
    }

    public static void main(String[] args){
        test();
    }
}

interface C{

}

interface D extends C{

}

class E implements D{

}

class F extends E{

}

