package lotto.view;

import lotto.model.RandomLottoNumber;

import java.util.List;

public class OutputView {
    private List<String> winningAmount = List.of("5,000", "50,000", "1,500,000", "30,000,000", "2,000,000,000");
    public void showRandomLottoNumber(List<RandomLottoNumber> randomLottoNumbers) {
        System.out.println(randomLottoNumbers.size() +"개를 구매했습니다.");
        for (RandomLottoNumber randomLottoNumber : randomLottoNumbers) {
            System.out.println(randomLottoNumber.toString());
        }
    }

    public void showWinningStatistics(List<Integer> stats) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + winningAmount.get(0) + "원) - " + stats.get(0) + "개");
        System.out.println("4개 일치 (" + winningAmount.get(1) + "원) - " + stats.get(1) + "개");
        System.out.println("5개 일치 (" + winningAmount.get(2) + "원) - " + stats.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + winningAmount.get(3) + "원) - " + stats.get(3) + "개");
        System.out.println("6개 일치 (" + winningAmount.get(4) + "원) - " + stats.get(4) + "개");
    }

    public void showProfit(String profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }
}
