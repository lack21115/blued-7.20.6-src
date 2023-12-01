package com.huawei.openalliance.ad.msgnotify;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.openalliance.ad.utils.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/msgnotify/a.class */
public class a {
    private static a Code;
    private static final byte[] V = new byte[0];
    private final byte[] I = new byte[0];
    private final Map<String, Set<NotifyCallback>> Z = new HashMap();

    private a() {
    }

    public static a Code() {
        a aVar;
        synchronized (V) {
            if (Code == null) {
                Code = new a();
            }
            aVar = Code;
        }
        return aVar;
    }

    public void Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.I) {
            this.Z.remove(str);
        }
    }

    public void Code(final String str, final Intent intent) {
        synchronized (this.I) {
            Set<NotifyCallback> set = this.Z.get(str);
            if (set != null) {
                for (final NotifyCallback notifyCallback : set) {
                    if (notifyCallback != null) {
                        f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.msgnotify.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                notifyCallback.onMessageNotify(str, intent);
                            }
                        });
                    }
                }
            }
        }
    }

    public void Code(String str, NotifyCallback notifyCallback) {
        if (TextUtils.isEmpty(str) || notifyCallback == null) {
            return;
        }
        synchronized (this.I) {
            Set<NotifyCallback> set = this.Z.get(str);
            HashSet hashSet = set;
            if (set == null) {
                hashSet = new HashSet();
                this.Z.put(str, hashSet);
            }
            hashSet.add(notifyCallback);
        }
    }

    public void V(String str, NotifyCallback notifyCallback) {
        if (TextUtils.isEmpty(str) || notifyCallback == null) {
            return;
        }
        synchronized (this.I) {
            Set<NotifyCallback> set = this.Z.get(str);
            if (set != null) {
                set.remove(notifyCallback);
                if (set.isEmpty()) {
                    this.Z.remove(str);
                }
            }
        }
    }
}
