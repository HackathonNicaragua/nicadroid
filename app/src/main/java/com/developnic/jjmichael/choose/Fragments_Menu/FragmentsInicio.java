package com.developnic.jjmichael.choose.Fragments_Menu;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developnic.jjmichael.choose.R;

/**
 * Created by jjmic on 26/11/2017.
 */

public class FragmentsInicio extends Fragment{

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_inicio_fragmnents, container, false);

        return view;
    }

}
