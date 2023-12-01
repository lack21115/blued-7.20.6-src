package com.soft.blued.user;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.web.jsbridge.BridgeWhiteListManager;
import com.blued.android.statistics.BluedStatistics;
import com.blued.community.model.BubbleExhibitionModel;
import com.blued.community.utils.CityHelper;
import com.blued.track.bytedance.ByteDanceLogUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soft.blued.R;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.ui.find.model.HomeTopTabModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.login_register.model.MarketPraiseGuide;
import com.soft.blued.ui.login_register.model.NearbyPeopleTabModel;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.user.Observer.BluedConfigDataObserver;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/user/BluedConfig.class */
public class BluedConfig {

    /* renamed from: c  reason: collision with root package name */
    private static volatile BluedConfig f34698c;
    private static long f = 5000;
    private AppConfigModel d;
    private Gson g;
    private long e = 0;

    /* renamed from: a  reason: collision with root package name */
    public boolean f34699a = false;
    public boolean b = false;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/user/BluedConfig$UpdateBluedConfigListner.class */
    public interface UpdateBluedConfigListner {
        void a();

        void b();
    }

    private BluedConfig() {
        String C = BluedPreferences.C();
        this.g = new GsonBuilder().disableHtmlEscaping().create();
        if (StringUtils.d(C)) {
            this.d = new AppConfigModel();
            return;
        }
        try {
            this.d = (AppConfigModel) this.g.fromJson(C, (Class<Object>) AppConfigModel.class);
        } catch (Exception e) {
            this.d = new AppConfigModel();
        }
    }

