/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch12_revisit;

import java.util.*;

/**
 *
 * @author User
 */
public class MixForLoops {

    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        String output = "";

        //Candidate goes here...
 for (int i = 0; i <= nums.size(); i++) 
    output += nums.get(i) + " ";
        //  

        System.out.println(output);
    }

}

//----- Page 372 Exercise -----
//
//          CANDIDATE                                   OUTPUT
//
//for (int i = 1; i < nums.size(); i++)                 2 3 4 5
//    output += nums.get(i) + " ";
//
// for (Integer num : nums)                         
//    output += nums + " ";                          [1, 2, 3, 4, 5] 
//                                                   [1, 2, 3, 4, 5] 
//                                                   [1, 2, 3, 4, 5] 
//                                                   [1, 2, 3, 4, 5] 
//                                                   [1, 2, 3, 4, 5]
//
// for (int i = 0; i <= nums.length; i++) 
//    output += nums.get(i) + " ";                    Compiler Error 
//                                                  (length symbol not found)
//
// for (int i = 0; i <= nums.size(); i++) 
//    output += nums.get(i) + " ";                   Exception thrown
//                                                  (ArrayIndexOutOfBounds)
