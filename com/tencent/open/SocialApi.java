package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/SocialApi.class */
public class SocialApi {

    /* renamed from: a  reason: collision with root package name */
    private SocialApiIml f38190a;

    public SocialApi(QQToken qQToken) {
        this.f38190a = new SocialApiIml(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38190a.ask(activity, bundle, iUiListener);
    }

    public void brag(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38190a.brag(activity, bundle, iUiListener);
    }

    public void challenge(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38190a.challenge(activity, bundle, iUiListener);
    }

    public boolean checkVoiceApi(Activity activity, Bundle bundle, IUiListener iUiListener) {
        bundle.putString("version", Util.getAppVersion(activity));
        this.f38190a.grade(activity, bundle, iUiListener);
        return true;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38190a.gift(activity, bundle, iUiListener);
    }

    public void grade(Activity activity, Bundle bundle, IUiListener iUiListener) {
        bundle.putString("version", Util.getAppVersion(activity));
        this.f38190a.grade(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38190a.invite(activity, bundle, iUiListener);
    }

    public void reactive(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38190a.reactive(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38190a.story(activity, bundle, iUiListener);
    }

    public void voice(Activity activity, Bundle bundle, IUiListener iUiListener) {
        bundle.putString("version", Util.getAppVersion(activity));
        this.f38190a.voice(activity, bundle, iUiListener);
    }
}
