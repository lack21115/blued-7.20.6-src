package com.soft.blued.ui.user.utils;

import android.widget.ImageView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.das.profile.PersonalProfileProtos;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/UserInfoUtils.class */
public final class UserInfoUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final UserInfoUtils f20642a = new UserInfoUtils();

    private UserInfoUtils() {
    }

    private final void a(final UserFindResult userFindResult, final ImageView imageView, LogData logData, IRequestHost iRequestHost, final ShapeRelativeLayout shapeRelativeLayout) {
        UserRelationshipUtils.a(imageView.getContext(), new UserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.user.utils.UserInfoUtils$addOrRemoveAttention$1
            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a() {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
                UserFindResult.this.relationship = str;
                UserInfoUtils userInfoUtils = UserInfoUtils.f20642a;
                String str2 = str;
                if (str == null) {
                    str2 = "";
                }
                userInfoUtils.a(str2, imageView, shapeRelativeLayout);
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b() {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
                UserFindResult.this.relationship = str;
                UserInfoUtils userInfoUtils = UserInfoUtils.f20642a;
                String str2 = str;
                if (str == null) {
                    str2 = "";
                }
                userInfoUtils.a(str2, imageView, shapeRelativeLayout);
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
            }
        }, userFindResult.uid, userFindResult.relationship, logData.userFrom, iRequestHost, false);
    }

    public static /* synthetic */ void a(UserInfoUtils userInfoUtils, UserFindResult userFindResult, ImageView imageView, IRequestHost iRequestHost, LogData logData, ShapeRelativeLayout shapeRelativeLayout, int i, Object obj) {
        if ((i & 16) != 0) {
            shapeRelativeLayout = null;
        }
        userInfoUtils.a(userFindResult, imageView, iRequestHost, logData, shapeRelativeLayout);
    }

    public static /* synthetic */ void a(UserInfoUtils userInfoUtils, String str, ImageView imageView, ShapeRelativeLayout shapeRelativeLayout, int i, Object obj) {
        if ((i & 4) != 0) {
            shapeRelativeLayout = null;
        }
        userInfoUtils.a(str, imageView, shapeRelativeLayout);
    }

    public final void a(UserFindResult userFindResult, ImageView imageView, IRequestHost iRequestHost, LogData logData, ShapeRelativeLayout shapeRelativeLayout) {
        Intrinsics.e(userFindResult, "userinfo");
        Intrinsics.e(imageView, "iv_attention");
        Intrinsics.e(iRequestHost, "requestHost");
        Intrinsics.e(logData, "userLogData");
        if (Intrinsics.a("1", userFindResult.relationship) || Intrinsics.a("3", userFindResult.relationship)) {
            return;
        }
        a(userFindResult, imageView, logData, iRequestHost, shapeRelativeLayout);
        logData.isAddFollow = true;
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FOLLOWED_BTN_CLICK, logData);
    }

    public final void a(String str, ImageView imageView, ShapeRelativeLayout shapeRelativeLayout) {
        Intrinsics.e(str, "relationship");
        Intrinsics.e(imageView, "img_attention");
        if (StringUtils.d(str)) {
            imageView.setImageResource(R.drawable.icon_user_attention_normal);
            if (shapeRelativeLayout == null) {
                return;
            }
            ShapeHelper.d((ShapeHelper.ShapeView) shapeRelativeLayout, 2131101766);
        } else if (Intrinsics.a("0", str)) {
            imageView.setImageResource(R.drawable.icon_user_attention_normal);
            if (shapeRelativeLayout == null) {
                return;
            }
            ShapeHelper.d((ShapeHelper.ShapeView) shapeRelativeLayout, 2131101766);
        } else if (Intrinsics.a("1", str)) {
            imageView.setImageResource(R.drawable.icon_user_attention_ok);
            if (shapeRelativeLayout == null) {
                return;
            }
            ShapeHelper.d((ShapeHelper.ShapeView) shapeRelativeLayout, 2131102272);
        } else if (Intrinsics.a("2", str)) {
            imageView.setImageResource(R.drawable.icon_user_attention_normal);
            if (shapeRelativeLayout == null) {
                return;
            }
            ShapeHelper.d((ShapeHelper.ShapeView) shapeRelativeLayout, 2131101766);
        } else if (Intrinsics.a("3", str)) {
            imageView.setImageResource(R.drawable.icon_user_attention_each);
            if (shapeRelativeLayout == null) {
                return;
            }
            ShapeHelper.d((ShapeHelper.ShapeView) shapeRelativeLayout, 2131102272);
        } else {
            imageView.setImageResource(R.drawable.icon_user_attention_normal);
            if (shapeRelativeLayout == null) {
                return;
            }
            ShapeHelper.d((ShapeHelper.ShapeView) shapeRelativeLayout, 2131101766);
        }
    }
}
