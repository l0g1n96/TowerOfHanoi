package com.unycom.markoedu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToH implements DataHandler {

    private final static Logger logger = LoggerFactory.getLogger(ToH.class);

    @Override
    public HanoiOutputDataDTO doWork(HanoiInputDataDTO hanoiInputDataDTO) {

        logger.trace("doWork called with:{}", hanoiInputDataDTO);

        try {
            List<HanoiMoveDTO> list = new ArrayList<>();
            Map<Character, List<Integer>> map = new HashMap<>();

            List<Integer> l = new ArrayList<>();

            for (int i = 1; i <= hanoiInputDataDTO.getDiskCount(); i++) {
                l.add(i);
            }

            map.put('A', l);

            hanoi(map, list, hanoiInputDataDTO.getDiskCount(), 'A', 'B', 'C');

            HanoiOutputDataDTO hanoiOutputDataDTO = new HanoiOutputDataDTO(list, map);
            logger.trace("doWork finished with:{}", hanoiOutputDataDTO);
            return hanoiOutputDataDTO;

        } catch (Exception th) {
            logger.error("Error in doWork", th);
            throw th;
        }
    }

    private void hanoi(Map<Character, List<Integer>> map, List<HanoiMoveDTO> list, int diskNum, char poleA, char poleB, char poleC) {

        if (diskNum == 0) {
            return;
        }

        if (diskNum == 1) {
            moveDiskFromAtoC(map, list, diskNum, poleA, poleC);
        } else {
            hanoi(map, list, diskNum - 1, poleA, poleC, poleB);
            moveDiskFromAtoC(map, list, diskNum, poleA, poleC);
            hanoi(map, list, diskNum - 1, poleB, poleA, poleC);
        }
    }


    private void moveDiskFromAtoC(Map<Character, List<Integer>> map, List<HanoiMoveDTO> list, int diskNum, char poleA, char poleC) {
        list.add(new HanoiMoveDTO(diskNum, poleA, poleC));

        List<Integer> aDisks = map.get(poleA);
        if (aDisks == null) {
            throw new UnsupportedOperationException(poleA + "is empty! Can't remove disk from that pole!");
        }

        aDisks.remove(aDisks.indexOf(diskNum));

        List<Integer> cDisks = map.get(poleC);
        if (cDisks == null) {
            cDisks = new ArrayList<>();
            map.put(poleC, cDisks);
        }
        cDisks.add(diskNum);
    }
}