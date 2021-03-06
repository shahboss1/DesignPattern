package view;

import controller.RetrieveShapes;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a Doodleiew class which extends application.
 * @author Shahbaz Iqbal
 * @version 1.0
 */
public class DoodleView extends Application
{
    public static final int WIN_WIDTH = 1000;
    public static final int WIN_HEIGHT = 600;
    public static final int SHAPE_ICON_SIZE = 20;
    public static final int MAX_STROKE = 20;
    public static final int MIN_STROKE = 1;
    public static ArrayList <Double> x1 = new ArrayList <>( );
    public static ArrayList <Double> y1 = new ArrayList <>( );
    public static String typeOfShape = "Line";
    //public static IShapes shape;
    
    /**
     * Invokes RetrieveShape class.
     */
    public RetrieveShapes controller = new RetrieveShapes( );
    
    //drawing on the canvas
    private Canvas canvas;
    private GraphicsContext graphics;
    
    //selecting shapes
    private ToggleGroup shapeGroup;
    
    //shape settings
    private ColorPicker fillColorPicker = new ColorPicker( );
    private ColorPicker strokeColorPicker = new ColorPicker( );
    private Slider strokeSlider;
    private CheckBox filledCheckbox;
    
    /**
     * This method creates stage.
     * @param stage stage
     */
    @Override
    public void start(Stage stage)
    {
        stage.setTitle( "Doodle Program" );
        stage.setScene( getPrimaryScene( ) );
        stage.show( );
    }
    
    private Scene getPrimaryScene()
    {
        BorderPane mainPanel = new BorderPane( );
        VBox top = new VBox( );
        top.getChildren( ).addAll( buildMenu( ),getToolbar( ) );
        
        //set the primary regions
        mainPanel.setTop( top );
        mainPanel.setCenter( getCanvas( ) );
        
        Scene scene = new Scene( mainPanel,WIN_WIDTH,WIN_HEIGHT );
        scene.getStylesheets( ).add( "styles.css" );
        return scene;
    }
    
    private Parent getToolbar()
    {
        HBox panel = new HBox( );
        panel.setId( "toolbar-main" );
        panel.getChildren( ).addAll( buildShapeSection( ),buildSettings( ),buildEdit( ) );
        return panel;
    }
    ToggleButton[] buttons;
    
    private HBox buildShapeSection()
    {
        HBox shapesPanel = new HBox( );
        shapesPanel.setId( "toolbar-shapes" );
        
        String[] shapes = {"Line","Oval","Rectangle","Squiggle", "Triangle"};
        buttons = new ToggleButton[shapes.length];
        shapeGroup = new ToggleGroup( );
        
        for (int i = 0; i < shapes.length; i++)
        {
            buttons[i] = getImageToggleButton( shapes[i] );
        }
        
        buttons[0].setSelected( true );
        
        shapeGroup.getToggles( ).addAll( buttons );
        shapesPanel.getChildren( ).addAll( buttons );
        
        return shapesPanel;
    }
    
    private HBox buildSettings()
    {
        HBox settingsPanel = new HBox( );
        settingsPanel.setId( "toolbar-settings" );
        
        styleColorPicker( fillColorPicker );
        styleColorPicker( strokeColorPicker );
        
        VBox strokeBox = new VBox( );
        Label strokeLabel = new Label( "Stroke: 1" );
        strokeSlider = new Slider( );
        strokeBox.getChildren( ).addAll( strokeSlider,strokeLabel );
        
        strokeSlider.setMin( MIN_STROKE );
        strokeSlider.setMax( MAX_STROKE );
        strokeSlider.valueProperty( ).addListener( (observable,oldV,newV) ->
                strokeLabel.setText( "Stroke: " + numToInt( newV ) ) );
        
        filledCheckbox = new CheckBox( "Filled" );
        
        settingsPanel.getChildren( ).addAll( new Label( "Fill:" ),fillColorPicker,
                new Label( "Stroke:" ),strokeColorPicker,strokeBox,filledCheckbox );
        
        return settingsPanel;
    }
    
