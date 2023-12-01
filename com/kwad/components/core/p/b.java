package com.kwad.components.core.p;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.huawei.openalliance.ad.constant.at;
import com.kwad.components.core.webview.a.b.d;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/p/b.class */
public final class b extends d {
    protected com.kwad.components.core.webview.a.d.c Pv;

    public static b a(b bVar, Activity activity, com.kwad.components.core.webview.a.d.c cVar) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        bVar.Pv = cVar;
        bVar.show(activity.getFragmentManager(), "webTKCloseDialog");
        return bVar;
    }

    public static b a(d.b bVar) {
        b bVar2 = new b();
        bVar2.mAdTemplate = bVar.getAdTemplate();
        bVar2.Vt = bVar.getTemplateId();
        Bundle bundle = new Bundle();
        bundle.putString(at.C, bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    @Override // com.kwad.components.core.webview.a.b.d
    public final com.kwad.components.core.webview.a.b.b jf() {
        return super.jf();
    }

    @Override // com.kwad.components.core.webview.a.b.d
    public final com.kwad.components.core.webview.a.b.c jg() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.a.b.d, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.a.d.c cVar = this.Pv;
        if (cVar != null) {
            cVar.gg();
        }
    }

    @Override // com.kwad.components.core.webview.a.b.d, android.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.kwad.components.core.webview.a.d.c cVar = this.Pv;
        if (cVar != null) {
            cVar.fZ();
        }
    }
}
