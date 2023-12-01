package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/StringTokenizer.class */
public class StringTokenizer implements Enumeration<Object> {
    private String delimiters;
    private int position;
    private boolean returnDelimiters;
    private String string;

    public StringTokenizer(String str) {
        this(str, " \t\n\r\f", false);
    }

    public StringTokenizer(String str, String str2) {
        this(str, str2, false);
    }

    public StringTokenizer(String str, String str2, boolean z) {
        if (str == null) {
            throw new NullPointerException("string == null");
        }
        this.string = str;
        this.delimiters = str2;
        this.returnDelimiters = z;
        this.position = 0;
    }

    public int countTokens() {
        boolean z;
        int i = 0;
        boolean z2 = false;
        int i2 = this.position;
        int length = this.string.length();
        while (i2 < length) {
            if (this.delimiters.indexOf(this.string.charAt(i2), 0) >= 0) {
                int i3 = i;
                if (this.returnDelimiters) {
                    i3 = i + 1;
                }
                i = i3;
                z = z2;
                if (z2) {
                    i = i3 + 1;
                    z = false;
                }
            } else {
                z = true;
            }
            i2++;
            z2 = z;
        }
        int i4 = i;
        if (z2) {
            i4 = i + 1;
        }
        return i4;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return hasMoreTokens();
    }

    public boolean hasMoreTokens() {
        if (this.delimiters == null) {
            throw new NullPointerException("delimiters == null");
        }
        int length = this.string.length();
        if (this.position >= length) {
            return false;
        }
        if (this.returnDelimiters) {
            return true;
        }
        int i = this.position;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (this.delimiters.indexOf(this.string.charAt(i2), 0) == -1) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        return nextToken();
    }

    public String nextToken() {
        if (this.delimiters == null) {
            throw new NullPointerException("delimiters == null");
        }
        int i = this.position;
        int length = this.string.length();
        if (i < length) {
            int i2 = i;
            if (this.returnDelimiters) {
                if (this.delimiters.indexOf(this.string.charAt(this.position), 0) >= 0) {
                    String str = this.string;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    return String.valueOf(str.charAt(i3));
                }
                this.position++;
                while (this.position < length) {
                    if (this.delimiters.indexOf(this.string.charAt(this.position), 0) >= 0) {
                        return this.string.substring(i, this.position);
                    }
                    this.position++;
                }
                return this.string.substring(i);
            }
            while (i2 < length && this.delimiters.indexOf(this.string.charAt(i2), 0) >= 0) {
                i2++;
            }
            this.position = i2;
            if (i2 < length) {
                this.position++;
                while (this.position < length) {
                    if (this.delimiters.indexOf(this.string.charAt(this.position), 0) >= 0) {
                        return this.string.substring(i2, this.position);
                    }
                    this.position++;
                }
                return this.string.substring(i2);
            }
        }
        throw new NoSuchElementException();
    }

    public String nextToken(String str) {
        this.delimiters = str;
        return nextToken();
    }
}
