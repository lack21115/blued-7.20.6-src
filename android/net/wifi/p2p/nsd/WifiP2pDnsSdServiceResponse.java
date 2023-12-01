package android.net.wifi.p2p.nsd;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.nsd.WifiP2pServiceResponse;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/nsd/WifiP2pDnsSdServiceResponse.class */
public class WifiP2pDnsSdServiceResponse extends WifiP2pServiceResponse {
    private static final Map<Integer, String> sVmpack = new HashMap();
    private String mDnsQueryName;
    private int mDnsType;
    private String mInstanceName;
    private final HashMap<String, String> mTxtRecord;
    private int mVersion;

    static {
        sVmpack.put(12, "_tcp.local.");
        sVmpack.put(17, "local.");
        sVmpack.put(28, "_udp.local.");
    }

    protected WifiP2pDnsSdServiceResponse(int i, int i2, WifiP2pDevice wifiP2pDevice, byte[] bArr) {
        super(1, i, i2, wifiP2pDevice, bArr);
        this.mTxtRecord = new HashMap<>();
        if (!parse()) {
            throw new IllegalArgumentException("Malformed bonjour service response");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WifiP2pDnsSdServiceResponse newInstance(int i, int i2, WifiP2pDevice wifiP2pDevice, byte[] bArr) {
        if (i != 0) {
            return new WifiP2pDnsSdServiceResponse(i, i2, wifiP2pDevice, null);
        }
        try {
            return new WifiP2pDnsSdServiceResponse(i, i2, wifiP2pDevice, bArr);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean parse() {
        if (this.mData == null) {
            return true;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.mData));
        this.mDnsQueryName = readDnsName(dataInputStream);
        if (this.mDnsQueryName == null) {
            return false;
        }
        try {
            this.mDnsType = dataInputStream.readUnsignedShort();
            this.mVersion = dataInputStream.readUnsignedByte();
            if (this.mDnsType != 12) {
                if (this.mDnsType == 16) {
                    return readTxtData(dataInputStream);
                }
                return false;
            }
            String readDnsName = readDnsName(dataInputStream);
            if (readDnsName != null && readDnsName.length() > this.mDnsQueryName.length()) {
                this.mInstanceName = readDnsName.substring(0, (readDnsName.length() - this.mDnsQueryName.length()) - 1);
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String readDnsName(DataInputStream dataInputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        HashMap hashMap = new HashMap(sVmpack);
        if (this.mDnsQueryName != null) {
            hashMap.put(39, this.mDnsQueryName);
        }
        while (true) {
            try {
                int readUnsignedByte = dataInputStream.readUnsignedByte();
                if (readUnsignedByte == 0) {
                    return stringBuffer.toString();
                }
                if (readUnsignedByte == 192) {
                    String str = (String) hashMap.get(Integer.valueOf(dataInputStream.readUnsignedByte()));
                    if (str != null) {
                        stringBuffer.append(str);
                        return stringBuffer.toString();
                    }
                    return null;
                }
                byte[] bArr = new byte[readUnsignedByte];
                dataInputStream.readFully(bArr);
                stringBuffer.append(new String(bArr));
                stringBuffer.append(".");
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private boolean readTxtData(DataInputStream dataInputStream) {
        boolean z;
        int readUnsignedByte;
        while (dataInputStream.available() > 0 && (readUnsignedByte = dataInputStream.readUnsignedByte()) != 0) {
            try {
                byte[] bArr = new byte[readUnsignedByte];
                dataInputStream.readFully(bArr);
                String[] split = new String(bArr).split("=");
                z = false;
                if (split.length != 2) {
                    break;
                }
                this.mTxtRecord.put(split[0], split[1]);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        z = true;
        return z;
    }

    public String getDnsQueryName() {
        return this.mDnsQueryName;
    }

    public int getDnsType() {
        return this.mDnsType;
    }

    public String getInstanceName() {
        return this.mInstanceName;
    }

    public Map<String, String> getTxtRecord() {
        return this.mTxtRecord;
    }

    public int getVersion() {
        return this.mVersion;
    }

    @Override // android.net.wifi.p2p.nsd.WifiP2pServiceResponse
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("serviceType:DnsSd(").append(this.mServiceType).append(")");
        stringBuffer.append(" status:").append(WifiP2pServiceResponse.Status.toString(this.mStatus));
        stringBuffer.append(" srcAddr:").append(this.mDevice.deviceAddress);
        stringBuffer.append(" version:").append(String.format("%02x", Integer.valueOf(this.mVersion)));
        stringBuffer.append(" dnsName:").append(this.mDnsQueryName);
        stringBuffer.append(" TxtRecord:");
        for (String str : this.mTxtRecord.keySet()) {
            stringBuffer.append(" key:").append(str).append(" value:").append(this.mTxtRecord.get(str));
        }
        if (this.mInstanceName != null) {
            stringBuffer.append(" InsName:").append(this.mInstanceName);
        }
        return stringBuffer.toString();
    }
}
