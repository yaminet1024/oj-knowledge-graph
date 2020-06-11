package cn.yaminets.ojknowledgegraph.pojo.node;

import java.util.List;

public class ProblemPojo {


    /**
     * code : 200
     * currentTemplate : ProblemSolution
     * currentData : {"solutions":{"result":[{"content":"明显的字典树\n\n以每个数字建立字典树\n\n建立一次查询一次\n\nspj正负 下面上代码\n\n```cpp\n#include<cstdio>\n#include<cstring>\n#include<cstdlib>\n#include<algorithm>\nusing namespace std;\nstruct node{\n    int str[26];\n    int sum;\n}s[1000];\nchar str1[100];\nint t=0,tot=0,ss=0;\nbool f1;\nvoid built()\n{\n    t=0;\n    for(int i=0;i<strlen(str1);i++)\n    {\n         if(str1[i]=='-'){\n             f1=true;continue;\n         }\n         if(!s[t].str[str1[i]-'0'])\n         s[t].str[str1[i]-'0']=++tot;\n         t=s[t].str[str1[i]-'0'];\n         s[t].sum=str1[i]-'0';\n    }\n}\nint query()\n{\n   int t=0;int s1=0;\n   for(int i=0;i<strlen(str1);i++)\n   {\n           if(str1[i]=='-') continue;\n           if(!s[t].str[str1[i]-'0']) return s1;\n           t=s[t].str[str1[i]-'0'];\n           s1=s1*10+s[t].sum;\n   }\n   return s1;\n}\nint main()\n{    \n  for(int i=1;i<=2;i++)\n  {\n      f1=false;\n      scanf(\"%s\",str1);\n    built();\n    if(f1)\n      ss-=query();\n      else ss+=query();\n  }\n  printf(\"%d\",ss);\n  return 0;    \n}\n```","type":"题解","status":2,"postTime":1477879617,"author":{"uid":25215,"name":"Linbom","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":55,"commentCount":50,"currentUserVoteType":0,"contentDescription":"明显的字典树\n以每个数字建立字典树\n建立一次查询一次\nspj正负 下面上代码\n","id":793,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"这里用到了Scanner类，这个类是SDK1.5新增的一个类，它可以直接输入整型数据，不像JAVA其他从键盘输入的方法只能输入字符或字符串，非常方便。\n\n另外，在线IDE，不能用package，如果有这行的话程序会RE，而且JAVA的public类一定要为Main，可能它的文件名就是\u201cMain\u201d，这些不仅是洛谷在线IDE要求的，同时也是PAT、ACM等程序设计竞赛所要求的。\n\n```java\nimport java.util.Scanner;  \n  \npublic class Main { \n    \nprivate static Scanner sc;\npublic static void main(String[] args) {\n    Scanner(0);\n} \npublic static void Scanner(int sum){ \n    sc = new Scanner(System.in); \n    int a = sc.nextInt();\n    int b = sc.nextInt();\n    int c;\n    c = a + b;\n    System.out.println(c); \n\t} \n}\n```","type":"题解","status":2,"postTime":1538276336,"author":{"uid":108673,"name":"Luminous107","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":55,"commentCount":27,"currentUserVoteType":0,"contentDescription":"这里用到了Scanner类，这个类是SDK1.5新增的一个类，它可以直接输入整型数据，不像JAVA其他从键盘输入的方法只能输入字符或字符串，非常方便。\n另外，在线IDE，不能用package，如...","id":71696,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"最小生成树最好了\n\n```cpp\n#include <cstdio>\n#include <algorithm>\n#define INF 2140000000\nusing namespace std;\nstruct tree{int x,y,t;}a[10];\nbool cmp(const tree&a,const tree&b){return a.t<b.t;}\nint f[11],i,j,k,n,m,x,y,t,ans;\nint root(int x){if (f[x]==x) return x;f[x]=root(f[x]);return f[x];}\nint main(){\n    for (i=1;i<=10;i++) f[i]=i;\n    for (i=1;i<=2;i++){\n        scanf(\"%d\",&a[i].t);\n        a[i].x=i+1;a[i].y=1;k++;\n    }\n    a[++k].x=1;a[k].y=3,a[k].t=INF;\n    sort(a+1,a+1+k,cmp);\n    for (i=1;i<=k;i++){\n    //    printf(\"%d %d %d %d\\n\",k,a[i].x,a[i].y,a[i].t);\n        x=root(a[i].x);y=root(a[i].y);\n        if (x!=y) f[x]=y,ans+=a[i].t; \n    }\n    printf(\"%d\\n\",ans);\n}\n```","type":"题解","status":2,"postTime":1470026485,"author":{"uid":19864,"name":"Acheing","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Blue","ccfLevel":0},"thumbUp":49,"commentCount":28,"currentUserVoteType":0,"contentDescription":"最小生成树最好了\n","id":786,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"看了这么久至今没有看到Python的题解，让我来一发。\n\n    string=input()\n\n    print(int(string.split(\" \")[0])+int(string.split(\" \")[1]))\n\nPython万能的运算看起来比C++的的算法要简单得多。但我看见过很多人用Python成功RE爆零的，原因是Python在一行上检测到空格时不会将前面的内容储存进变量，而是会将一整行内容转成字符串，自然会RE。本方法是将输入先以字符串格式读入变量string，再以空格为依据用split()函数进行分片，产生一个字符型的列表，再用int()函数将两个字符转为数，相加，再输出它们的和。\n","type":"题解","status":2,"postTime":1513831158,"author":{"uid":72413,"name":"蒟蒻南瓜","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":43,"commentCount":14,"currentUserVoteType":0,"contentDescription":"看了这么久至今没有看到Python的题解，让我来一发。\n\nPython万能的运算看起来比C++的的算法要简单得多。但我看见过很多人用Python成功RE爆零的，原因是Python在一行上检测到空...","id":19296,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"各位大神都用网络流啊 最短路啊解这道题，那么既然是可以求最短路，为什么不可以从树上跑呢？\n\n怀着这种想法，我冥思苦想（划掉），发现，###我可以用LCA做这道题啊~\n\n然而鄙人不才，什么Tarjan啊ST表啊都不会，只会用一个倍增来求LCA，所以权当抛砖引玉吧。\n\n不过我估计应该没什么想学LCA的来这道题看LCA题解吧。所以多半是写着玩~~\n\n###先说说思路（这还用说？）：\n\n###建一个有三个节点的树，1为树根，2 3分别是左右儿子。\n\n###其中1 2之间的距离为a,2 3之间的距离为b，然后求1 2的LCA，和分别到LCA的距离，加起来就是1->3的最短路\n\n###其实就是题目中所求的a+b了\n\n好吧闲话不说 上代码了（多半是个LCA的板子了）：\n\n```cpp\n#include<cstdio>                                                  //头文件\n#define NI 2                                                          \n//从来不喜欢算log所以一般用常数 不知道算不算坏习惯 因为3个节点 所以log3(当然以2为底)上取整得2\nstruct edge\n{\n    int to,next,data;                                              //分别表示边的终点，下一条边的编号和边的权值\n}e[30];                                                                     //邻接表，点少边少开30是为了浪啊\nint v[10],d[10],lca[10][NI+1],f[10][NI+1],tot=0;      //数组开到10依然为了浪\n//数组还解释嘛，v表示第一条边在邻接表中的编号，d是深度，lca[x][i]表示x向上跳2^i的节点，f[x][i]表示x向上跳2^i的距离和\nvoid build(int x,int y,int z)                                      //建边\n{\n    e[++tot].to=y; e[tot].data=z; e[tot].next=v[x]; v[x]=tot;\n    e[++tot].to=x; e[tot].data=z; e[tot].next=v[y]; v[y]=tot;\n}\nvoid dfs(int x)                                                        //递归建树\n{\n    for(int i=1;i<=NI;i++)                                   //懒，所以常数懒得优化\n        f[x][i]=f[x][i-1]+f[lca[x][i-1]][i-1],\n        lca[x][i]=lca[lca[x][i-1]][i-1];                   //建树的同时进行预处理\n    for(int i=v[x];i;i=e[i].next)                              //遍历每个连接的点\n    {\n        int y=e[i].to;\n        if(lca[x][0]==y) continue;\n        lca[y][0]=x;                                       //小技巧：lca[x][0]即为x的父亲~~（向上跳2^0=1不就是父节点嘛）\n        f[y][0]=e[i].data;\n        d[y]=d[x]+1;\n        dfs(y);                                            //再以这个节点为根建子树【这里真的用得到嘛？？】\n    }\n}\nint ask(int x,int y)                                             //询问，也是关键\n{                                                                        \n    if(d[x]<d[y]) {int t=x;x=y;y=t;}                  //把x搞成深的点\n    int k=d[x]-d[y],ans=0;\n    for(int i=0;i<=NI;i++)\n        if(k&(1<<i))                                      //若能跳就把x跳一跳\n            ans+=f[x][i],                              //更新信息\n            x=lca[x][i];\n    for(int i=NI;i>=0;i--)                                  //不知道能不能正着循环，好像倒着优，反正记得倒着就好了\n        if(lca[x][i]!=lca[y][i])                            //如果x跳2^i和y跳2^j没跳到一起就让他们跳\n            ans+=f[x][i]+f[y][i],\n            x=lca[x][i],y=lca[y][i];\n    return ans+f[x][0]+f[y][0];                           //跳到LCA上去（每步跳的时候都要更新信息，而且要在跳之前更新信息哦~）\n}\nint main()\n{\n    int a,b;\n    scanf(\"%d%d\",&a,&b);\n    build(1,2,a);\n    build(1,3,b);                                                       //分别建1 2、1 3之间的边\n    dfs(1);                                                                //以1为根建树\n    printf(\"%d\",ask(2,3));                                         //求解2 3到它们的LCA的距离和并输出\n}\n```\nBINGO~~\n","type":"题解","status":2,"postTime":1478782006,"author":{"uid":18455,"name":"Enzymii","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Blue","ccfLevel":0},"thumbUp":34,"commentCount":33,"currentUserVoteType":0,"contentDescription":"各位大神都用网络流啊 最短路啊解这道题，那么既然是可以求最短路，为什么不可以从树上跑呢？\n怀着这种想法，我冥思苦想（划掉），发现，###我可以用LCA做这道题啊~\n然而鄙人不才，什么Tarjan...","id":794,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"## 发布一个Scala的版本\n\n```\nimport scala.io._\nobject Test\n{\n    def main(args: Array[String])\n    {\n        val a = StdIn.readInt()\n        val b = StdIn.readInt()\n        println(a+b)\n    }\n}\n```","type":"题解","status":2,"postTime":1543731555,"author":{"uid":48993,"name":"liuyifan","slogan":"退役啦qwq","badge":null,"isAdmin":false,"isBanned":false,"color":"Blue","ccfLevel":0},"thumbUp":27,"commentCount":66,"currentUserVoteType":0,"contentDescription":"发布一个Scala的版本\n","id":93141,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"二进制下的a+b。如果有重复，请无视，如果没有，删了这句话\n\n```cpp\n#include<iostream>\n#include<cstdio>\n#include<cstdlib>\n#include<cmath>\n#include<algorithm>\nusing namespace std;\nint main()\n{\n    int a,b,s=0,s1=0,i=0,na=0,nb=0;\n    cin>>a>>b;\n    if(a<=0) na=1,a*=-1;\n    while(a!=0)\n    {\n        if(a%2!=0)\n        s+=pow(2,a%2*i);\n        a/=2;\n        i++;\n    }\n    i=0;\n    if(na==1) s*=-1;\n    if(b<=0) nb=1,b*=-1;\n    while(b!=0)\n    {\n        if(b%2!=0)\n        s1+=pow(2,b%2*i);\n        b/=2;\n        i++;\n    }\n    if(nb==1) s1*=-1;\n    cout<<s+s1;;\n    return 0;\n}\n```","type":"题解","status":2,"postTime":1485185452,"author":{"uid":23394,"name":"jacky_chen","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":26,"commentCount":63,"currentUserVoteType":0,"contentDescription":"二进制下的a+b。如果有重复，请无视，如果没有，删了这句话\n","id":800,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"#P1001题解大神多啊- -然而我写了一个高精模板类#\n\n#include <bits/stdc++.h>\n\nusing namespace std;\n\nclass cint{ //定义一个类\n\nprivate:\n\nint c\\_number[100001],c\\_len,c\\_d,c\\_fh; //属性,包括数字,长度,进制,符号\n\npublic:\n\n\n```cpp\n        cint(); \n        ~cint();\n        cint(int x); \n        cint(string st); //构造与析构函数\n        cint operator+(cint& b); //重载+,以用于更方便地运算\n        cint read_cint(); //读入\n        void write_cint(); //输出\n};\ncint::cint()\n{\n    c_d=10;\n}\ncint::~cint()\n{\n}\ncint::cint(int x)\n{\n    c_d=10;\n    if (x<0)\n    {\n        c_fh=-1;\n        x=-x;\n    }\n    else c_fh=1;\n    c_len=0;\n    while (x)\n    {\n        c_len++;\n        c_number[c_len]=x%c_d;\n        x/=c_d;\n    }\n}\ncint::cint (string st)\n{\n    int i;\n    if (st[0]=='-') \n    {\n        c_fh=-1;\n        st.erase(0,1);\n    }\n    else c_fh=1;\n    while (st[0]=='0'&&st.length()>1)\n        st.erase(0,1); //去除前导0\n    c_len=st.length();\n    for (i=1;i<=c_len;i++)\n        c_number[i]=(st[c_len-i]-48)*c_fh; //将字符的ascii码-48,存入数组中\n} //构造函数,将字符串存入类中\ncint cint::operator+(cint& b)\n{\n    int i;\n    cint c;\n    if (c_len>=b.c_len) c.c_len=c_len;\n    else c.c_len=b.c_len;\n    for (i=1;i<=c.c_len;i++)\n    {\n        c.c_number[i]+=c_number[i]+b.c_number[i]; //将两位相加\n        c.c_number[i+1]=c.c_number[i]/c.c_d;\n        c.c_number[i]%=c.c_d; //处理进位\n    }\n    while (c.c_number[c.c_len+1])\n        c.c_len++;\n    return c;\n} //核心部分,高精加\ncint cint::read_cint()\n{\n    string st;\n    cin>>st;\n    return cint(st);\n}\nvoid cint::write_cint()\n{\n    int i;\n    for (i=1;i<=c_len;i++)\n        cout<<c_number[c_len-i+1]; //输出部分,很容易理解\n}\nistream& operator>>(istream& is,cint &c)\n{\n    c=c.read_cint();\n    return is;\n} //重载>>,便于输入\nostream& operator<<(ostream& os,cint c)\n{\n    c.write_cint();\n    return os;\n} //重载<<,便于输出.\n```\n##下面是美丽的主程序##\n\n```cpp\nint main()\n{\n    cint a,b;\n    cin>>a>>b;\n    cout<<a+b<<endl;\n}\n```","type":"题解","status":1,"postTime":1481345394,"author":{"uid":22132,"name":"little_gift","slogan":"没有未来的未来不是我想要的未来","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":25,"commentCount":63,"currentUserVoteType":0,"contentDescription":"P1001题解大神多啊- -然而我写了一个高精模板类\ninclude &lt;bits/stdc++.h&gt;\nusing namespace std;\nclass cint{ //定义一个类...","id":797,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"看楼下也有位运算，用递归做的，我就贴个非递归的吧。。。\n\n```cpp\n#include <cstdio>\nint m, n;\nint main()\n{\n    scanf(\"%d%d\", &m, &n);\n    int u = m & n;\n    int v = m ^ n;\n    while (u) {\n        int s = v;\n        int t = u << 1;\n        u = s & t;\n        v = s ^ t;\n    }\n    printf(\"%d\\n\", v);\n}\n```","type":"题解","status":2,"postTime":1479216185,"author":{"uid":27965,"name":"zhjian","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":25,"commentCount":19,"currentUserVoteType":0,"contentDescription":"看楼下也有位运算，用递归做的，我就贴个非递归的吧。。。\n","id":795,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"5ms , 1371kb\n\n线段树走起\n\n附上在下65行线段树代码\n\n```cpp\n#include<cstdio>\n#include<algorithm>\n#include<cstdlib>\n#include<cmath>\n#include<cstring>\n#include<iostream>\nusing namespace std;\nstruct node{\n    int val,l,r;\n};\nnode t[5];\nint a[5],f[5];\nint n,m;\nvoid init(){\n    for(int i=1;i<=2;i++){\n        scanf(\"%d\",&a[i]);\n    }\n}\nvoid build(int l,int r,int node){//这是棵树\n    t[node].l=l;t[node].r=r;t[node].val=0;\n    if(l==r){\n        f[l]=node;\n        t[node].val=a[l];\n        return;\n    }\n    int mid=(l+r)>>1;\n    build(l,mid,node*2);\n    build(mid+1,r,node*2+1);\n    t[node].val=t[node*2].val+t[node*2+1].val;\n}\nvoid update(int node){\n    if(node==1)return;\n    int fa=node>>1;\n    t[fa].val=t[fa*2].val+t[fa*2+1].val;\n    update(fa);\n}\nint find(int l,int r,int node){\n    if(t[node].l==l&&t[node].r==r){\n        return t[node].val;\n    }\n    int sum=0;\n    int lc=node*2;int rc=lc+1;\n    if(t[lc].r>=l){\n        if(t[lc].r>=r){\n            sum+=find(l,r,lc);\n        }\n        else{\n            sum+=find(l,t[lc].r,lc);\n        }\n    }\n    if(t[rc].l<=r){\n        if(t[rc].l<=l){\n            sum+=find(l,r,rc);\n        }\n        else{\n            sum+=find(t[rc].l,r,rc);\n        }\n    }\n    return sum;\n}\nint main(){\n    init();\n    build(1,2,1);\n    printf(\"%d\",find(1,2,1));\n}\n```","type":"题解","status":2,"postTime":1473245426,"author":{"uid":10025,"name":"神一般的世界","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":25,"commentCount":35,"currentUserVoteType":0,"contentDescription":"5ms , 1371kb\n线段树走起\n附上在下65行线段树代码\n","id":788,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"}],"perPage":10,"count":27},"problem":{"pid":"P1001","title":"A+B Problem","difficulty":1,"fullScore":100,"type":"P"},"acceptSolution":false}
     * currentTitle : 题解
     * currentTheme : {"id":1,"header":{"imagePath":null,"color":[[35,37,38,1],[65,67,69,1]],"blur":0,"brightness":0,"degree":90,"repeat":0,"position":[50,50],"size":[0,0],"type":2,"__CLASS_NAME":"Luogu\\DataClass\\User\\ThemeConfig\\HeaderFooterConfig"},"sideNav":{"logoBackgroundColor":[52,152,219,1],"color":[52,73,94,1],"invertColor":false,"__CLASS_NAME":"Luogu\\DataClass\\User\\ThemeConfig\\SideNavConfig"},"footer":{"imagePath":null,"color":[[51,51,51,1]],"blur":0,"brightness":0,"degree":0,"repeat":0,"position":[0,0],"size":[0,0],"type":2,"__CLASS_NAME":"Luogu\\DataClass\\User\\ThemeConfig\\HeaderFooterConfig"}}
     * currentUser : {"blogAddress":null,"followingCount":0,"followerCount":0,"ranking":null,"unreadMessageCount":0,"unreadNoticeCount":0,"verified":true,"uid":349784,"name":"yami1574150143","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0}
     */

