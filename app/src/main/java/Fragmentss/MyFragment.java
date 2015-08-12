package Fragmentss;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import Interfaces.FragInteract;
import butterknife.Bind;
import butterknife.ButterKnife;
import presentation.last.com.checkedskys.R;

/**
 * Created by rob2cool on 8/5/15.
 */
public class MyFragment extends Fragment implements FragInteract {

    FragInteract mListener;

    @Bind(R.id.weatherCaption)
    TextView weatherCaption;
    View v;
    @Bind(R.id.fragId)
    RelativeLayout fragId;


    public MyFragment() {
    }


    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String caption = getArguments().getString("temp");
        int wallpaper =getArguments().getInt("wallpaper");
        View view = inflater.inflate(R.layout.fragment_main2, container, false);
        ButterKnife.bind(this, view);
        weatherCaption.setText(caption);

        fragId.setBackgroundResource(wallpaper);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public int updateCaption(String texts) {

        weatherCaption.setText(texts);
        return 0;
    }
}
