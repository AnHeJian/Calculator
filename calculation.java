package com.example.calculator3;

import java.util.Arrays;
import java.util.*;
import java.lang.Math;

class Calculation
{
    static int max=100;
    private char [] ex = new char[max];/*存储后缀表达式*/
    private char [] str = new char[max];  /*存储原算术表达式*/
    private char [] stack = new char[max]; /*作为栈使用*/
    private int sum,lk,rk;

    public boolean Isright;

    public Calculation(char m[])
    {
        if(m[0]=='+'||m[0]=='-'){
            sum = m.length+1;
            str[1]='0';
            int i=1;
            do
            {
                i++;
                str[i]=m[i-2];
            }while(i<sum);
            str[i+1]='#';}
        //首位是+-的情况

        else{
            sum=m.length;
            int i=0;
            do
            {
                i++;
                str[i]=m[i-1];
            }while(i<sum);
            str[i+1]='#';}
    }

    public void trans()  /*将算术表达式转化为后缀表达式*/
    {
        char ch;
        int i=1,t=1,top=0;
        lk=rk=0;
        ch=str[i];
        i++;   //
        while(ch!='#'){
            switch(ch)
            {
                case '(': /*判定为左括号*/
                    lk++;
                    top++;
                    stack[top]=ch;
                    break;
                case ')': /*判定为右括号*/
                    rk++;
                    while(stack[top]!='(')
                    {
                        ex[t]=stack[top];
                        top--;
                        t++;
                    }
                    top--;
                    break;
                case '+': /*判定为加减号*/
                case '-':
                    while(top!=0&&stack[top]!='(')
                    {
                        ex[t]=stack[top];
                        top--;
                        t++;
                    }
                    top++;
                    stack[top]=ch;
                    break;
                case '*': /*判定为乘除号*/
                case '/':
                    while(stack[top]=='*'||stack[top]=='/')
                    {
                        ex[t]=stack[top];
                        top--;
                        t++;
                    }
                    top++;
                    stack[top]=ch;
                    break;
                case '^':
                    while(stack[top]=='^')
                    {
                        ex[t]=stack[top];
                        top--;
                        t++;
                    }
                    top++;
                    stack[top]=ch;
                    break;
                case '~':
                    while(stack[top]=='~')
                    {
                        ex[t]=stack[top];
                        top--;
                        t++;
                    }
                    top++;
                    stack[top]=ch;
                    break;

                case ' ':break;
                default:
                    while((ch>='0'&&ch<='9')||ch=='.')
                    { /*判定为数字*/
                        ex[t]=ch;
                        t++;
                        ch=str[i];
                        i++;
                    }
                    i--;
                    ex[t]=' ';
                    t++;
            }
            ch=str[i];
            i++;
        }
        while(top!=0)
        {
            ex[t]=stack[top];
            t++;
            top--;
        }
        ex[t]=' ';
    }

    public double compvalue()/*计算后缀表达式的值*/
    {
        Isright=true;
        if(lk!=rk)
            Isright=false;//判断左括号是否等于右括号
        double []value = new double[max]; /*作为栈使用*/
        double d;
        char ch;
        int t=1,top=0; /*t为ex下标，top为stack下标*/
        ch=ex[t];
        t++;
        while(ch!=' '){
            switch(ch){
                case '+':
                    if(top>=2){
                        value[top-1]=value[top-1]+value[top];
                        top--;
                        break;}
                    else{
                        Isright=false;
                        return 0;}

                case '-':
                    if(top>=2){
                        value[top-1]=value[top-1]-value[top];
                        top--;
                        break;}
                    else{
                        Isright=false;
                        return 0;}
                case '*':
                    if(top>=2){
                        value[top-1]=value[top-1]*value[top];
                        top--;
                        break;}
                    else{
                        Isright=false;
                        return 0;}
                case '/':
                    if(top>=2){
                        if(value[top]!=0)
                            value[top-1]=value[top-1]/value[top];
                        else{
                            Isright=false;
                            return 0;}
                        top--;
                        break; }
                    else{
                        Isright=false;
                        return 0;}
                case '^':
                    if(top>=2){
                        value[top-1]=Math.pow(value[top-1],value[top]);
                        top--;
                        break;}
                    else{
                        Isright=false;
                        return 0;}
                case '~':
                    if(top>=1){
                        value[top]=0-value[top];
                        break;}
                    else{
                        Isright=false;
                        return 0;}

                default:
                    d=0;
                    double x=1;
                    while((ch>='0'&&ch<='9')||ch=='.')
                    {
                        while(ch>='0'&&ch<='9'){
                            d=10*d+ch-'0';
                            ch=ex[t];t++; }
                        if(ch=='.'){
                            ch=ex[t];t++;
                            while(ch>='0'&&ch<='9'){
                                int a=ch-'0';
                                d+=a*Math.pow(0.1,x++);
                                ch=ex[t];t++; }
                        }
                    } /*将数字字符转化为对应的数值*/

                    top++;
                    value[top]=d;
            }
            ch=ex[t];
            t++;
        }
        return value[top];
    }

}