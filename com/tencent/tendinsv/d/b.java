package com.tencent.tendinsv.d;

import android.content.Context;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/d/b.class */
public class b extends d {
    public b(String str, Context context) {
        super(str, context);
    }

    @Override // com.tencent.tendinsv.d.d
    public void a(c cVar) {
        a(f.GET, null, cVar, false, "");
    }

    @Override // com.tencent.tendinsv.d.d
    public void a(Map<String, String> map, c cVar, Boolean bool, String str) {
        a(f.POST, map, cVar, bool, str);
    }
}
