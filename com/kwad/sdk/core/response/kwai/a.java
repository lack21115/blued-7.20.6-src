package com.kwad.sdk.core.response.kwai;

import com.kwad.sdk.core.a.kwai.ev;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/kwai/a.class */
public class a implements b {
    private static final List<String> WHITE_LIST;
    private List<d<a>> mHolders;

    static {
        ArrayList arrayList = new ArrayList();
        WHITE_LIST = arrayList;
        arrayList.add("com.kwad.sdk.core.report.BaseReportAction");
    }

    private d<a> getHolder(Class<? extends a> cls) {
        if (a.class.equals(cls) || WHITE_LIST.contains(cls.getName())) {
            return null;
        }
        return ev.getHolder(cls);
    }

    private List<d<a>> getHolders() {
        if (this.mHolders == null) {
            this.mHolders = new ArrayList();
            Class<?> cls = getClass();
            while (true) {
                Class<?> cls2 = cls;
                if (cls2 == null || !a.class.isAssignableFrom(cls2)) {
                    break;
                }
                d<a> holder = getHolder(cls2);
                if (holder != null) {
                    this.mHolders.add(0, holder);
                }
                cls = cls2.getSuperclass();
            }
        }
        List<d<a>> list = this.mHolders;
        if (list == null || list.isEmpty()) {
            com.kwad.sdk.core.d.b.printStackTrace(new IllegalStateException("no holders for class: " + getClass()));
        }
        return this.mHolders;
    }

    public void afterParseJson(JSONObject jSONObject) {
    }

    public void afterToJson(JSONObject jSONObject) {
    }

    public void beforeToJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        List<d<a>> holders = getHolders();
        int size = holders.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                afterParseJson(jSONObject);
                return;
            } else {
                holders.get(i).a(this, jSONObject);
                size = i;
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        List<d<a>> holders = getHolders();
        JSONObject jSONObject = new JSONObject();
        beforeToJson(jSONObject);
        if (holders == null) {
            return jSONObject;
        }
        int size = holders.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                afterToJson(jSONObject);
                return jSONObject;
            }
            d<a> dVar = holders.get(i);
            if (dVar != null) {
                dVar.b(this, jSONObject);
            }
            size = i;
        }
    }

    public String toString() {
        return super.toString();
    }
}
