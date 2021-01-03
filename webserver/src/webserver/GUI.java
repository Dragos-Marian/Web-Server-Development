package webserver;
import webserver.WebServer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	private static JLabel porting;
	private static JLabel rooting;
	private static JTextField port;
	private static JTextField root;
	private static JButton button;
	private static JLabel start;
	private static JLabel path;
	private static JLabel po;
	private int pressed=0;
	public static String f1;
	public static String f2;
	public static String f3;
	public static int p1;
	
	 Process process;
	 Runtime run;
	
	
	public static void main(String [] args)
	{
		JFrame frame=new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		porting=new JLabel("PORT");
		porting.setBounds(90, 100, 80, 25);
		panel.add(porting);
		port=new JTextField(5);
		port.setBounds(135, 100, 165, 25);
		panel.add(port);
		rooting=new JLabel("ROOT");
		rooting.setBounds(90, 130, 80, 25);
		panel.add(rooting);
		root=new JTextField(80);
		root.setBounds(135, 130, 165, 25);
		panel.add(root);
		button=new JButton("START");
		button.setBounds(160, 160, 80, 25);
		button.addActionListener(new GUI());
		panel.add(button);
		start=new JLabel("");
		start.setBounds(175, 180, 80, 25);
		panel.add(start);
		path=new JLabel("");
		path.setBounds(160, 200, 140, 25);
		panel.add(path);
		po=new JLabel("");
		po.setBounds(160, 220, 140, 25);
		panel.add(po);
		
		frame.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(pressed == 0)
		{
			File file;
			pressed =1;
			String r=root.getText();
			String p=port.getText();
			int porti=Integer.parseInt(p);
			file=new File(r);
			if(porti > 0 && porti< 99999 && file.isDirectory() )
			{
				start.setText("STARTED");
				System.out.println(porti);
				Config c=new Config(r,porti);
				f1=c.getDefaultIndex();
				f2=c.getNotFound();
				f3=c.getNotExist();
				p1=c.getPORT();
				System.out.println(f1);
				try {
					WebServer.main(null);
										

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			else {
				po.setText("Wrong port or dir");
				
			}
			
		}
		else
		{
		
			pressed=0;
			start.setText("STOPED");
		}
	}
	public static String f1()
	{
		return f1;
	}
	public static int p1()
	{
		return p1;
	}
	public static String f2()
	{
		return f2;
	}
	
	public static String f3()
	{
		return f3;
	}

}
