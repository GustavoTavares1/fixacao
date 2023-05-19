package br.com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

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

public class JanelaAtendimento extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtStatus;
	private JTextField txtDataResolucao;
	private JTextField txtResponsavel;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	Long id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAtendimento frame = new JanelaAtendimento();
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
	public JanelaAtendimento() {
		setTitle("Sistema de Suporte - Atendente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Do Chamado:");
		lblNewLabel.setBounds(35, 35, 129, 14);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(35, 47, 166, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Status Do Chamado:");
		lblNewLabel_1.setBounds(284, 35, 111, 14);
		contentPane.add(lblNewLabel_1);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(278, 47, 177, 20);
		contentPane.add(txtStatus);
		txtStatus.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Resolução:");
		lblNewLabel_2.setBounds(35, 88, 111, 14);
		contentPane.add(lblNewLabel_2);
		
		txtDataResolucao = new JTextField();
		txtDataResolucao.setBounds(35, 103, 166, 20);
		contentPane.add(txtDataResolucao);
		txtDataResolucao.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Responsavel Do  Chamado:");
		lblNewLabel_3.setBounds(284, 99, 142, 14);
		contentPane.add(lblNewLabel_3);
		
		txtResponsavel = new JTextField();
		txtResponsavel.setBounds(278, 113, 177, 20);
		contentPane.add(txtResponsavel);
		txtResponsavel.setColumns(10);
		
		JTextArea txtObservacoes = new JTextArea();
		txtObservacoes.setBounds(10, 155, 256, 211);
		contentPane.add(txtObservacoes);
		
		btnAtualizar = new JButton("Atualizar Chamado");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CRUDChamado cc = new CRUDChamado();
				
				Chamado cr = new Chamado(); 
				 
				if(txtResponsavel.getText().trim().equals("") || txtStatus.getText().trim().equals("") || 
				txtId.getText().trim().equals("") || txtDataResolucao.getText().trim().equals("")) {
				 JOptionPane.showMessageDialog(null, "Os campos Responsável Chamado, Id do Chamado, Status do Chamado e Data de Resolução devem ser preenchidos", 
				"Erro 4000765x" , JOptionPane.ERROR_MESSAGE); 
				} 
				else { 
				 
				 cr.setDataResolucao(txtDataResolucao.getText());
				cr.setStatusChamado(txtStatus.getText()); 
				cr.setAtendente(txtResponsavel.getText()); 
				cr.setObservacoes(txtObservacoes.getText()); 
				cr.setIdChamado(Long.parseLong(txtId.getText())); 
				 JOptionPane.showMessageDialog(null, cc.atualizar(cr)); 
				
				}
			}
		});
		btnAtualizar.setBounds(414, 155, 150, 42);
		contentPane.add(btnAtualizar);
		
		btnExcluir = new JButton("Excluir Chamado");
		btnExcluir.addActionListener(new ActionListener() {
			
			CRUDChamado cc = new CRUDChamado();
			
			public void actionPerformed(ActionEvent e) {
				if(txtId.equals(null)) { 
					JOptionPane.showMessageDialog(null,"Selecione o chamado a ser excluído.","Erro 4000770x",JOptionPane.ERROR_MESSAGE); 
					} 
					else { 
					if(JOptionPane.showConfirmDialog(null, "Você tem certeza desta ação? \nEstá ação é permanente "+ "e não pode ser desfeita", "ATENÇÃO", JOptionPane.YES_NO_OPTION, 
					 JOptionPane.QUESTION_MESSAGE) == 0) { 
					Chamado cr = new Chamado(); 
					cr.setIdChamado(Long.parseLong(txtId.getText())); 
					
					JOptionPane.showConfirmDialog(null, cc.apagar(cr)); 

					}
					}
			}
		});
		btnExcluir.setBounds(414, 210, 150, 42);
		contentPane.add(btnExcluir);
		
		JLabel lblNewLabel_4 = new JLabel("Observaçoes:");
		lblNewLabel_4.setBounds(66, 139, 80, 14);
		contentPane.add(lblNewLabel_4);
	}
	
	
}
