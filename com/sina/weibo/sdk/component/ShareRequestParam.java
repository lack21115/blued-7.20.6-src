package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MusicObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseRequest;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.Base64;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/ShareRequestParam.class */
public class ShareRequestParam extends BrowserRequestParamBase {
    public static final String REQ_PARAM_AID = "aid";
    public static final String REQ_PARAM_KEY_HASH = "key_hash";
    public static final String REQ_PARAM_PACKAGENAME = "packagename";
    public static final String REQ_PARAM_PICINFO = "picinfo";
    public static final String REQ_PARAM_SOURCE = "source";
    public static final String REQ_PARAM_TITLE = "title";
    public static final String REQ_PARAM_TOKEN = "access_token";
    public static final String REQ_PARAM_VERSION = "version";
    public static final String REQ_UPLOAD_PIC_PARAM_IMG = "img";
    public static final String RESP_UPLOAD_PIC_PARAM_CODE = "code";
    public static final String RESP_UPLOAD_PIC_PARAM_DATA = "data";
    public static final int RESP_UPLOAD_PIC_SUCC_CODE = 1;
    private static final String SHARE_URL = "http://service.weibo.com/share/mobilesdk.php";
    public static final String UPLOAD_PIC_URL = "http://service.weibo.com/share/mobilesdk_uppic.php";
    private String mAppKey;
    private String mAppPackage;
    private WeiboAuthListener mAuthListener;
    private String mAuthListenerKey;
    private byte[] mBase64ImgData;
    private BaseRequest mBaseRequest;
    private String mHashKey;
    private String mShareContent;
    private String mToken;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/ShareRequestParam$UploadPicResult.class */
    public static class UploadPicResult {
        private int code = -2;
        private String picId;

        private UploadPicResult() {
        }

        public static UploadPicResult parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            UploadPicResult uploadPicResult = new UploadPicResult();
            try {
                JSONObject jSONObject = new JSONObject(str);
                uploadPicResult.code = jSONObject.optInt("code", -2);
                uploadPicResult.picId = jSONObject.optString("data", "");
                return uploadPicResult;
            } catch (JSONException e) {
                return uploadPicResult;
            }
        }

        public int getCode() {
            return this.code;
        }

