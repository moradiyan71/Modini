package ir.modini.classes;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> Fragment = new ArrayList<>(); //Fragment List

    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    public void add(Fragment Frag) {
        Fragment.add(Frag);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return Fragment.get(position);
    }

    @Override
    public int getCount() {
        return 5;
    }
}
