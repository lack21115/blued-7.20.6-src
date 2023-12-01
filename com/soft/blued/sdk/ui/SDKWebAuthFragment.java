package com.soft.blued.sdk.ui;

import android.content.Context;
import android.os.Bundle;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.url.H5Url;
import com.soft.blued.sdk.SDKActionManager;
import com.soft.blued.sdk.SDKAuthAction;
import com.soft.blued.sdk.SDKBaseAction;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/ui/SDKWebAuthFragment.class */
public class SDKWebAuthFragment extends WebViewShowInfoFragment {
    private long m = 0;

    public static void a(Context context, String str, String str2, long j) {
        String a2 = H5Url.a(33, new Object[]{str});
        Bundle bundle = new Bundle();
        bundle.putString("web_url", a2);
        bundle.putString("title_name", "");
        bundle.putInt("from_tag", 0);
        bundle.putLong("action_id", j);
        TerminalActivity.d(context, SDKWebAuthFragment.class, bundle);
    }

    @Override // com.soft.blued.ui.web.WebViewShowInfoFragment
    public void a() {
        super.a();
        long j = getArguments().getLong("action_id");
        this.m = j;
        Logger.a("SDKAction", "SDKWebAuthFragment init, actionId:", Long.valueOf(j));
    }

    @Override // com.soft.blued.ui.web.WebViewShowInfoFragment
    public boolean a(BluedWebView bluedWebView, BluedUrlParser bluedUrlParser) {
        int i;
        if ("blued_auth".equals(bluedUrlParser.a()) && getFragmentActive() != null && getFragmentActive().isActive()) {
            if (bluedUrlParser.b() != null) {
                String str = (String) bluedUrlParser.b().get("access_token");
                String str2 = (String) bluedUrlParser.b().get("expire");
                String str3 = (String) bluedUrlParser.b().get("package_name");
                try {
                    i = Integer.parseInt(str2);
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 0;
                }
                SDKBaseAction b = SDKActionManager.b(this.m);
                if (b != null && (b instanceof SDKAuthAction)) {
                    ((SDKAuthAction) b).a(getActivity(), 0, 0, null, str, i, str3);
                }
            }
            getActivity().finish();
            return true;
        }
        return super.a(bluedWebView, bluedUrlParser);
    }

    @Override // com.soft.blued.ui.web.WebViewShowInfoFragment
    public void b() {
        super.b();
        SDKActionManager.a(getActivity(), this.m);
    }

    @Override // com.soft.blued.ui.web.WebViewShowInfoFragment
    public void onResume() {
        super.onResume();
        if (SDKActionManager.a(this.m)) {
            return;
        }
        getActivity().finish();
    }
}
