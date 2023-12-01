package com.blued.android.module.media.audio.audio_manager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.util.List;
import java.util.Set;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLBluetoothManager.class */
public class BLBluetoothManager {
    private final Context a;
    private final BLAudioManager b;
    private final AudioManager c;
    private final Handler d;
    private int e;
    private State f;
    private final BluetoothProfile.ServiceListener g;
    private BluetoothAdapter h;
    private BluetoothHeadset i;
    private BluetoothDevice j;
    private final BroadcastReceiver k;
    private final Runnable l = new Runnable() { // from class: com.blued.android.module.media.audio.audio_manager.BLBluetoothManager.1
        @Override // java.lang.Runnable
        public void run() {
            BLBluetoothManager.this.h();
        }
    };

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLBluetoothManager$BluetoothHeadsetBroadcastReceiver.class */
    class BluetoothHeadsetBroadcastReceiver extends BroadcastReceiver {
        private BluetoothHeadsetBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (BLBluetoothManager.this.f == State.UNINITIALIZED) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                Log.d("BLBluetoothManager", "BluetoothHeadsetBroadcastReceiver.onReceive: a=ACTION_CONNECTION_STATE_CHANGED, s=" + BLBluetoothManager.this.a(intExtra) + ", sb=" + isInitialStickyBroadcast() + ", BT state: " + BLBluetoothManager.this.f);
                if (intExtra == 2) {
                    BLBluetoothManager.this.e = 0;
                    BLBluetoothManager.this.f();
                } else if (intExtra != 1 && intExtra != 3 && intExtra == 0) {
                    BLBluetoothManager.this.d();
                    BLBluetoothManager.this.f();
                }
            } else if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
                Log.d("BLBluetoothManager", "BluetoothHeadsetBroadcastReceiver.onReceive: a=ACTION_AUDIO_STATE_CHANGED, s=" + BLBluetoothManager.this.a(intExtra2) + ", sb=" + isInitialStickyBroadcast() + ", BT state: " + BLBluetoothManager.this.f);
                if (intExtra2 == 12) {
                    BLBluetoothManager.this.g();
                    if (BLBluetoothManager.this.f == State.SCO_CONNECTING) {
                        Log.d("BLBluetoothManager", "+++ Bluetooth audio SCO is now connected");
                        BLBluetoothManager.this.f = State.SCO_CONNECTED;
                        BLBluetoothManager.this.e = 0;
                        BLBluetoothManager.this.f();
                    } else {
                        Log.w("BLBluetoothManager", "Unexpected state BluetoothHeadset.STATE_AUDIO_CONNECTED");
                    }
                } else if (intExtra2 == 11) {
                    Log.d("BLBluetoothManager", "+++ Bluetooth audio SCO is now connecting...");
                } else if (intExtra2 == 10) {
                    Log.d("BLBluetoothManager", "+++ Bluetooth audio SCO is now disconnected");
                    if (isInitialStickyBroadcast()) {
                        Log.d("BLBluetoothManager", "Ignore STATE_AUDIO_DISCONNECTED initial sticky broadcast.");
                        return;
                    }
                    BLBluetoothManager.this.f();
                }
            }
            Log.d("BLBluetoothManager", "onReceive done: BT state=" + BLBluetoothManager.this.f);
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLBluetoothManager$BluetoothServiceListener.class */
    class BluetoothServiceListener implements BluetoothProfile.ServiceListener {
        private BluetoothServiceListener() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            if (i != 1 || BLBluetoothManager.this.f == State.UNINITIALIZED) {
                return;
            }
            Log.d("BLBluetoothManager", "BluetoothServiceListener.onServiceConnected: BT state=" + BLBluetoothManager.this.f);
            BLBluetoothManager.this.i = (BluetoothHeadset) bluetoothProfile;
            BLBluetoothManager.this.f();
            Log.d("BLBluetoothManager", "onServiceConnected done: BT state=" + BLBluetoothManager.this.f);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            if (i != 1 || BLBluetoothManager.this.f == State.UNINITIALIZED) {
                return;
            }
            Log.d("BLBluetoothManager", "BluetoothServiceListener.onServiceDisconnected: BT state=" + BLBluetoothManager.this.f);
            BLBluetoothManager.this.d();
            BLBluetoothManager.this.i = null;
            BLBluetoothManager.this.j = null;
            BLBluetoothManager.this.f = State.HEADSET_UNAVAILABLE;
            BLBluetoothManager.this.f();
            Log.d("BLBluetoothManager", "onServiceDisconnected done: BT state=" + BLBluetoothManager.this.f);
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLBluetoothManager$State.class */
    public enum State {
        UNINITIALIZED,
        ERROR,
        HEADSET_UNAVAILABLE,
        HEADSET_AVAILABLE,
        SCO_DISCONNECTING,
        SCO_CONNECTING,
        SCO_CONNECTED
    }

    protected BLBluetoothManager(Context context, BLAudioManager bLAudioManager) {
        Log.d("BLBluetoothManager", "ctor");
        ThreadUtils.a();
        this.a = context;
        this.b = bLAudioManager;
        this.c = a(context);
        this.f = State.UNINITIALIZED;
        this.g = new BluetoothServiceListener();
        this.k = new BluetoothHeadsetBroadcastReceiver();
        this.d = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BLBluetoothManager a(Context context, BLAudioManager bLAudioManager) {
        Log.d("BLBluetoothManager", "create" + BLUtils.a());
        return new BLBluetoothManager(context, bLAudioManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        switch (i) {
                            case 10:
                                return "OFF";
                            case 11:
                                return "TURNING_ON";
                            case 12:
                                return "ON";
                            case 13:
                                return "TURNING_OFF";
                            default:
                                return "INVALID";
                        }
                    }
                    return "DISCONNECTING";
                }
                return "CONNECTED";
            }
            return "CONNECTING";
        }
        return "DISCONNECTED";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ThreadUtils.a();
        Log.d("BLBluetoothManager", "updateAudioDeviceState");
        this.b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ThreadUtils.a();
        Log.d("BLBluetoothManager", "cancelTimer");
        this.d.removeCallbacks(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h() {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.media.audio.audio_manager.BLBluetoothManager.h():void");
    }

    private boolean i() {
        return this.c.isBluetoothScoOn();
    }

    protected AudioManager a(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public State a() {
        ThreadUtils.a();
        return this.f;
    }

    protected void a(BluetoothAdapter bluetoothAdapter) {
        Log.d("BLBluetoothManager", "BluetoothAdapter: enabled=" + bluetoothAdapter.isEnabled() + ", state=" + a(bluetoothAdapter.getState()) + ", name=" + bluetoothAdapter.getName() + ", address=" + bluetoothAdapter.getAddress());
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        if (bondedDevices.isEmpty()) {
            return;
        }
        Log.d("BLBluetoothManager", "paired devices:");
        for (BluetoothDevice bluetoothDevice : bondedDevices) {
            Log.d("BLBluetoothManager", " name=" + bluetoothDevice.getName() + ", address=" + bluetoothDevice.getAddress());
        }
    }

    protected boolean a(Context context, BluetoothProfile.ServiceListener serviceListener, int i) {
        return this.h.getProfileProxy(context, serviceListener, i);
    }

    protected boolean a(Context context, String str) {
        return this.a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public void b() {
        ThreadUtils.a();
        Log.d("BLBluetoothManager", "start");
        if (!a(this.a, "android.permission.BLUETOOTH")) {
            Log.w("BLBluetoothManager", "Process (pid=" + Process.myPid() + ") lacks BLUETOOTH permission");
        } else if (this.f != State.UNINITIALIZED) {
            Log.w("BLBluetoothManager", "Invalid BT state");
        } else {
            this.i = null;
            this.j = null;
            this.e = 0;
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            this.h = defaultAdapter;
            if (defaultAdapter == null) {
                Log.w("BLBluetoothManager", "Device does not support Bluetooth");
            } else if (!this.c.isBluetoothScoAvailableOffCall()) {
                Log.e("BLBluetoothManager", "Bluetooth SCO audio is not available off call");
            } else {
                a(this.h);
                if (!a(this.a, this.g, 1)) {
                    Log.e("BLBluetoothManager", "BluetoothAdapter.getProfileProxy(HEADSET) failed");
                    return;
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
                registerReceiver(this.k, intentFilter);
                Log.d("BLBluetoothManager", "HEADSET profile state: " + a(this.h.getProfileConnectionState(1)));
                Log.d("BLBluetoothManager", "Bluetooth proxy for headset profile has started");
                this.f = State.HEADSET_UNAVAILABLE;
                Log.d("BLBluetoothManager", "start done: BT state=" + this.f);
            }
        }
    }

    public void c() {
        ThreadUtils.a();
        Log.d("BLBluetoothManager", "stop: BT state=" + this.f);
        if (this.h == null) {
            return;
        }
        d();
        if (this.f == State.UNINITIALIZED) {
            return;
        }
        unregisterReceiver(this.k);
        g();
        BluetoothHeadset bluetoothHeadset = this.i;
        if (bluetoothHeadset != null) {
            this.h.closeProfileProxy(1, bluetoothHeadset);
            this.i = null;
        }
        this.h = null;
        this.j = null;
        this.f = State.UNINITIALIZED;
        Log.d("BLBluetoothManager", "stop done: BT state=" + this.f);
    }

    public void d() {
        ThreadUtils.a();
        Log.d("BLBluetoothManager", "stopScoAudio: BT state=" + this.f + ", SCO is on: " + i());
        if (this.f == State.SCO_CONNECTING || this.f == State.SCO_CONNECTED) {
            g();
            this.c.stopBluetoothSco();
            this.c.setBluetoothScoOn(false);
            this.f = State.SCO_DISCONNECTING;
            Log.d("BLBluetoothManager", "stopScoAudio done: BT state=" + this.f + ", SCO is on: " + i());
        }
    }

    public void e() {
        if (this.f == State.UNINITIALIZED || this.i == null) {
            return;
        }
        Log.d("BLBluetoothManager", "updateDevice");
        List<BluetoothDevice> connectedDevices = this.i.getConnectedDevices();
        if (connectedDevices.isEmpty()) {
            this.j = null;
            this.f = State.HEADSET_UNAVAILABLE;
            Log.d("BLBluetoothManager", "No connected bluetooth headset");
        } else {
            this.j = connectedDevices.get(0);
            this.f = State.HEADSET_AVAILABLE;
            Log.d("BLBluetoothManager", "Connected bluetooth headset: name=" + this.j.getName() + ", state=" + a(this.i.getConnectionState(this.j)) + ", SCO audio=" + this.i.isAudioConnected(this.j));
        }
        Log.d("BLBluetoothManager", "updateDevice done: BT state=" + this.f);
    }

    protected void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.a.registerReceiver(broadcastReceiver, intentFilter);
    }

    protected void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.a.unregisterReceiver(broadcastReceiver);
    }
}
