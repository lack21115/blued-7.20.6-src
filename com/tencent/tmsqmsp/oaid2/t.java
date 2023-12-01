package com.tencent.tmsqmsp.oaid2;

import android.os.AsyncTask;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/t.class */
public class t extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public q f25972a;
    public s b;

    public t(q qVar, s sVar) {
        this.f25972a = qVar;
        this.b = sVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Void... voidArr) {
        boolean c2;
        s sVar;
        if (this.f25972a == null) {
            return Boolean.FALSE;
        }
        int i = 0;
        while (true) {
            try {
                c2 = this.f25972a.c();
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
        if (c2 && (sVar = this.b) != null) {
            sVar.a(true);
        }
        return Boolean.valueOf(c2);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
    }
}
