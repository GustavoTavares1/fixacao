package br.com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.dao.CRUDChamado;
import br.com.dominio.Chamado;

public class JanelaChamado extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDepartamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaChamado frame = new JanelaChamado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaChamado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Insira Seu Nome:");
		lblNewLabel.setBounds(301, 61, 104, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(218, 75, 327, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preencha todos os campos para efetuar um chamado");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(135, 11, 480, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("informe com qual departamento deseja falar:");
		lblNewLabel_2.setBounds(255, 108, 256, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setBounds(214, 195, 441, 131);
		contentPane.add(txtDescricao);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(218, 122, 327, 20);
		contentPane.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar Chamado");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CRUDChamado cc = new CRUDChamado();
				
				 Chamado soliChamado = new Chamado(); 
				 
					if(txtNome.getText().trim().equals("") || 
							txtDepartamento.getText().trim().equals("") || 
							txtDescricao.getText().trim().equals("")) { 
							 JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro 4000765x" , JOptionPane.ERROR_MESSAGE); 
							} 
							else { 
							 
							soliChamado.setSolicitacao(txtNome.getText()); 
							 
							soliChamado.setDepSolicitado(txtDepartamento.getText()); 
							 
							soliChamado.setDescChamado(txtDescricao.getText()); 
							 
							 JOptionPane.showMessageDialog(null, cc.registrar(soliChamado)); 
				}
				
			}
		});
		btnRegistrar.setBounds(10, 177, 146, 23);
		contentPane.add(btnRegistrar);
		
		JLabel lblNewLabel_3 = new JLabel("Conte-nos mais sobre seu problema:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(218, 181, 186, 14);
		contentPane.add(lblNewLabel_3);
		
	
		
	

	}
}
