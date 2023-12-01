package com.blued.android.module.yy_china.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.anythink.core.common.l;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYDouZiPayRequestModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import com.blued.android.module.yy_china.model.YYGiftWantSelectMode;
import com.blued.android.module.yy_china.model.YYPayGoodsExtraMode;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRemaining;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYPerFirstGiftModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment;
import com.blued.android.module.yy_china.view.YYPeyPayBackGiftView;
import com.blued.android.module.yy_china.view.YYPeyPayFirstGiftView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYPayUtils.class */
public class YYPayUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.yy_china.utils.YYPayUtils$8  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYPayUtils$8.class */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[YYConstants.PayFromSource.values().length];
            a = iArr;
            try {
                iArr[YYConstants.PayFromSource.Pay_Gift.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYPayUtils$PayGiftStatusListener.class */
    public interface PayGiftStatusListener {
        void a(int i, String str);

        void a(YYPayGoodsModel yYPayGoodsModel);
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYPayUtils$YYSuccessPasswordEvent.class */
    public static class YYSuccessPasswordEvent {
    }

    public static void a(int i, int i2, Intent intent, BaseFragment baseFragment) {
        Serializable serializableExtra;
        if (i2 == -1) {
            if ((i != 4221005 && i != 4221004) || intent == null) {
                if (i != 4221002 || intent == null || (serializableExtra = intent.getSerializableExtra("selected_model")) == null || !(serializableExtra instanceof YYDouZiPayRequestModel)) {
                    return;
                }
                YYDouZiPayRequestModel yYDouZiPayRequestModel = (YYDouZiPayRequestModel) serializableExtra;
                boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
                yYDouZiPayRequestModel.setPay_code(intent.getStringExtra("password"));
                yYDouZiPayRequestModel.setRemember_me(booleanExtra);
                a(yYDouZiPayRequestModel, baseFragment, baseFragment.getFragmentActive(), new PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.utils.YYPayUtils.3
                    @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
                    public void a(int i3, String str) {
                    }

                    @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
                    public void a(YYPayGoodsModel yYPayGoodsModel) {
                        ToastUtils.a("购买成功，快去佩戴吧");
                    }
                });
                return;
            }
            Serializable serializableExtra2 = intent.getSerializableExtra("selected_model");
            if (serializableExtra2 == null || !(serializableExtra2 instanceof YYDouZiPayRequestModel)) {
                return;
            }
            YYDouZiPayRequestModel yYDouZiPayRequestModel2 = (YYDouZiPayRequestModel) serializableExtra2;
            String stringExtra = intent.getStringExtra("password");
            boolean booleanExtra2 = intent.getBooleanExtra("remember_me", false);
            yYDouZiPayRequestModel2.setPay_code(stringExtra);
            yYDouZiPayRequestModel2.setRemember_me(booleanExtra2);
            if (TextUtils.isEmpty(stringExtra) || yYDouZiPayRequestModel2 == null) {
                return;
            }
            a(yYDouZiPayRequestModel2, baseFragment, baseFragment.getFragmentActive(), new PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.utils.YYPayUtils.2
                @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
                public void a(int i3, String str) {
                }

                @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
                public void a(YYPayGoodsModel yYPayGoodsModel) {
                    ToastUtils.a("购买成功，快去佩戴吧");
                }
            });
        }
    }

    public static void a(Fragment fragment) {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.NO_MONEY_POP_SHOW, b.room_id, b.uid);
        }
        LiveAlterDialog.a(fragment.getContext(), R.layout.dialog_charge_layout, (View.OnClickListener) null, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.utils.YYPayUtils.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYRoomModel.this != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.NO_MONEY_POP_RECHARGE_CLICK, YYRoomModel.this.room_id, YYRoomModel.this.uid);
                }
                LiveEventBus.get("event_to_charge").post("");
            }
        }, true, false);
    }

    private static void a(final BaseFragment baseFragment) {
        LiveAlterDialog.a(baseFragment.getContext(), R.layout.dialog_charge_layout, (View.OnClickListener) null, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.utils.YYPayUtils.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                new YYBeansPrePayDialogFragment().a(BaseFragment.this.getContext(), BaseFragment.this, 0).a(new YYBeansPrePayDialogFragment.YYBeansListener() { // from class: com.blued.android.module.yy_china.utils.YYPayUtils.4.1
                    @Override // com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.YYBeansListener
                    public void a(YYPerFirstGiftModel yYPerFirstGiftModel, View.OnClickListener onClickListener) {
                        YYPeyPayFirstGiftView.a(BaseFragment.this.getContext(), yYPerFirstGiftModel, onClickListener, BaseFragment.this);
                    }

                    @Override // com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.YYBeansListener
                    public void b(YYPerFirstGiftModel yYPerFirstGiftModel, View.OnClickListener onClickListener) {
                        YYPeyPayBackGiftView.b.a(BaseFragment.this.getContext(), yYPerFirstGiftModel, onClickListener, BaseFragment.this);
                    }

                    @Override // com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.YYBeansListener
                    public void s() {
                    }
                }).show(BaseFragment.this.getChildFragmentManager(), "YYBeansPrePayDialogFragment");
            }
        }, true, false);
    }

    public static void a(final YYDouZiPayRequestModel yYDouZiPayRequestModel, final BaseFragment baseFragment, final ActivityFragmentActive activityFragmentActive, final PayGiftStatusListener payGiftStatusListener) {
        if (b(baseFragment, activityFragmentActive)) {
            YYRoomHttpUtils.a(yYDouZiPayRequestModel.getProp_id(), yYDouZiPayRequestModel.getDay(), yYDouZiPayRequestModel.getPay_code(), TextUtils.isEmpty(yYDouZiPayRequestModel.getPay_code()) ? LiveBasePreferences.a("") : "", yYDouZiPayRequestModel.getRemember_me(), new BluedUIHttpResponse<BluedEntityA<YYPayGoodsModel>>(activityFragmentActive) { // from class: com.blued.android.module.yy_china.utils.YYPayUtils.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<YYPayGoodsModel> bluedEntityA) {
                    if (YYPayUtils.b(baseFragment, activityFragmentActive)) {
                        KeyboardUtils.a((Activity) baseFragment.getActivity());
                        if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                            LogUtils.c("buyGift onUIUpdate failure ... ");
                            YYPayUtils.b(yYDouZiPayRequestModel, 0, null, baseFragment, payGiftStatusListener);
                            return;
                        }
                        if (!TextUtils.isEmpty(bluedEntityA.getSingleData().payment_token)) {
                            LiveBasePreferences.b(bluedEntityA.getSingleData().payment_token);
                        }
                        if (payGiftStatusListener != null) {
                            LogUtils.c("buyGift successed: " + bluedEntityA.getSingleData().toString());
                            payGiftStatusListener.a(bluedEntityA.getSingleData());
                        }
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    LogUtils.c("buyGift failure: errorCode=" + i + "; message:" + str);
                    if (YYPayUtils.b(baseFragment, activityFragmentActive)) {
                        KeyboardUtils.a((Activity) baseFragment.getActivity());
                        YYPayUtils.b(yYDouZiPayRequestModel, i, str, baseFragment, payGiftStatusListener);
                        return true;
                    }
                    return false;
                }
            }, activityFragmentActive);
        }
    }

    public static void a(YYPayRequestModel yYPayRequestModel, YYConstants.PayFromSource payFromSource, Fragment fragment, ActivityFragmentActive activityFragmentActive, PayGiftStatusListener payGiftStatusListener) {
        a(yYPayRequestModel, payFromSource, fragment, activityFragmentActive, payGiftStatusListener, "YY_SU_DEFAULT");
    }

    public static void a(final YYPayRequestModel yYPayRequestModel, final YYConstants.PayFromSource payFromSource, final Fragment fragment, final ActivityFragmentActive activityFragmentActive, final PayGiftStatusListener payGiftStatusListener, String str) {
        if (yYPayRequestModel != null && b(fragment, activityFragmentActive)) {
            BluedUIHttpResponse<BluedEntity<YYPayGoodsModel, YYPayGoodsExtraMode>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<YYPayGoodsModel, YYPayGoodsExtraMode>>(activityFragmentActive) { // from class: com.blued.android.module.yy_china.utils.YYPayUtils.5
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str2) {
                    LogUtils.c("buyGift failure: errorCode=" + i + "; message:" + str2);
                    if (YYPayUtils.b(fragment, activityFragmentActive)) {
                        YYPayUtils.b(yYPayRequestModel.gift, yYPayRequestModel.target_uid, yYPayRequestModel.giftCount, yYPayRequestModel.pay_from, i, str2, fragment, payGiftStatusListener, payFromSource, yYPayRequestModel.wantSelect, yYPayRequestModel.needFailDialog);
                        return true;
                    }
                    return false;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<YYPayGoodsModel, YYPayGoodsExtraMode> bluedEntity) {
                    if (YYPayUtils.b(fragment, activityFragmentActive)) {
                        if (bluedEntity == null || bluedEntity.getSingleData() == null) {
                            LogUtils.c("buyGift onUIUpdate failure ... ");
                            YYPayUtils.b(yYPayRequestModel.gift, yYPayRequestModel.target_uid, yYPayRequestModel.giftCount, yYPayRequestModel.pay_from, 0, null, fragment, payGiftStatusListener, payFromSource, yYPayRequestModel.wantSelect, yYPayRequestModel.needFailDialog);
                            return;
                        }
                        if (!TextUtils.isEmpty(bluedEntity.getSingleData().token)) {
                            LiveBasePreferences.b(bluedEntity.getSingleData().token);
                        }
                        if (payGiftStatusListener != null) {
                            LogUtils.c("buyGift successed: " + bluedEntity.getSingleData().toString());
                            if (bluedEntity.extra != null && !StringUtils.b(bluedEntity.extra.getJson_contents())) {
                                bluedEntity.getSingleData().json_contents_im = bluedEntity.extra.getJson_contents();
                            }
                            YYPayGoodsModel singleData = bluedEntity.getSingleData();
                            payGiftStatusListener.a(singleData);
                            YYRoomModel b = YYRoomInfoManager.e().b();
                            if (b == null || singleData == null || singleData.current_wealth == null || singleData.next_wealth == null) {
                                return;
                            }
                            b.wealth_level = singleData.current_wealth.getWealth_level();
                            b.enter_effects = singleData.current_wealth.getEnter_effects();
                            b.avatar_frame = singleData.current_wealth.getAvatar_frame();
                        }
                    }
                }
            };
            if (yYPayRequestModel.gift != null) {
                yYPayRequestModel.gift.yyTarget_uid = yYPayRequestModel.target_uid;
                if (str != null) {
                    yYPayRequestModel.gift.yy_password_success_event = str;
                }
            }
            YYRoomHttpUtils.a(yYPayRequestModel.isFirstToMicsInTeam ? "1" : "0", yYPayRequestModel.hit_id + "", yYPayRequestModel.goods_id, yYPayRequestModel.giftCount, yYPayRequestModel.giftCount > 1 ? 1 : 0, yYPayRequestModel.room_id, yYPayRequestModel.target_uid, yYPayRequestModel.beans + "", yYPayRequestModel.payCode, TextUtils.isEmpty(yYPayRequestModel.payCode) ? LiveBasePreferences.a("") : "", yYPayRequestModel.remember_me, yYPayRequestModel.goods_type == new Integer(YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID).intValue() ? "1" : "0", TextUtils.isEmpty(yYPayRequestModel.redPacket_group_id) ? "" : yYPayRequestModel.redPacket_group_id, yYPayRequestModel.extra_contents, bluedUIHttpResponse, activityFragmentActive);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.blued.android.module.yy_china.utils.YYPayUtils$6] */
    private static void a(String str) {
        LogUtils.c("checkSavePayToken: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str, new TypeToken<BluedEntityA<YYPayRemaining>>() { // from class: com.blued.android.module.yy_china.utils.YYPayUtils.6
            }.getType());
            if (bluedEntityA.hasData()) {
                String str2 = ((YYPayRemaining) bluedEntityA.data.get(0)).token;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                LiveBasePreferences.b(str2);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Serializable> void b(T t, int i, String str, BaseFragment baseFragment, PayGiftStatusListener payGiftStatusListener) {
        LogUtils.c("buyDouziFail: " + t.toString() + ", errorCode:" + i + ", errorMessage:" + str);
        a(str);
        switch (i) {
            case 4032007:
                a(baseFragment);
                return;
            case 4221002:
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected_model", t);
                bundle.putString("title", AppUtils.a(R.string.yy_reset_pay_password));
                bundle.putString(l.y, AppUtils.a(R.string.yy_set_6_num));
                bundle.putString("http_host", YYRoomInfoManager.e().c().f());
                YYRouteUtil.a(baseFragment, bundle, i);
                return;
            case 4221004:
            case 4221005:
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("selected_model", t);
                if (i == 4221005) {
                    bundle2.putString("title", AppUtils.a(R.string.yy_verify__pay_password));
                } else {
                    bundle2.putString("title", str);
                }
                bundle2.putString(l.y, AppUtils.a(R.string.yy_verify_6_num));
                YYRouteUtil.a(baseFragment, bundle2, i);
                return;
            default:
                if (payGiftStatusListener != null) {
                    payGiftStatusListener.a(i, str);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                AppMethods.a((CharSequence) str);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Serializable> void b(T t, String str, int i, int i2, int i3, String str2, Fragment fragment, PayGiftStatusListener payGiftStatusListener, YYConstants.PayFromSource payFromSource, ArrayList<YYSeatMemberModel> arrayList, boolean z) {
        LogUtils.c("buyGiftFail: " + t.toString() + ", giftCount:" + i + ", errorCode:" + i3 + ", errorMessage:" + str2);
        StringUtils.b(str);
        if (AnonymousClass8.a[payFromSource.ordinal()] == 1) {
            ((YYGiftModel) t).sendGiftStatus = 2;
            LiveEventBus.get("gift_item_update").post(t);
        }
        LogUtils.c("buyGiftFail: " + i3 + ", msg: " + str2);
        a(str2);
        switch (i3) {
            case 4032007:
                if (payGiftStatusListener != null) {
                    payGiftStatusListener.a(i3, str2);
                }
                if (z) {
                    a(fragment);
                } else {
                    LiveEventBus.get("event_to_charge").post("");
                }
                if (i2 != 1 || YYRoomInfoManager.e().b() == null) {
                    return;
                }
                YYRoomModel b = YYRoomInfoManager.e().b();
                EventTrackYY.o(ChatRoomProtos.Event.CHAT_ROOM_OUT_GOODS_NOT_ENOUGH_SHOW, b.room_id, b.uid, ((YYGiftModel) t).goods_id);
                return;
            case 4221002:
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected_model", t);
                if (arrayList != null) {
                    bundle.putSerializable("want_select", new YYGiftWantSelectMode(arrayList));
                }
                bundle.putInt("gift_count", i);
                bundle.putString("title", AppUtils.a(R.string.yy_reset_pay_password));
                bundle.putString(l.y, AppUtils.a(R.string.yy_set_6_num));
                bundle.putString("http_host", YYRoomInfoManager.e().c().f());
                bundle.putBoolean("need_charge_dialog", z);
                YYRouteUtil.a(fragment, bundle, i3);
                return;
            case 4221004:
            case 4221005:
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("selected_model", t);
                if (arrayList != null) {
                    bundle2.putSerializable("want_select", new YYGiftWantSelectMode(arrayList));
                }
                bundle2.putInt("gift_count", i);
                if (i3 == 4221005) {
                    bundle2.putString("title", AppUtils.a(R.string.yy_verify__pay_password));
                } else {
                    bundle2.putString("title", str2);
                }
                bundle2.putString(l.y, AppUtils.a(R.string.yy_verify_6_num));
                bundle2.putBoolean("need_charge_dialog", z);
                YYRouteUtil.a(fragment, bundle2, i3);
                return;
            default:
                if (payGiftStatusListener != null) {
                    payGiftStatusListener.a(i3, str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                AppMethods.a((CharSequence) str2);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Fragment fragment, ActivityFragmentActive activityFragmentActive) {
        return activityFragmentActive != null && fragment.isAdded() && activityFragmentActive.isActive();
    }
}
