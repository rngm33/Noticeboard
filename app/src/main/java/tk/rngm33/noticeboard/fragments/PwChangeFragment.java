package tk.rngm33.noticeboard.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.rngm33.noticeboard.R;

/**
 * Created by hp on 4/2/2018.
 */

public class PwChangeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.passwordchanger,null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}