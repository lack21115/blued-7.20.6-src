package com.soft.blued.ui.user.views;

import android.content.Context;
import android.view.View;
import com.app.share.MoreOptionFromBtm;
import com.app.share.model.ShareEntity;
import com.soft.blued.R;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import com.soft.blued.ui.user.model.UserInfoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/UserProfileBtmOptions.class */
public class UserProfileBtmOptions extends MoreOptionFromBtm {
    private int h;
    private int i;
    private int j;
    private String k;

    public UserProfileBtmOptions(Context context, boolean z, boolean z2, boolean z3, View.OnClickListener onClickListener) {
        super(context, z, z2, z3, onClickListener);
    }

    @Override // com.soft.blued.customview.BaseMoreOptionFromBtm
    public List<ShareOption> a() {
        ArrayList arrayList = new ArrayList();
        if (this.e) {
            arrayList.add(new ShareOption(R.drawable.icon_option_qr, R.string.qr_code));
            return arrayList;
        }
        if (!this.g) {
            arrayList.add(new ShareOption(R.drawable.icon_option_allow_private_album, R.string.allow_visit_privacy_photo_album));
            arrayList.add(new ShareOption(R.drawable.icon_option_set_note, R.string.add_comment));
            arrayList.add(new ShareOption(R.drawable.icon_option_follow_secret, R.string.follow_secretly));
            arrayList.add(new ShareOption(R.drawable.icon_option_invisible_to_he, R.string.invisible_to_he));
            if (!this.f) {
                arrayList.add(new ShareOption(R.drawable.icon_option_add_to_blacklist, R.string.add_to_black));
            }
            arrayList.add(new ShareOption(R.drawable.icon_option_report, 2131891497));
        }
        return arrayList;
    }

    @Override // com.app.share.MoreOptionFromBtm
    public void a(ShareEntity shareEntity, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener) {
        super.a(shareEntity, shareOptionsItemClickListener);
    }

    public void a(ShareEntity shareEntity, UserInfoEntity userInfoEntity, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener) {
        this.h = userInfoEntity.access_private_photos;
        this.i = userInfoEntity.secretly_followed_status;
        this.k = userInfoEntity.relationship;
        this.j = userInfoEntity.stealth_status;
        a(shareEntity, shareOptionsItemClickListener);
    }

    @Override // com.app.share.MoreOptionFromBtm, com.soft.blued.customview.BaseMoreOptionFromBtm
    public void a(List<ShareOption> list, List<ShareOption> list2) {
        Iterator<ShareOption> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().iconResourceId == 2131233826) {
                it.remove();
            }
        }
        if (this.e) {
            return;
        }
        Iterator<ShareOption> it2 = list2.iterator();
        while (it2.hasNext()) {
            ShareOption next = it2.next();
            if (next.textResourceID == 2131891052 || next.textResourceID == 2131886406) {
                int i = this.h;
                if (i == 1) {
                    next.iconResourceId = R.drawable.icon_option_disallow_private_album;
                    next.textResourceID = R.string.no_access_privacy_photo_album;
                } else if (i == 0) {
                    next.iconResourceId = R.drawable.icon_option_allow_private_album;
                    next.textResourceID = R.string.allow_visit_privacy_photo_album;
                } else {
                    it2.remove();
                }
            }
            if (next.iconResourceId == 2131233666 || next.iconResourceId == 2131233677) {
                if ("4".equals(this.k)) {
                    next.iconResourceId = R.drawable.icon_option_remove_from_blacklist;
                    next.textResourceID = R.string.remove_from_black;
                } else {
                    next.iconResourceId = R.drawable.icon_option_add_to_blacklist;
                    next.textResourceID = R.string.add_to_black;
                }
            }
            if (next.iconResourceId == 2131233671 || next.iconResourceId == 2131233672) {
                if (this.i == 1) {
                    next.iconResourceId = R.drawable.icon_option_followed_secret;
                    next.textResourceID = 2131888173;
                } else {
                    next.iconResourceId = R.drawable.icon_option_follow_secret;
                    next.textResourceID = R.string.follow_secretly;
                }
            }
            if (next.iconResourceId == 2131233673 || next.iconResourceId == 2131233668) {
                if (this.j == 1) {
                    next.iconResourceId = R.drawable.icon_option_cancel_invisible_to_he;
                    next.textResourceID = R.string.cancel_invisible_to_he;
                } else {
                    next.iconResourceId = R.drawable.icon_option_invisible_to_he;
                    next.textResourceID = R.string.invisible_to_he;
                }
            }
        }
    }
}
