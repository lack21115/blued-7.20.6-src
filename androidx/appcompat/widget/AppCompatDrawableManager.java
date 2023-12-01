package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/AppCompatDrawableManager.class */
public final class AppCompatDrawableManager {

    /* renamed from: a  reason: collision with root package name */
    private static final PorterDuff.Mode f1753a = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager b;

    /* renamed from: c  reason: collision with root package name */
    private ResourceManagerInternal f1754c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.a(drawable, tintInfo, iArr);
    }

    public static AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            try {
                if (b == null) {
                    preload();
                }
                appCompatDrawableManager = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appCompatDrawableManager;
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            try {
                porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
            } catch (Throwable th) {
                throw th;
            }
        }
        return porterDuffColorFilter;
    }

    public static void preload() {
        synchronized (AppCompatDrawableManager.class) {
            try {
                if (b == null) {
                    AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                    b = appCompatDrawableManager;
                    appCompatDrawableManager.f1754c = ResourceManagerInternal.get();
                    b.f1754c.setHooks(new ResourceManagerInternal.ResourceManagerHooks() { // from class: androidx.appcompat.widget.AppCompatDrawableManager.1

                        /* renamed from: a  reason: collision with root package name */
                        private final int[] f1755a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                        private final int[] b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

                        /* renamed from: c  reason: collision with root package name */
                        private final int[] f1756c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
                        private final int[] d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                        private final int[] e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                        private final int[] f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

                        private ColorStateList a(Context context) {
                            return a(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
                        }

                        /* JADX WARN: Type inference failed for: r2v1, types: [int[], int[][]] */
                        private ColorStateList a(Context context, int i) {
                            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
                            int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal);
                            int[] iArr = ThemeUtils.f1891a;
                            int[] iArr2 = ThemeUtils.d;
                            int compositeColors = ColorUtils.compositeColors(themeAttrColor, i);
                            return new ColorStateList(new int[]{iArr, iArr2, ThemeUtils.b, ThemeUtils.h}, new int[]{disabledThemeAttrColor, compositeColors, ColorUtils.compositeColors(themeAttrColor, i), i});
                        }

                        private LayerDrawable a(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
                            BitmapDrawable bitmapDrawable;
                            BitmapDrawable bitmapDrawable2;
                            BitmapDrawable bitmapDrawable3;
                            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
                            Drawable drawable = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
                            Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
                            if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                                bitmapDrawable = (BitmapDrawable) drawable;
                                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
                            } else {
                                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                                Canvas canvas = new Canvas(createBitmap);
                                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                                drawable.draw(canvas);
                                bitmapDrawable = new BitmapDrawable(createBitmap);
                                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                            }
                            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
                            if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                                bitmapDrawable3 = (BitmapDrawable) drawable2;
                            } else {
                                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                                Canvas canvas2 = new Canvas(createBitmap2);
                                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                                drawable2.draw(canvas2);
                                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
                            }
                            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
                            layerDrawable.setId(0, 16908288);
                            layerDrawable.setId(1, 16908303);
                            layerDrawable.setId(2, 16908301);
                            return layerDrawable;
                        }

                        private void a(Drawable drawable, int i, PorterDuff.Mode mode) {
                            Drawable drawable2 = drawable;
                            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                                drawable2 = drawable.mutate();
                            }
                            PorterDuff.Mode mode2 = mode;
                            if (mode == null) {
                                mode2 = AppCompatDrawableManager.f1753a;
                            }
                            drawable2.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode2));
                        }

                        private boolean a(int[] iArr, int i) {
                            int length = iArr.length;
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= length) {
                                    return false;
                                }
                                if (iArr[i3] == i) {
                                    return true;
                                }
                                i2 = i3 + 1;
                            }
                        }

                        private ColorStateList b(Context context) {
                            return a(context, 0);
                        }

                        private ColorStateList c(Context context) {
                            return a(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v1, types: [int[], int[][]] */
                        private ColorStateList d(Context context) {
                            ?? r0 = new int[3];
                            int[] iArr = new int[3];
                            ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorSwitchThumbNormal);
                            if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                                r0[0] = ThemeUtils.f1891a;
                                iArr[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
                                r0[1] = ThemeUtils.e;
                                iArr[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                                r0[2] = ThemeUtils.h;
                                iArr[2] = ThemeUtils.getThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
                            } else {
                                r0[0] = ThemeUtils.f1891a;
                                iArr[0] = themeAttrColorStateList.getColorForState(r0[0], 0);
                                r0[1] = ThemeUtils.e;
                                iArr[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                                r0[2] = ThemeUtils.h;
                                iArr[2] = themeAttrColorStateList.getDefaultColor();
                            }
                            return new ColorStateList(r0, iArr);
                        }

                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        public Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
                            if (i == R.drawable.abc_cab_background_top_material) {
                                return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
                            }
                            if (i == R.drawable.abc_ratingbar_material) {
                                return a(resourceManagerInternal, context, R.dimen.abc_star_big);
                            }
                            if (i == R.drawable.abc_ratingbar_indicator_material) {
                                return a(resourceManagerInternal, context, R.dimen.abc_star_medium);
                            }
                            if (i == R.drawable.abc_ratingbar_small_material) {
                                return a(resourceManagerInternal, context, R.dimen.abc_star_small);
                            }
                            return null;
                        }

                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        public ColorStateList getTintListForDrawableRes(Context context, int i) {
                            if (i == R.drawable.abc_edit_text_material) {
                                return AppCompatResources.getColorStateList(context, R.color.abc_tint_edittext);
                            }
                            if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                                return AppCompatResources.getColorStateList(context, R.color.abc_tint_switch_track);
                            }
                            if (i == R.drawable.abc_switch_thumb_material) {
                                return d(context);
                            }
                            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                                return a(context);
                            }
                            if (i == R.drawable.abc_btn_borderless_material) {
                                return b(context);
                            }
                            if (i == R.drawable.abc_btn_colored_material) {
                                return c(context);
                            }
                            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                                return AppCompatResources.getColorStateList(context, R.color.abc_tint_spinner);
                            }
                            if (a(this.b, i)) {
                                return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
                            }
                            if (a(this.e, i)) {
                                return AppCompatResources.getColorStateList(context, R.color.abc_tint_default);
                            }
                            if (a(this.f, i)) {
                                return AppCompatResources.getColorStateList(context, R.color.abc_tint_btn_checkable);
                            }
                            if (i == R.drawable.abc_seekbar_thumb_material) {
                                return AppCompatResources.getColorStateList(context, R.color.abc_tint_seek_thumb);
                            }
                            return null;
                        }

                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        public PorterDuff.Mode getTintModeForDrawableRes(int i) {
                            if (i == R.drawable.abc_switch_thumb_material) {
                                return PorterDuff.Mode.MULTIPLY;
                            }
                            return null;
                        }

                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        public boolean tintDrawable(Context context, int i, Drawable drawable) {
                            if (i == R.drawable.abc_seekbar_track_material) {
                                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                                a(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.f1753a);
                                a(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.f1753a);
                                a(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.f1753a);
                                return true;
                            } else if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
                                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                                a(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.f1753a);
                                a(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.f1753a);
                                a(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.f1753a);
                                return true;
                            } else {
                                return false;
                            }
                        }

                        /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
                        /* JADX WARN: Removed duplicated region for block: B:30:0x00af A[RETURN] */
                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public boolean tintDrawableUsingColorFilter(android.content.Context r5, int r6, android.graphics.drawable.Drawable r7) {
                            /*
                                r4 = this;
                                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.a()
                                r11 = r0
                                r0 = r4
                                r1 = r4
                                int[] r1 = r1.f1755a
                                r2 = r6
                                boolean r0 = r0.a(r1, r2)
                                r10 = r0
                                r0 = 16842801(0x1010031, float:2.3693695E-38)
                                r8 = r0
                                r0 = r10
                                if (r0 == 0) goto L27
                                int r0 = androidx.appcompat.R.attr.colorControlNormal
                                r6 = r0
                            L1e:
                                r0 = -1
                                r8 = r0
                            L21:
                                r0 = 1
                                r9 = r0
                                goto L7c
                            L27:
                                r0 = r4
                                r1 = r4
                                int[] r1 = r1.f1756c
                                r2 = r6
                                boolean r0 = r0.a(r1, r2)
                                if (r0 == 0) goto L3a
                                int r0 = androidx.appcompat.R.attr.colorControlActivated
                                r6 = r0
                                goto L1e
                            L3a:
                                r0 = r4
                                r1 = r4
                                int[] r1 = r1.d
                                r2 = r6
                                boolean r0 = r0.a(r1, r2)
                                if (r0 == 0) goto L51
                                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                                r11 = r0
                                r0 = r8
                                r6 = r0
                                goto L1e
                            L51:
                                r0 = r6
                                int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
                                if (r0 != r1) goto L67
                                r0 = 16842800(0x1010030, float:2.3693693E-38)
                                r6 = r0
                                r0 = 1109603123(0x42233333, float:40.8)
                                int r0 = java.lang.Math.round(r0)
                                r8 = r0
                                goto L21
                            L67:
                                r0 = r6
                                int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
                                if (r0 != r1) goto L74
                                r0 = r8
                                r6 = r0
                                goto L1e
                            L74:
                                r0 = -1
                                r8 = r0
                                r0 = 0
                                r9 = r0
                                r0 = 0
                                r6 = r0
                            L7c:
                                r0 = r9
                                if (r0 == 0) goto Laf
                                r0 = r7
                                r12 = r0
                                r0 = r7
                                boolean r0 = androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(r0)
                                if (r0 == 0) goto L91
                                r0 = r7
                                android.graphics.drawable.Drawable r0 = r0.mutate()
                                r12 = r0
                            L91:
                                r0 = r12
                                r1 = r5
                                r2 = r6
                                int r1 = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(r1, r2)
                                r2 = r11
                                android.graphics.PorterDuffColorFilter r1 = androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(r1, r2)
                                r0.setColorFilter(r1)
                                r0 = r8
                                r1 = -1
                                if (r0 == r1) goto Lad
                                r0 = r12
                                r1 = r8
                                r0.setAlpha(r1)
                            Lad:
                                r0 = 1
                                return r0
                            Laf:
                                r0 = 0
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.tintDrawableUsingColorFilter(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a(Context context, int i) {
        ColorStateList a2;
        synchronized (this) {
            a2 = this.f1754c.a(context, i);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable a(Context context, int i, boolean z) {
        Drawable a2;
        synchronized (this) {
            a2 = this.f1754c.a(context, i, z);
        }
        return a2;
    }

    public Drawable getDrawable(Context context, int i) {
        Drawable drawable;
        synchronized (this) {
            drawable = this.f1754c.getDrawable(context, i);
        }
        return drawable;
    }

    public void onConfigurationChanged(Context context) {
        synchronized (this) {
            this.f1754c.onConfigurationChanged(context);
        }
    }
}
