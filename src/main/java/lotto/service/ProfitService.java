package lotto.service;

import java.util.List;

public class ProfitService {
    public String profit(String amount, List<Integer> stats) {
        long[] prize = {5000L, 50000L, 1500000L, 30000000L, 2000000000L};

        long totalWinning = 0L;
        for (int i = 0; i < 5; i++) {
            totalWinning += (long) stats.get(i) * prize[i];
        }

        double yield = (double) totalWinning / Integer.parseInt(amount) * 100.0;
        return String.format("%.1f%%", yield);
    }
}
