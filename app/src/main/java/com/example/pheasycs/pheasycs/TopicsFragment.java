package com.example.pheasycs.pheasycs;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TopicsFragment extends Fragment {

    enum topicsEnum  {UnitConversions, Kinematics, SumOfVectors};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topics_fragment, container, false);

        final String[] topicItems = {"Unit Conversions", "Kinematics", "Sum of Vectors"};


        final ListView listView = view.findViewById(R.id.lvTopics);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                topicsEnum topicEnum = topicsEnum.values()[position];

                switch(topicEnum){

                    case UnitConversions:
                        MyProperties.getInstance().fragmentValue = 0;
                        break;
                    case Kinematics:
                        MyProperties.getInstance().fragmentValue = 1;
                        break;
                    case SumOfVectors:
                        MyProperties.getInstance().fragmentValue = 2;
                        break;
                }
                ((MainActivity)getActivity()).Restart();
            }
        });

        ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<String>(getContext(), R.layout.topics_items, topicItems);

        listView.setAdapter(ListViewAdapter);

        return view;
    }
}
