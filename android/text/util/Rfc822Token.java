package android.text.util;

import com.blued.das.live.LiveProtos;

/* loaded from: source-9557208-dex2jar.jar:android/text/util/Rfc822Token.class */
public class Rfc822Token {
    private String mAddress;
    private String mComment;
    private String mName;

    public Rfc822Token(String str, String str2, String str3) {
        this.mName = str;
        this.mAddress = str2;
        this.mComment = str3;
    }

    public static String quoteComment(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt == '(' || charAt == ')' || charAt == '\\') {
                sb.append('\\');
            }
            sb.append(charAt);
            i = i2 + 1;
        }
    }

    public static String quoteName(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt == '\\' || charAt == '\"') {
                sb.append('\\');
            }
            sb.append(charAt);
            i = i2 + 1;
        }
    }

    public static String quoteNameIfNecessary(String str) {
        String str2;
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            str2 = str;
            if (i2 >= length) {
                break;
            }
            char charAt = str.charAt(i2);
            if ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && charAt != ' ' && (charAt < '0' || charAt > '9'))) {
                break;
            }
            i = i2 + 1;
        }
        str2 = '\"' + quoteName(str) + '\"';
        return str2;
    }

    private static boolean stringEquals(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Rfc822Token) {
            Rfc822Token rfc822Token = (Rfc822Token) obj;
            return stringEquals(this.mName, rfc822Token.mName) && stringEquals(this.mAddress, rfc822Token.mAddress) && stringEquals(this.mComment, rfc822Token.mComment);
        }
        return false;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getComment() {
        return this.mComment;
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        int i = 17;
        if (this.mName != null) {
            i = this.mName.hashCode() + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
        }
        int i2 = i;
        if (this.mAddress != null) {
            i2 = (i * 31) + this.mAddress.hashCode();
        }
        int i3 = i2;
        if (this.mComment != null) {
            i3 = (i2 * 31) + this.mComment.hashCode();
        }
        return i3;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setComment(String str) {
        this.mComment = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.mName != null && this.mName.length() != 0) {
            sb.append(quoteNameIfNecessary(this.mName));
            sb.append(' ');
        }
        if (this.mComment != null && this.mComment.length() != 0) {
            sb.append('(');
            sb.append(quoteComment(this.mComment));
            sb.append(") ");
        }
        if (this.mAddress != null && this.mAddress.length() != 0) {
            sb.append('<');
            sb.append(this.mAddress);
            sb.append('>');
        }
        return sb.toString();
    }
}
