package interfac.grafica;

import javax.swing.JFrame;

public class InterfaceGrafica extends JFrame {

	//classe construtor
	public InterfaceGrafica() {
		setTitle ("Campo Minado");//nome do jogo, será mostrado quando rodar o codigo
		setSize(1024,728);//dimensao do jogo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );//o X agora fecha a aba do jogo
		setLocationRelativeTo(null);//onde o mouse ira aparecer quando o codigo rodar
		this.setResizable(false);//para nao poder maximizar a aba do jogo.
		setVisible(true);//torna essas series de comandos visivel
	}
	
	public static void main(String []args) {
		new InterfaceGrafica();
	}
	

}
