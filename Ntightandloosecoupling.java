//tightcoupling
import java.io.*;
import java.util.*;

public class Main {
    public static class Mouse {
        public void click() {
            System.out.println("Mouse is clicked");
        }
    }
    public static void main(String[] args) {
        Mouse m1 = new Mouse();
        m1.click();
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static class Mouse {
        boolean isbluetooth;
        
        Mouse(boolean isbluetooth) {
            this.isbluetooth = isbluetooth;
        }
        
        public void click() {
            if(isbluetooth) {
                System.out.println("Bluetooth used");
            }
            else {
                System.out.println("Normal click");
            }
        }
    }
    public static void main(String[] args) {
        Mouse m1 = new Mouse();
        m1.click();
    }
}
//Now you will get an error
//Now we have to change main class by adding true
import java.io.*;
import java.util.*;

public class Main {
    public static class Mouse {
        boolean isbluetooth;
        
        Mouse(boolean isbluetooth) {
            this.isbluetooth = isbluetooth;
        }
        
        public void click() {
            if(isbluetooth) {
                System.out.println("Bluetooth used");
            }
            else {
                System.out.println("Normal click");
            }
        }
    }
    public static void main(String[] args) {
        Mouse m1 = new Mouse(true);
        m1.click();
    }
}

//Loose coupling
interface Mouse {
    void click();
}

class WiredMouse implements Mouse {
    public void click() {
        System.out.println("Wired Mouse clicked");
    }
}

class BluetoothMouse implements Mouse {
    public void click() {
        System.out.println("Bluetooth Mouse clicked wirelessly");
    }
}

class Computer {
    Mouse mouse;

    Computer(Mouse mouse) {
        this.mouse = mouse;
    }

    void useMouse() {
        mouse.click();
    }
}
Computer comp1 = new Computer(new WiredMouse());
Computer comp2 = new Computer(new BluetoothMouse());
