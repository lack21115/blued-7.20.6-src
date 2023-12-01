package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveShakeScrollAdapter;
import com.blued.android.module.live_china.manager.ScrollSpeedLinearLayoutManger;
import com.blued.android.module.live_china.model.LiveShakeResModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveShakeScrollView.class */
public class LiveShakeScrollView extends FrameLayout {
    EventCallback a;
    private Context b;
    private RecyclerView c;
    private LiveShakeScrollAdapter d;
    private int e;
    private int f;
    private int g;
    private Integer[] h;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveShakeScrollView$EventCallback.class */
    public interface EventCallback {
        void a();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveShakeScrollView$RecyclerViewTouchDisabler.class */
    public class RecyclerViewTouchDisabler implements RecyclerView.OnItemTouchListener {
        public RecyclerViewTouchDisabler() {
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return true;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    public LiveShakeScrollView(Context context) {
        this(context, null);
    }

    public LiveShakeScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveShakeScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.h = new Integer[]{Integer.valueOf(R.drawable.live_shake_num_0), Integer.valueOf(R.drawable.live_shake_num_1), Integer.valueOf(R.drawable.live_shake_num_2), Integer.valueOf(R.drawable.live_shake_num_3), Integer.valueOf(R.drawable.live_shake_num_4), Integer.valueOf(R.drawable.live_shake_num_5), Integer.valueOf(R.drawable.live_shake_num_6), Integer.valueOf(R.drawable.live_shake_num_7), Integer.valueOf(R.drawable.live_shake_num_8), Integer.valueOf(R.drawable.live_shake_num_9)};
        this.b = context;
        LayoutInflater.from(context).inflate(R.layout.live_shake_scroll_view, this);
        this.c = findViewById(R.id.recy_view);
        ScrollSpeedLinearLayoutManger scrollSpeedLinearLayoutManger = new ScrollSpeedLinearLayoutManger(context);
        scrollSpeedLinearLayoutManger.a();
        scrollSpeedLinearLayoutManger.setReverseLayout(true);
        this.c.setLayoutManager(scrollSpeedLinearLayoutManger);
        LiveShakeScrollAdapter liveShakeScrollAdapter = new LiveShakeScrollAdapter(context);
        this.d = liveShakeScrollAdapter;
        this.c.setAdapter(liveShakeScrollAdapter);
        this.c.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.live_china.view.LiveShakeScrollView.1
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0 && LiveShakeScrollView.this.a != null) {
                    LiveShakeScrollView.this.a.a();
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
            }
        });
        this.c.addOnItemTouchListener(new RecyclerViewTouchDisabler());
    }

    private void setPosition(final int i) {
        this.c.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveShakeScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                LiveShakeScrollView.this.g = i;
                LiveShakeScrollView liveShakeScrollView = LiveShakeScrollView.this;
                liveShakeScrollView.f = liveShakeScrollView.g;
                LiveShakeScrollView.this.c.smoothScrollToPosition(LiveShakeScrollView.this.f);
            }
        }, 500L);
    }

    public List<LiveShakeResModel> a(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LiveShakeResModel(10));
        int[] b = b(10);
        int length = b.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            arrayList.add(new LiveShakeResModel(b[i3] - 1));
            i2 = i3 + 1;
        }
        int[] b2 = b(3);
        int length2 = b2.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length2) {
                arrayList.add(new LiveShakeResModel(i));
                return arrayList;
            }
            arrayList.add(new LiveShakeResModel(b2[i5] - 1));
            i4 = i5 + 1;
        }
    }

    public void a(int i, boolean z) {
        int i2;
        ArrayList arrayList = new ArrayList();
        if (i == -1) {
            arrayList.add(new LiveShakeResModel(10));
        } else {
            if (i < 0) {
                i2 = 0;
            } else {
                i2 = i;
                if (i >= 10) {
                    i2 = 10;
                }
            }
            if (z) {
                arrayList = a(i2);
            } else {
                arrayList.add(new LiveShakeResModel(i2));
            }
        }
        this.d.a(arrayList);
        if (z) {
            setPosition(arrayList.size() - 1);
        }
    }

    public int[] b(int i) {
        boolean z;
        int[] iArr = new int[i];
        int i2 = 0;
        while (i2 < i) {
            int nextInt = new Random().nextInt(10) + 1;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                z = true;
                if (i4 >= i) {
                    break;
                } else if (nextInt == iArr[i4]) {
                    z = false;
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
            if (z) {
                iArr[i2] = nextInt;
                i2++;
            }
        }
        return iArr;
    }

    public void setEventCallback(EventCallback eventCallback) {
        this.a = eventCallback;
    }
}
