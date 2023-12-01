package com.blued.android.module.live_china.live_info;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveChatBadgeModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/live_info/ILiveRoomInfoCallBack.class */
public interface ILiveRoomInfoCallBack {
    String A();

    String B();

    String C();

    String D();

    Activity E();

    void F();

    CharSequence a(CharSequence charSequence, String str, LiveRoomConstants.ClickAtLinkListener clickAtLinkListener);

    String a();

    String a(Context context, TextView textView, String str);

    String a(String str);

    String a(String str, boolean z);

    void a(double d);

    void a(int i);

    void a(Activity activity);

    void a(Context context);

    void a(Context context, int i);

    void a(Context context, TextView textView, int i, int i2);

    void a(Context context, TextView textView, LiveRoomUserModel liveRoomUserModel, int i);

    void a(Context context, FragmentManager fragmentManager, int i, int i2, String str);

    void a(Context context, FragmentManager fragmentManager, int i, LiveChargeCouponModel liveChargeCouponModel);

    void a(Context context, PayOption._pay_list _pay_listVar, String str);

    void a(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, IRequestHost iRequestHost);

    void a(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, String str3, IRequestHost iRequestHost, boolean z);

    void a(Context context, LiveRoomData liveRoomData);

    void a(Context context, LiveRoomData liveRoomData, int i, List<LiveRoomData> list, Bundle bundle);

    void a(Context context, LiveRoomData liveRoomData, String str, String str2, String str3, String str4, Bitmap bitmap);

    void a(Context context, LiveTwoFloorModel liveTwoFloorModel);

    void a(Context context, String str);

    void a(Context context, String str, TextView textView, ImageView imageView, boolean z);

    void a(Context context, String str, String str2, long j, IRequestHost iRequestHost);

    void a(Context context, String str, String str2, String str3, int i, int i2);

    void a(Context context, boolean z, LiveRoomData liveRoomData, Bitmap bitmap, String str);

    void a(Bitmap bitmap, long j, Context context, KeyboardListenLinearLayout keyboardListenLinearLayout);

    void a(EditText editText, String str, String str2);

    void a(ImageView imageView, int i);

    void a(ImageView imageView, LiveRoomUserModel liveRoomUserModel);

    void a(Fragment fragment);

    void a(Fragment fragment, float f, int i);

    void a(Fragment fragment, int i);

    void a(Fragment fragment, boolean z);

    void a(Fragment fragment, boolean z, String str, int i);

    void a(BaseFragment baseFragment, String str, String str2, int i);

    void a(PermissionCallbacks permissionCallbacks);

    void a(RecordingOnliveFragment recordingOnliveFragment, int i, int i2, String str, String[] strArr);

    void a(LiveChatBadgeModel liveChatBadgeModel);

    void a(LiveChattingModel liveChattingModel, boolean z);

    void a(String str, int i);

    void a(String str, String str2, String str3);

    void a(String str, boolean z, IRequestHost iRequestHost);

    void a(String[] strArr);

    boolean a(Context context, View.OnClickListener onClickListener);

    String b();

    String b(String str, boolean z);

    void b(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, IRequestHost iRequestHost);

    void b(Context context, String str);

    boolean b(Context context);

    boolean b(String str);

    String c();

    void c(Context context);

    void c(Context context, String str);

    String d();

    String d(Context context, String str);

    boolean e();

    String f();

    int g();

    LiveChatBadgeModel h();

    boolean i();

    int j();

    boolean k();

    String l();

    String m();

    String n();

    String o();

    String p();

    BluedLoginResult q();

    boolean r();

    void s();

    boolean t();

    boolean u();

    String v();

    String w();

    String x();

    String y();

    String z();
}
