package com.tencent.qmsp.sdk.g.d;

import android.os.AsyncTask;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/d/d.class */
public class d extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public a f24938a;
    public c b;

    public d(a aVar, c cVar) {
        this.f24938a = aVar;
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Void... voidArr) {
        boolean c2;
        c cVar;
        int i = 0;
        if (this.f24938a == null) {
            return false;
        }
        while (true) {
            try {
                c2 = this.f24938a.c();
            } catch (InterruptedException e) {
            }
            if (c2) {
                break;
            }
            Thread.sleep(10L);
            int i2 = i + 1;
            i = i2;
            if (i2 >= 30) {
                break;
            }
        }
        if (c2 && (cVar = this.b) != null) {
            cVar.a(true);
        }
        return Boolean.valueOf(c2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
    }
}
