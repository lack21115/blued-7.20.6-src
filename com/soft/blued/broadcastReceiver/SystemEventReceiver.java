package com.soft.blued.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.live_china.observer.LiveSysNetworkObserver;
import com.blued.android.statistics.BluedStatistics;
import com.soft.blued.ui.video.manager.NetWorkObserverManager;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/broadcastReceiver/SystemEventReceiver.class */
public class SystemEventReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f28307a = SystemEventReceiver.class.getName();
    private final int b = 100;

    /* renamed from: c  reason: collision with root package name */
    private final int f28308c = 101;
    private final int d = 102;
    private final int e = 103;
    private Handler f = new Handler(new Handler.Callback() { // from class: com.soft.blued.broadcastReceiver.SystemEventReceiver.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    ChatManager.getInstance().networkChanged();
                    NetWorkObserverManager.a().a(true);
                    return false;
                case 101:
                    Logger.b(SystemEventReceiver.f28307a, " 非联网状态1");
                    NetWorkObserverManager.a().a(false);
                    return false;
                case 102:
                    NetWorkObserverManager.a().b(true);
                    return false;
                case 103:
                    NetWorkObserverManager.a().b(false);
                    LiveSysNetworkObserver.a().b();
                    return false;
                default:
                    return false;
            }
        }
    });

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/broadcastReceiver/SystemEventReceiver$SingletonCreator.class */
    static class SingletonCreator {

        /* renamed from: a  reason: collision with root package name */
        private static final SystemEventReceiver f28310a = new SystemEventReceiver();

        private SingletonCreator() {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Logger.b(f28307a, "  网络状态改变了。。。");
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (Intent.ACTION_LOCALE_CHANGED.equals(intent.getAction())) {
                LocaleUtils.d();
                if (!LocaleUtils.a()) {
                    LocaleUtils.c(AppInfo.d());
                    return;
                }
                LocaleUtils.a(AppInfo.d(), LocaleUtils.e());
                AppUtils.a(AppInfo.d());
                return;
            }
            return;
        }
        BluedStatistics.a().b(NetworkUtils.d());
        BluedStatistics.a().a(DeviceUtils.d());
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            this.f.sendEmptyMessage(101);
            Logger.b(f28307a, " 非联网状态");
            return;
        }
        this.f.sendEmptyMessage(100);
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            this.f.sendEmptyMessage(103);
            Logger.b(f28307a, "  正常联网的非wifi状态");
            return;
        }
        this.f.sendEmptyMessage(102);
        Logger.b(f28307a, "  wifi状态");
    }
}
