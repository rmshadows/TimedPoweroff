package control;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

import javafx.scene.control.Alert;
import resources.SampleController;

/**
 * 时间差计算
 * 用java.time包
 */
public class TimeCalculator {

	/**
	 * 计算时间差
	 * @return long 秒数
	 */
	public static long timer() {
		Long second = 1000L;
		try {
			int a = SampleController.YEAR;
			Month b = Month.of(SampleController.MONTH);
			int c = SampleController.DAY;
			int d = SampleController.HOUR;
			int e = (int)SampleController.MINUTE;
			int f = SampleController.SECOND;
			int aa = LocalDateTime.now().getYear();
			Month bb = LocalDateTime.now().getMonth();
			int cc = LocalDateTime.now().getDayOfMonth();
			int dd = LocalDateTime.now().getHour();
			int ee = LocalDateTime.now().getMinute();
			int ff = LocalDateTime.now().getSecond();
			
//			System.out.println(a+"-"+b+"-"+c+" "+d+":"+e+":"+f);
			LocalDateTime from = LocalDateTime.of(aa, bb, cc, dd, ee, ff); // 2019-01-05 10:07:00
			LocalDateTime to = LocalDateTime.of(a, b, c, d, e, f); // 2019-02-05 10:07:00
			Duration duration = Duration.between(from, to); // 表示从 2019-01-05 10:07:00 到 2019-02-05 10:07:00 这段时间
			second = duration.getSeconds();
			if(second<0) {
				throw new Exception();
			}
			else {
				System.out.println(second);
			}
		}catch (Exception e1) {
			// TODO: handle exception
			Alert alert = new Alert(Alert.AlertType.WARNING); // 创建一个消息对话框
			alert.setHeaderText("出错:请检查输入的时间是否早于当前或者时间不存在。\n别问。问就是程序员偷懒。。 嘘。。。。"); // 设置对话框的头部文本
			// 设置对话框的内容文本
			alert.setContentText("切换到计划模式请自行调整小时、分钟参数，因为默认显示启动时间(过去)。");
			alert.show(); // 显示对话框
		}
		return second;
	}
}
