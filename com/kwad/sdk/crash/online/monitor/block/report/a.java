package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/online/monitor/block/report/a.class */
public class a extends d {
    public static int HE = 1;
    private static volatile a asd;

    private a(Context context) {
        super(new com.kwad.sdk.crash.online.monitor.block.kwai.a(context, HE));
    }

    public static a bn(Context context) {
        if (asd == null) {
            synchronized (a.class) {
                try {
                    if (asd == null) {
                        asd = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return asd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* renamed from: h */
    public BlockReportAction e(Cursor cursor) {
        synchronized (this) {
            int columnIndex = cursor.getColumnIndex("aLog");
            if (columnIndex < 0) {
                return new BlockReportAction("");
            }
            try {
                return new BlockReportAction(new JSONObject(cursor.getString(columnIndex)));
            } catch (JSONException e) {
                b.printStackTrace(e);
                return new BlockReportAction("");
            }
        }
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String wU() {
        return "ksad_block_actions";
    }
}
