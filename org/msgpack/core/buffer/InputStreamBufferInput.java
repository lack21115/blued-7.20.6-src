package org.msgpack.core.buffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import org.msgpack.core.Preconditions;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/buffer/InputStreamBufferInput.class */
public class InputStreamBufferInput implements MessageBufferInput {
    private final byte[] buffer;
    private InputStream in;

    public InputStreamBufferInput(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public InputStreamBufferInput(InputStream inputStream, int i) {
        this.in = (InputStream) Preconditions.checkNotNull(inputStream, "input is null");
        this.buffer = new byte[i];
    }

    public static MessageBufferInput newBufferInput(InputStream inputStream) {
        FileChannel channel;
        Preconditions.checkNotNull(inputStream, "InputStream is null");
        return (!(inputStream instanceof FileInputStream) || (channel = ((FileInputStream) inputStream).getChannel()) == null) ? new InputStreamBufferInput(inputStream) : new ChannelBufferInput(channel);
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput
    public MessageBuffer next() throws IOException {
        int read = this.in.read(this.buffer);
        if (read == -1) {
            return null;
        }
        return MessageBuffer.wrap(this.buffer, 0, read);
    }

    public InputStream reset(InputStream inputStream) throws IOException {
        InputStream inputStream2 = this.in;
        this.in = inputStream;
        return inputStream2;
    }
}
