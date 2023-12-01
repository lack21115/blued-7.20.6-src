package android.net.wifi.p2p.nsd;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/nsd/WifiP2pServiceRequest.class */
public class WifiP2pServiceRequest implements Parcelable {
    public static final Parcelable.Creator<WifiP2pServiceRequest> CREATOR = new Parcelable.Creator<WifiP2pServiceRequest>() { // from class: android.net.wifi.p2p.nsd.WifiP2pServiceRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pServiceRequest createFromParcel(Parcel parcel) {
            return new WifiP2pServiceRequest(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pServiceRequest[] newArray(int i) {
            return new WifiP2pServiceRequest[i];
        }
    };
    private int mLength;
    private int mProtocolType;
    private String mQuery;
    private int mTransId;

    private WifiP2pServiceRequest(int i, int i2, int i3, String str) {
        this.mProtocolType = i;
        this.mLength = i2;
        this.mTransId = i3;
        this.mQuery = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WifiP2pServiceRequest(int i, String str) {
        validateQuery(str);
        this.mProtocolType = i;
        this.mQuery = str;
        if (str != null) {
            this.mLength = (str.length() / 2) + 2;
        } else {
            this.mLength = 2;
        }
    }

    public static WifiP2pServiceRequest newInstance(int i) {
        return new WifiP2pServiceRequest(i, null);
    }

    public static WifiP2pServiceRequest newInstance(int i, String str) {
        return new WifiP2pServiceRequest(i, str);
    }

    private void validateQuery(String str) {
        if (str == null) {
            return;
        }
        if (str.length() % 2 == 1) {
            throw new IllegalArgumentException("query size is invalid. query=" + str);
        }
        if (str.length() / 2 > 65535) {
            throw new IllegalArgumentException("query size is too large. len=" + str.length());
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        char[] charArray = lowerCase.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            char c2 = charArray[i2];
            if ((c2 < '0' || c2 > '9') && (c2 < 'a' || c2 > 'f')) {
                break;
            }
            i = i2 + 1;
        }
        throw new IllegalArgumentException("query should be hex string. query=" + lowerCase);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof WifiP2pServiceRequest) {
            WifiP2pServiceRequest wifiP2pServiceRequest = (WifiP2pServiceRequest) obj;
            if (wifiP2pServiceRequest.mProtocolType == this.mProtocolType && wifiP2pServiceRequest.mLength == this.mLength) {
                if (wifiP2pServiceRequest.mQuery == null && this.mQuery == null) {
                    return true;
                }
                if (wifiP2pServiceRequest.mQuery != null) {
                    return wifiP2pServiceRequest.mQuery.equals(this.mQuery);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String getSupplicantQuery() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format(Locale.US, "%02x", Integer.valueOf(this.mLength & 255)));
        stringBuffer.append(String.format(Locale.US, "%02x", Integer.valueOf((this.mLength >> 8) & 255)));
        stringBuffer.append(String.format(Locale.US, "%02x", Integer.valueOf(this.mProtocolType)));
        stringBuffer.append(String.format(Locale.US, "%02x", Integer.valueOf(this.mTransId)));
        if (this.mQuery != null) {
            stringBuffer.append(this.mQuery);
        }
        return stringBuffer.toString();
    }

    public int getTransactionId() {
        return this.mTransId;
    }

    public int hashCode() {
        int i = this.mProtocolType;
        return ((((i + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.mLength) * 31) + (this.mQuery == null ? 0 : this.mQuery.hashCode());
    }

    public void setTransactionId(int i) {
        this.mTransId = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mProtocolType);
        parcel.writeInt(this.mLength);
        parcel.writeInt(this.mTransId);
        parcel.writeString(this.mQuery);
    }
}
