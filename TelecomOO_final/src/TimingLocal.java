import java.time.Duration;
import java.time.Instant;

public class TimingLocal extends Local {

    protected Instant startTime;

    protected Instant stopTime;

    public TimingLocal(TimingCustomer caller, TimingCustomer receiver) {
        super(caller, receiver);
    }

    protected long getTime() {
        return Duration.between(startTime, stopTime).getSeconds();
    }

    @Override
    void complete() {
        super.complete();
        startTime = Instant.now();
    }

    @Override
    void drop() {
        super.drop();
        stopTime = Instant.now();
        ((TimingCustomer) caller).addConnectTime(getTime());
        ((TimingCustomer) receiver).addConnectTime(getTime());
    }
}
