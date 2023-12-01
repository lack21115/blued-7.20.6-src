package android.net;

import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import com.android.internal.R;
import com.android.internal.util.ArrayUtils;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkTemplate.class */
public class NetworkTemplate implements Parcelable {
    public static final int MATCH_BLUETOOTH = 8;
    public static final int MATCH_ETHERNET = 5;
    @Deprecated
    public static final int MATCH_MOBILE_3G_LOWER = 2;
    @Deprecated
    public static final int MATCH_MOBILE_4G = 3;
    public static final int MATCH_MOBILE_ALL = 1;
    public static final int MATCH_MOBILE_WILDCARD = 6;
    public static final int MATCH_WIFI = 4;
    public static final int MATCH_WIFI_WILDCARD = 7;
    private final int mMatchRule;
    private final String[] mMatchSubscriberIds;
    private final String mNetworkId;
    private final String mSubscriberId;
    private static final int[] DATA_USAGE_NETWORK_TYPES = Resources.getSystem().getIntArray(R.array.config_data_usage_network_types);
    private static boolean sForceAllNetworkTypes = false;
    public static final Parcelable.Creator<NetworkTemplate> CREATOR = new Parcelable.Creator<NetworkTemplate>() { // from class: android.net.NetworkTemplate.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkTemplate createFromParcel(Parcel parcel) {
            return new NetworkTemplate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkTemplate[] newArray(int i) {
            return new NetworkTemplate[i];
        }
    };

    public NetworkTemplate(int i, String str, String str2) {
        this(i, str, new String[]{str}, str2);
    }

    public NetworkTemplate(int i, String str, String[] strArr, String str2) {
        this.mMatchRule = i;
        this.mSubscriberId = str;
        this.mMatchSubscriberIds = strArr;
        this.mNetworkId = str2;
    }

    private NetworkTemplate(Parcel parcel) {
        this.mMatchRule = parcel.readInt();
        this.mSubscriberId = parcel.readString();
        this.mMatchSubscriberIds = parcel.createStringArray();
        this.mNetworkId = parcel.readString();
    }

    public static NetworkTemplate buildTemplateBluetooth() {
        return new NetworkTemplate(8, null, null);
    }

    public static NetworkTemplate buildTemplateEthernet() {
        return new NetworkTemplate(5, null, null);
    }

    @Deprecated
    public static NetworkTemplate buildTemplateMobile3gLower(String str) {
        return new NetworkTemplate(2, str, null);
    }

    @Deprecated
    public static NetworkTemplate buildTemplateMobile4g(String str) {
        return new NetworkTemplate(3, str, null);
    }

    public static NetworkTemplate buildTemplateMobileAll(String str) {
        return new NetworkTemplate(1, str, null);
    }

    public static NetworkTemplate buildTemplateMobileWildcard() {
        return new NetworkTemplate(6, null, null);
    }

    @Deprecated
    public static NetworkTemplate buildTemplateWifi() {
        return buildTemplateWifiWildcard();
    }

    public static NetworkTemplate buildTemplateWifi(String str) {
        return new NetworkTemplate(4, null, str);
    }

    public static NetworkTemplate buildTemplateWifiWildcard() {
        return new NetworkTemplate(7, null, null);
    }

    private static void ensureSubtypeAvailable() {
        throw new IllegalArgumentException("Unable to enforce 3G_LOWER template on combined data.");
    }

    public static void forceAllNetworkTypes() {
        sForceAllNetworkTypes = true;
    }

    private static String getMatchRuleName(int i) {
        switch (i) {
            case 1:
                return "MOBILE_ALL";
            case 2:
                return "MOBILE_3G_LOWER";
            case 3:
                return "MOBILE_4G";
            case 4:
                return "WIFI";
            case 5:
                return "ETHERNET";
            case 6:
                return "MOBILE_WILDCARD";
            case 7:
                return "WIFI_WILDCARD";
            case 8:
                return "BLUETOOTH";
            default:
                return "UNKNOWN";
        }
    }

    private boolean matchesBluetooth(NetworkIdentity networkIdentity) {
        return networkIdentity.mType == 7;
    }

    private boolean matchesEthernet(NetworkIdentity networkIdentity) {
        return networkIdentity.mType == 9;
    }

    private boolean matchesMobile(NetworkIdentity networkIdentity) {
        if (networkIdentity.mType == 6) {
            return true;
        }
        return (sForceAllNetworkTypes || ArrayUtils.contains(DATA_USAGE_NETWORK_TYPES, networkIdentity.mType)) && ArrayUtils.contains(this.mMatchSubscriberIds, networkIdentity.mSubscriberId);
    }

