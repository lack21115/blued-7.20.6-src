package com.huawei.openalliance.ad.ipc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.utils.at;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.v;
import java.io.Closeable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/b.class */
public class b {
    private static final String B = ".pps.apiprovider";
    private static final String C = ".pps.innerapiprovider";
    private static final String Code = "ApiCallManager";
    private static b V;
    private static final String Z = "content";
    private volatile Uri L;

    /* renamed from: a  reason: collision with root package name */
    private Context f9379a;
    private static final byte[] I = new byte[0];
    private static final String S = "com.huawei.hwid.pps.apiprovider";
    private static final String F = "/pps/api/call";
    private static final Uri D = new Uri.Builder().scheme("content").authority(S).path(F).build();

    private b(Context context) {
        this.f9379a = context.getApplicationContext();
    }

    private Uri Code(boolean z) {
        if (z) {
            return D;
        }
        int t = fk.Code(this.f9379a).t();
        ge.V(Code, "ads selection:" + t);
        if (v.V(this.f9379a) && (t == 0 || t == 2)) {
            return D;
        }
        if (v.I()) {
            if (this.L == null) {
                Uri.Builder scheme = new Uri.Builder().scheme("content");
                this.L = scheme.authority(this.f9379a.getPackageName() + C).path(F).build();
            }
            return this.L;
        }
        return D;
    }

    public static b Code(Context context) {
        b bVar;
        synchronized (I) {
            if (V == null) {
                V = new b(context);
            }
            bVar = V;
        }
        return bVar;
    }

    public <T> CallResult<T> Code(String str, String str2, Class<T> cls) {
        return Code(str, str2, cls, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> CallResult<T> Code(String str, String str2, Class<T> cls, boolean z) {
        String message;
        Cursor cursor;
        CallResult<T> callResult = (CallResult<T>) new CallResult();
        Cursor cursor2 = null;
        try {
            try {
                ge.V(Code, "call remote method: %s", str);
                if (ge.Code()) {
                    ge.Code(Code, "paramContent: %s", bc.Code(str2));
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sdk_version", "13.4.61.304");
                jSONObject.put("content", str2);
                Cursor query = this.f9379a.getContentResolver().query(Code(z), null, null, new String[]{str, jSONObject.toString()}, null);
                cursor = query;
                if (query != null) {
                    cursor = query;
                    if (query.moveToFirst()) {
                        int i = query.getInt(query.getColumnIndexOrThrow("code"));
                        callResult.setCode(i);
                        String string = query.getString(query.getColumnIndexOrThrow("content"));
                        ge.Code(Code, "call: %s code: %s result: %s", str, Integer.valueOf(i), string);
                        if (i == 200) {
                            callResult.setData(i.Code(string, cls));
                            cursor = query;
                        } else {
                            callResult.setMsg(string);
                            cursor = query;
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                ge.I(Code, "callRemote IllegalArgumentException");
                callResult.setCode(-1);
                message = e.getMessage();
                cursor2 = null;
                callResult.setMsg(message);
                cursor = cursor2;
                at.Code(cursor);
                ge.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
                return callResult;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("callRemote ");
                sb.append(th.getClass().getSimpleName());
                ge.I(Code, sb.toString());
                callResult.setCode(-1);
                message = th.getMessage();
                callResult.setMsg(message);
                cursor = cursor2;
                at.Code(cursor);
                ge.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
                return callResult;
            }
            at.Code(cursor);
            ge.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
            return callResult;
        } catch (Throwable th2) {
            at.Code((Closeable) str2);
            throw th2;
        }
    }
}
