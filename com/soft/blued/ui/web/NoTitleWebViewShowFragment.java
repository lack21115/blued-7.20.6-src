package com.soft.blued.ui.web;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/NoTitleWebViewShowFragment.class */
public class NoTitleWebViewShowFragment extends WebViewShowInfoFragment {
    private View m;

    public NoTitleWebViewShowFragment a(String str) {
        String str2 = str;
        if (!str.contains("://")) {
            str2 = "http://" + str;
        }
        this.f34480a = str2;
        return this;
    }

    @Override // com.soft.blued.ui.web.WebViewShowInfoFragment
    public void a(String str, String str2) {
        if (this.f34481c.a(this.f34480a, "")) {
            return;
        }
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f34481c.c().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soft.blued.ui.web.WebViewShowInfoFragment
    public void c() {
        super.c();
        View findViewById = this.b.findViewById(R.id.web_title);
        this.m = findViewById;
        findViewById.setVisibility(8);
    }

    public void d() {
        this.f34481c.b("");
    }

    @Override // com.soft.blued.ui.web.WebViewShowInfoFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
