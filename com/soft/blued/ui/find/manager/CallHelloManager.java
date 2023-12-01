package com.soft.blued.ui.find.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.HelloHttpUtils;
import com.soft.blued.log.bytedance.CallEventUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.fragment.HelloOpenDialogFragment;
import com.soft.blued.ui.find.fragment.HelloStateDialogFragment;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.HelloOpenState;
import com.soft.blued.ui.find.observer.CallHelloObserver;
import com.soft.blued.ui.msg.fragment.OpenCallTwiceDialogFragment;
import com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.activity.BDActivityManager;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/CallHelloManager.class */
public class CallHelloManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile CallHelloManager f16871a;
    private volatile CallMeStatusData b;

    /* renamed from: c  reason: collision with root package name */
    private int f16872c;
    private Timer d;
    private int e;
    private Timer f;
    private boolean g = true;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/CallHelloManager$ToOpenListener.class */
    public interface ToOpenListener {
        void done(boolean z);
    }

    private CallHelloManager() {
    }

    public static CallHelloManager a() {
        if (f16871a == null) {
            synchronized (CallHelloManager.class) {
                try {
                    if (f16871a == null) {
                        f16871a = new CallHelloManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f16871a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i, GuyProtos.VocativeType vocativeType, String str, boolean z, String str2) {
        if (z) {
            EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.CALL_MORE_TIMES, vocativeType, str2);
            return;
        }
        switch (i) {
            case 1:
                EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.VOCATIVE_HOMEPAGE, vocativeType, str2);
                return;
            case 2:
                EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.VOCATIVE_MESSAGE, vocativeType, str2);
                CallEventUtils.a("VOCATIVE_MESSAGE");
                return;
            case 3:
                EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.HOME_VOCATIVE_BTN, vocativeType, str2);
                CallEventUtils.a("HOME_VOCATIVE_BTN");
                return;
            case 4:
                EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.HOME_KEEP_ON, vocativeType, str2);
                CallEventUtils.a("HOME_KEEP_ON");
                return;
            case 5:
                CallEventUtils.a("REPORT_KEEP_ON");
                return;
            case 6:
                CallEventUtils.a("ORDER_BUY");
                break;
            case 7:
                EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.VISIT_PAGE_CALL, vocativeType, str2);
                return;
            case 8:
                CallEventUtils.a("VOCATIVE_SECOND_PAGE");
                return;
            case 9:
                EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, EventTrackGuy.a(str), vocativeType, str2);
                return;
            case 10:
            default:
                return;
            case 11:
                EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.CALL_POP, vocativeType, str2);
                CallEventUtils.a("CALL_POP");
                return;
            case 12:
                break;
            case 13:
                EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW, GuyProtos.VocativeSourcePage.PUSH_CALL_TIME, vocativeType, str2);
                return;
        }
        CallEventUtils.a("ORDER_BUY_MORE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, final ToOpenListener toOpenListener, boolean z) {
        if (BluedPreferences.dB() || !z) {
            toOpenListener.done(true);
            return;
        }
        EventTrackGuy.b(GuyProtos.Event.VOCATIVE_OPEN_POP_SHOW);
        BluedAlertDialog a2 = CommonAlertDialog.a(context, context.getString(R.string.call_open_spotlight_reminder), context.getString(R.string.call_open_spotlight_reminder_msg), context.getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                BluedPreferences.dC();
                EventTrackGuy.b(GuyProtos.Event.VOCATIVE_PROMPT_TRUE_BTN_CLICK);
                toOpenListener.done(true);
            }
        }, (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                toOpenListener.done(false);
            }
        }, (DialogInterface.OnDismissListener) null);
        a2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                toOpenListener.done(false);
            }
        });
        a2.c().setGravity(1);
    }

    static /* synthetic */ int c(CallHelloManager callHelloManager) {
        int i = callHelloManager.e;
        callHelloManager.e = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Context context, final ToOpenListener toOpenListener, final boolean z) {
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.10
            public void U_() {
                CallHelloManager.this.b(context, toOpenListener, z);
            }

            public void a(String[] strArr) {
                toOpenListener.done(false);
            }
        });
    }

    public void a(final Context context, final IRequestHost iRequestHost, final int i) {
        if (this.b == null || this.b.countdown <= 0) {
            return;
        }
        try {
            c();
            this.e = this.b.countdown;
            Timer timer = new Timer();
            this.d = timer;
            timer.schedule(new TimerTask() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.11
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    CallHelloManager.c(CallHelloManager.this);
                    if (CallHelloManager.this.e > 0) {
                        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.11.3
                            @Override // java.lang.Runnable
                            public void run() {
                                CallHelloObserver.a().a(CallHelloManager.this.e);
                            }
                        });
                        return;
                    }
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CallHelloManager.this.b.call_status = 5;
                            CallHelloObserver.a().a(CallHelloManager.this.b);
                        }
                    });
                    CallHelloManager.this.c();
                    AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.11.2
                        @Override // java.lang.Runnable
                        public void run() {
                            CallHelloManager.this.a(context, iRequestHost, i, (ToOpenListener) null);
                        }
                    }, 1000L);
                }
            }, 0L, 1000L);
        } catch (Throwable th) {
        }
    }

    public void a(Context context, IRequestHost iRequestHost, int i, ToOpenListener toOpenListener) {
        a(context, iRequestHost, i, false, false, toOpenListener);
    }

    public void a(final Context context, IRequestHost iRequestHost, final int i, final boolean z, final boolean z2, final ToOpenListener toOpenListener) {
        FindHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<CallMeStatusData>>(iRequestHost) { // from class: com.soft.blued.ui.find.manager.CallHelloManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CallMeStatusData> bluedEntityA) {
                if (bluedEntityA.data == null || !bluedEntityA.hasData()) {
                    return;
                }
                CallHelloManager.this.b = (CallMeStatusData) bluedEntityA.getSingleData();
                CallHelloManager.this.f16872c = BluedPreferences.bL();
                if (CallHelloManager.this.f16872c == 1 && CallHelloManager.this.b.call_status == 0) {
                    BluedPreferences.o(5);
                    CallHelloManager.this.b.call_status = 5;
                } else {
                    BluedPreferences.o(CallHelloManager.this.b.call_status);
                }
                if (toOpenListener != null) {
                    if (CallHelloManager.this.b.call_status != 0) {
                        if (!z) {
                            HelloStateDialogFragment.a(context, CallHelloManager.a().b());
                        }
                        toOpenListener.done(false);
                    } else if (CallHelloManager.this.b == null || (CallHelloManager.this.b.free_count == 0 && CallHelloManager.this.b.pay_count == 0)) {
                        if (BluedConfig.a().R() != 1) {
                            CallHelloManager.a(i, GuyProtos.VocativeType.VOCATIVE_COMMON, "", z2, "");
                        }
                        PrivilegeBuyDialogFragment.a(context, i);
                        toOpenListener.done(false);
                    } else if (BluedConfig.a().C()) {
                        CallHelloManager.this.a(context, z, i);
                        toOpenListener.done(false);
                    } else if (z) {
                        CallHelloManager.this.a(context, z2, i, toOpenListener);
                    } else {
                        CallHelloManager.this.a(context, toOpenListener);
                    }
                }
                CallHelloObserver.a().a(CallHelloManager.this.b);
            }
        }, iRequestHost);
    }

    public void a(final Context context, IRequestHost iRequestHost, final boolean z, final int i) {
        if (BluedConfig.a().ac()) {
            FindHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<CallMeStatusData>>(iRequestHost) { // from class: com.soft.blued.ui.find.manager.CallHelloManager.3
                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(final BluedEntityA<CallMeStatusData> bluedEntityA) {
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str;
                            String str2;
                            BluedEntityA bluedEntityA2 = bluedEntityA;
                            if (bluedEntityA2 == null || bluedEntityA2.getSingleData() == null) {
                                str = "";
                                str2 = str;
                            } else {
                                str = ((CallMeStatusData) bluedEntityA.getSingleData()).button;
                                str2 = ((CallMeStatusData) bluedEntityA.getSingleData()).button_top;
                            }
                            OpenCallTwiceDialogFragment.b.a(context, str, str2, i, z);
                        }
                    });
                }
            }, iRequestHost);
        } else {
            a(context, iRequestHost, z, i, false);
        }
    }

    public void a(final Context context, IRequestHost iRequestHost, boolean z, final int i, final boolean z2) {
        HelloHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<HelloOpenState>>(iRequestHost) { // from class: com.soft.blued.ui.find.manager.CallHelloManager.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<HelloOpenState> bluedEntityA) {
                if (bluedEntityA.data == null || !bluedEntityA.hasData()) {
                    return;
                }
                final HelloOpenState helloOpenState = (HelloOpenState) bluedEntityA.getSingleData();
                CallHelloManager.this.b.is_quietly = helloOpenState.is_quietly;
                if (helloOpenState.open_status == 0) {
                    ToastUtils.a(context.getResources().getString(R.string.open_failed));
                } else if (helloOpenState.open_status == 2) {
                    if (BluedConfig.a().R() != 1 || z2) {
                        CallHelloManager.a(i, GuyProtos.VocativeType.VOCATIVE_COMMON, "", z2, "");
                    }
                    PrivilegeBuyDialogFragment.a(context, i, z2);
                } else if (helloOpenState.open_status == 3) {
                    CallHelloManager.this.b.call_status = 2;
                    HelloStateDialogFragment.a(context, CallHelloManager.this.b);
                    CallHelloObserver.a().a(CallHelloManager.this.b);
                } else if (helloOpenState.open_status != 1) {
                    if (helloOpenState.open_status == 4) {
                        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CommonAlertDialog.a(BDActivityManager.f21128a.a() != null ? BDActivityManager.f21128a.a() : context, 0, AppUtils.a((int) R.string.biao_new_signin_tip), String.format(AppUtils.a((int) R.string.hello_open_failed_tips), TimeAndDateUtils.d(helloOpenState.expire_time * 1000)), (View) null, AppUtils.a((int) R.string.hello_open_failed_ok), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, false, 0, 0, false, false);
                                EventTrackGuy.b(GuyProtos.Event.VOCATIVE_MB_POP_SHOW);
                                BluedPreferences.dc();
                            }
                        });
                    } else if (helloOpenState.open_status == 5) {
                        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.4.2
                            @Override // java.lang.Runnable
                            public void run() {
                                int i2 = (int) ((helloOpenState.expire_time / 60) / 60);
                                float f = (float) ((helloOpenState.expire_time - ((i2 * 60) * 60)) / 60);
                                int i3 = (int) f;
                                int i4 = i3;
                                if (f > i3) {
                                    i4 = i3 + 1;
                                }
                                CommonAlertDialog.a(BDActivityManager.f21128a.a() != null ? BDActivityManager.f21128a.a() : context, 0, AppUtils.a((int) R.string.hello_open_mute_title), String.format(AppUtils.a((int) R.string.hello_open_mute_tip), i2 + AppUtils.a((int) R.string.hello_open_mute_tip_hour) + i4 + AppUtils.a((int) R.string.hello_open_mute_tip_minutes)), (View) null, AppUtils.a((int) R.string.hello_open_mute_ok), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, false, 0, 0, false, false);
                            }
                        });
                    }
                } else {
                    CallHelloManager.this.b.call_status = 4;
                    CallHelloManager.this.b.countdown = (int) helloOpenState.countdown;
                    CallHelloManager.this.b.multiples = helloOpenState.multiples;
                    if (z2) {
                        CallHelloManager.a().i();
                    }
                    HelloStateDialogFragment.a(context, CallHelloManager.this.b);
                    CallHelloObserver.a().a(CallHelloManager.this.b);
                }
            }
        }, iRequestHost, z, i == 2 ? "vocative_msg" : "", z2);
    }

    public void a(Context context, ToOpenListener toOpenListener) {
        a(context, toOpenListener, true);
    }

    public void a(final Context context, final ToOpenListener toOpenListener, final boolean z) {
        if (PermissionUtils.a()) {
            b(context, toOpenListener, z);
            return;
        }
        Activity activity = (Activity) context;
        if ((activity == null || activity.isFinishing()) && !(context instanceof Application)) {
            return;
        }
        CommonAlertDialog.a(context, context.getString(R.string.hello_location_permission_title), context.getString(R.string.hello_location_permission), context.getString(R.string.hello_location_setting), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                CallHelloManager.this.c(context, toOpenListener, z);
            }
        }, (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                toOpenListener.done(false);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    public void a(Context context, boolean z, int i) {
        HelloOpenDialogFragment.a(context, z, i);
    }

    public void a(final Context context, final boolean z, final int i, final ToOpenListener toOpenListener) {
        if (context == null) {
            return;
        }
        String string = context.getString(R.string.hello_now_open);
        if (z) {
            string = context.getString(R.string.open_twice_call_now);
        }
        EventTrackGuy.b(GuyProtos.Event.VOCATIVE_BUY_SUCCESS_POP_SHOW);
        BluedAlertDialog a2 = CommonAlertDialog.a(context, context.getString(R.string.hello_buy_success), context.getString(R.string.hello_buy_success_tip), string, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                EventTrackGuy.b(GuyProtos.Event.VOCATIVE_BUY_SUCCESS_POP_OPEN_BTN_CLICK);
                if (!z) {
                    CallHelloManager.this.a(context, toOpenListener, false);
                    return;
                }
                toOpenListener.done(false);
                CallHelloManager.this.a(context, (IRequestHost) null, false, i, true);
            }
        }, (DialogInterface.OnDismissListener) null, 1);
        a2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.14
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                toOpenListener.done(false);
            }
        });
        a2.c().setGravity(1);
    }

    public void a(IRequestHost iRequestHost) {
        FindHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<CallMeStatusData>>(iRequestHost) { // from class: com.soft.blued.ui.find.manager.CallHelloManager.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CallMeStatusData> bluedEntityA) {
                if (bluedEntityA.data == null || !bluedEntityA.hasData()) {
                    return;
                }
                CallHelloObserver.a().a(CallHelloManager.this.b);
            }
        }, iRequestHost);
    }

    public void a(CallMeStatusData callMeStatusData) {
        synchronized (this) {
            this.b = callMeStatusData;
        }
    }

    public CallMeStatusData b() {
        CallMeStatusData callMeStatusData;
        synchronized (this) {
            if (this.b == null) {
                this.b = new CallMeStatusData();
            }
            callMeStatusData = this.b;
        }
        return callMeStatusData;
    }

    public void c() {
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
            this.d = null;
        }
    }

    public void d() {
        if (this.b == null) {
            return;
        }
        e();
        int i = this.b.free_count == 0 ? this.b.pay_count : this.b.free_count;
        if (i == 0) {
            return;
        }
        Timer timer = new Timer();
        this.f = timer;
        final int i2 = i;
        timer.schedule(new TimerTask() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.12
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.find.manager.CallHelloManager.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CallHelloObserver.a().a(CallHelloManager.this.g, String.valueOf(i2));
                        CallHelloManager.this.g = !CallHelloManager.this.g;
                    }
                });
            }
        }, 5000L, 5000L);
    }

    public void e() {
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
            this.f = null;
        }
    }

    public String f() {
        CallMeStatusData b = a().b();
        return b.call_status == 1 ? "doing" : b.call_status == 2 ? "audit" : (b.free_count == 0 && b.pay_count == 0) ? "no_stock" : "stock";
    }

    public boolean g() {
        boolean z = false;
        if (b() != null) {
            z = false;
            if (b().call_type == 2) {
                z = true;
            }
        }
        return z;
    }

    public boolean h() {
        boolean z = false;
        if (b() != null) {
            z = false;
            if (b().call_type == 3) {
                z = true;
            }
        }
        return z;
    }

    public void i() {
        if (b() != null) {
            b().call_type = 3;
        }
    }
}
