package com.tencent.beacon.event.open;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/open/a.class */
/* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f35073a;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
    static {
        int[] iArr = new int[EventType.values().length];
        f35073a = iArr;
        try {
            iArr[EventType.NORMAL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f35073a[EventType.DT_NORMAL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f35073a[EventType.IMMEDIATE_MSF.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f35073a[EventType.IMMEDIATE_WNS.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f35073a[EventType.REALTIME.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f35073a[EventType.DT_REALTIME.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
