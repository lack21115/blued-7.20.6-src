package com.blued.community.http;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.utils.UserInfoUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/http/CommunityHttpUtils.class */
public class CommunityHttpUtils {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/http/CommunityHttpUtils$IAddOrRemoveAttentionDone.class */
    public interface IAddOrRemoveAttentionDone {
        void a();

        void a(String str);

        void b();

        void b(String str);

        void c();
    }

    public static String a() {
        return !TextUtils.isEmpty(BluedHttpUrl.q()) ? BluedHttpUrl.q() : "http://dev-argo.blued.cn";
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = str;
        if (map != null) {
            str2 = str;
            if (map.size() > 0) {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, String> next = it.next();
                    if (str.contains("?")) {
                        str = str + "&" + ((Object) next.getKey()) + "=" + ((Object) next.getValue());
                    } else {
                        str = str + "?" + ((Object) next.getKey()) + "=" + ((Object) next.getValue());
                    }
                }
            }
        }
        return str2;
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(a() + "/blued/qiniu?filter=token&action=ticktocks", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    private static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        String str4 = a() + "/users/" + str + "/followed/" + str2;
        String str5 = str4;
        if (!TextUtils.isEmpty(str3)) {
            str5 = str4 + "?from=" + str3;
        }
        HttpManager.b(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, final IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, final String str, String str2, IRequestHost iRequestHost) {
        b(context, new BluedUIHttpResponse<BluedEntityA<UserBasicModel>>(iRequestHost) { // from class: com.blued.community.http.CommunityHttpUtils.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserBasicModel> bluedEntityA) {
                int i = 0;
                String str3 = bluedEntityA.data.get(0).relationship;
                if ("1".equals(str3) || "3".equals(str3)) {
                    i = 1;
                }
                try {
                    CommunityServiceManager.e().a(Long.valueOf(str), i);
                } catch (Exception e) {
                }
                iAddOrRemoveAttentionDone.b(str3);
                bluedEntityA.getSingleData().uid = str;
                LiveEventBus.get("feed_relation_ship").post(bluedEntityA.getSingleData());
                LiveEventBus.get("common_clear_group_member_state").post(str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                iAddOrRemoveAttentionDone.b();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                iAddOrRemoveAttentionDone.a();
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), str, str2, iRequestHost);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = str;
        if (str.contains("__CONN_TYPE__")) {
            str2 = str.replace("__CONN_TYPE__", NetworkUtils.d());
        }
        if (UserInfoUtils.f()) {
            HttpManager.a(str2, null).b(BluedHttpTools.a(true)).h();
        } else {
            HttpManager.a(str2, null).b(BluedHttpTools.a(false)).h();
        }
    }

    public static void a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            a(strArr[i2]);
            i = i2 + 1;
        }
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(a() + "/blued/qiniu?filter=token&action=videos&ops=ticktocks", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    private static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str, String str2, String str3, IRequestHost iRequestHost) {
        Map<String, String> a2 = BluedHttpTools.a();
        String str4 = a() + "/users/" + str + "/followed/" + str2 + "?http_method_override=DELETE";
        String str5 = str4;
        if (!TextUtils.isEmpty(str3)) {
            str5 = str4 + "&from=" + str3;
        }
        HttpManager.b(str5, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(Context context, final IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, final String str, String str2, IRequestHost iRequestHost) {
        a(context, new BluedUIHttpResponse<BluedEntityA<UserBasicModel>>(iRequestHost) { // from class: com.blued.community.http.CommunityHttpUtils.2

            /* renamed from: a  reason: collision with root package name */
            boolean f19077a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserBasicModel> bluedEntityA) {
                int i = 0;
                String str3 = bluedEntityA.data.get(0).relationship;
                if ("1".equals(str3) || "3".equals(str3)) {
                    i = 1;
                }
                try {
                    CommunityServiceManager.e().a(Long.valueOf(str), i);
                } catch (Exception e) {
                }
                IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    iAddOrRemoveAttentionDone2.a(str3);
                }
                bluedEntityA.getSingleData().uid = str;
                LiveEventBus.get("feed_relation_ship").post(bluedEntityA.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str3) {
                this.f19077a = true;
                return super.onUIFailure(i, str3);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    if (this.f19077a) {
                        iAddOrRemoveAttentionDone2.c();
                    } else {
                        iAddOrRemoveAttentionDone2.b();
                    }
                }
                this.f19077a = false;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    iAddOrRemoveAttentionDone2.a();
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), str, str2, iRequestHost);
    }
}
