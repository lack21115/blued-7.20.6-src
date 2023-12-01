package com.soft.blued.ui.discover.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentWebviewTitleBinding;
import com.soft.blued.databinding.FragmentWmDetailBinding;
import com.web.library.groups.webviewsdk.core.WMWebView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/WmWebFragment.class */
public final class WmWebFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f16139a = new Companion(null);
    private FragmentWmDetailBinding b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentWebviewTitleBinding f16140c;

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/WmWebFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void a() {
        FragmentWebviewTitleBinding fragmentWebviewTitleBinding = this.f16140c;
        if (fragmentWebviewTitleBinding == null) {
            return;
        }
        fragmentWebviewTitleBinding.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.-$$Lambda$WmWebFragment$lFdEtEUvuVFRoBXE3Y-52B72rJ8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WmWebFragment.a(WmWebFragment.this, view);
            }
        });
        fragmentWebviewTitleBinding.i.setVisibility(0);
        fragmentWebviewTitleBinding.n.setVisibility(8);
        fragmentWebviewTitleBinding.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.-$$Lambda$WmWebFragment$2w5305WrmSz6otjF_kRNLZPLJ1Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WmWebFragment.b(WmWebFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(WmWebFragment wmWebFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(wmWebFragment, "this$0");
        wmWebFragment.onBackPressed();
    }

    private final void b() {
        WMWebView wMWebView;
        FragmentWmDetailBinding fragmentWmDetailBinding = this.b;
        if (fragmentWmDetailBinding != null) {
            fragmentWmDetailBinding.f15353a.setWebStateClient(new WMWebView.WMWebStateClient() { // from class: com.soft.blued.ui.discover.fragment.WmWebFragment$initView$1$1
                @Override // com.web.library.groups.webviewsdk.core.WMWebView.WMWebStateClient
                public void onProgressChanged(WebView webView, int i) {
                    Log.v("drb", String.valueOf(Integer.valueOf(i)));
                }

                @Override // com.web.library.groups.webviewsdk.core.WMWebView.WMWebStateClient
                public void onReceivedTitle(WebView webView, String str) {
                    FragmentWebviewTitleBinding fragmentWebviewTitleBinding;
                    fragmentWebviewTitleBinding = WmWebFragment.this.f16140c;
                    if (fragmentWebviewTitleBinding == null) {
                        return;
                    }
                    WmWebFragment wmWebFragment = WmWebFragment.this;
                    boolean z = true;
                    String str2 = null;
                    if (str == null || !StringsKt.c(str, "weixin", false, 2, (Object) null)) {
                        z = false;
                    }
                    if (!z) {
                        fragmentWebviewTitleBinding.f15349c.setText(str);
                        return;
                    }
                    TextView textView = fragmentWebviewTitleBinding.f15349c;
                    FragmentActivity activity = wmWebFragment.getActivity();
                    if (activity != null) {
                        str2 = activity.getString(R.string.mine_jumping);
                    }
                    textView.setText(str2);
                }

                @Override // com.web.library.groups.webviewsdk.core.WMWebView.WMWebStateClient
                public void pageFinished(WebView webView, String str) {
                    Log.v("drb", String.valueOf(str));
                    Intrinsics.a("pageFinished:", str);
                }

                @Override // com.web.library.groups.webviewsdk.core.WMWebView.WMWebStateClient
                public void pageStarted(WebView webView, String str, Bitmap bitmap) {
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        Log.v("drb", String.valueOf(arguments.getString("KEY_URL")));
        FragmentWmDetailBinding fragmentWmDetailBinding2 = this.b;
        if (fragmentWmDetailBinding2 == null || (wMWebView = fragmentWmDetailBinding2.f15353a) == null) {
            return;
        }
        wMWebView.loadUrl(String.valueOf(arguments.getString("KEY_URL")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WmWebFragment wmWebFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(wmWebFragment, "this$0");
        FragmentActivity activity = wmWebFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        WMWebView wMWebView;
        super.onActivityResult(i, i2, intent);
        FragmentWmDetailBinding fragmentWmDetailBinding = this.b;
        if (fragmentWmDetailBinding == null || (wMWebView = fragmentWmDetailBinding.f15353a) == null) {
            return;
        }
        wMWebView.onActivityResult(i, i2, intent);
    }

    public boolean onBackPressed() {
        WMWebView wMWebView;
        WMWebView wMWebView2;
        FragmentWmDetailBinding fragmentWmDetailBinding = this.b;
        if (!((fragmentWmDetailBinding == null || (wMWebView = fragmentWmDetailBinding.f15353a) == null || !wMWebView.canGoBack()) ? false : true)) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return false;
            }
            activity.finish();
            return false;
        }
        FragmentWmDetailBinding fragmentWmDetailBinding2 = this.b;
        if (fragmentWmDetailBinding2 == null || (wMWebView2 = fragmentWmDetailBinding2.f15353a) == null) {
            return true;
        }
        wMWebView2.goBack();
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_wm_detail, (ViewGroup) null);
        this.b = FragmentWmDetailBinding.a(inflate);
        this.f16140c = FragmentWebviewTitleBinding.a(inflate);
        b();
        a();
        return inflate;
    }

    public void onDestroy() {
        WMWebView wMWebView;
        super.onDestroy();
        FragmentWmDetailBinding fragmentWmDetailBinding = this.b;
        if (fragmentWmDetailBinding == null || (wMWebView = fragmentWmDetailBinding.f15353a) == null) {
            return;
        }
        wMWebView.destroy();
    }

    public void onResume() {
        WMWebView wMWebView;
        super.onResume();
        FragmentWmDetailBinding fragmentWmDetailBinding = this.b;
        if (fragmentWmDetailBinding == null || (wMWebView = fragmentWmDetailBinding.f15353a) == null) {
            return;
        }
        wMWebView.onResume();
    }
}
