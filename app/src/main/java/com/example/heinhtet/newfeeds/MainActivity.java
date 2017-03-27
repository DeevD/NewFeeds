package com.example.heinhtet.newfeeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.heinhtet.newfeeds.Google.GoogleFragment;
import com.example.heinhtet.newfeeds.MTV.MtvFragment;
import com.example.heinhtet.newfeeds.guide.AppIntro;

import static com.example.heinhtet.newfeeds.R.id.about;
import static com.example.heinhtet.newfeeds.R.id.guide;
import static com.example.heinhtet.newfeeds.R.id.spinner;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    android.app.Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Calling MainFragment on Blank main_activity
         */
        placingFragment();


        Toolbar toolbarIcon = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarIcon);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbarIcon, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    private void placingFragment() {
        GoogleFragment googleFragment = new GoogleFragment();
        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.blank_space, googleFragment);
        ft.commit();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        callingSpinner(menu);



//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        //final MenuItem searchItem = menu.findItem(R.id.action_search);
//       // final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.action_search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        /*
        When use of custom searchView Icon
         */
//        int searchImgId = android.support.v7.appcompat.R.id.search_button; // I used the explicit layout ID of searchview's ImageView
//        ImageView v = (ImageView) searchView.findViewById(searchImgId);
//        v.setImageResource(R.drawable.simple);
        // super.onPrepareOptionsMenu(menu);

//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if(fragment instanceof GoogleFragment)
//                    ((GoogleFragment)fragment).googleRecyclerAdapter.getFilter().filter(newText);
//                //googleRe    cyclerAdapter.getFilter().filter(newText);
//
//                return true;
//            }
//        });

        return true;
    }

    private void callingSpinner(Menu menu) {
         /*
        Adding Spinner on ActionBar and click onItemSelected for Spinner
         */

        MenuItem menuItem = menu.findItem(spinner);

        final Spinner spinnerID = (Spinner) MenuItemCompat.getActionView(menuItem);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerID.setAdapter(adapter);
        // spinner.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        spinnerID.setPopupBackgroundResource(R.color.bg_screen1);
        spinnerID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (spinnerID.getSelectedItemPosition()) {
                    case 1: {
                        GoogleFragment googleFragment = new GoogleFragment();
                        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.blank_space, googleFragment);
                        ft.addToBackStack("tag");
                        ft.commit();
                        break;

                    }
                    case 2: {
                        MtvFragment mptFragment = new MtvFragment();
                        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.blank_space, mptFragment);
                        fragmentTransaction.commit();
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.categoriesID) {

            CategoreisFragment categoreisFragment = new CategoreisFragment();
            android.app.FragmentTransaction ftp = getFragmentManager().beginTransaction().remove(this.fragment).replace(R.id.blank_space, categoreisFragment);
            ftp.commit();

        } else if (id == guide) {
            Intent about  = new Intent(MainActivity.this, AppIntro.class);
            startActivity(about);
        }
        else if (id==about){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setBackgroundResource(R.color.bg_screen1);
        drawer.closeDrawer(GravityCompat.START);
        drawer.setBackgroundResource(R.drawable.back_icon);
        drawer.setStatusBarBackground(R.drawable.book);
        drawer.setStatusBarBackgroundColor(getResources().getColor(R.color.bg_screen1));
        return true;
    }
}
