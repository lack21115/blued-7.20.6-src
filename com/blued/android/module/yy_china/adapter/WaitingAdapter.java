package com.blued.android.module.yy_china.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ClickApplyHandleListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/WaitingAdapter.class */
public class WaitingAdapter extends BaseQuickAdapter<YYAudienceModel, BaseViewHolder> {
    private BaseYYStudioFragment a;
    private ClickApplyHandleListener b;

    public WaitingAdapter(BaseYYStudioFragment baseYYStudioFragment) {
        super(R.layout.item_yy_waitting_layout, new ArrayList());
        this.mContext = baseYYStudioFragment.getContext();
        this.a = baseYYStudioFragment;
    }

    public void a(int i) {
        if (i < 0 || i >= getData().size()) {
            return;
        }
        getData().remove(i);
        notifyDataSetChanged();
    }

    public void a(ClickApplyHandleListener clickApplyHandleListener) {
        this.b = clickApplyHandleListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final YYAudienceModel yYAudienceModel) {
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.btn_reject);
        final ShapeTextView shapeTextView2 = (ShapeTextView) baseViewHolder.getView(R.id.btn_accept);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_seat);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        textView.setText(YYRoomInfoManager.e().a(yYAudienceModel.getUid(), yYAudienceModel.getName()));
        YYRoomInfoManager.e().b(this.a.getFragmentActive(), imageView, yYAudienceModel.getUid(), yYAudienceModel.getAvatar());
        if (yYAudienceModel.mic_position == 0) {
            textView2.setText(this.mContext.getResources().getString(R.string.yy_up_seat));
        } else {
            textView2.setText(String.format(this.mContext.getResources().getString(R.string.yy_mic_position), Integer.valueOf(yYAudienceModel.mic_position)));
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.WaitingAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (WaitingAdapter.this.b != null) {
                    WaitingAdapter.this.b.a(yYAudienceModel, 0, baseViewHolder.getAdapterPosition());
                }
            }
        });
        shapeTextView2.setEnabled(true);
        shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.WaitingAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                shapeTextView2.setEnabled(false);
                if (WaitingAdapter.this.b != null) {
                    WaitingAdapter.this.b.a(yYAudienceModel, 1, baseViewHolder.getAdapterPosition());
                }
            }
        });
    }

    public void b(int i) {
        View viewByPosition;
        if (i < getData().size() && (viewByPosition = getViewByPosition(i, R.id.btn_accept)) != null) {
            viewByPosition.setEnabled(true);
        }
    }
}
