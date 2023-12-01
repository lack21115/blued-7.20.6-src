package com.tencent.thumbplayer.c;

import android.os.Looper;
import com.tencent.thumbplayer.config.TPPlayerConfig;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/c.class */
public class c {
    public static a a(Looper looper, com.tencent.thumbplayer.tplayer.a aVar) {
        return TPPlayerConfig.getNewReportEnable() ? (a) new d(new e(aVar.a(), looper), aVar).a() : new e(aVar.a(), looper);
    }
}
