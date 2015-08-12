package presentation.last.com.checkedskys;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import RecycleView.MyNaviAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class radar extends ActionBarActivity {

    String NAME = "Robert Keazor";
    String EMAIL = "rkeazor@gmail.com";
    int PROFILE = R.drawable.aka;
    @Bind(R.id.web)
    WebView web;
    @Bind(R.id.RecyclerView)
    android.support.v7.widget.RecyclerView recyclerView;
    @Bind(R.id.DrawerLayout)
    android.support.v4.widget.DrawerLayout DrawerLayout;
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    String TITLES[] = {"Weather", "Location", "News"};
    int ICONS[] = {R.drawable.sun, R.drawable.location, R.drawable.news};
    RecyclerView.Adapter mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.loadUrl("http://www.cnn.com/");

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
