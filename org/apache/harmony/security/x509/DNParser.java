package org.apache.harmony.security.x509;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.harmony.security.utils.ObjectIdentifier;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.AttributeValue;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/DNParser.class */
public final class DNParser {
    private int beg;
    private final char[] chars;
    private byte[] encoded;
    private int end;
    private boolean hasQE;
    private int pos;

    public DNParser(String str) throws IOException {
        this.chars = str.toCharArray();
    }

    private String escapedAV() throws IOException {
        this.beg = this.pos;
        this.end = this.pos;
        while (this.pos < this.chars.length) {
            switch (this.chars[this.pos]) {
                case ' ':
                    int i = this.end;
                    this.pos++;
                    char[] cArr = this.chars;
                    int i2 = this.end;
                    this.end = i2 + 1;
                    cArr[i2] = ' ';
                    while (this.pos < this.chars.length && this.chars[this.pos] == ' ') {
                        char[] cArr2 = this.chars;
                        int i3 = this.end;
                        this.end = i3 + 1;
                        cArr2[i3] = ' ';
                        this.pos++;
                    }
                    if (this.pos != this.chars.length && this.chars[this.pos] != ',' && this.chars[this.pos] != '+' && this.chars[this.pos] != ';') {
                        break;
                    } else {
                        return new String(this.chars, this.beg, i - this.beg);
                    }
                    break;
                case '+':
                case ',':
                case ';':
                    return new String(this.chars, this.beg, this.end - this.beg);
                case '\\':
                    char[] cArr3 = this.chars;
                    int i4 = this.end;
                    this.end = i4 + 1;
                    cArr3[i4] = getEscaped();
                    this.pos++;
                    break;
                default:
                    char[] cArr4 = this.chars;
                    int i5 = this.end;
                    this.end = i5 + 1;
                    cArr4[i5] = this.chars[this.pos];
                    this.pos++;
                    break;
            }
        }
        return new String(this.chars, this.beg, this.end - this.beg);
    }

    private int getByte(int i) throws IOException {
        int i2;
        int i3;
        if (i + 1 >= this.chars.length) {
            throw new IOException("Invalid distinguished name string");
        }
        char c2 = this.chars[i];
        if (c2 >= '0' && c2 <= '9') {
            i2 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i2 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IOException("Invalid distinguished name string");
        } else {
            i2 = c2 - '7';
        }
        char c3 = this.chars[i + 1];
        if (c3 >= '0' && c3 <= '9') {
            i3 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i3 = c3 - 'W';
        } else if (c3 < 'A' || c3 > 'F') {
            throw new IOException("Invalid distinguished name string");
        } else {
            i3 = c3 - '7';
        }
        return (i2 << 4) + i3;
    }

    private char getEscaped() throws IOException {
        this.pos++;
        if (this.pos == this.chars.length) {
            throw new IOException("Invalid distinguished name string");
        }
        char c2 = this.chars[this.pos];
        char c3 = c2;
        switch (c2) {
            case ' ':
            case '#':
            case '%':
            case '*':
            case '+':
            case ',':
            case ';':
            case '<':
            case '=':
            case '>':
            case '_':
                break;
            case '\"':
            case '\\':
                this.hasQE = true;
                return c2;
            default:
                c3 = getUTF8();
                break;
        }
        return c3;
    }

    private String hexAV() throws IOException {
        int i;
        if (this.pos + 4 >= this.chars.length) {
            throw new IOException("Invalid distinguished name string");
        }
        this.beg = this.pos;
        this.pos++;
        while (this.pos != this.chars.length && this.chars[this.pos] != '+' && this.chars[this.pos] != ',' && this.chars[this.pos] != ';') {
            if (this.chars[this.pos] == ' ') {
                this.end = this.pos;
                this.pos++;
                while (this.pos < this.chars.length && this.chars[this.pos] == ' ') {
                    this.pos++;
                }
                i = this.end - this.beg;
                if (i >= 5 || (i & 1) == 0) {
                    throw new IOException("Invalid distinguished name string");
                }
                this.encoded = new byte[i / 2];
                int i2 = this.beg + 1;
                for (int i3 = 0; i3 < this.encoded.length; i3++) {
                    this.encoded[i3] = (byte) getByte(i2);
                    i2 += 2;
                }
                return new String(this.chars, this.beg, i);
            }
            if (this.chars[this.pos] >= 'A' && this.chars[this.pos] <= 'F') {
                char[] cArr = this.chars;
                int i4 = this.pos;
                cArr[i4] = (char) (cArr[i4] + ' ');
            }
            this.pos++;
        }
        this.end = this.pos;
        i = this.end - this.beg;
        if (i >= 5) {
        }
        throw new IOException("Invalid distinguished name string");
    }

