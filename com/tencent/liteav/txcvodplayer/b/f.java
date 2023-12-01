package com.tencent.liteav.txcvodplayer.b;

import android.media.MediaFormat;
import com.cdo.oaps.ad.OapsKey;
import com.sobot.network.http.model.SobotProgress;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.b.c;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    protected JSONObject f22847a;
    public g b;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f22848a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public List<Integer> f22849c;
    }

    public f(JSONObject jSONObject) {
        this.f22847a = jSONObject;
    }

    private static List<c.C0764c> a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("keyFrameDescList");
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return arrayList;
            }
            String string = jSONArray.getJSONObject(i2).getString("content");
            float f = (float) (jSONArray.getJSONObject(i2).getLong("timeOffset") / 1000.0d);
            c.C0764c c0764c = new c.C0764c();
            try {
                c0764c.f22839a = URLDecoder.decode(string, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                c0764c.f22839a = "";
            }
            c0764c.b = f;
            arrayList.add(c0764c);
            i = i2 + 1;
        }
    }

    private g l() {
        try {
            JSONObject jSONObject = this.f22847a.getJSONObject("videoInfo").getJSONObject("masterPlayList");
            g gVar = new g();
            gVar.f22850a = jSONObject.getString("url");
            return gVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String m() {
        try {
            return this.f22847a.getJSONObject("playerInfo").getString("defaultVideoClassification");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Integer> n() {
        List<a> k = k();
        String m = m();
        if (m == null || k == null) {
            return null;
        }
        for (a aVar : k) {
            if (aVar.f22848a.equals(m)) {
                return aVar.f22849c;
            }
        }
        return null;
    }

    public final String a() {
        if (this.b == null) {
            this.b = c();
        }
        g gVar = this.b;
        if (gVar != null) {
            return gVar.f22850a;
        }
        return null;
    }

    public final int b() {
        if (this.b == null) {
            this.b = c();
        }
        g gVar = this.b;
        if (gVar != null) {
            return gVar.e;
        }
        return -1;
    }

    public final g c() {
        if (l() != null) {
            return l();
        }
        if (e().size() != 0) {
            List<Integer> n = n();
            if (n != null) {
                for (g gVar : e()) {
                    if (n.contains(Integer.valueOf(gVar.i))) {
                        return gVar;
                    }
                }
            }
            return e().get(0);
        }
        return f();
    }

    public final String d() {
        try {
            JSONObject jSONObject = this.f22847a.getJSONObject("coverInfo");
            if (jSONObject != null) {
                return jSONObject.getString("coverUrl");
            }
            return null;
        } catch (JSONException e) {
            LiteavLog.e("TXPlayInfoResponse", "get cover url failed.", e);
            return null;
        }
    }

    public final List<g> e() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = this.f22847a.getJSONObject("videoInfo").getJSONArray("transcodeList");
            if (jSONArray != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    g gVar = new g();
                    gVar.f22850a = jSONObject.getString("url");
                    gVar.e = jSONObject.getInt("duration");
                    gVar.f22851c = jSONObject.getInt("width");
                    gVar.b = jSONObject.getInt("height");
                    gVar.d = Math.max(jSONObject.getInt(SobotProgress.TOTAL_SIZE), jSONObject.getInt(OapsKey.KEY_SIZE));
                    gVar.f = jSONObject.getInt(MediaFormat.KEY_BIT_RATE);
                    gVar.i = jSONObject.getInt("definition");
                    gVar.g = jSONObject.getString("container");
                    gVar.h = jSONObject.getString("templateName");
                    arrayList.add(gVar);
                    i = i2 + 1;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final g f() {
        try {
            JSONObject jSONObject = this.f22847a.getJSONObject("videoInfo").getJSONObject("sourceVideo");
            g gVar = new g();
            gVar.f22850a = jSONObject.getString("url");
            gVar.e = jSONObject.getInt("duration");
            gVar.f22851c = jSONObject.getInt("width");
            gVar.b = jSONObject.getInt("height");
            gVar.d = Math.max(jSONObject.getInt(OapsKey.KEY_SIZE), jSONObject.getInt(SobotProgress.TOTAL_SIZE));
            gVar.f = jSONObject.getInt(MediaFormat.KEY_BIT_RATE);
            return gVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String g() {
        try {
            JSONObject jSONObject = this.f22847a.getJSONObject("videoInfo").getJSONObject("basicInfo");
            if (jSONObject != null) {
                return jSONObject.getString("name");
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String h() {
        try {
            JSONObject jSONObject = this.f22847a.getJSONObject("videoInfo").getJSONObject("basicInfo");
            if (jSONObject != null) {
                return jSONObject.getString("description");
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final c.b i() {
        JSONObject optJSONObject = this.f22847a.optJSONObject("imageSpriteInfo");
        if (optJSONObject == null) {
            return null;
        }
        try {
            JSONArray jSONArray = optJSONObject.getJSONArray("imageSpriteList");
            if (jSONArray == null) {
                return null;
            }
            JSONObject jSONObject = jSONArray.getJSONObject(jSONArray.length() - 1);
            c.b bVar = new c.b();
            bVar.b = jSONObject.getString("webVttUrl");
            JSONArray jSONArray2 = jSONObject.getJSONArray("imageUrls");
            ArrayList<String> arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray2.length()) {
                    bVar.f22838a = arrayList;
                    return bVar;
                }
                arrayList.add(jSONArray2.getString(i2));
                i = i2 + 1;
            }
        } catch (JSONException e) {
            LiteavLog.e("TXPlayInfoResponse", "v2 getImageSpriteInfo exception");
            return null;
        }
    }

    public final List<c.C0764c> j() {
        JSONObject optJSONObject = this.f22847a.optJSONObject("keyFrameDescInfo");
        if (optJSONObject != null) {
            try {
                return a(optJSONObject);
            } catch (JSONException e) {
                LiteavLog.e("TXPlayInfoResponse", "v2 parseKeyFrameDescInfo exception");
                return null;
            }
        }
        return null;
    }

    public final List<a> k() {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = this.f22847a.getJSONObject("playerInfo").getJSONArray("videoClassification");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return arrayList;
                }
                a aVar = new a();
                aVar.f22848a = jSONArray.getJSONObject(i2).getString("id");
                aVar.b = jSONArray.getJSONObject(i2).getString("name");
                aVar.f22849c = new ArrayList();
                JSONArray jSONArray2 = jSONArray.getJSONObject(i2).getJSONArray("definitionList");
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= jSONArray2.length()) {
                        break;
                    }
                    aVar.f22849c.add(Integer.valueOf(jSONArray2.getInt(i4)));
                    i3 = i4 + 1;
                }
                arrayList.add(aVar);
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
