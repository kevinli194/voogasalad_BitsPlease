// This entire file is part of my masterpiece.
// Eli Lichtenberg

package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import authoring.model.GameData;

/**
 * Responsible for loading and saving of all files within authoring 
 * environment and game engine.
 * 
 * @author Eli Lichtenberg
 */
public interface DataManager {
	
	public static final String IMAGES_FOLDER_NAME = "images";
	public static final String SOUNDS_FOLDER_NAME = "sounds";
	public static final String PROGRESS_FOLDER_NAME = "progress";
	
	/**
	 * Creates a file based on an object representing a game.
	 * @param dataPath Game folder location.
	 * @param data Game data being saved.
	 * @return
	 * @throws IOException
	 */
	public boolean writeGameFile(File dataPath, GameData data) throws IOException;
	
	/**
	 * Gets an object representing a game from a file.
	 * @param dataPath Game folder location.
	 * @return
	 * @throws FileNotFoundException
	 */
	public GameData readGameFile(File dataPath) throws FileNotFoundException;
	
	/**
	 * Creates a file based on an object representing a game at a certain 
	 * progress state.
	 * @param dataPath Game folder location.
	 * @param progressName Name of progress state file.
	 * @param data Game progress data being saved.
	 * @return
	 * @throws IOException
	 */
	public boolean writeProgressFile(File dataPath, String progressName, GameData data) throws IOException;
	
	/**
	 * Gets an object representing a game at a certain progress state from a 
	 * file.
	 * @param dataPath Game folder location.
	 * @param progressName Name of progress state file.
	 * @return
	 * @throws FileNotFoundException
	 */
	public GameData readProgressFile(File dataPath, String progressName) throws FileNotFoundException;
}
