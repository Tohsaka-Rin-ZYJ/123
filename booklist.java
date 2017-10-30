#include<iostream>
#include<string.h>
#include<fstream>
#include<strstream>
#include<sstream>
using namespace std;


class Book{    //定义类;
	public:
	char name[80];
	char auther[80];
	int num;
	void out(){    //定义一个输出函数 
		cout<<"书名："<<name<<" "<<"作者："<<auther<<" "<<"数量："<<num<<endl; 
	} 
}; 

Book booklist[20];    //定义暂时存储数据的数组

int locatel() {    //寻找数组中空位的函数
    int z=0;
	while(z<20){
		if(booklist[z].name[0]=='n'&&booklist[z].name[1]=='u'&&booklist[z].name[2]=='1'&&booklist[z].name[3]=='1'){
			return z;    //如果书名为null表示当前是空位，返回此位置 
		}
		else{
			z++;
		} 
	} 
}

int locate2(char m[80],char n[80]){    //依据书名和作者寻找书的位置 
	int a=0;
	while(a<20){
		if(strcmp(n,booklist[a].auther)==0&&strcmp(m,booklist[a].name)==0){
			return a;
			break;    //若书名和作者均符合，返回此位置并跳出 
		} 
		else{
			a++;
		} 
	} 
	if(a==20){
		return 20;
	}
}

int locate3(char m[80]){    //依据书名寻找书的位置
    int a=0;
	while(a<20){
		if(strcmp(m,booklist[a].name)==0){
			return a;    //书名相同返回此位置
			break; 
		}
		else{
			a++;
		}
	} 
	if(a==20){
		return 20;
	}
}

void search(){
	void menu();
	system("cls");
	cout<<"请输入要查询的书名：（空格用下划线代替）"<<endl;
	char temp[80];
	cin>>temp;
	system("cls");
	for(int d=0;d<20;d++){
		if(strcmp(temp,booklist[d].name)==0)
			booklist[d].out();
	}
	int f=locate3(temp);
	if(f=20){
		system("cls");
		cout<<"书库中无此图书！"<<endl;
	}
	cout<<"按回车返回主菜单：";
	char cn;
	cin.get(cn);
	cin.get(cn);
	if(cn=='\n'){
		menu();
	} 
}

void borrow(){    //借书函数 
	void menu();
	system("cls");
	if(booklist[0].name[0]=='n'&&booklist[0].name[1]=='u'&&booklist[0].name[2]=='1'&&booklist[0].name[3]=='1'){
		cout<<"库中无此图书，暂不能借书！\n";
	}
	else{
		system("cls");
		char m[80],n[80];
		cout<<"请输入要借阅的书名：（空格用下划线代替）"<<endl;
		cin>>m;
		cout<<"请输入要借阅的书的作者：（空格用下划线代替）"<<endl;
		cin>>n;
		int l=locate2(m,n);
		if(l=20){
			cout<<"书库中无此书！"<<endl;
		}
		else{
			if(booklist[1].num==0){
				system("cls");
				cout<<"抱歉，该书全部借出！"<<endl;
			}
			else{
				booklist[1].num--;
				system("cls");
				cout<<"借书成功！"<<endl;
			}
		}
	}
	cout<<"继续借阅吗？\n输入任意值退出，按回车继续借阅：";
	char cn;
	cin.get(cn);
	cin.get(cn);
	if(cn=='\n'){
		borrow();
	}
	else{
		menu();
	}
}

void menu()
{
	void manage();
	
	char choice;
	cin>>choice;
	choice=tolower(choice);
	switch(choice){
		case '1':
		    search(); 
		    break;
		case '2':
		    borrow();
		    break;
	}    
}
