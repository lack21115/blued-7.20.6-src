package com.tencent.cloud.huiyansdkface.okhttp3;

import com.alipay.sdk.util.i;
import com.blued.das.live.LiveProtos;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Address.class */
public final class Address {

    /* renamed from: a  reason: collision with root package name */
    final HttpUrl f35804a;
    final Dns b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f35805c;
    final Authenticator d;
    final List<Protocol> e;
    final List<ConnectionSpec> f;
    final ProxySelector g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final CertificatePinner k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f35804a = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        if (dns == null) {
            throw new NullPointerException("dns == null");
        }
        this.b = dns;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f35805c = socketFactory;
        if (authenticator == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.d = authenticator;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.e = Util.immutableList(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f = Util.immutableList(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = certificatePinner;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Address address) {
        return this.b.equals(address.b) && this.d.equals(address.d) && this.e.equals(address.e) && this.f.equals(address.f) && this.g.equals(address.g) && Util.equal(this.h, address.h) && Util.equal(this.i, address.i) && Util.equal(this.j, address.j) && Util.equal(this.k, address.k) && url().port() == address.url().port();
    }

    public CertificatePinner certificatePinner() {
        return this.k;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f;
    }

    public Dns dns() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return this.f35804a.equals(address.f35804a) && a(address);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f35804a.hashCode();
        int hashCode2 = this.b.hashCode();
        int hashCode3 = this.d.hashCode();
        int hashCode4 = this.e.hashCode();
        int hashCode5 = this.f.hashCode();
        int hashCode6 = this.g.hashCode();
        Proxy proxy = this.h;
        int i = 0;
        int hashCode7 = proxy != null ? proxy.hashCode() : 0;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode8 = sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode9 = hostnameVerifier != null ? hostnameVerifier.hashCode() : 0;
        CertificatePinner certificatePinner = this.k;
        if (certificatePinner != null) {
            i = certificatePinner.hashCode();
        }
        return ((((((((((((((((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + i;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.j;
    }

    public List<Protocol> protocols() {
        return this.e;
    }

    public Proxy proxy() {
        return this.h;
    }

    public Authenticator proxyAuthenticator() {
        return this.d;
    }

    public ProxySelector proxySelector() {
        return this.g;
    }

    public SocketFactory socketFactory() {
        return this.f35805c;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.i;
    }

    public String toString() {
        Proxy proxy;
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f35804a.host());
        sb.append(":");
        sb.append(this.f35804a.port());
        if (this.h != null) {
            sb.append(", proxy=");
            proxy = this.h;
        } else {
            sb.append(", proxySelector=");
            proxy = this.g;
        }
        sb.append(proxy);
        sb.append(i.d);
        return sb.toString();
    }

    public HttpUrl url() {
        return this.f35804a;
    }
}
