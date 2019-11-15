
 package capture;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.bytedeco.javacpp.BytePointer;
import static org.bytedeco.javacpp.opencv_imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
import static org.bytedeco.opencv.global.opencv_core.CV_32SC1;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.MatVector;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import util.conectoBanco;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_face.FaceRecognizer;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import util.ControlPersn;
import util.ModelPersn;

public class Capture extends javax.swing.JFrame {
    
    private Capture.DaemonThread myThread = null;

// javaCV
    VideoCapture webSource = null;
    Mat cameraImage = new Mat();
    CascadeClassifier cascade = new CascadeClassifier("C:\\photos\\haarcascade_frontalface_alt.xml");
    BytePointer mem = new BytePointer();
    RectVector detectedFaces = new RectVector();
    
    // vars
    String root, firstNamePerson, lastNamePerson, officePerson, dobPerson;
    int numSamples = 25, sample = 1, idpersn;
    
    //utils
    conectoBanco conecta = new conectoBanco();
    
    
    
    public Capture(int id, String fName, String lName, String office, String dob) {
        
        initComponents();
       
        idpersn = id;
        firstNamePerson = fName;
        lastNamePerson = lName;
        officePerson = office;
        dobPerson = dob;
        
                
           startCamera();
           System.out.println("hops it get here");
        //DaemonThread startCamera = new DaemonThread();
        //startCamera.startCamera();
    
    
    }
    
   

    private Capture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_photo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        counterLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Security System - Capture Photos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CAPTURE 25 SNAPSHOTS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 330, 30));

        label_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jPanel1.add(label_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 320, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        counterLabel.setBackground(new java.awt.Color(51, 102, 255));
        counterLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        counterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        counterLabel.setText("00");
        counterLabel.setOpaque(true);
        jPanel2.add(counterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        saveButton.setBackground(new java.awt.Color(51, 153, 0));
        saveButton.setText("capture");
        saveButton.setContentAreaFilled(false);
        saveButton.setOpaque(true);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel2.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 320, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 420));

        setSize(new java.awt.Dimension(337, 451));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new Capture().setVisible(true);
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel counterLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_photo;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

class DaemonThread implements Runnable {
    protected volatile boolean runnable = false;
        
        
    @Override
    
    public void run() 
    {
        synchronized (this){
            while  (runnable){
                try {
                    if (webSource.grab()){
                        webSource.retrieve(cameraImage);
                        Graphics g = label_photo.getGraphics();
                        Mat imageColor = new Mat();
                        imageColor = cameraImage;
                        
                        Mat imageGray = new Mat();
                        cvtColor(imageColor, imageGray, COLOR_BGRA2GRAY);
                        
                        RectVector detectedFaces = new RectVector();
                        cascade.detectMultiScale(imageColor, detectedFaces, 1.1, 1, 0, new Size(150,150), new Size (500, 500));
                        
                        
                        for  (int i = 0; 1< detectedFaces.size(); i++) {
                            Rect dadosFace = detectedFaces.get (0);
                            rectangle (imageColor, dadosFace, new Scalar(255,255, 255, 255));
                            Mat face = new Mat (imageGray, dadosFace);
                            opencv_imgproc.resize(face, face, new Size(160, 160));
                            
                            
                            if (saveButton.getModel().isPressed()) {
                                
                                if (sample <= numSamples){
                                    String cropped = "C:\\photos\\persn."+idpersn + " . " + sample + ".jpg";
                                    imwrite(cropped, face);
                                    
                                    //system.out.println(" face " + samotra " capturew);
                                    counterLabel. setText(String.valueOf(sample));
                                    sample++;
                                }
                                
                                if (sample > 25){
                                    generate();
                                    insertDatabase();
                                    System.out.println("File generated");
                                  
                                    stopCamera();
                                    
                                  
                                }
                               }
                    }
                      imencode(".bmp", cameraImage, mem);
                      Image im = ImageIO.read(new ByteArrayInputStream (mem.getStringBytes()));
                      
                      BufferedImage buff = (BufferedImage) im;
                      
                      if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 90, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                          if (runnable == false) {
                              System.out.println("save photo");
                              this.wait();
                          }
                          
                    }
                }
            } catch (IOException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao iniciar camera (IOEx)\n" + ex);
                    
            } catch (InterruptedException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao iniciar camera (Interrupted)\n" + ex);
                    
        }
            }
        }
     
    }
        
        
}



 public void generate() {
            File directory = new File("C:\\photos\\");
            FilenameFilter filter = new FilenameFilter() {
                @Override
                
                public boolean accept(File dir, String name) {
                   return name. endsWith(".jpg")|| name. endsWith(".png");
                   
        
                }
            };
           
            File[] files = directory.listFiles(filter);
           MatVector photos = new MatVector( files.length);
           Mat labels = new Mat (files.length, 1, CV_32SC1);
           IntBuffer labelsBuffer = labels.createBuffer();
                    
           int counter = 0;
           for (File image : files){
               Mat photo = imread(image.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
               int idp = Integer.parseInt(image.getName().split ("\\.")[1]);
               opencv_imgproc.resize(photo, photo, new Size(100,100));
               
               photos.put(counter, photo);
               labelsBuffer.put(counter, idp);
               counter++;
               
               
               
           }
           FaceRecognizer lbph = LBPHFaceRecognizer.create();
           lbph.train(photos, labels);
           lbph.save("C:\\photos\\classifierLBPH.yml");
           
                   }
        


public void insertDatabase() {
        ControlPersn cod = new ControlPersn();
        ModelPersn mod = new ModelPersn();
    
           
           
                    
           mod.setFirst_name(firstNamePerson);
           mod.setLast_name(lastNamePerson);
           mod.setDob(dobPerson);
           mod.setOffice(officePerson);
           mod.setDob(dobPerson);
           
           
           cod.inserir(mod);
           
        }

        public void stopCamera(){
            myThread.runnable = false;
            webSource.release();
            dispose();
        
            
        }
        
      

       public void startCamera(){
            webSource = new VideoCapture(0);
            myThread = new Capture.DaemonThread();
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;
            t.start();    
        }


}
 


        



