package control;

/**
 * 检测系统类型的类
 * 判断Linux还是Windows的类方法
 */
public class DetectSystem {

	/**
	 * 检测系统类型
	 * 判断Linux还是Windows的类方法
	 * @return int Windows[0]Linux[1]Other[2]
	 */
	public static int detectOS() {
		String os = System.getProperties().getProperty("os.name");
		if (os.substring(0, 3).equals("Win")) {
//			System.out.println(os);
			return 0;
		} 
		else if (os.substring(0, 3).equals("Lin")){
//			System.out.println(os);
			return 1;
		}
		else {
			System.out.println(os);
			return 2;
		}
	}
}
