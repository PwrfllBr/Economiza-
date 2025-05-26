package com.economiza.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IncomeFlowDTO {
    private LocalDate period;
    private BigDecimal total_income;
    private BigDecimal total_expense;

    public LocalDate getPeriod() {
        return period;
    }

    public void setPeriod(LocalDate period) {
        this.period = period;
    }

    public BigDecimal getTotal_income() {
        return total_income;
    }

    public void setTotal_income(BigDecimal total_income) {
        this.total_income = total_income;
    }

    public BigDecimal getTotal_expense() {
        return total_expense;
    }

    public void setTotal_expense(BigDecimal total_expense) {
        this.total_expense = total_expense;
    }
}
