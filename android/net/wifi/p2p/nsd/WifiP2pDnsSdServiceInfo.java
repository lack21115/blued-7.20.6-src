package android.net.wifi.p2p.nsd;

import android.net.nsd.DnsSdTxtRecord;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/nsd/WifiP2pDnsSdServiceInfo.class */
public class WifiP2pDnsSdServiceInfo extends WifiP2pServiceInfo {
    public static final int DNS_TYPE_PTR = 12;
    public static final int DNS_TYPE_TXT = 16;
    public static final int VERSION_1 = 1;
    private static final Map<String, String> sVmPacket = new HashMap();

    static {
        sVmPacket.put("_tcp.local.", "c00c");
        sVmPacket.put("local.", "c011");
        sVmPacket.put("_udp.local.", "c01c");
    }

    private WifiP2pDnsSdServiceInfo(List<String> list) {
        super(list);
    }

    private static String compressDnsName(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String str2 = sVmPacket.get(str);
            if (str2 != null) {
                stringBuffer.append(str2);
                break;
            }
            int indexOf = str.indexOf(46);
            if (indexOf == -1) {
                if (str.length() > 0) {
                    stringBuffer.append(String.format(Locale.US, "%02x", Integer.valueOf(str.length())));
                    stringBuffer.append(WifiP2pServiceInfo.bin2HexStr(str.getBytes()));
                }
                stringBuffer.append("00");
            } else {
                String substring = str.substring(0, indexOf);
                str = str.substring(indexOf + 1);
                stringBuffer.append(String.format(Locale.US, "%02x", Integer.valueOf(substring.length())));
                stringBuffer.append(WifiP2pServiceInfo.bin2HexStr(substring.getBytes()));
            }
        }
        return stringBuffer.toString();
    }

    private static String createPtrServiceQuery(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bonjour ");
        stringBuffer.append(createRequest(str2 + ".local.", 12, 1));
        stringBuffer.append(" ");
        byte[] bytes = str.getBytes();
        stringBuffer.append(String.format(Locale.US, "%02x", Integer.valueOf(bytes.length)));
        stringBuffer.append(WifiP2pServiceInfo.bin2HexStr(bytes));
        stringBuffer.append("c027");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String createRequest(String str, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str;
        if (i == 16) {
            str2 = str.toLowerCase(Locale.ROOT);
        }
        stringBuffer.append(compressDnsName(str2));
        stringBuffer.append(String.format(Locale.US, "%04x", Integer.valueOf(i)));
        stringBuffer.append(String.format(Locale.US, "%02x", Integer.valueOf(i2)));
        return stringBuffer.toString();
    }

    private static String createTxtServiceQuery(String str, String str2, DnsSdTxtRecord dnsSdTxtRecord) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bonjour ");
        stringBuffer.append(createRequest(str + "." + str2 + ".local.", 16, 1));
        stringBuffer.append(" ");
        byte[] rawData = dnsSdTxtRecord.getRawData();
        if (rawData.length == 0) {
            stringBuffer.append("00");
        } else {
            stringBuffer.append(bin2HexStr(rawData));
        }
        return stringBuffer.toString();
    }

    public static WifiP2pDnsSdServiceInfo newInstance(String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("instance name or service type cannot be empty");
        }
        DnsSdTxtRecord dnsSdTxtRecord = new DnsSdTxtRecord();
        if (map != null) {
            for (String str3 : map.keySet()) {
                dnsSdTxtRecord.set(str3, map.get(str3));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(createPtrServiceQuery(str, str2));
        arrayList.add(createTxtServiceQuery(str, str2, dnsSdTxtRecord));
        return new WifiP2pDnsSdServiceInfo(arrayList);
    }
}
