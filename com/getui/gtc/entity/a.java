package com.getui.gtc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Contacts;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/entity/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<C0351a> f22001a = new SparseArray<>();
    private String b;

    /* renamed from: com.getui.gtc.entity.a$a  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/entity/a$a.class */
    public static final class C0351a implements Parcelable {
        public static final Parcelable.Creator<C0351a> CREATOR = new Parcelable.Creator<C0351a>() { // from class: com.getui.gtc.entity.a.a.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ C0351a createFromParcel(Parcel parcel) {
                return new C0351a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ C0351a[] newArray(int i) {
                return new C0351a[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public int f22002a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f22003c;
        public String d;
        public String e;
        public String f;
        public long g;
        public String h;
        public boolean i;
        public boolean j;

        public C0351a() {
        }

        protected C0351a(Parcel parcel) {
            this.f22002a = parcel.readInt();
            this.b = parcel.readString();
            this.f22003c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
            this.g = parcel.readLong();
            this.h = parcel.readString();
            this.i = parcel.readByte() != 0;
            this.j = parcel.readByte() != 0;
        }

        public final String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f22002a);
                jSONObject.put("version", this.b);
                jSONObject.put("name", this.f22003c);
                jSONObject.put("cls_name", this.d);
                jSONObject.put("url", this.h);
                jSONObject.put("isdestroy", this.i);
                jSONObject.put("effective", String.valueOf(this.g));
                jSONObject.put("key", this.f);
                jSONObject.put("checksum", this.e);
            } catch (Exception e) {
                com.getui.gtc.i.c.a.a(e);
            }
            return jSONObject.toString();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f22002a);
            parcel.writeString(this.b);
            parcel.writeString(this.f22003c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeLong(this.g);
            parcel.writeString(this.h);
            parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        }
    }

    public static a a(Map<String, String> map) {
        String str = map.get("ext_infos");
        a aVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar2 = new a();
            aVar2.b = jSONObject.getString("version");
            JSONArray jSONArray = jSONObject.getJSONArray(Contacts.People.Extensions.CONTENT_DIRECTORY);
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    C0351a c0351a = new C0351a();
                    c0351a.f22002a = jSONObject2.getInt("id");
                    c0351a.b = jSONObject2.getString("version");
                    c0351a.f22003c = jSONObject2.getString("name");
                    c0351a.d = jSONObject2.getString("cls_name");
                    c0351a.h = jSONObject2.getString("url");
                    c0351a.e = jSONObject2.getString("checksum");
                    c0351a.f = jSONObject2.getString("key");
                    if (jSONObject2.has("isdestroy")) {
                        c0351a.i = jSONObject2.getBoolean("isdestroy");
                    }
                    if (jSONObject2.has("effective")) {
                        long j = 0;
                        try {
                            j = Long.parseLong(jSONObject2.getString("effective")) * 1000;
                        } catch (Exception e) {
                            com.getui.gtc.i.c.a.b(e);
                        }
                        c0351a.g = j;
                    }
                    aVar2.f22001a.put(c0351a.f22002a, c0351a);
                    i = i2 + 1;
                }
            }
            aVar = aVar2;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
        String str2 = map.get("sdk.push.plugins");
        if (aVar != null && !TextUtils.isEmpty(str2)) {
            String[] split = str2.split(",");
            int length2 = split.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                try {
                    C0351a b = aVar.b(Integer.parseInt(split[i4]));
                    if (b != null) {
                        b.j = true;
                    }
                } catch (Exception e2) {
                }
                i3 = i4 + 1;
            }
        }
        return aVar;
    }

    public final C0351a a(int i) {
        SparseArray<C0351a> sparseArray = this.f22001a;
        return sparseArray.get(sparseArray.keyAt(i));
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.b);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(Contacts.People.Extensions.CONTENT_DIRECTORY, jSONArray);
            int size = this.f22001a.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                jSONArray.put(i2, new JSONObject(this.f22001a.get(this.f22001a.keyAt(i2)).a()));
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.getui.gtc.i.c.a.a(e);
        }
        return jSONObject.toString();
    }

    public final C0351a b(int i) {
        return this.f22001a.get(i);
    }

    public final void c(int i) {
        this.f22001a.removeAt(i);
    }
}
