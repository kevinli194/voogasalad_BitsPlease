package authoring.controller;

import java.io.File;
import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import authoring.eventhandlers.AddConditionHandler;
import authoring.eventhandlers.AddImageHandler;
import authoring.eventhandlers.AddLevelHandler;
import authoring.eventhandlers.AddObjectHandler;
import authoring.eventhandlers.AddSoundHandler;
import authoring.eventhandlers.DeleteConditionHandler;
import authoring.eventhandlers.DeleteGameObjectHandler;
import authoring.eventhandlers.DeleteLevelHandler;
import authoring.eventhandlers.EditGameObjectHandler;
import authoring.eventhandlers.FileDragOverHandler;
import authoring.eventhandlers.GameObjGraphicDragHandler;
import authoring.eventhandlers.GameObjectClickHandler;
import authoring.eventhandlers.GameObjectDragHandler;
import authoring.eventhandlers.GameObjectDragToLevelHandler;
import authoring.eventhandlers.IconClickHandler;
import authoring.eventhandlers.ImageDropHandler;
import authoring.eventhandlers.LevelToViewHandler;
import authoring.eventhandlers.SaveAsNewHandler;
import authoring.eventhandlers.SoundDropHandler;
import authoring.eventhandlers.SoundsDoubleClickHandler;
import authoring.model.AuthoringModel;
import authoring.model.GameData;
import authoring.view.AuthoringView;
import authoring.view.baseclasses.AccordionContainer;
import authoring.view.baseclasses.BPContainer;
import authoring.view.conditionsview.ConditionOptions;
import authoring.view.conditionsview.ConditionsAccordionView;
import authoring.view.gameobjectsview.GameObjectOptions;
import authoring.view.gameobjectsview.GameObjectsView;
import authoring.view.graphicsview.GraphicOptions;
import authoring.view.graphicsview.ImagesView;
import authoring.view.levelview.LevelOptions;
import authoring.view.levelview.LevelsAccordionView;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.soundsview.SoundOptions;
import authoring.view.soundsview.SoundsView;

/**
 * Controller class that interacts between model and view. Holds and constructs
 * all the view components in order to allow communication between them. Allows
 * the Model and View to exchange data without knowledge of each other.
 * 
 * @author Kevin Li
 * @author Wesley Valentine
 * @author Chris Bernt
 * @author Arjun Jain
 * @author Eli Lichtenberg
 *
 */
public class AuthoringController {
	private static final double LEFT_ACCORDION_HEIGHT_RATIO = .70;
	private static final double LEFT_ACCORDION_WIDTH_RATIO = .2;
	private static final double CENTER_HEIGHT_RATIO = .92;
	private static final double CENTER_WIDTH_RATIO = .6;
	private AuthoringView myView;
	private AuthoringModel myModel;
	private ResourceBundle myLanguage;
	private double myWidth;
	private double myHeight;
	private LevelsView myLevels;
	private LevelOptions myLevelOptions;
	private GameObjectsView myGameObjects;
	private GameObjectOptions myObjectOptions;

	private ImagesView myGraphics;
	private GraphicOptions myGraphicOptions;

	private SoundsView mySounds;
	private SoundOptions mySoundOptions;

	private PropertiesView myProperties;
	private LevelsAccordionView myLevelsAccordionView;
	private ConditionsAccordionView myConditionsAccordionView;
	private ConditionOptions myConditionOptions;
	private File myGameLocation;

	public AuthoringController(AuthoringView view, AuthoringModel model,
			double width, double height, ResourceBundle language, File gameLoc) {
		myView = view;
		myModel = model;
		myWidth = width;
		myHeight = height;
		myLanguage = language;
		myGameLocation = gameLoc;
		initializeView();
	}

	/**
	 * Sets the contents of the AuthoringView - which is essentially an empty
	 * BorderPane.
	 */

	private void initializeView() {
		initializeViewComponents();
		myView.setCenter(intitializeCenter());
		myView.setLeft(initializeLeft());
		myView.setRight(initializeRight());
		initializeGameHandlers();
		initializeObs();

	}

