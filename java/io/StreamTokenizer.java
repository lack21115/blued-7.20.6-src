package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/StreamTokenizer.class */
public class StreamTokenizer {
    private static final byte TOKEN_COMMENT = 1;
    private static final byte TOKEN_DIGIT = 16;
    private static final byte TOKEN_QUOTE = 2;
    private static final byte TOKEN_WHITE = 4;
    private static final byte TOKEN_WORD = 8;
    public static final int TT_EOF = -1;
    public static final int TT_EOL = 10;
    public static final int TT_NUMBER = -2;
    private static final int TT_UNKNOWN = -4;
    public static final int TT_WORD = -3;
    private boolean forceLowercase;
    private Reader inReader;
    private InputStream inStream;
    private boolean isEOLSignificant;
    private boolean lastCr;
    private int lineNumber;
    public double nval;
    private int peekChar;
    private boolean pushBackToken;
    private boolean slashSlashComments;
    private boolean slashStarComments;
    public String sval;
    private byte[] tokenTypes;
    public int ttype;

    private StreamTokenizer() {
        this.ttype = -4;
        this.tokenTypes = new byte[256];
        this.lineNumber = 1;
        this.peekChar = -2;
        wordChars(65, 90);
        wordChars(97, 122);
        wordChars(160, 255);
        whitespaceChars(0, 32);
        commentChar(47);
        quoteChar(34);
        quoteChar(39);
        parseNumbers();
    }

    @Deprecated
    public StreamTokenizer(InputStream inputStream) {
        this();
        if (inputStream == null) {
            throw new NullPointerException("is == null");
        }
        this.inStream = inputStream;
    }

    public StreamTokenizer(Reader reader) {
        this();
        if (reader == null) {
            throw new NullPointerException("r == null");
        }
        this.inReader = reader;
    }

    private int read() throws IOException {
        return this.inStream == null ? this.inReader.read() : this.inStream.read();
    }

    public void commentChar(int i) {
        if (i < 0 || i >= this.tokenTypes.length) {
            return;
        }
        this.tokenTypes[i] = 1;
    }

    public void eolIsSignificant(boolean z) {
        this.isEOLSignificant = z;
    }

    public int lineno() {
        return this.lineNumber;
    }

    public void lowerCaseMode(boolean z) {
        this.forceLowercase = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:153:0x03aa, code lost:
        if (r4.slashStarComments != false) goto L185;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int nextToken() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.StreamTokenizer.nextToken():int");
    }

    public void ordinaryChar(int i) {
        if (i < 0 || i >= this.tokenTypes.length) {
            return;
        }
        this.tokenTypes[i] = 0;
    }

    public void ordinaryChars(int i, int i2) {
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > this.tokenTypes.length) {
            i4 = this.tokenTypes.length - 1;
        }
        while (i3 <= i4) {
            this.tokenTypes[i3] = 0;
            i3++;
        }
    }

    public void parseNumbers() {
        int i = 48;
        while (true) {
            int i2 = i;
            if (i2 > 57) {
                byte[] bArr = this.tokenTypes;
                bArr[46] = (byte) (bArr[46] | 16);
                byte[] bArr2 = this.tokenTypes;
                bArr2[45] = (byte) (bArr2[45] | 16);
                return;
            }
            byte[] bArr3 = this.tokenTypes;
            bArr3[i2] = (byte) (bArr3[i2] | 16);
            i = i2 + 1;
        }
    }

    public void pushBack() {
        this.pushBackToken = true;
    }

    public void quoteChar(int i) {
        if (i < 0 || i >= this.tokenTypes.length) {
            return;
        }
        this.tokenTypes[i] = 2;
    }

    public void resetSyntax() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
                return;
            }
            this.tokenTypes[i2] = 0;
            i = i2 + 1;
        }
    }

    public void slashSlashComments(boolean z) {
        this.slashSlashComments = z;
    }

    public void slashStarComments(boolean z) {
        this.slashStarComments = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Token[");
        switch (this.ttype) {
            case -3:
                sb.append(this.sval);
                break;
            case -2:
                sb.append("n=");
                sb.append(this.nval);
                break;
            case -1:
                sb.append("EOF");
                break;
            case 10:
                sb.append("EOL");
                break;
            default:
                if (this.ttype != -4 && this.tokenTypes[this.ttype] != 2) {
                    sb.append('\'');
                    sb.append((char) this.ttype);
                    sb.append('\'');
                    break;
                } else {
                    sb.append(this.sval);
                    break;
                }
                break;
        }
        sb.append("], line ");
        sb.append(this.lineNumber);
        return sb.toString();
    }

    public void whitespaceChars(int i, int i2) {
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > this.tokenTypes.length) {
            i4 = this.tokenTypes.length - 1;
        }
        while (i3 <= i4) {
            this.tokenTypes[i3] = 4;
            i3++;
        }
    }

    public void wordChars(int i, int i2) {
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > this.tokenTypes.length) {
            i4 = this.tokenTypes.length - 1;
        }
        while (i3 <= i4) {
            byte[] bArr = this.tokenTypes;
            bArr[i3] = (byte) (bArr[i3] | 8);
            i3++;
        }
    }
}
