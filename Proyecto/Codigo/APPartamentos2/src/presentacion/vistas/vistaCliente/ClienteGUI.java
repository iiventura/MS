/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vistas.vistaCliente;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import negocio.cliente.TCliente;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 *
 * @author usuario_local
 */
@SuppressWarnings("serial")
public class ClienteGUI extends javax.swing.JFrame {

  
	/**
     * Creates new form ClienteGUI
     */
    public ClienteGUI() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldIDCliente = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCiudad = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jCheckBoxActivo = new javax.swing.JCheckBox();
        jButtonSalir = new javax.swing.JButton();
        jTextAreaLista = new javax.swing.JTextArea();
        jScrollLista = new JScrollPane(jTextAreaLista);
        jScrollLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jButtonMaxComprador = new javax.swing.JButton();
        jButtonAlta = new javax.swing.JButton();
        jButtonBaja = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonListar = new javax.swing.JButton();
        
        jTextAreaLista.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1090, 505));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID CLIENTE:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DNI:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CIUDAD:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DIRECCION:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ACTIVO:");

        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonMaxComprador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonMaxComprador.setText("MAX  COMPRADOR");
        jButtonMaxComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaxCompradorActionPerformed(evt);
            }
        });

        jButtonAlta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAlta.setText("ALTA");
        jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaActionPerformed(evt);
            }
        });

        jButtonBaja.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonBaja.setText("BAJA");
        jButtonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaActionPerformed(evt);
            }
        });

        jButtonModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonModificar.setText("MODIFICAR");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonConsultar.setText("CONSULTAR");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonListar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonListar.setText("LISTAR");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxActivo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addComponent(jScrollLista, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButtonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonMaxComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxActivo))
                    .addComponent(jScrollLista, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMaxComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
   // Rellenar el id
   public void setIdField(int id){
	   String idAux = Integer.toString(id);
	   jTextFieldIDCliente.setText(idAux);
   }
   // Rellenar el campo de la lista
   public void setListField(ArrayList<TCliente> lista) {
	   String temp;
	   for (TCliente cli : lista) {
		   temp = cli.toString();
		   jTextAreaLista.append(temp + "\n");
	   }
   }
   
// Rellenar el campo de la lista
   public void setClienttField(TCliente cliente,String title) {
	   String temp;
	  temp=title+" \n";
		   temp += cliente.toString();
		   jTextAreaLista.append(temp + "\n");
	   
   }
   
   public void mensaje(String mensaje, String status){
	   	if(status=="Exito"){
		   JOptionPane.showMessageDialog(this, mensaje, status, JOptionPane.INFORMATION_MESSAGE);
	   	}
	   	else if(status=="Error"){
		   JOptionPane.showMessageDialog(this, mensaje, status, JOptionPane.ERROR_MESSAGE);
	   	}

   }
   
   
   
    private void jButtonMaxCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaxCompradorActionPerformed
    	limpiarComponentes();
    	Controlador.getInstance().run(ListaComandos.MAXCOMPRADOCLIENTE, 0);
    }//GEN-LAST:event_jButtonMaxCompradorActionPerformed

    private void jButtonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaActionPerformed
    	    
    	//Primero comprobamos que los campos est�n rellenos correctamente�
    	 
    	if( jTextFieldNombre.getText().isEmpty() || jTextFieldCiudad.getText().isEmpty()|| jTextFieldDNI.getText().isEmpty() || jTextFieldDireccion.getText().isEmpty()){
    		JOptionPane.showMessageDialog(this, "Rellena los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	
    	else{
    		String dniAux = jTextFieldDNI.getText();
    		String nombreAux = jTextFieldNombre.getText(); 
    		String ciudadAux = jTextFieldCiudad.getText();
    		String dirAux = jTextFieldDireccion.getText();
    		
    		TCliente tCli = new TCliente(-1, nombreAux, dniAux, dirAux, ciudadAux, true);
    		
    		Controlador.getInstance().run(ListaComandos.ALTACLIENTE, tCli);
    		limpiarComponentes();
    	}
    }//GEN-LAST:event_jButtonAltaActionPerformed

    private void jButtonBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBajaActionPerformed
    	if (jTextFieldIDCliente.getText().isEmpty()){
    		JOptionPane.showMessageDialog(this, "Por favor indica el id del Cliente.", "Error", JOptionPane.ERROR_MESSAGE);
    	} 
    	
    	else{
    		
    		try {
    			int id =Integer.parseInt(jTextFieldIDCliente.getText());
        		Controlador.getInstance().run(ListaComandos.BAJACLIENTE, id);
    	    	limpiarComponentes();
            } catch (NumberFormatException excepcion) {
        		JOptionPane.showMessageDialog(this, "El campo ID CLIENTE debe ser un n�mero entero", "Error", JOptionPane.ERROR_MESSAGE);

            }
    		
    	}
    }//GEN-LAST:event_jButtonBajaActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

    	if (jTextFieldNombre.getText().isEmpty() || jTextFieldCiudad.getText().isEmpty()|| jTextFieldDNI.getText().isEmpty() || jTextFieldDireccion.getText().isEmpty()){
        	JOptionPane.showMessageDialog(this, "Rellena los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	else{
        	String dniAux = jTextFieldDNI.getText();
        	String nombreAux = jTextFieldNombre.getText(); 
        	String ciudadAux = jTextFieldCiudad.getText();
        	String dirAux = jTextFieldDireccion.getText();
        		
        	TCliente tCli = new TCliente(nombreAux, dniAux, dirAux, ciudadAux, true);
        		
        	Controlador.getInstance().run(ListaComandos.MODIFICARCLIENTE, tCli);
    	    limpiarComponentes();
        }	
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
    	if (jTextFieldIDCliente.getText().isEmpty()){
    		JOptionPane.showMessageDialog(this, "Por favor indica el id del Cliente.", "Error", JOptionPane.ERROR_MESSAGE);
    	} else{
    		try {
    			int id = Integer.parseInt(jTextFieldIDCliente.getText());
        		limpiarComponentes();
        		Controlador.getInstance().run(ListaComandos.CONSULTARCLIENTE, id);
            } catch (NumberFormatException excepcion) {
        		JOptionPane.showMessageDialog(this, "El campo ID CLIENTE debe ser un n�mero entero", "Error", JOptionPane.ERROR_MESSAGE);

            }
    		
    	}
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
    	limpiarComponentes();
    	Controlador.getInstance().run(ListaComandos.LISTARCLIENTE, 0);
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
    	limpiarComponentes();
    	Controlador.getInstance().run(ListaComandos.CERRARVISTACLIENTE, null);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void limpiarComponentes(){
    	this.jCheckBoxActivo.setSelected(false);
    	this.jTextFieldCiudad.setText("");
    	this.jTextFieldDireccion.setText("");
    	this.jTextFieldDNI.setText("");
    	this.jTextFieldNombre.setText("");
    	this.jTextFieldIDCliente.setText("");
    	this.jTextAreaLista.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JButton jButtonBaja;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonMaxComprador;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JCheckBox jCheckBoxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldCiudad;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldIDCliente;
    private JScrollPane jScrollLista;
    private JTextArea jTextAreaLista;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
