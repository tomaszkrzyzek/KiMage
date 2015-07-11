package kimage.utils.gui;

import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import kimage.image.Image;

/**
 *
 * @author Krzysztof
 */
public class ImageFrame extends JFrame {

    FilenameFilter fileNameFilter;
    ResizableImagePanel imageView;

    public ImageFrame(String title) {
        super(title == null ? "Step Handler Executor" : title);
        LookAndFeel.doIt();
        EscapeClose.doIt(this);


        imageView = new ResizableImagePanel();

//        fileNameFilter = (File file, String name1) -> true;
        
        fileNameFilter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return true;
            }
        };

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new JScrollPane(imageView));
        setLocationByPlatform(true);
        pack();
        setSize(800, 600);
    }

    public ImageFrame(Image image)  {
        this();
        imageView.setImage(image.getBufferedImage());
    }
    
    private ImageFrame() {
        this("");
    }

    
    public static void display(Image img){
        ImageFrame i = new ImageFrame(img);
        i.display();
    }
    
    public static void displayCopy(Image img){
        display(img.copy());
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            ImageFrame imageList1 = new ImageFrame();
//            imageList1.setVisible(true);
//        });
//    }

    public void display() {
        this.setVisible(true);
    }

}
