package module.base.baseframwork.base.fragment;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> listFragments;
    public BaseFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        listFragments=list;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}
