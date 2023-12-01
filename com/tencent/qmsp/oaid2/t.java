package com.tencent.qmsp.oaid2;

import android.os.AsyncTask;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/t.class */
public class t extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public q f38504a;
    public s b;

    public t(q qVar, s sVar) {
        this.f38504a = qVar;
        this.b = sVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Void... voidArr) {
        boolean c2;
        s sVar;
        int i = 0;
        if (this.f38504a == null) {
            return false;
        }
        while (true) {
            try {
                c2 = this.f38504a.c();
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
