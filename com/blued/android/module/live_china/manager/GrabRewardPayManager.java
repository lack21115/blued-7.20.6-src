package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.model.DecryptJson;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.model.LiveRewardDescribe;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.same.tip.model.DialogWith6PW;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GrabRewardPayManager.class */
public class GrabRewardPayManager {

    /* renamed from: a  reason: collision with root package name */
    public DialogWith6PW f13592a;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private BackGiftStatusListener f13593c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.manager.GrabRewardPayManager$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GrabRewardPayManager$1.class */
    public class AnonymousClass1 extends BluedUIHttpResponse<BluedEntity<PayRemaining, LiveRewardDescribe>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f13594a;
        final /* synthetic */ BackGiftStatusListener b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LiveRewardConfigModel f13595c;
        final /* synthetic */ FragmentManager d;
        final /* synthetic */ IRequestHost e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ boolean h;
        final /* synthetic */ String i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.blued.android.module.live_china.manager.GrabRewardPayManager$1$2  reason: invalid class name */
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GrabRewardPayManager$1$2.class */
        public class AnonymousClass2 implements Runnable {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.blued.android.module.live_china.manager.GrabRewardPayManager$1$2$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GrabRewardPayManager$1$2$1.class */
            public class C02331 implements CommonAlertDialog.PWDListener {
                C02331() {
                }

