package com.developnic.jjmichael.choose.DetallePorCarrera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.developnic.jjmichael.choose.DetallePorCarrera.tab_de_detalle_carreras.FragmentsComentarios;
import com.developnic.jjmichael.choose.DetallePorCarrera.tab_de_detalle_carreras.FragmentsDescripcion;
import com.developnic.jjmichael.choose.DetallePorCarrera.tab_de_detalle_carreras.FragmentsUtilidad;
import com.developnic.jjmichael.choose.POJO.Carreras;
import com.developnic.jjmichael.choose.POJO.Conexiones;
import com.developnic.jjmichael.choose.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjmic on 25/11/2017.
 */

public class DetalleCarrera extends AppCompatActivity {


    private static final String EXTRA_NAME = "com.developnic.jjmichael.name";
    private static final String EXTRA_DRAWABLE = "com.developnic.jjmichael.drawable";
    private ViewPager viewPager;
    private TabLayout tabLayout;


    public static void createInstance(Activity activity, Carreras title) {
        Intent intent = getLaunchIntent(activity, title);
        activity.startActivity(intent);
    }


    public static Intent getLaunchIntent(Context context, Carreras carreras) {
        Intent intent = new Intent(context, DetalleCarrera.class);
        intent.putExtra(EXTRA_NAME, carreras.getNombre());
        intent.putExtra(EXTRA_DRAWABLE, carreras.getImagen());
        Conexiones.carreras = carreras;
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_carreras);


        setToolbar();
        metodo_viewpager();
        TabLayoutIcon();

        if (getSupportActionBar() != null) // Habilitar up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        //String name = i.getStringExtra(EXTRA_NAME);
        String imagen = i.getStringExtra(EXTRA_DRAWABLE);
        String name = Conexiones.carreras.getNombre();
        CollapsingToolbarLayout collapser =
                (CollapsingToolbarLayout) findViewById(R.id.collapser);
        collapser.setTitle(name); // Cambiar título

        loadImageParallax(imagen);// Cargar Imagen

    }

    private void TabLayoutIcon() {

        int[] tabIcons = {
                R.drawable.ic_description_24dp,
                R.drawable.ic_util_24dp,
                R.drawable.chat,
        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);

    }

    private void metodo_viewpager() {

        viewPager = (ViewPager)findViewById(R.id.tab_viewpager);
        if (viewPager != null){
            setupViewPager(viewPager);
        }

        tabLayout = (TabLayout)findViewById(R.id.tabLayout_Detalle);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

    }


    private void setToolbar() {
        // Añadir la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detalle);
        setSupportActionBar(toolbar);

    }


    private void loadImageParallax(String imagen) {
        ImageView imageView = (ImageView) findViewById(R.id.image_paralax);
        // Usando Glide para la carga asíncrona

        Glide.with(this).load(imagen).centerCrop().into(imageView);
    }

    private void showSnackBar(String msg) {
        Snackbar
                .make(findViewById(R.id.coordinator), msg, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle_car, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                showSnackBar("Se abren los ajustes");
                return true;
            case R.id.action_add:
                showSnackBar("Añadir a contactos");
                return true;
            case R.id.action_favorite:
                showSnackBar("Añadir a favoritos");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentsDescripcion(), "");
        adapter.addFrag(new FragmentsUtilidad(), "");
        adapter.addFrag(new FragmentsComentarios(), "");
        viewPager.setAdapter(adapter);
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return mFragmentTitleList.get(position);
        }
    }

}

