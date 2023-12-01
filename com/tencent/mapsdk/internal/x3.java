package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetResponse;
import java.io.UnsupportedEncodingException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x3.class */
public class x3<OUT extends JsonComposer> extends u3 {

    /* renamed from: a  reason: collision with root package name */
    private Class<OUT> f38101a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x3$a.class */
    public static class a<OUT extends JsonComposer> extends NetResponse {

        /* renamed from: a  reason: collision with root package name */
        private String f38102a;
        private OUT b;

        public a(NetResponse netResponse) {
            clone(netResponse);
            if (netResponse.available()) {
                try {
                    this.f38102a = new String(netResponse.data, netResponse.charset);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        public a(NetResponse netResponse, Class<OUT> cls) {
            clone(netResponse);
            if (netResponse.available()) {
                try {
                    String str = new String(netResponse.data, netResponse.charset);
                    this.f38102a = str;
                    this.b = (OUT) JsonUtils.parseToModel(str, cls, new Object[0]);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        public String a() {
            return this.f38102a;
        }

        @Override // com.tencent.map.tools.net.NetResponse
        public boolean available() {
            String str;
            return (!super.available() || (str = this.f38102a) == null || TextUtils.isEmpty(str)) ? false : true;
        }

        public OUT b() {
            return this.b;
        }
    }

    public x3(Class<OUT> cls) {
        this.f38101a = cls;
    }

    @Override // com.tencent.mapsdk.internal.u3, com.tencent.mapsdk.internal.y3
    /* renamed from: b */
    public a<OUT> a(NetResponse netResponse) {
        return new a<>(netResponse, this.f38101a);
    }
}
