package android.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.SamplingDataTracker;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.R;
import com.android.internal.telephony.DctConstants;
import com.android.internal.telephony.ITelephony;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.telephony.TelephonyIntents;
import com.android.internal.util.AsyncChannel;
import com.android.internal.util.cm.QSConstants;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-9557208-dex2jar.jar:android/net/MobileDataStateTracker.class */
public class MobileDataStateTracker extends BaseNetworkStateTracker {
    private static final boolean DBG = false;
    private static final String TAG = "MobileDataStateTracker";
    private static final int UNKNOWN = Integer.MAX_VALUE;
    private static final boolean VDBG = false;
    private static NetworkDataEntry[] mTheoreticalBWTable = {new NetworkDataEntry(2, 237, 118, Integer.MAX_VALUE), new NetworkDataEntry(1, 48, 40, Integer.MAX_VALUE), new NetworkDataEntry(3, 384, 64, Integer.MAX_VALUE), new NetworkDataEntry(8, 14400, Integer.MAX_VALUE, Integer.MAX_VALUE), new NetworkDataEntry(9, 14400, 5760, Integer.MAX_VALUE), new NetworkDataEntry(10, 14400, 5760, Integer.MAX_VALUE), new NetworkDataEntry(15, 21000, 5760, Integer.MAX_VALUE), new NetworkDataEntry(4, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE), new NetworkDataEntry(7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE), new NetworkDataEntry(5, 2468, 153, Integer.MAX_VALUE), new NetworkDataEntry(6, 3072, 1800, Integer.MAX_VALUE), new NetworkDataEntry(12, 14700, 1800, Integer.MAX_VALUE), new NetworkDataEntry(11, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE), new NetworkDataEntry(13, 100000, 50000, Integer.MAX_VALUE), new NetworkDataEntry(14, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)};
    private String mApnType;
    private Context mContext;
    private AsyncChannel mDataConnectionTrackerAc;
    private Handler mHandler;
    private LinkProperties mLinkProperties;
    private PhoneConstants.DataState mMobileDataState;
    private NetworkInfo mNetworkInfo;
    private ITelephony mPhoneService;
    private SignalStrength mSignalStrength;
    private Handler mTarget;
    private boolean mTeardownRequested = false;
    private boolean mPrivateDnsRouteSet = false;
    private boolean mDefaultRouteSet = false;
    protected boolean mUserDataEnabled = true;
    protected boolean mPolicyDataEnabled = true;
    private AtomicBoolean mIsCaptivePortal = new AtomicBoolean(false);
    private SamplingDataTracker mSamplingDataTracker = new SamplingDataTracker();
    private final PhoneStateListener mPhoneStateListener = new PhoneStateListener() { // from class: android.net.MobileDataStateTracker.1
        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            MobileDataStateTracker.this.mSignalStrength = signalStrength;
        }
    };

    /* renamed from: android.net.MobileDataStateTracker$2  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/net/MobileDataStateTracker$2.class */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$android$internal$telephony$PhoneConstants$DataState = new int[PhoneConstants.DataState.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0038 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003c -> B:21:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0040 -> B:19:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$com$android$internal$telephony$PhoneConstants$DataState[PhoneConstants.DataState.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$android$internal$telephony$PhoneConstants$DataState[PhoneConstants.DataState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$android$internal$telephony$PhoneConstants$DataState[PhoneConstants.DataState.SUSPENDED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$android$internal$telephony$PhoneConstants$DataState[PhoneConstants.DataState.CONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/MobileDataStateTracker$MdstHandler.class */
    static class MdstHandler extends Handler {
        private MobileDataStateTracker mMdst;

        MdstHandler(Looper looper, MobileDataStateTracker mobileDataStateTracker) {
            super(looper);
            this.mMdst = mobileDataStateTracker;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 69632:
                    if (message.arg1 == 0) {
                        this.mMdst.mDataConnectionTrackerAc = (AsyncChannel) message.obj;
                        return;
                    }
                    return;
                case AsyncChannel.CMD_CHANNEL_DISCONNECTED /* 69636 */:
                    this.mMdst.mDataConnectionTrackerAc = null;
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/MobileDataStateTracker$MobileDataStateReceiver.class */
    private class MobileDataStateReceiver extends BroadcastReceiver {
        private MobileDataStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = true;
            if (intent.getAction().equals(TelephonyIntents.ACTION_DATA_CONNECTION_CONNECTED_TO_PROVISIONING_APN)) {
                String stringExtra = intent.getStringExtra("apn");
                if (TextUtils.equals(MobileDataStateTracker.this.mApnType, intent.getStringExtra("apnType"))) {
                    MobileDataStateTracker.this.mMobileDataState = PhoneConstants.DataState.CONNECTING;
                    MobileDataStateTracker.this.updateLinkProperitesAndCapatilities(intent);
                    MobileDataStateTracker.this.mNetworkInfo.setIsConnectedToProvisioningNetwork(true);
                    MobileDataStateTracker.this.setDetailedState(NetworkInfo.DetailedState.SUSPENDED, "", stringExtra);
                }
            } else if (!intent.getAction().equals(TelephonyIntents.ACTION_ANY_DATA_CONNECTION_STATE_CHANGED)) {
                if (intent.getAction().equals(TelephonyIntents.ACTION_DATA_CONNECTION_FAILED) && TextUtils.equals(intent.getStringExtra("apnType"), MobileDataStateTracker.this.mApnType)) {
                    MobileDataStateTracker.this.mNetworkInfo.setIsConnectedToProvisioningNetwork(false);
                    MobileDataStateTracker.this.setDetailedState(NetworkInfo.DetailedState.FAILED, intent.getStringExtra("reason"), intent.getStringExtra("apn"));
                }
            } else if (TextUtils.equals(intent.getStringExtra("apnType"), MobileDataStateTracker.this.mApnType)) {
                MobileDataStateTracker.this.mNetworkInfo.setIsConnectedToProvisioningNetwork(false);
                int subtype = MobileDataStateTracker.this.mNetworkInfo.getSubtype();
                int networkType = TelephonyManager.getDefault().getNetworkType();
                MobileDataStateTracker.this.mNetworkInfo.setSubtype(networkType, TelephonyManager.getDefault().getNetworkTypeName());
                if (networkType != subtype && MobileDataStateTracker.this.mNetworkInfo.isConnected()) {
                    MobileDataStateTracker.this.mTarget.obtainMessage(NetworkStateTracker.EVENT_NETWORK_SUBTYPE_CHANGED, subtype, 0, MobileDataStateTracker.this.mNetworkInfo).sendToTarget();
                }
                PhoneConstants.DataState dataState = (PhoneConstants.DataState) Enum.valueOf(PhoneConstants.DataState.class, intent.getStringExtra("state"));
                String stringExtra2 = intent.getStringExtra("reason");
                String stringExtra3 = intent.getStringExtra("apn");
                MobileDataStateTracker.this.mNetworkInfo.setRoaming(intent.getBooleanExtra(PhoneConstants.DATA_NETWORK_ROAMING_KEY, false));
                NetworkInfo networkInfo = MobileDataStateTracker.this.mNetworkInfo;
                if (intent.getBooleanExtra(PhoneConstants.NETWORK_UNAVAILABLE_KEY, false)) {
                    z = false;
                }
                networkInfo.setIsAvailable(z);
                if (MobileDataStateTracker.this.mMobileDataState == dataState) {
                    if (TextUtils.equals(stringExtra2, PhoneConstants.REASON_LINK_PROPERTIES_CHANGED)) {
                        MobileDataStateTracker.this.mLinkProperties = (LinkProperties) intent.getParcelableExtra("linkProperties");
                        if (MobileDataStateTracker.this.mLinkProperties == null) {
                            MobileDataStateTracker.this.loge("No link property in LINK_PROPERTIES change event.");
                            MobileDataStateTracker.this.mLinkProperties = new LinkProperties();
                        }
                        MobileDataStateTracker.this.mNetworkInfo.setDetailedState(MobileDataStateTracker.this.mNetworkInfo.getDetailedState(), stringExtra2, MobileDataStateTracker.this.mNetworkInfo.getExtraInfo());
                        MobileDataStateTracker.this.mTarget.obtainMessage(NetworkStateTracker.EVENT_CONFIGURATION_CHANGED, MobileDataStateTracker.this.mNetworkInfo).sendToTarget();
                        return;
                    }
                    return;
                }
                MobileDataStateTracker.this.mMobileDataState = dataState;
                switch (AnonymousClass2.$SwitchMap$com$android$internal$telephony$PhoneConstants$DataState[dataState.ordinal()]) {
                    case 1:
                        if (MobileDataStateTracker.this.isTeardownRequested()) {
                            MobileDataStateTracker.this.setTeardownRequested(false);
                        }
                        MobileDataStateTracker.this.setDetailedState(NetworkInfo.DetailedState.DISCONNECTED, stringExtra2, stringExtra3);
                        break;
                    case 2:
                        MobileDataStateTracker.this.setDetailedState(NetworkInfo.DetailedState.CONNECTING, stringExtra2, stringExtra3);
                        break;
                    case 3:
                        MobileDataStateTracker.this.setDetailedState(NetworkInfo.DetailedState.SUSPENDED, stringExtra2, stringExtra3);
                        break;
                    case 4:
                        MobileDataStateTracker.this.updateLinkProperitesAndCapatilities(intent);
                        MobileDataStateTracker.this.setDetailedState(NetworkInfo.DetailedState.CONNECTED, stringExtra2, stringExtra3);
                        break;
                }
                MobileDataStateTracker.this.mSamplingDataTracker.resetSamplingData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/MobileDataStateTracker$NetworkDataEntry.class */
    public static class NetworkDataEntry {
        public int downloadBandwidth;
        public int latency;
        public int networkType;
        public int uploadBandwidth;

        NetworkDataEntry(int i, int i2, int i3, int i4) {
            this.networkType = i;
            this.downloadBandwidth = i2;
            this.uploadBandwidth = i3;
            this.latency = i4;
        }
    }

    public MobileDataStateTracker(int i, String str) {
        this.mNetworkInfo = new NetworkInfo(i, TelephonyManager.getDefault().getNetworkType(), str, TelephonyManager.getDefault().getNetworkTypeName());
        this.mApnType = networkTypeToApnType(i);
    }

    private static NetworkDataEntry getNetworkDataEntry(int i) {
        NetworkDataEntry[] networkDataEntryArr = mTheoreticalBWTable;
        int length = networkDataEntryArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                Slog.e(TAG, "Could not find Theoretical BW entry for " + String.valueOf(i));
                return null;
            }
            NetworkDataEntry networkDataEntry = networkDataEntryArr[i3];
            if (networkDataEntry.networkType == i) {
                return networkDataEntry;
            }
            i2 = i3 + 1;
        }
    }

    private static int getNormalizedSignalStrength(int i, SignalStrength signalStrength) {
        int lteLevel;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 8:
            case 9:
            case 10:
            case 15:
                lteLevel = signalStrength.getGsmLevel();
                break;
            case 4:
            case 7:
                lteLevel = signalStrength.getCdmaLevel();
                break;
            case 5:
            case 6:
            case 12:
                lteLevel = signalStrength.getEvdoLevel();
                break;
            case 11:
            case 14:
            default:
                return Integer.MAX_VALUE;
            case 13:
                lteLevel = signalStrength.getLteLevel();
                break;
        }
        return (lteLevel * 100) / 5;
    }

    private void getPhoneService(boolean z) {
        if (this.mPhoneService == null || z) {
            this.mPhoneService = ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
        }
    }

    private void log(String str) {
        Slog.d(TAG, this.mApnType + ": " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loge(String str) {
        Slog.e(TAG, this.mApnType + ": " + str);
    }

    public static String networkTypeToApnType(int i) {
        switch (i) {
            case 0:
                return "default";
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 13:
            default:
                sloge("Error mapping networkType " + i + " to apnType.");
                return null;
            case 2:
                return PhoneConstants.APN_TYPE_MMS;
            case 3:
                return PhoneConstants.APN_TYPE_SUPL;
            case 4:
                return PhoneConstants.APN_TYPE_DUN;
            case 5:
                return PhoneConstants.APN_TYPE_HIPRI;
            case 10:
                return PhoneConstants.APN_TYPE_FOTA;
            case 11:
                return PhoneConstants.APN_TYPE_IMS;
            case 12:
                return PhoneConstants.APN_TYPE_CBS;
            case 14:
                return PhoneConstants.APN_TYPE_IA;
            case 15:
                return PhoneConstants.APN_TYPE_EMERGENCY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetailedState(NetworkInfo.DetailedState detailedState, String str, String str2) {
        if (detailedState != this.mNetworkInfo.getDetailedState()) {
            boolean z = this.mNetworkInfo.getState() == NetworkInfo.State.CONNECTING;
            String reason = this.mNetworkInfo.getReason();
            String str3 = str;
            if (z) {
                str3 = str;
                if (detailedState == NetworkInfo.DetailedState.CONNECTED) {
                    str3 = str;
                    if (str == null) {
                        str3 = str;
                        if (reason != null) {
                            str3 = reason;
                        }
                    }
                }
            }
            this.mNetworkInfo.setDetailedState(detailedState, str3, str2);
            this.mTarget.obtainMessage(458752, new NetworkInfo(this.mNetworkInfo)).sendToTarget();
        }
    }

    private int setEnableApn(String str, boolean z) {
        getPhoneService(false);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                break;
            } else if (this.mPhoneService == null) {
                loge("Ignoring feature request because could not acquire PhoneService");
                break;
            } else {
                i = i2 + 1;
            }
        }
        loge("Could not " + (z ? "enable" : "disable") + " APN type \"" + str + "\"");
        return 3;
    }

    private static void sloge(String str) {
        Slog.e(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLinkProperitesAndCapatilities(Intent intent) {
        this.mLinkProperties = (LinkProperties) intent.getParcelableExtra("linkProperties");
        if (this.mLinkProperties == null) {
            loge("CONNECTED event did not supply link properties.");
            this.mLinkProperties = new LinkProperties();
        }
        this.mLinkProperties.setMtu(this.mContext.getResources().getInteger(R.integer.config_mobile_mtu));
        this.mNetworkCapabilities = (NetworkCapabilities) intent.getParcelableExtra("networkCapabilities");
        if (this.mNetworkCapabilities == null) {
            loge("CONNECTED event did not supply network capabilities.");
            this.mNetworkCapabilities = new NetworkCapabilities();
        }
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void captivePortalCheckCompleted(boolean z) {
        if (this.mIsCaptivePortal.getAndSet(z) != z) {
            setEnableFailFastMobileData(z ? 1 : 0);
        }
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void defaultRouteSet(boolean z) {
        this.mDefaultRouteSet = z;
    }

    public void enableMobileProvisioning(String str) {
        AsyncChannel asyncChannel = this.mDataConnectionTrackerAc;
        if (asyncChannel != null) {
            Message obtain = Message.obtain();
            obtain.what = DctConstants.CMD_ENABLE_MOBILE_PROVISIONING;
            obtain.setData(Bundle.forPair(DctConstants.PROVISIONING_URL_KEY, str));
            asyncChannel.sendMessage(obtain);
        }
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public LinkProperties getLinkProperties() {
        return new LinkProperties(this.mLinkProperties);
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public LinkQualityInfo getLinkQualityInfo() {
        MobileLinkQualityInfo mobileLinkQualityInfo;
        if (this.mNetworkInfo == null || this.mNetworkInfo.getType() == -1) {
            mobileLinkQualityInfo = null;
        } else {
            MobileLinkQualityInfo mobileLinkQualityInfo2 = new MobileLinkQualityInfo();
            mobileLinkQualityInfo2.setNetworkType(this.mNetworkInfo.getType());
            this.mSamplingDataTracker.setCommonLinkQualityInfoFields(mobileLinkQualityInfo2);
            if (this.mNetworkInfo.getSubtype() != 0) {
                mobileLinkQualityInfo2.setMobileNetworkType(this.mNetworkInfo.getSubtype());
                NetworkDataEntry networkDataEntry = getNetworkDataEntry(this.mNetworkInfo.getSubtype());
                if (networkDataEntry != null) {
                    mobileLinkQualityInfo2.setTheoreticalRxBandwidth(networkDataEntry.downloadBandwidth);
                    mobileLinkQualityInfo2.setTheoreticalRxBandwidth(networkDataEntry.uploadBandwidth);
                    mobileLinkQualityInfo2.setTheoreticalLatency(networkDataEntry.latency);
                }
                if (this.mSignalStrength != null) {
                    mobileLinkQualityInfo2.setNormalizedSignalStrength(getNormalizedSignalStrength(mobileLinkQualityInfo2.getMobileNetworkType(), this.mSignalStrength));
                }
            }
            SignalStrength signalStrength = this.mSignalStrength;
            mobileLinkQualityInfo = mobileLinkQualityInfo2;
            if (signalStrength != null) {
                mobileLinkQualityInfo2.setRssi(signalStrength.getGsmSignalStrength());
                mobileLinkQualityInfo2.setGsmErrorRate(signalStrength.getGsmBitErrorRate());
                mobileLinkQualityInfo2.setCdmaDbm(signalStrength.getCdmaDbm());
                mobileLinkQualityInfo2.setCdmaEcio(signalStrength.getCdmaEcio());
                mobileLinkQualityInfo2.setEvdoDbm(signalStrength.getEvdoDbm());
                mobileLinkQualityInfo2.setEvdoEcio(signalStrength.getEvdoEcio());
                mobileLinkQualityInfo2.setEvdoSnr(signalStrength.getEvdoSnr());
                mobileLinkQualityInfo2.setLteSignalStrength(signalStrength.getLteSignalStrength());
                mobileLinkQualityInfo2.setLteRsrp(signalStrength.getLteRsrp());
                mobileLinkQualityInfo2.setLteRsrq(signalStrength.getLteRsrq());
                mobileLinkQualityInfo2.setLteRssnr(signalStrength.getLteRssnr());
                mobileLinkQualityInfo2.setLteCqi(signalStrength.getLteCqi());
                return mobileLinkQualityInfo2;
            }
        }
        return mobileLinkQualityInfo;
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public NetworkInfo getNetworkInfo() {
        return this.mNetworkInfo;
    }

    @Override // android.net.NetworkStateTracker
    public String getTcpBufferSizesPropName() {
        String str = "unknown";
        TelephonyManager telephonyManager = new TelephonyManager(this.mContext);
        switch (telephonyManager.getNetworkType()) {
            case 1:
                str = "gprs";
                break;
            case 2:
                str = "edge";
                break;
            case 3:
                str = "umts";
                break;
            case 4:
                str = "cdma";
                break;
            case 5:
                str = "evdo";
                break;
            case 6:
                str = "evdo";
                break;
            case 7:
                str = "1xrtt";
                break;
            case 8:
                str = "hsdpa";
                break;
            case 9:
                str = "hsupa";
                break;
            case 10:
                str = "hspa";
                break;
            case 11:
                str = "iden";
                break;
            case 12:
                str = "evdo";
                break;
            case 13:
            case 18:
                str = QSConstants.TILE_LTE;
                break;
            case 14:
                str = "ehrpd";
                break;
            case 15:
                str = "hspap";
                break;
            case 16:
            case 17:
            default:
                loge("unknown network type: " + telephonyManager.getNetworkType());
                break;
        }
        return "net.tcp.buffersize." + str;
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public boolean isAvailable() {
        return this.mNetworkInfo.isAvailable();
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public boolean isDefaultRouteSet() {
        return this.mDefaultRouteSet;
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public boolean isPrivateDnsRouteSet() {
        return this.mPrivateDnsRouteSet;
    }

    public boolean isProvisioningNetwork() {
        try {
            Message obtain = Message.obtain();
            obtain.what = DctConstants.CMD_IS_PROVISIONING_APN;
            obtain.setData(Bundle.forPair("apnType", this.mApnType));
            return this.mDataConnectionTrackerAc.sendMessageSynchronously(obtain).arg1 == 1;
        } catch (NullPointerException e) {
            loge("isProvisioningNetwork: X " + e);
            return false;
        }
    }

    public boolean isReady() {
        return this.mDataConnectionTrackerAc != null;
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public boolean isTeardownRequested() {
        return this.mTeardownRequested;
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void privateDnsRouteSet(boolean z) {
        this.mPrivateDnsRouteSet = z;
    }

    @Override // android.net.NetworkStateTracker
    public boolean reconnect() {
        setTeardownRequested(false);
        switch (setEnableApn(this.mApnType, true)) {
            case 0:
                return true;
            case 1:
                this.mNetworkInfo.setDetailedState(NetworkInfo.DetailedState.IDLE, null, null);
                return true;
            case 2:
            case 3:
                return false;
            default:
                loge("Error in reconnect - unexpected response.");
                return false;
        }
    }

    public void releaseWakeLock() {
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void setDependencyMet(boolean z) {
        Bundle forPair = Bundle.forPair("apnType", this.mApnType);
        try {
            Message obtain = Message.obtain();
            obtain.what = DctConstants.CMD_SET_DEPENDENCY_MET;
            obtain.arg1 = z ? 1 : 0;
            obtain.setData(forPair);
            this.mDataConnectionTrackerAc.sendMessage(obtain);
        } catch (NullPointerException e) {
            loge("setDependencyMet: X mAc was null" + e);
        }
    }

    public void setEnableFailFastMobileData(int i) {
        AsyncChannel asyncChannel = this.mDataConnectionTrackerAc;
        if (asyncChannel != null) {
            asyncChannel.sendMessage(DctConstants.CMD_SET_ENABLE_FAIL_FAST_MOBILE_DATA, i);
        }
    }

    public void setInternalDataEnable(boolean z) {
        AsyncChannel asyncChannel = this.mDataConnectionTrackerAc;
        if (asyncChannel != null) {
            asyncChannel.sendMessage(DctConstants.EVENT_SET_INTERNAL_DATA_ENABLE, z ? 1 : 0);
        }
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void setPolicyDataEnable(boolean z) {
        AsyncChannel asyncChannel = this.mDataConnectionTrackerAc;
        if (asyncChannel != null) {
            asyncChannel.sendMessage(DctConstants.CMD_SET_POLICY_DATA_ENABLE, z ? 1 : 0);
            this.mPolicyDataEnabled = z;
        }
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public boolean setRadio(boolean z) {
        getPhoneService(false);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                break;
            } else if (this.mPhoneService == null) {
                loge("Ignoring mobile radio request because could not acquire PhoneService");
                break;
            } else {
                try {
                    return this.mPhoneService.setRadio(z);
                } catch (RemoteException e) {
                    if (i2 == 0) {
                        getPhoneService(true);
                    }
                    i = i2 + 1;
                }
            }
        }
        loge("Could not set radio power to " + (z ? "on" : "off"));
        return false;
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void setTeardownRequested(boolean z) {
        this.mTeardownRequested = z;
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void setUserDataEnable(boolean z) {
        AsyncChannel asyncChannel = this.mDataConnectionTrackerAc;
        if (asyncChannel != null) {
            asyncChannel.sendMessage(DctConstants.CMD_SET_USER_DATA_ENABLE, z ? 1 : 0);
            this.mUserDataEnabled = z;
        }
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void startMonitoring(Context context, Handler handler) {
        this.mTarget = handler;
        this.mContext = context;
        this.mHandler = new MdstHandler(handler.getLooper(), this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TelephonyIntents.ACTION_ANY_DATA_CONNECTION_STATE_CHANGED);
        intentFilter.addAction(TelephonyIntents.ACTION_DATA_CONNECTION_CONNECTED_TO_PROVISIONING_APN);
        intentFilter.addAction(TelephonyIntents.ACTION_DATA_CONNECTION_FAILED);
        this.mContext.registerReceiver(new MobileDataStateReceiver(), intentFilter);
        this.mMobileDataState = PhoneConstants.DataState.DISCONNECTED;
        ((TelephonyManager) this.mContext.getSystemService("phone")).listen(this.mPhoneStateListener, 256);
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void startSampling(SamplingDataTracker.SamplingSnapshot samplingSnapshot) {
        this.mSamplingDataTracker.startSampling(samplingSnapshot);
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void stopSampling(SamplingDataTracker.SamplingSnapshot samplingSnapshot) {
        this.mSamplingDataTracker.stopSampling(samplingSnapshot);
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void supplyMessenger(Messenger messenger) {
        new AsyncChannel().connect(this.mContext, this.mHandler, messenger);
    }

    @Override // android.net.NetworkStateTracker
    public boolean teardown() {
        setTeardownRequested(true);
        return setEnableApn(this.mApnType, false) != 3;
    }

    public String toString() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        PrintWriter printWriter = new PrintWriter(charArrayWriter);
        printWriter.print("Mobile data state: ");
        printWriter.println(this.mMobileDataState);
        printWriter.print("Data enabled: user=");
        printWriter.print(this.mUserDataEnabled);
        printWriter.print(", policy=");
        printWriter.println(this.mPolicyDataEnabled);
        return charArrayWriter.toString();
    }
}
