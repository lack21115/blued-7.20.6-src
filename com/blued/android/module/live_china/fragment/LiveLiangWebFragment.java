package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveLiangWebFragment.class */
public class LiveLiangWebFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public PopLiveActivityWebView f13006a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f13007c;
    private Context d;
    private View e;

    private void a() {
        if (getArguments() != null) {
            this.b = getArguments().getString("web_url");
            this.f13007c = getArguments().getInt("type");
        }
    }

    public ViewGroup a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ViewGroup) layoutInflater.inflate(R.layout.dialog_live_web, viewGroup, false);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = getActivity();
        getActivity().getWindow().setSoftInputMode(18);
        View view = this.e;
        if (view == null) {
            try {
                this.e = a(layoutInflater, viewGroup);
                a();
                PopLiveActivityWebView popLiveActivityWebView = (PopLiveActivityWebView) this.e.findViewById(R.id.live_activity_web_view);
                this.f13006a = popLiveActivityWebView;
                popLiveActivityWebView.a(this);
                this.f13006a.b(this.b, this.f13007c);
            } catch (InflateException e) {
                getActivity().finish();
                AppMethods.a((CharSequence) "请前往系统应用商店安装系统浏览器~");
                return null;
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.e.getParent()).removeView(this.e);
        }
        return this.e;
    }
}
