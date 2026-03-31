abstract class SmartDevice{
    String name;
    SmartDevice(String name){
        this.name=name;
    }
    abstract void turn_on();
    abstract void turn_off();
}

class Light extends SmartDevice{
    Light(String name){
        super(name);
    }
    void turn_on(){
        System.out.println(name + " Light Is ON");
    }
    
    void turn_off(){
        System.out.println(name + " Light Is OFF");
    }
}

class Fan extends SmartDevice{
    Fan(String name){
        super(name);
    }
    void turn_on(){
        System.out.println(name + " Light Is ON");
    }
    
    void turn_off(){
        System.out.println(name + " Light Is OFF");
    }
}


class Ac extends SmartDevice{
    Ac(String name){
        super(name);
    }
    void turn_on(){
        System.out.println(name + " Ac Is ON");
    }
    
    void turn_off(){
        System.out.println(name + " Ac Is OFF");
    }
}


interface Trigger{
    boolean istrigger();
}

class motion_trigger implements Trigger{
    public boolean istrigger(){
        return true;
    }
}

class temp_trigger implements Trigger{
    int value;
    temp_trigger(int value){
        this.value=value;
    }
    public boolean istrigger(){
        
        return (value>30)?true:false;
    }
}
class time_trigger implements Trigger{
    int value;
    time_trigger(int value){
        this.value=value;
    }
    public boolean istrigger(){
         return (value>30)?true:false;
    }
}


interface Action{
    void  execute();
}

class turnOnAction implements Action{
    SmartDevice device;
    turnOnAction(SmartDevice device){
        this.device=device;
    }
    public void execute(){
        device.turn_on();
    }
}

class turnOffAction implements Action{
    SmartDevice device;
    turnOffAction(SmartDevice device){
        this.device=device;
    }
    public void execute(){
        device.turn_off();
    }
}


class Rule{
    Trigger t;
    Action a;
    Rule(Trigger t,Action a){
        this.t=t; this.a=a;
    }
    void result(){
        if(t.istrigger()){
            a.execute();;
        }
        else{
            System.out.println("Trigger Condition Not Meet");
        }
    }


}




public class OOPs {
    public static void main(String[] args) {
        SmartDevice d1 = new Light("Philips");
        SmartDevice d2 = new Fan("Compton");
        SmartDevice d3 = new Ac("Voltas");
        Trigger t1 = new motion_trigger();
        Trigger t2 = new temp_trigger(30);
        Trigger t3 = new time_trigger(60);
        Action a1 = new turnOnAction(d1);
        Action a2 = new turnOffAction(d1);
        Rule r1 = new Rule(t1,a1);
        Rule r2 = new Rule(t2,a1);
        Rule r3 = new Rule(t3,a2);
        r1.result();;
        r2.result();
        r3.result();
        
        
    }
}
