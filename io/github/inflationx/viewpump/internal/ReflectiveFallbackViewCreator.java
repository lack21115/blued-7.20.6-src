package io.github.inflationx.viewpump.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import io.github.inflationx.viewpump.FallbackViewCreator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: io.github.inflationx.viewpump.internal.-ReflectiveFallbackViewCreator  reason: invalid class name */
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ReflectiveFallbackViewCreator.class */
public final class ReflectiveFallbackViewCreator implements FallbackViewCreator {
    public static final Companion Companion = new Companion(null);
    private static final Class<? extends Object>[] CONSTRUCTOR_SIGNATURE_1 = {Context.class};
    private static final Class<? extends Object>[] CONSTRUCTOR_SIGNATURE_2 = {Context.class, AttributeSet.class};

    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ReflectiveFallbackViewCreator$Companion */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ReflectiveFallbackViewCreator$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v44, types: [java.lang.Object[]] */
    @Override // io.github.inflationx.viewpump.FallbackViewCreator
    public View onCreateView(View view, String name, Context context, AttributeSet attributeSet) {
        Constructor constructor;
        Context[] contextArr;
        Intrinsics.d(name, "name");
        Intrinsics.d(context, "context");
        try {
            Class asSubclass = Class.forName(name).asSubclass(View.class);
            try {
                Class<? extends Object>[] clsArr = CONSTRUCTOR_SIGNATURE_2;
                constructor = asSubclass.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                Intrinsics.b(constructor, "clazz.getConstructor(*CONSTRUCTOR_SIGNATURE_2)");
                contextArr = new Object[2];
                contextArr[0] = context;
                contextArr[1] = attributeSet;
            } catch (NoSuchMethodException e) {
                Class<? extends Object>[] clsArr2 = CONSTRUCTOR_SIGNATURE_1;
                constructor = asSubclass.getConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                Intrinsics.b(constructor, "clazz.getConstructor(*CONSTRUCTOR_SIGNATURE_1)");
                contextArr = new Context[1];
                contextArr[0] = context;
            }
            constructor.setAccessible(true);
            return (View) constructor.newInstance(Arrays.copyOf(contextArr, contextArr.length));
        } catch (Exception e2) {
            if (e2 instanceof ClassNotFoundException) {
                e2.printStackTrace();
                return null;
            } else if (e2 instanceof NoSuchMethodException) {
                e2.printStackTrace();
                return null;
            } else if (e2 instanceof IllegalAccessException) {
                e2.printStackTrace();
                return null;
            } else if (e2 instanceof InstantiationException) {
                e2.printStackTrace();
                return null;
            } else if (e2 instanceof InvocationTargetException) {
                e2.printStackTrace();
                return null;
            } else {
                throw e2;
            }
        }
    }
}
