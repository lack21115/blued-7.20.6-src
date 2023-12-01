package com.xiaomi.push;

import com.xiaomi.push.service.bg;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fc.class */
/* synthetic */ class fc {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f41399a;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
    static {
        int[] iArr = new int[bg.c.values().length];
        f41399a = iArr;
        try {
            iArr[bg.c.unbind.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f41399a[bg.c.binding.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f41399a[bg.c.binded.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
