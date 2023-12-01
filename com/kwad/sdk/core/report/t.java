package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/t.class */
public class t extends d {
    private static volatile t ajQ;
    private final List<r> ajR;

    private t(Context context) {
        super(new s(context, s.HE));
        ArrayList arrayList = new ArrayList();
        this.ajR = arrayList;
        arrayList.add(new k());
    }

    public static t aU(Context context) {
        if (ajQ == null) {
            synchronized (t.class) {
                try {
                    if (ajQ == null) {
                        ajQ = new t(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ajQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* renamed from: f */
    public q e(Cursor cursor) {
        synchronized (this) {
            try {
                JSONObject jSONObject = new JSONObject(cursor.getString(cursor.getColumnIndex("aLog")));
                int size = this.ajR.size() - 1;
                if (size >= 0) {
                    return this.ajR.get(size).h(jSONObject);
                }
                return new q(jSONObject);
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
                return new q("");
            }
        }
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String getTag() {
        return "ReportActionDBManager";
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String wU() {
        return "ksad_actions";
    }
}
