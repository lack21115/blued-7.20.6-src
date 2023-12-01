package java.nio.channels;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/Channels.class */
public final class Channels {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/nio/channels/Channels$ChannelInputStream.class */
    public static class ChannelInputStream extends InputStream {
        private final ReadableByteChannel channel;

        ChannelInputStream(ReadableByteChannel readableByteChannel) {
            if (readableByteChannel == null) {
                throw new NullPointerException("channel == null");
            }
            this.channel = readableByteChannel;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (this.channel instanceof FileChannel) {
                FileChannel fileChannel = (FileChannel) this.channel;
                long size = fileChannel.size() - fileChannel.position();
                if (size > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                return (int) size;
            }
            return super.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (this) {
                this.channel.close();
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int readSingleByte;
            synchronized (this) {
                readSingleByte = Streams.readSingleByte(this);
            }
            return readSingleByte;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read;
            synchronized (this) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
                Channels.checkBlocking(this.channel);
                read = this.channel.read(wrap);
            }
            return read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/nio/channels/Channels$ChannelOutputStream.class */
    public static class ChannelOutputStream extends OutputStream {
        private final WritableByteChannel channel;

        ChannelOutputStream(WritableByteChannel writableByteChannel) {
            if (writableByteChannel == null) {
                throw new NullPointerException("channel == null");
            }
            this.channel = writableByteChannel;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (this) {
                this.channel.close();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            synchronized (this) {
                write(new byte[]{(byte) i});
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            synchronized (this) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
                Channels.checkBlocking(this.channel);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < i2) {
                        i3 = i4 + this.channel.write(wrap);
                    }
                }
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/nio/channels/Channels$InputStreamChannel.class */
    private static class InputStreamChannel extends AbstractInterruptibleChannel implements ReadableByteChannel {
        private final InputStream inputStream;

        InputStreamChannel(InputStream inputStream) {
            if (inputStream == null) {
                throw new NullPointerException("inputStream == null");
            }
            this.inputStream = inputStream;
        }

        @Override // java.nio.channels.spi.AbstractInterruptibleChannel
        protected void implCloseChannel() throws IOException {
            this.inputStream.close();
        }

        @Override // java.nio.channels.ReadableByteChannel
        public int read(ByteBuffer byteBuffer) throws IOException {
            int read;
            boolean z = true;
            synchronized (this) {
                if (!isOpen()) {
                    throw new ClosedChannelException();
                }
                byte[] bArr = new byte[byteBuffer.remaining()];
                begin();
                read = this.inputStream.read(bArr);
                if (read < 0) {
                    z = false;
                }
                end(z);
                if (read > 0) {
                    byteBuffer.put(bArr, 0, read);
                }
            }
            return read;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/nio/channels/Channels$OutputStreamChannel.class */
    private static class OutputStreamChannel extends AbstractInterruptibleChannel implements WritableByteChannel {
        private final OutputStream outputStream;

        OutputStreamChannel(OutputStream outputStream) {
            if (outputStream == null) {
                throw new NullPointerException("outputStream == null");
            }
            this.outputStream = outputStream;
        }

        @Override // java.nio.channels.spi.AbstractInterruptibleChannel
        protected void implCloseChannel() throws IOException {
            this.outputStream.close();
        }

        @Override // java.nio.channels.WritableByteChannel
        public int write(ByteBuffer byteBuffer) throws IOException {
            int remaining;
            boolean z = true;
            synchronized (this) {
                if (!isOpen()) {
                    throw new ClosedChannelException();
                }
                remaining = byteBuffer.remaining();
                if (remaining == 0) {
                    remaining = 0;
                } else {
                    byte[] bArr = new byte[remaining];
                    byteBuffer.get(bArr);
                    begin();
                    this.outputStream.write(bArr, 0, remaining);
                    if (remaining < 0) {
                        z = false;
                    }
                    end(z);
                }
            }
            return remaining;
        }
    }

    private Channels() {
    }

    static void checkBlocking(Channel channel) {
        if ((channel instanceof SelectableChannel) && !((SelectableChannel) channel).isBlocking()) {
            throw new IllegalBlockingModeException();
        }
    }

    public static ReadableByteChannel newChannel(InputStream inputStream) {
        return new InputStreamChannel(inputStream);
    }

    public static WritableByteChannel newChannel(OutputStream outputStream) {
        return new OutputStreamChannel(outputStream);
    }

    public static InputStream newInputStream(ReadableByteChannel readableByteChannel) {
        return new ChannelInputStream(readableByteChannel);
    }

    public static OutputStream newOutputStream(WritableByteChannel writableByteChannel) {
        return new ChannelOutputStream(writableByteChannel);
    }

    public static Reader newReader(ReadableByteChannel readableByteChannel, String str) {
        if (str == null) {
            throw new NullPointerException("charsetName == null");
        }
        return newReader(readableByteChannel, Charset.forName(str).newDecoder(), -1);
    }

    public static Reader newReader(ReadableByteChannel readableByteChannel, CharsetDecoder charsetDecoder, int i) {
        return new InputStreamReader(new ChannelInputStream(readableByteChannel), charsetDecoder);
    }

    public static Writer newWriter(WritableByteChannel writableByteChannel, String str) {
        if (str == null) {
            throw new NullPointerException("charsetName == null");
        }
        return newWriter(writableByteChannel, Charset.forName(str).newEncoder(), -1);
    }

    public static Writer newWriter(WritableByteChannel writableByteChannel, CharsetEncoder charsetEncoder, int i) {
        return new OutputStreamWriter(new ChannelOutputStream(writableByteChannel), charsetEncoder);
    }
}
