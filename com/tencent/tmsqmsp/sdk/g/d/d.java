package com.tencent.tmsqmsp.sdk.g.d;

import android.os.AsyncTask;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/d/d.class */
public class d extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public a f39779a;
    public c b;

    public d(a aVar, c cVar) {
        this.f39779a = aVar;
        this.b = cVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Void... voidArr) {
        boolean c2;
        c cVar;
        if (this.f39779a == null) {
            return Boolean.FALSE;
        }
        int i = 0;
        while (true) {
            try {
                c2 = this.f39779a.c();
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

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
    }
}
