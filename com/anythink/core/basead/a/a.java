package com.anythink.core.basead.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.internal.app.HeavyWeightSwitcherActivity;
import com.anythink.core.c.b;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.am;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.l;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/a/a.class */
public final class a {
    public static final String a = "play.google.com";
    public static final String b = "market.android.com";
    public static final String c = "details?";
    public static final String d = "market";
    public static final String e = "market://";

    public static am a(Context context, String str) {
        am amVar = new am();
        amVar.n = !str.startsWith("http");
        amVar.o = str;
        if (c(str)) {
            amVar.o = str;
            boolean equals = TextUtils.equals(b.a(context).b(n.a().p()).l(), "1");
            if (!a(context, str, false, equals)) {
                if (a(context, str, false, false)) {
                    amVar.m = true;
                    amVar.l = 4;
                }
                return amVar;
            }
            amVar.m = true;
            if (equals) {
                amVar.l = 3;
                return amVar;
            }
            amVar.l = 4;
            return amVar;
        } else if (!str.startsWith("http")) {
            amVar.o = str;
            if (a(context, str, false, false)) {
                amVar.m = true;
                amVar.l = 5;
            }
            return amVar;
        } else {
            if (b(str)) {
                String e2 = e(str);
                amVar.n = true;
                amVar.o = e2;
                if (a(context, e2, false, true)) {
                    amVar.m = true;
                    amVar.l = 1;
                    return amVar;
                } else if (a(context, e2, false, false)) {
                    amVar.m = true;
                    amVar.l = 2;
                }
            }
            return amVar;
        }
    }

    public static am a(String str) {
        am amVar = new am();
        amVar.l = 8;
        amVar.n = false;
        amVar.m = true;
        amVar.o = str;
        try {
            if (Uri.parse(str).getScheme().equals(HeavyWeightSwitcherActivity.KEY_INTENT)) {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                if (Build.VERSION.SDK_INT >= 15) {
                    parseUri.setSelector(null);
                }
                String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.startsWith("http")) {
                    amVar.l = 10;
                    amVar.o = stringExtra;
                    return amVar;
                }
            }
        } catch (Throwable th) {
        }
        if (c(str)) {
            String d2 = d(str);
            amVar.l = 9;
            amVar.o = d2;
        }
        return amVar;
    }

    public static boolean a(Context context, String str, boolean z) {
        boolean z2 = true;
        if (b(str)) {
            return a(context, e(str), z, true);
        }
        String scheme = Uri.parse(str).getScheme();
        if (scheme == null || scheme.startsWith("http")) {
            return false;
        }
        com.anythink.core.c.a b2 = b.a(context).b(n.a().p());
        if (!scheme.startsWith(d) || !TextUtils.equals(b2.l(), "1")) {
            z2 = false;
        }
        return a(context, str, z, z2);
    }

    private static boolean a(final Context context, String str, boolean z, boolean z2) {
        Intent intent;
        try {
            Uri parse = Uri.parse(str);
            if (parse.getScheme().equals(HeavyWeightSwitcherActivity.KEY_INTENT)) {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                intent = parseUri;
                if (Build.VERSION.SDK_INT >= 15) {
                    parseUri.setSelector(null);
                    intent = parseUri;
                }
            } else {
                intent = new Intent("android.intent.action.VIEW", parse);
                intent.setData(parse);
            }
            if (z2 && TextUtils.isEmpty(intent.getPackage())) {
                intent.setPackage(g.a.a);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            if (z) {
                n.a().a(new Runnable() { // from class: com.anythink.core.basead.a.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(context, "Detect that the App Market is not installed and cannot be opened through the App Market.", 1).show();
                    }
                });
                return false;
            }
            return false;
        }
    }

    private static void b(Context context, String str) {
        l.a(context, str);
    }

    public static boolean b(String str) {
        Uri parse;
        try {
            if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || parse.getHost() == null) {
                return false;
            }
            if (parse.getHost().equals(a)) {
                return true;
            }
            return parse.getHost().equals(b);
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Uri.parse(str).getScheme().equals(d);
        } catch (Throwable th) {
            return false;
        }
    }

    private static String d(String str) {
        try {
            return "https://play.google.com/store/apps/details?id=".concat(String.valueOf(str.replace("market://details?id=", "")));
        } catch (Throwable th) {
            return str;
        }
    }

    private static String e(String str) {
        try {
            return e.concat(String.valueOf(str.substring(str.indexOf(c))));
        } catch (Throwable th) {
            return null;
        }
    }
}
