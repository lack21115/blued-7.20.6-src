package com.huawei.hms.framework.network.grs.h.g;

import android.content.Context;
import android.content.res.AssetManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/h/g/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final HostnameVerifier f22726a = new StrictHostnameVerifier();

    public static HostnameVerifier a() {
        return f22726a;
    }

    public static SSLSocketFactory a(Context context) {
        try {
            AssetManager assets = context.getAssets();
            return new SecureSSLSocketFactoryNew(new SecureX509TrustManager(assets.open(GrsApp.getInstance().getBrand(BridgeUtil.SPLIT_MARK) + "grs_sp.bks"), ""));
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
