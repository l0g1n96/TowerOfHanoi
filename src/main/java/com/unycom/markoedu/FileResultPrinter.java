package com.unycom.markoedu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileResultPrinter implements ResultPrinter {

    private String path;
    private final static Logger logger = LoggerFactory.getLogger(FileResultPrinter.class);

    public FileResultPrinter(String path) {
        this.path = path;
    }

    @Override
    public void print(HanoiOutputDataDTO hanoiOutputDataDTO) {

        try (FileWriter fw = new FileWriter(new File(path));
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (HanoiMoveDTO h : hanoiOutputDataDTO.getLines()) {
                bw.append(h.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            logger.error("File doesn't exist " + new File(path).getAbsolutePath());
            throw new HanoiBusinessException("File doesn't exist", e, HanoiBusinessErrorCodes.FILE_PROBLEM);
        }
    }
}
