package com.blued.community.http;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alipay.sdk.util.i;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.util.cm.QSConstants;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.g.c;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedExtra;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.utils.CityHelper;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.google.gson.JsonParser;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/http/FeedHttpUtils.class */
public class FeedHttpUtils {
    public static String a = "?http_method_override=DELETE";

    private static Map<String, String> a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("filter", str);
        a2.put("page", str2);
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, str3);
        a2.put("lot", str4);
        a2.put(c.B, str5);
        a2.put("distance", str6);
        a2.put("type", String.valueOf(i));
        if (!TextUtils.isEmpty(str7)) {
            a2.put("exclude_id", str7);
        }
        return a2;
    }

    public static void a(int i, int i2, int i3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("filter", "3");
        a2.put("push_page", String.valueOf(i));
        a2.put("push_site", String.valueOf(i2));
        a2.put("p_id", String.valueOf(i3));
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/users/feed/diversion", null, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", i + "");
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, i2 + "");
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/super_topics/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", String.valueOf(i));
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/discover/recommend", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", i + "");
        int i3 = i2;
        if (i2 == 0) {
            i3 = 20;
        }
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, i3 + "");
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/" + str + "/comments/hot", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("source", "ticktock");
        HttpManager.b(CommunityHttpUtils.a(a2, CommunityHttpUtils.a() + "/ticktocks/" + str + "?http_method_override=DELETE"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, int i, int i2, int i3, String str3, String str4, String str5, int i4, String str6, String str7, String str8, int i5) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("contents", str2);
        b.put("allow_comments", i + "");
        b.put("reading_scope", i2 + "");
        b.put("is_super_topics", i4 + "");
        b.put("super_did", str6);
        b.put("super_topics_name", str7);
        b.put("share_circle_posting_id", str8);
        b.put("repost_also_comment", i5 + "");
        Map<String, String> a2 = BluedHttpTools.a();
        if (i3 != 0) {
            a2.put("is_ads", i3 + "");
        }
        b.put(QSConstants.TILE_LOCATION, str3);
        b.put("location_lot", str4);
        b.put("location_lat", str5);
        HttpManager.b(CommunityHttpUtils.a(a2, CommunityHttpUtils.a() + "/ticktocks/" + str + "/repost"), bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tid", str2);
        a2.put("uid", str);
        if (i != 0) {
            a2.put("is_ads", i + "");
        }
        Map<String, String> a3 = BluedHttpTools.a();
        a3.put("source", "ticktock");
        HttpManager.b(CommunityHttpUtils.a(a3, CommunityHttpUtils.a() + "/ticktocks/" + str2 + "/liked/" + str + "?http_method_override=DELETE"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, int i, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tid", str2);
        a2.put("uid", str);
        if (i != 0) {
            a2.put("is_ads", i + "");
        }
        Map<String, String> a3 = BluedHttpTools.a();
        a3.put("source", "ticktock");
        String a4 = CommunityHttpUtils.a(a3, CommunityHttpUtils.a() + "/ticktocks/" + str2 + "/liked/" + str);
        if (!TextUtils.isEmpty(str3)) {
            CommunityHttpUtils.a(str3);
        }
        HttpManager.b(a4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("reason", str2);
        HttpManager.b(CommunityHttpUtils.a() + "/blued/objectionable/ticktocks/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", str2);
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, str3);
        if (i != 0) {
            a2.put("is_ads", i + "");
        }
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/" + str + "/repost", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tid", str);
        a2.put("page", str2);
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, str3);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/recommend/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        HttpManager.a(CommunityHttpUtils.a() + "/blued/feedback", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, IRequestHost iRequestHost) {
        String str = CommunityHttpUtils.a() + "/ticktocks/users/feed/diversion";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("filter", String.valueOf(i));
        a2.put(c.B, CityHelper.a().e());
        a2.put("lot", CityHelper.a().c());
        a2.put("is_no_show", String.valueOf(i2));
        int v = CommunityPreferences.v("RecommendDrawDepthBubbleShowCount");
        String str2 = v >= 2 ? "1" : "0";
        a2.put("shallow_draw_user_hit", str2);
        LogUtils.c("浅绘用户--> RecommendDrawDepthBubbleShowCount=" + v);
        LogUtils.c("浅绘用户--> shallow_draw_user_hit=" + str2);
        HttpManager.a(str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", i + "");
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, i2 + "");
        a2.put("q", URLEncoder.encode(str));
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/super_topics/search", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/live/feed/followed-onair-list?page=" + i, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, String str, String str2, IRequestHost iRequestHost) {
        String str3 = CommunityHttpUtils.a() + "/ticktocks/users/" + UserInfo.getInstance().getLoginUserInfo().getUid() + "/explore";
        Map<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put("page", i + "");
        if (!TextUtils.isEmpty(str)) {
            arrayMap.put("exclude_id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayMap.put("super_num", str2);
        }
        arrayMap.put("channel", AppInfo.c);
        String[] r = CommunityServiceManager.a().r();
        if (r != null && CommunityServiceManager.a().q() != 6) {
            if (!TextUtils.isEmpty(r[0])) {
                arrayMap.put(r[0], r[1]);
            }
            if (!TextUtils.isEmpty(r[2])) {
                arrayMap.put(r[2], r[3]);
            }
        }
        HttpManager.a(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, String str, String str2, String str3, String str4, String str5, IRequestHost iRequestHost) {
        String str6 = CommunityHttpUtils.a() + "/ticktocks/info";
        Map<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put("page", i + "");
        arrayMap.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "20");
        arrayMap.put("filter", str);
        arrayMap.put("longitude", str2);
        arrayMap.put("latitude", str3);
        if (!TextUtils.isEmpty(str4)) {
            arrayMap.put("feed_ids", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            arrayMap.put("bubble_state", str5);
        }
        HttpManager.a(str6, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/super_topics/outside", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, NewFeedModel newFeedModel, String str, String str2, String[] strArr, String[] strArr2, String str3, String str4, double d) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("os", str);
        b.put(PhoneConstants.PHONE_KEY, str2);
        b.put("duration", String.valueOf(d));
        b.put("text", newFeedModel.getContent());
        b.put("pics", strArr);
        b.put("videos", strArr2);
        b.put("width", str3);
        b.put("height", str4);
        b.put("location_lot", newFeedModel.getLng());
        b.put("location_lat", newFeedModel.getLat());
        b.put("allow_comments", newFeedModel.allow_comments + "");
        b.put("reading_scope", newFeedModel.reading_scope + "");
        b.put(QSConstants.TILE_LOCATION, newFeedModel.address);
        b.put("is_vote", newFeedModel.is_vote + "");
        b.put("is_super_topics", newFeedModel.is_super_topics + "");
        b.put("super_did", newFeedModel.super_did);
        b.put("super_topics_avatar", newFeedModel.super_topics_avatar);
        b.put("super_topics_name", newFeedModel.super_topics_name);
        b.put("is_share_super_topics", Integer.valueOf(newFeedModel.is_share_super_topics));
        b.put("share_s_t_did", newFeedModel.share_s_t_did);
        b.put("circle_id", newFeedModel.circle_id);
        b.put("is_posts_vote", Integer.valueOf(newFeedModel.is_posts_vote));
        b.put("posts_vote_title", newFeedModel.posts_vote_title);
        b.put("option", TextUtils.isEmpty(newFeedModel.option) ? "" : newFeedModel.option.split(i.b));
        b.put("share_circle_posting_id", newFeedModel.share_posting_id);
        b.put("is_join_circle", newFeedModel.is_join_circle + "");
        b.put("join_circle_id", newFeedModel.join_circle_id + "");
        b.put("join_circle_title", newFeedModel.join_circle_title);
        b.put("repost_also_comment", newFeedModel.repost_also_comment + "");
        b.put("is_share_circle", newFeedModel.is_share_circle + "");
        b.put("share_circle_id", newFeedModel.share_circle_id);
        b.put("is_share_activity", newFeedModel.is_share_activity + "");
        b.put("share_activity_id", newFeedModel.share_activity_id);
        b.put("activity_score", newFeedModel.event_score + "");
        b.put("activity_evaluate", newFeedModel.event_evaluate);
        b.put("activity_id", newFeedModel.activity_id);
        b.put("feed_pics_width", newFeedModel.feed_pics_width);
        b.put("feed_pics_height", newFeedModel.feed_pics_height);
        b.put("h5_topic_id", newFeedModel.h5_topic_id);
        b.put("h5_topic_name", newFeedModel.h5_topic_name);
        if (!TextUtils.isEmpty(newFeedModel.music_id)) {
            b.put("music_id", newFeedModel.music_id);
        }
        b.put("is_anonym", Integer.valueOf(newFeedModel.is_anonym));
        b.put("anonym_comment", Integer.valueOf(newFeedModel.anonym_comment));
        b.put("anonym_avatar", Integer.valueOf(newFeedModel.anonym_avatar));
        b.put("bubble_state_id", newFeedModel.sign_state_id);
        if (!TextUtils.isEmpty(newFeedModel.extraJSON)) {
            if (!TextUtils.isEmpty(((FeedExtra) AppInfo.f().fromJson(newFeedModel.extraJSON, FeedExtra.class)).url)) {
                b.put("is_url", "1");
            }
            b.put("extras", new JsonParser().parse(newFeedModel.extraJSON));
        }
        if (strArr2 == null || strArr2.length <= 0) {
            b.put("is_catch", "0");
        } else {
            b.put("is_catch", "1");
        }
        b.put("is_questionnaire", newFeedModel.is_questionnaire + "");
        b.put("tt_type", newFeedModel.tt_type + "");
        b.put("is_label", newFeedModel.is_label + "");
        b.put("classify_id", newFeedModel.bubbleClassifyId);
        b.put("state_types", newFeedModel.state_types);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/me", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, BluedIngSelfFeed bluedIngSelfFeed, FeedComment feedComment, String str, IRequestHost iRequestHost) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        String str2 = (feedComment == null || TextUtils.isEmpty(feedComment.comment_id)) ? "0" : "1";
        String str3 = feedComment == null ? "" : feedComment.comment_id;
        int i = feedComment == null ? bluedIngSelfFeed.is_ads : feedComment.is_ads;
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("text", str);
        a2.put("is_reply", str2);
        a2.put("reply_id", str3);
        String str4 = CommunityHttpUtils.a() + "/ticktocks/" + bluedIngSelfFeed.feed_id + "/comments";
        Map<String, String> a3 = BluedHttpTools.a();
        if (i != 0) {
            a3.put("is_ads", i + "");
        }
        a3.put("source", "ticktock");
        if (!TextUtils.isEmpty(bluedIngSelfFeed.comments_url)) {
            CommunityHttpUtils.a(bluedIngSelfFeed.comments_url);
        }
        HttpManager.b(CommunityHttpUtils.a(a3, str4), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("contents", str);
        a2.put("type", i + "");
        HttpManager.b(CommunityHttpUtils.a() + "/blued/feedback", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/super_topics/recorded?filter=" + str + "&page=" + i + "&size=" + i2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/" + str + "/stickypost", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, int i, int i2, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/catch/music/star/" + str + "/own?size=" + i2 + "&page=" + i, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        a(bluedUIHttpResponse, UserInfoUtils.c(), "all_hot_data", str, str2, CommunityServiceManager.c().e(), CommunityServiceManager.c().f(), "", "", iRequestHost);
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", str);
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, str2);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/waterfall/" + str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", str2);
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, str3);
        a2.put("source", "ticktock");
        a2.put("anchor_comment_id", str4);
        if (i != 0) {
            a2.put("is_ads", i + "");
        }
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/" + str + "/comments", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, IRequestHost iRequestHost) {
        String str8 = str;
        try {
            if (!TextUtils.isEmpty(str)) {
                str8 = URLEncoder.encode(str);
            }
        } catch (Exception e) {
            str8 = "";
        }
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("filter", str3);
        a2.put("page", str4);
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, str5);
        if (!TextUtils.isEmpty(str8)) {
            a2.put("name", str8);
        }
        if (!TextUtils.isEmpty(str2)) {
            a2.put("super_did", str2);
        }
        if (!TextUtils.isEmpty(str6)) {
            a2.put("get_type", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            a2.put("insert_tt_dids", str7);
        }
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/super_topics", bluedUIHttpResponse, iRequestHost).a(a2).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = a(str2, str3, str4, str5, str6, str7, str8, i);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/users/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, boolean z, boolean z2, String str9, int i2, IRequestHost iRequestHost) {
        Map<String, String> a2 = a(str2, str3, str4, str5, str6, str7, str8, i);
        a2.put("is_top", z ? "1" : "0");
        a2.put("is_third_ads", z2 ? "1" : "0");
        if (CommunityManager.a.a().h()) {
            a2.put("enter_city_num", String.valueOf(CommunityPreferences.E()));
        }
        if (!StringUtils.d(str9)) {
            a2.put("ads_id", str9);
        }
        a2.put("last_data_total", i2 + "");
        if (CommonStringUtils.a(str3) == 1) {
            a2.put("anchor_round", CommunityPreferences.O().booleanValue() ? "2" : "1");
        } else {
            a2.put("anchor_round", CommunityPreferences.O().booleanValue() ? "1" : "2");
        }
        if (CommonStringUtils.a(str3) == 1 && CommunityManager.a.a().b() && CommunityManager.a.a().a() != null) {
            if (CommunityManager.a.a().a().getDouble_click_feed_id() > 0) {
                LogUtils.c("noticeGetBubbleData.getCityFeed.feedId:" + CommunityManager.a.a().a().getDouble_click_feed_id());
                LogUtils.c("noticeGetBubbleData.getCityFeed.uid:" + CommunityManager.a.a().a().getDouble_click_feed_uid());
                a2.put("double_click_feed_id", CommunityManager.a.a().a().getDouble_click_feed_id() + "");
                a2.put("double_click_feed_uid", CommunityManager.a.a().a().getDouble_click_feed_uid() + "");
                CommunityManager.a.a().a().setDouble_click_feed_id(0);
                CommunityManager.a.a().a().setDouble_click_feed_uid(0);
                CommunityManager.a.a().a().double_click_feed_avatar = null;
            }
            if (CommunityManager.a.a().a().predestined_person_feed_ttids != null) {
                LogUtils.c("noticeGetBubbleData.getCityFeed.predestined_person_feed_ttids:" + CommunityManager.a.a().a().predestined_person_feed_ttids);
                LogUtils.c("noticeGetBubbleData.getCityFeed.predestined_person_feed_uids:" + CommunityManager.a.a().a().predestined_person_feed_uids);
                a2.put("predestined_person_feed_ttids", CommunityManager.a.a().a().predestined_person_feed_ttids);
                a2.put("predestined_person_feed_uids", CommunityManager.a.a().a().predestined_person_feed_uids);
                CommunityManager.a.a().a().predestined_person_feed_ttids = null;
                CommunityManager.a.a().a().predestined_person_feed_uids = null;
                CommunityManager.a.a().a().extra_bubble_img = null;
            }
            if (CommunityManager.a.a().a().extra_activity_id != 0) {
                a2.put("extra_activity_id", String.valueOf(CommunityManager.a.a().a().extra_activity_id));
                CommunityManager.a.a().a().extra_activity_id = 0;
            }
            if (CommunityManager.a.a().a().adv_activity_id != 0) {
                a2.put("adv_activity_id", String.valueOf(CommunityManager.a.a().a().adv_activity_id));
                CommunityManager.a.a().a().adv_activity_id = 0;
            }
            if (!TextUtils.isEmpty(CommunityManager.a.a().a().extra_bubble_id)) {
                a2.put("extra_bubble_id", String.valueOf(CommunityManager.a.a().a().extra_bubble_id));
                CommunityManager.a.a().a().extra_bubble_id = null;
            }
            CommunityManager.a.a().a(false);
        }
        if (CommunityServiceManager.a().q() == 6 || CommunityServiceManager.a().q() == 7) {
            String[] r = CommunityServiceManager.a().r();
            if (r != null) {
                if (!TextUtils.isEmpty(r[0])) {
                    a2.put(r[0], r[1]);
                }
                if (!TextUtils.isEmpty(r[2])) {
                    a2.put(r[2], r[3]);
                }
            }
            CommunityServiceManager.a().s();
        }
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/users/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, IRequestHost iRequestHost) {
        a(bluedUIHttpResponse, str, str2, str3, str4, str5, str6, str7, str8, 0, iRequestHost);
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, boolean z, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("vote_option", z ? "a" : "b");
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/" + str + "/voted/" + str2 + "?is_ads=0", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String[] strArr, boolean z) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("text", str2);
        b.put("is_reply", "0");
        b.put("reply_id", "");
        b.put("pics", strArr);
        b.put("is_anonym", z ? "1" : "0");
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("source", "posting");
        HttpManager.b(CommunityHttpUtils.a(a2, CommunityHttpUtils.a() + "/ticktocks/" + str + "/comments"), bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, boolean z, String str, String str2, int i, IRequestHost iRequestHost) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("cid", str2);
        Map<String, String> a3 = BluedHttpTools.a();
        a3.put("source", z ? "ticktock" : "posting");
        if (i != 0) {
            a3.put("is_ads", i + "");
        }
        HttpManager.b(CommunityHttpUtils.a(a3, CommunityHttpUtils.a() + "/ticktocks/" + str + "/comments?http_method_override=DELETE"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, boolean z, String str, String str2, String str3, String str4, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", str2);
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, str3);
        a2.put("source", z ? "ticktock" : "posting");
        a2.put("anchor_comment_id", str4);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/comments/" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("allow_comments", i + "");
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/" + str + "?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("keyword", str);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/search/circle_mini", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, String str2, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost, boolean z) {
        String str3;
        Map<String, String> a2 = BluedHttpTools.a();
        if (i == 0) {
            str3 = CommunityHttpUtils.a() + "/ticktocks/" + str + "/comments/" + str2 + "?http_method_override=DELETE";
        } else {
            str3 = CommunityHttpUtils.a() + "/ticktocks/" + str + "/comments/" + str2;
        }
        Map<String, String> a3 = BluedHttpTools.a();
        a3.put("source", z ? "ticktock" : "posting");
        HttpManager.b(CommunityHttpUtils.a(a3, str3), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("types", str);
        a2.put("feed_id", str2);
        a2.put("feed_uid", str3);
        a(CommunityHttpUtils.a() + "/ticktocks/click", a2, bluedUIHttpResponse, iRequestHost);
    }

    public static void a(String str, String str2, String str3, String str4, IRequestHost iRequestHost, BluedUIHttpResponse bluedUIHttpResponse) {
        String str5 = CommunityHttpUtils.a() + "/users/live/recommend";
        Map<String, String> a2 = BluedHttpTools.a();
        if (!TextUtils.isEmpty(str)) {
            a2.put("last_lid", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            a2.put("ai_last_uid", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            a2.put("recommend_char", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            a2.put("type", str4);
        }
        HttpManager.a(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, Map<String, String> map, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(map).h();
    }

    public static void a(String str, boolean z, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str2 = CommunityHttpUtils.a() + "/ticktocks/super_topics/follow";
        String str3 = str2;
        if (!z) {
            str3 = str2 + a;
        }
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("super_id", str);
        HttpManager.a(str3, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        String str2 = (CommunityHttpUtils.a() + "/blued/explore") + "?exclude_id=" + str;
        Map<String, String> a3 = BluedHttpTools.a(true);
        if (AppInfo.m()) {
            try {
                Logger.c("user-agent", "user-agent", AppInfo.f().toJson(a3));
            } catch (Exception e) {
            }
        }
        HttpManager.a(str2, bluedUIHttpResponse, iRequestHost).b(a3).a(a2).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/super_topics?filter=list&page=" + str + "&size=" + str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", str2);
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, str3);
        if (i != 0) {
            a2.put("is_ads", i + "");
        }
        a2.put("source", "ticktock");
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/" + str + "/liked", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/questionnaire?filter=text", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/state", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/catch/music/" + str + "/detail?size=" + i2 + "&page=" + i, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/" + str + "/stickypost?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", str);
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, str2);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/comments/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("lot", str);
        a2.put(c.B, str2);
        a2.put("city_name", str3);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/banner", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(String str, int i, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("reading_scope", i + "");
        a2.put("tid", str);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/scope?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void b(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("keyword", str);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/search/topic_mini", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        a(bluedUIHttpResponse, UserInfoUtils.c(), "handsome", str, str2, CommunityServiceManager.c().e(), CommunityServiceManager.c().f(), "", "", iRequestHost);
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", "1");
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "100");
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/questionnaire?filter=img", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put("filter", "banner");
        arrayMap.put("longitude", CityHelper.a().c());
        arrayMap.put("latitude", CityHelper.a().e());
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, IRequestHost iRequestHost) {
        String str2 = CommunityHttpUtils.a() + "/ticktocks/" + str + "/liked/" + UserInfoUtils.c() + "?filter=expression";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("expression_id", String.valueOf(i));
        if (i2 > 0) {
            a2.put("interaction_id", String.valueOf(i2));
        }
        HttpManager.b(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/super_topics/exist?name=" + str, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("page", str);
        a2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, str2);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/liked/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse) {
        Map<String, String> a2 = BluedHttpTools.a();
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/oneself/describe", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/feed/guess_like", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, IRequestHost iRequestHost) {
        String str2 = CommunityHttpUtils.a() + "/ticktocks/" + str + "/liked/" + UserInfoUtils.c() + "?filter=expression&http_method_override=DELETE";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("expression_id", String.valueOf(i));
        if (i2 > 0) {
            a2.put("interaction_id", String.valueOf(i2));
        }
        HttpManager.b(str2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("super_did", str);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/super_topics/recorded?http_method_override=DELETE&filter=joined", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("text", str);
        a2.put("type", str2);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/check_content", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("filter", "follow_region");
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/super_topics/follow/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/catch/music/" + str + "/star?http_method_override=POST", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("filter", "join_follow_region");
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/super_topics/follow/list", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void f(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/catch/music/" + str + "/star?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void g(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String ao = CommunityPreferences.ao();
        LogUtils.c("关注发布引导--> lastShowDate=" + ao);
        String str = CommunityHttpUtils.a() + "/ticktocks/send/guide";
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("filter", "2");
        if (!TextUtils.isEmpty(ao)) {
            a2.put("last_date", ao);
        }
        a(str, a2, bluedUIHttpResponse, iRequestHost);
    }

    public static void g(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("feed_id", str);
        HttpManager.b(CommunityHttpUtils.a() + "/users/activity/similarly", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void h(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("filter", "1");
        a(CommunityHttpUtils.a() + "/ticktocks/send/guide", a2, bluedUIHttpResponse, iRequestHost);
    }

    public static void h(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put("filter", str);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/info", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void i(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        String str = CommunityHttpUtils.a() + "/ticktocks/send/guide";
        Map<String, String> a2 = BluedHttpTools.a();
        if (CommunityPreferences.x("SendFeedFirstTime")) {
            a2.put("is_first", String.valueOf(1));
        }
        a2.put("filter", "3");
        a(str, a2, bluedUIHttpResponse, iRequestHost);
    }

    public static void i(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put("feed_id", str);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/feed/double_click", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(arrayMap).h();
    }

    public static void j(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("feed_id", String.valueOf(str));
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/feed/say_hello", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }
}
