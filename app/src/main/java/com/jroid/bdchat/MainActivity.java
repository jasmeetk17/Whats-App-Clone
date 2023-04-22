package com.jroid.bdchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.jroid.bdchat.Adapter.FragmentsAdpter;
import com.jroid.bdchat.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth=FirebaseAuth.getInstance();
        binding.viewPager.setAdapter(new FragmentsAdpter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.settings:
                //Toast.makeText(this, "Setting is clicked", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(MainActivity.this,Settings.class);
                startActivity(intent2);
                break;
            case R.id.groupChat:
               // Toast.makeText(this, "Group Chat is Started", Toast.LENGTH_SHORT).show();
             Intent intent1=new Intent(MainActivity.this,GroupChatActivity.class);
             startActivity(intent1);
                break;
            case R.id.logout:
               mAuth.signOut();
               Intent intent=new Intent(MainActivity.this,SigninActivity.class);
               startActivity(intent);
               break;
        }
        return super.onOptionsItemSelected(item);
    }
}