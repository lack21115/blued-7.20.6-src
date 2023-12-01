package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cx.class */
public abstract class cx {

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cx$a.class */
    public static class a extends cw {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.cw
        public String a(Context context, String str, List<bg> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (bg bgVar : list) {
                    buildUpon.appendQueryParameter(bgVar.a(), bgVar.b());
                }
                url = new URL(buildUpon.toString());
            }
            return bh.a(context, url);
        }
    }

    static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
    }

    static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * 132) + 1011 + i2 + i + i3;
    }

    private static int a(cw cwVar, String str, List<bg> list, String str2) {
        if (cwVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (cwVar.a() == 2) {
            return a(str.length(), a(list), a(str2));
        }
        return -1;
    }

    static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            return 0;
        }
    }

    static int a(List<bg> list) {
        int i = 0;
        for (bg bgVar : list) {
            int i2 = i;
            if (!TextUtils.isEmpty(bgVar.a())) {
                i2 = i + bgVar.a().length();
            }
            i = i2;
            if (!TextUtils.isEmpty(bgVar.b())) {
                i = i2 + bgVar.b().length();
            }
        }
        return i * 2;
    }

    public static String a(Context context, String str, List<bg> list) {
        return a(context, str, list, new a(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0113 A[Catch: MalformedURLException -> 0x0136, TRY_ENTER, TryCatch #1 {MalformedURLException -> 0x0136, blocks: (B:4:0x0007, B:6:0x0015, B:8:0x0023, B:9:0x002e, B:11:0x0037, B:13:0x0040, B:15:0x0047, B:17:0x0051, B:19:0x0061, B:20:0x006e, B:50:0x0113, B:52:0x012e), top: B:64:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r9, java.lang.String r10, java.util.List<com.xiaomi.push.bg> r11, com.xiaomi.push.cw r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cx.a(android.content.Context, java.lang.String, java.util.List, com.xiaomi.push.cw, boolean):java.lang.String");
    }
}
