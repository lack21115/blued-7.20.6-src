package com.anythink.expressad.videocommon.b;

import android.text.TextUtils;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.videocommon.b.h;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final int f8745a = 259200000;
    private static final String b = "HTMLResourceManager";

    /* renamed from: c  reason: collision with root package name */
    private String f8746c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/j$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static j f8748a = new j((byte) 0);

        private a() {
        }
    }

    private j() {
        this.f8746c = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
    }

    /* synthetic */ j(byte b2) {
        this();
    }

    public static j a() {
        return a.f8748a;
    }

    private void c() {
        this.f8746c = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
    }

    public final String a(String str) {
        try {
            String str2 = this.f8746c + BridgeUtil.SPLIT_MARK + p.a(x.a(str)) + ".html";
            if (new File(str2).exists()) {
                return "file:////".concat(String.valueOf(str2));
            }
            return null;
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f6941a) {
                th.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public final boolean a(String str, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f8746c);
                    sb.append(BridgeUtil.SPLIT_MARK);
                    sb.append(p.a(x.a(str)));
                    sb.append(".html");
                    return com.anythink.expressad.foundation.h.m.a(bArr, new File(sb.toString()));
                }
                return false;
            } catch (Exception e) {
                if (com.anythink.expressad.a.f6941a) {
                    e.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    public final String b(String str) {
        try {
            String a2 = p.a(x.a(str));
            File file = new File(this.f8746c + BridgeUtil.SPLIT_MARK + a2 + ".html");
            if (file.exists()) {
                return com.anythink.expressad.foundation.h.m.a(file);
            }
            return null;
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f6941a) {
                th.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public final void b() {
        try {
            if (TextUtils.isEmpty(this.f8746c)) {
                return;
            }
            h.a.f8740a.a(new com.anythink.expressad.foundation.g.g.a() { // from class: com.anythink.expressad.videocommon.b.j.1
                @Override // com.anythink.expressad.foundation.g.g.a
                public final void a() {
                    com.anythink.expressad.foundation.h.m.c(j.this.f8746c);
                }

                @Override // com.anythink.expressad.foundation.g.g.a
                public final void b() {
                }

                @Override // com.anythink.expressad.foundation.g.g.a
                public final void c() {
                }
            });
        } catch (Exception e) {
            if (com.anythink.expressad.a.f6941a) {
                e.printStackTrace();
            }
        }
    }
}