    private void styleColorPicker(ColorPicker picker)
    {
        picker.getStyleClass( ).add( ColorPicker.STYLE_CLASS_BUTTON );
        picker.setValue( Color.BLACK );
    }
    
    private int numToInt(Number value)
    {
        return (int) Math.floor( value.doubleValue( ) );
    }
    
    private HBox buildEdit()
    {
        HBox editPanel = new HBox( );
        editPanel.setId( "toolbar-edits" );
        
        String[] edits = {"undo","redo"};
        Button[] buttons = new Button[edits.length];
        
        for (int i = 0; i < edits.length; i++)
        {
            buttons[i] = getImageButton( edits[i] );
        }
        editPanel.getChildren( ).addAll( buttons );
        
        //button array for undo
        buttons[0].setOnAction( event ->
        {
            graphics.clearRect( 0,0,canvas.getWidth( ),canvas.getHeight( ) );
            controller.undoShape( graphics );
            
        } );
        
        //button array for redo
        buttons[1].setOnAction( event ->
        {
            graphics.clearRect( 0,0,canvas.getWidth( ),canvas.getHeight( ) );
            controller.redoShape( graphics );
            
        } );
        return editPanel;
    }
    
    private ImageView getButtonIcon(String text)
    {
        ImageView image = new ImageView( text + ".png" );
        image.setFitHeight( SHAPE_ICON_SIZE );
        image.setFitWidth( SHAPE_ICON_SIZE );
        return image;
    }
    
    private ToggleButton getImageToggleButton(String text)
    {
        ToggleButton result = new ToggleButton( );
        result.setGraphic( getButtonIcon( text ) );
        
        result.setOnAction( event ->
                typeOfShape = text );
        return result;
    }
    
    private Button getImageButton(String text)
    {
        Button result = new Button( );
        result.setGraphic( getButtonIcon( text ) );
        return result;
    }
    
    
    private Parent getCanvas()
    {
        VBox box = new VBox( );
        canvas = new Canvas( WIN_WIDTH,WIN_HEIGHT );
        graphics = canvas.getGraphicsContext2D( );
        canvas.setStyle( "-fx-background-color: black" );
        box.setStyle( "-fx-background-color: #FFFFFF;" );
        
        canvas.setOnMousePressed( event ->
        {
            x1.add( event.getX( ) );
            y1.add( event.getY( ) );
        } );
        
        canvas.setOnMouseDragged( event ->
        {
            double x2 = event.getX( );
            double y2 = event.getY( );
            x1.add( x2 );
            y1.add( y2 );
            graphics.clearRect( 0,0,canvas.getWidth( ),canvas.getHeight( ) );
            controller.addShape( graphics,x1,y1,typeOfShape,fillColorPicker.getValue( ),strokeColorPicker.getValue( ),strokeSlider.getValue( ),filledCheckbox.isSelected( ) );
            controller.redrawAllShapes( graphics );
            controller.removePreviousShape( );
            
            
        } );
        canvas.setOnMouseReleased( event ->
        {
            double x2 = event.getX( );
            double y2 = event.getY( );
            x1.add( x2 );
            y1.add( y2 );
            controller.addShape( graphics,x1,y1,typeOfShape,fillColorPicker.getValue( ),strokeColorPicker.getValue( ),strokeSlider.getValue( ),filledCheckbox.isSelected( ) );
            controller.redrawAllShapes( graphics );
            x1.clear( );
            y1.clear( );
            
        } );
        box.getChildren( ).add( canvas );
        return box;
    }
    
    private MenuBar buildMenu()
    {
        
        MenuBar menuBar = new MenuBar( );
        Menu file = new Menu( "File" );
        Menu edit = new Menu( "Edit" );
        Menu draw = new Menu( "Draw" );
        Menu help = new Menu( "Help" );
        
        fileMenu( file );
        editMenu( edit );
        drawMenu( draw );
        help( help );
        
        menuBar.getMenus( ).addAll( file,edit,draw,help );
        return menuBar;
    }
    
