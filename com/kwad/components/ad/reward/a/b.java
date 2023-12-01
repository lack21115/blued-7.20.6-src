package com.kwad.components.ad.reward.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.components.ad.reward.a.a;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.core.l.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/a/b.class */
public final class b extends g implements a.b {
    private AdTemplate mAdTemplate;
    private int[] qP;
    private com.kwad.components.ad.reward.a.a rf;
    private a rg;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/a/b$a.class */
    public interface a {
        void gO();
    }

    public static void a(Activity activity, AdTemplate adTemplate, a aVar, int[] iArr) {
        if (adTemplate == null || activity == null) {
            return;
        }
        String jSONObject = adTemplate.toJson().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", jSONObject);
        bundle.putIntArray("key_end_location", iArr);
        b bVar = new b();
        bVar.a(aVar);
        bVar.setArguments(bundle);
        bVar.show(activity.getFragmentManager(), "rewardCoupon");
    }

    private void a(a aVar) {
        this.rg = aVar;
    }

    @Override // com.kwad.components.core.l.g
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        com.kwad.components.ad.reward.a.a aVar = new com.kwad.components.ad.reward.a.a(layoutInflater.getContext(), viewGroup, this.qP);
        this.rf = aVar;
        aVar.a(this);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.rf.b(v.B(this.mAdTemplate));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.a.b.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return this.rf.gK();
    }

    @Override // com.kwad.components.ad.reward.a.a.b
    public final void gO() {
        dismiss();
        a aVar = this.rg;
        if (aVar != null) {
            aVar.gO();
        }
    }

    @Override // com.kwad.components.ad.reward.a.a.b
    public final void gP() {
        dismiss();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("key_template_json")) {
                try {
                    String string = arguments.getString("key_template_json");
                    AdTemplate adTemplate = new AdTemplate();
                    this.mAdTemplate = adTemplate;
                    adTemplate.parseJson(new JSONObject(string));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                }
            }
            if (arguments.containsKey("key_end_location")) {
                this.qP = arguments.getIntArray("key_end_location");
            }
        }
    }
}
