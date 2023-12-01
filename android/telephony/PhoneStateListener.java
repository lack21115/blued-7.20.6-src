package android.telephony;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.internal.telephony.IPhoneStateListener;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/PhoneStateListener.class */
public class PhoneStateListener {
    private static final boolean DBG = false;
    public static final int LISTEN_CALL_FORWARDING_INDICATOR = 8;
    public static final int LISTEN_CALL_STATE = 32;
    public static final int LISTEN_CELL_INFO = 1024;
    public static final int LISTEN_CELL_LOCATION = 16;
    public static final int LISTEN_DATA_ACTIVITY = 128;
    public static final int LISTEN_DATA_CONNECTION_REAL_TIME_INFO = 8192;
    public static final int LISTEN_DATA_CONNECTION_STATE = 64;
    public static final int LISTEN_MESSAGE_WAITING_INDICATOR = 4;
    public static final int LISTEN_NONE = 0;
    public static final int LISTEN_OEM_HOOK_RAW_EVENT = 32768;
    public static final int LISTEN_OTASP_CHANGED = 512;
    public static final int LISTEN_PRECISE_CALL_STATE = 2048;
    public static final int LISTEN_PRECISE_DATA_CONNECTION_STATE = 4096;
    public static final int LISTEN_SERVICE_STATE = 1;
    @Deprecated
    public static final int LISTEN_SIGNAL_STRENGTH = 2;
    public static final int LISTEN_SIGNAL_STRENGTHS = 256;
    public static final int LISTEN_VOLTE_STATE = 16384;
    private static final String LOG_TAG = "PhoneStateListener";
    IPhoneStateListener callback;
    private final Handler mHandler;
    protected int mSubId;

    public PhoneStateListener() {
        this(Integer.MAX_VALUE, Looper.myLooper());
    }

    public PhoneStateListener(int i) {
        this(i, Looper.myLooper());
    }

