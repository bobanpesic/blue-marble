package hellofx;

import java.text.ParseException;

import org.curiousworks.BlueMarble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlueMarbleController {

	@FXML
	private ImageView image;

	@FXML
	private DatePicker datePicker;

	@FXML
	private Button setMonochromeButton;

	@FXML
	private Button setQualityButton;

	@FXML
	void setMonochrome(ActionEvent event) {
		BlueMarble blueMarble = new BlueMarble();
		blueMarble.setDate(datePicker.getValue().getYear() + "-0" + datePicker.getValue().getMonthValue() + "-"
				+ datePicker.getValue().getDayOfMonth());
		image.setImage(new Image(blueMarble.getImage()));
		ColorAdjust grayscale = new ColorAdjust();
		grayscale.setSaturation(-1);
		image.setEffect(grayscale);

	}

	@FXML
	void setQuality(ActionEvent event) {
		BlueMarble blueMarble = new BlueMarble();
		blueMarble.setDate(datePicker.getValue().getYear() + "-0" + datePicker.getValue().getMonthValue() + "-"
				+ datePicker.getValue().getDayOfMonth());
		blueMarble.setEnhanced(true);
		image.setImage(new Image(blueMarble.getImage()));
	}

	@FXML
	void updateDate(ActionEvent event) {

		BlueMarble blueMarble = new BlueMarble();
		blueMarble.setDate(datePicker.getValue().getYear() + "-0" + datePicker.getValue().getMonthValue() + "-"
				+ datePicker.getValue().getDayOfMonth());
		ColorAdjust loseEffect = new ColorAdjust();
		loseEffect.setSaturation(0);
		try {
			blueMarble.checkDate();
			image.setImage(new Image(blueMarble.getImage()));
			if (blueMarble.checkQuality()) {
				setQualityButton.setVisible(true);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

//		blueMarble.setDate(datePicker.getValue().getYear() + "-0" + datePicker.getValue().getMonthValue() + "-" + datePicker.getValue().getDayOfMonth());
//		blueMarble.setDate(
//				"2018-0" + datePicker.getValue().getMonthValue() + "-" + datePicker.getValue().getDayOfMonth());
//		blueMarble.setEnhanced(false);
//		Image value = new Image(BlueMarble.getMostRecentImage());
//		image.setImage(new Image(blueMarble.getImage()));
	}

}
