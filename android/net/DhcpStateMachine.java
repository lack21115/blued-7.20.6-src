package android.net;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;

/* loaded from: source-9557208-dex2jar.jar:android/net/DhcpStateMachine.class */
public class DhcpStateMachine extends StateMachine {
    private static final String ACTION_DHCP_RENEW = "android.net.wifi.DHCP_RENEW";
    private static final int BASE = 196608;
    public static final int CMD_ON_QUIT = 196614;
    public static final int CMD_POST_DHCP_ACTION = 196613;
    public static final int CMD_PRE_DHCP_ACTION = 196612;
    public static final int CMD_PRE_DHCP_ACTION_COMPLETE = 196615;
    public static final int CMD_RENEW_DHCP = 196611;
    public static final int CMD_START_DHCP = 196609;
    public static final int CMD_STOP_DHCP = 196610;
    private static final boolean DBG = false;
    public static final int DHCP_FAILURE = 2;
    private static final int DHCP_RENEW = 0;
    public static final int DHCP_SUCCESS = 1;
    private static final int MIN_RENEWAL_TIME_SECS = 300;
    private static final String TAG = "DhcpStateMachine";
    private static final String WAKELOCK_TAG = "DHCP";
    private AlarmManager mAlarmManager;
    private BroadcastReceiver mBroadcastReceiver;
    private Context mContext;
    private StateMachine mController;
    private State mDefaultState;
    private PowerManager.WakeLock mDhcpRenewWakeLock;
    private PendingIntent mDhcpRenewalIntent;
    private DhcpResults mDhcpResults;
    private final String mInterfaceName;
    private boolean mRegisteredForPreDhcpNotification;
    private State mRunningState;
    private State mStoppedState;
    private State mWaitBeforeRenewalState;
    private State mWaitBeforeStartState;

