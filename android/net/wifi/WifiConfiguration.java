package android.net.wifi;

import android.net.IpConfiguration;
import android.net.ProxyInfo;
import android.net.StaticIpConfiguration;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.anythink.expressad.foundation.d.c;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiConfiguration.class */
public class WifiConfiguration implements Parcelable {
    public static final int AUTO_JOIN_DELETED = 200;
    public static final int AUTO_JOIN_DISABLED_NO_CREDENTIALS = 160;
    public static final int AUTO_JOIN_DISABLED_ON_AUTH_FAILURE = 128;
    public static final int AUTO_JOIN_DISABLED_USER_ACTION = 161;
    public static final int AUTO_JOIN_ENABLED = 0;
    public static final int AUTO_JOIN_TEMPORARY_DISABLED = 1;
    public static final int AUTO_JOIN_TEMPORARY_DISABLED_AT_SUPPLICANT = 64;
    public static final int AUTO_JOIN_TEMPORARY_DISABLED_LINK_ERRORS = 32;
    public static final int DISABLED_ASSOCIATION_REJECT = 4;
    public static final int DISABLED_AUTH_FAILURE = 3;
    public static final int DISABLED_BY_WIFI_MANAGER = 5;
    public static final int DISABLED_DHCP_FAILURE = 2;
    public static final int DISABLED_DNS_FAILURE = 1;
    public static final int DISABLED_UNKNOWN_REASON = 0;
    public static final int INVALID_NETWORK_ID = -1;
    public static final String SIMNumVarName = "sim_num";
    private static final String TAG = "WifiConfiguration";
    public static final String bssidVarName = "bssid";
    public static final String frequencyVarName = "frequency";
    public static final String hiddenSSIDVarName = "scan_ssid";
    public static final String modeVarName = "mode";
    public static final String pmfVarName = "ieee80211w";
    public static final String priorityVarName = "priority";
    public static final String pskVarName = "psk";
    public static final String ssidVarName = "ssid";
    public static final String updateIdentiferVarName = "update_identifier";
    public static final String wepTxKeyIdxVarName = "wep_tx_keyidx";
    public String BSSID;
    public String FQDN;
    public int SIMNum;
    public String SSID;
    public BitSet allowedAuthAlgorithms;
    public BitSet allowedGroupCiphers;
    public BitSet allowedKeyManagement;
    public BitSet allowedPairwiseCiphers;
    public BitSet allowedProtocols;
    public String autoJoinBSSID;
    public boolean autoJoinBailedDueToLowRssi;
    public int autoJoinStatus;
    public int autoJoinUseAggressiveJoinAttemptThreshold;
    public long blackListTimestamp;
    public HashMap<String, Integer> connectChoices;
    public int creatorUid;
    public String defaultGwMacAddress;
    public String dhcpServer;
    public boolean didSelfAdd;
    public boolean dirty;
    public int disableReason;
    public boolean duplicateNetwork;
    public WifiEnterpriseConfig enterpriseConfig;
    public boolean ephemeral;
    public int frequency;
    public boolean hiddenSSID;
    public boolean isIBSS;
    public int lastConnectUid;
    public long lastConnected;
    public long lastConnectionFailure;
    public long lastDisconnected;
    public String lastFailure;
    public long lastRoamingFailure;
    public int lastRoamingFailureReason;
    public int lastUpdateUid;
    public HashMap<String, Integer> linkedConfigurations;
    String mCachedConfigKey;
    private IpConfiguration mIpConfiguration;
    public String naiRealm;
    public int networkId;
    public int numAssociation;
    public int numAuthFailures;
    public int numConnectionFailures;
    public int numIpConfigFailures;
    public int numNoInternetAccessReports;
    public int numScorerOverride;
    public int numScorerOverrideAndSwitchedNetwork;
    public int numTicksAtBadRSSI;
    public int numTicksAtLowRSSI;
    public int numTicksAtNotHighRSSI;
    public int numUserTriggeredJoinAttempts;
    public int numUserTriggeredWifiDisableBadRSSI;
    public int numUserTriggeredWifiDisableLowRSSI;
    public int numUserTriggeredWifiDisableNotHighRSSI;
    public String peerWifiConfiguration;
    public String preSharedKey;
    public int priority;
    public boolean requirePMF;
    public long roamingFailureBlackListTimeMilli;
    public HashMap<String, ScanResult> scanResultCache;
    public boolean selfAdded;
    public int status;
    public String updateIdentifier;
    public boolean validatedInternetAccess;
    public Visibility visibility;
    public String[] wepKeys;
    public int wepTxKeyIndex;
    public static final String[] wepKeyVarNames = {"wep_key0", "wep_key1", "wep_key2", "wep_key3"};
    public static int INVALID_RSSI = WifiInfo.INVALID_RSSI;
    public static int UNWANTED_BLACKLIST_SOFT_RSSI_24 = -80;
    public static int UNWANTED_BLACKLIST_SOFT_RSSI_5 = -70;
    public static int GOOD_RSSI_24 = -65;
    public static int LOW_RSSI_24 = -77;
    public static int BAD_RSSI_24 = -87;
    public static int GOOD_RSSI_5 = -60;
    public static int LOW_RSSI_5 = -72;
    public static int BAD_RSSI_5 = -82;
    public static int UNWANTED_BLACKLIST_SOFT_BUMP = 4;
    public static int UNWANTED_BLACKLIST_HARD_BUMP = 8;
    public static int UNBLACKLIST_THRESHOLD_24_SOFT = -77;
    public static int UNBLACKLIST_THRESHOLD_24_HARD = -68;
    public static int UNBLACKLIST_THRESHOLD_5_SOFT = -63;
    public static int UNBLACKLIST_THRESHOLD_5_HARD = -56;
    public static int INITIAL_AUTO_JOIN_ATTEMPT_MIN_24 = -80;
    public static int INITIAL_AUTO_JOIN_ATTEMPT_MIN_5 = -70;
    public static int A_BAND_PREFERENCE_RSSI_THRESHOLD = -65;
    public static int G_BAND_PREFERENCE_RSSI_THRESHOLD = -75;
    public static int HOME_NETWORK_RSSI_BOOST = 5;
    public static int MAX_INITIAL_AUTO_JOIN_RSSI_BOOST = 8;
    public static int ROAMING_FAILURE_IP_CONFIG = 1;
    public static int ROAMING_FAILURE_AUTH_FAILURE = 2;
    public static final Parcelable.Creator<WifiConfiguration> CREATOR = new Parcelable.Creator<WifiConfiguration>() { // from class: android.net.wifi.WifiConfiguration.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiConfiguration createFromParcel(Parcel parcel) {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.networkId = parcel.readInt();
            wifiConfiguration.status = parcel.readInt();
            wifiConfiguration.disableReason = parcel.readInt();
            wifiConfiguration.SSID = parcel.readString();
            wifiConfiguration.BSSID = parcel.readString();
            wifiConfiguration.autoJoinBSSID = parcel.readString();
            wifiConfiguration.FQDN = parcel.readString();
            wifiConfiguration.naiRealm = parcel.readString();
            wifiConfiguration.preSharedKey = parcel.readString();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= wifiConfiguration.wepKeys.length) {
                    break;
                }
                wifiConfiguration.wepKeys[i2] = parcel.readString();
                i = i2 + 1;
            }
            wifiConfiguration.wepTxKeyIndex = parcel.readInt();
            wifiConfiguration.priority = parcel.readInt();
            wifiConfiguration.hiddenSSID = parcel.readInt() != 0;
            wifiConfiguration.isIBSS = parcel.readInt() != 0;
            wifiConfiguration.frequency = parcel.readInt();
            wifiConfiguration.requirePMF = parcel.readInt() != 0;
            wifiConfiguration.updateIdentifier = parcel.readString();
            wifiConfiguration.allowedKeyManagement = WifiConfiguration.readBitSet(parcel);
            wifiConfiguration.allowedProtocols = WifiConfiguration.readBitSet(parcel);
            wifiConfiguration.allowedAuthAlgorithms = WifiConfiguration.readBitSet(parcel);
            wifiConfiguration.allowedPairwiseCiphers = WifiConfiguration.readBitSet(parcel);
            wifiConfiguration.allowedGroupCiphers = WifiConfiguration.readBitSet(parcel);
            wifiConfiguration.enterpriseConfig = (WifiEnterpriseConfig) parcel.readParcelable(null);
            wifiConfiguration.mIpConfiguration = (IpConfiguration) parcel.readParcelable(null);
            wifiConfiguration.dhcpServer = parcel.readString();
            wifiConfiguration.defaultGwMacAddress = parcel.readString();
            wifiConfiguration.autoJoinStatus = parcel.readInt();
            wifiConfiguration.selfAdded = parcel.readInt() != 0;
            wifiConfiguration.didSelfAdd = parcel.readInt() != 0;
            wifiConfiguration.validatedInternetAccess = parcel.readInt() != 0;
            wifiConfiguration.ephemeral = parcel.readInt() != 0;
            wifiConfiguration.creatorUid = parcel.readInt();
            wifiConfiguration.lastConnectUid = parcel.readInt();
            wifiConfiguration.lastUpdateUid = parcel.readInt();
            wifiConfiguration.blackListTimestamp = parcel.readLong();
            wifiConfiguration.lastConnectionFailure = parcel.readLong();
            wifiConfiguration.lastRoamingFailure = parcel.readLong();
            wifiConfiguration.lastRoamingFailureReason = parcel.readInt();
            wifiConfiguration.roamingFailureBlackListTimeMilli = parcel.readLong();
            wifiConfiguration.numConnectionFailures = parcel.readInt();
            wifiConfiguration.numIpConfigFailures = parcel.readInt();
            wifiConfiguration.numAuthFailures = parcel.readInt();
            wifiConfiguration.numScorerOverride = parcel.readInt();
            wifiConfiguration.numScorerOverrideAndSwitchedNetwork = parcel.readInt();
            wifiConfiguration.numAssociation = parcel.readInt();
            wifiConfiguration.numUserTriggeredWifiDisableLowRSSI = parcel.readInt();
            wifiConfiguration.numUserTriggeredWifiDisableBadRSSI = parcel.readInt();
            wifiConfiguration.numUserTriggeredWifiDisableNotHighRSSI = parcel.readInt();
            wifiConfiguration.numTicksAtLowRSSI = parcel.readInt();
            wifiConfiguration.numTicksAtBadRSSI = parcel.readInt();
            wifiConfiguration.numTicksAtNotHighRSSI = parcel.readInt();
            wifiConfiguration.numUserTriggeredJoinAttempts = parcel.readInt();
            wifiConfiguration.autoJoinUseAggressiveJoinAttemptThreshold = parcel.readInt();
            wifiConfiguration.autoJoinBailedDueToLowRssi = parcel.readInt() != 0;
            wifiConfiguration.SIMNum = parcel.readInt();
            wifiConfiguration.numNoInternetAccessReports = parcel.readInt();
            return wifiConfiguration;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiConfiguration[] newArray(int i) {
            return new WifiConfiguration[i];
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiConfiguration$AuthAlgorithm.class */
    public static class AuthAlgorithm {
        public static final int LEAP = 2;
        public static final int OPEN = 0;
        public static final int SHARED = 1;
        public static final String[] strings = {"OPEN", "SHARED", "LEAP"};
        public static final String varName = "auth_alg";

        private AuthAlgorithm() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiConfiguration$GroupCipher.class */
    public static class GroupCipher {
        public static final int CCMP = 3;
        public static final int TKIP = 2;
        public static final int WEP104 = 1;
        public static final int WEP40 = 0;
        public static final String[] strings = {"WEP40", "WEP104", "TKIP", "CCMP"};
        public static final String varName = "group";

        private GroupCipher() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiConfiguration$KeyMgmt.class */
    public static class KeyMgmt {
        public static final int IEEE8021X = 3;
        public static final int NONE = 0;
        public static final int WPA2_PSK = 4;
        public static final int WPA_EAP = 2;
        public static final int WPA_PSK = 1;
        public static final String[] strings = {"NONE", "WPA_PSK", "WPA_EAP", "IEEE8021X", "WPA2_PSK"};
        public static final String varName = "key_mgmt";

        private KeyMgmt() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiConfiguration$PairwiseCipher.class */
    public static class PairwiseCipher {
        public static final int CCMP = 2;
        public static final int NONE = 0;
        public static final int TKIP = 1;
        public static final String[] strings = {"NONE", "TKIP", "CCMP"};
        public static final String varName = "pairwise";

        private PairwiseCipher() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiConfiguration$Protocol.class */
    public static class Protocol {
        public static final int RSN = 1;
        public static final int WPA = 0;
        public static final String[] strings = {"WPA", "RSN"};
        public static final String varName = "proto";

        private Protocol() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiConfiguration$Status.class */
    public static class Status {
        public static final int CURRENT = 0;
        public static final int DISABLED = 1;
        public static final int ENABLED = 2;
        public static final String[] strings = {"current", "disabled", "enabled"};

        private Status() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiConfiguration$Visibility.class */
    public final class Visibility {
        public String BSSID24;
        public String BSSID5;
        public long age24;
        public long age5;
        public int bandPreferenceBoost;
        public int currentNetworkBoost;
        public int lastChoiceBoost;
        public String lastChoiceConfig;
        public int num24;
        public int num5;
        public int rssi24;
        public int rssi5;
        public int score;

        public Visibility() {
            this.rssi5 = WifiConfiguration.INVALID_RSSI;
            this.rssi24 = WifiConfiguration.INVALID_RSSI;
        }

        public Visibility(Visibility visibility) {
            this.rssi5 = visibility.rssi5;
            this.rssi24 = visibility.rssi24;
            this.age24 = visibility.age24;
            this.age5 = visibility.age5;
            this.num24 = visibility.num24;
            this.num5 = visibility.num5;
            this.BSSID5 = visibility.BSSID5;
            this.BSSID24 = visibility.BSSID24;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (this.rssi24 > WifiConfiguration.INVALID_RSSI) {
                sb.append(Integer.toString(this.rssi24));
                sb.append(",");
                sb.append(Integer.toString(this.num24));
                if (this.BSSID24 != null) {
                    sb.append(",").append(this.BSSID24);
                }
            }
            sb.append("; ");
            if (this.rssi5 > WifiConfiguration.INVALID_RSSI) {
                sb.append(Integer.toString(this.rssi5));
                sb.append(",");
                sb.append(Integer.toString(this.num5));
                if (this.BSSID5 != null) {
                    sb.append(",").append(this.BSSID5);
                }
            }
            if (this.score != 0) {
                sb.append("; ").append(this.score);
                sb.append(", ").append(this.currentNetworkBoost);
                sb.append(", ").append(this.bandPreferenceBoost);
                if (this.lastChoiceConfig != null) {
                    sb.append(", ").append(this.lastChoiceBoost);
                    sb.append(", ").append(this.lastChoiceConfig);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public WifiConfiguration() {
        this.roamingFailureBlackListTimeMilli = 1000L;
        this.networkId = -1;
        this.SSID = null;
        this.BSSID = null;
        this.FQDN = null;
        this.naiRealm = null;
        this.priority = 0;
        this.hiddenSSID = false;
        this.isIBSS = false;
        this.frequency = 0;
        this.disableReason = 0;
        this.allowedKeyManagement = new BitSet();
        this.allowedProtocols = new BitSet();
        this.allowedAuthAlgorithms = new BitSet();
        this.allowedPairwiseCiphers = new BitSet();
        this.allowedGroupCiphers = new BitSet();
        this.wepKeys = new String[4];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.wepKeys.length) {
                this.enterpriseConfig = new WifiEnterpriseConfig();
                this.autoJoinStatus = 0;
                this.selfAdded = false;
                this.didSelfAdd = false;
                this.ephemeral = false;
                this.validatedInternetAccess = false;
                this.mIpConfiguration = new IpConfiguration();
                this.duplicateNetwork = false;
                this.SIMNum = 0;
                return;
            }
            this.wepKeys[i2] = null;
            i = i2 + 1;
        }
    }

    public WifiConfiguration(WifiConfiguration wifiConfiguration) {
        this.roamingFailureBlackListTimeMilli = 1000L;
        if (wifiConfiguration != null) {
            this.networkId = wifiConfiguration.networkId;
            this.status = wifiConfiguration.status;
            this.disableReason = wifiConfiguration.disableReason;
            this.disableReason = wifiConfiguration.disableReason;
            this.SSID = wifiConfiguration.SSID;
            this.BSSID = wifiConfiguration.BSSID;
            this.FQDN = wifiConfiguration.FQDN;
            this.naiRealm = wifiConfiguration.naiRealm;
            this.preSharedKey = wifiConfiguration.preSharedKey;
            this.wepKeys = new String[4];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.wepKeys.length) {
                    break;
                }
                this.wepKeys[i2] = wifiConfiguration.wepKeys[i2];
                i = i2 + 1;
            }
            this.wepTxKeyIndex = wifiConfiguration.wepTxKeyIndex;
            this.priority = wifiConfiguration.priority;
            this.hiddenSSID = wifiConfiguration.hiddenSSID;
            this.isIBSS = wifiConfiguration.isIBSS;
            this.frequency = wifiConfiguration.frequency;
            this.allowedKeyManagement = (BitSet) wifiConfiguration.allowedKeyManagement.clone();
            this.allowedProtocols = (BitSet) wifiConfiguration.allowedProtocols.clone();
            this.allowedAuthAlgorithms = (BitSet) wifiConfiguration.allowedAuthAlgorithms.clone();
            this.allowedPairwiseCiphers = (BitSet) wifiConfiguration.allowedPairwiseCiphers.clone();
            this.allowedGroupCiphers = (BitSet) wifiConfiguration.allowedGroupCiphers.clone();
            this.enterpriseConfig = new WifiEnterpriseConfig(wifiConfiguration.enterpriseConfig);
            this.defaultGwMacAddress = wifiConfiguration.defaultGwMacAddress;
            this.mIpConfiguration = new IpConfiguration(wifiConfiguration.mIpConfiguration);
            if (wifiConfiguration.scanResultCache != null && wifiConfiguration.scanResultCache.size() > 0) {
                this.scanResultCache = new HashMap<>();
                this.scanResultCache.putAll(wifiConfiguration.scanResultCache);
            }
            if (wifiConfiguration.connectChoices != null && wifiConfiguration.connectChoices.size() > 0) {
                this.connectChoices = new HashMap<>();
                this.connectChoices.putAll(wifiConfiguration.connectChoices);
            }
            if (wifiConfiguration.linkedConfigurations != null && wifiConfiguration.linkedConfigurations.size() > 0) {
                this.linkedConfigurations = new HashMap<>();
                this.linkedConfigurations.putAll(wifiConfiguration.linkedConfigurations);
            }
            this.mCachedConfigKey = null;
            this.autoJoinStatus = wifiConfiguration.autoJoinStatus;
            this.selfAdded = wifiConfiguration.selfAdded;
            this.validatedInternetAccess = wifiConfiguration.validatedInternetAccess;
            this.ephemeral = wifiConfiguration.ephemeral;
            if (wifiConfiguration.visibility != null) {
                this.visibility = new Visibility(wifiConfiguration.visibility);
            }
            this.lastFailure = wifiConfiguration.lastFailure;
            this.didSelfAdd = wifiConfiguration.didSelfAdd;
            this.lastConnectUid = wifiConfiguration.lastConnectUid;
            this.lastUpdateUid = wifiConfiguration.lastUpdateUid;
            this.creatorUid = wifiConfiguration.creatorUid;
            this.peerWifiConfiguration = wifiConfiguration.peerWifiConfiguration;
            this.blackListTimestamp = wifiConfiguration.blackListTimestamp;
            this.lastConnected = wifiConfiguration.lastConnected;
            this.lastDisconnected = wifiConfiguration.lastDisconnected;
            this.lastConnectionFailure = wifiConfiguration.lastConnectionFailure;
            this.lastRoamingFailure = wifiConfiguration.lastRoamingFailure;
            this.lastRoamingFailureReason = wifiConfiguration.lastRoamingFailureReason;
            this.roamingFailureBlackListTimeMilli = wifiConfiguration.roamingFailureBlackListTimeMilli;
            this.numConnectionFailures = wifiConfiguration.numConnectionFailures;
            this.numIpConfigFailures = wifiConfiguration.numIpConfigFailures;
            this.numAuthFailures = wifiConfiguration.numAuthFailures;
            this.numScorerOverride = wifiConfiguration.numScorerOverride;
            this.numScorerOverrideAndSwitchedNetwork = wifiConfiguration.numScorerOverrideAndSwitchedNetwork;
            this.numAssociation = wifiConfiguration.numAssociation;
            this.numUserTriggeredWifiDisableLowRSSI = wifiConfiguration.numUserTriggeredWifiDisableLowRSSI;
            this.numUserTriggeredWifiDisableBadRSSI = wifiConfiguration.numUserTriggeredWifiDisableBadRSSI;
            this.numUserTriggeredWifiDisableNotHighRSSI = wifiConfiguration.numUserTriggeredWifiDisableNotHighRSSI;
            this.numTicksAtLowRSSI = wifiConfiguration.numTicksAtLowRSSI;
            this.numTicksAtBadRSSI = wifiConfiguration.numTicksAtBadRSSI;
            this.numTicksAtNotHighRSSI = wifiConfiguration.numTicksAtNotHighRSSI;
            this.numUserTriggeredJoinAttempts = wifiConfiguration.numUserTriggeredJoinAttempts;
            this.autoJoinBSSID = wifiConfiguration.autoJoinBSSID;
            this.autoJoinUseAggressiveJoinAttemptThreshold = wifiConfiguration.autoJoinUseAggressiveJoinAttemptThreshold;
            this.autoJoinBailedDueToLowRssi = wifiConfiguration.autoJoinBailedDueToLowRssi;
            this.dirty = wifiConfiguration.dirty;
            this.duplicateNetwork = wifiConfiguration.duplicateNetwork;
            this.SIMNum = wifiConfiguration.SIMNum;
            this.numNoInternetAccessReports = wifiConfiguration.numNoInternetAccessReports;
        }
    }

    public static String configKey(ScanResult scanResult) {
        String str = "\"" + scanResult.SSID + "\"";
        return scanResult.capabilities.contains("WEP") ? str + "-WEP" : scanResult.capabilities.contains("PSK") ? str + "-" + KeyMgmt.strings[1] : (scanResult.capabilities.contains("EAP") || scanResult.capabilities.contains("IEEE8021X")) ? str + "-" + KeyMgmt.strings[2] : str + "-" + KeyMgmt.strings[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BitSet readBitSet(Parcel parcel) {
        int readInt = parcel.readInt();
        BitSet bitSet = new BitSet();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return bitSet;
            }
            bitSet.set(parcel.readInt());
            i = i2 + 1;
        }
    }

    private ArrayList<ScanResult> sortScanResults() {
        ArrayList<ScanResult> arrayList = new ArrayList<>(this.scanResultCache.values());
        if (arrayList.size() != 0) {
            Collections.sort(arrayList, new Comparator() { // from class: android.net.wifi.WifiConfiguration.2
                @Override // java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    ScanResult scanResult = (ScanResult) obj;
                    ScanResult scanResult2 = (ScanResult) obj2;
                    if (scanResult.numIpConfigFailures > scanResult2.numIpConfigFailures) {
                        return 1;
                    }
                    if (scanResult.numIpConfigFailures >= scanResult2.numIpConfigFailures && scanResult.seen <= scanResult2.seen) {
                        if (scanResult.seen >= scanResult2.seen) {
                            if (scanResult.level > scanResult2.level) {
                                return -1;
                            }
                            if (scanResult.level >= scanResult2.level) {
                                return scanResult.BSSID.compareTo(scanResult2.BSSID);
                            }
                            return 1;
                        }
                        return 1;
                    }
                    return -1;
                }
            });
        }
        return arrayList;
    }

    private String trimStringForKeyId(String str) {
        return str.replace("\"", "").replace(" ", "");
    }

    private static void writeBitSet(Parcel parcel, BitSet bitSet) {
        int i = -1;
        parcel.writeInt(bitSet.cardinality());
        while (true) {
            i = bitSet.nextSetBit(i + 1);
            if (i == -1) {
                return;
            }
            parcel.writeInt(i);
        }
    }

    public String configKey() {
        return configKey(false);
    }

    public String configKey(boolean z) {
        if (!z || this.mCachedConfigKey == null) {
            String str = this.allowedKeyManagement.get(1) ? this.SSID + "-" + KeyMgmt.strings[1] : (this.allowedKeyManagement.get(2) || this.allowedKeyManagement.get(3)) ? this.SSID + "-" + KeyMgmt.strings[2] : this.wepKeys[0] != null ? this.SSID + "-WEP" : this.SSID + "-" + KeyMgmt.strings[0];
            this.mCachedConfigKey = str;
            return str;
        }
        return this.mCachedConfigKey;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAuthType() {
        if (isValid()) {
            if (this.allowedKeyManagement.get(1)) {
                return 1;
            }
            if (this.allowedKeyManagement.get(4)) {
                return 4;
            }
            if (this.allowedKeyManagement.get(2)) {
                return 2;
            }
            return this.allowedKeyManagement.get(3) ? 3 : 0;
        }
        throw new IllegalStateException("Invalid configuration");
    }

    public ProxyInfo getHttpProxy() {
        return this.mIpConfiguration.httpProxy;
    }

    public IpConfiguration.IpAssignment getIpAssignment() {
        return this.mIpConfiguration.ipAssignment;
    }

    public IpConfiguration getIpConfiguration() {
        return this.mIpConfiguration;
    }

    public String getKeyIdForCredentials(WifiConfiguration wifiConfiguration) {
        String str = null;
        try {
            if (TextUtils.isEmpty(this.SSID)) {
                this.SSID = wifiConfiguration.SSID;
            }
            if (this.allowedKeyManagement.cardinality() == 0) {
                this.allowedKeyManagement = wifiConfiguration.allowedKeyManagement;
            }
            if (this.allowedKeyManagement.get(2)) {
                str = KeyMgmt.strings[2];
            }
            String str2 = str;
            if (this.allowedKeyManagement.get(3)) {
                str2 = str + KeyMgmt.strings[3];
            }
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalStateException("Not an EAP network");
            }
            return trimStringForKeyId(this.SSID) + BridgeUtil.UNDERLINE_STR + str2 + BridgeUtil.UNDERLINE_STR + trimStringForKeyId(this.enterpriseConfig.getKeyId(wifiConfiguration != null ? wifiConfiguration.enterpriseConfig : null));
        } catch (NullPointerException e) {
            throw new IllegalStateException("Invalid config details");
        }
    }

    public String getPrintableSsid() {
        if (this.SSID == null) {
            return "";
        }
        int length = this.SSID.length();
        return (length > 2 && this.SSID.charAt(0) == '\"' && this.SSID.charAt(length - 1) == '\"') ? this.SSID.substring(1, length - 1) : (length > 3 && this.SSID.charAt(0) == 'P' && this.SSID.charAt(1) == '\"' && this.SSID.charAt(length - 1) == '\"') ? WifiSsid.createFromAsciiEncoded(this.SSID.substring(2, length - 1)).toString() : this.SSID;
    }

    public IpConfiguration.ProxySettings getProxySettings() {
        return this.mIpConfiguration.proxySettings;
    }

    public StaticIpConfiguration getStaticIpConfiguration() {
        return this.mIpConfiguration.getStaticIpConfiguration();
    }

    public boolean hasNoInternetAccess() {
        return this.numNoInternetAccessReports > 0 && !this.validatedInternetAccess;
    }

    public boolean isLinked(WifiConfiguration wifiConfiguration) {
        return (wifiConfiguration.linkedConfigurations == null || this.linkedConfigurations == null || wifiConfiguration.linkedConfigurations.get(configKey()) == null || this.linkedConfigurations.get(wifiConfiguration.configKey()) == null) ? false : true;
    }

    public boolean isValid() {
        if (this.allowedKeyManagement == null) {
            return false;
        }
        if (this.allowedKeyManagement.cardinality() > 1) {
            if (this.allowedKeyManagement.cardinality() == 2 && this.allowedKeyManagement.get(2)) {
                return this.allowedKeyManagement.get(3) || this.allowedKeyManagement.get(1);
            }
            return false;
        }
        return true;
    }

    public ScanResult lastSeen() {
        ScanResult scanResult = null;
        if (this.scanResultCache == null) {
            return null;
        }
        for (ScanResult scanResult2 : this.scanResultCache.values()) {
            if (scanResult == null) {
                if (scanResult2.seen != 0) {
                    scanResult = scanResult2;
                }
            } else if (scanResult2.seen > scanResult.seen) {
                scanResult = scanResult2;
            }
        }
        return scanResult;
    }

    public void setAutoJoinStatus(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            this.blackListTimestamp = 0L;
        } else if (i2 > this.autoJoinStatus) {
            this.blackListTimestamp = System.currentTimeMillis();
        }
        if (i2 != this.autoJoinStatus) {
            this.autoJoinStatus = i2;
            this.dirty = true;
        }
    }

    public void setHttpProxy(ProxyInfo proxyInfo) {
        this.mIpConfiguration.httpProxy = proxyInfo;
    }

    public void setIpAssignment(IpConfiguration.IpAssignment ipAssignment) {
        this.mIpConfiguration.ipAssignment = ipAssignment;
    }

    public void setIpConfiguration(IpConfiguration ipConfiguration) {
        this.mIpConfiguration = ipConfiguration;
    }

    public void setProxy(IpConfiguration.ProxySettings proxySettings, ProxyInfo proxyInfo) {
        this.mIpConfiguration.proxySettings = proxySettings;
        this.mIpConfiguration.httpProxy = proxyInfo;
    }

    public void setProxySettings(IpConfiguration.ProxySettings proxySettings) {
        this.mIpConfiguration.proxySettings = proxySettings;
    }

    public void setStaticIpConfiguration(StaticIpConfiguration staticIpConfiguration) {
        this.mIpConfiguration.setStaticIpConfiguration(staticIpConfiguration);
    }

    public Visibility setVisibility(long j) {
        return setVisibility(j, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x007a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0034 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.wifi.WifiConfiguration.Visibility setVisibility(long r6, int r8) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.wifi.WifiConfiguration.setVisibility(long, int):android.net.wifi.WifiConfiguration$Visibility");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.status == 0) {
            sb.append("* ");
        } else if (this.status == 1) {
            sb.append("- DSBLE ");
        }
        sb.append("ID: ").append(this.networkId).append(" SSID: ").append(this.SSID).append(" BSSID: ").append(this.BSSID).append(" FQDN: ").append(this.FQDN).append(" REALM: ").append(this.naiRealm).append(" PRIO: ").append(this.priority).append('\n');
        if (this.numConnectionFailures > 0) {
            sb.append(" numConnectFailures ").append(this.numConnectionFailures).append("\n");
        }
        if (this.numIpConfigFailures > 0) {
            sb.append(" numIpConfigFailures ").append(this.numIpConfigFailures).append("\n");
        }
        if (this.numAuthFailures > 0) {
            sb.append(" numAuthFailures ").append(this.numAuthFailures).append("\n");
        }
        if (this.autoJoinStatus > 0) {
            sb.append(" autoJoinStatus ").append(this.autoJoinStatus).append("\n");
        }
        if (this.disableReason > 0) {
            sb.append(" disableReason ").append(this.disableReason).append("\n");
        }
        if (this.numAssociation > 0) {
            sb.append(" numAssociation ").append(this.numAssociation).append("\n");
        }
        if (this.numNoInternetAccessReports > 0) {
            sb.append(" numNoInternetAccessReports ");
            sb.append(this.numNoInternetAccessReports).append("\n");
        }
        if (this.didSelfAdd) {
            sb.append(" didSelfAdd");
        }
        if (this.selfAdded) {
            sb.append(" selfAdded");
        }
        if (this.validatedInternetAccess) {
            sb.append(" validatedInternetAccess");
        }
        if (this.ephemeral) {
            sb.append(" ephemeral");
        }
        if (this.didSelfAdd || this.selfAdded || this.validatedInternetAccess || this.ephemeral) {
            sb.append("\n");
        }
        sb.append(" KeyMgmt:");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.allowedKeyManagement.size()) {
                break;
            }
            if (this.allowedKeyManagement.get(i2)) {
                sb.append(" ");
                if (i2 < KeyMgmt.strings.length) {
                    sb.append(KeyMgmt.strings[i2]);
                } else {
                    sb.append("??");
                }
            }
            i = i2 + 1;
        }
        sb.append(" Protocols:");
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.allowedProtocols.size()) {
                break;
            }
            if (this.allowedProtocols.get(i4)) {
                sb.append(" ");
                if (i4 < Protocol.strings.length) {
                    sb.append(Protocol.strings[i4]);
                } else {
                    sb.append("??");
                }
            }
            i3 = i4 + 1;
        }
        sb.append('\n');
        sb.append(" AuthAlgorithms:");
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.allowedAuthAlgorithms.size()) {
                break;
            }
            if (this.allowedAuthAlgorithms.get(i6)) {
                sb.append(" ");
                if (i6 < AuthAlgorithm.strings.length) {
                    sb.append(AuthAlgorithm.strings[i6]);
                } else {
                    sb.append("??");
                }
            }
            i5 = i6 + 1;
        }
        sb.append('\n');
        sb.append(" PairwiseCiphers:");
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= this.allowedPairwiseCiphers.size()) {
                break;
            }
            if (this.allowedPairwiseCiphers.get(i8)) {
                sb.append(" ");
                if (i8 < PairwiseCipher.strings.length) {
                    sb.append(PairwiseCipher.strings[i8]);
                } else {
                    sb.append("??");
                }
            }
            i7 = i8 + 1;
        }
        sb.append('\n');
        sb.append(" GroupCiphers:");
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= this.allowedGroupCiphers.size()) {
                break;
            }
            if (this.allowedGroupCiphers.get(i10)) {
                sb.append(" ");
                if (i10 < GroupCipher.strings.length) {
                    sb.append(GroupCipher.strings[i10]);
                } else {
                    sb.append("??");
                }
            }
            i9 = i10 + 1;
        }
        sb.append('\n').append(" PSK: ");
        if (this.preSharedKey != null) {
            sb.append('*');
        }
        sb.append('\n').append(" sim_num ");
        if (this.SIMNum > 0) {
            sb.append('*');
        }
        sb.append("\nEnterprise config:\n");
        sb.append(this.enterpriseConfig);
        sb.append("IP config:\n");
        sb.append(this.mIpConfiguration.toString());
        if (this.creatorUid != 0) {
            sb.append(" uid=" + Integer.toString(this.creatorUid));
        }
        if (this.autoJoinBSSID != null) {
            sb.append(" autoJoinBSSID=" + this.autoJoinBSSID);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.blackListTimestamp != 0) {
            sb.append('\n');
            long j = currentTimeMillis - this.blackListTimestamp;
            if (j <= 0) {
                sb.append(" blackListed since <incorrect>");
            } else {
                sb.append(" blackListed: ").append(Long.toString(j / 1000)).append(c.al);
            }
        }
        if (this.lastConnected != 0) {
            sb.append('\n');
            long j2 = currentTimeMillis - this.lastConnected;
            if (j2 <= 0) {
                sb.append("lastConnected since <incorrect>");
            } else {
                sb.append("lastConnected: ").append(Long.toString(j2 / 1000)).append(c.al);
            }
        }
        if (this.lastConnectionFailure != 0) {
            sb.append('\n');
            long j3 = currentTimeMillis - this.lastConnectionFailure;
            if (j3 <= 0) {
                sb.append("lastConnectionFailure since <incorrect>");
            } else {
                sb.append("lastConnectionFailure: ").append(Long.toString(j3 / 1000));
                sb.append(c.al);
            }
        }
        if (this.lastRoamingFailure != 0) {
            sb.append('\n');
            long j4 = currentTimeMillis - this.lastRoamingFailure;
            if (j4 <= 0) {
                sb.append("lastRoamingFailure since <incorrect>");
            } else {
                sb.append("lastRoamingFailure: ").append(Long.toString(j4 / 1000));
                sb.append(c.al);
            }
        }
        sb.append("roamingFailureBlackListTimeMilli: ").append(Long.toString(this.roamingFailureBlackListTimeMilli));
        sb.append('\n');
        if (this.linkedConfigurations != null) {
            for (String str : this.linkedConfigurations.keySet()) {
                sb.append(" linked: ").append(str);
                sb.append('\n');
            }
        }
        if (this.connectChoices != null) {
            for (String str2 : this.connectChoices.keySet()) {
                Integer num = this.connectChoices.get(str2);
                if (num != null) {
                    sb.append(" choice: ").append(str2);
                    sb.append(" = ").append(num);
                    sb.append('\n');
                }
            }
        }
        if (this.scanResultCache != null) {
            sb.append("Scan Cache:  ").append('\n');
            ArrayList<ScanResult> sortScanResults = sortScanResults();
            if (sortScanResults.size() > 0) {
                Iterator<ScanResult> it = sortScanResults.iterator();
                while (it.hasNext()) {
                    ScanResult next = it.next();
                    long j5 = currentTimeMillis - next.seen;
                    long j6 = 0;
                    long j7 = 0;
                    long j8 = 0;
                    long j9 = 0;
                    long j10 = 0;
                    if (currentTimeMillis > next.seen) {
                        j6 = 0;
                        j7 = 0;
                        j8 = 0;
                        j9 = 0;
                        j10 = 0;
                        if (next.seen > 0) {
                            j8 = j5 % 1000;
                            j10 = (j5 / 1000) % 60;
                            j9 = (j5 / 60000) % 60;
                            j7 = (j5 / 3600000) % 24;
                            j6 = j5 / 86400000;
                        }
                    }
                    sb.append("{").append(next.BSSID).append(",").append(next.frequency);
                    sb.append(",").append(String.format("%3d", Integer.valueOf(next.level)));
                    if (next.autoJoinStatus > 0) {
                        sb.append(",st=").append(next.autoJoinStatus);
                    }
                    if (j10 > 0 || j8 > 0) {
                        sb.append(String.format(",%4d.%02d.%02d.%02d.%03dms", Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j8)));
                    }
                    if (next.numIpConfigFailures > 0) {
                        sb.append(",ipfail=");
                        sb.append(next.numIpConfigFailures);
                    }
                    sb.append("} ");
                }
                sb.append('\n');
            }
        }
        sb.append("triggeredLow: ").append(this.numUserTriggeredWifiDisableLowRSSI);
        sb.append(" triggeredBad: ").append(this.numUserTriggeredWifiDisableBadRSSI);
        sb.append(" triggeredNotHigh: ").append(this.numUserTriggeredWifiDisableNotHighRSSI);
        sb.append('\n');
        sb.append("ticksLow: ").append(this.numTicksAtLowRSSI);
        sb.append(" ticksBad: ").append(this.numTicksAtBadRSSI);
        sb.append(" ticksNotHigh: ").append(this.numTicksAtNotHighRSSI);
        sb.append('\n');
        sb.append("triggeredJoin: ").append(this.numUserTriggeredJoinAttempts);
        sb.append('\n');
        sb.append("autoJoinBailedDueToLowRssi: ").append(this.autoJoinBailedDueToLowRssi);
        sb.append('\n');
        sb.append("autoJoinUseAggressiveJoinAttemptThreshold: ");
        sb.append(this.autoJoinUseAggressiveJoinAttemptThreshold);
        sb.append('\n');
        return sb.toString();
    }

    public void trimScanResultsCache(int i) {
        int size;
        if (this.scanResultCache == null || (size = this.scanResultCache.size()) <= i) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.scanResultCache.values());
        if (arrayList.size() != 0) {
            Collections.sort(arrayList, new Comparator() { // from class: android.net.wifi.WifiConfiguration.1
                @Override // java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    ScanResult scanResult = (ScanResult) obj;
                    ScanResult scanResult2 = (ScanResult) obj2;
                    if (scanResult.seen > scanResult2.seen) {
                        return 1;
                    }
                    if (scanResult.seen < scanResult2.seen) {
                        return -1;
                    }
                    return scanResult.BSSID.compareTo(scanResult2.BSSID);
                }
            });
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size - i) {
                return;
            }
            this.scanResultCache.remove(((ScanResult) arrayList.get(i3)).BSSID);
            i2 = i3 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.networkId);
        parcel.writeInt(this.status);
        parcel.writeInt(this.disableReason);
        parcel.writeString(this.SSID);
        parcel.writeString(this.BSSID);
        parcel.writeString(this.autoJoinBSSID);
        parcel.writeString(this.FQDN);
        parcel.writeString(this.naiRealm);
        parcel.writeString(this.preSharedKey);
        String[] strArr = this.wepKeys;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            parcel.writeString(strArr[i3]);
            i2 = i3 + 1;
        }
        parcel.writeInt(this.wepTxKeyIndex);
        parcel.writeInt(this.priority);
        parcel.writeInt(this.hiddenSSID ? 1 : 0);
        parcel.writeInt(this.isIBSS ? 1 : 0);
        parcel.writeInt(this.frequency);
        parcel.writeInt(this.requirePMF ? 1 : 0);
        parcel.writeString(this.updateIdentifier);
        writeBitSet(parcel, this.allowedKeyManagement);
        writeBitSet(parcel, this.allowedProtocols);
        writeBitSet(parcel, this.allowedAuthAlgorithms);
        writeBitSet(parcel, this.allowedPairwiseCiphers);
        writeBitSet(parcel, this.allowedGroupCiphers);
        parcel.writeParcelable(this.enterpriseConfig, i);
        parcel.writeParcelable(this.mIpConfiguration, i);
        parcel.writeString(this.dhcpServer);
        parcel.writeString(this.defaultGwMacAddress);
        parcel.writeInt(this.autoJoinStatus);
        parcel.writeInt(this.selfAdded ? 1 : 0);
        parcel.writeInt(this.didSelfAdd ? 1 : 0);
        parcel.writeInt(this.validatedInternetAccess ? 1 : 0);
        parcel.writeInt(this.ephemeral ? 1 : 0);
        parcel.writeInt(this.creatorUid);
        parcel.writeInt(this.lastConnectUid);
        parcel.writeInt(this.lastUpdateUid);
        parcel.writeLong(this.blackListTimestamp);
        parcel.writeLong(this.lastConnectionFailure);
        parcel.writeLong(this.lastRoamingFailure);
        parcel.writeInt(this.lastRoamingFailureReason);
        parcel.writeLong(this.roamingFailureBlackListTimeMilli);
        parcel.writeInt(this.numConnectionFailures);
        parcel.writeInt(this.numIpConfigFailures);
        parcel.writeInt(this.numAuthFailures);
        parcel.writeInt(this.numScorerOverride);
        parcel.writeInt(this.numScorerOverrideAndSwitchedNetwork);
        parcel.writeInt(this.numAssociation);
        parcel.writeInt(this.numUserTriggeredWifiDisableLowRSSI);
        parcel.writeInt(this.numUserTriggeredWifiDisableBadRSSI);
        parcel.writeInt(this.numUserTriggeredWifiDisableNotHighRSSI);
        parcel.writeInt(this.numTicksAtLowRSSI);
        parcel.writeInt(this.numTicksAtBadRSSI);
        parcel.writeInt(this.numTicksAtNotHighRSSI);
        parcel.writeInt(this.numUserTriggeredJoinAttempts);
        parcel.writeInt(this.autoJoinUseAggressiveJoinAttemptThreshold);
        parcel.writeInt(this.autoJoinBailedDueToLowRssi ? 1 : 0);
        parcel.writeInt(this.SIMNum);
        parcel.writeInt(this.numNoInternetAccessReports);
    }
}
