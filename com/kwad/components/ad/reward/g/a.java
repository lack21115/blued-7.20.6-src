package com.kwad.components.ad.reward.g;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.core.l.g;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/g/a.class */
public final class a extends g implements DialogInterface.OnKeyListener, DialogInterface.OnShowListener, b {
    private static a rP;
    private AdTemplate mAdTemplate;
    private q rO;
    private b rQ;

    public static void a(Activity activity, b bVar, AdTemplate adTemplate) {
        rP = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        rP.setArguments(bundle);
        rP.a(bVar);
        rP.show(activity.getFragmentManager(), "playAgainDialog");
    }

    private void a(b bVar) {
        this.rQ = bVar;
    }

    private void hp() {
        try {
            String string = getArguments().getString("key_template_json", null);
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(string));
            this.mAdTemplate = adTemplate;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.components.core.l.g
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        getDialog().setOnKeyListener(this);
        hp();
        if (this.rO == null) {
            q qVar = new q(layoutInflater, viewGroup);
            this.rO = qVar;
            qVar.b(this);
        }
        return this.rO.gK();
    }

    @Override // com.kwad.components.ad.reward.g.b
    public final void gu() {
        dismiss();
        b bVar = this.rQ;
        if (bVar != null) {
            bVar.gu();
        }
        com.kwad.sdk.core.report.a.q(this.mAdTemplate, 163);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setOnShowListener(this);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            dismiss();
            b bVar = this.rQ;
            if (bVar != null) {
                bVar.gu();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.ad.reward.g.c, com.kwad.components.core.webview.jshandler.j.a
    public final void onPlayAgainClick(boolean z) {
        dismiss();
        b bVar = this.rQ;
        if (bVar != null) {
            bVar.onPlayAgainClick(z);
        }
        com.kwad.sdk.core.report.a.q(this.mAdTemplate, 162);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        y.b bVar = new y.b();
        bVar.akL = 205;
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 162, bVar, (JSONObject) null);
    }
}
