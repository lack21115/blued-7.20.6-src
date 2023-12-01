package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;
import java.math.BigDecimal;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/KSRatingBar.class */
public class KSRatingBar extends LinearLayout {
    private boolean aCY;
    private boolean aCZ;
    private int aDa;
    private int aDb;
    private a aDc;
    private float aDd;
    private float aDe;
    private float aDf;
    private Drawable aDg;
    private Drawable aDh;
    private Drawable aDi;
    private boolean aDj;
    private int y;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/KSRatingBar$a.class */
    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.aDj = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.aDi = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.aDg = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.aDh = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.aDd = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.aDe = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.aDf = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.aDa = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.aDb = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.aCY = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.aCZ = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i = 0; i < this.aDa; i++) {
            ImageView w = w(context, this.aDj);
            w.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    if (KSRatingBar.this.aCY) {
                        if (!KSRatingBar.this.aCZ) {
                            KSRatingBar kSRatingBar = KSRatingBar.this;
                            kSRatingBar.setStar(kSRatingBar.indexOfChild(view) + 1.0f);
                            if (KSRatingBar.this.aDc != null) {
                                a unused = KSRatingBar.this.aDc;
                                KSRatingBar.this.indexOfChild(view);
                                return;
                            }
                            return;
                        }
                        if (KSRatingBar.this.y % 2 == 0) {
                            KSRatingBar kSRatingBar2 = KSRatingBar.this;
                            kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view) + 1.0f);
                        } else {
                            KSRatingBar kSRatingBar3 = KSRatingBar.this;
                            kSRatingBar3.setStar(kSRatingBar3.indexOfChild(view) + 0.5f);
                        }
                        if (KSRatingBar.this.aDc != null) {
                            int unused2 = KSRatingBar.this.y;
                            a unused3 = KSRatingBar.this.aDc;
                            KSRatingBar.this.indexOfChild(view);
                            KSRatingBar.e(KSRatingBar.this);
                        }
                    }
                }
            });
            addView(w);
        }
        setStar(this.aDb);
    }

    static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i = kSRatingBar.y;
        kSRatingBar.y = i + 1;
        return i;
    }

    private ImageView w(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.aDd), Math.round(this.aDe)));
        imageView.setPadding(0, 0, Math.round(this.aDf), 0);
        imageView.setImageDrawable(z ? this.aDg : this.aDh);
        return imageView;
    }

    public void setImagePadding(float f) {
        this.aDf = f;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.aDc = aVar;
    }

    public void setStar(float f) {
        int i = (int) f;
        float floatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.aDa;
        float f2 = i > i2 ? i2 : i;
        float f3 = f2;
        if (f2 < 0.0f) {
            f3 = 0.0f;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= f3) {
                break;
            }
            ((ImageView) getChildAt(i4)).setImageDrawable(this.aDh);
            i3 = i4 + 1;
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.aDi);
            int i5 = this.aDa;
            while (true) {
                int i6 = i5 - 1;
                if (i6 < 1.0f + f3) {
                    return;
                }
                ((ImageView) getChildAt(i6)).setImageDrawable(this.aDg);
                i5 = i6;
            }
        } else {
            int i7 = this.aDa;
            while (true) {
                int i8 = i7 - 1;
                if (i8 < f3) {
                    return;
                }
                ((ImageView) getChildAt(i8)).setImageDrawable(this.aDg);
                i7 = i8;
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.aDg = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.aDh = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.aDi = drawable;
    }

    public void setStarImageHeight(float f) {
        this.aDe = f;
    }

    public void setStarImageWidth(float f) {
        this.aDd = f;
    }

    public void setTotalStarCount(int i) {
        this.aDa = i;
    }

    public void setmClickable(boolean z) {
        this.aCY = z;
    }
}
