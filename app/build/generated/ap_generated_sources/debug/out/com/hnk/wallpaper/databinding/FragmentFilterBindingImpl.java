package com.hnk.wallpaper.databinding;
import com.hnk.wallpaper.R;
import com.hnk.wallpaper.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentFilterBindingImpl extends FragmentFilterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.im_back, 1);
        sViewsWithIds.put(R.id.tv_filter, 2);
        sViewsWithIds.put(R.id.tv_content, 3);
        sViewsWithIds.put(R.id.tv_latest_uploads, 4);
        sViewsWithIds.put(R.id.sw_lastest_uploads, 5);
        sViewsWithIds.put(R.id.tv_newest_collection, 6);
        sViewsWithIds.put(R.id.sw_newest_collection, 7);
        sViewsWithIds.put(R.id.tv_most_downloaded, 8);
        sViewsWithIds.put(R.id.sw_most_downloaded, 9);
        sViewsWithIds.put(R.id.tv_exclusive_first, 10);
        sViewsWithIds.put(R.id.sw_exclusive_first, 11);
        sViewsWithIds.put(R.id.tv_sort_by_size, 12);
        sViewsWithIds.put(R.id.sw_sort_by_size, 13);
        sViewsWithIds.put(R.id.btn_get_started, 14);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentFilterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private FragmentFilterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[14]
            , (android.widget.ImageView) bindings[1]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[11]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[5]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[9]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[7]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[13]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[12]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
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