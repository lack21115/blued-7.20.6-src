package com.tencent.liteav.txcvodplayer.b;

import android.provider.MediaStore;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.b.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f22826a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f22827c;
    int d;
    public int e;
    public List<c.d> f;
    public String g;
    String h;
    public String i;
    public c.b j;
    public List<c.C0764c> k;
    private JSONObject l;
    private String m;
    private List<a> n;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f22828a;
        public String b;
    }

    public b(JSONObject jSONObject) {
        this.l = jSONObject;
        b();
    }

    private void a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.f = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return;
            }
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            c.d dVar = new c.d();
            int optInt = jSONObject.optInt("width");
            int optInt2 = jSONObject.optInt("height");
            dVar.b = optInt;
            dVar.f22841c = optInt2;
            dVar.f22840a = jSONObject.optString("resolutionName");
            dVar.d = jSONObject.optString("type");
            this.f.add(dVar);
            i = i2 + 1;
        }
    }

    private void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("keyFrameDescInfo");
        if (optJSONObject == null) {
            return;
        }
        this.k = new ArrayList();
        JSONArray optJSONArray = optJSONObject.optJSONArray("keyFrameDescList");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return;
            }
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = optJSONArray.getJSONObject(i2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c.C0764c c0764c = new c.C0764c();
            c0764c.b = (float) jSONObject2.optLong("timeOffset");
            c0764c.f22839a = jSONObject2.optString("content");
            this.k.add(c0764c);
            i = i2 + 1;
        }
    }

    private String b(String str) {
        for (a aVar : this.n) {
            if (aVar.f22828a != null && aVar.f22828a.equalsIgnoreCase(str)) {
                return aVar.b;
            }
        }
        return null;
    }

    private void b() {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = this.l.getJSONObject(MediaStore.AUTHORITY);
            if (jSONObject != null) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("basicInfo");
                if (optJSONObject2 != null) {
                    this.f22826a = optJSONObject2.optString("name");
                    String optString = optJSONObject2.optString("description");
                    this.b = optString;
                    if (TextUtils.isEmpty(optString)) {
                        this.b = this.f22826a;
                    }
                    this.f22827c = optJSONObject2.optString("coverUrl");
                    this.d = optJSONObject2.optInt("duration");
                    this.e = optJSONObject2.optInt(OapsKey.KEY_SIZE);
                }
                String optString2 = jSONObject.optString("audioVideoType");
                if (TextUtils.equals(optString2, "AdaptiveDynamicStream")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("streamingInfo");
                    if (jSONObject2 != null) {
                        JSONObject optJSONObject3 = jSONObject2.optJSONObject("plainOutput");
                        if (optJSONObject3 != null) {
                            this.m = optJSONObject3.optString("url");
                            a(optJSONObject3.optJSONArray("subStreams"));
                        }
                        JSONArray optJSONArray = jSONObject2.optJSONArray("drmOutput");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            this.n = new ArrayList();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= optJSONArray.length()) {
                                    break;
                                }
                                JSONObject optJSONObject4 = optJSONArray.optJSONObject(i2);
                                String optString3 = optJSONObject4.optString("type");
                                String optString4 = optJSONObject4.optString("url");
                                a aVar = new a();
                                aVar.f22828a = optString3;
                                aVar.b = optString4;
                                this.h = optString3;
                                this.n.add(aVar);
                                a(optJSONObject4.optJSONArray("subStreams"));
                                i = i2 + 1;
                            }
                        }
                        this.g = jSONObject2.optString("drmToken");
                        this.i = jSONObject2.optString("widevineLicenseUrl");
                    }
                } else if (TextUtils.equals(optString2, "Transcode")) {
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("transcodeInfo");
                    if (optJSONObject5 != null) {
                        this.m = optJSONObject5.optString("url");
                    }
                } else if (TextUtils.equals(optString2, "Original") && (optJSONObject = jSONObject.optJSONObject("originalInfo")) != null) {
                    this.m = optJSONObject.optString("url");
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imageSpriteInfo");
                if (optJSONObject6 != null) {
                    c.b bVar = new c.b();
                    this.j = bVar;
                    bVar.b = optJSONObject6.getString("webVttUrl");
                    JSONArray optJSONArray2 = optJSONObject6.optJSONArray("imageUrls");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= optJSONArray2.length()) {
                                break;
                            }
                            arrayList.add(optJSONArray2.getString(i4));
                            i3 = i4 + 1;
                        }
                        this.j.f22838a = arrayList;
                    }
                }
                a(jSONObject);
            }
        } catch (JSONException e) {
            LiteavLog.e("TXCPlayInfoParserV4", e.getMessage());
        }
    }

    public final String a() {
        if (TextUtils.isEmpty(this.g)) {
            return null;
        }
        return this.g;
    }

    public final String a(String str) {
        String str2 = this.m;
        if (!TextUtils.isEmpty(this.g)) {
            str2 = b(str);
        }
        return str2;
    }
}
