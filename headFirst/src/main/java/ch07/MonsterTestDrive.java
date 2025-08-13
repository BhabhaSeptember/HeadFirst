package ch07;

//----- Page 195 Exercise -----
public class MonsterTestDrive {

    public static void main(String[] args) {
        Monster[] monsters = new Monster[3];
        monsters[0] = new Vampire();
        monsters[1] = new Dragon();
        monsters[2] = new Monster();

        for (int i = 0; i < monsters.length; i++) {
            // uncomment to do the exercise
            monsters[i].frighten(i);
        }
    }
}

class Monster {

    boolean frighten(int d) {
        System.out.println("arrrgh");
        return true;
    }

}

class Vampire extends Monster {

    @Override
    boolean frighten(int x) {
        System.out.println("a bite?");
        return false;
    }
}

class Dragon extends Monster {

    @Override
    boolean frighten(int degree) {
        System.out.println("breathe fire");
        return true;
    }
}

//===========================================================
//----- Page 195 Exercise -----
//1) ANSWER: The combination below would compile because, 
//the return type & argument list is the same so it's a legal override
//
//A) Monster class
//boolean frighten(int d) {
//  System.out.println("arrrgh");
//  return true;
//}
//B) Vampire class
//boolean frighten(int x) {
//  System.out.println("a bite?");
//  return false;
//}
//2) Answer: Below would not compile because although argument list is the same,
//the return type in subclass is different to superclass
//therefor it is not a legal override or method overload
//
//A) Monster class
//boolean frighten(int x) {
//  System.out.println("arrrgh");
//  return true;
//}
//B) Vampire class
//int frighten(int f) {
//  System.out.println("a bite?");
//  return 1;
//}
//3) ANSWER: The method name in subclass is not the same as superclass,
//so compiler would consider the scare method as a new, unique method to subclass,
//and not as an override of the superclass method
//
//A) Monster class
//boolean frighten(int x) {
//  System.out.println("arrrgh");
//  return false;
//}
//B) Vampire class
//boolean scare(int x) {
//  System.out.println("a bite?");
//  return true;
//}
//4) ANSWER: Below is not a legal override, the subclass argument list is
//different to superclass 
//
//A) Monster class
//boolean frighten(int z) {
//  System.out.println("arrrgh");
//  return true;
//}
//
//B) Vampire class
//boolean frighten(byte b) {
//  System.out.println("a bite?");
//  return true;
//}
