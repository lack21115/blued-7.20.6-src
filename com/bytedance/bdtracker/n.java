package com.bytedance.bdtracker;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/n.class */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f21263a = new n();

    public final JSONObject a(Context context) {
        Object systemService;
        if (context != null) {
            try {
                systemService = context.getSystemService(Context.CLIPBOARD_SERVICE);
            } catch (Throwable th) {
                return null;
            }
        } else {
            systemService = null;
        }
        if (systemService != null) {
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            if (primaryClip != null) {
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                Intrinsics.b(itemAt, "clipData.getItemAt(0)");
                String obj = itemAt.getText().toString();
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
                if (StringsKt.a(obj, "datatracer:", false, 2, (Object) null)) {
                    if (obj != null) {
                        String substring = obj.substring(11);
                        Intrinsics.b(substring, "(this as java.lang.String).substring(startIndex)");
                        Charset charset = Charsets.b;
                        if (substring != null) {
                            byte[] bytes = substring.getBytes(charset);
                            Intrinsics.b(bytes, "(this as java.lang.String).getBytes(charset)");
                            byte[] data = Base64.decode(bytes, 2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("?");
                            Intrinsics.b(data, "data");
                            sb.append(new String(data, Charsets.b));
                            return a(Uri.parse(sb.toString()));
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                return null;
            }
            return null;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    public final JSONObject a(Uri uri) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject = jSONObject2;
            if (uri != null) {
                String scheme = uri.getScheme();
                if (Intrinsics.a((Object) scheme, (Object) "http") || Intrinsics.a((Object) scheme, (Object) "https")) {
                    jSONObject2.put("tr_token", uri.getLastPathSegment());
                }
                Iterator<String> it = uri.getQueryParameterNames().iterator();
                while (true) {
                    jSONObject = jSONObject2;
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    jSONObject2.put(next, uri.getQueryParameter(next));
                }
            }
        } catch (Throwable th) {
            jSONObject = null;
        }
        return jSONObject;
    }
}
