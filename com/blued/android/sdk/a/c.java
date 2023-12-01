package com.blued.android.sdk.a;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.sdk.BluedSDK;
import com.blued.android.sdk.a.e;
import com.blued.android.sdk.model.BluedEntity;
import com.blued.android.sdk.model.EmptyModel;
import com.blued.android.sdk.model.ModelCallback;
import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/sdk/a/c.class */
public class c {
    public static <T> void a(final e.a aVar, final String str, final Map<String, String> map, final Map<String, String> map2, final Type type, final ModelCallback<T> modelCallback) {
        new AsyncTask() { // from class: com.blued.android.sdk.a.c.1

            /* renamed from: a  reason: collision with root package name */
            int f18653a = -1;
            String b = "";

            /* renamed from: c  reason: collision with root package name */
            T f18654c = null;

            /* JADX WARN: Type inference failed for: r1v18, types: [T, com.blued.android.sdk.model.EmptyModel] */
            /* JADX WARN: Type inference failed for: r1v21, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r1v23, types: [T, java.util.List<T>] */
            @Override // android.os.AsyncTask
            protected Object doInBackground(Object[] objArr) {
                BluedEntity bluedEntity;
                try {
                    URL url = new URL(String.this);
                    if (BluedSDK.DEBUG) {
                        String str2 = BluedSDK.TAG;
                        Log.v(str2, "start get link:" + url);
                    }
                    HttpURLConnection a2 = e.a(aVar, url, map, map2);
                    int responseCode = a2.getResponseCode();
                    this.f18653a = responseCode;
                    String a3 = e.a(a2);
                    if (BluedSDK.DEBUG) {
                        String str3 = BluedSDK.TAG;
                        Log.v(str3, "response get link:" + url + ", status:" + this.f18653a + ", response:" + a3);
                    }
                    if (TextUtils.isEmpty(a3) || (bluedEntity = (BluedEntity) new Gson().fromJson(a3, type)) == null) {
                        return null;
                    }
                    this.f18653a = bluedEntity.code;
                    this.b = bluedEntity.message;
                    if (modelCallback == null || responseCode < 200 || responseCode >= 300) {
                        return null;
                    }
                    String obj = ((ParameterizedType) modelCallback.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0].toString();
                    if (BluedSDK.DEBUG) {
                        String str4 = BluedSDK.TAG;
                        Log.v(str4, "response get link:" + url + ", modelTypeString:" + obj);
                    }
                    if (bluedEntity.data != null) {
                        if (obj.contains("java.util.List")) {
                            this.f18654c = bluedEntity.data;
                            return null;
                        } else if (bluedEntity.data.size() > 0) {
                            this.f18654c = bluedEntity.data.get(0);
                            return null;
                        } else if (obj.contains(EmptyModel.class.getSimpleName())) {
                            this.f18654c = new EmptyModel();
                            return null;
                        } else {
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th.printStackTrace();
                    this.b = th.toString();
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                ModelCallback modelCallback2 = modelCallback;
                if (modelCallback2 != null) {
                    T t = this.f18654c;
                    if (t != 0) {
                        modelCallback2.onModel(t);
                    } else {
                        modelCallback2.onFailed(this.f18653a, this.b);
                    }
                }
            }
        }.execute(new Object[0]);
    }

    public static <T> void a(String str, Map<String, String> map, Type type, ModelCallback<T> modelCallback) {
        a(e.a.Get, str, map, null, type, modelCallback);
    }

    public static <T> void a(String str, Map<String, String> map, Map<String, String> map2, Type type, ModelCallback<T> modelCallback) {
        a(e.a.Post, str, map, map2, type, modelCallback);
    }
}
