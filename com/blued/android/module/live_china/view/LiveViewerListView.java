package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.view.pulltorefresh.RecyclerViewSpacing;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveOnlineUserDialogFragment;
import com.blued.android.module.live_china.liveForMsg.data.LiveMsgPeopleAdapter;
import com.blued.android.module.live_china.manager.LiveRoomManager;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveViewerListView.class */
public class LiveViewerListView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    float f14958a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f14959c;
    private View d;
    private RecyclerView e;
    private LiveMsgPeopleAdapter f;
    private FragmentManager g;
    private Boolean h;

    public LiveViewerListView(Context context) {
        this(context, null);
    }

    public LiveViewerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14958a = 0.0f;
        this.h = false;
        this.b = context;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f14958a = motionEvent.getX();
            return false;
        } else if (action == 1 && Math.abs(motionEvent.getX() - this.f14958a) < 10.0f) {
            LiveOnlineUserDialogFragment.f13080a.a(this.g);
            return true;
        } else {
            return false;
        }
    }

    private void d() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f14959c = from;
        View inflate = from.inflate(R.layout.live_viewer_list_view, (ViewGroup) this, true);
        this.d = inflate;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.live_viewer_listview);
        this.e = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.b, 0, false));
        this.e.addItemDecoration(new RecyclerViewSpacing(this.b, 0, 1));
        LiveMsgPeopleAdapter liveMsgPeopleAdapter = new LiveMsgPeopleAdapter(this.b);
        this.f = liveMsgPeopleAdapter;
        this.e.setAdapter(liveMsgPeopleAdapter);
    }

    public void a() {
        if (LiveRoomManager.a().p() == null) {
            return;
        }
        this.f.a();
    }

    public void a(FragmentManager fragmentManager, boolean z) {
        this.g = fragmentManager;
        this.h = Boolean.valueOf(z);
        this.f.a(Boolean.valueOf(z));
        if (this.h.booleanValue()) {
            return;
        }
        this.e.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveViewerListView$O3pcSE8Aw-aIE5it3lIsy9VbO-Y
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a2;
                a2 = LiveViewerListView.this.a(view, motionEvent);
                return a2;
            }
        });
    }

    public void b() {
        this.e.setVisibility(8);
    }

    public void c() {
        this.e.setVisibility(0);
    }
}
