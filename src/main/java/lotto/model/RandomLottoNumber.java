package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoNumber {
    private List<Integer> randomLottoNumbers;

    public RandomLottoNumber() {
        List<Integer> picked = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        this.randomLottoNumbers = picked.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getRandomLottoNumbers() {
        return randomLottoNumbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < randomLottoNumbers.size(); i++) {
            if (i == randomLottoNumbers.size() - 1) {
                sb.append(randomLottoNumbers.get(i));
            } else {
                sb.append(randomLottoNumbers.get(i)).append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
