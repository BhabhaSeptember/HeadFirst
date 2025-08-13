package ch04;

public class Mix4 {
  int counter = 0;

  public static void main(String[] args) {
    int count = 0;
    Mix4[] mixes = new Mix4[20];
    int i = 0;
    while (i < 19) {
      mixes[i] = new Mix4(); 
      mixes[i].counter = mixes[i].counter + 1; 
      count = count + 1; 
      count = count + mixes[i].maybeNew(i);  
      i = i + 1; 
    }
    System.out.println(count + " " +
                       mixes[1].counter); 
  }

  public int maybeNew(int index) {
    if ( index < 1 ) {
      Mix4 mix = new Mix4();
      mix.counter = mix.counter + 1; 
      return 1;
    }
    return 0;
  }
}


// ---- Page 90 Exercise -----

//CANDIDATE       ---->      OUTPUT
// i < 9          
// index < 5                   14 1

// i < 20
// index < 5                   25 1

// i < 7
// index < 7                   14 1

// i < 19
// index < 1                   20 1
