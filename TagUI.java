package taggr;

import java.io.*;

import org.jcodec.api.JCodecException;

/**
 *
 * @author Badhrinath
 */
@SuppressWarnings("serial")
public class TagUI extends javax.swing.JFrame {

    public TagUI() {
        initComponents();
    }

    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setToolTipText("Enter Here");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        jLabel1.setText("Enter Search Text");

        jButton1.setText("Search");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jButton1MouseClicked(evt);
				} catch (NumberFormatException | IOException | JCodecException e) {
					
					e.printStackTrace();
				}
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        jLabel2.setText("Video that contains Search Input");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }                        

                                      

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) throws NumberFormatException, IOException, JCodecException {                                      
        enteredText = jTextField1.getText();
        boolean found = false;
        jLabel3.setText("Text being extracted from Video, Thank you for waiting");
    	ExtractImages extractImageInstance = new ExtractImages();
    	File videoFolder = new File("/Users/Soorya/Documents/Masters/SEM 3/Multimedia Systems/Project/Code/videos");
    	int videoNumber = 1;
    	File[] videoFiles = videoFolder.listFiles();
    	File videoFile = null;
    	while(videoNumber <= videoFiles.length)
    	{
    	videoFile = videoFiles[videoNumber-1];
		extractImageInstance.extractImage(videoFile, videoNumber);
		jLabel3.setText("Text Extracted from Video");
		Tags.generateTagFile();
		FileReader fr = new FileReader("toBeTagged.txt");
		BufferedReader br = new BufferedReader(fr);
		String textLine = br.readLine();
		int frameNumber = 1;
		while(textLine!=null)
		{
			if(textLine.contains(enteredText))
			{
				found = true;
				frameNumber = Integer.parseInt(textLine.split(" ")[1]);
				break;
			}
			textLine = br.readLine();
		}
		if(found)
		{
			jLabel3.setText("Entered search text found in the video '\"/Users/Soorya/Documents/Masters/SEM 3/Multimedia Systems/Project/Code/test1.mp4\"' and in around: "+(frameNumber/30)+" seconds");
		break;
		}
			else
			jLabel3.setText("Entered search text not found");
		
		videoNumber ++;
		br.close();
    	}
    	
    }                                     

    
    public static void main(String args[]) {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TagUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TagUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TagUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TagUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TagUI().setVisible(true);
            }
        });
    }

                        
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private String enteredText;
                      
}
