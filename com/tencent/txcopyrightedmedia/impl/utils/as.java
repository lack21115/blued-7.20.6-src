package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import com.tencent.txcopyrightedmedia.impl.utils.i;
import com.tencent.txcopyrightedmedia.impl.utils.w;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/as.class */
public class as extends bb {

    /* renamed from: a  reason: collision with root package name */
    public String f26377a;
    private ArrayList<at> b;

    public as(ba baVar) {
        super(baVar);
        this.b = new ArrayList<>();
    }

    private w.d p() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Action", "DescribeMusicMaterials");
            jSONObject.put("PlayToken", this.k.e.f26390c);
            jSONObject.put("LicenseExtAppName", ap.a().d.f26372c);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("Original");
            jSONArray.put("Accompaniment");
            jSONArray.put("ChorusClip");
            jSONObject.put("MaterialTypes", jSONArray);
            jSONObject.put(TXCopyrightedMedia.EXT_INFO_PLAY_SCENE, m.a().a(TXCopyrightedMedia.EXT_INFO_PLAY_SCENE));
            str = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        w wVar = w.c.f26493a;
        return w.a(this.f26377a, str.getBytes(), "application/json");
    }

    private i q() {
        if (o().a()) {
            return new i(-5, "BGMPlayList data null.");
        }
        try {
            String str = new String(ac.a(o().f26397a, ac.a(f().f26396c.f), ac.a(f().f26396c.g), "PKCS5Padding"), "UTF-8");
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("Response");
                if (optJSONObject == null) {
                    i iVar = new i(-6, "Parse bgm playlist fail. Response not found.");
                    iVar.f26410a.a(str);
                    return iVar;
                }
                String optString = optJSONObject.optString("MusicId");
                if (!TextUtils.isEmpty(optString)) {
                    this.k.f26396c.f26387a = optString;
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("Error");
                if (optJSONObject2 != null) {
                    String optString2 = optJSONObject2.optString("Code");
                    if (optString2.contains("AuthFailure")) {
                        i iVar2 = new i(-3, "Token fail. ".concat(String.valueOf(optString2)));
                        iVar2.f26410a.a(str);
                        return iVar2;
                    }
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("MusicMaterialSet");
                if (optJSONArray == null) {
                    i iVar3 = new i(-6, "Parse bgm playlist fail. MusicMaterialSet not found.");
                    iVar3.f26410a.a(str);
                    return iVar3;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        return new i(0, null);
                    }
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                    String optString3 = optJSONObject3.optString("MaterialType");
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("DefinitionInfoSet");
                    if (optJSONArray2 != null) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < optJSONArray2.length()) {
                                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i4);
                                String optString4 = optJSONObject4.optString("Definition");
                                String optString5 = optJSONObject4.optString("Url");
                                String optString6 = optJSONObject4.optString("LyricsUrl");
                                String optString7 = optJSONObject4.optString("ExtName");
                                if (!TextUtils.isEmpty(optString5)) {
                                    at atVar = new at(this.k, optString4, optString3, optString5, optString7);
                                    synchronized (as.class) {
                                        this.b.add(atVar);
                                    }
                                    if (!TextUtils.isEmpty(optString6) && a("Subtitles", 3, l()) == null) {
                                        at atVar2 = new at(this.k, "Subtitles", optString3, optString6, "application/octet-stream");
                                        synchronized (as.class) {
                                            this.b.add(atVar2);
                                        }
                                    }
                                }
                                i3 = i4 + 1;
                            }
                        }
                    } else if (f().g.b == 1 && TextUtils.equals(optString3, "ChorusClip")) {
                        return new i(-10, "Resource " + i() + " " + j() + " not found.");
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new i(-6, "Parse bgm playlist fail. " + e.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            i iVar4 = new i(-5, "Content format error.");
            iVar4.f26410a.a(e2.toString());
            return iVar4;
        }
    }

    public final at a(String str, int i, int i2) {
        synchronized (as.class) {
            try {
                Iterator<at> it = this.b.iterator();
                while (it.hasNext()) {
                    at next = it.next();
                    if (TextUtils.equals(next.f26378a, str) && next.b == i && next.f26379c == i2) {
                        return next;
                    }
                }
                return null;
            } finally {
            }
        }
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.bb
    public final String b() {
        return this.f26377a;
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.bb
    public final String c() {
        return "txcm://bgmPlaylist/" + URLEncoder.encode(i()) + "/" + URLEncoder.encode(j());
    }

    public final ArrayList<at> d() {
        ArrayList<at> arrayList = new ArrayList<>();
        synchronized (as.class) {
            try {
                arrayList.addAll(this.b);
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final i e() {
        if (f().b) {
            return new i(-2, "Cancel by user.");
        }
        if (TextUtils.isEmpty(this.f26377a)) {
            return new i(-6, "Get url fail.");
        }
        if (g() != null && f().f26396c.e == 100) {
            this.m = g().a(c(), j());
        }
        if (o().a()) {
            w.d p = p();
            if (p == null) {
                return new i(-5, "Build describeMusicMaterials request fail.");
            }
            if (f().b) {
                return new i(-2, "Cancel by user.");
            }
            if (p.f26494a < 200 || p.f26494a >= 300) {
                i iVar = new i(-4, "Fetch " + this.f26377a + " fail. Status: " + p.f26494a);
                i.a aVar = iVar.f26410a;
                aVar.b = String.valueOf(p.f26494a);
                aVar.a(p.e);
                return iVar;
            }
            p.b = ac.a(p.b, ac.a(f().f26396c.f), ac.a(f().f26396c.g));
            if (p.b == null) {
                return new i(-5, "Fail encrypt bgm playlist.");
            }
            p.d = p.b.length;
            o().a(p.b, p.d);
            if (h().a() > 0) {
                g().a(this);
            }
        }
        i q = q();
        if (q.code != 0) {
            o().a(null, -1L);
            g().b(this);
        }
        return q;
    }
}
