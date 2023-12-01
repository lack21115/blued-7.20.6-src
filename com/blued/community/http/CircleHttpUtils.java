package com.blued.community.http;

import android.content.Context;
import android.os.BatteryManager;
import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.utils.UserInfoUtils;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/http/CircleHttpUtils.class */
public class CircleHttpUtils {
    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("source", "posting");
        a2.put("del_reason_id", str2);
        HttpManager.b(CommunityHttpUtils.a(a2, CommunityHttpUtils.a() + "/ticktocks/" + str + "?http_method_override=DELETE"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/circles/class", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/users/circle?page=" + i, bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/circle/posts_list", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/users/circle/notice", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, int i2, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        a2.put("classify_id", str);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/circles", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, int i, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("type", str);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/my/posting", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/recommend/circles", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, BluedIngSelfFeed bluedIngSelfFeed, FeedComment feedComment, String str, boolean z, int i, IRequestHost iRequestHost) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        String str2 = (feedComment == null || TextUtils.isEmpty(feedComment.comment_id)) ? "0" : "1";
        String str3 = feedComment == null ? "" : feedComment.comment_id;
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("text", str);
        a2.put("is_reply", str2);
        a2.put("reply_id", str3);
        a2.put("is_anonym", z ? "1" : "0");
        a2.put("anonym_avatar", i + "");
        String str4 = CommunityHttpUtils.a() + "/ticktocks/" + bluedIngSelfFeed.feed_id + "/comments";
        Map<String, String> a3 = BluedHttpTools.a();
        a3.put("source", "posting");
        if (!TextUtils.isEmpty(bluedIngSelfFeed.comments_url)) {
            CommunityHttpUtils.a(bluedIngSelfFeed.comments_url);
        }
        HttpManager.b(CommunityHttpUtils.a(a3, str4), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("posting_id", str);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/posting/shared", bluedUIHttpResponse, null).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, int i2, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        a2.put("source", "posting");
        a2.put("anchor_comment_id", str2);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/" + str + "/comments", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("vote_option", String.valueOf(i));
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/" + str + "/posts_voted/" + UserInfoUtils.c(), bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tid", str);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/circle/posts/top", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, int i, int i2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        a2.put("type", str2);
        a2.put(WBPageConstants.ParamKey.PAGE, i + "");
        a2.put("size", i2 + "");
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/circles/list", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tid", str2);
        a2.put("uid", str);
        Map<String, String> a3 = BluedHttpTools.a();
        a3.put("source", "posting");
        HttpManager.b(CommunityHttpUtils.a(a3, CommunityHttpUtils.a() + "/ticktocks/" + str2 + "/liked/" + str + "?http_method_override=DELETE"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tid", str2);
        a2.put("uid", str);
        Map<String, String> a3 = BluedHttpTools.a();
        a3.put("source", "posting");
        String a4 = CommunityHttpUtils.a(a3, CommunityHttpUtils.a() + "/ticktocks/" + str2 + "/liked/" + str);
        if (!TextUtils.isEmpty(str3)) {
            CommunityHttpUtils.a(str3);
        }
        HttpManager.b(a4, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/users/circle?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, String str2, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        a2.put("target_uid", str2);
        a2.put("is_anonym", String.valueOf(i));
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/circle/mute?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, String str2, int i, String str3, String str4, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        a2.put("target_uid", str2);
        a2.put("is_anonym", String.valueOf(i));
        a2.put("anonym_name", str3);
        a2.put("anonym_avatar", str4);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/circle/mute?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put("size", str3);
        a2.put("circle_id", str);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/circle/members", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(String str, String str2, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        a2.put("reason", str2);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/users/circle/apply?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/users/circle?filter=admin&page=" + i, bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/hot/posting", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, int i, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("id", str);
        a2.put("result", i + "");
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/users/circle/notice", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("tid", str);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/circle/posts/top?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        a2.put("uid", str2);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/users/circle/invitation?http_method_override=PUT", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void b(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        a2.put("cover", str2);
        a2.put("description", str3);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/circles", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void b(String str, BluedUIHttpResponse bluedUIHttpResponse, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/users/circle?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void b(String str, BluedUIHttpResponse bluedUIHttpResponse, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(WBPageConstants.ParamKey.PAGE, str2);
        a2.put("size", str3);
        a2.put("circle_id", str);
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/circle/mute", bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, int i) {
        HttpManager.a(CommunityHttpUtils.a() + "/ticktocks/circles?page=" + i, bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("posting_id", str);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/circle/posts/essence", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void c(BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        a2.put("allow_join", str2);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/circles", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void c(String str, BluedUIHttpResponse bluedUIHttpResponse, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        a2.put("uid", str2);
        a2.put(BatteryManager.EXTRA_LEVEL, str3);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/circle/members/setup", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void d(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("posting_id", str);
        HttpManager.b(CommunityHttpUtils.a() + "/ticktocks/circle/posts/essence?http_method_override=DELETE", bluedUIHttpResponse, iRequestHost).a(BluedHttpTools.a(a2)).b(BluedHttpTools.a(true)).h();
    }

    public static void e(BluedUIHttpResponse bluedUIHttpResponse, String str, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("circle_id", str);
        HttpManager.a(CommunityHttpUtils.a(a2, CommunityHttpUtils.a() + "/ticktocks/circles/bubble"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }
}
