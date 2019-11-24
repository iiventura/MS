package presentacion.vistas.vistaEmpleado;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JOptionPane;

import negocio.empleado.TAgenteInmobiliario;
import negocio.empleado.TDirector;
import negocio.empleado.TEmpleado;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 *
 * @author usuario_local
 */
@SuppressWarnings("serial")
public class EmpleadoGUI02 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EmpleadoGUI02() {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabelIDEmpleado = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelSueldo = new javax.swing.JLabel();
        jCheckBoxActivo = new javax.swing.JCheckBox();
        jTextFieldIDEmpleado = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDomicilio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonAlta = new javax.swing.JButton();
        jButtonBaja = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonMostrar = new javax.swing.JButton();
        jButtonListar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabelActivo = new javax.swing.JLabel();
        jLabelIDDepartamento = new javax.swing.JLabel();
        jTextFieldSueldo = new javax.swing.JTextField();
        jTextFieldIDDepartamento = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelDirector = new javax.swing.JLabel();
        jLabelPEmpresarial = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxDirector = new javax.swing.JCheckBox();
        jTextFieldPEmpresarial = new javax.swing.JTextField();
        jTextFieldComision = new javax.swing.JTextField();
        jLabelAInmobiliario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAExperiencia = new javax.swing.JTextField();
        jCheckBoxAInmobiliario = new javax.swing.JCheckBox();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //Inhabilitamos Escritura en el jTextArea
        jTextArea1.setEditable(false);
        
        //Inhabilitamos las variables de Director
        this.jTextFieldPEmpresarial.setEditable(false);
        this.jTextFieldComision.setEditable(false);
        
        //Inhabilitamos las variables de Agente Inmobiliario
        this.jTextFieldAExperiencia.setEditable(false);

        jLabelIDEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelIDEmpleado.setText("ID EMPLEADO:");

        jLabelDNI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDNI.setText("DNI:");

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNombre.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("DOMICILIO");

