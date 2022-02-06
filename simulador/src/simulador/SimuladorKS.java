package simulador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class SimuladorKS extends JFrame {

	private JPanel contentPane;
	private JTextField end1;
	private JLabel txtFlagZero;
	private JButton btnNext;
	private Pattern pattern;
	private Matcher matcher;
	private JTextField end0;
	private JTextField end3;
	private JTextField end2;
	private JTextField end4;
	private JTextField end5;
	private JTextField end6;
	private JTextField end7;
	private JTextField end8;
	private JTextField end9;
	private JTextField end10;
	private JTextField end11;
	private JTextField outPutIR;
	private JTextField reg00;
	private JTextField reg01;
	private JTextField reg02;
	private JTextField reg03;

	private List<String> instrucion;
	private List<String> numeros;
	private int programCounter, num_1, num_2;
	private String instru;
	private List<JTextField> enderecos;
	private List<JTextField> registradores;
	private JTextField cxProgramCounter;
	private JButton btnReset;
	private JTextField outPutMIR;
	private JLabel txtFlagNegative;
	private JLabel txtFlagNegativeLabel;
	private JScrollPane scrollPane;
	private JTextField end12;
	private JTextField end13;
	private JTextField end15;
	private JTextField end14;
	private JTextField end16;
	private JTextField end17;
	private JTextField end18;
	private JTextField end19;
	private JTextField end20;
	private JTextField end21;
	private JTextField end22;
	private JTextField end23;
	private JTextField end24;
	private JTextField end25;
	private JTextField end26;
	private JTextField end27;
	private JTextField end28;
	private JTextField end29;
	private JTextField end30;
	private JLabel txtEnd_0_1_1_1_1_1_5;
	private JTextField end31;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimuladorKS frame = new SimuladorKS();
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
	public SimuladorKS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNext = new JButton("next");
		btnNext.setBounds(685, 509, 117, 25);
		contentPane.add(btnNext);

		txtFlagZero = new JLabel("false");
		txtFlagZero.setHorizontalAlignment(SwingConstants.CENTER);
		txtFlagZero.setBounds(762, 354, 117, 15);
		contentPane.add(txtFlagZero);

		outPutIR = new JTextField();
		outPutIR.setHorizontalAlignment(SwingConstants.CENTER);
		outPutIR.setEnabled(false);
		Color c1 = new Color(0, 0, 0);
		outPutIR.setDisabledTextColor(c1);

		outPutIR.setBounds(134, 120, 179, 33);
		contentPane.add(outPutIR);
		outPutIR.setColumns(10);

		reg00 = new JTextField();
		reg00.setColumns(10);
		reg00.setBounds(765, 127, 114, 19);
		contentPane.add(reg00);

		reg01 = new JTextField();
		reg01.setColumns(10);
		reg01.setBounds(765, 158, 114, 19);
		contentPane.add(reg01);

		reg02 = new JTextField();
		reg02.setColumns(10);
		reg02.setBounds(765, 189, 114, 19);
		contentPane.add(reg02);

		reg03 = new JTextField();
		reg03.setColumns(10);
		reg03.setBounds(765, 220, 114, 19);
		contentPane.add(reg03);

		cxProgramCounter = new JTextField();
		cxProgramCounter.setText("PC: 0");
		cxProgramCounter.setHorizontalAlignment(SwingConstants.CENTER);
		cxProgramCounter.setEnabled(false);
		cxProgramCounter.setDisabledTextColor(Color.BLACK);
		cxProgramCounter.setColumns(10);
		cxProgramCounter.setBounds(51, 120, 61, 33);
		contentPane.add(cxProgramCounter);

		JButton btnClearReset = new JButton("clear/reset");
		btnClearReset.setBounds(557, 509, 117, 25);
		contentPane.add(btnClearReset);

		btnReset = new JButton("reset pc");
		btnReset.setBounds(819, 509, 117, 25);
		contentPane.add(btnReset);

		JLabel txtEnd_0_1 = new JLabel("0");
		txtEnd_0_1.setBounds(742, 129, 19, 15);
		contentPane.add(txtEnd_0_1);

		JLabel txtEnd_1_1 = new JLabel("1");
		txtEnd_1_1.setBounds(742, 160, 19, 15);
		contentPane.add(txtEnd_1_1);

		JLabel txtEnd_2_1 = new JLabel("2");
		txtEnd_2_1.setBounds(742, 191, 19, 15);
		contentPane.add(txtEnd_2_1);

		JLabel txtEnd_0_2_2 = new JLabel("3");
		txtEnd_0_2_2.setBounds(742, 224, 19, 15);
		contentPane.add(txtEnd_0_2_2);

		JLabel lblEndereos = new JLabel("ENDEREÇOS");
		lblEndereos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereos.setBounds(51, 222, 117, 15);
		contentPane.add(lblEndereos);

		JLabel lblRegistradores = new JLabel("REGISTRADORES");
		lblRegistradores.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistradores.setBounds(765, 100, 117, 15);
		contentPane.add(lblRegistradores);

		outPutMIR = new JTextField();
		outPutMIR.setHorizontalAlignment(SwingConstants.CENTER);
		outPutMIR.setEnabled(false);
		outPutMIR.setDisabledTextColor(Color.BLACK);
		outPutMIR.setColumns(10);
		outPutMIR.setBounds(51, 56, 262, 33);
		contentPane.add(outPutMIR);

		JLabel txtFlagValid = new JLabel("false");
		txtFlagValid.setHorizontalAlignment(SwingConstants.CENTER);
		txtFlagValid.setBounds(762, 381, 117, 15);
		contentPane.add(txtFlagValid);

		JLabel txtFlagZeroLabel = new JLabel("zero:");
		txtFlagZeroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		txtFlagZeroLabel.setBounds(710, 354, 61, 15);
		contentPane.add(txtFlagZeroLabel);

		txtFlagNegative = new JLabel("false");
		txtFlagNegative.setHorizontalAlignment(SwingConstants.CENTER);
		txtFlagNegative.setBounds(762, 328, 117, 15);
		contentPane.add(txtFlagNegative);

		txtFlagNegativeLabel = new JLabel("negative:");
		txtFlagNegativeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		txtFlagNegativeLabel.setBounds(711, 328, 81, 15);
		contentPane.add(txtFlagNegativeLabel);
		{

			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(30, 249, 441, 315);
			contentPane.add(scrollPane_1);

			end1 = new JTextField();
			// contentPane.add(end1);
			end1.setColumns(10);

			end0 = new JTextField();
			end0.setColumns(10);

			JLabel txtEnd_0 = new JLabel("0");
			// contentPane.add(txtEnd_0);

			JLabel txtEnd_1 = new JLabel("1");

			JPanel endsContainer = new JPanel();
			scrollPane_1.setViewportView(endsContainer);
			// contentPane.add(txtEnd_1);

			JLabel txtEnd_2 = new JLabel("2");

			end2 = new JTextField();
			end2.setColumns(10);

			JLabel txtEnd_0_2 = new JLabel("3");
			// contentPane.add(end0);

			end3 = new JTextField();
			end3.setColumns(10);

			end4 = new JTextField();
			end4.setColumns(10);

			JLabel txtEnd_0_1_2 = new JLabel("4");

			end5 = new JTextField();
			end5.setColumns(10);

			JLabel txtEnd_0_1_1_1 = new JLabel("5");

			JLabel txtEnd_0_3 = new JLabel("6");

			end6 = new JTextField();
			end6.setColumns(10);

			JLabel txtEnd_0_1_3 = new JLabel("7");

			end7 = new JTextField();
			end7.setColumns(10);

			JLabel txtEnd_0_1_1_2 = new JLabel("8");

			end8 = new JTextField();
			end8.setColumns(10);

			JLabel txtEnd_0_2_1 = new JLabel("9");

			end9 = new JTextField();
			end9.setColumns(10);

			JLabel txtEnd_0_1_2_1 = new JLabel("10");

			end10 = new JTextField();
			end10.setColumns(10);

			JLabel txtEnd_0_1_1_1_1 = new JLabel("11");

			end11 = new JTextField();
			end11.setColumns(10);

			JLabel txtEnd_0_1_2_1_1 = new JLabel("12");

			end12 = new JTextField();
			end12.setColumns(10);

			JLabel txtEnd_0_1_1_1_1_1 = new JLabel("13");

			end13 = new JTextField();
			end13.setColumns(10);

			JLabel txtEnd_0_1_1_1_1_1_1 = new JLabel("15");

			end15 = new JTextField();
			end15.setColumns(10);

			JLabel txtEnd_0_1_2_1_1_1 = new JLabel("14");

			end14 = new JTextField();
			end14.setColumns(10);

			JLabel txtEnd_0_1_2_1_2 = new JLabel("16");

			end16 = new JTextField();
			end16.setColumns(10);

			JLabel txtEnd_0_1_1_1_1_2 = new JLabel("17");

			end17 = new JTextField();
			end17.setColumns(10);

			JLabel txtEnd_0_1_2_1_1_2 = new JLabel("18");

			end18 = new JTextField();
			end18.setColumns(10);

			JLabel txtEnd_0_1_2_1_1_1_1 = new JLabel("19");

			end19 = new JTextField();
			end19.setColumns(10);

			end20 = new JTextField();
			end20.setColumns(10);

			JLabel txtEnd_0_1_1_1_1_1_1_1 = new JLabel("20");

			JLabel txtEnd_0_1_2_1_3 = new JLabel("21");

			end21 = new JTextField();
			end21.setColumns(10);

			JLabel txtEnd_0_1_1_1_1_3 = new JLabel("22");

			end22 = new JTextField();
			end22.setColumns(10);

			JLabel txtEnd_0_1_2_1_1_3 = new JLabel("23");

			end23 = new JTextField();
			end23.setColumns(10);

			end24 = new JTextField();
			end24.setColumns(10);

			JLabel txtEnd_0_1_1_1_1_1_3 = new JLabel("24");

			JLabel txtEnd_0_1_2_1_1_1_2 = new JLabel("25");

			end25 = new JTextField();
			end25.setColumns(10);

			end26 = new JTextField();
			end26.setColumns(10);

			JLabel txtEnd_0_1_1_1_1_1_1_2 = new JLabel("26");

			JLabel txtEnd_0_1_2_1_4 = new JLabel("27");

			end27 = new JTextField();
			end27.setColumns(10);

			JLabel txtEnd_0_1_1_1_1_4 = new JLabel("28");

			end28 = new JTextField();
			end28.setColumns(10);

			JLabel txtEnd_0_1_2_1_1_4 = new JLabel("29");

			end29 = new JTextField();
			end29.setColumns(10);

			end30 = new JTextField();
			end30.setColumns(10);

			JLabel txtEnd_0_1_1_1_1_1_4 = new JLabel("30");

			txtEnd_0_1_1_1_1_1_5 = new JLabel("31");

			end31 = new JTextField();
			end31.setColumns(10);
			GroupLayout gl_endsContainer = new GroupLayout(endsContainer);
			gl_endsContainer.setHorizontalGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(13).addGroup(gl_endsContainer
							.createParallelGroup(Alignment.LEADING)
							.addComponent(txtEnd_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_endsContainer.createSequentialGroup().addGap(18).addComponent(end2,
									GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(101)
							.addComponent(txtEnd_0_1_2_1_1_2, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(13).addGroup(gl_endsContainer
							.createParallelGroup(Alignment.LEADING)
							.addComponent(txtEnd_0_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_endsContainer.createSequentialGroup().addGap(18).addComponent(end3,
									GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(101)
							.addComponent(txtEnd_0_1_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(13).addGroup(gl_endsContainer
							.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_endsContainer.createSequentialGroup().addGap(18).addComponent(end4,
									GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtEnd_0_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(101)
							.addComponent(txtEnd_0_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(9).addGroup(gl_endsContainer
							.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(txtEnd_0_1_1_1,
									GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtEnd_0_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtEnd_0_1_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(2)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addComponent(end5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end6,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end7,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGap(100)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(
											txtEnd_0_1_2_1_3, GroupLayout.PREFERRED_SIZE, 19,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(
											txtEnd_0_1_1_1_1_3, GroupLayout.PREFERRED_SIZE, 19,
											GroupLayout.PREFERRED_SIZE))
									.addComponent(txtEnd_0_1_2_1_1_3, GroupLayout.PREFERRED_SIZE, 19,
											GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end21,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end22,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addComponent(end23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(9)
							.addComponent(txtEnd_0_1_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(end8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(100)
							.addComponent(txtEnd_0_1_1_1_1_1_3, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(9)
							.addComponent(txtEnd_0_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(end9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(101)
							.addComponent(txtEnd_0_1_2_1_1_1_2, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(1)
							.addComponent(txtEnd_0_1_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(end10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(101)
							.addComponent(txtEnd_0_1_1_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(1)
							.addComponent(txtEnd_0_1_1_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(end11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(101)
							.addComponent(txtEnd_0_1_2_1_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup()
							.addComponent(txtEnd_0_1_2_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(end12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(102)
							.addComponent(txtEnd_0_1_1_1_1_4, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup()
							.addComponent(txtEnd_0_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(end13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(101)
							.addComponent(txtEnd_0_1_2_1_1_4, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(1)
							.addComponent(txtEnd_0_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(end14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(100)
							.addComponent(txtEnd_0_1_1_1_1_1_4, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(1)
							.addComponent(txtEnd_0_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(end15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(100)
							.addComponent(txtEnd_0_1_1_1_1_1_5, GroupLayout.PREFERRED_SIZE, 19,
									GroupLayout.PREFERRED_SIZE)
							.addGap(12).addComponent(end31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_endsContainer.createSequentialGroup().addGap(13)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_endsContainer.createSequentialGroup().addComponent(txtEnd_0).addGap(10)
											.addComponent(end0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
											.addComponent(txtEnd_1, GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_endsContainer.createSequentialGroup().addGap(18).addComponent(
													end1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE))))
							.addGap(102)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_endsContainer.createSequentialGroup()
											.addComponent(txtEnd_0_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE)
											.addGap(12).addComponent(end17, GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup()
											.addComponent(txtEnd_0_1_2_1_2, GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE)
											.addGap(12).addComponent(end16, GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))));
			gl_endsContainer.setVerticalGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_endsContainer.createSequentialGroup().addContainerGap().addGroup(gl_endsContainer
							.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_endsContainer.createSequentialGroup()
									.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
											.addComponent(txtEnd_0_1_2_1_2)
											.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(
													end16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)))
									.addGap(7))
							.addGroup(gl_endsContainer.createSequentialGroup()
									.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
											.addComponent(txtEnd_0)
											.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(
													end0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING).addComponent(txtEnd_1)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end1,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(3)
											.addComponent(txtEnd_0_1_1_1_1_2))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(4).addComponent(end17,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGap(7)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING).addComponent(txtEnd_2)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end2,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addComponent(txtEnd_0_1_2_1_1_2)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end18,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING).addComponent(txtEnd_0_2)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end3,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(7)
											.addComponent(txtEnd_0_1_2_1_1_1_1))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(8).addComponent(end19,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addComponent(end4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(4)
											.addComponent(txtEnd_0_1_2))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(11)
											.addComponent(txtEnd_0_1_1_1_1_1_1_1))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(12).addComponent(end20,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGroup(
									gl_endsContainer.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_endsContainer.createSequentialGroup().addGap(4)
													.addComponent(txtEnd_0_1_1_1).addGap(13).addComponent(txtEnd_0_3)
													.addGap(16).addComponent(txtEnd_0_1_3))
											.addGroup(gl_endsContainer.createSequentialGroup()
													.addComponent(end5, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(13)
													.addComponent(end6, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(12).addComponent(end7, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_endsContainer.createSequentialGroup().addGap(13)
													.addComponent(txtEnd_0_1_2_1_3).addGap(16)
													.addComponent(txtEnd_0_1_1_1_1_3).addGap(12)
													.addComponent(txtEnd_0_1_2_1_1_3))
											.addGroup(gl_endsContainer.createSequentialGroup().addGap(14)
													.addComponent(end21, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(12)
													.addComponent(end22, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(8).addComponent(end23, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(3)
							.addGroup(
									gl_endsContainer.createParallelGroup(Alignment.LEADING).addComponent(txtEnd_0_1_1_2)
											.addComponent(end8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_endsContainer.createSequentialGroup().addGap(8)
													.addComponent(txtEnd_0_1_1_1_1_1_3))
											.addGroup(gl_endsContainer.createSequentialGroup().addGap(9)
													.addComponent(end24, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(3)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(2)
											.addComponent(txtEnd_0_2_1))
									.addComponent(end9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(4)
											.addComponent(txtEnd_0_1_2_1_1_1_2))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(5).addComponent(end25,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addComponent(txtEnd_0_1_2_1)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end10,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(5)
											.addComponent(txtEnd_0_1_1_1_1_1_1_2))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(6).addComponent(end26,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addComponent(txtEnd_0_1_1_1_1)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end11,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1)
											.addComponent(txtEnd_0_1_2_1_4))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(2).addComponent(end27,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addComponent(txtEnd_0_1_2_1_1)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end12,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(5)
											.addComponent(txtEnd_0_1_1_1_1_4))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(6).addComponent(end28,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addComponent(txtEnd_0_1_1_1_1_1)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end13,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1)
											.addComponent(txtEnd_0_1_2_1_1_4))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(2).addComponent(end29,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addComponent(txtEnd_0_1_2_1_1_1)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end14,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(5)
											.addComponent(txtEnd_0_1_1_1_1_1_4))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(6).addComponent(end30,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(gl_endsContainer.createParallelGroup(Alignment.LEADING)
									.addComponent(txtEnd_0_1_1_1_1_1_1)
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1).addComponent(end15,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(1)
											.addComponent(txtEnd_0_1_1_1_1_1_5))
									.addGroup(gl_endsContainer.createSequentialGroup().addGap(2).addComponent(end31,
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))));
			endsContainer.setLayout(gl_endsContainer);

		}
		
		JLabel lblInstrucaoProcessada = new JLabel("Instrução processada");
		lblInstrucaoProcessada.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrucaoProcessada.setBounds(51, 34, 188, 15);
		contentPane.add(lblInstrucaoProcessada);
		
		JLabel lblInstrucaoEntrada = new JLabel("Instrução entrada");
		lblInstrucaoEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrucaoEntrada.setBounds(142, 100, 168, 15);
		contentPane.add(lblInstrucaoEntrada);
		initDados();

		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				validarEntrada();

				programCounter++;
				programCounter = programCounter % 12;
				cxProgramCounter.setText("PC: " + programCounter);
			}
		});
		btnClearReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (JTextField jTextField : enderecos) {
					jTextField.setText("");
				}
				for (JTextField jTextField : registradores) {
					jTextField.setText("");
				}
				programCounter = 0;
				cxProgramCounter.setText("PC: " + programCounter);
			}

		});
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				programCounter = 0;
				cxProgramCounter.setText("PC: " + programCounter);
			}

		});

	}

	private void initDados() {
		instrucion = new ArrayList();
		numeros = new ArrayList();
		registradores = new ArrayList<>();
		enderecos = new ArrayList<>();
		instrucion.add("add");
		instrucion.add("sub");
		instrucion.add("div");
		instrucion.add("mul");
		instrucion.add("mov");
		instrucion.add("not");

		instrucion.add("load");
		instrucion.add("stor");

		instrucion.add("jump");
		instrucion.add("junp");
		instrucion.add("juzp");

		enderecos.add(end0);
		enderecos.add(end1);
		enderecos.add(end2);
		enderecos.add(end3);
		enderecos.add(end4);
		enderecos.add(end5);
		enderecos.add(end6);
		enderecos.add(end7);
		enderecos.add(end8);
		enderecos.add(end9);
		enderecos.add(end10);
		enderecos.add(end11);

		enderecos.add(end12);
		enderecos.add(end13);
		enderecos.add(end14);
		enderecos.add(end15);
		enderecos.add(end16);
		enderecos.add(end17);
		enderecos.add(end18);
		enderecos.add(end19);
		enderecos.add(end20);
		enderecos.add(end21);
		enderecos.add(end22);
		enderecos.add(end23);

		enderecos.add(end24);
		enderecos.add(end25);
		enderecos.add(end26);
		enderecos.add(end27);
		enderecos.add(end28);
		enderecos.add(end29);
		enderecos.add(end30);
		enderecos.add(end31);

		registradores.add(reg00);
		registradores.add(reg01);
		registradores.add(reg02);
		registradores.add(reg03);

		programCounter = 0;

		num_1 = 0;
		num_2 = 0;
	}

	private void rotina() {

	}

	private void validarEntrada() {

		String regex = "^\\s*([a-zA-Z]{3})\\s+([0]*[0-3]{1})\\s+([0]*[0-3]{1})\\s*$";
		pattern = Pattern.compile(regex);
		String dad = enderecos.get(programCounter).getText();
		matcher = pattern.matcher(dad);

		if (matcher.find()) { // add e essas porra

			separarPalavraAritimetica();
		} else {

			regex = "^\\s*([a-zA-z]{4})\\s+([0]*[0-3]{1})\\s+[0]*(([0-9])|([0-2][0-9])|([3][0-1]))\\s*$";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(dad);
			if (matcher.find()) { // load stor

				separarPalavraManiMemoria();

			} else {

				regex = "^\\s*([a-zA-z]{4})\\s+[0]*(([0-9])|([0-2][0-9])|([3][0-1]))\\s*$";
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(dad);
				if (matcher.find()) { // jumpps

					separarPalavraManiPC();

				} else {

				}
			}
		}
		// TODO: Verificar para outros comandos tbm seu bobo

	}

	private void separarPalavraManiPC() {
		numeros.clear();
		String regex = "([a-zA-Z]{4})";
		pattern = Pattern.compile(regex);
		String dad = enderecos.get(programCounter).getText();
		matcher = pattern.matcher(dad);
		instru = "";
		while (matcher.find()) {
			matcher.start();
			instru = matcher.group();
			outPutIR.setText(instru);
		}
		regex = "([0-9]{2}|[0-9])";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(dad);
		while (matcher.find()) {
			matcher.start();
			numeros.add(matcher.group());
		}
		num_1 = Integer.valueOf(numeros.get(0));
		outPutIR.setText(instru + " " + numeros.get(0));

		if (!instrucion.contains(instru)) { // tem essa instrução?
			outPutMIR.setText("invalid");
			return;
		}
		outPutMIR.setText("instruction: " + instru + " | " + "end: " + (num_1 > 9 ? "" : "0") + num_1);

		computarSimulacaoPC();

	}

	private void separarPalavraManiMemoria() {
		numeros.clear();
		String regex = "([a-zA-Z]{4})";
		pattern = Pattern.compile(regex);
		String dad = enderecos.get(programCounter).getText();
		matcher = pattern.matcher(dad);

		instru = "";
		while (matcher.find()) {
			matcher.start();
			instru = matcher.group();
			outPutIR.setText(instru);
		}

		regex = "([0-9]{2}|[0-9])";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(dad);

		while (matcher.find()) {
			matcher.start();
			numeros.add(matcher.group());
		}
		num_1 = Integer.valueOf(numeros.get(0)); // registrador
		num_2 = Integer.valueOf(numeros.get(1)); // mem

		outPutIR.setText(instru + " " + numeros.get(0) + " " + numeros.get(1));

		if (!instrucion.contains(instru)) { // tem essa instrução?
			outPutMIR.setText("invalid");
			return;
		}
		outPutMIR.setText(
				"instruction: " + instru + " | " + "reg: 0" + num_1 + " | end: " + (num_2 > 9 ? "" : "0") + num_2);
		computarSimulacaoMem();
	}

	private void separarPalavraAritimetica() { //
		numeros.clear();
		String regex = "([a-zA-Z]{3})";
		pattern = Pattern.compile(regex);
		String dad = enderecos.get(programCounter).getText();
		matcher = pattern.matcher(dad);

		instru = "";
		while (matcher.find()) {
			matcher.start();
			instru = matcher.group();
			outPutIR.setText(instru);
		}

		regex = "([0]*[0-3]{1})";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(dad);

		while (matcher.find()) {
			matcher.start();
			numeros.add(matcher.group());

		}

		num_1 = Integer.valueOf(numeros.get(0)); // registrador
		num_2 = Integer.valueOf(numeros.get(1));

		outPutIR.setText(instru + " " + numeros.get(0) + " " + numeros.get(1));

		if (!instrucion.contains(instru)) { // tem essa instrução?
			outPutMIR.setText("invalid");
			return;
		}
		outPutMIR.setText("instruction: " + instru + "" + "| reg: 0" + num_1 + " | reg: 0" + num_2);

		computarSimulacaoAri();
	}

	private void showInterpreter() {

	}

	private void computarSimulacaoMem() {
		JTextField reg = registradores.get(num_1);
		JTextField end = enderecos.get(num_2);
		if (instru.equals("load")) {
			reg.setText(end.getText());
		} else if (instru.equals("stor")) {
			end.setText(reg.getText());
		}
	}

	private void computarSimulacaoPC() {

		if (instru.equals("jump")) {
			programCounter = num_1 - 1;
			cxProgramCounter.setText("PC: " + programCounter);

		} else if (instru.equals("junp")) {
			if (txtFlagNegative.getText().equals("true")) {
				programCounter = num_1 - 1;
				cxProgramCounter.setText("PC: " + programCounter);
			}

		} else if (instru.equals("juzp")) {
			if (txtFlagZero.getText().equals("true")) {
				programCounter = num_1 - 1;
				cxProgramCounter.setText("PC: " + programCounter);
			}

		}

	}

	private void computarSimulacaoAri() { // esse vai ser generico vai servir pra todas as instruçoes
		int result;

		JTextField reg1 = registradores.get(num_1);
		JTextField reg2 = registradores.get(num_2);

		try {
			if (instru.equals("add")) {

				result = Integer.valueOf(reg1.getText()) + Integer.valueOf(reg2.getText());
				reg1.setText(result + "");

			} else if (instru.equals("sub")) {
				result = Integer.valueOf(reg1.getText()) - Integer.valueOf(reg2.getText());
				reg1.setText(result + "");

			} else if (instru.equals("mul")) {
				result = Integer.valueOf(reg1.getText()) * Integer.valueOf(reg2.getText());
				reg1.setText(result + "");

			} else if (instru.equals("div")) {
				result = Integer.valueOf(reg1.getText()) / Integer.valueOf(reg2.getText());
				reg1.setText(result + "");
				// TODO: guardar resto

			} else if (instru.equals("mov")) { // não é aritimetica mas é de registrador para registrador
				reg1.setText(reg2.getText());
			} else if (instru.equals("not")) {
				reg1.setText("" + Integer.valueOf(reg2.getText()) * (-1));
			}
		} catch (Exception e) {

		} finally {
			// regis

			txtFlagZero.setText(reg1.getText().equals("0") + "");

			txtFlagNegative.setText(reg1.getText().contains("-") + "");

		}

	}
}
