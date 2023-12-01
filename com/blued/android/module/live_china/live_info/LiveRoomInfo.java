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
import com.blued.android.module.common.utils.CommonStringUtils;
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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/live_info/LiveRoomInfo.class */
public class LiveRoomInfo {

    /* renamed from: a  reason: collision with root package name */
    public static LiveRoomInfo f13565a;
    private ILiveRoomInfoCallBack b;

    public static LiveRoomInfo a() {
        if (f13565a == null) {
            f13565a = new LiveRoomInfo();
        }
        return f13565a;
    }

    public static boolean b() {
        LiveRoomInfo liveRoomInfo = f13565a;
        return (liveRoomInfo == null || liveRoomInfo.b == null) ? false : true;
    }

    public String A() {
        return this.b.x();
    }

    public String B() {
        return this.b.y();
    }

    public String C() {
        return this.b.z();
    }

    public String D() {
        return this.b.A();
    }

    public String E() {
        return this.b.B();
    }

    public String F() {
        return this.b.C();
    }

    public String G() {
        return this.b.D();
    }

    public Activity H() {
        return this.b.E();
    }

    public void I() {
        this.b.F();
    }

    public CharSequence a(CharSequence charSequence, String str, LiveRoomConstants.ClickAtLinkListener clickAtLinkListener) {
        return this.b.a(charSequence, str, clickAtLinkListener);
    }

    public String a(Context context, TextView textView, String str) {
        return this.b.a(context, textView, str);
    }

    public String a(String str) {
        return this.b.a(str);
    }

    public String a(String str, boolean z) {
        return this.b.a(str, z);
    }

    public void a(double d) {
        this.b.a(d);
    }

    public void a(int i) {
        this.b.a(i);
    }

    public void a(Activity activity) {
        this.b.a(activity);
    }

    public void a(Context context) {
        this.b.a(context);
    }

    public void a(Context context, int i) {
        this.b.a(context, i);
    }

    public void a(Context context, TextView textView, int i, int i2) {
        this.b.a(context, textView, i, i2);
    }

    public void a(Context context, TextView textView, LiveRoomUserModel liveRoomUserModel, int i) {
        this.b.a(context, textView, liveRoomUserModel, i);
    }

    public void a(Context context, FragmentManager fragmentManager, int i) {
        a(context, fragmentManager, i, 0, "");
    }

    public void a(Context context, FragmentManager fragmentManager, int i, int i2) {
        this.b.a(context, fragmentManager, i, i2, "");
    }

    public void a(Context context, FragmentManager fragmentManager, int i, int i2, String str) {
        this.b.a(context, fragmentManager, i, i2, str);
    }

    public void a(Context context, FragmentManager fragmentManager, int i, LiveChargeCouponModel liveChargeCouponModel) {
        this.b.a(context, fragmentManager, i, liveChargeCouponModel);
    }

    public void a(Context context, FragmentManager fragmentManager, int i, String str) {
        a(context, fragmentManager, i, 0, str);
    }

    public void a(Context context, PayOption._pay_list _pay_listVar, String str) {
        this.b.a(context, _pay_listVar, str);
    }

    public void a(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, IRequestHost iRequestHost) {
        this.b.a(context, iAddOrRemoveAttentionDone, str, str2, iRequestHost);
    }

    public void a(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, String str3, IRequestHost iRequestHost, boolean z) {
        this.b.a(context, iAddOrRemoveAttentionDone, str, str2, str3, iRequestHost, z);
    }

    public void a(Context context, LiveRoomData liveRoomData) {
        this.b.a(context, liveRoomData);
    }

    public void a(Context context, LiveRoomData liveRoomData, int i, List<LiveRoomData> list, Bundle bundle) {
        this.b.a(context, liveRoomData, i, list, bundle);
    }

    public void a(Context context, LiveRoomData liveRoomData, String str, String str2, String str3, String str4, Bitmap bitmap) {
        this.b.a(context, liveRoomData, str, str2, str3, str4, bitmap);
    }

    public void a(Context context, LiveTwoFloorModel liveTwoFloorModel) {
        this.b.a(context, liveTwoFloorModel);
    }

    public void a(Context context, String str) {
        this.b.a(context, str);
    }

    public void a(Context context, String str, TextView textView, ImageView imageView, boolean z) {
        this.b.a(context, str, textView, imageView, z);
    }

    public void a(Context context, String str, String str2, long j, IRequestHost iRequestHost) {
        this.b.a(context, str, str2, j, iRequestHost);
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2) {
        this.b.a(context, str, str2, str3, i, i2);
    }

