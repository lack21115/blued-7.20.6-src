package com.blued.android.module.yy_china.test;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.url.ActivityUrl;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ClickAtLinkListener;
import com.blued.android.module.yy_china.listener.YYIVIPBuyResultObserver;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYRoomInfoLocalChannel.class */
public final class YYRoomInfoLocalChannel {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17808a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYRoomInfoLocalChannel$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final IYYRoomInfoCallback b(final Application application) {
            return new IYYRoomInfoCallback() { // from class: com.blued.android.module.yy_china.test.YYRoomInfoLocalChannel$Companion$getYYRoomInfoCallback$1
                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public CharSequence a(CharSequence charSequence, String str, ClickAtLinkListener clickAtLinkListener) {
                    CharSequence a2 = YYStringUtils.a(charSequence, str, clickAtLinkListener);
                    Intrinsics.c(a2, "parseYYAtUserLinkYY(content, color, callBask)");
                    return a2;
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public Object a(YYIVIPBuyResultObserver observer) {
                    Intrinsics.e(observer, "observer");
                    ToastUtils.a("单模块，不支持充值");
                    return observer;
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public String a() {
                    String name = UserInfo.getInstance().getLoginUserInfo().getName();
                    Intrinsics.c(name, "getInstance().loginUserInfo.getName()");
                    return name;
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public String a(int i) {
                    switch (i) {
                        case -1:
                            String a2 = H5Url.a(63);
                            Intrinsics.c(a2, "get(H5Url.YYCodeOfCOnductUrl)");
                            return a2;
                        case 0:
                        case 12:
                        default:
                            return "";
                        case 1:
                            String a3 = H5Url.a(76);
                            Intrinsics.c(a3, "get(H5Url.YYChatAnchorLevel)");
                            return a3;
                        case 2:
                            String a4 = ActivityUrl.a(2);
                            Intrinsics.c(a4, "get(ActivityUrl.YYRoomMagicGift)");
                            return a4;
                        case 3:
                            String a5 = H5Url.a(77);
                            Intrinsics.c(a5, "get(H5Url.YYChatPropCity)");
                            return a5;
                        case 4:
                            String a6 = H5Url.a(81);
                            Intrinsics.c(a6, "get(H5Url.YYChatKtvRank)");
                            return a6;
                        case 5:
                            String a7 = ActivityUrl.a(3);
                            Intrinsics.c(a7, "get(ActivityUrl.YYWeekStar)");
                            return a7;
                        case 6:
                            String a8 = H5Url.a(80);
                            Intrinsics.c(a8, "get(H5Url.YYChatPropCityMyself)");
                            return a8;
                        case 7:
                            String a9 = H5Url.a(78);
                            Intrinsics.c(a9, "get(H5Url.YYChatHonorLv)");
                            return a9;
                        case 8:
                            String a10 = H5Url.a(79);
                            Intrinsics.c(a10, "get(H5Url.YYChatAnchorLv)");
                            return a10;
                        case 9:
                            String a11 = H5Url.a(82);
                            Intrinsics.c(a11, "get(H5Url.YYTreasureChestIntro)");
                            return a11;
                        case 10:
                            String a12 = H5Url.a(62);
                            Intrinsics.c(a12, "get(H5Url.YYFirstCharge)");
                            return a12;
                        case 11:
                            String a13 = H5Url.a(61);
                            Intrinsics.c(a13, "get(H5Url.YYChatGiftWallHome)");
                            return a13;
                        case 13:
                            String a14 = H5Url.a(93);
                            Intrinsics.c(a14, "get(H5Url.YYChatCarIntroduction)");
                            return a14;
                        case 14:
                            String a15 = H5Url.a(94);
                            Intrinsics.c(a15, "get(H5Url.YYChatCarRecord)");
                            return a15;
                        case 15:
                            String a16 = H5Url.a(96);
                            Intrinsics.c(a16, "get(H5Url.YYChatRoomRule)");
                            return a16;
                        case 16:
                            String a17 = H5Url.a(97);
                            Intrinsics.c(a17, "get(H5Url.YYChatThemeEventRule)");
                            return a17;
                        case 17:
                            String a18 = H5Url.a(100);
                            Intrinsics.c(a18, "get(H5Url.YYChatROMANTIC)");
                            return a18;
                        case 18:
                            String a19 = H5Url.a(98);
                            Intrinsics.c(a19, "get(H5Url.YYChatNESTING)");
                            return a19;
                        case 19:
                            String a20 = H5Url.a(99);
                            Intrinsics.c(a20, "get(H5Url.YYChatLOVERULE)");
                            return a20;
                    }
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context) {
                    Intrinsics.e(context, "context");
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context, EditText editText, int i, int i2, String str, Map<String, String> map) {
                    YYCommonUtils.a(context, editText, i, i2, str, map);
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context, FragmentManager manager, YYRoomModel roomData, Bitmap headerBitmap, String shareText) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(manager, "manager");
                    Intrinsics.e(roomData, "roomData");
                    Intrinsics.e(headerBitmap, "headerBitmap");
                    Intrinsics.e(shareText, "shareText");
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context, String params) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(params, "params");
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context, String url, int i) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(url, "url");
                    ToastUtils.a("单模块，内部跳转");
                    LiveEventBus.get("event_yy_game").post(url);
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context, String url, int i, boolean z) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(url, "url");
                    ToastUtils.a("单模块，内部跳转");
                    LiveEventBus.get("event_yy_game").post(url);
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context, String str, String str2) {
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context, String uid, String from, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone followDone, IRequestHost fragmentActive) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(uid, "uid");
                    Intrinsics.e(from, "from");
                    Intrinsics.e(followDone, "followDone");
                    Intrinsics.e(fragmentActive, "fragmentActive");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context, String uid, String name, String avatar) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(uid, "uid");
                    Intrinsics.e(name, "name");
                    Intrinsics.e(avatar, "avatar");
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context, String uid, String name, String avatar, int i, int i2) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(uid, "uid");
                    Intrinsics.e(name, "name");
                    Intrinsics.e(avatar, "avatar");
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Context context, String id, String target_uid, String activity_id, String exchange_id, String from, String vipDetail, int i) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(id, "id");
                    Intrinsics.e(target_uid, "target_uid");
                    Intrinsics.e(activity_id, "activity_id");
                    Intrinsics.e(exchange_id, "exchange_id");
                    Intrinsics.e(from, "from");
                    Intrinsics.e(vipDetail, "vipDetail");
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(BaseFragment fragment) {
                    Intrinsics.e(fragment, "fragment");
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(BluedUIHttpResponse<?> bluedUIHttpResponse, ActivityFragmentActive fragmentActive, String beans) {
                    Intrinsics.e(fragmentActive, "fragmentActive");
                    Intrinsics.e(beans, "beans");
                    ToastUtils.a("单模块，不支持充值");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(BaseYYStudioFragment context, YYRoomModel roomData, Bitmap headerBitmap, String shareText) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(roomData, "roomData");
                    Intrinsics.e(headerBitmap, "headerBitmap");
                    Intrinsics.e(shareText, "shareText");
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(Object observer) {
                    Intrinsics.e(observer, "observer");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void a(String[] urls) {
                    Intrinsics.e(urls, "urls");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public boolean a(Context context, View.OnClickListener onClickListener) {
                    Intrinsics.e(context, "context");
                    return false;
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public String b() {
                    String str = UserInfo.getInstance().getLoginUserInfo().avatar;
                    Intrinsics.c(str, "getInstance().loginUserInfo.avatar");
                    return str;
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void b(Context mContext) {
                    Intrinsics.e(mContext, "mContext");
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void b(Context context, String uid, String from, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone followDone, IRequestHost fragmentActive) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(uid, "uid");
                    Intrinsics.e(from, "from");
                    Intrinsics.e(followDone, "followDone");
                    Intrinsics.e(fragmentActive, "fragmentActive");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public String c() {
                    String uid = UserInfo.getInstance().getLoginUserInfo().getUid();
                    Intrinsics.c(uid, "getInstance().loginUserInfo.getUid()");
                    return uid;
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public void c(Context context) {
                    Intrinsics.e(context, "context");
                    ToastUtils.a("单模块，无法跳转");
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public boolean d() {
                    return BluedHttpUrl.h();
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public String e() {
                    String q = BluedHttpUrl.q();
                    Intrinsics.c(q, "getHttpHost()");
                    return q;
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public String f() {
                    String r = BluedHttpUrl.r();
                    Intrinsics.c(r, "getPayHost()");
                    return r;
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public Application g() {
                    return Application.this;
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public String h() {
                    return "https://www.blued.cn/live/agreement";
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public String i() {
                    return "";
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public String j() {
                    return "119";
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public boolean k() {
                    return true;
                }

                @Override // com.blued.android.module.yy_china.IYYRoomInfoCallback
                public boolean l() {
                    return false;
                }
            };
        }

        public final void a(Application app) {
            Intrinsics.e(app, "app");
            if (YYRoomInfoManager.e().a()) {
                return;
            }
            YYRoomInfoManager.e().a(b(app));
        }
    }
}
