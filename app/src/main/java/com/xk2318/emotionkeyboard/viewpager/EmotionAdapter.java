package com.xk2318.emotionkeyboard.viewpager;

/**
 * Created by xiaokai on 2016/12/21.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * Created by dss886 on 15/9/22.
 */
public class EmotionAdapter extends FragmentStatePagerAdapter {
    private SparseArray<Fragment> mPages;

    private int fragmentNum;

    public EmotionAdapter(FragmentManager fm, int num) {
        super(fm);
        mPages = new SparseArray<>();
        fragmentNum = num;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = EmotionFragment.newInstance(position*20);
        mPages.put(position, f);
        return f;
    }

    @Override
    public int getCount() {
        return fragmentNum;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (0 <= mPages.indexOfKey(position)) {
            mPages.remove(position);
        }
        super.destroyItem(container, position, object);
    }
}
