package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.LiveFansLevelView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/ItemLiveOnlineUserBinding.class */
public final class ItemLiveOnlineUserBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeConstraintLayout f12067a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveFansLevelView f12068c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ShapeTextView j;
    public final TextView k;
    private final ShapeConstraintLayout l;

    private ItemLiveOnlineUserBinding(ShapeConstraintLayout shapeConstraintLayout, ShapeConstraintLayout shapeConstraintLayout2, ImageView imageView, LiveFansLevelView liveFansLevelView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ShapeTextView shapeTextView, TextView textView) {
        this.l = shapeConstraintLayout;
        this.f12067a = shapeConstraintLayout2;
        this.b = imageView;
        this.f12068c = liveFansLevelView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = imageView6;
        this.i = imageView7;
        this.j = shapeTextView;
        this.k = textView;
    }

    public static ItemLiveOnlineUserBinding a(View view) {
        String str;
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.item_online_view);
        if (shapeConstraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_chat_marker);
            if (imageView != null) {
                LiveFansLevelView liveFansLevelView = (LiveFansLevelView) view.findViewById(R.id.iv_fans_level);
                if (liveFansLevelView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_live_manager);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_noble_marker);
                        if (imageView3 != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_online_user_avatar);
                            if (imageView4 != null) {
                                ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_online_user_avatar_frame);
                                if (imageView5 != null) {
                                    ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_online_user_weight);
                                    if (imageView6 != null) {
                                        ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_rich_level);
                                        if (imageView7 != null) {
                                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_give_gifts_behalf);
                                            if (shapeTextView != null) {
                                                TextView textView = (TextView) view.findViewById(R.id.tv_online_user_nickname);
                                                if (textView != null) {
                                                    return new ItemLiveOnlineUserBinding((ShapeConstraintLayout) view, shapeConstraintLayout, imageView, liveFansLevelView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, shapeTextView, textView);
                                                }
                                                str = "tvOnlineUserNickname";
                                            } else {
                                                str = "tvGiveGiftsBehalf";
                                            }
                                        } else {
                                            str = "ivRichLevel";
                                        }
                                    } else {
                                        str = "ivOnlineUserWeight";
                                    }
                                } else {
                                    str = "ivOnlineUserAvatarFrame";
                                }
                            } else {
                                str = "ivOnlineUserAvatar";
                            }
                        } else {
                            str = "ivNobleMarker";
                        }
                    } else {
                        str = "ivLiveManager";
                    }
                } else {
                    str = "ivFansLevel";
                }
            } else {
                str = "ivChatMarker";
            }
        } else {
            str = "itemOnlineView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.l;
    }
}
