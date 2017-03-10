package com.unycom.markoedu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDataReader implements InputDataReader {

    private String path;
    private final static Logger logger = LoggerFactory.getLogger(ToH.class);

    public FileDataReader(String path) {
        this.path = path;
    }

    @Override
    public HanoiInputDataDTO read() {

        try (FileInputStream fis = new FileInputStream(new File(path));
             BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {

            String n;

            long count = Files.lines(Paths.get(path)).count();

            if (count > 1) {
                logger.error("Multiple inputs in a file " + new File(path).getAbsolutePath());
                throw new HanoiException(NumberErrorCodes.MULTIPLE_INPUTS, "File has multiple inputs");
            }

            n = br.readLine();

            if (n == null) {
                logger.error("File is empty " + new File(path).getAbsolutePath());
                throw new HanoiException(NumberErrorCodes.FILE_IS_EMPTY, "File is empty");
            }

            try {
                int i = Integer.parseInt(n);
            } catch (NumberFormatException e) {
                logger.error("Wrong input type " + new File(path).getAbsolutePath());
                throw new HanoiException(e, NumberErrorCodes.WRONG_INPUT_TYPE, "Wrong input type");
            }

            if (Integer.parseInt(n) < 1) {
                logger.error("Number must be higher than 0 " + new File(path).getAbsolutePath());
                throw new HanoiException(NumberErrorCodes.INPUT_HIGHER_THAN_0, "Number must be higher than 0");
            }

            HanoiInputDataDTO hanoiInputDataDTO = new HanoiInputDataDTO(Integer.parseInt(n));
            return hanoiInputDataDTO;

        } catch (HanoiException ex) {
            if (ex.getError() == NumberErrorCodes.FILE_DOESNT_EXIST ||
                    ex.getError() == NumberErrorCodes.FILE_IS_EMPTY ||
                    ex.getError() == NumberErrorCodes.FILE_PERMISSION) {

                logger.error("File problem", ex);
                throw new HanoiBusinessException("File error", ex, HanoiBusinessErrorCodes.FILE_PROBLEM);
            } else {
                logger.error("File Input problem");
                throw new HanoiBusinessException("File input problem", ex, HanoiBusinessErrorCodes.INPUT_PROBLEM);
            }
        } catch (IOException e) {
            logger.error("File not found!");
            throw new HanoiBusinessException("File not found", e, HanoiBusinessErrorCodes.FILE_PROBLEM);
        }
    }
}
