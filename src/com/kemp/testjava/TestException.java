package com.kemp.testjava;

/**
 * Created by wangkp on 2017/12/7.
 */
public class TestException {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                if(a instanceof Sneeze){
                    System.out.println("a instanceof Sneeze");
                }
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze s) {
            if(s instanceof Sneeze){
                System.out.println("a instanceof Sneeze");
            }
            System.out.println("Caught Sneeze");
            return;
        } finally {
            System.out.println("Hello World!");
        }
    }
}

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}
