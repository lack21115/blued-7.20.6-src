package com.soft.blued.manager;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.das.message.MessageProtos;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.model.FriendsNotificationExtra;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/FollowedUsersNotificationManager$dismissAnimation$1.class */
public final class FollowedUsersNotificationManager$dismissAnimation$1 implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrameLayout f29707a;
    final /* synthetic */ View b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FriendsNotificationExtra f29708c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FollowedUsersNotificationManager$dismissAnimation$1(FrameLayout frameLayout, View view, FriendsNotificationExtra friendsNotificationExtra) {
        this.f29707a = frameLayout;
        this.b = view;
        this.f29708c = friendsNotificationExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FrameLayout frameLayout, FriendsNotificationExtra friendsNotificationExtra) {
        FollowedUsersNotificationManager.f29698a.a(frameLayout, friendsNotificationExtra);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        String str;
        FollowedUsersNotificationManager.f29698a.a(this.f29707a, this.b);
        if (this.f29708c != null) {
            sparseArray = FollowedUsersNotificationManager.d;
            FrameLayout frameLayout = this.f29707a;
            FriendsNotificationExtra friendsNotificationExtra = (FriendsNotificationExtra) sparseArray.get(frameLayout != null ? frameLayout.hashCode() : 0);
            if (friendsNotificationExtra != null && !TextUtils.isEmpty(friendsNotificationExtra.notification_type)) {
                String str2 = friendsNotificationExtra.notification_type;
                if (str2 != null) {
                    int hashCode = str2.hashCode();
                    if (hashCode != 3872) {
                        if (hashCode != 3138974) {
                            if (hashCode != 3322092) {
                                if (hashCode == 109801339 && str2.equals("super")) {
                                    str = friendsNotificationExtra.user_id;
                                    Intrinsics.c(str, "lastModel.user_id");
                                    EventTrackMessage.f(MessageProtos.Event.POPUP_BANNER_COVER, str, friendsNotificationExtra.notification_type);
                                }
                            } else if (str2.equals("live")) {
                                str = String.valueOf(friendsNotificationExtra.rome_id);
                                EventTrackMessage.f(MessageProtos.Event.POPUP_BANNER_COVER, str, friendsNotificationExtra.notification_type);
                            }
                        } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_FEEDS)) {
                            str = String.valueOf(friendsNotificationExtra.circle_id);
                            EventTrackMessage.f(MessageProtos.Event.POPUP_BANNER_COVER, str, friendsNotificationExtra.notification_type);
                        }
                    } else if (str2.equals("yy")) {
                        str = String.valueOf(friendsNotificationExtra.yy_rome_id);
                        EventTrackMessage.f(MessageProtos.Event.POPUP_BANNER_COVER, str, friendsNotificationExtra.notification_type);
                    }
                }
                str = "";
                EventTrackMessage.f(MessageProtos.Event.POPUP_BANNER_COVER, str, friendsNotificationExtra.notification_type);
            }
            sparseArray2 = FollowedUsersNotificationManager.d;
            FrameLayout frameLayout2 = this.f29707a;
            int i = 0;
            if (frameLayout2 != null) {
                i = frameLayout2.hashCode();
            }
            sparseArray2.remove(i);
            Handler a2 = FollowedUsersNotificationManager.f29698a.a();
            final FrameLayout frameLayout3 = this.f29707a;
            final FriendsNotificationExtra friendsNotificationExtra2 = this.f29708c;
            a2.postDelayed(new Runnable() { // from class: com.soft.blued.manager.-$$Lambda$FollowedUsersNotificationManager$dismissAnimation$1$6_gqVp6k_hTXtSH6nk-McdC_DbM
                @Override // java.lang.Runnable
                public final void run() {
                    FollowedUsersNotificationManager$dismissAnimation$1.a(FrameLayout.this, friendsNotificationExtra2);
                }
            }, 50L);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
