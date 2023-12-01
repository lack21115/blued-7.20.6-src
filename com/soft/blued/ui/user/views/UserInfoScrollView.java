package com.soft.blued.ui.user.views;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Scroller;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/UserInfoScrollView.class */
class UserInfoScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    TouchTool f20696a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f20697c;
    float d;
    float e;
    float f;
    float g;
    int h;
    int i;
    int j;
    ImageView k;
    boolean l;
    private OnScrollListener m;
    private int n;
    private Scroller o;
    private int[] p;
    private int[] q;
    private float r;
    private boolean s;
    private Handler t;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/UserInfoScrollView$OnScrollListener.class */
    public interface OnScrollListener {
        void a(int i);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/UserInfoScrollView$TouchTool.class */
    public class TouchTool {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f20700c;

        public TouchTool(int i, int i2, int i3, int i4) {
            this.b = i;
            this.f20700c = i2;
        }

        public int a(float f) {
            return (int) (this.f20700c + (f / 2.5f));
        }
    }

    public UserInfoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = new int[2];
        this.q = new int[2];
        this.s = true;
        this.t = new Handler() { // from class: com.soft.blued.ui.user.views.UserInfoScrollView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int scrollY = UserInfoScrollView.this.getScrollY();
                if (UserInfoScrollView.this.n != scrollY) {
                    UserInfoScrollView.this.n = scrollY;
                    UserInfoScrollView.this.t.sendMessageDelayed(UserInfoScrollView.this.t.obtainMessage(), 5L);
                }
                if (UserInfoScrollView.this.m != null) {
                    UserInfoScrollView.this.m.a(scrollY);
                }
            }
        };
        this.o = new Scroller(context);
    }

    public UserInfoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = new int[2];
        this.q = new int[2];
        this.s = true;
        this.t = new Handler() { // from class: com.soft.blued.ui.user.views.UserInfoScrollView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int scrollY = UserInfoScrollView.this.getScrollY();
                if (UserInfoScrollView.this.n != scrollY) {
                    UserInfoScrollView.this.n = scrollY;
                    UserInfoScrollView.this.t.sendMessageDelayed(UserInfoScrollView.this.t.obtainMessage(), 5L);
                }
                if (UserInfoScrollView.this.m != null) {
                    UserInfoScrollView.this.m.a(scrollY);
                }
            }
        };
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.o.computeScrollOffset()) {
            int currX = this.o.getCurrX();
            int currY = this.o.getCurrY();
            ImageView imageView = this.k;
            imageView.layout(0, 0, currX + imageView.getWidth(), currY);
            invalidate();
            if (this.o.isFinished() || !this.l || currY <= 200) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            layoutParams.height = currY;
            this.k.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.ScrollView
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (this.o.isFinished()) {
            this.f = motionEvent.getX();
            this.g = motionEvent.getY();
            this.k.getLocationInWindow(this.p);
            getLocationOnScreen(this.q);
            this.k.getTop();
            if (action == 0) {
                if (this.p[1] != this.q[1]) {
                    this.s = false;
                }
                this.b = this.k.getLeft();
                this.f20697c = this.k.getBottom();
                this.i = getWidth();
                this.j = getHeight();
                this.h = this.k.getHeight();
                this.d = this.f;
                this.e = this.g;
                this.f20696a = new TouchTool(this.k.getLeft(), this.k.getBottom(), this.k.getLeft(), this.k.getBottom() + 200);
                return true;
            } else if (action == 1) {
                if (this.p[1] == this.q[1]) {
                    this.l = true;
                    this.o.startScroll(this.k.getLeft(), this.k.getBottom(), 0 - this.k.getLeft(), this.h - this.k.getBottom(), 500);
                    invalidate();
                }
                this.s = true;
                return true;
            } else if (action != 2) {
                return true;
            } else {
                if (!this.s && this.p[1] == this.q[1]) {
                    this.e = this.g;
                    this.s = true;
                }
                if (this.k.isShown() && this.k.getTop() >= 0) {
                    TouchTool touchTool = this.f20696a;
                    if (touchTool != null) {
                        int a2 = touchTool.a(this.g - this.e);
                        if (!this.l && this.g < this.r && this.k.getHeight() > this.h) {
                            scrollTo(0, 0);
                            this.k.getLocationInWindow(this.p);
                            getLocationOnScreen(this.q);
                            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
                            layoutParams.height = a2;
                            this.k.setLayoutParams(layoutParams);
                            if (this.k.getHeight() == this.h && this.p[1] == this.q[1]) {
                                this.l = true;
                            }
                            if (this.s && this.p[1] != this.q[1]) {
                                this.s = false;
                            }
                        }
                        if (a2 >= this.f20697c && a2 <= this.k.getBottom() + 200 && this.p[1] == this.q[1] && this.g > this.r) {
                            ViewGroup.LayoutParams layoutParams2 = this.k.getLayoutParams();
                            layoutParams2.height = a2;
                            this.k.setLayoutParams(layoutParams2);
                        }
                    }
                    this.l = false;
                }
                this.r = this.g;
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnScrollListener onScrollListener = this.m;
        if (onScrollListener != null) {
            int scrollY = getScrollY();
            this.n = scrollY;
            onScrollListener.a(scrollY);
        }
        if (motionEvent.getAction() == 1) {
            Handler handler = this.t;
            handler.sendMessageDelayed(handler.obtainMessage(), 20L);
        }
        return super.onTouchEvent(motionEvent);
    }
}
