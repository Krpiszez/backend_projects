package enums_strategy_dp;

import static enums_strategy_dp.PayRollDay.PayType.*;

public enum PayRollDay {
// STRATEGY PATTERN
    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY), THURSDAY(WEEKDAY), FRIDAY(WEEKDAY), SATURDAY(WEEKEND),
    SUNDAY(WEEKEND);

    private final PayType payType;

    PayRollDay(PayType payType) {
        this.payType = payType;
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    enum PayType{

        WEEKDAY{
            int overTimePay(int minsWorked, int rate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * rate / 2;
            }
        },
        WEEKEND{
            int overTimePay(int minsWorked, int rate) {
                return minsWorked * rate / 2;
            }
        };

        abstract int overTimePay(int mins, int rate);

        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int rate){
            int basePay = minsWorked * rate;
            return basePay + overTimePay(minsWorked, rate);
        }
    }

    public static void main(String[] args) {
        for (PayRollDay day : values())
            System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1));
    }
}
