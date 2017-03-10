package com.unycom.markoedu;

import java.util.Scanner;

public class ConsoleReader implements InputDataReader {

    @Override
    public HanoiInputDataDTO read() {

        Scanner s = new Scanner(System.in);

        System.out.println("Unesite broj diskova: ");

        int brojDiskova = s.nextInt();

        HanoiInputDataDTO input = new HanoiInputDataDTO(brojDiskova);

        return input;
    }
}
