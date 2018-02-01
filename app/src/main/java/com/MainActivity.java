package com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.faq.match.NameMate;
import com.miracle.textmatch.R;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    //the source List
    private String inPut =
            "安捷汽车#斌#春#成都小狗#超儿#车库#程丽红#陈谦#成松YY荟#蔡文刚#陈小娟#陈小娟姐#曹小龙#大爸电信" +
                    "#大爸 电信#董春梅#邓光义#德辉哥#邓瑾#DJM#大妈#刁强#邓琪#邓腾龙#段魏洪#二爸#EJJ#EJM#Fer" +
                    "#芳姐#高德辉#姑父#哥哥#GG#刚哥#高金华#黄车库#胡琼#猴子#J#韭黄#JJiu#JJiu的#贾菊梅#柯萧" +
                    "#刘芳园#罗姣#老姐#李乐#李庆#梁婷#李维#李小霞#刘莹#李雨涵#阆中#马丹#美的#Mer#玫瑰之约" +
                    "#马娟#麻麻#嬢嬢#萍沓子#山东#山东电信#山哥#爽阴#唐春普#童林杰#婷美眉#涂平#涂仕芳#吴纯天" +
                    "#王凤#王飞#汪芳#王娟电信#王林#王旭#王显锋#王洋#王永辉#谢东升#小狗#小狗电信#俞翠#Ye#杨红" +
                    "#俞海桐#姚晶晶#杨莲花#俞利琼#杨璐强#余鹏#余森#杨婷婷#杨小凤#姚小凤#野猪#杨真斌#赵彩丝" +
                    "#赵娟电信#周君君#赵攀#张瑞#张鑫#张晓旭#张鱼#祝永立#匪警#火警#急救中心#道路交通事故报警" +
                    "#水上求救专用电话#天气预报#报时服务#森林火警#电力服务#红十字会急救台#公安短信报警" +
                    "#通用紧急求救#中国电信客服服务#中国联通客服热线#中国移动客服热线#中国铁通客服热线" +
                    "#电话号码查询#查号台（电信）#查号台（联通）#中国人寿保险#中国人保保险#中华联合保险" +
                    "#泰康人寿保险#太平洋保险#天安保险#华安财险#新华人寿保险#平安保险#大众保险#中国大地保险" +
                    "#太平人寿保险#华泰财险#安邦财险#中国银行#交通银行#中国银联#招商银行#农业银行#民生银行" +
                    "#上海浦东发展银行#汇丰银行#东亚银行#兴业银行#工商银行#光大银行#广东发展银行#华夏银行" +
                    "#花旗银行#上海银行#中信银行#建设银行#邮政储蓄#深圳发展银行#北京银行#铁路电话订票号码" +
                    "#国航（中国国际航空）#海航（海南航空）#南航（中国南方航空）#东航（中国东方航空）" +
                    "#深航（深圳航空）#厦航（厦门航空）#山航（山东航空）#川航（四川航空）#消费者投诉热线" +
                    "#物价监督热线#质量监督热线#环保监督热线#纳税服务专线#市长热线#公共卫生热线#电信投诉热线" +
                    "#妇女维权#法律援助#劳动保障#机构编制违规举报#文化市场综合执法#申通快递#EMS特快专递" +
                    "#顺丰速运#圆通速递#中通速递#韵达快运#天天快递#汇通快运#速尔快递#德邦物流#宅急送#中铁快运" +
                    "#鑫飞鸿快递#UPS#FedEx(联邦快递)#DHL#新邦物流#TNT#民航快递#吉利汽车#长春一汽#一汽马自达" +
                    "#宝马汽车#广汽丰田#BUICK别克#东南汽车#奇瑞汽车#一汽大众#东风日产#奔驰汽车#上海大众咨询" +
                    "#沃尔沃轿车#北京吉普#上海华普汽车#昌河汽车#东风本田#比亚迪汽车#凯迪拉克咨询#Ford福特" +
                    "#北京现代#江铃汽车#东风雪铁龙#广州本田#一汽丰田#雪佛兰#北汽福田#南京依维柯#麦当劳#肯德基" +
                    "#必胜客#真功夫#丽华快餐";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.et);
        editText.setText("曹小龙");
        textView = findViewById(R.id.tv);
        initEgine();
    }

    /**
     * init the engine
     */
    private void initEgine() {
        NameMate.getInstance(this).setFree();
        NameMate.getInstance(this).init(this, inPut);
    }

    public void click(View v) {
        if (TextUtils.isEmpty(editText.getText().toString().trim())) {
            Toast.makeText(this, "InputText is empty !", Toast.LENGTH_SHORT).show();
        } else {
            {
                long startTime = System.currentTimeMillis();
                String[] matchName = NameMate.getInstance(this).TextScore(editText.getText().toString(), 4, 1);
                Log.i("!!!", "" + matchName[0] + "\n" + matchName[1] +
                        "\n" + matchName[2] + "\n" + matchName[3]);
                textView.setText("Match Result:\n" + matchName[0] + "\n" + matchName[1] +
                        "\n" + matchName[2] + "\n" + matchName[3] + "\n\n" + "Cost：" + (System.currentTimeMillis() - startTime) + "ms");
            }
        }
    }
}
