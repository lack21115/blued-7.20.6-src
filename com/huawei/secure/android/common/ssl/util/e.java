package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/util/e.class */
public class e extends AsyncTask<Context, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23130a = e.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e) {
            String str = f23130a;
            g.b(str, "doInBackground: exception : " + e.getMessage());
            inputStream = null;
        }
        String str2 = f23130a;
        g.a(str2, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream != null) {
            f.a(inputStream);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            g.c(f23130a, "onPostExecute: upate done");
        } else {
            g.b(f23130a, "onPostExecute: upate failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        g.c(f23130a, "onProgressUpdate");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPreExecute() {
        g.a(f23130a, "onPreExecute");
    }
}