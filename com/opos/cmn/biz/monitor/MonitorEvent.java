package com.opos.cmn.biz.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/MonitorEvent.class */
public class MonitorEvent implements Parcelable {
    public static final Parcelable.Creator<MonitorEvent> CREATOR = new Parcelable.Creator<MonitorEvent>() { // from class: com.opos.cmn.biz.monitor.MonitorEvent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MonitorEvent createFromParcel(Parcel parcel) {
            if (parcel != null) {
                ArrayList arrayList = new ArrayList();
                parcel.readList(arrayList, getClass().getClassLoader());
                return new MonitorEvent(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), arrayList);
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MonitorEvent[] newArray(int i) {
            return new MonitorEvent[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f10922a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f10923c;
    private int d;
    private int e;
    private String f;
    private String g;
    private int h;
    private String i;
    private String j;
    private List<String> k;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/MonitorEvent$a.class */
    public enum a {
        BTN("1"),
        EXTRA("2");
        

        /* renamed from: c  reason: collision with root package name */
        private String f10925c;

        a(String str) {
            this.f10925c = "";
            this.f10925c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.f10925c;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/MonitorEvent$b.class */
    public static class b {
        private a i;

        /* renamed from: a  reason: collision with root package name */
        private int f10926a = -1;
        private int b = com.anythink.expressad.video.bt.a.c.f5450a;

        /* renamed from: c  reason: collision with root package name */
        private int f10927c = com.anythink.expressad.video.bt.a.c.f5450a;
        private int d = com.anythink.expressad.video.bt.a.c.f5450a;
        private int e = com.anythink.expressad.video.bt.a.c.f5450a;
        private c f = c.OTHER;
        private d g = d.OTHER;
        private int h = 1;
        private String j = "";
        private List<String> k = new ArrayList();

        public b a(int i) {
            if (i >= 0) {
                this.f10926a = i;
            }
            return this;
        }

        public b a(int i, int i2, int i3, int i4) {
            if (i >= 0 && i2 >= 0 && i3 >= 0 && i4 >= 0) {
                this.b = i;
                this.f10927c = i2;
                this.d = i3;
                this.e = i4;
            }
            return this;
        }

        public b a(a aVar) {
            this.i = aVar;
            return this;
        }

        public b a(c cVar) {
            if (cVar == null) {
                return this;
            }
            this.f = cVar;
            return this;
        }

        public b a(d dVar) {
            if (dVar == null) {
                return this;
            }
            this.g = dVar;
            return this;
        }

        public b a(String str) {
            this.j = str;
            return this;
        }

        public MonitorEvent a() {
            a aVar = this.i;
            return new MonitorEvent(this.f10926a, this.b, this.f10927c, this.d, this.e, this.f.a(), this.g.a(), this.h, aVar != null ? aVar.a() : "", this.j, this.k);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/MonitorEvent$c.class */
    public enum c {
        IMAGE("1"),
        CLICK_BUTTON("2"),
        TEXT("3"),
        OPEN_BUTTON("4"),
        OTHER("0");
        
        private String f;

        c(String str) {
            this.f = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.f;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/MonitorEvent$d.class */
    public enum d {
        WEB_URL("1"),
        DEEP_LINK("2"),
        APP_HOME("3"),
        QA("4"),
        APP_SHOP("5"),
        DOWNLOADER("6"),
        OTHER("0"),
        MINI_PROGRAM("7");
        
        private String i;

        d(String str) {
            this.i = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.i;
        }
    }

    private MonitorEvent(int i, int i2, int i3, int i4, int i5, String str, String str2, int i6, String str3, String str4, List<String> list) {
        this.f10922a = -1;
        this.f10922a = i;
        this.b = i2;
        this.f10923c = i3;
        this.d = i4;
        this.e = i5;
        this.f = str;
        this.g = str2;
        this.h = i6;
        this.i = str3;
        this.j = str4;
        this.k = list;
    }

    public int a() {
        return this.f10922a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f10923c;
    }

    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        StringBuilder sb = new StringBuilder();
        if (this.k != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.k.size()) {
                    break;
                }
                sb.append(this.k.get(i2).trim());
                if (i2 < this.k.size() - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.k);
        parcel.writeInt(this.f10922a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f10923c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
    }
}
