
//NGUYỄN VĂN CHÂU	

package BT_kt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class c1_server {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					c1_server window = new c1_server();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public c1_server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 292, 85);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ServerSocket server = new ServerSocket(8000);
					server.getLocalPort();
					JOptionPane.showMessageDialog(null, "Server already");
					Socket socketServer = server.accept();
					DataInputStream inputServer = new DataInputStream(socketServer.getInputStream());
					String so1 = inputServer.readLine();
					String so2 = inputServer.readLine();
					int a = Integer.parseInt(so1);
					int b = Integer.parseInt(so2);
					int tong = a+b;
					
					DataOutputStream outputStream = new DataOutputStream(socketServer.getOutputStream());
					outputStream.writeBytes(String.valueOf(tong));
					inputServer.close();
					outputStream.close();
					server.close();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnStart)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
