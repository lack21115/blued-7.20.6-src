package com.android.internal.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/BackgroundFallback.class */
public class BackgroundFallback {
    private Drawable mBackgroundFallback;

    public void draw(ViewGroup viewGroup, Canvas canvas, View view) {
        int i;
        int i2;
        int i3;
        int i4;
        if (hasFallback()) {
            int width = viewGroup.getWidth();
            int height = viewGroup.getHeight();
            int i5 = width;
            int i6 = height;
            int i7 = 0;
            int i8 = 0;
            int childCount = viewGroup.getChildCount();
            int i9 = 0;
            while (i9 < childCount) {
                View childAt = viewGroup.getChildAt(i9);
                Drawable background = childAt.getBackground();
                if (childAt == view) {
                    if (background == null && (childAt instanceof ViewGroup) && ((ViewGroup) childAt).getChildCount() == 0) {
                        i4 = i6;
                        i3 = i7;
                        i2 = i5;
                        i = i8;
                    }
                    i2 = Math.min(i5, childAt.getLeft());
                    i4 = Math.min(i6, childAt.getTop());
                    i3 = Math.max(i7, childAt.getRight());
                    i = Math.max(i8, childAt.getBottom());
                } else {
                    i = i8;
                    i2 = i5;
                    i3 = i7;
                    i4 = i6;
                    if (childAt.getVisibility() == 0) {
                        i = i8;
                        i2 = i5;
                        i3 = i7;
                        i4 = i6;
                        if (background != null) {
                            i = i8;
                            i2 = i5;
                            i3 = i7;
                            i4 = i6;
                            if (background.getOpacity() != -1) {
                            }
                            i2 = Math.min(i5, childAt.getLeft());
                            i4 = Math.min(i6, childAt.getTop());
                            i3 = Math.max(i7, childAt.getRight());
                            i = Math.max(i8, childAt.getBottom());
                        }
                    }
                }
                i9++;
                i8 = i;
                i5 = i2;
                i7 = i3;
                i6 = i4;
            }
            if (i5 >= i7 || i6 >= i8) {
                return;
            }
            if (i6 > 0) {
                this.mBackgroundFallback.setBounds(0, 0, width, i6);
                this.mBackgroundFallback.draw(canvas);
            }
            if (i5 > 0) {
                this.mBackgroundFallback.setBounds(0, i6, i5, height);
                this.mBackgroundFallback.draw(canvas);
            }
            if (i7 < width) {
                this.mBackgroundFallback.setBounds(i7, i6, width, height);
                this.mBackgroundFallback.draw(canvas);
            }
            if (i8 < height) {
                this.mBackgroundFallback.setBounds(i5, i8, i7, height);
                this.mBackgroundFallback.draw(canvas);
            }
        }
    }

    public boolean hasFallback() {
        return this.mBackgroundFallback != null;
    }

    public void setDrawable(Drawable drawable) {
        this.mBackgroundFallback = drawable;
    }
}
