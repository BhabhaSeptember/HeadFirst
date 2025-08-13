package ch04;

class Clock {
  String time;

  void setTime(String t) {
    time = t;
  }

//Previously the return type was void which didnt match the returned value type
//So we changed void to String  
  String getTime() { //fixed line of code
    return time;
  }
}

