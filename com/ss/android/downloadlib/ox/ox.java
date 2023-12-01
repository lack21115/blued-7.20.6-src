package com.ss.android.downloadlib.ox;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/ox/ox.class */
public class ox {
    public void mb(final com.ss.android.downloadad.api.mb.ox oxVar, final ko koVar, int i) {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.ox.ox.1
            @Override // java.lang.Runnable
            public void run() {
                if (lz.mb(oxVar)) {
                    koVar.mb(false);
                } else if (u.mb(oxVar)) {
                    u.mb(oxVar, new ww() { // from class: com.ss.android.downloadlib.ox.ox.1.1
                        @Override // com.ss.android.downloadlib.ox.ww
                        public void mb(boolean z) {
                            koVar.mb(z);
                        }
                    });
                } else {
                    koVar.mb(false);
                }
            }
        }, i);
    }
}
