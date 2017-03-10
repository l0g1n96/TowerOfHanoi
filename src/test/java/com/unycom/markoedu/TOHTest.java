package com.unycom.markoedu;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TOHTest {

    @Test
    public void testForInput2AndSize() {

        HanoiInputDataDTO hanoiInputDataDTO = new HanoiInputDataDTO(2);

        ToH toH = new ToH();
        HanoiOutputDataDTO hanoiOutputDataDTO = toH.doWork(hanoiInputDataDTO);

        List<Integer> a = hanoiOutputDataDTO.getPoles().get('A');
        List<Integer> b = hanoiOutputDataDTO.getPoles().get('B');
        List<Integer> c = hanoiOutputDataDTO.getPoles().get('C');

        List<Integer> bExcepted = new ArrayList<>();
        List<Integer> aExcepted = new ArrayList<>();
        List<Integer> cExcepted = new ArrayList<>();
        cExcepted.add(2);
        cExcepted.add(1);

        Assert.assertEquals(3, hanoiOutputDataDTO.getLines().size());
        Assert.assertEquals(aExcepted, a);
        Assert.assertEquals(bExcepted, b);
        Assert.assertEquals(cExcepted, c);

    }

    @Test
    public void checkingMoves() {

        HanoiInputDataDTO hanoiInputDataDTO = new HanoiInputDataDTO(2);
        ToH toh = new ToH();
        HanoiOutputDataDTO outputDataDTO = toh.doWork(hanoiInputDataDTO);

        List<HanoiMoveDTO> actual = outputDataDTO.getLines();

        List<HanoiMoveDTO> expected = new ArrayList<>();
        expected.add(new HanoiMoveDTO(1, 'A', 'B'));
        expected.add(new HanoiMoveDTO(2, 'A', 'C'));
        expected.add(new HanoiMoveDTO(1, 'B', 'C'));

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testForInput3AndSize() {

        HanoiInputDataDTO hanoiInputDataDTO = new HanoiInputDataDTO(3);

        ToH toH = new ToH();
        HanoiOutputDataDTO hanoiOutputDataDTO = toH.doWork(hanoiInputDataDTO);

        List<Integer> a = hanoiOutputDataDTO.getPoles().get('A');
        List<Integer> b = hanoiOutputDataDTO.getPoles().get('B');
        List<Integer> c = hanoiOutputDataDTO.getPoles().get('C');

        List<Integer> bExcepted = new ArrayList<>();
        List<Integer> aExcepted = new ArrayList<>();
        List<Integer> cExcepted = new ArrayList<>();
        cExcepted.add(3);
        cExcepted.add(2);
        cExcepted.add(1);

        Assert.assertEquals(7, hanoiOutputDataDTO.getLines().size());
        Assert.assertEquals(aExcepted, a);
        Assert.assertEquals(bExcepted, b);
        Assert.assertEquals(cExcepted, c);
    }

    @Test
    public void testForInput0AndSize() {

        HanoiInputDataDTO hanoiInputDataDTO = new HanoiInputDataDTO(0);
        ToH toH = new ToH();
        HanoiOutputDataDTO hanoiOutputDataDTO = toH.doWork(hanoiInputDataDTO);

        Assert.assertNotNull(hanoiOutputDataDTO.getLines());
        Assert.assertTrue(hanoiOutputDataDTO.getLines().isEmpty());
    }

    @Test
    public void testingLastPoleInMapAndSize() {

        HanoiInputDataDTO hanoiInputDataDTO = new HanoiInputDataDTO(1);
        ToH toH = new ToH();
        HanoiOutputDataDTO hanoiOutputDataDTO = toH.doWork(hanoiInputDataDTO);

        List<Integer> a = hanoiOutputDataDTO.getPoles().get('A');
        List<Integer> b = hanoiOutputDataDTO.getPoles().get('B');
        List<Integer> c = hanoiOutputDataDTO.getPoles().get('C');

        List<Integer> aExcepted = new ArrayList<>();
        List<Integer> cExcepted = new ArrayList<>();
        cExcepted.add(1);

        Assert.assertEquals(aExcepted, a);
        Assert.assertNull(b);
        Assert.assertEquals(cExcepted, c);
        Assert.assertEquals(1, hanoiOutputDataDTO.getLines().size());
    }

    @Test
    public void testingFileInput2AndNotNull() {

        FileDataReader fdr = new FileDataReader("input2.txt");
        HanoiInputDataDTO hanoiInputDataDTO = fdr.read();
        ToH toH = new ToH();
        HanoiOutputDataDTO hanoiOutputDataDTO = toH.doWork(hanoiInputDataDTO);

        List<Integer> a = hanoiOutputDataDTO.getPoles().get('C');

        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(1);

        Assert.assertNotNull(hanoiInputDataDTO);
        Assert.assertEquals(expected, a);
        Assert.assertEquals(3, hanoiOutputDataDTO.getLines().size());
    }

    @Test
    public void testingFileInput1AndNotNull() {

        FileDataReader fdr = new FileDataReader("asdf.txt");
        HanoiInputDataDTO hanoiInputDataDTO = fdr.read();
        ToH toH = new ToH();
        HanoiOutputDataDTO hanoiOutputDataDTO = toH.doWork(hanoiInputDataDTO);

        List<Integer> a = hanoiOutputDataDTO.getPoles().get('C');

        List<Integer> expected = new ArrayList<>();
        expected.add(1);

        Assert.assertNotNull(hanoiInputDataDTO);
        Assert.assertEquals(expected, a);
        Assert.assertEquals(1, hanoiOutputDataDTO.getLines().size());
    }

    @Test
    public void testForFileExistence() {

        FileDataReader fdr = new FileDataReader("sdf.txt");

        try {
            fdr.read();
            Assert.fail("exception expected");
        } catch (HanoiBusinessException hex) {
            Assert.assertTrue(hex.getHanoiBusinessErrorCodes() == HanoiBusinessErrorCodes.FILE_PROBLEM);
        }
    }

    @Test
    public void testPermission1() throws IOException {

        File file = new File("reader.txt");

        if (!file.canWrite()) {
            throw new HanoiException(NumberErrorCodes.FILE_PERMISSION, "No permission to write");
        }

        if (!file.canExecute()) {
            throw new HanoiException(NumberErrorCodes.FILE_PERMISSION, "No permission to execute");
        }

        if (!file.canRead()) {
            throw new HanoiException(NumberErrorCodes.FILE_PERMISSION, "No permission to read");
        }
    }

    @Test
    public void testIfFileIsEmpty() {

        FileDataReader fileDataReader = new FileDataReader("empty.txt");

        try {
            fileDataReader.read();
            Assert.fail("exception expected");
        } catch (HanoiBusinessException hex) {
            Assert.assertTrue(hex.getHanoiBusinessErrorCodes() == HanoiBusinessErrorCodes.FILE_PROBLEM);
        }
    }

    @Test
    public void testExceptionIfFileExists() {

        FileDataReader fileDataReader = new FileDataReader("aer.txt");

        try {
            fileDataReader.read();
            Assert.fail("Exception expected");
        } catch (HanoiBusinessException hex) {
            Assert.assertTrue(hex.getHanoiBusinessErrorCodes() == HanoiBusinessErrorCodes.FILE_PROBLEM);
        }
    }

    @Test
    public void testExceptionIfFileHasPermission() {

        FileDataReader fileDataReader = new FileDataReader("multiple.txt");

        try {
            fileDataReader.read();
            Assert.fail("Exception expected");
        } catch (HanoiBusinessException hex) {
            Assert.assertTrue(hex.getHanoiBusinessErrorCodes() == HanoiBusinessErrorCodes.INPUT_PROBLEM);
        }
    }

    @Test
    public void testExceptionIfFileHasWrongInput() {

        FileDataReader fileDataReader = new FileDataReader("reader.txt");

        try {
            fileDataReader.read();
            Assert.fail("Exception expected");
        } catch (HanoiBusinessException hex) {
            Assert.assertTrue(hex.getHanoiBusinessErrorCodes() == HanoiBusinessErrorCodes.FILE_PROBLEM);
        }
    }

    @Test
    public void testExceptionIfFileHasMultipleInputs() {

        FileDataReader fileDataReader = new FileDataReader("multiple.txt");

        try {
            fileDataReader.read();
            Assert.fail("Exception expected");
        } catch (HanoiBusinessException hex) {
            Assert.assertTrue(hex.getHanoiBusinessErrorCodes() == HanoiBusinessErrorCodes.INPUT_PROBLEM);
        }
    }
}