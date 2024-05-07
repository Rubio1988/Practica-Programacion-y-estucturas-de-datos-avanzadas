import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame {
	
 

    public Tabla(int jug, int dia,int [][] tabla) {
        initComponents(jug,dia,tabla);
        tablaCenter();
        setVisible(true);
    }

    //metodo para colocar la tabla en el centro de la pantalla
    public void tablaCenter() {
        moverTabla(0, 0);
    }

    //Metodo para mover la tabla por la pantalla
    public void moverTabla(int width, int height) {

        // Obtenemos el tamaño de la pantalla.
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        // Obtenemos el tamaño de nuestro frame.
        Dimension tamañoFrame = this.getSize();
        tamañoFrame.width = tamañoFrame.width > tamañoPantalla.width ? tamañoPantalla.width : tamañoFrame.width;
        tamañoFrame.height = tamañoFrame.height > tamañoPantalla.height ? tamañoPantalla.height : tamañoFrame.height;

        //Definimos la localización.
        setLocation((tamañoPantalla.width - tamañoFrame.width) / 2 + width, (tamañoPantalla.height - tamañoFrame.height) / 2 + height);
    }

    private void initComponents(int jug,int dia,int [][] tabla) {
    	jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jButton1 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Torneo de Tenis");
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla de partidos"));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setColumnCount(dia+1);
        model.setRowCount(jug+1);
        for (int i=1; i < tabla.length-1; i++) {
        	for (int j=1; j < tabla[i].length; j++) {
        		jTable1.setValueAt("D"+j, 0, j);
        	}
		}
        if(eje.lista) {
			for (int i=1; i < tabla.length-1; i++) {
    		jTable1.setValueAt("J"+i+" "+eje.listaJugadores.get(i-1), i, 0);
			}
			for (int i=1; i < tabla.length-1; i++) {
	        	for (int j=1; j < tabla[i].length; j++) {
	        		if((tabla[i][j])-1<0) {
	        			jTable1.setValueAt("X", i, j);
	        		}else {
	        			jTable1.setValueAt(eje.listaJugadores.get((tabla[i][j])-1), i, j);
	        		}	        		
	        	}
			}
		}else {
			for (int i=1; i < tabla.length-1; i++) {
	    		jTable1.setValueAt("J"+i, i, 0);
	    	}
	        for (int i=1; i < tabla.length-1; i++) {
	        	for (int j=1; j < tabla[i].length; j++) {
	        		jTable1.setValueAt(tabla[i][j], i, j);
	        	}
			}
		}
        
        jScrollPane1.setViewportView(jTable1);
        
        javax.swing.GroupLayout jPanel1Layout = new GroupLayout(jPanel1);

        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(

            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)

            .addComponent(jScrollPane1)

        );

        jPanel1Layout.setVerticalGroup(

            jPanel1Layout.createParallelGroup(Alignment.LEADING)

            .addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()

                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)

                .addContainerGap())

        );
 
        jButton1.setText("SALIR");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
 

        GroupLayout layout = new GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(

            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(layout.createSequentialGroup()

                .addContainerGap()

                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                .addContainerGap())

            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                .addGap(84, 84, 84)

                .addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)

                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE,159, GroupLayout.PREFERRED_SIZE)

                .addGap(89, 89, 89))

        );

        layout.setVerticalGroup(

            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(layout.createSequentialGroup()

                .addContainerGap()

                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                .addGroup(layout.createParallelGroup(Alignment.CENTER).addComponent(jButton1))

                .addContainerGap(1, Short.MAX_VALUE))

        );
        pack();
    }                       

    //Metodo para dar auso al boton
    private void jButton1ActionPerformed(ActionEvent evt) {
        dispose();
    }
                   
    private JPanel jPanel1;
    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    Ejecucion eje;
}
