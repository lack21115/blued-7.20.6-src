package com.blued.android.module.live_china.utils;

import android.graphics.Color;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.VipCurrentHttpDataModel;
import com.blued.android.module.live_china.model.VipDataModel;
import com.blued.android.module.live_china.model.VipHttpDataModel;
import com.blued.android.module.live_china.model.VipLevelHttpDataModel;
import com.blued.android.module.live_china.model.VipModel;
import com.blued.android.module.live_china.model.VipPrivilegeModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/VipDataUtil.class */
public final class VipDataUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f14199a = new Companion(null);
    private static final ArrayList<VipModel> b = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/VipDataUtil$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final VipLevelHttpDataModel a(int i, ArrayList<VipLevelHttpDataModel> arrayList) {
        for (VipLevelHttpDataModel vipLevelHttpDataModel : arrayList) {
            if (vipLevelHttpDataModel.getLevel() == i) {
                return vipLevelHttpDataModel;
            }
        }
        return null;
    }

    private final ArrayList<VipPrivilegeModel> a(int i) {
        ArrayList<VipPrivilegeModel> arrayList = new ArrayList<>();
        if (i == 0) {
            VipPrivilegeModel vipPrivilegeModel = new VipPrivilegeModel();
            vipPrivilegeModel.setId(1);
            vipPrivilegeModel.setName("个性身份标识");
            vipPrivilegeModel.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_rank.1h0kph93h9fu0j.webp");
            vipPrivilegeModel.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_rank_highlight.1h0kpgqbj17dn37.webp");
            vipPrivilegeModel.setInfo_decs("VIP身份生效期内，将拥有专属铭牌、专属勋章的身份标识");
            vipPrivilegeModel.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_rank_level_2.1h39feuus2nlrh1.png");
            arrayList.add(vipPrivilegeModel);
            VipPrivilegeModel vipPrivilegeModel2 = new VipPrivilegeModel();
            vipPrivilegeModel2.setId(2);
            vipPrivilegeModel2.setName("炫酷入场特权");
            vipPrivilegeModel2.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_join.1h0kpfcuv127md4.webp");
            vipPrivilegeModel2.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_join_highlight.1h0kpersc2lt4v7.webp");
            vipPrivilegeModel2.setInfo_decs("VIP身份生效期内，将拥有专属入场通知和座驾");
            vipPrivilegeModel2.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_join_level_2.1h39faqr029j446.png");
            arrayList.add(vipPrivilegeModel2);
            VipPrivilegeModel vipPrivilegeModel3 = new VipPrivilegeModel();
            vipPrivilegeModel3.setId(3);
            vipPrivilegeModel3.setName("专属特权礼物");
            vipPrivilegeModel3.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_gift.1h0kpebog9t0j4.webp");
            vipPrivilegeModel3.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_gift_highlight.1h0kpdn1i2c7rt4.webp");
            vipPrivilegeModel3.setInfo_decs("VIP身份生效期内，礼物面板将装备普通用户没有的一款专属特权礼物，彰显独特身份");
            vipPrivilegeModel3.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_gift_level_2.1h39f73ke11nthu.png");
            arrayList.add(vipPrivilegeModel3);
            VipPrivilegeModel vipPrivilegeModel4 = new VipPrivilegeModel();
            vipPrivilegeModel4.setId(4);
            vipPrivilegeModel4.setName("尊享商城体验");
            vipPrivilegeModel4.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_store.1h0kpj3vh2tefhu.webp");
            vipPrivilegeModel4.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_store_highlight.webp.1h0kpilvhoft76.webp");
            vipPrivilegeModel4.setInfo_decs("VIP身份生效期内，将解锁尊享商城使用权，拥有此特权的VIP可通过尊享积分兑换商城内的丰厚奖品（特权、礼物、道具等）");
            vipPrivilegeModel4.setInfo_btn("尊享商城");
            vipPrivilegeModel4.setInfo_btn_type(2);
            vipPrivilegeModel4.setInfo_btn_url_online("https://app.blued.cn/home/point-store?is_vip=true");
            vipPrivilegeModel4.setInfo_btn_url_test("https://app-testenv.blued.cn/home/point-store?is_vip=true");
            vipPrivilegeModel4.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_store.1h39f4r3c1gq1vq.png");
            arrayList.add(vipPrivilegeModel4);
            VipPrivilegeModel vipPrivilegeModel5 = new VipPrivilegeModel();
            vipPrivilegeModel5.setId(5);
            vipPrivilegeModel5.setName("VIP贵宾通道");
            vipPrivilegeModel5.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_channel.1h0kp9a7pafq8d.webp");
            vipPrivilegeModel5.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_channel_highlight.1h1451oiqj3m71.webp");
            vipPrivilegeModel5.setInfo_decs("VIP身份生效期内，可通过直播间内弹窗提示获取VIP专属运营经理微信（或通过下方按钮联系「Blued小D」获取专属运营经理微信），添加后可享受一站式专属VIP服务。");
            vipPrivilegeModel5.setInfo_btn("联系Blued小D");
            vipPrivilegeModel5.setInfo_btn_type(3);
            vipPrivilegeModel5.setInfo_btn_uid(256L);
            vipPrivilegeModel5.setInfo_btn_nickname("Blued小D");
            vipPrivilegeModel5.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_channel.1h39f0lil65r9m.png");
            arrayList.add(vipPrivilegeModel5);
            return arrayList;
        } else if (i == 1) {
            VipPrivilegeModel vipPrivilegeModel6 = new VipPrivilegeModel();
            vipPrivilegeModel6.setId(1);
            vipPrivilegeModel6.setName("个性身份标识");
            vipPrivilegeModel6.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_rank.1h0kph93h9fu0j.webp");
            vipPrivilegeModel6.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_rank_highlight.1h0kpgqbj17dn37.webp");
            vipPrivilegeModel6.setInfo_decs("VIP身份生效期内，将拥有专属铭牌、专属勋章的身份标识");
            vipPrivilegeModel6.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_rank_level_2.1h39feuus2nlrh1.png");
            arrayList.add(vipPrivilegeModel6);
            VipPrivilegeModel vipPrivilegeModel7 = new VipPrivilegeModel();
            vipPrivilegeModel7.setId(2);
            vipPrivilegeModel7.setName("炫酷入场特权");
            vipPrivilegeModel7.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_join.1h0kpfcuv127md4.webp");
            vipPrivilegeModel7.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_join_highlight.1h0kpersc2lt4v7.webp");
            vipPrivilegeModel7.setInfo_decs("VIP身份生效期内，将拥有专属入场通知和座驾");
            vipPrivilegeModel7.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_join_level_2.1h39faqr029j446.png");
            arrayList.add(vipPrivilegeModel7);
            VipPrivilegeModel vipPrivilegeModel8 = new VipPrivilegeModel();
            vipPrivilegeModel8.setId(3);
            vipPrivilegeModel8.setName("专属特权礼物");
            vipPrivilegeModel8.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_gift.1h0kpebog9t0j4.webp");
            vipPrivilegeModel8.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_gift_highlight.1h0kpdn1i2c7rt4.webp");
            vipPrivilegeModel8.setInfo_decs("VIP身份生效期内，礼物面板将装备普通用户没有的一款专属特权礼物，彰显独特身份");
            vipPrivilegeModel8.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_gift_level_2.1h39f73ke11nthu.png");
            arrayList.add(vipPrivilegeModel8);
            VipPrivilegeModel vipPrivilegeModel9 = new VipPrivilegeModel();
            vipPrivilegeModel9.setId(4);
            vipPrivilegeModel9.setName("尊享商城体验");
            vipPrivilegeModel9.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_store.1h0kpj3vh2tefhu.webp");
            vipPrivilegeModel9.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_store_highlight.webp.1h0kpilvhoft76.webp");
            vipPrivilegeModel9.setInfo_decs("VIP身份生效期内，将解锁尊享商城使用权，拥有此特权的VIP可通过尊享积分兑换商城内的丰厚奖品（特权、礼物、道具等）");
            vipPrivilegeModel9.setInfo_btn("尊享商城");
            vipPrivilegeModel9.setInfo_btn_type(2);
            vipPrivilegeModel9.setInfo_btn_url_online("\u200bhttps://app.blued.cn/home/point-store?is_vip=true");
            vipPrivilegeModel9.setInfo_btn_url_test("https://app-testenv.blued.cn/home/point-store?is_vip=true");
            vipPrivilegeModel9.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_store.1h39f4r3c1gq1vq.png");
            arrayList.add(vipPrivilegeModel9);
            VipPrivilegeModel vipPrivilegeModel10 = new VipPrivilegeModel();
            vipPrivilegeModel10.setId(5);
            vipPrivilegeModel10.setName("VIP贵宾通道");
            vipPrivilegeModel10.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_channel.1h0kp9a7pafq8d.webp");
            vipPrivilegeModel10.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_channel_highlight.1h1451oiqj3m71.webp");
            vipPrivilegeModel10.setInfo_decs("VIP身份生效期内，可通过直播间内弹窗提示获取VIP专属运营经理微信（或通过下方按钮联系「Blued小D」获取专属运营经理微信），添加后可享受一站式专属VIP服务。");
            vipPrivilegeModel10.setInfo_btn("联系Blued小D");
            vipPrivilegeModel10.setInfo_btn_type(3);
            vipPrivilegeModel10.setInfo_btn_uid(256L);
            vipPrivilegeModel10.setInfo_btn_nickname("Blued小D");
            vipPrivilegeModel10.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_channel.1h39f0lil65r9m.png");
            arrayList.add(vipPrivilegeModel10);
            return arrayList;
        } else if (i == 2) {
            VipPrivilegeModel vipPrivilegeModel11 = new VipPrivilegeModel();
            vipPrivilegeModel11.setId(1);
            vipPrivilegeModel11.setName("个性身份标识");
            vipPrivilegeModel11.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_rank.1h0kph93h9fu0j.webp");
            vipPrivilegeModel11.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_rank_highlight.1h0kpgqbj17dn37.webp");
            vipPrivilegeModel11.setInfo_decs("VIP身份生效期内，将拥有专属铭牌、专属勋章的身份标识");
            vipPrivilegeModel11.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_rank_level_3.1h39ffajn2gn04e.png");
            arrayList.add(vipPrivilegeModel11);
            VipPrivilegeModel vipPrivilegeModel12 = new VipPrivilegeModel();
            vipPrivilegeModel12.setId(2);
            vipPrivilegeModel12.setName("炫酷入场特权");
            vipPrivilegeModel12.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_join.1h0kpfcuv127md4.webp");
            vipPrivilegeModel12.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_join_highlight.1h0kpersc2lt4v7.webp");
            vipPrivilegeModel12.setInfo_decs("VIP身份生效期内，将拥有专属入场通知和座驾");
            vipPrivilegeModel12.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_join_level_3.1h39fb8771gbp3u.png");
            arrayList.add(vipPrivilegeModel12);
            VipPrivilegeModel vipPrivilegeModel13 = new VipPrivilegeModel();
            vipPrivilegeModel13.setId(3);
            vipPrivilegeModel13.setName("专属特权礼物");
            vipPrivilegeModel13.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_gift.1h0kpebog9t0j4.webp");
            vipPrivilegeModel13.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_gift_highlight.1h0kpdn1i2c7rt4.webp");
            vipPrivilegeModel13.setInfo_decs("VIP身份生效期内，礼物面板将装备普通用户没有的两款专属特权礼物，彰显独特身份");
            vipPrivilegeModel13.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_gift_level_3.1h39f7dv824uat2.png");
            arrayList.add(vipPrivilegeModel13);
            VipPrivilegeModel vipPrivilegeModel14 = new VipPrivilegeModel();
            vipPrivilegeModel14.setId(4);
            vipPrivilegeModel14.setName("尊享商城体验");
            vipPrivilegeModel14.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_store.1h0kpj3vh2tefhu.webp");
            vipPrivilegeModel14.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_store_highlight.webp.1h0kpilvhoft76.webp");
            vipPrivilegeModel14.setInfo_decs("VIP身份生效期内，将解锁尊享商城使用权，拥有此特权的VIP可通过尊享积分兑换商城内的丰厚奖品（特权、礼物、道具等）");
            vipPrivilegeModel14.setInfo_btn("尊享商城");
            vipPrivilegeModel14.setInfo_btn_type(2);
            vipPrivilegeModel14.setInfo_btn_url_online("https://app.blued.cn/home/point-store?is_vip=true");
            vipPrivilegeModel14.setInfo_btn_url_test("https://app-testenv.blued.cn/home/point-store?is_vip=true");
            vipPrivilegeModel14.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_store.1h39f4r3c1gq1vq.png");
            arrayList.add(vipPrivilegeModel14);
            VipPrivilegeModel vipPrivilegeModel15 = new VipPrivilegeModel();
            vipPrivilegeModel15.setId(5);
            vipPrivilegeModel15.setName("VIP贵宾通道");
            vipPrivilegeModel15.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_channel.1h0kp9a7pafq8d.webp");
            vipPrivilegeModel15.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_channel_highlight.1h1451oiqj3m71.webp");
            vipPrivilegeModel15.setInfo_decs("VIP身份生效期内，可通过直播间内弹窗提示获取VIP专属运营经理微信（或通过下方按钮联系「Blued小D」获取专属运营经理微信），添加后可享受一站式专属VIP服务。");
            vipPrivilegeModel15.setInfo_btn("联系Blued小D");
            vipPrivilegeModel15.setInfo_btn_type(3);
            vipPrivilegeModel15.setInfo_btn_uid(256L);
            vipPrivilegeModel15.setInfo_btn_nickname("Blued小D");
            vipPrivilegeModel15.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_channel.1h39f0lil65r9m.png");
            arrayList.add(vipPrivilegeModel15);
            VipPrivilegeModel vipPrivilegeModel16 = new VipPrivilegeModel();
            vipPrivilegeModel16.setId(6);
            vipPrivilegeModel16.setName("珍稀特权兑换");
            vipPrivilegeModel16.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_convert.1h0kpc8qv1gtbjg.webp");
            vipPrivilegeModel16.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_convert_highlight.1h0kpbnd61tcv1r.webp");
            vipPrivilegeModel16.setInfo_decs("VIP身份生效期内，拥有此特权的VIP，可兑换珍稀特权和不定时开放的神秘豪礼");
            vipPrivilegeModel16.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_convert.1h39f1ssu1hegdq.png");
            arrayList.add(vipPrivilegeModel16);
            VipPrivilegeModel vipPrivilegeModel17 = new VipPrivilegeModel();
            vipPrivilegeModel17.setId(7);
            vipPrivilegeModel17.setName("生日专属礼包");
            vipPrivilegeModel17.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_birthday.1h0kp8a8jticg0.webp");
            vipPrivilegeModel17.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_birthday_highlight.1h0kp7mva1g8drs.webp");
            vipPrivilegeModel17.setInfo_decs("VIP身份生效期内，官方会在生日当天准备一份生日专属礼包相赠");
            vipPrivilegeModel17.setInfo_btn("请填写生日信息");
            vipPrivilegeModel17.setInfo_btn_type(1);
            vipPrivilegeModel17.setInfo_btn_url_online("https://app.blued.cn/home/birthday-gift-bag");
            vipPrivilegeModel17.setInfo_btn_url_test("https://app-testenv.blued.cn/home/birthday-gift-bag");
            vipPrivilegeModel17.setLive_suffix("?isLive=true");
            vipPrivilegeModel17.setInfo_img_url("https://web.bldimg.com/image-manager/1689055664_88302.png");
            arrayList.add(vipPrivilegeModel17);
            return arrayList;
        } else if (i == 3) {
            VipPrivilegeModel vipPrivilegeModel18 = new VipPrivilegeModel();
            vipPrivilegeModel18.setId(1);
            vipPrivilegeModel18.setName("个性身份标识");
            vipPrivilegeModel18.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_rank.1h0kph93h9fu0j.webp");
            vipPrivilegeModel18.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_rank_highlight.1h0kpgqbj17dn37.webp");
            vipPrivilegeModel18.setInfo_decs("VIP身份生效期内，将拥有专属铭牌、专属勋章的身份标识");
            vipPrivilegeModel18.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_rank_level_4.1h39fflpq1oabge.png");
            arrayList.add(vipPrivilegeModel18);
            VipPrivilegeModel vipPrivilegeModel19 = new VipPrivilegeModel();
            vipPrivilegeModel19.setId(2);
            vipPrivilegeModel19.setName("炫酷入场特权");
            vipPrivilegeModel19.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_join.1h0kpfcuv127md4.webp");
            vipPrivilegeModel19.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_join_highlight.1h0kpersc2lt4v7.webp");
            vipPrivilegeModel19.setInfo_decs("VIP身份生效期内，将拥有专属入场通知和座驾");
            vipPrivilegeModel19.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_join_level_4.1h39fbn0klks3r.png");
            arrayList.add(vipPrivilegeModel19);
            VipPrivilegeModel vipPrivilegeModel20 = new VipPrivilegeModel();
            vipPrivilegeModel20.setId(3);
            vipPrivilegeModel20.setName("专属特权礼物");
            vipPrivilegeModel20.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_gift.1h0kpebog9t0j4.webp");
            vipPrivilegeModel20.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_gift_highlight.1h0kpdn1i2c7rt4.webp");
            vipPrivilegeModel20.setInfo_decs("VIP身份生效期内，礼物面板将装备普通用户没有的三款专属特权礼物，彰显独特身份");
            vipPrivilegeModel20.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_gift_level_4.1h39f7m9q2bsf6b.png");
            arrayList.add(vipPrivilegeModel20);
            VipPrivilegeModel vipPrivilegeModel21 = new VipPrivilegeModel();
            vipPrivilegeModel21.setId(4);
            vipPrivilegeModel21.setName("尊享商城体验");
            vipPrivilegeModel21.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_store.1h0kpj3vh2tefhu.webp");
            vipPrivilegeModel21.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_store_highlight.webp.1h0kpilvhoft76.webp");
            vipPrivilegeModel21.setInfo_decs("VIP身份生效期内，将解锁尊享商城使用权，拥有此特权的VIP可通过尊享积分兑换商城内的丰厚奖品（特权、礼物、道具等）");
            vipPrivilegeModel21.setInfo_btn("尊享商城");
            vipPrivilegeModel21.setInfo_btn_type(2);
            vipPrivilegeModel21.setInfo_btn_url_online("https://app.blued.cn/home/point-store?is_vip=true");
            vipPrivilegeModel21.setInfo_btn_url_test("https://app-testenv.blued.cn/home/point-store?is_vip=true");
            vipPrivilegeModel21.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_store.1h39f4r3c1gq1vq.png");
            arrayList.add(vipPrivilegeModel21);
            VipPrivilegeModel vipPrivilegeModel22 = new VipPrivilegeModel();
            vipPrivilegeModel22.setId(5);
            vipPrivilegeModel22.setName("VIP贵宾通道");
            vipPrivilegeModel22.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_channel.1h0kp9a7pafq8d.webp");
            vipPrivilegeModel22.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_channel_highlight.1h1451oiqj3m71.webp");
            vipPrivilegeModel22.setInfo_decs("VIP身份生效期内，可通过直播间内弹窗提示获取VIP专属运营经理微信（或通过下方按钮联系「Blued小D」获取专属运营经理微信），添加后可享受一站式专属VIP服务。");
            vipPrivilegeModel22.setInfo_btn("联系Blued小D");
            vipPrivilegeModel22.setInfo_btn_type(3);
            vipPrivilegeModel22.setInfo_btn_uid(256L);
            vipPrivilegeModel22.setInfo_btn_nickname("Blued小D");
            vipPrivilegeModel22.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_channel.1h39f0lil65r9m.png");
            arrayList.add(vipPrivilegeModel22);
            VipPrivilegeModel vipPrivilegeModel23 = new VipPrivilegeModel();
            vipPrivilegeModel23.setId(6);
            vipPrivilegeModel23.setName("珍稀特权兑换");
            vipPrivilegeModel23.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_convert.1h0kpc8qv1gtbjg.webp");
            vipPrivilegeModel23.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_convert_highlight.1h0kpbnd61tcv1r.webp");
            vipPrivilegeModel23.setInfo_decs("VIP身份生效期内，拥有此特权的VIP，可兑换珍稀特权和不定时开放的神秘豪礼");
            vipPrivilegeModel23.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_convert.1h39f1ssu1hegdq.png");
            arrayList.add(vipPrivilegeModel23);
            VipPrivilegeModel vipPrivilegeModel24 = new VipPrivilegeModel();
            vipPrivilegeModel24.setId(7);
            vipPrivilegeModel24.setName("生日专属礼包");
            vipPrivilegeModel24.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_birthday.1h0kp8a8jticg0.webp");
            vipPrivilegeModel24.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_birthday_highlight.1h0kp7mva1g8drs.webp");
            vipPrivilegeModel24.setInfo_decs("VIP身份生效期内，官方会在生日当天准备一份生日专属礼包相赠");
            vipPrivilegeModel24.setInfo_btn("请填写生日信息");
            vipPrivilegeModel24.setInfo_btn_type(1);
            vipPrivilegeModel24.setInfo_btn_url_online("https://app.blued.cn/home/birthday-gift-bag");
            vipPrivilegeModel24.setInfo_btn_url_test("https://app-testenv.blued.cn/home/birthday-gift-bag");
            vipPrivilegeModel24.setLive_suffix("?isLive=true");
            vipPrivilegeModel24.setInfo_img_url("https://web.bldimg.com/image-manager/1689055664_74673.png");
            arrayList.add(vipPrivilegeModel24);
            VipPrivilegeModel vipPrivilegeModel25 = new VipPrivilegeModel();
            vipPrivilegeModel25.setId(8);
            vipPrivilegeModel25.setName("大额充值特权");
            vipPrivilegeModel25.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_recharge.1h0kpi87ac98s4.webp");
            vipPrivilegeModel25.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_recharge_highlight.1h0kphnjk2mulgc.webp");
            vipPrivilegeModel25.setInfo_decs("VIP身份生效期内，将享有首次单笔大额充值折扣福利特权，了解具体门槛及折扣比例详情可联系VIP专属运营经理");
            vipPrivilegeModel25.setInfo_btn("联系Blued小D");
            vipPrivilegeModel25.setInfo_btn_type(3);
            vipPrivilegeModel25.setInfo_btn_uid(256L);
            vipPrivilegeModel25.setInfo_btn_nickname("Blued小D");
            vipPrivilegeModel25.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_recharge.1h3dtk3se1mrun6.png");
            arrayList.add(vipPrivilegeModel25);
            return arrayList;
        } else if (i != 4) {
            return arrayList;
        } else {
            VipPrivilegeModel vipPrivilegeModel26 = new VipPrivilegeModel();
            vipPrivilegeModel26.setId(1);
            vipPrivilegeModel26.setName("个性身份标识");
            vipPrivilegeModel26.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_rank.1h0kph93h9fu0j.webp");
            vipPrivilegeModel26.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_rank_highlight.1h0kpgqbj17dn37.webp");
            vipPrivilegeModel26.setInfo_decs("VIP身份生效期内，将拥有专属铭牌、专属勋章的身份标识");
            vipPrivilegeModel26.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_rank_level_5.1h39fg4d92m69av.png");
            arrayList.add(vipPrivilegeModel26);
            VipPrivilegeModel vipPrivilegeModel27 = new VipPrivilegeModel();
            vipPrivilegeModel27.setId(2);
            vipPrivilegeModel27.setName("炫酷入场特权");
            vipPrivilegeModel27.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_join.1h0kpfcuv127md4.webp");
            vipPrivilegeModel27.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_join_highlight.1h0kpersc2lt4v7.webp");
            vipPrivilegeModel27.setInfo_decs("VIP身份生效期内，将拥有专属入场通知和座驾");
            vipPrivilegeModel27.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_join_level_5.1h39fc66g2obtup.png");
            arrayList.add(vipPrivilegeModel27);
            VipPrivilegeModel vipPrivilegeModel28 = new VipPrivilegeModel();
            vipPrivilegeModel28.setId(3);
            vipPrivilegeModel28.setName("专属特权礼物");
            vipPrivilegeModel28.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_gift.1h0kpebog9t0j4.webp");
            vipPrivilegeModel28.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_gift_highlight.1h0kpdn1i2c7rt4.webp");
            vipPrivilegeModel28.setInfo_decs("VIP身份生效期内，礼物面板将装备普通用户没有的四款专属特权礼物，彰显独特身份");
            vipPrivilegeModel28.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_gift_level_5.1h39f7vd753vl.png");
            arrayList.add(vipPrivilegeModel28);
            VipPrivilegeModel vipPrivilegeModel29 = new VipPrivilegeModel();
            vipPrivilegeModel29.setId(4);
            vipPrivilegeModel29.setName("尊享商城体验");
            vipPrivilegeModel29.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_store.1h0kpj3vh2tefhu.webp");
            vipPrivilegeModel29.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_store_highlight.webp.1h0kpilvhoft76.webp");
            vipPrivilegeModel29.setInfo_decs("VIP身份生效期内，将解锁尊享商城使用权，拥有此特权的VIP可通过尊享积分兑换商城内的丰厚奖品（特权、礼物、道具等）");
            vipPrivilegeModel29.setInfo_btn("尊享商城");
            vipPrivilegeModel29.setInfo_btn_type(2);
            vipPrivilegeModel29.setInfo_btn_url_online("https://app.blued.cn/home/point-store?is_vip=true");
            vipPrivilegeModel29.setInfo_btn_url_test("https://app-testenv.blued.cn/home/point-store?is_vip=true");
            vipPrivilegeModel29.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_store.1h39f4r3c1gq1vq.png");
            arrayList.add(vipPrivilegeModel29);
            VipPrivilegeModel vipPrivilegeModel30 = new VipPrivilegeModel();
            vipPrivilegeModel30.setId(5);
            vipPrivilegeModel30.setName("VIP贵宾通道");
            vipPrivilegeModel30.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_channel.1h0kp9a7pafq8d.webp");
            vipPrivilegeModel30.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_channel_highlight.1h1451oiqj3m71.webp");
            vipPrivilegeModel30.setInfo_decs("VIP身份生效期内，可通过直播间内弹窗提示获取VIP专属运营经理微信（或通过下方按钮联系「Blued小D」获取专属运营经理微信），添加后可享受一站式专属VIP服务。");
            vipPrivilegeModel30.setInfo_btn("联系Blued小D");
            vipPrivilegeModel30.setInfo_btn_type(3);
            vipPrivilegeModel30.setInfo_btn_uid(256L);
            vipPrivilegeModel30.setInfo_btn_nickname("Blued小D");
            vipPrivilegeModel30.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_channel.1h39f0lil65r9m.png");
            arrayList.add(vipPrivilegeModel30);
            VipPrivilegeModel vipPrivilegeModel31 = new VipPrivilegeModel();
            vipPrivilegeModel31.setId(6);
            vipPrivilegeModel31.setName("珍稀特权兑换");
            vipPrivilegeModel31.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_convert.1h0kpc8qv1gtbjg.webp");
            vipPrivilegeModel31.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_convert_highlight.1h0kpbnd61tcv1r.webp");
            vipPrivilegeModel31.setInfo_decs("VIP身份生效期内，拥有此特权的VIP，可兑换珍稀特权和不定时开放的神秘豪礼");
            vipPrivilegeModel31.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_convert.1h39f1ssu1hegdq.png");
            arrayList.add(vipPrivilegeModel31);
            VipPrivilegeModel vipPrivilegeModel32 = new VipPrivilegeModel();
            vipPrivilegeModel32.setId(7);
            vipPrivilegeModel32.setName("生日专属礼包");
            vipPrivilegeModel32.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_birthday.1h0kp8a8jticg0.webp");
            vipPrivilegeModel32.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_birthday_highlight.1h0kp7mva1g8drs.webp");
            vipPrivilegeModel32.setInfo_decs("VIP身份生效期内，官方会在生日当天准备一份生日专属礼包相赠");
            vipPrivilegeModel32.setInfo_btn("请填写生日信息");
            vipPrivilegeModel32.setInfo_btn_type(1);
            vipPrivilegeModel32.setInfo_btn_url_online("https://app.blued.cn/home/birthday-gift-bag");
            vipPrivilegeModel32.setInfo_btn_url_test("https://app-testenv.blued.cn/home/birthday-gift-bag");
            vipPrivilegeModel32.setLive_suffix("?isLive=true");
            vipPrivilegeModel32.setInfo_img_url("https://web.bldimg.com/image-manager/1689055664_84345.png");
            arrayList.add(vipPrivilegeModel32);
            VipPrivilegeModel vipPrivilegeModel33 = new VipPrivilegeModel();
            vipPrivilegeModel33.setId(8);
            vipPrivilegeModel33.setName("大额充值特权");
            vipPrivilegeModel33.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_recharge.1h0kpi87ac98s4.webp");
            vipPrivilegeModel33.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_recharge_highlight.1h0kphnjk2mulgc.webp");
            vipPrivilegeModel33.setInfo_decs("VIP身份生效期内，将享有首次单笔大额充值折扣福利特权，了解具体门槛及折扣比例详情可联系VIP专属运营经理");
            vipPrivilegeModel33.setInfo_btn("联系Blued小D");
            vipPrivilegeModel33.setInfo_btn_type(3);
            vipPrivilegeModel33.setInfo_btn_uid(256L);
            vipPrivilegeModel33.setInfo_btn_nickname("Blued小D");
            vipPrivilegeModel33.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_recharge.1h3dtk3se1mrun6.png");
            arrayList.add(vipPrivilegeModel33);
            VipPrivilegeModel vipPrivilegeModel34 = new VipPrivilegeModel();
            vipPrivilegeModel34.setId(9);
            vipPrivilegeModel34.setName("VIP定制服务");
            vipPrivilegeModel34.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_customize.1h0kpd7u92ckko6.webp");
            vipPrivilegeModel34.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_customize_highlight.1h0kpcojodsm77.webp");
            vipPrivilegeModel34.setInfo_decs("VIP身份生效期内，将享有官方不定期私人定制化服务/节日赠礼，活动优先参与/通知特权");
            vipPrivilegeModel34.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_customize.1h3dtj3air0q6f.png");
            arrayList.add(vipPrivilegeModel34);
            VipPrivilegeModel vipPrivilegeModel35 = new VipPrivilegeModel();
            vipPrivilegeModel35.setId(10);
            vipPrivilegeModel35.setName("VIP超管权限");
            vipPrivilegeModel35.setIcon("https://web.bldimg.com/cblued/static/live_vip_power_manage.1h0kpgb4i1g56aa.webp");
            vipPrivilegeModel35.setIcon_select("https://web.bldimg.com/cblued/static/live_vip_power_manage_highlight.1h0kpfschgida4.webp");
            vipPrivilegeModel35.setInfo_decs("VIP身份生效期内，拥有此特权的黑金VIP，在直播间内将享有防禁言、防踢、禁言、踢人的VIP超管权限");
            vipPrivilegeModel35.setInfo_img_url("https://web.bldimg.com/cblued/static/live_vip_power_info_manage.1h3dtjiughdhsa.png");
            arrayList.add(vipPrivilegeModel35);
            return arrayList;
        }
    }

    private final ArrayList<VipModel> a(ArrayList<VipLevelHttpDataModel> arrayList) {
        ArrayList<VipModel> arrayList2 = b;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            VipModel vipModel = new VipModel();
            vipModel.setLevel(0);
            VipLevelHttpDataModel a2 = a(vipModel.getLevel(), arrayList);
            if (a2 != null) {
                vipModel.setName(a2.getName());
                vipModel.setScore(a2.getScore());
            }
            vipModel.setLast_level_name("");
            vipModel.setTag_color(Color.parseColor("#A5B1C8"));
            vipModel.setTag_text_color(Color.parseColor("#121C2C"));
            vipModel.setDesc_color(Color.parseColor("#80121C2C"));
            vipModel.setDesc_light_color("#121C2C");
            vipModel.setBg_url("https://web.bldimg.com/cblued/static/live_vip_level_1_bg.1h0ko8h6b1ecpbk.webp");
            vipModel.setCard_bg_url("https://web.bldimg.com/cblued/static/live_vip_level_1_card_bg_02.1h2sjrr4d1il0jk.webp");
            vipModel.setLevel_title_url("https://web.bldimg.com/cblued/static/live_vip_level_1_card_title.1h0kobb7320h5ns.webp");
            vipModel.setOrnament_url("");
            vipModel.setPrivileges(a(vipModel.getLevel()));
            b.add(vipModel);
            VipModel vipModel2 = new VipModel();
            vipModel2.setLevel(1);
            VipLevelHttpDataModel a3 = a(vipModel2.getLevel(), arrayList);
            if (a3 != null) {
                vipModel2.setName(a3.getName());
                vipModel2.setScore(a3.getScore());
            }
            ArrayList<VipModel> arrayList3 = b;
            vipModel2.setLast_level_name(arrayList3.get(arrayList3.size() - 1).getName());
            ArrayList<VipModel> arrayList4 = b;
            arrayList4.get(arrayList4.size() - 1).setNext_level_name(vipModel2.getName());
            ArrayList<VipModel> arrayList5 = b;
            arrayList5.get(arrayList5.size() - 1).setNext_level_score(vipModel2.getScore());
            vipModel2.setTag_color(Color.parseColor("#F5CE87"));
            vipModel2.setTag_text_color(Color.parseColor("#8D5100"));
            vipModel2.setDesc_color(Color.parseColor("#808D5100"));
            vipModel2.setDesc_light_color("#8D5100");
            vipModel2.setBg_url("https://web.bldimg.com/cblued/static/live_vip_level_2_bg.1h0koc8l02sp5oe.webp");
            vipModel2.setCard_bg_url("https://web.bldimg.com/cblued/static/live_vip_level_2_card_bg_02.1h2sjrrmi2lai5k.webp");
            vipModel2.setLevel_title_url("https://web.bldimg.com/cblued/static/live_vip_level_2_card_title.1h0koeejio0bha.webp");
            vipModel2.setOrnament_url("https://web.bldimg.com/cblued/static/live_vip_level_2_card_medal.1h2mni0ge1olp1q.png");
            vipModel2.setPrivileges(a(vipModel2.getLevel()));
            b.add(vipModel2);
            VipModel vipModel3 = new VipModel();
            vipModel3.setLevel(2);
            VipLevelHttpDataModel a4 = a(vipModel3.getLevel(), arrayList);
            if (a4 != null) {
                vipModel3.setName(a4.getName());
                vipModel3.setScore(a4.getScore());
            }
            ArrayList<VipModel> arrayList6 = b;
            vipModel3.setLast_level_name(arrayList6.get(arrayList6.size() - 1).getName());
            ArrayList<VipModel> arrayList7 = b;
            arrayList7.get(arrayList7.size() - 1).setNext_level_name(vipModel3.getName());
            ArrayList<VipModel> arrayList8 = b;
            arrayList8.get(arrayList8.size() - 1).setNext_level_score(vipModel3.getScore());
            vipModel3.setTag_color(Color.parseColor("#A2BCEC"));
            vipModel3.setTag_text_color(Color.parseColor("#11254C"));
            vipModel3.setDesc_color(Color.parseColor("#8011254C"));
            vipModel3.setDesc_light_color("#11254C");
            vipModel3.setBg_url("https://web.bldimg.com/cblued/static/live_vip_level_3_bg.1h0kofu1v20u7o7.webp");
            vipModel3.setCard_bg_url("https://web.bldimg.com/cblued/static/live_vip_level_3_card_bg_02.1h2sjrsc41esa43.webp");
            vipModel3.setLevel_title_url("https://web.bldimg.com/cblued/static/live_vip_level_3_card_title.1h0kogvch1pl7uh.webp");
            vipModel3.setOrnament_url("https://web.bldimg.com/cblued/static/live_vip_level_3_card_medal.1h2mnikooerg03.png");
            vipModel3.setPrivileges(a(vipModel3.getLevel()));
            b.add(vipModel3);
            VipModel vipModel4 = new VipModel();
            vipModel4.setLevel(3);
            VipLevelHttpDataModel a5 = a(vipModel4.getLevel(), arrayList);
            if (a5 != null) {
                vipModel4.setName(a5.getName());
                vipModel4.setScore(a5.getScore());
            }
            ArrayList<VipModel> arrayList9 = b;
            vipModel4.setLast_level_name(arrayList9.get(arrayList9.size() - 1).getName());
            ArrayList<VipModel> arrayList10 = b;
            arrayList10.get(arrayList10.size() - 1).setNext_level_name(vipModel4.getName());
            ArrayList<VipModel> arrayList11 = b;
            arrayList11.get(arrayList11.size() - 1).setNext_level_score(vipModel4.getScore());
            vipModel4.setTag_color(Color.parseColor("#9D9AE5"));
            vipModel4.setTag_text_color(Color.parseColor("#45049B"));
            vipModel4.setDesc_color(Color.parseColor("#8045049B"));
            vipModel4.setDesc_light_color("#45049B");
            vipModel4.setBg_url("https://web.bldimg.com/cblued/static/live_vip_level_4_bg.1h0kohm7rikfqn.webp");
            vipModel4.setCard_bg_url("https://web.bldimg.com/cblued/static/live_vip_level_4_card_bg_02.1h2sjrt01mpi9a.webp");
            vipModel4.setLevel_title_url("https://web.bldimg.com/cblued/static/live_vip_level_4_card_title.1h0kp5bnj1lbp48.webp");
            vipModel4.setOrnament_url("https://web.bldimg.com/cblued/static/live_vip_level_4_card_medal_anim.1h2mnkdn92t4ejp.png");
            vipModel4.setPlaceholder(R.drawable.live_vip_level_4_card_medal);
            vipModel4.setPrivileges(a(vipModel4.getLevel()));
            b.add(vipModel4);
            VipModel vipModel5 = new VipModel();
            vipModel5.setLevel(4);
            VipLevelHttpDataModel a6 = a(vipModel5.getLevel(), arrayList);
            if (a6 != null) {
                vipModel5.setName(a6.getName());
                vipModel5.setScore(a6.getScore());
            }
            ArrayList<VipModel> arrayList12 = b;
            vipModel5.setLast_level_name(arrayList12.get(arrayList12.size() - 1).getName());
            ArrayList<VipModel> arrayList13 = b;
            arrayList13.get(arrayList13.size() - 1).setNext_level_name(vipModel5.getName());
            ArrayList<VipModel> arrayList14 = b;
            arrayList14.get(arrayList14.size() - 1).setNext_level_score(vipModel5.getScore());
            vipModel5.setNext_level_name("");
            vipModel5.setNext_level_score(-1.0f);
            vipModel5.setTag_color(Color.parseColor("#523A23"));
            vipModel5.setTag_text_color(Color.parseColor("#F5DDA7"));
            vipModel5.setDesc_color(Color.parseColor("#80F5DDA7"));
            vipModel5.setDesc_light_color("#F5DDA7");
            vipModel5.setBg_url("https://web.bldimg.com/cblued/static/live_vip_level_5_bg.1h0kp60uh8tcva.webp");
            vipModel5.setCard_bg_url("https://web.bldimg.com/cblued/static/live_vip_level_5_card_bg_02.1h2sjrtpd9quu4.webp");
            vipModel5.setLevel_title_url("https://web.bldimg.com/cblued/static/live_vip_level_5_card_title.1h0kp70h49einb.webp");
            vipModel5.setOrnament_url("https://web.bldimg.com/cblued/static/live_vip_level_5_card_medal_anim.1h2mnl2qs264ho1.png");
            vipModel5.setPlaceholder(R.drawable.live_vip_level_5_card_medal);
            vipModel5.setPrivileges(a(vipModel5.getLevel()));
            b.add(vipModel5);
            return b;
        }
        return b;
    }

    public final VipDataModel a(VipHttpDataModel data) {
        Intrinsics.e(data, "data");
        VipDataModel vipDataModel = new VipDataModel();
        VipCurrentHttpDataModel current = data.getCurrent();
        if (current != null) {
            vipDataModel.setCurrent_level(current.getLevel());
            vipDataModel.setCurrent_score(current.getScore());
            vipDataModel.setCurrent_level_name(current.getName());
            vipDataModel.setNext_level_name(current.getNext_name());
            vipDataModel.setNext_level_score(current.getNext_score());
        }
        ArrayList<VipLevelHttpDataModel> config = data.getConfig();
        vipDataModel.setLevels(config == null ? null : a(config));
        return vipDataModel;
    }
}
