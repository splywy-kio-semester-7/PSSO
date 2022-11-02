public class BillingLongDistance extends TimingLongDistance {

    private static final long LONG_DISTANCE_RATE = 10;

    public BillingLongDistance(BillingCustomer caller, BillingCustomer receiver) {
        super(caller, receiver);
    }

    public long getBillRate() {
        return getTime() * LONG_DISTANCE_RATE;
    }

    @Override
    void complete() {
        super.complete();

    }

    @Override
    void drop() {
        super.drop();
        ((BillingCustomer) caller).addBillRate(getBillRate());
        ((BillingCustomer) receiver).addBillRate(getBillRate());
    }
}
