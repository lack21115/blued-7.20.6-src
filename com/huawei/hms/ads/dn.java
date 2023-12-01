package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.kn;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.uiengine.a;
import com.huawei.openalliance.ad.constant.bc;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.views.PPSNativeView;
import com.huawei.openalliance.ad.views.c;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dn.class */
public class dn extends a.b {
    private Context g;
    private WeakReference<PPSNativeView> h;
    private AdContentData i;
    private com.huawei.openalliance.ad.inter.data.n j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dn$a.class */
    public static class a extends c {
        public a(Context context) {
            super(context);
            Resources resources = context.getResources();
            this.V.Code(resources.getDrawable(R.drawable.hiad_native_tpt_list_page_btn));
            this.V.V((int) resources.getDimension(R.dimen.hiad_12_dp));
            this.V.Code(resources.getColor(R.color.hiad_down_btn_normal));
            this.I.Code(resources.getDrawable(R.drawable.hiad_native_tpt_list_page_btn));
            this.I.V((int) resources.getDimension(R.dimen.hiad_12_dp));
            this.I.Code(resources.getColor(R.color.hiad_down_btn_process));
            this.Z.Code(resources.getDrawable(R.drawable.hiad_native_tpt_list_page_btn));
            this.Z.V((int) resources.getDimension(R.dimen.hiad_12_dp));
            this.Z.Code(resources.getColor(R.color.hiad_down_btn_installing));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dn$b.class */
    public static class b extends c {
        public b(Context context) {
            super(context);
            Resources resources = context.getResources();
            this.V.Code(resources.getDrawable(R.drawable.hiad_app_down_btn_normal));
            this.V.Code(resources.getColor(R.color.hiad_down_normal_text_icon));
            this.I.Code(Code(context, R.drawable.hiad_app_down_btn_processing));
            this.I.Code(resources.getColor(R.color.hiad_app_down_processing_text_icon));
            this.Z.Code(resources.getDrawable(R.drawable.hiad_app_down_btn_installing));
            this.Z.Code(resources.getColor(R.color.hiad_app_down_installing_text_icon));
        }
    }

    public dn(Context context, PPSNativeView pPSNativeView, com.huawei.openalliance.ad.inter.data.n nVar) {
        this.g = context;
        this.h = new WeakReference<>(pPSNativeView);
        this.j = nVar;
        this.i = nVar != null ? nVar.l() : null;
    }

    private void Code(IObjectWrapper iObjectWrapper, String str, int i) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            if (view instanceof com.huawei.openalliance.ad.views.AppDownloadButton) {
                ge.V("NativeProxy", "registerDownloadBtn");
                final com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton = (com.huawei.openalliance.ad.views.AppDownloadButton) view;
                final PPSNativeView pPSNativeView = this.h.get();
                if (pPSNativeView != null) {
                    if (!Z()) {
                        if (this.j.i_() != 0) {
                            ge.Code("NativeProxy", "show btn");
                            appDownloadButton.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.hms.ads.dn.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    Tracker.onClick(view2);
                                    PPSNativeView pPSNativeView2 = pPSNativeView;
                                    if (pPSNativeView2 != null) {
                                        pPSNativeView2.Code(appDownloadButton, 1);
                                    }
                                }
                            });
                            Code(str, appDownloadButton, i);
                            appDownloadButton.Code();
                            return;
                        }
                        view.setVisibility(8);
                    }
                    if (pPSNativeView.Code((kz) appDownloadButton)) {
                        ge.Code("NativeProxy", "register succ");
                        if (V(str)) {
                            appDownloadButton.setAfDlBtnText(str);
                        }
                        appDownloadButton.setNeedAppendProgress(true);
                        Code(appDownloadButton, i);
                        appDownloadButton.Code();
                        return;
                    }
                    view.setVisibility(8);
                }
            }
        }
    }

    private void Code(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        appDownloadButton.setMinWidth((int) this.g.getResources().getDimension(R.dimen.hiad_64_dp));
        appDownloadButton.setPadding(0, 0, 0, (int) this.g.getResources().getDimension(R.dimen.hiad_6_dp));
        appDownloadButton.setFontFamily("HwChinese-medium");
        appDownloadButton.setTextSize(this.g.getResources().getDimension(R.dimen.hiad_12_dp));
        appDownloadButton.setAppDownloadButtonStyle(new a(this.g));
        appDownloadButton.setVisibility(0);
    }

    private void Code(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton, int i) {
        if (i == 0) {
            Code(appDownloadButton);
            return;
        }
        appDownloadButton.setMinWidth((int) this.g.getResources().getDimension(R.dimen.hiad_56_dp));
        appDownloadButton.setMaxWidth((int) this.g.getResources().getDimension(R.dimen.hiad_56_dp));
        appDownloadButton.setFixedWidth(false);
        int dimension = (int) this.g.getResources().getDimension(R.dimen.hiad_8_dp);
        appDownloadButton.setPadding(dimension, dimension, dimension, dimension);
        appDownloadButton.setFontFamily("HwChinese-medium");
        appDownloadButton.setTextSize((int) this.g.getResources().getDimension(R.dimen.hiad_12_dp));
        appDownloadButton.setAppDownloadButtonStyle(new b(this.g));
        appDownloadButton.setVisibility(0);
    }

    private void Code(String str, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        appDownloadButton.setMinWidth((int) this.g.getResources().getDimension(R.dimen.hiad_56_dp));
        appDownloadButton.setMaxWidth((int) this.g.getResources().getDimension(R.dimen.hiad_56_dp));
        int dimension = (int) this.g.getResources().getDimension(R.dimen.hiad_8_dp);
        appDownloadButton.setPadding(dimension, dimension, dimension, dimension);
        appDownloadButton.setFontFamily("HwChinese-medium");
        appDownloadButton.setTextSize(this.g.getResources().getDimension(R.dimen.hiad_12_dp));
        appDownloadButton.setTextColor(this.g.getResources().getColor(R.color.hiad_down_btn_normal));
        appDownloadButton.setBackground(this.g.getResources().getDrawable(R.drawable.hiad_app_down_btn_normal));
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(str)) {
            charSequence = this.g.getString(R.string.hiad_detail);
        }
        appDownloadButton.setText(charSequence);
    }

    private void Code(String str, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton, int i) {
        if (i != 0) {
            Code(str, appDownloadButton);
            return;
        }
        appDownloadButton.setMinWidth((int) this.g.getResources().getDimension(R.dimen.hiad_64_dp));
        appDownloadButton.setPadding(0, 0, 0, (int) this.g.getResources().getDimension(R.dimen.hiad_6_dp));
        appDownloadButton.setFontFamily("HwChinese-medium");
        appDownloadButton.setTextSize(this.g.getResources().getDimension(R.dimen.hiad_12_dp));
        appDownloadButton.setTextColor(this.g.getResources().getColor(R.color.hiad_down_btn_normal));
        appDownloadButton.setBackground(this.g.getResources().getDrawable(R.drawable.hiad_native_tpt_list_page_btn));
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(str)) {
            charSequence = this.g.getString(R.string.hiad_detail);
        }
        appDownloadButton.setText(charSequence);
    }

    private boolean V(String str) {
        if (this.j.v() != null) {
            return (this.j.i_() == 4 || this.j.i_() == 8) && !TextUtils.isEmpty(str);
        }
        return false;
    }

    private boolean Z() {
        return this.j.i_() == 2 || this.j.i_() == 5 || this.j.i_() == 4 || this.j.i_() == 8;
    }

    public void Code(long j) {
        AdContentData adContentData = this.i;
        if (adContentData == null) {
            return;
        }
        adContentData.Z(j);
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public void Code(long j, long j2) {
        eh.Code(this.g, this.i, j, j2);
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public void Code(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.h.get();
            if (view == null || pPSNativeView == null) {
                return;
            }
            pPSNativeView.showFeedback(view);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public void Code(IObjectWrapper iObjectWrapper, int i) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.h.get();
            if (pPSNativeView != null) {
                pPSNativeView.Code(view, i);
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public void Code(IObjectWrapper iObjectWrapper, String str) {
        Code(iObjectWrapper, str, 0);
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
        Code(iObjectWrapper, str, bundle.getInt(bc.a.Code));
    }

    public void Code(String str) {
        AdContentData adContentData = this.i;
        if (adContentData == null) {
            return;
        }
        adContentData.V(str);
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public void Code(String str, int i) {
        PPSNativeView pPSNativeView = this.h.get();
        if (!com.huawei.openalliance.ad.constant.ac.e.equals(str)) {
            if (pPSNativeView != null) {
                pPSNativeView.Code(Integer.valueOf(i), false);
                return;
            }
            return;
        }
        kn.a aVar = new kn.a();
        aVar.V(Integer.valueOf(i));
        if (pPSNativeView != null) {
            aVar.Code(com.huawei.openalliance.ad.utils.b.Code(pPSNativeView));
        }
        ko.Code(this.g, this.i, aVar.Code(), com.huawei.openalliance.ad.constant.ac.e);
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public void Code(String str, long j, long j2, int i, int i2) {
        Context context;
        AdContentData adContentData;
        Long valueOf;
        Long valueOf2;
        Integer valueOf3;
        Integer valueOf4;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -1891923166:
                if (str.equals(com.huawei.openalliance.ad.constant.ac.C)) {
                    z = true;
                    break;
                }
                break;
            case -1888605810:
                if (str.equals(com.huawei.openalliance.ad.constant.ac.B)) {
                    z = true;
                    break;
                }
                break;
            case -493598457:
                if (str.equals(com.huawei.openalliance.ad.constant.ac.Z)) {
                    z = false;
                    break;
                }
                break;
            case 1540819073:
                if (str.equals(com.huawei.openalliance.ad.constant.ac.S)) {
                    z = true;
                    break;
                }
                break;
        }
        if (!z) {
            context = this.g;
            adContentData = this.i;
            valueOf = Long.valueOf(j);
            valueOf2 = Long.valueOf(j2);
            valueOf3 = Integer.valueOf(i);
            valueOf4 = Integer.valueOf(i2);
            str2 = com.huawei.openalliance.ad.constant.ac.Z;
        } else if (z) {
            context = this.g;
            adContentData = this.i;
            valueOf = null;
            valueOf2 = null;
            valueOf3 = null;
            valueOf4 = null;
            str2 = com.huawei.openalliance.ad.constant.ac.B;
        } else if (z) {
            context = this.g;
            adContentData = this.i;
            valueOf = null;
            valueOf2 = null;
            valueOf3 = null;
            valueOf4 = null;
            str2 = com.huawei.openalliance.ad.constant.ac.S;
        } else if (!z) {
            return;
        } else {
            context = this.g;
            adContentData = this.i;
            valueOf = Long.valueOf(j);
            valueOf2 = Long.valueOf(j2);
            valueOf3 = Integer.valueOf(i);
            valueOf4 = Integer.valueOf(i2);
            str2 = com.huawei.openalliance.ad.constant.ac.C;
        }
        ko.Code(context, adContentData, str2, valueOf, valueOf2, valueOf3, valueOf4);
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public void Code(boolean z) {
        ko.Code(this.g, this.i, z);
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public boolean Code() {
        return this.j.R();
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public void V(String str, long j, long j2, int i, int i2) {
        ko.Code(this.g, this.i, com.huawei.openalliance.ad.constant.ac.f, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), str);
    }

    @Override // com.huawei.hms.ads.uiengine.a
    public boolean V() {
        try {
            boolean booleanValue = ((Boolean) com.huawei.openalliance.ad.utils.aw.Code(new Callable<Boolean>() { // from class: com.huawei.hms.ads.dn.1
                @Override // java.util.concurrent.Callable
                /* renamed from: Code */
                public Boolean call() {
                    if (dn.this.i == null) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(com.huawei.openalliance.ad.constant.at.S, dn.this.i.aA());
                        jSONObject.put("content_id", dn.this.i.S());
                        jSONObject.put(com.huawei.openalliance.ad.constant.at.C, dn.this.i.az());
                        jSONObject.put(com.huawei.openalliance.ad.constant.at.ac, dn.this.i.C());
                    } catch (Throwable th) {
                        ge.V("NativeProxy", "construct json err: %s", th.getClass().getSimpleName());
                    }
                    return Boolean.valueOf(Boolean.TRUE.toString().equals(com.huawei.openalliance.ad.ipc.b.Code(dn.this.g).Code(com.huawei.openalliance.ad.constant.p.y, jSONObject.toString(), String.class).getData()));
                }
            }, false)).booleanValue();
            ge.Code("NativeProxy", "result = %s", Boolean.valueOf(booleanValue));
            return booleanValue;
        } catch (Throwable th) {
            ge.V("NativeProxy", "downloadVideos err: %s", th.getClass().getSimpleName());
            return false;
        }
    }
}
