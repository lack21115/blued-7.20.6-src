package com.android.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/ActionBarPolicy.class */
public class ActionBarPolicy {
    private Context mContext;

    private ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean enableHomeButtonByDefault() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        return this.mContext.getResources().getInteger(R.integer.max_action_buttons);
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.action_bar_stacked_tab_max_width);
    }

    public int getTabContainerHeight() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(4, 0);
        Resources resources = this.mContext.getResources();
        int i = layoutDimension;
        if (!hasEmbeddedTabs()) {
            i = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return i;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getApplicationInfo().targetSdkVersion >= 16 ? this.mContext.getResources().getBoolean(R.bool.action_bar_embed_tabs) : this.mContext.getResources().getBoolean(R.bool.action_bar_embed_tabs_pre_jb);
    }

    public boolean showsOverflowMenuButton() {
        return true;
    }
}
