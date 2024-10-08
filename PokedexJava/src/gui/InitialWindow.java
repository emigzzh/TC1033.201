package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class InitialWindow extends JFrame {
	private JPanel contentPane;
	public String nombreArchivo;
	private JTextField textWritesName;
	private JTextField textWriteFileName;
	private static InitialWindow frame;
	public static boolean ready;
	
	/*** Launch the application.*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InitialWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*** Create the frame.*/
	public InitialWindow() {
		 ready = false;
		
		setResizable(false);
		// aquí esta lo de el frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtSelArch = new JLabel("File Selection");
		txtSelArch.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		txtSelArch.setBounds(10, 10, 175, 34);
		contentPane.add(txtSelArch);
		
		/* 
		 * CONTINUE AND CANCEL BUTTONS
		 */
		
		final JButton btnCont = new JButton("Continue");
		btnCont.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ready) {
					PokedexWindow pokemonWindow = new PokedexWindow();
					pokemonWindow.setVisibility(true);
					frame.dispose();
				}
			}
		});
		btnCont.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnCont.setBounds(40, 123, 110, 21);
		contentPane.add(btnCont);
		
		final JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnCancel.setBounds(164, 123, 104, 21);
		contentPane.add(btnCancel);
		
		/*
		 *  SEARCHES ABSOLUTE PATH OF THE CSV
		 */
		
		textWritesName = new JTextField();
		textWritesName.setEditable(false);
		textWritesName.setBounds(164, 49, 307, 19);
		contentPane.add(textWritesName);
		textWritesName.setColumns(10);
		
		final JButton btnSel = new JButton("...");
		btnSel.setEnabled(false);
		btnSel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				JFileChooser sa = new JFileChooser();
				sa.showOpenDialog(null);
				File file = sa.getSelectedFile();
				String fileName = file.getAbsolutePath();
				textWritesName.setText(fileName);
				String mensaje;
				// se abre la ventana de buscar el archivo y pues se busca y se encuentra y ya
				
				String finalS = fileName.substring(fileName.length()-3, fileName.length());
				if(!finalS.equals("csv" )){
					mensaje = fileName + ": Denied file, select a .csv file";
				} else {
					mensaje = fileName + ": Accepted file, click Continue";
					ready = true;
					DataFinder.runFile(fileName);
				}
				// se divide un substring para identificar si es .csv
					try {
						textWritesName.setText(fileName);
					JOptionPane.showMessageDialog(null, mensaje);
					// aquí es donde te dice que si se acepta o no
					} catch (Exception e1) {
			}
					
		}});
		btnSel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSel.setBounds(481, 47, 47, 21);
		contentPane.add(btnSel);
		
		/*
		 *  WRITE RELATIVE PATH OF THE CSV
		 */
		
		textWriteFileName = new JTextField();
		textWriteFileName.setEditable(true);
		textWriteFileName.setEnabled(false);
		textWriteFileName.setBounds(164, 83, 307, 19);
		contentPane.add(textWriteFileName);
		textWriteFileName.setColumns(10);
		
		final JButton btnSearch = new JButton("Search");
		btnSearch.setEnabled(false);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lo que hace el search button
				String nomArchivo = textWriteFileName.getText();
				String subStringCSV = nomArchivo.substring(nomArchivo.length()-4, nomArchivo.length());
				// lo mismo de arriba de el substring .csv
				if(subStringCSV.equals(".csv")) {
					File arch = new File(nomArchivo);
					
					if(arch.exists()) { // verifica que exista la dirección
						try {
						JOptionPane.showMessageDialog(null, "File found and accepted!");
						ready = true;
	                    DataFinder.runFile(nomArchivo);
						} catch (Exception e1) {
					}

					} else {
						try {
							JOptionPane.showMessageDialog(null, "File is .csv, but not found!");
						} catch (Exception e2) {
					}
				}
				} else {
					try {
						JOptionPane.showMessageDialog(null, "File must be .csv");
					} catch (Exception e2) {
				
				}
				
		}}});
		btnSearch.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSearch.setBounds(481, 83, 85, 21);
		contentPane.add(btnSearch);
		
		/*
		 *  RADIO BUTTONS
		 */
		
		final JRadioButton rdbtnSelectFile = new JRadioButton("Select a file to read");
		rdbtnSelectFile.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		rdbtnSelectFile.setBounds(20, 47, 141, 21);
		contentPane.add(rdbtnSelectFile);
		
		final JRadioButton rdbtnWriteFile = new JRadioButton("Write file's name");
		rdbtnWriteFile.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		rdbtnWriteFile.setBounds(20, 81, 130, 21);
		contentPane.add(rdbtnWriteFile);
		
		ButtonGroup grp = new ButtonGroup();
		//button group hace que solamente se pueda seleccionar uno de los jradiobutton
		grp.add(rdbtnWriteFile);
		grp.add(rdbtnSelectFile);
		
		 ActionListener list = new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	// evita que le piques a los demás botones mientras estés usando el otro en el jradiobutton
	                if (rdbtnSelectFile.isSelected()) {
	                    btnSel.setEnabled(true);
	                    textWriteFileName.setEnabled(false);
	                    btnSearch.setEnabled(false);
	                } else if (rdbtnWriteFile.isSelected()) {
	                    btnSel.setEnabled(false);
	                    textWriteFileName.setEnabled(true);
	                    btnSearch.setEnabled(true);
	                } else {
	                	btnSel.setEnabled(false);
	                	textWriteFileName.setEnabled(false);
	                	btnSearch.setEnabled(false);
	                }
	            }
	        };
	        rdbtnSelectFile.addActionListener(list);
	        rdbtnWriteFile.addActionListener(list);
}}