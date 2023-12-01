package android.net.nsd;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/net/nsd/NsdServiceInfo.class */
public final class NsdServiceInfo implements Parcelable {
    public static final Parcelable.Creator<NsdServiceInfo> CREATOR = new Parcelable.Creator<NsdServiceInfo>() { // from class: android.net.nsd.NsdServiceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NsdServiceInfo createFromParcel(Parcel parcel) {
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.mServiceName = parcel.readString();
            nsdServiceInfo.mServiceType = parcel.readString();
            if (parcel.readInt() == 1) {
                try {
                    nsdServiceInfo.mHost = InetAddress.getByAddress(parcel.createByteArray());
                } catch (UnknownHostException e) {
                }
            }
            nsdServiceInfo.mPort = parcel.readInt();
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return nsdServiceInfo;
                }
                byte[] bArr = null;
                if (parcel.readInt() == 1) {
                    bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                }
                nsdServiceInfo.mTxtRecord.put(parcel.readString(), bArr);
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NsdServiceInfo[] newArray(int i) {
            return new NsdServiceInfo[i];
        }
    };
    private static final String TAG = "NsdServiceInfo";
    private InetAddress mHost;
    private int mPort;
    private String mServiceName;
    private String mServiceType;
    private final ArrayMap<String, byte[]> mTxtRecord = new ArrayMap<>();

    public NsdServiceInfo() {
    }

    public NsdServiceInfo(String str, String str2) {
        this.mServiceName = str;
        this.mServiceType = str2;
    }

    private int getTxtRecordSize() {
        int i = 0;
        for (Map.Entry<String, byte[]> entry : this.mTxtRecord.entrySet()) {
            int length = entry.getKey().length();
            byte[] value = entry.getValue();
            i = i + 2 + length + (value == null ? 0 : value.length);
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, byte[]> getAttributes() {
        return Collections.unmodifiableMap(this.mTxtRecord);
    }

    public InetAddress getHost() {
        return this.mHost;
    }

    public int getPort() {
        return this.mPort;
    }

    public String getServiceName() {
        return this.mServiceName;
    }

    public String getServiceType() {
        return this.mServiceType;
    }

    public byte[] getTxtRecord() {
        byte[] bArr;
        int txtRecordSize = getTxtRecordSize();
        if (txtRecordSize != 0) {
            byte[] bArr2 = new byte[txtRecordSize];
            int i = 0;
            Iterator<Map.Entry<String, byte[]>> it = this.mTxtRecord.entrySet().iterator();
            while (true) {
                bArr = bArr2;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, byte[]> next = it.next();
                String key = next.getKey();
                byte[] value = next.getValue();
                int i2 = i + 1;
                bArr2[i] = (byte) ((value == null ? 0 : value.length) + key.length() + 1);
                System.arraycopy(key.getBytes(StandardCharsets.US_ASCII), 0, bArr2, i2, key.length());
                int length = i2 + key.length();
                i = length + 1;
                bArr2[length] = 61;
                if (value != null) {
                    System.arraycopy(value, 0, bArr2, i, value.length);
                    i += value.length;
                }
            }
        } else {
            bArr = null;
        }
        return bArr;
    }

    public void removeAttribute(String str) {
        this.mTxtRecord.remove(str);
    }

    public void setAttribute(String str, String str2) {
        try {
            setAttribute(str, str2 == null ? null : str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Value must be UTF-8");
        }
    }

    public void setAttribute(String str, byte[] bArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                if ((bArr == null ? 0 : bArr.length) + str.length() >= 255) {
                    throw new IllegalArgumentException("Key length + value length must be < 255 bytes");
                }
                if (str.length() > 9) {
                    Log.w(TAG, "Key lengths > 9 are discouraged: " + str);
                }
                int txtRecordSize = getTxtRecordSize();
                int length = (bArr == null ? 0 : bArr.length) + str.length() + txtRecordSize + 2;
                if (length > 1300) {
                    throw new IllegalArgumentException("Total length of attributes must be < 1300 bytes");
                }
                if (length > 400) {
                    Log.w(TAG, "Total length of all attributes exceeds 400 bytes; truncation may occur");
                }
                this.mTxtRecord.put(str, bArr);
                return;
            }
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~') {
                break;
            } else if (charAt == '=') {
                throw new IllegalArgumentException("Key strings must not include '='");
            } else {
                i = i2 + 1;
            }
        }
        throw new IllegalArgumentException("Key strings must be printable US-ASCII");
    }

    public void setHost(InetAddress inetAddress) {
        this.mHost = inetAddress;
    }

    public void setPort(int i) {
        this.mPort = i;
    }

    public void setServiceName(String str) {
        this.mServiceName = str;
    }

    public void setServiceType(String str) {
        this.mServiceType = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name: ").append(this.mServiceName).append(", type: ").append(this.mServiceType).append(", host: ").append(this.mHost).append(", port: ").append(this.mPort);
        byte[] txtRecord = getTxtRecord();
        if (txtRecord != null) {
            stringBuffer.append(", txtRecord: ").append(new String(txtRecord, StandardCharsets.UTF_8));
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mServiceName);
        parcel.writeString(this.mServiceType);
        if (this.mHost != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(this.mHost.getAddress());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.mPort);
        parcel.writeInt(this.mTxtRecord.size());
        for (String str : this.mTxtRecord.keySet()) {
            byte[] bArr = this.mTxtRecord.get(str);
            if (bArr != null) {
                parcel.writeInt(1);
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(bArr);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(str);
        }
    }
}
