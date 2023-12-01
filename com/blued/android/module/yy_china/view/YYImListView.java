package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYImMsgAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.observer.IMMessageObserver;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYImListView.class */
public class YYImListView extends RelativeLayout implements View.OnClickListener, FollowStatusObserver, IMMessageObserver {
    public YYImMsgAdapter a;
    private BaseYYStudioFragment b;
    private RecycleViewCustomer c;
    private ShapeTextView d;
    private LinearLayoutManager e;
    private boolean f;
    private int g;
    private Observer<String> h;
    private int i;

    public YYImListView(Context context) {
        super(context);
        this.f = false;
        this.h = new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYImListView.1
            /* renamed from: a */
            public void onChanged(String str) {
                if (YYImListView.this.a != null) {
                    YYImListView.this.a.notifyDataSetChanged();
                }
            }
        };
        this.i = 100;
        a();
    }

    public YYImListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.h = new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYImListView.1
            /* renamed from: a */
            public void onChanged(String str) {
                if (YYImListView.this.a != null) {
                    YYImListView.this.a.notifyDataSetChanged();
                }
            }
        };
        this.i = 100;
        a();
    }

    public YYImListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
        this.h = new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYImListView.1
            /* renamed from: a */
            public void onChanged(String str) {
                if (YYImListView.this.a != null) {
                    YYImListView.this.a.notifyDataSetChanged();
                }
            }
        };
        this.i = 100;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_im_list_view, (ViewGroup) this, true);
        this.c = (RecycleViewCustomer) findViewById(R.id.im_list_view);
        ShapeTextView shapeTextView = (ShapeTextView) findViewById(R.id.tv_new_msg);
        this.d = shapeTextView;
        shapeTextView.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.e = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.c.setLayoutManager(this.e);
        this.c.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.view.YYImListView.2
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.bottom = DensityUtils.a(YYImListView.this.getContext(), 4.0f);
            }
        });
        this.c.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.yy_china.view.YYImListView.3
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager2 = layoutManager;
                    YYImListView.this.g = linearLayoutManager2.findLastVisibleItemPosition();
                    if (recyclerView.canScrollVertically(1) || YYImListView.this.g != YYImListView.this.e.getItemCount() - 1) {
                        YYImListView.this.f = false;
                    } else {
                        YYImListView.this.f = true;
                    }
                    if (!YYImListView.this.f) {
                        YYImListView.this.a(false);
                    } else if (YYImListView.this.d.getVisibility() == 0) {
                        YYImListView.this.a(false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.c.scrollToPosition(i);
    }

    public void a(int i) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        Iterator<YYImModel> it = b.getImDatas().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().type == i) {
                it.remove();
                break;
            }
        }
        this.a.notifyDataSetChanged();
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.b = baseYYStudioFragment;
        YYImMsgAdapter yYImMsgAdapter = new YYImMsgAdapter(baseYYStudioFragment);
        this.a = yYImMsgAdapter;
        yYImMsgAdapter.bindToRecyclerView(this.c);
        this.c.setAdapter(this.a);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            List<YYImModel> imDatas = b.getImDatas();
            this.a.setNewData(imDatas);
            if (imDatas.size() > 0) {
                baseYYStudioFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYImListView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        YYImListView yYImListView = YYImListView.this;
                        yYImListView.b(yYImListView.a.getItemCount() - 1);
                    }
                }, 50L);
            }
        }
    }

    @Override // com.blued.android.module.yy_china.observer.IMMessageObserver
    public void a(YYImModel yYImModel) {
        this.b.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYImListView.5
            @Override // java.lang.Runnable
            public void run() {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                int size = b.getImDatas().size();
                if (size >= YYImListView.this.i) {
                    b.getImDatas().remove(0);
                }
                YYImListView.this.a.notifyDataSetChanged();
                if (!YYImListView.this.f && size > 3) {
                    YYImListView.this.a(true);
                    return;
                }
                YYImListView yYImListView = YYImListView.this;
                yYImListView.b(yYImListView.a.getItemCount() - 1);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.observer.FollowStatusObserver
    public void a_(String str, String str2) {
        if (TextUtils.equals(str2, "1") || TextUtils.equals(str2, "3")) {
            a(-3);
        }
    }

    public void b(YYImModel yYImModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        b.getImDatas().remove(yYImModel);
        this.a.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.e("observer", "onAttachedToWindow ... ");
        YYObserverManager.a().a((IMMessageObserver) this);
        YYObserverManager.a().a((FollowStatusObserver) this);
        LiveEventBus.get("take_off_mask", String.class).observeForever(this.h);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_new_msg) {
            a(false);
            b(this.a.getItemCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.e("observer", "onDetachedFromWindow ... ");
        YYObserverManager.a().b((IMMessageObserver) this);
        YYObserverManager.a().b((FollowStatusObserver) this);
        LiveEventBus.get("take_off_mask", String.class).removeObserver(this.h);
        this.a.a();
    }
}
