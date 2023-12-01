package com.tencent.open;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.e;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.OpenConfig;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/SocialApiIml.class */
public class SocialApiIml extends BaseApi {

    /* renamed from: a  reason: collision with root package name */
    private Activity f38191a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/SocialApiIml$a.class */
    public class a implements IUiListener {

        /* renamed from: a  reason: collision with root package name */
        b f38194a;

        public a(b bVar) {
            this.f38194a = bVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            SocialApiIml.this.b();
            e.a(this.f38194a.f38196c.getString(SocialConstants.PARAM_IMG_DATA));
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
        @Override // com.tencent.tauth.IUiListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onComplete(java.lang.Object r8) {
            /*
                r7 = this;
                r0 = r8
                if (r0 == 0) goto L18
                r0 = r8
                org.json.JSONObject r0 = (org.json.JSONObject) r0
                r8 = r0
                r0 = r8
                java.lang.String r1 = "check_result"
                boolean r0 = r0.getBoolean(r1)     // Catch: org.json.JSONException -> L13
                r9 = r0
                goto L1a
            L13:
                r8 = move-exception
                r0 = r8
                r0.printStackTrace()
            L18:
                r0 = 0
                r9 = r0
            L1a:
                r0 = r7
                com.tencent.open.SocialApiIml r0 = com.tencent.open.SocialApiIml.this
                com.tencent.open.SocialApiIml.a(r0)
                r0 = r9
                if (r0 == 0) goto L4f
                r0 = r7
                com.tencent.open.SocialApiIml r0 = com.tencent.open.SocialApiIml.this
                r8 = r0
                r0 = r8
                r1 = r8
                android.app.Activity r1 = com.tencent.open.SocialApiIml.b(r1)
                r2 = r7
                com.tencent.open.SocialApiIml$b r2 = r2.f38194a
                android.content.Intent r2 = r2.f38195a
                r3 = r7
                com.tencent.open.SocialApiIml$b r3 = r3.f38194a
                java.lang.String r3 = r3.b
                r4 = r7
                com.tencent.open.SocialApiIml$b r4 = r4.f38194a
                android.os.Bundle r4 = r4.f38196c
                r5 = r7
                com.tencent.open.SocialApiIml$b r5 = r5.f38194a
                com.tencent.tauth.IUiListener r5 = r5.e
                com.tencent.open.SocialApiIml.a(r0, r1, r2, r3, r4, r5)
                return
            L4f:
                r0 = r7
                com.tencent.open.SocialApiIml$b r0 = r0.f38194a
                android.os.Bundle r0 = r0.f38196c
                java.lang.String r1 = "image_date"
                java.lang.String r0 = r0.getString(r1)
                com.tencent.open.e.a(r0)
                r0 = r7
                com.tencent.open.SocialApiIml r0 = com.tencent.open.SocialApiIml.this
                r8 = r0
                r0 = r8
                r1 = r8
                android.app.Activity r1 = com.tencent.open.SocialApiIml.b(r1)
                r2 = r7
                com.tencent.open.SocialApiIml$b r2 = r2.f38194a
                java.lang.String r2 = r2.b
                r3 = r7
                com.tencent.open.SocialApiIml$b r3 = r3.f38194a
                android.os.Bundle r3 = r3.f38196c
                r4 = r7
                com.tencent.open.SocialApiIml$b r4 = r4.f38194a
                java.lang.String r4 = r4.d
                r5 = r7
                com.tencent.open.SocialApiIml$b r5 = r5.f38194a
                com.tencent.tauth.IUiListener r5 = r5.e
                com.tencent.open.SocialApiIml.a(r0, r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.SocialApiIml.a.onComplete(java.lang.Object):void");
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SocialApiIml.this.b();
            e.a(this.f38194a.f38196c.getString(SocialConstants.PARAM_IMG_DATA));
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.a(socialApiIml.f38191a, this.f38194a.b, this.f38194a.f38196c, this.f38194a.d, this.f38194a.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/SocialApiIml$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        Intent f38195a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        Bundle f38196c;
        String d;
        IUiListener e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/SocialApiIml$c.class */
    public class c implements IUiListener {
        private IUiListener b;

        /* renamed from: c  reason: collision with root package name */
        private String f38198c;
        private String d;
        private Bundle e;
        private Activity f;

        c(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.b = iUiListener;
            this.f38198c = str;
            this.d = str2;
            this.e = bundle;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            this.b.onCancel();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            try {
                str = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (JSONException e) {
                e.printStackTrace();
                f.b("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e);
                str = null;
            }
            this.e.putString("encrytoken", str);
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.a((Context) socialApiIml.f38191a, this.f38198c, this.e, this.d, this.b);
            if (TextUtils.isEmpty(str)) {
                f.b("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            f.b("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.b.onError(uiError);
        }
    }

    public SocialApiIml(QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    private b a(Bundle bundle, String str, String str2, IUiListener iUiListener) {
        Intent intent = new Intent();
        intent.setClassName("com.qzone", "com.tencent.open.agent.AgentActivity");
        b bVar = new b();
        bVar.f38195a = intent;
        bVar.f38196c = bundle;
        bVar.d = str2;
        bVar.e = iUiListener;
        bVar.b = str;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        startAssitActivity(activity, intent, Constants.REQUEST_SOCIAL_API);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("-->handleIntent action = ");
        sb.append(str);
        sb.append(", activityIntent = null ? ");
        sb.append(intent == null);
        f.c("openSDK_LOG.SocialApiIml", sb.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        OpenConfig openConfig = OpenConfig.getInstance(Global.getContext(), this.mToken.getAppId());
        boolean z2 = true;
        if (!z) {
            z2 = openConfig.getBoolean("C_LoginH5");
        }
        if (z2) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            handleDownloadLastestQQ(activity, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_VOICE);
        String envUrl = ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_VOICE);
        if (agentIntentWithTarget != null || !a()) {
            a(activity, agentIntentWithTarget, SocialConstants.ACTION_VOICE, bundle, envUrl, iUiListener, true);
            return;
        }
        if (this.mProgressDialog == null || !this.mProgressDialog.isShowing()) {
            this.mProgressDialog = new ProgressDialog(activity);
            this.mProgressDialog.setTitle("请稍候");
            this.mProgressDialog.show();
        }
        a(activity, SocialConstants.ACTION_VOICE, new a(a(bundle, SocialConstants.ACTION_VOICE, envUrl, iUiListener)));
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.f38191a = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        Intent intent = agentIntentWithTarget;
        if (agentIntentWithTarget == null) {
            f.c("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            intent = getAgentIntentWithTarget(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        bundle.putAll(composeActivityParams());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", "request");
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        a(activity, intent, str, bundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), "http://qzs.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent targetActivityIntent = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
        IUiListener cVar = new c(activity, iUiListener, str, str2, bundle);
        Intent targetActivityIntent2 = getTargetActivityIntent("com.tencent.open.agent.EncryTokenActivity");
        if (targetActivityIntent2 != null && targetActivityIntent != null && targetActivityIntent.getComponent() != null && targetActivityIntent2.getComponent() != null && targetActivityIntent.getComponent().getPackageName().equals(targetActivityIntent2.getComponent().getPackageName())) {
            targetActivityIntent2.putExtra("oauth_consumer_key", this.mToken.getAppId());
            targetActivityIntent2.putExtra("openid", this.mToken.getOpenId());
            targetActivityIntent2.putExtra("access_token", this.mToken.getAccessToken());
            targetActivityIntent2.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
            if (hasActivityForIntent(targetActivityIntent2)) {
                f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, cVar);
                startAssitActivity(activity, targetActivityIntent2, Constants.REQUEST_SOCIAL_H5);
                return;
            }
            return;
        }
        f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String encrypt = Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, encrypt);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cVar.onComplete(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        f.a("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.mToken.getAppId());
        if (this.mToken.isSessionValid()) {
            bundle.putString("access_token", this.mToken.getAccessToken());
        }
        String openId = this.mToken.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString("pf", Global.getContext().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString("pf", Constants.DEFAULT_PF));
        } catch (Exception e) {
            e.printStackTrace();
            bundle.putString("pf", Constants.DEFAULT_PF);
        }
        String str3 = str2 + Util.encodeUrl(bundle);
        f.b("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (!SocialConstants.ACTION_CHALLENGE.equals(str) && !SocialConstants.ACTION_BRAG.equals(str)) {
            new TDialog(this.f38191a, str, str3, iUiListener, this.mToken).show();
            return;
        }
        f.b("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
        new PKDialog(this.f38191a, str, str3, iUiListener, this.mToken).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f38191a.isFinishing() || this.mProgressDialog == null || !this.mProgressDialog.isShowing()) {
            return;
        }
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
    }

    protected void a(Activity activity, String str, IUiListener iUiListener) {
        Intent intent = new Intent();
        intent.setClassName("com.qzone", "com.tencent.open.agent.AgentActivity");
        intent.putExtra(Constants.KEY_ACTION, "action_check");
        Bundle bundle = new Bundle();
        bundle.putString("apiName", str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        startAssitActivity(activity, intent, Constants.REQUEST_SOCIAL_API);
    }

    protected boolean a() {
        Intent intent = new Intent();
        intent.setClassName("com.qzone", SocialConstants.ACTIVITY_CHECK_FUNCTION);
        return SystemUtils.isActivityExist(Global.getContext(), intent);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    public void brag(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38191a = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_BRAG);
        bundle.putAll(composeActivityParams());
        a(activity, agentIntentWithTarget, SocialConstants.ACTION_BRAG, bundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_BRAG), iUiListener, false);
    }

    public void challenge(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38191a = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_CHALLENGE);
        bundle.putAll(composeActivityParams());
        a(activity, agentIntentWithTarget, SocialConstants.ACTION_CHALLENGE, bundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_BRAG), iUiListener, false);
    }

    @Override // com.tencent.connect.common.BaseApi
    public Intent getTargetActivityIntent(String str) {
        Intent intent = new Intent();
        intent.setClassName("com.qzone", str);
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        if (!SystemUtils.isActivityExist(Global.getContext(), intent2) || SystemUtils.compareQQVersion(Global.getContext(), "4.7") < 0) {
            if (SystemUtils.isActivityExist(Global.getContext(), intent) && SystemUtils.compareVersion(SystemUtils.getAppVersionName(Global.getContext(), "com.qzone"), "4.2") >= 0 && SystemUtils.isAppSignatureValid(Global.getContext(), intent.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE)) {
                return intent;
            }
            return null;
        }
        return intent2;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void grade(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38191a = activity;
        bundle.putAll(composeActivityParams());
        bundle.putString("version", Util.getAppVersion(activity));
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_GRADE);
        if (agentIntentWithTarget != null || !a()) {
            a(activity, agentIntentWithTarget, SocialConstants.ACTION_GRADE, bundle, "http://qzs.qq.com/open/mobile/rate/sdk_rate.html?", iUiListener, true);
            return;
        }
        this.mProgressDialog = new ProgressDialog(activity);
        this.mProgressDialog.setMessage("请稍候...");
        this.mProgressDialog.show();
        a(activity, SocialConstants.ACTION_GRADE, new a(a(bundle, SocialConstants.ACTION_GRADE, "http://qzs.qq.com/open/mobile/rate/sdk_rate.html?", iUiListener)));
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38191a = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        Intent intent = agentIntentWithTarget;
        if (agentIntentWithTarget == null) {
            f.c("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            intent = getAgentIntentWithTarget(SocialConstants.ACTIVITY_INVITE);
        }
        bundle.putAll(composeActivityParams());
        a(activity, intent, SocialConstants.ACTION_INVITE, bundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_INVITE), iUiListener, false);
    }

    public void reactive(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38191a = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        Intent intent = agentIntentWithTarget;
        if (agentIntentWithTarget == null) {
            intent = getAgentIntentWithTarget(SocialConstants.ACTIVITY_REACTIVE);
        }
        bundle.putAll(composeActivityParams());
        String envUrl = ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_REACTIVE);
        if (intent != null || !a()) {
            bundle.putString(SocialConstants.PARAM_SEND_IMG, bundle.getString("img"));
            bundle.putString("type", SocialConstants.TYPE_REACTIVE);
            bundle.remove("img");
            a(activity, intent, SocialConstants.ACTION_REACTIVE, bundle, envUrl, iUiListener, false);
            return;
        }
        this.mProgressDialog = new ProgressDialog(activity);
        this.mProgressDialog.setMessage("请稍候...");
        this.mProgressDialog.show();
        bundle.putString("type", SocialConstants.TYPE_REACTIVE);
        a(activity, SocialConstants.ACTION_REACTIVE, new a(a(bundle, SocialConstants.ACTION_REACTIVE, envUrl, iUiListener)));
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f38191a = activity;
        Intent agentIntentWithTarget = getAgentIntentWithTarget(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(composeActivityParams());
        a(activity, agentIntentWithTarget, SocialConstants.ACTION_STORY, bundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), ServerSetting.DEFAULT_URL_SEND_STORY), iUiListener, false);
    }

    public void voice(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        Bitmap bitmap;
        this.f38191a = activity;
        bundle.putAll(composeActivityParams());
        bundle.putString("version", Util.getAppVersion(activity));
        if (!e.a()) {
            f.c("openSDK_LOG.SocialApiIml", "voice no SDCard");
            iUiListener.onError(new UiError(-12, Constants.MSG_NO_SDCARD, Constants.MSG_NO_SDCARD));
        } else if (!bundle.containsKey(SocialConstants.PARAM_IMG_DATA) || (bitmap = (Bitmap) bundle.getParcelable(SocialConstants.PARAM_IMG_DATA)) == null) {
            a(activity, bundle, iUiListener);
        } else {
            this.mProgressDialog = new ProgressDialog(activity);
            this.mProgressDialog.setMessage("请稍候...");
            this.mProgressDialog.show();
            new e(new e.a() { // from class: com.tencent.open.SocialApiIml.1
                @Override // com.tencent.open.e.a
                public void a(String str) {
                    bundle.remove(SocialConstants.PARAM_IMG_DATA);
                    if (!TextUtils.isEmpty(str)) {
                        bundle.putString(SocialConstants.PARAM_IMG_DATA, str);
                    }
                    SocialApiIml.this.a(activity, bundle, iUiListener);
                }

                @Override // com.tencent.open.e.a
                public void b(String str) {
                    bundle.remove(SocialConstants.PARAM_IMG_DATA);
                    iUiListener.onError(new UiError(-5, Constants.MSG_IMAGE_ERROR, Constants.MSG_IMAGE_ERROR));
                    SocialApiIml.this.b();
                }
            }).execute(bitmap);
        }
    }

    public void writeEncryToken(Context context) {
        String str;
        String accessToken = this.mToken.getAccessToken();
        String appId = this.mToken.getAppId();
        String openId = this.mToken.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            str = null;
        } else {
            str = Util.encrypt("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        String envUrl = ServerSetting.getInstance().getEnvUrl(context, ServerSetting.DEFAULT_LOCAL_STORAGE_URI);
        bVar.loadDataWithBaseURL(envUrl, "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.mToken.getOpenId() + BridgeUtil.UNDERLINE_STR + this.mToken.getAppId() + "\"]=\"" + str + "\";</script></head><body></body></html>", ClipDescription.MIMETYPE_TEXT_HTML, "utf-8", envUrl);
    }
}
