package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.shortvideo.adapter.ConfigAdapter;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.observer.ReturnObserver;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.widget.SpacesItemDecoration;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/ConfigView.class */
public class ConfigView extends RecyclerView implements EventObserver, ReturnObserver {

    /* renamed from: a  reason: collision with root package name */
    private ConfigAdapter f15881a;

    /* renamed from: com.blued.android.module.shortvideo.view.ConfigView$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/ConfigView$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15882a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0089 -> B:51:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008d -> B:67:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0091 -> B:61:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0095 -> B:55:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0099 -> B:49:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009d -> B:65:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a1 -> B:59:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a5 -> B:53:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00a9 -> B:47:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00ad -> B:63:0x007c). Please submit an issue!!! */
        static {
            int[] iArr = new int[EventType.VALUE.values().length];
            f15882a = iArr;
            try {
                iArr[EventType.VALUE.START_TIMEDOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15882a[EventType.VALUE.CONFIG_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15882a[EventType.VALUE.CONFIG_COVER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15882a[EventType.VALUE.CONFIG_VOLUME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15882a[EventType.VALUE.HIDE_COVER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15882a[EventType.VALUE.SHINE_ENDRECORD.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15882a[EventType.VALUE.RECOVER_SHINE_V.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f15882a[EventType.VALUE.CONCAT_SECTION_FINISH.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f15882a[EventType.VALUE.SAVE_VOLUME.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f15882a[EventType.VALUE.SAVE_FILTER.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f15882a[EventType.VALUE.UPDATE_FILTER.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public ConfigView(Context context) {
        super(context);
        g();
    }

    public ConfigView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public ConfigView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    private void g() {
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        setClipChildren(false);
    }

    public int a(boolean z) {
        ConfigAdapter configAdapter = this.f15881a;
        if (configAdapter != null) {
            return configAdapter.a(z);
        }
        return -1;
    }

    public void a() {
        if (getVisibility() == 8) {
            setVisibility(0);
            StvViewUtils.c(getContext(), this);
        }
    }

    public void a(int i, int i2, int i3) {
        if (i == 2) {
            b();
            return;
        }
        this.f15881a.a(i, i2, i3);
        setAdapter(this.f15881a);
        a(0, 0L);
    }

    public void a(int i, long j) {
        ConfigAdapter configAdapter = this.f15881a;
        if (configAdapter != null) {
            configAdapter.a(i, j);
        }
    }

    public void a(CommonModel commonModel) {
        this.f15881a = new ConfigAdapter(commonModel);
        addItemDecoration(new SpacesItemDecoration(1, DensityUtils.a(getContext(), 18.0f)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        switch (AnonymousClass1.f15882a[value.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                b();
                return;
            case 5:
                ConfigAdapter configAdapter = this.f15881a;
                if (configAdapter != null) {
                    configAdapter.a();
                    break;
                }
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
            case 11:
                ConfigAdapter configAdapter2 = this.f15881a;
                if (configAdapter2 != null) {
                    configAdapter2.b();
                    return;
                }
                return;
            default:
                return;
        }
        a();
    }

    @Override // com.blued.android.module.shortvideo.observer.ReturnObserver
    public void a(EventType.VALUE value, boolean z) {
        if (z) {
            if (value == EventType.VALUE.SHINE_RECORD) {
                b();
            } else if (value == EventType.VALUE.SHINE_ENDRECORD) {
                a();
            }
        }
    }

    public void b() {
        if (getVisibility() == 0) {
            StvViewUtils.d(getContext(), this);
        }
    }

    public void c() {
        ObserverMgr.a().a((EventObserver) this);
        ObserverMgr.a().a((ReturnObserver) this);
    }

    public void d() {
        a();
    }

    public void e() {
        ObserverMgr.a().b((EventObserver) this);
        ObserverMgr.a().b((ReturnObserver) this);
    }

    public void f() {
    }
}
