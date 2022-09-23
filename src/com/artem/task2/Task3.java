package com.artem.task2;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 *
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 *
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */
public class Task3 {
    public static void main(String[] args) {
        int startingSalary = 600;
        int increasingOfSalary = 400;
        int percentageToBroker = 10;
        int spendingPerMonth = 300;
        countIvanAccount(startingSalary, increasingOfSalary, percentageToBroker, spendingPerMonth);
        System.out.println();
    }

    public static void countIvanAccount(int salary, int increasingSalary, int brokersPercent, int spending) {
        double ivanFunds = 0;
        double brokerFunds = 0;
        double profit = 0;
        for (int i = 1; i <= 38; i++) {
            if (i % 7 == 0) {
                salary += increasingSalary;
            }
            ivanFunds += salary;
            ivanFunds -= spending;
            double difference = salary * brokersPercent * 0.01;
            brokerFunds += difference;
            ivanFunds -= difference;
            if (i < 38) {
                profit += brokerFunds * 0.02;
            }
        }
        ivanFunds += profit;
        System.out.println("Ivan has " + ivanFunds + " $ on his account after 3 years and 2 months");
        System.out.println("Broker has " + brokerFunds + " $ on his account after 3 years and 2 months");
    }

}
