package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class debugger extends AppCompatActivity {

    String night    = "#282A36";
    String dusk     = "#6272A4";
    String twilight = "#44475A";
    String pink     = "#FF79C6";
    String green    = "#50FA7B";
    String yellow   = "#F1FA8C";
    String purple   = "#BD93F9";
    String red      = "#FF5555";
    String orange   = "#FFB86C";
    String dawn     = "#F8F8F2";
    String cyan     = "#8BE9FD";

    public String addColor(String keyword, String color){
        String res =  "<font color="+color+">"+keyword+"</font>";
        return res;
    }

    String def  =  addColor("def ",pink);
    String lpar =  addColor("(", yellow);
    String rpar =  addColor(")", yellow);
    String retu =  addColor("return ",pink);
    String main =  addColor("main",green);

    String plus =  addColor(" + ",pink);
    String minus =  addColor(" - ",pink);
    String div =  addColor(" / ",pink);
    String mult =  addColor(" * ",pink);
    String eq =  addColor(" = ",pink);

    String indent = "\t\t\t";

    String add2 = defName("add2");
    String dato1 = argName("dato1");
    String dato2 = argName("dato2");

    String br = "<br/>";
    String l1 = def + add2+lpar+dato1+","+dato2+rpar+":"+br;
    String l2 = indent + retu + " dato1 "+plus+" dato2"+br+br;
    String l3 = def + main+lpar+rpar+":"+br;
    String l4 = indent + "dato1"+eq+num("12")+br;
    String l5 = indent + "dato2"+eq+num("33")+br;
    String l6 = indent + add2+lpar+"dato1, dato2"+rpar+br;

    public String render(String[][] program,int pointer){
        String res = "";
        for(int i = 0; i<program[0].length;i++){
            if(program[0][i]==null){
                return res;
            }

            if(i==pointer){
                res+=highlight(program[0][i]);
            }else {
                res += program[0][i];
            }
        }
        return res;
    }

    public String defName(String s){
        String res = "<font color="+green+">"+s+"</font>";
        return res;
    }
    public String argName(String s){
        String res = "<font color="+orange+">"+s+"</font>";
        return res;
    }

    public String num(String s){
        String res = "<font color="+purple+">"+s+"</font>";
        return res;
    }

    public String highlight(String s){
        String res = "<span style=\"background-color:"+dusk+"\">"+s+"</span>";
        return res;
    }

    String[][] matrix = new String[2][20];
    int[] flow = {2,3,4,5,0,1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugger);

        TextView codeView = (TextView) findViewById(R.id.codeView);

        if(codeView != null){
            matrix[0][0] = l1;
            matrix[0][1] = l2;//return x+y
            matrix[0][2] = l3;//main
            matrix[0][3] = l4;//dato1
            matrix[0][4] = l5;//dato2
            matrix[0][5] = l6;

            matrix[1][0] = "";
            matrix[1][1] = "45\n";
            matrix[1][2] = "var"+indent+"value\n";
            matrix[1][3] = "dato1"+indent+"12\n";
            matrix[1][4] = "dato2"+indent+"33\n";
            matrix[1][5] = "  add2(12,33)\n";


        String text = render(matrix, -1);
        codeView.setText(Html.fromHtml(text));
    }
    }

    int start =  0;
    String disp = "";
    public void nextLine(View v){

        if(start>=flow.length){
            start=0;
            disp="";
        }

        disp += matrix[1][flow[start]];

        TextView bugText = (TextView) findViewById(R.id.bugText);
        bugText.setText(disp);
        TextView codeView = (TextView) findViewById(R.id.codeView);
        String text = render(matrix, flow[start]);
        codeView.setText(Html.fromHtml(text));

        start++;
    }


}