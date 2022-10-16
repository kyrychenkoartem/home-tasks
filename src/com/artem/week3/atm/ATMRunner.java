package com.artem.week3.atm;


public class ATMRunner {

    public static void main(String[] args) {
        AutomatedTellerMachine atm = new AutomatedTellerMachine(20, 8, 4);
        atm.printBalance();
        atm.cashWithdraw(400);
        atm.printBalance();
        atm.cashWithdraw(400);
        atm.printBalance();
        atm.cashWithdraw(368);
        atm.printBalance();
    }
}
