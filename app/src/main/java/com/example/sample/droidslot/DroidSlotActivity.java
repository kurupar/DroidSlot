package com.example.sample.droidslot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class DroidSlotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_droid_slot);
        //画面上から「droidimageid1」を検出し変数にセット
        ImageView droidImage1 = (ImageView) this.findViewById(R.id.droidimageid1);
        int droidSide1;                     //整数を入れるための変数を宣言
        Random r = new Random();            //Rondomクラスのオブジェクト作成
        droidSide1 = r.nextInt(4);   //0以上4未満の整数の乱数を作成する。
        //if(droidSide1 == 0){
        //    //0なら前向き
        //    droidImage1.setImageResource(R.drawable.droid_front);
        //}else{
        //   //それ以外は後ろ向き
        //    droidImage1.setImageResource(R.drawable.droid_back);
        //}
        int drowbleId;  //リソースID用変数
        switch(droidSide1){
            case 0:
                //0なら前向き
                drowbleId = R.drawable.droid_front;
                break;
            case 1:
                //1なら後ろ向き
                drowbleId = R.drawable.droid_back;
                break;
            case 2:
                //２なら左向き
                drowbleId = R.drawable.droid_left;
                break;
            default:
                //それ以外は右向き
                drowbleId = R.drawable.droid_right;
        }
        droidImage1.setImageResource(drowbleId);

    }
}
