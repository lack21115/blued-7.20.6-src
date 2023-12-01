package com.tencent.open.yyb;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.yyb.a;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/AppbarAgent.class */
public class AppbarAgent extends BaseApi {
    public static final String TO_APPBAR_DETAIL = "siteIndex";
    public static final String TO_APPBAR_NEWS = "myMessage";
    public static final String TO_APPBAR_SEND_BLOG = "newThread";
    public static final String wx_appid = "wx8e8dc60535c9cd93";

    /* renamed from: a  reason: collision with root package name */
    private Bundle f24613a;
    private String b;

    public AppbarAgent(QQToken qQToken) {
        super(qQToken);
    }

    private String a() {
        Bundle bundle = new Bundle();
        if (this.mToken != null && this.mToken.getAppId() != null && this.mToken.getAccessToken() != null && this.mToken.getOpenId() != null) {
            bundle.putString("qOpenAppId", this.mToken.getAppId());
            bundle.putString("qOpenId", this.mToken.getOpenId());
            bundle.putString("qAccessToken", this.mToken.getAccessToken());
        }
        bundle.putString("qPackageName", Global.getContext().getPackageName());
        return ContainerUtils.FIELD_DELIMITER + a(bundle);
    }

    private String a(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            sb.append(str);
            sb.append("=");
            sb.append(bundle.get(str));
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        String sb2 = sb.toString();
        String str2 = sb2;
        if (sb2.endsWith(ContainerUtils.FIELD_DELIMITER)) {
            str2 = sb2.substring(0, sb2.length() - 1);
        }
        f.a("openSDK_LOG.AppbarAgent", "-->encodeParams, result: " + str2);
        return str2;
    }

    private void a(Activity activity, String str) {
        if (this.mToken == null) {
            return;
        }
        Intent intent = new Intent(activity, AppbarActivity.class);
        intent.putExtra("appid", this.mToken.getAppId());
        if (this.mToken.getAccessToken() != null && this.mToken.getOpenId() != null) {
            a.C0805a c0805a = new a.C0805a();
            c0805a.b = this.mToken.getAccessToken();
            c0805a.f24618c = Long.parseLong(this.mToken.getAppId());
            c0805a.f24617a = this.mToken.getOpenId();
            a.a(activity, str, this.mToken.getOpenId(), this.mToken.getAccessToken(), this.mToken.getAppId());
        }
        intent.putExtra("url", str);
        f.a("openSDK_LOG.AppbarAgent", "-->(AppbarAgent)startAppbar H5 : url = " + str);
        try {
            activity.startActivityForResult(intent, Constants.REQUEST_APPBAR);
        } catch (Exception e) {
            f.b("openSDK_LOG.AppbarAgent", "-->(AppbarAgent)startAppbar : activity not found, start H5", e);
        }
    }

    private boolean a(String str) {
        return TO_APPBAR_DETAIL.equals(str) || TO_APPBAR_NEWS.equals(str) || TO_APPBAR_SEND_BLOG.equals(str) || "sId".equals(str) || "toThread".equals(str);
    }

    private Bundle b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("pkgName", Global.getContext().getPackageName());
        String str2 = str;
        if (!TO_APPBAR_DETAIL.equals(str)) {
            if (TO_APPBAR_SEND_BLOG.equals(str)) {
                str2 = str;
            } else if (TO_APPBAR_NEWS.equals(str)) {
                bundle.putString("source", "myapp");
                str2 = str;
            } else if ("sId".equals(str)) {
                Bundle bundle2 = this.f24613a;
                str2 = str;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                    str2 = str;
                }
            } else {
                str2 = str;
                if ("toThread".equals(str)) {
                    str2 = String.format("sId/t/%s", this.b);
                }
            }
        }
        bundle.putString("route", str2);
        return bundle;
    }

    private String b() {
        try {
            PackageInfo packageInfo = Global.getContext().getPackageManager().getPackageInfo("com.tencent.android.qqdownloader", 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String c(String str) {
        return "http://m.wsq.qq.com/direct?" + a(b(str));
    }

    private boolean d(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^[1-9][0-9]*$", str);
    }

    public void startAppbar(Activity activity, String str) {
        if (!a(str)) {
            Toast.makeText(activity, Constants.MSG_PARAM_ERROR, 0).show();
            return;
        }
        String c2 = c(str);
        String b = b();
        if (TextUtils.isEmpty(b) || SystemUtils.compareVersion(b, "4.2") < 0) {
            a(activity, c2);
            return;
        }
        String str2 = c2 + a();
        f.a("openSDK_LOG.AppbarAgent", "-->(AppbarAgent)startAppbar : yybUrl = " + str2);
        try {
            Intent intent = new Intent();
            intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.assistant.activity.ExportBrowserActivity");
            intent.putExtra("com.tencent.assistant.BROWSER_URL", str2);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } catch (Exception e) {
            f.b("openSDK_LOG.AppbarAgent", "-->(AppbarAgent)startAppbar : ExportBrowserActivity not found, start H5", e);
            a(activity, c2);
        }
    }

    public void startAppbarLabel(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(activity, Constants.MSG_PARAM_ERROR, 0).show();
            return;
        }
        Bundle bundle = new Bundle();
        this.f24613a = bundle;
        bundle.putString("params", "label/" + str);
        startAppbar(activity, "sId");
    }

    public void startAppbarThread(Activity activity, String str) {
        if (!d(str)) {
            Toast.makeText(activity, Constants.MSG_PARAM_ERROR, 0).show();
            return;
        }
        this.b = str;
        startAppbar(activity, "toThread");
    }
}
