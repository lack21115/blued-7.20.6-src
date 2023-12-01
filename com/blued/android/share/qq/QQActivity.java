package com.blued.android.share.qq;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module_share_china.R;
import com.blued.android.share.Constants;
import com.blued.android.share.ShareProvider;
import com.blued.android.share.Util;
import com.blued.android.share.msg.AbsShareMsg;
import com.blued.android.share.msg.MsgImageText;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.utils.UIUtils;
import com.tencent.connect.auth.QQAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/qq/QQActivity.class */
public class QQActivity extends Activity {
    private BaseUiListener callbackListener;
    private int flag;
    private Activity mActivity;
    private boolean mIsCompleteTask;
    private QQAuth mQQAuth;
    private Tencent mTencent;
    MsgImageText mt = null;
    private int type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/qq/QQActivity$BaseUiListener.class */
    public class BaseUiListener implements IUiListener {
        private BaseUiListener() {
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            ShareProvider.getInstance().onCancel(Constants.QQNAME);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            ShareProvider.getInstance().onSuccess(Constants.QQNAME);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ShareProvider.getInstance().onFailure(Constants.QQNAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFinish() {
        ShareProvider.getInstance().unregisterCallback();
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public String getAppId() {
        return TextUtils.equals("a0300a", AppInfo.f9487c) ? "1106192727" : "1101054119";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mTencent != null) {
            Tencent.onActivityResultData(i, i2, intent, this.callbackListener);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        doFinish();
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26 && UIUtils.a((Context) this)) {
            boolean a2 = UIUtils.a((Object) this);
            Log.c("WXEntryActivity", "onCreate fixOrientation when Oreo, result = " + a2);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_empty_share);
        String appId = getAppId();
        this.mQQAuth = QQAuth.createInstance(appId, this);
        this.mTencent = Tencent.createInstance(appId, this);
        AbsShareMsg absShareMsg = (AbsShareMsg) getIntent().getParcelableExtra(Constants.BUNDLE_SHOW);
        this.type = getIntent().getIntExtra("type", 0);
        this.flag = getIntent().getIntExtra("flag", 0);
        this.mActivity = this;
        this.callbackListener = new BaseUiListener();
        if (Util.isClientAvailable(this, "com.tencent.mobileqq")) {
            shareMsg(absShareMsg);
            return;
        }
        AppMethods.d(R.string.qq_uninstall);
        doFinish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        if (this.mIsCompleteTask) {
            getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.blued.android.share.qq.QQActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    ShareProvider.getInstance().onResume(Constants.QQNAME);
                    QQActivity.this.doFinish();
                }
            }, 300L);
        }
        if (!this.mIsCompleteTask) {
            this.mIsCompleteTask = true;
        }
        super.onResume();
    }

    public void shareMsg(AbsShareMsg absShareMsg) {
        if (absShareMsg instanceof MsgImageText) {
            this.mt = (MsgImageText) absShareMsg;
            final Bundle bundle = new Bundle();
            bundle.putInt("req_type", this.type == 0 ? 1 : 5);
            bundle.putString("title", this.mt.title);
            bundle.putString("summary", this.mt.summary);
            bundle.putString("targetUrl", this.mt.targetUrl);
            bundle.putInt("cflag", 0);
            bundle.putString("appName", this.mt.appName);
            if (this.flag == 0) {
                bundle.putString("imageLocalUrl", this.mt.imageUrl);
                this.mTencent.shareToQQ(this, bundle, this.callbackListener);
            } else if (this.type == 1) {
                final ProgressDialog showProgressDialog = Util.showProgressDialog(this);
                ThreadManager.a().a(new ThreadExecutor("QQActShareMsg") { // from class: com.blued.android.share.qq.QQActivity.2
                    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a5, code lost:
                        if (r9 == null) goto L20;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
                        if (r9 == null) goto L20;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b5, code lost:
                        r9.disconnect();
                        r8 = r7;
                     */
                    @Override // com.blued.android.framework.pool.ThreadExecutor
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void execute() {
                        /*
                            Method dump skipped, instructions count: 230
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.share.qq.QQActivity.AnonymousClass2.execute():void");
                    }
                });
            } else {
                bundle.putString("imageUrl", this.mt.imageUrl);
                this.mTencent.shareToQQ(this, bundle, this.callbackListener);
            }
        }
    }
}
