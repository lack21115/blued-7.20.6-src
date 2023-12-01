package com.soft.blued.utils;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.openalliance.ad.constant.t;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.setting.fragment.FeedBackFragmentNew;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/MarketTool.class */
public class MarketTool {

    /* renamed from: a  reason: collision with root package name */
    private static MarketTool f21061a;

    public static MarketTool a() {
        if (f21061a == null) {
            synchronized (MarketTool.class) {
                try {
                    if (f21061a == null) {
                        f21061a = new MarketTool();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21061a;
    }

    public void a(Context context) {
        try {
            Uri parse = Uri.parse(BaseConstants.MARKET_PREFIX + context.getApplicationContext().getPackageName());
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.addFlags(268435456);
            String str = AppInfo.c;
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            boolean z = true;
            switch (str.hashCode()) {
                case -1472132929:
                    if (str.equals("a0001a")) {
                        z = true;
                        break;
                    }
                    break;
                case -1472131999:
                    if (str.equals("a0010a")) {
                        z = true;
                        break;
                    }
                    break;
                case -1472131038:
                    if (str.equals("a0020a")) {
                        z = true;
                        break;
                    }
                    break;
                case -1472131007:
                    if (str.equals("a0021a")) {
                        z = true;
                        break;
                    }
                    break;
                case -1472130976:
                    if (str.equals("a0022a")) {
                        z = true;
                        break;
                    }
                    break;
                case -1472130883:
                    if (str.equals("a0025a")) {
                        z = true;
                        break;
                    }
                    break;
                case -1472130046:
                    if (str.equals("a0031a")) {
                        z = true;
                        break;
                    }
                    break;
                case -1471209439:
                    if (str.equals("a1000a")) {
                        z = true;
                        break;
                    }
                    break;
                case -1470285887:
                    if (str.equals("a2001a")) {
                        z = true;
                        break;
                    }
                    break;
                case -1463544224:
                    if (str.equals("a9999a")) {
                        z = false;
                        break;
                    }
                    break;
            }
            Object obj = "com.tencent.android.qqdownloader";
            switch (z) {
                case false:
                case true:
                    break;
                case true:
                    obj = "com.baidu.appsearch";
                    break;
                case true:
                    obj = t.W;
                    break;
                case true:
                    obj = "com.oppo.market";
                    break;
                case true:
                    obj = "com.qihoo.appstore";
                    break;
                case true:
                    obj = "com.bbk.appstore";
                    break;
                case true:
                    obj = "com.xiaomi.market";
                    break;
                case true:
                    obj = "com.pp.assistant";
                    break;
                case true:
                    obj = "com.meizu.mstore";
                    break;
                default:
                    obj = "com.tencent.android.qqdownloader";
                    break;
            }
            if (queryIntentActivities.size() <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= queryIntentActivities.size()) {
                    return;
                }
                ResolveInfo resolveInfo = queryIntentActivities.get(i2);
                String str2 = resolveInfo.activityInfo.packageName;
                if (str2.toLowerCase().equals(obj)) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                    intent2.setComponent(new ComponentName(str2, resolveInfo.activityInfo.name));
                    context.startActivity(intent2);
                    return;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(final Context context, String str, String str2, String str3, String str4, String str5) {
        View inflate = View.inflate(context, R.layout.dialog_favourable_comment, null);
        final AlertDialog create = new AlertDialog.Builder(context).setView(inflate).create();
        ImageView imageView = (ImageView) inflate.findViewById(2131365207);
        TextView textView = (TextView) inflate.findViewById(2131372754);
        TextView textView2 = (TextView) inflate.findViewById(2131371186);
        TextView textView3 = (TextView) inflate.findViewById(2131372272);
        TextView textView4 = (TextView) inflate.findViewById(2131372071);
        textView.setText(str);
        textView2.setText(str2);
        textView3.setText(str3);
        textView4.setText(str4);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.utils.MarketTool.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                create.dismiss();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.utils.MarketTool.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                create.dismiss();
                MarketTool.this.a(context);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.utils.MarketTool.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                create.dismiss();
                InstantLog.a("my_suggestion");
                FeedBackFragmentNew.a(context);
            }
        });
        create.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        create.show();
    }

    public Intent b() {
        return new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + AppInfo.d().getPackageName()));
    }
}
