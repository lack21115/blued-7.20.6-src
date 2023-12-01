package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/helper/widget/MotionEffect.class */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    public static final int WEST = 3;

    /* renamed from: a  reason: collision with root package name */
    private float f2113a;
    private int b;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private int i;

    public MotionEffect(Context context) {
        super(context);
        this.f2113a = 0.1f;
        this.b = 49;
        this.d = 50;
        this.e = 0;
        this.f = 0;
        this.g = true;
        this.h = -1;
        this.i = -1;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2113a = 0.1f;
        this.b = 49;
        this.d = 50;
        this.e = 0;
        this.f = 0;
        this.g = true;
        this.h = -1;
        this.i = -1;
        a(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2113a = 0.1f;
        this.b = 49;
        this.d = 50;
        this.e = 0;
        this.f = 0;
        this.g = true;
        this.h = -1;
        this.i = -1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    break;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i3 = obtainStyledAttributes.getInt(index, this.b);
                    this.b = i3;
                    this.b = Math.max(Math.min(i3, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i4 = obtainStyledAttributes.getInt(index, this.d);
                    this.d = i4;
                    this.d = Math.max(Math.min(i4, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.f2113a = obtainStyledAttributes.getFloat(index, this.f2113a);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.i = obtainStyledAttributes.getInt(index, this.i);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.g = obtainStyledAttributes.getBoolean(index, this.g);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.h = obtainStyledAttributes.getResourceId(index, this.h);
                }
                i = i2 + 1;
            }
            int i5 = this.b;
            int i6 = this.d;
            if (i5 == i6) {
                if (i5 > 0) {
                    this.b = i5 - 1;
                } else {
                    this.d = i6 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isDecorator() {
        return true;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> hashMap) {
        Key key;
        Key key2;
        Key key3;
        View[] c2 = c((ConstraintLayout) getParent());
        if (c2 == null) {
            Log.v(TAG, Debug.getLoc() + " views = null");
            return;
        }
        Key keyAttributes = new KeyAttributes();
        Key keyAttributes2 = new KeyAttributes();
        keyAttributes.setValue("alpha", Float.valueOf(this.f2113a));
        keyAttributes2.setValue("alpha", Float.valueOf(this.f2113a));
        keyAttributes.setFramePosition(this.b);
        keyAttributes2.setFramePosition(this.d);
        KeyPosition keyPosition = new KeyPosition();
        keyPosition.setFramePosition(this.b);
        keyPosition.setType(0);
        keyPosition.setValue("percentX", 0);
        keyPosition.setValue("percentY", 0);
        KeyPosition keyPosition2 = new KeyPosition();
        keyPosition2.setFramePosition(this.d);
        keyPosition2.setType(0);
        keyPosition2.setValue("percentX", 1);
        keyPosition2.setValue("percentY", 1);
        Key key4 = null;
        if (this.e > 0) {
            key = new KeyAttributes();
            key2 = new KeyAttributes();
            key.setValue("translationX", Integer.valueOf(this.e));
            key.setFramePosition(this.d);
            key2.setValue("translationX", 0);
            key2.setFramePosition(this.d - 1);
        } else {
            key = null;
            key2 = null;
        }
        if (this.f > 0) {
            key4 = new KeyAttributes();
            key3 = new KeyAttributes();
            key4.setValue("translationY", Integer.valueOf(this.f));
            key4.setFramePosition(this.d);
            key3.setValue("translationY", 0);
            key3.setFramePosition(this.d - 1);
        } else {
            key3 = null;
        }
        int i = this.i;
        int i2 = i;
        if (i == -1) {
            int[] iArr = new int[4];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= c2.length) {
                    break;
                }
                MotionController motionController = hashMap.get(c2[i4]);
                if (motionController != null) {
                    float finalX = motionController.getFinalX() - motionController.getStartX();
                    float finalY = motionController.getFinalY() - motionController.getStartY();
                    if (finalY < 0.0f) {
                        iArr[1] = iArr[1] + 1;
                    }
                    if (finalY > 0.0f) {
                        iArr[0] = iArr[0] + 1;
                    }
                    if (finalX > 0.0f) {
                        iArr[3] = iArr[3] + 1;
                    }
                    if (finalX < 0.0f) {
                        iArr[2] = iArr[2] + 1;
                    }
                }
                i3 = i4 + 1;
            }
            int i5 = iArr[0];
            int i6 = 1;
            int i7 = 0;
            while (true) {
                i2 = i7;
                if (i6 >= 4) {
                    break;
                }
                int i8 = i5;
                if (i5 < iArr[i6]) {
                    i8 = iArr[i6];
                    i7 = i6;
                }
                i6++;
                i5 = i8;
            }
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= c2.length) {
                return;
            }
            MotionController motionController2 = hashMap.get(c2[i10]);
            if (motionController2 != null) {
                float finalX2 = motionController2.getFinalX() - motionController2.getStartX();
                float finalY2 = motionController2.getFinalY() - motionController2.getStartY();
                if (i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 || finalX2 <= 0.0f || (this.g && finalY2 != 0.0f) : finalX2 >= 0.0f || (this.g && finalY2 != 0.0f) : finalY2 >= 0.0f || (this.g && finalX2 != 0.0f) : finalY2 <= 0.0f || (this.g && finalX2 != 0.0f)) {
                    int i11 = this.h;
                    if (i11 == -1) {
                        motionController2.addKey(keyAttributes);
                        motionController2.addKey(keyAttributes2);
                        motionController2.addKey(keyPosition);
                        motionController2.addKey(keyPosition2);
                        if (this.e > 0) {
                            motionController2.addKey(key);
                            motionController2.addKey(key2);
                        }
                        if (this.f > 0) {
                            motionController2.addKey(key4);
                            motionController2.addKey(key3);
                        }
                    } else {
                        motionLayout.applyViewTransition(i11, motionController2);
                    }
                }
            }
            i9 = i10 + 1;
        }
    }
}
