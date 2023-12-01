package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.adapter.FilterAdapter;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.widget.SpacesItemDecoration;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/FilterView.class */
public class FilterView extends EditBottomBaseView implements EventObserver {
    protected RecyclerView d;
    protected FilterAdapter e;
    private CommonModel f;
    private int g;
    private int h;

    /* renamed from: com.blued.android.module.shortvideo.view.FilterView$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/FilterView$2.class */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15896a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[EventType.VALUE.values().length];
            f15896a = iArr;
            try {
                iArr[EventType.VALUE.CONFIG_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15896a[EventType.VALUE.UPDATE_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public FilterView(Context context) {
        super(context);
    }

    public FilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void a() {
        this.d = (RecyclerView) LayoutInflater.from(getContext()).inflate(R.layout.stv_recyclerview, (ViewGroup) null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.d.setLayoutManager(linearLayoutManager);
        this.d.addItemDecoration(new SpacesItemDecoration(0, 30));
    }

    public void a(int i) {
        FilterAdapter filterAdapter = this.e;
        if (filterAdapter != null) {
            filterAdapter.a(i);
        }
        RecyclerView recyclerView = this.d;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(i);
        }
    }

    public void a(int i, int i2, int i3) {
        if (this.f == null) {
            return;
        }
        this.h = i2;
        this.g = i3;
        if (i != 2) {
            if (i3 == 1 || ((i3 == 4 && i2 == 3) || this.g == 5)) {
                if (this.e == null) {
                    FilterAdapter filterAdapter = new FilterAdapter(getContext(), this.f);
                    this.e = filterAdapter;
                    this.d.setAdapter(filterAdapter);
                }
                this.e.a(i, i2, i3);
            }
        }
    }

    public void a(CommonModel commonModel) {
        this.f = commonModel;
    }

    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        if (this.f == null) {
            return;
        }
        int i = AnonymousClass2.f15896a[value.ordinal()];
        if (i == 1) {
            c();
        } else if (i != 2) {
        } else {
            a((this.g == 4 && this.h == 3) ? this.f.getSelectFilterPosition() : this.f.getSelectFilterPosition());
        }
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected void b() {
        StvViewUtils.a(this.f15888c, 15, 16, 15, 20);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void c() {
        super.c();
        CommonModel commonModel = this.f;
        if (commonModel == null) {
            return;
        }
        if (this.g == 1) {
            commonModel.setShowVType(2);
        } else {
            commonModel.setShowVType(2);
        }
        this.d.postDelayed(new Runnable() { // from class: com.blued.android.module.shortvideo.view.FilterView.1
            @Override // java.lang.Runnable
            public void run() {
                FilterView.this.d.smoothScrollToPosition(FilterView.this.f.getSelectFilterPosition());
            }
        }, 50L);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void d() {
        super.d();
        CommonModel commonModel = this.f;
        if (commonModel != null) {
            commonModel.setShowVType(0);
        }
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected void e() {
        ObserverMgr.a().a(EventType.VALUE.SAVE_FILTER);
        d();
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected void f() {
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected boolean g() {
        return true;
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected View getContentV() {
        return this.d;
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected int getTitleId() {
        return R.string.stv_select_filter_title;
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void h() {
        ObserverMgr.a().a(this);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void i() {
    }

    public void j() {
        ObserverMgr.a().b(this);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void k() {
    }
}
