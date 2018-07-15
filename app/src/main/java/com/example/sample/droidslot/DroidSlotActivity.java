package com.example.sample.droidslot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class DroidSlotActivity extends AppCompatActivity {

    int droidSide1 = -1;                     //整数を入れるための変数を宣言
    int droidSide2 = -1;                     //整数を入れるための変数を宣言
    int droidSide3 = -1;                     //整数を入れるための変数を宣言
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_droid_slot);
        //画面上から「droidimageid1」を検出し変数にセット
        final ImageView droidImage1 = (ImageView) this.findViewById(R.id.droidimageid1);
        final ImageView droidImage2 = (ImageView) this.findViewById(R.id.droidimageid2);
        final ImageView droidImage3 = (ImageView) this.findViewById(R.id.droidimageid3);
        final Random r = new Random();            //Rondomクラスのオブジェクト作成

        final Button b1 = (Button) this.findViewById(R.id.slotbutton1);
        final Button b2 = (Button) this.findViewById(R.id.slotbutton2);
        final Button b3 = (Button) this.findViewById(R.id.slotbutton3);

        retryButton = (Button) this.findViewById(R.id.retrybutton);
        retryButton.setVisibility(View.INVISIBLE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                droidSide1 = r.nextInt(4);   //0以上4未満の整数の乱数を作成する。
                droidImage1.setImageResource(getDrowbleId(droidSide1));
                checkSlot();
                b1.setEnabled(false);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                droidSide2 = r.nextInt(4);   //0以上4未満の整数の乱数を作成する。
                droidImage2.setImageResource(getDrowbleId(droidSide2));
                checkSlot();
                b2.setEnabled(false);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                droidSide3 = r.nextInt(4);   //0以上4未満の整数の乱数を作成する。
                droidImage3.setImageResource(getDrowbleId(droidSide3));
                checkSlot();
                b3.setEnabled(false);
            }
        });

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                droidImage1.setImageResource(R.drawable.star);
                droidImage2.setImageResource(R.drawable.star);
                droidImage3.setImageResource(R.drawable.star);

                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);

                retryButton.setVisibility(View.INVISIBLE);
                droidSide1 = droidSide2 = droidSide3 = -1;
            }
        });

    }

    private int getDrowbleId(int side){
        int[] drawbleId = new int[]{    R.drawable.droid_front,
                                        R.drawable.droid_back,
                                        R.drawable.droid_left,
                                        R.drawable.droid_right  };

        return drawbleId[side];
    }

    private void checkSlot(){
        if(droidSide1 == droidSide2 && droidSide1 == droidSide3){
            Toast.makeText(getApplicationContext(), "おめでとう！揃いました" , Toast.LENGTH_SHORT).show();
            retryButton.setVisibility(View.VISIBLE);
        }else if(droidSide1 != 1 && droidSide2 != 1 && droidSide3 != 1 ){
            retryButton.setVisibility(View.VISIBLE);
        }

    }

}
