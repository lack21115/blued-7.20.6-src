package com.tencent.thumbplayer.tplayer.a;

import com.tencent.thumbplayer.utils.TPLogUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/k.class */
public class k {
    public static a a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    TPLogUtil.e("TPReporterFactory", "Type is not match ReporterType, return null");
                    return null;
                }
                return new f();
            }
            return new e();
        }
        return new n();
    }
}
