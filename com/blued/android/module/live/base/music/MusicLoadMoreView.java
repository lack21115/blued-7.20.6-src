package com.blued.android.module.live.base.music;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.module.live.base.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/MusicLoadMoreView.class */
public class MusicLoadMoreView extends InternalClassics implements RefreshFooter {
    protected boolean a;
    private View b;

    /* renamed from: com.blued.android.module.live.base.music.MusicLoadMoreView$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/MusicLoadMoreView$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            try {
                iArr[RefreshState.a.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[RefreshState.c.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[RefreshState.m.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[RefreshState.k.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[RefreshState.g.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[RefreshState.l.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public MusicLoadMoreView(Context context) {
        this(context, null);
    }

    public MusicLoadMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MusicLoadMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = LayoutInflater.from(context).inflate(R.layout.music_load_more, (ViewGroup) this).findViewById(R.id.load_more_loading_view);
    }

    public int a(RefreshLayout refreshLayout, boolean z) {
        if (this.a) {
            return 0;
        }
        if (z) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        return super.a(refreshLayout, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        if (this.a) {
            return;
        }
        switch (AnonymousClass1.a[refreshState2.ordinal()]) {
            case 1:
                this.b.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.b.setVisibility(0);
                return;
            case 5:
                this.b.setVisibility(0);
                return;
            case 6:
                this.b.setVisibility(0);
                return;
            default:
                return;
        }
        this.b.setVisibility(0);
    }

    public boolean a(boolean z) {
        if (this.a != z) {
            this.a = z;
            if (z) {
                this.b.setVisibility(8);
                return true;
            }
            this.b.setVisibility(0);
            return true;
        }
        return true;
    }
}
