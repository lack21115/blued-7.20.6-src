package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiSsid.class */
public class WifiSsid implements Parcelable {
    public static final Parcelable.Creator<WifiSsid> CREATOR = new Parcelable.Creator<WifiSsid>() { // from class: android.net.wifi.WifiSsid.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiSsid createFromParcel(Parcel parcel) {
            WifiSsid wifiSsid = new WifiSsid();
            int readInt = parcel.readInt();
            byte[] bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            wifiSsid.octets.write(bArr, 0, readInt);
            return wifiSsid;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiSsid[] newArray(int i) {
            return new WifiSsid[i];
        }
    };
    private static final int HEX_RADIX = 16;
    public static final String NONE = "<unknown ssid>";
    private static final String TAG = "WifiSsid";
    public final ByteArrayOutputStream octets;

    private WifiSsid() {
        this.octets = new ByteArrayOutputStream(32);
    }

    private void convertToBytes(String str) {
        int i;
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            switch (charAt) {
                case '\\':
                    i2++;
                    switch (str.charAt(i2)) {
                        case '\"':
                            this.octets.write(34);
                            i2++;
                            continue;
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                            int charAt2 = str.charAt(i2) - '0';
                            int i3 = i2 + 1;
                            int i4 = i3;
                            int i5 = charAt2;
                            if (str.charAt(i3) >= '0') {
                                i4 = i3;
                                i5 = charAt2;
                                if (str.charAt(i3) <= '7') {
                                    i5 = ((charAt2 * 8) + str.charAt(i3)) - 48;
                                    i4 = i3 + 1;
                                }
                            }
                            int i6 = i4;
                            int i7 = i5;
                            if (str.charAt(i4) >= '0') {
                                i6 = i4;
                                i7 = i5;
                                if (str.charAt(i4) <= '7') {
                                    i7 = ((i5 * 8) + str.charAt(i4)) - 48;
                                    i6 = i4 + 1;
                                }
                            }
                            this.octets.write(i7);
                            i2 = i6;
                            continue;
                        case '\\':
                            this.octets.write(92);
                            i2++;
                            continue;
                        case 'e':
                            this.octets.write(27);
                            i2++;
                            continue;
                        case 'n':
                            this.octets.write(10);
                            i2++;
                            continue;
                        case 'r':
                            this.octets.write(13);
                            i2++;
                            continue;
                        case 't':
                            this.octets.write(9);
                            i2++;
                            continue;
                        case 'x':
                            int i8 = i2 + 1;
                            try {
                                i = Integer.parseInt(str.substring(i8, i8 + 2), 16);
                            } catch (NumberFormatException e) {
                                i = -1;
                            }
                            if (i < 0) {
                                int digit = Character.digit(str.charAt(i8), 16);
                                i2 = i8;
                                if (digit < 0) {
                                    break;
                                } else {
                                    this.octets.write(digit);
                                    i2 = i8 + 1;
                                    break;
                                }
                            } else {
                                this.octets.write(i);
                                i2 = i8 + 2;
                                continue;
                            }
                    }
                default:
                    this.octets.write(charAt);
                    i2++;
                    break;
            }
        }
    }

    public static WifiSsid createFromAsciiEncoded(String str) {
        WifiSsid wifiSsid = new WifiSsid();
        wifiSsid.convertToBytes(str);
        return wifiSsid;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r5.startsWith("0X") != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.wifi.WifiSsid createFromHex(java.lang.String r5) {
        /*
            android.net.wifi.WifiSsid r0 = new android.net.wifi.WifiSsid
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r5
            if (r0 != 0) goto L10
        Ld:
            r0 = r9
            return r0
        L10:
            r0 = r5
            java.lang.String r1 = "0x"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L24
            r0 = r5
            r8 = r0
            r0 = r5
            java.lang.String r1 = "0X"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L2a
        L24:
            r0 = r5
            r1 = 2
            java.lang.String r0 = r0.substring(r1)
            r8 = r0
        L2a:
            r0 = 0
            r6 = r0
        L2c:
            r0 = r6
            r1 = r8
            int r1 = r1.length()
            r2 = 1
            int r1 = r1 - r2
            if (r0 >= r1) goto Ld
            r0 = r8
            r1 = r6
            r2 = r6
            r3 = 2
            int r2 = r2 + r3
            java.lang.String r0 = r0.substring(r1, r2)     // Catch: java.lang.NumberFormatException -> L54
            r1 = 16
            int r0 = java.lang.Integer.parseInt(r0, r1)     // Catch: java.lang.NumberFormatException -> L54
            r7 = r0
        L44:
            r0 = r9
            java.io.ByteArrayOutputStream r0 = r0.octets
            r1 = r7
            r0.write(r1)
            r0 = r6
            r1 = 2
            int r0 = r0 + r1
            r6 = r0
            goto L2c
        L54:
            r5 = move-exception
            r0 = 0
            r7 = r0
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.wifi.WifiSsid.createFromHex(java.lang.String):android.net.wifi.WifiSsid");
    }

    private boolean isArrayAllZeroes(byte[] bArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return true;
            }
            if (bArr[i2] != 0) {
                return false;
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getHexString() {
        String str = "0x";
        byte[] octets = getOctets();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.octets.size()) {
                return str;
            }
            str = str + String.format(Locale.US, "%02x", Byte.valueOf(octets[i2]));
            i = i2 + 1;
        }
    }

    public byte[] getOctets() {
        return this.octets.toByteArray();
    }

    public boolean isHidden() {
        return isArrayAllZeroes(this.octets.toByteArray());
    }

    public String toString() {
        byte[] byteArray = this.octets.toByteArray();
        if (this.octets.size() <= 0 || isArrayAllZeroes(byteArray)) {
            return "";
        }
        CharsetDecoder onUnmappableCharacter = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        CharBuffer allocate = CharBuffer.allocate(32);
        CoderResult decode = onUnmappableCharacter.decode(ByteBuffer.wrap(byteArray), allocate, true);
        allocate.flip();
        return decode.isError() ? NONE : allocate.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.octets.size());
        parcel.writeByteArray(this.octets.toByteArray());
    }
}
