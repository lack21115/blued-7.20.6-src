package org.json;

import com.igexin.push.core.b;
import com.loopj.android.http.AsyncHttpResponseHandler;

/* loaded from: source-2895416-dex2jar.jar:org/json/JSONTokener.class */
public class JSONTokener {

    /* renamed from: in  reason: collision with root package name */
    private final String f44093in;
    private int pos;

    public JSONTokener(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (str.startsWith(AsyncHttpResponseHandler.UTF8_BOM)) {
                str2 = str.substring(1);
            }
        }
        this.f44093in = str2;
    }

    public static int dehexchar(char c2) {
        if (c2 < '0' || c2 > '9') {
            if (c2 < 'A' || c2 > 'F') {
                if (c2 < 'a' || c2 > 'f') {
                    return -1;
                }
                return (c2 - 'a') + 10;
            }
            return (c2 - 'A') + 10;
        }
        return c2 - '0';
    }

    private int nextCleanInternal() throws JSONException {
        while (this.pos < this.f44093in.length()) {
            String str = this.f44093in;
            int i = this.pos;
            this.pos = i + 1;
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    break;
                case '#':
                    skipToEndOfLine();
                    break;
                case '/':
                    if (this.pos != this.f44093in.length()) {
                        switch (this.f44093in.charAt(this.pos)) {
                            case '*':
                                this.pos++;
                                int indexOf = this.f44093in.indexOf("*/", this.pos);
                                if (indexOf == -1) {
                                    throw syntaxError("Unterminated comment");
                                }
                                this.pos = indexOf + 2;
                                continue;
                            case '/':
                                this.pos++;
                                skipToEndOfLine();
                                continue;
                            default:
                                return charAt;
                        }
                    } else {
                        return charAt;
                    }
                default:
                    return charAt;
            }
        }
        return -1;
    }

    private String nextToInternal(String str) {
        int i = this.pos;
        while (this.pos < this.f44093in.length()) {
            char charAt = this.f44093in.charAt(this.pos);
            if (charAt == '\r' || charAt == '\n' || str.indexOf(charAt) != -1) {
                return this.f44093in.substring(i, this.pos);
            }
            this.pos++;
        }
        return this.f44093in.substring(i);
    }

    private JSONArray readArray() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        while (true) {
            boolean z2 = z;
            switch (nextCleanInternal()) {
                case -1:
                    throw syntaxError("Unterminated array");
                case 44:
                case 59:
                    jSONArray.put((Object) null);
                    z = true;
                    break;
                case 93:
                    if (z2) {
                        jSONArray.put((Object) null);
                        break;
                    }
                    break;
                default:
                    this.pos--;
                    jSONArray.put(nextValue());
                    switch (nextCleanInternal()) {
                        case 44:
                        case 59:
                            z = true;
                            break;
                        case 93:
                            break;
                        default:
                            throw syntaxError("Unterminated array");
                    }
            }
        }
        return jSONArray;
    }

    private char readEscapeCharacter() throws JSONException {
        String str = this.f44093in;
        int i = this.pos;
        this.pos = i + 1;
        char charAt = str.charAt(i);
        switch (charAt) {
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                if (this.pos + 4 > this.f44093in.length()) {
                    throw syntaxError("Unterminated escape sequence");
                }
                String substring = this.f44093in.substring(this.pos, this.pos + 4);
                this.pos += 4;
                return (char) Integer.parseInt(substring, 16);
            default:
                return charAt;
        }
    }

    private Object readLiteral() throws JSONException {
        String substring;
        int i;
        String nextToInternal = nextToInternal("{}[]/\\:,=;# \t\f");
        if (nextToInternal.length() == 0) {
            throw syntaxError("Expected literal value");
        }
        if (b.l.equalsIgnoreCase(nextToInternal)) {
            return JSONObject.NULL;
        }
        if ("true".equalsIgnoreCase(nextToInternal)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(nextToInternal)) {
            return Boolean.FALSE;
        }
        if (nextToInternal.indexOf(46) == -1) {
            if (nextToInternal.startsWith("0x") || nextToInternal.startsWith("0X")) {
                substring = nextToInternal.substring(2);
                i = 16;
            } else {
                i = 10;
                substring = nextToInternal;
                if (nextToInternal.startsWith("0")) {
                    i = 10;
                    substring = nextToInternal;
                    if (nextToInternal.length() > 1) {
                        substring = nextToInternal.substring(1);
                        i = 8;
                    }
                }
            }
            try {
                long parseLong = Long.parseLong(substring, i);
                return (parseLong > 2147483647L || parseLong < -2147483648L) ? Long.valueOf(parseLong) : Integer.valueOf((int) parseLong);
            } catch (NumberFormatException e) {
            }
        }
        try {
            return Double.valueOf(nextToInternal);
        } catch (NumberFormatException e2) {
            return new String(nextToInternal);
        }
    }

    private JSONObject readObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal != 125) {
            if (nextCleanInternal != -1) {
                this.pos--;
            }
            while (true) {
                Object nextValue = nextValue();
                if (!(nextValue instanceof String)) {
                    if (nextValue == null) {
                        throw syntaxError("Names cannot be null");
                    }
                    throw syntaxError("Names must be strings, but " + nextValue + " is of type " + nextValue.getClass().getName());
                }
                int nextCleanInternal2 = nextCleanInternal();
                if (nextCleanInternal2 == 58 || nextCleanInternal2 == 61) {
                    if (this.pos < this.f44093in.length() && this.f44093in.charAt(this.pos) == '>') {
                        this.pos++;
                    }
                    jSONObject.put((String) nextValue, nextValue());
                    switch (nextCleanInternal()) {
                        case 44:
                        case 59:
                            break;
                        case 125:
                            break;
                        default:
                            throw syntaxError("Unterminated object");
                    }
                } else {
                    throw syntaxError("Expected ':' after " + nextValue);
                }
            }
        } else {
            return jSONObject;
        }
    }

    private void skipToEndOfLine() {
        while (this.pos < this.f44093in.length()) {
            char charAt = this.f44093in.charAt(this.pos);
            if (charAt == '\r' || charAt == '\n') {
                this.pos++;
                return;
            }
            this.pos++;
        }
    }

    public void back() {
        int i = this.pos - 1;
        this.pos = i;
        if (i == -1) {
            this.pos = 0;
        }
    }

    public boolean more() {
        return this.pos < this.f44093in.length();
    }

    public char next() {
        if (this.pos < this.f44093in.length()) {
            String str = this.f44093in;
            int i = this.pos;
            this.pos = i + 1;
            return str.charAt(i);
        }
        return (char) 0;
    }

    public char next(char c2) throws JSONException {
        char next = next();
        if (next != c2) {
            throw syntaxError("Expected " + c2 + " but was " + next);
        }
        return next;
    }

    public String next(int i) throws JSONException {
        if (this.pos + i > this.f44093in.length()) {
            throw syntaxError(i + " is out of bounds");
        }
        String substring = this.f44093in.substring(this.pos, this.pos + i);
        this.pos += i;
        return substring;
    }

    public char nextClean() throws JSONException {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == -1) {
            return (char) 0;
        }
        return (char) nextCleanInternal;
    }

    public String nextString(char c2) throws JSONException {
        StringBuilder sb = null;
        int i = this.pos;
        while (this.pos < this.f44093in.length()) {
            String str = this.f44093in;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt == c2) {
                if (sb == null) {
                    return new String(this.f44093in.substring(i, this.pos - 1));
                }
                sb.append((CharSequence) this.f44093in, i, this.pos - 1);
                return sb.toString();
            } else if (charAt == '\\') {
                if (this.pos == this.f44093in.length()) {
                    throw syntaxError("Unterminated escape sequence");
                }
                StringBuilder sb2 = sb;
                if (sb == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append((CharSequence) this.f44093in, i, this.pos - 1);
                sb2.append(readEscapeCharacter());
                i = this.pos;
                sb = sb2;
            }
        }
        throw syntaxError("Unterminated string");
    }

    public String nextTo(char c2) {
        return nextToInternal(String.valueOf(c2)).trim();
    }

    public String nextTo(String str) {
        if (str == null) {
            throw new NullPointerException("excluded == null");
        }
        return nextToInternal(str).trim();
    }

    public Object nextValue() throws JSONException {
        int nextCleanInternal = nextCleanInternal();
        switch (nextCleanInternal) {
            case -1:
                throw syntaxError("End of input");
            case 34:
            case 39:
                return nextString((char) nextCleanInternal);
            case 91:
                return readArray();
            case 123:
                return readObject();
            default:
                this.pos--;
                return readLiteral();
        }
    }

    public void skipPast(String str) {
        int indexOf = this.f44093in.indexOf(str, this.pos);
        this.pos = indexOf == -1 ? this.f44093in.length() : str.length() + indexOf;
    }

    public char skipTo(char c2) {
        int indexOf = this.f44093in.indexOf(c2, this.pos);
        if (indexOf != -1) {
            this.pos = indexOf;
            return c2;
        }
        return (char) 0;
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + this);
    }

    public String toString() {
        return " at character " + this.pos + " of " + this.f44093in;
    }
}
