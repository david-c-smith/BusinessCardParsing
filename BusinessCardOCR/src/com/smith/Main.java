package com.smith;

import com.smith.classes.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        while(true) {
            System.out.println("\nEnter the absolute path to a business card .txt file: ");
            Scanner input = new Scanner(System.in);
            BusinessCardParser businessCardParser = new BusinessCardParser( input.nextLine());
        }
    }
}


