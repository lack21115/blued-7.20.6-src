package io.github.inflationx.calligraphy3;

import io.github.inflationx.viewpump.InflateResult;
import io.github.inflationx.viewpump.Interceptor;

/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/calligraphy3/CalligraphyInterceptor.class */
public class CalligraphyInterceptor implements Interceptor {
    private final Calligraphy calligraphy;

    public CalligraphyInterceptor(CalligraphyConfig calligraphyConfig) {
        this.calligraphy = new Calligraphy(calligraphyConfig);
    }

    @Override // io.github.inflationx.viewpump.Interceptor
    public InflateResult intercept(Interceptor.Chain chain) {
        InflateResult proceed = chain.proceed(chain.request());
        return proceed.toBuilder().view(this.calligraphy.onViewCreated(proceed.view(), proceed.context(), proceed.attrs())).build();
    }
}