    public PhoneStateListener(int i, Looper looper) {
        this.mSubId = -1;
        this.callback = new IPhoneStateListener.Stub() { // from class: android.telephony.PhoneStateListener.2
            public void onCallForwardingIndicatorChanged(boolean z) {
                Message.obtain(PhoneStateListener.this.mHandler, 8, z ? 1 : 0, 0, null).sendToTarget();
            }

            public void onCallStateChanged(int i2, String str) {
                Message.obtain(PhoneStateListener.this.mHandler, 32, i2, 0, str).sendToTarget();
            }

            public void onCellInfoChanged(List<CellInfo> list) {
                Message.obtain(PhoneStateListener.this.mHandler, 1024, 0, 0, list).sendToTarget();
            }

            public void onCellLocationChanged(Bundle bundle) {
                Message.obtain(PhoneStateListener.this.mHandler, 16, 0, 0, CellLocation.newFromBundle(bundle)).sendToTarget();
            }

            public void onDataActivity(int i2) {
                Message.obtain(PhoneStateListener.this.mHandler, 128, i2, 0, null).sendToTarget();
            }

            public void onDataConnectionRealTimeInfoChanged(DataConnectionRealTimeInfo dataConnectionRealTimeInfo) {
                Message.obtain(PhoneStateListener.this.mHandler, 8192, 0, 0, dataConnectionRealTimeInfo).sendToTarget();
            }

            public void onDataConnectionStateChanged(int i2, int i3) {
                Message.obtain(PhoneStateListener.this.mHandler, 64, i2, i3).sendToTarget();
            }

            public void onMessageWaitingIndicatorChanged(boolean z) {
                Message.obtain(PhoneStateListener.this.mHandler, 4, z ? 1 : 0, 0, null).sendToTarget();
            }

            public void onOemHookRawEvent(byte[] bArr) {
                Message.obtain(PhoneStateListener.this.mHandler, 32768, 0, 0, bArr).sendToTarget();
            }

            public void onOtaspChanged(int i2) {
                Message.obtain(PhoneStateListener.this.mHandler, 512, i2, 0).sendToTarget();
            }

            public void onPreciseCallStateChanged(PreciseCallState preciseCallState) {
                Message.obtain(PhoneStateListener.this.mHandler, 2048, 0, 0, preciseCallState).sendToTarget();
            }

            public void onPreciseDataConnectionStateChanged(PreciseDataConnectionState preciseDataConnectionState) {
                Message.obtain(PhoneStateListener.this.mHandler, 4096, 0, 0, preciseDataConnectionState).sendToTarget();
            }

            public void onServiceStateChanged(ServiceState serviceState) {
                Message.obtain(PhoneStateListener.this.mHandler, 1, 0, 0, serviceState).sendToTarget();
            }

            public void onSignalStrengthChanged(int i2) {
                Message.obtain(PhoneStateListener.this.mHandler, 2, i2, 0, null).sendToTarget();
            }

            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                Message.obtain(PhoneStateListener.this.mHandler, 256, 0, 0, signalStrength).sendToTarget();
            }

            public void onUnregistered() {
                PhoneStateListener.this.mHandler.removeCallbacksAndMessages(null);
            }

            public void onVoLteServiceStateChanged(VoLteServiceState voLteServiceState) {
                Message.obtain(PhoneStateListener.this.mHandler, 16384, 0, 0, voLteServiceState).sendToTarget();
            }
        };
        this.mSubId = i;
        this.mHandler = new Handler(looper) { // from class: android.telephony.PhoneStateListener.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z = true;
                switch (message.what) {
                    case 1:
                        PhoneStateListener.this.onServiceStateChanged((ServiceState) message.obj);
                        return;
                    case 2:
                        PhoneStateListener.this.onSignalStrengthChanged(message.arg1);
                        return;
                    case 4:
                        PhoneStateListener phoneStateListener = PhoneStateListener.this;
                        if (message.arg1 == 0) {
                            z = false;
                        }
                        phoneStateListener.onMessageWaitingIndicatorChanged(z);
                        return;
                    case 8:
                        PhoneStateListener.this.onCallForwardingIndicatorChanged(message.arg1 != 0);
                        return;
                    case 16:
                        PhoneStateListener.this.onCellLocationChanged((CellLocation) message.obj);
                        return;
                    case 32:
                        PhoneStateListener.this.onCallStateChanged(message.arg1, (String) message.obj);
                        return;
                    case 64:
                        PhoneStateListener.this.onDataConnectionStateChanged(message.arg1, message.arg2);
                        PhoneStateListener.this.onDataConnectionStateChanged(message.arg1);
                        return;
                    case 128:
                        PhoneStateListener.this.onDataActivity(message.arg1);
                        return;
                    case 256:
                        PhoneStateListener.this.onSignalStrengthsChanged((SignalStrength) message.obj);
                        return;
                    case 512:
                        PhoneStateListener.this.onOtaspChanged(message.arg1);
                        return;
                    case 1024:
                        PhoneStateListener.this.onCellInfoChanged((List) message.obj);
                        return;
                    case 2048:
                        PhoneStateListener.this.onPreciseCallStateChanged((PreciseCallState) message.obj);
                        return;
                    case 4096:
                        PhoneStateListener.this.onPreciseDataConnectionStateChanged((PreciseDataConnectionState) message.obj);
                        return;
                    case 8192:
                        PhoneStateListener.this.onDataConnectionRealTimeInfoChanged((DataConnectionRealTimeInfo) message.obj);
                        return;
                    case 16384:
                        PhoneStateListener.this.onVoLteServiceStateChanged((VoLteServiceState) message.obj);
                        return;
                    case 32768:
                        PhoneStateListener.this.onOemHookRawEvent((byte[]) message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public PhoneStateListener(Looper looper) {
        this(Integer.MAX_VALUE, looper);
    }

    private void log(String str) {
        Rlog.d(LOG_TAG, str);
    }

    public void onCallForwardingIndicatorChanged(boolean z) {
    }

    public void onCallStateChanged(int i, String str) {
    }

    public void onCellInfoChanged(List<CellInfo> list) {
    }

    public void onCellLocationChanged(CellLocation cellLocation) {
    }

    public void onDataActivity(int i) {
    }

    public void onDataConnectionRealTimeInfoChanged(DataConnectionRealTimeInfo dataConnectionRealTimeInfo) {
    }

    public void onDataConnectionStateChanged(int i) {
    }

    public void onDataConnectionStateChanged(int i, int i2) {
    }

    public void onMessageWaitingIndicatorChanged(boolean z) {
    }

    public void onOemHookRawEvent(byte[] bArr) {
    }

    public void onOtaspChanged(int i) {
    }

    public void onPreciseCallStateChanged(PreciseCallState preciseCallState) {
    }

    public void onPreciseDataConnectionStateChanged(PreciseDataConnectionState preciseDataConnectionState) {
    }

    public void onServiceStateChanged(ServiceState serviceState) {
    }

    @Deprecated
    public void onSignalStrengthChanged(int i) {
    }

    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
    }

    public void onVoLteServiceStateChanged(VoLteServiceState voLteServiceState) {
    }
}
