package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bw;
import com.baidu.mobads.sdk.internal.cf;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bs.class */
public class bs extends Thread {
    private static final String b = "ApkDownloadThread";

    /* renamed from: c  reason: collision with root package name */
    private static final int f9357c = 900000;
    private static volatile bs h;
    private volatile String d;
    private String e;
    private double f;
    private Handler g;
    private final Context i;
    private final bu k;
    private cf j = null;
    private bq l = bq.a();

    /* renamed from: a  reason: collision with root package name */
    cf.a f9358a = new bt(this);

    private bs(Context context, bu buVar, String str, Handler handler) {
        this.e = null;
        this.i = context;
        this.k = buVar;
        a(buVar.c());
        this.g = handler;
        this.e = str;
    }

    public static bs a(Context context, bu buVar, String str, Handler handler) {
        if (h == null) {
            h = new bs(context, buVar, str, handler);
        }
        return h;
    }

    private String a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ShareConstants.JAR_SUFFIX;
        String str2 = this.e + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.j.a(this.e, str);
            return str2;
        } catch (IOException e) {
            file.delete();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, bu buVar, String str2) {
        if (str.equals(bw.k) || str.equals(bw.l)) {
            Message obtainMessage = this.g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(bw.m, buVar);
            bundle.putString(bw.n, str);
            obtainMessage.setData(bundle);
            this.g.sendMessage(obtainMessage);
        }
    }

    private boolean b() {
        try {
            try {
                this.j = new cf(this.i, new URL(this.d), this.k, this.f9358a);
            } catch (MalformedURLException e) {
                this.j = new cf(this.i, this.d, this.k, this.f9358a);
            }
            double d = bw.q != null ? bw.q.b : bw.p != null ? bw.p.b > 0.0d ? bw.p.b : bw.p.b : 0.0d;
            this.l.a(b, "isNewApkAvailable: local apk version is: " + d + ", remote apk version: " + this.k.b());
            if (d > 0.0d) {
                if (this.k.b() <= 0.0d) {
                    this.l.a(b, "remote is null, local apk version is null, do not upgrade");
                    return false;
                }
                this.l.a(b, "remote not null, local apk version is null, force upgrade");
                this.f = this.k.b();
                return true;
            } else if (this.k.b() > 0.0d) {
                if (this.k.b() > d) {
                    this.f = this.k.b();
                    return true;
                }
                return false;
            } else {
                this.l.a(b, "remote apk version is: null, local apk version is: " + d + ", do not upgrade");
                return false;
            }
        } catch (Exception e2) {
            String str = "parse apk failed, error:" + e2.toString();
            this.l.a(b, str);
            throw new bw.a(str);
        }
    }

    public void a(String str) {
        this.d = str;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.l.a(b, "download apk successfully, downloader exit");
                    h = null;
                } catch (IOException e) {
                    bq bqVar = this.l;
                    bqVar.a(b, "create File or HTTP Get failed, exception: " + e.getMessage());
                }
                this.l.a(b, "no newer apk, downloader exit");
                h = null;
            }
        } catch (Throwable th) {
        }
    }
}
