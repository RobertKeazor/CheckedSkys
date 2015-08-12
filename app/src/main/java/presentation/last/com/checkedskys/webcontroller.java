package presentation.last.com.checkedskys;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import Fragmentss.PageAdapter;

public class webcontroller extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcontroller);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pagecontrol);
        PageAdapter pager = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pager);
    }
}

