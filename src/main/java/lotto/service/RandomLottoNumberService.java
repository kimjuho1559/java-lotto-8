package lotto.service;

import lotto.model.RandomLottoNumber;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoNumberService {
    private List<RandomLottoNumber> lottoNumbers = new ArrayList<RandomLottoNumber>();
    public List<RandomLottoNumber> makeRandomLottoNumber(String money) {
        int count = separateLottoCount(Integer.parseInt(money));
        for (int i = 0; i < count; i++) {
            RandomLottoNumber lottoNumber = new RandomLottoNumber();
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private int separateLottoCount(int money) {
        return validateMoney(money);
    }

    private int validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어져야합니다.");
        }
        return money / 1000;
    }
}
