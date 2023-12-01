package com.blued.android.module.common.api;

import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.api.annotation.ApiHost;
import com.blued.android.module.common.api.annotation.DELETE;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.api.annotation.InterruptError;
import com.blued.android.module.common.api.annotation.NoVerification;
import com.blued.android.module.common.api.annotation.POST;
import com.blued.android.module.common.api.annotation.PUT;
import com.blued.android.module.common.api.annotation.Param;
import com.blued.android.module.common.api.annotation.ParamsMap;
import com.blued.android.module.common.api.annotation.ReplaceMap;
import com.soft.blued.http.api.ApiUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/api/BluedServiceMethod.class */
public final class BluedServiceMethod {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f10625a = new Companion(null);
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10626c;
    private final String d;
    private HashMap<String, String> e;
    private final ParamModel[] f;
    private final Type g;
    private final Type h;
    private boolean i;
    private boolean j;
    private boolean k;
    private String l;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/api/BluedServiceMethod$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f10627a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public ParamModel[] f10628c;
        private final Method d;
        private boolean e;
        private boolean f;
        private String g;
        private Type h;
        private Type i;
        private boolean j;

        public Builder(Method method) {
            Intrinsics.e(method, "method");
            this.d = method;
            this.e = true;
        }

        private final void a(int i, Type type, Annotation[] annotationArr) {
            int length = annotationArr.length;
            int i2 = 0;
            while (i2 < length) {
                Annotation annotation = annotationArr[i2];
                int i3 = i2 + 1;
                Logger.c("KT_API", Intrinsics.a("parameterAnnotation -> ", (Object) annotation));
                if (annotation instanceof Param) {
                    if (f()[i] != null) {
                        throw new RuntimeException("params must have only one annotation \n");
                    }
                    f()[i] = new ParamModel(((Param) annotation).a(), false);
                    return;
                } else if ((annotation instanceof ParamsMap) && a(type)) {
                    if (f()[i] != null) {
                        throw new RuntimeException("params must have only one annotation \n");
                    }
                    f()[i] = new ParamModel("MAP", true);
                    return;
                } else {
                    i2 = i3;
                    if (annotation instanceof ReplaceMap) {
                        i2 = i3;
                        if (!a(type)) {
                            continue;
                        } else if (f()[i] != null) {
                            throw new RuntimeException("params must have only one annotation \n");
                        } else {
                            f()[i] = new ParamModel("REPLACE", true);
                            i2 = i3;
                        }
                    }
                }
            }
        }

        private final void a(String str, String str2) {
            b(str);
            a(str2);
        }

        private final void a(Annotation annotation) {
            if (annotation instanceof GET) {
                a("GET", ((GET) annotation).a());
            } else if (annotation instanceof DELETE) {
                a("DELETE", ((DELETE) annotation).a());
            } else if (annotation instanceof PUT) {
                a("PUT", ((PUT) annotation).a());
            } else if (annotation instanceof POST) {
                a("POST", ((POST) annotation).a());
            } else if (annotation instanceof ApiHost) {
                this.g = BluedApiProxy.b().a().get(((ApiHost) annotation).a());
            } else if (annotation instanceof InterruptError) {
                this.f = true;
            } else if (annotation instanceof NoVerification) {
                this.e = false;
            }
        }

