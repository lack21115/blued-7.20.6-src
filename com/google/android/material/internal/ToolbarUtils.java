package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/internal/ToolbarUtils.class */
public class ToolbarUtils {
    private ToolbarUtils() {
    }

    public static ActionMenuItemView getActionMenuItemView(Toolbar toolbar, int i) {
        ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= actionMenuView.getChildCount()) {
                return null;
            }
            View childAt = actionMenuView.getChildAt(i3);
            if (childAt instanceof ActionMenuItemView) {
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) childAt;
                if (actionMenuItemView.getItemData().getItemId() == i) {
                    return actionMenuItemView;
                }
            }
            i2 = i3 + 1;
        }
    }

    public static ActionMenuView getActionMenuView(Toolbar toolbar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= toolbar.getChildCount()) {
                return null;
            }
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
            i = i2 + 1;
        }
    }

    public static ImageButton getNavigationIconButton(Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= toolbar.getChildCount()) {
                return null;
            }
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
            i = i2 + 1;
        }
    }

    public static View getSecondaryActionMenuItemView(Toolbar toolbar) {
        ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView == null || actionMenuView.getChildCount() <= 1) {
            return null;
        }
        return actionMenuView.getChildAt(0);
    }

    public static TextView getSubtitleTextView(Toolbar toolbar) {
        return getTextView(toolbar, toolbar.getSubtitle());
    }

    private static TextView getTextView(Toolbar toolbar, CharSequence charSequence) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= toolbar.getChildCount()) {
                return null;
            }
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
            i = i2 + 1;
        }
    }

    public static TextView getTitleTextView(Toolbar toolbar) {
        return getTextView(toolbar, toolbar.getTitle());
    }
}
