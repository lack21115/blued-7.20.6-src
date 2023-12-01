package com.soft.blued.wxapi;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.FailReason;
import com.blued.android.core.imagecache.ImageLoadingListener;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.view.AutoAttachRecyclingImageView;
import com.blued.android.core.imagecache.view.RecyclingImageView;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module_share_china.R;
import com.blued.android.share.Constants;
import com.blued.android.share.ShareProvider;
import com.blued.android.share.Util;
import com.blued.android.share.msg.AbsShareMsg;
import com.blued.android.share.msg.MsgImage;
import com.blued.android.share.msg.MsgImageText;
import com.blued.android.share.msg.MsgWeixinVideoText;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.constant.ShareCoreConstants;
import com.soft.blued.utils.ShareBitmapUtils;
import com.soft.blued.utils.ShareDialogUtils;
import com.soft.blued.utils.UIUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.net.URL;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/wxapi/WXEntryActivity.class */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    /* renamed from: a  reason: collision with root package name */
    String f34870a;
    private IWXAPI b;

    /* renamed from: c  reason: collision with root package name */
    private int f34871c;
    private boolean d;
    private boolean e = false;
    private Dialog f;

    /* JADX INFO: Access modifiers changed from: private */
    public float a(Bitmap bitmap, int i) {
        float f;
        int width;
        if (bitmap == null || bitmap.getHeight() <= i || bitmap.getWidth() <= i) {
            return 1.0f;
        }
        if (bitmap.getWidth() > bitmap.getHeight()) {
            f = i;
            width = bitmap.getHeight();
        } else {
            f = i;
            width = bitmap.getWidth();
        }
        return f / width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ShareDialogUtils.b(this.f);
        if (this.d) {
            if (!this.e && TextUtils.equals(this.f34870a, "intent_mode_login")) {
                WXProvider.a().a(1, null);
            }
            if (TextUtils.equals(this.f34870a, "intent_mode_share")) {
                ShareProvider.getInstance().onResume(this.f34871c == 8 ? Constants.WechatNAME : Constants.WechatMomentsNAME);
            }
            d();
        }
    }

    private void a(final AbsShareMsg absShareMsg) {
        if (!(absShareMsg instanceof MsgImageText)) {
            if (absShareMsg instanceof MsgImage) {
                a((MsgImage) absShareMsg);
                return;
            } else if (absShareMsg instanceof MsgWeixinVideoText) {
                MsgWeixinVideoText msgWeixinVideoText = (MsgWeixinVideoText) absShareMsg;
                a(msgWeixinVideoText, msgWeixinVideoText.title, msgWeixinVideoText.summary, msgWeixinVideoText.targetUrl);
                return;
            } else {
                return;
            }
        }
        MsgImageText msgImageText = (MsgImageText) absShareMsg;
        final String str = msgImageText.imageUrl;
        if (str != null && str.startsWith("http")) {
            final ProgressDialog showProgressDialog = Util.showProgressDialog(this);
            ThreadManager.a().a(new ThreadExecutor("WxEntryShareMsg") { // from class: com.soft.blued.wxapi.WXEntryActivity.2
                /* JADX WARN: Code restructure failed: missing block: B:32:0x009f, code lost:
                    if (r9 == null) goto L20;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
                    if (r9 == null) goto L20;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:37:0x00af, code lost:
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
                        Method dump skipped, instructions count: 224
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.wxapi.WXEntryActivity.AnonymousClass2.execute():void");
                }
            });
            return;
        }
        Bitmap imageZoomToSize = Util.imageZoomToSize(msgImageText.imageUrl, 100);
        Bitmap bitmap = imageZoomToSize;
        if (imageZoomToSize == null) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blued_logo_500);
        }
        msgImageText.image = bitmap;
        a(msgImageText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MsgImage msgImage, Bitmap bitmap) {
        byte[] bArr;
        if (msgImage == null) {
            return;
        }
        int i = msgImage.pType == 16 ? 1 : 0;
        WXImageObject wXImageObject = new WXImageObject(bitmap);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        Bitmap imageZoomToSize = Util.imageZoomToSize(bitmap, 20);
        float a2 = a(imageZoomToSize, 60);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(imageZoomToSize, (int) (imageZoomToSize.getWidth() * a2), (int) (imageZoomToSize.getHeight() * a2), true);
        if (imageZoomToSize != null && !imageZoomToSize.equals(createScaledBitmap)) {
            imageZoomToSize.recycle();
        }
        byte[] bmpToByteArray = Util.bmpToByteArray(createScaledBitmap, false);
        Logger.b("xpf", "first image compress bitmap size:", Integer.valueOf(bmpToByteArray.length / 1024));
        if (bmpToByteArray == null || bmpToByteArray.length / 1024 < 20) {
            bArr = bmpToByteArray;
            if (createScaledBitmap != null) {
                createScaledBitmap.recycle();
                bArr = bmpToByteArray;
            }
        } else {
            float a3 = a(createScaledBitmap, 30);
            Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(createScaledBitmap, (int) (createScaledBitmap.getWidth() * a3), (int) (createScaledBitmap.getHeight() * a3), true);
            if (!createScaledBitmap.equals(createScaledBitmap2)) {
                createScaledBitmap.recycle();
            }
            bArr = Util.bmpToByteArray(createScaledBitmap2, true);
            Logger.b("xpf", "second image compress bitmap size:", Integer.valueOf(bArr.length / 1024));
        }
        wXMediaMessage.thumbData = bArr;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = a("img");
        req.message = wXMediaMessage;
        req.scene = i;
        this.b.sendReq(req);
    }

    private void a(ShowMessageFromWX.Req req) {
        WXMediaMessage wXMediaMessage = req.message;
        WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) wXMediaMessage.mediaObject;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("description: ");
        stringBuffer.append(wXMediaMessage.description);
        stringBuffer.append("\n");
        stringBuffer.append("extInfo: ");
        stringBuffer.append(wXAppExtendObject.extInfo);
        stringBuffer.append("\n");
        stringBuffer.append("filePath: ");
        stringBuffer.append(wXAppExtendObject.filePath);
        d();
    }

    private void b() {
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "none";
        this.b.sendReq(req);
    }

    private void c() {
    }

    private void d() {
        ShareProvider.getInstance().unregisterCallback();
        WXProvider.a().b();
        finish();
    }

    public void a(final MsgImage msgImage) {
        if (msgImage == null) {
            return;
        }
        if (msgImage.imageUrl.startsWith("http")) {
            AutoAttachRecyclingImageView.a(msgImage.imageUrl, new LoadOptions(), new ImageLoadingListener() { // from class: com.soft.blued.wxapi.WXEntryActivity.3
                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public void a(int i, int i2) {
                }

                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions) {
                }

                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions, Drawable drawable, boolean z) {
                    WXEntryActivity.this.a(msgImage, ShareBitmapUtils.a(drawable));
                }

                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions, FailReason failReason) {
                    AppMethods.d(R.string.common_net_error);
                }

                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public boolean a() {
                    return false;
                }

                @Override // com.blued.android.core.imagecache.ImageLoadingListener
                public void b(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions) {
                }
            });
        } else {
            a(msgImage, BitmapFactory.decodeFile(msgImage.imageUrl));
        }
    }

    public void a(final MsgImageText msgImageText) {
        if (msgImageText == null) {
            return;
        }
        ThreadManager.a().a(new ThreadExecutor("shareWebPage") { // from class: com.soft.blued.wxapi.WXEntryActivity.4
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                byte[] bArr;
                byte[] bArr2;
                int i = msgImageText.pType == 16 ? 1 : 0;
                WXWebpageObject wXWebpageObject = new WXWebpageObject();
                wXWebpageObject.webpageUrl = msgImageText.targetUrl;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
                wXMediaMessage.title = msgImageText.title;
                wXMediaMessage.description = msgImageText.summary;
                if (msgImageText.image != null) {
                    Bitmap imageZoomToSize = Util.imageZoomToSize(msgImageText.image, 20);
                    float a2 = WXEntryActivity.this.a(imageZoomToSize, 60);
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(imageZoomToSize, (int) (imageZoomToSize.getWidth() * a2), (int) (imageZoomToSize.getHeight() * a2), true);
                    if (!msgImageText.image.equals(createScaledBitmap)) {
                        msgImageText.image.recycle();
                    }
                    byte[] bmpToByteArray = Util.bmpToByteArray(createScaledBitmap, false);
                    Logger.b("xpf", "first link compress bitmap size:", Integer.valueOf(bmpToByteArray.length / 1024));
                    if (bmpToByteArray == null || bmpToByteArray.length / 1024 < 20) {
                        bArr2 = bmpToByteArray;
                        if (createScaledBitmap != null) {
                            createScaledBitmap.recycle();
                            bArr2 = bmpToByteArray;
                        }
                    } else {
                        float a3 = WXEntryActivity.this.a(createScaledBitmap, 30);
                        Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(createScaledBitmap, (int) (createScaledBitmap.getWidth() * a3), (int) (createScaledBitmap.getHeight() * a3), true);
                        if (!createScaledBitmap.equals(createScaledBitmap2)) {
                            createScaledBitmap.recycle();
                        }
                        bArr2 = Util.bmpToByteArray(createScaledBitmap2, true);
                        Logger.b("xpf", "second link compress bitmap size:", Integer.valueOf(bArr2.length / 1024));
                    }
                    wXMediaMessage.thumbData = bArr2;
                } else if (msgImageText.imageUrl != null) {
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(new URL(msgImageText.imageUrl).openStream());
                        Bitmap imageZoomToSize2 = Util.imageZoomToSize(decodeStream, 20);
                        float a4 = WXEntryActivity.this.a(imageZoomToSize2, 60);
                        Bitmap createScaledBitmap3 = Bitmap.createScaledBitmap(imageZoomToSize2, (int) (imageZoomToSize2.getWidth() * a4), (int) (imageZoomToSize2.getHeight() * a4), true);
                        if (!decodeStream.equals(createScaledBitmap3)) {
                            decodeStream.recycle();
                        }
                        byte[] bmpToByteArray2 = Util.bmpToByteArray(createScaledBitmap3, false);
                        Logger.b("xpf", "first link url compress bitmap size:", Integer.valueOf(bmpToByteArray2.length / 1024));
                        if (bmpToByteArray2 == null || bmpToByteArray2.length / 1024 < 20) {
                            bArr = bmpToByteArray2;
                            if (createScaledBitmap3 != null) {
                                createScaledBitmap3.recycle();
                                bArr = bmpToByteArray2;
                            }
                        } else {
                            float a5 = WXEntryActivity.this.a(createScaledBitmap3, 30);
                            Bitmap createScaledBitmap4 = Bitmap.createScaledBitmap(createScaledBitmap3, (int) (createScaledBitmap3.getWidth() * a5), (int) (createScaledBitmap3.getHeight() * a5), true);
                            if (!createScaledBitmap3.equals(createScaledBitmap4)) {
                                createScaledBitmap3.recycle();
                            }
                            bArr = Util.bmpToByteArray(createScaledBitmap4, true);
                            Logger.b("xpf", "second link url compress bitmap size:", Integer.valueOf(bArr.length / 1024));
                        }
                        wXMediaMessage.thumbData = bArr;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = WXEntryActivity.this.a("webpage");
                req.message = wXMediaMessage;
                req.scene = i;
                WXEntryActivity.this.b.sendReq(req);
            }
        });
    }

    public void a(MsgWeixinVideoText msgWeixinVideoText, String str, String str2, String str3) {
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = str3;
        int i = msgWeixinVideoText.pType == 16 ? 1 : 0;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
        if (msgWeixinVideoText.image != null) {
            wXMediaMessage.thumbData = Util.bmpToByteArray(msgWeixinVideoText.image, true);
        } else if (msgWeixinVideoText.imageUrl != null) {
            try {
                Bitmap imageZoomToSize = Util.imageZoomToSize(msgWeixinVideoText.imageUrl, 20);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(imageZoomToSize, 60, 60, true);
                if (imageZoomToSize != null && !imageZoomToSize.equals(createScaledBitmap)) {
                    imageZoomToSize.recycle();
                }
                wXMediaMessage.thumbData = Util.bmpToByteArray(createScaledBitmap, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = a("video");
        req.message = wXMediaMessage;
        req.scene = i;
        this.b.sendReq(req);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        d();
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26 && UIUtils.a((Context) this)) {
            boolean a2 = UIUtils.a((Object) this);
            Log.c("WXEntryActivity", "onCreate fixOrientation when Oreo, result = " + a2);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_empty_share);
        this.f = ShareDialogUtils.a(this);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, ShareCoreConstants.a(), false);
        this.b = createWXAPI;
        createWXAPI.registerApp(ShareCoreConstants.a());
        this.b.handleIntent(getIntent(), this);
        this.f34870a = getIntent().getStringExtra("intent_mode");
        AbsShareMsg absShareMsg = (AbsShareMsg) getIntent().getParcelableExtra("WXEnetry_jrj_show");
        if (absShareMsg != null) {
            this.f34871c = absShareMsg.pType;
        }
        if (bundle != null) {
            this.d = bundle.getBoolean("task_running");
        } else if (!this.b.isWXAppInstalled()) {
            AppMethods.d(R.string.we_chat_uninstall);
            d();
        } else if (TextUtils.equals(this.f34870a, "intent_mode_login")) {
            b();
        } else if (TextUtils.equals(this.f34870a, "intent_mode_share")) {
            a(absShareMsg);
        } else {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.b.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        int type = baseReq.getType();
        if (type == 3) {
            c();
        } else if (type != 4) {
        } else {
            a((ShowMessageFromWX.Req) baseReq);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        int i = baseResp.errCode;
        if (i == -4) {
            this.e = true;
            if (TextUtils.equals(this.f34870a, "intent_mode_login")) {
                WXProvider.a().a(-1, null);
            } else if (TextUtils.equals(this.f34870a, "intent_mode_share")) {
                ShareProvider.getInstance().onFailure(this.f34871c == 8 ? Constants.WechatNAME : Constants.WechatMomentsNAME);
            }
        } else if (i == -2) {
            this.e = true;
            if (TextUtils.equals(this.f34870a, "intent_mode_login")) {
                WXProvider.a().a(1, null);
            } else if (TextUtils.equals(this.f34870a, "intent_mode_share")) {
                ShareProvider.getInstance().onCancel(this.f34871c == 8 ? Constants.WechatNAME : Constants.WechatMomentsNAME);
            }
        } else if (i != 0) {
        } else {
            this.e = true;
            if (!TextUtils.equals(this.f34870a, "intent_mode_login")) {
                if (TextUtils.equals(this.f34870a, "intent_mode_share")) {
                    ShareProvider.getInstance().onSuccess(this.f34871c == 8 ? Constants.WechatNAME : Constants.WechatMomentsNAME);
                    return;
                }
                return;
            }
            WXLoginBean wXLoginBean = new WXLoginBean();
            SendAuth.Resp resp = (SendAuth.Resp) baseResp;
            wXLoginBean.code = resp.code;
            wXLoginBean.state = resp.state;
            WXProvider.a().a(0, wXLoginBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.d) {
            this.d = true;
        } else if (this.e || !TextUtils.equals(this.f34870a, "intent_mode_login")) {
            a();
        } else {
            ShareDialogUtils.a(this.f);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.wxapi.WXEntryActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (UiUtils.a((Activity) WXEntryActivity.this)) {
                        WXEntryActivity.this.a();
                    }
                }
            }, m.ag);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("task_running", this.d);
    }
}
