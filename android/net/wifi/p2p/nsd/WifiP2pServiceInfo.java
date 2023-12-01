package android.net.wifi.p2p.nsd;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/nsd/WifiP2pServiceInfo.class */
public class WifiP2pServiceInfo implements Parcelable {
    public static final Parcelable.Creator<WifiP2pServiceInfo> CREATOR = new Parcelable.Creator<WifiP2pServiceInfo>() { // from class: android.net.wifi.p2p.nsd.WifiP2pServiceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pServiceInfo createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            return new WifiP2pServiceInfo(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pServiceInfo[] newArray(int i) {
            return new WifiP2pServiceInfo[i];
        }
    };
    public static final int SERVICE_TYPE_ALL = 0;
    public static final int SERVICE_TYPE_BONJOUR = 1;
    public static final int SERVICE_TYPE_UPNP = 2;
    public static final int SERVICE_TYPE_VENDOR_SPECIFIC = 255;
    public static final int SERVICE_TYPE_WS_DISCOVERY = 3;
    private List<String> mQueryList;

    /* JADX INFO: Access modifiers changed from: protected */
    public WifiP2pServiceInfo(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("query list cannot be null");
        }
        this.mQueryList = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String bin2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return stringBuffer.toString();
            }
            try {
                String hexString = Integer.toHexString(bArr[i2] & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(hexString);
                i = i2 + 1;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof WifiP2pServiceInfo) {
            return this.mQueryList.equals(((WifiP2pServiceInfo) obj).mQueryList);
        }
        return false;
    }

    public List<String> getSupplicantQueryList() {
        return this.mQueryList;
    }

    public int hashCode() {
        return (this.mQueryList == null ? 0 : this.mQueryList.hashCode()) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.mQueryList);
    }
}
