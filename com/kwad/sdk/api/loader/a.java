package com.kwad.sdk.api.loader;

import android.provider.Downloads;
import com.umeng.analytics.pro.bh;
import java.io.File;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/a.class */
final class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/a$a.class */
    static final class C0379a {
        String Tf;
        int Zk;
        String Zl;
        transient File Zm;
        long interval;
        String sdkVersion;

        C0379a() {
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.Zk = jSONObject.optInt("dynamicType");
            this.Zl = jSONObject.optString("dynamicUrl");
            this.Tf = jSONObject.optString("md5");
            this.interval = jSONObject.optLong(bh.aX);
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }

        public final boolean tl() {
            return this.Zk == 1;
        }

        public final boolean tm() {
            return this.Zk == -1;
        }

        public final String toString() {
            return "Data{dynamicType=" + this.Zk + ", dynamicUrl='" + this.Zl + "', md5='" + this.Tf + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.Zm + '}';
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/a$b.class */
    static final class b {
        long Zn;
        C0379a Zo;
        String errorMsg;

        public final void parseJson(JSONObject jSONObject) {
            this.Zn = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString(Downloads.Impl.COLUMN_ERROR_MSG);
            C0379a c0379a = new C0379a();
            this.Zo = c0379a;
            c0379a.parseJson(jSONObject.optJSONObject("data"));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean tn() {
            return this.Zn == 1 && this.Zo != null;
        }

        public final String toString() {
            return "UpdateData{result=" + this.Zn + ", errorMsg='" + this.errorMsg + "', data=" + this.Zo + '}';
        }
    }
}
