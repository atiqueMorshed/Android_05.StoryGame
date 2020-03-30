package com.atiquemorshed.storygame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Constants

    //Member Variables
    private TextView mTextTop;
    private Button mButtonTop;
    private Button mButtonBottom;

    private int mStateIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            mStateIndex = savedInstanceState.getInt("StateIndex");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextTop = findViewById(R.id.text_top);
        mButtonTop = findViewById(R.id.button_top);
        mButtonBottom = findViewById(R.id.button_bottom);

        mTextTop.setText(R.string.T1_Story);
        mButtonTop.setText(R.string.T1_Ans1);
        mButtonBottom.setText(R.string.T1_Ans2);

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStateIndex == 1 || mStateIndex == 2) { //Story 1, Button 1 -> Story 3 || Story 2, Button 1 -> Story 3
                    mStateIndex = 3;
                    mTextTop.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                } else { //Story 3, Button 1 -> Story 6 END
                    mStateIndex = 6;
                    mTextTop.setText(R.string.T6_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                }

            }
        });

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStateIndex == 1) { //Story 1, Button 2 -> Story 2
                    mStateIndex = 2;
                    mTextTop.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText(R.string.T2_Ans2);
                } else if(mStateIndex == 2) {//Story 2, Button 2 -> Story 4 END
                    mStateIndex = 4;
                    mTextTop.setText(R.string.T4_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                } else { //Story 3, Button 2 -> Story 5 END
                    mStateIndex = 5;
                    mTextTop.setText(R.string.T5_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                }

            }
        });

    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle onState) {
        super.onSaveInstanceState(onState);
        onState.putInt("StateIndex", 1);
    }
}
