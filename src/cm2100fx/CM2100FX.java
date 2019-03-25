/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm2100fx;

import algorithms.CWAlgorithms;
import java.util.ArrayList;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Michal Petrycki
 */

/*
    Application draws time complexity charts for Merge Sort and Quick Sort 
    and space complexity chart for Merge Sort. I used TabPanel for Merge Sort 
    charts. 
*/
public class CM2100FX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        quickBtn = new Button("Quick Sort");
        mergeBtn = new Button("Merge Sort");
        
        root = new VBox();
        topPanel = new HBox();
        bottomPanel = new VBox();
        tabPane = new TabPane();
        
        timeTab = new Tab();
        spaceTab = new Tab();
        
        algorithms = new CWAlgorithms();
        maps = algorithms.getMaps();
        
        merge_time_chart = drawMergeTimeChart(maps.get(0));
        merge_space_chart = drawMergeSpaceChart(maps.get(1));
        quick_chart = drawQuickChart(maps.get(2));
        
        timeTab.setContent(merge_time_chart);
        timeTab.setText("Time chart");
        timeTab.setClosable(false);
        spaceTab.setContent(merge_space_chart);
        spaceTab.setText("Space chart");
        spaceTab.setClosable(false);
        
        tabPane.getTabs().addAll(timeTab, spaceTab);
        
        
        topPanel.getChildren().addAll(quickBtn, mergeBtn);
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setPadding(new Insets(25, 0, 25, 0));
        topPanel.setSpacing(25);
        mergeBtn.setPrefWidth(120);
        quickBtn.setPrefWidth(120);
        
        bottomPanel.getChildren().add(quick_chart);
        
        quickBtn.setOnAction((e) -> {
        
            bottomPanel.getChildren().clear();
            bottomPanel.getChildren().add(quick_chart);
        
        });
        
        mergeBtn.setOnAction((e) -> {
        
            bottomPanel.getChildren().clear();
            bottomPanel.getChildren().add(tabPane);
        
        });
        
        root.getChildren().addAll(topPanel, bottomPanel);
        
        Scene scene = new Scene(root, 900, 520);
        
        primaryStage.setTitle("CM2100 CourseWork");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //Draws time chart for merge sort
    public LineChart drawMergeTimeChart(Map<Integer, Double> map){
    
        //Local map variable 
        Map<Integer, Double> space_map = map;
        
        //x axis data; number of items
        Integer[] xdata = space_map.keySet().toArray(new Integer[0]);
        //y axis data; number of operations
        Double[] ydata = space_map.values().toArray(new Double[0]);
        
        //Axis creation
        NumberAxis xaxis = new NumberAxis();
        NumberAxis yaxis = new NumberAxis();
        
        //Labels for axis
        xaxis.setLabel("No. of items");
        yaxis.setLabel("No. of characteristic operations");
        
        //Creating data set variable
        XYChart.Series data = new XYChart.Series();
        //Setting name for data set
        data.setName("Merge Sort - time taken chart");
        
        //Adding data to data set
        for(int i = 0; i < xdata.length; i++)
            data.getData().add(new XYChart.Data(xdata[i], ydata[i]));
        
        //Creating chart
        LineChart<Number, Number> chart = new LineChart(xaxis, yaxis);
        
        //Adding data to chart
        chart.getData().add(data);
        
        //Making line chart more visible by not creating any symbols for values
        chart.setCreateSymbols(false);
        
        //Returns chart
        return chart;
        
    }
    
    //Draws space chart for merge sort
    public LineChart drawMergeSpaceChart(Map<Integer, Double> map){
    
        //Local map variable 
        Map<Integer, Double> space_map = map;
        
        //x axis data; number of items
        Integer[] xdata = space_map.keySet().toArray(new Integer[0]);
        //y axis data; number of operations
        Double[] ydata = space_map.values().toArray(new Double[0]);
        
        //Axis creation
        NumberAxis xaxis = new NumberAxis();
        NumberAxis yaxis = new NumberAxis();
        
        //Labels for axis
        xaxis.setLabel("No. of items");
        yaxis.setLabel("No. of characteristic operations");
        
        //Creating data set variable
        XYChart.Series data = new XYChart.Series();
        //Setting name for data set
        data.setName("Merge Sort - space taken chart");
        
        //Adding data to data set
        for(int i = 0; i < xdata.length; i++)
            data.getData().add(new XYChart.Data(xdata[i], ydata[i]));
        
        //Creating chart
        LineChart<Number, Number> chart = new LineChart(xaxis, yaxis);
        
        //Adding data to chart
        chart.getData().add(data);
        
        //Making line chart more visible by not creating any symbols for values
        chart.setCreateSymbols(false);
        
        //Returns chart
        return chart;
    
    }
    
    //Draws time chart for quick sort
    public LineChart drawQuickChart(Map<Integer, Double> map){
    
        //Local map variable 
        Map<Integer, Double> quick_map = map;
        
        //x axis data; number of items
        Integer[] xdata = quick_map.keySet().toArray(new Integer[0]);
        //y axis data; number of operations
        Double[] ydata = quick_map.values().toArray(new Double[0]);
        
        //Axis creation
        NumberAxis xaxis = new NumberAxis();
        NumberAxis yaxis = new NumberAxis();
        
        //Labels for axis
        xaxis.setLabel("No. of items");
        yaxis.setLabel("No. of characteristic operations");
        
        //Creating data set variable
        XYChart.Series data = new XYChart.Series();
        //Setting name for data set
        data.setName("Quick Sort - time taken chart");
        
        //Adding data to data set
        for(int i = 0; i < xdata.length; i++)
            data.getData().add(new XYChart.Data(xdata[i], ydata[i]));
        
        //Creating chart
        LineChart<Number, Number> chart = new LineChart(xaxis, yaxis);
        
        //Adding data to chart
        chart.getData().add(data);
        
        //Making line chart more visible by not creating any symbols for values
        chart.setCreateSymbols(false);
        
        //Returns chart
        return chart;
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private Button quickBtn;
    private Button mergeBtn;
    
    private VBox root;
    private HBox topPanel;
    private VBox bottomPanel;
    private TabPane tabPane;
    
    private Tab timeTab;
    private Tab spaceTab;
    
    private CWAlgorithms algorithms;
    private ArrayList<Map> maps;
    
    private LineChart merge_time_chart;
    private LineChart merge_space_chart;
    private LineChart quick_chart;
    
}
