package com.blued.android.share.sina;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module_share_china.R;
import com.blued.android.share.Constants;
import com.blued.android.share.ShareProvider;
import com.blued.android.share.Util;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.openalliance.ad.constant.s;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.utils.Utility;
import com.soft.blued.utils.UIUtils;
import java.io.File;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/sina/SinaShareActivity.class */
public class SinaShareActivity extends Activity implements IWeiboHandler.Response {
    private String des;
    private String fileUrl;
    private int flag;
    private String imgUrl;
    private boolean isInstalledWeibo;
    private String linkUrl;
    private Bitmap mBigBitmap;
    private Bitmap mBitmap;
    boolean mIsCompleteTask;
    private IWeiboShareAPI mWeiboShareAPI = null;
    private String title;

    private void doFinish() {
        ShareProvider.getInstance().unregisterCallback();
        finish();
    }

    private void downloadImage() {
        Logger.c("module_share", "sina start download image:" + this.imgUrl);
        final String d = RecyclingUtils.d(this.imgUrl);
        if (!new File(d).exists()) {
            Logger.c("module_share", "file not exists.");
            final ProgressDialog showProgressDialog = Util.showProgressDialog(this);
            FileDownloader.a(this.imgUrl, d, new FileHttpResponseHandler() { // from class: com.blued.android.share.sina.SinaShareActivity.1
                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFailure(Throwable th, int i, File file) {
                    Logger.c("module_share", "file download fail:" + SinaShareActivity.this.imgUrl);
                }

                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFinish() {
                    Logger.c("module_share", "file download finish:" + SinaShareActivity.this.imgUrl);
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.share.sina.SinaShareActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!SinaShareActivity.this.isFinishing()) {
                                Util.hideProgressDialog(showProgressDialog);
                            }
                            SinaShareActivity.this.zoomImage();
                        }
                    });
                }

                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onSuccess(File file) {
                    SinaShareActivity.this.fileUrl = d;
                    Logger.c("module_share", "file download success:" + SinaShareActivity.this.imgUrl);
                }
            }, null);
            return;
        }
        this.fileUrl = d;
        Logger.c("module_share", "download file exists:" + this.fileUrl);
        zoomImage();
    }

    private String getAppKey() {
        return TextUtils.equals("a0300a", AppInfo.f9487c) ? "183873903" : "2677078813";
    }

    private ImageObject getImageObj() {
        ImageObject imageObject = new ImageObject();
        imageObject.setImageObject(this.mBigBitmap);
        return imageObject;
    }

    private TextObject getTextObj() {
        TextObject textObject = new TextObject();
        textObject.text = this.des;
        textObject.setThumbImage(this.mBitmap);
        return textObject;
    }

    private WebpageObject getWebpageObj() {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = this.title;
        webpageObject.description = this.des;
        webpageObject.setThumbImage(this.mBitmap);
        webpageObject.actionUrl = this.linkUrl;
        webpageObject.defaultText = s.B;
        return webpageObject;
    }

    private void sendMultiMessage(boolean z, boolean z2, boolean z3) {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (z) {
            weiboMultiMessage.textObject = getTextObj();
        }
        if (z2) {
            weiboMultiMessage.imageObject = getImageObj();
        }
        if (z3) {
            weiboMultiMessage.mediaObject = getWebpageObj();
        }
        SendMultiMessageToWeiboRequest sendMultiMessageToWeiboRequest = new SendMultiMessageToWeiboRequest();
        sendMultiMessageToWeiboRequest.transaction = String.valueOf(System.currentTimeMillis());
        sendMultiMessageToWeiboRequest.multiMessage = weiboMultiMessage;
        this.mWeiboShareAPI.sendRequest(this, sendMultiMessageToWeiboRequest);
    }

    private void sendSingleMessage(boolean z, boolean z2, boolean z3) {
        WeiboMessage weiboMessage = new WeiboMessage();
        if (z) {
            weiboMessage.mediaObject = getTextObj();
        }
        if (z2) {
            weiboMessage.mediaObject = getImageObj();
        }
        if (z3) {
            weiboMessage.mediaObject = getWebpageObj();
        }
        SendMessageToWeiboRequest sendMessageToWeiboRequest = new SendMessageToWeiboRequest();
        sendMessageToWeiboRequest.transaction = String.valueOf(System.currentTimeMillis());
        sendMessageToWeiboRequest.message = weiboMessage;
        this.mWeiboShareAPI.sendRequest(this, sendMessageToWeiboRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zoomImage() {
        Logger.c("module_share", "start zoom image");
        if (!TextUtils.isEmpty(this.fileUrl)) {
            Logger.c("module_share", "!TextUtils.isEmpty(fileUrl)");
            this.mBitmap = Util.imageZoomToSize(this.fileUrl, 20);
            this.mBigBitmap = Util.imageZoomToSize(this.fileUrl, 150);
        }
        if (this.mBitmap == null) {
            Logger.c("module_share", "mBitmap == null");
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.blued_logo_500);
            this.mBitmap = decodeResource;
            this.mBigBitmap = decodeResource;
        }
        ThreadManager.a().a(new ThreadExecutor("zoomImage") { // from class: com.blued.android.share.sina.SinaShareActivity.2
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                if (SinaShareActivity.this.mBitmap == null) {
                    Logger.c("module_share", "sendmsg:true,false,false");
                    SinaShareActivity.this.sendMessage(true, false, false);
                    return;
                }
                Logger.c("module_share", "sendmsg:true,true,true");
                SinaShareActivity.this.sendMessage(true, true, true);
            }
        });
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
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
        IWeiboShareAPI createWeiboAPI = WeiboShareSDK.createWeiboAPI(this, getAppKey());
        this.mWeiboShareAPI = createWeiboAPI;
        createWeiboAPI.registerApp();
        if (bundle != null) {
            this.mWeiboShareAPI.handleWeiboResponse(getIntent(), this);
            return;
        }
        boolean isWeiboAppInstalled = this.mWeiboShareAPI.isWeiboAppInstalled();
        this.isInstalledWeibo = isWeiboAppInstalled;
        if (!isWeiboAppInstalled) {
            AppMethods.d(R.string.weibo_uninstall);
            doFinish();
            return;
        }
        this.title = getIntent().getStringExtra("title");
        this.des = getIntent().getStringExtra("des");
        this.flag = getIntent().getIntExtra("flag", 0);
        this.imgUrl = getIntent().getStringExtra("imgUrl");
        this.linkUrl = getIntent().getStringExtra("linkUrl");
        this.fileUrl = getIntent().getStringExtra("fileUrl");
        if (!TextUtils.isEmpty(this.imgUrl) && this.imgUrl.startsWith("http") && this.flag == 1) {
            downloadImage();
        } else {
            zoomImage();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mWeiboShareAPI.handleWeiboResponse(intent, this);
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboHandler.Response
    public void onResponse(BaseResponse baseResponse) {
        if (baseResponse != null) {
            int i = baseResponse.errCode;
            if (i == 0) {
                ShareProvider.getInstance().onSuccess(Constants.SinaWeiboNAME);
            } else if (i != 1) {
                if (i != 2) {
                    return;
                }
                ShareProvider.getInstance().onFailure(Constants.SinaWeiboNAME);
            } else if (this.isInstalledWeibo) {
                ShareProvider.getInstance().onCancel(Constants.SinaWeiboNAME);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        if (this.mIsCompleteTask) {
            ShareProvider.getInstance().onResume(Constants.SinaWeiboNAME);
            doFinish();
        }
        if (!this.mIsCompleteTask) {
            this.mIsCompleteTask = true;
        }
        super.onResume();
    }

    public void sendMessage(boolean z, boolean z2, boolean z3) {
        if (!this.isInstalledWeibo) {
            finish();
        } else if (!this.mWeiboShareAPI.isWeiboAppSupportAPI()) {
            finish();
        } else if (this.mWeiboShareAPI.getWeiboAppSupportAPI() >= 10351) {
            Logger.c("module_share", "send multi msg");
            sendMultiMessage(z, z2, z3);
        } else {
            Logger.c("module_share", "send single msg");
            sendSingleMessage(z, z2, z3);
        }
    }
}
