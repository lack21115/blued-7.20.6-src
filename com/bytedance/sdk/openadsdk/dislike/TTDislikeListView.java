package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeController;
import com.bytedance.sdk.openadsdk.api.b;
import com.bytedance.sdk.openadsdk.api.ox;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/dislike/TTDislikeListView.class */
public class TTDislikeListView extends ListView {
    private TTDislikeController mDislikeController;
    private EventListener mOnItemClickBridge;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListenerInner;

    public TTDislikeListView(Context context) {
        super(context);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i) == null || !(TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (TTDislikeListView.this.mDislikeController != null) {
                    TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                }
                if (TTDislikeListView.this.mOnItemClickListener != null) {
                    TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i, j);
                }
                if (TTDislikeListView.this.mOnItemClickBridge != null) {
                    TTDislikeListView.this.mOnItemClickBridge.onEvent(0, ox.mb().mb(b.mb().mb(0, filterWord.getId()).mb(1, filterWord.getName()).ox()).ox());
                }
            }
        };
        init();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i) == null || !(TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (TTDislikeListView.this.mDislikeController != null) {
                    TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                }
                if (TTDislikeListView.this.mOnItemClickListener != null) {
                    TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i, j);
                }
                if (TTDislikeListView.this.mOnItemClickBridge != null) {
                    TTDislikeListView.this.mOnItemClickBridge.onEvent(0, ox.mb().mb(b.mb().mb(0, filterWord.getId()).mb(1, filterWord.getName()).ox()).ox());
                }
            }
        };
        init();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Tracker.onItemClick(adapterView, view, i2, j);
                if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i2) == null || !(TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (TTDislikeListView.this.mDislikeController != null) {
                    TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                }
                if (TTDislikeListView.this.mOnItemClickListener != null) {
                    TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i2, j);
                }
                if (TTDislikeListView.this.mOnItemClickBridge != null) {
                    TTDislikeListView.this.mOnItemClickBridge.onEvent(0, ox.mb().mb(b.mb().mb(0, filterWord.getId()).mb(1, filterWord.getName()).ox()).ox());
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnItemClickListener(this.mOnItemClickListenerInner);
    }

    public void setDislikeInfo(TTDislikeController tTDislikeController) {
        this.mDislikeController = tTDislikeController;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener instanceof EventListener) {
            this.mOnItemClickBridge = (EventListener) onItemClickListener;
        } else {
            this.mOnItemClickListener = onItemClickListener;
        }
    }
}
