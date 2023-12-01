package io.noties.markwon;

import android.content.Context;
import android.widget.TextView;
import io.noties.markwon.Markwon;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactoryImpl;
import io.noties.markwon.MarkwonVisitorImpl;
import io.noties.markwon.core.MarkwonTheme;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.commonmark.parser.Parser;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/MarkwonBuilderImpl.class */
class MarkwonBuilderImpl implements Markwon.Builder {
    private final Context context;
    private Markwon.TextSetter textSetter;
    private final List<MarkwonPlugin> plugins = new ArrayList(3);
    private TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
    private boolean fallbackToRawInputWhenEmpty = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkwonBuilderImpl(Context context) {
        this.context = context;
    }

    private static List<MarkwonPlugin> preparePlugins(List<MarkwonPlugin> list) {
        return new RegistryImpl(list).process();
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon.Builder bufferType(TextView.BufferType bufferType) {
        this.bufferType = bufferType;
        return this;
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon build() {
        if (this.plugins.isEmpty()) {
            throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
        }
        List<MarkwonPlugin> preparePlugins = preparePlugins(this.plugins);
        Parser.Builder builder = new Parser.Builder();
        MarkwonTheme.Builder builderWithDefaults = MarkwonTheme.builderWithDefaults(this.context);
        MarkwonConfiguration.Builder builder2 = new MarkwonConfiguration.Builder();
        MarkwonVisitorImpl.BuilderImpl builderImpl = new MarkwonVisitorImpl.BuilderImpl();
        MarkwonSpansFactoryImpl.BuilderImpl builderImpl2 = new MarkwonSpansFactoryImpl.BuilderImpl();
        for (MarkwonPlugin markwonPlugin : preparePlugins) {
            markwonPlugin.configureParser(builder);
            markwonPlugin.configureTheme(builderWithDefaults);
            markwonPlugin.configureConfiguration(builder2);
            markwonPlugin.configureVisitor(builderImpl);
            markwonPlugin.configureSpansFactory(builderImpl2);
        }
        MarkwonConfiguration build = builder2.build(builderWithDefaults.build(), builderImpl2.build());
        return new MarkwonImpl(this.bufferType, this.textSetter, builder.a(), MarkwonVisitorFactory.create(builderImpl, build), build, Collections.unmodifiableList(preparePlugins), this.fallbackToRawInputWhenEmpty);
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon.Builder fallbackToRawInputWhenEmpty(boolean z) {
        this.fallbackToRawInputWhenEmpty = z;
        return this;
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon.Builder textSetter(Markwon.TextSetter textSetter) {
        this.textSetter = textSetter;
        return this;
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon.Builder usePlugin(MarkwonPlugin markwonPlugin) {
        this.plugins.add(markwonPlugin);
        return this;
    }

    @Override // io.noties.markwon.Markwon.Builder
    public Markwon.Builder usePlugins(Iterable<? extends MarkwonPlugin> iterable) {
        for (MarkwonPlugin markwonPlugin : iterable) {
            if (markwonPlugin == null) {
                throw null;
            }
            this.plugins.add(markwonPlugin);
        }
        return this;
    }
}
