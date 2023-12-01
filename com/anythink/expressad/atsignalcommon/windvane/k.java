package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/k.class */
public final class k {
    private static b a(Object obj) {
        try {
            return "wv_hybird:".equals(((a) obj).f4263a.getSignalCommunication().b()) ? j.a() : j.a();
        } catch (Exception e) {
            e.printStackTrace();
            return j.a();
        }
    }
}
