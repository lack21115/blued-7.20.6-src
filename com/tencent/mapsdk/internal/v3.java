package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetResponse;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v3.class */
public class v3 extends u3 {

    /* renamed from: a  reason: collision with root package name */
    private String f38060a;
    private String b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v3$a.class */
    public static class a extends NetResponse {

        /* renamed from: a  reason: collision with root package name */
        private File f38061a;

        public a(NetResponse netResponse, String str, String str2) {
            clone(netResponse);
            if (netResponse.available()) {
                this.f38061a = new File(str, str2);
                File file = new File(str, str2 + ".tmp");
                ga.d(file);
                if (ga.b(file) && ga.b(file, netResponse.data) && ga.b(file, this.f38061a)) {
                    ga.d(file);
                }
            }
        }

        public File a() {
            return this.f38061a;
        }

        @Override // com.tencent.map.tools.net.NetResponse
        public boolean available() {
            File file;
            return super.available() && (file = this.f38061a) != null && file.exists();
        }
    }

    public v3(String str) {
        this.f38060a = str;
    }

    @Override // com.tencent.mapsdk.internal.u3, com.tencent.mapsdk.internal.y3
    public Object[] a(int[] iArr, Object[] objArr) {
        if (objArr != null && iArr != null && iArr.length == 1 && objArr.length > 0) {
            Object obj = objArr[iArr[0]];
            if (obj instanceof String) {
                this.b = String.valueOf(obj);
            }
        }
        return super.a(iArr, objArr);
    }

    @Override // com.tencent.mapsdk.internal.u3, com.tencent.mapsdk.internal.y3
    /* renamed from: b */
    public a a(NetResponse netResponse) {
        return new a(netResponse, this.b, this.f38060a);
    }
}
