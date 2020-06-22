package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 主界面
 * 
 * @author jessie
 */
public class TimedPoweroffMainApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/resources/Sample.fxml"));//load fxml
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/resources/application.css").toExternalForm());//load css
			primaryStage.setScene(scene);
			primaryStage.setTitle(">T< Poweroff v2.0");
			primaryStage.setResizable(false);//不可以调整窗口大小
			primaryStage.getIcons().add(new Image(TimedPoweroffMainApp.class.getResourceAsStream("/resources/Doge_white.png")));//图标
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/**
 * main方法
 * 主程序入口
 */
	public static void main(String[] args) {
		launch(args);
	}
}
