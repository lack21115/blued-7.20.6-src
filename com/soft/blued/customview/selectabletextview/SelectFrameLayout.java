package com.soft.blued.customview.selectabletextview;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.widget.emoticon.ui.SelectedImageSpan;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/selectabletextview/SelectFrameLayout.class */
public class SelectFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f28628a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f28629c;
    private View d;
    private TextView e;
    private Spannable f;
    private SelectionInfo g;
    private BackgroundColorSpan h;
    private int i;
    private int j;
    private CursorHandle k;
    private CursorHandle l;
    private boolean m;
    private OperateWindow n;
    private FullScreenWindow o;
    private SelectableOnShowListener p;
    private SelectableOnChangeListener q;
    private SelectableItemOnClickListener r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/selectabletextview/SelectFrameLayout$CursorHandle.class */
    public class CursorHandle extends View {
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private PopupWindow f28636c;
        private Paint d;
        private int e;
        private int f;
        private int g;
        private int h;
        private boolean i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int[] n;

        public CursorHandle(boolean z) {
            super(SelectFrameLayout.this.f28628a);
            this.b = 48;
            this.e = 24;
            this.f = 24 * 2;
            this.g = 24 * 2;
            this.h = 25;
            this.n = new int[2];
            this.i = z;
            Paint paint = new Paint(1);
            this.d = paint;
            paint.setColor(SelectFrameLayout.this.f28628a.getResources().getColor(SelectFrameLayout.this.j));
            PopupWindow popupWindow = new PopupWindow(this);
            this.f28636c = popupWindow;
            popupWindow.setClippingEnabled(false);
            this.f28636c.setWidth(this.f + (this.h * 2));
            this.f28636c.setHeight(this.g + (this.h / 2));
            invalidate();
        }

        private void d() {
            this.i = !this.i;
            invalidate();
        }

        private void e() {
            SelectFrameLayout.this.getLocationInWindow(this.n);
            Layout layout = SelectFrameLayout.this.e.getLayout();
            if (this.i) {
                this.f28636c.update((((int) layout.getPrimaryHorizontal(SelectFrameLayout.this.g.a(SelectFrameLayout.this.e))) - this.f) + b(), layout.getLineBottom(layout.getLineForOffset(SelectFrameLayout.this.g.a(SelectFrameLayout.this.e))) + c(), -1, -1);
            } else {
                this.f28636c.update(((int) layout.getPrimaryHorizontal(SelectFrameLayout.this.g.b(SelectFrameLayout.this.e))) + b(), layout.getLineBottom(layout.getLineForOffset(SelectFrameLayout.this.g.b(SelectFrameLayout.this.e))) + c(), -1, -1);
            }
        }

        public void a() {
            this.f28636c.dismiss();
        }

        public void a(int i, int i2) {
            SelectFrameLayout.this.getLocationInWindow(this.n);
            this.f28636c.showAtLocation(SelectFrameLayout.this, 0, (i - (this.i ? this.f : 0)) + b(), i2 + c());
        }

        public int b() {
            return (this.n[0] - this.h) + SelectFrameLayout.this.getPaddingLeft();
        }

        public int c() {
            return this.n[1] + SelectFrameLayout.this.getPaddingTop();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            int i;
            int i2;
            int i3 = this.e;
            canvas.drawCircle(this.h + i3, i3, i3, this.d);
            if (this.i) {
                int i4 = this.e;
                int i5 = this.h;
                canvas.drawRect(i4 + i5, 0.0f, (i4 * 2) + i5, i4, this.d);
                return;
            }
            canvas.drawRect(this.h, 0.0f, i + i2, this.e, this.d);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.l = SelectFrameLayout.this.g.a(SelectFrameLayout.this.e);
                this.m = SelectFrameLayout.this.g.b(SelectFrameLayout.this.e);
                this.j = (int) motionEvent.getX();
                this.k = (int) motionEvent.getY();
                return true;
            }
            if (action != 1) {
                if (action == 2) {
                    SelectFrameLayout.this.n.c();
                    update(((((int) motionEvent.getRawX()) + this.j) - this.f) - SelectFrameLayout.this.getSubViewX(), (((int) motionEvent.getRawY()) + this.k) - this.g);
                    return true;
                } else if (action != 3) {
                    return true;
                }
            }
            SelectFrameLayout.this.n.a();
            return true;
        }

        public void update(int i, int i2) {
            SelectFrameLayout.this.getLocationInWindow(this.n);
            int a2 = this.i ? SelectFrameLayout.this.g.a(SelectFrameLayout.this.e) : SelectFrameLayout.this.g.b(SelectFrameLayout.this.e);
            int a3 = TextLayoutUtil.a(SelectFrameLayout.this.e, i, i2 - this.n[1], a2);
            if (a3 != a2) {
                SelectFrameLayout.this.d();
                if (this.i) {
                    if (a3 > this.m) {
                        CursorHandle a4 = SelectFrameLayout.this.a(false);
                        d();
                        a4.d();
                        int i3 = this.m;
                        this.l = i3;
                        SelectFrameLayout.this.b(i3, a3);
                        a4.e();
                    } else {
                        SelectFrameLayout.this.b(a3, -1);
                    }
                    e();
                    return;
                }
                int i4 = this.l;
                if (a3 < i4) {
                    CursorHandle a5 = SelectFrameLayout.this.a(true);
                    a5.d();
                    d();
                    int i5 = this.l;
                    this.m = i5;
                    SelectFrameLayout.this.b(a3, i5);
                    a5.e();
                } else {
                    SelectFrameLayout.this.b(i4, a3);
                }
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/selectabletextview/SelectFrameLayout$FullScreenWindow.class */
    public class FullScreenWindow {
        private PopupWindow b;

        public FullScreenWindow(Context context) {
            PopupWindow popupWindow = new PopupWindow(LayoutInflater.from(context).inflate(R.layout.select_text_full_screen_windows, (ViewGroup) null), -1, -1, false);
            this.b = popupWindow;
            popupWindow.setClippingEnabled(false);
            this.b.setTouchInterceptor(new View.OnTouchListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.FullScreenWindow.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (SelectFrameLayout.this.n == null || SelectFrameLayout.this.n.e == null) {
                        FullScreenWindow.this.b();
                    }
                    if (SelectFrameLayout.this.a(SelectFrameLayout.this.n.e, motionEvent)) {
                        return true;
                    }
                    if (SelectFrameLayout.this.k == null || SelectFrameLayout.this.l == null) {
                        SelectFrameLayout.this.c();
                        return true;
                    } else if (SelectFrameLayout.this.a(SelectFrameLayout.this.k, motionEvent) || SelectFrameLayout.this.a(SelectFrameLayout.this.l, motionEvent)) {
                        return true;
                    } else {
                        SelectFrameLayout.this.d();
                        SelectFrameLayout.this.c();
                        return true;
                    }
                }
            });
        }

        public void a() {
            this.b.showAtLocation(SelectFrameLayout.this, 0, 0, 0);
        }

        public void b() {
            this.b.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/selectabletextview/SelectFrameLayout$OperateWindow.class */
    public class OperateWindow {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f28640c;
        private PopupWindow d;
        private View e;
        private LinearLayout f;
        private View g;
        private View h;
        private View i;
        private View j;
        private View k;
        private View l;
        private View m;
        private View n;
        private View o;
        private View p;

        public OperateWindow(Context context) {
            this.b = TextLayoutUtil.a(SelectFrameLayout.this.f28628a);
            this.f28640c = DensityUtils.a(SelectFrameLayout.this.f28628a, 13.0f);
            View inflate = LayoutInflater.from(context).inflate(R.layout.select_text_operate_windows, (ViewGroup) null);
            this.e = inflate;
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            PopupWindow popupWindow = new PopupWindow(this.e, -2, -2, false);
            this.d = popupWindow;
            popupWindow.setClippingEnabled(false);
            this.f = (LinearLayout) this.e.findViewById(R.id.ll_it_all);
            View findViewById = this.e.findViewById(R.id.it_copy);
            this.g = findViewById;
            findViewById.setVisibility(8);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.OperateWindow.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    try {
                        ((ClipboardManager) SelectFrameLayout.this.f28628a.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText(SelectFrameLayout.this.g.f28650a, SelectFrameLayout.this.g.f28650a));
                    } catch (Exception e) {
                    }
                    SelectFrameLayout.this.d();
                    SelectFrameLayout.this.c();
                }
            });
            View findViewById2 = this.e.findViewById(R.id.it_select_all);
            this.h = findViewById2;
            findViewById2.setVisibility(8);
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.OperateWindow.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SelectFrameLayout.this.c();
                    SelectFrameLayout.this.b(0, SelectFrameLayout.this.e.getText().length());
                    SelectFrameLayout.this.m = false;
                    SelectFrameLayout.this.o.a();
                    SelectFrameLayout.this.a(SelectFrameLayout.this.k);
                    SelectFrameLayout.this.a(SelectFrameLayout.this.l);
                    SelectFrameLayout.this.n.a();
                }
            });
            View findViewById3 = this.e.findViewById(R.id.it_recall);
            this.i = findViewById3;
            findViewById3.setVisibility(8);
            this.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.OperateWindow.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SelectFrameLayout.this.r != null) {
                        SelectFrameLayout.this.r.a();
                    }
                    SelectFrameLayout.this.d();
                    SelectFrameLayout.this.c();
                }
            });
            View findViewById4 = this.e.findViewById(R.id.it_translate);
            this.j = findViewById4;
            findViewById4.setVisibility(8);
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.OperateWindow.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SelectFrameLayout.this.r != null) {
                        SelectFrameLayout.this.r.b();
                    }
                    SelectFrameLayout.this.d();
                    SelectFrameLayout.this.c();
                }
            });
            View findViewById5 = this.e.findViewById(R.id.it_turn_text);
            this.k = findViewById5;
            findViewById5.setVisibility(8);
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.OperateWindow.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SelectFrameLayout.this.r != null) {
                        SelectFrameLayout.this.r.c();
                    }
                    SelectFrameLayout.this.d();
                    SelectFrameLayout.this.c();
                }
            });
            View findViewById6 = this.e.findViewById(R.id.it_report);
            this.l = findViewById6;
            findViewById6.setVisibility(8);
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.OperateWindow.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SelectFrameLayout.this.r != null) {
                        SelectFrameLayout.this.r.d();
                    }
                    SelectFrameLayout.this.d();
                    SelectFrameLayout.this.c();
                }
            });
            View findViewById7 = this.e.findViewById(R.id.it_bubble);
            this.m = findViewById7;
            findViewById7.setVisibility(8);
            this.m.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.OperateWindow.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SelectFrameLayout.this.r != null) {
                        SelectFrameLayout.this.r.e();
                    }
                    SelectFrameLayout.this.d();
                    SelectFrameLayout.this.c();
                }
            });
            View findViewById8 = this.e.findViewById(R.id.it_cancel);
            this.n = findViewById8;
            findViewById8.setVisibility(8);
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.OperateWindow.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SelectFrameLayout.this.r != null) {
                        SelectFrameLayout.this.r.f();
                    }
                    SelectFrameLayout.this.d();
                    SelectFrameLayout.this.c();
                }
            });
            View findViewById9 = this.e.findViewById(R.id.it_quote);
            this.o = findViewById9;
            findViewById9.setVisibility(8);
            this.o.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.OperateWindow.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SelectFrameLayout.this.r != null) {
                        SelectFrameLayout.this.r.g();
                    }
                    SelectFrameLayout.this.d();
                    SelectFrameLayout.this.c();
                }
            });
            if (SelectFrameLayout.this.e == null) {
                this.g.setVisibility(8);
                this.h.setVisibility(8);
            }
            this.p = this.e.findViewById(2131365072);
        }

        private int d() {
            int i = 0;
            for (int i2 = 0; i2 < this.f.getChildCount(); i2++) {
                i += this.f.getChildAt(i2).getVisibility() == 0 ? this.f.getChildAt(i2).getMeasuredWidth() : 0;
            }
            return i;
        }

        private int e() {
            return this.e.getMeasuredHeight();
        }

        private int f() {
            Layout layout = SelectFrameLayout.this.e.getLayout();
            int primaryHorizontal = (int) layout.getPrimaryHorizontal(SelectFrameLayout.this.g.a(SelectFrameLayout.this.e));
            int primaryHorizontal2 = (int) layout.getPrimaryHorizontal(SelectFrameLayout.this.g.b(SelectFrameLayout.this.e));
            return ((primaryHorizontal2 <= primaryHorizontal || !(layout.getLineTop(layout.getLineForOffset(SelectFrameLayout.this.g.a(SelectFrameLayout.this.e))) == layout.getLineTop(layout.getLineForOffset(SelectFrameLayout.this.g.b(SelectFrameLayout.this.e))))) ? ((SelectFrameLayout.this.getWidth() - primaryHorizontal) - SelectFrameLayout.this.getPaddingLeft()) - SelectFrameLayout.this.getPaddingRight() : primaryHorizontal2 - primaryHorizontal) / 2;
        }

        public void a() {
            int i;
            Layout layout = SelectFrameLayout.this.e.getLayout();
            int primaryHorizontal = ((((int) layout.getPrimaryHorizontal(SelectFrameLayout.this.g.a(SelectFrameLayout.this.e))) + SelectFrameLayout.this.getSubViewX()) - (d() / 2)) + f();
            int lineTop = layout.getLineTop(layout.getLineForOffset(SelectFrameLayout.this.g.a(SelectFrameLayout.this.e)));
            int subViewY = SelectFrameLayout.this.getSubViewY();
            int e = e();
            int i2 = this.f28640c;
            int i3 = ((lineTop + subViewY) - e) - i2;
            if (primaryHorizontal < i2) {
                int i4 = primaryHorizontal - i2;
                primaryHorizontal = i2;
                i = i4;
            } else {
                i = 0;
            }
            int i5 = i3;
            if (i3 < 0) {
                i5 = this.f28640c;
            }
            int d = d();
            int i6 = this.b;
            int i7 = primaryHorizontal;
            if (d + primaryHorizontal > i6 - this.f28640c) {
                i = primaryHorizontal - ((i6 - d()) - this.f28640c);
                i7 = (this.b - d()) - this.f28640c;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            this.p.setLayoutParams(marginLayoutParams);
            this.d.showAtLocation(SelectFrameLayout.this.e, 0, i7, i5);
        }

        public void b() {
            int i;
            int subViewX = (SelectFrameLayout.this.getSubViewX() - (d() / 2)) + (SelectFrameLayout.this.d.getMeasuredWidth() / 2);
            int subViewY = SelectFrameLayout.this.getSubViewY();
            int e = e();
            int paddingTop = SelectFrameLayout.this.d.getPaddingTop();
            int i2 = this.f28640c;
            int i3 = ((subViewY - e) + paddingTop) - i2;
            if (subViewX < i2) {
                int i4 = subViewX - i2;
                subViewX = i2;
                i = i4;
            } else {
                i = 0;
            }
            int i5 = this.f28640c;
            int i6 = i3;
            if (i3 < i5) {
                i6 = i5;
            }
            int d = d();
            int i7 = this.b;
            int i8 = subViewX;
            if (d + subViewX > i7 - this.f28640c) {
                i = subViewX - ((i7 - d()) - this.f28640c);
                i8 = (this.b - d()) - this.f28640c;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            this.p.setLayoutParams(marginLayoutParams);
            this.d.showAtLocation(SelectFrameLayout.this.d, 0, i8, i6);
        }

        public void c() {
            this.d.dismiss();
        }
    }

    public SelectFrameLayout(Context context) {
        this(context, null);
    }

    public SelectFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new SelectionInfo();
        this.i = 2131101932;
        this.j = 2131101810;
        this.m = true;
        this.f28628a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CursorHandle a(boolean z) {
        return this.k.i == z ? this.k : this.l;
    }

    private void a() {
        this.d.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SelectFrameLayout.this.p != null) {
                    SelectFrameLayout.this.p.a();
                }
                SelectFrameLayout.this.o.a();
                SelectFrameLayout.this.n.b();
                return true;
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SelectFrameLayout.this.c();
            }
        });
        this.n = new OperateWindow(this.f28628a);
        this.o = new FullScreenWindow(this.f28628a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        c();
        d();
        this.m = false;
        if (this.k == null) {
            this.k = new CursorHandle(true);
        }
        if (this.l == null) {
            this.l = new CursorHandle(false);
        }
        int length = this.e.length();
        if (this.e.getText() instanceof Spannable) {
            this.f = (Spannable) this.e.getText();
        }
        if (this.f == null || this.e.getText().length() <= 0) {
            return;
        }
        b(0, length);
        this.o.a();
        a(this.k);
        a(this.l);
        this.n.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CursorHandle cursorHandle) {
        Layout layout = this.e.getLayout();
        int a2 = cursorHandle.i ? this.g.a(this.e) : this.g.b(this.e);
        cursorHandle.a((int) layout.getPrimaryHorizontal(a2), layout.getLineBottom(layout.getLineForOffset(a2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2).contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private void b() {
        TextView textView = this.e;
        textView.setText(textView.getText(), TextView.BufferType.SPANNABLE);
        this.e.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (SelectFrameLayout.this.p != null) {
                    SelectFrameLayout.this.p.a();
                }
                SelectFrameLayout selectFrameLayout = SelectFrameLayout.this;
                selectFrameLayout.a(selectFrameLayout.b, SelectFrameLayout.this.f28629c);
                return true;
            }
        });
        this.e.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                SelectFrameLayout.this.b = (int) motionEvent.getX();
                SelectFrameLayout.this.f28629c = (int) motionEvent.getY();
                return false;
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.selectabletextview.SelectFrameLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SelectFrameLayout.this.d();
                SelectFrameLayout.this.c();
            }
        });
        this.n = new OperateWindow(this.f28628a);
        this.o = new FullScreenWindow(this.f28628a);
        setCopyVisibility(true);
        setSelectAllVisibility(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        if (i != -1) {
            this.g.a(i);
        }
        if (i2 != -1) {
            this.g.b(i2);
        }
        if (this.g.a(this.e) > this.g.b(this.e)) {
            int a2 = this.g.a(this.e);
            SelectionInfo selectionInfo = this.g;
            selectionInfo.a(selectionInfo.b(this.e));
            this.g.b(a2);
        }
        if (this.f != null) {
            if (this.h == null) {
                this.h = new BackgroundColorSpan(this.f28628a.getResources().getColor(this.i));
            }
            Spannable spannable = this.f;
            SelectedImageSpan[] selectedImageSpanArr = (SelectedImageSpan[]) spannable.getSpans(0, spannable.length(), SelectedImageSpan.class);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= selectedImageSpanArr.length) {
                    break;
                }
                int spanStart = this.f.getSpanStart(selectedImageSpanArr[i4]);
                int spanEnd = this.f.getSpanEnd(selectedImageSpanArr[i4]);
                if (spanStart < this.g.a(this.e) || spanEnd > this.g.b(this.e)) {
                    selectedImageSpanArr[i4].f11196a = 0;
                } else {
                    selectedImageSpanArr[i4].f11196a = ContextCompat.getColor(AppInfo.d(), 2131101932);
                }
                i3 = i4 + 1;
            }
            SelectionInfo selectionInfo2 = this.g;
            Spannable spannable2 = this.f;
            selectionInfo2.f28650a = spannable2.subSequence(selectionInfo2.a(spannable2), this.g.b(this.f)).toString();
            Spannable spannable3 = this.f;
            spannable3.setSpan(this.h, this.g.a(spannable3), this.g.b(this.f), 17);
            SelectableOnChangeListener selectableOnChangeListener = this.q;
            if (selectableOnChangeListener != null) {
                String str = this.g.f28650a;
                boolean z = false;
                if (i == 0) {
                    z = false;
                    if (i2 == this.e.getText().length()) {
                        z = true;
                    }
                }
                selectableOnChangeListener.a(str, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.m = true;
        Spannable spannable = this.f;
        if (spannable != null && this.e != null) {
            SelectedImageSpan[] selectedImageSpanArr = (SelectedImageSpan[]) spannable.getSpans(0, spannable.length(), SelectedImageSpan.class);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= selectedImageSpanArr.length) {
                    break;
                }
                selectedImageSpanArr[i2].f11196a = 0;
                i = i2 + 1;
            }
            this.e.invalidate();
        }
        CursorHandle cursorHandle = this.k;
        if (cursorHandle != null) {
            cursorHandle.a();
        }
        CursorHandle cursorHandle2 = this.l;
        if (cursorHandle2 != null) {
            cursorHandle2.a();
        }
        OperateWindow operateWindow = this.n;
        if (operateWindow != null) {
            operateWindow.c();
        }
        FullScreenWindow fullScreenWindow = this.o;
        if (fullScreenWindow != null) {
            fullScreenWindow.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        BackgroundColorSpan backgroundColorSpan;
        this.g.f28650a = null;
        Spannable spannable = this.f;
        if (spannable == null || (backgroundColorSpan = this.h) == null) {
            return;
        }
        spannable.removeSpan(backgroundColorSpan);
        this.h = null;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (getChildCount() != 1) {
            throw new SelectFrameLayoutException("你必须使SelectFrameLayout有且只有一个子View");
        }
        this.d = getChildAt(0);
        if (!(getChildAt(0) instanceof TextView)) {
            a();
            return;
        }
        this.e = (TextView) getChildAt(0);
        b();
    }

    public int getSubViewX() {
        int[] iArr = new int[2];
        this.d.getLocationOnScreen(iArr);
        return iArr[0];
    }

    public int getSubViewY() {
        int[] iArr = new int[2];
        this.d.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setBubbleVisibility(boolean z) {
        OperateWindow operateWindow = this.n;
        if (operateWindow == null || operateWindow.m == null) {
            return;
        }
        this.n.m.setVisibility(z ? 0 : 8);
    }

    public void setCancelVisibility(boolean z) {
        OperateWindow operateWindow = this.n;
        if (operateWindow == null || operateWindow.n == null) {
            return;
        }
        this.n.n.setVisibility(z ? 0 : 8);
    }

    public void setCopyVisibility(boolean z) {
        OperateWindow operateWindow = this.n;
        if (operateWindow == null || operateWindow.g == null) {
            return;
        }
        this.n.g.setVisibility(z ? 0 : 8);
    }

    public void setQuoteVisibility(boolean z) {
        this.n.o.setVisibility(z ? 0 : 8);
    }

    public void setRecallVisibility(boolean z) {
        OperateWindow operateWindow = this.n;
        if (operateWindow == null || operateWindow.i == null) {
            return;
        }
        this.n.i.setVisibility(z ? 0 : 8);
    }

    public void setRepostVisibility(boolean z) {
        OperateWindow operateWindow = this.n;
        if (operateWindow == null || operateWindow.l == null) {
            return;
        }
        this.n.l.setVisibility(z ? 0 : 8);
    }

    public void setSelectAllVisibility(boolean z) {
        OperateWindow operateWindow = this.n;
        if (operateWindow == null || operateWindow.h == null) {
            return;
        }
        this.n.h.setVisibility(z ? 0 : 8);
    }

    public void setSelectableItemOnClickListener(SelectableItemOnClickListener selectableItemOnClickListener) {
        this.r = selectableItemOnClickListener;
    }

    public void setSelectableOnChangeListener(SelectableOnChangeListener selectableOnChangeListener) {
        this.q = selectableOnChangeListener;
    }

    public void setSelectableOnShowListener(SelectableOnShowListener selectableOnShowListener) {
        this.p = selectableOnShowListener;
    }

    public void setTranslateVisibility(boolean z) {
        OperateWindow operateWindow = this.n;
        if (operateWindow == null || operateWindow.j == null) {
            return;
        }
        this.n.j.setVisibility(z ? 0 : 8);
    }

    public void setTurnTextVisibility(boolean z) {
        OperateWindow operateWindow = this.n;
        if (operateWindow == null || operateWindow.k == null) {
            return;
        }
        this.n.k.setVisibility(z ? 0 : 8);
    }
}
