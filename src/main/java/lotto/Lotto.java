package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRepeat(numbers);
        this.numbers = numbers;
    }

    private void validateRepeat(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 중복될 수 없습니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    public void addBonusNumber(int number) {
        bonusValidate(number);
        repeatBonusNumber(number);
        numbers.add(number);
    }
    public void repeatBonusNumber(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 로또 번호와 중복됩니다.");
        }
    }
    private void bonusValidate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 숫자여야입니다.");
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
