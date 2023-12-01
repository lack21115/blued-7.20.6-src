package com.blued.android.module.yy_china.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/broadcastReceiver/YYNetworkReceiver.class */
public class YYNetworkReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f16285a = YYNetworkReceiver.class.getName();
    private final int b = 100;

    /* renamed from: c  reason: collision with root package name */
    private final int f16286c = 101;
    private Handler d = new Handler(new Handler.Callback() { // from class: com.blued.android.module.yy_china.broadcastReceiver.YYNetworkReceiver.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            YYRoomModel b;
            if (message.what == 100 && (b = YYRoomInfoManager.e().b()) != null && TextUtils.equals(b.chat_type, "6") && b.music != null && b.music.isSinging) {
                b.music.isSinging = false;
                return false;
            }
            return false;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/broadcastReceiver/YYNetworkReceiver$SingletonCreator.class */
    public static class SingletonCreator {

        /* renamed from: a  reason: collision with root package name */
        private static final YYNetworkReceiver f16288a = new YYNetworkReceiver();

        private SingletonCreator() {
        }
    }

    public static YYNetworkReceiver a() {
        return SingletonCreator.f16288a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogUtils.c(f16285a, "  网络状态改变了。。。");
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                this.d.sendEmptyMessage(101);
                LogUtils.c(f16285a, " 非联网状态");
                return;
            }
            this.d.sendEmptyMessage(100);
            LogUtils.c(f16285a, " 联网状态");
        }
    }
}
