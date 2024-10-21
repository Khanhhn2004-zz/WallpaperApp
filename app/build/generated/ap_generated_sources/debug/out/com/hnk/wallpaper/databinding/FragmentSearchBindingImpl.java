package com.hnk.wallpaper.databinding;
import com.hnk.wallpaper.R;
import com.hnk.wallpaper.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSearchBindingImpl extends FragmentSearchBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(14);
        sIncludes.setIncludes(1, 
            new String[] {"item_wallpaper_shimmer"},
            new int[] {2},
            new int[] {com.hnk.wallpaper.R.layout.item_wallpaper_shimmer});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_title, 3);
        sViewsWithIds.put(R.id.tv_content_search, 4);
        sViewsWithIds.put(R.id.ic_cancel, 5);
        sViewsWithIds.put(R.id.cv_search, 6);
        sViewsWithIds.put(R.id.im_search, 7);
        sViewsWithIds.put(R.id.v_line_1, 8);
        sViewsWithIds.put(R.id.edt_search, 9);
        sViewsWithIds.put(R.id.im_go, 10);
        sViewsWithIds.put(R.id.rcl_photo, 11);
        sViewsWithIds.put(R.id.im_no_result, 12);
        sViewsWithIds.put(R.id.tv_no_result, 13);
    }
    // views
    @Nullable
    private final com.hnk.wallpaper.databinding.ItemWallpaperShimmerBinding mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSearchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private FragmentSearchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.card.MaterialCardView) bindings[6]
            , (android.widget.EditText) bindings[9]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (com.facebook.shimmer.ShimmerFrameLayout) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[3]
            , (android.view.View) bindings[8]
            );
        this.layout.setTag(null);
        this.mboundView1 = (com.hnk.wallpaper.databinding.ItemWallpaperShimmerBinding) bindings[2];
        setContainedBinding(this.mboundView1);
        this.shimmerView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        mboundView1.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView1.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        mboundView1.setLifecycleOwner(lifecycleOwner);
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
        executeBindingsOn(mboundView1);
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