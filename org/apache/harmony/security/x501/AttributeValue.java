package org.apache.harmony.security.x501;

import java.io.IOException;
import java.util.Collection;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.DerInputStream;
import org.apache.harmony.security.utils.ObjectIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x501/AttributeValue.class */
public final class AttributeValue {
    public byte[] bytes;
    public byte[] encoded;
    public final String escapedString;
    private boolean hasConsecutiveSpaces;
    public boolean hasQE;
    private String hexString;
    public final String rawString;
    private String rfc2253String;
    private final int tag;
    public boolean wasEncoded = false;

    public AttributeValue(String str, boolean z, ObjectIdentifier objectIdentifier) {
        this.hasQE = z;
        this.rawString = str;
        this.escapedString = makeEscaped(this.rawString);
        this.tag = (objectIdentifier == AttributeTypeAndValue.EMAILADDRESS || objectIdentifier == AttributeTypeAndValue.DC) ? ASN1StringType.IA5STRING.id : isPrintableString(this.rawString) ? ASN1StringType.PRINTABLESTRING.id : ASN1StringType.UTF8STRING.id;
    }

    public AttributeValue(String str, byte[] bArr) {
        this.hexString = str;
        this.encoded = bArr;
        try {
            DerInputStream derInputStream = new DerInputStream(bArr);
            this.tag = derInputStream.tag;
            if (DirectoryString.ASN1.checkTag(this.tag)) {
                this.rawString = (String) DirectoryString.ASN1.decode(derInputStream);
                this.escapedString = makeEscaped(this.rawString);
                return;
            }
            this.rawString = str;
            this.escapedString = str;
        } catch (IOException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            illegalArgumentException.initCause(e);
            throw illegalArgumentException;
        }
    }

    public AttributeValue(String str, byte[] bArr, int i) {
        this.encoded = bArr;
        this.tag = i;
        if (str == null) {
            this.rawString = getHexString();
            this.escapedString = this.hexString;
            return;
        }
        this.rawString = str;
        this.escapedString = makeEscaped(str);
    }

