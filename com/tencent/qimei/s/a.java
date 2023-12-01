package com.tencent.qimei.s;

import com.tencent.qimei.s.c;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/s/a.class */
public class a extends c.a {
    public final /* synthetic */ c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, String str, String str2) {
        super(str, str2);
        this.d = cVar;
    }

    @Override // com.tencent.qimei.s.c.a
    public String a(String str) {
        String replace = str.replace("https://tun-cos-1258344701.file.myqcloud.com/fp.js", "tun-cos-1258344701.js");
        com.tencent.qimei.j.c.a(this.d.d, replace, "tun-cos-1258344701.html");
        return replace;
    }
}