    @Deprecated
    private boolean matchesMobile3gLower(NetworkIdentity networkIdentity) {
        ensureSubtypeAvailable();
        if (networkIdentity.mType != 6 && matchesMobile(networkIdentity)) {
            switch (TelephonyManager.getNetworkClass(networkIdentity.mSubType)) {
                case 0:
                case 1:
                case 2:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    @Deprecated
    private boolean matchesMobile4g(NetworkIdentity networkIdentity) {
        ensureSubtypeAvailable();
        if (networkIdentity.mType == 6) {
            return true;
        }
        if (matchesMobile(networkIdentity)) {
            switch (TelephonyManager.getNetworkClass(networkIdentity.mSubType)) {
                case 3:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    private boolean matchesMobileWildcard(NetworkIdentity networkIdentity) {
        return networkIdentity.mType == 6 || sForceAllNetworkTypes || ArrayUtils.contains(DATA_USAGE_NETWORK_TYPES, networkIdentity.mType);
    }

    private boolean matchesWifi(NetworkIdentity networkIdentity) {
        switch (networkIdentity.mType) {
            case 1:
                return Objects.equals(WifiInfo.removeDoubleQuotes(this.mNetworkId), WifiInfo.removeDoubleQuotes(networkIdentity.mNetworkId));
            default:
                return false;
        }
    }

    private boolean matchesWifiWildcard(NetworkIdentity networkIdentity) {
        switch (networkIdentity.mType) {
            case 1:
            case 13:
                return true;
            default:
                return false;
        }
    }

    public static NetworkTemplate normalize(NetworkTemplate networkTemplate, String[] strArr) {
        NetworkTemplate networkTemplate2 = networkTemplate;
        if (networkTemplate.isMatchRuleMobile()) {
            networkTemplate2 = networkTemplate;
            if (ArrayUtils.contains(strArr, networkTemplate.mSubscriberId)) {
                networkTemplate2 = new NetworkTemplate(networkTemplate.mMatchRule, strArr[0], strArr, networkTemplate.mNetworkId);
            }
        }
        return networkTemplate2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof NetworkTemplate) {
            NetworkTemplate networkTemplate = (NetworkTemplate) obj;
            z = false;
            if (this.mMatchRule == networkTemplate.mMatchRule) {
                z = false;
                if (Objects.equals(this.mSubscriberId, networkTemplate.mSubscriberId)) {
                    z = false;
                    if (Objects.equals(this.mNetworkId, networkTemplate.mNetworkId)) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public int getMatchRule() {
        return this.mMatchRule;
    }

    public String getNetworkId() {
        return this.mNetworkId;
    }

    public String getSubscriberId() {
        return this.mSubscriberId;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mMatchRule), this.mSubscriberId, this.mNetworkId);
    }

    public boolean isMatchRuleMobile() {
        switch (this.mMatchRule) {
            case 1:
            case 2:
            case 3:
            case 6:
                return true;
            case 4:
            case 5:
            default:
                return false;
        }
    }

    public boolean matches(NetworkIdentity networkIdentity) {
        switch (this.mMatchRule) {
            case 1:
                return matchesMobile(networkIdentity);
            case 2:
                return matchesMobile3gLower(networkIdentity);
            case 3:
                return matchesMobile4g(networkIdentity);
            case 4:
                return matchesWifi(networkIdentity);
            case 5:
                return matchesEthernet(networkIdentity);
            case 6:
                return matchesMobileWildcard(networkIdentity);
            case 7:
                return matchesWifiWildcard(networkIdentity);
            case 8:
                return matchesBluetooth(networkIdentity);
            default:
                throw new IllegalArgumentException("unknown network template");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkTemplate: ");
        sb.append("matchRule=").append(getMatchRuleName(this.mMatchRule));
        if (this.mSubscriberId != null) {
            sb.append(", subscriberId=").append(NetworkIdentity.scrubSubscriberId(this.mSubscriberId));
        }
        if (this.mMatchSubscriberIds != null) {
            sb.append(", matchSubscriberIds=").append(Arrays.toString(NetworkIdentity.scrubSubscriberId(this.mMatchSubscriberIds)));
        }
        if (this.mNetworkId != null) {
            sb.append(", networkId=").append(this.mNetworkId);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMatchRule);
        parcel.writeString(this.mSubscriberId);
        parcel.writeStringArray(this.mMatchSubscriberIds);
        parcel.writeString(this.mNetworkId);
    }
}
