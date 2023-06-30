package com.example.refactor;

import com.example.refactor.caseone.after.BudgetPlan;
import com.example.refactor.caseone.after.BudgetRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;

@SpringBootTest
class RefactorApplicationTests {
    private final BudgetRepo repo = mock(BudgetRepo.class);
    private final BudgetPlan plan = new BudgetPlan(repo);

    @Test
    public void no_budget(){
        givenBudgets();
        Assert.isTrue(0 == plan.query(LocalDate.of(2019,10,4),LocalDate.of(2019,11,12)));
    }

    private void givenBudgets() {
    }

}