    public void a(Context context, boolean z, LiveRoomData liveRoomData, Bitmap bitmap, String str) {
        this.b.a(context, z, liveRoomData, bitmap, str);
    }

    public void a(Bitmap bitmap, long j, Context context, KeyboardListenLinearLayout keyboardListenLinearLayout) {
        this.b.a(bitmap, j, context, keyboardListenLinearLayout);
    }

    public void a(EditText editText, String str, String str2) {
        this.b.a(editText, str, str2);
    }

    public void a(ImageView imageView, int i) {
        this.b.a(imageView, i);
    }

    public void a(ImageView imageView, LiveRoomUserModel liveRoomUserModel) {
        this.b.a(imageView, liveRoomUserModel);
    }

    public void a(Fragment fragment) {
        this.b.a(fragment);
    }

    public void a(Fragment fragment, float f, int i) {
        this.b.a(fragment, f, i);
    }

    public void a(Fragment fragment, int i) {
        this.b.a(fragment, i);
    }

    public void a(Fragment fragment, boolean z) {
        this.b.a(fragment, z);
    }

    public void a(Fragment fragment, boolean z, String str, int i) {
        this.b.a(fragment, z, str, i);
    }

    public void a(BaseFragment baseFragment, String str, String str2, int i) {
        this.b.a(baseFragment, str, str2, i);
    }

    public void a(PermissionCallbacks permissionCallbacks) {
        this.b.a(permissionCallbacks);
    }

    public void a(RecordingOnliveFragment recordingOnliveFragment, int i, int i2, String str, String[] strArr) {
        this.b.a(recordingOnliveFragment, i, i2, str, strArr);
    }

    public void a(ILiveRoomInfoCallBack iLiveRoomInfoCallBack) {
        this.b = iLiveRoomInfoCallBack;
    }

    public void a(LiveChatBadgeModel liveChatBadgeModel) {
        this.b.a(liveChatBadgeModel);
    }

    public void a(LiveChattingModel liveChattingModel, boolean z) {
        this.b.a(liveChattingModel, z);
    }

    public void a(String str, int i) {
        this.b.a(str, i);
    }

    public void a(String str, String str2, String str3) {
        this.b.a(str, str2, str3);
    }

    public void a(String str, boolean z, IRequestHost iRequestHost) {
        this.b.a(str, z, iRequestHost);
    }

    public void a(String[] strArr) {
        this.b.a(strArr);
    }

    public boolean a(Context context, View.OnClickListener onClickListener) {
        return this.b.a(context, onClickListener);
    }

    public String b(String str, boolean z) {
        return this.b.b(str, z);
    }

    public void b(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, IRequestHost iRequestHost) {
        this.b.b(context, iAddOrRemoveAttentionDone, str, str2, iRequestHost);
    }

    public void b(Context context, String str) {
        this.b.b(context, str);
    }

    public boolean b(Context context) {
        return this.b.b(context);
    }

    public boolean b(String str) {
        return this.b.b(str);
    }

    public String c() {
        return this.b.a();
    }

    public void c(Context context) {
        this.b.c(context);
    }

    public void c(Context context, String str) {
        this.b.c(context, str);
    }

    public String d() {
        return this.b.b();
    }

    public String d(Context context, String str) {
        return this.b.d(context, str);
    }

    public String e() {
        return this.b.c();
    }

    public String f() {
        return this.b.d();
    }

    public long g() {
        return CommonStringUtils.c(this.b.d());
    }

    public boolean h() {
        return this.b.e();
    }

    public boolean i() {
        return this.b.r();
    }

    public boolean j() {
        return this.b.k();
    }

    public String k() {
        return this.b.l();
    }

    public String l() {
        return this.b.m();
    }

    public String m() {
        return this.b.p();
    }

    public BluedLoginResult n() {
        return this.b.q();
    }

    public String o() {
        return this.b.n();
    }

    public String p() {
        return this.b.o();
    }

    public String q() {
        return this.b.f();
    }

    public int r() {
        return this.b.g();
    }

    public LiveChatBadgeModel s() {
        return this.b.h();
    }

    public boolean t() {
        return this.b.i();
    }

    public int u() {
        return this.b.j();
    }

    public void v() {
        this.b.s();
    }

    public boolean w() {
        return this.b.t();
    }

    public boolean x() {
        return this.b.u();
    }

    public String y() {
        return this.b.v();
    }

    public String z() {
        return this.b.w();
    }
}
