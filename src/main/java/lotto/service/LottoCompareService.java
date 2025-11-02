package lotto.service;

import lotto.Lotto;
import lotto.model.RandomLottoNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoCompareService {
    public List<Integer> compareLotto(Lotto lotto, List<RandomLottoNumber> randomLottoNumbers) {
        List<Integer> result = new ArrayList<>();
        List<Integer> lottoNumbers = lotto.getNumbers();
        for (RandomLottoNumber randomLottoNumber : randomLottoNumbers) {
            result.add(compare(randomLottoNumber, lottoNumbers));
        }
        return result;
    }

    private int compare(RandomLottoNumber randomLottoNumbers, List<Integer> lottoNumbers) {
        List<Integer> mainNumbers = lottoNumbers.subList(0, lottoNumbers.size() - 1);
        int bonus = lottoNumbers.getLast();
        int count = 0;
        boolean matchBonusNumber = false;
        Set<Integer> mainSet = new HashSet<>(mainNumbers);
        for (int number : randomLottoNumbers.getRandomLottoNumbers()) {
            if (mainSet.contains(number)) {
                count++;
            }
            if (number == bonus) {
                matchBonusNumber = true;
            }
        }
        return ranking(count, matchBonusNumber);
    }

    private int ranking(int count, boolean matchBonusNumber) {
        if (count == 6) return 1;
        if (count == 5 && matchBonusNumber) return 2;
        if (count == 5) return 3;
        if (count == 4) return 4;
        if (count == 3) return 5;
        return 0;
    }
    public List<Integer> toWinningStatistics(List<Integer> ranks) {
        int[] count = new int[5];
        for (int rank : ranks) {
            switch (rank) {
                case 5 -> count[0]++;
                case 4 -> count[1]++;
                case 3 -> count[2]++;
                case 2 -> count[3]++;
                case 1 -> count[4]++;
                default -> {}
            }
        }
        return List.of(count[0], count[1], count[2], count[3], count[4]);
    }
}
