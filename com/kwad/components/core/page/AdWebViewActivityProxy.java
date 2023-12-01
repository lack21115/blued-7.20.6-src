package com.kwad.components.core.page;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kwad.components.core.page.widget.a;
import com.kwad.components.core.webview.a.b.d;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/AdWebViewActivityProxy.class */
public class AdWebViewActivityProxy extends com.kwad.components.core.l.d {
    private static final String KEY_IS_AUTO_SHOW = "key_is_auto_show";
    private static final String KEY_PAGE_TITLE = "key_page_title";
    private static final String KEY_PAGE_URL = "key_page_url";
    private static final String KEY_SHOW_PERMISSION = "key_show_permission";
    public static final String KEY_TEMPLATE = "key_template_json";
    private AdTemplate mAdTemplate;
    private boolean mAutoShow;
    private com.kwad.components.core.p.b mDialogFragment;
    private Dialog mKsExitInterceptDialog;
    private Dialog mKsExitInterceptDialogV2;
    private c mLandingPageView;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private volatile boolean destroyed = false;
    private com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener = new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
        @Override // com.kwad.sdk.core.webview.c.kwai.b
        public final void a(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    };
    private com.kwad.components.core.page.kwai.a mLandPageViewListener = new com.kwad.components.core.page.kwai.a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
        @Override // com.kwad.components.core.page.kwai.a
        public final void dK() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.kwai.a
        public final void dL() {
            if (AdWebViewActivityProxy.this.mLandingPageView != null && AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                AdWebViewActivityProxy.this.mLandingPageView.oe();
            } else if (AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                AdWebViewActivityProxy.this.finish();
            } else {
                if (com.kwad.sdk.core.response.a.a.aG(com.kwad.sdk.core.response.a.d.cb(AdWebViewActivityProxy.this.mAdTemplate)) && com.kwad.components.core.p.a.pt().pu() == 1 && com.kwad.components.core.p.a.pt().pz() && !com.kwad.components.core.p.a.pt().pw()) {
                    if (!com.kwad.components.core.p.a.pt().pv()) {
                        AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
                        adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
                        com.kwad.components.core.p.b.a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
                        return;
                    }
                } else if (AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                    AdWebViewActivityProxy.this.showDialog();
                    return;
                }
                AdWebViewActivityProxy.this.finish();
            }
        }
    };
    private com.kwad.components.core.webview.a.d.c mBaseDialogListener = new com.kwad.components.core.webview.a.d.c() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
        @Override // com.kwad.components.core.webview.a.d.c
        public final void J(boolean z) {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public final void fZ() {
            com.kwad.components.core.p.a.pt().aJ(true);
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public final void gg() {
            com.kwad.components.core.p.a.pt().aJ(false);
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public final void gh() {
        }
    };

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/AdWebViewActivityProxy$a.class */
    public static final class a {
        private String Ll;
        private String Lm;
        private boolean Ln;
        private boolean Lo;
        private AdTemplate adTemplate;

        /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a  reason: collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/AdWebViewActivityProxy$a$a.class */
        public static final class C0359a {
            private String Ll;
            private String Lm;
            private boolean Lo;
            private boolean Lp;
            private AdTemplate adTemplate;

            public final C0359a L(AdTemplate adTemplate) {
                this.adTemplate = adTemplate;
                return this;
            }

            public final C0359a aA(boolean z) {
                this.Lp = z;
                return this;
            }

            public final C0359a aB(boolean z) {
                this.Lo = z;
                return this;
            }

            public final C0359a au(String str) {
                this.Ll = str;
                return this;
            }

            public final C0359a av(String str) {
                this.Lm = str;
                return this;
            }

            public final a oc() {
                return new a(this.Ll, this.Lm, this.adTemplate, this.Lp, this.Lo, (byte) 0);
            }
        }

        private a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2) {
            this.Ll = str;
            this.Lm = str2;
            this.adTemplate = adTemplate;
            this.Ln = z;
            this.Lo = z2;
        }

        /* synthetic */ a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, byte b) {
            this(str, str2, adTemplate, z, z2);
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final String nY() {
            return this.Ll;
        }

        public final String nZ() {
            return this.Lm;
        }

        public final boolean oa() {
            return this.Ln;
        }

        public final boolean ob() {
            return this.Lo;
        }
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0362a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.5
            @Override // com.kwad.components.core.page.widget.a.InterfaceC0362a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.q(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0362a
            public final void b(DialogInterface dialogInterface) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable th) {
                }
                com.kwad.sdk.core.report.a.q(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0362a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.q(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.p.b getTkDialogFragment() {
        d.b bVar = new d.b();
        bVar.setAdTemplate(this.mAdTemplate);
        bVar.aP("ksad-video-web-close-card");
        bVar.aQ(false);
        bVar.aR(true);
        return com.kwad.components.core.p.b.a(bVar);
    }

    private void initContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_land_page_root);
        c b = c.b(this.mContext, new a.C0359a().au(this.mPageTitle).av(this.mPageUrl).L(this.mAdTemplate).aA(this.mShowPermission).aB(this.mAutoShow).oc());
        this.mLandingPageView = b;
        b.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        viewGroup.addView(this.mLandingPageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mShowPermission || (adTemplate = this.mAdTemplate) == null || com.kwad.sdk.core.response.a.d.p(adTemplate)) {
            return false;
        }
        if (com.kwad.sdk.core.config.d.uv() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.d.uw() && !this.mAdTemplate.mIsFromContent;
    }

    public static void launch(Context context, a aVar) {
        BusinessType bv = aVar.adTemplate.mAdScene != null ? KSLoggerReporter.bv(aVar.adTemplate.mAdScene.getAdStyle()) : null;
        if (TextUtils.isEmpty(aVar.Lm) || aVar.Lm.contains(" ") || !aVar.Lm.startsWith("http")) {
            KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_convert").aF(aVar.adTemplate).J("h5UrlError", aVar.Lm).report();
        }
        if (context == null || TextUtils.isEmpty(aVar.Lm)) {
            return;
        }
        com.kwad.sdk.g.a.e("all", "convert", "launch_landing_page");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(bv, "startH5Page").report();
        com.kwad.sdk.service.a.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(KEY_PAGE_TITLE, aVar.Ll);
        intent.putExtra(KEY_PAGE_URL, aVar.Lm);
        intent.putExtra(KEY_IS_AUTO_SHOW, aVar.Lo);
        intent.putExtra("key_template_json", aVar.adTemplate.toJson().toString());
        intent.putExtra(KEY_SHOW_PERMISSION, aVar.Ln);
        context.startActivity(intent);
        com.kwad.sdk.g.a.f("all", "convert", "launch_landing_page");
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        launch(context, new a.C0359a().av(com.kwad.sdk.core.response.a.b.bg(adTemplate)).L(adTemplate).oc());
    }

    public static void register() {
        com.kwad.sdk.service.a.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    @Override // com.kwad.components.core.l.d
    public boolean checkIntentData(Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
        return this.mAdTemplate != null;
    }

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return "AdWebViewActivityProxy";
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        this.destroyed = false;
        String stringExtra = getIntent().getStringExtra("key_template_json");
        this.mPageTitle = getIntent().getStringExtra(KEY_PAGE_TITLE);
        this.mPageUrl = getIntent().getStringExtra(KEY_PAGE_URL);
        this.mAutoShow = getIntent().getBooleanExtra(KEY_IS_AUTO_SHOW, false);
        this.mShowPermission = getIntent().getBooleanExtra(KEY_SHOW_PERMISSION, false);
        try {
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        setContentView(R.layout.ksad_activity_landpage);
        initContentView();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        c cVar = this.mLandingPageView;
        if (cVar != null && cVar.getCanInterceptBackClick()) {
            this.mLandingPageView.oe();
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null || adTemplate.mIsForceJumpLandingPage) {
            super.onBackPressed();
        } else if (com.kwad.sdk.core.response.a.a.aG(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) && com.kwad.components.core.p.a.pt().pu() == 1 && com.kwad.components.core.p.a.pt().pz() && !com.kwad.components.core.p.a.pt().pw()) {
            if (com.kwad.components.core.p.a.pt().pv()) {
                super.onBackPressed();
                return;
            }
            com.kwad.components.core.p.b tkDialogFragment = getTkDialogFragment();
            this.mDialogFragment = tkDialogFragment;
            com.kwad.components.core.p.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
        } else {
            if (isFormAdExitInterceptEnable()) {
                try {
                    if (this.mKsExitInterceptDialogV2 == null) {
                        this.mKsExitInterceptDialogV2 = new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0362a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.4
                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0362a
                            public final void a(DialogInterface dialogInterface) {
                                com.kwad.sdk.core.report.a.q(AdWebViewActivityProxy.this.mAdTemplate, 104);
                                dialogInterface.dismiss();
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0362a
                            public final void b(DialogInterface dialogInterface) {
                                if (!AdWebViewActivityProxy.this.destroyed) {
                                    try {
                                        AdWebViewActivityProxy.super.onBackPressed();
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.b.printStackTrace(th);
                                    }
                                }
                                com.kwad.sdk.core.report.a.q(AdWebViewActivityProxy.this.mAdTemplate, 105);
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0362a
                            public final void c(DialogInterface dialogInterface) {
                                com.kwad.sdk.core.report.a.q(AdWebViewActivityProxy.this.mAdTemplate, 106);
                                dialogInterface.dismiss();
                            }
                        });
                    }
                    com.kwad.sdk.core.report.a.b(this.mAdTemplate, 103, (JSONObject) null);
                    this.mKsExitInterceptDialogV2.show();
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AdTemplate adTemplate = this.mAdTemplate;
        KSLoggerReporter.ReportClient.CONVERT_H5WEB.buildMethodCheck((adTemplate == null || adTemplate.mAdScene == null) ? null : KSLoggerReporter.bv(this.mAdTemplate.mAdScene.getAdStyle()), "h5PageCreate").report();
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        this.destroyed = true;
        Dialog dialog = this.mKsExitInterceptDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mKsExitInterceptDialog.dismiss();
        }
        Dialog dialog2 = this.mKsExitInterceptDialogV2;
        if (dialog2 != null && dialog2.isShowing()) {
            this.mKsExitInterceptDialogV2.dismiss();
        }
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.interactLandingPageShowing = false;
            this.mAdTemplate.mIsForceJumpLandingPage = false;
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable th) {
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
