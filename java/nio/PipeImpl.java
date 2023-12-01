package java.nio;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.Pipe;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import libcore.io.IoUtils;
import libcore.io.Libcore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/PipeImpl.class */
public final class PipeImpl extends Pipe {
    private final PipeSinkChannel sink;
    private final PipeSourceChannel source;

    /* loaded from: source-2895416-dex2jar.jar:java/nio/PipeImpl$PipeSinkChannel.class */
    private class PipeSinkChannel extends Pipe.SinkChannel implements FileDescriptorChannel {
        private final SocketChannel channel;
        private final FileDescriptor fd;

        private PipeSinkChannel(SelectorProvider selectorProvider, FileDescriptor fileDescriptor) throws IOException {
            super(selectorProvider);
            this.fd = fileDescriptor;
            this.channel = new SocketChannelImpl(selectorProvider, fileDescriptor);
        }

        @Override // java.nio.FileDescriptorChannel
        public FileDescriptor getFD() {
            return this.fd;
        }

        @Override // java.nio.channels.spi.AbstractSelectableChannel
        protected void implCloseSelectableChannel() throws IOException {
            this.channel.close();
        }

        @Override // java.nio.channels.spi.AbstractSelectableChannel
        protected void implConfigureBlocking(boolean z) throws IOException {
            IoUtils.setBlocking(getFD(), z);
        }

        @Override // java.nio.channels.WritableByteChannel
        public int write(ByteBuffer byteBuffer) throws IOException {
            return this.channel.write(byteBuffer);
        }

        @Override // java.nio.channels.GatheringByteChannel
        public long write(ByteBuffer[] byteBufferArr) throws IOException {
            return this.channel.write(byteBufferArr);
        }

        @Override // java.nio.channels.GatheringByteChannel
        public long write(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
            return this.channel.write(byteBufferArr, i, i2);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/nio/PipeImpl$PipeSourceChannel.class */
    private class PipeSourceChannel extends Pipe.SourceChannel implements FileDescriptorChannel {
        private final SocketChannel channel;
        private final FileDescriptor fd;

        private PipeSourceChannel(SelectorProvider selectorProvider, FileDescriptor fileDescriptor) throws IOException {
            super(selectorProvider);
            this.fd = fileDescriptor;
            this.channel = new SocketChannelImpl(selectorProvider, fileDescriptor);
        }

        @Override // java.nio.FileDescriptorChannel
        public FileDescriptor getFD() {
            return this.fd;
        }

        @Override // java.nio.channels.spi.AbstractSelectableChannel
        protected void implCloseSelectableChannel() throws IOException {
            this.channel.close();
        }

        @Override // java.nio.channels.spi.AbstractSelectableChannel
        protected void implConfigureBlocking(boolean z) throws IOException {
            IoUtils.setBlocking(getFD(), z);
        }

        @Override // java.nio.channels.ReadableByteChannel
        public int read(ByteBuffer byteBuffer) throws IOException {
            return this.channel.read(byteBuffer);
        }

        @Override // java.nio.channels.ScatteringByteChannel
        public long read(ByteBuffer[] byteBufferArr) throws IOException {
            return this.channel.read(byteBufferArr);
        }

        @Override // java.nio.channels.ScatteringByteChannel
        public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
            return this.channel.read(byteBufferArr, i, i2);
        }
    }

    public PipeImpl(SelectorProvider selectorProvider) throws IOException {
        try {
            FileDescriptor fileDescriptor = new FileDescriptor();
            FileDescriptor fileDescriptor2 = new FileDescriptor();
            Libcore.os.socketpair(OsConstants.AF_UNIX, OsConstants.SOCK_STREAM, 0, fileDescriptor, fileDescriptor2);
            this.sink = new PipeSinkChannel(selectorProvider, fileDescriptor);
            this.source = new PipeSourceChannel(selectorProvider, fileDescriptor2);
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    @Override // java.nio.channels.Pipe
    public Pipe.SinkChannel sink() {
        return this.sink;
    }

    @Override // java.nio.channels.Pipe
    public Pipe.SourceChannel source() {
        return this.source;
    }
}
