package com.hnk.wallpaper.databinding;
import com.hnk.wallpaper.R;
import com.hnk.wallpaper.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentFeaturedBindingImpl extends FragmentFeaturedBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(18);
        sIncludes.setIncludes(1, 
            new String[] {"item_banner_shimmer"},
            new int[] {3},
            new int[] {com.hnk.wallpaper.R.layout.item_banner_shimmer});
        sIncludes.setIncludes(2, 
            new String[] {"item_wallpaper_shimmer"},
            new int[] {4},
            new int[] {com.hnk.wallpaper.R.layout.item_wallpaper_shimmer});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_title, 5);
        sViewsWithIds.put(R.id.pg_featured_1, 6);
        sViewsWithIds.put(R.id.dotsIndicator, 7);
        sViewsWithIds.put(R.id.v_show_more, 8);
        sViewsWithIds.put(R.id.tv_curated, 9);
        sViewsWithIds.put(R.id.im_show_more_curated, 10);
        sViewsWithIds.put(R.id.rcl_wallpaper_curated, 11);
        sViewsWithIds.put(R.id.tv_trending, 12);
        sViewsWithIds.put(R.id.im_show_more_trending, 13);
        sViewsWithIds.put(R.id.rcl_wallpaper, 14);
        sViewsWithIds.put(R.id.tv_featured, 15);
        sViewsWithIds.put(R.id.im_show_more_featured, 16);
        sViewsWithIds.put(R.id.rcl_wallpaper_featured, 17);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    @Nullable
    private final com.hnk.wallpaper.databinding.ItemBannerShimmerBinding mboundView1;
    @Nullable
    private final com.hnk.wallpaper.databinding.ItemWallpaperShimmerBinding mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentFeaturedBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private FragmentFeaturedBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.tbuonomo.viewpagerdotsindicator.DotsIndicator) bindings[7]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[13]
            , (androidx.viewpager2.widget.ViewPager2) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[14]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[17]
            , (com.facebook.shimmer.ShimmerFrameLayout) bindings[1]
            , (com.facebook.shimmer.ShimmerFrameLayout) bindings[2]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.hnk.wallpaper.databinding.ItemBannerShimmerBinding) bindings[3];
        setContainedBinding(this.mboundView1);
        this.mboundView2 = (com.hnk.wallpaper.databinding.ItemWallpaperShimmerBinding) bindings[4];
        setContainedBinding(this.mboundView2);
        this.shimmerBanner.setTag(null);
        this.shimmerViewWallpaperCurated.setTag(null);
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
        mboundView2.invalidateAll();
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
        if (mboundView2.hasPendingBindings()) {
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
        mboundView2.setLifecycleOwner(lifecycleOwner);
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
        executeBindingsOn(mboundView2);
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