                @Override // com.blued.android.module.live_china.same.tip.CommonAlertDialog.PWDListener
                public void a(String str, boolean z, DialogWith6PW dialogWith6PW) {
                    String str2;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        str2 = BluedHttpTools.b(str);
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                        str2 = "";
                    }
                    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveRewardDescribe>>() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.1.2.1.1
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                        public void onFailure(Throwable th, int i, String str3) {
                            GrabRewardPayManager.this.a(str3);
                            final Pair<Integer, String> a2 = BluedHttpUtils.a(th, i, str3);
                            int intValue = a2.first.intValue();
                            if (intValue == 4221004) {
                                if (TextUtils.isEmpty(a2.second)) {
                                    return;
                                }
                                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.1.2.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (GrabRewardPayManager.this.f13592a == null || GrabRewardPayManager.this.f13592a.f14129c == null || GrabRewardPayManager.this.f13592a.b == null) {
                                            return;
                                        }
                                        GrabRewardPayManager.this.f13592a.f14129c.setTextColor(AnonymousClass1.this.f13594a.getResources().getColor(R.color.biao_live_bug_gift_paycode_error));
                                        GrabRewardPayManager.this.f13592a.f14129c.setText((CharSequence) a2.second);
                                        GrabRewardPayManager.this.f13592a.b.a();
                                    }
                                });
                            } else if (intValue == 4221008) {
                                GrabRewardPayManager.this.a(AnonymousClass1.this.f13594a, AnonymousClass1.this.d, AnonymousClass1.this.b, AnonymousClass1.this.e);
                            } else {
                                GrabRewardPayManager.this.a(AnonymousClass1.this.b, a2.second);
                                BluedHttpUtils.b(th, i, str3);
                            }
                        }

                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIUpdate(BluedEntity<PayRemaining, LiveRewardDescribe> bluedEntity) {
                            if (!bluedEntity.hasData()) {
                                GrabRewardPayManager.this.a(AnonymousClass1.this.b, "");
                                return;
                            }
                            PayRemaining payRemaining = bluedEntity.data.get(0);
                            String str3 = payRemaining.token;
                            if (!TextUtils.isEmpty(str3)) {
                                LiveRoomPreferences.c(str3);
                            }
                            GrabRewardPayManager.this.a(AnonymousClass1.this.f13594a, AnonymousClass1.this.b, payRemaining, AnonymousClass1.this.f13595c, bluedEntity.extra);
                        }
                    }, AnonymousClass1.this.f13595c, AnonymousClass1.this.f, AnonymousClass1.this.g, str2, "", z, AnonymousClass1.this.h, AnonymousClass1.this.i, AnonymousClass1.this.e);
                }
            }

            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (GrabRewardPayManager.this.f13592a == null || GrabRewardPayManager.this.f13592a.f14128a == null || !GrabRewardPayManager.this.f13592a.f14128a.isShowing()) {
                    String string = AnonymousClass1.this.f13594a.getResources().getString(R.string.Live_SendPresent_verifyPassword);
                    String string2 = AnonymousClass1.this.f13594a.getResources().getString(R.string.Live_SendPresent_verifyPasswordText);
                    GrabRewardPayManager.this.f13592a = CommonAlertDialog.a(AnonymousClass1.this.f13594a, string, string2, true, false, true, !LiveFloatManager.a().C(), false, (CommonAlertDialog.PWDListener) new C02331(), new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.1.2.2
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            GrabRewardPayManager.this.a(AnonymousClass1.this.b, "");
                        }
                    });
                }
            }
        }

        AnonymousClass1(Context context, BackGiftStatusListener backGiftStatusListener, LiveRewardConfigModel liveRewardConfigModel, FragmentManager fragmentManager, IRequestHost iRequestHost, String str, String str2, boolean z, String str3) {
            this.f13594a = context;
            this.b = backGiftStatusListener;
            this.f13595c = liveRewardConfigModel;
            this.d = fragmentManager;
            this.e = iRequestHost;
            this.f = str;
            this.g = str2;
            this.h = z;
            this.i = str3;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            GrabRewardPayManager.this.a(str);
            Pair<Integer, String> a2 = BluedHttpUtils.a(th, i, str);
            if (a2.first.intValue() == 0) {
                return;
            }
            int intValue = a2.first.intValue();
            if (intValue == 4221002) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GrabRewardPayManager.this.a(AnonymousClass1.this.f13594a, AnonymousClass1.this.d, AnonymousClass1.this.e, AnonymousClass1.this.f13595c, AnonymousClass1.this.f, AnonymousClass1.this.g, AnonymousClass1.this.h, AnonymousClass1.this.b);
                    }
                });
            } else if (intValue == 4221005) {
                AppInfo.n().post(new AnonymousClass2());
            } else if (intValue == 4221008) {
                GrabRewardPayManager.this.a(this.f13594a, this.d, this.b, this.e);
            } else {
                BluedHttpUtils.b(th, i, str);
                GrabRewardPayManager.this.a(this.b, a2.second);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<PayRemaining, LiveRewardDescribe> bluedEntity) {
            if (!bluedEntity.hasData()) {
                GrabRewardPayManager.this.a(this.b, "");
                return;
            }
            GrabRewardPayManager.this.a(this.f13594a, this.b, bluedEntity.data.get(0), this.f13595c, bluedEntity.extra);
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GrabRewardPayManager$BackGiftStatusListener.class */
    public interface BackGiftStatusListener {
        void a();

        void a(PayRemaining payRemaining, LiveRewardDescribe liveRewardDescribe, LiveRewardConfigModel liveRewardConfigModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GrabRewardPayManager$SingletonCreator.class */
    public static class SingletonCreator {

        /* renamed from: a  reason: collision with root package name */
        private static final GrabRewardPayManager f13613a = new GrabRewardPayManager();

        private SingletonCreator() {
        }
    }

    public static GrabRewardPayManager a() {
        return SingletonCreator.f13613a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final FragmentManager fragmentManager, final IRequestHost iRequestHost, boolean z, final LiveRewardConfigModel liveRewardConfigModel, final String str, final String str2, final boolean z2, final String str3, final BackGiftStatusListener backGiftStatusListener) {
        String str4 = LiveRoomInfo.a().m() + "/paymentcode/1";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("verify", z ? "1" : "0");
        a2.put("type", "set");
        try {
            a2.put("code", BluedHttpTools.b(str3));
            String b = AesCrypto.b(AppInfo.f().toJson(a2));
            Map<String, String> a3 = BluedHttpTools.a();
            a3.put(BridgeUtil.UNDERLINE_STR, b);
            HttpManager.b(str4, new BluedUIHttpResponse<BluedEntityA<BasePayRemaining>>(iRequestHost) { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.5
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<BasePayRemaining> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                        AppMethods.d(com.blued.android.module.live.base.R.string.get_user_info_fail);
                    } else if (!BluedHttpUtils.a(bluedEntityA.code, bluedEntityA.message)) {
                        AppMethods.d(com.blued.android.module.live.base.R.string.get_user_info_fail);
                    } else {
                        try {
                            String c2 = AesCrypto.c(bluedEntityA.getSingleData().encrypted);
                            Logger.c("pwd", "dataStr = " + c2);
                            LiveBasePreferences.b(((DecryptJson) AppInfo.f().fromJson(c2, (Class<Object>) DecryptJson.class)).token);
                            GrabRewardPayManager.this.a(context, fragmentManager, iRequestHost, liveRewardConfigModel, str, str2, z2, str3, backGiftStatusListener);
                        } catch (Exception e) {
                        }
                    }
                }
            }, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a3)).h();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final FragmentManager fragmentManager, final BackGiftStatusListener backGiftStatusListener, final IRequestHost iRequestHost) {
        b();
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.4
            @Override // java.lang.Runnable
            public void run() {
                IRequestHost iRequestHost2;
                if (GrabRewardPayManager.this.b || (iRequestHost2 = iRequestHost) == null || !iRequestHost2.isActive()) {
                    return;
                }
                GrabRewardPayManager.this.b = true;
                Context context2 = context;
                CommonAlertDialog.a(context2, (View) null, "", context2.getResources().getString(R.string.Live_SendPresent_notEnoughWandou), context.getResources().getString(R.string.cancel), context.getResources().getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.4.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        if (backGiftStatusListener != null) {
                            backGiftStatusListener.a();
                        }
                        if (LiveDataManager.a().f()) {
                            LiveRoomInfo.a().a(context, 2);
                        } else {
                            LiveRoomInfo.a().a(context, fragmentManager, 2);
                        }
                        GrabRewardPayManager.this.b = false;
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.4.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        GrabRewardPayManager.this.a(backGiftStatusListener, "");
                        GrabRewardPayManager.this.b = false;
                    }
                }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.4.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        GrabRewardPayManager.this.b = false;
                    }
                }, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, BackGiftStatusListener backGiftStatusListener, PayRemaining payRemaining, LiveRewardConfigModel liveRewardConfigModel, LiveRewardDescribe liveRewardDescribe) {
        b();
        if (backGiftStatusListener == null) {
            return;
        }
        payRemaining.sendGiftStatus = 3;
        backGiftStatusListener.a(payRemaining, liveRewardDescribe, liveRewardConfigModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackGiftStatusListener backGiftStatusListener, String str) {
        b();
        if (backGiftStatusListener == null) {
            return;
        }
        PayRemaining payRemaining = new PayRemaining();
        payRemaining.sendGiftStatus = 2;
        payRemaining.errorMessage = str;
        backGiftStatusListener.a(payRemaining, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str, new TypeToken<BluedEntityA<PayRemaining>>() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.6
            }.getType());
            if (bluedEntityA.hasData()) {
                String str2 = ((PayRemaining) bluedEntityA.data.get(0)).token;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                LiveRoomPreferences.c(str2);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    private void b() {
        DialogWith6PW dialogWith6PW = this.f13592a;
        if (dialogWith6PW == null || dialogWith6PW.f14128a == null) {
            return;
        }
        this.f13592a.f14128a.dismiss();
    }

    public void a(final Context context, final FragmentManager fragmentManager, final IRequestHost iRequestHost, final LiveRewardConfigModel liveRewardConfigModel, final String str, final String str2, final boolean z, final BackGiftStatusListener backGiftStatusListener) {
        DialogWith6PW dialogWith6PW = this.f13592a;
        if (dialogWith6PW == null || dialogWith6PW.f14128a == null || !this.f13592a.f14128a.isShowing()) {
            this.f13592a = CommonAlertDialog.a(context, context.getResources().getString(R.string.Live_SendPresent_resetPayPassword), context.getResources().getString(R.string.live_set_6_num), true, new CommonAlertDialog.PWDListener() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.2
                @Override // com.blued.android.module.live_china.same.tip.CommonAlertDialog.PWDListener
                public void a(String str3, boolean z2, DialogWith6PW dialogWith6PW2) {
                    GrabRewardPayManager.this.a(context, fragmentManager, iRequestHost, z2, liveRewardConfigModel, str, str2, z, str3, backGiftStatusListener);
                }
            }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.manager.GrabRewardPayManager.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    GrabRewardPayManager.this.a(backGiftStatusListener, "");
                }
            });
        }
    }

    public void a(Context context, FragmentManager fragmentManager, IRequestHost iRequestHost, LiveRewardConfigModel liveRewardConfigModel, String str, String str2, boolean z, String str3, BackGiftStatusListener backGiftStatusListener) {
        this.f13593c = backGiftStatusListener;
        try {
            LiveRoomHttpUtils.a((BluedUIHttpResponse) new AnonymousClass1(context, backGiftStatusListener, liveRewardConfigModel, fragmentManager, iRequestHost, str, str2, z, str3), liveRewardConfigModel, str, str2, "", LiveRoomPreferences.b(""), false, z, str3, iRequestHost);
        } catch (Exception e) {
            e.printStackTrace();
            a(backGiftStatusListener, "");
        }
    }
}
