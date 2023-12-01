package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.module.shortvideo.adapter.VideoCoverAdapter;
import com.blued.android.module.shortvideo.contract.IGetFrameCallback;
import com.blued.android.module.shortvideo.model.VideoFrameInfo;
import com.blued.android.module.shortvideo.model.VideoFrameModel;
import com.blued.android.module.shortvideo.widget.SpacesItemDecoration;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/VideoFrameView.class */
public class VideoFrameView extends RelativeLayout implements IGetFrameCallback {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f15928a;
    private VideoCoverAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private String f15929c;
    private long d;
    private int e;
    private int f;
    private int g;
    private int h;

    public VideoFrameView(Context context) {
        this(context, null);
    }

    public VideoFrameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a() {
        RecyclerView recyclerView = this.f15928a;
        if (recyclerView != null) {
            recyclerView.clearOnScrollListeners();
        }
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        this.f15928a.addOnScrollListener(onScrollListener);
    }

    @Override // com.blued.android.module.shortvideo.contract.IGetFrameCallback
    public void a(final VideoFrameInfo videoFrameInfo) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.shortvideo.view.VideoFrameView.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoFrameView.this.b != null) {
                    VideoFrameView.this.b.a(videoFrameInfo);
                }
            }
        });
    }

    public void a(String str, long j, int i, int i2, int i3, int i4) {
        this.f15929c = str;
        this.d = j;
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        RecyclerView recyclerView = new RecyclerView(getContext());
        this.f15928a = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        VideoCoverAdapter videoCoverAdapter = new VideoCoverAdapter(getContext(), i);
        this.b = videoCoverAdapter;
        this.f15928a.setAdapter(videoCoverAdapter);
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(0, 0, i4);
        spacesItemDecoration.a(i3, 0, i3, 0);
        spacesItemDecoration.a(true, true);
        this.f15928a.addItemDecoration(spacesItemDecoration);
        VideoFrameModel.getInstance().getVideoFrame(str, 0L, j, i4, i, i2, this);
        addView(this.f15928a);
    }
}
