package com.mokee.cloud.misc;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.mokee.cloud.requests.ChineseCalendarRequest;
import com.mokee.volley.DefaultRetryPolicy;
import com.mokee.volley.RequestQueue;
import com.mokee.volley.Response;
import com.mokee.volley.VolleyError;
import com.mokee.volley.VolleyLog;
import java.net.URI;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/misc/FetchChineseWorkdayTask.class */
public class FetchChineseWorkdayTask extends AsyncTask<Void, Void, Void> implements Response.Listener<String>, Response.ErrorListener {
    private static final String[] d = null;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f24216a;
    private RequestQueue b;

    /* renamed from: c  reason: collision with root package name */
    private String f24217c;

    static {
        String[] strArr = new String[5];
        throw new VerifyError("bad dex opcode");
    }

    public FetchChineseWorkdayTask(SharedPreferences sharedPreferences, RequestQueue requestQueue, int i) {
        boolean z = CloudUtils.b;
        this.f24216a = sharedPreferences;
        this.b = requestQueue;
        this.f24217c = String.valueOf(i);
        if (z) {
            VolleyError.b = !VolleyError.b;
        }
    }

    private void a(SharedPreferences sharedPreferences, RequestQueue requestQueue) {
        ChineseCalendarRequest chineseCalendarRequest = new ChineseCalendarRequest(1, URI.create(d[4]).toASCIIString(), this, this);
        chineseCalendarRequest.setRetryPolicy(new DefaultRetryPolicy(5000, 3, 1.0f));
        requestQueue.add(chineseCalendarRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        a(this.f24216a, this.b);
        return null;
    }

    @Override // com.mokee.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        VolleyLog.e(d[3], volleyError.getMessage());
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0056  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x00a1 -> B:6:0x003f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00e7 -> B:9:0x0059). Please submit an issue!!! */
    @Override // com.mokee.volley.Response.Listener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResponse(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.cloud.misc.FetchChineseWorkdayTask.onResponse(java.lang.String):void");
    }
}
