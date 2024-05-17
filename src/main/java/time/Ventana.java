package time;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ventana extends JFrame {
	// Variables 
	private static final long serialVersionUID = 5892148773647425132L;
	private Panel panel;
	private Timer contador;
	private JButton start;
	private JButton stop;
	private int pantalla = 0; // Marcador de tiempo en segundos

	// Constructor
	public Ventana() {
		this.setBounds(500, 500, 1020, 680);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Panel();

		// Agregar Botones al panel
		start = new JButton("Start");
		start.addActionListener(e -> contador.start());
		panel.add(start);

		stop = new JButton("Stop");
		stop.addActionListener(e -> contador.stop());
		panel.add(stop);

		// Agregar panel a la ventana
		this.add(panel);

		this.setVisible(true);

		// Contador
		contador = new Timer(1000, e -> {
			JLabel etiqueta = panel.getLabel();
			pantalla++;
			etiqueta.setText(formatearTiempo(pantalla));
		});
	}

	// CHATGPT REVISAR PARA LAS HORAS
	private String formatearTiempo(int segundos) {
		int horas = segundos / 3600;
		int minutos = (segundos % 3600) / 60;
		int seg = segundos % 60;
		return String.format("%02d:%02d:%02d", horas, minutos, seg);
	}

	class Panel extends JPanel {

		private static final long serialVersionUID = 5624075046605598209L;
		private JLabel marcador;

		public Panel() {
			// Etiqueta
			// SE PODRIA CREAR EN EL PADRE COMO LOS BOTONES, PRUEBAS
			marcador = new JLabel("00:00:00");
			marcador.setPreferredSize(new Dimension(100, 100));

			this.add(marcador);
		}

		public JLabel getLabel() {
			return this.marcador;
		}
	}

	public static void main(String[] args) {
		Ventana frame = new Ventana();
	}
}
