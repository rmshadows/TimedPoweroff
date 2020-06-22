package control;

import javafx.scene.control.Alert;
import resources.SampleController;

/**
 * MacOS关机方法
 * 执行MacOS平台的shutdown命令
 */
public class MacOS {
	public static void macShell(String shellString) {
		try {
			Process process = Runtime.getRuntime().exec(shellString);
			int exitValue = process.waitFor();
			if (0 != exitValue) {
//				log.error("call shell failed. error code is :" + exitValue);
			}
		} catch (Throwable e) {
//			log.error("call shell failed. " + e);
			System.out.println("ERROR");
		}
	}

	public static void shutdown() {
		if(SampleController.MODE==0) {
			int a = SampleController.YEAR;
			int b = SampleController.MONTH;
			int c = SampleController.DAY;
			int d = SampleController.HOUR;
			int e = (int)SampleController.MINUTE;
			int f = SampleController.SECOND;
			String aa = String.valueOf(a).substring(2);
			String bb = String.valueOf(String.format("%02d",b));
			String cc = String.valueOf(String.format("%02d",c));
			String dd = String.valueOf(String.format("%02d",d));
			String ee = String.valueOf(String.format("%02d",e));
			String ff = String.valueOf(String.format("%02d",f));
			
			String x = aa+bb+cc+dd+ee+ff;
			
			String y = "shutdown -s "+x;
			macShell(y);
		}
		else if (SampleController.MODE==1) {
			int x = (int) (SampleController.HOUR*60+SampleController.MINUTE);
			String y = "shutdown -s +"+x;
			macShell(y);
		}
		else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION); // 创建一个消息对话框
			alert.setHeaderText("警告"); // 设置对话框的头部文本
			// 设置对话框的内容文本
			alert.setContentText("失败");
			alert.show(); // 显示对话框
		}
	}

	public static void reboot() {
		if(SampleController.MODE==0) {
			int a = SampleController.YEAR;
			int b = SampleController.MONTH;
			int c = SampleController.DAY;
			int d = SampleController.HOUR;
			int e = (int)SampleController.MINUTE;
			int f = SampleController.SECOND;
			String aa = String.valueOf(a).substring(2);
			String bb = String.valueOf(String.format("%02d",b));
			String cc = String.valueOf(String.format("%02d",c));
			String dd = String.valueOf(String.format("%02d",d));
			String ee = String.valueOf(String.format("%02d",e));
			String ff = String.valueOf(String.format("%02d",f));
			
			String x = aa+bb+cc+dd+ee+ff;
			
			String y = "shutdown -r"+x;
			macShell(y);
		}
		else if (SampleController.MODE==1) {
			int x = (int) (SampleController.HOUR*60+SampleController.MINUTE);
			String y = "shutdown -r +"+x;
			macShell(y);
		}
		else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION); // 创建一个消息对话框
			alert.setHeaderText("警告"); // 设置对话框的头部文本
			// 设置对话框的内容文本
			alert.setContentText("失败");
			alert.show(); // 显示对话框
		}
	}

	public static void cancel() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION); // 创建一个消息对话框
		alert.setHeaderText("警告"); // 设置对话框的头部文本
		// 设置对话框的内容文本
		alert.setContentText("MacOS等需要手动取消。");
		alert.show(); // 显示对话框
	}
}
