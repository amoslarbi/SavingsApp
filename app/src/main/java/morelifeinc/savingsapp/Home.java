package morelifeinc.savingsapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.app.SearchManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.text.Layout;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    SearchView search;
    FloatingActionButton aboutback;
    EditText editText, editText1, watts;
    ArrayList<String> itemlist;
    ArrayList<String> itemlist1;
    ArrayList<String> itemlist2;
    private TextView names, wtf, hoover, larry;
    Uri imageUri;
    ImageView Uimmg;
    public static final String hello = "hellol";
    public static final String qhello = "hellolol";
    private FirebaseAuth nAuth;
    private FirebaseAuth.AuthStateListener nAuthListener;

    AlertDialog.Builder sett;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

//        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        boolean default = sharedPref.getBoolean("switchValue", false);

        nAuth = FirebaseAuth.getInstance();
        nAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() == null){
                    startActivity(new Intent(Home.this, MainActivity.class));
                }
            }
        };





        //MyCustomAdapter adapter = new MyCustomAdapter(this, hello);
        //

        //list = new ArrayList<String>(Arrays.asList("111,222,333,444,555,666".split(",")));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView nav = (NavigationView) findViewById(R.id.nav_view);
        View hvv = nav.getHeaderView(0);

        names = (TextView) hvv.findViewById(R.id.name);
        wtf = (TextView) hvv.findViewById(R.id.email);
        Uimmg = (ImageView) hvv.findViewById(R.id.Uimmg);
        hoover = (TextView) findViewById(R.id.hoover);

        names.setText(getIntent().getStringExtra("nm"));
        wtf.setText(getIntent().getStringExtra("em"));

        SharedPreferences sh = getSharedPreferences(hello, 0);
        names.setText(sh.getString("nmm", "nmoo"));
        wtf.setText(sh.getString("nmma", "nmoo1"));
        hoover.setText(sh.getString("nmmaa", "nmoo2"));

        String lolo = hoover.getText().toString();
        Uri c = Uri.parse(lolo);
        Picasso.with(getApplicationContext()).load(c).into(Uimmg);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {

        //finish();

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {



        } else if (id == R.id.aboutus) {

            Intent StartIntent = new Intent(getApplicationContext(), Aboutus.class);

            startActivity(StartIntent);

        } else if (id == R.id.userguide) {

            Intent StartIntent = new Intent(getApplicationContext(), Userguide.class);

            startActivity(StartIntent);

        } else if (id == R.id.logout) {

            nAuth.signOut();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        nAuth.addAuthStateListener(nAuthListener);



    }


}
