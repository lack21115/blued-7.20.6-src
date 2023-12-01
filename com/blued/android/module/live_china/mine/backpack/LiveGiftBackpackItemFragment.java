package com.blued.android.module.live_china.mine.backpack;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.common.view.CommonGiftTabView;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.backpack.LiveGiftBagItemTabView;
import com.blued.android.module.live_china.model.LiveAvatarFrameModel;
import com.blued.android.module.live_china.model.LiveBubbleBgModel;
import com.blued.android.module.live_china.model.LiveChatBadgeModel;
import com.blued.android.module.live_china.model.LiveGiftBackpackEquips;
import com.blued.android.module.live_china.model.LiveGiftBackpackModel;
import com.blued.android.module.live_china.model.LiveGiftBackpackProps;
import com.blued.android.module.live_china.model.LiveGiftBackpackTabsModel;
import com.blued.android.module.live_china.model.LiveGiftBagChatBadgeModel;
import com.blued.android.module.live_china.model.LiveGiftCardFrameModel;
import com.blued.android.module.live_china.model.LiveGiftFragmentModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftPackageModel;
import com.blued.android.module.live_china.model.LiveGiftSkinItemModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBackpackItemFragment.class */
public final class LiveGiftBackpackItemFragment extends BaseGiftBagRootFragment<CommonGiftPackageModel<?>> {
    private ArrayList<LiveGiftModel> g;
    private ArrayList<LiveGiftFragmentModel> l;
    private LiveGiftBackpackProps m;
    private LiveGiftBackpackEquips n;
    private LiveGiftPackageModel t;
    private final ArrayList<CommonGiftPackageModel<?>> f = new ArrayList<>();
    private String o = "";
    private final Lazy p = LazyKt.a(new Function0<LinearLayout>() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackItemFragment$pageNoDataLayout$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LinearLayout invoke() {
            View view;
            view = LiveGiftBackpackItemFragment.this.rootView;
            return (LinearLayout) view.findViewById(R.id.base_gift_page_no_data_layout);
        }
    });
    private final Lazy q = LazyKt.a(new Function0<TextView>() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackItemFragment$pageNoDataTv$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final TextView invoke() {
            View view;
            view = LiveGiftBackpackItemFragment.this.rootView;
            return (TextView) view.findViewById(R.id.base_gift_page_no_data_tv);
        }
    });
    private final Lazy r = LazyKt.a(new Function0<LinearLayout>() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackItemFragment$llPagerContentView$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LinearLayout invoke() {
            View view;
            view = LiveGiftBackpackItemFragment.this.rootView;
            return (LinearLayout) view.findViewById(R.id.ll_pager_content);
        }
    });
    private final Observer<LiveGiftModel> s = new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackItemFragment$6xyLFEU-VZf3sUahEygBJTB2ToA
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            LiveGiftBackpackItemFragment.a(LiveGiftBackpackItemFragment.this, (LiveGiftModel) obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackItemFragment this$0, LiveGiftModel liveGiftModel) {
        ArrayList<CommonGiftPackageModel<?>> arrayList;
        Intrinsics.e(this$0, "this$0");
        if (this$0.m == null || (arrayList = this$0.f) == null || arrayList.size() <= 1) {
            return;
        }
        LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) this$0.f.get(0);
        if (liveGiftPackageModel.packageType == 8) {
            liveGiftModel.user_store_count--;
            if (liveGiftModel.user_store_count == 0) {
                Iterator it = liveGiftPackageModel.goods.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    LiveGiftModel liveGiftModel2 = (LiveGiftModel) it.next();
                    if (liveGiftModel2.goods_id.equals(liveGiftModel.goods_id)) {
                        liveGiftPackageModel.goods.remove(liveGiftModel2);
                        break;
                    }
                }
            }
        }
        LiveGiftPackageModel liveGiftPackageModel2 = (LiveGiftPackageModel) this$0.f.get(1);
        if (liveGiftPackageModel2.packageType == 7) {
            LiveGiftModel liveGiftModel3 = new LiveGiftModel();
            ReflectionUtils.a(liveGiftModel, liveGiftModel3);
            liveGiftModel3.count = 1;
            liveGiftModel3.is_use = 1;
            liveGiftModel3.expire_time = String.valueOf(liveGiftModel.effect_time + (System.currentTimeMillis() / 1000));
            liveGiftModel3.user_store_count = 1;
            liveGiftPackageModel2.goods.add(liveGiftModel3);
        }
        this$0.b(this$0.f);
        this$0.d();
    }

    private final void a(LiveGiftBackpackEquips liveGiftBackpackEquips) {
        if (liveGiftBackpackEquips == null) {
            return;
        }
        this.f.clear();
        Iterator<LiveGiftBackpackTabsModel> it = liveGiftBackpackEquips.getTabs().iterator();
        while (it.hasNext()) {
            LiveGiftBackpackTabsModel next = it.next();
            LiveGiftPackageModel liveGiftPackageModel = new LiveGiftPackageModel();
            liveGiftPackageModel.name = next.getName();
            liveGiftPackageModel.type_name = next.getKey();
            liveGiftPackageModel.showQuestion = true;
            liveGiftPackageModel.hasNew = next.getRed_point() == 1;
            liveGiftPackageModel.red_point = next.getRed_point();
            liveGiftPackageModel.red_point_cancel = next.getRed_point_cancel();
            liveGiftPackageModel.red_point_word = next.getRed_point_word();
            liveGiftPackageModel.isBag = true;
            liveGiftPackageModel.goods.clear();
            a(liveGiftPackageModel, next.getKey());
            String key = next.getKey();
            switch (key.hashCode()) {
                case -1333284868:
                    if (!key.equals("chat_badge")) {
                        break;
                    } else {
                        liveGiftPackageModel.packageType = 12;
                        LogUtils.d("pLog", Intrinsics.a("-----chat_badge = ", (Object) liveGiftBackpackEquips.getChat_badge()));
                        try {
                            Iterator<LiveGiftBagChatBadgeModel> it2 = liveGiftBackpackEquips.getChat_badge().iterator();
                            while (it2.hasNext()) {
                                LiveGiftBagChatBadgeModel next2 = it2.next();
                                LiveGiftModel liveGiftModel = new LiveGiftModel();
                                liveGiftModel.is_use = next2.is_wear();
                                liveGiftModel.expire_time = next2.getChat_badge_expire_time();
                                liveGiftModel.is_hide_expire_time = next2.is_hide_expire_time();
                                liveGiftModel.expire = new BigInteger(next2.getChat_badge_expire_time()).intValue();
                                liveGiftModel.goods_id = next2.getChat_badge_id();
                                liveGiftModel.ops = 21;
                                liveGiftModel.images_static = next2.getChat_badge_package_url();
                                liveGiftModel.name = next2.getChat_badge_name();
                                liveGiftModel.extraModel = next2;
                                LiveChatBadgeModel liveChatBadgeModel = new LiveChatBadgeModel();
                                liveChatBadgeModel.setChat_badge_height(Integer.valueOf(next2.getChat_badge_height()));
                                liveChatBadgeModel.setChat_badge_length(Integer.valueOf(next2.getChat_badge_length()));
                                liveChatBadgeModel.setChat_badge_url(next2.getChat_badge_url());
                                liveGiftModel.chatBadgeModel = liveChatBadgeModel;
                                liveGiftPackageModel.goods.add(liveGiftModel);
                            }
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                case -1329087034:
                    if (!key.equals("chat_frame")) {
                        break;
                    } else {
                        liveGiftPackageModel.packageType = 9;
                        Iterator<LiveBubbleBgModel> it3 = liveGiftBackpackEquips.getChat_frame().iterator();
                        while (it3.hasNext()) {
                            LiveBubbleBgModel next3 = it3.next();
                            LiveGiftModel liveGiftModel2 = new LiveGiftModel();
                            liveGiftModel2.is_use = next3.wear;
                            liveGiftModel2.availability = next3.status;
                            liveGiftModel2.expire = next3.days;
                            liveGiftModel2.expire_time = next3.expire_time;
                            liveGiftModel2.is_hide_expire_time = next3.is_hide_expire_time;
                            liveGiftModel2.goods_id = String.valueOf(next3.chat_frame_id);
                            if (!TextUtils.isEmpty(next3.chat_frame)) {
                                liveGiftModel2.images_static = next3.chat_frame;
                            }
                            liveGiftModel2.ops = 18;
                            liveGiftModel2.name = next3.chat_frame_name;
                            liveGiftModel2.extraModel = next3;
                            liveGiftPackageModel.goods.add(liveGiftModel2);
                            if (liveGiftModel2.is_use == 1) {
                                next3.convertColors();
                                LiveRoomManager.a().a(next3);
                            }
                        }
                        break;
                    }
                case -1306084975:
                    if (!key.equals("effect")) {
                        break;
                    } else {
                        liveGiftPackageModel.packageType = 11;
                        Iterator<LiveGiftModel> it4 = liveGiftBackpackEquips.getEffect().iterator();
                        while (it4.hasNext()) {
                            LiveGiftModel next4 = it4.next();
                            next4.ops = 16;
                            liveGiftPackageModel.goods.add(next4);
                        }
                        break;
                    }
                case -581458169:
                    if (!key.equals("avatar_frame")) {
                        break;
                    } else {
                        liveGiftPackageModel.packageType = 10;
                        Iterator<LiveAvatarFrameModel> it5 = liveGiftBackpackEquips.getAvatar_frame().iterator();
                        while (it5.hasNext()) {
                            LiveAvatarFrameModel next5 = it5.next();
                            LiveGiftModel liveGiftModel3 = new LiveGiftModel();
                            liveGiftModel3.is_use = next5.wear;
                            liveGiftModel3.availability = next5.status;
                            liveGiftModel3.expire = next5.days;
                            liveGiftModel3.expire_time = next5.expire_time;
                            liveGiftModel3.is_hide_expire_time = next5.is_hide_expire_time;
                            liveGiftModel3.goods_id = String.valueOf(next5.avatar_frame_id);
                            liveGiftModel3.imageType = next5.avatar_frame_type;
                            liveGiftModel3.ops = 17;
                            liveGiftModel3.images_static = next5.avatar_frame;
                            liveGiftModel3.name = next5.avatar_frame_name;
                            liveGiftPackageModel.goods.add(liveGiftModel3);
                            if (liveGiftModel3.is_use == 1) {
                                LiveRoomInfo.a().a(next5.avatar_frame, next5.avatar_frame_type);
                            }
                        }
                        break;
                    }
                case 981007230:
                    if (!key.equals("card_frame")) {
                        break;
                    } else {
                        liveGiftPackageModel.packageType = 14;
                        LogUtils.d("pLog", Intrinsics.a("-----card_frame = ", (Object) liveGiftBackpackEquips.getCard_frame()));
                        try {
                            Iterator<LiveGiftCardFrameModel> it6 = liveGiftBackpackEquips.getCard_frame().iterator();
                            while (it6.hasNext()) {
                                LiveGiftCardFrameModel next6 = it6.next();
                                if (next6.getBasic() != null) {
                                    LiveGiftModel liveGiftModel4 = new LiveGiftModel();
                                    liveGiftModel4.is_use = next6.is_wear();
                                    liveGiftModel4.expire_time = next6.getExpire_time();
                                    liveGiftModel4.is_hide_expire_time = next6.is_hide_expire_time();
                                    liveGiftModel4.expire = new BigInteger(next6.getExpire_time()).intValue();
                                    liveGiftModel4.goods_id = next6.getBasic().getId();
                                    liveGiftModel4.decoration_id = String.valueOf(next6.getDecoration_id());
                                    liveGiftModel4.decoration_type = next6.getDecoration_type();
                                    liveGiftModel4.ops = 23;
                                    liveGiftModel4.images_static = next6.getBasic().getPackage_image();
                                    liveGiftModel4.name = next6.getBasic().getName();
                                    liveGiftModel4.extraModel = next6;
                                    liveGiftPackageModel.goods.add(liveGiftModel4);
                                }
                            }
                            break;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            break;
                        }
                    }
            }
            this.f.add(liveGiftPackageModel);
        }
        a(this.f);
        b(this.f);
    }

    private final void a(LiveGiftBackpackProps liveGiftBackpackProps) {
        if (liveGiftBackpackProps == null) {
            return;
        }
        this.f.clear();
        Iterator<LiveGiftBackpackTabsModel> it = liveGiftBackpackProps.getTabs().iterator();
        while (it.hasNext()) {
            LiveGiftBackpackTabsModel next = it.next();
            LogUtils.d("key = " + next.getKey() + " ---- name = " + next.getName());
            LiveGiftPackageModel liveGiftPackageModel = new LiveGiftPackageModel();
            liveGiftPackageModel.name = next.getName();
            liveGiftPackageModel.type_name = next.getKey();
            liveGiftPackageModel.hasNew = next.getRed_point() == 1;
            liveGiftPackageModel.red_point = next.getRed_point();
            liveGiftPackageModel.red_point_cancel = next.getRed_point_cancel();
            liveGiftPackageModel.red_point_word = next.getRed_point_word();
            liveGiftPackageModel.showQuestion = true;
            liveGiftPackageModel.isBag = true;
            if (LiveDataManager.a().f()) {
                liveGiftPackageModel.setLine(1);
                liveGiftPackageModel.setColumn(8);
            } else {
                liveGiftPackageModel.setLine(2);
                liveGiftPackageModel.setColumn(4);
            }
            liveGiftPackageModel.goods.clear();
            String key = next.getKey();
            if (Intrinsics.a((Object) key, (Object) "not_use")) {
                liveGiftPackageModel.packageType = 8;
                Iterator<LiveChargeCouponModel> it2 = liveGiftBackpackProps.getNot_use().iterator();
                while (it2.hasNext()) {
                    LiveChargeCouponModel next2 = it2.next();
                    LiveGiftModel liveGiftModel = new LiveGiftModel();
                    liveGiftModel.expire = (int) next2.expire_time;
                    liveGiftModel.expire_info = next2.description;
                    liveGiftModel.expire_time = String.valueOf(next2.expire_time);
                    liveGiftModel.is_hide_expire_time = next2.is_hide_expire_time;
                    liveGiftModel.goods_id = String.valueOf(next2.id);
                    liveGiftModel.images_static = next2.image;
                    liveGiftModel.ops = 20;
                    liveGiftModel.name = next2.name;
                    liveGiftModel.user_store_count = next2.count;
                    liveGiftModel.beans = next2.threshold;
                    liveGiftModel.expire_time = String.valueOf(next2.expire_time);
                    liveGiftModel.desc = next2.description;
                    liveGiftModel.effect_time = next2.effect_time;
                    liveGiftModel.type = String.valueOf(next2.prop_type);
                    liveGiftModel.extraModel = next2;
                    liveGiftModel.show_info = 1;
                    liveGiftModel.info_type = 1;
                    liveGiftModel.pop_up_title = next2.pop_up_title;
                    liveGiftModel.pop_up_description = next2.pop_up_description;
                    if (next2.prop_type == 1) {
                        liveGiftModel.info_content = "使用此券单笔充值满" + next2.threshold + "元，额外赠送" + ((Object) next2.name);
                    }
                    liveGiftPackageModel.goods.add(liveGiftModel);
                }
            } else if (Intrinsics.a((Object) key, (Object) "in_use")) {
                liveGiftPackageModel.packageType = 7;
                Iterator<LiveChargeCouponModel> it3 = liveGiftBackpackProps.getIn_use().iterator();
                while (it3.hasNext()) {
                    LiveChargeCouponModel next3 = it3.next();
                    LiveGiftModel liveGiftModel2 = new LiveGiftModel();
                    liveGiftModel2.expire = (int) next3.expire_time;
                    liveGiftModel2.expire_time = String.valueOf(next3.effect_time + next3.use_time);
                    liveGiftModel2.effect_time = next3.effect_time;
                    liveGiftModel2.is_hide_expire_time = next3.is_hide_expire_time;
                    liveGiftModel2.goods_id = String.valueOf(next3.id);
                    liveGiftModel2.images_static = next3.image;
                    liveGiftModel2.ops = 20;
                    liveGiftModel2.name = next3.name;
                    liveGiftModel2.user_store_count = next3.count;
                    liveGiftModel2.beans = next3.threshold;
                    liveGiftModel2.extraModel = next3;
                    liveGiftModel2.is_use = 1;
                    liveGiftModel2.desc = next3.description;
                    liveGiftModel2.show_info = 1;
                    liveGiftModel2.type = String.valueOf(next3.prop_type);
                    liveGiftModel2.info_type = 1;
                    if (next3.prop_type == 1) {
                        liveGiftModel2.info_content = "使用此券单笔充值满" + next3.threshold + "元，额外赠送" + ((Object) next3.name);
                    }
                    liveGiftPackageModel.goods.add(liveGiftModel2);
                }
            }
            this.f.add(liveGiftPackageModel);
        }
        a(this.f);
        b(this.f);
    }

    private final void a(LiveGiftModel liveGiftModel) {
        if (liveGiftModel == null || liveGiftModel.groups == null || liveGiftModel.groups.size() <= 1) {
            return;
        }
        if (liveGiftModel.groups.get(liveGiftModel.groups.size() - 1).count != 1) {
            List<LiveGiftNumberModel> list = liveGiftModel.groups;
            Intrinsics.c(list, "it.groups");
            CollectionsKt.g((List) list);
        }
        LiveGiftNumberModel liveGiftNumberModel = new LiveGiftNumberModel();
        liveGiftNumberModel.isUserDefined = true;
        liveGiftModel.groups.add(liveGiftNumberModel);
    }

    private final void a(LiveGiftModel liveGiftModel, LiveGiftSkinItemModel liveGiftSkinItemModel) {
        if (liveGiftModel == null || liveGiftSkinItemModel == null || TextUtils.isEmpty(liveGiftSkinItemModel.images_static)) {
            return;
        }
        liveGiftModel.images_apng2 = liveGiftSkinItemModel.images_apng;
        liveGiftModel.images_gif = liveGiftSkinItemModel.images_gif;
        liveGiftModel.images_static = liveGiftSkinItemModel.images_static;
        liveGiftModel.images_mp4 = liveGiftSkinItemModel.images_mp4;
        liveGiftModel.skin_on_use = liveGiftSkinItemModel;
        liveGiftModel.animation = liveGiftSkinItemModel.animation;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
        if (r5.equals("chat_frame") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
        if (r5.equals("chat_badge") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (com.blued.android.module.live.base.manager.LiveDataManager.a().f() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
        r4.setLine(1);
        r4.setColumn(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
        r4.setLine(2);
        r4.setColumn(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0039, code lost:
        if (r5.equals("card_frame") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0046, code lost:
        if (r5.equals("effect") == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(com.blued.android.module.live_china.model.LiveGiftPackageModel r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = r5
            int r0 = r0.hashCode()
            switch(r0) {
                case -1333284868: goto L59;
                case -1329087034: goto L4c;
                case -1306084975: goto L3f;
                case 981007230: goto L33;
                default: goto L30;
            }
        L30:
            goto L86
        L33:
            r0 = r5
            java.lang.String r1 = "card_frame"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L66
            goto L86
        L3f:
            r0 = r5
            java.lang.String r1 = "effect"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L66
            goto L86
        L4c:
            r0 = r5
            java.lang.String r1 = "chat_frame"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L66
            goto L86
        L59:
            r0 = r5
            java.lang.String r1 = "chat_badge"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L66
            goto L86
        L66:
            com.blued.android.module.live.base.manager.LiveDataManager r0 = com.blued.android.module.live.base.manager.LiveDataManager.a()
            boolean r0 = r0.f()
            if (r0 == 0) goto L7b
            r0 = r4
            r1 = 1
            r0.setLine(r1)
            r0 = r4
            r1 = 6
            r0.setColumn(r1)
            return
        L7b:
            r0 = r4
            r1 = 2
            r0.setLine(r1)
            r0 = r4
            r1 = 3
            r0.setColumn(r1)
            return
        L86:
            com.blued.android.module.live.base.manager.LiveDataManager r0 = com.blued.android.module.live.base.manager.LiveDataManager.a()
            boolean r0 = r0.f()
            if (r0 == 0) goto L9b
            r0 = r4
            r1 = 1
            r0.setLine(r1)
            r0 = r4
            r1 = 8
            r0.setColumn(r1)
            return
        L9b:
            r0 = r4
            r1 = 2
            r0.setLine(r1)
            r0 = r4
            r1 = 4
            r0.setColumn(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackItemFragment.a(com.blued.android.module.live_china.model.LiveGiftPackageModel, java.lang.String):void");
    }

    private final void a(ArrayList<LiveGiftModel> arrayList) {
        this.f.clear();
        ArrayList<LiveGiftModel> arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            BluedViewExKt.b(l());
            BluedViewExKt.a(n());
            m().setText("暂无礼物");
            return;
        }
        LiveGiftPackageModel liveGiftPackageModel = new LiveGiftPackageModel();
        liveGiftPackageModel.name = "";
        liveGiftPackageModel.type_name = liveGiftPackageModel.name;
        liveGiftPackageModel.packageType = 6;
        liveGiftPackageModel.showQuestion = true;
        liveGiftPackageModel.isBag = true;
        Intrinsics.a(arrayList);
        Iterator<LiveGiftModel> it = arrayList.iterator();
        while (it.hasNext()) {
            LiveGiftModel next = it.next();
            next.ops = 19;
            a(next);
            liveGiftPackageModel.goods.add(next);
        }
        int size = liveGiftPackageModel.goods.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            LiveGiftModel liveGiftModel = (LiveGiftModel) liveGiftPackageModel.goods.get(i2);
            if ((liveGiftModel != null ? liveGiftModel.groups : null) != null && liveGiftModel.groups.size() != 0) {
                Iterator<LiveGiftNumberModel> it2 = liveGiftModel.groups.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!TextUtils.isEmpty(it2.next().gift_pic_mp4)) {
                            liveGiftModel.isMp4 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i = i2 + 1;
        }
        for (LiveGiftModel liveGiftModel2 : liveGiftPackageModel.goods) {
            if (liveGiftModel2.skin_on_process == null || liveGiftModel2.skin_on_process.goods_id == null) {
                liveGiftModel2.skin_on_process = liveGiftModel2.skin_on_use;
            }
            if (liveGiftModel2.skin_on_use != null && StringsKt.a(liveGiftModel2.goods_id, liveGiftModel2.skin_on_use.goods_id, true)) {
                a(liveGiftModel2, liveGiftModel2.skin_on_use);
            }
        }
        if (LiveDataManager.a().f()) {
            liveGiftPackageModel.setLine(1);
            liveGiftPackageModel.setColumn(8);
        } else {
            liveGiftPackageModel.setLine(2);
            liveGiftPackageModel.setColumn(4);
        }
        this.f.add(liveGiftPackageModel);
        b(this.f);
        a(this.f);
        this.f13890a.setData(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGiftBackpackItemFragment this$0, LiveGiftModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        if (this$0.j.size() > 0 && (this$0.j.get(0) instanceof LiveGiftBackpackParentFragment)) {
            BaseFragment baseFragment = this$0.j.get(0);
            if (baseFragment == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackParentFragment");
            }
            ((LiveGiftBackpackParentFragment) baseFragment).c(model.pageIndex);
        }
        LiveEventBus.get("gift_backpack_item_clicked").post(model);
    }

    private final void b(ArrayList<LiveGiftFragmentModel> arrayList) {
        this.f.clear();
        ArrayList<LiveGiftFragmentModel> arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            BluedViewExKt.b(l());
            BluedViewExKt.a(n());
            m().setText("暂无碎片");
            return;
        }
        LiveGiftPackageModel liveGiftPackageModel = new LiveGiftPackageModel();
        liveGiftPackageModel.name = "";
        liveGiftPackageModel.type_name = liveGiftPackageModel.name;
        liveGiftPackageModel.packageType = 13;
        liveGiftPackageModel.showQuestion = false;
        liveGiftPackageModel.isBag = true;
        Iterator<LiveGiftFragmentModel> it = arrayList.iterator();
        while (it.hasNext()) {
            LiveGiftFragmentModel next = it.next();
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            liveGiftModel.expire_time = next.getExpire_time();
            liveGiftModel.goods_id = String.valueOf(next.getId());
            liveGiftModel.ops = 22;
            liveGiftModel.name = next.getName();
            liveGiftModel.images_static = next.getImage();
            liveGiftModel.type = String.valueOf(next.getType());
            liveGiftModel.type_icon = next.getType_icon();
            liveGiftModel.consume = next.getConsume();
            liveGiftModel.count = next.getCount();
            liveGiftPackageModel.goods.add(liveGiftModel);
        }
        if (LiveDataManager.a().f()) {
            liveGiftPackageModel.setLine(1);
            liveGiftPackageModel.setColumn(2);
        } else {
            liveGiftPackageModel.setLine(2);
            liveGiftPackageModel.setColumn(2);
        }
        this.f.add(liveGiftPackageModel);
        b(this.f);
        a(this.f);
        this.f13890a.setData(null);
    }

    private final LinearLayout l() {
        Object value = this.p.getValue();
        Intrinsics.c(value, "<get-pageNoDataLayout>(...)");
        return (LinearLayout) value;
    }

    private final TextView m() {
        Object value = this.q.getValue();
        Intrinsics.c(value, "<get-pageNoDataTv>(...)");
        return (TextView) value;
    }

    private final LinearLayout n() {
        Object value = this.r.getValue();
        Intrinsics.c(value, "<get-llPagerContentView>(...)");
        return (LinearLayout) value;
    }

    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagRootFragment
    protected BaseFragment a(CommonGiftPackageModel<?> commonGiftPackageModel, Bundle arg) {
        Intrinsics.e(arg, "arg");
        return new LiveGiftBackpackParentFragment();
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void a() {
    }

    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagRootFragment
    protected void a(int i) {
        if (i < this.b.size()) {
            Object obj = this.b.get(i);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftPackageModel");
            }
            LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) obj;
            this.t = liveGiftPackageModel;
            String str = liveGiftPackageModel == null ? null : liveGiftPackageModel.type_name;
            boolean z = true;
            if (str != null) {
                switch (str.hashCode()) {
                    case -1333284868:
                        if (str.equals("chat_badge")) {
                            EventTrackLive.a(LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                            break;
                        }
                        break;
                    case -1329087034:
                        if (str.equals("chat_frame")) {
                            EventTrackLive.a(LiveProtos.Event.LIVE_BAG_CHAT_BUBBLE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                            break;
                        }
                        break;
                    case -1306084975:
                        if (str.equals("effect")) {
                            EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_POP_DRESS_TAB_CAR_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                            break;
                        }
                        break;
                    case -1184372883:
                        if (str.equals("in_use")) {
                            LiveEventBus.get("live_gift_backpack_pager_send_status").post(false);
                            EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_POP_GIFT_TAB_USED_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                            break;
                        }
                        break;
                    case -581458169:
                        if (str.equals("avatar_frame")) {
                            EventTrackLive.a(LiveProtos.Event.LIVE_PHOTO_FRAME_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                            break;
                        }
                        break;
                    case 981007230:
                        if (str.equals("card_frame")) {
                            EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_POP_DRESS_TAB_PROFILE_CARD_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                            break;
                        }
                        break;
                    case 2129067547:
                        if (str.equals("not_use")) {
                            LiveEventBus.get("live_gift_backpack_pager_send_status").post(true);
                            EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_POP_GIFT_TAB_TO_USE_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                            break;
                        }
                        break;
                }
            }
            LiveProtos.Event event = LiveProtos.Event.LIVE_GIFT_POP_PACK_TAB_CLICK;
            String e = LiveRoomManager.a().e();
            String g = LiveRoomManager.a().g();
            LiveGiftPackageModel liveGiftPackageModel2 = this.t;
            EventTrackLive.k(event, e, g, liveGiftPackageModel2 == null ? null : liveGiftPackageModel2.type_name);
            LiveGiftPackageModel liveGiftPackageModel3 = this.t;
            if (liveGiftPackageModel3 == null || liveGiftPackageModel3.packageType != 5) {
                z = false;
            }
            if (z) {
                EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_COUPON_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagRootFragment
    public void a(CommonGiftPackageModel<?> packageModel) {
        Intrinsics.e(packageModel, "packageModel");
        super.a(packageModel);
        int size = packageModel.goods.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            Object obj = packageModel.goods.get(i2);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftModel");
            }
            ((LiveGiftModel) obj).packageTypeName = packageModel.name;
            i = i2 + 1;
        }
    }

    public final void b(List<? extends CommonGiftPackageModel<?>> tmpList) {
        Intrinsics.e(tmpList, "tmpList");
        a((List<CommonGiftPackageModel>) tmpList);
        this.b.clear();
        this.b.addAll(tmpList);
        b();
    }

    public final BaseFragment c() {
        if (this.j.size() > 0) {
            return this.j.get(0);
        }
        return null;
    }

    public final void c(int i) {
        if (this.j == null || this.j.size() <= i) {
            return;
        }
        BaseFragment baseFragment = this.j.get(i);
        if (baseFragment instanceof LiveGiftBackpackParentFragment) {
            ((LiveGiftBackpackParentFragment) baseFragment).g();
        }
    }

    public final void d() {
        List<BaseFragment> fragmentList = this.j;
        Intrinsics.c(fragmentList, "fragmentList");
        for (IndexedValue indexedValue : CollectionsKt.i((Iterable) fragmentList)) {
            if (indexedValue instanceof LiveGiftBackpackParentFragment) {
                ((LiveGiftBackpackParentFragment) indexedValue).h();
            }
        }
    }

    public final void d(int i) {
        Object obj = this.b.get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftPackageModel");
        }
        LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) obj;
        this.t = liveGiftPackageModel;
        if (liveGiftPackageModel != null && liveGiftPackageModel.red_point == 1) {
            LiveGiftPackageModel liveGiftPackageModel2 = this.t;
            if (liveGiftPackageModel2 != null && liveGiftPackageModel2.red_point_cancel == 1) {
                LiveGiftPackageModel liveGiftPackageModel3 = this.t;
                if (liveGiftPackageModel3 != null) {
                    liveGiftPackageModel3.hasNew = false;
                }
                LiveGiftPackageModel liveGiftPackageModel4 = this.t;
                if (liveGiftPackageModel4 != null) {
                    liveGiftPackageModel4.red_point = 0;
                }
                LiveGiftPackageModel liveGiftPackageModel5 = this.t;
                if (liveGiftPackageModel5 != null) {
                    liveGiftPackageModel5.red_point_cancel = 0;
                }
                LiveGiftPackageModel liveGiftPackageModel6 = this.t;
                LiveRoomHttpUtils.b((BluedUIHttpResponse) null, liveGiftPackageModel6 == null ? null : liveGiftPackageModel6.red_point_word);
                e(i);
            }
        }
        h();
    }

    public final void e(int i) {
        if (this.f13890a != null) {
            this.f13890a.a(i);
        }
    }

    public final void g() {
        if (this.h == null || this.j == null || this.j.size() <= 0) {
            return;
        }
        this.h.setCurrentItem(0);
        BaseFragment baseFragment = this.j.get(0);
        if (baseFragment instanceof LiveGiftBackpackParentFragment) {
            ((LiveGiftBackpackParentFragment) baseFragment).c(0);
        }
    }

    public final void h() {
        boolean z;
        boolean z2;
        String str = this.g != null ? "gift" : this.m != null ? "props" : this.n != null ? "equips" : "";
        if (Intrinsics.a(str, (Object) "props")) {
            Iterator<CommonGiftPackageModel<?>> it = this.f.iterator();
            boolean z3 = false;
            while (true) {
                z2 = z3;
                if (!it.hasNext()) {
                    break;
                }
                CommonGiftPackageModel<?> next = it.next();
                LogUtils.d("bLog", Intrinsics.a("props-liveGiftPackageModel.hasNew = ----- ", (Object) Boolean.valueOf(next.hasNew)));
                if (next.hasNew) {
                    z2 = false;
                    break;
                }
                z3 = true;
            }
            if (z2) {
                LiveEventBus.get("live_gift_bag_page_switch", String.class).post(str);
            }
        } else if (Intrinsics.a(str, (Object) "equips")) {
            Iterator<CommonGiftPackageModel<?>> it2 = this.f.iterator();
            boolean z4 = false;
            while (true) {
                z = z4;
                if (!it2.hasNext()) {
                    break;
                } else if (it2.next().hasNew) {
                    z = false;
                    break;
                } else {
                    z4 = true;
                }
            }
            if (z) {
                LiveEventBus.get("live_gift_bag_page_switch", String.class).post(str);
            }
        }
    }

    public final void i() {
        ArrayList<LiveGiftModel> arrayList = this.g;
        if (arrayList != null) {
            a(arrayList);
        }
        LiveGiftBackpackProps liveGiftBackpackProps = this.m;
        if (liveGiftBackpackProps != null) {
            a(liveGiftBackpackProps);
        }
        LiveGiftBackpackEquips liveGiftBackpackEquips = this.n;
        if (liveGiftBackpackEquips != null) {
            a(liveGiftBackpackEquips);
        }
        ArrayList<LiveGiftFragmentModel> arrayList2 = this.l;
        if (arrayList2 != null) {
            b(arrayList2);
        }
        CommonGiftTabView commonGiftTabView = this.f13890a;
        if (commonGiftTabView == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.mine.backpack.LiveGiftBagItemTabView");
        }
        ((LiveGiftBagItemTabView) commonGiftTabView).setOnTabViewItemClick(new LiveGiftBagItemTabView.OnTabViewItemClick() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackItemFragment$initData$1
            @Override // com.blued.android.module.live_china.mine.backpack.LiveGiftBagItemTabView.OnTabViewItemClick
            public void a(int i) {
                LiveGiftBackpackItemFragment.this.h.setCurrentItem(i);
                LiveGiftBackpackItemFragment.this.d(i);
            }
        });
    }

    public final void j() {
        ArrayList<LiveGiftModel> arrayList = this.g;
        Intrinsics.a(arrayList);
        Iterator<LiveGiftModel> it = arrayList.iterator();
        while (it.hasNext()) {
            final LiveGiftModel next = it.next();
            if (StringUtils.a(next.goods_id, this.o)) {
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackItemFragment$fyHTJTEWSaJtdmEB39I0NHTnt8o
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveGiftBackpackItemFragment.b(LiveGiftBackpackItemFragment.this, next);
                    }
                }, 100L);
            }
        }
    }

    public final void k() {
        if (this.n != null) {
            this.h.setCurrentItem(3);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LiveEventBus.get("live_use_prop_success", LiveGiftModel.class).removeObserver(this.s);
    }

    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagRootFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitListener() {
        super.onInitListener();
        this.h.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackItemFragment$onInitListener$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                LiveGiftBackpackItemFragment.this.c(i);
                LiveGiftBackpackItemFragment.this.d(i);
            }
        });
        LiveEventBus.get("live_use_prop_success", LiveGiftModel.class).observeForever(this.s);
    }

    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagRootFragment, com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("gifts");
            this.o = String.valueOf(arguments.getString("goods_id"));
            Serializable serializable2 = arguments.getSerializable("props");
            Serializable serializable3 = arguments.getSerializable("equips");
            Serializable serializable4 = arguments.getSerializable("fragment");
            if (serializable != null) {
                this.g = ((LiveGiftBackpackModel) serializable).getGifts();
            }
            if (serializable2 != null) {
                this.m = (LiveGiftBackpackProps) serializable2;
            }
            if (serializable3 != null) {
                this.n = (LiveGiftBackpackEquips) serializable3;
            }
            if (serializable4 != null) {
                this.l = ((LiveGiftBackpackModel) serializable4).getFragment();
            }
        }
        i();
    }

    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagRootFragment, com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return LiveDataManager.a().f() ? R.layout.fragment_live_gift_backpack_item_layout_land : R.layout.fragment_live_gift_backpack_item_layout;
    }
}
