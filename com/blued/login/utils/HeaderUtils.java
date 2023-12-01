package com.blued.login.utils;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.track.trackUtils.EventTrackUtils;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/utils/HeaderUtils.class */
public class HeaderUtils {
    private HeaderUtils() {
    }

    private static void a(BluedUIHttpResponse bluedUIHttpResponse) {
        HttpManager.a(BluedHttpUrl.q() + "/blued/qiniu?filter=token&action=avatar", bluedUIHttpResponse).b(BluedHttpTools.a(true)).h();
    }

    public static void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.v("HeaderUtils", "localImagePath=" + str);
        a(new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.blued.login.utils.HeaderUtils.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                final BluedAlbum bluedAlbum = (BluedAlbum) bluedEntityA.data.get(0);
                ThreadManager.a().a(new ThreadExecutor("uploadQiNiuForRegHead") { // from class: com.blued.login.utils.HeaderUtils.1.1
                    public void execute() {
                        HeaderUtils.b(str, bluedAlbum);
                    }
                });
            }
        });
    }

    private static void a(String str, String str2, String str3, BluedUIHttpResponse bluedUIHttpResponse) {
        Map a2 = BluedHttpTools.a();
        a2.put("avatar", str2);
        a2.put("pid", str3);
        HttpManager.b(BluedHttpUrl.q() + "/users/" + str + "/avatar?http_method_override=PUT", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, BluedAlbum bluedAlbum) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.login.utils.HeaderUtils.2
            public void a(String str2) {
            }

            public void a(String str2, double d) {
            }

            public void a(final String str2, String str3) {
                ThreadManager.a().a(new ThreadExecutor("synServerForRegHead") { // from class: com.blued.login.utils.HeaderUtils.2.1
                    public void execute() {
                        HeaderUtils.b(str2, UserInfo.getInstance().getLoginUserInfo().getUid());
                    }
                });
            }

            public boolean a() {
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final String str, String str2) {
        a(str2, str, "", new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.blued.login.utils.HeaderUtils.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                UserInfo.getInstance().getLoginUserInfo().setAvatar(str);
                HeaderUtils.b();
            }
        });
    }
}
