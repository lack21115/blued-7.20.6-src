package com.huawei.hms.push;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/AttributionEvent.class */
public enum AttributionEvent {
    APP_START_COMPLETE(1),
    OPEN_PRIVACY_PAGE(2),
    REJECT_PRIVACY(3),
    AGREED_PRIVACY(4),
    PERMISSION_GRANTED(5),
    PERMISSION_DENIED(6),
    OPEN_LANDING_PAGE(7);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f22827a;

    AttributionEvent(int i) {
        this.f22827a = i;
    }

    public int getEventId() {
        return this.f22827a;
    }
}
