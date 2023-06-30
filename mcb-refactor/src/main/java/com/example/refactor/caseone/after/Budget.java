package com.example.refactor.caseone.after;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.YearMonth;

/**
 * @author chunbo.ma.o
 * @since 2023/6/2
 */
@Data
@AllArgsConstructor
public class Budget {

    private YearMonth month;
    private Long amount;

}
