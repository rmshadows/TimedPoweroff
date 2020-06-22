/**
 * @author jessie
 * TimedPoweroff定时关机模块
 * @version v2.0
 * 2020-06-22 Edit
 */
module cn.rmshadows.TimedPoweroff {
	exports application;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	
	opens resources to javafx.fxml;
}
