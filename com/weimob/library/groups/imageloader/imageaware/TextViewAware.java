package com.weimob.library.groups.imageloader.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.ImageInfo;
import com.weimob.library.groups.html.Html;
import com.weimob.library.groups.imageloader.core.DisplayImageOptions;
import com.weimob.library.groups.imageloader.core.ImageLoaderConfiguration;
import com.weimob.library.groups.imageloader.core.ImageLoaderTransform;
import com.weimob.library.groups.imageloader.drawee.RichTextView;
import com.weimob.library.groups.imageloader.listener.ImageLoadingListener;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/TextViewAware.class */
public class TextViewAware extends ViewAware {

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/TextViewAware$ControllerListenerImpl.class */
    static class ControllerListenerImpl implements ControllerListener<ImageInfo> {
        private DraweeHolder<GenericDraweeHierarchy> draweeHolder;
        private TextView textView;

        public ControllerListenerImpl(TextView textView, DraweeHolder<GenericDraweeHierarchy> draweeHolder) {
            this.textView = textView;
            this.draweeHolder = draweeHolder;
        }

        public void onFailure(String str, Throwable th) {
            th.printStackTrace();
        }

        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            this.draweeHolder.getTopLevelDrawable().setBounds(0, 0, imageInfo.getWidth(), imageInfo.getHeight());
            TextView textView = this.textView;
            textView.setText(textView.getText());
        }

        public void onIntermediateImageFailed(String str, Throwable th) {
        }

        public void onIntermediateImageSet(String str, ImageInfo imageInfo) {
        }

        public void onRelease(String str) {
        }

        public void onSubmit(String str, Object obj) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/TextViewAware$HtmlImageGetter.class */
    public static class HtmlImageGetter implements Html.ImageGetter {
        private ImageLoaderConfiguration defaultImageLoaderConfiguration;
        private DisplayImageOptions displayImageOptions;
        private List<DraweeHolder> draweeHolderList;
        private TextView textView;

        public HtmlImageGetter(TextView textView, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions, List<DraweeHolder> list) {
            this.textView = textView;
            this.defaultImageLoaderConfiguration = imageLoaderConfiguration;
            this.displayImageOptions = displayImageOptions;
            this.draweeHolderList = list;
        }

        public Drawable getDrawable(String str, int i, int i2) {
            if (i > 0 && i2 > 0) {
                this.displayImageOptions = new DisplayImageOptions.Builder(this.defaultImageLoaderConfiguration.getContext()).cloneFrom(this.displayImageOptions).targetSize(i, i2).build();
            }
            GenericDraweeHierarchyBuilder draweeHierarchy = ImageLoaderTransform.getDraweeHierarchy(this.displayImageOptions);
            if (draweeHierarchy == null) {
                return null;
            }
            List<DraweeHolder> list = this.draweeHolderList;
            DraweeHolder<GenericDraweeHierarchy> draweeHolder = null;
            if (list != null) {
                draweeHolder = null;
                if (list.size() > 0) {
                    draweeHolder = this.draweeHolderList.remove(0);
                }
            }
            DraweeHolder<GenericDraweeHierarchy> draweeHolder2 = draweeHolder;
            if (draweeHolder == null) {
                draweeHolder2 = new DraweeHolder<>(draweeHierarchy.build());
            }
            TextView textView = this.textView;
            if (textView instanceof RichTextView) {
                ((RichTextView) textView).addDraweeHolder(draweeHolder2);
            }
            AbstractDraweeControllerBuilder draweeController = ImageLoaderTransform.getDraweeController(str, null, null, this.defaultImageLoaderConfiguration, this.displayImageOptions, null);
            draweeController.setOldController(draweeHolder2.getController());
            AbstractDraweeController build = draweeController.build();
            build.addControllerListener(new ControllerListenerImpl(this.textView, draweeHolder2));
            if (this.displayImageOptions.getTargetWidth() > 0 && this.displayImageOptions.getTargetHeight() > 0) {
                draweeHolder2.getTopLevelDrawable().setBounds(0, 0, this.displayImageOptions.getTargetWidth(), this.displayImageOptions.getTargetHeight());
            }
            draweeHolder2.setController(build);
            return draweeHolder2.getTopLevelDrawable();
        }
    }

    public TextViewAware(View view) {
        super(view);
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ViewAware, com.weimob.library.groups.imageloader.imageaware.ImageAware
    public TextView getWrappedView() {
        return (TextView) super.getWrappedView();
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public void loadImage(String str, String str2, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public void loadRichText(CharSequence charSequence, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions) {
        TextView wrappedView = getWrappedView();
        if (wrappedView == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            wrappedView.setText(charSequence);
            return;
        }
        DisplayImageOptions displayImageOptions2 = displayImageOptions;
        if (displayImageOptions == null) {
            displayImageOptions2 = imageLoaderConfiguration.getDefaultDisplayImageOptions();
        }
        DisplayImageOptions displayImageOptions3 = displayImageOptions2;
        if (displayImageOptions2.getFadeDuration() != 0) {
            displayImageOptions3 = new DisplayImageOptions.Builder(imageLoaderConfiguration.getContext()).cloneFrom(displayImageOptions2).fadeDuration(0).build();
        }
        List<DraweeHolder> list = null;
        if (wrappedView instanceof RichTextView) {
            RichTextView richTextView = (RichTextView) wrappedView;
            list = richTextView.getOldDraweeHolderList();
            richTextView.release();
        }
        wrappedView.setText(Html.fromHtml((String) charSequence, new HtmlImageGetter(wrappedView, imageLoaderConfiguration, displayImageOptions3, list), (Html.TagHandler) null, (Html.AClick) null, false, true));
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ViewAware
    protected void setImageBitmapInto(Bitmap bitmap, View view) {
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ViewAware
    protected void setImageDrawableInto(Drawable drawable, View view) {
    }
}