        jLabelSueldo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSueldo.setText("SUELDO:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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

        jButtonMostrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonMostrar.setText("MOSTRAR");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
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

        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSalir.setText("SALIR");

        jLabelActivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelActivo.setText("ACTIVO:");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSalirActionPerformed(evt);
			}
		});

        jLabelIDDepartamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelIDDepartamento.setText("ID DEPARTAMENTO:");

        jLabelDirector.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDirector.setText("DIRECTOR:");
        jCheckBoxDirector.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBoxDirectorActionPerformed(evt);
			}
		});
        

        jLabelPEmpresarial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPEmpresarial.setText("POLÍTICA EMPRESARIAL:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("COMISIÓN: ");

        jLabelAInmobiliario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAInmobiliario.setText("AGENTE INMOBILIARIO:");
        jCheckBoxAInmobiliario.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBoxAInmobiliarioActionPerformed(evt);
			}
		});

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("AÑOS EMPERIENCIA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                            .addComponent(jTextFieldIDEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextFieldNombre)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabelActivo)
                                                .addGap(18, 18, 18)
                                                .addComponent(jCheckBoxActivo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelIDDepartamento)
                                                        .addGap(29, 29, 29)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextFieldIDDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldSueldo))))
                                        .addGap(1, 1, 1)))
                                .addGap(47, 47, 47)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelDirector)
                                        .addComponent(jLabelPEmpresarial)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckBoxDirector)
                                    .addComponent(jTextFieldPEmpresarial)
                                    .addComponent(jTextFieldComision, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelAInmobiliario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxAInmobiliario)
                                    .addComponent(jTextFieldAExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jButtonAlta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelIDEmpleado)
                                    .addComponent(jTextFieldIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDNI)
                                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelNombre)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelSueldo)
                                    .addComponent(jTextFieldSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelActivo)
                                    .addComponent(jCheckBoxActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelIDDepartamento)
                                    .addComponent(jTextFieldIDDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBoxDirector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDirector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAInmobiliario)
                            .addComponent(jCheckBoxAInmobiliario))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPEmpresarial)
                    .addComponent(jTextFieldPEmpresarial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBaja)
                    .addComponent(jButtonAlta)
                    .addComponent(jButtonListar)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonMostrar))
                .addGap(29, 29, 29)
                .addComponent(jButtonSalir)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>        
    
    private void limpiarComponentes(){
    	//Empleado
    	jTextFieldIDEmpleado.setText("");
    	jTextFieldDNI.setText("");
    	jTextFieldNombre.setText("");
    	jTextFieldDomicilio.setText("");
    	jTextFieldSueldo.setText("");
    	jTextFieldIDDepartamento.setText("");
    	jCheckBoxActivo.setSelected(false);
    	
    	jTextArea1.setText("");
    	
    	//Agente Inmobiliario
    	jCheckBoxAInmobiliario.setSelected(false);
    	jTextFieldAExperiencia.setText("");
    	
    	//Director
    	jCheckBoxDirector.setSelected(false);
    	jTextFieldPEmpresarial.setText("");
    	jTextFieldComision.setText("");
    	
    }

    public void mensaje(String mensaje, String status){
	   	if(status.equals("Exito")){
	   		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	   	}
	   	else if(status=="Error"){
	   		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	   	}
	   	else if(status=="Warning"){
	   		JOptionPane.showMessageDialog(this, mensaje, "Atención", JOptionPane.WARNING_MESSAGE);
	   	}

   }
    
    public void setListField(List<TEmpleado> lista) {
		   String temp;
		   for (TEmpleado emp : lista) {
			   temp = emp.toString();
			   jTextArea1.append(temp + "\n");
		   }
	   }
    
    public void mostrarEmpleado(String mensaje, TEmpleado emp){
		limpiarComponentes();
	   	if(emp != null){
		   JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
		   
		   if(emp instanceof TDirector){
			   String s = ((TDirector) emp).toString();
			   jTextArea1.append(s);
		   }
		   else  if(emp instanceof TAgenteInmobiliario){
			   String s = ((TAgenteInmobiliario) emp).toString();
			   jTextArea1.append(s);
		   }
		   
		
	   	}
	   	else{
		   JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	   	}

   }
    
    protected void jCheckBoxAInmobiliarioActionPerformed(ActionEvent evt) {
    	jTextFieldAExperiencia.setEditable(true);
		jTextFieldPEmpresarial.setEditable(false);
		jTextFieldPEmpresarial.setText("");
		jTextFieldComision.setEditable(false);
		jTextFieldComision.setText("");
		
		if (jCheckBoxDirector.isSelected()) {
			jCheckBoxDirector.setSelected(false);
		}
		
	}


	protected void jCheckBoxDirectorActionPerformed(ActionEvent evt) {
		jTextFieldPEmpresarial.setEditable(true);
		jTextFieldComision.setEditable(true);
		jTextFieldAExperiencia.setEditable(false);
		jTextFieldAExperiencia.setText("");

		if (jCheckBoxAInmobiliario.isSelected()) {
			jCheckBoxAInmobiliario.setSelected(false);
		}
		
	}


	protected void jButtonSalirActionPerformed(ActionEvent evt) {
		limpiarComponentes();
		Controlador.getInstance().run(ListaComandos.CERRARVISTAEMPLEADO, null);
		
	}


	protected void jButtonListarActionPerformed(ActionEvent evt) {
		limpiarComponentes();
		Controlador.getInstance().run(ListaComandos.LISTAREMPLEADO,null);
		
	}


	protected void jButtonConsultarActionPerformed(ActionEvent evt) {
		int id;
		if (!jTextFieldIDEmpleado.getText().isEmpty()) {
			try {
				id = Integer.parseInt(jTextFieldIDEmpleado.getText());
				
				if(id <= 0){
					JOptionPane.showMessageDialog(this, "El campo ID debe ser un numero positivo", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else{
					limpiarComponentes();
					Controlador.getInstance().run(ListaComandos.CONSULTAREMPLEADO,id);
				}
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El campo ID debe ser un numero positivo", "Consulta empleado",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Introduzca un ID de empleado", "Consulta empleado",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}


	protected void jButtonModificarActionPerformed(ActionEvent evt) {
		try {
			int id = Integer.valueOf(jTextFieldIDEmpleado.getText());
			String dni = jTextFieldDNI.getText();
			String nombre = jTextFieldNombre.getText();
			String domicilio = jTextFieldDomicilio.getText();
			double sueldo = Double.parseDouble(jTextFieldSueldo.getText());
			int departamento = Integer.parseInt(jTextFieldIDDepartamento.getText());
			
			//Comprobar que los campos generales de empleado tienen informacion
			if (jTextFieldDNI.getText().isEmpty() ||jTextFieldNombre.getText().isEmpty()|| 
				jTextFieldDomicilio.getText().isEmpty() || jTextFieldSueldo.getText().isEmpty()||
				jTextFieldIDDepartamento.getText().isEmpty() || jTextFieldIDEmpleado.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, rellena los campos de empleado", "Error",
						JOptionPane.ERROR_MESSAGE);
			} 
			//Comprueba que el ID de Departamento este en el rango
			else if(departamento <= 0){
				JOptionPane.showMessageDialog(this, "El id departamento debe ser un número mayor que cero", "Error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(sueldo <= 0){
				JOptionPane.showMessageDialog(this, "El sueldo del Empleado debe ser un número mayor que cero", "Error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(id <= 0) {
				JOptionPane.showMessageDialog(this, "El identificador del Empleado debe ser un número mayor que cero", "Error",JOptionPane.ERROR_MESSAGE);	
			}

			else {
				// Comprobar que han seleccionado un tipo de Empleado
				if (jCheckBoxDirector.isSelected() || jCheckBoxAInmobiliario.isSelected()) {
					// DIRECTOR
					if (jCheckBoxDirector.isSelected()) {
						double comision= Double.parseDouble(jTextFieldComision.getText());
						
						//Comprueba que los Politica Empresarial y Comision no esten vacios
						if(this.jTextFieldPEmpresarial.getText().isEmpty() || this.jTextFieldComision.getText().isEmpty()){
							JOptionPane.showMessageDialog(this, "Por favor, rellenar los campos correctamente para modificar al Director.", "Error",
									JOptionPane.ERROR_MESSAGE);
					
						//Si la comision es un valor negativo
						}else if(comision<=0){
							JOptionPane.showMessageDialog(this, "La comision del Empleado debe ser un número mayor que cero", "Error",JOptionPane.ERROR_MESSAGE);	
						
						}else{
							String politicaEmpresarial = jTextFieldPEmpresarial.getText();
							TEmpleado e = new TDirector(id, dni, nombre, domicilio,sueldo, true, departamento,
														politicaEmpresarial,comision);
							Controlador.getInstance().run(ListaComandos.MODIFICAREMPLEADO, e);
							
						}
						
						
											
					//AGENTE INMOBILIARIO
					} else {
						if (!jTextFieldAExperiencia.getText().isEmpty()) {
							int anosEperiencia = Integer.parseInt(jTextFieldAExperiencia.getText());
							if(anosEperiencia >= 0){
								TEmpleado e = new TAgenteInmobiliario(id, dni, nombre, domicilio,sueldo, true, departamento,
																	anosEperiencia);
								Controlador.getInstance().run(ListaComandos.MODIFICAREMPLEADO, e);
							}
							else{
								JOptionPane.showMessageDialog(this, "Los años de experiencia del agente inmobiliario debe ser un número positivo","Error", JOptionPane.ERROR_MESSAGE);
							}
							
						} else {
							JOptionPane.showMessageDialog(this, "Por favor, rellenar los campos correctamente para modificar al Agente Inmobiliario.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					limpiarComponentes();
				} else {
					JOptionPane.showMessageDialog(this, "Por favor, seleccione un tipo de empleado", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Por favor rellene los campos de Empleado correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}


	protected void jButtonBajaActionPerformed(ActionEvent evt) {
		int id;
		try {
			if (!jTextFieldIDEmpleado.getText().isEmpty()) {

				id = Integer.parseInt(jTextFieldIDEmpleado.getText());
				
				if(id <= 0){
					JOptionPane.showMessageDialog(this, "El campo ID debe ser un numero positivo", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else{
					Controlador.getInstance().run(ListaComandos.BAJAEMPLEADO, id);
				}
				
			} else {
				JOptionPane.showMessageDialog(this, "Introduzca un ID de empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El campo ID debe ser un numero positivo", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}


	protected void jButtonAltaActionPerformed(ActionEvent evt) {
		try {
			String dni = jTextFieldDNI.getText();
			String nombre = jTextFieldNombre.getText();
			String domicilio = jTextFieldDomicilio.getText();
			double sueldo = Double.parseDouble(jTextFieldSueldo.getText());
			int departamento = Integer.parseInt(jTextFieldIDDepartamento.getText());
			
			//Comprobar que los campos generales de empleado tienen informacion
			if (jTextFieldDNI.getText().isEmpty() ||jTextFieldNombre.getText().isEmpty()|| 
				jTextFieldDomicilio.getText().isEmpty() || jTextFieldSueldo.getText().isEmpty()||
				jTextFieldIDDepartamento.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, rellena los campos de empleado", "Error",
						JOptionPane.ERROR_MESSAGE);
			} 
			//Comprueba que el ID de Departamento este en el rango
			else if(departamento <= 0){
				JOptionPane.showMessageDialog(this, "El id departamento debe ser un número mayor que cero", "Error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(sueldo <= 0){
				JOptionPane.showMessageDialog(this, "El sueldo del Empleado debe ser un número mayor que cero", "Error",JOptionPane.ERROR_MESSAGE);	
			}
			else {
				// Comprobar que han seleccionado un tipo de Empleado
				if (jCheckBoxDirector.isSelected() || jCheckBoxAInmobiliario.isSelected()) {
					// DIRECTOR
					if (jCheckBoxDirector.isSelected()) {
						double comision= Double.parseDouble(jTextFieldComision.getText());
						
						//Comprueba que los Politica Empresarial y Comision no esten vacios
						if(this.jTextFieldPEmpresarial.getText().isEmpty() || this.jTextFieldComision.getText().isEmpty()){
							JOptionPane.showMessageDialog(this, "Por favor, rellenar los campos correctamente para añadir a un Director.", "Error",
									JOptionPane.ERROR_MESSAGE);
					
						//Si la comision es un valor negativo
						}else if(comision<=0){
							JOptionPane.showMessageDialog(this, "La comision del Empleado debe ser un número mayor que cero", "Error",JOptionPane.ERROR_MESSAGE);	
						
						}else{
							String politicaEmpresarial = jTextFieldPEmpresarial.getText();
							TEmpleado e = new TDirector(dni, nombre, domicilio,sueldo, true, departamento,
														politicaEmpresarial,comision);
							Controlador.getInstance().run(ListaComandos.ALTAEMPLEADO, e);
							
						}
						
						
											
					//AGENTE INMOBILIARIO
					} else {
						if (!jTextFieldAExperiencia.getText().isEmpty()) {
							int anosEperiencia = Integer.parseInt(jTextFieldAExperiencia.getText());
							if(anosEperiencia >= 0){
								TEmpleado e = new TAgenteInmobiliario(dni, nombre, domicilio,sueldo, true, departamento,
																	anosEperiencia);
								Controlador.getInstance().run(ListaComandos.ALTAEMPLEADO, e);
							}
							else{
								JOptionPane.showMessageDialog(this, "Los años de experiencia del agente inmobiliario debe ser un número positivo","Error", JOptionPane.ERROR_MESSAGE);
							}
							
						} else {
							JOptionPane.showMessageDialog(this, "Por favor, rellenar los campos correctamente para añadir a un Agente Inmobiliario.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Por favor, seleccione un tipo de empleado", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Por favor rellene los campos de Empleado  correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		limpiarComponentes();
		
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
            java.util.logging.Logger.getLogger(EmpleadoGUI02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpleadoGUI02().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JButton jButtonBaja;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JCheckBox jCheckBoxAInmobiliario;
    private javax.swing.JCheckBox jCheckBoxActivo;
    private javax.swing.JCheckBox jCheckBoxDirector;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAInmobiliario;
    private javax.swing.JLabel jLabelActivo;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelDirector;
    private javax.swing.JLabel jLabelIDDepartamento;
    private javax.swing.JLabel jLabelIDEmpleado;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPEmpresarial;
    private javax.swing.JLabel jLabelSueldo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldAExperiencia;
    private javax.swing.JTextField jTextFieldComision;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldDomicilio;
    private javax.swing.JTextField jTextFieldIDDepartamento;
    private javax.swing.JTextField jTextFieldIDEmpleado;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPEmpresarial;
    private javax.swing.JTextField jTextFieldSueldo;
    // End of variables declaration                   
}