    private void fileMenu(Menu file)
    {
        MenuItem[] items = {new MenuItem( "Quit" )};
        file.getItems( ).addAll( items );
        file.setOnAction( event ->
                Platform.exit( ) );
    }
    
    private void editMenu(Menu edit)
    {
        MenuItem[] items = {new MenuItem( "Undo" ),new MenuItem( "Redo" )};
        edit.getItems( ).addAll( items );
        
            //button array for undo
            items[0].setOnAction( event ->
            {
                graphics.clearRect( 0,0,canvas.getWidth( ),canvas.getHeight( ) );
                controller.undoShape( graphics );
        
            } );
    
            //button array for redo
            items[1].setOnAction( event ->
            {
                graphics.clearRect( 0,0,canvas.getWidth( ),canvas.getHeight( ) );
                controller.redoShape( graphics );

            } );
        
    }
    
    private void drawMenu(Menu draw)
    {
        Menu shapesMenu = new Menu( "Shape Tools" );
        MenuItem[] shapes = {new MenuItem( "Line" ),new MenuItem( "Oval" ),
                new MenuItem( "Rectangle" ),new MenuItem( "Squiggle" ),new MenuItem( "Triangle" )};
        shapesMenu.getItems( ).addAll( shapes );
        draw.getItems( ).add( shapesMenu );
    
        for (MenuItem clickImage : shapes)
        {
            clickImage.setOnAction( event ->
            {
                typeOfShape = clickImage.getText( );
                updateToggle( clickImage.getText( ) );
            } );
        }
        
        MenuItem clear = new MenuItem( "Clear Shapes" );
        draw.getItems( ).add( clear );
        clear.setOnAction( event ->
        {
            System.out.println( "testing clear" );
            controller.clearAll( graphics );
            graphics.clearRect( 0,0,canvas.getWidth( ),canvas.getHeight( ) );
        } );
    }
    
    private void updateToggle(String text)
    {
        
        switch (text)
        {
            case "Line":
                buttons[0].setSelected( true );
                buttons[0].requestFocus( );
                
                break;
            case "Oval":
                buttons[1].setSelected( true );
                buttons[1].requestFocus( );
                break;
            
            case "Rectangle":
                buttons[2].setSelected( true );
                buttons[2].requestFocus( );
                break;
            
            case "Squiggle":
                buttons[3].setSelected( true );
                buttons[3].requestFocus( );
                break;
            case "Triangle":
                buttons[4].setSelected( true );
                buttons[4].requestFocus( );
                break;
        }
    }
    
    private void help(Menu about)
    {
        MenuItem[] items = {new MenuItem( "About" )};
        about.setOnAction( e ->
                alertBox( ) );
        about.getItems( ).addAll( items );
    }
    
    private void alertBox()
    {
        Alert alert = new Alert( Alert.AlertType.INFORMATION );
        alert.setTitle( "Doodle Application" );
        alert.setHeaderText( "Doodle Application Version 1.0" );
        String stringName = "By: Shahbaz Iqbal <siqbal2@mail.greenriver.edu>";
        alert.setContentText( stringName );
        alert.show( );
    }
    
    /**
     * This is a toString method.
     * @return toString.
     */
    @Override
    public String toString()
    {
        
        return "DoodleView{" +
                "controller=" + controller +
                ", canvas=" + canvas +
                ", graphics=" + graphics +
                ", shapeGroup=" + shapeGroup +
                ", fillColorPicker=" + fillColorPicker +
                ", strokeColorPicker=" + strokeColorPicker +
                ", strokeSlider=" + strokeSlider +
                ", filledCheckbox=" + filledCheckbox +
                ", buttons=" + Arrays.toString( buttons ) +
                '}';
    }
}