        public String getPicId() {
            return this.picId;
        }
    }

    public ShareRequestParam(Context context) {
        super(context);
        this.mLaucher = BrowserLauncher.SHARE;
    }

    private void handleMblogPic(String str, byte[] bArr) {
        FileInputStream fileInputStream;
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[(int) file.length()];
                    FileInputStream fileInputStream2 = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            fileInputStream.read(bArr2);
                            this.mBase64ImgData = Base64.encodebyte(bArr2);
                            try {
                                fileInputStream.close();
                                return;
                            } catch (Exception e) {
                                return;
                            }
                        } catch (IOException e2) {
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bArr != null) {
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            fileInputStream2 = fileInputStream;
                            th = th;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e3) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        } catch (SecurityException | Exception e5) {
        }
        if (bArr != null || bArr.length <= 0) {
            return;
        }
        this.mBase64ImgData = Base64.encodebyte(bArr);
    }

    private void handleSharedMessage(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.toObject(bundle);
        StringBuilder sb = new StringBuilder();
        if (weiboMultiMessage.textObject instanceof TextObject) {
            sb.append(weiboMultiMessage.textObject.text);
        }
        if (weiboMultiMessage.imageObject instanceof ImageObject) {
            ImageObject imageObject = weiboMultiMessage.imageObject;
            handleMblogPic(imageObject.imagePath, imageObject.imageData);
        }
        if (weiboMultiMessage.mediaObject instanceof TextObject) {
            sb.append(((TextObject) weiboMultiMessage.mediaObject).text);
        }
        if (weiboMultiMessage.mediaObject instanceof ImageObject) {
            ImageObject imageObject2 = (ImageObject) weiboMultiMessage.mediaObject;
            handleMblogPic(imageObject2.imagePath, imageObject2.imageData);
        }
        if (weiboMultiMessage.mediaObject instanceof WebpageObject) {
            sb.append(" ");
            sb.append(((WebpageObject) weiboMultiMessage.mediaObject).actionUrl);
        }
        if (weiboMultiMessage.mediaObject instanceof MusicObject) {
            sb.append(" ");
            sb.append(((MusicObject) weiboMultiMessage.mediaObject).actionUrl);
        }
        if (weiboMultiMessage.mediaObject instanceof VideoObject) {
            sb.append(" ");
            sb.append(((VideoObject) weiboMultiMessage.mediaObject).actionUrl);
        }
        if (weiboMultiMessage.mediaObject instanceof VoiceObject) {
            sb.append(" ");
            sb.append(((VoiceObject) weiboMultiMessage.mediaObject).actionUrl);
        }
        this.mShareContent = sb.toString();
    }

    private void sendSdkResponse(Activity activity, int i, String str) {
        Bundle extras = activity.getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Intent intent = new Intent(WBConstants.ACTIVITY_REQ_SDK);
        intent.setFlags(131072);
        intent.setPackage(extras.getString(WBConstants.Base.APP_PKG));
        intent.putExtras(extras);
        intent.putExtra(WBConstants.Base.APP_PKG, activity.getPackageName());
        intent.putExtra(WBConstants.Response.ERRCODE, i);
        intent.putExtra(WBConstants.Response.ERRMSG, str);
        try {
            activity.startActivityForResult(intent, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
        } catch (ActivityNotFoundException e) {
        }
    }

    public WeiboParameters buildUploadPicParam(WeiboParameters weiboParameters) {
        if (hasImage()) {
            weiboParameters.put("img", new String(this.mBase64ImgData));
            return weiboParameters;
        }
        return weiboParameters;
    }

    public String buildUrl(String str) {
        Uri.Builder buildUpon = Uri.parse(SHARE_URL).buildUpon();
        buildUpon.appendQueryParameter("title", this.mShareContent);
        buildUpon.appendQueryParameter("version", WBConstants.WEIBO_SDK_VERSION_CODE);
        if (!TextUtils.isEmpty(this.mAppKey)) {
            buildUpon.appendQueryParameter("source", this.mAppKey);
        }
        if (!TextUtils.isEmpty(this.mToken)) {
            buildUpon.appendQueryParameter("access_token", this.mToken);
        }
        String aid = Utility.getAid(this.mContext, this.mAppKey);
        if (!TextUtils.isEmpty(aid)) {
            buildUpon.appendQueryParameter("aid", aid);
        }
        if (!TextUtils.isEmpty(this.mAppPackage)) {
            buildUpon.appendQueryParameter("packagename", this.mAppPackage);
        }
        if (!TextUtils.isEmpty(this.mHashKey)) {
            buildUpon.appendQueryParameter("key_hash", this.mHashKey);
        }
        if (!TextUtils.isEmpty(str)) {
            buildUpon.appendQueryParameter(REQ_PARAM_PICINFO, str);
        }
        return buildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    public void execRequest(Activity activity, int i) {
        if (i == 3) {
            sendSdkCancleResponse(activity);
            WeiboSdkBrowser.closeBrowser(activity, this.mAuthListenerKey, null);
        }
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppPackage() {
        return this.mAppPackage;
    }

    public WeiboAuthListener getAuthListener() {
        return this.mAuthListener;
    }

    public String getAuthListenerKey() {
        return this.mAuthListenerKey;
    }

    public byte[] getBase64ImgData() {
        return this.mBase64ImgData;
    }

    public String getHashKey() {
        return this.mHashKey;
    }

    public String getShareContent() {
        return this.mShareContent;
    }

    public String getToken() {
        return this.mToken;
    }

    public boolean hasImage() {
        byte[] bArr = this.mBase64ImgData;
        return bArr != null && bArr.length > 0;
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    public void onCreateRequestParamBundle(Bundle bundle) {
        BaseRequest baseRequest = this.mBaseRequest;
        if (baseRequest != null) {
            baseRequest.toBundle(bundle);
        }
        if (!TextUtils.isEmpty(this.mAppPackage)) {
            this.mHashKey = MD5.hexdigest(Utility.getSign(this.mContext, this.mAppPackage));
        }
        bundle.putString("access_token", this.mToken);
        bundle.putString("source", this.mAppKey);
        bundle.putString("packagename", this.mAppPackage);
        bundle.putString("key_hash", this.mHashKey);
        bundle.putString(WBConstants.Base.APP_PKG, this.mAppPackage);
        bundle.putString(WBConstants.Base.APP_KEY, this.mAppKey);
        bundle.putInt(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
        bundle.putString(WBConstants.SIGN, this.mHashKey);
        if (this.mAuthListener != null) {
            WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(this.mContext);
            String genCallbackKey = weiboCallbackManager.genCallbackKey();
            this.mAuthListenerKey = genCallbackKey;
            weiboCallbackManager.setWeiboAuthListener(genCallbackKey, this.mAuthListener);
            bundle.putString(AuthRequestParam.EXTRA_KEY_LISTENER, this.mAuthListenerKey);
        }
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    protected void onSetupRequestParam(Bundle bundle) {
        this.mAppKey = bundle.getString("source");
        this.mAppPackage = bundle.getString("packagename");
        this.mHashKey = bundle.getString("key_hash");
        this.mToken = bundle.getString("access_token");
        String string = bundle.getString(AuthRequestParam.EXTRA_KEY_LISTENER);
        this.mAuthListenerKey = string;
        if (!TextUtils.isEmpty(string)) {
            this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey);
        }
        handleSharedMessage(bundle);
        this.mUrl = buildUrl("");
    }

    public void sendSdkCancleResponse(Activity activity) {
        sendSdkResponse(activity, 1, "send cancel!!!");
    }

    public void sendSdkErrorResponse(Activity activity, String str) {
        sendSdkResponse(activity, 2, str);
    }

    public void sendSdkOkResponse(Activity activity) {
        sendSdkResponse(activity, 0, "send ok!!!");
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public void setAppPackage(String str) {
        this.mAppPackage = str;
    }

    public void setAuthListener(WeiboAuthListener weiboAuthListener) {
        this.mAuthListener = weiboAuthListener;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.mBaseRequest = baseRequest;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
