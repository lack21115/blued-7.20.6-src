package com.kwad.sdk.kwai.kwai;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/kwai/kwai/a.class */
public final class a extends com.kwad.components.core.l.e {
    private static a YA;
    private final DialogInterface.OnDismissListener YB;
    private final AdTemplate mAdTemplate;
    private final DialogInterface.OnClickListener mOnClickListener;

    private a(Activity activity, AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.mAdTemplate = adTemplate;
        this.YB = onDismissListener;
        this.mOnClickListener = onClickListener;
    }

    public static boolean a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate ta;
        if (activity == null || activity.isFinishing() || (ta = c.sZ().ta()) == null) {
            return false;
        }
        return a(activity, ta, onDismissListener, onClickListener);
    }

    public static boolean a(Activity activity, AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (activity == null || activity.isFinishing() || adTemplate == null) {
            return false;
        }
        a aVar = YA;
        if (aVar != null && aVar.isShowing()) {
            YA.dismiss();
        }
        try {
            a aVar2 = new a(activity, adTemplate, onDismissListener, onClickListener);
            aVar2.show();
            YA = aVar2;
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean mF() {
        a aVar = YA;
        return aVar != null && aVar.isShowing();
    }

    public static boolean sU() {
        a aVar = YA;
        if (aVar == null || !aVar.isShowing()) {
            return false;
        }
        YA.dismiss();
        return true;
    }

    @Override // com.kwad.components.core.l.e, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        DialogInterface.OnDismissListener onDismissListener = this.YB;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
        YA = null;
    }

    @Override // com.kwad.components.core.l.e
    public final void g(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ksad_install_tips_content);
        TextView textView2 = (TextView) view.findViewById(R.id.ksad_install_cancel);
        TextView textView3 = (TextView) view.findViewById(R.id.ksad_install_tv);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        String z = d.z(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        String str = z;
        if (z.equals("")) {
            str = this.mContext.getString(R.string.ksad_install_tips, com.kwad.sdk.core.response.a.a.ao(cb));
        }
        textView.setText(str);
        textView3.setText(d.tf());
        textView2.setText(d.tg());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Tracker.onClick(view2);
                a.this.dismiss();
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -2);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Tracker.onClick(view2);
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -1);
                }
                if (ak.ak(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), com.kwad.sdk.core.download.a.A(com.kwad.sdk.core.response.a.d.cb(a.this.mAdTemplate)))) {
                    com.kwad.sdk.core.report.a.i(a.this.mAdTemplate, 1);
                }
            }
        });
    }

    @Override // com.kwad.components.core.l.e
    public final int getLayoutId() {
        return R.layout.ksad_install_dialog;
    }
}
