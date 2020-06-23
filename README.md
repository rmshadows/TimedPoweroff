# TimedPoweroff

#### 介绍

- JavaFX写的定时关机程序，支持倒计时、计划关机、重启。
- 平台：Windows、Linux (没有MacOS，这辈子都不会买Mac的，有钱我还在这儿自己敲这破代码？？是商业软件用的不够香吗还是重金请不到商业公司解决需求嘛hhhhhh能花钱解决就花钱，效果真的好！！比如自己做视频和花钱让别人做视频……)

- 版本：[Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)  [JavaFX 11](https://gluonhq.com/) [JavaFX环境搭建指南](https://openjfx.io/openjfx-docs/)

- 缺点： **启动** 是真的慢……至少在我这3千大洋的商务本[问：如何杜绝端游？答：买个三千元的笔记本就行了，开个炉石都卡爆了]上就是这么慢。。。五六秒吧。。最快也要3秒。还有就是 **模式切换后** ， **必须手动** 刷新 **时、分、秒** 三个数据， **否则** 时间设定将出现偏差。

#### 编译与运行

- Linux

 1. 编译：`javac --module-path [%Your JavaFX_Home%] --module-source-path src -d bin/ -m cn.rmshadows.TimedPoweroff`

    然后再把res里的资源文件复制到bin去。

 1. 运行：`java --module-path bin/:[%Your JavaFX_Home%] -m cn.rmshadows.TimedPoweroff/application.TimedPoweroffMainApp`

 1. 打包：`jlink --launcher StartTimedPoweroff=cn.rmshadows.TimedPoweroff/application.TimedPoweroffMainApp --module-path jomds_linux/:bin/ --add-modules cn.rmshadows.TimedPoweroff,java.base,java.desktop,javafx.base,javafx.controls,javafx.fxml,javafx.graphics --output TimedPoweroff2.0`

Windows下打包：`jlink --launcher StartTimedPoweroff=cn.rmshadows.TimedPoweroff/application.TimedPoweroffMainApp --module-path "jomds_windows/;bin/" --add-modules cn.rmshadows.TimedPoweroff,java.base,java.desktop,javafx.base,javafx.controls,javafx.fxml,javafx.graphics --output TimedPoweroff2.0`

总之打包就是：`jlink --launcher [StartFilename]=[ModuleName/Package.MainClass] --module-path "%JAVA_FX_HOME%\jmods"[分割符(Linux:Windows;)][PathToModuleClassFile] --add-modules [ModuleName...] --output [JlinkOutputFileName]`

#### 使用说明

1.  默认是倒计时功能，打开软件直接回车将立即关闭计算机。倒计时功能通过鼠标滚轮控制滑动条的移动来设置倒计时时长。
2.  模式切换在左下角，同样可以用鼠标滚轮控制。
3.  切换到计划关机模式时，用鼠标在上方时间框处，滚轮滑动修改时间。需要手动点击下时、分、秒三个标签刷新时间，保证定时准确。
4.  ！！ **每次切换模式都要手动刷新下“时”、“分”、“秒”三个参数** ！！！！ **每次切换模式都要手动刷新下“时”、“分”、“秒”三个参数** ！！！！ **每次切换模式都要手动刷新下“时”、“分”、“秒”三个参数** ！！(这就是麻烦的地方，程序员偷懒，你懂得。)

### 截屏

![输入图片说明](https://images.gitee.com/uploads/images/2020/0623/103400_ab71cea9_7423713.jpeg "37F53EC3959A28560249D4AB15E77B54.jpg")

#### 许可

[LICENSE](https://gitee.com/rmshadows/TimedPoweroff/new/master?license=Apache-2.0)

