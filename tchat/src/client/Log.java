package client;
/**
 * Class Log.java
 * 
 * DialogBox to give to the client the name of the user
 */
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QTextEdit;
import com.trolltech.qt.gui.QVBoxLayout;
import com.trolltech.qt.gui.QWidget;

public class Log extends QWidget{
	private QLabel label;
	private QPushButton bp;
	private QTextEdit te;
	private QVBoxLayout layout;
	
	public Signal1<String> getId;
	
	/**
	 * Default constructor
	 */
	public Log(){
		
		getId = new Signal1<String>();
		
		label = new QLabel("Enter your name");
		
		//Connection between the click on the button and the function validate()
		bp = new QPushButton("ok");
		bp.clicked.connect(this, "validate()");
		
		te = new QTextEdit();
		
		layout = new QVBoxLayout();
		layout.addWidget(label);
		layout.addWidget(te);
		layout.addWidget(bp);
		setLayout(layout);
	}
	
	/**
	 * Function to emit teh result and hide the window
	 */
	public void validate(){
		getId.emit(te.toPlainText());
		te.setText("");
		this.hide();
	}
}