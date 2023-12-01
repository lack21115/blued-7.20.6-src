package com.blued.community.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import com.app.share.ShareUtils;
import com.app.share.model.ShareEntity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.topic.model.BluedTopic;
import com.soft.blued.utils.ShareCoreUtils;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/CommunityShareUtils.class */
public class CommunityShareUtils extends ShareUtils {

    /* renamed from: a  reason: collision with root package name */
    private static CommunityShareUtils f20464a;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, ShareEntity shareEntity, Bitmap bitmap) {
        Bitmap a2 = BitmapUtils.a(bitmap, BitmapUtils.a(BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_share_feed_video_play), 1.2f));
        if (a2 != null) {
            shareEntity.fileUrl = BitmapUtils.a(a2, false);
        }
        shareEntity.netImgUrl = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
        shareEntity.title = String.format(context.getResources().getString(R.string.share_video_feed_title), bluedIngSelfFeed.user_name);
        shareEntity.mainBody = StringUtils.d(bluedIngSelfFeed.feed_content) ? context.getResources().getString(R.string.feed_share_mainbody_null_for_sight) : bluedIngSelfFeed.feed_content;
        b(context, shareEntity);
    }

    public static CommunityShareUtils b() {
        if (f20464a == null) {
            f20464a = new CommunityShareUtils();
        }
        return f20464a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(final Context context, View view, Bitmap bitmap, final BluedIngSelfFeed bluedIngSelfFeed, final String str, boolean z, int i, String str2, int i2, int i3) {
        final ShareEntity shareEntity = new ShareEntity();
        if (!StringUtils.d(bluedIngSelfFeed.feed_content)) {
            shareEntity.content = StringUtils.a(bluedIngSelfFeed.feed_content, true, true, true, "").toString();
        } else if (!StringUtils.d(bluedIngSelfFeed.is_videos)) {
            if (bluedIngSelfFeed.is_videos.equals("0")) {
                shareEntity.content = bluedIngSelfFeed.user_name + " " + context.getResources().getString(R.string.feed_share_mainbody_null_for_pic);
            } else if (bluedIngSelfFeed.is_videos.equals("1")) {
                shareEntity.content = bluedIngSelfFeed.user_name + " " + context.getResources().getString(R.string.feed_share_mainbody_null_for_sight);
            }
        }
        shareEntity.flag = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(EncryptTool.b(bluedIngSelfFeed.feed_id));
        sb.append(bluedIngSelfFeed.is_ads == 1 ? "&is_ads=1" : "");
        shareEntity.linkUrl = H5Url.a(28, sb.toString());
        shareEntity.shareBackLister = null;
        shareEntity.b = -1;
        shareEntity.f9215a = bluedIngSelfFeed;
        if (bluedIngSelfFeed.is_feed_anonym == 1) {
            shareEntity.shareFrom = 15;
        } else {
            shareEntity.shareFrom = 4;
        }
        shareEntity.ifHideRepostToFeed = z;
        shareEntity.f9216c = i;
        shareEntity.d = str2;
        shareEntity.e = i2;
        shareEntity.h = true;
        shareEntity.i = i3;
        shareEntity.shareBackLister = new ShareCoreUtils.ShareBackLister() { // from class: com.blued.community.utils.CommunityShareUtils.1
            @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
            public void a(String str3) {
                CommunityServiceManager.d().b(str3, str);
            }

            @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
            public void b(String str3) {
            }

            @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
            public void c(String str3) {
            }

            @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
            public void d(String str3) {
            }
        };
        if (!StringUtils.d(bluedIngSelfFeed.is_videos)) {
            shareEntity.shareType = 0;
            if (bluedIngSelfFeed.is_videos.equals("0")) {
                if (bluedIngSelfFeed.feed_pics != null && bluedIngSelfFeed.feed_pics.length > 0) {
                    shareEntity.netImgUrl = bluedIngSelfFeed.feed_pics[0];
                } else if (TextUtils.isEmpty(bluedIngSelfFeed.user_avatar) || bluedIngSelfFeed.is_feed_anonym == 1) {
                    shareEntity.netImgUrl = "";
                } else {
                    shareEntity.netImgUrl = bluedIngSelfFeed.user_avatar;
                }
                if (bluedIngSelfFeed.is_feed_anonym == 1 && view != null) {
                    shareEntity.fileUrl = BitmapUtils.a(BitmapUtils.a(view), true);
                } else if (bitmap != null) {
                    shareEntity.fileUrl = BitmapUtils.a(bitmap, false);
                }
                if (TextUtils.isEmpty(shareEntity.netImgUrl)) {
                    shareEntity.flag = 0;
                    shareEntity.netImgUrl = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
                } else {
                    shareEntity.flag = 1;
                }
                shareEntity.title = String.format(context.getResources().getString(R.string.share_nonvideo_feed_title), bluedIngSelfFeed.user_name);
                shareEntity.mainBody = StringUtils.d(bluedIngSelfFeed.feed_content) ? context.getResources().getString(R.string.feed_share_mainbody_null_for_pic) : bluedIngSelfFeed.feed_content;
                b(context, shareEntity);
            } else if (bluedIngSelfFeed.is_videos.equals("1")) {
                shareEntity.shareType = 2;
                if (bluedIngSelfFeed.feed_videos == null || bluedIngSelfFeed.feed_videos.length <= 0) {
                    a(context, bluedIngSelfFeed, shareEntity, bitmap);
                } else {
                    ImageFileLoader.a((IRequestHost) null).b(bluedIngSelfFeed.feed_videos[0]).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.utils.CommunityShareUtils.2
                        @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                        public void onUIFinish(File file, Exception exc) {
                            if (file == null || !file.exists()) {
                                CommunityShareUtils.this.a(context, bluedIngSelfFeed, shareEntity, (Bitmap) null);
                                return;
                            }
                            CommunityShareUtils.this.a(context, bluedIngSelfFeed, shareEntity, BitmapFactory.decodeFile(file.getPath()));
                        }
                    }).a();
                }
            }
        }
        if (bluedIngSelfFeed.is_vote == 1) {
            shareEntity.shareType = 3;
        }
        if (StringUtils.d(bluedIngSelfFeed.share_url)) {
            return;
        }
        CommunityHttpUtils.a(bluedIngSelfFeed.share_url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, int i) {
        ShareEntity shareEntity = new ShareEntity();
        if (StringUtils.d(bluedIngSelfFeed.feed_pure_content)) {
            shareEntity.content = context.getResources().getString(R.string.circle_post_share_default);
        } else {
            shareEntity.content = StringUtils.a(bluedIngSelfFeed.feed_pure_content, true, true, true, "").toString();
            if (!shareEntity.content.isEmpty() && shareEntity.content.length() > 100) {
                shareEntity.content = shareEntity.content.substring(0, 100);
            }
        }
        shareEntity.flag = 1;
        shareEntity.linkUrl = H5Url.a(29, EncryptTool.b(bluedIngSelfFeed.circle_id), EncryptTool.b(bluedIngSelfFeed.feed_id));
        shareEntity.shareBackLister = null;
        shareEntity.b = -1;
        shareEntity.f9215a = bluedIngSelfFeed;
        shareEntity.shareFrom = 11;
        shareEntity.i = i;
        shareEntity.l = true;
        shareEntity.ifHideRepostToFeed = false;
        shareEntity.shareType = 0;
        if (bluedIngSelfFeed.is_video_posts == 1 && bluedIngSelfFeed.feed_videos != null && bluedIngSelfFeed.feed_videos.length > 0) {
            shareEntity.netImgUrl = bluedIngSelfFeed.feed_videos[0];
        } else if (bluedIngSelfFeed.feed_pics == null || bluedIngSelfFeed.feed_pics.length <= 0) {
            shareEntity.netImgUrl = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
        } else {
            shareEntity.netImgUrl = bluedIngSelfFeed.feed_pics[0];
        }
        if (bluedIngSelfFeed.is_vote == 1) {
            shareEntity.shareType = 3;
        }
        shareEntity.title = bluedIngSelfFeed.circle_title;
        shareEntity.mainBody = context.getResources().getString(R.string.circle_share_body);
        b(context, shareEntity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, MyCircleModel myCircleModel) {
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.title = myCircleModel.title + "圈子";
        if (StringUtils.d(myCircleModel.description)) {
            shareEntity.content = context.getResources().getString(R.string.circle_share_default);
        } else {
            shareEntity.content = myCircleModel.description;
        }
        shareEntity.flag = 1;
        shareEntity.linkUrl = H5Url.a(30, EncryptTool.b(myCircleModel.circle_id));
        shareEntity.shareBackLister = null;
        shareEntity.b = -1;
        shareEntity.f9215a = myCircleModel;
        shareEntity.m = true;
        shareEntity.ifHideRepostToFeed = false;
        shareEntity.shareType = 0;
        shareEntity.shareFrom = 13;
        shareEntity.netImgUrl = myCircleModel.cover;
        shareEntity.mainBody = shareEntity.content;
        b(context, shareEntity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, EventDetailsModel eventDetailsModel) {
        ShareEntity shareEntity = new ShareEntity();
        if (eventDetailsModel.mode_id == 1) {
            shareEntity.title = "线下活动：" + eventDetailsModel.name;
            shareEntity.content = eventDetailsModel.city + "·" + eventDetailsModel.location;
        } else {
            shareEntity.title = "线上活动：" + eventDetailsModel.name;
            if (TextUtils.isEmpty(eventDetailsModel.online_text)) {
                shareEntity.content = "线上";
            } else {
                shareEntity.content = eventDetailsModel.online_text;
            }
        }
        shareEntity.flag = 1;
        shareEntity.linkUrl = H5Url.a(31, EncryptTool.b(eventDetailsModel.id), EncryptTool.b(UserInfo.getInstance().getLoginUserInfo().uid));
        shareEntity.shareBackLister = null;
        shareEntity.b = -1;
        shareEntity.f9215a = eventDetailsModel;
        shareEntity.n = true;
        shareEntity.ifHideRepostToFeed = false;
        shareEntity.shareType = 0;
        shareEntity.shareFrom = 14;
        if (TextUtils.isEmpty(eventDetailsModel.pic)) {
            shareEntity.netImgUrl = "https://www.bldimg.com/patch/new_image.png";
        } else {
            shareEntity.netImgUrl = eventDetailsModel.pic;
        }
        shareEntity.mainBody = shareEntity.content;
        b(context, shareEntity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, BluedTopic bluedTopic) {
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.content = "";
        shareEntity.flag = 1;
        shareEntity.linkUrl = H5Url.a(43, bluedTopic.super_did);
        shareEntity.shareBackLister = null;
        shareEntity.b = -1;
        shareEntity.f9215a = bluedTopic;
        shareEntity.ifHideRepostToFeed = false;
        shareEntity.shareFrom = 10;
        shareEntity.shareType = 0;
        shareEntity.shareBackLister = new ShareCoreUtils.ShareBackLister() { // from class: com.blued.community.utils.CommunityShareUtils.3
            @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
            public void a(String str) {
            }

            @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
            public void b(String str) {
            }

            @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
            public void c(String str) {
            }

            @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
            public void d(String str) {
            }
        };
        shareEntity.netImgUrl = bluedTopic.avatar;
        if (StringUtils.d(shareEntity.netImgUrl)) {
            shareEntity.netImgUrl = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
        }
        shareEntity.title = bluedTopic.name;
        String str = UserInfo.getInstance().getLoginUserInfo().name;
        context.getResources().getString(R.string.shared_a_topic);
        shareEntity.content = AppInfo.d().getString(R.string.share_a_topic_to_you);
        shareEntity.mainBody = bluedTopic.description;
        b(context, shareEntity);
    }
}
