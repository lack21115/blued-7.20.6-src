package com.kwad.components.core.offline.init.kwai;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/init/kwai/i.class */
public final class i extends IOfflineCompoWrapper {
    public i(String str) {
        super(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context unwrapContextIfNeed(Context context) {
        return com.kwai.sodler.lib.kwai.b.a.unwrapContextIfNeed(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context wrapContextIfNeed(Context context) {
        return com.kwai.sodler.lib.kwai.b.a.at(context, this.mOfflinePackageName);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Application wrapGetApplication(Context context) {
        return com.kwad.sdk.j.k.FP();
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        return com.kwai.sodler.lib.kwai.b.a.a(layoutInflater, this.mOfflinePackageName);
    }
}
