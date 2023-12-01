package com.blued.community.http;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.internal.util.cm.QSConstants;
import com.anythink.core.api.ATAdConst;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.ui.event.model.EventPostModel;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/http/EventHttpUtils.class */
public final class EventHttpUtils {
    public static final EventHttpUtils a = new EventHttpUtils();

    private EventHttpUtils() {
    }

    @JvmStatic
    public static final void a(BluedUIHttpResponse<?> ajaxCallBack, EventPostModel model) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(model, "model");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("uid", UserInfo.getInstance().getLoginUserInfo().uid);
        ajaxParams.put("pic", model.pic);
        ajaxParams.put("name", model.name);
        ajaxParams.put("description", model.description);
        ajaxParams.put("activity_date", String.valueOf(model.activity_date));
        ajaxParams.put("mode_id", String.valueOf(model.mode_id));
        ajaxParams.put("type_id", model.type_id);
        ajaxParams.put("quota_num", String.valueOf(model.quota_num));
        if (model.mode_id == 1) {
            ajaxParams.put(DistrictSearchQuery.KEYWORDS_CITY, model.city);
            ajaxParams.put(QSConstants.TILE_LOCATION, model.location);
            ajaxParams.put("location_detail", model.location_detail);
            if (!TextUtils.isEmpty(model.longitude)) {
                ajaxParams.put("longitude", model.longitude);
            }
            if (!TextUtils.isEmpty(model.latitude)) {
                ajaxParams.put("latitude", model.latitude);
            }
            ajaxParams.put("is_customize", String.valueOf(model.is_customize));
        } else if (model.mode_id == 2) {
            ajaxParams.put("online_url", model.online_url);
            ajaxParams.put("online_text", model.online_text);
        }
        ajaxParams.put("is_free", String.valueOf(model.is_free));
        ajaxParams.put("scene_images", model.localSceneImg);
        HttpManager.b(Intrinsics.a(CommunityHttpUtils.a(), (Object) "/users/activity"), ajaxCallBack, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(ajaxParams)).h();
    }

    @JvmStatic
    public static final void c(BluedUIHttpResponse<?> ajaxCallBack, String uid, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(uid, "uid");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        String a2 = Intrinsics.a(BluedHttpUrl.q(), (Object) "/users/activity/subscribe?filter=set");
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("target_uid", uid);
        HttpManager.b(a2, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(ajaxParams)).h();
    }

    @JvmStatic
    public static final void d(BluedUIHttpResponse<?> ajaxCallBack, String uid, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(uid, "uid");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        String a2 = Intrinsics.a(BluedHttpUrl.q(), (Object) "/users/activity/subscribe?filter=del");
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("target_uid", uid);
        HttpManager.b(a2, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(ajaxParams)).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, int i, int i2, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        String a2 = Intrinsics.a(CommunityHttpUtils.a(), (Object) "/users/activity/subscribe?filter=get");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("page", String.valueOf(i));
        ajaxParams.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, String.valueOf(i2));
        HttpManager.a(a2, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(ajaxParams).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, int i, String filter, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(filter, "filter");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("page", String.valueOf(i));
        ajaxParams.put("filter", filter);
        HttpManager.a(Intrinsics.a(CommunityHttpUtils.a(), (Object) "/users/activity"), ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(ajaxParams).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, int i, String latitude, String longitude, String city_latitude, String city_longitude, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(latitude, "latitude");
        Intrinsics.e(longitude, "longitude");
        Intrinsics.e(city_latitude, "city_latitude");
        Intrinsics.e(city_longitude, "city_longitude");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("page", String.valueOf(i));
        ajaxParams.put("latitude", latitude);
        ajaxParams.put("longitude", longitude);
        if (TextUtils.isEmpty(city_latitude) || TextUtils.isEmpty(city_longitude)) {
            ajaxParams.put("city_latitude", latitude);
            ajaxParams.put("city_longitude", longitude);
        } else {
            ajaxParams.put("city_latitude", city_latitude);
            ajaxParams.put("city_longitude", city_longitude);
        }
        HttpManager.a(Intrinsics.a(CommunityHttpUtils.a(), (Object) "/users/activity/list"), ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(ajaxParams).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        HttpManager.a(Intrinsics.a(CommunityHttpUtils.a(), (Object) "/users/activity/type_list"), ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, String eventId, int i, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(eventId, "eventId");
        HttpManager.a(CommunityHttpUtils.a() + "/users/activity/audit/" + eventId + "?filter=wait&page=" + i, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, String eventId, int i, String evaluateId, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(eventId, "eventId");
        Intrinsics.e(evaluateId, "evaluateId");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("score", String.valueOf(i));
        String str = evaluateId;
        if (evaluateId.length() > 0) {
            String substring = evaluateId.substring(evaluateId.length() - 1, evaluateId.length());
            Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            str = evaluateId;
            if (substring.equals(",")) {
                str = evaluateId.substring(0, evaluateId.length() - 1);
                Intrinsics.c(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
        }
        ajaxParams.put("quick_evaluate_id", str);
        HttpManager.b(CommunityHttpUtils.a() + "/users/activity/evaluate/" + eventId, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(ajaxParams)).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, String eventId, int i, String latitude, String longitude, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(eventId, "eventId");
        Intrinsics.e(latitude, "latitude");
        Intrinsics.e(longitude, "longitude");
        HttpManager.a(CommunityHttpUtils.a() + "/users/activity/join/" + eventId + "?latitude=" + latitude + "&longitude=" + longitude + "&page=" + i, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, String eventId, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(eventId, "eventId");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("activity_id", eventId);
        HttpManager.b(CommunityHttpUtils.a() + "/users/activity/join/" + eventId, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, String str, String str2, int i, int i2, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        String a2 = Intrinsics.a(CommunityHttpUtils.a(), (Object) "/ticktocks/activity/feed");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        if (str != null) {
            Intrinsics.c(ajaxParams, "ajaxParams");
            ajaxParams.put("activity_id", str);
        }
        if (str2 != null) {
            Intrinsics.c(ajaxParams, "ajaxParams");
            ajaxParams.put("activity_uid", str2);
        }
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("page", String.valueOf(i));
        ajaxParams.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, String.valueOf(i2));
        HttpManager.a(a2, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(ajaxParams).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, String str, String str2, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        if (str != null) {
            Intrinsics.c(ajaxParams, "ajaxParams");
            ajaxParams.put("uid", str);
        }
        if (str2 != null) {
            Intrinsics.c(ajaxParams, "ajaxParams");
            ajaxParams.put("activity_id", str2);
        }
        HttpManager.a(Intrinsics.a(CommunityHttpUtils.a(), (Object) "/users/activity/user_info"), ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(ajaxParams).h();
    }

    public final void a(BluedUIHttpResponse<?> ajaxCallBack, String eventId, String latitude, String longitude, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(eventId, "eventId");
        Intrinsics.e(latitude, "latitude");
        Intrinsics.e(longitude, "longitude");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("latitude", latitude);
        ajaxParams.put("longitude", longitude);
        HttpManager.a(CommunityHttpUtils.a() + "/users/activity/" + eventId + "/info", ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(ajaxParams).h();
    }

    public final void b(BluedUIHttpResponse<?> ajaxCallBack, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        HttpManager.a(Intrinsics.a(CommunityHttpUtils.a(), (Object) "/users/activity/identify"), ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public final void b(BluedUIHttpResponse<?> ajaxCallBack, String eventId, int i, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(eventId, "eventId");
        HttpManager.a(CommunityHttpUtils.a() + "/users/activity/audit/" + eventId + "?filter=pass&page=" + i, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    public final void b(BluedUIHttpResponse<?> ajaxCallBack, String eventId, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(eventId, "eventId");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("activity_id", eventId);
        HttpManager.b(CommunityHttpUtils.a() + "/users/activity/withdraw/" + eventId, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(ajaxParams)).h();
    }

    public final void b(BluedUIHttpResponse<?> ajaxCallBack, String activity_id, String content, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(activity_id, "activity_id");
        Intrinsics.e(content, "content");
        Map<String, String> jsonParams = BluedHttpTools.a();
        Intrinsics.c(jsonParams, "jsonParams");
        jsonParams.put("sign_content", content);
        HttpManager.b(CommunityHttpUtils.a() + "/users/activity/sign_in?&activity_id=" + activity_id, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(jsonParams)).h();
    }

    public final void b(BluedUIHttpResponse<?> ajaxCallBack, String eventId, String latitude, String longitude, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(eventId, "eventId");
        Intrinsics.e(latitude, "latitude");
        Intrinsics.e(longitude, "longitude");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("latitude", latitude);
        ajaxParams.put("longitude", longitude);
        ajaxParams.put("activity_id", eventId);
        HttpManager.a(Intrinsics.a(CommunityHttpUtils.a(), (Object) "/users/activity/recommend"), ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(ajaxParams).h();
    }

    public final void c(BluedUIHttpResponse<?> ajaxCallBack, String eventId, String joiner_uid, String status, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(eventId, "eventId");
        Intrinsics.e(joiner_uid, "joiner_uid");
        Intrinsics.e(status, "status");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("activity_id", eventId);
        ajaxParams.put("joiner_uid", joiner_uid);
        ajaxParams.put("status", status);
        HttpManager.b(CommunityHttpUtils.a() + "/users/activity/audit/" + eventId, ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(ajaxParams)).h();
    }

    @Deprecated
    public final void d(BluedUIHttpResponse<?> ajaxCallBack, String uid, String target_uid, String from, IRequestHost fragmentActive) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(from, "from");
        Intrinsics.e(fragmentActive, "fragmentActive");
        Map<String, String> a2 = BluedHttpTools.a();
        String str = BluedHttpUrl.q() + "/users/" + uid + "/followed/" + target_uid;
        String str2 = str;
        if (!TextUtils.isEmpty(from)) {
            str2 = str + "?from=" + from;
        }
        HttpManager.b(str2, ajaxCallBack, fragmentActive).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public final void e(BluedUIHttpResponse<?> ajaxCallBack, String activity_id, IRequestHost iRequestHost) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(activity_id, "activity_id");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("longitude", CommunityServiceManager.c().e());
        ajaxParams.put("latitude", CommunityServiceManager.c().f());
        ajaxParams.put("activity_id", activity_id);
        HttpManager.a(Intrinsics.a(CommunityHttpUtils.a(), (Object) "/users/activity/sign_in"), ajaxCallBack, iRequestHost).b(BluedHttpTools.a(true)).a(ajaxParams).h();
    }

    @Deprecated
    public final void e(BluedUIHttpResponse<?> ajaxCallBack, String uid, String target_uid, String from, IRequestHost fragmentActive) {
        Intrinsics.e(ajaxCallBack, "ajaxCallBack");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(from, "from");
        Intrinsics.e(fragmentActive, "fragmentActive");
        Map<String, String> a2 = BluedHttpTools.a();
        String str = BluedHttpUrl.q() + "/users/" + uid + "/followed/" + target_uid + "?http_method_override=DELETE";
        String str2 = str;
        if (!TextUtils.isEmpty(from)) {
            str2 = str + "&from=" + from;
        }
        HttpManager.b(str2, ajaxCallBack, fragmentActive).b(BluedHttpTools.a(true)).a(a2).h();
    }
}
