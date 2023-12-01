package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManagerNonConfig.class */
public class FragmentManagerNonConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Collection<Fragment> f2989a;
    private final Map<String, FragmentManagerNonConfig> b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, ViewModelStore> f2990c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentManagerNonConfig(Collection<Fragment> collection, Map<String, FragmentManagerNonConfig> map, Map<String, ViewModelStore> map2) {
        this.f2989a = collection;
        this.b = map;
        this.f2990c = map2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Fragment> a() {
        return this.f2989a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, FragmentManagerNonConfig> b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, ViewModelStore> c() {
        return this.f2990c;
    }
}
