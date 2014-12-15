package gamePlayer.view;

import java.io.File;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * 
 * @author Abhishek B
 *
 */
public class FileSelectionWizard {

	private Stage myFileStage;

	public File selectFile() {
		myFileStage = new Stage();
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Open Resource File");
		return directoryChooser.showDialog(myFileStage);
	}

}
