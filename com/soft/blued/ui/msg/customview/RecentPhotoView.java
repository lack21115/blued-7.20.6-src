package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.customview.SelectPhotoBarView;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.common_contract.ISelectPhotoBarCallback;
import com.soft.blued.ui.msg.adapter.RecentPhotoAdapter;
import com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import com.soft.blued.ui.msg.pop.GuideAttachPop;
import com.soft.blued.ui.msg.pop.PicPinPop;
import com.soft.blued.utils.BluedPreferences;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/RecentPhotoView.class */
public class RecentPhotoView extends RelativeLayout implements BluedSkinSupportable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f18615a = RecentPhotoView.class.getSimpleName();
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f18616c;
    private SelectPhotoBarView d;
    private RecentPhotoAdapter e;
    private IRecentPhotoOperationCallback f;
    private View g;
    private GuideAttachPop h;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/RecentPhotoView$IRecentPhotoOperationCallback.class */
    public interface IRecentPhotoOperationCallback extends ISelectPhotoBarCallback, IRecentPhotoAdapterCallback {
    }

    public RecentPhotoView(Context context) {
        this(context, null);
    }

    public RecentPhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecentPhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        b(context);
        this.f18616c = (RecyclerView) findViewById(R.id.msg_recent_pic_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f18616c.setLayoutManager(linearLayoutManager);
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(getContext(), 2.0f));
        spacesItemDecoration.a(0);
        spacesItemDecoration.a(DensityUtils.a(getContext(), 3.0f), 0, DensityUtils.a(getContext(), 3.0f), 0);
        spacesItemDecoration.a(true, true);
        this.f18616c.addItemDecoration(spacesItemDecoration);
        this.b = findViewById(R.id.msg_recent_photos_no_pics_layout);
        this.d = (SelectPhotoBarView) findViewById(R.id.msg_recent_bar_view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (this.h == null) {
            this.h = new GuideAttachPop(getContext(), getContext().getString(R.string.msg_pic_pin_guide), GuideAttachPop.ArrowPosition.CENTER, GuideAttachPop.Position.TOP, 0);
        }
        if (this.h.s()) {
            return;
        }
        BluedPreferences.eh();
        new XPopup.Builder(getContext()).a(view).b(false).a(PopupAnimation.a).a(PopupPosition.c).b(true).d(false).a(this.h).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final MsgRecentPhotoInfo msgRecentPhotoInfo, View view) {
        new XPopup.Builder(getContext()).a(view).a(PopupAnimation.a).a(PopupPosition.c).b(true).d(false).b(true).a(new PicPinPop(getContext(), msgRecentPhotoInfo.isPin, new PicPinPop.OperateListener() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.3
            @Override // com.soft.blued.ui.msg.pop.PicPinPop.OperateListener
            public void a() {
                CommonAlertDialog.a(RecentPhotoView.this.getContext(), RecentPhotoView.this.getContext().getResources().getString(R.string.msg_pic_remove_title), RecentPhotoView.this.getContext().getResources().getString(R.string.msg_pic_remove_hint), RecentPhotoView.this.getContext().getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        RecentPhotoView.this.e.getData().remove(msgRecentPhotoInfo);
                        if (RecentPhotoView.this.e.getData().size() == 0) {
                            RecentPhotoView.this.d();
                        } else {
                            RecentPhotoView.this.f.a(msgRecentPhotoInfo);
                        }
                        RecentPhotoView.this.a(false);
                    }
                }, RecentPhotoView.this.getContext().getResources().getString(R.string.common_cancel), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.3.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                    }
                }, (DialogInterface.OnDismissListener) null);
            }

            @Override // com.soft.blued.ui.msg.pop.PicPinPop.OperateListener
            public void b() {
                RecentPhotoView.this.f.b(msgRecentPhotoInfo);
                RecentPhotoView.this.f.a(new IRecentPhotoAdapterCallback.IGetPhotoListCallback() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.3.3
                    @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback.IGetPhotoListCallback
                    public void a(List<MsgRecentPhotoInfo> list) {
                        RecentPhotoView.this.e.setNewData(list);
                    }
                });
            }
        })).h();
    }

    private void c() {
        View inflate = View.inflate(getContext(), R.layout.layout_img_record_delete, null);
        this.g = inflate;
        this.e.addFooterView(inflate, -1, 0);
        this.g.setVisibility(8);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RecentPhotoView.this.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f.C();
        this.e.getData().clear();
        this.e.notifyDataSetChanged();
        a(false);
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
        RecyclerView recyclerView = this.f18616c;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        CommonAlertDialog.a(getContext(), getContext().getString(R.string.msg_clear_recent_img_title), getResources().getString(R.string.msg_clear_recent_img_desc), getContext().getString(R.string.msg_clear_recent_img_confirm), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                RecentPhotoView.this.d();
                EventTrackMessage.a(MessageProtos.Event.MSG_PHOTO_CLEAR_BTN_CLICK);
            }
        }, getContext().getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (RecentPhotoView.this.getVisibility() != 0 || RecentPhotoView.this.e == null || RecentPhotoView.this.e.getData().size() <= 0 || RecentPhotoView.this.f18616c == null || RecentPhotoView.this.f18616c.getChildCount() <= 0) {
                    return;
                }
                RecentPhotoView recentPhotoView = RecentPhotoView.this;
                recentPhotoView.a((View) recentPhotoView);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFixForRecycleView(View view) {
        if (this.f18616c == null || view == null) {
            return;
        }
        int width = view.getWidth();
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        if (rect.left > 0 && rect.right == width) {
            this.f18616c.scrollBy(-rect.left, 0);
        } else if (rect.left != 0 || rect.right >= width) {
        } else {
            this.f18616c.scrollBy(width - rect.right, 0);
        }
    }

    public void a() {
        SelectPhotoBarView selectPhotoBarView = this.d;
        if (selectPhotoBarView != null) {
            selectPhotoBarView.b();
        }
    }

    public void a(Context context) {
        if (this.d != null) {
            if (TextUtils.isEmpty(FlashPhotoManager.a().b().flash_prompt)) {
                this.d.setBurnBtnText(context.getString(R.string.msg_look_burn));
                return;
            }
            SelectPhotoBarView selectPhotoBarView = this.d;
            selectPhotoBarView.setBurnBtnText(context.getString(R.string.msg_look_burn) + "\n" + FlashPhotoManager.a().b().flash_prompt);
        }
    }

    public void a(IRequestHost iRequestHost, IRecentPhotoOperationCallback iRecentPhotoOperationCallback) {
        this.f = iRecentPhotoOperationCallback;
        RecentPhotoAdapter recentPhotoAdapter = new RecentPhotoAdapter(iRequestHost, iRecentPhotoOperationCallback);
        this.e = recentPhotoAdapter;
        recentPhotoAdapter.bindToRecyclerView(this.f18616c);
        this.f18616c.setAdapter(this.e);
        this.d.setOperationCallback(iRecentPhotoOperationCallback);
        this.e.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MsgRecentPhotoInfo msgRecentPhotoInfo = (MsgRecentPhotoInfo) baseQuickAdapter.getData().get(i);
                RecentPhotoView.this.setFixForRecycleView(view);
                RecentPhotoView.this.a(msgRecentPhotoInfo, view);
                return true;
            }
        });
        this.e.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                if (RecentPhotoView.this.e.getItem(i).isSelected) {
                    RecentPhotoView.this.e.a(RecentPhotoView.this.e.getItem(i));
                } else if (!RecentPhotoView.this.d.a() || RecentPhotoView.this.e.a()) {
                    RecentPhotoView.this.e.a(RecentPhotoView.this.e.getItem(i));
                } else {
                    PayVIPPopupWindow.c.a(RecentPhotoView.this.getContext(), RecentPhotoView.this.e.b(), (DialogInterface.OnDismissListener) null);
                }
            }
        });
        c();
    }

    public void a(boolean z) {
        IRecentPhotoOperationCallback iRecentPhotoOperationCallback = this.f;
        if (iRecentPhotoOperationCallback == null || iRecentPhotoOperationCallback.A() == null) {
            return;
        }
        if (this.f.A().size() <= 0) {
            View view = this.b;
            if (view != null) {
                view.setVisibility(0);
            }
            RecyclerView recyclerView = this.f18616c;
            if (recyclerView != null) {
                recyclerView.setVisibility(4);
            }
            SelectPhotoBarView selectPhotoBarView = this.d;
            if (selectPhotoBarView != null) {
                selectPhotoBarView.a(0);
                return;
            }
            return;
        }
        this.f.b(new IRecentPhotoAdapterCallback.IGetPhotoListCallback() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.8
            @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback.IGetPhotoListCallback
            public void a(final List<MsgRecentPhotoInfo> list) {
                AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RecentPhotoView.this.d != null) {
                            RecentPhotoView.this.d.a(list.size());
                        }
                    }
                });
            }
        });
        View view2 = this.b;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        RecyclerView recyclerView2 = this.f18616c;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        if (this.e != null) {
            this.g.setVisibility(0);
            this.e.notifyDataSetChanged();
        }
        if (z) {
            this.f18616c.scrollToPosition(0);
        }
    }

    public void applySkin() {
        findViewById(2131369264).setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
    }

    protected View b(Context context) {
        return View.inflate(context, R.layout.view_msg_recent_pic, this);
    }

    public void b() {
        if (!BluedPreferences.ei()) {
            f();
            this.e.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.soft.blued.ui.msg.customview.RecentPhotoView.6
                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    if (BluedPreferences.ei()) {
                        return;
                    }
                    RecentPhotoView.this.f();
                }
            });
        }
        a(false);
    }

    public void setBurnChecked(boolean z) {
        SelectPhotoBarView selectPhotoBarView = this.d;
        if (selectPhotoBarView != null) {
            selectPhotoBarView.setBurnBtnChecked(z);
        }
    }
}
