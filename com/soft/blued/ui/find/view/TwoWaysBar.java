package com.soft.blued.ui.find.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.R;
import com.soft.blued.customview.rangebar.RangeBar;
import com.soft.blued.ui.home.HomeActivity;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/TwoWaysBar.class */
public class TwoWaysBar extends RangeBar {

    /* renamed from: a  reason: collision with root package name */
    public Context f17044a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public TwoWaysBarListner f17045c;
    public int d;
    private boolean e;
    private int f;
    private int g;
    private boolean h;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/TwoWaysBar$RANGE_TYPE.class */
    public interface RANGE_TYPE {
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/TwoWaysBar$TowWaysBarListenerAdapter.class */
    public static class TowWaysBarListenerAdapter implements TwoWaysBarListner {
        @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
        public void a(int i, int i2) {
        }

        @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
        public void a(boolean z) {
        }

        @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
        public void b(boolean z) {
        }

        @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
        public void c(boolean z) {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/TwoWaysBar$TwoWaysBarListner.class */
    public interface TwoWaysBarListner {
        void a(int i, int i2);

        void a(boolean z);

        void b(boolean z);

        void c(boolean z);
    }

    public TwoWaysBar(Context context) {
        super(context);
        this.b = 100;
        this.e = true;
        this.d = 1;
        this.f17044a = context;
        a();
    }

    public TwoWaysBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 100;
        this.e = true;
        this.d = 1;
        this.f17044a = context;
        a();
    }

    public TwoWaysBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 100;
        this.e = true;
        this.d = 1;
        this.f17044a = context;
        a();
    }

    public static String a(Context context, int i, int i2, int i3) {
        String str = "";
        if (i3 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(context.getResources().getString(2131890633), i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2));
            sb.append(i2 < 30 ? "" : "+");
            return sb.toString();
        } else if (i3 == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb2.append(i2);
            sb2.append(context.getResources().getString(R.string.distance_unit));
            sb2.append(i2 < 100 ? "" : "+");
            return sb2.toString();
        } else {
            if (i3 == 4) {
                if (i == 0 && i2 == 0) {
                    return context.getResources().getString(R.string.msg_mute_box_not_set);
                }
                if (i == 0 && i2 == 100) {
                    return context.getResources().getString(R.string.msg_mute_box_all_folded);
                }
                if (i == i2) {
                    int i4 = i;
                    if (i == 100) {
                        i4 = 99;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i4);
                    sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    int i5 = i4 + 1;
                    sb3.append(i5);
                    sb3.append(context.getResources().getString(R.string.distance_unit));
                    sb3.append(i5 < 100 ? "" : "+");
                    return sb3.toString();
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(i);
                sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb4.append(i2);
                sb4.append(context.getResources().getString(R.string.distance_unit));
                sb4.append(i2 < 100 ? "" : "+");
                str = sb4.toString();
            }
            return str;
        }
    }

    public static String a(Context context, String str, int i) {
        int i2 = 0;
        if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                try {
                    i2 = Integer.valueOf(split[0]).intValue();
                } catch (Exception e) {
                }
                int i3 = i == 2 ? 30 : 100;
                try {
                    i3 = i == 2 ? split[1].equals("max") ? 30 : Integer.valueOf(split[1]).intValue() : split[1].equals("max") ? 100 : Integer.valueOf(split[1]).intValue();
                } catch (Exception e2) {
                }
                return a(context, i2, i3, i);
            }
        }
        if (i == 2) {
            return String.format(context.getResources().getString(2131890633), "0-30+");
        }
        return "0-100+" + context.getResources().getString(R.string.distance_unit);
    }

    private void a() {
        setTickCount(this.b);
        setTickHeight(0.0f);
        this.g = ViewConfiguration.get(this.f17044a).getScaledTouchSlop();
        setBarColor(BluedSkinUtils.a(this.f17044a, 2131101196));
        setBarWeight(DensityUtils.a(this.f17044a, 3.0f));
        if (this.e || (getContext() instanceof HomeActivity)) {
            setConnectingLineColor(this.f17044a.getResources().getColor(2131101190));
        } else {
            setConnectingLineColor(this.f17044a.getResources().getColor(2131101196));
        }
        setConnectingLineWeight(DensityUtils.a(this.f17044a, 1.0f));
        setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() { // from class: com.soft.blued.ui.find.view.TwoWaysBar.1
            @Override // com.soft.blued.customview.rangebar.RangeBar.OnRangeBarChangeListener
            public void a(RangeBar rangeBar, int i, int i2) {
                if (TwoWaysBar.this.f17045c != null) {
                    if (TwoWaysBar.this.d == 3 || TwoWaysBar.this.d == 4) {
                        TwoWaysBar.this.f17045c.a(i, i2);
                        return;
                    }
                    int i3 = i;
                    if (i < 0) {
                        i3 = 0;
                    }
                    int i4 = i2;
                    if (i2 + 1 > TwoWaysBar.this.b) {
                        i4 = TwoWaysBar.this.b - 1;
                    }
                    TwoWaysBar.this.f17045c.a(i3, i4 + 1);
                }
            }
        });
    }

    private boolean b(int i, int i2) {
        int i3;
        return i < 0 || i >= (i3 = this.b) || i2 < 0 || i2 >= i3;
    }

    public void a(String str, int i) {
        this.b = i;
        a();
        int i2 = i - 1;
        int i3 = 0;
        int i4 = i2;
        if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            int i5 = 0;
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                int intValue = Integer.valueOf(split[0]).intValue();
                i4 = i2;
                i3 = intValue;
                if (!"max".equals(split[1])) {
                    i5 = intValue;
                    i4 = Integer.valueOf(split[1]).intValue();
                    i3 = intValue;
                }
            } catch (Exception e) {
                i4 = i2;
                i3 = i5;
            }
        }
        int i6 = this.d;
        if (i6 == 3 || i6 == 4 || i6 == 2) {
            if (b(i3, i4)) {
                return;
            }
            a(i3, i4);
        } else if (i3 < 0 || i4 >= i) {
        } else {
            a(i3, i4 - 1);
        }
    }

    @Override // com.soft.blued.customview.rangebar.RangeBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TwoWaysBarListner twoWaysBarListner;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f = (int) motionEvent.getX();
            TwoWaysBarListner twoWaysBarListner2 = this.f17045c;
            if (twoWaysBarListner2 != null) {
                twoWaysBarListner2.a(this.e);
            }
        } else if (actionMasked == 1) {
            this.h = false;
            TwoWaysBarListner twoWaysBarListner3 = this.f17045c;
            if (twoWaysBarListner3 != null) {
                twoWaysBarListner3.b(this.e);
            }
        } else if (actionMasked == 2 && !this.h && Math.abs(this.f - motionEvent.getX()) > this.g && (twoWaysBarListner = this.f17045c) != null) {
            this.h = true;
            twoWaysBarListner.c(this.e);
        }
        if (this.e) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.e = z;
        if (z || (getContext() instanceof HomeActivity)) {
            setThumbImageNormal(R.drawable.icon_two_bars_blue);
            setThumbImagePressed(R.drawable.icon_two_bars_blue);
            setConnectingLineColor(this.f17044a.getResources().getColor(2131101766));
            return;
        }
        setThumbImageNormal(R.drawable.icon_two_bars_gray);
        setThumbImagePressed(R.drawable.icon_two_bars_gray);
        setConnectingLineColor(this.f17044a.getResources().getColor(2131101796));
    }

    public void setTwoWaysBarListner(TwoWaysBarListner twoWaysBarListner) {
        this.f17045c = twoWaysBarListner;
    }
}
