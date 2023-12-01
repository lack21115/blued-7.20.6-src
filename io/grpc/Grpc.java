package io.grpc;

import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketAddress;
import javax.net.ssl.SSLSession;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/Grpc.class */
public final class Grpc {
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_REMOTE_ADDR = Attributes.Key.create("remote-addr");
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_LOCAL_ADDR = Attributes.Key.create("local-addr");
    public static final Attributes.Key<SSLSession> TRANSPORT_ATTR_SSL_SESSION = Attributes.Key.create("ssl-session");

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Grpc$TransportAttr.class */
    public @interface TransportAttr {
    }

    private Grpc() {
    }
}
