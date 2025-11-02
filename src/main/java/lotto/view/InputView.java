package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String purchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        if (!input.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        return input;
    }

    public String winningNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String bonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
