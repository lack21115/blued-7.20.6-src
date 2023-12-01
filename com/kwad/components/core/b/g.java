package com.kwad.components.core.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/g.class */
public final class g implements h, Comparable<g> {
    private final String Ic;
    private final String Ij;
    private final String Ik;
    private final String Il;
    private final long Im;
    private String In = null;
    private final long createTime;
    private final int ecpm;

    private g(String str, String str2, String str3, int i, String str4, long j, long j2) {
        this.Ij = str;
        this.Ic = str2;
        this.Ik = str3;
        this.ecpm = i;
        this.Il = str4;
        this.createTime = j;
        this.Im = j2;
    }

    public static List<g> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
        }
        return arrayList;
    }

    public static List<g> a(e eVar, AdResultData adResultData) {
        AdResultData adResultData2 = adResultData;
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis / 1000;
        long mi = eVar.mi();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        for (AdTemplate adTemplate : proceedTemplateList) {
            long cl = com.kwad.sdk.core.response.a.d.cl(adTemplate);
            long posId = adResultData.getPosId();
            g gVar = new g(String.valueOf(cl), String.valueOf(posId), new AdResultData(adResultData2, defaultAdScene, Collections.singletonList(adTemplate)).getResponseJson(), com.kwad.sdk.core.response.a.d.cq(adTemplate), adResultData.getDefaultAdScene().toJson().toString(), size + currentTimeMillis, j + mi);
            if (adTemplate.hasPlayAgain()) {
                gVar.ak(new AdResultData(adResultData, defaultAdScene, Collections.singletonList(adTemplate.mPlayAgain)).getResponseJson());
            }
            arrayList.add(gVar);
            size--;
            adResultData2 = adResultData;
        }
        return arrayList;
    }

    private void ak(String str) {
        this.In = str;
    }

    private static g c(Cursor cursor) {
        g gVar;
        synchronized (g.class) {
            try {
                String string = cursor.getString(cursor.getColumnIndex("creativeId"));
                String string2 = cursor.getString(cursor.getColumnIndex("posId"));
                String string3 = cursor.getString(cursor.getColumnIndex("adJson"));
                int i = cursor.getInt(cursor.getColumnIndex(SplashAd.KEY_BIDFAIL_ECPM));
                String string4 = cursor.getString(cursor.getColumnIndex("adSenseJson"));
                long j = cursor.getLong(cursor.getColumnIndex("createTime"));
                long j2 = cursor.getLong(cursor.getColumnIndex("expireTime"));
                String string5 = cursor.getString(cursor.getColumnIndex("playAgainJson"));
                gVar = new g(string, string2, string3, i, string4, j, j2);
                gVar.ak(string5);
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    private static AdResultData c(g gVar) {
        if (gVar == null) {
            return null;
        }
        if (gVar.mm() == null || gVar.mq() == null) {
            com.kwad.sdk.core.d.b.w("CachedAd", "createAdResultData cachedAd data illegal");
            return null;
        }
        try {
            String mq = gVar.mq();
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(mq));
            AdResultData createFromResponseJson = AdResultData.createFromResponseJson(gVar.mm(), sceneImpl);
            String ms = gVar.ms();
            if (!TextUtils.isEmpty(ms)) {
                AdTemplate firstAdTemplate = createFromResponseJson.getFirstAdTemplate();
                AdResultData createFromResponseJson2 = AdResultData.createFromResponseJson(ms, sceneImpl);
                for (AdTemplate adTemplate : createFromResponseJson2.getProceedTemplateList()) {
                    adTemplate.fromCache = true;
                }
                firstAdTemplate.setPlayAgain(createFromResponseJson2.getFirstAdTemplate());
            }
            for (AdTemplate adTemplate2 : createFromResponseJson.getProceedTemplateList()) {
                adTemplate2.fromCache = true;
            }
            return createFromResponseJson;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(g gVar) {
        return gVar.mn() == mn() ? (int) (gVar.mo() - mo()) : gVar.mn() - mn();
    }

    public static AdResultData h(List<g> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultData = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        SceneImpl sceneImpl = null;
        for (g gVar : list) {
            AdResultData c2 = c(gVar);
            adResultData = c2;
            if (c2 != null) {
                SceneImpl sceneImpl2 = sceneImpl;
                if (sceneImpl == null) {
                    sceneImpl2 = c2.getDefaultAdScene();
                }
                arrayList.addAll(c2.getProceedTemplateList());
                adResultData = c2;
                sceneImpl = sceneImpl2;
            }
        }
        return new AdResultData(adResultData, sceneImpl, arrayList);
    }

    private String mm() {
        return this.Ik;
    }

    private int mn() {
        return this.ecpm;
    }

    private long mo() {
        return this.createTime;
    }

    private String mq() {
        return this.Il;
    }

    private String ms() {
        return this.In;
    }

    @Override // com.kwad.components.core.b.h
    public final ContentValues mj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.Ij);
        contentValues.put("posId", this.Ic);
        contentValues.put("adJson", this.Ik);
        contentValues.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.Il);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.Im));
        contentValues.put("playAgainJson", this.In);
        return contentValues;
    }

    public final String ml() {
        return this.Ic;
    }

    public final long mp() {
        return this.Im;
    }

    public final String mr() {
        return this.Ij;
    }
}
