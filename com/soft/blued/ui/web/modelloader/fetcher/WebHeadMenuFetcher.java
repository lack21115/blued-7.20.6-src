package com.soft.blued.ui.web.modelloader.fetcher;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.jsbridge.BridgeManager;
import com.blued.android.module.common.web.jsbridge.CallBackFunction;
import com.blued.android.module.common.web.jsbridge.CallJsModel;
import com.blued.android.module.common.web.modelloader.fetcher.DataFetcher;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/fetcher/WebHeadMenuFetcher.class */
public class WebHeadMenuFetcher implements DataFetcher {
    Activity activity;
    BridgeManager bridgeManager;
    View rootView;

    public WebHeadMenuFetcher(BridgeManager bridgeManager, View view, Activity activity) {
        this.rootView = view;
        this.bridgeManager = bridgeManager;
        this.activity = activity;
    }

    private void setOnClickListener(final String str, View view) {
        Log.v("drb", "setOnClickListener：" + str);
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(8);
            view.setOnClickListener(null);
            return;
        }
        view.setVisibility(0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.web.modelloader.fetcher.WebHeadMenuFetcher.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                String json = AppInfo.f().toJson(new CallJsModel(str));
                Log.v("drb", "控件点击：" + str + " -- " + json);
                WebHeadMenuFetcher.this.bridgeManager.callHandler(LoaderConstants.NATIVE_TO_JS, json, new CallBackFunction() { // from class: com.soft.blued.ui.web.modelloader.fetcher.WebHeadMenuFetcher.2.1
                    @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                    public void onCallBack(String str2) {
                        Log.v("drb", str + "点击事件设置成功：" + str2);
                    }
                });
            }
        });
    }

    @Override // com.blued.android.module.common.web.modelloader.fetcher.DataFetcher
    public void cancel() {
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0709  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0522  */
    @Override // com.blued.android.module.common.web.modelloader.fetcher.DataFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadData(java.lang.String r7, com.blued.android.module.common.web.jsbridge.CallBackFunction r8, com.blued.android.module.common.web.modelloader.fetcher.DataFetcher.DataFetcherCallback r9) {
        /*
            Method dump skipped, instructions count: 2326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.web.modelloader.fetcher.WebHeadMenuFetcher.loadData(java.lang.String, com.blued.android.module.common.web.jsbridge.CallBackFunction, com.blued.android.module.common.web.modelloader.fetcher.DataFetcher$DataFetcherCallback):void");
    }
}
