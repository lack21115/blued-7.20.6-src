package com.soft.blued.ui.web;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentWebLinkPromptBinding;
import com.soft.blued.ui.web.WebLinkManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/WebViewLinkPromptFragment.class */
public final class WebViewLinkPromptFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f34478a = new Companion(null);
    private FragmentWebLinkPromptBinding b;

    /* renamed from: c  reason: collision with root package name */
    private WebLinkManager.LinkType f34479c = WebLinkManager.LinkType.NORMAL;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/WebViewLinkPromptFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context, String web_url, String centerName, boolean z, int i, boolean z2, WebLinkManager.LinkType linkType) {
            Intrinsics.e(context, "context");
            Intrinsics.e(web_url, "web_url");
            Intrinsics.e(centerName, "centerName");
            Intrinsics.e(linkType, "linkType");
            Bundle bundle = new Bundle();
            bundle.putString("web_url", web_url);
            bundle.putString("title_name", centerName);
            bundle.putInt("from_tag", i);
            bundle.putBoolean("auto_finish", z);
            bundle.putBoolean("Screen_Invasion", z2);
            bundle.putSerializable("link_type", linkType);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, WebViewLinkPromptFragment.class, bundle);
        }
    }

    @JvmStatic
    public static final void a(Context context, String str, String str2, boolean z, int i, boolean z2, WebLinkManager.LinkType linkType) {
        f34478a.a(context, str, str2, z, i, z2, linkType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(WebViewLinkPromptFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WebViewLinkPromptFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Bundle arguments = this$0.getArguments();
        if (arguments != null) {
            WebViewShowInfoFragment.a(this$0.getActivity(), arguments.getString("web_url"), arguments.getString("title_name"), arguments.getBoolean("auto_finish"), arguments.getInt("from_tag"), arguments.getBoolean("Screen_Invasion"), false);
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    public final void a() {
        String string;
        FragmentWebLinkPromptBinding fragmentWebLinkPromptBinding = this.b;
        if (fragmentWebLinkPromptBinding == null) {
            return;
        }
        fragmentWebLinkPromptBinding.b.getCenterTextView().setText(getString(R.string.web_link_prompt_title));
        fragmentWebLinkPromptBinding.b.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.web.-$$Lambda$WebViewLinkPromptFragment$jYXvJdma2jw-NEzj3773wsF7b_8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewLinkPromptFragment.a(WebViewLinkPromptFragment.this, view);
            }
        });
        if (StatusBarHelper.a()) {
            int a2 = StatusBarHelper.a(getContext());
            CommonTopTitleNoTrans commonTopTitleNoTrans = fragmentWebLinkPromptBinding.b;
            ViewGroup.LayoutParams layoutParams = fragmentWebLinkPromptBinding.b.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(0, a2, 0, 0);
            commonTopTitleNoTrans.setLayoutParams(layoutParams2);
        }
        if (this.f34479c != WebLinkManager.LinkType.NORMAL) {
            if (this.f34479c == WebLinkManager.LinkType.BLACK) {
                fragmentWebLinkPromptBinding.f29036a.setImageResource(R.drawable.icon_web_link_prompt_black);
                fragmentWebLinkPromptBinding.f.setVisibility(8);
                fragmentWebLinkPromptBinding.e.setText(getString(R.string.web_link_prompt_forbidden));
                fragmentWebLinkPromptBinding.d.setText(getString(R.string.web_link_prompt_forbidden_desc));
                fragmentWebLinkPromptBinding.f29037c.setVisibility(8);
                return;
            }
            return;
        }
        fragmentWebLinkPromptBinding.f29036a.setImageResource(R.drawable.icon_web_link_prompt_normal);
        fragmentWebLinkPromptBinding.f.setVisibility(0);
        TextView textView = fragmentWebLinkPromptBinding.f;
        Bundle arguments = getArguments();
        textView.setText((arguments == null || (string = arguments.getString("web_url")) == null) ? "" : string);
        fragmentWebLinkPromptBinding.e.setText(getString(R.string.web_link_prompt_non_official));
        fragmentWebLinkPromptBinding.d.setText(getString(R.string.web_link_prompt_non_official_desc));
        fragmentWebLinkPromptBinding.f29037c.setVisibility(0);
        fragmentWebLinkPromptBinding.f29037c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.web.-$$Lambda$WebViewLinkPromptFragment$z5-IFaTM6VnGG6WuRQW0TJrDQlg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewLinkPromptFragment.b(WebViewLinkPromptFragment.this, view);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_web_link_prompt, (ViewGroup) null);
        this.b = FragmentWebLinkPromptBinding.a(inflate);
        Bundle arguments = getArguments();
        Object obj = arguments == null ? null : arguments.get("link_type");
        if (obj != null) {
            this.f34479c = (WebLinkManager.LinkType) obj;
            a();
            return inflate;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.web.WebLinkManager.LinkType");
    }
}
