import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;
import jcckit.GraphicsPlotCanvas;
import jcckit.data.DataCurve;
import jcckit.data.DataPlot;
import jcckit.data.DataPoint;
import jcckit.util.ConfigParameters;
import jcckit.util.PropertiesBasedConfigData;

public class AnimatedChart2 extends Applet {
	
  private double[] _data;
  private DataPlot _dataPlot;

  public AnimatedChart2(double[] _data){
	  this._data=_data;
  }
  public AnimatedChart2(){};
  public void init() {
    GraphicsPlotCanvas plotCanvas = createPlotCanvas();

    _dataPlot = new DataPlot();
    _dataPlot.addElement(new DataCurve(""));
    plotCanvas.connect(_dataPlot);

    setLayout(new BorderLayout());
    add(plotCanvas.getGraphicsCanvas(), BorderLayout.CENTER);
    add(createControlPanel(), BorderLayout.SOUTH);
  }

  private GraphicsPlotCanvas createPlotCanvas() {
    Properties props = new Properties();
    ConfigParameters config
        = new ConfigParameters(new PropertiesBasedConfigData(props));
    props.put("plot/legendVisible", "false");
    props.put("plot/coordinateSystem/xAxis/minimum", "-0.5");
    props.put("plot/coordinateSystem/xAxis/maximum", "6.5");
    props.put("plot/coordinateSystem/xAxis/axisLabel", "Array Length");
    props.put("plot/coordinateSystem/xAxis/ticLabelFormat/className",
              "jcckit.plot.TicLabelMap");
    props.put("plot/coordinateSystem/xAxis/ticLabelFormat/map",
              "0=Sum1:10;1=Sum2:10;2=Sum1:100;3=Sum2:100;4=Sum1:1000;5=Sum2:1000");
    props.put("plot/coordinateSystem/yAxis/axisLabel", "hit");
    props.put("plot/coordinateSystem/yAxis/maximum", "10");
    props.put("plot/coordinateSystem/yAxis/ticLabelFormat", "%d%%");
    props.put("plot/curveFactory/definitions", "curve");
    props.put("plot/curveFactory/curve/withLine", "false");
    props.put("plot/curveFactory/curve/symbolFactory/className", 
              "jcckit.plot.BarFactory");
    props.put("plot/curveFactory/curve/symbolFactory/attributes/className", 
              "jcckit.graphic.ShapeAttributes");
    props.put("plot/curveFactory/curve/symbolFactory/attributes/fillColor", 
              "0xfe8000");
    props.put("plot/curveFactory/curve/symbolFactory/attributes/lineColor", 
              "0");
    props.put("plot/curveFactory/curve/symbolFactory/size", "0.08");
    props.put("plot/initialHintForNextCurve/className", 
              "jcckit.plot.PositionHint");
    props.put("plot/initialHintForNextCurve/position", "0 0.1");

    return new GraphicsPlotCanvas(config);
  }
  
  private Panel createControlPanel() {
    Panel controlPanel = new Panel();
    Button startButton = new Button("Goster");
    startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  new Thread() {
                          public void run() {
                            animate();
                          }
                        }.start();
                }
              });
    controlPanel.add(startButton);
    
    return controlPanel;
  }
  private void animate() {
    DataCurve curve = new DataCurve("");
    for (int i = 0; i < _data.length; i++) {
      curve.addElement(new DataPoint(i, 0));
    }
    _dataPlot.replaceElementAt(0, curve);

    for (int i = 0; i < _data.length; i++) {
      double x = i;
      double y = 0;
      while (y < _data[i]) {
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {}
        y = Math.min(_data[i], y + 5);
        curve.replaceElementAt(i, new DataPoint(x, y));
      }
    }
  }

  public void ciz(double[] _data){
	  	Frame frame = new Frame("Animated Chart");
	    frame.addWindowListener(new WindowAdapter() {
	              public void windowClosing(WindowEvent event) {
	                System.exit(0);
	              } 
	            });
	    Applet applet = new AnimatedChart2(_data);
	    applet.init();
	    frame.add(applet);
	    frame.setSize(600, 500);
	    frame.show();
  }
}