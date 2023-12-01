package android.net;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.android.net.IProxyService;
import com.google.android.collect.Lists;
import com.huawei.openalliance.ad.constant.t;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/net/PacProxySelector.class */
public class PacProxySelector extends ProxySelector {
    private static final String PROXY = "PROXY ";
    public static final String PROXY_SERVICE = "com.android.net.IProxyService";
    private static final String SOCKS = "SOCKS ";
    private static final String TAG = "PacProxySelector";
    private final List<java.net.Proxy> mDefaultList;
    private IProxyService mProxyService = IProxyService.Stub.asInterface(ServiceManager.getService(PROXY_SERVICE));

    public PacProxySelector() {
        if (this.mProxyService == null) {
            Log.e(TAG, "PacManager: no proxy service");
        }
        this.mDefaultList = Lists.newArrayList(new java.net.Proxy[]{java.net.Proxy.NO_PROXY});
    }

    private static List<java.net.Proxy> parseResponse(String str) {
        java.net.Proxy proxyFromHostPort;
        String[] split = str.split(t.aE);
        ArrayList newArrayList = Lists.newArrayList();
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            String trim = split[i2].trim();
            if (trim.equals("DIRECT")) {
                newArrayList.add(java.net.Proxy.NO_PROXY);
            } else if (trim.startsWith(PROXY)) {
                java.net.Proxy proxyFromHostPort2 = proxyFromHostPort(Proxy.Type.HTTP, trim.substring(PROXY.length()));
                if (proxyFromHostPort2 != null) {
                    newArrayList.add(proxyFromHostPort2);
                }
            } else if (trim.startsWith(SOCKS) && (proxyFromHostPort = proxyFromHostPort(Proxy.Type.SOCKS, trim.substring(SOCKS.length()))) != null) {
                newArrayList.add(proxyFromHostPort);
            }
            i = i2 + 1;
        }
        if (newArrayList.size() == 0) {
            newArrayList.add(java.net.Proxy.NO_PROXY);
        }
        return newArrayList;
    }

    private static java.net.Proxy proxyFromHostPort(Proxy.Type type, String str) {
        try {
            String[] split = str.split(":");
            return new java.net.Proxy(type, InetSocketAddress.createUnresolved(split[0], Integer.parseInt(split[1])));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            Log.d(TAG, "Unable to parse proxy " + str + " " + e);
            return null;
        }
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }

    @Override // java.net.ProxySelector
    public List<java.net.Proxy> select(URI uri) {
        String host;
        String str;
        if (this.mProxyService == null) {
            this.mProxyService = IProxyService.Stub.asInterface(ServiceManager.getService(PROXY_SERVICE));
        }
        if (this.mProxyService == null) {
            Log.e(TAG, "select: no proxy service return NO_PROXY");
            return Lists.newArrayList(new java.net.Proxy[]{java.net.Proxy.NO_PROXY});
        }
        try {
            host = uri.toURL().toString();
        } catch (MalformedURLException e) {
            host = uri.getHost();
        }
        try {
            str = this.mProxyService.resolvePacFile(uri.getHost(), host);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            str = null;
        }
        return str == null ? this.mDefaultList : parseResponse(str);
    }
}
