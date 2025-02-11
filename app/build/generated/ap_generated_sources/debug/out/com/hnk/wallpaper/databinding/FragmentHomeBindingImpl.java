package com.hnk.wallpaper.databinding;
import com.hnk.wallpaper.R;
import com.hnk.wallpaper.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.menu, 1);
        sViewsWithIds.put(R.id.im_back, 2);
        sViewsWithIds.put(R.id.tv_home, 3);
        sViewsWithIds.put(R.id.tv_recent, 4);
        sViewsWithIds.put(R.id.tv_download, 5);
        sViewsWithIds.put(R.id.tv_language, 6);
        sViewsWithIds.put(R.id.tv_dark_theme, 7);
        sViewsWithIds.put(R.id.tv_enable_notifications, 8);
        sViewsWithIds.put(R.id.tv_privicy, 9);
        sViewsWithIds.put(R.id.tv_rate_this_app, 10);
        sViewsWithIds.put(R.id.tv_share_with_friend, 11);
        sViewsWithIds.put(R.id.im_menu, 12);
        sViewsWithIds.put(R.id.im_search, 13);
        sViewsWithIds.put(R.id.view_pager2, 14);
        sViewsWithIds.put(R.id.cv_bottom_navigation, 15);
        sViewsWithIds.put(R.id.bottom_navigation, 16);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.bottomnavigation.BottomNavigationView) bindings[16]
            , (androidx.cardview.widget.CardView) bindings[15]
            , (nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout) bindings[0]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[13]
            , (nl.psdcompany.duonavigationdrawer.views.DuoMenuView) bindings[1]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[11]
            , (androidx.viewpager2.widget.ViewPager2) bindings[14]
            );
        this.drawerLayout.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}