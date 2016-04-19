package com.hadis.hadispagerslidingtabstrip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author hadis on 16.4.18.
 */
public class SecendFrgament extends Fragment {
    int position;

    public static SecendFrgament newInstance(int position) {
        SecendFrgament f = new SecendFrgament();
        Bundle b = new Bundle();
        b.putInt("pos", position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView textView = (TextView) view.findViewById(R.id.hhh);
        textView.setText(position + "");
        return view;
    }

}
