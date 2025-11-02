package lotto.service;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private Lotto lotto;
    public void separateNumber(String stringNumber) {
        String[] numbers = stringNumber.split(",");
        List<Integer> numberList = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            validate(num);
            numberList.add(num);
        }
        lotto = new Lotto(numberList);
    }
    public Lotto addBonusNumber(String stringBonusNumber) {
        lotto.addBonusNumber(Integer.parseInt(stringBonusNumber));
        return lotto;
    }
    private void validate(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
