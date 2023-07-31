package com.example.refactor.caseone.after;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author chunbo.ma.o
 * @since 2023/6/2
 */
@AllArgsConstructor
public class BudgetPlan {
    private final BudgetRepo repo;


    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2023, 6, 2);

        System.out.println(localDate.withDayOfMonth(1));
    }

    public long query(LocalDate startDate, LocalDate endDate) {

        if (startDate.withDayOfMonth(1).equals(endDate.withDayOfMonth(1))) {
            long amount = getBudgetAmount(startDate);
            long daysInPeriod = getBudgetDaysCount(startDate);
            long daysBetween = startDate.until(endDate, DAYS) + 1;
            return amount / daysInPeriod * daysBetween;
        }

        if (YearMonth.from(startDate).isBefore(YearMonth.from(endDate))) {
            long amountStartPeriod = getBudgetAmount(startDate);
            long daysInStartPeriod = getBudgetDaysCount(startDate);
            long daysAfterStartDateInStartPeriod = startDate.until(startDate.withDayOfMonth(startDate.lengthOfMonth()), DAYS) + 1;
            long totalStartPeriod = amountStartPeriod / daysInStartPeriod * daysAfterStartDateInStartPeriod;

            long totalInMiddle = 0;
            for (Budget budget : getBudgetsBetween(startDate, endDate)) {
                totalInMiddle += budget.getAmount();
            }

            long amountEndPeriod = getBudgetAmount(endDate);
            long daysInEndPeriod = getBudgetDaysCount(endDate);
            long daysBeforeEndDateInEndPeriod = endDate.getDayOfMonth();
            long totalEndPeriod = amountEndPeriod / daysInEndPeriod * daysBeforeEndDateInEndPeriod;

            return totalStartPeriod + totalInMiddle + totalEndPeriod;
        }
        throw new RuntimeException("错误参数范围");
    }

    private List<Budget> getBudgetsBetween(LocalDate startDate, LocalDate endDate) {
        List<Budget> budgets = repo.findAll();
        return budgets.stream().filter(budget -> budget.getMonth().atDay(1).isAfter(startDate) && budget.getMonth().atEndOfMonth().isBefore(endDate)).collect(Collectors.toList());
    }

    private long getBudgetDaysCount(LocalDate date) {
        Budget budget = getBudgetContaining(date);
        return budget.getMonth().lengthOfMonth();
    }

    private long getBudgetAmount(LocalDate data) {
       Budget budget = getBudgetContaining(data);
        return budget.getAmount();
    }

    private Budget getBudgetContaining(LocalDate data) {

      List<Budget> budgets = repo.findAll();
      return budgets.stream().filter(budget -> budget.getMonth().atDay(1).equals(data.withDayOfMonth(1))).findFirst().orElse(null);
    }
}
