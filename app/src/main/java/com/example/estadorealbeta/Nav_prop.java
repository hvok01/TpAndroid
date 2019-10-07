package com.example.estadorealbeta;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.estadorealbeta.ui.propiedades.Propiedad;
import com.example.estadorealbeta.ui.propiedades.PropiedadesFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class Nav_prop extends AppCompatActivity  {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_propiedades);

        viewPager= findViewById(R.id.viewPage);
        appBarLayout = findViewById(R.id.appBar);

        tabLayout = new TabLayout(this);

        appBarLayout.addView(tabLayout);

        Nav_prop.ViewPageAdapter vp = new Nav_prop.ViewPageAdapter(getSupportFragmentManager());

        vp.addFragment(new PropiedadesFragment(),"prop1");
        vp.addFragment(new PropiedadesFragment(),"prop2");

        viewPager.setAdapter(vp);

        tabLayout.setupWithViewPager(viewPager);
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

