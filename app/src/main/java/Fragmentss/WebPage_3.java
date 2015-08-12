package Fragmentss;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.Bind;
import butterknife.ButterKnife;
import presentation.last.com.checkedskys.R;

/**
 * Created by rob2cool on 8/6/15.
 */
public class WebPage_3 extends Fragment {
    @Bind(R.id.web3)
    WebView web3;
    @Bind(R.id.RecyclerView)
    android.support.v7.widget.RecyclerView RecyclerView;
    @Bind(R.id.DrawerLayout)
    android.support.v4.widget.DrawerLayout DrawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webpage3, container, false);
        ButterKnife.bind(this, view);
        WebSettings webSettings = web3.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web3.loadUrl("http://news.yahoo.com/");
        web3.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
