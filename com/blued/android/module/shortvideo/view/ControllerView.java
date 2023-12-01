package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.observer.ReturnObserver;
import com.blued.android.module.shortvideo.presenter.ShinePresenter;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.utils.VideoConfigData;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/ControllerView.class */
public class ControllerView extends FrameLayout implements View.OnClickListener, EventObserver, ReturnObserver {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f15883a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f15884c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private TextView g;
    private StvShineTabsView h;
    private ShinePresenter i;

    /* renamed from: com.blued.android.module.shortvideo.view.ControllerView$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/ControllerView$2.class */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15886a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[EventType.VALUE.values().length];
            f15886a = iArr;
            try {
                iArr[EventType.VALUE.START_TIMEDOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15886a[EventType.VALUE.CONFIG_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15886a[EventType.VALUE.RECOVER_SHINE_V.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15886a[EventType.VALUE.SHINE_RECORD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15886a[EventType.VALUE.SAVE_FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15886a[EventType.VALUE.CONCAT_SECTION_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15886a[EventType.VALUE.SHINE_ENDRECORD.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f15886a[EventType.VALUE.DELECT_LAST_SECOTION.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public ControllerView(Context context) {
        super(context);
        h();
    }

    public ControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public ControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h();
    }

    private double a(int i) {
        return VideoConfigData.f[i];
    }

    private int a(double d) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= VideoConfigData.f.length) {
                return 3;
            }
            if (VideoConfigData.f[i2] == d) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private void a(boolean z) {
        if (this.i == null) {
            return;
        }
        if (z) {
            this.f15883a.setSelected(true);
            this.b.setActivated(false);
            this.b.setVisibility(4);
            this.f15884c.setVisibility(4);
            this.h.b();
            return;
        }
        this.f15883a.setSelected(false);
        if (this.i.z()) {
            this.b.setVisibility(0);
            this.f15884c.setVisibility(0);
            this.b.setEnabled(true);
            if (this.i.A()) {
                this.f15884c.setEnabled(true);
            } else {
                this.f15884c.setEnabled(false);
            }
        } else {
            this.b.setVisibility(4);
            this.f15884c.setVisibility(4);
        }
        this.h.a();
    }

    private void b(boolean z) {
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 4);
        }
    }

    private void h() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.controller_view, (ViewGroup) null);
        this.b = (ImageView) inflate.findViewById(R.id.stv_delete);
        this.f15883a = (ImageView) inflate.findViewById(R.id.stv_record);
        this.f15884c = (ImageView) inflate.findViewById(R.id.stv_concat);
        this.b.setOnClickListener(this);
        this.f15883a.setOnClickListener(this);
        this.f15883a.setSelected(false);
        this.f15884c.setOnClickListener(this);
        this.b.setActivated(false);
        this.b.setVisibility(4);
        this.f15884c.setVisibility(4);
        this.d = (LinearLayout) inflate.findViewById(R.id.stv_speed_v);
        this.e = (TextView) inflate.findViewById(R.id.stv_speed_2);
        this.f = (TextView) inflate.findViewById(R.id.stv_speed_3);
        this.g = (TextView) inflate.findViewById(R.id.stv_speed_4);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h = (StvShineTabsView) inflate.findViewById(R.id.stv_shine_tabs);
        StvViewUtils.a((View) this.f15884c, false);
        b(false);
        addView(inflate);
    }

    private void i() {
        this.e.setSelected(false);
        this.f.setSelected(false);
        this.g.setSelected(false);
        this.i.a(a(0));
        ObserverMgr.a().a(EventType.VALUE.SHINE_SPEED);
    }

    private void j() {
        this.e.setSelected(true);
        this.f.setSelected(false);
        this.g.setSelected(false);
        this.i.a(a(1));
        ObserverMgr.a().a(EventType.VALUE.SHINE_SPEED);
    }

    private void k() {
        this.e.setSelected(false);
        this.f.setSelected(true);
        this.g.setSelected(false);
        this.i.a(a(2));
        ObserverMgr.a().a(EventType.VALUE.SHINE_SPEED);
    }

    private void l() {
        this.e.setSelected(false);
        this.f.setSelected(false);
        this.g.setSelected(true);
        this.i.a(a(3));
        ObserverMgr.a().a(EventType.VALUE.SHINE_SPEED);
    }

    private void m() {
        this.e.setSelected(false);
        this.f.setSelected(false);
        this.g.setSelected(false);
        this.i.a(a(4));
        ObserverMgr.a().a(EventType.VALUE.SHINE_SPEED);
    }

    private void setSpeedV(int i) {
        if (this.i == null) {
            return;
        }
        if (i == 0) {
            i();
        } else if (i == 1) {
            j();
        } else if (i == 2) {
            k();
        } else if (i == 3) {
            l();
        } else if (i != 4) {
        } else {
            m();
        }
    }

    public void a() {
        if (getVisibility() == 8) {
            postDelayed(new Runnable() { // from class: com.blued.android.module.shortvideo.view.ControllerView.1
                @Override // java.lang.Runnable
                public void run() {
                    ControllerView.this.setVisibility(0);
                    StvViewUtils.a(ControllerView.this.getContext(), ControllerView.this);
                }
            }, 200L);
        }
    }

    public void a(int i, int i2, int i3) {
        this.h.a(i, i2, i3);
        if (i3 == 5) {
            this.b.setVisibility(4);
            this.f15884c.setVisibility(4);
        }
    }

    public void a(int i, long j) {
        if (this.i == null) {
            return;
        }
        if (i > 0) {
            this.b.setVisibility(0);
            this.f15884c.setVisibility(0);
        } else {
            this.b.setVisibility(4);
            this.f15884c.setVisibility(4);
        }
        this.b.setEnabled(i > 0);
        ImageView imageView = this.f15884c;
        boolean z = false;
        if (j >= this.i.x() * this.i.y()) {
            z = true;
        }
        StvViewUtils.a(imageView, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        switch (AnonymousClass2.f15886a[value.ordinal()]) {
            case 1:
            case 2:
                b();
                return;
            case 3:
                a(false);
                break;
            case 4:
            case 5:
                break;
            case 6:
                a(false);
                return;
            default:
                return;
        }
        a();
    }

    @Override // com.blued.android.module.shortvideo.observer.ReturnObserver
    public void a(EventType.VALUE value, boolean z) {
        if (z) {
            int i = AnonymousClass2.f15886a[value.ordinal()];
            if (i == 4) {
                a(true);
            } else if (i == 7) {
                a(false);
            } else if (i != 8) {
            } else {
                this.b.setActivated(false);
            }
        }
    }

    public void a(ShinePresenter shinePresenter) {
        this.i = shinePresenter;
        if (shinePresenter == null) {
            return;
        }
        setSpeedV(a(shinePresenter.y()));
        a(0, 0L);
    }

    public void b() {
        if (getVisibility() == 0) {
            StvViewUtils.b(getContext(), this);
        }
    }

    public void c() {
        this.f15883a.setEnabled(false);
        ObserverMgr.a().a((EventObserver) this);
        ObserverMgr.a().a((ReturnObserver) this);
    }

    public void d() {
        if (this.i.n() != 5) {
            a(false);
        }
    }

    public void e() {
        ObserverMgr.a().b((EventObserver) this);
        ObserverMgr.a().b((ReturnObserver) this);
    }

    public void f() {
        this.f15883a.setEnabled(true);
    }

    public void g() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (this.i == null) {
            return;
        }
        StvViewUtils.a(view);
        int id = view.getId();
        if (id == R.id.stv_record) {
            if (this.i.n() == 5) {
                ObserverMgr.a().a(EventType.VALUE.CAPTURE_FRAME);
            } else if (!view.isSelected()) {
                ObserverMgr.a().a(EventType.VALUE.SHINE_RECORD);
            } else {
                ObserverMgr.a().a(EventType.VALUE.SHINE_ENDRECORD);
                a(false);
            }
        } else if (id == R.id.stv_delete) {
            if (view.isActivated()) {
                ObserverMgr.a().a(EventType.VALUE.DELECT_LAST_SECOTION);
                return;
            }
            ObserverMgr.a().a(EventType.VALUE.SELECT_LAST_SECOTION);
            view.setActivated(true);
        } else if (id == R.id.stv_concat) {
            ObserverMgr.a().a(EventType.VALUE.CONCAT_SECOTION);
        } else if (id == R.id.stv_speed_2) {
            j();
        } else if (id == R.id.stv_speed_3) {
            k();
        } else if (id == R.id.stv_speed_4) {
            l();
        }
    }
}
