package com.blued.android.framework.urlroute;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/urlroute/BluedUrlParser.class */
public class BluedUrlParser {

    /* renamed from: a  reason: collision with root package name */
    private String f10062a;
    private Map<String, String> b;

    private BluedUrlParser(String str) {
        this.f10062a = str;
    }

    public static BluedUrlParser a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return null;
            }
            if (!BluedURIRouter.a().a(parse.getScheme()) && !BluedURIRouter.a().b(parse.getHost())) {
                return null;
            }
            Map<String, String> a2 = BluedUrlUtils.a(str);
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            String str2 = a2.get("action");
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            BluedUrlParser bluedUrlParser = new BluedUrlParser(str2);
            bluedUrlParser.a(a2);
            return bluedUrlParser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String a() {
        return this.f10062a;
    }

    public void a(Map<String, String> map) {
        this.b = map;
    }

    public Map<String, String> b() {
        return this.b;
    }
}
