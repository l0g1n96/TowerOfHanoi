package com.unycom.markoedu;

public class Main {

    public static void main(String[] args) throws Exception {

        InputDataReader inputDataReader = new FileDataReader("input2.txt");
        DataHandler dataHandler = new ToH();
        ResultPrinter fileResultPrinter = new FileResultPrinter("file.txt");

        TowerOfHanoi towerOfHanoi = new TowerOfHanoi(inputDataReader, dataHandler, fileResultPrinter);
        towerOfHanoi.doWork();

    }
}
