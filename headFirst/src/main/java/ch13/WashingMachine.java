package ch13;

public class WashingMachine {

    public void go() {
        Laundry laundry = new Laundry();

//1) MULTIPLE EXCEPTIONS EXAMPLE
//If doLaundry() throws a PantsException, it lands in PantsException catch block    
//If doLaundry() throws a LingerieException, it lands in LingerieException catch block      
//        try {
//            laundry.doLaundry();
//        } catch (PantsException pex) {
//            // recovery code
//
//        } catch (LingerieException lex) {
//            // recovery code
//        }
//
//2) CATCHING EXCEPTIONS USING SUPERCLASS
//if subclasses must handle exceptions in a unique manner, we can add unique 
//catch blocks for them but the ClothingException superclass can handle 
//exceptions for all other subtypes types if they can be handled in the same way
//
//Inheritance tree dictates the order in which you can order exception catch blocks
//Exceptions in same hierachy level can be ordered in any way because they cant
//catch each others exceptions
//Exceptions higher up the inheritance tree must be placed last otherwise
//they will catch all the subclass exceptions rendering their unique declarations
//useless.. So exceptions lower down in inheritance tree must be placed at the top
try {
            laundry.doLaundry();
        } 
         catch(TeeShirtException tex) {
        //recovery code
        }
        catch (ClothingException cex) {
            //recovery code
        }
        
    }//END OF GO() METHOD
}
