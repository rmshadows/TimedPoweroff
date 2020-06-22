package resources;

import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import control.DetectSystem;
import control.Linux;
import control.MacOS;
import control.Windows;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;

/**
 * 控制器初始化
 * 初始化fxml
 */
public class SampleController implements Initializable {
	/**
	 * 引入的类变量
	 */
	public static int YEAR = 0;
	public static int MONTH = 0;
	public static int DAY = 0;
	public static int HOUR = 0;
	public static double MINUTE = 0;
	public static int SECOND = 0;
	public static int MODE = 1;

	@FXML
	private Button run;
	@FXML
	private Button reboot;
	@FXML
	private Button cancel;

	@FXML
	private MenuItem MI_Nothing;
	@FXML
	private MenuItem MI_Quit;
	@FXML
	private MenuItem MI_Info;
	@FXML
	private MenuItem MI_About;

	@FXML
	private Slider S_Mode;
	@FXML
	private Slider S_Hour;
	@FXML
	private Slider S_Min;

	@FXML
	private TextField Hour;
	@FXML
	private TextField Min;

	@FXML
	private TextField Nian;
	@FXML
	private TextField Yue;
	@FXML
	private TextField Ri;
	@FXML
	private TextField Shi;
	@FXML
	private TextField Fen;
	@FXML
	private TextField Miao;

	@FXML
	private Label Year;
	@FXML
	private Label Month;
	@FXML
	private Label Day;
	@FXML
	private Label Hours;
	@FXML
	private Label Minutes;
	@FXML
	private Label Seconds;
	
	@FXML
	private AnchorPane An;
	
	@FXML
	private MenuBar Me;
	
	@FXML
	protected void runButtonAction(ActionEvent event) throws InterruptedException, ParseException {
		try {
			int os = DetectSystem.detectOS();
			if (os == 0) {
				Windows.shutdown();
			} else if (os == 1) {
				Linux.shutdown();
			} else {
				MacOS.shutdown();
			}
		} catch (Exception e) {
			// TODO: handle exception
			Alert alert = new Alert(Alert.AlertType.ERROR); // 创建一个消息对话框
			alert.setHeaderText("ERROR"); // 设置对话框的头部文本
			// 设置对话框的内容文本
			alert.setContentText("不支持的操作系统。");
			alert.show(); // 显示对话框
		}
	}

	@FXML
	protected void rebootButtonAction(ActionEvent event) throws InterruptedException {
		try {
			int os = DetectSystem.detectOS();
			if (os == 0) {
				Windows.reboot();
			} else if (os == 1) {
				Linux.reboot();
			} else {
				MacOS.reboot();
			}
		} catch (Exception e) {
			// TODO: handle exception
			Alert alert = new Alert(Alert.AlertType.ERROR); // 创建一个消息对话框
			alert.setHeaderText("ERROR"); // 设置对话框的头部文本
			// 设置对话框的内容文本
			alert.setContentText("不支持的操作系统。");
			alert.show(); // 显示对话框
		}
	}

	@FXML
	protected void cancelButtonAction(ActionEvent event) throws InterruptedException {
		try {
			int os = DetectSystem.detectOS();
			if (os == 0) {
				Windows.cancel();
			} else if (os == 1) {
				Linux.cancel();
			} else {
				MacOS.cancel();
			}
		} catch (Exception e) {
			// TODO: handle exception
			Alert alert = new Alert(Alert.AlertType.ERROR); // 创建一个消息对话框
			alert.setHeaderText("ERROR"); // 设置对话框的头部文本
			// 设置对话框的内容文本
			alert.setContentText("不支持的操作系统。");
			alert.show(); // 显示对话框
		}
	}

