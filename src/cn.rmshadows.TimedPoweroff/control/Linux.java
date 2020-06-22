package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;

import javafx.scene.control.Alert;
import resources.SampleController;

/**
 * Linux关机方法
 * 执行Linux平台的shutdown命令
 */
public class Linux {
	public static String shellToDo(String command) throws InterruptedException {
		String returnString = "";
		Process pro = null;
		Runtime runTime = Runtime.getRuntime();
		if (runTime == null) {
			System.err.println("Create runtime false!");
		}
		try {
			pro = runTime.exec(command);
			BufferedReader input = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			PrintWriter output = new PrintWriter(new OutputStreamWriter(pro.getOutputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				returnString = returnString + line + "\n";
			}
			input.close();
			output.close();
			pro.destroy();
		} catch (IOException ex) {
			System.out.println("ERROR");
		}
		return returnString;
	}

	public static void shutdown() throws InterruptedException, ParseException {
		if (SampleController.MODE == 1) {
			int x = (int) (SampleController.HOUR * 60 + SampleController.MINUTE);
			String y = "shutdown -P " + x;
			System.out.println(y);
			shellToDo(y);
			if(x==0) {
				shellToDo("poweroff");
			}
		} else {
			long x = TimeCalculator.timer()/60;
			String y = "shutdown -P "+x;
			System.out.println(y);
			shellToDo(y);
			if(x==0) {
				shellToDo("poweroff");
			}
		}
		Alert alert = new Alert(Alert.AlertType.INFORMATION); // 创建一个消息对话框
		alert.setHeaderText("信息"); // 设置对话框的头部文本
		// 设置对话框的内容文本
		alert.setContentText("已经设置定时关机任务！");
		alert.show(); // 显示对话框
	}
	
	public static void reboot() throws InterruptedException {
//		shellToDo("reboot");
		if (SampleController.MODE == 1) {
			int x = (int) (SampleController.HOUR * 60 + SampleController.MINUTE);
			String y = "shutdown -r +" + x;
			shellToDo(y);
			if(x==0) {
				shellToDo("reboot");
			}
		} else {
			long x = TimeCalculator.timer()/60;
			String y = "shutdown -r +"+x;
			shellToDo(y);
			if(x==0) {
				shellToDo("reboot");
			}
			Alert alert = new Alert(Alert.AlertType.INFORMATION); // 创建一个消息对话框
			alert.setHeaderText("信息"); // 设置对话框的头部文本
			// 设置对话框的内容文本
			alert.setContentText("已经设置定时关机任务！");
			alert.show(); // 显示对话框
		}
	}

	public static void cancel() throws InterruptedException {
		shellToDo("shutdown -c");
		Alert alert = new Alert(Alert.AlertType.INFORMATION); // 创建一个消息对话框
		alert.setHeaderText("信息"); // 设置对话框的头部文本
		// 设置对话框的内容文本
		alert.setContentText("定时关机任务已取消！");
		alert.show(); // 显示对话框
	}
}
