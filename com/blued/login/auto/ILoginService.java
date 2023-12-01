package com.blued.login.auto;

import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.login.model.LoginAVConfigExtra;
import com.blued.login.model.ProfileInfoModel;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/auto/ILoginService.class */
public interface ILoginService {
    String a();

    String a(String str);

    void a(Context context);

    void a(Context context, Bundle bundle);

    void a(Context context, Bundle bundle, Bundle bundle2);

    void a(TextView textView, TextView textView2, boolean z);

    void a(BaseFragment baseFragment, int i, int i2);

    void a(BaseFragment baseFragment, String str, String str2, String str3, int i);

    void a(BluedLoginResult bluedLoginResult, LoginAVConfigExtra loginAVConfigExtra, ProfileInfoModel profileInfoModel, Context context);

    void a(String str, Context context, CheckBox checkBox);

    String b();

    String b(String str);

    void b(Context context);

    void b(Context context, Bundle bundle);

    void c();

    void c(Context context);

    void c(Context context, Bundle bundle);

    void d(Context context);

    void d(Context context, Bundle bundle);
}
