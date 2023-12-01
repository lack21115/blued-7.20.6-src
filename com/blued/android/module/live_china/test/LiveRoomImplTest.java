package com.blued.android.module.live_china.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChatBadgeModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveRelationModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/test/LiveRoomImplTest.class */
public final class LiveRoomImplTest {
    public static final Companion a = new Companion(null);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/test/LiveRoomImplTest$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            if (LiveRoomInfo.b()) {
                return;
            }
            Log.i("==xpm==", "setFlashChatCallBack");
            LiveRoomInfo.a().a(b());
        }

        public final ILiveRoomInfoCallBack b() {
            return new ILiveRoomInfoCallBack() { // from class: com.blued.android.module.live_china.test.LiveRoomImplTest$Companion$getFlashChatCallBack$1
                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String A() {
                    return "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String B() {
                    return "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String C() {
                    return "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String D() {
                    return "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public Activity E() {
                    return null;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void F() {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public CharSequence a(CharSequence content, String str, LiveRoomConstants.ClickAtLinkListener callBask) {
                    Intrinsics.e(content, "content");
                    Intrinsics.e(callBask, "callBask");
                    return "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String a() {
                    return UserInfo.getInstance().getLoginUserInfo().getName();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String a(Context context, TextView textView, String str) {
                    String str2 = str;
                    if (str == null) {
                        str2 = "";
                    }
                    return str2;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String a(String str) {
                    String str2 = str;
                    if (str == null) {
                        str2 = "";
                    }
                    return str2;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String a(String str, boolean z) {
                    String str2 = str;
                    if (str == null) {
                        str2 = "";
                    }
                    return str2;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(double d) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(int i) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Activity activity) {
                    Intrinsics.e(activity, "activity");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context) {
                    Intrinsics.e(context, "context");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, int i) {
                    Intrinsics.e(context, "context");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, TextView tvCity, int i, int i2) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(tvCity, "tvCity");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context mContext, TextView tvName, LiveRoomUserModel mData, int i) {
                    Intrinsics.e(mContext, "mContext");
                    Intrinsics.e(tvName, "tvName");
                    Intrinsics.e(mData, "mData");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, FragmentManager fragment, int i, int i2, String details) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(fragment, "fragment");
                    Intrinsics.e(details, "details");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, FragmentManager fragment, int i, LiveChargeCouponModel model) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(fragment, "fragment");
                    Intrinsics.e(model, "model");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, PayOption._pay_list item, String str) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(item, "item");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, IRequestHost fragmentActive) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(iAddOrRemoveAttentionDone, "iAddOrRemoveAttentionDone");
                    Intrinsics.e(fragmentActive, "fragmentActive");
                    Map<String, String> a = BluedHttpTools.a();
                    String str3 = BluedHttpUrl.q() + "/users/" + ((Object) UserInfo.getInstance().getLoginUserInfo().getUid()) + "/followed/" + ((Object) str);
                    String str4 = str3;
                    if (!TextUtils.isEmpty(str2)) {
                        str4 = str3 + "?from=" + ((Object) str2);
                    }
                    HttpManager.b(str4, null, fragmentActive).b(BluedHttpTools.a(true)).a(a).h();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, final LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, final String str2, String str3, final IRequestHost fragmentActive, boolean z) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(iAddOrRemoveAttentionDone, "iAddOrRemoveAttentionDone");
                    Intrinsics.e(fragmentActive, "fragmentActive");
                    LiveRoomManager.a(str2, new BluedUIHttpResponse<BluedEntityA<LiveRelationModel>>(str2, iAddOrRemoveAttentionDone) { // from class: com.blued.android.module.live_china.test.LiveRoomImplTest$Companion$getFlashChatCallBack$1$addOrRemoveAttention$1
                        final /* synthetic */ String b;
                        final /* synthetic */ LiveUserRelationshipUtils.IAddOrRemoveAttentionDone c;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(IRequestHost.this);
                            this.b = str2;
                            this.c = iAddOrRemoveAttentionDone;
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<LiveRelationModel> bluedEntityA) {
                            if (getData() != null) {
                                Intrinsics.a(bluedEntityA);
                                if (bluedEntityA.data != null) {
                                    List<LiveRelationModel> list = bluedEntityA.data;
                                    Intrinsics.a(list);
                                    if (list.size() > 0) {
                                        List<LiveRelationModel> list2 = bluedEntityA.data;
                                        Intrinsics.a(list2);
                                        String relationship = list2.get(0).getRelationship();
                                        if (TextUtils.equals("3", this.b) || TextUtils.equals("1", this.b)) {
                                            LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = this.c;
                                            if (iAddOrRemoveAttentionDone2 != null) {
                                                iAddOrRemoveAttentionDone2.b(relationship);
                                                return;
                                            }
                                            return;
                                        }
                                        LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone3 = this.c;
                                        if (iAddOrRemoveAttentionDone3 != null) {
                                            iAddOrRemoveAttentionDone3.a(relationship);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIFinish() {
                        }
                    }, str, "live_", fragmentActive);
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, LiveRoomData liveRoomData) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, LiveRoomData liveRoomData, int i, List<LiveRoomData> list, Bundle bundle) {
                    PlayingOnliveFragment.a(context, liveRoomData, i, list, bundle);
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context mContext, LiveRoomData liveRoomData, String str, String str2, String str3, String str4, Bitmap bitmap) {
                    Intrinsics.e(mContext, "mContext");
                    Intrinsics.e(liveRoomData, "liveRoomData");
                    Intrinsics.e(bitmap, "bitmap");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, LiveTwoFloorModel liveTwoFloorModel) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, String str) {
                    Intrinsics.e(context, "context");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, String str, TextView textView, ImageView imageView, boolean z) {
                    Intrinsics.e(context, "context");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, String str, String str2, long j, IRequestHost fragmentActive) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(fragmentActive, "fragmentActive");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, String str, String str2, String str3, int i, int i2) {
                    Intrinsics.e(context, "context");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Context context, boolean z, LiveRoomData liveRoomData, Bitmap headerBitmap, String str) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(liveRoomData, "liveRoomData");
                    Intrinsics.e(headerBitmap, "headerBitmap");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Bitmap bitmap, long j, Context mContext, KeyboardListenLinearLayout keyboardLayout) {
                    Intrinsics.e(bitmap, "bitmap");
                    Intrinsics.e(mContext, "mContext");
                    Intrinsics.e(keyboardLayout, "keyboardLayout");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(EditText editText, String str, String str2) {
                    Intrinsics.e(editText, "editText");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(ImageView img_verify, int i) {
                    Intrinsics.e(img_verify, "img_verify");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(ImageView imgVIPIcon, LiveRoomUserModel mData) {
                    Intrinsics.e(imgVIPIcon, "imgVIPIcon");
                    Intrinsics.e(mData, "mData");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Fragment fragment) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Fragment fragment, float f, int i) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Fragment fragment, int i) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Fragment fragment, boolean z) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(Fragment fragment, boolean z, String str, int i) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(BaseFragment fragment, String str, String str2, int i) {
                    Intrinsics.e(fragment, "fragment");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(PermissionCallbacks permissionCallbacks) {
                    Intrinsics.e(permissionCallbacks, "permissionCallbacks");
                    permissionCallbacks.U_();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(RecordingOnliveFragment mFragment, int i, int i2, String str, String[] choosed_uids) {
                    Intrinsics.e(mFragment, "mFragment");
                    Intrinsics.e(choosed_uids, "choosed_uids");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(LiveChatBadgeModel model) {
                    int intValue;
                    int intValue2;
                    Intrinsics.e(model, "model");
                    UserInfo.getInstance().getLoginUserInfo().chat_badge_url = model.getChat_badge_url();
                    BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
                    if (model.getChat_badge_length() == null) {
                        intValue = 0;
                    } else {
                        Integer chat_badge_length = model.getChat_badge_length();
                        Intrinsics.a(chat_badge_length);
                        intValue = chat_badge_length.intValue();
                    }
                    loginUserInfo.chat_badge_length = intValue;
                    BluedLoginResult loginUserInfo2 = UserInfo.getInstance().getLoginUserInfo();
                    if (model.getChat_badge_height() == null) {
                        intValue2 = 0;
                    } else {
                        Integer chat_badge_height = model.getChat_badge_height();
                        Intrinsics.a(chat_badge_height);
                        intValue2 = chat_badge_height.intValue();
                    }
                    loginUserInfo2.chat_badge_height = intValue2;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(LiveChattingModel liveChattingModel, boolean z) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(String str, int i) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(String str, String str2, String str3) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(String str, boolean z, IRequestHost fragmentActive) {
                    Intrinsics.e(fragmentActive, "fragmentActive");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void a(String[] strArr) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public boolean a(Context context, View.OnClickListener onClickListener) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(onClickListener, "onClickListener");
                    return false;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String b() {
                    return UserInfo.getInstance().getLoginUserInfo().avatar;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String b(String str, boolean z) {
                    String str2 = str;
                    if (str == null) {
                        str2 = "";
                    }
                    return str2;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void b(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, IRequestHost fragmentActive) {
                    Intrinsics.e(context, "context");
                    Intrinsics.e(iAddOrRemoveAttentionDone, "iAddOrRemoveAttentionDone");
                    Intrinsics.e(fragmentActive, "fragmentActive");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void b(Context context, String str) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public boolean b(Context appContext) {
                    Intrinsics.e(appContext, "appContext");
                    return true;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public boolean b(String str) {
                    return false;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String c() {
                    return UserInfo.getInstance().getLoginResultFromDB() != null ? UserInfo.getInstance().getLoginResultFromDB().avatar : "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void c(Context context) {
                    Intrinsics.e(context, "context");
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void c(Context context, String str) {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String d() {
                    return UserInfo.getInstance().getLoginUserInfo().uid;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String d(Context context, String str) {
                    Intrinsics.e(context, "context");
                    String str2 = str;
                    if (str == null) {
                        str2 = "";
                    }
                    return str2;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public boolean e() {
                    return false;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String f() {
                    return UserInfo.getInstance().getLoginUserInfo().getAccess_token();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public int g() {
                    return UserInfo.getInstance().getLoginUserInfo().getRich_level();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public LiveChatBadgeModel h() {
                    LiveChatBadgeModel liveChatBadgeModel = new LiveChatBadgeModel();
                    liveChatBadgeModel.setChat_badge_url(UserInfo.getInstance().getLoginUserInfo().chat_badge_url);
                    liveChatBadgeModel.setChat_badge_length(Integer.valueOf(UserInfo.getInstance().getLoginUserInfo().chat_badge_length));
                    liveChatBadgeModel.setChat_badge_height(Integer.valueOf(UserInfo.getInstance().getLoginUserInfo().chat_badge_height));
                    return liveChatBadgeModel;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public boolean i() {
                    return false;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public int j() {
                    return UserInfo.getInstance().getLoginUserInfo().getVBadge();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public boolean k() {
                    return BluedHttpUrl.h();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String l() {
                    return BluedHttpUrl.q();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String m() {
                    return BluedHttpUrl.A();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String n() {
                    return NetworkUtils.d();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String o() {
                    return "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String p() {
                    return BluedHttpUrl.r();
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public BluedLoginResult q() {
                    BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
                    Intrinsics.c(loginUserInfo, "getInstance().loginUserInfo");
                    return loginUserInfo;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public boolean r() {
                    return false;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public void s() {
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public boolean t() {
                    return true;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public boolean u() {
                    return false;
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String v() {
                    return "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String w() {
                    return "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String x() {
                    return "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String y() {
                    return "";
                }

                @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
                public String z() {
                    return "";
                }
            };
        }
    }
}
