package com.baidu.mobads.sdk.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/au.class */
public class au extends at {
    public static final String b = "logout";

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f9321c = {"#", "#", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", "W", ExifInterface.LONGITUDE_EAST, "A"};

    @Override // com.baidu.mobads.sdk.internal.at, com.baidu.mobads.sdk.internal.av.a
    String a() {
        return b;
    }

    @Override // com.baidu.mobads.sdk.internal.at, com.baidu.mobads.sdk.internal.av.a
    protected void a(int i, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory c2 = z.a().c();
            if (c2 != null) {
                c2.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + f9321c[i] + BridgeUtil.SPLIT_MARK + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + "\n");
            }
        } catch (Throwable th2) {
        }
    }
}