        private final void a(Method method) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            ApiUtils apiUtils = ApiUtils.f29672a;
            Type type = genericParameterTypes[genericParameterTypes.length - 1];
            if (type == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            }
            Type b = apiUtils.b(0, (ParameterizedType) type);
            Logger.c("KT_API", Intrinsics.a("parseReturnType : ", (Object) b));
            if (ApiUtils.f29672a.b(b) == BluedEntityA.class && (b instanceof ParameterizedType)) {
                Type a2 = ApiUtils.f29672a.a(0, (ParameterizedType) b);
                this.h = a2;
                Logger.c("KT_API", Intrinsics.a("actual parseReturnType : ", (Object) a2));
            } else if (ApiUtils.f29672a.b(b) == BluedEntity.class && (b instanceof ParameterizedType)) {
                ParameterizedType parameterizedType = (ParameterizedType) b;
                this.h = ApiUtils.f29672a.a(0, parameterizedType);
                this.i = ApiUtils.f29672a.a(1, parameterizedType);
                Logger.c("KT_API", "actual parseReturnType : " + this.h + " + extraType : " + this.i);
                this.j = true;
            }
        }

        private final boolean a(Class<?> cls) {
            Logger.c("KT_API", Intrinsics.a("checkMapType -> ", (Object) (cls == null ? null : cls.getSimpleName())));
            if (Intrinsics.a(cls, Map.class)) {
                return true;
            }
            Type genericSuperclass = cls == null ? null : cls.getGenericSuperclass();
            if (genericSuperclass == null) {
                return false;
            }
            return a(genericSuperclass);
        }

        private final boolean a(Type type) {
            return a(ApiUtils.f29672a.b(type));
        }

        public final void a(String str) {
            Intrinsics.e(str, "<set-?>");
            this.f10627a = str;
        }

        public final void a(ParamModel[] paramModelArr) {
            Intrinsics.e(paramModelArr, "<set-?>");
            this.f10628c = paramModelArr;
        }

        public final boolean a() {
            return this.e;
        }

        public final void b(String str) {
            Intrinsics.e(str, "<set-?>");
            this.b = str;
        }

        public final boolean b() {
            return this.f;
        }

        public final String c() {
            String str = this.f10627a;
            if (str != null) {
                return str;
            }
            Intrinsics.c("url");
            return null;
        }

        public final String d() {
            String str = this.b;
            if (str != null) {
                return str;
            }
            Intrinsics.c("reqMethod");
            return null;
        }

        public final String e() {
            return this.g;
        }

        public final ParamModel[] f() {
            ParamModel[] paramModelArr = this.f10628c;
            if (paramModelArr != null) {
                return paramModelArr;
            }
            Intrinsics.c("paramsModelArray");
            return null;
        }

        public final Type g() {
            return this.h;
        }

        public final Type h() {
            return this.i;
        }

        public final boolean i() {
            return this.j;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0110  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.blued.android.module.common.api.BluedServiceMethod j() {
            /*
                Method dump skipped, instructions count: 283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.api.BluedServiceMethod.Builder.j():com.blued.android.module.common.api.BluedServiceMethod");
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/api/BluedServiceMethod$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/api/BluedServiceMethod$ParamModel.class */
    public static final class ParamModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f10629a;
        private final boolean b;

        public ParamModel(String name, boolean z) {
            Intrinsics.e(name, "name");
            this.f10629a = name;
            this.b = z;
        }

        public final String a() {
            return this.f10629a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public BluedServiceMethod(Builder builder) {
        Intrinsics.e(builder, "builder");
        this.b = builder.c();
        this.f10626c = builder.d();
        String e = builder.e();
        this.d = e == null ? BluedApiProxy.b().a().get("HOST_HTTP") : e;
        this.e = new HashMap<>();
        this.f = builder.f();
        this.g = builder.g();
        this.h = builder.h();
        this.i = builder.i();
        this.j = builder.b();
        this.k = builder.a();
        this.l = builder.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02e7 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.api.BluedServiceMethod.a(java.lang.Object[]):void");
    }

    public final Object a(Object[] objArr, Continuation<? super BluedEntity<?, ?>> continuation) {
        a(objArr);
        return ApiUtils.f29672a.a(this.f10626c, Intrinsics.a(b(), (Object) a()), c(), f(), e(), this.g, this.h, continuation);
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.b = str;
    }

    public final String b() {
        return this.d;
    }

    public final HashMap<String, String> c() {
        return this.e;
    }

    public final Object call(Object[] objArr, Continuation<? super BluedEntityA<?>> continuation) {
        a(objArr);
        return ApiUtils.f29672a.a(this.f10626c, Intrinsics.a(b(), (Object) a()), c(), f(), e(), ApiUtils.f29672a.b(this.g), continuation);
    }

    public final boolean d() {
        return this.i;
    }

    public final boolean e() {
        return this.j;
    }

    public final boolean f() {
        return this.k;
    }
}