	/**
	 * Method that initializes the observer/observable interaction between model
	 * and view components.
	 */
	private void initializeObs() {
		myModel.getImages().addObserver(myGraphics);
		myModel.getGameObjectCollection().addObserver(myGameObjects);

		myModel.getSounds().addObserver(mySounds);

		myModel.getLevels().addObserver(myLevelsAccordionView);
		myModel.getConditions().addObserver(myConditionsAccordionView);
	}

	/**
	 * Initializes all the view components that have a 1 to 1 relationship with
	 * back end data components. Provides event handlers for View objects to
	 * handle sending data to the back end.
	 */

	private void initializeViewComponents() {
		myProperties = new PropertiesView(myLanguage, myWidth, myHeight);
		myLevels = new LevelsView(myLanguage, myWidth, myHeight, myGameLocation);
		myLevelOptions = new LevelOptions(myLanguage, myWidth, myHeight);
		mySounds = new SoundsView(myLanguage, myWidth, myHeight, myGameLocation);
		mySoundOptions = new SoundOptions(myLanguage, myWidth, myHeight);

		myGraphics = new ImagesView(myLanguage, myWidth, myHeight,
				myGameLocation);
		myGraphicOptions = new GraphicOptions(myLanguage, myWidth, myHeight);

		myGameObjects = new GameObjectsView(myLanguage, myWidth, myHeight,
				myGameLocation);
		myObjectOptions = new GameObjectOptions(myLanguage, myWidth, myHeight);

		myLevelsAccordionView = new LevelsAccordionView(myLanguage, myWidth,
				myHeight);
		myConditionsAccordionView = new ConditionsAccordionView(myLanguage,
				myWidth, myHeight);
		myConditionOptions = new ConditionOptions(myLanguage, myWidth, myHeight);

	}

	/**
	 * Method that initializes and assigns the proper eventhandlers to each view
	 * component.
	 */
	private void initializeGameHandlers() {

		myGraphics.setIconEvents(new IconClickHandler(myProperties));
		myGraphics.setDragOver(new FileDragOverHandler());
		myGraphics.setDragDrop(new ImageDropHandler(myModel.getImages(),
				myGameLocation));
		mySounds.setIconEvents(new SoundsDoubleClickHandler(),
				new IconClickHandler(myProperties));
		mySounds.setDragOver(new FileDragOverHandler());
		mySounds.setDragDrop(new SoundDropHandler(myModel.getSounds(),
				myGameLocation));
		myGameObjects.setIconEvents(new GameObjectClickHandler(myProperties),
				new GameObjectDragToLevelHandler(myLevels, myModel.getLevels(),
						myProperties));

		myLevelOptions.setAddLevelButtonBehavior(new AddLevelHandler(myModel
				.getLevels(), myLevels));
		myLevelOptions.setDeleteLevelButtonBehavior(new DeleteLevelHandler(
				myModel.getLevels(), myLevels));

		myGraphicOptions.setButtonBehavior(new AddImageHandler(myModel
				.getImages(), myGameLocation));

		mySoundOptions.setButtonBehavior(new AddSoundHandler(myModel
				.getSounds(), myGameLocation));

		myObjectOptions.setButtonBehavior(new AddObjectHandler(myModel
				.getGameObjectCollection()));

		myLevels.setEventHandlers(new GameObjectClickHandler(myProperties),
				new GameObjectDragHandler(myLevels, myModel.getLevels(),
						myProperties), new GameObjGraphicDragHandler(myLevels));

		myLevelsAccordionView.setIconEvents(new LevelToViewHandler(myLevels),
				new IconClickHandler(myProperties));

		myConditionsAccordionView.setIconEvents(new IconClickHandler(
				myProperties));

		myConditionOptions
				.setAddConditionButtonBehavior(new AddConditionHandler(myModel
						.getConditions()));
		myConditionOptions
				.setDeleteConditionButtonBehavior(new DeleteConditionHandler(
						myModel.getConditions()));

		myLevelsAccordionView.setLevelEvents(new GameObjectClickHandler(
				myProperties),
				new GameObjectDragHandler(myLevels, myModel.getLevels(),
						myProperties), new GameObjGraphicDragHandler(myLevels));

		myProperties.setButtonBehaviors(new EditGameObjectHandler(myLevels,
				myModel.getLevels(), myProperties), new SaveAsNewHandler(
				myModel.getGameObjectCollection(), myProperties),
				new DeleteGameObjectHandler(myLevels, myModel.getLevels(),
						myProperties));

	}

