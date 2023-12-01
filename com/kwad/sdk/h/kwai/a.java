package com.kwad.sdk.h.kwai;

import android.content.Context;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/h/kwai/a.class */
public abstract class a implements c {
    protected List<c> axx;
    protected boolean enabled;

    public a() {
        this.enabled = true;
    }

    public a(boolean z) {
        this.enabled = z;
    }

    private List<c> getChildren() {
        return this.axx;
    }

    @Override // com.kwad.sdk.h.kwai.c
    public final boolean br(Context context) {
        if (this.enabled) {
            List<c> children = getChildren();
            if (children == null || children.size() <= 0) {
                try {
                    return bs(context);
                } catch (Throwable th) {
                    return false;
                }
            }
            for (c cVar : children) {
                if (cVar.br(context)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    protected boolean bs(Context context) {
        return false;
    }
}
