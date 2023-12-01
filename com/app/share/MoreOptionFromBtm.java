package com.app.share;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.app.share.auto.ShareServiceManager;
import com.app.share.model.ShareEntity;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.share.Constants;
import com.soft.blued.customview.BaseMoreOptionFromBtm;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/app/share/MoreOptionFromBtm.class */
public abstract class MoreOptionFromBtm extends BaseMoreOptionFromBtm {

    /* renamed from: a  reason: collision with root package name */
    public ShareEntity f6370a;
    private ShareOptionRecyclerAdapter.ShareOptionsItemClickListener h;

    public MoreOptionFromBtm(Context context, boolean z, boolean z2, boolean z3, View.OnClickListener onClickListener) {
        super(context, z, z2, z3, onClickListener);
    }

    private void a(int i, ShareEntity shareEntity) {
        if (shareEntity.shareFrom == 1) {
            if (i == R.string.ssdk_sinaweibo || i == R.string.ssdk_wechat || i == R.string.ssdk_wechatmoments || i == R.string.ssdk_qq) {
                shareEntity.content = shareEntity.r;
                shareEntity.mainBody = shareEntity.r;
            }
        }
    }

    @Override // com.soft.blued.customview.BaseMoreOptionFromBtm
    public void a(int i) {
        ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener = this.h;
        if (shareOptionsItemClickListener != null) {
            shareOptionsItemClickListener.onItemClick(i);
        }
        String str = "";
        if (this.f6370a.shareFrom == 6) {
            str = "";
            if (!TextUtils.isEmpty(this.f6370a.linkUrl)) {
                str = this.f6370a.linkUrl;
            }
        }
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(H5Url.a(38).toLowerCase()) && i != R.string.share_to_friends && i != R.string.common_main_feed && i != R.string.feed_repost) {
            ShareServiceManager.a().b();
        }
        if (UserInfoHelper.a(this.d)) {
            return;
        }
        int i2 = -1;
        ShareServiceManager.a().a(this.f6370a, str, i);
        if (i == R.string.share_to_friends) {
            i2 = 0;
            this.f6370a.platFormName = Constants.BLUED_GROUP_AND_PEOPLE;
        } else if (i == R.string.common_main_feed) {
            i2 = 1;
            this.f6370a.platFormName = Constants.BLUED_FEED;
        } else if (i == R.string.ssdk_sinaweibo) {
            i2 = 2;
            this.f6370a.platFormName = Constants.SinaWeiboNAME;
        } else if (i == R.string.ssdk_wechat) {
            i2 = 3;
            this.f6370a.platFormName = Constants.WechatNAME;
        } else if (i == R.string.ssdk_wechatmoments) {
            i2 = 4;
            this.f6370a.platFormName = Constants.WechatMomentsNAME;
        } else if (i == R.string.ssdk_qq) {
            i2 = 5;
            this.f6370a.platFormName = Constants.QQNAME;
        } else if (i == R.string.share_to_code) {
            super.a(i);
            return;
        }
        ShareServiceManager.a().a(this.f6370a, i2, str);
        a(i, this.f6370a);
        ShareServiceManager.a().a(this.b, null, null, this.h, this.f6370a);
        super.a(i);
    }

    public void a(ShareEntity shareEntity, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener) {
        this.f6370a = shareEntity;
        this.h = shareOptionsItemClickListener;
        super.a(shareEntity);
    }

    @Override // com.soft.blued.customview.BaseMoreOptionFromBtm
    public void a(List<ShareOption> list, List<ShareOption> list2) {
    }
}
