package com.google.common.net;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/net/InetAddresses.class */
public final class InetAddresses {
    private static final int IPV4_PART_COUNT = 4;
    private static final int IPV6_PART_COUNT = 8;
    private static final Splitter IPV4_SPLITTER = Splitter.on('.').limit(4);
    private static final Splitter IPV6_SPLITTER = Splitter.on(':').limit(10);
    private static final Inet4Address LOOPBACK4 = (Inet4Address) forString("127.0.0.1");
    private static final Inet4Address ANY4 = (Inet4Address) forString("0.0.0.0");

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/net/InetAddresses$TeredoInfo.class */
    public static final class TeredoInfo {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;

        public TeredoInfo(@NullableDecl Inet4Address inet4Address, @NullableDecl Inet4Address inet4Address2, int i, int i2) {
            Preconditions.checkArgument(i >= 0 && i <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", i);
            Preconditions.checkArgument(i2 >= 0 && i2 <= 65535, "flags '%s' is out of range (0 <= flags <= 0xffff)", i2);
            this.server = (Inet4Address) MoreObjects.firstNonNull(inet4Address, InetAddresses.ANY4);
            this.client = (Inet4Address) MoreObjects.firstNonNull(inet4Address2, InetAddresses.ANY4);
            this.port = i;
            this.flags = i2;
        }

        public Inet4Address getClient() {
            return this.client;
        }

        public int getFlags() {
            return this.flags;
        }

        public int getPort() {
            return this.port;
        }

        public Inet4Address getServer() {
            return this.server;
        }
    }

    private InetAddresses() {
    }

    private static InetAddress bytesToInetAddress(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static int coerceToInteger(InetAddress inetAddress) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    private static void compressLongestRunOfZeroes(int[] iArr) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            int i8 = i7;
            if (i4 >= iArr.length + 1) {
                break;
            }
            if (i4 >= iArr.length || iArr[i4] != 0) {
                i = i5;
                i2 = i6;
                i3 = i8;
                if (i8 >= 0) {
                    int i9 = i4 - i8;
                    i = i5;
                    if (i9 > i5) {
                        i = i9;
                        i6 = i8;
                    }
                    i3 = -1;
                    i2 = i6;
                }
            } else {
                i = i5;
                i2 = i6;
                i3 = i8;
                if (i8 < 0) {
                    i3 = i4;
                    i = i5;
                    i2 = i6;
                }
            }
            i4++;
            i5 = i;
            i6 = i2;
            i7 = i3;
        }
        if (i5 >= 2) {
            Arrays.fill(iArr, i6, i5 + i6, -1);
        }
    }

    @NullableDecl
    private static String convertDottedQuadToHex(String str) {
        int lastIndexOf = str.lastIndexOf(58) + 1;
        String substring = str.substring(0, lastIndexOf);
        byte[] textToNumericFormatV4 = textToNumericFormatV4(str.substring(lastIndexOf));
        if (textToNumericFormatV4 == null) {
            return null;
        }
        String hexString = Integer.toHexString(((textToNumericFormatV4[0] & 255) << 8) | (textToNumericFormatV4[1] & 255));
        String hexString2 = Integer.toHexString((textToNumericFormatV4[3] & 255) | ((textToNumericFormatV4[2] & 255) << 8));
        return substring + hexString + ":" + hexString2;
    }

    public static InetAddress decrement(InetAddress inetAddress) {
        int i;
        byte[] address = inetAddress.getAddress();
        int length = address.length;
        while (true) {
            i = length - 1;
            if (i < 0 || address[i] != 0) {
                break;
            }
            address[i] = -1;
            length = i;
        }
        Preconditions.checkArgument(i >= 0, "Decrementing %s would wrap.", inetAddress);
        address[i] = (byte) (address[i] - 1);
        return bytesToInetAddress(address);
    }

