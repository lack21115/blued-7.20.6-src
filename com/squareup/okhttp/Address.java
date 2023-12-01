package com.squareup.okhttp;

import com.blued.das.live.LiveProtos;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/Address.class */
public final class Address {
    final Authenticator authenticator;
    final CertificatePinner certificatePinner;
    final List<ConnectionSpec> connectionSpecs;
    final Dns dns;
    final HostnameVerifier hostnameVerifier;
    final List<Protocol> protocols;
    final Proxy proxy;
    final ProxySelector proxySelector;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final HttpUrl url;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        if (dns == null) {
            throw new IllegalArgumentException("dns == null");
        }
        this.dns = dns;
        if (socketFactory == null) {
            throw new IllegalArgumentException("socketFactory == null");
        }
        this.socketFactory = socketFactory;
        if (authenticator == null) {
            throw new IllegalArgumentException("authenticator == null");
        }
        this.authenticator = authenticator;
        if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        this.protocols = Util.immutableList(list);
        if (list2 == null) {
            throw new IllegalArgumentException("connectionSpecs == null");
        }
        this.connectionSpecs = Util.immutableList(list2);
        if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        }
        this.proxySelector = proxySelector;
        this.proxy = proxy;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof Address) {
            Address address = (Address) obj;
            z = false;
            if (this.url.equals(address.url)) {
                z = false;
                if (this.dns.equals(address.dns)) {
                    z = false;
                    if (this.authenticator.equals(address.authenticator)) {
                        z = false;
                        if (this.protocols.equals(address.protocols)) {
                            z = false;
                            if (this.connectionSpecs.equals(address.connectionSpecs)) {
                                z = false;
                                if (this.proxySelector.equals(address.proxySelector)) {
                                    z = false;
                                    if (Util.equal(this.proxy, address.proxy)) {
                                        z = false;
                                        if (Util.equal(this.sslSocketFactory, address.sslSocketFactory)) {
                                            z = false;
                                            if (Util.equal(this.hostnameVerifier, address.hostnameVerifier)) {
                                                z = false;
                                                if (Util.equal(this.certificatePinner, address.certificatePinner)) {
                                                    z = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public List<ConnectionSpec> getConnectionSpecs() {
        return this.connectionSpecs;
    }

    public Dns getDns() {
        return this.dns;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Protocol> getProtocols() {
        return this.protocols;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    @Deprecated
    public String getUriHost() {
        return this.url.host();
    }

    @Deprecated
    public int getUriPort() {
        return this.url.port();
    }

    public int hashCode() {
        int hashCode = this.url.hashCode();
        int hashCode2 = this.dns.hashCode();
        int hashCode3 = this.authenticator.hashCode();
        int hashCode4 = this.protocols.hashCode();
        int hashCode5 = this.connectionSpecs.hashCode();
        int hashCode6 = this.proxySelector.hashCode();
        Proxy proxy = this.proxy;
        int i = 0;
        int hashCode7 = proxy != null ? proxy.hashCode() : 0;
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        int hashCode8 = sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0;
        HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        int hashCode9 = hostnameVerifier != null ? hostnameVerifier.hashCode() : 0;
        CertificatePinner certificatePinner = this.certificatePinner;
        if (certificatePinner != null) {
            i = certificatePinner.hashCode();
        }
        return ((((((((((((((((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + i;
    }

    public HttpUrl url() {
        return this.url;
    }
}
