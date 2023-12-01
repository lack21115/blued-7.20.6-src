package com.blued.android.module.live_china.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveBunchLightModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveImgModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.same.tip.model.DialogWith6PW;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveGiftPayTools.class */
public class LiveGiftPayTools {
    public static DialogWith6PW b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f14163c = LiveGiftPayTools.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14162a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.utils.LiveGiftPayTools$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveGiftPayTools$1.class */
    public class AnonymousClass1 extends BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f14164a;
        final /* synthetic */ long b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14165c;
        final /* synthetic */ int d;
        final /* synthetic */ BackGiftStatusListener e;
        final /* synthetic */ LiveGiftModel f;
        final /* synthetic */ short g;
        final /* synthetic */ IRequestHost h;
        final /* synthetic */ String i;
        final /* synthetic */ int j;
        final /* synthetic */ FragmentManager k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.blued.android.module.live_china.utils.LiveGiftPayTools$1$2  reason: invalid class name */
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveGiftPayTools$1$2.class */
        public class AnonymousClass2 implements Runnable {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.blued.android.module.live_china.utils.LiveGiftPayTools$1$2$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveGiftPayTools$1$2$1.class */
            public class C02411 implements CommonAlertDialog.PWDListener {
                C02411() {
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
                    String str3 = AnonymousClass1.this.f14165c;
                    LiveRoomHttpUtils.a(str3, AnonymousClass1.this.b + "", AnonymousClass1.this.f, AnonymousClass1.this.i, str2, "", z, AnonymousClass1.this.j, new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.1.2.1.1
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                        public void onFailure(Throwable th, int i, String str4) {
                            super.onFailure(th, i, str4);
                            LiveGiftPayTools.a(str4);
                            final Pair<Integer, String> a2 = BluedHttpUtils.a(th, i, str4);
                            int intValue = a2.first.intValue();
                            if (intValue == 4221004) {
                                if (TextUtils.isEmpty(a2.second)) {
                                    return;
                                }
                                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.1.2.1.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (LiveGiftPayTools.b == null || LiveGiftPayTools.b.f14129c == null || LiveGiftPayTools.b.b == null) {
                                            return;
                                        }
                                        LiveGiftPayTools.b.f14129c.setTextColor(AnonymousClass1.this.f14164a.getResources().getColor(R.color.biao_live_bug_gift_paycode_error));
                                        LiveGiftPayTools.b.f14129c.setText((CharSequence) a2.second);
                                        LiveGiftPayTools.b.b.a();
                                    }
                                });
                            } else if (intValue == 4221008) {
                                LiveGiftPayTools.this.a(AnonymousClass1.this.e, AnonymousClass1.this.f);
                                LiveGiftPayTools.this.a(AnonymousClass1.this.f14164a, AnonymousClass1.this.k, AnonymousClass1.this.e, AnonymousClass1.this.h, AnonymousClass1.this.f);
                            } else {
                                if (!TextUtils.isEmpty(a2.second)) {
                                    AppMethods.a((CharSequence) a2.second);
                                }
                                AnonymousClass1.this.f.errorMessage = a2.second;
                                LiveGiftPayTools.this.a(AnonymousClass1.this.e, AnonymousClass1.this.f);
                                BluedHttpUtils.b(th, i, str4);
                            }
                        }

                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> bluedEntity) {
                            if (bluedEntity == null || !bluedEntity.hasData()) {
                                LiveGiftPayTools.this.a(AnonymousClass1.this.e, AnonymousClass1.this.f);
                                return;
                            }
                            PayRemaining payRemaining = bluedEntity.data.get(0);
                            String str4 = payRemaining.token;
                            if (!TextUtils.isEmpty(str4)) {
                                LiveRoomPreferences.c(str4);
                            }
                            LiveZanExtraModel liveZanExtraModel = bluedEntity.extra;
                            Logger.a("ddrb", "弹出输入密码框：giftSuccess");
                            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.1.2.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    LiveSetDataObserver.a().d(0);
                                }
                            });
                            LiveGiftPayTools.this.a(AnonymousClass1.this.f14164a, AnonymousClass1.this.b, AnonymousClass1.this.f14165c, AnonymousClass1.this.d, AnonymousClass1.this.e, AnonymousClass1.this.f, liveZanExtraModel, payRemaining, AnonymousClass1.this.g, AnonymousClass1.this.b);
                        }
                    }, AnonymousClass1.this.h);
                }
            }

            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (LiveGiftPayTools.b == null || LiveGiftPayTools.b.f14128a == null || !LiveGiftPayTools.b.f14128a.isShowing()) {
                    LiveGiftPayTools.b = CommonAlertDialog.a(AnonymousClass1.this.f14164a, AnonymousClass1.this.f14164a.getResources().getString(R.string.Live_SendPresent_verifyPassword), AnonymousClass1.this.f14164a.getResources().getString(R.string.Live_SendPresent_verifyPasswordText), false, false, true, !LiveFloatManager.a().C(), new C02411(), new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.1.2.2
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            LiveGiftPayTools.this.a(AnonymousClass1.this.e, AnonymousClass1.this.f);
                        }
                    });
                }
            }
        }

        AnonymousClass1(Context context, long j, String str, int i, BackGiftStatusListener backGiftStatusListener, LiveGiftModel liveGiftModel, short s, IRequestHost iRequestHost, String str2, int i2, FragmentManager fragmentManager) {
            this.f14164a = context;
            this.b = j;
            this.f14165c = str;
            this.d = i;
            this.e = backGiftStatusListener;
            this.f = liveGiftModel;
            this.g = s;
            this.h = iRequestHost;
            this.i = str2;
            this.j = i2;
            this.k = fragmentManager;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            LiveGiftPayTools.a(str);
            Pair<Integer, String> a2 = BluedHttpUtils.a(th, i, str);
            if (a2.first.intValue() == 0) {
                return;
            }
            int intValue = a2.first.intValue();
            if (intValue == 4221002) {
                LiveGiftPayTools.this.a(this.e, this.f);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveGiftPayTools.a(AnonymousClass1.this.f14164a, AnonymousClass1.this.h);
                    }
                });
            } else if (intValue == 4221005) {
                AppInfo.n().post(new AnonymousClass2());
            } else if (intValue == 4221008) {
                LiveGiftPayTools.this.a(this.e, this.f);
                LiveGiftPayTools.this.a(this.f14164a, this.k, this.e, this.h, this.f);
            } else {
                if (!TextUtils.isEmpty(a2.second)) {
                    AppMethods.a((CharSequence) a2.second);
                }
                Log.v("pk", "liveGiftModel default = " + a2.second);
                this.f.errorMessage = a2.second;
                LiveGiftPayTools.this.a(this.e, this.f);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> bluedEntity) {
            if (!bluedEntity.hasData()) {
                LiveGiftPayTools.this.a(this.e, this.f);
                return;
            }
            PayRemaining payRemaining = bluedEntity.data.get(0);
            LiveZanExtraModel liveZanExtraModel = bluedEntity.extra;
            Logger.a("ddrb", "giftSuccess");
            LiveGiftPayTools liveGiftPayTools = LiveGiftPayTools.this;
            Context context = this.f14164a;
            long j = this.b;
            liveGiftPayTools.a(context, j, this.f14165c, this.d, this.e, this.f, liveZanExtraModel, payRemaining, this.g, j);
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveGiftPayTools$BackGiftStatusListener.class */
    public interface BackGiftStatusListener {
        void a();

        void a(LiveGiftModel liveGiftModel, LiveGiftModel liveGiftModel2, List<LiveGiftModel> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveGiftPayTools$SingletonCreator.class */
    public static class SingletonCreator {

        /* renamed from: a  reason: collision with root package name */
        private static final LiveGiftPayTools f14179a = new LiveGiftPayTools();

        private SingletonCreator() {
        }
    }

    public static LiveGiftPayTools a() {
        return SingletonCreator.f14179a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j, String str, int i, BackGiftStatusListener backGiftStatusListener, LiveGiftModel liveGiftModel, LiveZanExtraModel liveZanExtraModel, PayRemaining payRemaining, short s, long j2) {
        b();
        if (backGiftStatusListener == null || liveGiftModel == null || liveZanExtraModel == null) {
            return;
        }
        LiveGiftModel liveGiftModel2 = new LiveGiftModel();
        if (payRemaining == null) {
            return;
        }
        try {
            LiveEventBus.get("live_pay_remain_update").post(payRemaining);
            liveGiftModel2.sendGiftStatus = 3;
            liveGiftModel2.beans = payRemaining.beans;
            liveGiftModel2.hit_id = payRemaining.hit_id;
            liveGiftModel2.hit_count = payRemaining.hit_count;
            liveGiftModel2.beans_count = payRemaining.beans_count;
            liveGiftModel2.beans_current_count = payRemaining.beans_current;
            liveGiftModel2.free_number = payRemaining.free_number;
            liveGiftModel2.bonus = payRemaining.bonus;
            liveGiftModel2.user_store_count = liveZanExtraModel.user_store_count;
            liveGiftModel2.danmu_count = liveZanExtraModel.danmu_count;
            liveGiftModel.bg_color = liveZanExtraModel.bg_color;
            liveGiftModel.bg_img = liveZanExtraModel.bg_img;
            liveGiftModel.avatar_frame_url = liveZanExtraModel.avatar_frame_url;
            if (liveZanExtraModel.join_club == 1) {
                AppMethods.d(R.string.live_fans_add_success);
                if (LiveRoomManager.a().q() != null) {
                    LiveRoomManager.a().q().fans_status = 1;
                }
                if (i == 2) {
                    LiveEventBus.get("live_fans_guide_pop").post(true);
                }
                LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_REFRESH_GIFT_LIST).post(true);
                LiveEventBus.get("key_event_live_add_fans_club_success").post(true);
            }
            if (LiveRoomManager.a().q() != null && LiveRoomManager.a().q().fans_status == 2 && liveGiftModel2.beans_count >= 6.0d) {
                Log.i("xpp", "zhi hui dian liang");
                LiveFansObserver.a().d();
            }
            if (liveGiftModel.is_join_ticket == 1) {
                if (i == 1) {
                    EventTrackLive.a(LiveProtos.Event.LIVE_SEND_FANS_CLUB_TICKET, LiveProtos.Source.FANS_CLUB_PAGE, String.valueOf(j), str);
                } else if (i == 2) {
                    EventTrackLive.a(LiveProtos.Event.LIVE_SEND_FANS_CLUB_TICKET, LiveProtos.Source.GIFT_PAGE, String.valueOf(j), str);
                }
            }
            backGiftStatusListener.a(liveGiftModel, liveGiftModel2, liveZanExtraModel.box);
            Logger.b(f14163c, "可以发礼物===", 3);
            if (TextUtils.isEmpty(liveGiftModel.contents) && liveGiftModel.effect == null) {
                if (liveGiftModel.selectNumModel == null || liveGiftModel.selectNumModel.count <= 1) {
                    liveGiftModel.hit_batch = 0;
                    if (liveGiftModel.double_hit == 1) {
                        liveGiftModel.hit_count++;
                    }
                } else {
                    liveGiftModel.hit_batch = 1;
                    liveGiftModel.hit_count = liveGiftModel.selectNumModel.count;
                }
                Logger.a("ddrb", "liveGiftModel.hit_batch = ", Integer.valueOf(liveGiftModel.hit_batch));
                Logger.a("ddrb", "liveGiftModel.hit_count = ", Integer.valueOf(liveGiftModel.hit_count));
                Logger.a("ddrb", "liveGiftModel.hit_id = ", Long.valueOf(liveGiftModel.hit_id));
                liveGiftModel.beans_count = payRemaining.beans_count;
                liveGiftModel.beans_current_count = payRemaining.beans_current;
                if (liveZanExtraModel.box != null && liveZanExtraModel.box.size() > 0) {
                    LiveGiftModel liveGiftModel3 = liveZanExtraModel.box.get(0);
                    if (liveGiftModel3.ops == 4) {
                        liveGiftModel.ops = liveGiftModel3.ops;
                        liveGiftModel.box_image = liveGiftModel3.images_static;
                    }
                }
                liveGiftModel.animation = payRemaining.animation;
                if (liveZanExtraModel.lantern_image != null && !liveZanExtraModel.lantern_image.isEmpty()) {
                    LiveBunchLightModel liveBunchLightModel = new LiveBunchLightModel();
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (LiveImgModel liveImgModel : liveZanExtraModel.lantern_image) {
                        arrayList.add(liveImgModel.getImg());
                    }
                    liveBunchLightModel.setImage(arrayList);
                    liveBunchLightModel.setPlay_times(liveZanExtraModel.lantern_play_times);
                    liveGiftModel.bunchLightModel = liveBunchLightModel;
                }
                if (liveZanExtraModel.behalf_bind_status) {
                    return;
                }
                LiveMsgSendManager.a().a(liveGiftModel);
                return;
            }
            Logger.a("ddrb", "弹幕消息，不模拟发消息");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final FragmentManager fragmentManager, final BackGiftStatusListener backGiftStatusListener, final IRequestHost iRequestHost, final LiveGiftModel liveGiftModel) {
        b();
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.3
            @Override // java.lang.Runnable
            public void run() {
                IRequestHost iRequestHost2;
                if (LiveGiftPayTools.f14162a || (iRequestHost2 = iRequestHost) == null || !iRequestHost2.isActive()) {
                    return;
                }
                String string = context.getResources().getString(R.string.Live_SendPresent_notEnoughWandou);
                String str = string;
                if (liveGiftModel.effect != null) {
                    str = string;
                    if (liveGiftModel.effect.size() > 0) {
                        str = context.getResources().getString(R.string.Live_effect_not_enough);
                    }
                }
                LiveGiftPayTools.f14162a = true;
                Context context2 = context;
                CommonAlertDialog.a(context2, (View) null, "", str, context2.getResources().getString(R.string.cancel), context.getResources().getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        if (LiveDataManager.a().f()) {
                            if (backGiftStatusListener != null) {
                                backGiftStatusListener.a();
                            }
                            LiveRoomInfo.a().a(context, 2);
                        } else {
                            LiveRoomInfo.a().a(context, fragmentManager, 2);
                        }
                        LiveGiftPayTools.f14162a = false;
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.3.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        LiveGiftPayTools.f14162a = false;
                    }
                }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.3.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LiveGiftPayTools.f14162a = false;
                    }
                }, true);
            }
        });
    }

    public static void a(Context context, final IRequestHost iRequestHost) {
        DialogWith6PW dialogWith6PW = b;
        if (dialogWith6PW == null || dialogWith6PW.f14128a == null || !b.f14128a.isShowing()) {
            b = CommonAlertDialog.a(context, context.getResources().getString(R.string.Live_SendPresent_resetPayPassword), context.getResources().getString(R.string.live_set_6_num), true, new CommonAlertDialog.PWDListener() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.2
                @Override // com.blued.android.module.live_china.same.tip.CommonAlertDialog.PWDListener
                public void a(String str, boolean z, DialogWith6PW dialogWith6PW2) {
                    LiveRoomInfo.a().a(str, z, IRequestHost.this);
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackGiftStatusListener backGiftStatusListener, LiveGiftModel liveGiftModel) {
        b();
        if (backGiftStatusListener == null || liveGiftModel == null) {
            return;
        }
        LiveGiftModel liveGiftModel2 = new LiveGiftModel();
        liveGiftModel2.sendGiftStatus = 2;
        Log.v("pk", "liveGiftModel = " + liveGiftModel.errorMessage);
        backGiftStatusListener.a(liveGiftModel, liveGiftModel2, null);
        Logger.b(f14163c, "取消发礼物===", 2);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str, new TypeToken<BluedEntityA<PayRemaining>>() { // from class: com.blued.android.module.live_china.utils.LiveGiftPayTools.4
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

    public static void b() {
        DialogWith6PW dialogWith6PW = b;
        if (dialogWith6PW == null || dialogWith6PW.f14128a == null) {
            return;
        }
        b.f14128a.dismiss();
    }

    public void a(Context context, FragmentManager fragmentManager, short s, long j, int i, IRequestHost iRequestHost, LiveGiftModel liveGiftModel, String str, String str2, int i2, BackGiftStatusListener backGiftStatusListener) {
        if (liveGiftModel == null || backGiftStatusListener == null) {
            return;
        }
        LogUtils.c("checkGiftPayStatus:  mSessionId:" + j + ", ticketSource: " + i + ", liveGiftModel:" + liveGiftModel.toString() + ", target_uid:" + str + ", discount_id:" + str2 + ", giftCount:" + i2);
        try {
            try {
                LiveRoomHttpUtils.a(str, j + "", liveGiftModel, str2, "", LiveRoomPreferences.b(""), false, i2, (BluedUIHttpResponse) new AnonymousClass1(context, j, str, i, backGiftStatusListener, liveGiftModel, s, iRequestHost, str2, i2, fragmentManager), iRequestHost);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                a(backGiftStatusListener, liveGiftModel);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void a(Context context, FragmentManager fragmentManager, short s, long j, IRequestHost iRequestHost, LiveGiftModel liveGiftModel, String str, String str2, int i, BackGiftStatusListener backGiftStatusListener) {
        a(context, fragmentManager, s, j, 0, iRequestHost, liveGiftModel, str, str2, i, backGiftStatusListener);
    }
}
