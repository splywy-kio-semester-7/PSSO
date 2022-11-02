public class BillingLocal extends TimingLocal {

    private static final long LOCAL_RATE = 3;

    public BillingLocal(BillingCustomer caller, BillingCustomer receiver) {
        super(caller, receiver);
    }

    public long getBillRate() {
        return getTime() * LOCAL_RATE;
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
