package android.speech.srec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-9557208-dex2jar.jar:android/speech/srec/WaveHeader.class */
public class WaveHeader {
    public static final short FORMAT_ALAW = 6;
    public static final short FORMAT_PCM = 1;
    public static final short FORMAT_ULAW = 7;
    private static final int HEADER_LENGTH = 44;
    private static final String TAG = "WaveHeader";
    private short mBitsPerSample;
    private short mFormat;
    private int mNumBytes;
    private short mNumChannels;
    private int mSampleRate;

    public WaveHeader() {
    }

    public WaveHeader(short s, short s2, int i, short s3, int i2) {
        this.mFormat = s;
        this.mSampleRate = i;
        this.mNumChannels = s2;
        this.mBitsPerSample = s3;
        this.mNumBytes = i2;
    }

    private static void readId(InputStream inputStream, String str) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return;
            }
            if (str.charAt(i2) != inputStream.read()) {
                throw new IOException(str + " tag not present");
            }
            i = i2 + 1;
        }
    }

    private static int readInt(InputStream inputStream) throws IOException {
        return inputStream.read() | (inputStream.read() << 8) | (inputStream.read() << 16) | (inputStream.read() << 24);
    }

    private static short readShort(InputStream inputStream) throws IOException {
        return (short) (inputStream.read() | (inputStream.read() << 8));
    }

    private static void writeId(OutputStream outputStream, String str) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return;
            }
            outputStream.write(str.charAt(i2));
            i = i2 + 1;
        }
    }

    private static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i >> 0);
        outputStream.write(i >> 8);
        outputStream.write(i >> 16);
        outputStream.write(i >> 24);
    }

    private static void writeShort(OutputStream outputStream, short s) throws IOException {
        outputStream.write(s >> 0);
        outputStream.write(s >> 8);
    }

    public short getBitsPerSample() {
        return this.mBitsPerSample;
    }

    public short getFormat() {
        return this.mFormat;
    }

    public int getNumBytes() {
        return this.mNumBytes;
    }

    public short getNumChannels() {
        return this.mNumChannels;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int read(InputStream inputStream) throws IOException {
        readId(inputStream, "RIFF");
        readInt(inputStream);
        readId(inputStream, "WAVE");
        readId(inputStream, "fmt ");
        if (16 != readInt(inputStream)) {
            throw new IOException("fmt chunk length not 16");
        }
        this.mFormat = readShort(inputStream);
        this.mNumChannels = readShort(inputStream);
        this.mSampleRate = readInt(inputStream);
        int readInt = readInt(inputStream);
        short readShort = readShort(inputStream);
        this.mBitsPerSample = readShort(inputStream);
        if (readInt != ((this.mNumChannels * this.mSampleRate) * this.mBitsPerSample) / 8) {
            throw new IOException("fmt.ByteRate field inconsistent");
        }
        if (readShort != (this.mNumChannels * this.mBitsPerSample) / 8) {
            throw new IOException("fmt.BlockAlign field inconsistent");
        }
        readId(inputStream, "data");
        this.mNumBytes = readInt(inputStream);
        return 44;
    }

    public WaveHeader setBitsPerSample(short s) {
        this.mBitsPerSample = s;
        return this;
    }

    public WaveHeader setFormat(short s) {
        this.mFormat = s;
        return this;
    }

    public WaveHeader setNumBytes(int i) {
        this.mNumBytes = i;
        return this;
    }

    public WaveHeader setNumChannels(short s) {
        this.mNumChannels = s;
        return this;
    }

    public WaveHeader setSampleRate(int i) {
        this.mSampleRate = i;
        return this;
    }

    public String toString() {
        return String.format("WaveHeader format=%d numChannels=%d sampleRate=%d bitsPerSample=%d numBytes=%d", Short.valueOf(this.mFormat), Short.valueOf(this.mNumChannels), Integer.valueOf(this.mSampleRate), Short.valueOf(this.mBitsPerSample), Integer.valueOf(this.mNumBytes));
    }

    public int write(OutputStream outputStream) throws IOException {
        writeId(outputStream, "RIFF");
        writeInt(outputStream, this.mNumBytes + 36);
        writeId(outputStream, "WAVE");
        writeId(outputStream, "fmt ");
        writeInt(outputStream, 16);
        writeShort(outputStream, this.mFormat);
        writeShort(outputStream, this.mNumChannels);
        writeInt(outputStream, this.mSampleRate);
        writeInt(outputStream, ((this.mNumChannels * this.mSampleRate) * this.mBitsPerSample) / 8);
        writeShort(outputStream, (short) ((this.mNumChannels * this.mBitsPerSample) / 8));
        writeShort(outputStream, this.mBitsPerSample);
        writeId(outputStream, "data");
        writeInt(outputStream, this.mNumBytes);
        return 44;
    }
}
