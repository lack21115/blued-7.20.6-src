package com.bytedance.pangle.transform;

import androidx.fragment.app.FragmentActivity;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/transform/HostPartUtils.class */
public class HostPartUtils {
    private Class fragmentActivityClazz;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/transform/HostPartUtils$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final HostPartUtils f21498a = new HostPartUtils();
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = FragmentActivity.class;
        } catch (Throwable th) {
        }
    }

    public static FragmentActivity getFragmentActivity(Object obj, String str) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(obj, str);
    }

    public static final Class getFragmentActivityClass() {
        return a.f21498a.fragmentActivityClazz;
    }
}
