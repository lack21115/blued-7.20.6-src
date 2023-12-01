package com.tencent.open.yyb;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.a.f;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/MoreFloatingDialog.class */
public class MoreFloatingDialog extends Dialog {
    private static final float NINE_PATCH_TOP = 9.0f;
    private static final float SHARE_ICON_SIZE = 28.0f;
    private static final String SOURCE_FLOATING_BG = "yyb_appdetail_bg_floatingwindow.9.png";
    private static final String SOURCE_FRIENDS_BG = "yyb_friends.png";
    private static final String SOURCE_QQ_BG = "yyb_qq.png";
    private static final String SOURCE_QZONE_BG = "yyb_qzone.png";
    private static final String SOURCE_WEIXIN_BG = "yyb_weixin.png";
    private static final String TAG = "openSDK_LOG.MoreFloatingDialog";
    private float density;
    private RelativeLayout mContentView;
    private LinearLayout mRootView;
    private HashMap<String, TextView> mShareItems;
    private Rect ninePatchRect;

    public MoreFloatingDialog(Context context) {
        super(context, R.style.Theme_Translucent_NoTitleBar);
        this.mShareItems = new HashMap<>(4);
        this.ninePatchRect = new Rect(0, dip2px(NINE_PATCH_TOP), 0, 0);
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.density = displayMetrics.density;
        f.b(TAG, "-->(MoreFloatingDialog) : density = " + this.density);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.mContentView = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.mContentView.setBackgroundDrawable(a.a(SOURCE_FLOATING_BG, context, this.ninePatchRect));
        this.mRootView = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.mRootView.setLayoutParams(layoutParams2);
        this.mShareItems.put(SOURCE_QQ_BG, addShareItemText(a.a(SOURCE_QQ_BG, getContext(), this.ninePatchRect), "QQ分享"));
        this.mShareItems.put(SOURCE_QZONE_BG, addShareItemText(a.a(SOURCE_QZONE_BG, getContext(), this.ninePatchRect), "空间分享"));
        this.mContentView.addView(this.mRootView, layoutParams2);
        setContentView(this.mContentView);
    }

    private void addHorizontalDivider() {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundColor(Color.parseColor("#33ffffff"));
        this.mRootView.addView(imageView, new LinearLayout.LayoutParams(dip2px(1.0f), -1));
    }

    private TextView addShareItemText(Drawable drawable, String str) {
        if (drawable != null) {
            drawable.setBounds(0, 0, dip2px(SHARE_ICON_SIZE), dip2px(SHARE_ICON_SIZE));
        }
        TextView textView = new TextView(getContext());
        textView.setTextColor(-1);
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setTextSize(13.0f);
        textView.setCompoundDrawablePadding(dip2px(8.0f));
        textView.setPadding(0, dip2px(19.0f), 0, dip2px(19.0f));
        textView.setGravity(1);
        textView.setText(str);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 1;
        this.mRootView.addView(textView, layoutParams);
        addHorizontalDivider();
        return textView;
    }

    public int dip2px(float f) {
        return (int) ((f * this.density) + 0.5f);
    }

    public int getContentViewHeight() {
        return this.mContentView.getHeight();
    }

    public int getHeight() {
        return this.mContentView.getHeight();
    }

    public View getQQItem() {
        return this.mShareItems.get(SOURCE_QQ_BG);
    }

    public View getQzoneItem() {
        return this.mShareItems.get(SOURCE_QZONE_BG);
    }

    public View getTimelineItem() {
        return this.mShareItems.get(SOURCE_FRIENDS_BG);
    }

    public View getWXItem() {
        return this.mShareItems.get(SOURCE_WEIXIN_BG);
    }
}
