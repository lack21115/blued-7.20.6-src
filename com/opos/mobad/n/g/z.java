package com.opos.mobad.n.g;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/z.class */
public class z extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f26946a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26947c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private a.InterfaceC0708a m;

    public z(Context context, int i, boolean z) {
        super(context);
        this.h = "#8CFFFFFF";
        this.i = "#4DFFFFFF";
        this.j = "#D9FFFFFF";
        this.k = "#2F80ED";
        this.l = "#3B000000";
        a(i, z);
    }

    public static z a(Context context) {
        return new z(context, 1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x03ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 1217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.g.z.a(int, boolean):void");
    }

    public static z b(Context context) {
        return new z(context, 0, false);
    }

    public static z c(Context context) {
        return new z(context, 0, true);
    }

    public void a(a.InterfaceC0708a interfaceC0708a) {
        com.opos.cmn.an.f.a.b("BlockPrivacyView", "setListener " + interfaceC0708a);
        this.m = interfaceC0708a;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f26946a.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f26947c.setText(str2);
    }
}