    public static BluedConfig a() {
        BluedConfig bluedConfig;
        synchronized (BluedConfig.class) {
            try {
                if (f34698c == null) {
                    f34698c = new BluedConfig();
                }
                bluedConfig = f34698c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bluedConfig;
    }

    public String A() {
        return this.d.new_gift_key;
    }

    public boolean B() {
        return this.d.nearby_recommend_live_ui == 1;
    }

    public boolean C() {
        return this.d.quietly_call_allow == 1;
    }

    public int D() {
        return this.d.nearby_online_time_ui;
    }

    public boolean E() {
        return this.d.users_call_filter == 1;
    }

    public boolean F() {
        return true;
    }

    public boolean G() {
        return this.d.is_anchor == 1;
    }

    public List<String> H() {
        return this.d.festival_activities;
    }

    public String I() {
        return this.d.festival_icon;
    }

    public int J() {
        return this.d.credit_score;
    }

    public boolean K() {
        return this.d.circle_open == 1;
    }

    public boolean L() {
        return this.d.publish_post == 1;
    }

    public boolean M() {
        return this.d.topics_open == 1;
    }

    public boolean N() {
        return this.d.create_topic == 1;
    }

    public int O() {
        return this.d.super_topics_type;
    }

    public boolean P() {
        return this.d.live_index_page == 1;
    }

    public int Q() {
        return this.d.call_pack_config;
    }

    public int R() {
        return this.d.super_call_config;
    }

    public int S() {
        return this.d.user_filter_style;
    }

    public int T() {
        return this.d.visitor_experiment;
    }

    public int U() {
        return this.d.new_regist_expirement;
    }

    public boolean V() {
        return this.d.ab_circle_test == 1;
    }

    public boolean W() {
        return this.d.tick_city_bubble == 1;
    }

    public boolean X() {
        return this.d.call_experiment == 1;
    }

    public boolean Y() {
        return this.d.is_bubble_exhibition == 1;
    }

    public boolean Z() {
        return this.d.tick_state_test == 1;
    }

    public List<NearbyPeopleTabModel> a(Context context) {
        if (this.d.home_tabs == null || this.d.home_tabs.size() <= 0) {
            this.d.home_tabs = new ArrayList();
            this.d.home_tabs.add(new NearbyPeopleTabModel(context.getResources().getString(R.string.distance), UserFindResult.USER_SORT_BY.NEARBY));
            this.d.home_tabs.add(new NearbyPeopleTabModel(context.getResources().getString(R.string.friends_actice), UserFindResult.USER_SORT_BY.ONLINE));
            this.d.home_tabs.add(new NearbyPeopleTabModel(context.getResources().getString(R.string.smart), UserFindResult.USER_SORT_BY.INTEGRATE));
            this.d.home_tabs.add(new NearbyPeopleTabModel(context.getResources().getString(R.string.view_fresh_only), UserFindResult.USER_SORT_BY.NEWBEE));
            return (ArrayList) ((ArrayList) this.d.home_tabs).clone();
        }
        return (ArrayList) ((ArrayList) this.d.home_tabs).clone();
    }

    public boolean a(final UpdateBluedConfigListner updateBluedConfigListner) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.e;
        if (j == 0 || currentTimeMillis - j >= f) {
            this.e = currentTimeMillis;
            AppHttpUtils.a();
            AppHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<AppConfigModel>>(null) { // from class: com.soft.blued.user.BluedConfig.1

                /* renamed from: a  reason: collision with root package name */
                boolean f34700a = false;

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<AppConfigModel> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                        return;
                    }
                    BluedConfig.this.d = bluedEntityA.getSingleData();
                    LogUtils.c("noticeGetBubbleData.updateConfigData.is_send_feed_msg:" + BluedConfig.this.d.is_send_feed_msg);
                    boolean z = true;
                    if (BluedConfig.this.d.show_net_error_toast != 1) {
                        z = false;
                    }
                    BluedHttpUtils.a(z);
                    if (UserInfo.getInstance().getLoginUserInfo() != null) {
                        UserInfo.getInstance().getLoginUserInfo().setVip_avatars(BluedConfig.this.d.vip_avatars);
                        UserInfo.getInstance().getLoginUserInfo().vip_grade = BluedConfig.this.d.vip_grade;
                        BluedStatistics.a().l(BluedConfig.this.d.vip_grade + "");
                        UserInfo.getInstance().getLoginUserInfo().setBlackCount(BluedConfig.this.d.black_count);
                        UserInfo.getInstance().getLoginUserInfo().setBlackMax(BluedConfig.this.d.black_allowed_count);
                        UserInfo.getInstance().getLoginUserInfo().is_invisible_all = BluedConfig.this.d.is_invisible_all;
                        UserInfo.getInstance().getLoginUserInfo().chat_sdk_type = BluedConfig.this.d.chat_sdk_type;
                        UserInfo.getInstance().getLoginUserInfo().is_user_reactive = BluedConfig.this.d.is_user_reactive;
                    }
                    BluedConfigDataObserver.a().b();
                    BridgeWhiteListManager.getInstance().setData(BluedConfig.this.d.jsbridge_url);
                    if (BluedConfig.this.d.ticktocks_bubble != null && !TextUtils.isEmpty(BluedConfig.this.d.ticktocks_bubble.bubble_pic)) {
                        ImageFileLoader.a((IRequestHost) null).a(BluedConfig.this.d.ticktocks_bubble.bubble_pic).a();
                    }
                    if (updateBluedConfigListner == null && BluedConfig.this.d.official_account != null && !TextUtils.isEmpty(BluedConfig.this.d.official_unique_account)) {
                        SubscribeNumberManager.f32449a.d();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("user_type", BluedConfig.this.d.user_type);
                    hashMap.put("is_vip", Integer.valueOf(UserInfo.getInstance().getLoginUserInfo().vip_grade));
                    hashMap.put("regist_time", BluedConfig.this.d.regist_time);
                    ByteDanceLogUtils.a(hashMap);
                    if (BluedConfig.this.d.festival_activities != null) {
                        for (String str : BluedConfig.this.d.festival_activities) {
                            ImageFileLoader.a((IRequestHost) null).a(str).a();
                        }
                    }
                    try {
                        BluedPreferences.i(AppInfo.f().toJson(bluedEntityA.getSingleData()));
                    } catch (Exception e) {
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    this.f34700a = true;
                    return super.onUIFailure(i, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    UpdateBluedConfigListner updateBluedConfigListner2 = updateBluedConfigListner;
                    if (updateBluedConfigListner2 != null) {
                        if (this.f34700a) {
                            updateBluedConfigListner2.b();
                        } else {
                            updateBluedConfigListner2.a();
                        }
                    }
                    this.f34700a = false;
                    super.onUIFinish();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                }
            });
            return true;
        }
        return false;
    }

    public List<BubbleExhibitionModel> aa() {
        return this.d.bubble_exhibition_data;
    }

    public int ab() {
        return this.d.state_list_ab;
    }

    public boolean ac() {
        return this.d.multi_call_experiment == 1;
    }

    public AppConfigModel b() {
        return this.d;
    }

    public List<List<String>> b(Context context) {
        if (this.d.home_menu == null || this.d.home_menu.size() <= 0) {
            if (this.d.home_menu == null) {
                this.d.home_menu = new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(UserFindResult.USER_SORT_BY.NEARBY);
            this.d.home_menu.add(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(UserFindResult.USER_SORT_BY.ONLINE);
            this.d.home_menu.add(arrayList2);
            return (ArrayList) ((ArrayList) this.d.home_menu).clone();
        }
        return (ArrayList) ((ArrayList) this.d.home_menu).clone();
    }

    public boolean b(UpdateBluedConfigListner updateBluedConfigListner) {
        this.e = 0L;
        return a(updateBluedConfigListner);
    }

    public List<HomeTopTabModel> c(Context context) {
        String string;
        ArrayList arrayList = new ArrayList();
        if (this.d.indexing_top_bar != null && this.d.indexing_top_bar.sort != null && this.d.indexing_top_bar.sort.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.d.indexing_top_bar.sort.size()) {
                    break;
                }
                int intValue = this.d.indexing_top_bar.sort.get(i2).intValue();
                if (intValue == 1) {
                    string = context.getResources().getString(R.string.find_person);
                } else if (intValue != 2) {
                    string = "";
                } else {
                    string = CityHelper.a().a(context, BluedPreferences.dd());
                }
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(new HomeTopTabModel(intValue, string));
                }
                i = i2 + 1;
            }
        }
        if (arrayList.size() == 0) {
            arrayList.add(new HomeTopTabModel(1, context.getResources().getString(R.string.find_person)));
            arrayList.add(new HomeTopTabModel(2, context.getResources().getString(2131887159)));
        }
        return arrayList;
    }

