package com.soft.blued.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.yy_china.view.HomeChatRotationView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/NearbyChatRoomHostViewBinding.class */
public final class NearbyChatRoomHostViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29486a;
    public final HomeChatRotationView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29487c;
    public final ImageView d;
    public final LinearLayout e;
    public final TextView f;
    public final ShapeLinearLayout g;
    private final RelativeLayout h;

    private NearbyChatRoomHostViewBinding(RelativeLayout relativeLayout, ImageView imageView, HomeChatRotationView homeChatRotationView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, TextView textView, ShapeLinearLayout shapeLinearLayout) {
        this.h = relativeLayout;
        this.f29486a = imageView;
        this.b = homeChatRotationView;
        this.f29487c = imageView2;
        this.d = imageView3;
        this.e = linearLayout;
        this.f = textView;
        this.g = shapeLinearLayout;
    }

    public static NearbyChatRoomHostViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.nearby_chat_room_host_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static NearbyChatRoomHostViewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_notice);
        if (imageView != null) {
            HomeChatRotationView homeChatRotationView = (HomeChatRotationView) view.findViewById(2131367603);
            if (homeChatRotationView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.nearby_chat_name_icon);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.nearby_chat_room_icon);
                    if (imageView3 != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.nearby_chat_room_long_layout);
                        if (linearLayout != null) {
                            TextView textView = (TextView) view.findViewById(R.id.nearby_chat_room_num);
                            if (textView != null) {
                                ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.nearby_chat_room_short_layout);
                                if (shapeLinearLayout != null) {
                                    return new NearbyChatRoomHostViewBinding((RelativeLayout) view, imageView, homeChatRotationView, imageView2, imageView3, linearLayout, textView, shapeLinearLayout);
                                }
                                str = "nearbyChatRoomShortLayout";
                            } else {
                                str = "nearbyChatRoomNum";
                            }
                        } else {
                            str = "nearbyChatRoomLongLayout";
                        }
                    } else {
                        str = "nearbyChatRoomIcon";
                    }
                } else {
                    str = "nearbyChatNameIcon";
                }
            } else {
                str = "livingRoomList";
            }
        } else {
            str = "ivNotice";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.h;
    }
}
