package skin.support.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;
import skin.support.appcompat.R;
import skin.support.content.res.SkinCompatVectorResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatSeekBarHelper.class */
public class SkinCompatSeekBarHelper extends SkinCompatProgressBarHelper {
    private final SeekBar a;
    private int b;

    public SkinCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.b = 0;
        this.a = seekBar;
    }

    @Override // skin.support.widget.SkinCompatProgressBarHelper
    public void a() {
        super.a();
        int b = b(this.b);
        this.b = b;
        if (b != 0) {
            SeekBar seekBar = this.a;
            seekBar.setThumb(SkinCompatVectorResources.a(seekBar.getContext(), this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // skin.support.widget.SkinCompatProgressBarHelper
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        this.b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatSeekBar_android_thumb, 0);
        obtainStyledAttributes.recycle();
        a();
    }
}
