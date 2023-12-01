package com.blued.login.auto;

import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.login.model.LoginAVConfigExtra;
import com.blued.login.model.ProfileInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/auto/LonginServiceDefaultImpl.class */
public final class LonginServiceDefaultImpl implements ILoginService {
    @Override // com.blued.login.auto.ILoginService
    public String a() {
        return "";
    }

    @Override // com.blued.login.auto.ILoginService
    public String a(String str) {
        return "";
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(Context context) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(Context context, Bundle bundle) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(Context context, Bundle bundle, Bundle bundle2) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(TextView tvTerms, TextView tvTermsEn, boolean z) {
        Intrinsics.e(tvTerms, "tvTerms");
        Intrinsics.e(tvTermsEn, "tvTermsEn");
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(BaseFragment baseFragment, int i, int i2) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(BaseFragment baseFragment, String str, String str2, String str3, int i) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(BluedLoginResult bluedLoginResult, LoginAVConfigExtra loginAVConfigExtra, ProfileInfoModel profileInfoModel, Context context) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void a(String from, Context context, CheckBox checkBox) {
        Intrinsics.e(from, "from");
    }

    @Override // com.blued.login.auto.ILoginService
    public String b() {
        return "";
    }

    @Override // com.blued.login.auto.ILoginService
    public String b(String str) {
        return "";
    }

    @Override // com.blued.login.auto.ILoginService
    public void b(Context context) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void b(Context context, Bundle bundle) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void c() {
    }

    @Override // com.blued.login.auto.ILoginService
    public void c(Context context) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void c(Context context, Bundle bundle) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void d(Context context) {
    }

    @Override // com.blued.login.auto.ILoginService
    public void d(Context context, Bundle bundle) {
    }
}
