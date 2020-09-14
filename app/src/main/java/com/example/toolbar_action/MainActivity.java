package com.example.toolbar_action;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private    DrawerLayout mDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar =findViewById(R.id.tl_main);
        setSupportActionBar(mToolbar);

        mDrawer = findViewById(R.id.drawer_layout);

        NavigationView navView =findViewById(R.id.sliding_navigation);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           // getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle("MyApp");


        }
ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawer,mToolbar,R.string.open,R.string.close);
        drawerToggle.syncState();
   //     navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
 //           @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                case R.id.action_edit:
//                break;
//                    case R.id.action_delete:
//                        break;
//                    case R.id.action_move:
//                        break;
//                }
//
//                return true;
//            }
//        });
        navView.setNavigationItemSelectedListener(this);
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
                 onBackPressed();
                 Toast.makeText(MainActivity.this,"home is clicked",Toast.LENGTH_LONG).show();

                 break;
             case   R.id.action_edit :
                 Toast.makeText(MainActivity.this,"Edit is clicked",Toast.LENGTH_LONG).show();
                 startActivity(new Intent(MainActivity.this,TabActivity.class));
                 break;
             case R.id.action_delete:
                 Toast.makeText(MainActivity.this,"Delete is clicked",Toast.LENGTH_LONG).show();

                 break;
         }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawer.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){
            case R.id.action_move: 
               startActivity(new Intent(MainActivity.this,TabActivity.class));
                ViewFragment editFragment1 =new ViewFragment();
                FragmentTransaction fm1 = getSupportFragmentManager().beginTransaction();

                fm1.replace(R.id.frament_container,editFragment1);
                fm1.commit();
                break;
            case R.id.action_delete:

                startActivity(new Intent(MainActivity.this,TabActivity.class));
                EditFragment editFragment2 =new EditFragment();
                FragmentTransaction fm2 = getSupportFragmentManager().beginTransaction();

                fm2.replace(R.id.frament_container,editFragment2);
                fm2.commit();
                Toast.makeText(MainActivity.this,"Delete is clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.action_edit:
                EditFragment editFragment =new EditFragment();
                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();

                fm.replace(R.id.frament_container,editFragment);
                fm.commit();
                break;
        }
        return true;
    }
}