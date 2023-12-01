package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYLivingStreamView;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRelationRankBinding.class */
public final class ItemYyRelationRankBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeableImageView f16788a;
    public final ShapeableImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final YYLivingStreamView f16789c;
    public final YYLivingStreamView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    private final ConstraintLayout j;

    private ItemYyRelationRankBinding(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, YYLivingStreamView yYLivingStreamView, YYLivingStreamView yYLivingStreamView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.j = constraintLayout;
        this.f16788a = shapeableImageView;
        this.b = shapeableImageView2;
        this.f16789c = yYLivingStreamView;
        this.d = yYLivingStreamView2;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = textView5;
    }

    public static ItemYyRelationRankBinding a(View view) {
        String str;
        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_user_1);
        if (shapeableImageView != null) {
            ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.iv_user_2);
            if (shapeableImageView2 != null) {
                YYLivingStreamView yYLivingStreamView = (YYLivingStreamView) view.findViewById(R.id.live_user_1);
                if (yYLivingStreamView != null) {
                    YYLivingStreamView yYLivingStreamView2 = (YYLivingStreamView) view.findViewById(R.id.live_user_2);
                    if (yYLivingStreamView2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_num);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_room_c);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_room_leve);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_room_name);
                                    if (textView4 != null) {
                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_room_type_value);
                                        if (textView5 != null) {
                                            return new ItemYyRelationRankBinding((ConstraintLayout) view, shapeableImageView, shapeableImageView2, yYLivingStreamView, yYLivingStreamView2, textView, textView2, textView3, textView4, textView5);
                                        }
                                        str = "tvRoomTypeValue";
                                    } else {
                                        str = "tvRoomName";
                                    }
                                } else {
                                    str = "tvRoomLeve";
                                }
                            } else {
                                str = "tvRoomC";
                            }
                        } else {
                            str = "tvNum";
                        }
                    } else {
                        str = "liveUser2";
                    }
                } else {
                    str = "liveUser1";
                }
            } else {
                str = "ivUser2";
            }
        } else {
            str = "ivUser1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.j;
    }
}
