package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/b.class */
public interface b extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/b$a.class */
    public static class a implements b {
        @Override // com.huawei.hms.ads.uiengine.b
        public IObjectWrapper Code(IObjectWrapper iObjectWrapper) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.b
        public List<String> Code(Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.b
        public void Code(IObjectWrapper iObjectWrapper, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.b
        public void Code(String str, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.b
        public boolean Code(String str, int i, Bundle bundle) {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.b
        public void V(IObjectWrapper iObjectWrapper, Bundle bundle) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: com.huawei.hms.ads.uiengine.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/b$b.class */
    public static abstract class AbstractBinderC0255b extends Binder implements b {
        static final int B = 5;
        static final int C = 6;
        static final int Code = 1;
        static final int I = 3;
        private static final String S = "com.huawei.hms.ads.uiengine.IUiEngineUtil";
        static final int V = 2;
        static final int Z = 4;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.huawei.hms.ads.uiengine.b$b$a */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/b$b$a.class */
        public static class a implements b {
            public static b Code;
            private IBinder V;

            a(IBinder iBinder) {
                this.V = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public IObjectWrapper Code(IObjectWrapper iObjectWrapper) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0255b.S);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.V.transact(4, obtain, obtain2, 0) || AbstractBinderC0255b.Code() == null) {
                        obtain2.readException();
                        return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return AbstractBinderC0255b.Code().Code(iObjectWrapper);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String Code() {
                return AbstractBinderC0255b.S;
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public List<String> Code(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0255b.S);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(1, obtain, obtain2, 0) || AbstractBinderC0255b.Code() == null) {
                        obtain2.readException();
                        return obtain2.createStringArrayList();
                    }
                    return AbstractBinderC0255b.Code().Code(bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public void Code(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0255b.S);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(5, obtain, obtain2, 0) || AbstractBinderC0255b.Code() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC0255b.Code().Code(iObjectWrapper, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public void Code(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0255b.S);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(2, obtain, obtain2, 0) || AbstractBinderC0255b.Code() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC0255b.Code().Code(str, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public boolean Code(String str, int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0255b.S);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    boolean z = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(3, obtain, obtain2, 0) || AbstractBinderC0255b.Code() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        return z;
                    }
                    return AbstractBinderC0255b.Code().Code(str, i, bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public void V(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0255b.S);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(6, obtain, obtain2, 0) || AbstractBinderC0255b.Code() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC0255b.Code().V(iObjectWrapper, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }
        }

        public AbstractBinderC0255b() {
            attachInterface(this, S);
        }

        public static b Code() {
            return a.Code;
        }

        public static b Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(S);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(iBinder) : (b) queryLocalInterface;
        }

        public static boolean Code(b bVar) {
            if (a.Code == null) {
                if (bVar != null) {
                    a.Code = bVar;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    IObjectWrapper Code(IObjectWrapper iObjectWrapper);

    List<String> Code(Bundle bundle);

    void Code(IObjectWrapper iObjectWrapper, Bundle bundle);

    void Code(String str, Bundle bundle);

    boolean Code(String str, int i, Bundle bundle);

    void V(IObjectWrapper iObjectWrapper, Bundle bundle);
}
