package com.blued.android.module.live.base.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.res_china.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveUserRelationshipUtils.class */
public class LiveUserRelationshipUtils {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveUserRelationshipUtils$IAddOrRemoveAttentionDone.class */
    public interface IAddOrRemoveAttentionDone {
        void Q_();

        void a(String str);

        void b(String str);

        void c();

        void d();
    }

    public static void a(Context context, String str, TextView textView, ImageView imageView) {
        a(context, str, textView, imageView, true);
    }

    public static void a(Context context, String str, TextView textView, ImageView imageView, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (textView != null) {
            if (z) {
                textView.setTextColor(BluedSkinUtils.a(context, R.color.syc_dark_79818D));
            }
            if ("0".equals(str)) {
                textView.setText(R.string.attention);
                if (z) {
                    textView.setTextColor(BluedSkinUtils.a(context, R.color.syc_a));
                }
            } else if ("1".equals(str)) {
                textView.setText(R.string.followed);
            } else if ("2".equals(str)) {
                textView.setText(R.string.being_followed);
                if (z) {
                    textView.setTextColor(BluedSkinUtils.a(context, R.color.syc_a));
                }
            } else if ("3".equals(str)) {
                textView.setText(R.string.follow_eachother);
            } else {
                textView.setText(R.string.attention);
            }
        }
        if (imageView != null) {
            if ("0".equals(str)) {
                imageView.setImageResource(R.drawable.icon_usercard_add_attention);
            } else if ("1".equals(str)) {
                imageView.setImageResource(R.drawable.icon_usercard_followed);
            } else if ("2".equals(str)) {
                imageView.setImageResource(R.drawable.icon_usercard_add_attention);
            } else if ("3".equals(str)) {
                imageView.setImageResource(R.drawable.icon_userlist_follow_each);
            } else {
                imageView.setImageResource(R.drawable.icon_usercard_add_attention);
            }
        }
    }

    public static void b(Context context, String str, TextView textView, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (textView != null) {
            textView.setTextColor(context.getResources().getColor(R.color.syc_b));
            if ("0".equals(str)) {
                textView.setText(R.string.attention);
            } else if ("1".equals(str)) {
                textView.setText(R.string.followed);
            } else if ("2".equals(str)) {
                textView.setText(R.string.being_followed);
            } else if ("3".equals(str)) {
                textView.setText(R.string.follow_eachother);
            } else {
                textView.setText(R.string.attention);
            }
        }
        if (imageView != null) {
            if ("0".equals(str)) {
                imageView.setImageResource(R.drawable.icon_usercard_add_attention_white);
            } else if ("1".equals(str)) {
                imageView.setImageResource(R.drawable.icon_usercard_followed_white);
            } else if ("2".equals(str)) {
                imageView.setImageResource(R.drawable.icon_usercard_add_attention_white);
            } else if ("3".equals(str)) {
                imageView.setImageResource(R.drawable.icon_userlist_follow_each_white);
            } else {
                imageView.setImageResource(R.drawable.icon_usercard_add_attention_white);
            }
        }
    }
}
