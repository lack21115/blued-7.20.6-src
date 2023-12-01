package com.blued.android.framework.ui.markdown.image;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.UiUtils;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.AsyncDrawableScheduler;
import io.noties.markwon.image.DrawableUtils;
import io.noties.markwon.image.ImageProps;
import io.noties.markwon.image.ImageSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin.class */
public class MarkdownGlideImagesPlugin extends AbstractMarkwonPlugin {
    private static final Pattern b = Pattern.compile("^[\\s\\S]*\\D+(\\d+)x(\\d+)\\s*$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f9909c = Pattern.compile("^\\s*(\\d+)x(\\d+)\\s*$");
    private IRequestHost g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private String m;
    private OnClickImageListener n;
    private int o = 0;

    /* renamed from: a  reason: collision with root package name */
    List<DrawableTargetModel> f9910a = new ArrayList();
    private GlideAsyncDrawableLoader f = new GlideAsyncDrawableLoader();
    private HashMap<ClickableSpan, Integer> d = new HashMap<>();
    private ArrayList<String> e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel.class */
    public class DrawableTargetModel {

        /* renamed from: a  reason: collision with root package name */
        public AsyncDrawable f9914a;
        public GlideAsyncDrawableLoader.AsyncDrawableTarget b;

        DrawableTargetModel(AsyncDrawable asyncDrawable) {
            this.f9914a = asyncDrawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader.class */
    public class GlideAsyncDrawableLoader extends AsyncDrawableLoader {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader$AsyncDrawableTarget.class */
        public class AsyncDrawableTarget extends CustomTarget<Drawable> {
            private final AsyncDrawable b;

            AsyncDrawableTarget(AsyncDrawable asyncDrawable) {
                this.b = asyncDrawable;
            }

            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                synchronized (MarkdownGlideImagesPlugin.this.f9910a) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= MarkdownGlideImagesPlugin.this.f9910a.size()) {
                            break;
                        } else if (MarkdownGlideImagesPlugin.this.f9910a.get(i2).f9914a != this.b) {
                            i = i2 + 1;
                        } else if (this.b.isAttached()) {
                            DrawableUtils.applyIntrinsicBoundsIfEmpty(drawable);
                            if (AppInfo.m()) {
                                Log.i("Markdown", "onResourceReady: [" + this.b.getDestination());
                            }
                            this.b.setResult(drawable);
                        }
                    }
                }
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
                if (this.b.isAttached()) {
                    if (AppInfo.m()) {
                        Log.i("Markdown", "onLoadCleared");
                    }
                    this.b.clearResult();
                }
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(Drawable drawable) {
                if (AppInfo.m()) {
                    Log.i("Markdown", "onLoadFailed: " + this.b.getDestination());
                }
                synchronized (MarkdownGlideImagesPlugin.this.f9910a) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= MarkdownGlideImagesPlugin.this.f9910a.size()) {
                            break;
                        } else if (MarkdownGlideImagesPlugin.this.f9910a.get(i2).f9914a != this.b) {
                            i = i2 + 1;
                        } else if (drawable != null) {
                            this.b.isAttached();
                        }
                    }
                }
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadStarted(Drawable drawable) {
                if (AppInfo.m()) {
                    Log.i("Markdown", "onLoadStarted: " + this.b.getDestination());
                }
                if (drawable != null) {
                    this.b.isAttached();
                }
            }
        }

        private GlideAsyncDrawableLoader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (MarkdownGlideImagesPlugin.this.g == null || MarkdownGlideImagesPlugin.this.g.isActive()) {
                synchronized (MarkdownGlideImagesPlugin.this.f9910a) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= MarkdownGlideImagesPlugin.this.f9910a.size()) {
                            break;
                        } else if (MarkdownGlideImagesPlugin.this.f9910a.get(i2).f9914a == null || MarkdownGlideImagesPlugin.this.f9910a.get(i2).b != null) {
                            i = i2 + 1;
                        } else {
                            MarkdownGlideImagesPlugin.this.f9910a.get(i2).b = new AsyncDrawableTarget(MarkdownGlideImagesPlugin.this.f9910a.get(i2).f9914a);
                            final String str = MarkdownGlideImagesPlugin.this.f9910a.get(i2).f9914a.getDestination() + MarkdownGlideImagesPlugin.this.m;
                            if (MarkdownGlideImagesPlugin.this.g != null && !MarkdownGlideImagesPlugin.this.g.isActive()) {
                                return;
                            }
                            if (AppInfo.m()) {
                                Log.i("Markdown", "ImageLoader.load " + str);
                            }
                            ImageLoader.a(MarkdownGlideImagesPlugin.this.g, str).a(MarkdownGlideImagesPlugin.this.i).a(new ImageLoadResult(MarkdownGlideImagesPlugin.this.g) { // from class: com.blued.android.framework.ui.markdown.image.MarkdownGlideImagesPlugin.GlideAsyncDrawableLoader.1
                                @Override // com.blued.android.core.image.ImageLoadResult
                                public void b() {
                                    super.b();
                                    if (AppInfo.m()) {
                                        Log.i("Markdown", "ImageLoader.loadFinish " + str);
                                    }
                                    GlideAsyncDrawableLoader.this.a();
                                }
                            }).a(MarkdownGlideImagesPlugin.this.f9910a.get(i2).b);
                        }
                    }
                }
            }
        }

        @Override // io.noties.markwon.image.AsyncDrawableLoader
        public void cancel(AsyncDrawable asyncDrawable) {
            if (AppInfo.m()) {
                Log.i("Markdown", "cancel drawable=" + asyncDrawable.getDestination());
            }
            synchronized (MarkdownGlideImagesPlugin.this.f9910a) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= MarkdownGlideImagesPlugin.this.f9910a.size()) {
                        break;
                    } else if (MarkdownGlideImagesPlugin.this.f9910a.get(i2).f9914a == asyncDrawable) {
                        AsyncDrawableTarget asyncDrawableTarget = MarkdownGlideImagesPlugin.this.f9910a.get(i2).b;
                        if (asyncDrawableTarget != null) {
                            if (AppInfo.m()) {
                                Log.i("Markdown", "cancel target=" + asyncDrawable);
                            }
                            ImageLoader.a(MarkdownGlideImagesPlugin.this.g, asyncDrawableTarget);
                        }
                    } else {
                        i = i2 + 1;
                    }
                }
            }
        }

        @Override // io.noties.markwon.image.AsyncDrawableLoader
        public void load(AsyncDrawable asyncDrawable) {
            if (asyncDrawable != null) {
                synchronized (MarkdownGlideImagesPlugin.this.f9910a) {
                    MarkdownGlideImagesPlugin.this.f9910a.add(0, new DrawableTargetModel(asyncDrawable));
                    int size = MarkdownGlideImagesPlugin.this.f9910a.size();
                    if (AppInfo.m()) {
                        Log.i("Markdown", "GlideAsyncDrawableLoader.load " + asyncDrawable.getDestination() + ",  listSize:" + size + ", imageArraySize:" + MarkdownGlideImagesPlugin.this.o);
                    }
                    if (size == MarkdownGlideImagesPlugin.this.o) {
                        a();
                    }
                }
            }
        }

        @Override // io.noties.markwon.image.AsyncDrawableLoader
        public Drawable placeholder(AsyncDrawable asyncDrawable) {
            GradientDrawable gradientDrawable;
            if (AppInfo.m()) {
                Log.v("Markdown", "placeholder() >>" + asyncDrawable.getDestination());
            }
            GradientDrawable gradientDrawable2 = null;
            if (AppInfo.d() != null) {
                if (MarkdownGlideImagesPlugin.this.k != 0) {
                    gradientDrawable = null;
                    if (AppInfo.d() != null) {
                        Resources resources = AppInfo.d().getResources();
                        gradientDrawable = null;
                        if (resources != null) {
                            gradientDrawable = resources.getDrawable(MarkdownGlideImagesPlugin.this.k);
                        }
                    }
                } else {
                    gradientDrawable = null;
                    if (MarkdownGlideImagesPlugin.this.j != 0) {
                        gradientDrawable = new GradientDrawable();
                        gradientDrawable.setCornerRadius(MarkdownGlideImagesPlugin.f(MarkdownGlideImagesPlugin.this.i));
                        gradientDrawable.setColor(MarkdownGlideImagesPlugin.this.j);
                    }
                }
                gradientDrawable2 = gradientDrawable;
                if (gradientDrawable != null) {
                    ImageSize imageSize = asyncDrawable.getImageSize();
                    gradientDrawable.setBounds(imageSize == null ? new Rect(0, 0, MarkdownGlideImagesPlugin.this.h, MarkdownGlideImagesPlugin.this.h) : new Rect(0, 0, (int) imageSize.width.value, (int) imageSize.height.value));
                    gradientDrawable2 = gradientDrawable;
                }
            }
            if (AppInfo.m()) {
                Log.v("Markdown", "<< placeholder() " + asyncDrawable.getDestination());
            }
            return gradientDrawable2;
        }
    }

    public MarkdownGlideImagesPlugin(IRequestHost iRequestHost, int i) {
        this.g = iRequestHost;
        this.h = i;
    }

    private ImageSize a(Pattern pattern, String str) {
        int i;
        Matcher matcher = pattern.matcher(str);
        if (AppInfo.m()) {
            Log.i("Markdown", "configureImageVistor -- " + pattern + ", " + matcher.matches());
        }
        if (matcher.matches()) {
            if (AppInfo.m()) {
                Log.e("Markdown", "configureImageVistor:" + matcher.group() + ", [" + matcher.group(1) + "x" + matcher.group(2) + "]");
            }
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            int i2 = 0;
            int parseInt = !TextUtils.isEmpty(group) ? Integer.parseInt(group) : 0;
            if (!TextUtils.isEmpty(group2)) {
                i2 = Integer.parseInt(group2);
            }
            if (parseInt <= 0 || i2 <= 0) {
                return null;
            }
            return new ImageSize(new ImageSize.Dimension(this.h, "px"), new ImageSize.Dimension((i2 * i) / parseInt, "px"));
        }
        return null;
    }

    private ImageSize a(Image image) {
        ImageSize imageSize = null;
        try {
            Node j = image.j();
            ImageSize imageSize2 = null;
            if (j != null) {
                imageSize2 = null;
                if (j instanceof Text) {
                    Text text = (Text) image.j();
                    imageSize2 = null;
                    if (text != null) {
                        String a2 = text.a();
                        imageSize2 = null;
                        if (!TextUtils.isEmpty(a2)) {
                            ImageSize a3 = a(b, a2);
                            imageSize2 = a3;
                            if (a3 == null) {
                                imageSize = a3;
                                imageSize2 = a(f9909c, a2);
                            }
                        }
                    }
                }
            }
            return imageSize2;
        } catch (Exception e) {
            return imageSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MarkwonVisitor markwonVisitor, Image image) {
        SpanFactory spanFactory = markwonVisitor.configuration().spansFactory().get(Image.class);
        if (spanFactory == null) {
            markwonVisitor.visitChildren(image);
            return;
        }
        int length = markwonVisitor.length();
        markwonVisitor.visitChildren(image);
        if (length == markwonVisitor.length()) {
            markwonVisitor.builder().append((char) 65532);
        }
        MarkwonConfiguration configuration = markwonVisitor.configuration();
        boolean z = image.b() instanceof Link;
        ImageSize a2 = a(image);
        String process = configuration.imageDestinationProcessor().process(image.a());
        RenderProps renderProps = markwonVisitor.renderProps();
        ImageProps.DESTINATION.set(renderProps, process);
        ImageProps.REPLACEMENT_TEXT_IS_LINK.set(renderProps, Boolean.valueOf(z));
        ImageProps.IMAGE_SIZE.set(renderProps, a2);
        markwonVisitor.setSpans(length, spanFactory.getSpans(configuration, renderProps));
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.blued.android.framework.ui.markdown.image.MarkdownGlideImagesPlugin.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (MarkdownGlideImagesPlugin.this.n == null || MarkdownGlideImagesPlugin.this.e == null || MarkdownGlideImagesPlugin.this.d == null) {
                    return;
                }
                MarkdownGlideImagesPlugin.this.n.a((String[]) MarkdownGlideImagesPlugin.this.e.toArray(new String[MarkdownGlideImagesPlugin.this.e.size()]), ((Integer) MarkdownGlideImagesPlugin.this.d.get(this)).intValue());
            }
        };
        this.e.add(process);
        this.o = this.e.size();
        if (AppInfo.m()) {
            Log.i("Markdown", "configureImageVistor: " + process + ", mImageArraySize: " + this.o);
        }
        this.d.put(clickableSpan, Integer.valueOf(this.e.size() - 1));
        markwonVisitor.builder().setSpan(clickableSpan, length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(int i) {
        int i2 = i;
        if (AppInfo.d() != null) {
            i2 = UiUtils.a(AppInfo.d(), i);
        }
        return i2;
    }

    public void a() {
        List<DrawableTargetModel> list = this.f9910a;
        if (list == null || list.size() == 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f9910a.size()) {
                return;
            }
            if (this.f9910a.get(i2).b != null) {
                ImageLoader.a(this.g, this.f9910a.get(i2).b);
            }
            if (this.f9910a.get(i2).f9914a != null) {
                this.f9910a.get(i2).f9914a.clearResult();
            }
            i = i2 + 1;
        }
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(OnClickImageListener onClickImageListener) {
        this.n = onClickImageListener;
    }

    public void a(String str) {
        this.m = str;
        if (str == null) {
            this.m = "";
        }
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
        AsyncDrawableScheduler.schedule(textView);
    }

    public void b(int i) {
        this.k = i;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned spanned) {
        AsyncDrawableScheduler.unschedule(textView);
    }

    public void c(int i) {
        this.i = i;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
        builder.asyncDrawableLoader(this.f);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        builder.setFactory(Image.class, new ImageSpanFactory());
        builder.appendFactory(Image.class, new SpanFactory() { // from class: com.blued.android.framework.ui.markdown.image.MarkdownGlideImagesPlugin.1
            @Override // io.noties.markwon.SpanFactory
            public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
                return new ImageLineSpacingSpan(MarkdownGlideImagesPlugin.f(MarkdownGlideImagesPlugin.this.l));
            }
        });
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.on(Image.class, new MarkwonVisitor.NodeVisitor<Image>() { // from class: com.blued.android.framework.ui.markdown.image.MarkdownGlideImagesPlugin.2
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            /* renamed from: a */
            public void visit(MarkwonVisitor markwonVisitor, Image image) {
                MarkdownGlideImagesPlugin.this.a(markwonVisitor, image);
            }
        });
    }

    public void d(int i) {
        this.l = i;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public String processMarkdown(String str) {
        this.d = new HashMap<>();
        this.e = new ArrayList<>();
        this.f9910a.clear();
        return str;
    }
}
