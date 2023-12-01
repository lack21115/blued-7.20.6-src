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
    private ShareEntity f33695c;

    public ShareToPlatform(Context context, ShareCoreUtils.ShareBackLister shareBackLister, BaseShareToPlatform.PopWindowSetting popWindowSetting, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener) {
        super(context, shareBackLister, popWindowSetting, shareOptionsItemClickListener);
    }

    private Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return Bitmap.createBitmap(view.getDrawingCache(), 0, 0, AppInfo.l, DensityUtils.a(this.f33704a, 189.0f), (Matrix) null, false);
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
        if (shareEntity == null || !(shareEntity.f9215a instanceof BluedIngSelfFeed)) {
            return null;
        }
        return (BluedIngSelfFeed) shareEntity.f9215a;
    }

    private void c() {
        if (PopMenuUtils.a(this.f33704a)) {
            return;
        }
        if (this.f33695c.shareFrom != 6) {
            ShareEntity shareEntity = this.f33695c;
            shareEntity.title = shareEntity.content;
        }
        if (this.f33695c.shareFrom != 8) {
            FeedAddPostFragment.a(this.f33704a, this.f33695c);
            return;
        }
        this.f33695c.g.setDrawingCacheEnabled(false);
        String e = RecyclingUtils.e("photo");
        BitmapUtils.a(a(this.f33695c.g), e, 100);
        ChildImageInfo childImageInfo = new ChildImageInfo();
        childImageInfo.mImagePath = e;
        SelectPhotoManager.a().a(childImageInfo);
        ShareEntity shareEntity2 = new ShareEntity();
        shareEntity2.title = AppInfo.d().getString(2131888047);
        shareEntity2.shareType = 1;
        FeedAddPostFragment.a(this.f33704a, shareEntity2);
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
        if (shareEntity == null || !(shareEntity.f9215a instanceof MyCircleModel)) {
            return null;
        }
        return (MyCircleModel) shareEntity.f9215a;
    }

    private static EventDetailsModel g(ShareEntity shareEntity) {
        if (shareEntity == null || !(shareEntity.f9215a instanceof EventDetailsModel)) {
            return null;
        }
        return (EventDetailsModel) shareEntity.f9215a;
    }

    private static UserBasicModel h(ShareEntity shareEntity) {
        if (shareEntity == null || !(shareEntity.f9215a instanceof UserBasicModel)) {
            return null;
        }
        return (UserBasicModel) shareEntity.f9215a;
    }

    private static BluedTopic i(ShareEntity shareEntity) {
        if (shareEntity == null || !(shareEntity.f9215a instanceof BluedTopic)) {
            return null;
        }
        return (BluedTopic) shareEntity.f9215a;
    }

    private static BluedGroupLists j(ShareEntity shareEntity) {
        if (shareEntity == null || !(shareEntity.f9215a instanceof BluedGroupLists)) {
            return null;
        }
        return (BluedGroupLists) shareEntity.f9215a;
    }

    public void a() {
        if (PopMenuUtils.a(this.f33704a)) {
            return;
        }
        if (c(this.f33695c) == null) {
            if (i(this.f33695c) != null) {
                FeedAddPostFragment.b(this.f33704a, i(this.f33695c));
                return;
            } else if (f(this.f33695c) != null) {
                FeedAddPostFragment.a(this.f33704a, f(this.f33695c));
                return;
            } else if (g(this.f33695c) != null) {
                FeedAddPostFragment.a(this.f33704a, g(this.f33695c));
                return;
            } else {
                return;
            }
        }
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        if (c(this.f33695c).repost == null || c(this.f33695c).repost.feed_is_delete != 1) {
            if (c(this.f33695c).is_repost == 1) {
                bluedIngSelfFeed.feed_id = c(this.f33695c).feed_id;
                bluedIngSelfFeed.repost = c(this.f33695c).repost;
                if (c(this.f33695c).is_feed_anonym == 1) {
                    bluedIngSelfFeed.feed_content = "//" + c(this.f33695c).user_name + "：" + c(this.f33695c).feed_content;
                } else {
                    bluedIngSelfFeed.feed_content = "//" + StringUtils.b(c(this.f33695c).user_name, c(this.f33695c).feed_uid) + "：" + c(this.f33695c).feed_content;
                }
            } else {
                bluedIngSelfFeed.feed_id = c(this.f33695c).feed_id;
                bluedIngSelfFeed.repost = c(this.f33695c);
                bluedIngSelfFeed.feed_content = "";
                if (this.f33695c.shareFrom == 11) {
                    bluedIngSelfFeed.is_share_posting = 1;
                }
                if (this.f33695c.shareFrom == 13) {
                    bluedIngSelfFeed.is_share_circle = 1;
                }
            }
            FeedAddPostFragment.a(this.f33704a, bluedIngSelfFeed);
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
        a(this.f33695c, i);
        super.a(i, shareBackLister, popWindowSetting);
    }

    public void a(ShareEntity shareEntity) {
        this.f33695c = shareEntity;
        if (!TextUtils.isEmpty(shareEntity.platFormName) && this.f33695c.platFormName.equals(Constants.BLUED_FEED)) {
            c();
        } else if (!TextUtils.isEmpty(this.f33695c.platFormName) && this.f33695c.platFormName.equals(Constants.REPOST_FEED)) {
            a();
        } else if (!TextUtils.isEmpty(this.f33695c.platFormName) && this.f33695c.platFormName.equals(Constants.BLUED_GROUP_AND_PEOPLE)) {
            b();
        }
        super.b((BaseShareEntity) shareEntity);
    }

    @Override // com.soft.blued.ui.share_custom.BaseShareToPlatform
    public void a(String str) {
        String str2 = this.f33695c.shareFrom == 6 ? this.f33695c.linkUrl : "";
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
        InstantLog.b(d(this.f33695c), i, str2, e(this.f33695c));
        super.a(str);
    }

    protected void b() {
        ShareEventToMsgEntity shareEventToMsgEntity;
        String str;
        if ((this.f33695c.shareFrom == 6 || this.f33695c.shareFrom == 9) && PopMenuUtils.a(this.f33704a)) {
            return;
        }
        ShareToMsgEntity shareToMsgEntity = new ShareToMsgEntity();
        switch (this.f33695c.shareFrom) {
            case 1:
                shareToMsgEntity.title = this.f33704a.getResources().getString(R.string.biao_im_msg_share_person);
                shareEventToMsgEntity = shareToMsgEntity;
                if (h(this.f33695c) != null) {
                    shareToMsgEntity.name = h(this.f33695c).name;
                    shareToMsgEntity.description = h(this.f33695c).description;
                    shareToMsgEntity.url = "http://native.blued.cn/?action=profile&uid=" + h(this.f33695c).uid;
                    shareToMsgEntity.image = this.f33695c.netImgUrl;
                    shareToMsgEntity.shareUserInfo = new ShareUserInfo();
                    shareToMsgEntity.shareUserInfo.age = h(this.f33695c).age;
                    shareToMsgEntity.shareUserInfo.height = h(this.f33695c).height;
                    shareToMsgEntity.shareUserInfo.weight = h(this.f33695c).weight;
                    shareToMsgEntity.shareUserInfo.role = h(this.f33695c).role;
                    shareToMsgEntity.shareUserInfo.badge = h(this.f33695c).vbadge;
                    shareToMsgEntity.shareUserInfo.vip_grade = h(this.f33695c).vip_grade;
                    shareToMsgEntity.shareUserInfo.vip_exp_lvl = h(this.f33695c).vip_exp_lvl;
                    shareToMsgEntity.shareUserInfo.expire_type = h(this.f33695c).expire_type;
                    shareToMsgEntity.shareUserInfo.is_hide_vip_look = h(this.f33695c).is_hide_vip_look;
                    shareToMsgEntity.shareUserInfo.is_vip_annual = h(this.f33695c).is_vip_annual;
                    shareEventToMsgEntity = shareToMsgEntity;
                    break;
                }
                break;
            case 2:
                if (j(this.f33695c) != null) {
                    shareToMsgEntity.image = j(this.f33695c).groups_avatar;
                    shareToMsgEntity.gid = j(this.f33695c).groups_gid;
                    shareToMsgEntity.isCreatorOrAdmin = "1".equals(j(this.f33695c).groups_is_admins) ? "1" : "1".equals(j(this.f33695c).groups_is_created) ? "1" : "0";
                    shareToMsgEntity.name = j(this.f33695c).groups_name;
                    shareToMsgEntity.description = j(this.f33695c).groups_city;
                }
                shareToMsgEntity.url = this.f33695c.linkUrl;
                shareToMsgEntity.title = this.f33704a.getResources().getString(R.string.biao_im_msg_share_toone);
                shareEventToMsgEntity = shareToMsgEntity;
                break;
            case 3:
                shareToMsgEntity.title = this.f33695c.title;
                shareToMsgEntity.name = this.f33695c.content;
                shareToMsgEntity.image = this.f33695c.netImgUrl;
                shareToMsgEntity.description = this.f33695c.mainBody;
                shareToMsgEntity.url = this.f33695c.linkUrl;
                shareToMsgEntity.sessionId = Long.valueOf(this.f33695c.f.h).longValue();
                shareEventToMsgEntity = shareToMsgEntity;
                break;
            case 4:
            case 15:
                shareToMsgEntity.title = this.f33704a.getResources().getString(R.string.biao_im_msg_share_feed);
                shareEventToMsgEntity = shareToMsgEntity;
                if (c(this.f33695c) != null) {
                    shareToMsgEntity.gid = c(this.f33695c).feed_id;
                    if (TextUtils.isEmpty(c(this.f33695c).feed_content)) {
                        shareToMsgEntity.name = c(this.f33695c).user_name + this.f33704a.getResources().getString(R.string.biao_im_msg_feed_of_someone);
                    } else {
                        shareToMsgEntity.name = c(this.f33695c).feed_content;
                    }
                    shareToMsgEntity.url = "http://native.blued.cn/?action=feed&fid=" + EncryptTool.b(c(this.f33695c).feed_id) + "&ads=" + c(this.f33695c).is_ads;
                    a(c(this.f33695c), shareToMsgEntity, "1".equals(c(this.f33695c).is_videos));
                    shareEventToMsgEntity = shareToMsgEntity;
                    if (c(this.f33695c).is_repost == 1) {
                        shareEventToMsgEntity = shareToMsgEntity;
                        if (c(this.f33695c).repost != null) {
                            shareToMsgEntity.repost = new ShareToMsgEntity();
                            if (TextUtils.isEmpty(c(this.f33695c).repost.feed_content)) {
                                shareToMsgEntity.repost.name = c(this.f33695c).repost.user_name + this.f33704a.getResources().getString(R.string.biao_im_msg_feed_of_someone);
                            } else {
                                ShareToMsgEntity shareToMsgEntity2 = shareToMsgEntity.repost;
                                shareToMsgEntity2.name = ("@(name:" + c(this.f33695c).repost.user_name + ",id:" + EncryptTool.b(c(this.f33695c).repost.feed_uid) + ")") + "：" + c(this.f33695c).repost.feed_content;
                            }
                            a(c(this.f33695c).repost, shareToMsgEntity.repost, "1".equals(c(this.f33695c).repost.is_videos));
                            a(c(this.f33695c).repost, shareToMsgEntity.repost);
                            shareEventToMsgEntity = shareToMsgEntity;
                            break;
                        }
                    }
                }
                break;
            case 5:
            case 7:
            case 8:
            default:
                shareToMsgEntity.title = this.f33695c.title;
                shareToMsgEntity.name = this.f33695c.content;
                shareToMsgEntity.image = this.f33695c.netImgUrl;
                shareToMsgEntity.description = this.f33695c.mainBody;
                shareToMsgEntity.url = this.f33695c.linkUrl;
                shareEventToMsgEntity = shareToMsgEntity;
                break;
            case 6:
                shareToMsgEntity.title = this.f33695c.title;
                shareToMsgEntity.name = this.f33695c.title;
                if (this.f33695c.flag == 0) {
                    shareToMsgEntity.image = this.f33695c.fileUrl;
                } else {
                    shareToMsgEntity.image = this.f33695c.netImgUrl;
                }
                shareToMsgEntity.description = this.f33695c.content;
                shareToMsgEntity.url = this.f33695c.linkUrl;
                shareEventToMsgEntity = shareToMsgEntity;
                break;
            case 9:
                if (this.f33695c.flag != 0) {
                    shareToMsgEntity.image = this.f33695c.netImgUrl;
                    shareEventToMsgEntity = shareToMsgEntity;
                    break;
                } else {
                    shareToMsgEntity.image = this.f33695c.fileUrl;
                    shareEventToMsgEntity = shareToMsgEntity;
                    break;
                }
            case 10:
                shareToMsgEntity.url = "http://native.blued.cn/?action=topic&id=" + i(this.f33695c).super_did + "&from=msg";
                shareToMsgEntity.title = this.f33704a.getResources().getString(2131891686);
                shareToMsgEntity.name = i(this.f33695c).name;
                shareToMsgEntity.image = i(this.f33695c).avatar;
                shareEventToMsgEntity = shareToMsgEntity;
                break;
            case 11:
                boolean z = false;
                shareToMsgEntity.title = String.format(this.f33704a.getResources().getString(R.string.biao_im_msg_share_circle_post), this.f33695c.title);
                shareEventToMsgEntity = shareToMsgEntity;
                if (c(this.f33695c) != null) {
                    shareToMsgEntity.name = c(this.f33695c).feed_pure_content;
                    shareToMsgEntity.gid = c(this.f33695c).feed_id;
                    shareToMsgEntity.url = "http://native.blued.cn/?action=base_post_detail&post_id=" + c(this.f33695c).feed_id + "&base_id=" + c(this.f33695c).circle_id;
                    BluedIngSelfFeed c2 = c(this.f33695c);
                    if (c(this.f33695c).is_video_posts == 1) {
                        z = true;
                    }
                    a(c2, shareToMsgEntity, z);
                    shareEventToMsgEntity = shareToMsgEntity;
                    if (c(this.f33695c).is_repost == 1) {
                        shareEventToMsgEntity = shareToMsgEntity;
                        if (c(this.f33695c).repost != null) {
                            shareToMsgEntity.repost = new ShareToMsgEntity();
                            shareToMsgEntity.repost.name = c(this.f33695c).repost.feed_pure_content;
                            shareToMsgEntity.repost.gid = c(this.f33695c).repost.feed_id;
                            shareToMsgEntity.repost.url = "http://native.blued.cn/?action=base_post_detail&post_id=" + c(this.f33695c).repost.feed_id + "&base_id=" + c(this.f33695c).repost.circle_id;
                            a(c(this.f33695c).repost, shareToMsgEntity.repost, "1".equals(c(this.f33695c).repost.is_videos));
                            a(c(this.f33695c).repost, shareToMsgEntity.repost);
                            shareEventToMsgEntity = shareToMsgEntity;
                            break;
                        }
                    }
                }
                break;
            case 12:
                shareToMsgEntity.title = this.f33695c.title;
                shareToMsgEntity.name = this.f33695c.content;
                shareToMsgEntity.image = this.f33695c.netImgUrl;
                shareToMsgEntity.description = this.f33695c.mainBody;
                shareToMsgEntity.url = this.f33695c.linkUrl;
                shareToMsgEntity.sessionId = Long.valueOf(this.f33695c.f.h).longValue();
                shareEventToMsgEntity = shareToMsgEntity;
                break;
            case 13:
                shareToMsgEntity.title = this.f33704a.getResources().getString(R.string.biao_im_msg_share_circle);
                shareEventToMsgEntity = shareToMsgEntity;
                if (f(this.f33695c) != null) {
                    shareToMsgEntity.name = this.f33695c.title;
                    shareToMsgEntity.description = this.f33695c.content;
                    shareToMsgEntity.gid = f(this.f33695c).circle_id;
                    shareToMsgEntity.url = "http://native.blued.cn/?action=base_detail&base_id=" + EncryptTool.b(f(this.f33695c).circle_id) + "&normal_back=1";
                    shareToMsgEntity.image = this.f33695c.netImgUrl;
                    shareEventToMsgEntity = shareToMsgEntity;
                    break;
                }
                break;
            case 14:
                EventDetailsModel g = g(this.f33695c);
                shareEventToMsgEntity = shareToMsgEntity;
                if (g != null) {
                    ShareEventToMsgEntity shareEventToMsgEntity2 = new ShareEventToMsgEntity();
                    shareEventToMsgEntity2.activityName = g.name;
                    shareEventToMsgEntity2.isActivity = 1;
                    shareEventToMsgEntity2.activityTime = TimeAndDateUtils.c(TimeAndDateUtils.j(g.activity_date), true);
                    if (g.mode_id == 2) {
                        shareEventToMsgEntity2.activityLocation = AppInfo.d().getResources().getString(2131887774);
                    } else if (g.mode_id == 1) {
                        if (TextUtils.isEmpty(g.city) || TextUtils.isEmpty(g.location)) {
                            str = !TextUtils.isEmpty(g.city) ? g.city : !TextUtils.isEmpty(g.location) ? g.location : "";
                        } else {
                            str = g.city + "·" + g.location;
                        }
                        shareEventToMsgEntity2.activityLocation = str;
                    }
                    shareEventToMsgEntity2.gid = g.id;
                    shareEventToMsgEntity2.url = "http://native.blued.cn/?action=event_details&event_id=" + g.id;
                    shareEventToMsgEntity2.title = g(this.f33695c).name;
                    shareEventToMsgEntity2.name = this.f33695c.content;
                    shareEventToMsgEntity2.description = this.f33695c.mainBody;
                    shareEventToMsgEntity2.image = AvatarUtils.a(g.pic);
                    shareEventToMsgEntity = shareEventToMsgEntity2;
                    break;
                }
                break;
        }
        shareEventToMsgEntity.type = this.f33695c.shareType;
        shareEventToMsgEntity.share_from = this.f33695c.shareFrom;
        ChatHelperV4.a().a(this.f33704a, shareEventToMsgEntity);
    }

    public void b(ShareEntity shareEntity) {
        this.f33695c = shareEntity;
        super.a((BaseShareEntity) shareEntity);
    }
}
