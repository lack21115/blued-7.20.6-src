package io.grpc.internal;

import android.provider.ContactsContract;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.HttpConnectProxiedSocketAddress;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ClientTransportFactory.class */
public interface ClientTransportFactory extends Closeable {

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ClientTransportFactory$ClientTransportOptions.class */
    public static final class ClientTransportOptions {
        private ChannelLogger channelLogger;
        @Nullable
        private HttpConnectProxiedSocketAddress connectProxiedSocketAddr;
        @Nullable
        private String userAgent;
        private String authority = "unknown-authority";
        private Attributes eagAttributes = Attributes.EMPTY;

        public boolean equals(Object obj) {
            if (obj instanceof ClientTransportOptions) {
                ClientTransportOptions clientTransportOptions = (ClientTransportOptions) obj;
                boolean z = false;
                if (this.authority.equals(clientTransportOptions.authority)) {
                    z = false;
                    if (this.eagAttributes.equals(clientTransportOptions.eagAttributes)) {
                        z = false;
                        if (Objects.equal(this.userAgent, clientTransportOptions.userAgent)) {
                            z = false;
                            if (Objects.equal(this.connectProxiedSocketAddr, clientTransportOptions.connectProxiedSocketAddr)) {
                                z = true;
                            }
                        }
                    }
                }
                return z;
            }
            return false;
        }

        public String getAuthority() {
            return this.authority;
        }

        public ChannelLogger getChannelLogger() {
            return this.channelLogger;
        }

        public Attributes getEagAttributes() {
            return this.eagAttributes;
        }

        @Nullable
        public HttpConnectProxiedSocketAddress getHttpConnectProxiedSocketAddress() {
            return this.connectProxiedSocketAddr;
        }

        @Nullable
        public String getUserAgent() {
            return this.userAgent;
        }

        public int hashCode() {
            return Objects.hashCode(this.authority, this.eagAttributes, this.userAgent, this.connectProxiedSocketAddr);
        }

        public ClientTransportOptions setAuthority(String str) {
            this.authority = (String) Preconditions.checkNotNull(str, ContactsContract.Directory.DIRECTORY_AUTHORITY);
            return this;
        }

        public ClientTransportOptions setChannelLogger(ChannelLogger channelLogger) {
            this.channelLogger = channelLogger;
            return this;
        }

        public ClientTransportOptions setEagAttributes(Attributes attributes) {
            Preconditions.checkNotNull(attributes, "eagAttributes");
            this.eagAttributes = attributes;
            return this;
        }

        public ClientTransportOptions setHttpConnectProxiedSocketAddress(@Nullable HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress) {
            this.connectProxiedSocketAddr = httpConnectProxiedSocketAddress;
            return this;
        }

        public ClientTransportOptions setUserAgent(@Nullable String str) {
            this.userAgent = str;
            return this;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ScheduledExecutorService getScheduledExecutorService();

    ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger);
}