	/**
	 * Places the correct view components into the center of the BorderPane
	 * 
	 * @return BorderPane to be displayed on the left side of the AuthoringView
	 */
	private BorderPane intitializeCenter() {
		BPContainer center = new BPContainer(myWidth * CENTER_WIDTH_RATIO,
				myHeight * CENTER_HEIGHT_RATIO);
		center.setTop(myLevelOptions);
		center.setCenter(myLevels);
		return center;

	}

	/**
	 * Places the correct view components into the left of the BorderPane
	 * 
	 * @return AccordianContainer to be displayed on the left side of the
	 *         AuthoringView
	 */

	private AccordionContainer initializeLeft() {
		AccordionContainer leftView = new AccordionContainer(myWidth, myHeight);

		BPContainer graphicsBP = new BPContainer(myWidth
				* LEFT_ACCORDION_WIDTH_RATIO, myHeight
				* LEFT_ACCORDION_HEIGHT_RATIO);
		graphicsBP.setTop(myGraphicOptions);
		graphicsBP.setCenter(myGraphics);

		BPContainer objectsBP = new BPContainer(myWidth
				* LEFT_ACCORDION_WIDTH_RATIO, myHeight
				* LEFT_ACCORDION_HEIGHT_RATIO);
		objectsBP.setTop(myObjectOptions);
		objectsBP.setCenter(myGameObjects);

		BPContainer soundsBP = new BPContainer(myWidth
				* LEFT_ACCORDION_WIDTH_RATIO, myHeight
				* LEFT_ACCORDION_HEIGHT_RATIO);
		soundsBP.setTop(mySoundOptions);
		soundsBP.setCenter(mySounds);

		BPContainer conditionBP = new BPContainer(myWidth
				* LEFT_ACCORDION_WIDTH_RATIO, myHeight
				* LEFT_ACCORDION_HEIGHT_RATIO);
		conditionBP.setTop(myConditionOptions);
		conditionBP.setCenter(myConditionsAccordionView);

		TitledPane graphics = new TitledPane(myLanguage.getString("Images"),
				graphicsBP);
		TitledPane sounds = new TitledPane(myLanguage.getString("Sounds"),
				soundsBP);
		TitledPane gameObjects = new TitledPane(
				myLanguage.getString("GameObjects"), objectsBP);
		TitledPane levels = new TitledPane(myLanguage.getString("Levels"),
				myLevelsAccordionView);

		TitledPane conditions = new TitledPane(
				myLanguage.getString("Conditions"), conditionBP);

		leftView.getPanes().addAll(graphics, sounds, gameObjects, levels,
				conditions);
		BorderPane.setAlignment(leftView, Pos.TOP_RIGHT);

		return leftView;
	}

	/**
	 * Places the correct view components into the right of the BorderPane
	 * 
	 * @return TitledPane to be displayed on the right side of the AuthoringView
	 */

	private TitledPane initializeRight() {
		TitledPane properties = new TitledPane(
				myLanguage.getString("Properties"), myProperties);
		properties.setCollapsible(false);
		return properties;
	}

	/**
	 * Method to save the data stored in the model out to a GSON File.
	 */

	public void saveData() {
		myModel.save(myGameLocation);
	}

	/**
	 * Method to load the data stored in the model from a GSON File.
	 */

	public void loadData(GameData input) {
		myModel.load(input);
	}

}
