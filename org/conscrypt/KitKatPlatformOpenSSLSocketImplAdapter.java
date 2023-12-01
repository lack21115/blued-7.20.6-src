package org.conscrypt;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/KitKatPlatformOpenSSLSocketImplAdapter.class */
public class KitKatPlatformOpenSSLSocketImplAdapter extends com.android.org.conscrypt.OpenSSLSocketImpl {
    private final AbstractConscryptSocket delegate;

    public KitKatPlatformOpenSSLSocketImplAdapter(AbstractConscryptSocket abstractConscryptSocket) throws IOException {
        super(null);
        this.delegate = abstractConscryptSocket;
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.delegate.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public void bind(SocketAddress socketAddress) throws IOException {
        this.delegate.bind(socketAddress);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, com.android.org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void clientCertificateRequested(byte[] bArr, byte[][] bArr2) throws CertificateEncodingException, SSLException {
        throw new RuntimeException("Shouldn't be here!");
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress) throws IOException {
        this.delegate.connect(socketAddress);
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress, int i) throws IOException {
        this.delegate.connect(socketAddress, i);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public byte[] getAlpnSelectedProtocol() {
        return this.delegate.getAlpnSelectedProtocol();
    }

    @Override // java.net.Socket
    public SocketChannel getChannel() {
        return this.delegate.getChannel();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public byte[] getChannelId() throws SSLException {
        return this.delegate.getChannelId();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public boolean getEnableSessionCreation() {
        return this.delegate.getEnableSessionCreation();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public String[] getEnabledCipherSuites() {
        return this.delegate.getEnabledCipherSuites();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public String[] getEnabledProtocols() {
        return this.delegate.getEnabledProtocols();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, java.net.Socket
    public FileDescriptor getFileDescriptor$() {
        return this.delegate.getFileDescriptor$();
    }

    @Override // java.net.Socket
    public InetAddress getInetAddress() {
        return this.delegate.getInetAddress();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, java.net.Socket
    public InputStream getInputStream() throws IOException {
        return this.delegate.getInputStream();
    }

    @Override // java.net.Socket
    public boolean getKeepAlive() throws SocketException {
        return this.delegate.getKeepAlive();
    }

    @Override // java.net.Socket
    public InetAddress getLocalAddress() {
        return this.delegate.getLocalAddress();
    }

    @Override // java.net.Socket
    public int getLocalPort() {
        return this.delegate.getLocalPort();
    }

    @Override // java.net.Socket
    public SocketAddress getLocalSocketAddress() {
        return this.delegate.getLocalSocketAddress();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public boolean getNeedClientAuth() {
        return this.delegate.getNeedClientAuth();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public byte[] getNpnSelectedProtocol() {
        return this.delegate.getNpnSelectedProtocol();
    }

    @Override // java.net.Socket
    public boolean getOOBInline() throws SocketException {
        return this.delegate.getOOBInline();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, java.net.Socket
    public OutputStream getOutputStream() throws IOException {
        return this.delegate.getOutputStream();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, java.net.Socket
    public int getPort() {
        return this.delegate.getPort();
    }

    @Override // java.net.Socket
    public int getReceiveBufferSize() throws SocketException {
        return this.delegate.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public SocketAddress getRemoteSocketAddress() {
        return this.delegate.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public boolean getReuseAddress() throws SocketException {
        return this.delegate.getReuseAddress();
    }

    @Override // javax.net.ssl.SSLSocket
    public SSLParameters getSSLParameters() {
        return this.delegate.getSSLParameters();
    }

    @Override // java.net.Socket
    public int getSendBufferSize() throws SocketException {
        return this.delegate.getSendBufferSize();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public SSLSession getSession() {
        return this.delegate.getSession();
    }

    @Override // java.net.Socket
    public int getSoLinger() throws SocketException {
        return this.delegate.getSoLinger();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, java.net.Socket
    public int getSoTimeout() throws SocketException {
        return this.delegate.getSoTimeout();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public int getSoWriteTimeout() throws SocketException {
        return this.delegate.getSoWriteTimeout();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public String[] getSupportedProtocols() {
        return this.delegate.getSupportedProtocols();
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() throws SocketException {
        return this.delegate.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public int getTrafficClass() throws SocketException {
        return this.delegate.getTrafficClass();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public boolean getUseClientMode() {
        return this.delegate.getUseClientMode();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public boolean getWantClientAuth() {
        return this.delegate.getWantClientAuth();
    }

    public void handshakeCompleted() {
        throw new RuntimeException("Shouldn't be here!");
    }

    @Override // java.net.Socket
    public boolean isBound() {
        return this.delegate.isBound();
    }

    @Override // java.net.Socket
    public boolean isClosed() {
        return this.delegate.isClosed();
    }

    @Override // java.net.Socket
    public boolean isConnected() {
        return this.delegate.isConnected();
    }

    @Override // java.net.Socket
    public boolean isInputShutdown() {
        return this.delegate.isInputShutdown();
    }

    @Override // java.net.Socket
    public boolean isOutputShutdown() {
        return this.delegate.isOutputShutdown();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.delegate.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, java.net.Socket
    public void sendUrgentData(int i) throws IOException {
        this.delegate.sendUrgentData(i);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public void setAlpnProtocols(byte[] bArr) {
        this.delegate.setAlpnProtocols(bArr);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public void setChannelIdEnabled(boolean z) {
        this.delegate.setChannelIdEnabled(z);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        this.delegate.setChannelIdPrivateKey(privateKey);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public void setEnableSessionCreation(boolean z) {
        this.delegate.setEnableSessionCreation(z);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public void setEnabledCipherSuites(String[] strArr) {
        this.delegate.setEnabledCipherSuites(strArr);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public void setEnabledProtocols(String[] strArr) {
        this.delegate.setEnabledProtocols(strArr);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public void setHandshakeTimeout(int i) throws SocketException {
        this.delegate.setHandshakeTimeout(i);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public void setHostname(String str) {
        this.delegate.setHostname(str);
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean z) throws SocketException {
        this.delegate.setKeepAlive(z);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public void setNeedClientAuth(boolean z) {
        this.delegate.setNeedClientAuth(z);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public void setNpnProtocols(byte[] bArr) {
        this.delegate.setNpnProtocols(bArr);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, java.net.Socket
    public void setOOBInline(boolean z) throws SocketException {
        this.delegate.setOOBInline(z);
    }

    @Override // java.net.Socket
    public void setPerformancePreferences(int i, int i2, int i3) {
        this.delegate.setPerformancePreferences(i, i2, i3);
    }

    @Override // java.net.Socket
    public void setReceiveBufferSize(int i) throws SocketException {
        this.delegate.setReceiveBufferSize(i);
    }

    @Override // java.net.Socket
    public void setReuseAddress(boolean z) throws SocketException {
        this.delegate.setReuseAddress(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public void setSSLParameters(SSLParameters sSLParameters) {
        this.delegate.setSSLParameters(sSLParameters);
    }

    @Override // java.net.Socket
    public void setSendBufferSize(int i) throws SocketException {
        this.delegate.setSendBufferSize(i);
    }

    @Override // java.net.Socket
    public void setSoLinger(boolean z, int i) throws SocketException {
        this.delegate.setSoLinger(z, i);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, java.net.Socket
    public void setSoTimeout(int i) throws SocketException {
        this.delegate.setSoTimeout(i);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public void setSoWriteTimeout(int i) throws SocketException {
        this.delegate.setSoWriteTimeout(i);
    }

    @Override // java.net.Socket
    public void setTcpNoDelay(boolean z) throws SocketException {
        this.delegate.setTcpNoDelay(z);
    }

    @Override // java.net.Socket
    public void setTrafficClass(int i) throws SocketException {
        this.delegate.setTrafficClass(i);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public void setUseClientMode(boolean z) {
        this.delegate.setUseClientMode(z);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl
    public void setUseSessionTickets(boolean z) {
        this.delegate.setUseSessionTickets(z);
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public void setWantClientAuth(boolean z) {
        this.delegate.setWantClientAuth(z);
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public void shutdownInput() throws IOException {
        this.delegate.shutdownInput();
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public void shutdownOutput() throws IOException {
        this.delegate.shutdownOutput();
    }

    @Override // com.android.org.conscrypt.OpenSSLSocketImpl, javax.net.ssl.SSLSocket
    public void startHandshake() throws IOException {
        this.delegate.startHandshake();
    }

    @Override // java.net.Socket
    public String toString() {
        return this.delegate.toString();
    }

    public void verifyCertificateChain(byte[][] bArr, String str) throws CertificateException {
        throw new RuntimeException("Shouldn't be here!");
    }
}
