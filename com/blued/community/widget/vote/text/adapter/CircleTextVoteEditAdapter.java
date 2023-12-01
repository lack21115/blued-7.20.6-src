package com.blued.community.widget.vote.text.adapter;

import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.R;
import com.blued.community.widget.vote.text.model.CircleTextVote;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/vote/text/adapter/CircleTextVoteEditAdapter.class */
public class CircleTextVoteEditAdapter extends BaseQuickAdapter<CircleTextVote, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private OnEditChangeListener f6882a;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/vote/text/adapter/CircleTextVoteEditAdapter$OnEditChangeListener.class */
    public interface OnEditChangeListener {
        void a();
    }

    public CircleTextVoteEditAdapter() {
        super(R.layout.item_circle_text_vote_edit);
        this.mData.add(new CircleTextVote());
        this.mData.add(new CircleTextVote());
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        CommonAlertDialog.a(this.mContext, this.mContext.getString(R.string.community_notice), this.mContext.getString(R.string.circle_text_vote_delete_tip), this.mContext.getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.widget.vote.text.adapter.CircleTextVoteEditAdapter.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                CircleTextVoteEditAdapter.this.mData.remove(i);
                CircleTextVoteEditAdapter.this.notifyDataSetChanged();
                CircleTextVoteEditAdapter.this.f6882a.a();
            }
        }, this.mContext.getString(R.string.biao_v4_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void a(OnEditChangeListener onEditChangeListener) {
        this.f6882a = onEditChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final CircleTextVote circleTextVote) {
        if (baseViewHolder == null || circleTextVote == null) {
            return;
        }
        final int adapterPosition = baseViewHolder.getAdapterPosition() - getHeaderLayoutCount();
        final EditText editText = (EditText) baseViewHolder.getView(R.id.edt_option);
        editText.removeTextChangedListener((TextWatcher) editText.getTag());
        editText.setText(circleTextVote.option);
        TextWatcher textWatcher = new TextWatcher() { // from class: com.blued.community.widget.vote.text.adapter.CircleTextVoteEditAdapter.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                circleTextVote.option = editText.getText().toString();
                if (CircleTextVoteEditAdapter.this.f6882a != null) {
                    CircleTextVoteEditAdapter.this.f6882a.a();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        editText.setTag(textWatcher);
        editText.addTextChangedListener(textWatcher);
        editText.setHint(this.mContext.getString(R.string.circle_text_vote_option) + (baseViewHolder.getAdapterPosition() + 1));
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.blued.community.widget.vote.text.adapter.CircleTextVoteEditAdapter.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_close);
        if (adapterPosition + 1 > 2) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.widget.vote.text.adapter.CircleTextVoteEditAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    CircleTextVoteEditAdapter.this.a(adapterPosition);
                }
            });
            return;
        }
        imageView.setVisibility(8);
        imageView.setOnClickListener(null);
    }
}
