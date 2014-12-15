// This entire file is part of my masterpiece.
// Eli Lichtenberg

package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import authoring.model.GameData;
import authoring.model.collections.GeneralCollection;

import com.google.gson.GsonBuilder;

import engine.actions.Action;
import engine.conditions.Condition;
import engine.physics.Force;
import engine.physics.Scalar;

/**
 * DataManager that saves and loads JSON files.
 * 
 * @author Eli Lichtenberg
 * @author Safkat Islam
 *
 */
public class JSONDataManager implements DataManager {
	
	private GsonBuilder gson;
	
	public JSONDataManager() {
		gson = new GsonBuilder();
		gson.registerTypeAdapter(Condition.class, new GenericTypeAdapter<Condition>("engine.conditions"));
		gson.registerTypeAdapter(Action.class, new GenericTypeAdapter<Action>("engine.actions", "engine.actions.translate"));
		gson.registerTypeAdapter(GeneralCollection.class, new GenericTypeAdapter<GeneralCollection>("authoring.model.collections"));
		gson.registerTypeAdapter(Force.class, new GenericTypeAdapter<Force>("engine.physics"));
		gson.registerTypeAdapter(Scalar.class, new GenericTypeAdapter<Scalar>("engine.physics"));
	}
	
	/**
	 * Creates a Json file based on an object representing a game.
	 * @param dataPath Game folder location.
	 * @param data Game data being saved.
	 * @return
	 * @throws IOException
	 */
	public boolean writeGameFile(File dataPath, GameData data) throws IOException {
		String fileName = dataPath.getName() + ".json";
		return writeFile(dataPath, fileName, data);
	}
	
	/**
	 * Gets an object representing a game from a Json file.
	 * @param dataPath Game folder location.
	 * @return
	 * @throws FileNotFoundException
	 */
	public GameData readGameFile(File dataPath) throws FileNotFoundException {
		String fileName = dataPath.getName() + ".json";
		return (GameData)readFile(dataPath, fileName, GameData.class);
	}
	
	/**
	 * Creates a Json file based on an object representing a game at a certain 
	 * progress state.
	 * @param dataPath Game folder location.
	 * @param progressName Name of progress state file.
	 * @param data Game progress data being saved.
	 * @return
	 * @throws IOException
	 */
	public boolean writeProgressFile(File dataPath, String progressName, GameData data) 
			throws IOException {
		String fileName = PROGRESS_FOLDER_NAME + "/" + progressName + ".json";
		return writeFile(dataPath, fileName, data);
	}
	
	/**
	 * Gets an object representing a game at a certain progress state from a 
	 * Json file.
	 * @param dataPath Game folder location.
	 * @param progressName Name of progress state file.
	 * @return
	 * @throws FileNotFoundException
	 */
	public GameData readProgressFile(File dataPath, String progressName) throws FileNotFoundException {
		String fileName = PROGRESS_FOLDER_NAME + "/" + progressName + ".json";
		return (GameData)readFile(dataPath, fileName, GameData.class);
	}
	
	private boolean writeFile(File dataPath, String fileName, Object obj) throws IOException {
			String json = gson.create().toJson(obj);
			File f = new File(dataPath, fileName);
			FileWriter writer = new FileWriter(f);
			writer.write(json);
			writer.close();
			return true;
	}
	
	private Object readFile(File dataPath, String fileName, Class cl) throws FileNotFoundException {
	    File f = new File(dataPath, fileName);
		BufferedReader br = new BufferedReader( new FileReader(f) );
		Object obj = gson.create().fromJson(br, cl);
		return obj;
	}
	
	private boolean hasValidName(String fileName) {
		if(!fileName.contains(".")) return true;
		else {
			if(fileName.endsWith(".json")) return true;
			else return false;
		}
	}
	
	private String checkForExtension(String fileName) {
		if(fileName.endsWith(".json")) return fileName;
		else return fileName + ".json";
	}
}