    /* loaded from: source-9557208-dex2jar.jar:android/net/DhcpStateMachine$DefaultState.class */
    class DefaultState extends State {
        DefaultState() {
        }

        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public void exit() {
            DhcpStateMachine.this.mContext.unregisterReceiver(DhcpStateMachine.this.mBroadcastReceiver);
        }

        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public boolean processMessage(Message message) {
            switch (message.what) {
                case DhcpStateMachine.CMD_RENEW_DHCP /* 196611 */:
                    Log.e(DhcpStateMachine.TAG, "Error! Failed to handle a DHCP renewal on " + DhcpStateMachine.this.mInterfaceName);
                    DhcpStateMachine.this.mDhcpRenewWakeLock.release();
                    return true;
                default:
                    Log.e(DhcpStateMachine.TAG, "Error! unhandled message  " + message);
                    return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/DhcpStateMachine$DhcpAction.class */
    public enum DhcpAction {
        START,
        RENEW
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/DhcpStateMachine$RunningState.class */
    class RunningState extends State {
        RunningState() {
        }

        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public void enter() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public boolean processMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case DhcpStateMachine.CMD_START_DHCP /* 196609 */:
                    break;
                case DhcpStateMachine.CMD_STOP_DHCP /* 196610 */:
                    DhcpStateMachine.this.mAlarmManager.cancel(DhcpStateMachine.this.mDhcpRenewalIntent);
                    if (!NetworkUtils.stopDhcp(DhcpStateMachine.this.mInterfaceName)) {
                        Log.e(DhcpStateMachine.TAG, "Failed to stop Dhcp on " + DhcpStateMachine.this.mInterfaceName);
                    }
                    DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mStoppedState);
                    return true;
                case DhcpStateMachine.CMD_RENEW_DHCP /* 196611 */:
                    if (DhcpStateMachine.this.mRegisteredForPreDhcpNotification) {
                        DhcpStateMachine.this.mController.sendMessage(DhcpStateMachine.CMD_PRE_DHCP_ACTION);
                        DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mWaitBeforeRenewalState);
                        return true;
                    }
                    if (!DhcpStateMachine.this.runDhcp(DhcpAction.RENEW)) {
                        DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mStoppedState);
                    }
                    DhcpStateMachine.this.mDhcpRenewWakeLock.release();
                    return true;
                default:
                    z = false;
                    break;
            }
            return z;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/DhcpStateMachine$StoppedState.class */
    class StoppedState extends State {
        StoppedState() {
        }

        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public void enter() {
        }

        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public boolean processMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case DhcpStateMachine.CMD_START_DHCP /* 196609 */:
                    if (DhcpStateMachine.this.mRegisteredForPreDhcpNotification) {
                        DhcpStateMachine.this.mController.sendMessage(DhcpStateMachine.CMD_PRE_DHCP_ACTION);
                        DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mWaitBeforeStartState);
                        return true;
                    }
                    z = true;
                    if (DhcpStateMachine.this.runDhcp(DhcpAction.START)) {
                        DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mRunningState);
                        return true;
                    }
                    break;
                case DhcpStateMachine.CMD_STOP_DHCP /* 196610 */:
                    break;
                default:
                    z = false;
                    break;
            }
            return z;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/DhcpStateMachine$WaitBeforeRenewalState.class */
    class WaitBeforeRenewalState extends State {
        WaitBeforeRenewalState() {
        }

        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public void enter() {
        }

        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public void exit() {
            DhcpStateMachine.this.mDhcpRenewWakeLock.release();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public boolean processMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case DhcpStateMachine.CMD_START_DHCP /* 196609 */:
                    break;
                case DhcpStateMachine.CMD_STOP_DHCP /* 196610 */:
                    DhcpStateMachine.this.mAlarmManager.cancel(DhcpStateMachine.this.mDhcpRenewalIntent);
                    if (!NetworkUtils.stopDhcp(DhcpStateMachine.this.mInterfaceName)) {
                        Log.e(DhcpStateMachine.TAG, "Failed to stop Dhcp on " + DhcpStateMachine.this.mInterfaceName);
                    }
                    DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mStoppedState);
                    return true;
                case DhcpStateMachine.CMD_PRE_DHCP_ACTION_COMPLETE /* 196615 */:
                    if (DhcpStateMachine.this.runDhcp(DhcpAction.RENEW)) {
                        DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mRunningState);
                        return true;
                    }
                    DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mStoppedState);
                    return true;
                default:
                    z = false;
                    break;
            }
            return z;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/DhcpStateMachine$WaitBeforeStartState.class */
    class WaitBeforeStartState extends State {
        WaitBeforeStartState() {
        }

        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public void enter() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.android.internal.util.State, com.android.internal.util.IState
        public boolean processMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case DhcpStateMachine.CMD_START_DHCP /* 196609 */:
                    break;
                case DhcpStateMachine.CMD_STOP_DHCP /* 196610 */:
                    DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mStoppedState);
                    return true;
                case DhcpStateMachine.CMD_PRE_DHCP_ACTION_COMPLETE /* 196615 */:
                    if (DhcpStateMachine.this.runDhcp(DhcpAction.START)) {
                        DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mRunningState);
                        return true;
                    }
                    DhcpStateMachine.this.transitionTo(DhcpStateMachine.this.mStoppedState);
                    return true;
                default:
                    z = false;
                    break;
            }
            return z;
        }
    }

    private DhcpStateMachine(Context context, StateMachine stateMachine, String str) {
        super(TAG);
        this.mRegisteredForPreDhcpNotification = false;
        this.mDefaultState = new DefaultState();
        this.mStoppedState = new StoppedState();
        this.mWaitBeforeStartState = new WaitBeforeStartState();
        this.mRunningState = new RunningState();
        this.mWaitBeforeRenewalState = new WaitBeforeRenewalState();
        this.mContext = context;
        this.mController = stateMachine;
        this.mInterfaceName = str;
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService("alarm");
        this.mDhcpRenewalIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent(ACTION_DHCP_RENEW, (Uri) null), 0);
        this.mDhcpRenewWakeLock = ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(1, WAKELOCK_TAG);
        this.mDhcpRenewWakeLock.setReferenceCounted(false);
        this.mBroadcastReceiver = new BroadcastReceiver() { // from class: android.net.DhcpStateMachine.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                DhcpStateMachine.this.mDhcpRenewWakeLock.acquire(40000L);
                DhcpStateMachine.this.sendMessage(DhcpStateMachine.CMD_RENEW_DHCP);
            }
        };
        this.mContext.registerReceiver(this.mBroadcastReceiver, new IntentFilter(ACTION_DHCP_RENEW));
        addState(this.mDefaultState);
        addState(this.mStoppedState, this.mDefaultState);
        addState(this.mWaitBeforeStartState, this.mDefaultState);
        addState(this.mRunningState, this.mDefaultState);
        addState(this.mWaitBeforeRenewalState, this.mDefaultState);
        setInitialState(this.mStoppedState);
    }

    public static DhcpStateMachine makeDhcpStateMachine(Context context, StateMachine stateMachine, String str) {
        DhcpStateMachine dhcpStateMachine = new DhcpStateMachine(context, stateMachine, str);
        dhcpStateMachine.start();
        return dhcpStateMachine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean runDhcp(DhcpAction dhcpAction) {
        boolean z = false;
        DhcpResults dhcpResults = new DhcpResults();
        if (dhcpAction == DhcpAction.START) {
            NetworkUtils.stopDhcp(this.mInterfaceName);
            z = NetworkUtils.runDhcp(this.mInterfaceName, dhcpResults);
        } else if (dhcpAction == DhcpAction.RENEW) {
            boolean runDhcpRenew = NetworkUtils.runDhcpRenew(this.mInterfaceName, dhcpResults);
            z = runDhcpRenew;
            if (runDhcpRenew) {
                dhcpResults.updateFromDhcpRequest(this.mDhcpResults);
                z = runDhcpRenew;
            }
        }
        if (!z) {
            Log.e(TAG, "DHCP failed on " + this.mInterfaceName + ": " + NetworkUtils.getDhcpError());
            NetworkUtils.stopDhcp(this.mInterfaceName);
            this.mController.obtainMessage(CMD_POST_DHCP_ACTION, 2, 0).sendToTarget();
            return z;
        }
        long j = dhcpResults.leaseDuration;
        if (j >= 0) {
            long j2 = j;
            if (j < 300) {
                j2 = 300;
            }
            this.mAlarmManager.setExact(2, SystemClock.elapsedRealtime() + (480 * j2), this.mDhcpRenewalIntent);
        }
        this.mDhcpResults = dhcpResults;
        this.mController.obtainMessage(CMD_POST_DHCP_ACTION, 1, 0, dhcpResults).sendToTarget();
        return z;
    }

    public void doQuit() {
        quit();
    }

    @Override // com.android.internal.util.StateMachine
    protected void onQuitting() {
        this.mController.sendMessage(CMD_ON_QUIT);
    }

    public void registerForPreDhcpNotification() {
        this.mRegisteredForPreDhcpNotification = true;
    }
}
