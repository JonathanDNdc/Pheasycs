package com.example.pheasycs.pheasycs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

// This is the fragment for the formulas tab.
public class FormulasFragment extends Fragment {

    // We declared the editText and the bool variable for the onChange.
    EditText firstEditText;
    EditText secondEditText;
    boolean canListen = true;

    // This is where the formulas view is created.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;

        // The layout will depend on the global variable.
        switch (MyProperties.getInstance().fragmentValue) {
            case 0:
                view = inflater.inflate(R.layout.formulas_unit_conversions_fragment, container, false);
                UnitSelected(view);
                break;
            case 1:
                view = inflater.inflate(R.layout.formulas_kinematics_fragment, container, false);
                KinematicSelected(view);
                break;
            case 2:
                view = inflater.inflate(R.layout.formulas_sumofvectors_fragment, container, false);
                sumvectbtn(view);
                break;
            case 3:
                view = inflater.inflate(R.layout.formulas_kin1_fragment, container, false);
                Kin1(view);
                break;
            case 4:
                view = inflater.inflate(R.layout.formulas_kin2_fragment, container, false);
                Kin2(view);
                break;
            case 5:
                view = inflater.inflate(R.layout.formulas_kin3_fragment, container, false);
                Kin3(view);
                break;
            case 6:
                view = inflater.inflate(R.layout.formulas_kin4_fragment, container, false);
                Kin4(view);
                break;
            default:
                view = inflater.inflate(R.layout.formulas_default_fragment, container, false);
                break;
        }
        return view;
    }

    // Declaration of variables.
    int typeposition = 0;
    int firstposition = 0;
    int secondposition = 0;

    // Creates the spinners of the Unit conversion.
    public void onCreateUnitCon(View view) {
        final Spinner typeSpinner = view.findViewById(R.id.unitTypeSpinner);
        final Spinner firstSpinner = view.findViewById(R.id.unitFirstSpinner);
        final Spinner secondSpinner = view.findViewById(R.id.unitSecondSpinner);

        final ArrayAdapter<CharSequence> adapterTopic = ArrayAdapter.createFromResource(getContext(), R.array.units_topic_array, R.layout.spinner_custom_item);
        final ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(getContext(), R.array.area_array, R.layout.spinner_custom_item);
        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.dstorage_array, R.layout.spinner_custom_item);
        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.frequency_array, R.layout.spinner_custom_item);
        final ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getContext(), R.array.length_array, R.layout.spinner_custom_item);
        final ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getContext(), R.array.angle_array, R.layout.spinner_custom_item);
        final ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getContext(), R.array.temperature_array, R.layout.spinner_custom_item);
        final ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getContext(), R.array.time_array, R.layout.spinner_custom_item);
        adapterTopic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        typeSpinner.setAdapter(adapterTopic);
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeposition = position;
                // Depending of the position the items of the spinner will change.
                switch (position) {
                    case 0:
                        firstSpinner.setAdapter(adapter0);
                        secondSpinner.setAdapter(adapter0);
                        break;
                    case 1:
                        firstSpinner.setAdapter(adapter1);
                        secondSpinner.setAdapter(adapter1);
                        break;
                    case 2:
                        firstSpinner.setAdapter(adapter2);
                        secondSpinner.setAdapter(adapter2);
                        break;
                    case 3:
                        firstSpinner.setAdapter(adapter3);
                        secondSpinner.setAdapter(adapter3);
                        break;
                    case 4:
                        firstSpinner.setAdapter(adapter4);
                        secondSpinner.setAdapter(adapter4);
                        break;
                    case 5:
                        firstSpinner.setAdapter(adapter5);
                        secondSpinner.setAdapter(adapter5);
                        break;
                    case 6:
                        firstSpinner.setAdapter(adapter6);
                        secondSpinner.setAdapter(adapter6);
                        break;
                }

                firstSpinner.setOnItemSelectedListener(onItemSelectedListener);
                secondSpinner.setOnItemSelectedListener(onItemSelectedListener);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    // This is called when the item of the spinners is changed.
    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (parent.getId() == R.id.unitFirstSpinner) {
                firstposition = position;
                ChangeSecond();
            } else {
                secondposition = position;
                ChangeFirst();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    public void UnitSelected(View view) {

        onCreateUnitCon(view);

        firstEditText = view.findViewById(R.id.unitFirstEditText);

        firstEditText.addTextChangedListener(new TextWatcher() {

            // When one of the EditText is changed, we show the conversion in the other.
            // We use the boolean so they don't change each other infinitely.
            public void afterTextChanged(Editable s) {
                if (canListen) {
                    canListen = false;
                    ChangeFirst();
                } else {
                    canListen = true;
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        secondEditText = view.findViewById(R.id.unitSecondEditText);

        secondEditText.addTextChangedListener(new TextWatcher() {

            // When one of the EditText is changed, we show the conversion in the other.
            // We use the boolean so they don't change each other infinitely.
            public void afterTextChanged(Editable s) {

                if (canListen) {
                    canListen = false;
                    ChangeSecond();
                } else {
                    canListen = true;
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }

    // Change the value of the other EditText according to the value of the conversion.
    public void ChangeFirst() {
        UnitConverter unitConverter = new UnitConverter();
        try {
            double value = Double.parseDouble(firstEditText.getText().toString());
            secondEditText.setText(String.valueOf(unitConverter.unitConverter(value, typeposition, firstposition, secondposition)));
        } catch (Exception e) {
            secondEditText.setText("");
        }
    }

    public void ChangeSecond() {
        UnitConverter unitConverter = new UnitConverter();
        try {
            double value = Double.parseDouble(secondEditText.getText().toString());
            firstEditText.setText(String.valueOf(unitConverter.unitConverter(value, typeposition, secondposition, firstposition)));
        } catch (Exception e) {
            firstEditText.setText("");
        }
    }

    // Images on the kinematic fragment.
    public void KinematicSelected(View v){
        ImageView kin1 = v.findViewById(R.id.kin1);
        ImageView kin2 = v.findViewById(R.id.kin2);
        ImageView kin3 = v.findViewById(R.id.kin3);
        ImageView kin4 = v.findViewById(R.id.kin4);
        kin1.setOnClickListener(imageClickListener);
        kin2.setOnClickListener(imageClickListener);
        kin3.setOnClickListener(imageClickListener);
        kin4.setOnClickListener(imageClickListener);
    }

    // For each formula we make an adapter for the spinner.

    public void Kin1(View v){
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getContext(), R.array.kin1_array, R.layout.spinner_custom_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerkin1 = v.findViewById(R.id.spinnerkin1);
        spinnerkin1.setAdapter(adapter7);
        spinnerkin1.setOnItemSelectedListener(kin1ItemSelected);

        kin1Button(v);
    }

    public void Kin2(View v){
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getContext(), R.array.kin2_array, R.layout.spinner_custom_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerkin1 = v.findViewById(R.id.spinnerkin1);
        spinnerkin1.setAdapter(adapter7);
        spinnerkin1.setOnItemSelectedListener(kin1ItemSelected);

        kin1Button(v);
    }

    public void Kin3(View v){
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getContext(), R.array.kin3_array, R.layout.spinner_custom_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerkin1 = v.findViewById(R.id.spinnerkin1);
        spinnerkin1.setAdapter(adapter7);
        spinnerkin1.setOnItemSelectedListener(kin1ItemSelected);

        kin1Button(v);
    }

    public void Kin4(View v){
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getContext(), R.array.kin4_array, R.layout.spinner_custom_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerkin1 = v.findViewById(R.id.spinnerkin1);
        spinnerkin1.setAdapter(adapter7);
        spinnerkin1.setOnItemSelectedListener(kin1ItemSelected);

        kin1Button(v);
    }

    // When an image is clicked, fragmentValue changes so the layout can change.
    private View.OnClickListener imageClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.kin1:
                    MyProperties.getInstance().fragmentValue = 3;
                    break;
                case R.id.kin2:
                    MyProperties.getInstance().fragmentValue = 4;
                    break;
                case R.id.kin3:
                    MyProperties.getInstance().fragmentValue = 5;
                    break;
                case R.id.kin4:
                    MyProperties.getInstance().fragmentValue = 6;
                    break;
            }
            // The app is restarted.
            ((MainActivity)getActivity()).Restart();
        }
    };

    // We get the position of the variable the user wants to get.
    AdapterView.OnItemSelectedListener kin1ItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            typeposition = position;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    double kinValue;

    // Function for the button functionality.
    public void kin1Button(View v){
        // Declaring the EditText's
        final EditText editvel = v.findViewById(R.id.editVel1);
        final EditText editinvel = v.findViewById(R.id.editInvel1);
        final EditText editacel = v.findViewById(R.id.editAcel1);
        final EditText edittime = v.findViewById(R.id.editTime1);

        Button kin1btn = v.findViewById(R.id.kin1btn);
        // When the button is pressed:
        kin1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Declaring each values
                double vel;
                double invel;
                double acel;
                double time;

                // If the user didn't entered a value, it will be taken as a 0.
                try{
                    vel = Double.parseDouble(editvel.getText().toString());
                } catch(Exception e){
                    vel = 0;
                }

                try{
                    invel = Double.parseDouble(editinvel.getText().toString());
                } catch(Exception e){
                    invel = 0;
                }

                try{
                    acel = Double.parseDouble(editacel.getText().toString());
                } catch (Exception e){
                    acel = 0;
                }

                try{
                    time = Double.parseDouble(edittime.getText().toString());
                } catch (Exception e){
                    time = 0;
                }

                // We get the result from the Kinematics class.
                Kinematics kinematics = new Kinematics();
                kinValue = kinematics.selectFormula(MyProperties.getInstance().fragmentValue, typeposition, vel, invel, acel, time);

                // We change the value the user wants to the result.
                switch(typeposition){
                    case 0:
                        editvel.setText(String.valueOf(kinValue));
                        break;
                    case 1:
                        editinvel.setText(String.valueOf(kinValue));
                        break;
                    case 2:
                        editacel.setText(String.valueOf(kinValue));
                        break;
                    case 3:
                        edittime.setText(String.valueOf(kinValue));
                        break;
                }
            }
        });
    }

    // Function for the sum of vectors button.
    public void sumvectbtn(View v){
        // Declaring the EditText's
        final EditText etmag1 = v.findViewById(R.id.mag1);
        final EditText etmag2 = v.findViewById(R.id.mag2);
        final EditText etmag3 = v.findViewById(R.id.mag3);

        final EditText etang1 = v.findViewById(R.id.ang1);
        final EditText etang2 = v.findViewById(R.id.ang2);
        final EditText etang3 = v.findViewById(R.id.ang3);

        final TextView mag= v.findViewById(R.id.magres);
        final TextView ang = v.findViewById(R.id.angres);

        Button sofbtn = v.findViewById(R.id.button);
        // When the button is pressed:
        sofbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Declaring the values.
                double mag1;
                double mag2;
                double mag3;

                double ang1;
                double ang2;
                double ang3;

                // If the user didn't enter a value, it will be taken as a 0.
                try{
                    mag1 = Double.parseDouble(etmag1.getText().toString());
                } catch(Exception e){
                    mag1 = 0;
                }

                try{
                    mag2 = Double.parseDouble(etmag2.getText().toString());
                } catch(Exception e){
                    mag2 = 0;
                }

                try{
                    mag3 = Double.parseDouble(etmag3.getText().toString());
                } catch(Exception e){
                    mag3 = 0;
                }

                try{
                    ang1 = Double.parseDouble(etang1.getText().toString());
                } catch(Exception e){
                    ang1 = 0;
                }

                try{
                    ang2 = Double.parseDouble(etang2.getText().toString());
                } catch(Exception e){
                    ang2 = 0;
                }

                try{
                    ang3 = Double.parseDouble(etang3.getText().toString());
                } catch(Exception e){
                    ang3 = 0;
                }


                // The magnitude and angle will be received from the SumOfVectors class.
                SumOfVectors sumOfVectors = new SumOfVectors();
                double resmag = sumOfVectors.getOne(true, mag1, ang1, mag2, ang2, mag3, ang3);
                double resang = sumOfVectors.getOne(false, mag1, ang1, mag2, ang2, mag3, ang3);

                mag.setText(String.format("%.3f", resmag));
                ang.setText(String.format("%.3f", resang));

            }
        });
    }
}
