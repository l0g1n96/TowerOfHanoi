package com.unycom.markoedu;

public class ConsoleResultPrinter implements ResultPrinter {

    @Override
    public void print(HanoiOutputDataDTO hanoiOutputDataDTO) {

        for (HanoiMoveDTO s : hanoiOutputDataDTO.getLines()) {
            System.out.println(s);
        }
    }
}
