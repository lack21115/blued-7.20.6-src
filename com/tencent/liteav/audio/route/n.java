package com.tencent.liteav.audio.route;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/n.class */
public final class n extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final Context f36272a;
    b b = null;

    /* renamed from: c  reason: collision with root package name */
    private final a f36273c;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/n$a.class */
    public static class a {
        public void onBluetoothConnectionChanged(boolean z) {
        }

        public void onBluetoothSCOConnected(boolean z) {
        }

        public void onWiredHeadsetConnectionChanged(boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/n$b.class */
    public static final class b implements BluetoothProfile.ServiceListener {

        /* renamed from: a  reason: collision with root package name */
        final BluetoothAdapter f36274a;
        BluetoothProfile b = null;

        /* renamed from: c  reason: collision with root package name */
        final Object f36275c = new Object();
        private final Context d;

        public b(Context context) {
            this.d = context;
            BluetoothAdapter c2 = c();
            this.f36274a = c2;
            if (c2 == null) {
                Log.i("AudioSystemBroadcastReceiver", "bluetooth adapter is null", new Object[0]);
                return;
            }
            try {
                c2.getProfileProxy(context, this, 1);
            } catch (Throwable th) {
                Log.w("AudioSystemBroadcastReceiver", "getProfileProxy " + th.getMessage(), new Object[0]);
            }
        }

        private static BluetoothAdapter c() {
            try {
                return BluetoothAdapter.getDefaultAdapter();
            } catch (Throwable th) {
                Log.w("AudioSystemBroadcastReceiver", "getDefaultAdapter exception " + th.getMessage(), new Object[0]);
                return null;
            }
        }

        private List<BluetoothDevice> d() {
            try {
                return this.b.getConnectedDevices();
            } catch (Throwable th) {
                Log.w("AudioSystemBroadcastReceiver", "getConnectedDevices exception " + th.getMessage(), new Object[0]);
                return null;
            }
        }

        private boolean e() {
            try {
                return this.f36274a.isEnabled();
            } catch (Throwable th) {
                Log.w("AudioSystemBroadcastReceiver", "isEnabled exception " + th.getMessage(), new Object[0]);
                return false;
            }
        }

        public final boolean a() {
            boolean z;
            if (this.f36274a == null || !e()) {
                return false;
            }
            List<BluetoothDevice> list = null;
            synchronized (this.f36275c) {
                if (this.b == null) {
                    try {
                        Log.i("AudioSystemBroadcastReceiver", "mBluetoothHeadsetProfile is null ,wait for 1000ms", new Object[0]);
                        this.f36275c.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (this.b == null) {
                        return false;
                    }
                    Log.i("AudioSystemBroadcastReceiver", "mBluetoothHeadsetProfile service is connected now", new Object[0]);
                }
                try {
                    if (n.a(this.d)) {
                        list = d();
                    }
                    z = false;
                    if (list != null) {
                        z = false;
                        if (list.size() > 0) {
                            z = true;
                        }
                    }
                } catch (Exception e2) {
                    Log.e("AudioSystemBroadcastReceiver", "get connected bluetooth devices failed." + e2.getMessage(), new Object[0]);
                    z = false;
                }
                return z;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void b() {
            try {
                this.f36274a.closeProfileProxy(1, this.b);
            } catch (Throwable th) {
                Log.w("AudioSystemBroadcastReceiver", "closeProfileProxy exception " + th.getMessage(), new Object[0]);
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            if (i != 1) {
                return;
            }
            synchronized (this.f36275c) {
                if (this.f36274a != null && this.b != null) {
                    Log.i("AudioSystemBroadcastReceiver", "BluetoohHeadset proxy changed from %s to %s", this.b, bluetoothProfile);
                    b();
                    this.b = null;
                }
                this.b = bluetoothProfile;
                this.f36275c.notifyAll();
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceDisconnected(int i) {
            if (i != 1) {
                return;
            }
            synchronized (this.f36275c) {
                if (this.f36274a != null && this.b != null) {
                    b();
                    this.b = null;
                }
            }
        }
    }

    public n(Context context, a aVar) {
        this.f36272a = context;
        this.f36273c = aVar;
    }

    private static int a(Intent intent, String str, int i) {
        try {
            return intent.getIntExtra(str, i);
        } catch (Exception e) {
            LiteavLog.e("AudioSystemBroadcastReceiver", "getIntentIntExtra ".concat(String.valueOf(e)));
            return i;
        }
    }

    private static String a(int i) {
        switch (i) {
            case 10:
                return "STATE_OFF";
            case 11:
                return "STATE_TURNING_ON";
            case 12:
                return "STATE_ON";
            case 13:
                return "STATE_TURNING_OFF";
            default:
                return "unknown";
        }
    }

    static /* synthetic */ boolean a(Context context) {
        boolean z = true;
        if (context != null) {
            z = true;
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 31) {
                if (context.checkPermission("android.permission.BLUETOOTH_CONNECT", Process.myPid(), Process.myUid()) == 0) {
                    return true;
                }
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z;
        boolean z2 = false;
        if (intent == null || context == null) {
            Log.e("AudioSystemBroadcastReceiver", "onReceive intent or context is null!", new Object[0]);
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        Log.i("AudioSystemBroadcastReceiver", "receive Action: %s", action);
        switch (action.hashCode()) {
            case -1676458352:
                if (action.equals("android.intent.action.HEADSET_PLUG")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -1530327060:
                if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1435586571:
                if (action.equals(BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 545516589:
                if (action.equals(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z) {
            int a2 = a(intent, "state", -1);
            if (a2 == -1) {
                Log.e("AudioSystemBroadcastReceiver", "unknown headset state, ignore...", new Object[0]);
                return;
            }
            a aVar = this.f36273c;
            if (a2 != 0) {
                z2 = true;
            }
            aVar.onWiredHeadsetConnectionChanged(z2);
        } else if (z) {
            int a3 = a(intent, BluetoothAdapter.EXTRA_STATE, 0);
            Log.i("AudioSystemBroadcastReceiver", "receive ACTION_STATE_CHANGED, EXTRA_STATE: %s, EXTRA_PREVIOUS_STATE: %s", a(a3), a(a(intent, BluetoothAdapter.EXTRA_PREVIOUS_STATE, 0)));
            if (a3 == 10) {
                this.f36273c.onBluetoothConnectionChanged(false);
            }
        } else if (z) {
            int a4 = a(intent, BluetoothProfile.EXTRA_STATE, -1);
            Log.i("AudioSystemBroadcastReceiver", "receive bluetooth headset connection state changed: %s", a4 != 0 ? a4 != 1 ? a4 != 2 ? a4 != 3 ? "unknown" : "STATE_DISCONNECTING" : "STATE_CONNECTED" : "STATE_CONNECTING" : "STATE_DISCONNECTED");
            if (a4 == 0) {
                this.f36273c.onBluetoothConnectionChanged(false);
            } else if (a4 != 2) {
            } else {
                this.f36273c.onBluetoothConnectionChanged(true);
            }
        } else if (!z) {
            Log.w("AudioSystemBroadcastReceiver", "ignore unknow Action: %s", action);
        } else {
            int a5 = a(intent, BluetoothProfile.EXTRA_STATE, 10);
            if (a5 == 12) {
                Log.i("AudioSystemBroadcastReceiver", "receive bluetooth audio state changed to STATE_AUDIO_CONNECTED", new Object[0]);
                this.f36273c.onBluetoothSCOConnected(true);
            } else if (a5 == 10) {
                Log.i("AudioSystemBroadcastReceiver", "receive bluetooth audio state changed to STATE_AUDIO_DISCONNECTED", new Object[0]);
                this.f36273c.onBluetoothSCOConnected(false);
            }
        }
    }
}
