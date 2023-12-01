package com.blued.android.module.yy_china;

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
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ClickAtLinkListener;
import com.blued.android.module.yy_china.listener.YYIVIPBuyResultObserver;
import com.blued.android.module.yy_china.model.YYRoomModel;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/IYYRoomInfoCallback.class */
public interface IYYRoomInfoCallback {
    CharSequence a(CharSequence charSequence, String str, ClickAtLinkListener clickAtLinkListener);

    Object a(YYIVIPBuyResultObserver yYIVIPBuyResultObserver);

    String a();

    String a(int i);

    void a(Context context);

    void a(Context context, EditText editText, int i, int i2, String str, Map<String, String> map);

    void a(Context context, FragmentManager fragmentManager, YYRoomModel yYRoomModel, Bitmap bitmap, String str);

    void a(Context context, String str);

    void a(Context context, String str, int i);

    void a(Context context, String str, int i, boolean z);

    void a(Context context, String str, String str2);

    void a(Context context, String str, String str2, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, IRequestHost iRequestHost);

    void a(Context context, String str, String str2, String str3);

    void a(Context context, String str, String str2, String str3, int i, int i2);

    void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i);

    void a(BaseFragment baseFragment);

    void a(BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive, String str);

    void a(BaseYYStudioFragment baseYYStudioFragment, YYRoomModel yYRoomModel, Bitmap bitmap, String str);

    void a(Object obj);

    void a(String[] strArr);

    boolean a(Context context, View.OnClickListener onClickListener);

    String b();

    void b(Context context);

    void b(Context context, String str, String str2, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, IRequestHost iRequestHost);

    String c();

    void c(Context context);

    boolean d();

    String e();

    String f();

    Application g();

    String h();

    String i();

    String j();

    boolean k();

    boolean l();
}
