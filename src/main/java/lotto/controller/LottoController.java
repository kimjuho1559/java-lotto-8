package lotto.controller;

import lotto.Lotto;
import lotto.model.RandomLottoNumber;
import lotto.service.LottoCompareService;
import lotto.service.LottoService;
import lotto.service.ProfitService;
import lotto.service.RandomLottoNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomLottoNumberService randomLottoNumberService = new RandomLottoNumberService();
    private final LottoService lottoService = new LottoService();
    private final LottoCompareService lottoCompareService = new LottoCompareService();
    private final ProfitService profitService = new ProfitService();

    public void run() {
        while (true) {
            try {
                String amount = inputView.purchaseAmountInput();
                List<RandomLottoNumber> randomLottoNumberList = randomLottoNumberService.makeRandomLottoNumber(amount);
                outputView.showRandomLottoNumber(randomLottoNumberList);
                lottoService.separateNumber(inputView.winningNumberInput());
                Lotto lotto = lottoService.addBonusNumber(inputView.bonusNumberInput());
                List<Integer> matchCounts = lottoCompareService.compareLotto(lotto, randomLottoNumberList);
                List<Integer> winningStats = lottoCompareService.toWinningStatistics(matchCounts);
                outputView.showWinningStatistics(winningStats);
                String profit = profitService.profit(amount, winningStats);
                outputView.showProfit(profit);
                break;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
