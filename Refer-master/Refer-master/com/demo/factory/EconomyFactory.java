package com.demo.factory;

import com.demo.service.Accounting;
import com.demo.serviceimpl.AccountingImpl;

public class EconomyFactory {

    public static Accounting getAccounting() {

        return new AccountingImpl();
    }
}
