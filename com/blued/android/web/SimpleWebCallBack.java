package com.blued.android.web;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.anythink.core.common.res.d;
import com.app.share.ShareUtils;
import com.app.share.model.ShareEntity;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.views.WebBtmOptions;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.openalliance.ad.constant.s;
import com.soft.blued.R;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.net.URL;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/SimpleWebCallBack.class */
public class SimpleWebCallBack implements BluedWebView.WebCallback {

    /* renamed from: a  reason: collision with root package name */
    public ShareOptionRecyclerAdapter.ShareOptionsItemClickListener f18774a;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public WebBtmOptions f18775c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        InstantLog.b("web_page_options_click", 3);
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void a() {
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void a(BluedWebView bluedWebView, int i) {
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void a(BluedWebView bluedWebView, int i, String str, String str2) {
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void a(BluedWebView bluedWebView, String str) {
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void a(BluedWebView bluedWebView, String str, boolean z) {
    }

    public void a(ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener) {
        this.f18774a = shareOptionsItemClickListener;
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void a(String str) {
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void a(final String str, final String str2, final Fragment fragment, final BluedWebView bluedWebView) {
        boolean z = bluedWebView.b() == 9;
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            AppHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<JudgeWebUrlParseJson>>() { // from class: com.blued.android.web.SimpleWebCallBack.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<JudgeWebUrlParseJson> bluedEntityA) {
                    if (!CommonTools.a(fragment) || bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        return;
                    }
                    int i = bluedEntityA.data.get(0).verification;
                    SimpleWebCallBack.this.b(bluedWebView, i);
                    if (i != -1) {
                        WebBlackListPreference.b(str);
                        WebBlackListPreference.b(str2);
                        return;
                    }
                    if (!WebBlackListPreference.c(str)) {
                        WebBlackListPreference.a(str);
                    }
                    if (WebBlackListPreference.c(str2)) {
                        return;
                    }
                    WebBlackListPreference.a(str2);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str3) {
                    SimpleWebCallBack.this.b(bluedWebView, 0);
                    return true;
                }
            }, z, str2, str);
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, String str5, BluedWebView bluedWebView) {
        String str6;
        try {
            str6 = new URL(str2).getHost();
        } catch (Exception e) {
            str6 = d.f6907a;
        }
        String string = AppInfo.d().getString(R.string.web_js_get_share_info);
        if (bluedWebView.c() != null) {
            WebView c2 = bluedWebView.c();
            Tracker.loadUrl(c2, "javascript:" + string);
            WebView c3 = bluedWebView.c();
            Tracker.loadUrl(c3, "javascript:getShareInfoFunction('" + str2 + "','" + str6 + "','" + str3 + "','" + str4 + "','" + str + "','" + i + "','" + str5 + "')");
        }
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void a(String str, String str2, String str3, String str4, int i, Map<String, String> map, BluedWebView bluedWebView) {
        a(str, str2, str3, str4, i, (map == null || !map.containsKey("src_url")) ? "" : map.get("src_url"), bluedWebView);
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, BluedWebView bluedWebView) {
        try {
            if (this.f18775c == null) {
                this.f18775c = new WebBtmOptions(bluedWebView.a().getActivity(), new View.OnClickListener() { // from class: com.blued.android.web.-$$Lambda$SimpleWebCallBack$dOeMybZGPQq_R3nRQ4bp658noT0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SimpleWebCallBack.a(view);
                    }
                });
            }
            FragmentActivity activity = bluedWebView.a().getActivity();
            JSONObject jSONObject = new JSONObject(str);
            if (StringUtils.d(jSONObject.getString("title"))) {
                jSONObject.put("title", "No Title");
            }
            JSONArray jSONArray = jSONObject.getJSONArray("thumb");
            String string = jSONArray.length() > 0 ? jSONArray.getString(0) : null;
            String string2 = jSONObject.getString("description");
            String string3 = jSONObject.getString("title");
            String string4 = jSONObject.getString("url");
            String string5 = jSONObject.getString("bd_target_url");
            if (!TextUtils.isEmpty(string5)) {
                string4 = string5;
            }
            int intValue = Integer.valueOf(str3).intValue();
            String e = !StringUtils.d(str8) ? str8 : !StringUtils.d(string3) ? string3 : !StringUtils.d(bluedWebView.e()) ? bluedWebView.e() : activity.getResources().getString(R.string.biao_common_share);
            Log.v("drb", "shareTitle:" + e);
            Log.v("drb", "shareContent:" + string3);
            if (!StringUtils.d(str9)) {
                string2 = str9;
            } else if (StringUtils.d(string2)) {
                string2 = "";
            }
            if (bluedWebView.b() == 11) {
                e = activity.getResources().getString(2131892585);
            }
            Log.v("drb", "---- shareTitle:" + e);
            Log.v("drb", "---- shareContent:" + string2);
            ShareEntity a2 = ShareUtils.a().a(string, bluedWebView.c(), string4, e, string2, string2, intValue);
            a2.o = jSONObject.getString("activity_secret_code");
            a2.p = jSONObject.getString("activity_secret_text");
            a2.q = jSONObject.getString("activity_secret_copy");
            this.b = jSONObject.getString("activity_secret_text");
            this.f18775c.a(a2, this.f18774a);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void a(Map<String, String> map, BluedWebView bluedWebView) {
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public boolean a(Context context, String str) {
        Uri f;
        if (str == null || (f = BluedURIRouter.a().f(str)) == null) {
            return false;
        }
        String queryParameter = f.getQueryParameter("action");
        if (!TextUtils.isEmpty(queryParameter) && "liveplay".equals(queryParameter)) {
            String queryParameter2 = f.getQueryParameter("lid");
            String queryParameter3 = f.getQueryParameter("uid");
            String str2 = queryParameter3;
            if (!TextUtils.isEmpty(queryParameter3)) {
                str2 = EncryptTool.a(queryParameter3);
            }
            String queryParameter4 = f.getQueryParameter("from");
            String str3 = queryParameter4;
            if (TextUtils.isEmpty(queryParameter4)) {
                str3 = s.B;
            }
            LiveRoomData liveRoomData = new LiveRoomData(CommonTools.a(queryParameter2), 0, str3, str2, "", "", 0);
            liveRoomData.liveFrom = LiveUtils.a();
            liveRoomData.recommendType = LiveUtils.b();
            liveRoomData.livePosition = LiveUtils.c();
            LiveRoomInfoChannel.a(context, liveRoomData);
            return true;
        }
        return false;
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public boolean a(BluedWebView bluedWebView, BluedUrlParser bluedUrlParser) {
        return false;
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void b() {
    }

    public void b(BluedWebView bluedWebView, int i) {
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void b(BluedWebView bluedWebView, String str, boolean z) {
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public void b(String str) {
    }

    @Override // com.blued.android.framework.web.BluedWebView.WebCallback
    public boolean c(String str) {
        return WebBlackListPreference.c(str);
    }
}
