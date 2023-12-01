package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/LineNumberReader.class */
public class LineNumberReader extends BufferedReader {
    private boolean lastWasCR;
    private int lineNumber;
    private boolean markedLastWasCR;
    private int markedLineNumber;

    public LineNumberReader(Reader reader) {
        super(reader);
        this.markedLineNumber = -1;
    }

    public LineNumberReader(Reader reader, int i) {
        super(reader, i);
        this.markedLineNumber = -1;
    }

    public int getLineNumber() {
        int i;
        synchronized (this.lock) {
            i = this.lineNumber;
        }
        return i;
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public void mark(int i) throws IOException {
        synchronized (this.lock) {
            super.mark(i);
            this.markedLineNumber = this.lineNumber;
            this.markedLastWasCR = this.lastWasCR;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.io.BufferedReader, java.io.Reader
    public int read() throws IOException {
        int i;
        synchronized (this.lock) {
            int read = super.read();
            int i2 = read;
            if (read == 10) {
                i2 = read;
                if (this.lastWasCR) {
                    i2 = super.read();
                }
            }
            this.lastWasCR = false;
            i = i2;
            int i3 = i2;
            switch (i2) {
                case 10:
                    this.lineNumber++;
                    i = i3;
                    break;
                case 11:
                case 12:
                    break;
                case 13:
                    i3 = 10;
                    this.lastWasCR = true;
                    this.lineNumber++;
                    i = i3;
                    break;
                default:
                    i = i2;
                    break;
            }
        }
        return i;
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        synchronized (this.lock) {
            int read = super.read(cArr, i, i2);
            if (read == -1) {
                return -1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= read) {
                    return read;
                }
                char c2 = cArr[i + i4];
                if (c2 == '\r') {
                    this.lineNumber++;
                    this.lastWasCR = true;
                } else if (c2 == '\n') {
                    if (!this.lastWasCR) {
                        this.lineNumber++;
                    }
                    this.lastWasCR = false;
                } else {
                    this.lastWasCR = false;
                }
                i3 = i4 + 1;
            }
        }
    }

    @Override // java.io.BufferedReader
    public String readLine() throws IOException {
        String readLine;
        synchronized (this.lock) {
            if (this.lastWasCR) {
                chompNewline();
                this.lastWasCR = false;
            }
            readLine = super.readLine();
            if (readLine != null) {
                this.lineNumber++;
            }
        }
        return readLine;
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public void reset() throws IOException {
        synchronized (this.lock) {
            super.reset();
            this.lineNumber = this.markedLineNumber;
            this.lastWasCR = this.markedLastWasCR;
        }
    }

    public void setLineNumber(int i) {
        synchronized (this.lock) {
            this.lineNumber = i;
        }
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("charCount < 0: " + j);
        }
        synchronized (this.lock) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= j) {
                    return j;
                }
                if (read() == -1) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
    }
}
