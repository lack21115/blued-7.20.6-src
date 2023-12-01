package com.soft.blued.ui.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import com.app.share.model.ShareEntity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.share.model.ShareEventToMsgEntity;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.share.Constants;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.blued.community.ui.topic.model.BluedTopic;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.msg.model.ShareUserInfo;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.BaseShareToPlatform;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.ShareCoreUtils;
import com.soft.blued.utils.StringUtils;
import java.util.Arrays;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share/ShareToPlatform.class */
public class ShareToPlatform extends BaseShareToPlatform {

    /* renamed from: c  reason: collision with root package name */
    private ShareEntity f20004c;

    public ShareToPlatform(Context context, ShareCoreUtils.ShareBackLister shareBackLister, BaseShareToPlatform.PopWindowSetting popWindowSetting, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener) {
        super(context, shareBackLister, popWindowSetting, shareOptionsItemClickListener);
    }

    private Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return Bitmap.createBitmap(view.getDrawingCache(), 0, 0, AppInfo.l, DensityUtils.a(this.f20013a, 189.0f), (Matrix) null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.app.share.model.ShareEntity r18, int r19) {
        /*
            Method dump skipped, instructions count: 686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.share.ShareToPlatform.a(com.app.share.model.ShareEntity, int):void");
    }

    private void a(BluedIngSelfFeed bluedIngSelfFeed, ShareToMsgEntity shareToMsgEntity) {
        if (bluedIngSelfFeed.is_vote == 1) {
            shareToMsgEntity.type = 3;
        } else if (bluedIngSelfFeed.is_videos.equals("1") && bluedIngSelfFeed.feed_videos != null && bluedIngSelfFeed.feed_videos.length > 0) {
            shareToMsgEntity.type = 2;
        } else if (bluedIngSelfFeed.feed_pics == null || bluedIngSelfFeed.feed_pics.length <= 0) {
            shareToMsgEntity.type = 0;
        } else {
            shareToMsgEntity.type = 1;
        }
    }

    private void a(BluedIngSelfFeed bluedIngSelfFeed, ShareToMsgEntity shareToMsgEntity, boolean z) {
        if (z && bluedIngSelfFeed.feed_videos != null && bluedIngSelfFeed.feed_videos.length > 0) {
            shareToMsgEntity.image = bluedIngSelfFeed.feed_videos[0];
        } else if (bluedIngSelfFeed.feed_pics != null && bluedIngSelfFeed.feed_pics.length > 0) {
            shareToMsgEntity.image = bluedIngSelfFeed.feed_pics[0];
        }
        if (bluedIngSelfFeed.feed_pics != null) {
            shareToMsgEntity.imageList = Arrays.asList(bluedIngSelfFeed.feed_pics);
        }
        shareToMsgEntity.shareUserInfo = new ShareUserInfo();
        shareToMsgEntity.shareUserInfo.avatar = bluedIngSelfFeed.user_avatar;
        shareToMsgEntity.shareUserInfo.badge = bluedIngSelfFeed.vbadge;
        shareToMsgEntity.shareUserInfo.nick = bluedIngSelfFeed.user_name;
    }

    public static BluedIngSelfFeed c(ShareEntity shareEntity) {
        if (shareEntity == null || !(shareEntity.f6375a instanceof BluedIngSelfFeed)) {
            return null;
        }
        return (BluedIngSelfFeed) shareEntity.f6375a;
    }

    private void c() {
        if (PopMenuUtils.a(this.f20013a)) {
            return;
        }
        if (this.f20004c.shareFrom != 6) {
            ShareEntity shareEntity = this.f20004c;
            shareEntity.title = shareEntity.content;
        }
        if (this.f20004c.shareFrom != 8) {
            FeedAddPostFragment.a(this.f20013a, this.f20004c);
            return;
        }
        this.f20004c.g.setDrawingCacheEnabled(false);
        String e = RecyclingUtils.e("photo");
        BitmapUtils.a(a(this.f20004c.g), e, 100);
        ChildImageInfo childImageInfo = new ChildImageInfo();
        childImageInfo.mImagePath = e;
        SelectPhotoManager.a().a(childImageInfo);
        ShareEntity shareEntity2 = new ShareEntity();
        shareEntity2.title = AppInfo.d().getString(R.string.feed_share_text);
        shareEntity2.shareType = 1;
        FeedAddPostFragment.a(this.f20013a, shareEntity2);
    }

    public static int d(ShareEntity shareEntity) {
        int i = shareEntity.shareFrom;
        if (i != 8) {
            if (i != 9) {
                if (i != 15) {
                    switch (i) {
                        case 1:
                            return 3;
                        case 2:
                            return 0;
                        case 3:
                            return 2;
                        case 4:
                            return 1;
                        case 5:
                            return 6;
                        case 6:
                            return 4;
                        default:
                            return -1;
                    }
                }
                return 1;
            }
            return 4;
        }
        return 5;
    }

    public static String e(ShareEntity shareEntity) {
        int i = shareEntity.shareFrom;
        if (i != 3) {
            if (i != 4) {
                if (i != 8) {
                    if (i != 15) {
                        return "";
                    }
                }
            }
            return c(shareEntity).feed_id;
        }
        return shareEntity.f.h;
    }

    private static MyCircleModel f(ShareEntity shareEntity) {
        if (shareEntity == null || !(shareEntity.f6375a instanceof MyCircleModel)) {
            return null;
        }
        return (MyCircleModel) shareEntity.f6375a;
    }

    private static EventDetailsModel g(ShareEntity shareEntity) {
        if (shareEntity == null || !(shareEntity.f6375a instanceof EventDetailsModel)) {
            return null;
        }
        return (EventDetailsModel) shareEntity.f6375a;
    }

    private static UserBasicModel h(ShareEntity shareEntity) {
        if (shareEntity == null || !(shareEntity.f6375a instanceof UserBasicModel)) {
            return null;
        }
        return (UserBasicModel) shareEntity.f6375a;
    }

    private static BluedTopic i(ShareEntity shareEntity) {
        if (shareEntity == null || !(shareEntity.f6375a instanceof BluedTopic)) {
            return null;
        }
        return (BluedTopic) shareEntity.f6375a;
    }

    private static BluedGroupLists j(ShareEntity shareEntity) {
        if (shareEntity == null || !(shareEntity.f6375a instanceof BluedGroupLists)) {
            return null;
        }
        return (BluedGroupLists) shareEntity.f6375a;
    }

    public void a() {
        if (PopMenuUtils.a(this.f20013a)) {
            return;
        }
        if (c(this.f20004c) == null) {
            if (i(this.f20004c) != null) {
                FeedAddPostFragment.b(this.f20013a, i(this.f20004c));
                return;
            } else if (f(this.f20004c) != null) {
                FeedAddPostFragment.a(this.f20013a, f(this.f20004c));
                return;
            } else if (g(this.f20004c) != null) {
                FeedAddPostFragment.a(this.f20013a, g(this.f20004c));
                return;
            } else {
                return;
            }
        }
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        if (c(this.f20004c).repost == null || c(this.f20004c).repost.feed_is_delete != 1) {
            if (c(this.f20004c).is_repost == 1) {
                bluedIngSelfFeed.feed_id = c(this.f20004c).feed_id;
                bluedIngSelfFeed.repost = c(this.f20004c).repost;
                if (c(this.f20004c).is_feed_anonym == 1) {
                    bluedIngSelfFeed.feed_content = "//" + c(this.f20004c).user_name + "：" + c(this.f20004c).feed_content;
                } else {
                    bluedIngSelfFeed.feed_content = "//" + StringUtils.b(c(this.f20004c).user_name, c(this.f20004c).feed_uid) + "：" + c(this.f20004c).feed_content;
                }
            } else {
                bluedIngSelfFeed.feed_id = c(this.f20004c).feed_id;
                bluedIngSelfFeed.repost = c(this.f20004c);
                bluedIngSelfFeed.feed_content = "";
                if (this.f20004c.shareFrom == 11) {
                    bluedIngSelfFeed.is_share_posting = 1;
                }
                if (this.f20004c.shareFrom == 13) {
                    bluedIngSelfFeed.is_share_circle = 1;
                }
            }
            FeedAddPostFragment.a(this.f20013a, bluedIngSelfFeed);
        }
    }

    @Override // com.soft.blued.ui.share_custom.BaseShareToPlatform
    public void a(int i, ShareCoreUtils.ShareBackLister shareBackLister, BaseShareToPlatform.PopWindowSetting popWindowSetting) {
        if (i == 2131888043) {
            a();
        } else if (i == 2131887268) {
            c();
        } else if (i == 2131891709) {
            b();
        }
        a(this.f20004c, i);
        super.a(i, shareBackLister, popWindowSetting);
    }

    public void a(ShareEntity shareEntity) {
        this.f20004c = shareEntity;
        if (!TextUtils.isEmpty(shareEntity.platFormName) && this.f20004c.platFormName.equals(Constants.BLUED_FEED)) {
            c();
        } else if (!TextUtils.isEmpty(this.f20004c.platFormName) && this.f20004c.platFormName.equals(Constants.REPOST_FEED)) {
            a();
        } else if (!TextUtils.isEmpty(this.f20004c.platFormName) && this.f20004c.platFormName.equals(Constants.BLUED_GROUP_AND_PEOPLE)) {
            b();
        }
        super.b((BaseShareEntity) shareEntity);
    }

    @Override // com.soft.blued.ui.share_custom.BaseShareToPlatform
    public void a(String str) {
        String str2 = this.f20004c.shareFrom == 6 ? this.f20004c.linkUrl : "";
        int i = -1;
        if (TextUtils.equals(str, Constants.SinaWeiboNAME)) {
            i = 2;
        } else if (TextUtils.equals(str, Constants.QQNAME)) {
            i = 5;
        } else if (TextUtils.equals(str, Constants.WechatNAME)) {
            i = 3;
        } else if (TextUtils.equals(str, Constants.WechatMomentsNAME)) {
            i = 4;
        }
        InstantLog.b(d(this.f20004c), i, str2, e(this.f20004c));
        super.a(str);
    }

    protected void b() {
        ShareToMsgEntity shareToMsgEntity;
        String str;
        if ((this.f20004c.shareFrom == 6 || this.f20004c.shareFrom == 9) && PopMenuUtils.a(this.f20013a)) {
            return;
        }
        ShareToMsgEntity shareToMsgEntity2 = new ShareToMsgEntity();
        switch (this.f20004c.shareFrom) {
            case 1:
                shareToMsgEntity2.title = this.f20013a.getResources().getString(R.string.biao_im_msg_share_person);
                shareToMsgEntity = shareToMsgEntity2;
                if (h(this.f20004c) != null) {
                    shareToMsgEntity2.name = h(this.f20004c).name;
                    shareToMsgEntity2.description = h(this.f20004c).description;
                    shareToMsgEntity2.url = "http://native.blued.cn/?action=profile&uid=" + h(this.f20004c).uid;
                    shareToMsgEntity2.image = this.f20004c.netImgUrl;
                    shareToMsgEntity2.shareUserInfo = new ShareUserInfo();
                    shareToMsgEntity2.shareUserInfo.age = h(this.f20004c).age;
                    shareToMsgEntity2.shareUserInfo.height = h(this.f20004c).height;
                    shareToMsgEntity2.shareUserInfo.weight = h(this.f20004c).weight;
                    shareToMsgEntity2.shareUserInfo.role = h(this.f20004c).role;
                    shareToMsgEntity2.shareUserInfo.badge = h(this.f20004c).vbadge;
                    shareToMsgEntity2.shareUserInfo.vip_grade = h(this.f20004c).vip_grade;
                    shareToMsgEntity2.shareUserInfo.vip_exp_lvl = h(this.f20004c).vip_exp_lvl;
                    shareToMsgEntity2.shareUserInfo.expire_type = h(this.f20004c).expire_type;
                    shareToMsgEntity2.shareUserInfo.is_hide_vip_look = h(this.f20004c).is_hide_vip_look;
                    shareToMsgEntity2.shareUserInfo.is_vip_annual = h(this.f20004c).is_vip_annual;
                    shareToMsgEntity = shareToMsgEntity2;
                    break;
                }
                break;
            case 2:
                if (j(this.f20004c) != null) {
                    shareToMsgEntity2.image = j(this.f20004c).groups_avatar;
                    shareToMsgEntity2.gid = j(this.f20004c).groups_gid;
                    shareToMsgEntity2.isCreatorOrAdmin = "1".equals(j(this.f20004c).groups_is_admins) ? "1" : "1".equals(j(this.f20004c).groups_is_created) ? "1" : "0";
                    shareToMsgEntity2.name = j(this.f20004c).groups_name;
                    shareToMsgEntity2.description = j(this.f20004c).groups_city;
                }
                shareToMsgEntity2.url = this.f20004c.linkUrl;
                shareToMsgEntity2.title = this.f20013a.getResources().getString(R.string.biao_im_msg_share_toone);
                shareToMsgEntity = shareToMsgEntity2;
                break;
            case 3:
                shareToMsgEntity2.title = this.f20004c.title;
                shareToMsgEntity2.name = this.f20004c.content;
                shareToMsgEntity2.image = this.f20004c.netImgUrl;
                shareToMsgEntity2.description = this.f20004c.mainBody;
                shareToMsgEntity2.url = this.f20004c.linkUrl;
                shareToMsgEntity2.sessionId = Long.valueOf(this.f20004c.f.h).longValue();
                shareToMsgEntity = shareToMsgEntity2;
                break;
            case 4:
            case 15:
                shareToMsgEntity2.title = this.f20013a.getResources().getString(R.string.biao_im_msg_share_feed);
                shareToMsgEntity = shareToMsgEntity2;
                if (c(this.f20004c) != null) {
                    shareToMsgEntity2.gid = c(this.f20004c).feed_id;
                    if (TextUtils.isEmpty(c(this.f20004c).feed_content)) {
                        shareToMsgEntity2.name = c(this.f20004c).user_name + this.f20013a.getResources().getString(R.string.biao_im_msg_feed_of_someone);
                    } else {
                        shareToMsgEntity2.name = c(this.f20004c).feed_content;
                    }
                    shareToMsgEntity2.url = "http://native.blued.cn/?action=feed&fid=" + EncryptTool.b(c(this.f20004c).feed_id) + "&ads=" + c(this.f20004c).is_ads;
                    a(c(this.f20004c), shareToMsgEntity2, "1".equals(c(this.f20004c).is_videos));
                    shareToMsgEntity = shareToMsgEntity2;
                    if (c(this.f20004c).is_repost == 1) {
                        shareToMsgEntity = shareToMsgEntity2;
                        if (c(this.f20004c).repost != null) {
                            shareToMsgEntity2.repost = new ShareToMsgEntity();
                            if (TextUtils.isEmpty(c(this.f20004c).repost.feed_content)) {
                                shareToMsgEntity2.repost.name = c(this.f20004c).repost.user_name + this.f20013a.getResources().getString(R.string.biao_im_msg_feed_of_someone);
                            } else {
                                ShareToMsgEntity shareToMsgEntity3 = shareToMsgEntity2.repost;
                                shareToMsgEntity3.name = ("@(name:" + c(this.f20004c).repost.user_name + ",id:" + EncryptTool.b(c(this.f20004c).repost.feed_uid) + ")") + "：" + c(this.f20004c).repost.feed_content;
                            }
                            a(c(this.f20004c).repost, shareToMsgEntity2.repost, "1".equals(c(this.f20004c).repost.is_videos));
                            a(c(this.f20004c).repost, shareToMsgEntity2.repost);
                            shareToMsgEntity = shareToMsgEntity2;
                            break;
                        }
                    }
                }
                break;
            case 5:
            case 7:
            case 8:
            default:
                shareToMsgEntity2.title = this.f20004c.title;
                shareToMsgEntity2.name = this.f20004c.content;
                shareToMsgEntity2.image = this.f20004c.netImgUrl;
                shareToMsgEntity2.description = this.f20004c.mainBody;
                shareToMsgEntity2.url = this.f20004c.linkUrl;
                shareToMsgEntity = shareToMsgEntity2;
                break;
            case 6:
                shareToMsgEntity2.title = this.f20004c.title;
                shareToMsgEntity2.name = this.f20004c.title;
                if (this.f20004c.flag == 0) {
                    shareToMsgEntity2.image = this.f20004c.fileUrl;
                } else {
                    shareToMsgEntity2.image = this.f20004c.netImgUrl;
                }
                shareToMsgEntity2.description = this.f20004c.content;
                shareToMsgEntity2.url = this.f20004c.linkUrl;
                shareToMsgEntity = shareToMsgEntity2;
                break;
            case 9:
                if (this.f20004c.flag != 0) {
                    shareToMsgEntity2.image = this.f20004c.netImgUrl;
                    shareToMsgEntity = shareToMsgEntity2;
                    break;
                } else {
                    shareToMsgEntity2.image = this.f20004c.fileUrl;
                    shareToMsgEntity = shareToMsgEntity2;
                    break;
                }
            case 10:
                shareToMsgEntity2.url = "http://native.blued.cn/?action=topic&id=" + i(this.f20004c).super_did + "&from=msg";
                shareToMsgEntity2.title = this.f20013a.getResources().getString(R.string.share_a_topic_to_you);
                shareToMsgEntity2.name = i(this.f20004c).name;
                shareToMsgEntity2.image = i(this.f20004c).avatar;
                shareToMsgEntity = shareToMsgEntity2;
                break;
            case 11:
                boolean z = false;
                shareToMsgEntity2.title = String.format(this.f20013a.getResources().getString(R.string.biao_im_msg_share_circle_post), this.f20004c.title);
                shareToMsgEntity = shareToMsgEntity2;
                if (c(this.f20004c) != null) {
                    shareToMsgEntity2.name = c(this.f20004c).feed_pure_content;
                    shareToMsgEntity2.gid = c(this.f20004c).feed_id;
                    shareToMsgEntity2.url = "http://native.blued.cn/?action=base_post_detail&post_id=" + c(this.f20004c).feed_id + "&base_id=" + c(this.f20004c).circle_id;
                    BluedIngSelfFeed c2 = c(this.f20004c);
                    if (c(this.f20004c).is_video_posts == 1) {
                        z = true;
                    }
                    a(c2, shareToMsgEntity2, z);
                    shareToMsgEntity = shareToMsgEntity2;
                    if (c(this.f20004c).is_repost == 1) {
                        shareToMsgEntity = shareToMsgEntity2;
                        if (c(this.f20004c).repost != null) {
                            shareToMsgEntity2.repost = new ShareToMsgEntity();
                            shareToMsgEntity2.repost.name = c(this.f20004c).repost.feed_pure_content;
                            shareToMsgEntity2.repost.gid = c(this.f20004c).repost.feed_id;
                            shareToMsgEntity2.repost.url = "http://native.blued.cn/?action=base_post_detail&post_id=" + c(this.f20004c).repost.feed_id + "&base_id=" + c(this.f20004c).repost.circle_id;
                            a(c(this.f20004c).repost, shareToMsgEntity2.repost, "1".equals(c(this.f20004c).repost.is_videos));
                            a(c(this.f20004c).repost, shareToMsgEntity2.repost);
                            shareToMsgEntity = shareToMsgEntity2;
                            break;
                        }
                    }
                }
                break;
            case 12:
                shareToMsgEntity2.title = this.f20004c.title;
                shareToMsgEntity2.name = this.f20004c.content;
                shareToMsgEntity2.image = this.f20004c.netImgUrl;
                shareToMsgEntity2.description = this.f20004c.mainBody;
                shareToMsgEntity2.url = this.f20004c.linkUrl;
                shareToMsgEntity2.sessionId = Long.valueOf(this.f20004c.f.h).longValue();
                shareToMsgEntity = shareToMsgEntity2;
                break;
            case 13:
                shareToMsgEntity2.title = this.f20013a.getResources().getString(R.string.biao_im_msg_share_circle);
                shareToMsgEntity = shareToMsgEntity2;
                if (f(this.f20004c) != null) {
                    shareToMsgEntity2.name = this.f20004c.title;
                    shareToMsgEntity2.description = this.f20004c.content;
                    shareToMsgEntity2.gid = f(this.f20004c).circle_id;
                    shareToMsgEntity2.url = "http://native.blued.cn/?action=base_detail&base_id=" + EncryptTool.b(f(this.f20004c).circle_id) + "&normal_back=1";
                    shareToMsgEntity2.image = this.f20004c.netImgUrl;
                    shareToMsgEntity = shareToMsgEntity2;
                    break;
                }
                break;
            case 14:
                EventDetailsModel g = g(this.f20004c);
                shareToMsgEntity = shareToMsgEntity2;
                if (g != null) {
                    ShareToMsgEntity shareEventToMsgEntity = new ShareEventToMsgEntity();
                    ((ShareEventToMsgEntity) shareEventToMsgEntity).activityName = g.name;
                    ((ShareEventToMsgEntity) shareEventToMsgEntity).isActivity = 1;
                    ((ShareEventToMsgEntity) shareEventToMsgEntity).activityTime = TimeAndDateUtils.c(TimeAndDateUtils.j(g.activity_date), true);
                    if (g.mode_id == 2) {
                        ((ShareEventToMsgEntity) shareEventToMsgEntity).activityLocation = AppInfo.d().getResources().getString(R.string.event_online_event);
                    } else if (g.mode_id == 1) {
                        if (TextUtils.isEmpty(g.city) || TextUtils.isEmpty(g.location)) {
                            str = !TextUtils.isEmpty(g.city) ? g.city : !TextUtils.isEmpty(g.location) ? g.location : "";
                        } else {
                            str = g.city + "·" + g.location;
                        }
                        ((ShareEventToMsgEntity) shareEventToMsgEntity).activityLocation = str;
                    }
                    ((ShareEventToMsgEntity) shareEventToMsgEntity).gid = g.id;
                    ((ShareEventToMsgEntity) shareEventToMsgEntity).url = "http://native.blued.cn/?action=event_details&event_id=" + g.id;
                    ((ShareEventToMsgEntity) shareEventToMsgEntity).title = g(this.f20004c).name;
                    ((ShareEventToMsgEntity) shareEventToMsgEntity).name = this.f20004c.content;
                    ((ShareEventToMsgEntity) shareEventToMsgEntity).description = this.f20004c.mainBody;
                    ((ShareEventToMsgEntity) shareEventToMsgEntity).image = AvatarUtils.a(g.pic);
                    shareToMsgEntity = shareEventToMsgEntity;
                    break;
                }
                break;
        }
        shareToMsgEntity.type = this.f20004c.shareType;
        shareToMsgEntity.share_from = this.f20004c.shareFrom;
        ChatHelperV4.a().a(this.f20013a, shareToMsgEntity);
    }

    public void b(ShareEntity shareEntity) {
        this.f20004c = shareEntity;
        super.a((BaseShareEntity) shareEntity);
    }
}
