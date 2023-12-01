package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.ItemKtvPrizeView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyKtvGorgeousPrizeDialogBinding.class */
public final class FragmentYyKtvGorgeousPrizeDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16515a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16516c;
    public final ImageView d;
    public final ShapeableImageView e;
    public final TextView f;
    public final ItemKtvPrizeView g;
    public final ItemKtvPrizeView h;
    public final ItemKtvPrizeView i;
    public final TextView j;
    private final ConstraintLayout k;

    private FragmentYyKtvGorgeousPrizeDialogBinding(ConstraintLayout constraintLayout, View view, TextView textView, ImageView imageView, ImageView imageView2, ShapeableImageView shapeableImageView, TextView textView2, ItemKtvPrizeView itemKtvPrizeView, ItemKtvPrizeView itemKtvPrizeView2, ItemKtvPrizeView itemKtvPrizeView3, TextView textView3) {
        this.k = constraintLayout;
        this.f16515a = view;
        this.b = textView;
        this.f16516c = imageView;
        this.d = imageView2;
        this.e = shapeableImageView;
        this.f = textView2;
        this.g = itemKtvPrizeView;
        this.h = itemKtvPrizeView2;
        this.i = itemKtvPrizeView3;
        this.j = textView3;
    }

    public static FragmentYyKtvGorgeousPrizeDialogBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            TextView textView = (TextView) view.findViewById(R.id.dialog_title);
            if (textView != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_bg_view);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_score_level);
                    if (imageView2 != null) {
                        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_singer_header);
                        if (shapeableImageView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.iv_singer_name);
                            if (textView2 != null) {
                                ItemKtvPrizeView itemKtvPrizeView = (ItemKtvPrizeView) view.findViewById(R.id.ll_item_applaud);
                                if (itemKtvPrizeView != null) {
                                    ItemKtvPrizeView itemKtvPrizeView2 = (ItemKtvPrizeView) view.findViewById(R.id.ll_item_beans);
                                    if (itemKtvPrizeView2 != null) {
                                        ItemKtvPrizeView itemKtvPrizeView3 = (ItemKtvPrizeView) view.findViewById(R.id.ll_item_gift);
                                        if (itemKtvPrizeView3 != null) {
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_send_gift_title);
                                            if (textView3 != null) {
                                                return new FragmentYyKtvGorgeousPrizeDialogBinding((ConstraintLayout) view, findViewById, textView, imageView, imageView2, shapeableImageView, textView2, itemKtvPrizeView, itemKtvPrizeView2, itemKtvPrizeView3, textView3);
                                            }
                                            str = "tvSendGiftTitle";
                                        } else {
                                            str = "llItemGift";
                                        }
                                    } else {
                                        str = "llItemBeans";
                                    }
                                } else {
                                    str = "llItemApplaud";
                                }
                            } else {
                                str = "ivSingerName";
                            }
                        } else {
                            str = "ivSingerHeader";
                        }
                    } else {
                        str = "ivScoreLevel";
                    }
                } else {
                    str = "imgBgView";
                }
            } else {
                str = WbCloudFaceContant.DIALOG_TITLE;
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.k;
    }
}
