package com.getui.gtc.a;

import android.text.TextUtils;
import com.getui.gtc.e.c;
import com.getui.gtc.i.d.b;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/c.class */
public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f21883a;
    private boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private long f21884c = 10000;

    @Override // java.lang.Runnable
    public final void run() {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        com.getui.gtc.e.c cVar3;
        com.getui.gtc.e.c cVar4;
        com.getui.gtc.e.c cVar5;
        com.getui.gtc.e.c cVar6;
        com.getui.gtc.e.c cVar7;
        com.getui.gtc.i.d.b unused;
        Map<String, String> a2 = com.getui.gtc.f.b.a(null);
        if (a2 != null && a2.size() > 0) {
            try {
                if (a2.containsKey("sdk.gtc.type301.enable")) {
                    this.b = Boolean.parseBoolean(a2.get("sdk.gtc.type301.enable"));
                }
            } catch (Exception e) {
                com.getui.gtc.i.c.a.a(e);
            }
            try {
                if (a2.containsKey("sdk.gtc.type301.interval")) {
                    this.f21884c = Long.parseLong(a2.get("sdk.gtc.type301.interval")) * 1000;
                }
            } catch (Exception e2) {
                com.getui.gtc.i.c.a.a(e2);
            }
        }
        if (!this.b) {
            com.getui.gtc.i.c.a.b("type 301 is not enabled");
            return;
        }
        cVar = c.a.f21997a;
        String str = cVar.f21995a.f21998a;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("\n");
                if (System.currentTimeMillis() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(split[0].split("\\|")[0]).getTime() > 604800000 || split.length > 300) {
                    cVar2 = c.a.f21997a;
                    cVar2.f21995a.d("");
                    com.getui.gtc.i.c.a.a("type 301 clean stored samples");
                }
            } catch (Exception e3) {
                com.getui.gtc.i.c.a.b("type 301 clean samples error: " + e3.toString());
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        StringBuilder sb = new StringBuilder();
        sb.append(a.a(simpleDateFormat.format(new Date())));
        sb.append("|");
        sb.append(a.a(com.getui.gtc.c.b.d));
        sb.append("|");
        sb.append(a.a(com.getui.gtc.c.b.f21920a));
        sb.append("|android|");
        unused = b.a.f22037a;
        Calendar calendar = Calendar.getInstance();
        double d = (calendar.get(15) + calendar.get(16)) / 3600000.0d;
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(2);
        sb.append(a.a(numberInstance.format(d)));
        String sb2 = sb.toString();
        cVar3 = c.a.f21997a;
        com.getui.gtc.e.d dVar = cVar3.f21995a;
        if (!TextUtils.isEmpty(sb2)) {
            String str2 = sb2;
            if (!TextUtils.isEmpty(dVar.f21998a)) {
                str2 = dVar.f21998a + "\n" + sb2;
            }
            if (dVar.a(7, str2)) {
                dVar.f21998a = str2;
            }
        }
        cVar4 = c.a.f21997a;
        this.f21883a = cVar4.f21995a.f21998a;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            cVar5 = c.a.f21997a;
            if (currentTimeMillis - cVar5.f21995a.b < this.f21884c) {
                return;
            }
            com.getui.gtc.h.a.a(this.f21883a, 301);
            cVar6 = c.a.f21997a;
            com.getui.gtc.e.d dVar2 = cVar6.f21995a;
            if (dVar2.a(6, currentTimeMillis)) {
                dVar2.b = currentTimeMillis;
            }
            cVar7 = c.a.f21997a;
            cVar7.f21995a.d("");
        } catch (Exception e4) {
            com.getui.gtc.i.c.a.c("type 301 report error: " + e4.toString());
        }
    }
}
