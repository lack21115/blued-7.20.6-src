package com.tencent.tmsbeacon.event.open;

import android.text.TextUtils;
import com.tencent.tmsbeacon.a.c.c;
import com.tencent.tmsbeacon.event.c.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/open/BeaconEvent.class */
public final class BeaconEvent {

    /* renamed from: a  reason: collision with root package name */
    private String f25894a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private EventType f25895c;
    private boolean d;
    private Map<String, String> e;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/open/BeaconEvent$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f25896a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private EventType f25897c;
        private boolean d;
        private Map<String, String> e;

        private Builder() {
            this.f25897c = EventType.NORMAL;
            this.d = true;
            this.e = new HashMap();
        }

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private Builder(BeaconEvent beaconEvent) {
            this.f25897c = EventType.NORMAL;
            this.d = true;
            this.e = new HashMap();
            this.f25896a = beaconEvent.f25894a;
            this.b = beaconEvent.b;
            this.f25897c = beaconEvent.f25895c;
            this.d = beaconEvent.d;
            this.e.putAll(beaconEvent.e);
        }

        public /* synthetic */ Builder(BeaconEvent beaconEvent, a aVar) {
            this(beaconEvent);
        }

        public BeaconEvent build() {
            String b = d.b(this.b);
            if (TextUtils.isEmpty(this.f25896a)) {
                this.f25896a = c.d().f();
            }
            return new BeaconEvent(this.f25896a, b, this.f25897c, this.d, this.e, null);
        }

        public Builder withAppKey(String str) {
            this.f25896a = str;
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
            this.f25897c = eventType;
            return this;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/open/BeaconEvent$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25898a;

        static {
            EventType.values();
            int[] iArr = new int[6];
            f25898a = iArr;
            try {
                EventType eventType = EventType.NORMAL;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f25898a;
                EventType eventType2 = EventType.DT_NORMAL;
                iArr2[2] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f25898a;
                EventType eventType3 = EventType.IMMEDIATE_MSF;
                iArr3[5] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = f25898a;
                EventType eventType4 = EventType.IMMEDIATE_WNS;
                iArr4[4] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = f25898a;
                EventType eventType5 = EventType.REALTIME;
                iArr5[1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = f25898a;
                EventType eventType6 = EventType.DT_REALTIME;
                iArr6[3] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private BeaconEvent(String str, String str2, EventType eventType, boolean z, Map<String, String> map) {
        this.f25894a = str;
        this.b = str2;
        this.f25895c = eventType;
        this.d = z;
        this.e = map;
    }

    public /* synthetic */ BeaconEvent(String str, String str2, EventType eventType, boolean z, Map map, a aVar) {
        this(str, str2, eventType, z, map);
    }

    public static Builder builder() {
        return new Builder((a) null);
    }

    public static Builder newBuilder(BeaconEvent beaconEvent) {
        return new Builder(beaconEvent, null);
    }

    public String getAppKey() {
        return this.f25894a;
    }

    public String getCode() {
        return this.b;
    }

    public String getLogidPrefix() {
        switch (a.f25898a[this.f25895c.ordinal()]) {
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
        return this.f25895c;
    }

    public boolean isSucceed() {
        return this.d;
    }

    public void setAppKey(String str) {
        this.f25894a = str;
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
        this.f25895c = eventType;
    }

    public String toString() {
        return super.toString();
    }
}
