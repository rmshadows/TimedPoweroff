package control;

import java.io.InputStream;

import resources.SampleController;

/**
 * Windows关机方法
 * 执行Windows平台的shutdown命令
 */
public class Windows {
	public static void shutdown() {
		if(SampleController.MODE==1) {
			int x = (int) (SampleController.HOUR*3600+SampleController.MINUTE*60);
			String y = "shutdown -f -s -t "+x;
			CMD(y);
		}
		else if (SampleController.MODE==0) {
			long x = TimeCalculator.timer();
			String y = "shutdown -f -s -t "+x;
			CMD(y);
		}
	}

	public static void reboot() {
		if(SampleController.MODE==1) {
			int x = (int) (SampleController.HOUR*3600+SampleController.MINUTE*60);
			String y = "shutdown -f -r -t "+x;
			CMD(y);
		}
		else if (SampleController.MODE==0) {
			long x = TimeCalculator.timer();
			String y = "shutdown -f -r -t "+x;
			CMD(y);
		}
	}

	public static void cancel() {
		CMD("shutdown -a");
	}

	public static void CMD(String cmdStr) {
		Runtime run = Runtime.getRuntime();
		try {
//			Process process = run.exec("cmd.exe /k start " + cmdStr);
			Process process = run.exec("cmd.exe /c " + cmdStr);
			InputStream in = process.getInputStream();
			while (in.read() != -1) {
				System.out.println(in.read());
			}
			in.close();
			process.waitFor();
		} catch (Exception e) {
			
		}
	}

}