    private int code;
    private String currentTemplate;
    private CurrentDataBean currentData;
    private String currentTitle;
    private CurrentThemeBean currentTheme;
    private CurrentUserBean currentUser;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(String currentTemplate) {
        this.currentTemplate = currentTemplate;
    }

    public CurrentDataBean getCurrentData() {
        return currentData;
    }

    public void setCurrentData(CurrentDataBean currentData) {
        this.currentData = currentData;
    }

    public String getCurrentTitle() {
        return currentTitle;
    }

    public void setCurrentTitle(String currentTitle) {
        this.currentTitle = currentTitle;
    }

    public CurrentThemeBean getCurrentTheme() {
        return currentTheme;
    }

    public void setCurrentTheme(CurrentThemeBean currentTheme) {
        this.currentTheme = currentTheme;
    }

    public CurrentUserBean getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUserBean currentUser) {
        this.currentUser = currentUser;
    }

    public static class CurrentDataBean {
        /**
         * solutions : {"result":[{"content":"明显的字典树\n\n以每个数字建立字典树\n\n建立一次查询一次\n\nspj正负 下面上代码\n\n```cpp\n#include<cstdio>\n#include<cstring>\n#include<cstdlib>\n#include<algorithm>\nusing namespace std;\nstruct node{\n    int str[26];\n    int sum;\n}s[1000];\nchar str1[100];\nint t=0,tot=0,ss=0;\nbool f1;\nvoid built()\n{\n    t=0;\n    for(int i=0;i<strlen(str1);i++)\n    {\n         if(str1[i]=='-'){\n             f1=true;continue;\n         }\n         if(!s[t].str[str1[i]-'0'])\n         s[t].str[str1[i]-'0']=++tot;\n         t=s[t].str[str1[i]-'0'];\n         s[t].sum=str1[i]-'0';\n    }\n}\nint query()\n{\n   int t=0;int s1=0;\n   for(int i=0;i<strlen(str1);i++)\n   {\n           if(str1[i]=='-') continue;\n           if(!s[t].str[str1[i]-'0']) return s1;\n           t=s[t].str[str1[i]-'0'];\n           s1=s1*10+s[t].sum;\n   }\n   return s1;\n}\nint main()\n{    \n  for(int i=1;i<=2;i++)\n  {\n      f1=false;\n      scanf(\"%s\",str1);\n    built();\n    if(f1)\n      ss-=query();\n      else ss+=query();\n  }\n  printf(\"%d\",ss);\n  return 0;    \n}\n```","type":"题解","status":2,"postTime":1477879617,"author":{"uid":25215,"name":"Linbom","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":55,"commentCount":50,"currentUserVoteType":0,"contentDescription":"明显的字典树\n以每个数字建立字典树\n建立一次查询一次\nspj正负 下面上代码\n","id":793,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"这里用到了Scanner类，这个类是SDK1.5新增的一个类，它可以直接输入整型数据，不像JAVA其他从键盘输入的方法只能输入字符或字符串，非常方便。\n\n另外，在线IDE，不能用package，如果有这行的话程序会RE，而且JAVA的public类一定要为Main，可能它的文件名就是\u201cMain\u201d，这些不仅是洛谷在线IDE要求的，同时也是PAT、ACM等程序设计竞赛所要求的。\n\n```java\nimport java.util.Scanner;  \n  \npublic class Main { \n    \nprivate static Scanner sc;\npublic static void main(String[] args) {\n    Scanner(0);\n} \npublic static void Scanner(int sum){ \n    sc = new Scanner(System.in); \n    int a = sc.nextInt();\n    int b = sc.nextInt();\n    int c;\n    c = a + b;\n    System.out.println(c); \n\t} \n}\n```","type":"题解","status":2,"postTime":1538276336,"author":{"uid":108673,"name":"Luminous107","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":55,"commentCount":27,"currentUserVoteType":0,"contentDescription":"这里用到了Scanner类，这个类是SDK1.5新增的一个类，它可以直接输入整型数据，不像JAVA其他从键盘输入的方法只能输入字符或字符串，非常方便。\n另外，在线IDE，不能用package，如...","id":71696,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"最小生成树最好了\n\n```cpp\n#include <cstdio>\n#include <algorithm>\n#define INF 2140000000\nusing namespace std;\nstruct tree{int x,y,t;}a[10];\nbool cmp(const tree&a,const tree&b){return a.t<b.t;}\nint f[11],i,j,k,n,m,x,y,t,ans;\nint root(int x){if (f[x]==x) return x;f[x]=root(f[x]);return f[x];}\nint main(){\n    for (i=1;i<=10;i++) f[i]=i;\n    for (i=1;i<=2;i++){\n        scanf(\"%d\",&a[i].t);\n        a[i].x=i+1;a[i].y=1;k++;\n    }\n    a[++k].x=1;a[k].y=3,a[k].t=INF;\n    sort(a+1,a+1+k,cmp);\n    for (i=1;i<=k;i++){\n    //    printf(\"%d %d %d %d\\n\",k,a[i].x,a[i].y,a[i].t);\n        x=root(a[i].x);y=root(a[i].y);\n        if (x!=y) f[x]=y,ans+=a[i].t; \n    }\n    printf(\"%d\\n\",ans);\n}\n```","type":"题解","status":2,"postTime":1470026485,"author":{"uid":19864,"name":"Acheing","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Blue","ccfLevel":0},"thumbUp":49,"commentCount":28,"currentUserVoteType":0,"contentDescription":"最小生成树最好了\n","id":786,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"看了这么久至今没有看到Python的题解，让我来一发。\n\n    string=input()\n\n    print(int(string.split(\" \")[0])+int(string.split(\" \")[1]))\n\nPython万能的运算看起来比C++的的算法要简单得多。但我看见过很多人用Python成功RE爆零的，原因是Python在一行上检测到空格时不会将前面的内容储存进变量，而是会将一整行内容转成字符串，自然会RE。本方法是将输入先以字符串格式读入变量string，再以空格为依据用split()函数进行分片，产生一个字符型的列表，再用int()函数将两个字符转为数，相加，再输出它们的和。\n","type":"题解","status":2,"postTime":1513831158,"author":{"uid":72413,"name":"蒟蒻南瓜","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":43,"commentCount":14,"currentUserVoteType":0,"contentDescription":"看了这么久至今没有看到Python的题解，让我来一发。\n\nPython万能的运算看起来比C++的的算法要简单得多。但我看见过很多人用Python成功RE爆零的，原因是Python在一行上检测到空...","id":19296,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"各位大神都用网络流啊 最短路啊解这道题，那么既然是可以求最短路，为什么不可以从树上跑呢？\n\n怀着这种想法，我冥思苦想（划掉），发现，###我可以用LCA做这道题啊~\n\n然而鄙人不才，什么Tarjan啊ST表啊都不会，只会用一个倍增来求LCA，所以权当抛砖引玉吧。\n\n不过我估计应该没什么想学LCA的来这道题看LCA题解吧。所以多半是写着玩~~\n\n###先说说思路（这还用说？）：\n\n###建一个有三个节点的树，1为树根，2 3分别是左右儿子。\n\n###其中1 2之间的距离为a,2 3之间的距离为b，然后求1 2的LCA，和分别到LCA的距离，加起来就是1->3的最短路\n\n###其实就是题目中所求的a+b了\n\n好吧闲话不说 上代码了（多半是个LCA的板子了）：\n\n```cpp\n#include<cstdio>                                                  //头文件\n#define NI 2                                                          \n//从来不喜欢算log所以一般用常数 不知道算不算坏习惯 因为3个节点 所以log3(当然以2为底)上取整得2\nstruct edge\n{\n    int to,next,data;                                              //分别表示边的终点，下一条边的编号和边的权值\n}e[30];                                                                     //邻接表，点少边少开30是为了浪啊\nint v[10],d[10],lca[10][NI+1],f[10][NI+1],tot=0;      //数组开到10依然为了浪\n//数组还解释嘛，v表示第一条边在邻接表中的编号，d是深度，lca[x][i]表示x向上跳2^i的节点，f[x][i]表示x向上跳2^i的距离和\nvoid build(int x,int y,int z)                                      //建边\n{\n    e[++tot].to=y; e[tot].data=z; e[tot].next=v[x]; v[x]=tot;\n    e[++tot].to=x; e[tot].data=z; e[tot].next=v[y]; v[y]=tot;\n}\nvoid dfs(int x)                                                        //递归建树\n{\n    for(int i=1;i<=NI;i++)                                   //懒，所以常数懒得优化\n        f[x][i]=f[x][i-1]+f[lca[x][i-1]][i-1],\n        lca[x][i]=lca[lca[x][i-1]][i-1];                   //建树的同时进行预处理\n    for(int i=v[x];i;i=e[i].next)                              //遍历每个连接的点\n    {\n        int y=e[i].to;\n        if(lca[x][0]==y) continue;\n        lca[y][0]=x;                                       //小技巧：lca[x][0]即为x的父亲~~（向上跳2^0=1不就是父节点嘛）\n        f[y][0]=e[i].data;\n        d[y]=d[x]+1;\n        dfs(y);                                            //再以这个节点为根建子树【这里真的用得到嘛？？】\n    }\n}\nint ask(int x,int y)                                             //询问，也是关键\n{                                                                        \n    if(d[x]<d[y]) {int t=x;x=y;y=t;}                  //把x搞成深的点\n    int k=d[x]-d[y],ans=0;\n    for(int i=0;i<=NI;i++)\n        if(k&(1<<i))                                      //若能跳就把x跳一跳\n            ans+=f[x][i],                              //更新信息\n            x=lca[x][i];\n    for(int i=NI;i>=0;i--)                                  //不知道能不能正着循环，好像倒着优，反正记得倒着就好了\n        if(lca[x][i]!=lca[y][i])                            //如果x跳2^i和y跳2^j没跳到一起就让他们跳\n            ans+=f[x][i]+f[y][i],\n            x=lca[x][i],y=lca[y][i];\n    return ans+f[x][0]+f[y][0];                           //跳到LCA上去（每步跳的时候都要更新信息，而且要在跳之前更新信息哦~）\n}\nint main()\n{\n    int a,b;\n    scanf(\"%d%d\",&a,&b);\n    build(1,2,a);\n    build(1,3,b);                                                       //分别建1 2、1 3之间的边\n    dfs(1);                                                                //以1为根建树\n    printf(\"%d\",ask(2,3));                                         //求解2 3到它们的LCA的距离和并输出\n}\n```\nBINGO~~\n","type":"题解","status":2,"postTime":1478782006,"author":{"uid":18455,"name":"Enzymii","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Blue","ccfLevel":0},"thumbUp":34,"commentCount":33,"currentUserVoteType":0,"contentDescription":"各位大神都用网络流啊 最短路啊解这道题，那么既然是可以求最短路，为什么不可以从树上跑呢？\n怀着这种想法，我冥思苦想（划掉），发现，###我可以用LCA做这道题啊~\n然而鄙人不才，什么Tarjan...","id":794,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"## 发布一个Scala的版本\n\n```\nimport scala.io._\nobject Test\n{\n    def main(args: Array[String])\n    {\n        val a = StdIn.readInt()\n        val b = StdIn.readInt()\n        println(a+b)\n    }\n}\n```","type":"题解","status":2,"postTime":1543731555,"author":{"uid":48993,"name":"liuyifan","slogan":"退役啦qwq","badge":null,"isAdmin":false,"isBanned":false,"color":"Blue","ccfLevel":0},"thumbUp":27,"commentCount":66,"currentUserVoteType":0,"contentDescription":"发布一个Scala的版本\n","id":93141,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"二进制下的a+b。如果有重复，请无视，如果没有，删了这句话\n\n```cpp\n#include<iostream>\n#include<cstdio>\n#include<cstdlib>\n#include<cmath>\n#include<algorithm>\nusing namespace std;\nint main()\n{\n    int a,b,s=0,s1=0,i=0,na=0,nb=0;\n    cin>>a>>b;\n    if(a<=0) na=1,a*=-1;\n    while(a!=0)\n    {\n        if(a%2!=0)\n        s+=pow(2,a%2*i);\n        a/=2;\n        i++;\n    }\n    i=0;\n    if(na==1) s*=-1;\n    if(b<=0) nb=1,b*=-1;\n    while(b!=0)\n    {\n        if(b%2!=0)\n        s1+=pow(2,b%2*i);\n        b/=2;\n        i++;\n    }\n    if(nb==1) s1*=-1;\n    cout<<s+s1;;\n    return 0;\n}\n```","type":"题解","status":2,"postTime":1485185452,"author":{"uid":23394,"name":"jacky_chen","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":26,"commentCount":63,"currentUserVoteType":0,"contentDescription":"二进制下的a+b。如果有重复，请无视，如果没有，删了这句话\n","id":800,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"#P1001题解大神多啊- -然而我写了一个高精模板类#\n\n#include <bits/stdc++.h>\n\nusing namespace std;\n\nclass cint{ //定义一个类\n\nprivate:\n\nint c\\_number[100001],c\\_len,c\\_d,c\\_fh; //属性,包括数字,长度,进制,符号\n\npublic:\n\n\n```cpp\n        cint(); \n        ~cint();\n        cint(int x); \n        cint(string st); //构造与析构函数\n        cint operator+(cint& b); //重载+,以用于更方便地运算\n        cint read_cint(); //读入\n        void write_cint(); //输出\n};\ncint::cint()\n{\n    c_d=10;\n}\ncint::~cint()\n{\n}\ncint::cint(int x)\n{\n    c_d=10;\n    if (x<0)\n    {\n        c_fh=-1;\n        x=-x;\n    }\n    else c_fh=1;\n    c_len=0;\n    while (x)\n    {\n        c_len++;\n        c_number[c_len]=x%c_d;\n        x/=c_d;\n    }\n}\ncint::cint (string st)\n{\n    int i;\n    if (st[0]=='-') \n    {\n        c_fh=-1;\n        st.erase(0,1);\n    }\n    else c_fh=1;\n    while (st[0]=='0'&&st.length()>1)\n        st.erase(0,1); //去除前导0\n    c_len=st.length();\n    for (i=1;i<=c_len;i++)\n        c_number[i]=(st[c_len-i]-48)*c_fh; //将字符的ascii码-48,存入数组中\n} //构造函数,将字符串存入类中\ncint cint::operator+(cint& b)\n{\n    int i;\n    cint c;\n    if (c_len>=b.c_len) c.c_len=c_len;\n    else c.c_len=b.c_len;\n    for (i=1;i<=c.c_len;i++)\n    {\n        c.c_number[i]+=c_number[i]+b.c_number[i]; //将两位相加\n        c.c_number[i+1]=c.c_number[i]/c.c_d;\n        c.c_number[i]%=c.c_d; //处理进位\n    }\n    while (c.c_number[c.c_len+1])\n        c.c_len++;\n    return c;\n} //核心部分,高精加\ncint cint::read_cint()\n{\n    string st;\n    cin>>st;\n    return cint(st);\n}\nvoid cint::write_cint()\n{\n    int i;\n    for (i=1;i<=c_len;i++)\n        cout<<c_number[c_len-i+1]; //输出部分,很容易理解\n}\nistream& operator>>(istream& is,cint &c)\n{\n    c=c.read_cint();\n    return is;\n} //重载>>,便于输入\nostream& operator<<(ostream& os,cint c)\n{\n    c.write_cint();\n    return os;\n} //重载<<,便于输出.\n```\n##下面是美丽的主程序##\n\n```cpp\nint main()\n{\n    cint a,b;\n    cin>>a>>b;\n    cout<<a+b<<endl;\n}\n```","type":"题解","status":1,"postTime":1481345394,"author":{"uid":22132,"name":"little_gift","slogan":"没有未来的未来不是我想要的未来","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":25,"commentCount":63,"currentUserVoteType":0,"contentDescription":"P1001题解大神多啊- -然而我写了一个高精模板类\ninclude &lt;bits/stdc++.h&gt;\nusing namespace std;\nclass cint{ //定义一个类...","id":797,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"看楼下也有位运算，用递归做的，我就贴个非递归的吧。。。\n\n```cpp\n#include <cstdio>\nint m, n;\nint main()\n{\n    scanf(\"%d%d\", &m, &n);\n    int u = m & n;\n    int v = m ^ n;\n    while (u) {\n        int s = v;\n        int t = u << 1;\n        u = s & t;\n        v = s ^ t;\n    }\n    printf(\"%d\\n\", v);\n}\n```","type":"题解","status":2,"postTime":1479216185,"author":{"uid":27965,"name":"zhjian","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":25,"commentCount":19,"currentUserVoteType":0,"contentDescription":"看楼下也有位运算，用递归做的，我就贴个非递归的吧。。。\n","id":795,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"5ms , 1371kb\n\n线段树走起\n\n附上在下65行线段树代码\n\n```cpp\n#include<cstdio>\n#include<algorithm>\n#include<cstdlib>\n#include<cmath>\n#include<cstring>\n#include<iostream>\nusing namespace std;\nstruct node{\n    int val,l,r;\n};\nnode t[5];\nint a[5],f[5];\nint n,m;\nvoid init(){\n    for(int i=1;i<=2;i++){\n        scanf(\"%d\",&a[i]);\n    }\n}\nvoid build(int l,int r,int node){//这是棵树\n    t[node].l=l;t[node].r=r;t[node].val=0;\n    if(l==r){\n        f[l]=node;\n        t[node].val=a[l];\n        return;\n    }\n    int mid=(l+r)>>1;\n    build(l,mid,node*2);\n    build(mid+1,r,node*2+1);\n    t[node].val=t[node*2].val+t[node*2+1].val;\n}\nvoid update(int node){\n    if(node==1)return;\n    int fa=node>>1;\n    t[fa].val=t[fa*2].val+t[fa*2+1].val;\n    update(fa);\n}\nint find(int l,int r,int node){\n    if(t[node].l==l&&t[node].r==r){\n        return t[node].val;\n    }\n    int sum=0;\n    int lc=node*2;int rc=lc+1;\n    if(t[lc].r>=l){\n        if(t[lc].r>=r){\n            sum+=find(l,r,lc);\n        }\n        else{\n            sum+=find(l,t[lc].r,lc);\n        }\n    }\n    if(t[rc].l<=r){\n        if(t[rc].l<=l){\n            sum+=find(l,r,rc);\n        }\n        else{\n            sum+=find(t[rc].l,r,rc);\n        }\n    }\n    return sum;\n}\nint main(){\n    init();\n    build(1,2,1);\n    printf(\"%d\",find(1,2,1));\n}\n```","type":"题解","status":2,"postTime":1473245426,"author":{"uid":10025,"name":"神一般的世界","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":25,"commentCount":35,"currentUserVoteType":0,"contentDescription":"5ms , 1371kb\n线段树走起\n附上在下65行线段树代码\n","id":788,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"}],"perPage":10,"count":27}
         * problem : {"pid":"P1001","title":"A+B Problem","difficulty":1,"fullScore":100,"type":"P"}
         * acceptSolution : false
         */

        private SolutionsBean solutions;
        private ProblemBean problem;
        private boolean acceptSolution;

        public SolutionsBean getSolutions() {
            return solutions;
        }

        public void setSolutions(SolutionsBean solutions) {
            this.solutions = solutions;
        }

        public ProblemBean getProblem() {
            return problem;
        }

        public void setProblem(ProblemBean problem) {
            this.problem = problem;
        }

        public boolean isAcceptSolution() {
            return acceptSolution;
        }

        public void setAcceptSolution(boolean acceptSolution) {
            this.acceptSolution = acceptSolution;
        }

        public static class SolutionsBean {
            /**
             * result : [{"content":"明显的字典树\n\n以每个数字建立字典树\n\n建立一次查询一次\n\nspj正负 下面上代码\n\n```cpp\n#include<cstdio>\n#include<cstring>\n#include<cstdlib>\n#include<algorithm>\nusing namespace std;\nstruct node{\n    int str[26];\n    int sum;\n}s[1000];\nchar str1[100];\nint t=0,tot=0,ss=0;\nbool f1;\nvoid built()\n{\n    t=0;\n    for(int i=0;i<strlen(str1);i++)\n    {\n         if(str1[i]=='-'){\n             f1=true;continue;\n         }\n         if(!s[t].str[str1[i]-'0'])\n         s[t].str[str1[i]-'0']=++tot;\n         t=s[t].str[str1[i]-'0'];\n         s[t].sum=str1[i]-'0';\n    }\n}\nint query()\n{\n   int t=0;int s1=0;\n   for(int i=0;i<strlen(str1);i++)\n   {\n           if(str1[i]=='-') continue;\n           if(!s[t].str[str1[i]-'0']) return s1;\n           t=s[t].str[str1[i]-'0'];\n           s1=s1*10+s[t].sum;\n   }\n   return s1;\n}\nint main()\n{    \n  for(int i=1;i<=2;i++)\n  {\n      f1=false;\n      scanf(\"%s\",str1);\n    built();\n    if(f1)\n      ss-=query();\n      else ss+=query();\n  }\n  printf(\"%d\",ss);\n  return 0;    \n}\n```","type":"题解","status":2,"postTime":1477879617,"author":{"uid":25215,"name":"Linbom","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":55,"commentCount":50,"currentUserVoteType":0,"contentDescription":"明显的字典树\n以每个数字建立字典树\n建立一次查询一次\nspj正负 下面上代码\n","id":793,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"这里用到了Scanner类，这个类是SDK1.5新增的一个类，它可以直接输入整型数据，不像JAVA其他从键盘输入的方法只能输入字符或字符串，非常方便。\n\n另外，在线IDE，不能用package，如果有这行的话程序会RE，而且JAVA的public类一定要为Main，可能它的文件名就是\u201cMain\u201d，这些不仅是洛谷在线IDE要求的，同时也是PAT、ACM等程序设计竞赛所要求的。\n\n```java\nimport java.util.Scanner;  \n  \npublic class Main { \n    \nprivate static Scanner sc;\npublic static void main(String[] args) {\n    Scanner(0);\n} \npublic static void Scanner(int sum){ \n    sc = new Scanner(System.in); \n    int a = sc.nextInt();\n    int b = sc.nextInt();\n    int c;\n    c = a + b;\n    System.out.println(c); \n\t} \n}\n```","type":"题解","status":2,"postTime":1538276336,"author":{"uid":108673,"name":"Luminous107","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":55,"commentCount":27,"currentUserVoteType":0,"contentDescription":"这里用到了Scanner类，这个类是SDK1.5新增的一个类，它可以直接输入整型数据，不像JAVA其他从键盘输入的方法只能输入字符或字符串，非常方便。\n另外，在线IDE，不能用package，如...","id":71696,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"最小生成树最好了\n\n```cpp\n#include <cstdio>\n#include <algorithm>\n#define INF 2140000000\nusing namespace std;\nstruct tree{int x,y,t;}a[10];\nbool cmp(const tree&a,const tree&b){return a.t<b.t;}\nint f[11],i,j,k,n,m,x,y,t,ans;\nint root(int x){if (f[x]==x) return x;f[x]=root(f[x]);return f[x];}\nint main(){\n    for (i=1;i<=10;i++) f[i]=i;\n    for (i=1;i<=2;i++){\n        scanf(\"%d\",&a[i].t);\n        a[i].x=i+1;a[i].y=1;k++;\n    }\n    a[++k].x=1;a[k].y=3,a[k].t=INF;\n    sort(a+1,a+1+k,cmp);\n    for (i=1;i<=k;i++){\n    //    printf(\"%d %d %d %d\\n\",k,a[i].x,a[i].y,a[i].t);\n        x=root(a[i].x);y=root(a[i].y);\n        if (x!=y) f[x]=y,ans+=a[i].t; \n    }\n    printf(\"%d\\n\",ans);\n}\n```","type":"题解","status":2,"postTime":1470026485,"author":{"uid":19864,"name":"Acheing","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Blue","ccfLevel":0},"thumbUp":49,"commentCount":28,"currentUserVoteType":0,"contentDescription":"最小生成树最好了\n","id":786,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"看了这么久至今没有看到Python的题解，让我来一发。\n\n    string=input()\n\n    print(int(string.split(\" \")[0])+int(string.split(\" \")[1]))\n\nPython万能的运算看起来比C++的的算法要简单得多。但我看见过很多人用Python成功RE爆零的，原因是Python在一行上检测到空格时不会将前面的内容储存进变量，而是会将一整行内容转成字符串，自然会RE。本方法是将输入先以字符串格式读入变量string，再以空格为依据用split()函数进行分片，产生一个字符型的列表，再用int()函数将两个字符转为数，相加，再输出它们的和。\n","type":"题解","status":2,"postTime":1513831158,"author":{"uid":72413,"name":"蒟蒻南瓜","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":43,"commentCount":14,"currentUserVoteType":0,"contentDescription":"看了这么久至今没有看到Python的题解，让我来一发。\n\nPython万能的运算看起来比C++的的算法要简单得多。但我看见过很多人用Python成功RE爆零的，原因是Python在一行上检测到空...","id":19296,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"各位大神都用网络流啊 最短路啊解这道题，那么既然是可以求最短路，为什么不可以从树上跑呢？\n\n怀着这种想法，我冥思苦想（划掉），发现，###我可以用LCA做这道题啊~\n\n然而鄙人不才，什么Tarjan啊ST表啊都不会，只会用一个倍增来求LCA，所以权当抛砖引玉吧。\n\n不过我估计应该没什么想学LCA的来这道题看LCA题解吧。所以多半是写着玩~~\n\n###先说说思路（这还用说？）：\n\n###建一个有三个节点的树，1为树根，2 3分别是左右儿子。\n\n###其中1 2之间的距离为a,2 3之间的距离为b，然后求1 2的LCA，和分别到LCA的距离，加起来就是1->3的最短路\n\n###其实就是题目中所求的a+b了\n\n好吧闲话不说 上代码了（多半是个LCA的板子了）：\n\n```cpp\n#include<cstdio>                                                  //头文件\n#define NI 2                                                          \n//从来不喜欢算log所以一般用常数 不知道算不算坏习惯 因为3个节点 所以log3(当然以2为底)上取整得2\nstruct edge\n{\n    int to,next,data;                                              //分别表示边的终点，下一条边的编号和边的权值\n}e[30];                                                                     //邻接表，点少边少开30是为了浪啊\nint v[10],d[10],lca[10][NI+1],f[10][NI+1],tot=0;      //数组开到10依然为了浪\n//数组还解释嘛，v表示第一条边在邻接表中的编号，d是深度，lca[x][i]表示x向上跳2^i的节点，f[x][i]表示x向上跳2^i的距离和\nvoid build(int x,int y,int z)                                      //建边\n{\n    e[++tot].to=y; e[tot].data=z; e[tot].next=v[x]; v[x]=tot;\n    e[++tot].to=x; e[tot].data=z; e[tot].next=v[y]; v[y]=tot;\n}\nvoid dfs(int x)                                                        //递归建树\n{\n    for(int i=1;i<=NI;i++)                                   //懒，所以常数懒得优化\n        f[x][i]=f[x][i-1]+f[lca[x][i-1]][i-1],\n        lca[x][i]=lca[lca[x][i-1]][i-1];                   //建树的同时进行预处理\n    for(int i=v[x];i;i=e[i].next)                              //遍历每个连接的点\n    {\n        int y=e[i].to;\n        if(lca[x][0]==y) continue;\n        lca[y][0]=x;                                       //小技巧：lca[x][0]即为x的父亲~~（向上跳2^0=1不就是父节点嘛）\n        f[y][0]=e[i].data;\n        d[y]=d[x]+1;\n        dfs(y);                                            //再以这个节点为根建子树【这里真的用得到嘛？？】\n    }\n}\nint ask(int x,int y)                                             //询问，也是关键\n{                                                                        \n    if(d[x]<d[y]) {int t=x;x=y;y=t;}                  //把x搞成深的点\n    int k=d[x]-d[y],ans=0;\n    for(int i=0;i<=NI;i++)\n        if(k&(1<<i))                                      //若能跳就把x跳一跳\n            ans+=f[x][i],                              //更新信息\n            x=lca[x][i];\n    for(int i=NI;i>=0;i--)                                  //不知道能不能正着循环，好像倒着优，反正记得倒着就好了\n        if(lca[x][i]!=lca[y][i])                            //如果x跳2^i和y跳2^j没跳到一起就让他们跳\n            ans+=f[x][i]+f[y][i],\n            x=lca[x][i],y=lca[y][i];\n    return ans+f[x][0]+f[y][0];                           //跳到LCA上去（每步跳的时候都要更新信息，而且要在跳之前更新信息哦~）\n}\nint main()\n{\n    int a,b;\n    scanf(\"%d%d\",&a,&b);\n    build(1,2,a);\n    build(1,3,b);                                                       //分别建1 2、1 3之间的边\n    dfs(1);                                                                //以1为根建树\n    printf(\"%d\",ask(2,3));                                         //求解2 3到它们的LCA的距离和并输出\n}\n```\nBINGO~~\n","type":"题解","status":2,"postTime":1478782006,"author":{"uid":18455,"name":"Enzymii","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Blue","ccfLevel":0},"thumbUp":34,"commentCount":33,"currentUserVoteType":0,"contentDescription":"各位大神都用网络流啊 最短路啊解这道题，那么既然是可以求最短路，为什么不可以从树上跑呢？\n怀着这种想法，我冥思苦想（划掉），发现，###我可以用LCA做这道题啊~\n然而鄙人不才，什么Tarjan...","id":794,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"## 发布一个Scala的版本\n\n```\nimport scala.io._\nobject Test\n{\n    def main(args: Array[String])\n    {\n        val a = StdIn.readInt()\n        val b = StdIn.readInt()\n        println(a+b)\n    }\n}\n```","type":"题解","status":2,"postTime":1543731555,"author":{"uid":48993,"name":"liuyifan","slogan":"退役啦qwq","badge":null,"isAdmin":false,"isBanned":false,"color":"Blue","ccfLevel":0},"thumbUp":27,"commentCount":66,"currentUserVoteType":0,"contentDescription":"发布一个Scala的版本\n","id":93141,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"二进制下的a+b。如果有重复，请无视，如果没有，删了这句话\n\n```cpp\n#include<iostream>\n#include<cstdio>\n#include<cstdlib>\n#include<cmath>\n#include<algorithm>\nusing namespace std;\nint main()\n{\n    int a,b,s=0,s1=0,i=0,na=0,nb=0;\n    cin>>a>>b;\n    if(a<=0) na=1,a*=-1;\n    while(a!=0)\n    {\n        if(a%2!=0)\n        s+=pow(2,a%2*i);\n        a/=2;\n        i++;\n    }\n    i=0;\n    if(na==1) s*=-1;\n    if(b<=0) nb=1,b*=-1;\n    while(b!=0)\n    {\n        if(b%2!=0)\n        s1+=pow(2,b%2*i);\n        b/=2;\n        i++;\n    }\n    if(nb==1) s1*=-1;\n    cout<<s+s1;;\n    return 0;\n}\n```","type":"题解","status":2,"postTime":1485185452,"author":{"uid":23394,"name":"jacky_chen","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":26,"commentCount":63,"currentUserVoteType":0,"contentDescription":"二进制下的a+b。如果有重复，请无视，如果没有，删了这句话\n","id":800,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"#P1001题解大神多啊- -然而我写了一个高精模板类#\n\n#include <bits/stdc++.h>\n\nusing namespace std;\n\nclass cint{ //定义一个类\n\nprivate:\n\nint c\\_number[100001],c\\_len,c\\_d,c\\_fh; //属性,包括数字,长度,进制,符号\n\npublic:\n\n\n```cpp\n        cint(); \n        ~cint();\n        cint(int x); \n        cint(string st); //构造与析构函数\n        cint operator+(cint& b); //重载+,以用于更方便地运算\n        cint read_cint(); //读入\n        void write_cint(); //输出\n};\ncint::cint()\n{\n    c_d=10;\n}\ncint::~cint()\n{\n}\ncint::cint(int x)\n{\n    c_d=10;\n    if (x<0)\n    {\n        c_fh=-1;\n        x=-x;\n    }\n    else c_fh=1;\n    c_len=0;\n    while (x)\n    {\n        c_len++;\n        c_number[c_len]=x%c_d;\n        x/=c_d;\n    }\n}\ncint::cint (string st)\n{\n    int i;\n    if (st[0]=='-') \n    {\n        c_fh=-1;\n        st.erase(0,1);\n    }\n    else c_fh=1;\n    while (st[0]=='0'&&st.length()>1)\n        st.erase(0,1); //去除前导0\n    c_len=st.length();\n    for (i=1;i<=c_len;i++)\n        c_number[i]=(st[c_len-i]-48)*c_fh; //将字符的ascii码-48,存入数组中\n} //构造函数,将字符串存入类中\ncint cint::operator+(cint& b)\n{\n    int i;\n    cint c;\n    if (c_len>=b.c_len) c.c_len=c_len;\n    else c.c_len=b.c_len;\n    for (i=1;i<=c.c_len;i++)\n    {\n        c.c_number[i]+=c_number[i]+b.c_number[i]; //将两位相加\n        c.c_number[i+1]=c.c_number[i]/c.c_d;\n        c.c_number[i]%=c.c_d; //处理进位\n    }\n    while (c.c_number[c.c_len+1])\n        c.c_len++;\n    return c;\n} //核心部分,高精加\ncint cint::read_cint()\n{\n    string st;\n    cin>>st;\n    return cint(st);\n}\nvoid cint::write_cint()\n{\n    int i;\n    for (i=1;i<=c_len;i++)\n        cout<<c_number[c_len-i+1]; //输出部分,很容易理解\n}\nistream& operator>>(istream& is,cint &c)\n{\n    c=c.read_cint();\n    return is;\n} //重载>>,便于输入\nostream& operator<<(ostream& os,cint c)\n{\n    c.write_cint();\n    return os;\n} //重载<<,便于输出.\n```\n##下面是美丽的主程序##\n\n```cpp\nint main()\n{\n    cint a,b;\n    cin>>a>>b;\n    cout<<a+b<<endl;\n}\n```","type":"题解","status":1,"postTime":1481345394,"author":{"uid":22132,"name":"little_gift","slogan":"没有未来的未来不是我想要的未来","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":25,"commentCount":63,"currentUserVoteType":0,"contentDescription":"P1001题解大神多啊- -然而我写了一个高精模板类\ninclude &lt;bits/stdc++.h&gt;\nusing namespace std;\nclass cint{ //定义一个类...","id":797,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"看楼下也有位运算，用递归做的，我就贴个非递归的吧。。。\n\n```cpp\n#include <cstdio>\nint m, n;\nint main()\n{\n    scanf(\"%d%d\", &m, &n);\n    int u = m & n;\n    int v = m ^ n;\n    while (u) {\n        int s = v;\n        int t = u << 1;\n        u = s & t;\n        v = s ^ t;\n    }\n    printf(\"%d\\n\", v);\n}\n```","type":"题解","status":2,"postTime":1479216185,"author":{"uid":27965,"name":"zhjian","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":25,"commentCount":19,"currentUserVoteType":0,"contentDescription":"看楼下也有位运算，用递归做的，我就贴个非递归的吧。。。\n","id":795,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"},{"content":"5ms , 1371kb\n\n线段树走起\n\n附上在下65行线段树代码\n\n```cpp\n#include<cstdio>\n#include<algorithm>\n#include<cstdlib>\n#include<cmath>\n#include<cstring>\n#include<iostream>\nusing namespace std;\nstruct node{\n    int val,l,r;\n};\nnode t[5];\nint a[5],f[5];\nint n,m;\nvoid init(){\n    for(int i=1;i<=2;i++){\n        scanf(\"%d\",&a[i]);\n    }\n}\nvoid build(int l,int r,int node){//这是棵树\n    t[node].l=l;t[node].r=r;t[node].val=0;\n    if(l==r){\n        f[l]=node;\n        t[node].val=a[l];\n        return;\n    }\n    int mid=(l+r)>>1;\n    build(l,mid,node*2);\n    build(mid+1,r,node*2+1);\n    t[node].val=t[node*2].val+t[node*2+1].val;\n}\nvoid update(int node){\n    if(node==1)return;\n    int fa=node>>1;\n    t[fa].val=t[fa*2].val+t[fa*2+1].val;\n    update(fa);\n}\nint find(int l,int r,int node){\n    if(t[node].l==l&&t[node].r==r){\n        return t[node].val;\n    }\n    int sum=0;\n    int lc=node*2;int rc=lc+1;\n    if(t[lc].r>=l){\n        if(t[lc].r>=r){\n            sum+=find(l,r,lc);\n        }\n        else{\n            sum+=find(l,t[lc].r,lc);\n        }\n    }\n    if(t[rc].l<=r){\n        if(t[rc].l<=l){\n            sum+=find(l,r,rc);\n        }\n        else{\n            sum+=find(t[rc].l,r,rc);\n        }\n    }\n    return sum;\n}\nint main(){\n    init();\n    build(1,2,1);\n    printf(\"%d\",find(1,2,1));\n}\n```","type":"题解","status":2,"postTime":1473245426,"author":{"uid":10025,"name":"神一般的世界","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0},"thumbUp":25,"commentCount":35,"currentUserVoteType":0,"contentDescription":"5ms , 1371kb\n线段树走起\n附上在下65行线段树代码\n","id":788,"identifier":"solution-p1001","title":"题解 P1001 【A+B Problem 】"}]
             * perPage : 10
             * count : 27
             */

            private int perPage;
            private int count;
            private List<ResultBean> result;

            public int getPerPage() {
                return perPage;
            }

            public void setPerPage(int perPage) {
                this.perPage = perPage;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<ResultBean> getResult() {
                return result;
            }

            public void setResult(List<ResultBean> result) {
                this.result = result;
            }

            public static class ResultBean {
                /**
                 * content : 明显的字典树

                 以每个数字建立字典树

                 建立一次查询一次

                 spj正负 下面上代码

                 ```cpp
                 #include<cstdio>
                 #include<cstring>
                 #include<cstdlib>
                 #include<algorithm>
                 using namespace std;
                 struct node{
                 int str[26];
                 int sum;
                 }s[1000];
                 char str1[100];
                 int t=0,tot=0,ss=0;
                 bool f1;
                 void built()
                 {
                 t=0;
                 for(int i=0;i<strlen(str1);i++)
                 {
                 if(str1[i]=='-'){
                 f1=true;continue;
                 }
                 if(!s[t].str[str1[i]-'0'])
                 s[t].str[str1[i]-'0']=++tot;
                 t=s[t].str[str1[i]-'0'];
                 s[t].sum=str1[i]-'0';
                 }
                 }
                 int query()
                 {
                 int t=0;int s1=0;
                 for(int i=0;i<strlen(str1);i++)
                 {
                 if(str1[i]=='-') continue;
                 if(!s[t].str[str1[i]-'0']) return s1;
                 t=s[t].str[str1[i]-'0'];
                 s1=s1*10+s[t].sum;
                 }
                 return s1;
                 }
                 int main()
                 {
                 for(int i=1;i<=2;i++)
                 {
                 f1=false;
                 scanf("%s",str1);
                 built();
                 if(f1)
                 ss-=query();
                 else ss+=query();
                 }
                 printf("%d",ss);
                 return 0;
                 }
                 ```
                 * type : 题解
                 * status : 2
                 * postTime : 1477879617
                 * author : {"uid":25215,"name":"Linbom","slogan":"","badge":null,"isAdmin":false,"isBanned":false,"color":"Gray","ccfLevel":0}
                 * thumbUp : 55
                 * commentCount : 50
                 * currentUserVoteType : 0
                 * contentDescription : 明显的字典树
                 以每个数字建立字典树
                 建立一次查询一次
                 spj正负 下面上代码
                 * id : 793
                 * identifier : solution-p1001
                 * title : 题解 P1001 【A+B Problem 】
                 */

                private String content;
                private String type;
                private int status;
                private int postTime;
                private AuthorBean author;
                private int thumbUp;
                private int commentCount;
                private int currentUserVoteType;
                private String contentDescription;
                private int id;
                private String identifier;
                private String title;

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getPostTime() {
                    return postTime;
                }

                public void setPostTime(int postTime) {
                    this.postTime = postTime;
                }

                public AuthorBean getAuthor() {
                    return author;
                }

                public void setAuthor(AuthorBean author) {
                    this.author = author;
                }

                public int getThumbUp() {
                    return thumbUp;
                }

                public void setThumbUp(int thumbUp) {
                    this.thumbUp = thumbUp;
                }

                public int getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }

                public int getCurrentUserVoteType() {
                    return currentUserVoteType;
                }

                public void setCurrentUserVoteType(int currentUserVoteType) {
                    this.currentUserVoteType = currentUserVoteType;
                }

                public String getContentDescription() {
                    return contentDescription;
                }

                public void setContentDescription(String contentDescription) {
                    this.contentDescription = contentDescription;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getIdentifier() {
                    return identifier;
                }

                public void setIdentifier(String identifier) {
                    this.identifier = identifier;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public static class AuthorBean {
                    /**
                     * uid : 25215
                     * name : Linbom
                     * slogan :
                     * badge : null
                     * isAdmin : false
                     * isBanned : false
                     * color : Gray
                     * ccfLevel : 0
                     */

                    private int uid;
                    private String name;
                    private String slogan;
                    private Object badge;
                    private boolean isAdmin;
                    private boolean isBanned;
                    private String color;
                    private int ccfLevel;

                    public int getUid() {
                        return uid;
                    }

                    public void setUid(int uid) {
                        this.uid = uid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getSlogan() {
                        return slogan;
                    }

                    public void setSlogan(String slogan) {
                        this.slogan = slogan;
                    }

                    public Object getBadge() {
                        return badge;
                    }

                    public void setBadge(Object badge) {
                        this.badge = badge;
                    }

                    public boolean isIsAdmin() {
                        return isAdmin;
                    }

                    public void setIsAdmin(boolean isAdmin) {
                        this.isAdmin = isAdmin;
                    }

                    public boolean isIsBanned() {
                        return isBanned;
                    }

                    public void setIsBanned(boolean isBanned) {
                        this.isBanned = isBanned;
                    }

                    public String getColor() {
                        return color;
                    }

                    public void setColor(String color) {
                        this.color = color;
                    }

                    public int getCcfLevel() {
                        return ccfLevel;
                    }

                    public void setCcfLevel(int ccfLevel) {
                        this.ccfLevel = ccfLevel;
                    }
                }
            }
        }

        public static class ProblemBean {
            /**
             * pid : P1001
             * title : A+B Problem
             * difficulty : 1
             * fullScore : 100
             * type : P
             */

            private String pid;
            private String title;
            private int difficulty;
            private int fullScore;
            private String type;

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getDifficulty() {
                return difficulty;
            }

            public void setDifficulty(int difficulty) {
                this.difficulty = difficulty;
            }

            public int getFullScore() {
                return fullScore;
            }

            public void setFullScore(int fullScore) {
                this.fullScore = fullScore;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }

    public static class CurrentThemeBean {
        /**
         * id : 1
         * header : {"imagePath":null,"color":[[35,37,38,1],[65,67,69,1]],"blur":0,"brightness":0,"degree":90,"repeat":0,"position":[50,50],"size":[0,0],"type":2,"__CLASS_NAME":"Luogu\\DataClass\\User\\ThemeConfig\\HeaderFooterConfig"}
         * sideNav : {"logoBackgroundColor":[52,152,219,1],"color":[52,73,94,1],"invertColor":false,"__CLASS_NAME":"Luogu\\DataClass\\User\\ThemeConfig\\SideNavConfig"}
         * footer : {"imagePath":null,"color":[[51,51,51,1]],"blur":0,"brightness":0,"degree":0,"repeat":0,"position":[0,0],"size":[0,0],"type":2,"__CLASS_NAME":"Luogu\\DataClass\\User\\ThemeConfig\\HeaderFooterConfig"}
         */

        private int id;
        private HeaderBean header;
        private SideNavBean sideNav;
        private FooterBean footer;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public SideNavBean getSideNav() {
            return sideNav;
        }

        public void setSideNav(SideNavBean sideNav) {
            this.sideNav = sideNav;
        }

        public FooterBean getFooter() {
            return footer;
        }

        public void setFooter(FooterBean footer) {
            this.footer = footer;
        }

        public static class HeaderBean {
            /**
             * imagePath : null
             * color : [[35,37,38,1],[65,67,69,1]]
             * blur : 0
             * brightness : 0
             * degree : 90
             * repeat : 0
             * position : [50,50]
             * size : [0,0]
             * type : 2
             * __CLASS_NAME : Luogu\DataClass\User\ThemeConfig\HeaderFooterConfig
             */

            private Object imagePath;
            private int blur;
            private int brightness;
            private int degree;
            private int repeat;
            private int type;
            private String __CLASS_NAME;
            private List<List<Integer>> color;
            private List<Integer> position;
            private List<Integer> size;

            public Object getImagePath() {
                return imagePath;
            }

            public void setImagePath(Object imagePath) {
                this.imagePath = imagePath;
            }

            public int getBlur() {
                return blur;
            }

            public void setBlur(int blur) {
                this.blur = blur;
            }

            public int getBrightness() {
                return brightness;
            }

            public void setBrightness(int brightness) {
                this.brightness = brightness;
            }

            public int getDegree() {
                return degree;
            }

            public void setDegree(int degree) {
                this.degree = degree;
            }

            public int getRepeat() {
                return repeat;
            }

            public void setRepeat(int repeat) {
                this.repeat = repeat;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String get__CLASS_NAME() {
                return __CLASS_NAME;
            }

            public void set__CLASS_NAME(String __CLASS_NAME) {
                this.__CLASS_NAME = __CLASS_NAME;
            }

            public List<List<Integer>> getColor() {
                return color;
            }

            public void setColor(List<List<Integer>> color) {
                this.color = color;
            }

            public List<Integer> getPosition() {
                return position;
            }

            public void setPosition(List<Integer> position) {
                this.position = position;
            }

            public List<Integer> getSize() {
                return size;
            }

            public void setSize(List<Integer> size) {
                this.size = size;
            }
        }

        public static class SideNavBean {
            /**
             * logoBackgroundColor : [52,152,219,1]
             * color : [52,73,94,1]
             * invertColor : false
             * __CLASS_NAME : Luogu\DataClass\User\ThemeConfig\SideNavConfig
             */

            private boolean invertColor;
            private String __CLASS_NAME;
            private List<Integer> logoBackgroundColor;
            private List<Integer> color;

            public boolean isInvertColor() {
                return invertColor;
            }

            public void setInvertColor(boolean invertColor) {
                this.invertColor = invertColor;
            }

            public String get__CLASS_NAME() {
                return __CLASS_NAME;
            }

            public void set__CLASS_NAME(String __CLASS_NAME) {
                this.__CLASS_NAME = __CLASS_NAME;
            }

            public List<Integer> getLogoBackgroundColor() {
                return logoBackgroundColor;
            }

            public void setLogoBackgroundColor(List<Integer> logoBackgroundColor) {
                this.logoBackgroundColor = logoBackgroundColor;
            }

            public List<Integer> getColor() {
                return color;
            }

            public void setColor(List<Integer> color) {
                this.color = color;
            }
        }

        public static class FooterBean {
            /**
             * imagePath : null
             * color : [[51,51,51,1]]
             * blur : 0
             * brightness : 0
             * degree : 0
             * repeat : 0
             * position : [0,0]
             * size : [0,0]
             * type : 2
             * __CLASS_NAME : Luogu\DataClass\User\ThemeConfig\HeaderFooterConfig
             */

            private Object imagePath;
            private int blur;
            private int brightness;
            private int degree;
            private int repeat;
            private int type;
            private String __CLASS_NAME;
            private List<List<Integer>> color;
            private List<Integer> position;
            private List<Integer> size;

            public Object getImagePath() {
                return imagePath;
            }

            public void setImagePath(Object imagePath) {
                this.imagePath = imagePath;
            }

            public int getBlur() {
                return blur;
            }

            public void setBlur(int blur) {
                this.blur = blur;
            }

            public int getBrightness() {
                return brightness;
            }

            public void setBrightness(int brightness) {
                this.brightness = brightness;
            }

            public int getDegree() {
                return degree;
            }

            public void setDegree(int degree) {
                this.degree = degree;
            }

            public int getRepeat() {
                return repeat;
            }

            public void setRepeat(int repeat) {
                this.repeat = repeat;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String get__CLASS_NAME() {
                return __CLASS_NAME;
            }

            public void set__CLASS_NAME(String __CLASS_NAME) {
                this.__CLASS_NAME = __CLASS_NAME;
            }

            public List<List<Integer>> getColor() {
                return color;
            }

            public void setColor(List<List<Integer>> color) {
                this.color = color;
            }

            public List<Integer> getPosition() {
                return position;
            }

            public void setPosition(List<Integer> position) {
                this.position = position;
            }

            public List<Integer> getSize() {
                return size;
            }

            public void setSize(List<Integer> size) {
                this.size = size;
            }
        }
    }

    public static class CurrentUserBean {
        /**
         * blogAddress : null
         * followingCount : 0
         * followerCount : 0
         * ranking : null
         * unreadMessageCount : 0
         * unreadNoticeCount : 0
         * verified : true
         * uid : 349784
         * name : yami1574150143
         * slogan :
         * badge : null
         * isAdmin : false
         * isBanned : false
         * color : Gray
         * ccfLevel : 0
         */

        private Object blogAddress;
        private int followingCount;
        private int followerCount;
        private Object ranking;
        private int unreadMessageCount;
        private int unreadNoticeCount;
        private boolean verified;
        private int uid;
        private String name;
        private String slogan;
        private Object badge;
        private boolean isAdmin;
        private boolean isBanned;
        private String color;
        private int ccfLevel;

        public Object getBlogAddress() {
            return blogAddress;
        }

        public void setBlogAddress(Object blogAddress) {
            this.blogAddress = blogAddress;
        }

        public int getFollowingCount() {
            return followingCount;
        }

        public void setFollowingCount(int followingCount) {
            this.followingCount = followingCount;
        }

        public int getFollowerCount() {
            return followerCount;
        }

        public void setFollowerCount(int followerCount) {
            this.followerCount = followerCount;
        }

        public Object getRanking() {
            return ranking;
        }

        public void setRanking(Object ranking) {
            this.ranking = ranking;
        }

        public int getUnreadMessageCount() {
            return unreadMessageCount;
        }

        public void setUnreadMessageCount(int unreadMessageCount) {
            this.unreadMessageCount = unreadMessageCount;
        }

        public int getUnreadNoticeCount() {
            return unreadNoticeCount;
        }

        public void setUnreadNoticeCount(int unreadNoticeCount) {
            this.unreadNoticeCount = unreadNoticeCount;
        }

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public Object getBadge() {
            return badge;
        }

        public void setBadge(Object badge) {
            this.badge = badge;
        }

        public boolean isIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
        }

        public boolean isIsBanned() {
            return isBanned;
        }

        public void setIsBanned(boolean isBanned) {
            this.isBanned = isBanned;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getCcfLevel() {
            return ccfLevel;
        }

        public void setCcfLevel(int ccfLevel) {
            this.ccfLevel = ccfLevel;
        }
    }
}
