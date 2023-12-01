package com.blued.community.view;

import android.graphics.Bitmap;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/CommonViewHolder.class */
public class CommonViewHolder extends BaseViewHolder {
    private IRequestHost requestHost;

    public CommonViewHolder(View view) {
        super(view);
    }

    public CommonViewHolder setApngUrl(int i, String str) {
        ImageView imageView = (ImageView) getView(i);
        if (imageView != null) {
            ImageLoader.a(this.requestHost, str).e(imageView.hashCode()).g(-1).a(imageView);
        }
        return this;
    }

    @Override // com.chad.library.adapter.base.BaseViewHolder
    public CommonViewHolder setBackgroundColor(int i, int i2) {
        View view = getView(i);
        if (view != null) {
            view.setBackgroundColor(i2);
        }
        return this;
    }

    @Override // com.chad.library.adapter.base.BaseViewHolder
    public CommonViewHolder setBackgroundRes(int i, int i2) {
        View view = getView(i);
        if (view != null) {
            view.setBackgroundResource(i2);
        }
        return this;
    }

    public CommonViewHolder setCardBackgroundColor(int i, int i2) {
        CardView cardView = (CardView) getView(i);
        if (cardView != null) {
            cardView.setCardBackgroundColor(i2);
        }
        return this;
    }

    public CommonViewHolder setCheckBoxText(int i, String str) {
        CheckBox checkBox = (CheckBox) getView(i);
        if (checkBox != null) {
            checkBox.setText(str);
        }
        return this;
    }

    public CommonViewHolder setCheckBoxTextColor(int i, int i2) {
        CheckBox checkBox = (CheckBox) getView(i);
        if (checkBox != null) {
            checkBox.setTextColor(i2);
        }
        return this;
    }

    public CommonViewHolder setColorText(int i, int i2, String str) {
        TextView textView = (TextView) getView(i);
        if (textView != null) {
            textView.setText(str);
            textView.setTextColor(i2);
        }
        return this;
    }

    public CommonViewHolder setConvertViewOnClickListener(View.OnClickListener onClickListener) {
        this.itemView.setOnClickListener(onClickListener);
        return this;
    }

    public CommonViewHolder setGifUrl(int i, String str) {
        ImageView imageView = (ImageView) getView(i);
        if (imageView != null) {
            ImageLoader.a(this.requestHost, str).f(imageView.hashCode()).g(-1).a(imageView);
        }
        return this;
    }

    @Override // com.chad.library.adapter.base.BaseViewHolder
    public CommonViewHolder setImageBitmap(int i, Bitmap bitmap) {
        ImageView imageView = (ImageView) getView(i);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        return this;
    }

    public CommonViewHolder setImageCircleUrl(int i, String str, int i2) {
        ImageView imageView = (ImageView) getView(i);
        if (imageView != null) {
            ImageLoader.a(this.requestHost, str).b(i2).c().a(imageView);
        }
        return this;
    }

    @Override // com.chad.library.adapter.base.BaseViewHolder
    public CommonViewHolder setImageResource(int i, int i2) {
        ImageView imageView = (ImageView) getView(i);
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
        return this;
    }

    public CommonViewHolder setImageUrl(int i, String str) {
        return setImageUrl(i, str, 0);
    }

    public CommonViewHolder setImageUrl(int i, String str, float f) {
        return setImageUrl(i, str, f, R.drawable.header_bg_blue);
    }

    public CommonViewHolder setImageUrl(int i, String str, float f, int i2) {
        ImageView imageView = (ImageView) getView(i);
        if (imageView != null) {
            if (f <= 0.0f) {
                ImageLoader.a(this.requestHost, str).b(i2).a(imageView);
                return this;
            }
            ImageLoader.a(this.requestHost, str).b(i2).a(f).a(imageView);
        }
        return this;
    }

    public CommonViewHolder setImageUrl(int i, String str, int i2) {
        return setImageUrl(i, str, 0.0f, i2);
    }

    @Override // com.chad.library.adapter.base.BaseViewHolder
    public CommonViewHolder setOnClickListener(int i, View.OnClickListener onClickListener) {
        View view = getView(i);
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        return this;
    }

    @Override // com.chad.library.adapter.base.BaseViewHolder
    public CommonViewHolder setOnLongClickListener(int i, View.OnLongClickListener onLongClickListener) {
        View view = getView(i);
        if (view != null) {
            view.setOnLongClickListener(onLongClickListener);
        }
        return this;
    }

    public CommonViewHolder setSeekBarProgress(int i, int i2) {
        SeekBar seekBar = (SeekBar) getView(i);
        if (seekBar != null) {
            seekBar.setProgress(i2);
        }
        return this;
    }

    public CommonViewHolder setSsbText(int i, Spannable spannable) {
        TextView textView = (TextView) getView(i);
        if (textView != null) {
            textView.setText(spannable, TextView.BufferType.SPANNABLE);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return this;
    }

    public CommonViewHolder setSsbText(int i, SpannableStringBuilder spannableStringBuilder) {
        TextView textView = (TextView) getView(i);
        if (textView != null) {
            textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return this;
    }

    public CommonViewHolder setSsbText(int i, Spanned spanned) {
        TextView textView = (TextView) getView(i);
        if (textView != null) {
            textView.setText(spanned, TextView.BufferType.SPANNABLE);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return this;
    }

    @Override // com.chad.library.adapter.base.BaseViewHolder
    public CommonViewHolder setText(int i, int i2) {
        TextView textView = (TextView) getView(i);
        if (textView != null) {
            textView.setText(AppInfo.d().getString(i2));
        }
        return this;
    }

    public CommonViewHolder setText(int i, String str) {
        TextView textView = (TextView) getView(i);
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    @Override // com.chad.library.adapter.base.BaseViewHolder
    public CommonViewHolder setTextColor(int i, int i2) {
        TextView textView = (TextView) getView(i);
        if (textView != null) {
            textView.setTextColor(i2);
        }
        return this;
    }

    public CommonViewHolder setTextFromHtml(int i, String str) {
        TextView textView = (TextView) getView(i);
        if (textView != null) {
            textView.setText(Html.fromHtml(str));
        }
        return this;
    }

    public CommonViewHolder setVisibility(int i, int i2) {
        View view = getView(i);
        if (view != null) {
            view.setVisibility(i2);
        }
        return this;
    }
}
