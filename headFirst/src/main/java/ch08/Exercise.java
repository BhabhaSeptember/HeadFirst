package ch08;

//----- Page 232 Exercise -----

public class Exercise {

//1) Bar ---> (interface) Foo  (i.e. Bar class implements Foo interface) 
  public interface Foo { }
  public class Bar implements Foo { }

//2) Vout ---> (interface) Vinn (i.e. Vout abstract class implements Vinn interface)
  public interface Vinn { }
  public abstract class Vout implements Vinn { }

//3)Muffie ---> (interface) Whuffie (i.e. Muffie abstract class implements Whuffie interface)
// Fluffie -> Muffie (i.e. Fluffie class extends abstract Muffie superclass)  
  public abstract class Muffie implements Whuffie { }
  public class Fluffie extends Muffie { }
  public interface Whuffie { }

//4) Boop -> Zoop (i.e. Boop class extends Zoop superclass)
//Goop -> Boop (i.e. Goop extends Boop class)  
  public class Zoop { }
  public class Boop extends Zoop { }
  public class Goop extends Boop { }

//5) Gamma ---> Epsilon (i.e. Gamma class implements Epsilon interface)
//Gamma -> Delta (i.e. Gamma class extends Delta superclass)
//Alpha ---> Beta (i.e. Alpha implements Beta interface)
//Alpha -> Gamma (i.e. Alpha extends Gamma class)  
  public class Gamma extends Delta implements Epsilon { }
  public interface Epsilon { }
  public interface Beta { }
  public class Alpha extends Gamma implements Beta { }
  public class Delta { }
}

