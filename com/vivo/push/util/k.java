package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.vivo.push.d.r;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/k.class */
public final class k extends AsyncTask<String, Void, List<Bitmap>> {

    /* renamed from: a  reason: collision with root package name */
    private Context f27447a;
    private InsideNotificationItem b;

    /* renamed from: c  reason: collision with root package name */
    private long f27448c;
    private boolean d;
    private int e = 0;
    private r.a f;

    public k(Context context, InsideNotificationItem insideNotificationItem, long j, boolean z, r.a aVar) {
        this.f27447a = context;
        this.b = insideNotificationItem;
        this.f27448c = j;
        this.d = z;
        this.f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0101, code lost:
        if (r10 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0104, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x011d, code lost:
        if (r10 == null) goto L50;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<android.graphics.Bitmap> doInBackground(java.lang.String... r5) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.k.doInBackground(java.lang.String[]):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        p.c("ImageDownTask", "onPostExecute");
        com.vivo.push.m.c(new l(this, list2));
    }
}
