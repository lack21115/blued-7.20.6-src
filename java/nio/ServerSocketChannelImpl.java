package java.nio;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.NotYetBoundException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import libcore.io.IoUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/ServerSocketChannelImpl.class */
public final class ServerSocketChannelImpl extends ServerSocketChannel implements FileDescriptorChannel {
    private final Object acceptLock;
    private final ServerSocketAdapter socket;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/nio/ServerSocketChannelImpl$ServerSocketAdapter.class */
    public static class ServerSocketAdapter extends ServerSocket {
        private final ServerSocketChannelImpl channelImpl;

        ServerSocketAdapter(ServerSocketChannelImpl serverSocketChannelImpl) throws IOException {
            this.channelImpl = serverSocketChannelImpl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FileDescriptor getFD$() {
            return super.getImpl$().getFD$();
        }

        @Override // java.net.ServerSocket
        public Socket accept() throws IOException {
            if (isBound()) {
                SocketChannel accept = this.channelImpl.accept();
                if (accept == null) {
                    throw new IllegalBlockingModeException();
                }
                return accept.socket();
            }
            throw new IllegalBlockingModeException();
        }

        @Override // java.net.ServerSocket, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (this.channelImpl) {
                super.close();
                if (this.channelImpl.isOpen()) {
                    this.channelImpl.close();
                }
            }
        }

        @Override // java.net.ServerSocket
        public ServerSocketChannel getChannel() {
            return this.channelImpl;
        }

        public Socket implAccept(SocketChannelImpl socketChannelImpl) throws IOException {
            Socket socket = socketChannelImpl.socket();
            try {
                synchronized (this) {
                    super.implAccept(socket);
                    socketChannelImpl.onAccept(new InetSocketAddress(socket.getInetAddress(), socket.getPort()), false);
                }
                if (1 == 0) {
                    socket.close();
                }
                return socket;
            } catch (Throwable th) {
                if (0 == 0) {
                    socket.close();
                }
                throw th;
            }
        }
    }

    public ServerSocketChannelImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        this.acceptLock = new Object();
        this.socket = new ServerSocketAdapter(this);
    }

    private boolean shouldThrowSocketTimeoutExceptionFromAccept(SocketTimeoutException socketTimeoutException) {
        if (isBlocking()) {
            return true;
        }
        Throwable cause = socketTimeoutException.getCause();
        return ((cause instanceof ErrnoException) && ((ErrnoException) cause).errno == OsConstants.EAGAIN) ? false : true;
    }

    @Override // java.nio.channels.ServerSocketChannel
    public SocketChannel accept() throws IOException {
        if (isOpen()) {
            if (this.socket.isBound()) {
                SocketChannelImpl socketChannelImpl = new SocketChannelImpl(provider(), false);
                try {
                    begin();
                    synchronized (this.acceptLock) {
                        try {
                            this.socket.implAccept(socketChannelImpl);
                        } catch (SocketTimeoutException e) {
                            if (shouldThrowSocketTimeoutExceptionFromAccept(e)) {
                                throw e;
                            }
                        }
                    }
                    end(socketChannelImpl.isConnected());
                    if (socketChannelImpl.isConnected()) {
                        return socketChannelImpl;
                    }
                    return null;
                } catch (Throwable th) {
                    end(socketChannelImpl.isConnected());
                    throw th;
                }
            }
            throw new NotYetBoundException();
        }
        throw new ClosedChannelException();
    }

    @Override // java.nio.FileDescriptorChannel
    public FileDescriptor getFD() {
        return this.socket.getFD$();
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implCloseSelectableChannel() throws IOException {
        synchronized (this) {
            if (!this.socket.isClosed()) {
                this.socket.close();
            }
        }
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implConfigureBlocking(boolean z) throws IOException {
        IoUtils.setBlocking(this.socket.getFD$(), z);
    }

    @Override // java.nio.channels.ServerSocketChannel
    public ServerSocket socket() {
        return this.socket;
    }
}
