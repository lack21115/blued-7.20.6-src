package com.anythink.expressad.videocommon.b;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.videocommon.b.h;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8752a = "foldername";
    public static final String b = "md5filename";

    /* renamed from: c  reason: collision with root package name */
    public static final String f8753c = "nc";
    public static final int d = 259200000;
    private static String e = "ResourceManager";
    private String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/m$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static m f8755a = new m((byte) 0);

        private a() {
        }
    }

    private m() {
        this.f = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_RES);
    }

    /* synthetic */ m(byte b2) {
        this();
    }

    public static m a() {
        return a.f8755a;
    }

    private String a(String str, String str2, File file) {
        String a2 = com.anythink.expressad.foundation.h.m.a(str2, this.f + BridgeUtil.SPLIT_MARK + p.a(x.a(str)));
        String str3 = a2;
        if (TextUtils.isEmpty(a2)) {
            str3 = com.anythink.expressad.foundation.h.m.b(file);
        }
        return str3;
    }

    private void c() {
        this.f = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_RES);
    }

    public final String a(String str) {
        String str2;
        try {
            String str3 = this.f + BridgeUtil.SPLIT_MARK + p.a(x.a(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(f8752a);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str4 = queryParameters.get(0);
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            String str5 = str3 + BridgeUtil.SPLIT_MARK + str4 + BridgeUtil.SPLIT_MARK + str4 + ".html";
            if (com.anythink.expressad.foundation.h.m.a(str5)) {
                try {
                    str2 = str.substring(str.indexOf("?") + 1);
                } catch (Exception e2) {
                    str2 = "";
                }
                return "file://" + str5 + (TextUtils.isEmpty(str2) ? "" : "?".concat(String.valueOf(str2)));
            }
            return null;
        } catch (Exception e3) {
            if (com.anythink.expressad.a.f6941a) {
                e3.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public final String a(String str, byte[] bArr) {
        String str2;
        synchronized (this) {
            str2 = "unknow exception ";
            if (bArr != null) {
                str2 = "unknow exception ";
                try {
                    if (bArr.length > 0) {
                        String str3 = this.f + BridgeUtil.SPLIT_MARK + p.a(x.a(str)) + ".zip";
                        File file = new File(str3);
                        String str4 = "unknow exception ";
                        if (com.anythink.expressad.foundation.h.m.a(bArr, file)) {
                            Uri parse = Uri.parse(str);
                            List<String> queryParameters = parse.getQueryParameters(f8753c);
                            if (queryParameters != null && queryParameters.size() != 0) {
                                str4 = a(str, str3, file);
                            }
                            List<String> queryParameters2 = parse.getQueryParameters(b);
                            str4 = "unknow exception ";
                            if (queryParameters2 != null) {
                                str4 = "unknow exception ";
                                if (queryParameters2.size() > 0) {
                                    String str5 = queryParameters2.get(0);
                                    str4 = "unknow exception ";
                                    if (!TextUtils.isEmpty(str5)) {
                                        str4 = "unknow exception ";
                                        if (str5.equals(com.anythink.expressad.foundation.h.l.a(file))) {
                                            str4 = a(str, str3, file);
                                        }
                                    }
                                }
                            }
                        }
                        str2 = str4;
                        if (!TextUtils.isEmpty(str4)) {
                            com.anythink.expressad.foundation.h.m.b(file);
                            str2 = str4;
                        }
                    }
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.f6941a) {
                        e2.printStackTrace();
                    }
                    str2 = e2.getMessage();
                }
            }
        }
        return str2;
    }

    public final void b() {
        try {
            if (TextUtils.isEmpty(this.f)) {
                return;
            }
            h.a.f8740a.a(new com.anythink.expressad.foundation.g.g.a() { // from class: com.anythink.expressad.videocommon.b.m.1
                @Override // com.anythink.expressad.foundation.g.g.a
                public final void a() {
                    com.anythink.expressad.foundation.h.m.c(m.this.f);
                }

                @Override // com.anythink.expressad.foundation.g.g.a
                public final void b() {
                }

                @Override // com.anythink.expressad.foundation.g.g.a
                public final void c() {
                }
            });
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f6941a) {
                e2.printStackTrace();
            }
        }
    }
}
