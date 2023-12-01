package com.soft.blued.http.api;

import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.google.gson.internal.C$Gson$Types;
import com.igexin.push.core.b;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/http/api/ApiUtils.class */
public final class ApiUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ApiUtils f29672a = new ApiUtils();

    private ApiUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, String str2, HashMap<String, String> hashMap, boolean z, BluedUIHttpResponse<BluedEntityA<?>> bluedUIHttpResponse) {
        switch (str.hashCode()) {
            case 70454:
                if (str.equals("GET")) {
                    c(str2, hashMap, z, bluedUIHttpResponse);
                    return;
                }
                return;
            case 79599:
                if (str.equals("PUT")) {
                    a(Intrinsics.a(str2, (Object) "?http_method_override=PUT"), hashMap, z, bluedUIHttpResponse);
                    return;
                }
                return;
            case 2461856:
                if (str.equals("POST")) {
                    a(str2, hashMap, z, bluedUIHttpResponse);
                    return;
                }
                return;
            case 2012838315:
                if (str.equals("DELETE")) {
                    a(Intrinsics.a(str2, (Object) "?http_method_override=DELETE"), hashMap, z, bluedUIHttpResponse);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void a(String str, HashMap<String, String> hashMap, boolean z, BluedUIHttpResponse<BluedEntityA<?>> bluedUIHttpResponse) {
        HttpRequestWrapper b = HttpManager.b(str, bluedUIHttpResponse);
        HashMap<String, String> hashMap2 = hashMap;
        if (!(hashMap2 == null || hashMap2.isEmpty())) {
            if (hashMap.containsKey("JSON")) {
                b.a(hashMap.get("JSON"));
            } else {
                b.a(BluedHttpTools.a(hashMap2));
            }
        }
        b.b(BluedHttpTools.a(z));
        b.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str, String str2, HashMap<String, String> hashMap, boolean z, BluedUIHttpResponse<BluedEntity<?, ?>> bluedUIHttpResponse) {
        switch (str.hashCode()) {
            case 70454:
                if (str.equals("GET")) {
                    d(str2, hashMap, z, bluedUIHttpResponse);
                    return;
                }
                return;
            case 79599:
                if (str.equals("PUT")) {
                    b(Intrinsics.a(str2, (Object) "?http_method_override=PUT"), hashMap, z, bluedUIHttpResponse);
                    return;
                }
                return;
            case 2461856:
                if (str.equals("POST")) {
                    b(str2, hashMap, z, bluedUIHttpResponse);
                    return;
                }
                return;
            case 2012838315:
                if (str.equals("DELETE")) {
                    b(Intrinsics.a(str2, (Object) "?http_method_override=DELETE"), hashMap, z, bluedUIHttpResponse);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void b(String str, HashMap<String, String> hashMap, boolean z, BluedUIHttpResponse<BluedEntity<?, ?>> bluedUIHttpResponse) {
        HttpRequestWrapper b = HttpManager.b(str, bluedUIHttpResponse);
        if (hashMap.containsKey("JSON")) {
            b.a(hashMap.get("JSON"));
        } else {
            b.a(BluedHttpTools.a(hashMap));
        }
        b.b(BluedHttpTools.a(z));
        b.h();
    }

    private final void c(String str, HashMap<String, String> hashMap, boolean z, BluedUIHttpResponse<BluedEntityA<?>> bluedUIHttpResponse) {
        HttpRequestWrapper a2 = HttpManager.a(str, bluedUIHttpResponse);
        HashMap<String, String> hashMap2 = hashMap;
        if (!(hashMap2 == null || hashMap2.isEmpty())) {
            a2.a(hashMap2);
        }
        a2.b(BluedHttpTools.a(z));
        a2.h();
    }

    private final void d(String str, HashMap<String, String> hashMap, boolean z, BluedUIHttpResponse<BluedEntity<?, ?>> bluedUIHttpResponse) {
        HttpRequestWrapper a2 = HttpManager.a(str, bluedUIHttpResponse);
        HashMap<String, String> hashMap2 = hashMap;
        if (!(hashMap2 == null || hashMap2.isEmpty())) {
            a2.a(hashMap2);
        }
        a2.b(BluedHttpTools.a(z));
        a2.h();
    }

    public final Object a(String str, final String str2, HashMap<String, String> hashMap, final boolean z, final boolean z2, Class<?> cls, Continuation<? super BluedEntityA<?>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (AppInfo.m()) {
            Logger.c("KT_API", "url :" + str2 + "  -  params -> " + ((Object) AppInfo.f().toJson(hashMap)) + "   internalError: " + z2 + " verifyToken: " + z);
        }
        ApiUtils apiUtils = f29672a;
        BluedUIHttpResponse<BluedEntityA<?>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<?>>() { // from class: com.soft.blued.http.api.ApiUtils$send$2$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<?> bluedEntityA) {
                if (bluedEntityA == null) {
                    return;
                }
                CancellableContinuation<BluedEntityA<?>> cancellableContinuation = cancellableContinuationImpl2;
                final String str3 = str2;
                cancellableContinuation.a((CancellableContinuation<BluedEntityA<?>>) bluedEntityA, (Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: com.soft.blued.http.api.ApiUtils$send$2$1$onUIUpdate$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final void a(Throwable it) {
                        Intrinsics.e(it, "it");
                        if (AppInfo.m()) {
                            Logger.c("KT_API", String.this + "  requestCancel : " + ((Object) it.getMessage()));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(Throwable th) {
                        a(th);
                        return Unit.f42314a;
                    }
                });
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str3) {
                Logger.c("KT_API", "send error -> code :" + i + "    msg : " + ((Object) str3) + ", verifyToken : " + z);
                BluedEntityA<?> bluedEntityA = new BluedEntityA<>();
                bluedEntityA.code = i;
                bluedEntityA.message = str3;
                CancellableContinuation<BluedEntityA<?>> cancellableContinuation = cancellableContinuationImpl2;
                final String str4 = str2;
                cancellableContinuation.a((CancellableContinuation<BluedEntityA<?>>) bluedEntityA, (Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: com.soft.blued.http.api.ApiUtils$send$2$1$onUIFailure$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final void a(Throwable it) {
                        Intrinsics.e(it, "it");
                        if (AppInfo.m()) {
                            Logger.c("KT_API", String.this + "  requestCancel : " + ((Object) it.getMessage()));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(Throwable th) {
                        a(th);
                        return Unit.f42314a;
                    }
                });
                return z2;
            }
        };
        bluedUIHttpResponse.setDataType(C$Gson$Types.newParameterizedTypeWithOwner(null, BluedEntityA.class, cls));
        Unit unit = Unit.f42314a;
        apiUtils.a(str, str2, hashMap, z, bluedUIHttpResponse);
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }

    public final Object a(String str, final String str2, HashMap<String, String> hashMap, boolean z, final boolean z2, Type type, Type type2, Continuation<? super BluedEntity<?, ?>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (AppInfo.m()) {
            Logger.c("KT_API", "url :" + str2 + "  -  params -> " + ((Object) AppInfo.f().toJson(hashMap)) + "   internalError: " + z2 + " verifyToken: " + z);
        }
        ApiUtils apiUtils = f29672a;
        BluedUIHttpResponse<BluedEntity<?, ?>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<?, ?>>() { // from class: com.soft.blued.http.api.ApiUtils$sendWithExtra$2$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str3) {
                Logger.c("KT_API", "send error -> code :" + i + "    msg : " + ((Object) str3));
                BluedEntity<?, ?> bluedEntity = new BluedEntity<>();
                bluedEntity.code = i;
                bluedEntity.message = str3;
                CancellableContinuation<BluedEntity<?, ?>> cancellableContinuation = cancellableContinuationImpl2;
                final String str4 = str2;
                cancellableContinuation.a((CancellableContinuation<BluedEntity<?, ?>>) bluedEntity, (Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: com.soft.blued.http.api.ApiUtils$sendWithExtra$2$1$onUIFailure$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final void a(Throwable it) {
                        Intrinsics.e(it, "it");
                        if (AppInfo.m()) {
                            Logger.c("KT_API", String.this + "  requestCancel : " + ((Object) it.getMessage()));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(Throwable th) {
                        a(th);
                        return Unit.f42314a;
                    }
                });
                return z2;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<?, ?> bluedEntity) {
                if (bluedEntity == null) {
                    return;
                }
                CancellableContinuation<BluedEntity<?, ?>> cancellableContinuation = cancellableContinuationImpl2;
                final String str3 = str2;
                cancellableContinuation.a((CancellableContinuation<BluedEntity<?, ?>>) bluedEntity, (Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: com.soft.blued.http.api.ApiUtils$sendWithExtra$2$1$onUIUpdate$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final void a(Throwable it) {
                        Intrinsics.e(it, "it");
                        if (AppInfo.m()) {
                            Logger.c("KT_API", String.this + "  requestCancel : " + ((Object) it.getMessage()));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(Throwable th) {
                        a(th);
                        return Unit.f42314a;
                    }
                });
            }
        };
        bluedUIHttpResponse.setDataType(C$Gson$Types.newParameterizedTypeWithOwner(null, BluedEntity.class, f29672a.b(type), f29672a.b(type2)));
        Unit unit = Unit.f42314a;
        apiUtils.b(str, str2, hashMap, z, bluedUIHttpResponse);
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }

    public final Type a(int i, ParameterizedType type) {
        Intrinsics.e(type, "type");
        Type[] actualTypeArguments = type.getActualTypeArguments();
        if (i >= 0 && i < actualTypeArguments.length) {
            Type type2 = actualTypeArguments[i];
            Type type3 = type2;
            if (type2 instanceof WildcardType) {
                type3 = ((WildcardType) type2).getUpperBounds()[0];
            }
            return type3;
        }
        throw new IllegalArgumentException(("Index " + i + " not in range [0," + actualTypeArguments.length + ") for " + type).toString());
    }

    public final boolean a(Class<?> clazz) {
        Intrinsics.e(clazz, "clazz");
        if (Intrinsics.a(clazz, Boolean.TYPE) ? true : Intrinsics.a(clazz, Float.TYPE) ? true : Intrinsics.a(clazz, Integer.TYPE) ? true : Intrinsics.a(clazz, String.class) ? true : Intrinsics.a(clazz, Double.TYPE) ? true : Intrinsics.a(clazz, Short.TYPE) ? true : Intrinsics.a(clazz, Long.TYPE) ? true : Intrinsics.a(clazz, Character.class) ? true : Intrinsics.a(clazz, Integer.class)) {
            return true;
        }
        return Intrinsics.a(clazz, Byte.TYPE);
    }

    public final boolean a(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            Intrinsics.c(actualTypeArguments, "type.actualTypeArguments");
            int length = actualTypeArguments.length;
            int i = 0;
            while (i < length) {
                Type type2 = actualTypeArguments[i];
                i++;
                if (a(type2)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            }
            String str = b.l;
            if (type != null) {
                Class<?> cls = type.getClass();
                str = b.l;
                if (cls != null) {
                    str = cls.getName();
                    if (str == null) {
                        str = b.l;
                    }
                }
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + str);
        }
    }

    public final Class<?> b(Type type) {
        Intrinsics.a((Object) type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(b(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return b(((WildcardType) type).getUpperBounds()[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            sb.append(type);
            sb.append("> is of type ");
            String str = null;
            if (type != null) {
                Class<?> cls = type.getClass();
                str = cls == null ? null : cls.getName();
            }
            sb.append((Object) str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final Type b(int i, ParameterizedType type) {
        Intrinsics.e(type, "type");
        Type type2 = type.getActualTypeArguments()[i];
        Type type3 = type2;
        if (type2 instanceof WildcardType) {
            type3 = ((WildcardType) type2).getLowerBounds()[0];
        }
        return type3;
    }
}
