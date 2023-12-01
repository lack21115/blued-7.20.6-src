package com.android.internal.app;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/PlatLogoActivity.class */
public class PlatLogoActivity extends Activity {
    static final int[] FLAVORS = {-6543440, -4560696, -26624, -18611, -1023342, -476208, -5262293, -3285959, -5317, -3722, -8825528, -6190977};
    PathInterpolator mInterpolator = new PathInterpolator(0.0f, 0.0f, 0.5f, 1.0f);
    private boolean mIsMK;
    int mKeyCount;
    FrameLayout mLayout;
    int mTapCount;

    /* renamed from: com.android.internal.app.PlatLogoActivity$2  reason: invalid class name */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/PlatLogoActivity$2.class */
    class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ ImageView val$im;
        final /* synthetic */ Drawable val$platlogo;
        final /* synthetic */ View val$stick;

        AnonymousClass2(ImageView imageView, Drawable drawable, View view) {
            this.val$im = imageView;
            this.val$platlogo = drawable;
            this.val$stick = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlatLogoActivity.this.mTapCount == 0) {
                this.val$im.animate().translationZ(40.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(PlatLogoActivity.this.mInterpolator).setDuration(700L).setStartDelay(500L).start();
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this.val$platlogo, "alpha", 0, 255);
                ofInt.setInterpolator(PlatLogoActivity.this.mInterpolator);
                ofInt.setStartDelay(1000L);
                ofInt.start();
                this.val$stick.animate().translationZ(20.0f).alpha(1.0f).setInterpolator(PlatLogoActivity.this.mInterpolator).setDuration(700L).setStartDelay(750L).start();
                this.val$im.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.android.internal.app.PlatLogoActivity.2.1
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        if (PlatLogoActivity.this.mTapCount < 5) {
                            return false;
                        }
                        ContentResolver contentResolver = PlatLogoActivity.this.getContentResolver();
                        if (Settings.System.getLong(contentResolver, Settings.System.EGG_MODE, 0L) == 0) {
                            Settings.System.putLong(contentResolver, Settings.System.EGG_MODE, System.currentTimeMillis());
                        }
                        AnonymousClass2.this.val$im.post(new Runnable() { // from class: com.android.internal.app.PlatLogoActivity.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    PlatLogoActivity.this.startActivity(new Intent(Intent.ACTION_MAIN).setFlags(276856832).putExtra("is_mk", PlatLogoActivity.this.mIsMK).addCategory("com.android.internal.category.PLATLOGO"));
                                } catch (ActivityNotFoundException e) {
                                    Log.e("PlatLogoActivity", "No more eggs.");
                                }
                                PlatLogoActivity.this.finish();
                            }
                        });
                        return true;
                    }
                });
            } else {
                this.val$im.setBackground(PlatLogoActivity.this.makeRipple());
            }
            PlatLogoActivity.this.mTapCount++;
        }
    }

    static int newColorIndex() {
        return ((int) ((Math.random() * FLAVORS.length) / 2.0d)) * 2;
    }

    Drawable makeRipple() {
        int newColorIndex = newColorIndex();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(FLAVORS[newColorIndex]);
        return new RippleDrawable(ColorStateList.valueOf(FLAVORS[newColorIndex + 1]), shapeDrawable, (Drawable) null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        final int min = (int) (Math.min(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels), 600.0f * f) - (100.0f * f));
        View view = new View(this) { // from class: com.android.internal.app.PlatLogoActivity.1
            Paint mPaint = new Paint();
            Path mShadow = new Path();

            @Override // android.view.View
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                setWillNotDraw(false);
                setOutlineProvider(new ViewOutlineProvider() { // from class: com.android.internal.app.PlatLogoActivity.1.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view2, Outline outline) {
                        outline.setRect(0, getHeight() / 2, getWidth(), getHeight());
                    }
                });
            }

            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                int width = canvas.getWidth();
                int height = canvas.getHeight() / 2;
                canvas.translate(0.0f, height);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                gradientDrawable.setGradientCenter(width * 0.75f, 0.0f);
                gradientDrawable.setColors(new int[]{-1, -5592406});
                gradientDrawable.setBounds(0, 0, width, height);
                gradientDrawable.draw(canvas);
                this.mPaint.setColor(-5592406);
                this.mShadow.reset();
                this.mShadow.moveTo(0.0f, 0.0f);
                this.mShadow.lineTo(width, 0.0f);
                this.mShadow.lineTo(width, (min / 2) + (1.5f * width));
                this.mShadow.lineTo(0.0f, min / 2);
                this.mShadow.close();
                canvas.drawPath(this.mShadow, this.mPaint);
            }
        };
        this.mLayout.addView(view, new FrameLayout.LayoutParams((int) (32.0f * f), -1, 1));
        view.setAlpha(0.0f);
        final ImageView imageView = new ImageView(this);
        imageView.setTranslationZ(20.0f);
        imageView.setScaleX(0.0f);
        imageView.setScaleY(0.0f);
        Drawable drawable = getDrawable(this.mIsMK ? 17302771 : 17302859);
        drawable.setAlpha(0);
        imageView.setImageDrawable(drawable);
        imageView.setBackground(makeRipple());
        imageView.setClickable(true);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(285212671);
        shapeDrawable.setBounds((int) (min * 0.15f), (int) (min * 0.15f), (int) (min * 0.6f), (int) (min * 0.6f));
        imageView.getOverlay().add(shapeDrawable);
        imageView.setOnClickListener(new AnonymousClass2(imageView, drawable, view));
        imageView.setFocusable(true);
        imageView.requestFocus();
        imageView.setOnKeyListener(new View.OnKeyListener() { // from class: com.android.internal.app.PlatLogoActivity.3
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view2, int i, KeyEvent keyEvent) {
                if (i == 4 || keyEvent.getAction() != 0) {
                    return false;
                }
                PlatLogoActivity.this.mKeyCount++;
                if (PlatLogoActivity.this.mKeyCount > 2) {
                    if (PlatLogoActivity.this.mTapCount > 5) {
                        imageView.performLongClick();
                        return true;
                    }
                    imageView.performClick();
                    return true;
                }
                return true;
            }
        });
        this.mLayout.addView(imageView, new FrameLayout.LayoutParams(min, min, 17));
        imageView.animate().scaleX(0.3f).scaleY(0.3f).setInterpolator(this.mInterpolator).setDuration(500L).setStartDelay(800L).start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mIsMK = getIntent().hasExtra("is_mk");
        this.mLayout = new FrameLayout(this);
        setContentView(this.mLayout);
    }
}
