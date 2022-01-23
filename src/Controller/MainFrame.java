package Controller;

import View.UI.ImageDisplay;
import View.UI.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
    
    private ImageDisplay imageDisplay;

    public MainFrame(){
    
        this.setTitle("Image Viewer");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    public JPanel toolBar(){
        JPanel sheet = new JPanel();
        sheet.add(prevButton());
        sheet.add(nextButton());
        return sheet;
    }
    
    private Component nextButton(){
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }
    
    private ActionListener nextImage(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                imageDisplay.show(imageDisplay.current().next());
            }
        };
    }
    
    private Component prevButton(){
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }
    
    private ActionListener prevImage(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                imageDisplay.show(imageDisplay.current().prev());
            }
        };
    }
    
    public JPanel imageDisplay(){
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
    
}