    public static InetAddress forString(String str) {
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes != null) {
            return bytesToInetAddress(ipStringToBytes);
        }
        throw formatIllegalArgumentException("'%s' is not an IP string literal.", str);
    }

    public static InetAddress forUriString(String str) {
        InetAddress forUriStringNoThrow = forUriStringNoThrow(str);
        if (forUriStringNoThrow != null) {
            return forUriStringNoThrow;
        }
        throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", str);
    }

    @NullableDecl
    private static InetAddress forUriStringNoThrow(String str) {
        int i;
        Preconditions.checkNotNull(str);
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
            i = 16;
        } else {
            i = 4;
        }
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes == null || ipStringToBytes.length != i) {
            return null;
        }
        return bytesToInetAddress(ipStringToBytes);
    }

    private static IllegalArgumentException formatIllegalArgumentException(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    private static InetAddress fromBigInteger(BigInteger bigInteger, boolean z) {
        Preconditions.checkArgument(bigInteger.signum() >= 0, "BigInteger must be greater than or equal to 0");
        int i = z ? 16 : 4;
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i];
        int max = Math.max(0, byteArray.length - i);
        int length = byteArray.length - max;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= max) {
                System.arraycopy((Object) byteArray, max, (Object) bArr, i - length, length);
                try {
                    return InetAddress.getByAddress(bArr);
                } catch (UnknownHostException e) {
                    throw new AssertionError(e);
                }
            } else if (byteArray[i3] != 0) {
                throw formatIllegalArgumentException("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", Integer.valueOf(i), bigInteger);
            } else {
                i2 = i3 + 1;
            }
        }
    }

    public static Inet4Address fromIPv4BigInteger(BigInteger bigInteger) {
        return (Inet4Address) fromBigInteger(bigInteger, false);
    }

    public static Inet6Address fromIPv6BigInteger(BigInteger bigInteger) {
        return (Inet6Address) fromBigInteger(bigInteger, true);
    }

    public static Inet4Address fromInteger(int i) {
        return getInet4Address(Ints.toByteArray(i));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return InetAddress.getByAddress(bArr2);
            }
            bArr2[i2] = bArr[(bArr.length - i2) - 1];
            i = i2 + 1;
        }
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress inetAddress) {
        boolean z;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 15) {
                z = true;
                break;
            } else if (address[i2] != 0) {
                z = false;
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (z && address[15] == 1) {
            return LOOPBACK4;
        }
        if (z && address[15] == 0) {
            return ANY4;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        int asInt = Hashing.murmur3_32().hashLong(hasEmbeddedIPv4ClientAddress(inet6Address) ? getEmbeddedIPv4ClientAddress(inet6Address).hashCode() : ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong()).asInt() | (-536870912);
        int i3 = asInt;
        if (asInt == -1) {
            i3 = -2;
        }
        return getInet4Address(Ints.toByteArray(i3));
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", toAddrString(inet6Address));
    }

    private static Inet4Address getInet4Address(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) bytesToInetAddress(bArr);
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static TeredoInfo getTeredoInfo(Inet6Address inet6Address) {
        Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", toAddrString(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address inet4Address = getInet4Address(Arrays.copyOfRange(address, 4, 8));
        short readShort = ByteStreams.newDataInput(address, 8).readShort();
        short readShort2 = ByteStreams.newDataInput(address, 10).readShort();
        byte[] copyOfRange = Arrays.copyOfRange(address, 12, 16);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= copyOfRange.length) {
                return new TeredoInfo(inet4Address, getInet4Address(copyOfRange), 65535 & readShort2, readShort & 65535);
            }
            copyOfRange[i2] = copyOfRange[i2];
            i = i2 + 1;
        }
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        return isCompatIPv4Address(inet6Address) || is6to4Address(inet6Address) || isTeredoAddress(inet6Address);
    }

    private static String hextetsToIPv6String(int[] iArr) {
        StringBuilder sb = new StringBuilder(39);
        int i = 0;
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (i >= iArr.length) {
                return sb.toString();
            }
            boolean z3 = iArr[i] >= 0;
            if (z3) {
                if (z2) {
                    sb.append(':');
                }
                sb.append(Integer.toHexString(iArr[i]));
            } else if (i == 0 || z2) {
                sb.append("::");
            }
            i++;
            z = z3;
        }
    }

    public static InetAddress increment(InetAddress inetAddress) {
        int i;
        boolean z;
        byte[] address = inetAddress.getAddress();
        int length = address.length;
        while (true) {
            i = length - 1;
            z = false;
            if (i < 0 || address[i] != -1) {
                break;
            }
            address[i] = 0;
            length = i;
        }
        if (i >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "Incrementing %s would wrap.", inetAddress);
        address[i] = (byte) (address[i] + 1);
        return bytesToInetAddress(address);
    }

    @NullableDecl
    private static byte[] ipStringToBytes(String str) {
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (i >= str.length()) {
                i = -1;
                break;
            }
            char charAt = str.charAt(i);
            if (charAt == '.') {
                z = true;
            } else if (charAt == ':') {
                if (z) {
                    return null;
                }
                z2 = true;
            } else if (charAt == '%') {
                break;
            } else if (Character.digit(charAt, 16) == -1) {
                return null;
            }
            i++;
        }
        if (!z2) {
            if (z) {
                return textToNumericFormatV4(str);
            }
            return null;
        }
        String str2 = str;
        if (z) {
            String convertDottedQuadToHex = convertDottedQuadToHex(str);
            str2 = convertDottedQuadToHex;
            if (convertDottedQuadToHex == null) {
                return null;
            }
        }
        String str3 = str2;
        if (i != -1) {
            str3 = str2.substring(0, i);
        }
        return textToNumericFormatV6(str3);
    }

    public static boolean is6to4Address(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        boolean z = false;
        if (address[0] == 32) {
            z = false;
            if (address[1] == 2) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isCompatIPv4Address(Inet6Address inet6Address) {
        if (inet6Address.isIPv4CompatibleAddress()) {
            byte[] address = inet6Address.getAddress();
            if (address[12] == 0 && address[13] == 0 && address[14] == 0) {
                return (address[15] == 0 || address[15] == 1) ? false : true;
            }
            return true;
        }
        return false;
    }

    public static boolean isInetAddress(String str) {
        return ipStringToBytes(str) != null;
    }

    public static boolean isIsatapAddress(Inet6Address inet6Address) {
        if (isTeredoAddress(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if ((address[8] | 3) != 3) {
            return false;
        }
        boolean z = false;
        if (address[9] == 0) {
            z = false;
            if (address[10] == 94) {
                z = false;
                if (address[11] == -2) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean isMappedIPv4Address(String str) {
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes == null || ipStringToBytes.length != 16) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                for (int i3 = 10; i3 < 12; i3++) {
                    if (ipStringToBytes[i3] != -1) {
                        return false;
                    }
                }
                return true;
            } else if (ipStringToBytes[i2] != 0) {
                return false;
            } else {
                i = i2 + 1;
            }
        }
    }

    public static boolean isMaximum(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= address.length) {
                return true;
            }
            if (address[i2] != -1) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isTeredoAddress(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        boolean z = false;
        if (address[0] == 32) {
            z = false;
            if (address[1] == 1) {
                z = false;
                if (address[2] == 0) {
                    z = false;
                    if (address[3] == 0) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static boolean isUriInetAddress(String str) {
        return forUriStringNoThrow(str) != null;
    }

    private static short parseHextet(String str) {
        int parseInt = Integer.parseInt(str, 16);
        if (parseInt <= 65535) {
            return (short) parseInt;
        }
        throw new NumberFormatException();
    }

    private static byte parseOctet(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt > 255 || (str.startsWith("0") && str.length() > 1)) {
            throw new NumberFormatException();
        }
        return (byte) parseInt;
    }

    @NullableDecl
    private static byte[] textToNumericFormatV4(String str) {
        int i;
        byte[] bArr = new byte[4];
        try {
            Iterator<String> it = IPV4_SPLITTER.split(str).iterator();
            int i2 = 0;
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                bArr[i] = parseOctet(it.next());
                i2 = i + 1;
            }
            if (i == 4) {
                return bArr;
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @NullableDecl
    private static byte[] textToNumericFormatV6(String str) {
        int size;
        int i;
        int i2;
        int i3;
        List<String> splitToList = IPV6_SPLITTER.splitToList(str);
        if (splitToList.size() < 3 || splitToList.size() > 9) {
            return null;
        }
        int i4 = -1;
        int i5 = 1;
        while (i5 < splitToList.size() - 1) {
            int i6 = i4;
            if (splitToList.get(i5).length() == 0) {
                if (i4 >= 0) {
                    return null;
                }
                i6 = i5;
            }
            i5++;
            i4 = i6;
        }
        if (i4 >= 0) {
            int size2 = (splitToList.size() - i4) - 1;
            if (splitToList.get(0).length() == 0) {
                int i7 = i4 - 1;
                i3 = i7;
                if (i7 != 0) {
                    return null;
                }
            } else {
                i3 = i4;
            }
            i = size2;
            size = i3;
            if (((String) Iterables.getLast(splitToList)).length() == 0) {
                int i8 = size2 - 1;
                i = i8;
                size = i3;
                if (i8 != 0) {
                    return null;
                }
            }
        } else {
            size = splitToList.size();
            i = 0;
        }
        int i9 = 8 - (size + i);
        if (i4 >= 0) {
            if (i9 < 1) {
                return null;
            }
        } else if (i9 != 0) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(16);
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= size) {
                break;
            }
            try {
                allocate.putShort(parseHextet(splitToList.get(i11)));
                i10 = i11 + 1;
            } catch (NumberFormatException e) {
                return null;
            }
            return null;
        }
        int i12 = 0;
        while (true) {
            int i13 = i12;
            if (i13 >= i9) {
                break;
            }
            allocate.putShort((short) 0);
            i12 = i13 + 1;
        }
        for (i2 = i; i2 > 0; i2--) {
            allocate.putShort(parseHextet(splitToList.get(splitToList.size() - i2)));
        }
        return allocate.array();
    }

    public static String toAddrString(InetAddress inetAddress) {
        Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.checkArgument(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                compressLongestRunOfZeroes(iArr);
                return hextetsToIPv6String(iArr);
            }
            int i3 = i2 * 2;
            iArr[i2] = Ints.fromBytes((byte) 0, (byte) 0, address[i3], address[i3 + 1]);
            i = i2 + 1;
        }
    }

    public static BigInteger toBigInteger(InetAddress inetAddress) {
        return new BigInteger(1, inetAddress.getAddress());
    }

    public static String toUriString(InetAddress inetAddress) {
        if (inetAddress instanceof Inet6Address) {
            return "[" + toAddrString(inetAddress) + "]";
        }
        return toAddrString(inetAddress);
    }
}
