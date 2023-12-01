package com.tencent.beacon.event.open;

import android.text.TextUtils;
import com.tencent.beacon.a.c.c;
import com.tencent.beacon.event.c.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/open/BeaconEvent.class */
public final class BeaconEvent {

    /* renamed from: a  reason: collision with root package name */
    private String f21376a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private EventType f21377c;
    private boolean d;
    private Map<String, String> e;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/open/BeaconEvent$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f21378a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private EventType f21379c;
        private boolean d;
        private Map<String, String> e;

        private Builder() {
            this.f21379c = EventType.NORMAL;
            this.d = true;
            this.e = new HashMap();
        }

        private Builder(BeaconEvent beaconEvent) {
            this.f21379c = EventType.NORMAL;
            this.d = true;
            this.e = new HashMap();
            this.f21378a = beaconEvent.f21376a;
            this.b = beaconEvent.b;
            this.f21379c = beaconEvent.f21377c;
            this.d = beaconEvent.d;
            this.e.putAll(beaconEvent.e);
        }

        /* synthetic */ Builder(BeaconEvent beaconEvent, a aVar) {
            this(beaconEvent);
        }

        /* synthetic */ Builder(a aVar) {
            this();
        }

        public BeaconEvent build() {
            String b = d.b(this.b);
            if (TextUtils.isEmpty(this.f21378a)) {
                this.f21378a = c.d().f();
            }
            return new BeaconEvent(this.f21378a, b, this.f21379c, this.d, this.e, null);
        }

        public Builder withAppKey(String str) {
            this.f21378a = str;
            return this;
        }

        public Builder withCode(String str) {
            this.b = str;
            return this;
        }

        public Builder withIsSucceed(boolean z) {
            this.d = z;
            return this;
        }

        public Builder withParams(String str, String str2) {
            this.e.put(str, str2);
            return this;
        }

        public Builder withParams(Map<String, String> map) {
            if (map != null) {
                this.e.putAll(map);
            }
            return this;
        }

        public Builder withType(EventType eventType) {
            this.f21379c = eventType;
            return this;
        }
    }

    private BeaconEvent(String str, String str2, EventType eventType, boolean z, Map<String, String> map) {
        this.f21376a = str;
        this.b = str2;
        this.f21377c = eventType;
        this.d = z;
        this.e = map;
    }

    /* synthetic */ BeaconEvent(String str, String str2, EventType eventType, boolean z, Map map, a aVar) {
        this(str, str2, eventType, z, map);
    }

    public static Builder builder() {
        return new Builder((a) null);
    }

    public static Builder newBuilder(BeaconEvent beaconEvent) {
        return new Builder(beaconEvent, null);
    }

    public String getAppKey() {
        return this.f21376a;
    }

    public String getCode() {
        return this.b;
    }

    public String getLogidPrefix() {
        switch (a.f21382a[this.f21377c.ordinal()]) {
            case 1:
            case 2:
                return "N";
            case 3:
            case 4:
                return "I";
            case 5:
            case 6:
                return "Y";
            default:
                return "";
        }
    }

    public Map<String, String> getParams() {
        return this.e;
    }

    public EventType getType() {
        return this.f21377c;
    }

    public boolean isSucceed() {
        return this.d;
    }

    public void setAppKey(String str) {
        this.f21376a = str;
    }

    public void setCode(String str) {
        this.b = str;
    }

    public void setParams(Map<String, String> map) {
        this.e = map;
    }

    public void setSucceed(boolean z) {
        this.d = z;
    }

    public void setType(EventType eventType) {
        this.f21377c = eventType;
    }

    public String toString() {
        return super.toString();
    }
}