    public void c() {
        this.e = 0L;
        d();
    }

    public boolean d() {
        return a((UpdateBluedConfigListner) null);
    }

    public boolean e() {
        return this.d.show_search_face == 1;
    }

    public AppConfigModel.Tip f() {
        return this.d.tips;
    }

    public AppConfigModel.VIPRight g() {
        return this.d.vip_split == null ? new AppConfigModel.VIPRight() : this.d.vip_split;
    }

    public AppConfigModel.VIPRight h() {
        AppConfigModel.VIPRight vIPRight = new AppConfigModel.VIPRight();
        vIPRight.is_hide_last_operate = this.d.is_hide_last_operate;
        vIPRight.is_global_view_secretly = this.d.is_global_view_secretly;
        vIPRight.is_hide_distance = this.d.is_hide_distance;
        vIPRight.is_hide_city_settled = this.d.is_hide_city_settled;
        vIPRight.is_invisible_half = this.d.is_invisible_half;
        vIPRight.is_invisible_all = this.d.is_invisible_all;
        vIPRight.is_show_vip_page = this.d.is_show_vip_page;
        vIPRight.is_traceless_access = this.d.is_traceless_access;
        vIPRight.is_hide_vip_look = this.d.is_hide_vip_look;
        vIPRight.is_filter_ads = this.d.is_filter_ads;
        return vIPRight;
    }

    public boolean i() {
        if (this.d.is_hide_group_graph == 1) {
            AppMethods.d((int) R.string.only_v_user_can_use);
            return true;
        }
        return false;
    }

    public boolean j() {
        return this.d.is_show_group_burn_after_reading == 0;
    }

    public AppConfigModel.FeedPromotion k() {
        return this.d.tt_promotion;
    }

    public boolean l() {
        return this.d.is_call_open == 1;
    }

    public int m() {
        return this.d.is_call;
    }

    public int n() {
        return this.d.call_count;
    }

    public int o() {
        if (this.d.indexing_top_bar != null) {
            return this.d.indexing_top_bar.default_show;
        }
        return 1;
    }

    public boolean p() {
        return this.d.is_open_logout == 1;
    }

    public boolean q() {
        return this.d.can_not_modify == 1;
    }

    public boolean r() {
        return this.d.show_msg_src == 1;
    }

    public MarketPraiseGuide s() {
        MarketPraiseGuide marketPraiseGuide = new MarketPraiseGuide();
        marketPraiseGuide.content = this.d.show_star_dialog_text;
        marketPraiseGuide.title = this.d.show_star_dialog_title;
        marketPraiseGuide.cancel = this.d.show_star_dialog_button_bad;
        marketPraiseGuide.confirm = this.d.show_star_dialog_button_praise;
        marketPraiseGuide.count = this.d.show_star_dialog_count;
        marketPraiseGuide.type = this.d.show_star_dialog_text_type;
        return marketPraiseGuide;
    }

    public boolean t() {
        return this.d.is_live_tx_player == 1;
    }

    public boolean u() {
        return this.d.index_is_complete_rate == 1;
    }

    public boolean v() {
        return this.d.message_is_complete_rate == 1;
    }

    public AppConfigModel.CallBubbleTest w() {
        return this.d.call_bubble_test;
    }

    public int x() {
        return this.d.complete_rate;
    }

    public boolean y() {
        return this.d.show_half_invisible == 1;
    }

    public int z() {
        return this.d.ad_close_pop;
    }
}
