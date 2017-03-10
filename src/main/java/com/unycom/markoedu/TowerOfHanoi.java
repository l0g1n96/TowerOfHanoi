package com.unycom.markoedu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TowerOfHanoi {

    private InputDataReader result;
    private DataHandler dataHandler;
    private ResultPrinter printer;

    private final static Logger logger = LoggerFactory.getLogger(ToH.class);

    public TowerOfHanoi(InputDataReader result, DataHandler dataHandler, ResultPrinter printer) {
        this.result = result;
        this.dataHandler = dataHandler;
        this.printer = printer;
    }

    public void doWork() {
        try {
            HanoiInputDataDTO read = result.read();
            HanoiOutputDataDTO hanoiOutputDataDTO = dataHandler.doWork(read);
            printer.print(hanoiOutputDataDTO);
        } catch (Exception th) {
            logger.error("Error in TowerOfHanoi doWork method", th);
            throw th;
        }
    }
}
