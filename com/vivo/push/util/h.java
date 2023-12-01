package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/h.class */
public final class h implements BaseNotifyDataAdapter {
    private static int e;
    private static int f;

    /* renamed from: a  reason: collision with root package name */
    private Resources f27442a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f27443c;
    private String d;

    private int a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        String[] split = str.split("\\.");
        String str3 = str;
        if (split != null) {
            str3 = str;
            if (split.length > 0) {
                str3 = split[0];
            }
        }
        try {
            int parseInt = Integer.parseInt(str3);
            while (true) {
                int i = parseInt;
                if (i <= 0) {
                    return -1;
                }
                String str4 = "vivo_push_ard" + i + str2;
                p.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str4)));
                int identifier = this.f27442a.getIdentifier(str4, com.anythink.expressad.foundation.h.i.f5112c, this.b);
                if (identifier > 0) {
                    p.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str4)));
                    return identifier;
                }
                parseInt = i - 1;
            }
        } catch (Exception e2) {
            p.a("DefaultNotifyDataAdapter", e2);
            return -1;
        }
    }

    private static boolean a(int i) {
        return (i == -1 || i == 0) ? false : true;
    }

    private static boolean a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
            return false;
        }
        return true;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        if (a(e)) {
            return e;
        }
        String str = this.d;
        int a2 = !a(str) ? -1 : a(str, "_notifyicon");
        e = a2;
        if (a(a2)) {
            return e;
        }
        String str2 = this.f27443c;
        while (true) {
            String str3 = str2;
            if (TextUtils.isEmpty(str3)) {
                return this.f27442a.getIdentifier("vivo_push_notifyicon", com.anythink.expressad.foundation.h.i.f5112c, this.b);
            }
            Resources resources = this.f27442a;
            int identifier = resources.getIdentifier("vivo_push_rom" + str3 + "_notifyicon", com.anythink.expressad.foundation.h.i.f5112c, this.b);
            if (identifier > 0) {
                return identifier;
            }
            str2 = str3.substring(0, str3.length() - 1);
        }
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        if (a(f)) {
            return f;
        }
        String str = this.d;
        int a2 = !a(str) ? -1 : a(str, "_icon");
        f = a2;
        if (a(a2)) {
            return f;
        }
        String str2 = this.f27443c;
        while (true) {
            String str3 = str2;
            if (TextUtils.isEmpty(str3)) {
                return this.f27442a.getIdentifier("vivo_push_icon", com.anythink.expressad.foundation.h.i.f5112c, this.b);
            }
            Resources resources = this.f27442a;
            int identifier = resources.getIdentifier("vivo_push_rom" + str3 + "_icon", com.anythink.expressad.foundation.h.i.f5112c, this.b);
            if (identifier > 0) {
                return identifier;
            }
            str2 = str3.substring(0, str3.length() - 1);
        }
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return Build.VERSION.SDK_INT >= 21 ? 2 : 1;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.b = context.getPackageName();
        this.f27442a = context.getResources();
        this.f27443c = j.a();
        this.d = Build.VERSION.RELEASE;
    }
}
