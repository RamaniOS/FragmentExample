package com.example.fragmentexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements RedFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        BlueFragment blueFragment = new BlueFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.blueFragmentContainer, blueFragment, BlueFragment.class.getName());
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            FragmentManager manager = getSupportFragmentManager();
            BlueFragment blueFragment = new BlueFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.blueFragmentContainer, blueFragment, BlueFragment.class.getName());
            transaction.commit();
        } else if (item.getItemId() == R.id.action_remove) {
            FragmentManager manager = getSupportFragmentManager();
            GreenFragment greenFragment;
            if (manager.findFragmentByTag(GreenFragment.class.getName()) != null) {
                greenFragment = (GreenFragment) manager.findFragmentByTag(GreenFragment.class.getName());
            } else {
                greenFragment = new GreenFragment();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.blueFragmentContainer, greenFragment, BlueFragment.class.getName());
                transaction.commit();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String title) {
        Log.i("SEND", title);
    }
}
