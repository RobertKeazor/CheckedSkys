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

public class WebPage_2 extends Fragment {


    @Bind(R.id.web2)
    WebView web2;
    @Bind(R.id.RecyclerView)
    android.support.v7.widget.RecyclerView RecyclerView;
    @Bind(R.id.DrawerLayout)
    android.support.v4.widget.DrawerLayout DrawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webpage2, container, false);
        ButterKnife.bind(this, view);
        WebSettings webSettings = web2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web2.loadUrl("https://news.google.com/");
        web2.setWebViewClient(new WebViewClient() {
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