    private static boolean isPrintableString(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return true;
            }
            char charAt = str.charAt(i2);
            if (charAt != ' ' && ((charAt < '\'' || charAt > ')') && ((charAt < '+' || charAt > ':') && charAt != '=' && charAt != '?' && ((charAt < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z'))))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private String makeEscaped(String str) {
        boolean z;
        boolean z2;
        int length = str.length();
        if (length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(length * 2);
        boolean z3 = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            switch (charAt) {
                case ' ':
                    if (i2 < length - 1) {
                        boolean z4 = str.charAt(i2 + 1) == ' ';
                        z2 = z3 || z4 || i2 == 0;
                        this.hasConsecutiveSpaces |= z4;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        sb.append('\\');
                    }
                    sb.append(' ');
                    z = z2;
                    break;
                case '\"':
                case '\\':
                    this.hasQE = true;
                    sb.append('\\');
                    sb.append(charAt);
                    z = z3;
                    break;
                case '#':
                case '+':
                case ',':
                case ';':
                case '<':
                case '=':
                case '>':
                    sb.append('\\');
                    sb.append(charAt);
                    z = z3;
                    break;
                default:
                    sb.append(charAt);
                    z = z3;
                    break;
            }
            z3 = z;
            if (z) {
                z3 = z;
                if (charAt != ' ') {
                    z3 = false;
                }
            }
            i = i2 + 1;
        }
    }

    public void appendQEString(StringBuilder sb) {
        sb.append('\"');
        if (this.hasQE) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.rawString.length()) {
                    break;
                }
                char charAt = this.rawString.charAt(i2);
                if (charAt == '\"' || charAt == '\\') {
                    sb.append('\\');
                }
                sb.append(charAt);
                i = i2 + 1;
            }
        } else {
            sb.append(this.rawString);
        }
        sb.append('\"');
    }

    public String getHexString() {
        if (this.hexString == null) {
            if (!this.wasEncoded) {
                if (this.tag == ASN1StringType.IA5STRING.id) {
                    this.encoded = ASN1StringType.IA5STRING.encode(this.rawString);
                } else if (this.tag == ASN1StringType.PRINTABLESTRING.id) {
                    this.encoded = ASN1StringType.PRINTABLESTRING.encode(this.rawString);
                } else {
                    this.encoded = ASN1StringType.UTF8STRING.encode(this.rawString);
                }
                this.wasEncoded = true;
            }
            StringBuilder sb = new StringBuilder((this.encoded.length * 2) + 1);
            sb.append('#');
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.encoded.length) {
                    break;
                }
                int i3 = (this.encoded[i2] >> 4) & 15;
                if (i3 < 10) {
                    sb.append((char) (i3 + 48));
                } else {
                    sb.append((char) (i3 + 87));
                }
                int i4 = this.encoded[i2] & 15;
                if (i4 < 10) {
                    sb.append((char) (i4 + 48));
                } else {
                    sb.append((char) (i4 + 87));
                }
                i = i2 + 1;
            }
            this.hexString = sb.toString();
        }
        return this.hexString;
    }

    public String getRFC2253String() {
        boolean z;
        int i;
        if (this.hasConsecutiveSpaces) {
            if (this.rfc2253String == null) {
                int length = this.escapedString.length() - 2;
                int i2 = length;
                while (i2 > 0) {
                    int i3 = length;
                    if (this.escapedString.charAt(i2) == '\\') {
                        i3 = length;
                        if (this.escapedString.charAt(i2 + 1) == ' ') {
                            i3 = i2 - 1;
                        }
                    }
                    i2 -= 2;
                    length = i3;
                }
                boolean z2 = true;
                StringBuilder sb = new StringBuilder(this.escapedString.length());
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.escapedString.length()) {
                        break;
                    }
                    char charAt = this.escapedString.charAt(i5);
                    if (charAt != '\\') {
                        sb.append(charAt);
                        i = i5;
                        z = false;
                    } else {
                        char charAt2 = this.escapedString.charAt(i5 + 1);
                        if (charAt2 == ' ') {
                            if (z2 || i5 > length) {
                                sb.append(charAt);
                            }
                            sb.append(charAt2);
                        } else {
                            sb.append(charAt);
                            sb.append(charAt2);
                            z2 = false;
                        }
                        int i6 = i5 + 1;
                        z = z2;
                        i = i6;
                    }
                    int i7 = i + 1;
                    z2 = z;
                    i4 = i7;
                }
                this.rfc2253String = sb.toString();
            }
            return this.rfc2253String;
        }
        return this.escapedString;
    }

    public int getTag() {
        return this.tag;
    }

    public Collection<?> getValues(ASN1Type aSN1Type) throws IOException {
        return (Collection) new ASN1SetOf(aSN1Type).decode(this.encoded);
    }

    public String makeCanonical() {
        int i;
        int length = this.rawString.length();
        if (length == 0) {
            return this.rawString;
        }
        StringBuilder sb = new StringBuilder(length * 2);
        int i2 = 0;
        if (this.rawString.charAt(0) == '#') {
            sb.append('\\');
            sb.append('#');
            i2 = 0 + 1;
        }
        while (i2 < length) {
            char charAt = this.rawString.charAt(i2);
            switch (charAt) {
                case ' ':
                    int length2 = sb.length();
                    if (length2 == 0) {
                        continue;
                    } else if (sb.charAt(length2 - 1) != ' ') {
                        sb.append(' ');
                    }
                    i2++;
                case '\"':
                case '+':
                case ',':
                case ';':
                case '<':
                case '>':
                case '\\':
                    sb.append('\\');
                    break;
            }
            sb.append(charAt);
            i2++;
        }
        int length3 = sb.length();
        while (true) {
            i = length3 - 1;
            if (i > -1 && sb.charAt(i) == ' ') {
                length3 = i;
            }
        }
        sb.setLength(i + 1);
        return sb.toString();
    }
}
