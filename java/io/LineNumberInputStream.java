package java.io;

import libcore.io.Streams;

@Deprecated
/* loaded from: source-2895416-dex2jar.jar:java/io/LineNumberInputStream.class */
public class LineNumberInputStream extends FilterInputStream {
    private int lastChar;
    private int lineNumber;
    private int markedLastChar;
    private int markedLineNumber;

    public LineNumberInputStream(InputStream inputStream) {
        super(inputStream);
        this.markedLineNumber = -1;
        this.lastChar = -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return (this.lastChar == -1 ? 0 : 1) + (this.f42254in.available() / 2);
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        this.f42254in.mark(i);
        this.markedLineNumber = this.lineNumber;
        this.markedLastChar = this.lastChar;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = this.lastChar;
        if (i == -1) {
            i = this.f42254in.read();
        } else {
            this.lastChar = -1;
        }
        int i2 = i;
        switch (i) {
            case 10:
                break;
            case 11:
            case 12:
            default:
                return i;
            case 13:
                this.lastChar = this.f42254in.read();
                i2 = 10;
                if (this.lastChar == 10) {
                    this.lastChar = -1;
                    i2 = 10;
                    break;
                }
                break;
        }
        this.lineNumber++;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        return r6;
     */
    @Override // java.io.FilterInputStream, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r5, int r6, int r7) throws java.io.IOException {
        /*
            r4 = this;
            r0 = r5
            int r0 = r0.length
            r1 = r6
            r2 = r7
            java.util.Arrays.checkOffsetAndCount(r0, r1, r2)
            r0 = 0
            r8 = r0
        La:
            r0 = r8
            r1 = r7
            if (r0 >= r1) goto L45
            r0 = r4
            int r0 = r0.read()     // Catch: java.io.IOException -> L28
            r9 = r0
            r0 = r9
            r1 = -1
            if (r0 != r1) goto L33
            r0 = r8
            r6 = r0
            r0 = r8
            if (r0 != 0) goto L26
            r0 = -1
            r6 = r0
        L26:
            r0 = r6
            return r0
        L28:
            r5 = move-exception
            r0 = r8
            r6 = r0
            r0 = r8
            if (r0 != 0) goto L26
            r0 = r5
            throw r0
        L33:
            r0 = r5
            r1 = r6
            r2 = r8
            int r1 = r1 + r2
            r2 = r9
            byte r2 = (byte) r2
            r0[r1] = r2
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto La
        L45:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.LineNumberInputStream.read(byte[], int, int):int");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        this.f42254in.reset();
        this.lineNumber = this.markedLineNumber;
        this.lastChar = this.markedLastChar;
    }

    public void setLineNumber(int i) {
        this.lineNumber = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        return Streams.skipByReading(this, j);
    }
}
