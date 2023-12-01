package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.squareup.okhttp.TlsVersion;
import io.grpc.InternalChannelz;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.Header;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/Utils.class */
public class Utils {
    static final int CONNECTION_STREAM_ID = 0;
    static final int DEFAULT_WINDOW_SIZE = 65535;
    static final float DEFAULT_WINDOW_UPDATE_RATIO = 0.5f;
    private static final Logger log = Logger.getLogger(Utils.class.getName());

    private Utils() {
    }

    public static Metadata convertHeaders(List<Header> list) {
        return InternalMetadata.newMetadata(convertHeadersToArray(list));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [byte[], byte[][]] */
    @CheckReturnValue
    private static byte[][] convertHeadersToArray(List<Header> list) {
        ?? r0 = new byte[list.size() * 2];
        int i = 0;
        for (Header header : list) {
            int i2 = i + 1;
            r0[i] = header.name.toByteArray();
            i = i2 + 1;
            r0[i2] = header.value.toByteArray();
        }
        return TransportFrameUtil.toRawSerializedHeaders(r0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConnectionSpec convertSpec(com.squareup.okhttp.ConnectionSpec connectionSpec) {
        Preconditions.checkArgument(connectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
        List tlsVersions = connectionSpec.tlsVersions();
        int size = tlsVersions.size();
        String[] strArr = new String[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            strArr[i2] = ((TlsVersion) tlsVersions.get(i2)).javaName();
            i = i2 + 1;
        }
        List cipherSuites = connectionSpec.cipherSuites();
        int size2 = cipherSuites.size();
        CipherSuite[] cipherSuiteArr = new CipherSuite[size2];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                return new ConnectionSpec.Builder(connectionSpec.isTls()).supportsTlsExtensions(connectionSpec.supportsTlsExtensions()).tlsVersions(strArr).cipherSuites(cipherSuiteArr).build();
            }
            cipherSuiteArr[i4] = CipherSuite.valueOf(((com.squareup.okhttp.CipherSuite) cipherSuites.get(i4)).name());
            i3 = i4 + 1;
        }
    }

    public static Metadata convertTrailers(List<Header> list) {
        return InternalMetadata.newMetadata(convertHeadersToArray(list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InternalChannelz.SocketOptions getSocketOptions(Socket socket) {
        InternalChannelz.SocketOptions.Builder builder = new InternalChannelz.SocketOptions.Builder();
        try {
            builder.setSocketOptionLingerSeconds(Integer.valueOf(socket.getSoLinger()));
        } catch (SocketException e) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e);
            builder.addOption("SO_LINGER", "channelz_internal_error");
        }
        try {
            builder.setSocketOptionTimeoutMillis(Integer.valueOf(socket.getSoTimeout()));
        } catch (Exception e2) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e2);
            builder.addOption("SO_TIMEOUT", "channelz_internal_error");
        }
        try {
            builder.addOption("TCP_NODELAY", socket.getTcpNoDelay());
        } catch (SocketException e3) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e3);
            builder.addOption("TCP_NODELAY", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_REUSEADDR", socket.getReuseAddress());
        } catch (SocketException e4) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e4);
            builder.addOption("SO_REUSEADDR", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_SNDBUF", socket.getSendBufferSize());
        } catch (SocketException e5) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e5);
            builder.addOption("SO_SNDBUF", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_RECVBUF", socket.getReceiveBufferSize());
        } catch (SocketException e6) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e6);
            builder.addOption("SO_RECVBUF", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_KEEPALIVE", socket.getKeepAlive());
        } catch (SocketException e7) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e7);
            builder.addOption("SO_KEEPALIVE", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_OOBINLINE", socket.getOOBInline());
        } catch (SocketException e8) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e8);
            builder.addOption("SO_OOBINLINE", "channelz_internal_error");
        }
        try {
            builder.addOption("IP_TOS", socket.getTrafficClass());
        } catch (SocketException e9) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e9);
            builder.addOption("IP_TOS", "channelz_internal_error");
        }
        return builder.build();
    }
}
