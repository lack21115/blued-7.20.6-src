package com.tencent.liteav.txcplayer.b;

import android.text.TextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import java.io.File;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/b/a.class */
public abstract class a {
    public static final String TAG = a.class.getName();
    public InterfaceC0929a mDownloadListener;
    protected String mDownloadPath;
    protected Map<String, String> mHeaders;

    /* renamed from: com.tencent.liteav.txcplayer.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/b/a$a.class */
    public interface InterfaceC0929a {
        void a(b bVar);

        void a(b bVar, int i, String str);

        void b(b bVar);

        void c(b bVar);

        void d(b bVar);
    }

    public abstract boolean deleteDownloadFile(String str);

    public abstract int downloadHls(String str, String str2);

    public abstract String makePlayPath(String str);

    protected String makePlayPathDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.mDownloadPath + "/txcache";
        File file = new File(str2);
        if ((file.exists() && file.isDirectory()) || file.mkdir()) {
            return str2;
        }
        LiteavLog.e(TAG, "Failed to create download path".concat(String.valueOf(str2)));
        return null;
    }

    public void setDownloadPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = com.tencent.liteav.txcplayer.a.b.a();
        this.mDownloadPath = a2;
        if (TextUtils.isEmpty(a2)) {
            String str2 = str + "/txcache";
            this.mDownloadPath = str2;
            com.tencent.liteav.txcplayer.a.b.a(str2);
        }
        try {
            new File(this.mDownloadPath).mkdirs();
        } catch (Exception e) {
            LiteavLog.e(TAG, "setDownloadPath exception: " + e.getLocalizedMessage());
        }
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setListener(InterfaceC0929a interfaceC0929a) {
        this.mDownloadListener = interfaceC0929a;
    }

    public abstract void stop(int i);
}
