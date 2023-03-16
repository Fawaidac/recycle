package com.kelurahankepuharjo.nyobam5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
//
//import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btndetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button btndetail = findViewById(R.id.detail);
//        Button btndetail2 = findViewById(R.id.detail2);
//
//        btndetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               setFragment(new DetailFragment());
//            }
//        });
//        btndetail2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
    //               setFragment(new DetailFragment2());
    //            }
//        });
//    setFragment(new HomeFragment());
        Fragment fragment  = HomeFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment, "main_fragment");
        transaction.commit();
    }
////    private void setFragment(Fragment fragment){
////        FragmentManager fm = getSupportFragmentManager();
////        FragmentTransaction ft = fm.beginTransaction();
////        ft.replace(R.id.frame, fragment);
////        ft.commit();
////    }
//        private void setFragment(Fragment fragment){
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.frame, fragment);
//        ft.commit();
//    }
}