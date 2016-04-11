package com.firsttread.grouply.view;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.firsttread.grouply.R;
import com.firsttread.grouply.view.fragments.AddNameDialog;
import com.firsttread.grouply.view.fragments.NameListFragment;

public class SingleGroup extends AppCompatActivity {

    private Fragment listFrag;

    private String LIST_FRAG = "listFrag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_group);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.single_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.add_item:
                //launch add dialog fragment
                showDialog();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showDialog(){

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");

        if(prev != null){
            ft.remove(prev);
        }

        ft.addToBackStack(null);

        DialogFragment newFragment = AddNameDialog.newInstance();
        newFragment.show(ft,"dialog");

    }


}