	@FXML
	protected void menuNothingAction(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION); // 创建一个消息对话框
		alert.setHeaderText("信息"); // 设置对话框的头部文本
		// 设置对话框的内容文本
		alert.setContentText("真的什么都没有。");
		alert.show(); // 显示对话框
	}

	@FXML
	protected void menuQuitAction(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	protected void menuInfoAction(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION); // 创建一个消息对话框
		alert.setHeaderText("帮助"); // 设置对话框的头部文本
		// 设置对话框的内容文本
		alert.setContentText(
				"设定时间前鼠标在每个参数上划划水会准一点(更新数据)。\n模式：\n* 倒计时关机----计时关机\n* 计划任务关机--定点关机\n* Run  -- 运行\n* 重启 -- 重新启动计算机\n* 取消 -- 取消当前的关机任务\n\n所有时间操作均通过鼠标滚轮完成。");
		alert.show(); // 显示对话框
	}

	@FXML
	protected void menuAboutAction(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION); // 创建一个消息对话框
		alert.setHeaderText("关于"); // 设置对话框的头部文本
		// 设置对话框的内容文本
		alert.setContentText("名称：计划关机程序2.0\n作者：Ryan Yim\n日期：2020-04-04\n平台：Windows、Linux");
		alert.show(); // 显示对话框
	}

	@FXML
	protected void YearAction() {
		Nian.setText(String.valueOf(LocalDateTime.now().getYear()));
	}

	@FXML
	protected void MonthAboutAction() {
		Yue.setText(String.valueOf(LocalDateTime.now().getMonthValue()));
	}

	@FXML
	protected void DayAboutAction() {
		Ri.setText(String.valueOf(LocalDateTime.now().getDayOfMonth()));
	}

	@FXML
	protected void HoursAboutAction() {
		Shi.setText(String.valueOf(LocalDateTime.now().getHour()));
	}

	@FXML
	protected void MinutesAboutAction() {
		Fen.setText(String.valueOf(LocalDateTime.now().getMinute()));
	}

	@FXML
	protected void SecondsAboutAction() {
		Miao.setText(String.valueOf(LocalDateTime.now().getSecond()));
	}

	/**
	 * 内部的初始化方法
	 * 初始化背景图等
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		InitStart();
		SynStatic();
		InitSlider();
		ChangeTime();
//		An.setStyle("-fx-background-image:url('/resources/R.png')");
		An.getStyleClass().add("bgm");
		Me.getStyleClass().add("menu");
	}
	
	
	
	/**
	 * 初始化年月日以及检查系统类型
	 * 用于程序刚启动时
	 */
	private void InitStart() {

		/**
		 * 初始化年月日参数
		 */
		LocalDateTime time = LocalDateTime.now();
		Nian.setText(String.valueOf(time.getYear()));
		Yue.setText(String.valueOf(time.getMonthValue()));
		Ri.setText(String.valueOf(time.getDayOfMonth()));
		Shi.setText(String.valueOf(time.getHour()));
		Fen.setText(String.valueOf(time.getMinute()));
		Miao.setText(String.valueOf(time.getSecond()));

		/**
		 * 类参数赋值
		 */
		YEAR = Integer.valueOf(Nian.getText());
		MONTH = Integer.valueOf(Yue.getText());
		DAY = Integer.valueOf(Ri.getText());
//		HOUR = Integer.valueOf(Hour.getText());
//		MINUTE = Double.valueOf(Min.getText());
		HOUR = 0;
		MINUTE = 0;
		SECOND = Integer.valueOf(Miao.getText());
		time = null;
		/**
		 * 检测系统类型，非Windows与Linux发出警告
		 */
		int os = DetectSystem.detectOS();
		if (os == 0 || os == 1) {
			System.out.println("Starting......");
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING); // 创建一个消息对话框
			alert.setHeaderText("提示"); // 设置对话框的头部文本
			alert.setContentText("程序不确定是否兼容您的系统！\n您当前的操作系统：" + System.getProperties().getProperty("os.name"));
			alert.show(); // 显示对话框
		}
	}

	/**
	 * 滑动条初始化
	 */
	private void InitSlider() {
		/**
		 * 设置滑动条值为0.1，要不报错，小于零
		 */
		S_Hour.setValue(0.1);
		S_Min.setValue(0.1);
		S_Mode.setValue(1.0);
		/**
		 * 设置滑块和滚轮一起动
		 */
		S_Hour.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY();
				if (deltaY > 0) {
//					if (S_Hour.getValue()<=0) {
//						System.out.println();
//					}
//					else {
//						S_Hour.setValue(S_Hour.getValue() - 1);
//					}
					S_Hour.setValue(S_Hour.getValue() - 1);
				} else if (deltaY < 0) {
					S_Hour.setValue(S_Hour.getValue() + 1);
				}
				if (MODE == 1) {
					HOUR = Integer.valueOf(Hour.getText());
				} else {

				}
			}
		});
		S_Min.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY() / 20;
				if (deltaY > 0) {
					S_Min.setValue(S_Min.getValue() - 1);
				} else if (deltaY < 0) {
					S_Min.setValue(S_Min.getValue() + 1);
				}
				if (MODE == 1) {
					MINUTE = Double.valueOf(Min.getText());
				} else {

				}
			}
		});
		S_Mode.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY();
				if (deltaY > 0) {
					S_Mode.setValue(1);
				} else if (deltaY < 0) {
					S_Mode.setValue(0);
				} else {
					System.out.println("MODE NO SET");
				}
				MODE = (int) S_Mode.getValue();
//				System.out.println("MODE set" + MODE);
			}
		});
		/**
		 * 滑动条滚轮事件
		 * 和下面的lambda表达式一样的作用，这里用的是匿名内部类
		 */
