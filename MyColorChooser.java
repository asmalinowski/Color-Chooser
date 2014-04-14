import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class MyColorChooser extends JFrame {
	private JPanel  contentPane;
	private JSlider redSlider;
	private JSlider greenSlider;
	private JSlider blueSlider;
	private JTextField  redValue;
	private JTextField  greenValue;
	private JTextField  blueValue;
	private JPanel  colorPanel;
	private int iRed;
        private int iGreen;
        private int iBlue;
	
	public MyColorChooser() {
		super("MyColorChooser");
		this.initializeFrame();
		this.buildSliderPanel();
		this.buildColorPanel();
	}
	
	private void initializeFrame() {
		contentPane = new JPanel( new BorderLayout() );
		super.setContentPane(contentPane);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setBackground(Color.WHITE);
	}
	
	private void buildSliderPanel() {
		JPanel sliderPanel = new JPanel( new FlowLayout() );
		this.addLabelsTo(sliderPanel);
		this.addSlidersTo(sliderPanel);
		this.addNumberLabelsTo(sliderPanel);
		contentPane.add(sliderPanel, BorderLayout.NORTH);
		iRed = iGreen = iBlue = 255;
	}
	
	private void addLabelsTo(JPanel containingPanel) {
		JPanel labelPane = new JPanel( new GridLayout(3,1) );
		labelPane.add( new JLabel("Red") );
		labelPane.add( new JLabel("Green") );
		labelPane.add( new JLabel("Blue") );
		containingPanel.add(labelPane);
	}
	
	private void addSlidersTo(JPanel containingPanel) {
		JPanel sliderSubPane = new JPanel( new GridLayout(3,1) );
		redSlider = new JSlider(0, 255);
		redSlider.setValue(255);
		redSlider.addChangeListener( new RedSliderListener() );
		sliderSubPane.add(redSlider);
		greenSlider = new JSlider(0, 255);
		greenSlider.setValue(255);
		greenSlider.addChangeListener( new GreenSliderListener() );
		sliderSubPane.add(greenSlider);
		blueSlider = new JSlider(0, 255);
		blueSlider.setValue(255);
		blueSlider.addChangeListener( new BlueSliderListener() );
		sliderSubPane.add(blueSlider);
		containingPanel.add(sliderSubPane);
	}
	
	private void addNumberLabelsTo(JPanel containingPanel) {
		JPanel numberPane = new JPanel( new GridLayout(3,1) );
		redValue = new JTextField("255");
		numberPane.add(redValue);
		greenValue = new JTextField("255");
		numberPane.add(greenValue);
		blueValue = new JTextField("255");
		numberPane.add(blueValue);
		containingPanel.add(numberPane);
	}
	
	private void buildColorPanel() {
		colorPanel = new JPanel();
		colorPanel.setPreferredSize( new Dimension(300, 100) );
		colorPanel.setBackground(Color.WHITE);
		contentPane.add(colorPanel, BorderLayout.CENTER);
	}
	
	
	private class RedSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent ce) {
			iRed = redSlider.getValue();
			redValue.setText( Integer.toString(iRed) );
			colorPanel.setBackground( new Color(iRed, iGreen, iBlue) );
		}
	}
	
	private class GreenSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent ce) {
			iGreen = greenSlider.getValue();
			greenValue.setText( Integer.toString(iGreen) );
			colorPanel.setBackground( new Color(iRed,iGreen,iBlue) );
		}
	}

	private class BlueSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent ce) {
			iBlue = blueSlider.getValue();
			blueValue.setText( Integer.toString(iBlue) );
			colorPanel.setBackground( new Color(iRed,iGreen,iBlue) );
		}
	}
	
	private void setColor(int red, int green, int blue) {
		redSlider.setValue(red);
		redValue.setText( Integer.toString(red) );
                greenSlider.setValue(green);
		greenValue.setText( Integer.toString(green) );
		blueSlider.setValue(blue);
		blueValue.setText( Integer.toString(blue) );
		colorPanel.setBackground(new Color(red, green, blue) );
		iRed = red; iGreen = green; iBlue = blue;
        }
        
	public static void main(String[] args) {
		MyColorChooser self = new MyColorChooser();
		self.setVisible(true);
	}
}
