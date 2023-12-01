package org.apache.harmony.security.x509;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.Array;
import org.apache.harmony.security.x501.Name;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/GeneralName.class */
public final class GeneralName {
    public static final ASN1Choice ASN1;
    public static final int DIR_NAME = 4;
    public static final int DNS_NAME = 2;
    public static final int EDIP_NAME = 5;
    public static final int IP_ADDR = 7;
    private static final ASN1SequenceOf NAME_ASN1;
    public static final int OTHER_NAME = 0;
    public static final int REG_ID = 8;
    public static final int RFC822_NAME = 1;
    public static final int UR_ID = 6;
    public static final int X400_ADDR = 3;
    private static ASN1Type[] nameASN1 = new ASN1Type[9];
    private byte[] encoding;
    private Object name;
    private byte[] name_encoding;
    private int tag;

    static {
        nameASN1[0] = OtherName.ASN1;
        nameASN1[1] = ASN1StringType.IA5STRING;
        nameASN1[2] = ASN1StringType.IA5STRING;
        nameASN1[6] = ASN1StringType.IA5STRING;
        nameASN1[3] = ORAddress.ASN1;
        nameASN1[4] = Name.ASN1;
        nameASN1[5] = EDIPartyName.ASN1;
        nameASN1[7] = ASN1OctetString.getInstance();
        nameASN1[8] = ASN1Oid.getInstance();
        NAME_ASN1 = new ASN1SequenceOf(Name.ASN1) { // from class: org.apache.harmony.security.x509.GeneralName.1
            @Override // org.apache.harmony.security.asn1.ASN1SequenceOf, org.apache.harmony.security.asn1.ASN1Type
            public Object decode(BerInputStream berInputStream) throws IOException {
                return ((List) super.decode(berInputStream)).get(0);
            }
        };
        ASN1 = new ASN1Choice(new ASN1Type[]{new ASN1Implicit(0, OtherName.ASN1), new ASN1Implicit(1, ASN1StringType.IA5STRING), new ASN1Implicit(2, ASN1StringType.IA5STRING), new ASN1Implicit(3, ORAddress.ASN1), new ASN1Implicit(4, NAME_ASN1), new ASN1Implicit(5, EDIPartyName.ASN1), new ASN1Implicit(6, ASN1StringType.IA5STRING), new ASN1Implicit(7, ASN1OctetString.getInstance()), new ASN1Implicit(8, ASN1Oid.getInstance())}) { // from class: org.apache.harmony.security.x509.GeneralName.2
            @Override // org.apache.harmony.security.asn1.ASN1Type
            public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
                GeneralName generalName;
                switch (berInputStream.choiceIndex) {
                    case 0:
                        generalName = new GeneralName((OtherName) berInputStream.content);
                        break;
                    case 1:
                    case 2:
                        generalName = new GeneralName(berInputStream.choiceIndex, (String) berInputStream.content);
                        break;
                    case 3:
                        generalName = new GeneralName((ORAddress) berInputStream.content);
                        break;
                    case 4:
                        generalName = new GeneralName((Name) berInputStream.content);
                        break;
                    case 5:
                        generalName = new GeneralName((EDIPartyName) berInputStream.content);
                        break;
                    case 6:
                        String str = (String) berInputStream.content;
                        if (str.indexOf(":") != -1) {
                            generalName = new GeneralName(berInputStream.choiceIndex, str);
                            break;
                        } else {
                            throw new IOException("GeneralName: scheme is missing in URI: " + str);
                        }
                    case 7:
                        generalName = new GeneralName((byte[]) berInputStream.content);
                        break;
                    case 8:
                        generalName = new GeneralName(berInputStream.choiceIndex, ObjectIdentifier.toString((int[]) berInputStream.content));
                        break;
                    default:
                        throw new IOException("GeneralName: unknown tag: " + berInputStream.choiceIndex);
                }
                generalName.encoding = berInputStream.getEncoded();
                return generalName;
            }

            @Override // org.apache.harmony.security.asn1.ASN1Choice
            public int getIndex(Object obj) {
                return ((GeneralName) obj).tag;
            }

            @Override // org.apache.harmony.security.asn1.ASN1Choice
            public Object getObjectToEncode(Object obj) {
                return ((GeneralName) obj).name;
            }
        };
    }

    public GeneralName(int i, String str) throws IOException {
        if (str == null) {
            throw new IOException("name == null");
        }
        this.tag = i;
        switch (i) {
            case 0:
            case 3:
            case 5:
                throw new IOException("Unknown string representation for type [" + i + "]");
            case 1:
                this.name = str;
                return;
            case 2:
                checkDNS(str);
                this.name = str;
                return;
            case 4:
                this.name = new Name(str);
                return;
            case 6:
                checkURI(str);
                this.name = str;
                return;
            case 7:
                this.name = ipStrToBytes(str);
                return;
            case 8:
                this.name = oidStrToInts(str);
                return;
            default:
                throw new IOException("Unknown type: [" + i + "]");
        }
    }

    public GeneralName(int i, byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("name == null");
        }
        if (i < 0 || i > 8) {
            throw new IOException("GeneralName: unknown tag: " + i);
        }
        this.tag = i;
        this.name_encoding = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.name_encoding, 0, bArr.length);
        this.name = nameASN1[i].decode(this.name_encoding);
    }

    public GeneralName(Name name) {
        this.tag = 4;
        this.name = name;
    }

    public GeneralName(EDIPartyName eDIPartyName) {
        this.tag = 5;
        this.name = eDIPartyName;
    }

    public GeneralName(ORAddress oRAddress) {
        this.tag = 3;
        this.name = oRAddress;
    }

    public GeneralName(OtherName otherName) {
        this.tag = 0;
        this.name = otherName;
    }

    public GeneralName(byte[] bArr) throws IllegalArgumentException {
        this.tag = 7;
        this.name = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.name, 0, bArr.length);
    }

    public static void checkDNS(String str) throws IOException {
        String lowerCase = str.toLowerCase(Locale.US);
        int length = lowerCase.length();
        boolean z = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            char charAt = lowerCase.charAt(i2);
            if (z) {
                if ((charAt > 'z' || charAt < 'a') && ((charAt < '0' || charAt > '9') && charAt != '*')) {
                    throw new IOException("DNS name must start with a letter: " + str);
                }
                z = false;
            } else if ((charAt < 'a' || charAt > 'z') && !((charAt >= '0' && charAt <= '9') || charAt == '-' || charAt == '.' || charAt == '*')) {
                throw new IOException("Incorrect DNS name: " + str);
            } else {
                if (charAt != '.') {
                    continue;
                } else if (lowerCase.charAt(i2 - 1) == '-') {
                    throw new IOException("Incorrect DNS name: label ends with '-': " + str);
                } else {
                    z = true;
                }
            }
            i = i2 + 1;
        }
    }

    public static void checkURI(String str) throws IOException {
        try {
            URI uri = new URI(str);
            if (uri.getScheme() == null || uri.getRawSchemeSpecificPart().isEmpty()) {
                throw new IOException("No scheme or scheme-specific-part in uniformResourceIdentifier: " + str);
            }
            if (!uri.isAbsolute()) {
                throw new IOException("Relative uniformResourceIdentifier: " + str);
            }
        } catch (URISyntaxException e) {
            throw ((IOException) new IOException("Bad representation of uniformResourceIdentifier: " + str).initCause(e));
        }
    }

    public static String ipBytesToStr(byte[] bArr) {
        try {
            return InetAddress.getByAddress(null, bArr).getHostAddress();
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("Unexpected IP address: " + Arrays.toString(bArr));
        }
    }

    public static byte[] ipStrToBytes(String str) throws IOException {
        if (InetAddress.isNumeric(str)) {
            return InetAddress.getByName(str).getAddress();
        }
        throw new IOException("Not an IP address: " + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00aa, code lost:
        if (r7 >= 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c8, code lost:
        throw new java.io.IOException("OID should consist of no less than 2 components: " + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0101, code lost:
        return java.util.Arrays.copyOfRange(r0, 0, r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] oidStrToInts(java.lang.String r5) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.security.x509.GeneralName.oidStrToInts(java.lang.String):int[]");
    }

    public boolean equals(Object obj) {
        if (obj instanceof GeneralName) {
            GeneralName generalName = (GeneralName) obj;
            if (this.tag == generalName.tag) {
                switch (this.tag) {
                    case 0:
                    case 3:
                    case 4:
                    case 5:
                        return Arrays.equals(getEncoded(), generalName.getEncoded());
                    case 1:
                    case 2:
                    case 6:
                        return ((String) this.name).equalsIgnoreCase((String) generalName.getName());
                    case 7:
                        return Arrays.equals((byte[]) this.name, (byte[]) generalName.name);
                    case 8:
                        return Arrays.equals((int[]) this.name, (int[]) generalName.name);
                    default:
                        return false;
                }
            }
            return false;
        }
        return false;
    }

    public List<Object> getAsList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.tag));
        switch (this.tag) {
            case 0:
                arrayList.add(((OtherName) this.name).getEncoded());
                break;
            case 1:
            case 2:
            case 6:
                arrayList.add(this.name);
                break;
            case 3:
                arrayList.add(((ORAddress) this.name).getEncoded());
                break;
            case 4:
                arrayList.add(((Name) this.name).getName(X500Principal.RFC2253));
                break;
            case 5:
                arrayList.add(((EDIPartyName) this.name).getEncoded());
                break;
            case 7:
                arrayList.add(ipBytesToStr((byte[]) this.name));
                break;
            case 8:
                arrayList.add(ObjectIdentifier.toString((int[]) this.name));
                break;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public byte[] getEncodedName() {
        if (this.name_encoding == null) {
            this.name_encoding = nameASN1[this.tag].encode(this.name);
        }
        return this.name_encoding;
    }

    public Object getName() {
        return this.name;
    }

    public int getTag() {
        return this.tag;
    }

    public int hashCode() {
        switch (this.tag) {
            case 0:
            case 3:
            case 4:
            case 5:
                return Arrays.hashCode(getEncoded());
            case 1:
            case 2:
            case 6:
            case 7:
            case 8:
                return this.name.hashCode();
            default:
                return super.hashCode();
        }
    }

    public boolean isAcceptable(GeneralName generalName) {
        if (this.tag != generalName.getTag()) {
            return false;
        }
        switch (this.tag) {
            case 0:
            case 3:
            case 4:
            case 5:
            case 8:
                return Arrays.equals(getEncoded(), generalName.getEncoded());
            case 1:
                return ((String) generalName.getName()).toLowerCase(Locale.US).endsWith(((String) this.name).toLowerCase(Locale.US));
            case 2:
                String str = (String) this.name;
                String str2 = (String) generalName.getName();
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
                return str2.toLowerCase(Locale.US).endsWith("." + str.toLowerCase(Locale.US));
            case 6:
                String str3 = (String) this.name;
                int indexOf = str3.indexOf("://") + 3;
                int indexOf2 = str3.indexOf(47, indexOf);
                String substring = indexOf2 == -1 ? str3.substring(indexOf) : str3.substring(indexOf, indexOf2);
                String str4 = (String) generalName.getName();
                int indexOf3 = str4.indexOf("://") + 3;
                int indexOf4 = str4.indexOf(47, indexOf3);
                String substring2 = indexOf4 == -1 ? str4.substring(indexOf3) : str4.substring(indexOf3, indexOf4);
                return substring.startsWith(".") ? substring2.toLowerCase(Locale.US).endsWith(substring.toLowerCase(Locale.US)) : substring.equalsIgnoreCase(substring2);
            case 7:
                byte[] bArr = (byte[]) this.name;
                byte[] bArr2 = (byte[]) generalName.getName();
                int length = bArr.length;
                if (length != 4 && length != 8 && length != 16 && length != 32) {
                    return false;
                }
                int length2 = bArr2.length;
                if (length == length2) {
                    return Arrays.equals(bArr, bArr2);
                }
                if (length != length2 * 2) {
                    return false;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bArr2.length) {
                        return true;
                    }
                    int i3 = bArr2[i2] & 255;
                    byte b = bArr[i2];
                    byte b2 = bArr[i2 + length2];
                    if (i3 < (b & 255) || i3 > (b2 & 255)) {
                        return false;
                    }
                    i = i2 + 1;
                }
                break;
            default:
                return true;
        }
    }

    public String toString() {
        switch (this.tag) {
            case 0:
                return "otherName[0]: " + Array.getBytesAsString(getEncoded());
            case 1:
                return "rfc822Name[1]: " + this.name;
            case 2:
                return "dNSName[2]: " + this.name;
            case 3:
                return "x400Address[3]: " + Array.getBytesAsString(getEncoded());
            case 4:
                return "directoryName[4]: " + ((Name) this.name).getName(X500Principal.RFC2253);
            case 5:
                return "ediPartyName[5]: " + Array.getBytesAsString(getEncoded());
            case 6:
                return "uniformResourceIdentifier[6]: " + this.name;
            case 7:
                return "iPAddress[7]: " + ipBytesToStr((byte[]) this.name);
            case 8:
                return "registeredID[8]: " + ObjectIdentifier.toString((int[]) this.name);
            default:
                return "";
        }
    }
}
