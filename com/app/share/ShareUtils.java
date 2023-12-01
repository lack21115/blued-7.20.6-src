package com.app.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.app.share.auto.ShareServiceManager;
import com.app.share.model.ShareEntity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.share.model.ShareEventToMsgEntity;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.share_custom.BaseShareToPlatform;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.utils.ShareCoreUtils;
import java.util.ArrayList;
import java.util.Random;

/* loaded from: source-8756600-dex2jar.jar:com/app/share/ShareUtils.class */
public class ShareUtils extends ShareCoreUtils {

    /* renamed from: a  reason: collision with root package name */
    private static ShareUtils f9211a;

    /* loaded from: source-8756600-dex2jar.jar:com/app/share/ShareUtils$SHARE_FLAG.class */
    public interface SHARE_FLAG {
    }

    public static ShareUtils a() {
        if (f9211a == null) {
            f9211a = new ShareUtils();
        }
        return f9211a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShareEntity a(Context context, String str, View view, Bitmap bitmap, String str2, String str3, String str4, String str5, UserBasicModel userBasicModel) {
        ShareEntity shareEntity = new ShareEntity();
        if (StringUtils.b(str)) {
            shareEntity.flag = 0;
            str = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
        } else {
            shareEntity.flag = 1;
        }
        String a2 = bitmap != null ? BitmapUtils.a(bitmap, false) : BitmapUtils.a(BitmapUtils.a(view), true);
        shareEntity.netImgUrl = str;
        shareEntity.fileUrl = a2;
        shareEntity.linkUrl = str2;
        shareEntity.title = str3;
        shareEntity.content = str4;
        shareEntity.mainBody = str5;
        shareEntity.shareType = 0;
        shareEntity.shareBackLister = null;
        shareEntity.b = -1;
        shareEntity.shareFrom = 1;
        shareEntity.f9215a = userBasicModel;
        shareEntity.j = true;
        return shareEntity;
    }

    public ShareEntity a(String str, View view, String str2, String str3, String str4, String str5, int i) {
        String str6;
        int i2;
        String a2;
        if (StringUtils.b(str) || !str.startsWith("http")) {
            str6 = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
            i2 = 0;
            a2 = view != null ? BitmapUtils.a(BitmapUtils.a(view), true) : "";
        } else {
            i2 = 1;
            a2 = "";
            str6 = str;
        }
        Log.v("drb", "netImgUrl:" + str6 + "flag:" + i2);
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.flag = i2;
        shareEntity.netImgUrl = str6;
        shareEntity.fileUrl = a2;
        shareEntity.linkUrl = str2;
        shareEntity.title = str3;
        shareEntity.content = str4;
        shareEntity.mainBody = str5;
        shareEntity.shareType = i;
        shareEntity.shareBackLister = null;
        shareEntity.ifHideShareToFeed = false;
        if (shareEntity.shareType == 1) {
            shareEntity.shareFrom = 9;
            return shareEntity;
        }
        shareEntity.shareFrom = 6;
        return shareEntity;
    }

    public String a(Context context, ShareToMsgEntity shareToMsgEntity) {
        if (shareToMsgEntity != null) {
            switch (shareToMsgEntity.share_from) {
                case 1:
                    return context.getResources().getString(R.string.share_him_to);
                case 2:
                    return context.getResources().getString(R.string.share_group_to);
                case 3:
                    return context.getResources().getString(R.string.share_live_to);
                case 4:
                case 15:
                    return context.getResources().getString(R.string.share_post_to);
                case 5:
                    return context.getResources().getString(R.string.share_viewpoint_to);
                case 6:
                case 7:
                    return context.getResources().getString(R.string.share_link_to);
                case 8:
                case 10:
                case 13:
                case 14:
                default:
                    return "";
                case 9:
                    return context.getResources().getString(R.string.share_img_to);
                case 11:
                    return context.getResources().getString(R.string.share_circle_to);
                case 12:
                    return context.getResources().getString(R.string.share_live_voice_to);
            }
        }
        return "";
    }

    public void a(final Context context, final long j, final short s, final String str, final String str2, final int i, final int i2, final int i3, final int i4, final int i5, final ShareToMsgEntity shareToMsgEntity, String str3, final String str4) {
        String a2 = a().a(context, shareToMsgEntity);
        CommonAlertDialog.a(context, context.getResources().getString(R.string.hint), a2 + " " + str3, context.getResources().getString(R.string.sure), new DialogInterface.OnClickListener() { // from class: com.app.share.ShareUtils.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                Tracker.onClick(dialogInterface, i6);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(String.valueOf(j));
                arrayList2.add(String.valueOf((int) s));
                if (shareToMsgEntity.share_from != 3) {
                    ShareServiceManager.a().a(shareToMsgEntity, j, s, str, str2, i, i2, i3, i4, i5, str4);
                } else {
                    ShareServiceManager.a().a(shareToMsgEntity.sessionId, (String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), shareToMsgEntity.name);
                    AppMethods.a((CharSequence) context.getString(R.string.liveVideo_message_label_hadShare));
                }
                ((Activity) context).finish();
            }
        }, context.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        if (shareToMsgEntity == null || !(shareToMsgEntity instanceof ShareEventToMsgEntity)) {
            return;
        }
        FeedProtos.ShareChannel shareChannel = FeedProtos.ShareChannel.SHARE_FRIEND;
        if (s == 3) {
            shareChannel = FeedProtos.ShareChannel.SHARE_GROUP;
        }
        ShareServiceManager.a().a(FeedProtos.Event.SHARE_TO_CLICK, shareChannel, String.valueOf(j), "", "", "", "", FeedProtos.SourcePage.ACTIVITY_DETAIL, shareToMsgEntity.url, false, "", false, false, shareToMsgEntity.gid, false, FeedProtos.FeedType.FEED_ACTIVITY);
    }

    public void a(Context context, ShareEntity shareEntity) {
        b(context, shareEntity);
    }

    public void a(Context context, BaseShareEntity.ShareLiveData shareLiveData) {
        String str;
        if (StringUtils.b(shareLiveData.d)) {
            shareLiveData.d = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
        }
        String a2 = shareLiveData.e != null ? BitmapUtils.a(shareLiveData.e, false) : "";
        String str2 = H5Url.a(74) + "?id=" + EncryptTool.b(shareLiveData.f);
        String str3 = shareLiveData.f33710a + " " + AppInfo.d().getResources().getString(R.string.live_share_livingOnBlued) + shareLiveData.f33711c;
        Logger.a("drb", "shareLiveData.description = ", shareLiveData.j);
        if (TextUtils.isEmpty(shareLiveData.b)) {
            int nextInt = new Random().nextInt(3);
            str = nextInt == 0 ? String.format(context.getString(R.string.live_share_blued_one), shareLiveData.f33710a) : nextInt == 1 ? String.format(context.getString(R.string.live_share_blued_two), shareLiveData.f33710a) : String.format(context.getString(R.string.live_share_blued_three), shareLiveData.f33710a);
        } else {
            str = shareLiveData.b;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.flag = 1;
        shareEntity.netImgUrl = shareLiveData.d;
        shareEntity.fileUrl = a2;
        shareEntity.linkUrl = str2;
        shareEntity.title = str3;
        shareEntity.content = str;
        shareEntity.mainBody = str;
        shareEntity.shareType = 0;
        shareEntity.platFormName = shareLiveData.g;
        shareEntity.f = shareLiveData;
        shareEntity.shareFrom = 3;
        shareEntity.k = true;
        BaseShareToPlatform.PopWindowSetting popWindowSetting = new BaseShareToPlatform.PopWindowSetting();
        popWindowSetting.f33708a = true;
        popWindowSetting.b = shareLiveData.i;
        if (TextUtils.isEmpty(shareLiveData.g)) {
            ShareServiceManager.a().b(context, shareLiveData.k, popWindowSetting, shareLiveData.l, shareEntity);
        } else {
            ShareServiceManager.a().a(context, shareLiveData.k, popWindowSetting, shareLiveData.l, shareEntity);
        }
    }

    public void a(Bitmap bitmap, long j, Context context, View view) {
        int i;
        String avatar = UserInfo.getInstance().getLoginUserInfo().getAvatar();
        if (StringUtils.b(avatar)) {
            avatar = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
            i = 0;
        } else {
            i = 1;
        }
        String a2 = bitmap != null ? BitmapUtils.a(bitmap, true) : "";
        String format = String.format(context.getString(R.string.live_share_performance_title), UserInfo.getInstance().getLoginUserInfo().getName());
        String format2 = String.format(context.getResources().getString(R.string.live_share_performance_des), UserInfo.getInstance().getLoginUserInfo().getName());
        String a3 = H5Url.a(42, EncryptTool.b(String.valueOf(j)));
        ShareEntity shareEntity = new ShareEntity();
        BaseShareEntity.ShareLiveData shareLiveData = new BaseShareEntity.ShareLiveData();
        shareLiveData.h = String.valueOf(j);
        shareEntity.flag = i;
        shareEntity.f = shareLiveData;
        shareEntity.netImgUrl = avatar;
        shareEntity.fileUrl = a2;
        shareEntity.linkUrl = a3;
        shareEntity.title = format;
        shareEntity.ifHideShareToPeopleAndGroup = true;
        shareEntity.ifHideShareToFeed = false;
        shareEntity.g = view;
        shareEntity.content = format2;
        shareEntity.mainBody = format2;
        shareEntity.shareType = 0;
        shareEntity.shareFrom = 8;
        ShareServiceManager.a().b(context, null, null, null, shareEntity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Context context, ShareEntity shareEntity) {
        ShareServiceManager.a().b(context, shareEntity.shareBackLister, null, null, shareEntity);
    }

    public void b(Context context, BaseShareEntity.ShareLiveData shareLiveData) {
        if (StringUtils.b(shareLiveData.d)) {
            shareLiveData.d = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
        }
        String a2 = shareLiveData.e != null ? BitmapUtils.a(shareLiveData.e, false) : "";
        String str = H5Url.a(65) + "?room_id=" + EncryptTool.b(shareLiveData.h) + "&source_uid=" + EncryptTool.b(shareLiveData.f);
        String str2 = shareLiveData.f33711c;
        Logger.a("drb", "shareLiveData.description = ", shareLiveData.j);
        String str3 = TextUtils.isEmpty(shareLiveData.b) ? new Random().nextInt(2) == 0 ? "对你的喜欢都藏在我的声音里，快点进来听一听" : "治愈男友音，肯定让你心动，我在房间等你" : shareLiveData.b;
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.flag = 1;
        shareEntity.netImgUrl = shareLiveData.d;
        shareEntity.fileUrl = a2;
        shareEntity.linkUrl = str;
        shareEntity.title = str2;
        shareEntity.content = str3;
        shareEntity.mainBody = str3;
        shareEntity.shareType = 0;
        shareEntity.platFormName = shareLiveData.g;
        shareEntity.f = shareLiveData;
        shareEntity.shareFrom = 12;
        shareEntity.k = true;
        BaseShareToPlatform.PopWindowSetting popWindowSetting = new BaseShareToPlatform.PopWindowSetting();
        popWindowSetting.f33708a = true;
        popWindowSetting.b = shareLiveData.i;
        ShareServiceManager.a().b(context, shareLiveData.k, popWindowSetting, shareLiveData.l, shareEntity);
    }
}
