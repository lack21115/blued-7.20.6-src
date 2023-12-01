package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/w.class */
public final class w {
    private final e axv;
    private final boolean axw;

    public w(e eVar) {
        this.axv = eVar;
        this.axw = !(eVar instanceof f);
    }

    private List<? extends t> ep(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.axv.W("tEXt", str));
        arrayList.addAll(this.axv.W("zTXt", str));
        arrayList.addAll(this.axv.W("iTXt", str));
        return arrayList;
    }

    public final String eq(String str) {
        List<? extends t> ep = ep(str);
        if (ep.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (t tVar : ep) {
            sb.append(tVar.Ch());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
