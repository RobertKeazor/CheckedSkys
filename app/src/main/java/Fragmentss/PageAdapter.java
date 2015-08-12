package Fragmentss;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by rob2cool on 8/6/15.
 */
public class PageAdapter extends FragmentPagerAdapter{
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch ( position){
            case 0:
                return new WebPage_1();
            case 1:
                return new WebPage_2();
            case 2:
                return  new WebPage_3();

            default: return new WebPage_1();

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
