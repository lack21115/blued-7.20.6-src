package com.soft.blued.ui.pay.alipay;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.sys.a;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.soft.blued.utils.AppUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/alipay/AlipayUtils.class */
public class AlipayUtils {
    public static String a(String str) {
        return "sign_type=\"" + str + "\"";
    }

    public static void a(final Context context, final Handler handler, String str, String str2, String str3) {
        try {
            str3 = URLEncoder.encode(str3, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final String str4 = str2 + "&sign=\"" + str3 + a.f4647a + a(str);
        ThreadManager.a().a(new ThreadExecutor("alipay", ThreadPriority.HIGH) { // from class: com.soft.blued.ui.pay.alipay.AlipayUtils.1
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                String pay = new PayTask((Activity) context).pay(str4, true);
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = pay;
                handler.sendMessage(obtain);
            }
        });
    }

    public static boolean a() {
        return AppUtils.a("com.taobao.taobao");
    }
}
