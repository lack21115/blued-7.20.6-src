package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il/l11l1111I1ll.class */
public final class l11l1111I1ll extends l111l1111lI1l {
    private Context l1111l111111Il;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l11l1111I1ll(Context context) {
        this.l1111l111111Il = context;
    }

    @Override // com.ishumei.l111l11111Il.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            return (String) cls.getMethod("getOAID", Context.class).invoke(cls.newInstance(), this.l1111l111111Il);
        } catch (Exception e) {
            return "";
        }
    }
}
