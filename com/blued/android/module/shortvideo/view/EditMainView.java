package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.EditPresenter;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/EditMainView.class */
public class EditMainView extends FrameLayout implements View.OnClickListener, EventObserver {
    private TextView a;
    private CheckBox b;
    private View c;
    private EditPresenter d;
    private int e;

    /* renamed from: com.blued.android.module.shortvideo.view.EditMainView$3  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/EditMainView$3.class */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[EventType.VALUE.values().length];
            a = iArr;
            try {
                iArr[EventType.VALUE.CONFIG_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[EventType.VALUE.CONFIG_COVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[EventType.VALUE.CONFIG_VOLUME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[EventType.VALUE.HIDE_COVER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[EventType.VALUE.SAVE_FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[EventType.VALUE.SAVE_VOLUME.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public EditMainView(Context context) {
        this(context, null);
    }

    public EditMainView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditMainView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        g();
    }

    private void g() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.edit_main_view, this);
        this.c = inflate;
        this.a = (TextView) inflate.findViewById(R.id.stv_edit_finish);
        this.b = (CheckBox) this.c.findViewById(R.id.stv_delete_auto_cb);
    }

    private void h() {
        this.b.setVisibility(0);
        this.a.setText(R.string.stv_send);
    }

    private void i() {
        this.b.setVisibility(8);
        this.a.setText(R.string.stv_send);
    }

    private void j() {
        this.b.setVisibility(8);
        this.a.setText(R.string.stv_upload);
    }

    public void a() {
        if (getVisibility() == 8) {
            postDelayed(new Runnable() { // from class: com.blued.android.module.shortvideo.view.EditMainView.2
                @Override // java.lang.Runnable
                public void run() {
                    EditMainView.this.setVisibility(0);
                    StvViewUtils.a(EditMainView.this.getContext(), EditMainView.this);
                }
            }, 200L);
        }
    }

    public void a(int i, int i2, int i3, DeleteAutoCheckedListener deleteAutoCheckedListener) {
        if (i == 0) {
            j();
            return;
        }
        if (i != 1) {
            if (i == 7) {
                i();
                return;
            } else if (i != 61) {
                return;
            }
        }
        h();
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.shortvideo.view.EditMainView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                boolean z = !EditMainView.this.d.u();
                EditMainView.this.b.setSelected(z);
                EditMainView.this.d.d(z);
            }
        });
    }

    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        switch (AnonymousClass3.a[value.ordinal()]) {
            case 1:
            case 2:
            case 3:
                b();
                return;
            case 4:
            case 5:
            case 6:
                a();
                return;
            default:
                return;
        }
    }

    public void a(EditPresenter editPresenter) {
        this.d = editPresenter;
        this.a.setOnClickListener(this);
    }

    public void b() {
        if (getVisibility() == 0) {
            StvViewUtils.b(getContext(), this);
        }
    }

    public void c() {
        ObserverMgr.a().a(this);
    }

    public void d() {
    }

    public void e() {
        ObserverMgr.a().b(this);
    }

    public void f() {
    }

    public CheckBox getDeleteAutoCb() {
        return this.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        StvViewUtils.a(view);
        if (view.getId() == R.id.stv_edit_finish) {
            ObserverMgr.a().a(EventType.VALUE.EDIT_FINISH);
        }
    }

    public void setDeleteAutoCbText(String str) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.setText(str);
    }

    public void setDeleteAutoNumber(int i) {
        this.e = i;
    }
}