//		S_Hour.valueProperty().addListener(new ChangeListener<Number>() {
//			@Override
//			public void changed(ObservableValue<? extends Number> observable,Number oldValue, Number newValue) {
//				Hour.setText(String.format("%.1sf", newValue));
//			}
//		});
//		S_Min.valueProperty().addListener(new ChangeListener<Number>() {
//			@Override
//			public void changed(ObservableValue<? extends Number> observable,Number oldValue, Number newValue) {
//				Min.setText(String.format("%.1sf", newValue));
//			}
//		});
		/**
		 * 下面是上面的Lambda表达式
		 */
		S_Hour.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
//			Hour.setText(String.format("%.2f", new_val));
			int x = new_val.intValue();
			Hour.setText(String.valueOf(x));
		});
		S_Min.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
			double x = new_val.doubleValue() / 2;
			Min.setText(String.valueOf(x));
		});
		S_Mode.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
			MODE = (int) S_Mode.getValue();
		});
	}

	/**
	 * 更新数据到Static参数
	 */
	private void SynStatic() {
		/**
		 * 同步static参数
		 */
		Nian.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (MODE == 0) {
					YEAR = Integer.valueOf(newValue);
//					System.out.println();
				} else {
//					System.out.println("Nian disable");
				}
			}
		});
		Yue.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (MODE == 0) {
					MONTH = Integer.valueOf(newValue);
				} else {
//					System.out.println("Yue disable");
				}
			}
		});
		Ri.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (MODE == 0) {
					DAY = Integer.valueOf(newValue);
				} else {
//					System.out.println("Ri disable");
				}
			}
		});
		Hour.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (MODE == 1) {
					HOUR = Integer.valueOf(newValue);
				} else {
//					System.out.println("Hour disable");
				}
			}
		});
		Shi.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (MODE == 0) {
					HOUR = Integer.valueOf(newValue);
				} else {
//					System.out.println("Shi disable");
				}
			}
		});
		Min.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				System.out.println(MODE==1);
				if (MODE == 1) {
					MINUTE = Double.valueOf(newValue);
//					System.out.println(MINUTE);
				} else {
//					System.out.println("Min disable");
				}
			}
		});
		Fen.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (MODE == 0) {
					MINUTE = Double.valueOf(newValue);
				} else {
//					System.out.println("Fen disable");
				}
			}
		});
		Miao.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (MODE == 0) {
					SECOND = Integer.valueOf(newValue);
				} else {
//					System.out.println("Miao disable");
				}
			}
		});
	}

	/**
	 * 滚轮调整时间的方法
	 */
	private void ChangeTime() {
		Nian.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				if (MODE == 0) {
					double deltaY = event.getDeltaY();
					if (deltaY > 0) {
						int x = Integer.valueOf(Nian.getText()) + 1;
						Nian.setText(String.valueOf(x));
					} else if (deltaY < 0) {
						int x = Integer.valueOf(Nian.getText());
						if (x > LocalDateTime.now().getYear()) {
							x = x - 1;
							Nian.setText(String.valueOf(x));
						} else {

						}
					} else {

					}
				}
			}
		});
		Yue.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				if (MODE == 0) {
					double deltaY = event.getDeltaY();
					if (deltaY > 0) {
						int x = Integer.valueOf(Yue.getText()) + 1;
						if (x < 13) {
							Yue.setText(String.valueOf(x));
						} else if (x > 13) {

						}
					} else if (deltaY < 0) {
						int x = Integer.valueOf(Yue.getText());
						// 如果年>当前
						if (x > 1 && YEAR > LocalDateTime.now().getYear()) {
							x = x - 1;
							Yue.setText(String.valueOf(x));
						}
						// 如果年<=当前
						else if (x > LocalDateTime.now().getMonthValue() && YEAR <= LocalDateTime.now().getYear()) {
							x = x - 1;
							Yue.setText(String.valueOf(x));
						} else {

						}
					} else {

					}
				}
			}
		});
		Ri.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				if (MODE == 0) {
					double deltaY = event.getDeltaY();
					if (deltaY > 0) {
						int x = Integer.valueOf(Ri.getText()) + 1;
						if (x < 32) {
							Ri.setText(String.valueOf(x));
						}
					} else if (deltaY < 0) {
						int x = Integer.valueOf(Ri.getText());
						// 如果年>当前
						if (x > 1 && YEAR > LocalDateTime.now().getYear()) {
							x = x - 1;
							Ri.setText(String.valueOf(x));
						}
						// 如果年<=当前，月>当前
						else if (x > 1 && YEAR <= LocalDateTime.now().getYear()
								&& MONTH > LocalDateTime.now().getMonthValue()) {
							x = x - 1;
							Ri.setText(String.valueOf(x));
						}
						// 如果年月<=当前
						else if (x > LocalDateTime.now().getDayOfMonth()) {
							x = x - 1;
							Ri.setText(String.valueOf(x));
						} else {

						}
					} else {

					}
				}
			}
		});
		Shi.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				if (MODE == 0) {
					double deltaY = event.getDeltaY();
					if (deltaY > 0) {
						int x = Integer.valueOf(Shi.getText()) + 1;
						if (x < 24) {
							Shi.setText(String.valueOf(x));
						}
					} else if (deltaY < 0) {
						int x = Integer.valueOf(Shi.getText());
						// 如果年>当前
						if (x > 1 && YEAR > LocalDateTime.now().getYear()) {
							x = x - 1;
							Shi.setText(String.valueOf(x));
						}
						// 如果年<=当前 月>当前
						else if (x > 1 && YEAR <= LocalDateTime.now().getYear()
								&& MONTH > LocalDateTime.now().getMonthValue()) {
							x = x - 1;
							Shi.setText(String.valueOf(x));
						}
						// 如果年月<=当前 日>当前
						else if (x > 1 && YEAR <= LocalDateTime.now().getYear()
								&& MONTH <= LocalDateTime.now().getMonthValue()
								&& DAY > LocalDateTime.now().getDayOfMonth()) {
							x = x - 1;
							Shi.setText(String.valueOf(x));
						}
						// 年月日<=当前
						else if (x > LocalDateTime.now().getHour()) {
							x = x - 1;
							Shi.setText(String.valueOf(x));
						} else {

						}
					} else {

					}
				}
			}
		});
		Fen.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				if (MODE == 0) {
					double deltaY = event.getDeltaY();
					if (deltaY > 0) {
						int x = Integer.valueOf(Fen.getText()) + 1;
						if (x < 60) {
							Fen.setText(String.valueOf(x));
						}
					} else if (deltaY < 0) {
						int x = Integer.valueOf(Fen.getText());
						// 年>=当前
						if (x > 1 && YEAR > LocalDateTime.now().getYear()) {
							x = x - 1;
							Fen.setText(String.valueOf(x));
						} else if (x > 1 && YEAR <= LocalDateTime.now().getYear()
								&& MONTH > LocalDateTime.now().getMonthValue()) {
							x = x - 1;
							Fen.setText(String.valueOf(x));
						} else if (x > 1 && YEAR <= LocalDateTime.now().getYear()
								&& MONTH <= LocalDateTime.now().getMonthValue()
								&& DAY > LocalDateTime.now().getDayOfMonth()) {
							x = x - 1;
							Fen.setText(String.valueOf(x));
						} else if (x > 1 && YEAR <= LocalDateTime.now().getYear()
								&& MONTH <= LocalDateTime.now().getMonthValue()
								&& DAY <= LocalDateTime.now().getDayOfMonth() && HOUR > LocalDateTime.now().getHour()) {
							x = x - 1;
							Fen.setText(String.valueOf(x));
						} else if (x > LocalDateTime.now().getMinute()) {
							x = x - 1;
							Fen.setText(String.valueOf(x));
						} else {

						}
					} else {

					}
				}
			}
		});
		Miao.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				if (MODE == 0) {
					double deltaY = event.getDeltaY();
					if (deltaY > 0) {
						int x = Integer.valueOf(Miao.getText()) + 1;
						if (x < 60) {
							Miao.setText(String.valueOf(x));
						}
					} else if (deltaY < 0) {
						int x = Integer.valueOf(Miao.getText());

						if (x > 1 && YEAR > LocalDateTime.now().getYear()) {
							x = x - 1;
							Miao.setText(String.valueOf(x));
						} else if (x > 1 && YEAR <= LocalDateTime.now().getYear()
								&& MONTH > LocalDateTime.now().getMonthValue()) {
							x = x - 1;
							Miao.setText(String.valueOf(x));
						} else if (x > 1 && YEAR <= LocalDateTime.now().getYear()
								&& MONTH <= LocalDateTime.now().getMonthValue()
								&& DAY > LocalDateTime.now().getDayOfMonth()) {
							x = x - 1;
							Miao.setText(String.valueOf(x));
						} else if (x > 1 && YEAR <= LocalDateTime.now().getYear()
								&& MONTH <= LocalDateTime.now().getMonthValue()
								&& DAY <= LocalDateTime.now().getDayOfMonth() && HOUR > LocalDateTime.now().getHour()) {
							x = x - 1;
							Miao.setText(String.valueOf(x));
						} else if (x > 1 && YEAR <= LocalDateTime.now().getYear()
								&& MONTH <= LocalDateTime.now().getMonthValue()
								&& DAY <= LocalDateTime.now().getDayOfMonth() && HOUR <= LocalDateTime.now().getHour()
								&& MINUTE > LocalDateTime.now().getMinute()) {
							x = x - 1;
							Miao.setText(String.valueOf(x));
						} else if (x > LocalDateTime.now().getSecond()) {
							x = x - 1;
							Miao.setText(String.valueOf(x));
						} else {

						}
					} else {

					}
				}
			}
		});
	}

}
