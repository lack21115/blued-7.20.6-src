package com.tencent.beacon.base.net.adapter;

import com.tencent.beacon.base.net.BodyType;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/adapter/a.class */
/* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f34963a;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
    static {
        int[] iArr = new int[BodyType.values().length];
        f34963a = iArr;
        try {
            iArr[BodyType.DATA.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f34963a[BodyType.FORM.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f34963a[BodyType.JSON.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
