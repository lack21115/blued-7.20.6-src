package com.tencent.mapsdk.internal;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.tools.net.NetResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/w3.class */
public class w3<IN extends MapJceStruct, OUT extends MapJceStruct> extends u3 {

    /* renamed from: a  reason: collision with root package name */
    private Class<IN> f38084a;
    private Class<OUT> b;

    /* renamed from: c  reason: collision with root package name */
    private MapJceStruct f38085c;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/w3$a.class */
    public static class a<OUT extends MapJceStruct> extends NetResponse {

        /* renamed from: a  reason: collision with root package name */
        private OUT f38086a;

        public a(NetResponse netResponse, Class<OUT> cls) {
            clone(netResponse);
            byte[] bArr = netResponse.data;
            if (bArr != null) {
                m mVar = new m(bArr);
                OUT out = (OUT) e7.a(cls, new Object[0]);
                this.f38086a = out;
                if (out != null) {
                    out.readFrom(mVar);
                }
            }
            na.c(ma.g, "[JCE-RESP]:" + this.f38086a);
        }

        public OUT a() {
            return this.f38086a;
        }

        @Override // com.tencent.map.tools.net.NetResponse
        public boolean available() {
            return super.available() && this.f38086a != null;
        }
    }

    public w3(Class<IN> cls, Class<OUT> cls2) {
        this.f38084a = cls;
        this.b = cls2;
    }

    @Override // com.tencent.mapsdk.internal.u3, com.tencent.mapsdk.internal.y3
    public Object[] a(int[] iArr, Object[] objArr) {
        if (objArr != null && iArr != null && iArr.length > 0 && objArr.length > 0) {
            List asList = Arrays.asList(objArr);
            int i = iArr[0];
            int i2 = iArr.length == 1 ? iArr[0] : iArr[1];
            if (objArr.length - 1 >= i2 && i >= 0) {
                MapJceStruct mapJceStruct = (MapJceStruct) e7.a(this.f38084a, Arrays.copyOfRange(objArr, i, i2 + 1));
                this.f38085c = mapJceStruct;
                byte[] bArr = new byte[0];
                if (mapJceStruct != null) {
                    bArr = mapJceStruct.toByteArray();
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < asList.size(); i3++) {
                    if (i3 < i || i3 > i2) {
                        arrayList.add(asList.get(i3));
                    } else if (i3 == i2) {
                        arrayList.add(bArr);
                    }
                }
                return arrayList.toArray();
            }
        }
        return super.a(iArr, objArr);
    }

    @Override // com.tencent.mapsdk.internal.u3, com.tencent.mapsdk.internal.y3
    /* renamed from: b */
    public a<OUT> a(NetResponse netResponse) {
        return new a<>(netResponse, this.b);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("JceResolver{");
        stringBuffer.append("inJce=");
        stringBuffer.append(this.f38085c);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