    private String nextAT() throws IOException {
        this.hasQE = false;
        while (this.pos < this.chars.length && this.chars[this.pos] == ' ') {
            this.pos++;
        }
        if (this.pos == this.chars.length) {
            return null;
        }
        this.beg = this.pos;
        this.pos++;
        while (this.pos < this.chars.length && this.chars[this.pos] != '=' && this.chars[this.pos] != ' ') {
            this.pos++;
        }
        if (this.pos >= this.chars.length) {
            throw new IOException("Invalid distinguished name string");
        }
        this.end = this.pos;
        if (this.chars[this.pos] == ' ') {
            while (this.pos < this.chars.length && this.chars[this.pos] != '=' && this.chars[this.pos] == ' ') {
                this.pos++;
            }
            if (this.chars[this.pos] != '=' || this.pos == this.chars.length) {
                throw new IOException("Invalid distinguished name string");
            }
        }
        this.pos++;
        while (this.pos < this.chars.length && this.chars[this.pos] == ' ') {
            this.pos++;
        }
        if (this.end - this.beg > 4 && this.chars[this.beg + 3] == '.' && ((this.chars[this.beg] == 'O' || this.chars[this.beg] == 'o') && ((this.chars[this.beg + 1] == 'I' || this.chars[this.beg + 1] == 'i') && (this.chars[this.beg + 2] == 'D' || this.chars[this.beg + 2] == 'd')))) {
            this.beg += 4;
        }
        return new String(this.chars, this.beg, this.end - this.beg);
    }

    private String quotedAV() throws IOException {
        this.pos++;
        this.beg = this.pos;
        this.end = this.beg;
        while (this.pos != this.chars.length) {
            if (this.chars[this.pos] == '\"') {
                this.pos++;
                while (this.pos < this.chars.length && this.chars[this.pos] == ' ') {
                    this.pos++;
                }
                return new String(this.chars, this.beg, this.end - this.beg);
            }
            if (this.chars[this.pos] == '\\') {
                this.chars[this.end] = getEscaped();
            } else {
                this.chars[this.end] = this.chars[this.pos];
            }
            this.pos++;
            this.end++;
        }
        throw new IOException("Invalid distinguished name string");
    }

    protected char getUTF8() throws IOException {
        char c2;
        int i;
        int i2;
        int i3 = getByte(this.pos);
        this.pos++;
        if (i3 < 128) {
            c2 = (char) i3;
        } else {
            c2 = '?';
            if (i3 >= 192) {
                c2 = '?';
                if (i3 <= 247) {
                    if (i3 <= 223) {
                        i = 1;
                        i2 = i3 & 31;
                    } else if (i3 <= 239) {
                        i = 2;
                        i2 = i3 & 15;
                    } else {
                        i = 3;
                        i2 = i3 & 7;
                    }
                    int i4 = i2;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= i) {
                            return (char) i4;
                        }
                        this.pos++;
                        c2 = '?';
                        if (this.pos == this.chars.length) {
                            break;
                        }
                        c2 = '?';
                        if (this.chars[this.pos] != '\\') {
                            break;
                        }
                        this.pos++;
                        int i7 = getByte(this.pos);
                        this.pos++;
                        c2 = '?';
                        if ((i7 & 192) != 128) {
                            break;
                        }
                        i4 = (i4 << 6) + (i7 & 63);
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return c2;
    }

    public List<List<AttributeTypeAndValue>> parse() throws IOException {
        ArrayList arrayList = new ArrayList();
        String nextAT = nextAT();
        if (nextAT == null) {
            return arrayList;
        }
        ObjectIdentifier objectIdentifier = AttributeTypeAndValue.getObjectIdentifier(nextAT);
        ArrayList arrayList2 = new ArrayList();
        while (this.pos != this.chars.length) {
            switch (this.chars[this.pos]) {
                case '\"':
                    arrayList2.add(new AttributeTypeAndValue(objectIdentifier, new AttributeValue(quotedAV(), this.hasQE, objectIdentifier)));
                    break;
                case '#':
                    arrayList2.add(new AttributeTypeAndValue(objectIdentifier, new AttributeValue(hexAV(), this.encoded)));
                    break;
                case '+':
                case ',':
                case ';':
                    arrayList2.add(new AttributeTypeAndValue(objectIdentifier, new AttributeValue("", false, objectIdentifier)));
                    break;
                default:
                    arrayList2.add(new AttributeTypeAndValue(objectIdentifier, new AttributeValue(escapedAV(), this.hasQE, objectIdentifier)));
                    break;
            }
            if (this.pos >= this.chars.length) {
                arrayList.add(0, arrayList2);
                return arrayList;
            }
            if (this.chars[this.pos] == ',' || this.chars[this.pos] == ';') {
                arrayList.add(0, arrayList2);
                arrayList2 = new ArrayList();
            } else if (this.chars[this.pos] != '+') {
                throw new IOException("Invalid distinguished name string");
            }
            this.pos++;
            String nextAT2 = nextAT();
            if (nextAT2 == null) {
                throw new IOException("Invalid distinguished name string");
            }
            objectIdentifier = AttributeTypeAndValue.getObjectIdentifier(nextAT2);
        }
        arrayList2.add(new AttributeTypeAndValue(objectIdentifier, new AttributeValue("", false, objectIdentifier)));
        arrayList.add(0, arrayList2);
        return arrayList;
    }
}
