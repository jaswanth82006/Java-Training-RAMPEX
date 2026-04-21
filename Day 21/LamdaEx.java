@FunctionalInterface
interface Math{
    int add(int a,int b);
}

@FunctionalInterface
interface Exersice{
    void sayhello();
}


public class LamdaEx{
    public static void main(String[] args) {
        Math obj = (a,b)->{
            System.out.println("Adding 2 numbers,...");
            return a+b;
        };
        Exersice ex = ()->System.out.print("Hello...");
      /*   Math obj = new Math(){
            @Override
            public int add(int a, int b){
                return a+b;
            }
        };
*/
        System.out.print(obj.add(5,6));
        ex.sayhello();
    }
}