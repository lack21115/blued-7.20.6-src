package com.opos.cmn.an.h.b;

import android.content.Context;
import android.media.AudioManager;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/h/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static AudioManager f24560a;

    public static AudioManager a(Context context) {
        if (f24560a == null && context != null) {
            f24560a = (AudioManager) context.getApplicationContext().getSystemService("audio");
        }
        return f24560a;
    }

    public static int b(Context context) {
        int i;
        AudioManager a2;
        try {
            a2 = a(context);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AudioMgrTool", "", e);
        }
        if (a2 != null) {
            i = a2.getStreamVolume(3);
            com.opos.cmn.an.f.a.b("AudioMgrTool", "getMusicCurrentVolume=" + i);
            return i;
        }
        i = 0;
        com.opos.cmn.an.f.a.b("AudioMgrTool", "getMusicCurrentVolume=" + i);
        return i;
    }
}
