package android.net;

import android.os.Parcel;
import android.util.Log;
import android.util.Pair;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkUtils.class */
public class NetworkUtils {
    public static final int RESET_ALL_ADDRESSES = 3;
    public static final int RESET_IPV4_ADDRESSES = 1;
    public static final int RESET_IPV6_ADDRESSES = 2;
    private static final String TAG = "NetworkUtils";

    public static boolean addressTypeMatches(InetAddress inetAddress, InetAddress inetAddress2) {
        if ((inetAddress instanceof Inet4Address) && (inetAddress2 instanceof Inet4Address)) {
            return true;
        }
        return (inetAddress instanceof Inet6Address) && (inetAddress2 instanceof Inet6Address);
    }

    public static native boolean bindProcessToNetwork(int i);

    public static native boolean bindProcessToNetworkForHostResolution(int i);

    public static native int bindSocketToNetwork(int i, int i2);

    public static native String getDhcpError();

    public static native int getNetworkBoundToProcess();

    public static InetAddress getNetworkPart(InetAddress inetAddress, int i) {
        byte[] address = inetAddress.getAddress();
        maskRawAddress(address, i);
        try {
            return InetAddress.getByAddress(address);
        } catch (UnknownHostException e) {
            throw new RuntimeException("getNetworkPart error - " + e.toString());
        }
    }

    public static InetAddress hexToInet6Address(String str) throws IllegalArgumentException {
        try {
            return numericToInetAddress(String.format(Locale.US, "%s:%s:%s:%s:%s:%s:%s:%s", str.substring(0, 4), str.substring(4, 8), str.substring(8, 12), str.substring(12, 16), str.substring(16, 20), str.substring(20, 24), str.substring(24, 28), str.substring(28, 32)));
        } catch (Exception e) {
            Log.e(TAG, "error in hexToInet6Address(" + str + "): " + e);
            throw new IllegalArgumentException(e);
        }
    }

    public static int inetAddressToInt(Inet4Address inet4Address) throws IllegalArgumentException {
        byte[] address = inet4Address.getAddress();
        return ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8) | (address[0] & 255);
    }

    public static InetAddress intToInetAddress(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
        } catch (UnknownHostException e) {
            throw new AssertionError();
        }
    }

    public static String[] makeStrings(Collection<InetAddress> collection) {
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (InetAddress inetAddress : collection) {
            strArr[i] = inetAddress.getHostAddress();
            i++;
        }
        return strArr;
    }

    public static void maskRawAddress(byte[] bArr, int i) {
        if (i < 0 || i > bArr.length * 8) {
            throw new RuntimeException("IP address with " + bArr.length + " bytes has invalid prefix length " + i);
        }
        int i2 = i / 8;
        byte b = (byte) (255 << (8 - (i % 8)));
        if (i2 < bArr.length) {
            bArr[i2] = (byte) (bArr[i2] & b);
        }
        int i3 = i2;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= bArr.length) {
                return;
            }
            bArr[i4] = 0;
            i3 = i4;
        }
    }

    public static int netmaskIntToPrefixLength(int i) {
        return Integer.bitCount(i);
    }

    public static InetAddress numericToInetAddress(String str) throws IllegalArgumentException {
        return InetAddress.parseNumericAddress(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void parcelInetAddress(Parcel parcel, InetAddress inetAddress, int i) {
        parcel.writeByteArray(inetAddress != null ? inetAddress.getAddress() : null);
    }

    public static Pair<InetAddress, Integer> parseIpAndMask(String str) {
        int i;
        InetAddress inetAddress = null;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        try {
            String[] split = str.split("/", 2);
            i = Integer.parseInt(split[1]);
            i2 = i;
            i3 = i;
            i4 = i;
            i5 = i;
            inetAddress = InetAddress.parseNumericAddress(split[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            i = i4;
        } catch (IllegalArgumentException e2) {
            i = i2;
        } catch (NullPointerException e3) {
            i = i5;
        } catch (NumberFormatException e4) {
            i = i3;
        }
        if (inetAddress == null || i == -1) {
            throw new IllegalArgumentException("Invalid IP address and mask " + str);
        }
        return new Pair<>(inetAddress, Integer.valueOf(i));
    }

    public static int prefixLengthToNetmaskInt(int i) throws IllegalArgumentException {
        if (i < 0 || i > 32) {
            throw new IllegalArgumentException("Invalid prefix length (0 <= prefix <= 32)");
        }
        return Integer.reverseBytes((-1) << (32 - i));
    }

    public static native boolean protectFromVpn(int i);

    public static native boolean releaseDhcpLease(String str);

    public static native int resetConnections(String str, int i);

    public static native boolean runDhcp(String str, DhcpResults dhcpResults);

    public static native boolean runDhcpRenew(String str, DhcpResults dhcpResults);

    public static native boolean stopDhcp(String str);

    public static String trimV4AddrZeros(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            String[] split = str.split("\\.");
            str2 = str;
            if (split.length == 4) {
                StringBuilder sb = new StringBuilder(16);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 4) {
                        return sb.toString();
                    }
                    str2 = str;
                    try {
                        if (split[i2].length() > 3) {
                            break;
                        }
                        sb.append(Integer.parseInt(split[i2]));
                        if (i2 < 3) {
                            sb.append('.');
                        }
                        i = i2 + 1;
                    } catch (NumberFormatException e) {
                        return str;
                    }
                }
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static InetAddress unparcelInetAddress(Parcel parcel) {
        byte[] createByteArray = parcel.createByteArray();
        if (createByteArray == null) {
            return null;
        }
        try {
            return InetAddress.getByAddress(createByteArray);
        } catch (UnknownHostException e) {
            return null;
        }
    }
}
