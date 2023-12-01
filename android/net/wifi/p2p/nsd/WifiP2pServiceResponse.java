package android.net.wifi.p2p.nsd;

import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.security.mobile.module.http.model.c;
import com.blued.das.live.LiveProtos;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/nsd/WifiP2pServiceResponse.class */
public class WifiP2pServiceResponse implements Parcelable {
    protected byte[] mData;
    protected WifiP2pDevice mDevice;
    protected int mServiceType;
    protected int mStatus;
    protected int mTransId;
    private static int MAX_BUF_SIZE = 1024;
    public static final Parcelable.Creator<WifiP2pServiceResponse> CREATOR = new Parcelable.Creator<WifiP2pServiceResponse>() { // from class: android.net.wifi.p2p.nsd.WifiP2pServiceResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pServiceResponse createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) parcel.readParcelable(null);
            int readInt4 = parcel.readInt();
            byte[] bArr = null;
            if (readInt4 > 0) {
                bArr = new byte[readInt4];
                parcel.readByteArray(bArr);
            }
            return readInt == 1 ? WifiP2pDnsSdServiceResponse.newInstance(readInt2, readInt3, wifiP2pDevice, bArr) : readInt == 2 ? WifiP2pUpnpServiceResponse.newInstance(readInt2, readInt3, wifiP2pDevice, bArr) : new WifiP2pServiceResponse(readInt, readInt2, readInt3, wifiP2pDevice, bArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pServiceResponse[] newArray(int i) {
            return new WifiP2pServiceResponse[i];
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/nsd/WifiP2pServiceResponse$Status.class */
    public static class Status {
        public static final int BAD_REQUEST = 3;
        public static final int REQUESTED_INFORMATION_NOT_AVAILABLE = 2;
        public static final int SERVICE_PROTOCOL_NOT_AVAILABLE = 1;
        public static final int SUCCESS = 0;

        private Status() {
        }

        public static String toString(int i) {
            switch (i) {
                case 0:
                    return c.g;
                case 1:
                    return "SERVICE_PROTOCOL_NOT_AVAILABLE";
                case 2:
                    return "REQUESTED_INFORMATION_NOT_AVAILABLE";
                case 3:
                    return "BAD_REQUEST";
                default:
                    return "UNKNOWN";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WifiP2pServiceResponse(int i, int i2, int i3, WifiP2pDevice wifiP2pDevice, byte[] bArr) {
        this.mServiceType = i;
        this.mStatus = i2;
        this.mTransId = i3;
        this.mDevice = wifiP2pDevice;
        this.mData = bArr;
    }

    private boolean equals(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    private static byte[] hexStr2Bin(String str) {
        byte[] bArr;
        int length = str.length() / 2;
        byte[] bArr2 = new byte[str.length() / 2];
        int i = 0;
        while (true) {
            int i2 = i;
            bArr = bArr2;
            if (i2 >= length) {
                break;
            }
            try {
                bArr2[i2] = (byte) Integer.parseInt(str.substring(i2 * 2, (i2 * 2) + 2), 16);
                i = i2 + 1;
            } catch (Exception e) {
                e.printStackTrace();
                bArr = null;
            }
        }
        return bArr;
    }

    public static List<WifiP2pServiceResponse> newInstance(String str) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        String[] split = str.split(" ");
        if (split.length != 4) {
            arrayList = null;
        } else {
            WifiP2pDevice wifiP2pDevice = new WifiP2pDevice();
            wifiP2pDevice.deviceAddress = split[1];
            byte[] hexStr2Bin = hexStr2Bin(split[3]);
            if (hexStr2Bin == null) {
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(hexStr2Bin));
            while (true) {
                arrayList = arrayList2;
                try {
                    if (dataInputStream.available() <= 0) {
                        break;
                    }
                    int readUnsignedByte = (dataInputStream.readUnsignedByte() + (dataInputStream.readUnsignedByte() << 8)) - 3;
                    int readUnsignedByte2 = dataInputStream.readUnsignedByte();
                    int readUnsignedByte3 = dataInputStream.readUnsignedByte();
                    int readUnsignedByte4 = dataInputStream.readUnsignedByte();
                    if (readUnsignedByte < 0) {
                        return null;
                    }
                    if (readUnsignedByte == 0) {
                        if (readUnsignedByte4 == 0) {
                            arrayList2.add(new WifiP2pServiceResponse(readUnsignedByte2, readUnsignedByte4, readUnsignedByte3, wifiP2pDevice, null));
                        }
                    } else if (readUnsignedByte > MAX_BUF_SIZE) {
                        dataInputStream.skip(readUnsignedByte);
                    } else {
                        byte[] bArr = new byte[readUnsignedByte];
                        dataInputStream.readFully(bArr);
                        WifiP2pDnsSdServiceResponse newInstance = readUnsignedByte2 == 1 ? WifiP2pDnsSdServiceResponse.newInstance(readUnsignedByte4, readUnsignedByte3, wifiP2pDevice, bArr) : readUnsignedByte2 == 2 ? WifiP2pUpnpServiceResponse.newInstance(readUnsignedByte4, readUnsignedByte3, wifiP2pDevice, bArr) : new WifiP2pServiceResponse(readUnsignedByte2, readUnsignedByte4, readUnsignedByte3, wifiP2pDevice, bArr);
                        if (newInstance != null && newInstance.getStatus() == 0) {
                            arrayList2.add(newInstance);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    arrayList = arrayList2;
                    if (arrayList2.size() <= 0) {
                        return null;
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof WifiP2pServiceResponse) {
            WifiP2pServiceResponse wifiP2pServiceResponse = (WifiP2pServiceResponse) obj;
            return wifiP2pServiceResponse.mServiceType == this.mServiceType && wifiP2pServiceResponse.mStatus == this.mStatus && equals(wifiP2pServiceResponse.mDevice.deviceAddress, this.mDevice.deviceAddress) && Arrays.equals(wifiP2pServiceResponse.mData, this.mData);
        }
        return false;
    }

    public byte[] getRawData() {
        return this.mData;
    }

    public int getServiceType() {
        return this.mServiceType;
    }

    public WifiP2pDevice getSrcDevice() {
        return this.mDevice;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getTransactionId() {
        return this.mTransId;
    }

    public int hashCode() {
        int i = 0;
        int i2 = this.mServiceType;
        int i3 = this.mStatus;
        int i4 = this.mTransId;
        int hashCode = this.mDevice.deviceAddress == null ? 0 : this.mDevice.deviceAddress.hashCode();
        if (this.mData != null) {
            i = this.mData.hashCode();
        }
        return ((((((((i2 + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + i3) * 31) + i4) * 31) + hashCode) * 31) + i;
    }

    public void setSrcDevice(WifiP2pDevice wifiP2pDevice) {
        if (wifiP2pDevice == null) {
            return;
        }
        this.mDevice = wifiP2pDevice;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("serviceType:").append(this.mServiceType);
        stringBuffer.append(" status:").append(Status.toString(this.mStatus));
        stringBuffer.append(" srcAddr:").append(this.mDevice.deviceAddress);
        stringBuffer.append(" data:").append(this.mData);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mServiceType);
        parcel.writeInt(this.mStatus);
        parcel.writeInt(this.mTransId);
        parcel.writeParcelable(this.mDevice, i);
        if (this.mData == null || this.mData.length == 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.mData.length);
        parcel.writeByteArray(this.mData);
    }
}
