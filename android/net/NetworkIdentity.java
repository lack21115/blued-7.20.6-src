package android.net;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Slog;
import com.igexin.push.core.b;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkIdentity.class */
public class NetworkIdentity implements Comparable<NetworkIdentity> {
    public static final boolean COMBINE_SUBTYPE_ENABLED = true;
    public static final int SUBTYPE_COMBINED = -1;
    private static final String TAG = "NetworkIdentity";
    final String mNetworkId;
    final boolean mRoaming;
    final int mSubType = -1;
    final String mSubscriberId;
    final int mType;

    public NetworkIdentity(int i, int i2, String str, String str2, boolean z) {
        this.mType = i;
        this.mSubscriberId = str;
        this.mNetworkId = str2;
        this.mRoaming = z;
    }

    public static NetworkIdentity buildNetworkIdentity(Context context, NetworkState networkState) {
        String str;
        boolean z;
        int type = networkState.networkInfo.getType();
        int subtype = networkState.networkInfo.getSubtype();
        String str2 = null;
        if (ConnectivityManager.isNetworkTypeMobile(type)) {
            if (networkState.subscriberId == null) {
                Slog.w(TAG, "Active mobile network without subscriber!");
            }
            str = networkState.subscriberId;
            z = networkState.networkInfo.isRoaming();
        } else {
            str = null;
            z = false;
            if (type == 1) {
                if (networkState.networkId != null) {
                    str2 = networkState.networkId;
                    str = null;
                    z = false;
                } else {
                    WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                    str2 = connectionInfo != null ? connectionInfo.getSSID() : null;
                    str = null;
                    z = false;
                }
            }
        }
        return new NetworkIdentity(type, subtype, str, str2, z);
    }

    public static String scrubSubscriberId(String str) {
        return "eng".equals(Build.TYPE) ? str : str != null ? str.substring(0, Math.min(6, str.length())) + "..." : b.l;
    }

    public static String[] scrubSubscriberId(String[] strArr) {
        String[] strArr2;
        if (strArr != null) {
            String[] strArr3 = new String[strArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                strArr2 = strArr3;
                if (i2 >= strArr3.length) {
                    break;
                }
                strArr3[i2] = scrubSubscriberId(strArr[i2]);
                i = i2 + 1;
            }
        } else {
            strArr2 = null;
        }
        return strArr2;
    }

    @Override // java.lang.Comparable
    public int compareTo(NetworkIdentity networkIdentity) {
        int compare = Integer.compare(this.mType, networkIdentity.mType);
        int i = compare;
        if (compare == 0) {
            i = Integer.compare(this.mSubType, networkIdentity.mSubType);
        }
        int i2 = i;
        if (i == 0) {
            i2 = i;
            if (this.mSubscriberId != null) {
                i2 = i;
                if (networkIdentity.mSubscriberId != null) {
                    i2 = this.mSubscriberId.compareTo(networkIdentity.mSubscriberId);
                }
            }
        }
        int i3 = i2;
        if (i2 == 0) {
            i3 = i2;
            if (this.mNetworkId != null) {
                i3 = i2;
                if (networkIdentity.mNetworkId != null) {
                    i3 = this.mNetworkId.compareTo(networkIdentity.mNetworkId);
                }
            }
        }
        int i4 = i3;
        if (i3 == 0) {
            i4 = Boolean.compare(this.mRoaming, networkIdentity.mRoaming);
        }
        return i4;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof NetworkIdentity) {
            NetworkIdentity networkIdentity = (NetworkIdentity) obj;
            z = false;
            if (this.mType == networkIdentity.mType) {
                z = false;
                if (this.mSubType == networkIdentity.mSubType) {
                    z = false;
                    if (this.mRoaming == networkIdentity.mRoaming) {
                        z = false;
                        if (Objects.equals(this.mSubscriberId, networkIdentity.mSubscriberId)) {
                            z = false;
                            if (Objects.equals(this.mNetworkId, networkIdentity.mNetworkId)) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public String getNetworkId() {
        return this.mNetworkId;
    }

    public boolean getRoaming() {
        return this.mRoaming;
    }

    public int getSubType() {
        return this.mSubType;
    }

    public String getSubscriberId() {
        return this.mSubscriberId;
    }

    public int getType() {
        return this.mType;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mType), Integer.valueOf(this.mSubType), this.mSubscriberId, this.mNetworkId, Boolean.valueOf(this.mRoaming));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("type=").append(ConnectivityManager.getNetworkTypeName(this.mType));
        sb.append(", subType=");
        sb.append("COMBINED");
        if (this.mSubscriberId != null) {
            sb.append(", subscriberId=").append(scrubSubscriberId(this.mSubscriberId));
        }
        if (this.mNetworkId != null) {
            sb.append(", networkId=").append(this.mNetworkId);
        }
        if (this.mRoaming) {
            sb.append(", ROAMING");
        }
        return sb.append("]").toString();
    }
}
