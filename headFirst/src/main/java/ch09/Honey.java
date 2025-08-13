package ch09;

class Bees {
  Honey[] beeHoney;
}

class Raccoon {
  Kit rk;
  Honey rh;
}

class Kit {
  Honey honey;
}

class Bear {
  Honey hunny;
}

public class Honey {
  public static void main(String[] args) {
    Honey honeyPot = new Honey();  // (1x Honey)
    Honey[] ha = {honeyPot, honeyPot, honeyPot, honeyPot}; // (4x Honey)
    
    Bees bees = new Bees();
    bees.beeHoney = ha; // (1x Honey references same object as 'ha' above)
    
    Bear[] bears = new Bear[5];
    for (int i = 0; i < 5; i++) {
      bears[i] = new Bear();
      bears[i].hunny = honeyPot; //(5x Honey)
    }
    Kit kit = new Kit();
    kit.honey = honeyPot; // (1x Honey)
    
    Raccoon raccoon = new Raccoon();
    raccoon.rh = honeyPot; // (1x Honey)
    raccoon.rk = kit; // (1x Honey)
    kit = null; // (-1x Honey)
  } //  end of main
}

// ----- Page 269 Exercises -----

