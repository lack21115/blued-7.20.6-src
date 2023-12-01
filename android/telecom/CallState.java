package android.telecom;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/CallState.class */
public final class CallState {
    public static final int ABORTED = 8;
    public static final int ACTIVE = 5;
    public static final int CONNECTING = 1;
    public static final int DIALING = 3;
    public static final int DISCONNECTED = 7;
    public static final int DISCONNECTING = 9;
    public static final int NEW = 0;
    public static final int ON_HOLD = 6;
    public static final int PRE_DIAL_WAIT = 2;
    public static final int RINGING = 4;

    private CallState() {
    }

    public static String toString(int i) {
        switch (i) {
            case 0:
                return "NEW";
            case 1:
                return "CONNECTING";
            case 2:
                return "PRE_DIAL_WAIT";
            case 3:
                return "DIALING";
            case 4:
                return "RINGING";
            case 5:
                return "ACTIVE";
            case 6:
                return "ON_HOLD";
            case 7:
                return "DISCONNECTED";
            case 8:
                return "ABORTED";
            case 9:
                return "DISCONNECTING";
            default:
                return "UNKNOWN";
        }
    }
}
