package com.zego.ve;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.nearx.tapplugin.pluginapi.BuildConfig;
import com.zego.ve.IHwAudioEngine;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/HwAudioKit.class */
public class HwAudioKit {
    public static final int APP_CONTEXT_NULL = 7;
    public static final int AUDIO_KIT_SERVICE_DIED = 6;
    public static final int AUDIO_KIT_SERVICE_DISCONNECTED = 4;
    public static final int AUDIO_KIT_SERVICE_LINKFAILED = 5;
    public static final int AUDIO_KIT_SUCCESS = 0;
    private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioEngineService";
    public static final int GET_LATENCY_FAIL = -1;
    public static final int KARAOKE_SERVICE_DIED = 1003;
    public static final int KARAOKE_SERVICE_DISCONNECTED = 1001;
    public static final int KARAOKE_SERVICE_LINKFAIL = 1002;
    public static final int KARAOKE_SUCCESS = 1000;
    public static final int KARAOKE_WIRED_HEADSET_NOT_PLUG_IN = 1805;
    public static final int PARAME_VALUE_ERROR = 1807;
    public static final int PLATEFORM_NOT_SUPPORT = 1806;
    public static final int SERVICE_BIND_ERROR = -2;
    private static final String TAG = "HwAudioKit.HwAudioKit";
    public static final int VENDOR_NOT_SUPPORTED = 2;
    protected IAudioKitCallback _callBack;
    private Context mContext;
    private IHwAudioEngine mIHwAudioEngine = null;
    private boolean mIsServiceConnected = false;
    private FeatureKitManager mFeatureKitManager = FeatureKitManager.getInstance();
    private IBinder mService = null;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.zego.ve.HwAudioKit.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HwAudioKit.this.mIHwAudioEngine = IHwAudioEngine.Stub.asInterface(iBinder);
            if (HwAudioKit.this.mIHwAudioEngine != null) {
                HwAudioKit.this.mIsServiceConnected = true;
                HwAudioKit.this.mFeatureKitManager.onCallBack(0);
                HwAudioKit hwAudioKit = HwAudioKit.this;
                hwAudioKit.serviceInit(hwAudioKit.mContext.getPackageName(), BuildConfig.VERSION_NAME);
                HwAudioKit.this.serviceLinkToDeath(iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HwAudioKit.this.mIHwAudioEngine = null;
            HwAudioKit.this.mIsServiceConnected = false;
            HwAudioKit.this.mFeatureKitManager.onCallBack(4);
        }
    };
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.zego.ve.HwAudioKit.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            HwAudioKit.this.mService.unlinkToDeath(HwAudioKit.this.mDeathRecipient, 0);
            HwAudioKit.this.mFeatureKitManager.onCallBack(6);
            HwAudioKit.this.mService = null;
        }
    };
    protected HwAudioKaraokeFeatureKit _hwAudioKaraokeFeatureKit = null;
    protected state _state = state.state_none;
    protected CountDownLatch barrier = null;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/HwAudioKit$state.class */
    enum state {
        state_none,
        state_audiokit_success,
        state_audiokit_failed,
        state_karaoke_success,
        state_karaoke_failed
    }

    public HwAudioKit(Context context) {
        this.mContext = null;
        IAudioKitCallback iAudioKitCallback = new IAudioKitCallback() { // from class: com.zego.ve.HwAudioKit.3
            @Override // com.zego.ve.IAudioKitCallback
            public void onResult(int i) {
                Log.i(HwAudioKit.TAG, "audiokit callback " + i);
                if (i == 0) {
                    HwAudioKit.this._state = state.state_audiokit_success;
                } else if (i != 2 && i != 4 && i != 5 && i != 6) {
                    switch (i) {
                        case 1000:
                            HwAudioKit.this._state = state.state_karaoke_success;
                            break;
                        case 1001:
                        case 1002:
                        case 1003:
                            HwAudioKit.this._state = state.state_karaoke_failed;
                            break;
                    }
                } else {
                    HwAudioKit.this._state = state.state_audiokit_failed;
                }
                if (HwAudioKit.this.barrier != null) {
                    HwAudioKit.this.barrier.countDown();
                }
            }
        };
        this._callBack = iAudioKitCallback;
        this.mFeatureKitManager.setCallBack(iAudioKitCallback);
        this.mContext = context;
    }

    private void bindService(Context context) {
        FeatureKitManager featureKitManager = this.mFeatureKitManager;
        if (featureKitManager == null || this.mIsServiceConnected) {
            return;
        }
        featureKitManager.bindService(context, this.mConnection, ENGINE_CLASS_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceInit(String str, String str2) {
        try {
            if (this.mIHwAudioEngine == null || !this.mIsServiceConnected) {
                return;
            }
            this.mIHwAudioEngine.init(str, str2);
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceLinkToDeath(IBinder iBinder) {
        this.mService = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this.mDeathRecipient, 0);
            } catch (RemoteException e) {
                this.mFeatureKitManager.onCallBack(5);
            }
        }
    }

    public void createFeatureKaraoke() {
        this.barrier = new CountDownLatch(1);
        this._hwAudioKaraokeFeatureKit = this.mFeatureKitManager.createFeatureKit(1, this.mContext);
        try {
            if (!this.barrier.await(1000L, TimeUnit.MILLISECONDS)) {
                Log.e(TAG, "createFeatureKaraoke timeout");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.barrier = null;
    }

    public void destroy() {
        if (this.mIsServiceConnected) {
            this.mIsServiceConnected = false;
            this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
        }
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this._hwAudioKaraokeFeatureKit;
        if (hwAudioKaraokeFeatureKit != null) {
            hwAudioKaraokeFeatureKit.destroy();
        }
    }

    public int enableKaraokeFeature(boolean z) {
        return this._hwAudioKaraokeFeatureKit.enableKaraokeFeature(z);
    }

    public boolean initialize() {
        this.barrier = new CountDownLatch(1);
        Context context = this.mContext;
        if (context == null) {
            this.mFeatureKitManager.onCallBack(7);
        } else if (this.mFeatureKitManager.isMediaKitSupport(context)) {
            bindService(this.mContext);
        } else {
            this.mFeatureKitManager.onCallBack(2);
        }
        try {
            if (!this.barrier.await(1000L, TimeUnit.MILLISECONDS)) {
                Log.e(TAG, "initialize timeout");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.barrier = null;
        return this._state == state.state_audiokit_success;
    }

    public boolean isFeatureKaraokeOn() {
        return this._state == state.state_karaoke_success;
    }

    public void setKaraokeReverbMode(int i) {
        this._hwAudioKaraokeFeatureKit.setParameter("Karaoke_reverb_mode=", i);
    }

    public void setKaraokeVolume(int i) {
        int i2 = i;
        if (i > 100) {
            i2 = 100;
        }
        this._hwAudioKaraokeFeatureKit.setParameter("Karaoke_volume=", i2);
    }
}
