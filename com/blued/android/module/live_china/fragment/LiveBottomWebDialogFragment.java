package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.web.LiveWebCallBack;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBottomWebDialogFragment.class */
public class LiveBottomWebDialogFragment extends BaseDialogFragment {
    public LayoutInflater a;
    private Context b;
    private View c;
    private ImageView d;
    private ProgressBar e;
    private BluedWebView f;
    private OnDismissListener g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBottomWebDialogFragment$OnDismissListener.class */
    public interface OnDismissListener {
        void a();
    }

    public static LiveBottomWebDialogFragment a(Context context, FragmentManager fragmentManager, String str) {
        if (BluedWebView.a(context, str, new LiveWebCallBack())) {
            return null;
        }
        LiveBottomWebDialogFragment liveBottomWebDialogFragment = new LiveBottomWebDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("WEB_URL", str);
        liveBottomWebDialogFragment.setArguments(bundle);
        liveBottomWebDialogFragment.show(fragmentManager, "webDialogFragment");
        return liveBottomWebDialogFragment;
    }

    private void d() {
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveBottomWebDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveBottomWebDialogFragment.this.getActivity().finish();
            }
        });
        this.e = (ProgressBar) this.c.findViewById(R.id.loading);
        this.d = (ImageView) this.c.findViewById(R.id.loading_bg);
        this.e.setVisibility(0);
        this.d.setVisibility(0);
        WebView webView = (WebView) this.c.findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setLayerType(2, null);
        webView.setBackgroundColor(0);
        webView.getBackground().setAlpha(0);
        this.f = new BluedWebView(this, webView, (ViewGroup) this.c, new LiveWebCallBack() { // from class: com.blued.android.module.live_china.fragment.LiveBottomWebDialogFragment.2
            @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void b(BluedWebView bluedWebView, String str, boolean z) {
                LiveBottomWebDialogFragment.this.e.setVisibility(8);
                LiveBottomWebDialogFragment.this.d.setVisibility(8);
            }
        });
    }

    private void e() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("WEB_URL") : null;
        if (TextUtils.isEmpty(string)) {
            getActivity().finish();
        } else {
            this.f.a(string);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_bottom_web, (ViewGroup) null);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(DensityUtils.a(getActivity(), 430.0f), -1));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        attributes.width = -1;
        attributes.height = DensityUtils.a(getActivity(), 430.0f);
        attributes.gravity = 5;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.b = activity;
        this.a = LayoutInflater.from(activity);
        if (this.c == null) {
            this.c = layoutInflater.inflate(R.layout.dialog_live_bottom_web, viewGroup, false);
            d();
        }
        e();
        return this.c;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        OnDismissListener onDismissListener = this.g;
        if (onDismissListener != null) {
            onDismissListener.a();
        }
    }
}
