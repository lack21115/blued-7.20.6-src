package javax.net.ssl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/DistinguishedNameParser.class */
public final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        this.dn = x500Principal.getName(X500Principal.RFC2253);
        this.length = this.dn.length();
    }

    private String escapedAV() {
        this.beg = this.pos;
        this.end = this.pos;
        while (this.pos < this.length) {
            switch (this.chars[this.pos]) {
                case ' ':
                    this.cur = this.end;
                    this.pos++;
                    char[] cArr = this.chars;
                    int i = this.end;
                    this.end = i + 1;
                    cArr[i] = ' ';
                    while (this.pos < this.length && this.chars[this.pos] == ' ') {
                        char[] cArr2 = this.chars;
                        int i2 = this.end;
                        this.end = i2 + 1;
                        cArr2[i2] = ' ';
                        this.pos++;
                    }
                    if (this.pos != this.length && this.chars[this.pos] != ',' && this.chars[this.pos] != '+' && this.chars[this.pos] != ';') {
                        break;
                    } else {
                        return new String(this.chars, this.beg, this.cur - this.beg);
                    }
                    break;
                case '+':
                case ',':
                case ';':
                    return new String(this.chars, this.beg, this.end - this.beg);
                case '\\':
                    char[] cArr3 = this.chars;
                    int i3 = this.end;
                    this.end = i3 + 1;
                    cArr3[i3] = getEscaped();
                    this.pos++;
                    break;
                default:
                    char[] cArr4 = this.chars;
                    int i4 = this.end;
                    this.end = i4 + 1;
                    cArr4[i4] = this.chars[this.pos];
                    this.pos++;
                    break;
            }
        }
        return new String(this.chars, this.beg, this.end - this.beg);
    }

    private int getByte(int i) {
        int i2;
        int i3;
        if (i + 1 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        char c = this.chars[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else if (c < 'A' || c > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        } else {
            i2 = c - '7';
        }
        char c2 = this.chars[i + 1];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        } else {
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    private char getEscaped() {
        this.pos++;
        if (this.pos == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        switch (this.chars[this.pos]) {
            case ' ':
            case '\"':
            case '#':
            case '%':
            case '*':
            case '+':
            case ',':
            case ';':
            case '<':
            case '=':
            case '>':
            case '\\':
            case '_':
                return this.chars[this.pos];
            default:
                return getUTF8();
        }
    }

    private char getUTF8() {
        char c;
        int i;
        int i2;
        int i3 = getByte(this.pos);
        this.pos++;
        if (i3 < 128) {
            c = (char) i3;
        } else {
            c = '?';
            if (i3 >= 192) {
                c = '?';
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
                        c = '?';
                        if (this.pos == this.length) {
                            break;
                        }
                        c = '?';
                        if (this.chars[this.pos] != '\\') {
                            break;
                        }
                        this.pos++;
                        int i7 = getByte(this.pos);
                        this.pos++;
                        c = '?';
                        if ((i7 & 192) != 128) {
                            break;
                        }
                        i4 = (i4 << 6) + (i7 & 63);
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return c;
    }

    private String hexAV() {
        int i;
        if (this.pos + 4 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.beg = this.pos;
        this.pos++;
        while (this.pos != this.length && this.chars[this.pos] != '+' && this.chars[this.pos] != ',' && this.chars[this.pos] != ';') {
            if (this.chars[this.pos] == ' ') {
                this.end = this.pos;
                this.pos++;
                while (this.pos < this.length && this.chars[this.pos] == ' ') {
                    this.pos++;
                }
                i = this.end - this.beg;
                if (i >= 5 || (i & 1) == 0) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.dn);
                }
                byte[] bArr = new byte[i / 2];
                int i2 = this.beg + 1;
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    bArr[i3] = (byte) getByte(i2);
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
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private String nextAT() {
        while (this.pos < this.length && this.chars[this.pos] == ' ') {
            this.pos++;
        }
        if (this.pos == this.length) {
            return null;
        }
        this.beg = this.pos;
        this.pos++;
        while (this.pos < this.length && this.chars[this.pos] != '=' && this.chars[this.pos] != ' ') {
            this.pos++;
        }
        if (this.pos >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.end = this.pos;
        if (this.chars[this.pos] == ' ') {
            while (this.pos < this.length && this.chars[this.pos] != '=' && this.chars[this.pos] == ' ') {
                this.pos++;
            }
            if (this.chars[this.pos] != '=' || this.pos == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
        this.pos++;
        while (this.pos < this.length && this.chars[this.pos] == ' ') {
            this.pos++;
        }
        if (this.end - this.beg > 4 && this.chars[this.beg + 3] == '.' && ((this.chars[this.beg] == 'O' || this.chars[this.beg] == 'o') && ((this.chars[this.beg + 1] == 'I' || this.chars[this.beg + 1] == 'i') && (this.chars[this.beg + 2] == 'D' || this.chars[this.beg + 2] == 'd')))) {
            this.beg += 4;
        }
        return new String(this.chars, this.beg, this.end - this.beg);
    }

    private String quotedAV() {
        this.pos++;
        this.beg = this.pos;
        this.end = this.beg;
        while (this.pos != this.length) {
            if (this.chars[this.pos] == '\"') {
                this.pos++;
                while (this.pos < this.length && this.chars[this.pos] == ' ') {
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
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    public String findMostSpecific(String str) {
        String str2;
        String nextAT;
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT2 = nextAT();
        String str3 = nextAT2;
        if (nextAT2 != null) {
            do {
                str2 = "";
                if (this.pos == this.length) {
                    return null;
                }
                switch (this.chars[this.pos]) {
                    case '\"':
                        str2 = quotedAV();
                        break;
                    case '#':
                        str2 = hexAV();
                        break;
                    case '+':
                    case ',':
                    case ';':
                        break;
                    default:
                        str2 = escapedAV();
                        break;
                }
                if (!str.equalsIgnoreCase(str3)) {
                    if (this.pos >= this.length) {
                        return null;
                    }
                    if (this.chars[this.pos] != ',' && this.chars[this.pos] != ';' && this.chars[this.pos] != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.dn);
                    }
                    this.pos++;
                    nextAT = nextAT();
                    str3 = nextAT;
                }
            } while (nextAT != null);
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        str2 = null;
        return str2;
    }

    public List<String> getAllMostSpecificFirst(String str) {
        String nextAT;
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String nextAT2 = nextAT();
        String str2 = nextAT2;
        List<String> list = emptyList;
        if (nextAT2 == null) {
            return emptyList;
        }
        do {
            ArrayList arrayList = list;
            if (this.pos < this.length) {
                String str3 = "";
                switch (this.chars[this.pos]) {
                    case '\"':
                        str3 = quotedAV();
                        break;
                    case '#':
                        str3 = hexAV();
                        break;
                    case '+':
                    case ',':
                    case ';':
                        break;
                    default:
                        str3 = escapedAV();
                        break;
                }
                arrayList = list;
                if (str.equalsIgnoreCase(str2)) {
                    arrayList = list;
                    if (list.isEmpty()) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(str3);
                }
                if (this.pos < this.length) {
                    if (this.chars[this.pos] != ',' && this.chars[this.pos] != ';' && this.chars[this.pos] != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.dn);
                    }
                    this.pos++;
                    nextAT = nextAT();
                    str2 = nextAT;
                    list = arrayList;
                }
            }
            return arrayList;
        } while (nextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
