package com.sobot.chat.widget.kpswitch.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/BaseChattingPanelView.class */
public abstract class BaseChattingPanelView {
    protected Context context;
    private View rootView;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/BaseChattingPanelView$SobotBasePanelListener.class */
    public interface SobotBasePanelListener {
    }

    public BaseChattingPanelView(Context context) {
        this.rootView = null;
        this.context = null;
        this.context = context;
        View initView = initView();
        this.rootView = initView;
        initView.setTag(getRootViewTag());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getResDrawableId(String str) {
        return ResourceUtils.getIdByName(this.context, i.f5112c, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getResId(String str) {
        return ResourceUtils.getIdByName(this.context, "id", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getResInteger(String str) {
        return this.context.getResources().getInteger(getResIntegerId(str));
    }

    protected int getResIntegerId(String str) {
        return ResourceUtils.getIdByName(this.context, TypedValues.Custom.S_INT, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getResLayoutId(String str) {
        return ResourceUtils.getIdByName(this.context, "layout", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResString(String str) {
        return ResourceUtils.getResString(this.context, str);
    }

    protected int getResStringId(String str) {
        return ResourceUtils.getIdByName(this.context, "string", str);
    }

    public View getRootView() {
        return this.rootView;
    }

    public abstract String getRootViewTag();

    public abstract void initData();

    public abstract View initView();

    public void onViewStart(Bundle bundle) {
    }

    public abstract void setListener(SobotBasePanelListener sobotBasePanelListener);
}
