public class TimingCustomer extends Customer{

    private long totalConnectTime;

    public TimingCustomer(String name, int areacode) {
        super(name, areacode);
        totalConnectTime = 0;
    }

    public TimingCall call(TimingCustomer receiver) {
        TimingCall timingCall = new TimingCall(this, receiver);
        addCall(timingCall);
        return timingCall;
    }

    public void addConnectTime(long connectionTime) {
        totalConnectTime += connectionTime;
    }

    public long getTotalConnectTime() {
        return totalConnectTime;
    }
}
