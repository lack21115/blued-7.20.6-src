package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.anythink.core.api.ErrorCode;
import com.blued.android.framework.ui.xpop.util.KeyboardUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveDesireGiftNumberModel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveDesireGiftNumberAdapter.class */
public class LiveDesireGiftNumberAdapter extends BaseMultiItemQuickAdapter<LiveDesireGiftNumberModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public FragmentManager f11611a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public int f11612c;
    private GiftNumberEventCallBack d;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveDesireGiftNumberAdapter$GiftNumberEventCallBack.class */
    public interface GiftNumberEventCallBack {
        void giftNumber(LiveDesireGiftNumberModel liveDesireGiftNumberModel);
    }

    public LiveDesireGiftNumberAdapter(Context context, FragmentManager fragmentManager, GiftNumberEventCallBack giftNumberEventCallBack) {
        super(new ArrayList());
        this.f11612c = 0;
        this.mContext = context;
        this.f11611a = fragmentManager;
        this.d = giftNumberEventCallBack;
        addItemType(0, R.layout.item_live_desire_gift_number);
        addItemType(1, R.layout.item_live_desire_gift_number_input);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, LiveDesireGiftNumberModel liveDesireGiftNumberModel) {
        if ((liveDesireGiftNumberModel == null || this.f11612c != liveDesireGiftNumberModel.id) && this.d != null) {
            View view2 = this.b;
            if (view2 != null) {
                a(view2, false);
            }
            if (view != null) {
                a(view, true);
                this.b = view;
                this.f11612c = liveDesireGiftNumberModel.id;
            } else {
                this.b = null;
                this.f11612c = 0;
            }
            this.d.giftNumber(liveDesireGiftNumberModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, LiveDesireGiftNumberModel liveDesireGiftNumberModel, View view2) {
        a(view, liveDesireGiftNumberModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z) {
        if (z && a(view)) {
            return;
        }
        if (z || a(view)) {
            view.setTag(Boolean.valueOf(z));
            if (z) {
                view.setPivotX(view.getWidth() / 2);
                view.setPivotY(view.getHeight() / 2);
                view.setScaleX(0.9f);
                view.setScaleY(0.9f);
            }
            ViewPropertyAnimator scaleX = view.animate().alpha(z ? 1.0f : 0.0f).scaleX(z ? 1.0f : 0.9f);
            float f = 0.9f;
            if (z) {
                f = 1.0f;
            }
            scaleX.scaleY(f).setDuration(70L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(EditText editText, LiveDesireGiftNumberModel liveDesireGiftNumberModel, View view) {
        if (editText.getText() == null || TextUtils.isEmpty(editText.getText().toString())) {
            return;
        }
        a(view, liveDesireGiftNumberModel);
    }

    private void a(final LiveDesireGiftNumberModel liveDesireGiftNumberModel, final EditText editText, final View view, final View view2) {
        editText.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.live_china.adapter.LiveDesireGiftNumberAdapter.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i;
                boolean z;
                if (editable == null || editable.length() == 0 || !LiveDesireGiftNumberAdapter.this.a(editable.toString())) {
                    i = 0;
                    z = false;
                } else if (editable.length() > 4) {
                    editText.setText(ErrorCode.exception);
                    editText.setSelection(4);
                    return;
                } else {
                    i = Integer.parseInt(editable.toString());
                    z = true;
                }
                if (z) {
                    liveDesireGiftNumberModel.count = i;
                    LiveDesireGiftNumberAdapter.this.a(view, true);
                    LiveDesireGiftNumberAdapter.this.a(view, liveDesireGiftNumberModel);
                    LiveDesireGiftNumberAdapter.this.a(view2, true);
                    return;
                }
                liveDesireGiftNumberModel.count = 0;
                view.setClickable(false);
                if (LiveDesireGiftNumberAdapter.this.f11612c == liveDesireGiftNumberModel.id) {
                    LiveDesireGiftNumberAdapter.this.a((View) null, (LiveDesireGiftNumberModel) null);
                }
                LiveDesireGiftNumberAdapter.this.a(view2, false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireGiftNumberAdapter$HH87omUZPN9sRw4qPSge2Wtw48A
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean a2;
                a2 = LiveDesireGiftNumberAdapter.a(EditText.this, textView, i, keyEvent);
                return a2;
            }
        });
    }

    private boolean a(View view) {
        if (view.getTag() != null && (view.getTag() instanceof Boolean)) {
            return ((Boolean) view.getTag()).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(EditText editText, TextView textView, int i, KeyEvent keyEvent) {
        KeyboardUtils.b(editText);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void b(BaseViewHolder baseViewHolder, final LiveDesireGiftNumberModel liveDesireGiftNumberModel) {
        ((TextView) baseViewHolder.getView(R.id.tv_number)).setText(String.valueOf(liveDesireGiftNumberModel.count));
        ((TextView) baseViewHolder.getView(R.id.tv_title)).setText(liveDesireGiftNumberModel.title);
        final View view = baseViewHolder.getView(R.id.iv_check);
        if (this.f11612c == liveDesireGiftNumberModel.id) {
            view.setAlpha(1.0f);
            view.setTag(true);
            this.b = view;
        } else {
            view.setAlpha(0.0f);
        }
        baseViewHolder.getView(R.id.rl_root).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireGiftNumberAdapter$jHzBAkf8SbaLCQU0o4TKy3bXoIM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveDesireGiftNumberAdapter.this.a(view, liveDesireGiftNumberModel, view2);
            }
        });
    }

    private void c(BaseViewHolder baseViewHolder, final LiveDesireGiftNumberModel liveDesireGiftNumberModel) {
        final EditText editText = (EditText) baseViewHolder.getView(R.id.et_number);
        View view = baseViewHolder.getView(R.id.iv_check);
        View view2 = baseViewHolder.getView(R.id.iv_check_not);
        a(liveDesireGiftNumberModel, editText, view, view2);
        if (liveDesireGiftNumberModel.count > 0) {
            editText.setText(String.valueOf(liveDesireGiftNumberModel.count));
            view2.setAlpha(1.0f);
        } else {
            editText.setText("");
            view2.setAlpha(0.0f);
        }
        if (this.f11612c == liveDesireGiftNumberModel.id) {
            view.setAlpha(1.0f);
            view.setTag(true);
            this.b = view;
        } else {
            view.setAlpha(0.0f);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireGiftNumberAdapter$1r4-Rd1vb54hcI8UXEG17PudcUU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LiveDesireGiftNumberAdapter.this.a(editText, liveDesireGiftNumberModel, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, LiveDesireGiftNumberModel liveDesireGiftNumberModel) {
        int i = liveDesireGiftNumberModel.type;
        if (i == 0) {
            b(baseViewHolder, liveDesireGiftNumberModel);
        } else if (i != 1) {
        } else {
            c(baseViewHolder, liveDesireGiftNumberModel);
        }
    }

    public void a(List<LiveDesireGiftNumberModel> list) {
        setNewData(list);
        setEnableLoadMore(false);
    }
}
