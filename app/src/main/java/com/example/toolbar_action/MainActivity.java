package com.example.toolbar_action;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar =findViewById(R.id.tl_main);
        setSupportActionBar(mToolbar);

        DrawerLayout mDrawer = findViewById(R.id.drawer_layout);

        NavigationView navView =findViewById(R.id.sliding_navigation);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           // getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle("MyApp");


        }
ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawer,mToolbar,R.string.open,R.string.close);
        drawerToggle.syncState();
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                case R.id.action_edit:
                break;
                    case R.id.action_delete:
                        break;
                    case R.id.action_move:
                        break;
                }

                return false;
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

}
     @Override
    public boolean onOptionsItemSelected(MenuItem item){
     switch (item.getItemId())
         {
             case  android.R.id.home:
                 break;
             case   R.id.action_edit :
                 break;
             case R.id.action_delete:
                 break;
         }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}