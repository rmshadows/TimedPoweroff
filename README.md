# TimedPoweroff

#### 介绍

- JavaFX写的定时关机程序，支持倒计时、计划关机、重启。
- 平台：Windows、Linux (没有MacOS，这辈子都不会买Mac的，有钱我还在这儿自己敲这破代码？？是商业软件用的不够香吗还是重金请不到商业公司解决需求嘛hhhhhh能花钱解决就花钱，效果真的好！！比如自己做视频和花钱让别人做视频……)
- 版本：Java 11
- 缺点： **启动** 是真的慢……至少在我这3千大洋的商务本[问：如何杜绝端游？答：买个三千元的笔记本就行了，开个炉石都卡爆了]上就是这么慢。。。五六秒吧。。最快也要3秒。还有就是 **模式切换后** ， **必须手动** 刷新 **时、分、秒** 三个数据， **否则** 时间设定将出现偏差。

#### 编译与运行

- Linux

 1. 编译：`javac --module-path lib/ --module-source-path src -d bin/ -m cn.rmshadows.TimedPoweroff`

    然后再把res里的资源文件复制到bin去。

 1. 运行：`java --module-path bin/:lib/ -m cn.rmshadows.TimedPoweroff/application.TimedPoweroffMainApp`

 1. 打包：`jlink --launcher StartTimedPoweroff=cn.rmshadows.TimedPoweroff/application.TimedPoweroffMainApp --module-path jomds_linux/:bin/ --add-modules cn.rmshadows.TimedPoweroff,java.base,java.desktop,javafx.base,javafx.controls,javafx.fxml,javafx.graphics --output TimedPoweroff2.0`

[下边这一大段可以略过。]

- Windows下其实是差不多的，改下分割符号就是了在这里不多说。[关于 **为什么** 上面放的是Linux的啊，因为我是在Linux写的嘛。虽然听起来很奇怪，给Windows用的桌面应用居然在Linux上写。。。是因为这电脑配置不行（作为全宿舍最轻、屏幕最小、最便宜的电脑，我很满意，因为每次校区停电，我的电脑总是撑到最后的那个，多亏了我这U结尾的CPU，省电。室友的电脑最便宜的也7k，毕竟男生嘛要玩游戏的。因为我不玩游戏所以我觉得我这台商务本够用，流畅的很（指的是打开一些界面啦啥的，并不是指跑大软件需要高性能的那种流畅），毕竟平时系统维护做的比他们好。最好玩的一次是我和我朋友一起打开了同一个fork炸弹（特地设置了打开一个进程就弹出一个窗口的那种，这样可以用关闭窗口来结束进程），电脑性能差点就是好哈哈哈哈，循环速度慢，我鼠标啪啪啪几下就把fork炸弹杀掉了。诶，我朋友的电脑性能好，杀不掉，弹窗弹的是真的快。。。。就那次，是我比较直观看到和别人的性能差距。。哈哈哈，因为之前以为，就同样运行小软件的话不同价位电脑是没区别的。打脸了，看来还是有差别的。），反正Windows下不是很稳定。。发热也挺厉害的就是说后台占用有点多，尽管我已经最大程度禁用第三方应用后台服务了，不过Windows系统本身占用还是有点多，这我就懒得整了。还有最重要一点，我真的很烦Windows这个一会儿‘ **磁盘正在使用无法弹出** ’和‘ **文件正在使用无法删除** ’，每次都得手动解除占用，去查什么鸟程序占用的文件， **吐了** 。还有 **explorer资源管理器** 在去年更新系统后多任务（多任务，其实也不是很多，就开了个Word和360浏览器。或者开个eclipse和foobar2000就有时会崩溃，自己重启，我也不是很懂，因为查了系统日志，没结果）一直时不时崩溃，受不了这气。。每次都要去接触占用真的是日了勾勒。Linux的话，我的电脑 **不发热** 。命令行效率挺高，还比Windows命令行好看，实在。最棒的是图形界面卡死，我还可以去其他 **TTY终端** 结束卡死的程序或者重启图形界面！！而Windows卡死，任务管理器都打不开那种我是真的没办法！还有Windows最操蛋的就是莫名其妙软件崩了。比如我现在没法在Windows开热点，以前还能开，现在不知为啥开了手机接的上，可以上网，但是网速感人，没法玩游戏看视频的，延时却不高。重装软件也没用，试了各种小米Wifi、360Wifi、猎豹Wifi反正以前都能用，现在能开热点但是网速慢的跟断网似的，遂放弃Windows做为主系统的想法，转Linux时，开热点是真的麻烦。。搞了半个月，最后开启来了哈哈哈哈超稳定，不过现在配置好了也忘了怎么配置的了，不过还能用就是。。。但是Linux也有缺点。。比如我那个AMD显卡在Linux这边是废的，没法用，没驱动。蓝后一些的东西一般都要自己解决。比如全局变量我还会改，用户变量改./.bashrc我也会，但是现在我都还搞不懂env那个用户变量怎么改。。就是你输入`env`显示一大堆用户变量。我用了`env -u xxx`想删除某个变量， **蓝而没用** ！还有就是 **[巨硬的Office](https://www.office.com/)** 真滴好用！Linux这边我只能用[ **WPS Office** ](https://www.wps.cn/product/wpslinux)，很感谢WPS！！有Linux版本！！太棒了给个赞！虽然有Linux版本，但是还是会用Office是因为之前WPS Linux每次退出都会卡死（旧版本），后面更新了最新版本2019就好了，但偶尔还是会卡一下，特别是保存的时候卡一下，弄得我一身冷汗。。很怕和当时旧版本一样又崩溃了。目前还需要Windows的只有QQ、Office2016和foobar2000了吧，其他软件可有可无无所谓了。哦，输入法Linux很旧。 **谷歌拼音如何导入词库（fcitx-googlepinyin）** ？？我不懂。对了，我用的是[ **Debian** ](https://www.debian.org/)，Ubuntu用过，不习惯，又转回Debian了。嗯，工作方面Linux没让我失望过，非常可靠、稳定，值得信赖。好了。。扯远了。。。打住]

Windows下打包：`jlink --launcher StartTimedPoweroff=cn.rmshadows.TimedPoweroff/application.TimedPoweroffMainApp --module-path "jomds_windows/;bin/" --add-modules cn.rmshadows.TimedPoweroff,java.base,java.desktop,javafx.base,javafx.controls,javafx.fxml,javafx.graphics --output TimedPoweroff2.0`

总之打包就是：`jlink --launcher [StartFilename]=[ModuleName/Package.MainClass] --module-path "%JAVA_FX_HOME%\jmods"[分割符(Linux:Windows;)][PathToModuleClassFile] --add-modules [ModuleName...] --output [JlinkOutputFileName]`

#### 使用说明

1.  有空再补充。。。
2.  xxxx
3.  xxxx

### 截屏



#### 许可

[LICENSE](https://gitee.com/rmshadows/TimedPoweroff/new/master?license=Apache-2.0)

