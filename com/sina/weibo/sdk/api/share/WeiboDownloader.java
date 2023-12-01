package com.sina.weibo.sdk.api.share;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.applog.tracker.Tracker;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.Utility;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/WeiboDownloader.class */
public class WeiboDownloader {
    private static final String CANCEL_CHINESS = "以后再说";
    private static final String CANCEL_ENGLISH = "Download Later";
    private static final String OK_CHINESS = "现在下载";
    private static final String OK_ENGLISH = "Download Now";
    private static final String PROMPT_CHINESS = "未安装微博客户端，是否现在去下载？";
    private static final String PROMPT_ENGLISH = "Sina Weibo client is not installed, download now?";
    private static final String TITLE_CHINESS = "提示";
    private static final String TITLE_ENGLISH = "Notice";

    public static Dialog createDownloadConfirmDialog(final Context context, final IWeiboDownloadListener iWeiboDownloadListener) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (Utility.isChineseLocale(context.getApplicationContext())) {
            charSequence = TITLE_CHINESS;
            charSequence2 = PROMPT_CHINESS;
            charSequence3 = OK_CHINESS;
            charSequence4 = CANCEL_CHINESS;
        } else {
            charSequence = TITLE_ENGLISH;
            charSequence2 = PROMPT_ENGLISH;
            charSequence3 = OK_ENGLISH;
            charSequence4 = CANCEL_ENGLISH;
        }
        return new AlertDialog.Builder(context).setMessage(charSequence2).setTitle(charSequence).setPositiveButton(charSequence3, new DialogInterface.OnClickListener() { // from class: com.sina.weibo.sdk.api.share.WeiboDownloader.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                WeiboDownloader.downloadWeibo(Context.this);
            }
        }).setNegativeButton(charSequence4, new DialogInterface.OnClickListener() { // from class: com.sina.weibo.sdk.api.share.WeiboDownloader.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                IWeiboDownloadListener iWeiboDownloadListener2 = IWeiboDownloadListener.this;
                if (iWeiboDownloadListener2 != null) {
                    iWeiboDownloadListener2.onCancel();
                }
            }
        }).create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void downloadWeibo(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(WBConstants.WEIBO_DOWNLOAD_URL));
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
