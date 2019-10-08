package com.example.estadorealbeta.ui.propiedades;

import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.estadorealbeta.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class PropiedadesFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);

        viewPager= root.findViewById(R.id.viewPage);
        appBarLayout = root.findViewById(R.id.appBar);

        tabLayout = new TabLayout(getContext());

        appBarLayout.addView(tabLayout);

        ViewPageAdapter vp = new ViewPageAdapter(getChildFragmentManager());

        Propiedad a = new Propiedad("Belgrano 443","4","Casa","Recidencial",18000,true);
        Propiedad b = new Propiedad("San Martin 225","3","Local","Comercial",19000,true);

        vp.addFragment(new PropiedadesTab(a),"prop1");
        vp.addFragment(new PropiedadesTab(b),"prop2");

        viewPager.setAdapter(vp);

        tabLayout.setupWithViewPager(viewPager);

        return root;

    }

    public class ViewPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private  List<String> titulosFragments = new ArrayList<>();

        public ViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulosFragments.get(position);
        }

        public void addFragment(Fragment fragment, String titulo) {
            fragmentList.add(fragment);
            titulosFragments.add(titulo);
        }
    }

}